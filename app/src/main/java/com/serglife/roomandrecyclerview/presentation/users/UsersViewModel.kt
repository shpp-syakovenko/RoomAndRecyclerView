package com.serglife.roomandrecyclerview.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.serglife.roomandrecyclerview.domain.entity.User
import com.serglife.roomandrecyclerview.domain.usecase.GetUsersUseCase

class UsersViewModel(private val getUsers: GetUsersUseCase) : ViewModel() {

    var users: LiveData<List<User>> = getUsers()

}