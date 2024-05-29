package com.example.teleafiakotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.teleafiakotlin.models.LoginResponse
import retrofit2.Call

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

        // Set click listener for the login button
        loginButton?.setOnClickListener {
            // Log the button press action
            Log.d("LoginActivity", "Login button pressed")

            // Get the email and password entered by the user
            val email = emailEditText?.text.toString().trim()
            val password = passwordEditText?.text.toString().trim()

            // Log the entered email and password
            Log.d("LoginActivity", "Email: $email")
            Log.d("LoginActivity", "Password: $password")

            // Call the login function
            postToLogin(email, password)
        }
    }

    private fun postToLogin(email: String, password: String) {
        val apiService = RetrofitClient.apiService
        val call = apiService.login(email, password)

        call.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: retrofit2.Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    // Log the successful response
                    Log.d("LoginActivity", "Login successful: ${responseBody?.toString()}")
                    // Handle successful response
                    if (responseBody != null) {
                        // Process the response body
                        Log.d("LoginActivity", "Received token: ${responseBody.token}")
                        Log.d("LoginActivity", "User info: ${responseBody.user}")
                    }
                } else {
                    // Log the unsuccessful response
                    Log.d("LoginActivity", "Login failed: ${response.errorBody()?.string()}")
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Log the network error
                Log.d("LoginActivity", "Login error: ${t.message}")
                // Handle network errors
            }
        })
    }
}
