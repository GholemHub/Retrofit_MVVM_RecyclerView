package com.example.a2api_segeda.api

import com.example.a2api_segeda.util.Constants.Companion.GITUSER_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(GITUSER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GitUsersAPI by lazy {
        retrofit.create(GitUsersAPI::class.java)
    }
}