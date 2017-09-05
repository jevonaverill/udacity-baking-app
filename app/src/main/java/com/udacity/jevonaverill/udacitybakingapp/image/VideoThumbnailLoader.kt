package com.udacity.jevonaverill.udacitybakingapp.image

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.signature.ObjectKey
import com.udacity.jevonaverill.udacitybakingapp.image.model.VideoThumbnailUrl
import java.io.InputStream

/**
 * Created by jevonaverill on 9/3/17.
 */
class VideoThumbnailLoader : ModelLoader<VideoThumbnailUrl, InputStream> {

    override fun handles(url: VideoThumbnailUrl): Boolean = true

    override fun buildLoadData(videoThumbnailUrl: VideoThumbnailUrl, width: Int, height: Int,
                               options: Options?): ModelLoader.LoadData<InputStream> {
        return ModelLoader.LoadData(ObjectKey(videoThumbnailUrl),
                VideoThumbnailFetcher(videoThumbnailUrl))
    }

}