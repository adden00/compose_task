package com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi

sealed interface RegisterBankEffect {
    data object NavigateToMain : RegisterBankEffect
}