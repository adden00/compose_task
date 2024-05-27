package com.adden00.tesk_task_neyron.ui.design_system

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Styles {
    val base_text = TextStyle(
        color = Colors.white,
        fontSize = 18.sp,
    )

    val text_grey_16 = base_text.copy(color = Colors.grey)
    val text_header_24 = base_text.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight(600)
    )
}