package com.reactnativekeyboardcontroller.extensions;

import android.graphics.Rect;
import android.view.View;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewKt {
    private static final int[] tmpIntArr = new int[2];

    public static final void requestApplyInsetsWhenAttached(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.reactnativekeyboardcontroller.extensions.ViewKt.requestApplyInsetsWhenAttached.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    v.removeOnAttachStateChangeListener(this);
                    v.requestApplyInsets();
                }
            });
        }
    }

    public static final void copyBoundsInWindow(@NotNull View view, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (view.isAttachedToWindow()) {
            rect.set(0, 0, view.getWidth(), view.getHeight());
            int[] iArr = tmpIntArr;
            view.getLocationInWindow(iArr);
            rect.offset(iArr[0], iArr[1]);
            return;
        }
        Logger.w$default(Logger.INSTANCE, "View.copyBoundsInWindow", "Can not copy bounds as view is not attached to window", null, 4, null);
    }

    public static final int[] getScreenLocation(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }
}
