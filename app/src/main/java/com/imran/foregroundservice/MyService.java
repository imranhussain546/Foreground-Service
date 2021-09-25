package com.imran.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import static com.imran.foregroundservice.App.Channel_id;

public class MyService extends Service {
    public static final String Channel_id="Foreground22211";
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String text=intent.getStringExtra("abc");
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=
                PendingIntent.getActivity(this,0, notificationIntent,0);

           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
           {
               NotificationChannel notificationChannel = new NotificationChannel(
                       Channel_id,"foreground", NotificationManager.IMPORTANCE_DEFAULT);

               NotificationManager notificationManager= getSystemService(NotificationManager.class);
               notificationManager.createNotificationChannel(notificationChannel);
           }
            Notification notification= new NotificationCompat.Builder(this,Channel_id)
                    .setContentTitle("xyz")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText(text)
                    .setContentIntent(pendingIntent)
                    .build();

        startForeground(1,notification);
        return START_NOT_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}