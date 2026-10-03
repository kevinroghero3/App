package com.zoontek.rnpermissions;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.locationmanager.config.TSNotification;
import java.util.ArrayList;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class RNPermissionsModuleImpl {
    private static final String BLOCKED = "blocked";
    private static final String DENIED = "denied";
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    private static final String GRANTED = "granted";
    public static final String NAME = "RNPermissions";
    private static final String UNAVAILABLE = "unavailable";
    private static int requestCode;
    public static final RNPermissionsModuleImpl INSTANCE = new RNPermissionsModuleImpl();
    private static final Map<String, Integer> minimumApi = MapsKt__MapsKt.mapOf(TuplesKt.to("android.permission.ACCEPT_HANDOVER", 28), TuplesKt.to(TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION, 29), TuplesKt.to("android.permission.ACCESS_MEDIA_LOCATION", 29), TuplesKt.to("android.permission.ACTIVITY_RECOGNITION", 29), TuplesKt.to("android.permission.ANSWER_PHONE_CALLS", 26), TuplesKt.to("android.permission.BLUETOOTH_ADVERTISE", 31), TuplesKt.to("android.permission.BLUETOOTH_CONNECT", 31), TuplesKt.to("android.permission.BLUETOOTH_SCAN", 31), TuplesKt.to("android.permission.BODY_SENSORS_BACKGROUND", 33), TuplesKt.to("android.permission.NEARBY_WIFI_DEVICES", 33), TuplesKt.to("android.permission.READ_MEDIA_AUDIO", 33), TuplesKt.to("android.permission.READ_MEDIA_IMAGES", 33), TuplesKt.to("android.permission.READ_MEDIA_VIDEO", 33), TuplesKt.to("android.permission.READ_MEDIA_VISUAL_USER_SELECTED", 34), TuplesKt.to("android.permission.READ_PHONE_NUMBERS", 26), TuplesKt.to("android.permission.UWB_RANGING", 31));

    private RNPermissionsModuleImpl() {
    }

    private final boolean isPermissionAvailable(String str) {
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "android.", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(str, "com.android", false, 2, null)) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        Integer num = minimumApi.get(str);
        return i >= (num != null ? num.intValue() : 1);
    }

    public final void openSettings(@NotNull ReactApplicationContext reactContext, @Nullable String str, @NotNull Promise promise) {
        Intent intent;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String packageName = reactContext.getPackageName();
            int i = Build.VERSION.SDK_INT;
            if (i >= 31 && Intrinsics.areEqual(str, "alarms")) {
                intent = new Intent();
                intent.setAction("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
                intent.setData(Uri.parse("package:" + packageName));
            } else if (i >= 34 && Intrinsics.areEqual(str, "fullscreen")) {
                intent = new Intent();
                intent.setAction("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT");
                intent.setData(Uri.parse("package:" + packageName));
            } else if (i >= 26 && Intrinsics.areEqual(str, "notifications")) {
                intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            } else {
                intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + packageName));
            }
            intent.addFlags(268435456);
            reactContext.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject(ERROR_INVALID_ACTIVITY, e);
        }
    }

    public final void canScheduleExactAlarms(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (Build.VERSION.SDK_INT < 31) {
            promise.resolve(Boolean.TRUE);
            return;
        }
        Object systemService = reactContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
        promise.resolve(Boolean.valueOf(alarmManager != null ? alarmManager.canScheduleExactAlarms() : false));
    }

    public final void canUseFullScreenIntent(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (Build.VERSION.SDK_INT < 34) {
            promise.resolve(Boolean.TRUE);
            return;
        }
        Object systemService = reactContext.getSystemService(TSNotification.NAME);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        promise.resolve(Boolean.valueOf(((NotificationManager) systemService).canUseFullScreenIntent()));
    }

    public final void check(@NotNull ReactApplicationContext reactContext, @NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!isPermissionAvailable(permission)) {
            promise.resolve(UNAVAILABLE);
        } else if (reactContext.getBaseContext().checkSelfPermission(permission) == 0) {
            promise.resolve(GRANTED);
        } else {
            promise.resolve(DENIED);
        }
    }

    public final void checkNotifications(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(reactContext).areNotificationsEnabled();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("status", zAreNotificationsEnabled ? GRANTED : DENIED);
        writableMapCreateMap.putMap("settings", Arguments.createMap());
        promise.resolve(writableMapCreateMap);
    }

    public final void checkMultiple(@NotNull ReactApplicationContext reactContext, @NotNull ReadableArray permissions, @NotNull Promise promise) {
        String str;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Context baseContext = reactContext.getBaseContext();
        int size = permissions.size();
        for (int i = 0; i < size; i++) {
            String string = permissions.getString(i);
            if (string != null && !StringsKt__StringsKt.isBlank(string)) {
                if (isPermissionAvailable(string)) {
                    str = baseContext.checkSelfPermission(string) == 0 ? GRANTED : DENIED;
                } else {
                    str = UNAVAILABLE;
                }
                writableNativeMap.putString(string, str);
            }
        }
        promise.resolve(writableNativeMap);
    }

    public final void request(@NotNull ReactApplicationContext reactContext, @NotNull PermissionListener listener, @NotNull SparseArray<Callback> callbacks, @NotNull final String permission, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (!isPermissionAvailable(permission)) {
            promise.resolve(UNAVAILABLE);
            return;
        }
        if (reactContext.getBaseContext().checkSelfPermission(permission) == 0) {
            promise.resolve(GRANTED);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity(reactContext);
            callbacks.put(requestCode, new Callback() { // from class: com.zoontek.rnpermissions.RNPermissionsModuleImpl$$ExternalSyntheticLambda1
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object[] objArr) {
                    RNPermissionsModuleImpl.request$lambda$6(promise, permission, objArr);
                }
            });
            permissionAwareActivity.requestPermissions(new String[]{permission}, requestCode, listener);
            requestCode++;
        } catch (IllegalStateException e) {
            promise.reject(ERROR_INVALID_ACTIVITY, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$6(Promise promise, String str, Object[] args) {
        String str2;
        Intrinsics.checkNotNullParameter(args, "args");
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        Object obj2 = args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
        PermissionAwareActivity permissionAwareActivity = (PermissionAwareActivity) obj2;
        Integer orNull = ArraysKt___ArraysKt.getOrNull((int[]) obj, 0);
        if (orNull != null && orNull.intValue() == 0) {
            str2 = GRANTED;
        } else {
            str2 = permissionAwareActivity.shouldShowRequestPermissionRationale(str) ? DENIED : BLOCKED;
        }
        promise.resolve(str2);
    }

    public final void requestNotifications(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(reactContext).areNotificationsEnabled();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("status", zAreNotificationsEnabled ? GRANTED : BLOCKED);
        writableMapCreateMap.putMap("settings", Arguments.createMap());
        promise.resolve(writableMapCreateMap);
    }

    public final void requestMultiple(@NotNull ReactApplicationContext reactContext, @NotNull PermissionListener listener, @NotNull SparseArray<Callback> callbacks, @NotNull ReadableArray permissions, @NotNull final Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        final ArrayList arrayList = new ArrayList();
        Context baseContext = reactContext.getBaseContext();
        int size = permissions.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String string = permissions.getString(i2);
            if (string != null && !StringsKt__StringsKt.isBlank(string)) {
                if (!isPermissionAvailable(string)) {
                    writableNativeMap.putString(string, UNAVAILABLE);
                } else if (baseContext.checkSelfPermission(string) == 0) {
                    writableNativeMap.putString(string, GRANTED);
                } else {
                    arrayList.add(string);
                }
                i++;
            }
        }
        if (permissions.size() == i) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity(reactContext);
            callbacks.put(requestCode, new Callback() { // from class: com.zoontek.rnpermissions.RNPermissionsModuleImpl$$ExternalSyntheticLambda2
                @Override // com.facebook.react.bridge.Callback
                public final void invoke(Object[] objArr) {
                    RNPermissionsModuleImpl.requestMultiple$lambda$9(arrayList, promise, writableNativeMap, objArr);
                }
            });
            permissionAwareActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), requestCode, listener);
            requestCode++;
        } catch (IllegalStateException e) {
            promise.reject(ERROR_INVALID_ACTIVITY, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestMultiple$lambda$9(ArrayList arrayList, Promise promise, WritableMap writableMap, Object[] args) {
        String str;
        Intrinsics.checkNotNullParameter(args, "args");
        int i = 0;
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
        int[] iArr = (int[]) obj;
        Object obj2 = args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.facebook.react.modules.core.PermissionAwareActivity");
        PermissionAwareActivity permissionAwareActivity = (PermissionAwareActivity) obj2;
        for (Object obj3 : arrayList) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj3;
            Integer orNull = ArraysKt___ArraysKt.getOrNull(iArr, i);
            if (orNull != null && orNull.intValue() == 0) {
                str = GRANTED;
            } else {
                str = permissionAwareActivity.shouldShowRequestPermissionRationale(str2) ? DENIED : BLOCKED;
            }
            writableMap.putString(str2, str);
            i++;
        }
        promise.resolve(writableMap);
    }

    public final void shouldShowRequestRationale(@NotNull ReactApplicationContext reactContext, @NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity(reactContext).shouldShowRequestPermissionRationale(permission)));
        } catch (IllegalStateException e) {
            promise.reject(ERROR_INVALID_ACTIVITY, e);
        }
    }

    private final PermissionAwareActivity getPermissionAwareActivity(ReactApplicationContext reactApplicationContext) {
        ComponentCallbacks2 currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (!(currentActivity instanceof PermissionAwareActivity)) {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
        return (PermissionAwareActivity) currentActivity;
    }

    public final void openPhotoPicker(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.reject("Permissions:openPhotoPicker", "openPhotoPicker is not supported on Android");
    }

    public final void checkLocationAccuracy(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.reject("Permissions:checkLocationAccuracy", "checkLocationAccuracy is not supported on Android");
    }

    public final void requestLocationAccuracy(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.reject("Permissions:requestLocationAccuracy", "requestLocationAccuracy is not supported on Android");
    }

    public final boolean onRequestPermissionsResult(@NotNull ReactApplicationContext reactContext, @NotNull SparseArray<Callback> callbacks, int i, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        try {
            Callback callback = callbacks.get(i);
            if (callback != null) {
                callback.invoke(grantResults, getPermissionAwareActivity(reactContext));
                callbacks.remove(i);
            } else {
                FLog.w("PermissionsModule", "Unable to find callback with requestCode %d", Integer.valueOf(i));
            }
            return callbacks.size() == 0;
        } catch (IllegalStateException e) {
            FLog.e("PermissionsModule", e, "Unexpected invocation of `onRequestPermissionsResult`", new Object[0]);
            return false;
        }
    }
}
