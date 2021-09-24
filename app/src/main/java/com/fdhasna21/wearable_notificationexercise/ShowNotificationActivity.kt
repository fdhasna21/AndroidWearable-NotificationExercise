package com.fdhasna21.wearable_notificationexercise

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.fdhasna21.wearable_notificationexercise.databinding.ActivityShowNotificationBinding

    class ShowNotificationActivity : Activity() {
    private lateinit var binding : ActivityShowNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val message = intent.getStringExtra("message")
        val data = intent.getParcelableExtra<NotificationData>("data")

        binding.apply {
            showTitle.text = "Title   : \n$title"
            showMessage.text = "Message : \n$message"
            when(data?.activityReceiver){
                "ShowAnimalActivity" -> {
                    showContent.text = "Animal : ${data.dataAnimal?.name}"
                }
                "ShowShapeActivity" -> {
                    val width : Float = data.dataShape?.width!!.toFloat()
                    val length : Float = data.dataShape?.length!!.toFloat()
                    showContent.text  = "Length  : ${length}\n" +
                                        "Width   : ${width}\n" +
                                        "Area    : ${length*width}"
                }
                else -> {
                    showContent.visibility = View.GONE
                }
            }
        }
    }
}