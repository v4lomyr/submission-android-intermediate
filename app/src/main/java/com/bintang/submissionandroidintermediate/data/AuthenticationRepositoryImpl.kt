package com.bintang.submissionandroidintermediate.data

import com.bintang.submissionandroidintermediate.data.api_call_response.LoginResponse
import com.bintang.submissionandroidintermediate.data.retrofit.ApiConfig
import com.bintang.submissionandroidintermediate.domain.model.User
import com.bintang.submissionandroidintermediate.domain.repos.AuthenticationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationRepositoryImpl(private val authPreferences: AuthenticationPreferences) : AuthenticationRepository {

    val scope = CoroutineScope(IO)

    override fun logIn(email: String, password: String): User {
        val client = ApiConfig.getApiService().login(email = email, password = password)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null){
                        scope.launch(Dispatchers.IO) {
                            authPreferences.saveUserData(responseBody.loginResult)
                        }
                    }
                    message = "login success"
                    isBusy = false
                } else {
                    message = "error: Akun tidak di temukan, silahkan coba lagi"
                    isBusy = false
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                message = "error : Terjadi kesalaha, silahkan coba lagi nanti"
                isBusy = false
            }
        })
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