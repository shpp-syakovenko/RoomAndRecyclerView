package com.serglife.roomandrecyclerview.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val secondName: String,
    val age: Int
)