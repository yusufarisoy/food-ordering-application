package com.kodluyoruz.yahnifood.di

import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.kodluyoruz.yahnifood.data.remote.NetworkApiService
import com.kodluyoruz.yahnifood.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): NetworkApiService {
        return retrofit.create(NetworkApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endPoint: EndPoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideEndPoint(): EndPoint {
        return EndPoint("bizim url")
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return builder.build()
    }


    @Provides
    fun provideGson(): Gson {
        return Gson()
    }


    @Provides
    fun provideRemoteDataSource(
        apiService: NetworkApiService,
//        rickApiService: RickApiService
    ): RemoteDataSource {
        return RemoteDataSource()
    }

}

data class EndPoint(val url: String)