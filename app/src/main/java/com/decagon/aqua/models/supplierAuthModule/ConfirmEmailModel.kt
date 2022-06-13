package com.decagon.aqua.models.supplierAuthModule

data class ConfirmEmailModel(
    val emailAddress: String,
    val token: String
)
