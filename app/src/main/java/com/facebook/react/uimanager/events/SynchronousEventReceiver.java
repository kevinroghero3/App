package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Experimental")
public interface SynchronousEventReceiver {
    void receiveEvent(int i, int i2, @NotNull String str, boolean z, @Nullable WritableMap writableMap, int i3, boolean z2);
}
