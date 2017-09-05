package com.udacity.jevonaverill.udacitybakingapp.dagger

import com.udacity.jevonaverill.udacitybakingapp.MainActivityFragment
import com.udacity.jevonaverill.udacitybakingapp.RecipeDetailActivity
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.ApiModule
import com.udacity.jevonaverill.udacitybakingapp.dagger.module.AppModule
import com.udacity.jevonaverill.udacitybakingapp.image.GlideConfiguration
import com.udacity.jevonaverill.udacitybakingapp.manager.RecipeInfoWidgetManager
import com.udacity.jevonaverill.udacitybakingapp.service.RecipeInfoWidgetRemoteViewService
import com.udacity.jevonaverill.udacitybakingapp.widget.RecipeInfoWidget
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jevonaverill on 9/3/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {

    fun inject(mainActivityFragment: MainActivityFragment)
    fun inject(glideConfiguration: GlideConfiguration)
    fun inject(recipeInfoWidgetManager: RecipeInfoWidgetManager)
    fun inject(recipeInfoWidgetRemoteViewService: RecipeInfoWidgetRemoteViewService)
    fun inject(recipeInfoWidget: RecipeInfoWidget)
    fun inject(recipeDetailActivity: RecipeDetailActivity)

}