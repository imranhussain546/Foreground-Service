package com.imran.foregroundservice;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

public class App extends Application {

    public static final String Channel_id="Foreground22211";

    @Override
    public void onCreate() {
        super.onCreate();

       // createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(
                    Channel_id,"foreground", NotificationManager.IMPORTANCE_DEFAULT);

//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(notificationChannel);
            NotificationManagerCompat notificationManager= NotificationManagerCompat.from(this);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        else
        {

            NotificationManagerCompat notificationManager= NotificationManagerCompat.from(this);
            notificationManager.notify();
        }
    }
}
