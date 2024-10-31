package com.example.moviedb.presentation.ui.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.moviedb.MoviesViewModel
import com.example.moviedb.R
import com.example.moviedb.presentation.common_ui.CircularProgressAnimated
import com.example.moviedb.presentation.ui.home_screen.movie_by_category.MovieByCategoryContent
import com.example.moviedb.util.API_KEY
import com.example.moviedb.util.UiState

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    onNavigateToDetails: (movieId: String) -> Unit,
    navController: NavHostController
) {
    // Trigger genre fetching when MoviesScreen is composed
    LaunchedEffect(Unit) {
        viewModel.getGenres(API_KEY)
    }

    // Collect the genres UI state
    val genresUiState by viewModel.genres.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding()
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
            text = stringResource(id = R.string.categories),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.size(20.dp))

        // Handle UI State for Genres
        when (val state = genresUiState) {
            is UiState.Loading -> {
                CircularProgressAnimated(modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterHorizontally))
            }
            is UiState.Success -> {
                CategoryLazyRow(
                    listOfCategories = state.data?.genres,
                    onClick = { genreId ->
                        viewModel.getMovies(API_KEY, genreId)
                    }
                )
            }
            is UiState.Error -> {
                Text(
                    text = "${state.message?.asString(navController.context)}" ,
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }

            is UiState.Empty -> {

            }
        }

        Spacer(modifier = Modifier.size(15.dp))

        // Second header text
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
            text = stringResource(id = R.string.Most_searched),
            fontWeight = FontWeight.Bold
        )

        // Display movies by category
        MovieByCategoryContent(
            genresId = genresUiState.data?.genres?.getOrNull(0)?.id.toString(),
            navController = navController
        )
    }
}
