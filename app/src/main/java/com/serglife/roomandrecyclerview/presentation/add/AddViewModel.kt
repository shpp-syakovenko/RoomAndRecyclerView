package com.serglife.roomandrecyclerview.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.roomandrecyclerview.domain.entity.User
import com.serglife.roomandrecyclerview.domain.usecase.AddUserUseCase
import com.serglife.roomandrecyclerview.domain.usecase.DeleteUserUseCase
import kotlinx.coroutines.launch

class AddViewModel(
    private val addUserUseCase: AddUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
): ViewModel() {

    fun addUser(id: Int = 0, name: String, secondName: String, age: Int){
        viewModelScope.launch {
            addUserUseCase(User(
                id = id,
                name = name,
                secondName = secondName,
                age = age
            ))
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch {
            deleteUserUseCase(user)
        }
    }
}