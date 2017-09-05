package com.udacity.jevonaverill.udacitybakingapp.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by jevonaverill on 9/3/17.
 */
@PaperParcel
data class Ingredient(val quantity: String, val measure: String, val ingredient: String) :
        PaperParcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelIngredient.CREATOR
    }

}