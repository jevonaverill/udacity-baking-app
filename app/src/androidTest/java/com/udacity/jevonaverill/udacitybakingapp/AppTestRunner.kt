package com.udacity.jevonaverill.udacitybakingapp

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

/**
 * Created by jevonaverill on 9/5/17.
 */
class AppTestRunner : AndroidJUnitRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, AppTest::class.java.canonicalName, context)
    }

}