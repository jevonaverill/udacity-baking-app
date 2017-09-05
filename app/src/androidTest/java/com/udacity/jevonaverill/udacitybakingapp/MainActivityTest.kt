package com.udacity.jevonaverill.udacitybakingapp

import android.content.Intent
import android.support.annotation.IdRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.udacity.jevonaverill.udacitybakingapp.extension.getStringFromFile
import com.udacity.jevonaverill.udacitybakingapp.matcher.RecyclerViewMatcher
import com.udacity.jevonaverill.udacitybakingapp.matcher.ToolbarViewMatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by jevonaverill on 9/5/17.
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    private var server: MockWebServer? = null

    @Before
    fun setUp() {
        server = MockWebServer()
        server!!.start()

        (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as AppTest)
                .injectWithApiUrl(server!!.url("/").toString())
    }

    @Test
    fun mainActivityTest() {
        val recipesResponseBody = InstrumentationRegistry.getInstrumentation().context
                .getStringFromFile("recipes_200_ok_response.json")

        server!!.enqueue(MockResponse()
                .setResponseCode(200)
                .setBody(recipesResponseBody))

        activityTestRule.launchActivity(Intent())

        Espresso.onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0, R.id.recipe_title))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withText("Nutella Pie")))

        Espresso.onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0, R.id.recipe_servings))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withText("8")))

        Espresso.onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                .perform(ViewActions.click())

        ToolbarViewMatcher().matchToolbarTitle("Nutella Pie")
    }

    fun withRecyclerView(@IdRes recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @After
    fun tearDown() {
        server?.shutdown()
    }

}