package com.example.profile.navigation

import androidx.navigation.NavHostController
data class PageInfo(
    val currentPage: Int,
    val title: String,
    val availablePages: List<Int>
)

class NavigationManager(private val navController: NavHostController) {

    private val pages = mapOf(
        1 to PageInfo(
            currentPage = 1,
            title = "Page 1",
            availablePages = listOf(2, 3)
        ),
        2 to PageInfo(
            currentPage = 2,
            title = "Page 2",
            availablePages = listOf(1, 3)
        ),
        3 to PageInfo(
            currentPage = 3,
            title = "Page 3",
            availablePages = listOf(1, 2)
        )
    )

    fun navigateToPage(page: Int) {
        when (page) {
            1 -> navController.navigate(Page1Screen)
            2 -> navController.navigate(Page2Screen)
            3 -> navController.navigate(Page3Screen)
        }
    }

    fun getCurrentPageInfo(): PageInfo? {
        val currentRoute = navController.currentDestination?.route?.substringBefore("?")
        return when {
            currentRoute?.contains("Page1Screen") == true -> pages[1]
            currentRoute?.contains("Page2Screen") == true -> pages[2]
            currentRoute?.contains("Page3Screen") == true -> pages[3]
            else -> null
        }
    }
}