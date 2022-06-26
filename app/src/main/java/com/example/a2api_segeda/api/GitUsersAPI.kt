package com.example.a2api_segeda.api

import com.example.a2api_segeda.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitUsersAPI {
    /*@GET("users")
    suspend fun getPost(): Post
*/

    @GET("users")
    suspend fun getPost(

    ): Response<List<Post>>

}