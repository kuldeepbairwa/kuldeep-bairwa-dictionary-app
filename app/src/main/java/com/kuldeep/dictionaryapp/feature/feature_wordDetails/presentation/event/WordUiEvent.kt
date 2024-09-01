package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.event

sealed class WordUiEvent {
    data object Idle : WordUiEvent()

    data class SearchWord(val word: String) : WordUiEvent()

    data class ShowErrorMessage(val message: String) : WordUiEvent()

}