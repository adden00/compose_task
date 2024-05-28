package com.adden00.tesk_task_neyron.ui.design_system

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Styles {
    val base_text = TextStyle(
        color = Colors.white,
        fontSize = 16.sp,
    )

    val text_grey_16 = base_text.copy(color = Colors.grey)

    val text_grey_12 = base_text.copy(color = Colors.grey, fontSize = 12.sp)

    val text_red_14 = base_text.copy(color = Colors.passive_red, fontSize = 14.sp)

    val text_header_26 = base_text.copy(
        fontSize = 26.sp,
        fontWeight = FontWeight(600)
    )

    val text_red_hint = base_text.copy(color = Colors.passive_red, fontSize = 14.sp)
}