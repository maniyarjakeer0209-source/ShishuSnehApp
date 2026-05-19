package com.example.shishusneh.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.shishusneh.R

class NotificationHelper(

    private val context: Context
) {

    private val channelId = "vaccine_channel"

    fun showNotification(

        title: String,

        message: String
    ) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(

                channelId,

                "Vaccine Reminders",

                NotificationManager.IMPORTANCE_HIGH
            )

            val manager = context.getSystemService(

                NotificationManager::class.java
            )

            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(

            context,
            channelId

        )

            .setSmallIcon(android.R.drawable.ic_dialog_info)

            .setContentTitle(title)

            .setContentText(message)

            .setPriority(NotificationCompat.PRIORITY_HIGH)

        NotificationManagerCompat.from(context)
            .notify(1, builder.build())
    }
}