package com.decagon.aqua.core.data.sharedpreference

import android.content.Context
import javax.inject.Inject

class AquaPreferences @Inject constructor(context: Context) : Preference {

    companion object {
        const val PREFERENCES_NAME = "AQUA_PREFERENCES"
    }

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun putToken(token: String) {
        preferences.edit().putString(PreferencesConstant.KEY_TOKEN, token).apply()
    }

    override fun getToken(): String {
        return preferences.getString(PreferencesConstant.KEY_TOKEN, "").orEmpty()
    }

    override fun putSupplierToken(token: String) {
        preferences.edit().putString(PreferencesConstant.KEY_TOKEN_SUPPLIER, token).apply()
    }

    override fun getSupplierToken(): String {
        return preferences.getString(PreferencesConstant.KEY_TOKEN_SUPPLIER, "").orEmpty()
    }

}