package com.serglife.roomandrecyclerview.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.serglife.roomandrecyclerview.data.entity.UserDb

@Database(entities = [UserDb::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var db: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "users.db"

        fun getDatabase(context: Application): AppDatabase{
           synchronized(LOCK){
               db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                db = instance
                return instance
            }
        }

    }
}