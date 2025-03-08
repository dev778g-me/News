package com.dev.news.data.model

data class newsmodel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)