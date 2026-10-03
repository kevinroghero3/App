package com.facebook.react.devsupport.inspector;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class InspectorNetworkRequestListener {
    private final HybridData mHybridData;

    public native void onCompletion();

    public native void onData(String str);

    public native void onError(@Nullable String str);

    public native void onHeaders(int i, Map<String, String> map);

    public InspectorNetworkRequestListener(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
