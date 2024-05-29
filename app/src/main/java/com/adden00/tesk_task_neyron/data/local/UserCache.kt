package com.adden00.tesk_task_neyron.data.local

import com.adden00.tesk_task_neyron.data.models.User
import kotlinx.coroutines.flow.StateFlow

interface UserCache {
    val currentUser: StateFlow<User>
    fun updateCurrentUser(newUser: User)
}

