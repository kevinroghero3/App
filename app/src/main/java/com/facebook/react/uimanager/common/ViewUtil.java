package com.facebook.react.uimanager.common;

import android.view.View;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ViewUtil {
    public static final ViewUtil INSTANCE = new ViewUtil();
    public static final int NO_SURFACE_ID = -1;

    private ViewUtil() {
    }

    @JvmStatic
    public static final int getUIManagerType(int i) {
        return i % 2 == 0 ? 2 : 1;
    }

    @JvmStatic
    public static final int getUIManagerType(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return getUIManagerType(view.getId());
    }

    @JvmStatic
    public static final int getUIManagerType(int i, int i2) {
        int i3 = i2 == -1 ? 1 : 2;
        if (i3 == 1 && !isRootTag(i) && i % 2 == 0) {
            return 2;
        }
        return i3;
    }

    @Deprecated(message = "You should not check the tag of the view to inspect if it's the rootTag. Relying on this logic could make your app/library break in the future.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    @JvmStatic
    public static final boolean isRootTag(int i) {
        return i % 10 == 1;
    }
}
