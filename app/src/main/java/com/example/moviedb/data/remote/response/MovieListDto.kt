package com.example.moviedb.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListDto(

    @field:SerializedName("page")
	val page: Int? = null,

    @field:SerializedName("total_pages")
	val totalPages: Int? = null,

    @field:SerializedName("results")
	val results: List<MovieDto?>? = null,

    @field:SerializedName("total_results")
	val totalResults: Int? = null
)