package com.example.moviedb.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{category}")
    suspend fun  getMoviesList(
        @Path("category") category : String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    )


    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1M2VlMTU4OTU5NDM1YjBhMTA1ZmI0ZWM1NTY3MjZlZiIsIm5iZiI6MTcyOTYwMDEyNC4yOTI0OTQsInN1YiI6IjY2YThjYmJhNGQyZDJhYjI4MDAzZWM5YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PHfcWPJ5IPhSEqiUcxGR-2K_-L81F4TMRmSVRL2E7c0"
    }
}