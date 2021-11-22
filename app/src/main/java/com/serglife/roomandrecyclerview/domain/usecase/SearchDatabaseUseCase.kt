package com.serglife.roomandrecyclerview.domain.usecase

import androidx.lifecycle.LiveData
import com.serglife.roomandrecyclerview.domain.UserRepository
import com.serglife.roomandrecyclerview.domain.entity.User

class SearchDatabaseUseCase(private val repository: UserRepository) {
    operator fun invoke(searchQuery: String): LiveData<List<User>>{
       return repository.searchDatabase(searchQuery)
    }
}