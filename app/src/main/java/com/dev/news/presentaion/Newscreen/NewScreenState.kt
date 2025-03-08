package com.dev.news.presentaion.Newscreen

import com.dev.news.data.model.Article

data class NewScreenState(
    val isLoading : Boolean = false,
    val articles : List<Article> = emptyList(),
    val error: String ? = null,
    val isSearchBarVisible : Boolean = false,
    val selectedArticle: Article ? = null,
    val category: String = "General",
    val searchQuery: String = ""

)
