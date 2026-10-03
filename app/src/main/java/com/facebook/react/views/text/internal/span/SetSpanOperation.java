package com.facebook.react.views.text.internal.span;

import android.text.SpannableStringBuilder;
import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class SetSpanOperation {
    public static final Companion Companion = new Companion(null);
    public static final int SPAN_MAX_PRIORITY = 255;
    private static final String TAG = "SetSpanOperation";
    private final int end;
    private final int start;
    public final ReactSpan what;

    public SetSpanOperation(int i, int i2, @NotNull ReactSpan what) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.start = i;
        this.end = i2;
        this.what = what;
    }

    public final void execute(@NotNull SpannableStringBuilder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (i < 0) {
            throw new IllegalStateException("Check failed.");
        }
        int i2 = this.start == 0 ? 18 : 34;
        int i3 = 255 - i;
        if (i3 < 0) {
            FLog.w(TAG, "Text tree size exceeded the limit, styling may become unpredictable");
        }
        builder.setSpan(this.what, this.start, this.end, ((Math.max(i3, 0) << 16) & 16711680) | (i2 & (-16711681)));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
