package com.bintang.submissionandroidintermediate.domain.repos

import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun logIn(email: String, password: String)
    fun register(name: String, email: String, password: String)
    fun isLoggedIn(): Flow<Boolean>
    fun logOut()
}