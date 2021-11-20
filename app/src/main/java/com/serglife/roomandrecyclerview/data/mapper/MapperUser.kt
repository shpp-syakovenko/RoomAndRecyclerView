package com.serglife.roomandrecyclerview.data.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.serglife.roomandrecyclerview.data.entity.UserDb
import com.serglife.roomandrecyclerview.domain.entity.User

class MapperUser {

    fun userToUserDb(user: User): UserDb {
        return UserDb(
            id = user.id,
            name = user.name,
            secondName = user.secondName,
            age = user.age
        )
    }

    fun userDbToUser(userDb: UserDb):User{
        return User(
            id = userDb.id,
            name = userDb.name,
            secondName = userDb.secondName,
            age = userDb.age
        )
    }

    fun listUsersDbToListUsers(listUsersDb: LiveData<List<UserDb>>): LiveData<List<User>>{
        return Transformations.map(listUsersDb){listUsers->
            listUsers.map { user ->
                userDbToUser(user)
            }
        }

    }


}