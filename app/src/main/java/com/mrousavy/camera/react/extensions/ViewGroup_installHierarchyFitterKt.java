package com.mrousavy.camera.react.extensions;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewGroup_installHierarchyFitterKt {
    public static final void installHierarchyFitter(@NotNull final ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.mrousavy.camera.react.extensions.ViewGroup_installHierarchyFitterKt.installHierarchyFitter.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), 1073741824));
                }
                if (view != null) {
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                }
            }
        });
    }
}
