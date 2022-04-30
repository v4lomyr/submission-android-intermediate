package com.bintang.submissionandroidintermediate.domain.repos

import com.bintang.submissionandroidintermediate.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    fun logIn(email: String, password: String) : User

    fun register(name: String, email: String, password: String)

    fun isLoggedIn(): Flow<Boolean>

    fun logOut()
}