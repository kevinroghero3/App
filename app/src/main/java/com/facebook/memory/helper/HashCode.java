package com.facebook.memory.helper;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class HashCode {
    public static final HashCode INSTANCE = new HashCode();

    private HashCode() {
    }

    @JvmStatic
    public static final int extend(int i, @Nullable Object obj) {
        return (i * 31) + (obj != null ? obj.hashCode() : 0);
    }
}
