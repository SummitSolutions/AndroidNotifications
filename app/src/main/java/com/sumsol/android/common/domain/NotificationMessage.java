package com.sumsol.android.common.domain;

import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class NotificationMessage implements Serializable, JsonDocument{

    private static final long serialVersionUID = -1L;

    private String message;
    private String title;
    private String type;

    public NotificationMessage(String type,String title, String message) {
        this.message = message;
        this.title = title;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toJson() {
        return new GsonBuilder().create().toJson(this, NotificationMessage.class);
    }
}
