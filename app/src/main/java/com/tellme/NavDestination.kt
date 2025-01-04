package com.tellme

import kotlinx.serialization.Serializable

sealed class NavDestination {
    @Serializable
    data object MainScreen : NavDestination()
}