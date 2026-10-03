package com.facebook.react.devsupport;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class InspectorFlags {
    public static final InspectorFlags INSTANCE = new InspectorFlags();

    @JvmStatic
    public static final native boolean getFuseboxEnabled();

    @JvmStatic
    public static final native boolean getIsProfilingBuild();

    private InspectorFlags() {
    }

    static {
        DevSupportSoLoader.staticInit();
    }
}
