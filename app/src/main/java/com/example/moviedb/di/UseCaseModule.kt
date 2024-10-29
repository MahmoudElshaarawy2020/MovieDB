package com.example.moviedb.di

import com.example.data.remote.ApiService
import com.example.data.repo.MoviesRepoImpl
import com.example.domain.repo.GenresRepo
import com.example.domain.repo.MoviesDetailsRepo
import com.example.domain.repo.MoviesRepo
import com.example.domain.usecase.GetDetails
import com.example.domain.usecase.GetGenres
import com.example.domain.usecase.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideMoviesUseCase(moviesRepo: MoviesRepo): GetMovies{
        return GetMovies(moviesRepo)
    }

    @Provides
    @Singleton
    fun provideGenresUseCase(genresRepo: GenresRepo): GetGenres {
        return GetGenres(genresRepo)
    }

    @Provides
    @Singleton
    fun provideMoviesDetailsUseCase(moviesDetailsRepo: MoviesDetailsRepo): GetDetails {
        return GetDetails(moviesDetailsRepo)
    }

}