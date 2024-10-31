package com.example.moviedb.navigation

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("onboarding")
    object HomeScreen : Screen("home")
    object DetailsScreen : Screen("DetailsScreen/{movieId}")
}
