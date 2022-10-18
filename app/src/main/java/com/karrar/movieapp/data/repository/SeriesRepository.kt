package com.karrar.movieapp.data.repository

import com.karrar.movieapp.data.local.database.entity.WatchHistoryEntity
import com.karrar.movieapp.data.remote.response.movie.RatingDto
import com.karrar.movieapp.domain.models.*

interface SeriesRepository {

    suspend fun getTVShowsGenreList(): List<Genre>

    suspend fun getOnTheAir(page: Int = 1): List<Media>

    suspend fun getAiringToday(page: Int = 1): List<Media>

    suspend fun getTopRatedTvShow(page: Int = 1): List<Media>

    suspend fun getPopularTvShow(page: Int = 1): List<Media>

    suspend fun getTvShowsByGenreID(genreId: Int): List<Media>

    suspend fun getTvShowDetails(tvShowId: Int): TvShowDetails

    suspend fun getTvShowCast(tvShowId: Int): List<Actor>

    suspend fun getTvShowReviews(tvShowId: Int): List<Review>

    suspend fun setRating(tvShowId: Int, value: Float, sessionId: String): RatingDto

    suspend fun getRatedTvShow(accountId: Int, sessionId: String): List<RatedMovies>

    suspend fun getSeasonDetails(tvShowId: Int, seasonId: Int): Season

    suspend fun getTvShowTrailer(tvShowId: Int): Trailer

    suspend fun insertTvShow(tvShow: WatchHistoryEntity)

}