package com.facebook.react.devsupport;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowOverlayCompat {
    public static final WindowOverlayCompat INSTANCE = new WindowOverlayCompat();
    private static final int TYPE_APPLICATION_OVERLAY = 2038;
    public static final int TYPE_SYSTEM_OVERLAY;

    public static /* synthetic */ void getTYPE_SYSTEM_OVERLAY$annotations() {
    }

    private WindowOverlayCompat() {
    }

    static {
        TYPE_SYSTEM_OVERLAY = Build.VERSION.SDK_INT < 26 ? 2006 : TYPE_APPLICATION_OVERLAY;
    }
}
