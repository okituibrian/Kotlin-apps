package com.example.teleafiakotlin
import android.annotation.SuppressLint
import android.widget.ProgressBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Handler


class MainActivity : AppCompatActivity() {
    private val Splash_delay: Long = 1000

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Handler().postDelayed({
            val intent = Intent(this, MenuActivity ::class.java)
            startActivity(intent)
            finish()
        },
        Splash_delay)
    }
}
