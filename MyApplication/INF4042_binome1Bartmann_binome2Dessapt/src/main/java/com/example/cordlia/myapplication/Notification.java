package com.example.cordlia.myapplication;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class Notification extends BroadcastReceiver {

    public static final String TAG = "TAG";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, intent.getAction());

        PendingIntent pi = PendingIntent.getActivity(context,0,new Intent(context,RecyclerActivity.class),0);
        NotificationCompat.Builder notif = new NotificationCompat.Builder(context);
        notif.setSmallIcon(R.drawable.chat_notif);
        notif.setContentTitle(context.getString(R.string.list_beer));
        notif.setContentText(context.getString(R.string.beer_ready));
        notif.setContentIntent(pi);
        notif.setAutoCancel(true);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(17, notif.build());

    }
}
