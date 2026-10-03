package com.reactnativebarcodecreator;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.ExceptionsManagerModule;

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    public static void showException(ReactContext reactContext, Exception exc) {
        ExceptionsManagerModule exceptionsManagerModule = (ExceptionsManagerModule) reactContext.getNativeModule(ExceptionsManagerModule.class);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("message", exc.getMessage());
        exceptionsManagerModule.reportException(writableNativeMap);
    }
}
