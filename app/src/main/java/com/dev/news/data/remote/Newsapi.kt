package com.dev.news.data.remote

import com.dev.news.data.model.newsmodel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface Newsapi {

    companion object {
        const val API_KEY = "d18b6e2150354caca0e178a2f4ea8d48"
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    @Headers("User-Agent: MyNewsApp")
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY,
       // @Header("User-Agent") userAgent: String = "Mozilla/5.0"
    ): newsmodel
}
