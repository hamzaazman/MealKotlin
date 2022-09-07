package com.example.mealkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mealkotlin.data.Repository
import com.example.mealkotlin.models.Categories
import com.example.mealkotlin.models.Meals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {

    var categoryResult: MutableLiveData<Categories> = MutableLiveData()
    var mealsResult: MutableLiveData<Meals> = MutableLiveData()

    fun getCategories() = viewModelScope.launch {
        try {
            val response = repository.remote.getCategories()
            if (response.isSuccessful) {
                categoryResult.value = response.body()
            }
        } catch (e: Exception) {
            Log.e("getCategories Error : ", e.message.toString())
        }
    }

    fun getMealsByCategoryName(categoryName: String) = viewModelScope.launch {
        try {
            val response = repository.remote.getMealsByCategoryName(categoryName)
            if (response.isSuccessful) {
                mealsResult.value = response.body()
            } else {
                Log.e("getMealViewModel: ", response.errorBody().toString())
            }
        } catch (e: Exception) {
            Log.e("getMealByCategoryName: ", e.message.toString())
        }
    }

}