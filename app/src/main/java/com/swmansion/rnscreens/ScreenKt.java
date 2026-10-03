package com.swmansion.rnscreens;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreenKt {
    public static final Screen asScreen(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (Screen) view;
    }
}
