package com.tellme

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tellme.core_ui.theme.TellMeTheme
import com.tellme.feature_note.screen.NewNoteScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            TellMeTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavDestination.MainRoot
                ) {
                    composable<NavDestination.MainRoot> {
                        MainRootScreen {
                            navController.navigate(NavDestination.NewNoteScreen)
                        }
                    }

                    composable<NavDestination.NewNoteScreen> {
                        NewNoteScreen(vm = hiltViewModel())
                    }
                }
            }
        }
    }
}