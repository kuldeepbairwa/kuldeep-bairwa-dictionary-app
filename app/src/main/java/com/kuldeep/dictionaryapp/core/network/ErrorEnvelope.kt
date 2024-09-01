package com.kuldeep.dictionaryapp.core.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiErrorModelMapper
import com.skydoves.sandwich.message
import com.skydoves.sandwich.retrofit.statusCode
import kotlinx.serialization.Serializable


@Serializable
data class ErrorEnvelope(
    val code: Int,
    val message: String
)

@Serializable
data class SKAA(
    val title: String,
    val message: String,
    val resolution:String
)

object ErrorEnvelopeMapper : ApiErrorModelMapper<ErrorEnvelope> {

    override fun map(apiErrorResponse: ApiResponse.Failure.Error): ErrorEnvelope {
        return ErrorEnvelope(apiErrorResponse.statusCode.code, apiErrorResponse.message())
    }
}