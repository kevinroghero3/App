package com.facebook.react.devsupport;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class DevSupportSoLoader {
    public static final DevSupportSoLoader INSTANCE = new DevSupportSoLoader();
    private static volatile boolean didInit;

    private DevSupportSoLoader() {
    }

    @JvmStatic
    public static final void staticInit() {
        synchronized (DevSupportSoLoader.class) {
            if (didInit) {
                return;
            }
            SoLoader.loadLibrary("react_devsupportjni");
            didInit = true;
        }
    }
}
