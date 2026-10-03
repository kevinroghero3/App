package com.zoontek.rnbootsplash;

import android.app.Activity;
import androidx.annotation.StyleRes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNBootSplash {
    public static final RNBootSplash INSTANCE = new RNBootSplash();

    private RNBootSplash() {
    }

    @JvmStatic
    public static final void init(@NotNull Activity activity, @StyleRes int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RNBootSplashModuleImpl.INSTANCE.init$react_native_bootsplash_release(activity, i);
    }
}
