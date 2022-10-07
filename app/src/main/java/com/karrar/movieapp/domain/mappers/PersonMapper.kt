package com.karrar.movieapp.domain.mappers

import com.karrar.movieapp.data.remote.response.actor.ActorDto
import com.karrar.movieapp.domain.models.MediaInfo
import com.karrar.movieapp.utilities.Constants
import javax.inject.Inject

class PersonMapper @Inject constructor() : Mapper<ActorDto, MediaInfo>{
    override fun map(input: ActorDto): MediaInfo {
        return MediaInfo(
            id = input.id,
            name = input.name,
            profileImage = Constants.IMAGE_BASE_PATH + input.profilePath,
            type = null,
            releaseDate = null,
            rate = null,
            imagePath = null
        )
    }
}
