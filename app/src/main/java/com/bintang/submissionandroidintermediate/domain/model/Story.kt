package com.bintang.submissionandroidintermediate.domain.model

data class Story(
    val imageUrl: String,
    val author: User,
    val dateCreated: String,
    val description: String
)
