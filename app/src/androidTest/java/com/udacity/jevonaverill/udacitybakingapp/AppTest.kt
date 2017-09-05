package com.udacity.jevonaverill.udacitybakingapp

import com.udacity.jevonaverill.udacitybakingapp.dagger.AppComponent
import com.udacity.jevonaverill.udacitybakingapp.dagger.DaggerAppComponent
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.ApiModule
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.AppModule

/**
 * Created by jevonaverill on 9/5/17.
 */
class AppTest : App() {

    override fun buildComponent(): AppComponent {
        return buildComponentWithApiUrl("/")
    }

    private fun buildComponentWithApiUrl(apiUrl: String): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(apiUrl))
                .build()
    }

    fun injectWithApiUrl(apiUrl: String) {
        appComponent = buildComponentWithApiUrl(apiUrl)
    }

}