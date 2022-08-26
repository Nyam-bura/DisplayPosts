package com.jane.mypost

import android.security.identity.AccessControlProfileId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")

    fun getPost():Call<List<Posts>>

    @GET("/posts/{postId}")
    fun getpostsById(@Path("postId") postId: Int):Call<Posts>


    @GET("/comments")
    fun getCommentsId():Call<List<Comment>>







}