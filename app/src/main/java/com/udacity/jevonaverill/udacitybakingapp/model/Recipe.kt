package com.udacity.jevonaverill.udacitybakingapp.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by jevonaverill on 9/3/17.
 */
@PaperParcel
data class Recipe (val id: Int, val name: String, val ingredients: List<Ingredient>,
                   val steps: List<Step>, val servings: Int, val image: String) :
        PaperParcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelRecipe.CREATOR;
    }

}