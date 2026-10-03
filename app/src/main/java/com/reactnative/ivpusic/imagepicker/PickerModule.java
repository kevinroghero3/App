package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes.dex */
public class PickerModule extends ReactContextBaseJavaModule {
    private final ImageCropPicker picker;

    public PickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.picker = new ImageCropPicker(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCImageCropPicker";
    }

    @ReactMethod
    public void openPicker(ReadableMap readableMap, Promise promise) {
        this.picker.openPicker(readableMap, promise);
    }

    @ReactMethod
    public void openCamera(ReadableMap readableMap, Promise promise) {
        this.picker.openCamera(readableMap, promise);
    }

    @ReactMethod
    public void openCropper(ReadableMap readableMap, Promise promise) {
        this.picker.openCropper(readableMap, promise);
    }

    @ReactMethod
    public void clean(Promise promise) {
        this.picker.clean(promise);
    }

    @ReactMethod
    public void cleanSingle(String str, Promise promise) {
        this.picker.cleanSingle(str, promise);
    }
}
