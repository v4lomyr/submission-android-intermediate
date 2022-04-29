package com.bintang.submissionandroidintermediate.data

import com.bintang.submissionandroidintermediate.domain.model.Story
import com.bintang.submissionandroidintermediate.domain.repos.StoryRepository
import kotlinx.coroutines.flow.Flow
import java.io.File

class StoryRepositoryImpl : StoryRepository {
    override fun getStoryList(): Flow<List<Story>> {
        TODO("Not yet implemented")
    }

    override fun uploadStory(imageFile: File, description: String) {
        TODO("Not yet implemented")
    }
}