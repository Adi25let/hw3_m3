package com.example.hw3_m3.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw3_m3.data.models.TaskModel


@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks_table ORDER BY id DESC")
    fun getAll(): List<TaskModel>

    @Insert
    fun insertTask(taskModel: TaskModel)

    @Delete
    fun deleteTask(taskModel: TaskModel)

    @Update
    fun updateTask(taskModel: TaskModel)
}