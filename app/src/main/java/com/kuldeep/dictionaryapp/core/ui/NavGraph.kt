package com.kuldeep.dictionaryapp.core.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Translate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.screens.SearchWordScreen
import com.kuldeep.dictionaryapp.feature.feature_searchHistory.presentation.screens.SearchHistoryScreen
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.screens.WordDetailsScreen


const val routes = "auth"

sealed class NavDestination(val title:String, val route: String, val icon: ImageVector) {
    data object SearchWord : NavDestination(
        title = "Home",
        route = "$routes/SearchWord",
        icon = Icons.Default.Search)
    data object WordDetails : NavDestination(
        title = "Meaning", route = "$routes/wordDetails/{word}",
        icon = Icons.Default.Translate)
    data object SearchHistory : NavDestination(
        title = "History",
        route = "$routes/searchHistory",
        icon = Icons.Default.History
    )
}

fun NavGraphBuilder.dictionaryNavGraph(
    navController: NavController,
) {
    navigation(startDestination = NavDestination.SearchWord.route, route = routes) {
        composable(NavDestination.SearchWord.route) {
            SearchWordScreen(
                viewModel = hiltViewModel()
            ) { word ->
                val route = NavDestination.WordDetails.route.replace("{word}", word)
                navController.navigate(route)
            }
        }

        composable(NavDestination.SearchHistory.route) {
            SearchHistoryScreen(
                viewModel = hiltViewModel()
            ) { word ->
                val route = NavDestination.WordDetails.route.replace("{word}", word)
                navController.navigate(route)
            }
        }

        composable(
            route = NavDestination.WordDetails.route,
            arguments = listOf(navArgument("word") { type = NavType.StringType })

        ) { backStackEntry ->
            val word = backStackEntry.arguments?.getString("word")
            WordDetailsScreen(
                viewModel = hiltViewModel(),
                word
            )
        }
    }
}