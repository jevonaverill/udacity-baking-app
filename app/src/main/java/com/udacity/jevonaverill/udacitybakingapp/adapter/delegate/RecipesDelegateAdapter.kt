package com.udacity.jevonaverill.udacitybakingapp.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.udacity.jevonaverill.udacitybakingapp.R
import com.udacity.jevonaverill.udacitybakingapp.extension.inflate
import com.udacity.jevonaverill.udacitybakingapp.image.GlideApp
import com.udacity.jevonaverill.udacitybakingapp.image.model.VideoThumbnailUrl
import com.udacity.jevonaverill.udacitybakingapp.model.Recipe
import kotlinx.android.synthetic.main.card_baking_recipe.view.*

/**
 * Created by jevonaverill on 9/5/17.
 */
class RecipesDelegateAdapter(val onRecipeClicked: (recipe: Recipe) -> Unit)
    : DelegateAdapter<Recipe, RecipesDelegateAdapter.RecipeViewHolder>() {

    override fun isForViewType(item: Any): Boolean {
        return item is Recipe
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, item: Recipe) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecipeViewHolder {
        return RecipeViewHolder(parent)
    }

    inner class RecipeViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.card_baking_recipe)) {

        fun bind(recipe: Recipe) {
            itemView.run {
                setOnClickListener {
                    onRecipeClicked(recipe)
                }
                recipe_title.text = recipe.name
                recipe_servings.text = recipe.servings.toString()

                if (recipe.image.isNotBlank()) {
                    GlideApp.with(itemView).load(recipe.image).placeholder(R.drawable.recipe_placeholder).into(recipe_image)
                } else {
                    val lastStepWithVideo = recipe.steps.lastOrNull { s -> !s.videoURL.isNullOrBlank() }
                    lastStepWithVideo?.let { s ->
                        GlideApp.with(itemView).load(VideoThumbnailUrl(s.videoURL))
                                .placeholder(R.drawable.recipe_placeholder).into(recipe_image)
                    }
                }
            }
        }
    }

}