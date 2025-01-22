package com.tellme.util

import androidx.navigation.NavHostController
import com.tellme.NavDestination


internal fun NavHostController.navigateThroughBottom(destination: NavDestination) {
    this.navigate(destination) {
        popUpTo(NavDestination.MainRoot) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}