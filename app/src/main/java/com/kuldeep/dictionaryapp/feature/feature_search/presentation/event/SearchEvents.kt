package com.kuldeep.dictionaryapp.feature.feature_search.presentation.event

sealed class SearchEvents {
    data object Idle : SearchEvents()
    data class SearchWord(val word: String) : SearchEvents()
    data class ShowErrorMessage(val message: String) : SearchEvents()
}