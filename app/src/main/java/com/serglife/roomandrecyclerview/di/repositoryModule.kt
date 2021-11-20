package com.serglife.roomandrecyclerview.di


import com.serglife.roomandrecyclerview.data.database.AppDatabase
import com.serglife.roomandrecyclerview.data.database.UserDao
import com.serglife.roomandrecyclerview.data.mapper.MapperUser
import com.serglife.roomandrecyclerview.data.repository.UserRepositoryImpl
import com.serglife.roomandrecyclerview.domain.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<UserDao> { AppDatabase.getDatabase(get()).userDao() }
    factory<MapperUser> { MapperUser() }
    single<UserRepositoryImpl> {UserRepositoryImpl(get<UserDao>(), get<MapperUser>())}
}