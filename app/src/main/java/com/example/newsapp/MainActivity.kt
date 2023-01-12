package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  MobileAds.initialize(this)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("AndroidSrk", news.toString())
                    adapter= NewsAdapter(this@MainActivity,news.articles)
                    recyclerView.adapter=adapter
                    recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
                }


            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("AndroidSrk", "Error in Fetching videos", t)


            }
        })


    }
}