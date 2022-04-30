package com.bintang.submissionandroidintermediate.ui.state_holders

data class StoriesUiState(
    val isSignedIn: Boolean,
    val storyItem: List<StoriesItemUiState> = listOf(),
)
