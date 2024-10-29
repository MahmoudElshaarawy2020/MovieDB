package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.PopularMovies
import com.example.domain.repo.MoviesRepo
import javax.inject.Inject

class MoviesRepoImpl @Inject constructor(private val apiService: ApiService): MoviesRepo {
    override suspend fun getPopularMoviesFromRemote(apiKey:String, genresId: String)
    = apiService.getPopularMovies(apiKey, page = 1, withGenres = genresId)
}