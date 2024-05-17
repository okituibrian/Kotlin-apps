package com.example.teleafiakotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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
        loginButton?.setOnClickListener(View.OnClickListener {
            // Get the email and password entered by the user
            val email = emailEditText?.text.toString().trim()
            val password = passwordEditText?.text.toString().trim()

            // You can perform validation here before sending the data to the backend

            // Call a method to post the data to your backend
            postDataToBackend(email, password)
        })
    }

    private fun postDataToBackend(email: String, password: String) {
        val apiService = RetrofitClient.apiService

        val call = apiService.login(email, password)
        call.enqueue(object : retrofit2.Callback<YourResponseModel> {

            override fun onResponse(
                call: Call<YourResponseModel>,
                response: retrofit2.Response<YourResponseModel>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    // Handle successful response
                    // For example, you can extract data from responseBody and process it
                    if (responseBody != null) {
                        // Process the response body
                    }
                } else {
                    // Handle unsuccessful response
                    // For example, display an error message to the user
                }
            }

            override fun onFailure(call: Call<YourResponseModel>, t: Throwable) {
                // Handle network errors
                // For example, display an error message to the user
            }
        })
    }

}
