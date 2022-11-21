package com.example.mealkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealkotlin.databinding.MealRowBinding
import com.example.mealkotlin.models.Meal

//class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {
//    class MealViewHolder(private val binding: MealRowBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(meal: Meal) {
//            binding.result = meal
//            binding.executePendingBindings()
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
//        return MealViewHolder(
//            MealRowBinding.inflate(
//                LayoutInflater.from(parent.context), parent, false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
//        val currentMealList = differ.currentList[position]
//        holder.bind(currentMealList)
//    }
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//    private val diffUtilCallback = object : DiffUtil.ItemCallback<Meal>() {
//        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
//            return oldItem.idMeal == newItem.idMeal
//        }
//
//        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    val differ = AsyncListDiffer(this, diffUtilCallback)
//
//}

class MealsAdapter : ListAdapter<Meal, MealsAdapter.ImageViewHolder>(DrinkDiffUtil) {

    class ImageViewHolder private constructor(private val binding: MealRowBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(meal: Meal) {
            binding.result = meal
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup): ImageViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemBinding = MealRowBinding.inflate(layoutInflater, parent, false)
                return ImageViewHolder(itemBinding)
            }
        }
    }

    object DrinkDiffUtil : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean = oldItem.idMeal == newItem.idMeal
        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder.create(parent)

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val meal = getItem(position)
        holder.bind(meal = meal)
    }

    override fun getItemCount(): Int = currentList.size
}