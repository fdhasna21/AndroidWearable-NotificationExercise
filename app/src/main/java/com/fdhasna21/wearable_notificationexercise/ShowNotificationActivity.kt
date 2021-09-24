package com.fdhasna21.wearable_notificationexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fdhasna21.wearable_notificationexercise.databinding.ActivityShowNotificationBinding

class ShowNotificationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShowNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val message = intent.getStringExtra("message")
        val data = intent.getParcelableExtra<NotificationData>("data")

        binding.apply {
            showTitle.text = "Title : $title"
            showMessage.text = "Message : $message"
            showContent.text = "Content : $data"
        }
    }
}