package com.udacity.jevonaverill.udacitybakingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.udacity.jevonaverill.udacitybakingapp.model.Recipe
import com.udacity.jevonaverill.udacitybakingapp.model.Step
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by jevonaverill on 9/3/17.
 */

/**
 * An activity representing a single Recipe detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [RecipeDetailActivity].
 */
class RecipeStepActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baking_recipe_step)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val recipe = intent.getParcelableExtra<Recipe>(ARG_RECIPE) ?: throw IllegalArgumentException("Pass recipe")
            val step = intent.getParcelableExtra<Step>(ARG_RECIPE_STEP) ?: throw IllegalArgumentException("Pass recipe step")

            val fragment = RecipeStepsPagerFragment.instance(recipe, step)
            supportFragmentManager.beginTransaction()
                    .add(R.id.recipe_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    companion object {
        private const val ARG_RECIPE = "recipe"
        private const val ARG_RECIPE_STEP = "recipe_step"
    }

}