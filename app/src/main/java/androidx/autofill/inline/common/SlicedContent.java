package androidx.autofill.inline.common;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.autofill.inline.UiVersions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SlicedContent implements UiVersions.Content {
    static final Uri INLINE_SLICE_URI = Uri.parse("inline.slice");
    public final Slice mSlice;

    public abstract PendingIntent getAttributionIntent();

    public abstract boolean isValid();

    public SlicedContent(@NonNull Slice slice) {
        this.mSlice = slice;
    }

    @Override // androidx.autofill.inline.UiVersions.Content
    public final Slice getSlice() {
        return this.mSlice;
    }

    public static String getVersion(@NonNull Slice slice) {
        return slice.getSpec().getType();
    }

    public static abstract class Builder<T extends SlicedContent> {
        public final Slice.Builder mSliceBuilder;

        public abstract T build();

        public Builder(@NonNull String str) {
            SlicedContent$Builder$$ExternalSyntheticApiModelOutline2.m();
            this.mSliceBuilder = SlicedContent$Builder$$ExternalSyntheticApiModelOutline1.m(SlicedContent.INLINE_SLICE_URI, SlicedContent$Builder$$ExternalSyntheticApiModelOutline0.m(str, 1));
        }
    }
}
