package com.facebook.fresco.vito.source;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class FirstAvailableImageSource implements ImageSource {
    private final ImageSource[] imageSources;

    public static /* synthetic */ FirstAvailableImageSource copy$default(FirstAvailableImageSource firstAvailableImageSource, ImageSource[] imageSourceArr, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSourceArr = firstAvailableImageSource.imageSources;
        }
        return firstAvailableImageSource.copy(imageSourceArr);
    }

    public final ImageSource[] component1() {
        return this.imageSources;
    }

    public final FirstAvailableImageSource copy(@NotNull ImageSource[] imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new FirstAvailableImageSource(imageSources);
    }

    public String toString() {
        return "FirstAvailableImageSource(imageSources=" + Arrays.toString(this.imageSources) + ")";
    }

    public FirstAvailableImageSource(@NotNull ImageSource[] imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        this.imageSources = imageSources;
    }

    public final ImageSource[] getImageSources() {
        return this.imageSources;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(FirstAvailableImageSource.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        ImageSource[] imageSourceArr = this.imageSources;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.fresco.vito.source.FirstAvailableImageSource");
        return Arrays.equals(imageSourceArr, ((FirstAvailableImageSource) obj).imageSources);
    }

    public int hashCode() {
        return Arrays.hashCode(this.imageSources);
    }
}
