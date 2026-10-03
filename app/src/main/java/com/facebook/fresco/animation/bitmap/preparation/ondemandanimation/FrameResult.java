package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FrameResult {
    private final CloseableReference<Bitmap> bitmapRef;
    private final FrameType type;

    public enum FrameType {
        SUCCESS,
        NEAREST,
        MISSING;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<FrameType> getEntries() {
            return $ENTRIES;
        }
    }

    public FrameResult(@Nullable CloseableReference<Bitmap> closeableReference, @NotNull FrameType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.bitmapRef = closeableReference;
        this.type = type;
    }

    public final CloseableReference<Bitmap> getBitmapRef() {
        return this.bitmapRef;
    }

    public final FrameType getType() {
        return this.type;
    }
}
