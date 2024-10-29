package com.example.domain.repo

import com.example.domain.entity.PopularMovies
import com.example.domain.entity.popular_movies.PopularMoviesResponse


interface MoviesRepo {
    suspend fun getPopularMoviesFromRemote(apiKey: String, genresId: String): PopularMoviesResponse
}