package com.facebook.react.internal;

import com.facebook.systrace.Systrace;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class SystraceSection implements AutoCloseable {
    public SystraceSection(@NotNull String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Systrace.beginSection(0L, sectionName);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Systrace.endSection(0L);
    }
}
