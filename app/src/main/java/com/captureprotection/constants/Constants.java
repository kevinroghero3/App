package com.captureprotection.constants;

import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class Constants {
    public static final Companion Companion = new Companion(null);
    public static final String LISTENER_EVENT_NAME = "CaptureProtectionListener";
    public static final String NAME = "CaptureProtection";
    private static final String requestPermission;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getRequestPermission() {
            return Constants.requestPermission;
        }
    }

    static {
        String str;
        if (Build.VERSION.SDK_INT >= 33) {
            str = "android.permission.READ_MEDIA_IMAGES";
        } else {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        }
        requestPermission = str;
    }
}
