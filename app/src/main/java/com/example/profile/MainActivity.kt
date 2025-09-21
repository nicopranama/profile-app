package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profile.navigation.*
import com.example.profile.ui.screens.Page1Screen
import com.example.profile.ui.screens.Page2Screen
import com.example.profile.ui.screens.Page3Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF1A1A1A)
                ) {
                    NavigationApp()
                }
            }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    val navigationManager = remember(navController) { NavigationManager(navController) }

    NavHost(
        navController = navController,
        startDestination = Page1Screen
    ) {
        composable<Page1Screen> {
            Page1Screen(navigationManager = navigationManager)
        }

        composable<Page2Screen> {
            Page2Screen(navigationManager = navigationManager)
        }

        composable<Page3Screen> {
            Page3Screen(navigationManager = navigationManager)
        }
    }
}

