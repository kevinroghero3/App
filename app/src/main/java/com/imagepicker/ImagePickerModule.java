package com.imagepicker;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public class ImagePickerModule extends ReactContextBaseJavaModule {
    final ImagePickerModuleImpl imagePickerModuleImpl;

    ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.imagePickerModuleImpl = new ImagePickerModuleImpl(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ImagePicker";
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback) {
        this.imagePickerModuleImpl.launchCamera(readableMap, callback);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        this.imagePickerModuleImpl.launchImageLibrary(readableMap, callback);
    }
}
