package com.dev.news.presentaion.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTabRow(
    pagerState: PagerState,
    category: List<String>,
    onTap : (Int) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
         edgePadding = 0.dp
    ) {
 category.forEachIndexed {
     index, category ->
     Tab(
         modifier = Modifier.padding(8.dp),
         selected = pagerState.currentPage == index,
         onClick = { onTap(index) },
         content = {
             Text(text = category)
         }
     )
 }

    }

}