package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class JSCInstance extends JSRuntimeFactory {
    private static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HybridData initHybrid();

    /* JADX INFO: loaded from: classes2.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final HybridData initHybrid() {
            return JSCInstance.initHybrid();
        }

        private Companion() {
        }
    }

    public JSCInstance() {
        super(Companion.initHybrid());
    }

    static {
        SoLoader.loadLibrary("jscinstance");
    }
}
