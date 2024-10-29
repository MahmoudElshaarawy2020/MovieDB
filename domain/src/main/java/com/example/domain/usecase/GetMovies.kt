package com.example.domain.usecase

import com.example.domain.entity.PopularMovies
import com.example.domain.repo.MoviesRepo

class GetMovies(private val moviesRepo: MoviesRepo) {
    suspend operator fun invoke(apiKey: String, genresId: String) = moviesRepo.getPopularMoviesFromRemote(apiKey, genresId = genresId)
}