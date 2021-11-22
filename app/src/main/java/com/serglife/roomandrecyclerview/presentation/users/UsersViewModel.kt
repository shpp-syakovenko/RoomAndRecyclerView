package com.serglife.roomandrecyclerview.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.roomandrecyclerview.domain.entity.User
import com.serglife.roomandrecyclerview.domain.usecase.DeleteUserUseCase
import com.serglife.roomandrecyclerview.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsers: GetUsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    var users: LiveData<List<User>> = getUsers()

    fun deleteUser(user: User){
        viewModelScope.launch {
            deleteUserUseCase(user)
        }
    }

}