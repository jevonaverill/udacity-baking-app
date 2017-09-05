package com.udacity.jevonaverill.udacitybakingapp.image

import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.udacity.jevonaverill.udacitybakingapp.image.model.VideoThumbnailUrl
import java.io.InputStream

/**
 * Created by jevonaverill on 9/3/17.
 */
class VideoThumbnailFactory : ModelLoaderFactory<VideoThumbnailUrl, InputStream> {

    override fun build(modelLoaderFactory: MultiModelLoaderFactory):
            ModelLoader<VideoThumbnailUrl, InputStream> {
        return VideoThumbnailLoader()
    }

    override fun teardown() {
        TODO("not implemented") //To change body of created functions use File | Settings |
        // File Templates.
    }

}