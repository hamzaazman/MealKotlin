package com.example.mealkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mealkotlin.R
import com.example.mealkotlin.databinding.FragmentDetailBinding
import com.example.mealkotlin.models.Ingredient
import com.example.mealkotlin.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var mealId: Int = 0
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mealId = args.mealId
        mainViewModel.getIngredientByMealId(mealId)
        mainViewModel.mealIngredient.observe(viewLifecycleOwner) {
            bind(it)
        }

    }

    private fun bind(ingredient: Ingredient) {
        val detail = ingredient.mealDetails[0]
        binding.detailImageView.apply {
            Picasso.get()
                .load(detail.mealImageUrl)
                .placeholder(R.drawable.placeholder_image)
                .into(this)
        }
        binding.detailTitleTextView.text = detail.mealName
        binding.detailDescriptionTextView.text = detail.instructionsName

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}