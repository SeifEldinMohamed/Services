package com.seif.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val TAG = "My Service"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showLog("on Start Command called")

        val runnable = Runnable {
            for (i in 0..10){
                showLog("Service is doing something: $i")
                Thread.sleep(1000)
            }
            // to end the service
            stopSelf()
        }
        val thread = Thread(runnable)
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        showLog("on Destroy called")
        super.onDestroy()
    }

    override fun onCreate() {
        showLog("on create called")
        super.onCreate()
    }

    private fun showLog(message: String){
        Log.d(TAG, message)
    }
    
}