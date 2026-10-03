package com.mrousavy.camera.core.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class OutputFile {
    private final Context context;
    private final File directory;
    private final String extension;
    private final File file;

    public static /* synthetic */ OutputFile copy$default(OutputFile outputFile, Context context, File file, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            context = outputFile.context;
        }
        if ((i & 2) != 0) {
            file = outputFile.directory;
        }
        if ((i & 4) != 0) {
            str = outputFile.extension;
        }
        return outputFile.copy(context, file, str);
    }

    public final Context component1() {
        return this.context;
    }

    public final File component2() {
        return this.directory;
    }

    public final String component3() {
        return this.extension;
    }

    public final OutputFile copy(@NotNull Context context, @NotNull File directory, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return new OutputFile(context, directory, extension);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutputFile)) {
            return false;
        }
        OutputFile outputFile = (OutputFile) obj;
        return Intrinsics.areEqual(this.context, outputFile.context) && Intrinsics.areEqual(this.directory, outputFile.directory) && Intrinsics.areEqual(this.extension, outputFile.extension);
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + this.directory.hashCode()) * 31) + this.extension.hashCode();
    }

    public String toString() {
        return "OutputFile(context=" + this.context + ", directory=" + this.directory + ", extension=" + this.extension + ")";
    }

    public OutputFile(@NotNull Context context, @NotNull File directory, @NotNull String extension) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(extension, "extension");
        this.context = context;
        this.directory = directory;
        this.extension = extension;
        File fileCreateTempFile = File.createTempFile("mrousavy", extension, directory);
        this.file = fileCreateTempFile;
        String absolutePath = directory.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String absolutePath2 = context.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        if (StringsKt__StringsKt.contains$default((CharSequence) absolutePath, (CharSequence) absolutePath2, false, 2, (Object) null)) {
            fileCreateTempFile.deleteOnExit();
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final File getFile() {
        return this.file;
    }
}
