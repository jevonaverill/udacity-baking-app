package com.udacity.jevonaverill.udacitybakingapp.service

import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.udacity.jevonaverill.udacitybakingapp.App
import com.udacity.jevonaverill.udacitybakingapp.R
import com.udacity.jevonaverill.udacitybakingapp.manager.RecipeInfoWidgetManager
import com.udacity.jevonaverill.udacitybakingapp.model.Recipe
import javax.inject.Inject

/**
 * Created by jevonaverill on 9/3/17.
 */
class RecipeInfoWidgetRemoteViewService : RemoteViewsService() {

    @Inject
    lateinit var recipeInfoWidgetManager: RecipeInfoWidgetManager

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return object : RemoteViewsFactory {
            private var recipe: Recipe? = null

            override fun onCreate() {
                App.get(applicationContext).appComponent.inject(
                        this@RecipeInfoWidgetRemoteViewService)
            }

            override fun onDataSetChanged() {
                recipe = recipeInfoWidgetManager.getRecipe()
            }

            override fun onDestroy() {
            }

            override fun getCount(): Int {
                return recipe?.ingredients?.size ?: 0
            }

            override fun getViewAt(position: Int): RemoteViews? {
                val views = RemoteViews(packageName, R.layout.card_widget_recipe_ingredient)

                val ingredient = recipe?.ingredients?.get(position)

                return ingredient?.let {
                    views.apply {
                        setTextViewText(R.id.recipe_ingredient_name, ingredient.ingredient)
                        setTextViewText(R.id.recipe_ingredient_quantity, getString(R.string
                                .ingredient_quantity_text, ingredient.quantity, ingredient.measure))
                    }
                }
            }

            override fun getLoadingView(): RemoteViews? {
                return null
            }

            override fun getViewTypeCount(): Int {
                return 1
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun hasStableIds(): Boolean {
                return false
            }
        }
    }

}