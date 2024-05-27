package com.adden00.tesk_task_neyron.ui.design_system

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object Colors {
    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)
    val grey = Color(0xFF918EA3)

    val bg_top = Color(0xFF3F3A58)
    val bg_bottom = Color(0xFF2A2545)

    val active_red = Color(0xFFEB3752)
    val passive_red = Color(0xFFAB3452)

    val bg_gradient = Brush.verticalGradient(listOf(bg_top, bg_bottom))
}