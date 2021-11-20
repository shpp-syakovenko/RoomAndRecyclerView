package com.serglife.roomandrecyclerview.di

import com.serglife.roomandrecyclerview.data.repository.UserRepositoryImpl
import com.serglife.roomandrecyclerview.domain.usecase.AddUserUseCase
import com.serglife.roomandrecyclerview.domain.usecase.DeleteUserUseCase
import com.serglife.roomandrecyclerview.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<AddUserUseCase> { AddUserUseCase(get<UserRepositoryImpl>()) }
    factory<DeleteUserUseCase> { DeleteUserUseCase(get<UserRepositoryImpl>()) }
    factory<GetUsersUseCase> { GetUsersUseCase(get<UserRepositoryImpl>()) }
}