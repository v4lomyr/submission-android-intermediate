package com.bintang.submissionandroidintermediate.domain.repos

import com.bintang.submissionandroidintermediate.domain.model.Story
import kotlinx.coroutines.flow.Flow
import java.io.File

interface StoryRepository {
    fun getStoryList() : Flow<List<Story>>
    fun uploadStory(imageFile: File, description: String)
}