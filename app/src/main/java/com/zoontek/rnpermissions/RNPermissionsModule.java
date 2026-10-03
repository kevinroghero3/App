package com.zoontek.rnpermissions;

import android.util.SparseArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNPermissionsModuleImpl.NAME)
public final class RNPermissionsModule extends ReactContextBaseJavaModule implements PermissionListener {
    private final SparseArray<Callback> callbacks;

    public RNPermissionsModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.callbacks = new SparseArray<>();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNPermissionsModuleImpl.NAME;
    }

    @ReactMethod
    public final void openSettings(@Nullable String str, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.openSettings(reactApplicationContext, str, promise);
    }

    @ReactMethod
    public final void canScheduleExactAlarms(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.canScheduleExactAlarms(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void canUseFullScreenIntent(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.canUseFullScreenIntent(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void check(@NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.check(reactApplicationContext, permission, promise);
    }

    @ReactMethod
    public final void checkNotifications(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.checkNotifications(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void checkMultiple(@NotNull ReadableArray permissions, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.checkMultiple(reactApplicationContext, permissions, promise);
    }

    @ReactMethod
    public final void request(@NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.request(reactApplicationContext, this, this.callbacks, permission, promise);
    }

    @ReactMethod
    public final void requestNotifications(@NotNull ReadableArray options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.requestNotifications(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void requestMultiple(@NotNull ReadableArray permissions, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.requestMultiple(reactApplicationContext, this, this.callbacks, permissions, promise);
    }

    @ReactMethod
    public final void shouldShowRequestRationale(@NotNull String permission, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.shouldShowRequestRationale(reactApplicationContext, permission, promise);
    }

    @ReactMethod
    public final void checkLocationAccuracy(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.checkLocationAccuracy(promise);
    }

    @ReactMethod
    public final void requestLocationAccuracy(@NotNull String purposeKey, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(purposeKey, "purposeKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.requestLocationAccuracy(promise);
    }

    @ReactMethod
    public final void openPhotoPicker(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.openPhotoPicker(promise);
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNPermissionsModuleImpl.onRequestPermissionsResult(reactApplicationContext, this.callbacks, i, grantResults);
    }
}
