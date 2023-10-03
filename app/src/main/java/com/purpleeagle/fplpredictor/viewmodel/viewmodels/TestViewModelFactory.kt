package com.purpleeagle.fplpredictor.viewmodel.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purpleeagle.fplpredictor.model.network.FplApiService

class TestViewModelFactory(private val api: FplApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TestViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return TestViewModel(api) as T
        }
        throw(IllegalArgumentException("View Model does not exist"))
    }
}