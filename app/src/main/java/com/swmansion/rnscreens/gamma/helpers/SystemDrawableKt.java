package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.swmansion.rnscreens.gamma.tabs.TabScreen;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemDrawableKt {
    public static final Drawable getSystemDrawableResource(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier > 0) {
            return AppCompatResources.getDrawable(context, identifier);
        }
        int identifier2 = context.getResources().getIdentifier(str, "drawable", "android");
        if (identifier2 > 0) {
            return AppCompatResources.getDrawable(context, identifier2);
        }
        SentryLogcatAdapter.w(TabScreen.TAG, "TabScreen could not resolve drawable resource with the name " + str);
        return null;
    }
}
