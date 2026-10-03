package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FileBinaryResource implements BinaryResource {
    public static final Companion Companion = new Companion(null);
    private final File file;

    public /* synthetic */ FileBinaryResource(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    @JvmStatic
    public static final FileBinaryResource create(@NotNull File file) {
        return Companion.create(file);
    }

    @JvmStatic
    public static final FileBinaryResource createOrNull(@Nullable File file) {
        return Companion.createOrNull(file);
    }

    private FileBinaryResource(File file) {
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        File file = this.file;
        return SentryFileInputStream.Factory.create(new FileInputStream(file), file);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.file.length();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] read() throws IOException {
        byte[] byteArray = Files.toByteArray(this.file);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return Intrinsics.areEqual(this.file, ((FileBinaryResource) obj).file);
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FileBinaryResource createOrNull(@Nullable File file) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (file != null) {
                return new FileBinaryResource(file, defaultConstructorMarker);
            }
            return null;
        }

        @JvmStatic
        public final FileBinaryResource create(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new FileBinaryResource(file, null);
        }
    }
}
