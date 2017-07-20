package com.sumsol.android.common.com.sumsol.android.common.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;

import com.example.ibaou.myapplication.R;
import com.sumsol.android.common.domain.NotificationMessage;

import java.util.Date;

final class NotificationBuilder {

    private static final String GROUP_KEY = "Messenger";
    private static final String NOTIFICATION_ID = "com.example.ibaou.myapplication.NOTIFICATION_ID";
    private static final int SUMMARY_ID = 0;

    private final Context context;
    private final NotificationManagerCompat notificationManager;
    private final SharedPreferences sharedPreferences;

    static NotificationBuilder newInstance(Context context) {
        Context appContext = context.getApplicationContext();
        Context safeContext = ContextCompat.createDeviceProtectedStorageContext(appContext);
        if (safeContext == null) {
            safeContext = appContext;
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(safeContext);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(safeContext);
        return new NotificationBuilder(safeContext, notificationManager, sharedPreferences);
    }

    private NotificationBuilder(Context context,
                                NotificationManagerCompat notificationManager,
                                SharedPreferences sharedPreferences) {
        this.context = context.getApplicationContext();
        this.notificationManager = notificationManager;
        this.sharedPreferences = sharedPreferences;
    }

    void sendBundledNotification(NotificationMessage message) {
        Notification notification = buildNotification(message, GROUP_KEY);
        notificationManager.notify(getNotificationId(), notification);
        Notification summary = buildSummary(message, GROUP_KEY);
        notificationManager.notify(SUMMARY_ID, summary);
    }

    private Notification buildNotification(NotificationMessage message, String groupKey) {
        return new NotificationCompat.Builder(context)
                .setContentTitle(message.getTitle())
                .setContentText(message.getMessage())
                .setWhen(new Date().getTime())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(
                        this.context.getResources(), R.mipmap.ic_launcher))
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setPriority(Notification.PRIORITY_HIGH)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setShowWhen(true)
                .setGroup(groupKey)
                .build();
    }

    private Notification buildSummary(NotificationMessage message, String groupKey) {
        return new NotificationCompat.Builder(context)
                .setContentTitle("Messenger")
                .setContentText("You have unread messages")
                .setWhen(new Date().getTime())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setShowWhen(true)
                .setGroup(groupKey)
                .setGroupSummary(true)
                .build();
    }

    private int getNotificationId() {
        int id = sharedPreferences.getInt(NOTIFICATION_ID, SUMMARY_ID) + 1;
        while (id == SUMMARY_ID) {
            id++;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NOTIFICATION_ID, id);
        editor.apply();
        return id;
    }

    @TargetApi(20)
    private void addReplyAction(NotificationCompat.Builder mBuilder, PendingIntent pendingIntent){

        String replyLabel = "Reply";
        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel(replyLabel)
                .build();

        NotificationCompat.Action action =
                new 	NotificationCompat.Action.Builder(R.mipmap.ic_launcher,
                        "paok", pendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

        mBuilder.addAction(action);
    }
}