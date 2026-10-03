package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import com.swmansion.reanimated.nativeProxy.NativeProxyCommon;
import com.swmansion.worklets.JSCallInvokerResolver;
import com.swmansion.worklets.WorkletsModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class NativeProxy extends NativeProxyCommon {
    private final HybridData mHybridData;
    private final AtomicBoolean mInvalidated;

    private native HybridData initHybrid(WorkletsModule workletsModule, long j, CallInvokerHolderImpl callInvokerHolderImpl, LayoutAnimations layoutAnimations, boolean z);

    private native void invalidateCpp();

    public native boolean isAnyHandlerWaitingForEvent(String str, int i);

    public native void performOperations();

    public NativeProxy(ReactApplicationContext reactApplicationContext, WorkletsModule workletsModule) {
        super(reactApplicationContext);
        this.mInvalidated = new AtomicBoolean(false);
        CallInvokerHolderImpl jSCallInvokerHolder = JSCallInvokerResolver.getJSCallInvokerHolder(reactApplicationContext);
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(workletsModule, javaScriptContextHolder.get(), jSCallInvokerHolder, layoutAnimations, false);
        prepareLayoutAnimations(layoutAnimations);
        installJSIBindings();
    }

    @Override // com.swmansion.reanimated.nativeProxy.NativeProxyCommon
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    protected void invalidate() {
        HybridData hybridData;
        if (this.mInvalidated.getAndSet(true) || (hybridData = this.mHybridData) == null || !hybridData.isValid()) {
            return;
        }
        invalidateCpp();
    }

    public static NativeMethodsHolder createNativeMethodsHolder(LayoutAnimations layoutAnimations) {
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        return new NativeMethodsHolder() { // from class: com.swmansion.reanimated.NativeProxy.1
            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void startAnimation(int i, int i2, HashMap<String, Object> map) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    HashMap map2 = new HashMap();
                    for (String str : map.keySet()) {
                        String string = map.get(str).toString();
                        if (str.endsWith("TransformMatrix")) {
                            map2.put(str, Utils.simplifyStringNumbersList(string));
                        } else {
                            map2.put(str, string);
                        }
                    }
                    layoutAnimations2.startAnimationForTag(i, i2, map2);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean shouldAnimateExiting(int i, boolean z) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.shouldAnimateExiting(i, z);
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean isLayoutAnimationEnabled() {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.isLayoutAnimationEnabled();
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public boolean hasAnimation(int i, int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.hasAnimationForTag(i, i2);
                }
                return false;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void clearAnimationConfig(int i) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.clearAnimationConfigForTag(i);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void cancelAnimation(int i) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.cancelAnimationForTag(i);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public int findPrecedingViewTagForTransition(int i) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.findPrecedingViewTagForTransition(i);
                }
                return -1;
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public void checkDuplicateSharedTag(int i, int i2) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    layoutAnimations2.checkDuplicateSharedTag(i, i2);
                }
            }

            @Override // com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder
            public int[] getSharedGroup(int i) {
                LayoutAnimations layoutAnimations2 = (LayoutAnimations) weakReference.get();
                if (layoutAnimations2 != null) {
                    return layoutAnimations2.getSharedGroup(i);
                }
                return new int[0];
            }
        };
    }
}
