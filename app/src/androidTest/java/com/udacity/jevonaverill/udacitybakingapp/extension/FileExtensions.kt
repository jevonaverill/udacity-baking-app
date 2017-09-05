package com.udacity.jevonaverill.udacitybakingapp.extension

import android.content.Context

/**
 * Created by jevonaverill on 9/5/17.
 */
fun Context.getStringFromFile(filePath: String): String {
    return resources.assets.open(filePath)?.use {
        it.bufferedReader().use { it.readText() }
    } ?: throw NullPointerException("Unable to read text from $filePath")
}
