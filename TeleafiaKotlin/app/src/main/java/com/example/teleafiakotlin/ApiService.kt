package com.example.teleafiakotlin

import com.example.teleafiakotlin.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body loginRequest: String, password: String): Call<LoginResponse>
}
