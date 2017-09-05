package com.udacity.jevonaverill.udacitybakingapp.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.udacity.jevonaverill.udacitybakingapp.R
import com.udacity.jevonaverill.udacitybakingapp.extension.inflate
import com.udacity.jevonaverill.udacitybakingapp.model.Ingredient
import kotlinx.android.synthetic.main.card_baking_recipe_ingredient.view.*

/**
 * Created by jevonaverill on 9/5/17.
 */
class RecipeIngredientDelegateAdapter : DelegateAdapter<Ingredient,
        RecipeIngredientDelegateAdapter.RecipeIngredientViewHolder>() {

    override fun isForViewType(item: Any): Boolean {
        return item is Ingredient
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecipeIngredientViewHolder {
        return RecipeIngredientViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecipeIngredientViewHolder, item: Ingredient) {
        holder.bind(item)
    }

    inner class RecipeIngredientViewHolder(parent: ViewGroup)
        : RecyclerView.ViewHolder(parent.inflate(R.layout.card_baking_recipe_ingredient)) {

        fun bind(item: Ingredient) = itemView.run {
            recipe_ingredient_name.text = item.ingredient
            recipe_ingredient_quantity.text = context.getString(R.string.ingredient_quantity_text,
                    item.quantity, item.measure)
        }
    }

}