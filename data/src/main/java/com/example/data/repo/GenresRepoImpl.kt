package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.GenreResponse
import com.example.domain.entity.GenresItem
import com.example.domain.entity.PopularMovies
import com.example.domain.repo.GenresRepo
import com.example.domain.repo.MoviesRepo
import javax.inject.Inject

class GenresRepoImpl @Inject constructor(private val apiService: ApiService): GenresRepo {
    override suspend fun getGenres(apiKey: String): GenreResponse = apiService.getCategoriesList(apiKey)

}