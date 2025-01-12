package com.karrar.movieapp.ui.tvShowDetails

import com.karrar.movieapp.R
import com.karrar.movieapp.domain.models.Season
import com.karrar.movieapp.ui.base.BaseAdapter
import com.karrar.movieapp.ui.base.BaseInteractionListener

class SeasonAdapter(
    items: List<Season>, listener: SeasonInteractionListener
) : BaseAdapter<Season>(items, listener) {
    override val layoutID: Int = R.layout.item_season
}

interface SeasonInteractionListener : BaseInteractionListener {
    fun onClickSeason(seasonNumber: Int)
}