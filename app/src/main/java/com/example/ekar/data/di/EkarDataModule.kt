package com.example.ekar.data.di

import com.example.ekar.data.intercepter.QueryInterceptor
import com.example.ekar.data.remote.EkarApi
import com.example.ekar.data.repository.EkarRepositoryImp
import com.example.ekar.domain.repository.EkarRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EkarDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        queryInterceptor: QueryInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor(
                queryInterceptor
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideEkarApi(client: OkHttpClient, moshi: Moshi): EkarApi {
        return Retrofit.Builder()
            .baseUrl(EkarApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideEkarRepository(
        api: EkarApi,
    ): EkarRepository {
        return EkarRepositoryImp(
            api = api
        )
    }
}