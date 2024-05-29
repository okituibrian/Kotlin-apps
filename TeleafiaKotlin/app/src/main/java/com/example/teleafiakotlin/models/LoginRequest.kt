package com.example.teleafiakotlin.models

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String, // assuming the response contains a token
    val user: User
)

data class User(
    val id: Int,
    val name: String,
    val email: String
)
