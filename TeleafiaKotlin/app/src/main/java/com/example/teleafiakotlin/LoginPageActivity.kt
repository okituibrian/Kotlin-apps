package com.example.teleafiakotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.teleafiakotlin.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private var loginButton: Button? = null
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initialize views
        loginButton = findViewById(R.id.Login)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        loginButton?.setOnClickListener {
            Log.d("LoginActivity", "Login button pressed")
            println("Login button pressed")
            val email = emailEditText?.text.toString().trim()
            val password = passwordEditText?.text.toString().trim()

            Log.d("LoginActivity", "Email: $email")
            Log.d("LoginActivity", "Password: $password")

            postToLogin(email, password)
        }
    }

    private fun postToLogin(email: String, password: String) {
        try {
            val apiService = RetrofitClient.apiService
            val call = apiService.login(email, password)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        Log.d("LoginActivity", "Login successful: ${responseBody?.toString()}")

                        if (responseBody != null) {
                            Log.d("LoginActivity", "Received token: ${responseBody.token}")
                            Log.d("LoginActivity", "User info: ${responseBody.user}")
                            println(responseBody.user)

                            // Navigate to PharmacyActivity
                            val intent = Intent(this@LoginActivity, PharmacyActivity::class.java)
                            startActivity(intent)
                            finish() // Optional: Call finish() if you want to close the LoginActivity
                        }
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.d("LoginActivity", "Login failed: $errorBody")
                        println(errorBody)
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("LoginActivity", "Login error: ${t.message}", t)
                    println(t.message)
                }
            })
        } catch (e: Exception) {
            Log.e("LoginActivity", "Error during login process", e)
        }
    }
}
