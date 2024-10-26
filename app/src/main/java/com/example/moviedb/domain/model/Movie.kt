package com.example.moviedb.domain.model

import androidx.room.PrimaryKey

data class Movie(

    val overview: String,
    val originalLanguage: String,
    val originalTitle: String,
    val video: Boolean,
    val title: String,
    val genreIds: List<Int?>,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val popularity: Any,
    val voteAverage: Any,
    val adult: Boolean,
    val voteCount: Int,
    val id: Int,
    val category : String


)
