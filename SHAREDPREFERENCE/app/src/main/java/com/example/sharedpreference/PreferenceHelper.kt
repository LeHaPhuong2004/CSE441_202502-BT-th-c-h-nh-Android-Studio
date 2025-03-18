package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    //sử dụng getSharedPreferences
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    //sử dụng apply() hoặc commit()
    fun saveData(username: String, password: String) {
        sharedPreferences.edit().apply {
            putString("USERNAME", username)
            putString("PASSWORD", password)
            apply()
        }
    }

    fun getData(): Pair<String?, String?> {
        val username = sharedPreferences.getString("USERNAME", null)
        val password = sharedPreferences.getString("PASSWORD", null)
        return Pair(username, password)
    }

    fun clearData() {
        //sử dụng clear()
        sharedPreferences.edit().clear().apply()
    }
}
