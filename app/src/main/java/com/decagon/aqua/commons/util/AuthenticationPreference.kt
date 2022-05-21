package com.decagon.aqua.commons.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AuthenticationPreference {
    companion object {
        val TOKEN_KEY = "token_key"
        val ID_KEY = "id_key"
        val MY_PREF = "my_pref"

        lateinit var pref: SharedPreferences
    }
    fun initializePreference(activity: Activity) {
        pref = activity.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)
    }
    fun saveToken(token: String) {
        pref.edit().putString(TOKEN_KEY, token).apply()
    }
    fun saveId(id: String) {
        pref.edit().putString(ID_KEY, id).apply()
    }
    fun getToken(key: String): String? {
        return pref.getString(key, null)
    }
    fun getId(id: String): String? {
        return pref.getString(id, null)
    }
    fun clearToken(key: String) {
        pref.edit().remove(key).apply()
    }
}
