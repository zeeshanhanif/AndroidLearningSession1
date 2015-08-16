package com.demo.alarammanager;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }
int i=0;
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
        }
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("alarmed")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("Alarmed Notification")
                .setContentText("this is notification text")
                .setContentIntent(PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity2.class), 0))
                .setAutoCancel(false)
                .build();
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(i++, notification);
    }
}
