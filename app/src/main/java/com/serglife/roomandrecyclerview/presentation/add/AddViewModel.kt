package com.serglife.roomandrecyclerview.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.roomandrecyclerview.domain.entity.User
import com.serglife.roomandrecyclerview.domain.usecase.AddUserUseCase
import kotlinx.coroutines.launch

class AddViewModel(private val addUserUseCase: AddUserUseCase): ViewModel() {

    fun addUser(name: String, secondName: String, age: Int){
        viewModelScope.launch {
            addUserUseCase(User(
                id = 0,
                name = name,
                secondName = secondName,
                age = age
            ))
        }

    }
}