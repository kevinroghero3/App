package com.facebook.imageformat;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageFormat {
    public static final Companion Companion = new Companion(null);
    public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
    private final String fileExtension;
    private final String name;

    public interface FormatChecker {
        ImageFormat determineFormat(@NotNull byte[] bArr, int i);

        int getHeaderSize();
    }

    public static /* synthetic */ ImageFormat copy$default(ImageFormat imageFormat, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageFormat.name;
        }
        if ((i & 2) != 0) {
            str2 = imageFormat.fileExtension;
        }
        return imageFormat.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.fileExtension;
    }

    public final ImageFormat copy(@NotNull String name, @Nullable String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ImageFormat(name, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFormat)) {
            return false;
        }
        ImageFormat imageFormat = (ImageFormat) obj;
        return Intrinsics.areEqual(this.name, imageFormat.name) && Intrinsics.areEqual(this.fileExtension, imageFormat.fileExtension);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode();
        String str = this.fileExtension;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public ImageFormat(@NotNull String name, @Nullable String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.fileExtension = str;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFileExtension() {
        return this.fileExtension;
    }

    public String toString() {
        return this.name;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
