package com.facebook.react.defaults;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSoLoader {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void maybeLoadSoLibrary() {
            synchronized (this) {
                SoLoader.loadLibrary("react_newarchdefaults");
                try {
                    SoLoader.loadLibrary("appmodules");
                } catch (UnsatisfiedLinkError unused) {
                }
            }
        }
    }

    @JvmStatic
    public static final void maybeLoadSoLibrary() {
        synchronized (DefaultSoLoader.class) {
            Companion.maybeLoadSoLibrary();
        }
    }
}
