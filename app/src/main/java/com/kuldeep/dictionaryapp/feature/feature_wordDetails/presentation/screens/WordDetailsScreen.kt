package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.viewmodel.WordDetailsViewModel

@Composable
fun WordDetailsScreen(viewModel: WordDetailsViewModel, navController: NavController,word:String?) {
    Text(text = word?:"not available")
}