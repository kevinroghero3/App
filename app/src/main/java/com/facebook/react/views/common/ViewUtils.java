package com.facebook.react.views.common;

import android.view.View;
import com.facebook.react.R;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    private ViewUtils() {
    }

    @JvmStatic
    public static final String getTestId(@Nullable View view) {
        Object tag = view != null ? view.getTag(R.id.react_test_id) : null;
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }
}
