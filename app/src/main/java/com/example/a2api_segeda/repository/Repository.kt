package com.example.a2api_segeda.repository

import com.example.a2api_segeda.api.RetrofitInstance
import com.example.a2api_segeda.model.Post
import retrofit2.Response

class Repository {


    suspend fun getPost(): Response<List<Post>> {
        return RetrofitInstance.api.getPost()
    }
}