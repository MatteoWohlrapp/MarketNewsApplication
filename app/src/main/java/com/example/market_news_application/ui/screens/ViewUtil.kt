package com.example.market_news_application.ui.screens

import androidx.compose.foundation.lazy.LazyListState

object ViewUtil {


    fun isScrolledToEnd(scrollState: LazyListState): Boolean {
        val lastItem = scrollState.layoutInfo.visibleItemsInfo.lastOrNull()

        return lastItem != null && lastItem.size + lastItem.offset <= scrollState.layoutInfo.viewportEndOffset
    }
}