package com.serglife.roomandrecyclerview.domain

import androidx.lifecycle.LiveData
import com.serglife.roomandrecyclerview.domain.entity.User

interface UserRepository {
    fun getUsers(): LiveData<List<User>>
    suspend fun addUser(user: User)
    suspend fun deleteUser(user: User)
    fun searchDatabase(searchQuery: String): LiveData<List<User>>
}