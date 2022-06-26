package com.example.a2api_segeda.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a2api_segeda.repository.Repository

class MainViewModelFactory(
    private val repositpry: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repositpry) as T
    }
}