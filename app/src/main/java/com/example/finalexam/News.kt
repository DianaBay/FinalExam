package com.example.finalexam

import com.google.gson.annotations.SerializedName


data class News {
    @SerializedName("category")
    val category: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String
}