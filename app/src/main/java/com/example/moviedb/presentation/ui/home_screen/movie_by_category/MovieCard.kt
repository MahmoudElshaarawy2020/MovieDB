package com.example.moviedb.presentation.ui.home_screen.movie_by_category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.entity.popular_movies.Result
import com.example.moviedb.R
import com.example.moviedb.util.IMAGE_BASE_URL

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movie: Result) {
    Column(
        modifier = Modifier.size(width = 170.dp, height = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GlideImage(
            model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
            contentDescription = "Product Image",
            modifier = Modifier
                .padding(4.dp, 2.dp)
                .fillMaxWidth()
                .height(150.dp)
        )
        
        Text(
            modifier = Modifier.padding(4.dp, 2.dp),text = movie.title ?: "No Title")
        Text(
            modifier = Modifier.padding(4.dp, 2.dp),text = movie.release_date ?: "No Date")


    }

}

