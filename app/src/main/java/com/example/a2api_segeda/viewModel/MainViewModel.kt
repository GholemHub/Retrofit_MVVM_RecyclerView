package com.example.a2api_segeda.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a2api_segeda.model.Post
import com.example.a2api_segeda.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    //val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    /*fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponse.value = response
        }
    }*/

    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myPosts.value = response
        }
    }
}