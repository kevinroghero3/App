package com.guhungry.photomanipulator.helper;

import android.os.SystemClock;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidConcreteFile implements AndroidFile {
    public static int MediaControllerCompatTransportControlsApi23;
    public static int MediaControllerCompatTransportControlsApi24;

    @Override // com.guhungry.photomanipulator.helper.AndroidFile
    public File createTempFile(@NotNull String prefix, @Nullable String str, @Nullable File file) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "createTempFile(prefix, suffix, directory)");
        return fileCreateTempFile;
    }

    @Override // com.guhungry.photomanipulator.helper.AndroidFile
    public FileOutputStream makeFileOutputStream(@NotNull File target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return SentryFileOutputStream.Factory.create(new FileOutputStream(target), target);
    }

    public static int onReceiveResult() {
        int i = MediaControllerCompatTransportControlsApi23;
        int i2 = i % 9250795;
        MediaControllerCompatTransportControlsApi23 = i + 1;
        if (i2 != 0) {
            return MediaControllerCompatTransportControlsApi24;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        MediaControllerCompatTransportControlsApi24 = iElapsedRealtime;
        return iElapsedRealtime;
    }
}
