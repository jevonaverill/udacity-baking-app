package com.udacity.jevonaverill.udacitybakingapp.adapter

import com.udacity.jevonaverill.udacitybakingapp.adapter.delegate.DelegatingAdapter
import com.udacity.jevonaverill.udacitybakingapp.adapter.delegate.RecipeIngredientDelegateAdapter
import com.udacity.jevonaverill.udacitybakingapp.adapter.delegate.RecipeStepsAdapter
import com.udacity.jevonaverill.udacitybakingapp.model.Ingredient
import com.udacity.jevonaverill.udacitybakingapp.model.Step

/**
 * Created by jevonaverill on 9/5/17.
 */
class RecipeListAdapter(onRecipeStepClicked: RecipeStepsAdapter.OnRecipeStepClicked) : DelegatingAdapter(
        RecipeStepsAdapter(onRecipeStepClicked),
        RecipeIngredientDelegateAdapter()) {

    fun bind(steps: List<Step>, ingredients: List<Ingredient>) {
        items = ingredients + steps
    }

}