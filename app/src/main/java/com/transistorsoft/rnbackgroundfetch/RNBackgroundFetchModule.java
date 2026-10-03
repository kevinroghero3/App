package com.transistorsoft.rnbackgroundfetch;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import com.transistorsoft.tsbackgroundfetch.LifecycleManager;
import io.sentry.ProfilingTraceData;

/* JADX INFO: loaded from: classes3.dex */
public class RNBackgroundFetchModule extends ReactContextBaseJavaModule implements ActivityEventListener, LifecycleEventListener {
    private static final String EVENT_FETCH = "fetch";
    private static final String FETCH_TASK_ID = "react-native-background-fetch";
    private static final String JOB_SERVICE_CLASS = HeadlessTask.class.getName();
    public static final String TAG = "RNBackgroundFetch";
    private boolean initialized;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNBackgroundFetchModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.initialized = false;
        Log.d(BackgroundFetch.TAG, "[RNBackgroundFetch initialize]");
        BackgroundFetch.getInstance(reactApplicationContext.getApplicationContext());
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void configure(ReadableMap readableMap, Callback callback, Callback callback2) {
        getAdapter().configure(buildConfig(readableMap).setTaskId(FETCH_TASK_ID).setIsFetchTask(true).build(), new BackgroundFetch.Callback() { // from class: com.transistorsoft.rnbackgroundfetch.RNBackgroundFetchModule.1
            @Override // com.transistorsoft.tsbackgroundfetch.BackgroundFetch.Callback
            public void onFetch(String str) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, str);
                writableNativeMap.putBoolean(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, false);
                ((RCTNativeAppEventEmitter) RNBackgroundFetchModule.this.getReactApplicationContext().getJSModule(RCTNativeAppEventEmitter.class)).emit("fetch", writableNativeMap);
            }

            @Override // com.transistorsoft.tsbackgroundfetch.BackgroundFetch.Callback
            public void onTimeout(String str) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, str);
                writableNativeMap.putBoolean(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, true);
                ((RCTNativeAppEventEmitter) RNBackgroundFetchModule.this.getReactApplicationContext().getJSModule(RCTNativeAppEventEmitter.class)).emit("fetch", writableNativeMap);
            }
        });
        callback.invoke(2);
    }

    @ReactMethod
    public void scheduleTask(ReadableMap readableMap, Callback callback, Callback callback2) {
        getAdapter().scheduleTask(buildConfig(readableMap).build());
        callback.invoke(Boolean.TRUE);
    }

    @ReactMethod
    public void start(Callback callback, Callback callback2) {
        BackgroundFetch adapter = getAdapter();
        adapter.start(FETCH_TASK_ID);
        callback.invoke(Integer.valueOf(adapter.status()));
    }

    @ReactMethod
    public void stop(String str, Callback callback, Callback callback2) {
        if (str == null) {
            str = FETCH_TASK_ID;
        }
        getAdapter().stop(str);
        callback.invoke(Boolean.TRUE);
    }

    @ReactMethod
    public void status(Callback callback) {
        callback.invoke(Integer.valueOf(getAdapter().status()));
    }

    @ReactMethod
    public void finish(String str) {
        getAdapter().finish(str);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        if (this.initialized) {
            return;
        }
        initializeBackgroundFetch();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        LifecycleManager.getInstance().setHeadless(true);
        this.initialized = false;
    }

    private BackgroundFetchConfig.Builder buildConfig(ReadableMap readableMap) {
        BackgroundFetchConfig.Builder builder = new BackgroundFetchConfig.Builder();
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL)) {
            builder.setMinimumFetchInterval(readableMap.getInt(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_TASK_ID)) {
            builder.setTaskId(readableMap.getString(BackgroundFetchConfig.FIELD_TASK_ID));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_DELAY)) {
            builder.setDelay(Integer.valueOf(readableMap.getInt(BackgroundFetchConfig.FIELD_DELAY)).longValue());
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE)) {
            builder.setStopOnTerminate(readableMap.getBoolean(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER)) {
            builder.setForceAlarmManager(readableMap.getBoolean(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER));
        }
        if (readableMap.hasKey("startOnBoot")) {
            builder.setStartOnBoot(readableMap.getBoolean("startOnBoot"));
        }
        if (readableMap.hasKey("enableHeadless") && readableMap.getBoolean("enableHeadless")) {
            builder.setJobService(JOB_SERVICE_CLASS);
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE)) {
            builder.setRequiredNetworkType(readableMap.getInt(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW)) {
            builder.setRequiresBatteryNotLow(readableMap.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING)) {
            builder.setRequiresCharging(readableMap.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(readableMap.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW)) {
            builder.setRequiresStorageNotLow(readableMap.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW));
        }
        if (readableMap.hasKey(BackgroundFetchConfig.FIELD_PERIODIC)) {
            builder.setPeriodic(readableMap.getBoolean(BackgroundFetchConfig.FIELD_PERIODIC));
        }
        return builder;
    }

    private void initializeBackgroundFetch() {
        if (getCurrentActivity() == null) {
            return;
        }
        this.initialized = true;
    }

    private BackgroundFetch getAdapter() {
        return BackgroundFetch.getInstance(getReactApplicationContext());
    }
}
