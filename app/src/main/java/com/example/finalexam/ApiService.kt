package com.example.finalexam

import retrofit2.Call
import retrofit2.http.*

class ApiService {
    @GET("category/")
    fun getNews(): Call<List<News>>

    @GET("category/{category}/")
    fun getNewsByCategory(@Path("category") todoId: Int): Call<News>

    @Headers("Cache-Control: max-age=640000", "User-Agent: My-App-Name")
    @GET("category/")
    fun getNewsByCategory(
        @Query("category") category: String,
        @Query("country") country: String
    ): Call<List<News>>


    @FormUrlEncoded
    @POST("category/")
    fun addTodo(
        @Field("category") category: String,
        @Field("country") country: String,

    ): Call<News>

    @GET
    fun getNewsWithUrl(@Url url: String): Call<List<News>>
}