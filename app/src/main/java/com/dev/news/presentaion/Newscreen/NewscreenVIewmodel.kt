package com.dev.news.presentaion.Newscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.news.data.model.Article
import com.dev.news.data.remote.Newsapi
import com.dev.news.domain.repo.newsrepo.Newsrepo
import com.dev.news.util.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewScreenViewmodel @Inject constructor(
    private val newsrepo: Newsrepo
) : ViewModel(){
    var articles by mutableStateOf<List<Article>>(emptyList())
    init {
        getNewsArticles("sports")
    }

    private fun getNewsArticles(category : String){
        viewModelScope.launch {
          try {
              val  result = newsrepo.getTopheadlines(category)
              println("viewmodel launched")

              when(result){
                  is Resource.Success -> {
                      articles = result.data ?: emptyList()
                      //println(articles)
                  }
                  is Resource.Error -> {
                      println("g")
                      println(result.message)
                  }
              }
          }catch (e:Exception) {
              println(e.localizedMessage)
          }
        }
    }


}
