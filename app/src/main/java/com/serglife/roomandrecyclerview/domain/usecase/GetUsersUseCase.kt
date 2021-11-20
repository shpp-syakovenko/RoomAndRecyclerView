package com.serglife.roomandrecyclerview.domain.usecase

import androidx.lifecycle.LiveData
import com.serglife.roomandrecyclerview.domain.UserRepository
import com.serglife.roomandrecyclerview.domain.entity.User

class GetUsersUseCase(private val repository: UserRepository) {
    operator fun invoke(): LiveData<List<User>> {
        return repository.getUsers()
    }
}