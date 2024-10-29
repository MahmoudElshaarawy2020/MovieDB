package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.MovieDetails
import com.example.domain.repo.MoviesDetailsRepo
import javax.inject.Inject

class MoviesDetailsRepoImpl @Inject constructor(private val apiService: ApiService):
    MoviesDetailsRepo {
    override suspend fun getMovieDetails(apiKey: String, movieId: String): MovieDetails
    = apiService.getMovieDetails(movieId.toInt(), apiKey)

}