package com.example.mealkotlin.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.mealkotlin.R
import com.squareup.picasso.Picasso

object MealRowBinding {

    @BindingAdapter("loadMealImageView")
    @JvmStatic
    fun loadMealImageView(imageView: ImageView, mealImageUrl: String) {
        Picasso.get()
            .load(mealImageUrl)
            .placeholder(R.drawable.placeholder_image)
            .into(imageView)
    }
}