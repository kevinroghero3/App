package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface CloseableReferenceLeakTracker {

    /* JADX INFO: loaded from: classes4.dex */
    public interface Listener {
        void onCloseableReferenceLeak(@NotNull SharedReference<Object> sharedReference, @Nullable Throwable th);
    }

    boolean isSet();

    void setListener(@Nullable Listener listener);

    void trackCloseableReferenceLeak(@NotNull SharedReference<Object> sharedReference, @Nullable Throwable th);
}
