package com.bintang.submissionandroidintermediate.data.api_call_response

data class LoginResponse(
    val error: Boolean,
    val loginResult: LoginResult,
    val message: String
)