package com.udacity.jevonaverill.udacitybakingapp.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.udacity.jevonaverill.udacitybakingapp.R
import com.udacity.jevonaverill.udacitybakingapp.extension.emptyToNull
import com.udacity.jevonaverill.udacitybakingapp.extension.inflate
import com.udacity.jevonaverill.udacitybakingapp.image.GlideApp
import com.udacity.jevonaverill.udacitybakingapp.image.model.VideoThumbnailUrl
import com.udacity.jevonaverill.udacitybakingapp.model.Step
import kotlinx.android.synthetic.main.card_baking_recipe_step.view.*

/**
 * Created by jevonaverill on 9/5/17.
 */
class RecipeStepsAdapter(private val onRecipeStepClicked: OnRecipeStepClicked)
    : DelegateAdapter<Step, RecipeStepsAdapter.RecipeStepsViewHolder>() {

    override fun isForViewType(item: Any): Boolean {
        return item is Step
    }

    override fun onBindViewHolder(holder: RecipeStepsViewHolder, item: Step) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecipeStepsViewHolder {
        return RecipeStepsViewHolder(parent)
    }

    inner class RecipeStepsViewHolder(parent: ViewGroup)
        : RecyclerView.ViewHolder(parent.inflate(R.layout.card_baking_recipe_step)) {
        fun bind(item: Step) = itemView.run {
            setOnClickListener {
                onRecipeStepClicked.onRecipeStepClicked(item)
            }
            recipe_step_title.text = item.shortDescription

            if (item.thumbnailURL.isNotBlank()) {
                GlideApp.with(itemView).load(item.thumbnailURL).placeholder(R.drawable
                        .recipe_placeholder).into(recipe_step_image)
            } else {
                item.videoURL.emptyToNull()?.let {
                    url ->
                    GlideApp.with(itemView).load(VideoThumbnailUrl(url))
                            .placeholder(R.drawable.recipe_placeholder).into(recipe_step_image)
                }
            }
        }
    }

    interface OnRecipeStepClicked {
        fun onRecipeStepClicked(step: Step)
    }

}