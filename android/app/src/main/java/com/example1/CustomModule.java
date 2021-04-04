package com.example1;

import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    CustomModule (ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }


    // we must define ReactMethod for every event
    // 1-) show toast message
    @ReactMethod
    public void show() {
        Toast.makeText(this.reactContext, "Android tarafından mesaj var",Toast.LENGTH_LONG).show();
    }

    // 2-) get device id
    @ReactMethod
    public void getDeviceId (Promise promise) {

        try {
            String android_id = Settings.Secure.getString((reactContext.getContentResolver()),Settings.Secure.ANDROID_ID);
            promise.resolve(android_id);
        } catch (Exception e) {
            promise.reject("Error",e);
        }
    }
    @NonNull
    @Override
    public String getName() {
        return "ABC";  // module name
    }
}
