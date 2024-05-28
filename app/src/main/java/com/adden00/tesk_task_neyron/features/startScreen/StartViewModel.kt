package com.adden00.tesk_task_neyron.features.startScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.tesk_task_neyron.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {
    companion object {
        const val PHONE = "+79143014334"
        const val EMAIL = "kursantic341@gmail.com"
        const val LANGUAGE = "русский"
    }

    val currentUser: StateFlow<StartScreenInfo>
        get() =
            repository.subscribeOnUser().map {
                StartScreenInfo(
                    it.name,
                    it.surname,
                    PHONE,
                    EMAIL,
                    LANGUAGE
                )
            }.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(),
                initialValue = StartScreenInfo("art", "art", PHONE, EMAIL, LANGUAGE)
            )

}