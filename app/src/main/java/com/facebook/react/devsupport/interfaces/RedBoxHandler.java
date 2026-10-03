package com.facebook.react.devsupport.interfaces;

import android.content.Context;
import android.text.SpannedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface RedBoxHandler {

    /* JADX INFO: loaded from: classes2.dex */
    public interface ReportCompletedListener {
        void onReportError(@Nullable SpannedString spannedString);

        void onReportSuccess(@Nullable SpannedString spannedString);
    }

    void handleRedbox(@Nullable String str, @NotNull StackFrame[] stackFrameArr, @NotNull ErrorType errorType);

    boolean isReportEnabled();

    void reportRedbox(@NotNull Context context, @NotNull String str, @NotNull StackFrame[] stackFrameArr, @NotNull String str2, @NotNull ReportCompletedListener reportCompletedListener);
}
