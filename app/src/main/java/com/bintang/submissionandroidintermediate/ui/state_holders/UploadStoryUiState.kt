package com.bintang.submissionandroidintermediate.ui.state_holders

import android.net.Uri

data class UploadStoryUiState(
    val description: String,
    val image: Uri,
    val isSuccess : Boolean,
)
