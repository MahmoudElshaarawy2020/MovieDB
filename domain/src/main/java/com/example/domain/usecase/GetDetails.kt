package com.example.domain.usecase

import com.example.domain.repo.MoviesDetailsRepo

class GetDetails(private val moviesDetailsRepo: MoviesDetailsRepo) {
    suspend operator fun invoke(apiKey:String, movieId: String) = moviesDetailsRepo.getMovieDetails(apiKey, movieId)

}