package com.example.moviedb.presentation.ui.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.moviedb.R
import com.example.moviedb.util.API_KEY

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(
    movieId: String,
    navHostController: NavHostController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getMovieDetails(API_KEY, movieId)
    }
    val movie by viewModel.movieDetails.collectAsState()
    val gridState = rememberLazyGridState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding()
    ) {
//        AsyncImage(model = , contentDescription = "Movie Poster")
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .shadow(
                        elevation = 25.dp,
                    )
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp),
                    model = "https://image.tmdb.org/t/p/w500${movie?.posterPath}",
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }

        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {


                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(0.8f),
                    text = movie?.title ?: "No name",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 52.sp
                )
                Spacer(modifier = Modifier.size(width = 60.dp, height = 10.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(0.2f)) {


                    Image(
                        modifier = Modifier
                            .size(35.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.stars),
                        contentDescription = null
                    )

                    Text(
                        text = movie?.voteAverage.toString(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
            }
        }

        item {
            Text(
                text = movie?.overview ?: "No overview",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            )
        }

        item {
            LazyHorizontalGrid(
                state = gridState,
                rows = GridCells.Fixed(2), // Number of rows
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp), // Set a height for the grid
                verticalArrangement = Arrangement.spacedBy(8.dp), // Space between images vertically
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between images horizontally
            ) {
//                items(imageList) { imageResId ->
//                    ActorsBox(image = imageResId)
                }
            }
        }
                


    }
