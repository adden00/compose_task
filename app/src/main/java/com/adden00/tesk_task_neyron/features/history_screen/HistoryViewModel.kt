package com.adden00.tesk_task_neyron.features.history_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adden00.tesk_task_neyron.features.history_screen.mvi.HistoryEvent
import com.adden00.tesk_task_neyron.features.history_screen.mvi.HistoryState
import com.adden00.tesk_task_neyron.features.history_screen.domain.use_cases.GetHistoryDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val getHistoryDataUseCase: GetHistoryDataUseCase): ViewModel() {
    private val _screenState = MutableStateFlow(HistoryState())
    val screenState: StateFlow<HistoryState> get() = _screenState.asStateFlow()

    fun newEvent(event: HistoryEvent) {
        when (event) {
            is HistoryEvent.LoadHistory -> {
                _screenState.update { it.copy(isLoading = true) }
                viewModelScope.launch {
                    val historyList = getHistoryDataUseCase()
                    // todo тут можно добавить обработку ошибок, например через Result<>, добавить side эффекты для отображения их пользователю и т.д.
                    _screenState.update { it.copy(isLoading = false, historyList = historyList) }
                }
            }
        }
    }
}