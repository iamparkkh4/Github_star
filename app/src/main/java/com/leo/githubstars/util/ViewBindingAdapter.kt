package com.leo.githubstars.util

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @BindingAdapter("toVisibleOrGone")
    @JvmStatic
    fun toVisibleOrGone(view: View, isVisible: Boolean) {
        view.visibility = when (isVisible) {
            true -> View.VISIBLE
            else -> View.GONE
        }

    }

    @BindingAdapter("toVisibleOrInvisible")
    @JvmStatic
    fun toVisibleOrInvisible(view: View, isVisible: Boolean) {
        view.visibility = when (isVisible) {
            true -> View.VISIBLE
            else -> View.INVISIBLE
        }

    }



}