package com.example.moviedb.domain.repository

import com.example.moviedb.domain.model.Movie
import com.example.moviedb.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote : Boolean,
        category : String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int) : Flow<Resource<Movie>>
}