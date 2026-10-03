package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class BindingsInstaller {
    private static final Companion Companion = new Companion(null);
    private final HybridData mHybridData;

    /* JADX INFO: loaded from: classes2.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BindingsInstaller(@Nullable HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    static {
        SoLoader.loadLibrary("rninstance");
    }
}
