package com.fdhasna21.wearable_notificationexercise

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fdhasna21.wearable_notificationexercise.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val TAG = "FirebaseMessaging"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(it.isSuccessful){
                val msg = "Token ${it.result}"
                Log.i(TAG, msg)
            } else {
                Log.i(TAG, "Fetching FCM registration token filed", it.exception)
            }

        }

        FirebaseMessaging.getInstance().subscribeToTopic("all").addOnCompleteListener {
            if(it.isSuccessful){
                Log.i(TAG, "Successfully send to all")
            } else {
                Log.i(TAG, "Subscription notification failed")
            }
        }
    }
}