package com.kuldeep.dictionaryapp.feature.feature_search.presentation.state

sealed class SearchUiState {
    data object Idle : SearchUiState()
    data class SearchWord(val word: String) : SearchUiState()
    data class Error(val message: String) : SearchUiState()
}