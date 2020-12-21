package com.example.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_countries.*
import kotlinx.android.synthetic.main.fragment_news.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    var list = mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://saurav.tech/NewsAPI/top-headlines/category/{category}/{country}.json")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        Picasso.get()
            .load("https://simg.nicepng.com/png/small/13-132275_zhs-news-and-events-news-icon-png-orange.png")
            .resize(300, 300)
            .rotate(90f)
            .into(imageNews)


        val countries = ArrayList<Country>()

        countries.add(Country("India"))
        countries.add(Country("USA"))
        countries.add(Country("Australia"))
        countries.add(Country("Russia"))
        countries.add(Country("France"))
        countries.add(Country("United Kingdom"))


        val countriesListAdapter = CountriesListAdapter(countries, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = countriesListAdapter

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, CountriesFragment()).commit()
    }
}