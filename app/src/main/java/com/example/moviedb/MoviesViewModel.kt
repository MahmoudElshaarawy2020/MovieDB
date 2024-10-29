package com.example.moviedb

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.GenreResponse
import com.example.domain.entity.GenresItem
import com.example.domain.entity.PopularMovies
import com.example.domain.entity.popular_movies.PopularMoviesResponse
import com.example.domain.usecase.GetDetails
import com.example.domain.usecase.GetGenres
import com.example.domain.usecase.GetMovies
import com.example.moviedb.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val genresUseCase: GetGenres,
    private val getMoviesUseCase : GetMovies,
    private val moviesDetailsUseCase: GetDetails
): ViewModel() {

    private val _popular: MutableStateFlow<PopularMoviesResponse?> = MutableStateFlow(null)
    val popular: StateFlow<PopularMoviesResponse?> = _popular

    private val _genres: MutableStateFlow<Resource<GenreResponse>> =
        MutableStateFlow(Resource.Loading())
    val genres: StateFlow<Resource<GenreResponse>> get() = _genres

    private val _details: MutableStateFlow<PopularMovies?> = MutableStateFlow(null)
    var details: StateFlow<PopularMovies?> = _details


    fun getMovies(apiKey: String, genresId: String) {
        viewModelScope.launch {
            try {
                _popular.value = getMoviesUseCase(apiKey, genresId)
            } catch (e: Exception) {
                Log.e("MoviesViewModel", e.message.toString())
            }
        }
    }

    fun getGenres(apiKey: String) {
        viewModelScope.launch {
            try {
                _genres.value = Resource.Loading()
                val response = genresUseCase(apiKey)
                _genres.value = Resource.Success(response)
            } catch (e: Exception) {
                Log.e("GenresViewModel", e.message.toString())
                _genres.value = Resource.Error(e.message.toString())
            }
        }
    }

    fun getMovieDetails(movieId: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                 moviesDetailsUseCase(apiKey, movieId.toString())
            } catch (e: Exception) {
                Log.e("MoviesViewModel", e.message.toString())
            }
        }
    }
}