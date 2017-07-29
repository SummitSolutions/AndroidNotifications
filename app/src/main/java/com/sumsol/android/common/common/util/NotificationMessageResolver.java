package com.sumsol.android.common.common.util;

import com.google.gson.JsonParser;
import com.sumsol.android.common.domain.NotificationMessage;

public class NotificationMessageResolver {

    public static Class<? extends NotificationMessage> resolve( String jsonMessage ){
        try {
            final String clazz = new JsonParser().parse(jsonMessage).getAsJsonObject()
                    .get("type").getAsString();
            return (Class<? extends NotificationMessage>) Class.forName(clazz);
        } catch (NullPointerException | ClassNotFoundException e) {
            return null;
        }
    }

}
