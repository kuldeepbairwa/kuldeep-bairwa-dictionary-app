package com.kuldeep.dictionaryapp.feature.feature_search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.event.SearchEvents
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.state.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor() :ViewModel() {
    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Idle)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onEvent(event:SearchEvents){

        when(event){
            SearchEvents.Idle -> {

            }
            is SearchEvents.SearchWord -> {

            }
            is SearchEvents.ShowErrorMessage -> {

            }
        }
    }
}