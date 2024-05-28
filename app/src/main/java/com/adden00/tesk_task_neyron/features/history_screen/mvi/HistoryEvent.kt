package com.adden00.tesk_task_neyron.features.history_screen.mvi

sealed interface HistoryEvent {
    data object LoadHistory : HistoryEvent
}