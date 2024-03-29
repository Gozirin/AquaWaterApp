package com.decagon.aqua.core.data.sharedpreference

interface Preference {

    fun putToken(token: String)

    fun getToken(): String

    fun putSupplierToken(token: String)

    fun getSupplierToken(): String
}
