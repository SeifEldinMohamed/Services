package com.seif.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seif.services.Constants.Companion.TYPEONE
import com.seif.services.Constants.Companion.TYPETWO
import com.seif.services.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

// unbounded(started) service:
//        val intent = Intent(this, MyService::class.java)
//        binding.startService.setOnClickListener {
//            startService(intent)
//        }
//       binding.endService.setOnClickListener {
//           stopService(intent)
//       }

        // Intent Service
        val intent = Intent(this, MyIntentService::class.java)
        intent.putExtra("type", TYPEONE)
        startService(intent)

        val intent2 = Intent(this, MyIntentService::class.java)
            intent2.putExtra("type", TYPETWO)
            startService(intent2)


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

/*Notice that the onStartCommand() method must return an integer.
  The integer is a value that describes how the system should continue the service in the event that
  the system kills it. The return value from onStartCommand() must be one of the following constants:
*/
/*
START_NOT_STICKY
If the system kills the service after onStartCommand() returns,
do not recreate the service unless there are pending intents to deliver.
This is the safest option to avoid running your service when not necessary and
when your application can simply restart any unfinished jobs.
*/
/*
START_STICKY
If the system kills the service after onStartCommand() returns,
recreate the service and call onStartCommand(), but do not redeliver the last intent. Instead,
the system calls onStartCommand() with a null intent unless there are pending intents to start the service.
In that case, those intents are delivered.
This is suitable for media players (or similar services)
that are not executing commands but are running indefinitely and waiting for a job.
*/
/*
START_REDELIVER_INTENT
If the system kills the service after onStartCommand() returns,
recreate the service and call onStartCommand() with the last intent that was delivered to the service.
Any pending intents are delivered in turn. This is suitable for services that are actively performing
a job that should be immediately resumed, such as downloading a file.
*/