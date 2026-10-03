package com.facebook.react.bridge;

import com.facebook.jni.HybridClassBase;

/* JADX INFO: loaded from: classes4.dex */
public class CxxCallbackImpl extends HybridClassBase implements Callback {
    private native void nativeInvoke(NativeArray nativeArray);

    private CxxCallbackImpl() {
    }

    @Override // com.facebook.react.bridge.Callback
    public void invoke(Object... objArr) {
        nativeInvoke(Arguments.fromJavaArgs(objArr));
    }
}
