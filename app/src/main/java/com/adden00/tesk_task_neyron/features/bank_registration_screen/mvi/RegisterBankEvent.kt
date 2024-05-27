package com.adden00.tesk_task_neyron.features.bank_registration_screen.mvi

import com.adden00.tesk_task_neyron.features.bank_registration_screen.models.RegisterInfo

sealed interface RegisterBankEvent {
    data class ConfirmRegister(val registerInfo: RegisterInfo)
}