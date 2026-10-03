package com.worklets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* JADX INFO: loaded from: classes3.dex */
abstract class WorkletsSpec extends ReactContextBaseJavaModule {
    public abstract boolean install();

    WorkletsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
