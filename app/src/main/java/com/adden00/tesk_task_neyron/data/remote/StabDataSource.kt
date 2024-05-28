package com.adden00.tesk_task_neyron.data.remote

import android.content.Context
import com.adden00.tesk_task_neyron.R
import com.adden00.tesk_task_neyron.data.models.HistoryResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class StubDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private const val STUB_RESPONSE = ""
    }
    @OptIn(ExperimentalSerializationApi::class)
    fun getHistory(): HistoryResponse {
        return Json.decodeFromStream(context.resources.openRawResource(R.raw.response))
    }
}