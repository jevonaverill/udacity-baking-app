package com.udacity.jevonaverill.udacitybakingapp

import android.app.Application
import android.content.Context
import com.udacity.jevonaverill.udacitybakingapp.dagger.AppComponent
import com.udacity.jevonaverill.udacitybakingapp.dagger.DaggerAppComponent
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.ApiModule
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.AppModule

/**
 * Created by jevonaverill on 9/3/17.
 */

open class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
        appComponent = buildComponent()
    }

    protected open fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(API_URL))
                .build()
    }

    companion object {

        protected val API_URL = "http://go.udacity.com/"

        fun get(context: Context): App {
            return context.applicationContext as App
        }

    }

}