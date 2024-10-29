package com.example.data.remote

import com.example.domain.entity.GenreResponse
import com.example.domain.entity.GenresItem
import com.example.domain.entity.MovieDetails
import com.example.domain.entity.PopularMovies
import com.example.domain.entity.popular_movies.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

//    @GET("movie/{category}")
//    suspend fun  getMoviesList(
//        @Path("category") category : String,
//        @Query("page") page: Int,
//        @Query("api_key") apiKey: String = API_KEY
//    )


    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String ,
        @Query("with_genres") withGenres: String,
        @Query("page") page: Int
    ): PopularMoviesResponse

    @GET("genre/movie/list")
    suspend fun getCategoriesList(
        @Query("api_key") apiKey: String
    ): GenreResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieDetails



}