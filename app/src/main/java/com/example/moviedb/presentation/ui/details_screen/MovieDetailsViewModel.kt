package com.example.moviedb.presentation.ui.details_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MovieDetails
import com.example.domain.usecase.GetDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import perfetto.protos.UiState
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel@Inject constructor(
    private val getDetails: GetDetails
): ViewModel() {
    private val _movieDetails: MutableStateFlow<MovieDetails?> = MutableStateFlow(null)
    val movieDetails: StateFlow<MovieDetails?>  = _movieDetails

    fun getMovieDetails(apiKey: String, movieId: String) {
        viewModelScope.launch {
            try {
                val result = getDetails(apiKey, movieId)
                _movieDetails.value = result
            }
            catch (e: Exception) {
                _movieDetails.value = null
                Log.e("MovieDetailsViewModel", "Error fetching movie details: ${e.message}")
            }
        }
    }
    }
