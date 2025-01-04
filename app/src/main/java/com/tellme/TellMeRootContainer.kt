package com.tellme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tellme.feature_main.screen.MainScreen

@Composable
fun TellMeRootContainer(navController: NavHostController, modifier: Modifier) {

    NavHost(navController = navController, startDestination = NavDestination.MainScreen, modifier = modifier) {
        composable<NavDestination.MainScreen> {
            MainScreen()
        }
    }
}
