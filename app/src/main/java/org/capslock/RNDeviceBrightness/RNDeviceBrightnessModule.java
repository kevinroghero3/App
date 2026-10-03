package org.capslock.RNDeviceBrightness;

import android.app.Activity;
import android.provider.Settings;
import android.view.WindowManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* JADX INFO: loaded from: classes3.dex */
public class RNDeviceBrightnessModule extends ReactContextBaseJavaModule {
    public RNDeviceBrightnessModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNDeviceBrightness";
    }

    @ReactMethod
    public void setBrightnessLevel(final float f) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: org.capslock.RNDeviceBrightness.RNDeviceBrightnessModule.1
            @Override // java.lang.Runnable
            public void run() {
                WindowManager.LayoutParams attributes = currentActivity.getWindow().getAttributes();
                attributes.screenBrightness = f;
                currentActivity.getWindow().setAttributes(attributes);
            }
        });
    }

    @ReactMethod
    public void getBrightnessLevel(Promise promise) {
        promise.resolve(Float.valueOf(getCurrentActivity().getWindow().getAttributes().screenBrightness));
    }

    @ReactMethod
    public void getSystemBrightnessLevel(Promise promise) {
        promise.resolve(Float.valueOf(Integer.parseInt(Settings.System.getString(getCurrentActivity().getContentResolver(), "screen_brightness")) / 255.0f));
    }
}
