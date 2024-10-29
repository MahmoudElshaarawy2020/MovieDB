package com.example.moviedb.presentation.ui.home_screen.movie_by_category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviedb.MoviesViewModel
import com.example.moviedb.util.API_KEY

@Composable
fun MovieByCategoryContent(viewModel: MoviesViewModel = hiltViewModel(), genresId: String) {
    val moviesList by viewModel.popular.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getMovies(API_KEY, genresId)
    }
    Column(
        modifier = Modifier
            .displayCutoutPadding()
    ){
        MovieLazyGrid(moviesList = moviesList?.results ?: emptyList())

    }

}