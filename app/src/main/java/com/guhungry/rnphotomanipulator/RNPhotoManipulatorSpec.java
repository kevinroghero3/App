package com.guhungry.rnphotomanipulator;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RNPhotoManipulatorSpec extends ReactContextBaseJavaModule {
    public abstract void batch(String str, ReadableArray readableArray, ReadableMap readableMap, @Nullable ReadableMap readableMap2, @Nullable Double d, @Nullable String str2, Promise promise);

    public abstract void crop(String str, ReadableMap readableMap, @Nullable ReadableMap readableMap2, @Nullable String str2, Promise promise);

    public abstract void flipImage(String str, String str2, @Nullable String str3, Promise promise);

    public abstract void optimize(String str, double d, Promise promise);

    public abstract void overlayImage(String str, String str2, ReadableMap readableMap, @Nullable String str3, Promise promise);

    public abstract void printText(String str, ReadableArray readableArray, @Nullable String str2, Promise promise);

    public abstract void rotateImage(String str, String str2, @Nullable String str3, Promise promise);

    public RNPhotoManipulatorSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
