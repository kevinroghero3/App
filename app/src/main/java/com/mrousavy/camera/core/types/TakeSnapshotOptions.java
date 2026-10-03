package com.mrousavy.camera.core.types;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.utils.FileUtils;
import com.mrousavy.camera.core.utils.OutputFile;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class TakeSnapshotOptions {
    public static final Companion Companion = new Companion(null);
    private final OutputFile file;
    private final int quality;

    public static /* synthetic */ TakeSnapshotOptions copy$default(TakeSnapshotOptions takeSnapshotOptions, OutputFile outputFile, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            outputFile = takeSnapshotOptions.file;
        }
        if ((i2 & 2) != 0) {
            i = takeSnapshotOptions.quality;
        }
        return takeSnapshotOptions.copy(outputFile, i);
    }

    public final OutputFile component1() {
        return this.file;
    }

    public final int component2() {
        return this.quality;
    }

    public final TakeSnapshotOptions copy(@NotNull OutputFile file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new TakeSnapshotOptions(file, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TakeSnapshotOptions)) {
            return false;
        }
        TakeSnapshotOptions takeSnapshotOptions = (TakeSnapshotOptions) obj;
        return Intrinsics.areEqual(this.file, takeSnapshotOptions.file) && this.quality == takeSnapshotOptions.quality;
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + Integer.hashCode(this.quality);
    }

    public String toString() {
        return "TakeSnapshotOptions(file=" + this.file + ", quality=" + this.quality + ")";
    }

    public TakeSnapshotOptions(@NotNull OutputFile file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.quality = i;
    }

    public final OutputFile getFile() {
        return this.file;
    }

    public final int getQuality() {
        return this.quality;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TakeSnapshotOptions fromJSValue(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            int i = map.hasKey("quality") ? map.getInt("quality") : 100;
            File directory = map.hasKey("path") ? FileUtils.Companion.getDirectory(map.getString("path")) : context.getCacheDir();
            Intrinsics.checkNotNull(directory);
            return new TakeSnapshotOptions(new OutputFile(context, directory, ".jpg"), i);
        }
    }
}
