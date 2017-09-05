package com.udacity.jevonaverill.udacitybakingapp.dagger.module

import com.squareup.moshi.Moshi
import com.udacity.jevonaverill.udacitybakingapp.service.RecipesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by jevonaverill on 9/3/17.
 */
@Module
class ApiModule (private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideBakingRecipesService(retrofit: Retrofit) : RecipesService {
        return retrofit.create(RecipesService::class.java)
    }

}