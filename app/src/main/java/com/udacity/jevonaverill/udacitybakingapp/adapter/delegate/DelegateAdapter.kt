package com.udacity.jevonaverill.udacitybakingapp.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by jevonaverill on 9/5/17.
 */
abstract class DelegateAdapter<I, H : RecyclerView.ViewHolder> {

    abstract fun isForViewType(item: Any): Boolean

    abstract fun onCreateViewHolder(parent: ViewGroup): H

    abstract fun onBindViewHolder(holder: H, item: I)

    internal fun onBindViewHolderItem(holder: RecyclerView.ViewHolder, item: Any) {
        @Suppress("UNCHECKED_CAST")
        onBindViewHolder(holder as H, item as I)
    }

}
