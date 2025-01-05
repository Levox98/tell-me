package com.tellme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tellme.feature_main.screen.MainScreen

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = NavDestination.MainScreen,
        modifier = modifier
    ) {
        composable<NavDestination.MainScreen> {
            MainScreen(vm = hiltViewModel(), onNavigateToDayNotes = {})
        }
    }
}
