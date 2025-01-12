package com.karrar.movieapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.karrar.movieapp.R
import com.karrar.movieapp.databinding.FragmentHomeBinding
import com.karrar.movieapp.domain.enums.HomeItemsType
import com.karrar.movieapp.ui.base.BaseFragment
import com.karrar.movieapp.ui.home.adapter.HomeAdapter
import com.karrar.movieapp.utilities.observeEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setAdapter()
        observeEvents()
    }

    private fun setAdapter(){
        val homeAdapter = HomeAdapter(mutableListOf(
            HomeRecyclerItem.Slider(emptyList()),
            HomeRecyclerItem.TvShows(emptyList()),
            HomeRecyclerItem.OnTheAiring(emptyList(),HomeItemsType.ON_THE_AIR),
            HomeRecyclerItem.Trending(emptyList(),HomeItemsType.TRENDING),
            HomeRecyclerItem.AiringToday(emptyList()),
            HomeRecyclerItem.NowStreaming(emptyList(),HomeItemsType.NOW_STREAMING),
            HomeRecyclerItem.Upcoming(emptyList(),HomeItemsType.UPCOMING),
            HomeRecyclerItem.Mystery(emptyList(),HomeItemsType.MYSTERY),
            HomeRecyclerItem.Adventure(emptyList(),HomeItemsType.ADVENTURE),
            HomeRecyclerItem.Actor(emptyList()),
        ), viewModel)
        binding.recyclerView.adapter = homeAdapter
    }

    private fun observeEvents() {
        viewModel.clickSeeAllActorEvent.observeEvent(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_homeFragment_to_actorsFragment)
        }

        viewModel.clickActorEvent.observeEvent(viewLifecycleOwner) {actorID ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToActorDetailsFragment(actorID))
        }

        viewModel.clickMovieEvent.observeEvent(viewLifecycleOwner) {movieID ->
            navigateToMovieDetails(movieID)
        }

        viewModel.clickSeriesEvent.observeEvent(viewLifecycleOwner) {seriesID ->
            navigateToTvShowDetails(seriesID)
        }

        viewModel.clickSeeAllMovieEvent.observeEvent(viewLifecycleOwner) {typeMovieID ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAllMovieFragment(-1, typeMovieID))
        }

        viewModel.clickSeeAllTVShowsEvent.observeEvent(viewLifecycleOwner) {typeTVShow ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAllMovieFragment(-1,typeTVShow))
        }
    }

    private fun navigateToMovieDetails(movieID: Int) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieID))
    }

    private fun navigateToTvShowDetails(tvShowId: Int) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTvShowDetailsFragment(tvShowId))
    }

}