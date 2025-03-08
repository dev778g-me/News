package com.dev.news.domain.repo.newsrepo

import com.dev.news.data.model.Article
import com.dev.news.util.resource.Resource

interface Newsrepo {

    suspend fun getTopheadlines(
        category: String
    ):Resource<List<Article>>
}