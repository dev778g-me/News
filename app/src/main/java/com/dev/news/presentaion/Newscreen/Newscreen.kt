package com.dev.news.presentaion.Newscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dev.news.presentaion.Components.CategoryTabRow
import com.dev.news.presentaion.Components.NewsTopAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    newScreenViewmodel : NewScreenViewmodel = hiltViewModel(),) {
    val articles = newScreenViewmodel.articles
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val courotinescope = rememberCoroutineScope()
    val categories = listOf(
        "General", "Business", "Health", "Sport" , "Science" , "Technology" , "Entertainment"
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = {categories.size}
    )
    Scaffold(
        topBar = { NewsTopAppBar(onSearch = {}, scrollBehavior = scrollBehavior) },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            CategoryTabRow(
                pagerState = pagerState,
                category = categories,
                onTap = {
                    index->
                    courotinescope.launch { pagerState.animateScrollToPage(index) }
                }
            )
            HorizontalPager(

                state = pagerState,

            ) { LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)

            ) {
                items(newScreenViewmodel.articles) { newsart ->
                    Card(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        ListItem(
                            tonalElevation = 5.dp,
                            overlineContent = {
                                Row (
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ){
                                    Text(text = newsart.author ?: "Unknown Author")
                                    Text(text = newsart.source?.name ?: "no data")
                                }
                            },
                            leadingContent = {
                                GlideImage(
                                    modifier = Modifier.size(50.dp),
                                    model = newsart.urlToImage,
                                    contentDescription = null
                                )
                            },
                            headlineContent = {
                                Text(text = newsart.title ?: "null title", maxLines = 2)
                            }
                            , supportingContent = {
                                Text(text = newsart.description ?: "null desc", maxLines = 3)
                            }
                        )
                    }
                }
            } }

        }
    }

}


