package com.udacity.jevonaverill.udacitybakingapp.extension

/**
 * Created by jevonaverill on 9/5/17.
 */
fun String.emptyToNull(): String? {
    return if (this.isNullOrEmpty()) null else this
}