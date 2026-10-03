package com.facebook.react.views.unimplementedview;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactUnimplementedView extends LinearLayout {
    private final AppCompatTextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactUnimplementedView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.textView = appCompatTextView;
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(-1);
        setBackgroundColor(1442775040);
        setGravity(1);
        setOrientation(1);
        addView(appCompatTextView);
    }

    public final void setName$ReactAndroid_release(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.textView.setText("'" + name + "' is not Fabric compatible yet.");
    }
}
