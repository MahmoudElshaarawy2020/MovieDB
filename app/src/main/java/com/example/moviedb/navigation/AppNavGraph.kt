package com.example.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviedb.presentation.ui.onboarding.OnBoardingScreen
import com.example.moviedb.presentation.ui.details_screen.DetailsScreen
import com.example.moviedb.presentation.ui.home_screen.MoviesScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route
    ) {
        composable(Screen.OnBoardingScreen.route) {
            OnBoardingScreen(
                onNavigateToHome = {
                navController.navigate(Screen.HomeScreen.route)
            })
        }
        composable(Screen.HomeScreen.route) {
            MoviesScreen(onNavigateToDetails = { movieId ->
                navController.navigate(Screen.DetailsScreen.route)
            }, navController = navController)
        }
        composable(
            route = "DetailsScreen/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?:""
            DetailsScreen(movieId = movieId, navHostController = navController)
        }
    }
}
