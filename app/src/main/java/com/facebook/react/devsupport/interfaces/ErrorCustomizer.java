package com.facebook.react.devsupport.interfaces;

import android.util.Pair;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface ErrorCustomizer {
    Pair<String, StackFrame[]> customizeErrorInfo(@NotNull Pair<String, StackFrame[]> pair);
}
