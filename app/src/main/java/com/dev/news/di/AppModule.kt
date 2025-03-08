package com.dev.news.di

import com.dev.news.data.remote.Newsapi
import com.dev.news.data.remote.Newsapi.Companion.BASE_URL
import com.dev.news.data.repo.NewsRepoImpl
import com.dev.news.domain.repo.newsrepo.Newsrepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi() : Newsapi{
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Newsapi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepo(newsapi: Newsapi): Newsrepo{
        return  NewsRepoImpl(newsapi)

    }


}