package com.example.simplelayouts

import android.graphics.Color
import android.os.Bundle
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

        // Adding TextViews to the LinearLayout
        //addTextView("Welcome")

    }

//    private fun addTextView(label: String) {
//        // Create a new TextView
//        val view = TextView(this)
//        view.text = label
//        view.textSize = 35f
//        view.setTextColor(Color.parseColor("#ff0000"))
//        val linearLayout = findViewById<LinearLayout>(R.id.linearlayout)
//        linearLayout.addView(view)
//    }
}