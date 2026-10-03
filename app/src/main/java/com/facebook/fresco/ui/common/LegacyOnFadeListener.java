package com.facebook.fresco.ui.common;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Please use the OnFadeListener directly", replaceWith = @ReplaceWith(expression = "OnFadeListener", imports = {"import com.facebook.fresco.ui.common.OnFadeListener"}))
public interface LegacyOnFadeListener {
    void onFadeFinished(@NotNull String str);

    void onFadeStarted(@NotNull String str);
}
