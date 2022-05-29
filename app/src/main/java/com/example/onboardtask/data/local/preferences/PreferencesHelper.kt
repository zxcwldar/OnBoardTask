package com.example.onboardtask.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    var hasOnBoardBeenShown: Boolean
        get() = preferences.getBoolean("hasOnBoardBeenShown", false)
        set(value) = preferences.edit().putBoolean("hasOnBoardBeenShown", value).apply()
}