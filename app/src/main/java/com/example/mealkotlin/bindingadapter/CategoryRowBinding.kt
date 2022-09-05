package com.example.mealkotlin.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class CategoryRowBinding {

    companion object {

        @BindingAdapter("loadCategoryImageView")
        @JvmStatic
        fun loadCategoryImageView(imageView: ImageView, imageUrl: String) {
            Glide
                .with(imageView.context)
                .load(imageUrl)
                .into(imageView)
        }

    }
}