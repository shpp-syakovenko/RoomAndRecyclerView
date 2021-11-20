package com.serglife.roomandrecyclerview.data.repository


import androidx.lifecycle.LiveData
import com.serglife.roomandrecyclerview.data.database.UserDao
import com.serglife.roomandrecyclerview.data.mapper.MapperUser
import com.serglife.roomandrecyclerview.domain.UserRepository
import com.serglife.roomandrecyclerview.domain.entity.User

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val mapper: MapperUser
): UserRepository {

    override fun getUsers(): LiveData<List<User>> {
        return mapper.listUsersDbToListUsers(userDao.getUsers())
    }

    override suspend fun addUser(user: User) {
        userDao.addUser(mapper.userToUserDb(user))
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(mapper.userToUserDb(user))
    }
}