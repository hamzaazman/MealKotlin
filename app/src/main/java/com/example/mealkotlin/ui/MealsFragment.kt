package com.example.mealkotlin.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealkotlin.R
import com.example.mealkotlin.adapter.MealsAdapter
import com.example.mealkotlin.databinding.FragmentMealsBinding
import com.example.mealkotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsFragment : Fragment(), SearchView.OnQueryTextListener {
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
        setHasOptionsMenu(true)
        mainViewModel.mealsResult.observe(viewLifecycleOwner) { list ->
            mealAdapter.submitList(list.meals)
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.setOnQueryTextListener(this)
    }

    private fun searchFilterByMeals(searchText: String) {
        mainViewModel.getSearchByMeals(searchText)
        mainViewModel.searchByMeals.observe(viewLifecycleOwner) {
            mealAdapter.submitList(it.meals)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchFilterByMeals(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            searchFilterByMeals(newText)
        }
        return true
    }

    private fun setupRecyclerView() {
        binding!!.mealRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mealAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}