package com.kuldeep.dictionaryapp.core.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiErrorModelMapper
import com.skydoves.sandwich.message
import com.skydoves.sandwich.retrofit.statusCode

/**
 * A mapper for mapping [ApiResponse.Failure.Error] response as custom [DictionaryErrorResponse] instance.
 *
 * @see [ApiErrorModelMapper](https://github.com/skydoves/sandwich#apierrormodelmapper)
 */
object ErrorResponseMapper : ApiErrorModelMapper<DictionaryErrorResponse> {

    /**
     * maps the [ApiResponse.Failure.Error] to the [DictionaryErrorResponse] using the mapper.
     *
     * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
     * @return A customized [DictionaryErrorResponse] error response.
     */
    override fun map(apiErrorResponse: ApiResponse.Failure.Error): DictionaryErrorResponse {
        return DictionaryErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
    }
}