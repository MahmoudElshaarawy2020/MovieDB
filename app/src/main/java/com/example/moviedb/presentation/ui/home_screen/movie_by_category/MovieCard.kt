package com.example.moviedb.presentation.ui.home_screen.movie_by_category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.entity.popular_movies.Result


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movie: Result, onClick: () -> Unit = {}) {
    //val movieId = movie.id.toString()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(width = 190.dp, height = 260.dp)
            .clickable {
                onClick()
            }
    ) {
        GlideImage(
            model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
            contentDescription = "Product Image",
            modifier = Modifier
                .padding(top = 2.dp, bottom = 4.dp)
                .height(150.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .weight(0.8f),
            contentScale = ContentScale.Fit
        )

        Text(
            modifier = Modifier
                .padding(4.dp, 2.dp)
                .weight(0.1f),
            text = movie.title ?: "No Title",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Text(
            modifier = Modifier
                .padding(4.dp, 2.dp)
                .weight(0.1f),
            text = movie.release_date ?: "No Date",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray

        )


    }

}

