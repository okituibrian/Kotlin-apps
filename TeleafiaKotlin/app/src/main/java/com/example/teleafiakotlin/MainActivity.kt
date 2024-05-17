package com.example.teleafiakotlin
import android.annotation.SuppressLint
import android.widget.ProgressBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val Splash_delay: Long = 3000

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = findViewById<ProgressBar>(R.id.spinner)
        progressBar.isIndeterminate = true


        Handler().postDelayed({
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        },
        Splash_delay)
    }
}
