package com.bintang.submissionandroidintermediate.data

import com.bintang.submissionandroidintermediate.domain.repos.AuthenticationRepository
import kotlinx.coroutines.flow.Flow

class AuthenticationRepositoryImpl : AuthenticationRepository {
    override fun logIn(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun register(name: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun isLoggedIn() : Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }
}