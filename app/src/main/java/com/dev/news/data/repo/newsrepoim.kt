package com.dev.news.data.repo

import android.widget.Toast
import com.dev.news.data.model.Article
import com.dev.news.data.remote.Newsapi
import com.dev.news.domain.repo.newsrepo.Newsrepo
import com.dev.news.util.resource.Resource

class NewsRepoImpl(
    private val newsapi: Newsapi
) : Newsrepo {
    override suspend fun getTopheadlines(category: String): Resource<List<Article>> {
        return try {
            val response = newsapi.getTopHeadlines(category = category)
            Resource.Success(response.articles)

        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message }")
        }
    }
}