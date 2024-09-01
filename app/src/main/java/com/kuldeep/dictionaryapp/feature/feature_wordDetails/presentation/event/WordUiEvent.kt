package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.event

sealed class WordUiEvent {
    data object LoadInitialWord : WordUiEvent()

    data class SearchWord(val word: String) : WordUiEvent()

    data object Retry : WordUiEvent()

    data class ShowErrorMessage(val message: String) : WordUiEvent()

}