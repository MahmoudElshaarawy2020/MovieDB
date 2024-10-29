package com.example.domain.usecase

import com.example.domain.entity.PopularMovies
import com.example.domain.repo.GenresRepo
import com.example.domain.repo.MoviesRepo

class GetGenres(private val genresRepo: GenresRepo) {
    suspend operator fun invoke(apiKey:String) = genresRepo.getGenres(apiKey)
}