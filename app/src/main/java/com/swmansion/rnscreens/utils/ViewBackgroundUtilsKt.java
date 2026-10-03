package com.swmansion.rnscreens.utils;

import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewBackgroundUtilsKt {
    public static final Integer resolveBackgroundColor(@NotNull ReactViewGroup reactViewGroup) {
        Intrinsics.checkNotNullParameter(reactViewGroup, "<this>");
        return BackgroundStyleApplicator.getBackgroundColor(reactViewGroup);
    }
}
