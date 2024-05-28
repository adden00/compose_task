package com.adden00.tesk_task_neyron.data.local

import com.adden00.tesk_task_neyron.data.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface UserCache {
    val currentUser: StateFlow<User>
    fun updateCurrentUser(newUser: User)
}
object UserCacheImplementation: UserCache {
    private val _currentUser = MutableStateFlow(User("art", "art"))
    override val currentUser: StateFlow<User> get() = _currentUser.asStateFlow()
    override fun updateCurrentUser(newUser: User) {
        _currentUser.update { newUser }
    }
}