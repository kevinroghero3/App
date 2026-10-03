package com.reactnativekeyboardcontroller.extensions;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsAnimationCompatKt {
    public static final boolean isKeyboardAnimation(@NotNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationCompat, "<this>");
        return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0;
    }
}
