package com.kuldeep.dictionaryapp.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kuldeep.dictionaryapp.core.ui.NavDestination
import com.kuldeep.dictionaryapp.core.ui.routes
import com.kuldeep.dictionaryapp.core.ui.dictionaryNavGraph
import com.kuldeep.dictionaryapp.core.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val destinations = listOf(
                    NavDestination.SearchWord,
                    NavDestination.WordDetails,
                    NavDestination.SearchHistory
            )

            var selectedIndex by remember { mutableIntStateOf(0) }
            DictionaryAppTheme {
                Scaffold(
                    content = { innerPadding ->
                        Surface(
                            modifier = Modifier.padding(innerPadding),
                            color = MaterialTheme.colorScheme.surface
                        ) {
                            NavHost(navController = navController, startDestination = routes) {
                                dictionaryNavGraph(navController)
                            }
                        }

                    },
                    bottomBar = {

                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            destinations.forEachIndexed { index, screen ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(imageVector = screen.icon, contentDescription = null)
                                    },
                                    label = { Text(screen.title) },
                                    selected = index == selectedIndex,
                                    onClick = {
                                        selectedIndex = index
                                        navController.navigate(screen.route) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true
                                            // Restore state when reselecting a previously selected item
                                            restoreState = true
                                        }
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                        selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                                        indicatorColor = Color.Transparent
                                    )
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}