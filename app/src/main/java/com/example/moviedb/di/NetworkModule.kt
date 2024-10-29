package com.example.moviedb.di

import com.example.data.remote.ApiService
import com.example.moviedb.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1M2VlMTU4OTU5NDM1YjBhMTA1ZmI0ZWM1NTY3MjZlZiIsIm5iZiI6MTczMDA0Njk5OS41NDMxOTQsInN1YiI6IjY2YThjYmJhNGQyZDJhYjI4MDAzZWM5YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.cO2e4qyFe3A18IIwHJ1Saa5v3dvU8Mu5JsRmYjX4Qck"

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val request: Request = original.newBuilder()
                .header("accept", "application/json")
                .header("Authorization", AUTH_TOKEN)
                .build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor) // Add the interceptor to OkHttp
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
