package com.kuldeep.dictionaryapp.core.network

import kotlinx.serialization.Serializable

@Serializable
data class DictionaryErrorResponse(
    val code: Int,
    val message: String?
)

