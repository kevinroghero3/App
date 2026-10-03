package com.heanoria.library.reactnative.locationenabler;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.location.LocationManagerCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "AndroidLocationEnabler")
public final class AndroidLocationEnablerModule extends NativeAndroidLocationEnablerSpec implements ActivityEventListener, OnCompleteListener<LocationSettingsResponse> {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INTERVAL_DURATION = 10000;
    public static final boolean DEFAULT_WAIT_FOR_ACCURATE = true;
    public static final String ERR_FAILED_OPEN_DIALOG_CODE = "ERR02";
    public static final String ERR_INTERNAL_ERROR = "ERR03";
    public static final String ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE = "ERR01";
    public static final String ERR_USER_DENIED_CODE = "ERR00";
    public static final String LOCATION_INTERVAL_DURATION_PARAMS_KEY = "interval";
    public static final String LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY = "waitForAccurate";
    public static final String NAME = "AndroidLocationEnabler";
    public static final int REQUEST_CHECK_SETTINGS = 42;
    public static final String TAG = "LocationEnablerModule";
    private final ReactApplicationContext context;
    private Promise promise;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationEnablerModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.context = reactContext;
        reactContext.addActivityEventListener(this);
    }

    @Override // com.heanoria.library.reactnative.locationenabler.NativeAndroidLocationEnablerSpec
    public void isLocationEnabled(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getCurrentActivity() == null) {
            return;
        }
        Object systemService = this.context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        promise.resolve(Boolean.valueOf(LocationManagerCompat.isLocationEnabled((LocationManager) systemService)));
    }

    @Override // com.heanoria.library.reactnative.locationenabler.NativeAndroidLocationEnablerSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AndroidLocationEnabler";
    }

    @Override // com.heanoria.library.reactnative.locationenabler.NativeAndroidLocationEnablerSpec
    public void promptForEnableLocationIfNeeded(@Nullable ReadableMap readableMap, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getCurrentActivity() == null) {
            return;
        }
        this.promise = promise;
        int i = (readableMap == null || !readableMap.hasKey(LOCATION_INTERVAL_DURATION_PARAMS_KEY)) ? 10000 : readableMap.getInt(LOCATION_INTERVAL_DURATION_PARAMS_KEY);
        boolean z = (readableMap == null || !readableMap.hasKey(LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY)) ? true : readableMap.getBoolean(LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY);
        Log.i(TAG, "passed interval " + i);
        LocationSettingsRequest locationSettingsRequestBuild = new LocationSettingsRequest.Builder().addLocationRequest(createRequest((long) i, z)).setAlwaysShow(true).build();
        Intrinsics.checkNotNullExpressionValue(locationSettingsRequestBuild, "build(...)");
        Task<LocationSettingsResponse> taskCheckLocationSettings = LocationServices.getSettingsClient(this.context).checkLocationSettings(locationSettingsRequestBuild);
        Intrinsics.checkNotNullExpressionValue(taskCheckLocationSettings, "checkLocationSettings(...)");
        taskCheckLocationSettings.addOnCompleteListener(this);
    }

    private final LocationRequest createRequest(long j, boolean z) {
        LocationRequest.Builder builder = new LocationRequest.Builder(100, j);
        builder.setWaitForAccurateLocation(z);
        LocationRequest locationRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
        return locationRequestBuild;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(@NotNull Task<LocationSettingsResponse> task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        Log.i(TAG, "OnComplete");
        try {
            task.getResult(ApiException.class);
            Promise promise = this.promise;
            if (promise != null) {
                promise.resolve("already-enabled");
            }
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode != 8502) {
                    return;
                }
                Promise promise2 = this.promise;
                if (promise2 != null) {
                    promise2.reject(new AndroidLocationEnablerException(ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE));
                }
                this.promise = null;
                return;
            }
            try {
                Intrinsics.checkNotNull(e, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                Activity currentActivity = this.context.getCurrentActivity();
                if (currentActivity != null) {
                    resolvableApiException.startResolutionForResult(currentActivity, 42);
                }
            } catch (IntentSender.SendIntentException e2) {
                SentryLogcatAdapter.e(TAG, "Failed to show dialog", e2);
                Promise promise3 = this.promise;
                if (promise3 != null) {
                    promise3.reject(new AndroidLocationEnablerException(ERR_FAILED_OPEN_DIALOG_CODE, e2));
                }
                this.promise = null;
            } catch (ClassCastException e3) {
                Promise promise4 = this.promise;
                if (promise4 != null) {
                    promise4.reject(new AndroidLocationEnablerException(ERR_INTERNAL_ERROR, e3));
                }
                this.promise = null;
            }
        }
    }

    private final boolean isLocationProviderEnabled() {
        Activity currentActivity = getCurrentActivity();
        Object systemService = currentActivity != null ? currentActivity.getSystemService("location") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(@NotNull Activity activity, int i, int i2, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.i(TAG, "On activityResult : " + i);
        if (i == 42) {
            if (i2 == -1 || isLocationProviderEnabled()) {
                Log.i(TAG, "User has enabled the location service");
                Promise promise = this.promise;
                if (promise != null) {
                    promise.resolve(ViewProps.ENABLED);
                }
            } else {
                Promise promise2 = this.promise;
                if (promise2 != null) {
                    promise2.reject(new AndroidLocationEnablerException(ERR_USER_DENIED_CODE));
                }
            }
            this.promise = null;
        }
    }
}
