package com.facebook.react.runtime.hermes;

import com.facebook.jni.HybridData;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class HermesInstance extends JSRuntimeFactory {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    protected static final native HybridData initHybrid(boolean z);

    public HermesInstance(boolean z) {
        super(initHybrid(z));
    }

    public HermesInstance() {
        this(false);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        protected final HybridData initHybrid(boolean z) {
            return HermesInstance.initHybrid(z);
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("hermesinstancejni");
    }
}
