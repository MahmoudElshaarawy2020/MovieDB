package com.example.domain.repo

import com.example.domain.entity.MovieDetails

interface MoviesDetailsRepo {
    suspend fun getMovieDetails(apiKey: String, movieId: String): MovieDetails

}