package com.example.mealkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealkotlin.R
import com.example.mealkotlin.adapter.MealsAdapter
import com.example.mealkotlin.bindingadapter.MealRowBinding
import com.example.mealkotlin.databinding.FragmentMealsBinding
import com.example.mealkotlin.models.Category
import com.example.mealkotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class MealsFragment : Fragment() {
    private var _binding: FragmentMealsBinding? = null
    private val binding get() = _binding
    private val args: MealsFragmentArgs by navArgs()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var categoryName: String
    private val mealAdapter: MealsAdapter by lazy { MealsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealsBinding.inflate(layoutInflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        categoryName = args.categoryName

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getMealsByCategoryName(categoryName)
        setupRecyclerView()

        mainViewModel.mealsResult.observe(viewLifecycleOwner) { list ->
            mealAdapter.differ.submitList(list.meals)
        }

    }

    private fun setupRecyclerView() {
        binding!!.mealRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mealAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}