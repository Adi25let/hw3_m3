package com.example.hw3_m3.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "tasks_table")
data class TaskModel (
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val title: String,
    val desc: String,
): java.io.Serializable