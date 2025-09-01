package com.example.hw3_m3.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw3_m3.data.dao.TaskDao
import com.example.hw3_m3.data.models.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
}


