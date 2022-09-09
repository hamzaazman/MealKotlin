package com.example.mealkotlin.bindingadapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.mealkotlin.R
import com.example.mealkotlin.ui.MealsFragmentDirections
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

    @BindingAdapter("mealCardClickListener")
    @JvmStatic
    fun mealCardClickListener(layout: CardView, mealId: Int) {
        layout.setOnClickListener {
            val action = MealsFragmentDirections.actionMealsFragmentToDetailFragment(mealId)
            layout.findNavController().navigate(action)
        }

    }
}