package com.example.domain.entity

import com.google.gson.annotations.SerializedName

data class GenreResponse(

	@field:SerializedName("genres")
	var genres: List<GenresItem>? = null
)


