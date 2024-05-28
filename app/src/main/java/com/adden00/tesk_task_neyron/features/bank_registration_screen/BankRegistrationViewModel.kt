package com.adden00.tesk_task_neyron.features.bank_registration_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.tesk_task_neyron.data.DataRepository
import com.adden00.tesk_task_neyron.data.models.User
import com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi.RegisterBankEffect
import com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi.RegisterBankEvent
import com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi.RegisterBankState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankRegistrationViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val _screenState = MutableStateFlow(RegisterBankState())
    val screenState: StateFlow<RegisterBankState> get() = _screenState.asStateFlow()
    private val _screenEffect = Channel<RegisterBankEffect>()
    val screenEffect: Flow<RegisterBankEffect> get() = _screenEffect.consumeAsFlow()

    fun newEvent(event: RegisterBankEvent) {
        when (event) {
            is RegisterBankEvent.ConfirmRegister -> {
                _screenState.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    repository.setNewUser(
                        User(
                            event.registerInfo.name,
                            event.registerInfo.surname
                        )
                    )
                    _screenState.update { it.copy(isLoading = false) }
                    _screenEffect.send(RegisterBankEffect.NavigateToMain)
                }
            }
        }
    }
}