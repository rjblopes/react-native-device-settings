package com.rjblopes.opensettings;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.content.ComponentName;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class OpenSettings extends ReactContextBaseJavaModule {

    private ReactContext reactContext;

    public OpenSettings(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNOpenSettings";
    }

    private void startActivity(final Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
            reactContext.startActivity(intent);
        }
    }

    //region React Native Methods
    @ReactMethod
    public void generalSettings() {
        try {
            ComponentName name = new ComponentName(
                "com.android.tv.settings",
                "com.android.tv.settings.MainSettings"
            );
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(name);
            this.startActivity(intent);
        } catch (Exception e) {
            this.startActivity(new Intent(Settings.ACTION_SETTINGS));
        }
    }

    @ReactMethod
    public void appSettings() {
        try {
            ComponentName name = new ComponentName(
                "com.android.tv.settings",
                "com.android.tv.settings.device.apps.AppManagementActivity"
            );
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(name);
            intent.setData(Uri.parse("package:" + reactContext.getPackageName()));
            this.startActivity(intent);
        } catch (Exception e) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + reactContext.getPackageName()));
            this.startActivity(intent);
        }
    }

    @ReactMethod
    public void wifiSettings() {
        try {
            ComponentName name = new ComponentName(
                "com.android.tv.settings",
                "com.android.tv.settings.connectivity.NetworkActivity"
            );
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(name);
            this.startActivity(intent);
        } catch (Exception e) {
            this.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
        }
    }

    @ReactMethod
    public void locationSettings() {
        try {
            ComponentName name = new ComponentName(
                "com.android.tv.settings",
                "com.android.tv.settings.system.LocationActivity"
            );
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(name);
            this.startActivity(intent);
        } catch (Exception e) {
            this.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }
    //endregion
}
