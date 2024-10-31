package com.example.moviedb.presentation.common_ui

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.moviedb.R


@Composable
fun CircularProgressAnimated(modifier: Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(animation = tween(900)),
        label = ""
    )
    CircularProgressIndicator(
        progress = { progressAnimationValue },
        modifier = modifier,
        color = Color.Green,
    )
}