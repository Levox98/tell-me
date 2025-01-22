package com.tellme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tellme.core_ui.component.bottomNavBarGradient
import com.tellme.util.navigateThroughBottom
import com.tellme.core_ui.R as BaseR

@Composable
fun MainRootScreen(
    onNavigateToNewNote: () -> Unit
) {
    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    LifecycleResumeEffect(navController) {
        if (currentBackStackEntry?.destination?.route == NavDestination.MainRoot::class.java.canonicalName) {
            navController.navigateThroughBottom(NavDestination.MainScreen)
        }

        onPauseOrDispose { }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .background(bottomNavBarGradient, RoundedCornerShape(24.dp, 24.dp)),
                containerColor = Color.Transparent
            ) {

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigateThroughBottom(NavDestination.MainScreen)
                    },
                    icon = {
                        SetupBottomNavIcon(
                            currentBackStackEntry = currentBackStackEntry,
                            desiredDestination = NavDestination.MainScreen,
                            selectedIconId = BaseR.drawable.ic_nav_bar_home_selected,
                            iconId = BaseR.drawable.ic_nav_bar_home
                        )
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigateThroughBottom(NavDestination.ChartsScreen)
                    },
                    icon = {
                        SetupBottomNavIcon(
                            currentBackStackEntry = currentBackStackEntry,
                            desiredDestination = NavDestination.ChartsScreen,
                            selectedIconId = BaseR.drawable.ic_nav_bar_chart_selected,
                            iconId = BaseR.drawable.ic_nav_bar_chart
                        )
                    }
                )

                Spacer(modifier = Modifier.width(50.dp))

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigateThroughBottom(NavDestination.UserScreen)
                    },
                    icon = {
                        SetupBottomNavIcon(
                            currentBackStackEntry = currentBackStackEntry,
                            desiredDestination = NavDestination.UserScreen,
                            selectedIconId = BaseR.drawable.ic_nav_bar_user_selected,
                            iconId = BaseR.drawable.ic_nav_bar_user
                        )
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigateThroughBottom(NavDestination.SettingsScreen)
                    },
                    icon = {
                        SetupBottomNavIcon(
                            currentBackStackEntry = currentBackStackEntry,
                            desiredDestination = NavDestination.SettingsScreen,
                            selectedIconId = BaseR.drawable.ic_nav_bar_settings_selected,
                            iconId = BaseR.drawable.ic_nav_bar_settings
                        )
                    }
                )
            }
        },
        floatingActionButton = {
            Box(
                modifier = Modifier.size(64.dp)
            ) {
                FloatingActionButton(
                    onClick = onNavigateToNewNote,
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = 54.dp),
                    shape = CircleShape,
                    containerColor = Color.Transparent,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp)
                ) {
                    Icon(
                        painter = painterResource(BaseR.drawable.ic_nav_bar_add),
                        null,
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                bottomNavBarGradient
                            ),
                        tint = Color.Black
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        MainNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun SetupBottomNavIcon(
    currentBackStackEntry: NavBackStackEntry?,
    desiredDestination: NavDestination,
    @DrawableRes selectedIconId: Int,
    @DrawableRes iconId: Int
) {
    val isDesiredDestination =
        currentBackStackEntry?.destination?.hasRoute(desiredDestination::class) == true

    Icon(
        painter = if (isDesiredDestination) {
            painterResource(selectedIconId)
        } else {
            painterResource(iconId)
        },
        contentDescription = null,
        tint = Color.Black
    )
}
