package com.example.moviedb

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.moviedb.navigation.AppNavGraph
import com.example.moviedb.navigation.Screen
import com.example.moviedb.presentation.ui.details_screen.DetailsScreen
import com.example.moviedb.presentation.ui.home_screen.MoviesScreen
import com.example.moviedb.presentation.ui.home_screen.movie_by_category.MovieByCategoryContent
import com.example.moviedb.util.API_KEY
import com.example.ui.theme.MovieDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MovieDBTheme {
                MoviesScreen(onNavigateToDetails = { movieId ->
                    navController.navigate(Screen.DetailsScreen.createRoute(movieId))
                })
            }
        }
    }
}

