package com.serglife.roomandrecyclerview.domain.usecase

import com.serglife.roomandrecyclerview.domain.UserRepository
import com.serglife.roomandrecyclerview.domain.entity.User

class DeleteUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User){
        repository.deleteUser(user)
    }
}