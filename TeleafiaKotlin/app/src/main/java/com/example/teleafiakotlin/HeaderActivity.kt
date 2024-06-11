package com.example.teleafiakotlin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.teleafiakotlin.R

class HeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val backImageView: ImageView
    private val logoImageView: ImageView
    private val notificationImageView: ImageView
    private val headingTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.activity_header, this, true)
        backImageView = findViewById(R.id.ivBack)
        logoImageView = findViewById(R.id.ivLogo)
        notificationImageView = findViewById(R.id.ivNotification)
        headingTextView = findViewById(R.id.tvHeading)
    }

    fun setHeading(text: String) {
        headingTextView.text = text
    }

    fun setOnBackClickListener(listener: OnClickListener) {
        backImageView.setOnClickListener(listener)
    }

    fun setOnNotificationClickListener(listener: OnClickListener) {
        notificationImageView.setOnClickListener(listener)
    }
}
