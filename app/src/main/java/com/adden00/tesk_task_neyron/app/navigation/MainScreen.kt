package com.adden00.tesk_task_neyron.app.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun MainScreen() {
    Navigator(screen = StartScreenRoute)
}