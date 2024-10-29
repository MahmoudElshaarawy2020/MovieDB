package com.example.moviedb.presentation.ui.home_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.entity.GenresItem

@Composable
fun CategoryItem(category: GenresItem){
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .size(width = 116.dp, height = 36.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = category.name.toString(),
            textAlign = TextAlign.Center
        )
    }
}

//@Composable
//@Preview(showBackground = true)
//fun CategoryItemPreview() {
//CategoryItem()
//}