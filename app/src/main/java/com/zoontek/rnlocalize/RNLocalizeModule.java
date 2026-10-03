package com.zoontek.rnlocalize;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNLocalizeModuleImpl.NAME)
public final class RNLocalizeModule extends ReactContextBaseJavaModule {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNLocalizeModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNLocalizeModuleImpl.NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getCalendar() {
        return RNLocalizeModuleImpl.INSTANCE.getCalendar();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getCountry() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getCountry(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final WritableArray getCurrencies() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getCurrencies(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final WritableArray getLocales() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getLocales(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final WritableMap getNumberFormatSettings() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getNumberFormatSettings(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getTemperatureUnit() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.getTemperatureUnit(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final String getTimeZone() {
        return RNLocalizeModuleImpl.INSTANCE.getTimeZone();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean uses24HourClock() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.uses24HourClock(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean usesMetricSystem() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.usesMetricSystem(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean usesAutoDateAndTime() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.usesAutoDateAndTime(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean usesAutoTimeZone() {
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNLocalizeModuleImpl.usesAutoTimeZone(reactApplicationContext);
    }

    @ReactMethod
    public final void openAppLanguageSettings(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNLocalizeModuleImpl rNLocalizeModuleImpl = RNLocalizeModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNLocalizeModuleImpl.openAppLanguageSettings(reactApplicationContext, promise);
    }
}
