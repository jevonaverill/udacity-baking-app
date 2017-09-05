package com.udacity.jevonaverill.udacitybakingapp.adapter

import com.udacity.jevonaverill.udacitybakingapp.adapter.delegate.DelegatingAdapter
import com.udacity.jevonaverill.udacitybakingapp.adapter.delegate.RecipesDelegateAdapter
import com.udacity.jevonaverill.udacitybakingapp.model.Recipe

/**
 * Created by jevonaverill on 9/5/17.
 */
class RecipesAdapter(onRecipeClicked: (recipe: Recipe) -> Unit) : DelegatingAdapter(
        RecipesDelegateAdapter(onRecipeClicked)) {

    fun bind(recipes: List<Recipe>) {
        items = recipes
    }

}