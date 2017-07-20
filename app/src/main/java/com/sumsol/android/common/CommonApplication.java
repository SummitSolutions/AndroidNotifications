package com.sumsol.android.common;

import android.app.Application;
import android.content.Context;

import com.sumsol.android.common.com.sumsol.android.common.util.PreferencesUtil;
import com.sumsol.android.common.domain.Preferences;

public class CommonApplication extends Application {

    private Preferences preferences = null;

    private static  CommonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static CommonApplication getInstance(){
        return instance;
    }

    public void savePreferences(){
        PreferencesUtil.persistPreferences(this, preferences);
    }

    public Preferences getPreferences(){
        if(this.preferences == null) {
            this.preferences = PreferencesUtil.loadPreferences(this);
        }

        return this.preferences;
    }
}
