package com.rjblopes.opensettings;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

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

    //region React Native Methods
    @ReactMethod
    public void generalSettings() {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
            reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void appSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.setData(Uri.parse("package:" + reactContext.getPackageName()));
        if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
            reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void wifiSettings() {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
            reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void bluetoothSettings() {
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
            reactContext.startActivity(intent);
        }
    }
    //endregion
}
