package com.sumsol.android.common.com.sumsol.android.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sumsol.android.common.domain.Preferences;

public class PreferencesUtil {

    private static final String APPLICATION_NAME_KEY= "app_name";
    private static final String PREFERENCES_FILE_KEY = "preferences";
    private static final String COMMON_PREFERENCES_KEY = "common";

    public static Preferences loadPreferences(Context context){
        return loadPreferences(context, PREFERENCES_FILE_KEY);
    }

    public static Preferences loadPreferences(Context context, String key){
        final String appName = getApplicationName(context);
        Preferences prefs = null;
        SharedPreferences sharedPrefs = getSharedPreferencesFile(appName, context);
        String keyValue = sharedPrefs.getString(key, null);
        if( keyValue == null ){
            prefs = new Preferences();
            persistPreferences( context, key, prefs );
        }else{
            prefs = new Gson().fromJson(keyValue, Preferences.class);
        }

        return prefs;
    }

    public static void persistPreferences( Context context, Preferences prefs ){
        persistPreferences( context, PREFERENCES_FILE_KEY, prefs );
    }

    public static void persistPreferences( Context context, String key, Preferences prefs ){
        final String appName = getApplicationName(context);
        SharedPreferences sharedPrefs = getSharedPreferencesFile(appName, context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(key, prefs.toJson());
        editor.commit();
    }

    private static SharedPreferences getSharedPreferencesFile(String appName, Context context){
        return context.getSharedPreferences(
                appName+"."+ PREFERENCES_FILE_KEY, Context.MODE_PRIVATE);
    }

    private static String getApplicationName(Context context) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(APPLICATION_NAME_KEY, "string", packageName);
        return context.getString(resId);
    }

}
