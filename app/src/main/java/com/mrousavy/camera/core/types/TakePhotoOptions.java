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
public final class TakePhotoOptions {
    public static final Companion Companion = new Companion(null);
    private final boolean enableShutterSound;
    private final OutputFile file;
    private final Flash flash;

    public static /* synthetic */ TakePhotoOptions copy$default(TakePhotoOptions takePhotoOptions, OutputFile outputFile, Flash flash, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            outputFile = takePhotoOptions.file;
        }
        if ((i & 2) != 0) {
            flash = takePhotoOptions.flash;
        }
        if ((i & 4) != 0) {
            z = takePhotoOptions.enableShutterSound;
        }
        return takePhotoOptions.copy(outputFile, flash, z);
    }

    public final OutputFile component1() {
        return this.file;
    }

    public final Flash component2() {
        return this.flash;
    }

    public final boolean component3() {
        return this.enableShutterSound;
    }

    public final TakePhotoOptions copy(@NotNull OutputFile file, @NotNull Flash flash, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(flash, "flash");
        return new TakePhotoOptions(file, flash, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TakePhotoOptions)) {
            return false;
        }
        TakePhotoOptions takePhotoOptions = (TakePhotoOptions) obj;
        return Intrinsics.areEqual(this.file, takePhotoOptions.file) && this.flash == takePhotoOptions.flash && this.enableShutterSound == takePhotoOptions.enableShutterSound;
    }

    public int hashCode() {
        return (((this.file.hashCode() * 31) + this.flash.hashCode()) * 31) + Boolean.hashCode(this.enableShutterSound);
    }

    public String toString() {
        return "TakePhotoOptions(file=" + this.file + ", flash=" + this.flash + ", enableShutterSound=" + this.enableShutterSound + ")";
    }

    public TakePhotoOptions(@NotNull OutputFile file, @NotNull Flash flash, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(flash, "flash");
        this.file = file;
        this.flash = flash;
        this.enableShutterSound = z;
    }

    public final boolean getEnableShutterSound() {
        return this.enableShutterSound;
    }

    public final OutputFile getFile() {
        return this.file;
    }

    public final Flash getFlash() {
        return this.flash;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TakePhotoOptions fromJS(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            Flash flashFromUnionValue = map.hasKey("flash") ? Flash.Companion.fromUnionValue(map.getString("flash")) : Flash.OFF;
            boolean z = map.hasKey("enableShutterSound") ? map.getBoolean("enableShutterSound") : false;
            File directory = map.hasKey("path") ? FileUtils.Companion.getDirectory(map.getString("path")) : context.getCacheDir();
            Intrinsics.checkNotNull(directory);
            return new TakePhotoOptions(new OutputFile(context, directory, ".jpg"), flashFromUnionValue, z);
        }
    }
}
