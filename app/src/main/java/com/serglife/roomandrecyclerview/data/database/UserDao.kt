package com.serglife.roomandrecyclerview.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.serglife.roomandrecyclerview.data.entity.UserDb

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getUsers():LiveData<List<UserDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userDb: UserDb)

    @Delete
    suspend fun deleteUser(userDb: UserDb)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()


}