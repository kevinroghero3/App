package com.facebook.react.internal.turbomodule.core;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeModuleSoLoader {
    public static final Companion Companion = new Companion(null);
    private static boolean isSoLibraryLoaded;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void maybeLoadSoLibrary() {
            synchronized (this) {
                if (!NativeModuleSoLoader.isSoLibraryLoaded) {
                    SoLoader.loadLibrary("turbomodulejsijni");
                    NativeModuleSoLoader.isSoLibraryLoaded = true;
                }
            }
        }
    }

    @JvmStatic
    public static final void maybeLoadSoLibrary() {
        synchronized (NativeModuleSoLoader.class) {
            Companion.maybeLoadSoLibrary();
        }
    }
}
