package com.hieuminh.chatapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SessionUtil(context: Context?) {

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var stateDarkModeState: Boolean
        set(value) = prefs.edit().putBoolean("DarkModeState", value).apply()
        get() = prefs.getBoolean("DarkModeState", false)

    var displayNotice : Boolean
        set(value) = prefs.edit().putBoolean("DisplayNotice", value).apply()
        get() = prefs.getBoolean("DisplayNotice", false)
}