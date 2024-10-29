package com.example.moviedb.di

import com.example.data.remote.ApiService
import com.example.data.repo.GenresRepoImpl
import com.example.data.repo.MoviesDetailsRepoImpl
import com.example.data.repo.MoviesRepoImpl
import com.example.domain.repo.GenresRepo
import com.example.domain.repo.MoviesDetailsRepo
import com.example.domain.repo.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideMoviesRepo(apiService: ApiService): MoviesRepo {
        return MoviesRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGenresRepo(apiService: ApiService): GenresRepo {
        return GenresRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideDetailsRepo(apiService: ApiService): MoviesDetailsRepo {
        return MoviesDetailsRepoImpl(apiService)
    }


}