package com.kuldeep.dictionaryapp.feature.feature_searchHistory.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.usecase.DeleteWordUseCase
import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.usecase.GetSearchHistoryUseCase
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchHistoryViewModel @Inject constructor(
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
    private val deleteWordUseCase: DeleteWordUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<List<Word>>(emptyList())
    val uiState: StateFlow<List<Word>> = _uiState.asStateFlow()

    init {
        loadWordHistory()
    }

    // Simulate loading words from a repository
    private fun loadWordHistory() {
        viewModelScope.launch {
            // Load your data here
            // For example:
            getSearchHistoryUseCase().collect{ words->
                _uiState.value =words
            }
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteWordUseCase(word.word)
        }
    }
}