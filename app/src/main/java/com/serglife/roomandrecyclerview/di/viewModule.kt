package com.serglife.roomandrecyclerview.di

import com.serglife.roomandrecyclerview.presentation.add.AddViewModel
import com.serglife.roomandrecyclerview.presentation.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { UsersViewModel(get(), get(), get()) }
    viewModel { AddViewModel(get(), get()) }
}