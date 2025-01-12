package com.karrar.movieapp.ui.explore

import com.karrar.movieapp.R
import com.karrar.movieapp.domain.models.Media
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener

class TrendAdapter(items: List<Media>, listener: TrendInteractionListener)
    : BaseAdapter<Media>(items, listener){
    override val layoutID: Int = R.layout.item_trend
}

interface TrendInteractionListener : BaseInteractionListener {
    fun onClickTrend(trendID: Int, trendType: String)
}