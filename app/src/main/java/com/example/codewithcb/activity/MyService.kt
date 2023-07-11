package com.example.codewithcb.activity

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Process.THREAD_PRIORITY_BACKGROUND
import android.provider.Settings
import android.widget.Toast

class MyService: Service() {


    private var serviceLooper: Looper? = null
    private var serviceHandler: ServiceHandler? = null
    private var mediaPlayer: MediaPlayer? = null

    private inner class ServiceHandler(looper: Looper): Handler(looper) {
        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                // Restore interrupt status.
                Thread.currentThread().interrupt()
            }

            stopSelf()
        }

    }

    override fun onCreate() {
//        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
//            start()
//
//            // Get the HandlerThread's Looper and use it for our Handler
//            serviceLooper = looper
//            serviceHandler = ServiceHandler(looper)
//        }
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            serviceHandler?.sendMessage(msg)
        }

        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()

        // If we get killed, after returning from here, restart
        return START_STICKY

    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
    }
}