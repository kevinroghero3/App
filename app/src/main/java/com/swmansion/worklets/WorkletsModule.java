package com.swmansion.worklets;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.NativeWorkletsModuleSpec;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = NativeWorkletsModuleSpec.NAME)
public class WorkletsModule extends NativeWorkletsModuleSpec {
    private final AndroidUIScheduler mAndroidUIScheduler;
    private HybridData mHybridData;
    private final AtomicBoolean mInvalidated;
    private final WorkletsMessageQueueThread mMessageQueueThread;

    private native HybridData initHybrid(long j, String str, MessageQueueThread messageQueueThread, CallInvokerHolderImpl callInvokerHolderImpl, AndroidUIScheduler androidUIScheduler);

    private native void invalidateCpp();

    static {
        SoLoader.loadLibrary("worklets");
    }

    protected HybridData getHybridData() {
        return this.mHybridData;
    }

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    public WorkletsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mMessageQueueThread = new WorkletsMessageQueueThread();
        this.mInvalidated = new AtomicBoolean(false);
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
    }

    @Override // com.swmansion.reanimated.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(String str) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), str, this.mMessageQueueThread, JSCallInvokerResolver.getJSCallInvokerHolder(reactApplicationContext), this.mAndroidUIScheduler);
        return true;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        if (this.mInvalidated.getAndSet(true)) {
            return;
        }
        HybridData hybridData = this.mHybridData;
        if (hybridData != null && hybridData.isValid()) {
            invalidateCpp();
        }
        this.mAndroidUIScheduler.deactivate();
    }
}
