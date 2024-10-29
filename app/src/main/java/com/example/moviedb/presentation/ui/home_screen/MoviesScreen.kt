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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviedb.MoviesViewModel
import com.example.moviedb.R
import com.example.moviedb.navigation.Screen
import com.example.moviedb.presentation.ui.home_screen.movie_by_category.MovieByCategoryContent
import com.example.moviedb.util.API_KEY

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    onNavigateToDetails: (movieId: String) -> Unit
){
    LaunchedEffect(key1 = Unit) {
        viewModel.getGenres(apiKey = API_KEY)
    }
    val genres by viewModel.genres.collectAsState()
    Column(
        modifier = Modifier
        .fillMaxSize()
        .displayCutoutPadding()
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
            text = stringResource(id = R.string.categories),
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(20.dp))
        CategoryLazyRow(listOfCategories = genres.data?.genres?: emptyList())

        Spacer(modifier = Modifier.size(20.dp))

        MovieByCategoryContent(genresId = "35")

    }
}

