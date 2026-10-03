package com.facebook.internal;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class InternalSettings {
    public static final InternalSettings INSTANCE = new InternalSettings();
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String customUserAgent;

    @JvmStatic
    public static /* synthetic */ void isUnityApp$annotations() {
    }

    private InternalSettings() {
    }

    @JvmStatic
    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    @JvmStatic
    public static final void setCustomUserAgent(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        customUserAgent = value;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return str != null && StringsKt__StringsJVMKt.startsWith$default(str, UNITY_PREFIX, false, 2, null);
    }
}
