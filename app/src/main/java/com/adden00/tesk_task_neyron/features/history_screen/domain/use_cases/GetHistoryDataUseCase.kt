package com.adden00.tesk_task_neyron.features.history_screen.domain.use_cases

import android.annotation.SuppressLint
import com.adden00.tesk_task_neyron.data.DataRepository
import com.adden00.tesk_task_neyron.data.models.DateModel
import com.adden00.tesk_task_neyron.features.history_screen.domain.models.HistoryModel
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject


class GetHistoryDataUseCase @Inject constructor(private val repository: DataRepository) {
    @SuppressLint("SimpleDateFormat")
    operator fun invoke(): List<HistoryModel> {
        val rawHistory = repository.getHistory()
        return rawHistory
            .asSequence()
            .map {
                val date: Date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(
                        it.date.replace("T", " ")
                            .replace("Z", "")
                    ) ?: throw Exception("Unknown format")
                val formattedDate = DateModel(
                    SimpleDateFormat("dd.MM.yyyy").format(date),
                    it.name
                )
                formattedDate                      // поменяли формат
            }
            .groupBy {                        // сгруппировали по дате
                it.date
            }
            .map {           // собрали в нужные модельки
                HistoryModel(date = it.key, names = it.value.map { it.name }.flatten())
            }
            .toList()
    }
}