package com.example.moviedb.presentation.ui.home_screen.movie_by_category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entity.popular_movies.Result

@Composable
fun MovieLazyGrid(moviesList: List<Result>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 4.dp, bottom = 46.dp)
    ) {
        items(moviesList.size) {
            MovieCard(
                moviesList[it],
            )
        }
    }
}