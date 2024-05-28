package com.adden00.tesk_task_neyron.data

import com.adden00.tesk_task_neyron.data.local.UserCache
import com.adden00.tesk_task_neyron.data.models.DateModel
import com.adden00.tesk_task_neyron.data.models.User
import com.adden00.tesk_task_neyron.data.remote.StubDataSource
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class DataRepository @Inject constructor(
    private val userCache: UserCache,
    private val dataSource: StubDataSource
) {

    fun subscribeOnUser(): StateFlow<User> {
        return userCache.currentUser
    }

    fun setNewUser(user: User) {
        userCache.updateCurrentUser(user)
    }

    fun getHistory(): List<DateModel> {
        val data = dataSource.getHistory().data
        return data
    }
}