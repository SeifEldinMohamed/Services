package com.seif.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seif.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = Intent(this, MyService::class.java)
        binding.startService.setOnClickListener {
            startService(intent)
        }
       binding.endService.setOnClickListener {
           stopService(intent)
       }


    }
}


/*
Caution:
 To ensure that your app is secure, always use an explicit intent when starting a Service and
 don't declare intent filters for your services. Using an implicit intent to start a service is a
 security hazard because you cannot be certain of the service that responds to the intent, and
 the user cannot see which service starts. Beginning with Android 5.0 (API level 21),
 the system throws an exception if you call bindService() with an implicit intent.
 */