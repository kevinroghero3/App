package com.swmansion.rnscreens.ext;

import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentExtKt {
    public static final ScreenStackFragment asScreenStackFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return (ScreenStackFragment) fragment;
    }
}
