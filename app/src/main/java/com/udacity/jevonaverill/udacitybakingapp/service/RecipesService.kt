package com.udacity.jevonaverill.udacitybakingapp.service

import com.udacity.jevonaverill.udacitybakingapp.model.Recipe
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by jevonaverill on 9/3/17.
 */
interface RecipesService {

    @GET("android-baking-app-json")
    fun recipes(): Call<List<Recipe>>

}