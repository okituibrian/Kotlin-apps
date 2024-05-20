package com.example.simplelayouts

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val bookButton = findViewById<Button>(R.id.book)
        bookButton.setOnClickListener{
            val intent = Intent(this, DoctorPage::class.java)
            startActivity(intent.setAction("your.custom.action"))
        }

    }
// Adding TextViews to the LinearLayout
    //addTextView("Welcome")

//    private fun addTextView(label: String) {
//        // Create a new TextView
//        val view = TextView(this)
//        view.text = label
//        view.textSize = 35f
//        val linearLayout = findViewById<LinearLayout>(R.id.linearlayout)
//        linearLayout.addView(view)
//    }
}
