package com.mrousavy.camera.core.types;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.utils.FileUtils;
import com.mrousavy.camera.core.utils.OutputFile;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class RecordVideoOptions {
    public static final Companion Companion = new Companion(null);
    private final OutputFile file;
    private final VideoCodec videoCodec;

    public RecordVideoOptions(@NotNull OutputFile file, @NotNull VideoCodec videoCodec) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(videoCodec, "videoCodec");
        this.file = file;
        this.videoCodec = videoCodec;
    }

    public final OutputFile getFile() {
        return this.file;
    }

    public final VideoCodec getVideoCodec() {
        return this.videoCodec;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecordVideoOptions fromJSValue(@NotNull Context context, @NotNull ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            File directory = map.hasKey("path") ? FileUtils.Companion.getDirectory(map.getString("path")) : context.getCacheDir();
            VideoFileType videoFileTypeFromUnionValue = map.hasKey("fileType") ? VideoFileType.Companion.fromUnionValue(map.getString("fileType")) : VideoFileType.MOV;
            VideoCodec videoCodecFromUnionValue = map.hasKey("videoCodec") ? VideoCodec.Companion.fromUnionValue(map.getString("videoCodec")) : VideoCodec.H264;
            Intrinsics.checkNotNull(directory);
            return new RecordVideoOptions(new OutputFile(context, directory, videoFileTypeFromUnionValue.toExtension()), videoCodecFromUnionValue);
        }
    }
}
