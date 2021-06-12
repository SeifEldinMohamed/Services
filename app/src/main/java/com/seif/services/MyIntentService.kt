package com.seif.services

import android.app.IntentService
import android.content.Intent
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {
    private val TAG = "IntentService"
    override fun onHandleIntent(intet: Intent?) {
        when (intet!!.extras!!.get("type")) {
            TYPEONE -> {
                for (i in 1..5) {
                    Log.d(TAG, "the First service is doing something $i")
                    Thread.sleep(1000)
                }
            }
            TYPETWO -> {
                for (i in 1..5) {
                    Log.d(TAG, "the Second service is doing something $i")
                    Thread.sleep(1000)
                }
            }
        }
    }
}
/*
This class was deprecated in API level 30.
IntentService is subject to all the background execution limits imposed with Android 8.0 (API level 26).
Consider using WorkManager or JobIntentService, which uses jobs instead of services when
running on Android 8.0 or higher.*/