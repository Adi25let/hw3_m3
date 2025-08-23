package com.example.hw3_m3.data.local

import android.content.Context

class Pref(context: Context) {

    private val pref = context.getSharedPreferences("Key", Context.MODE_PRIVATE)

    fun saveValue(text: String){
        pref.edit().putString("key_value",text).apply()
    }

    fun getValue(): String? {
        return pref.getString("key_value","first_value")
    }

    fun isOnBoardShown(): Boolean{
        return pref.getBoolean("onBoardShown", false)
    }

    fun setOnBoardShown(){
        pref.edit().putBoolean("onBoardShown", true).apply()
    }

}