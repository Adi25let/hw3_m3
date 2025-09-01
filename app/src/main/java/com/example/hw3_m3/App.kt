package com.example.hw3_m3

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hw3_m3.data.AppDatabase

class App : Application() {

    companion object {
       lateinit var db: AppDatabase


    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(applicationContext, AppDatabase::class.java,"DB").allowMainThreadQueries().build()
    }
}