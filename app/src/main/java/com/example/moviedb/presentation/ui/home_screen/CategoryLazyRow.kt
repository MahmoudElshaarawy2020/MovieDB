package com.example.moviedb.presentation.ui.home_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entity.GenresItem

@Composable
fun CategoryLazyRow(
    listOfCategories: List<GenresItem>?,
    onClick: (String) -> Unit
) {

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        if (listOfCategories != null) {
            items(listOfCategories) { category ->
                CategoryItem(
                    category = category,
                    onClick = {
                        onClick(category.id.toString())
                    }
                )
            }
        }
    }
}
