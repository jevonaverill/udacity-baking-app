package com.udacity.jevonaverill.udacitybakingapp.dagger.module

import com.squareup.moshi.Moshi
import com.udacity.jevonaverill.udacitybakingapp.App
import com.udacity.jevonaverill.udacitybakingapp.manager.RecipeInfoWidgetManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by jevonaverill on 9/3/17.
 */
@Module
class AppModule(private val application: App) {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun produceMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun produceRecipeInfoWidgetManager(): RecipeInfoWidgetManager {
        return RecipeInfoWidgetManager(application)
    }


}