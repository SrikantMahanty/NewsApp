package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="https://newsapi.org/"
const val API_KEY="4de7598dbc4f450689f96c66d69f339a"
interface NewsApi {
    @GET("/v2/top-headlines?apikey=$API_KEY")
    fun getHeadLines(@Query("country")country:String,@Query("page")page:Int): Call<News>
}
object NewsService{
    val newsInstance:NewsApi
    init {
        val retrofit: Retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance=retrofit.create(NewsApi::class.java)

        //https://www.googleapis.com/youtube/v3/videos
    }
}