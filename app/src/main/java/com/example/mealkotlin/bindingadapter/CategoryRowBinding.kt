package com.example.mealkotlin.bindingadapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.mealkotlin.R
import com.example.mealkotlin.ui.CategoriesFragmentDirections
import com.squareup.picasso.Picasso

object CategoryRowBinding {


    @BindingAdapter("loadCategoryImageView")
    @JvmStatic
    fun loadCategoryImageView(imageView: ImageView, imageUrl: String) {
        /*Glide
            .with(imageView.context)
            .load(imageUrl)
            .into(imageView)*/

        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.placeholder_image)
            .into(imageView)
    }

    @BindingAdapter("onClickCategoryListener")
    @JvmStatic
    fun onClickCategoryListener(categoryRowLayout: CardView, categoryName: String) {
        categoryRowLayout.setOnClickListener {
            val action =
                CategoriesFragmentDirections.actionCategoriesFragmentToMealsFragment(
                    categoryName
                )
            categoryRowLayout.findNavController().navigate(action)
        }
    }

}