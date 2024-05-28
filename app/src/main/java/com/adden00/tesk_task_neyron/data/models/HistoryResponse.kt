package com.adden00.tesk_task_neyron.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryResponse(
    @SerialName ("data")
    val data: List<DateModel>
)

@Serializable
data class DateModel(
    @SerialName ("date")
    val date: String,

    @SerialName ("name")
    val name: List<String>
)
