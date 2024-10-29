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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedb.R

@Composable
fun DetailsScreen(movieId: String?) {

    val gridState = rememberLazyGridState()

    val imageList = listOf(
        R.drawable.actor1,
        R.drawable.actor1,
        R.drawable.actor1,
        R.drawable.actor1,
        R.drawable.actor1,
        R.drawable.actor1
    )

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
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp),
                    painter = painterResource(id = R.drawable.movie1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {


                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Morbius",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 52.sp
                )
                Spacer(modifier = Modifier.size(width = 140.dp, height = 10.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {


                    Image(
                        modifier = Modifier
                            .size(35.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.stars),
                        contentDescription = null
                    )

                    Text(
                        "7.8/10",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp)
                }
            }
        }

        item {
            Text(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex.",
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
                items(imageList) { imageResId ->
                    ActorsBox(image = imageResId)
                }
            }
        }
                


    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(null)
}