package com.example.domain.repo

import com.example.domain.entity.GenreResponse
import com.example.domain.entity.GenresItem
import com.example.domain.entity.PopularMovies


interface GenresRepo {
    suspend fun getGenres(apiKey: String): GenreResponse
}