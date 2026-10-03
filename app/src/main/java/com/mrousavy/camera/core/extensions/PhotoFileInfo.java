package com.mrousavy.camera.core.extensions;

import androidx.camera.core.ImageCapture;
import java.net.URI;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class PhotoFileInfo {
    private final ImageCapture.Metadata metadata;
    private final URI uri;

    public static /* synthetic */ PhotoFileInfo copy$default(PhotoFileInfo photoFileInfo, URI uri, ImageCapture.Metadata metadata, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = photoFileInfo.uri;
        }
        if ((i & 2) != 0) {
            metadata = photoFileInfo.metadata;
        }
        return photoFileInfo.copy(uri, metadata);
    }

    public final URI component1() {
        return this.uri;
    }

    public final ImageCapture.Metadata component2() {
        return this.metadata;
    }

    public final PhotoFileInfo copy(@NotNull URI uri, @NotNull ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new PhotoFileInfo(uri, metadata);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoFileInfo)) {
            return false;
        }
        PhotoFileInfo photoFileInfo = (PhotoFileInfo) obj;
        return Intrinsics.areEqual(this.uri, photoFileInfo.uri) && Intrinsics.areEqual(this.metadata, photoFileInfo.metadata);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "PhotoFileInfo(uri=" + this.uri + ", metadata=" + this.metadata + ")";
    }

    public PhotoFileInfo(@NotNull URI uri, @NotNull ImageCapture.Metadata metadata) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.uri = uri;
        this.metadata = metadata;
    }

    public final ImageCapture.Metadata getMetadata() {
        return this.metadata;
    }

    public final URI getUri() {
        return this.uri;
    }
}
