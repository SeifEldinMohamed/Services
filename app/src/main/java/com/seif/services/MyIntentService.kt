package com.seif.services

import android.app.IntentService
import android.content.Intent
import android.util.Log


class MyIntentService : IntentService("MyIntentService") {
    val TAG = "IntentService"
    override fun onHandleIntent(inte: Intent?) {
        for (i in 1..5) {
            Log.d(TAG, inte!!.extras!!.get("type").toString() + "the service is doing something $i")
            Thread.sleep(1000)
        }
    }
}