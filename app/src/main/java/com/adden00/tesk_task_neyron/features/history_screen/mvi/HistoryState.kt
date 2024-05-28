package com.adden00.tesk_task_neyron.features.history_screen.mvi

import com.adden00.tesk_task_neyron.features.history_screen.domain.models.HistoryModel

data class HistoryState(
    val isLoading: Boolean = false,
    val historyList: List<HistoryModel> = listOf()
)