package com.adden00.tesk_task_neyron.app.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.adden00.tesk_task_neyron.features.bank_registration_screen.BankRegistrationScreen
import com.adden00.tesk_task_neyron.features.history_screen.HistoryScreen
import com.adden00.tesk_task_neyron.features.startScreen.StartScreen

object StartScreenRoute : Screen {
    @Composable
    override fun Content() {
        StartScreen()
    }
}

object BankScreenRoute : Screen {

    @Composable
    override fun Content() {
        BankRegistrationScreen()
    }
}

object HistoryScreenRoute : Screen {
    @Composable
    override fun Content() {
        HistoryScreen()
    }
}

