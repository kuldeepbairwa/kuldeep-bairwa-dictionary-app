package com.kuldeep.dictionaryapp.feature.feature_search.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.event.SearchEvents
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.state.SearchUiState
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.viewmodel.SearchWordViewModel

@Composable
fun SearchWordScreen(viewModel: SearchWordViewModel, onWordSearch: (String) -> Unit) {

    var word by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val onEvent = viewModel::onEvent

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.size(80.dp))

        TextField(
            value = word,
            onValueChange = {
                word = it.trim()
                            },
            label = { Text("Enter Word") }
        )

        Spacer(modifier = Modifier.size(20.dp))

        Button(onClick = {
            if(word.isNotEmpty()){
                onWordSearch(word)
            }else{
                viewModel.onEvent(SearchEvents.ShowErrorMessage("Please enter a word"))
            }
        }) {
            Text("Search")
        }

    }
}