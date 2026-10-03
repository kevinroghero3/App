package com.reactnativekeyboardcontroller.extensions;

import android.view.ViewGroup;
import android.view.ViewParent;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewGroupKt {
    public static final void removeSelf(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewParent parent = viewGroup.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeView(viewGroup);
    }
}
