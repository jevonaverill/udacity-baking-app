package com.udacity.jevonaverill.udacitybakingapp.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by jevonaverill on 9/3/17.
 */
@PaperParcel
data class Step (val id: Int, val shortDescription: String, val description: String, val videoURL: String,
                 val thumbnailURL: String) : PaperParcelable {

    companion object {
        @JvmField val CREATOR = PaperParcelStep.CREATOR;
    }

}