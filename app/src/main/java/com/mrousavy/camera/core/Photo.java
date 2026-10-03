package com.mrousavy.camera.core;

import com.mrousavy.camera.core.types.Orientation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Photo {
    private final int height;
    private final boolean isMirrored;
    private final Orientation orientation;
    private final String path;
    private final int width;

    public static /* synthetic */ Photo copy$default(Photo photo, String str, int i, int i2, Orientation orientation, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = photo.path;
        }
        if ((i3 & 2) != 0) {
            i = photo.width;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = photo.height;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            orientation = photo.orientation;
        }
        Orientation orientation2 = orientation;
        if ((i3 & 16) != 0) {
            z = photo.isMirrored;
        }
        return photo.copy(str, i4, i5, orientation2, z);
    }

    public final String component1() {
        return this.path;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final Orientation component4() {
        return this.orientation;
    }

    public final boolean component5() {
        return this.isMirrored;
    }

    public final Photo copy(@NotNull String path, int i, int i2, @NotNull Orientation orientation, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new Photo(path, i, i2, orientation, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) obj;
        return Intrinsics.areEqual(this.path, photo.path) && this.width == photo.width && this.height == photo.height && this.orientation == photo.orientation && this.isMirrored == photo.isMirrored;
    }

    public int hashCode() {
        return (((((((this.path.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.orientation.hashCode()) * 31) + Boolean.hashCode(this.isMirrored);
    }

    public String toString() {
        return "Photo(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", isMirrored=" + this.isMirrored + ")";
    }

    public Photo(@NotNull String path, int i, int i2, @NotNull Orientation orientation, boolean z) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.path = path;
        this.width = i;
        this.height = i2;
        this.orientation = orientation;
        this.isMirrored = z;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isMirrored() {
        return this.isMirrored;
    }
}
