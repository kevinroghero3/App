package com.facebook.react.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ChoreographerProvider {

    /* JADX INFO: loaded from: classes2.dex */
    public interface Choreographer {
        void postFrameCallback(@NotNull android.view.Choreographer.FrameCallback frameCallback);

        void removeFrameCallback(@NotNull android.view.Choreographer.FrameCallback frameCallback);
    }

    Choreographer getChoreographer();
}
