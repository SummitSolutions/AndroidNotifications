package com.sumsol.android.common.common.service;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;
import com.google.gson.Gson;

import com.sumsol.android.common.common.util.NotificationMessageResolver;
import com.sumsol.android.common.domain.NotificationMessage;

public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";
    private NotificationBuilder notificationBuilder;


    @Override
    public void onCreate() {
        super.onCreate();
        notificationBuilder = NotificationBuilder.newInstance(this);
    }

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(String from, Bundle data) {
        try {
            NotificationMessage message = null;
            if (from.startsWith("/topics/")) {
                // message received from some topic.
            } else {
                final String jsonMessage = data.getString("data");
                Log.d(TAG, "Message: " + jsonMessage);
                message = (NotificationMessage) new Gson().fromJson(jsonMessage, NotificationMessageResolver.resolve(jsonMessage));
            }

            // [START_EXCLUDE]
            /**
             * Production applications would usually process the message here.
             * Eg: - Syncing with server.
             *     - Store message in local database.
             *     - Update UI.
             */

            /**
             * In some cases it may be useful to show a notification indicating to the user
             * that a message was received.
             */
            notificationBuilder.sendBundledNotification(message);

            //sendNotification(message);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        // [END_EXCLUDE]
    }
    // [END receive_message]

}
