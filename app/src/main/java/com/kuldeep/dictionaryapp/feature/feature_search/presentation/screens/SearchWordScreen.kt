package com.kuldeep.dictionaryapp.feature.feature_search.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.viewmodel.SearchWordViewModel

@Composable
fun SearchWordScreen(viewModel: SearchWordViewModel, onWordSearch: (String) -> Unit) {

    var word by remember { mutableStateOf("") }

    Column {
        TextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("Enter Word") }
        )

        Button(onClick = {
            onWordSearch(word)
        }) {
            Text("Search")
        }
    }
}