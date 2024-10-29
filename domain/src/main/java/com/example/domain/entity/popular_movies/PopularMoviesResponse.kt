package com.example.domain.entity.popular_movies

data class PopularMoviesResponse(
    var page: Int?,
    var results: List<Result>?,
    var total_pages: Int?,
    var total_results: Int?
)