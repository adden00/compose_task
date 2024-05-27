package com.adden00.tesk_task_neyron.data.local

import com.adden00.tesk_task_neyron.data.local.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object UserCache {
    private val _currentUser = MutableStateFlow(User("art", "art"))
    val currentUser: StateFlow<User> get() = _currentUser.asStateFlow()
    fun updateCurrentUser(newUser: User) {
        _currentUser.update { newUser }
    }
}