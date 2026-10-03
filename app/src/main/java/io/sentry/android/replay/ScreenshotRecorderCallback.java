package io.sentry.android.replay;

import android.graphics.Bitmap;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ScreenshotRecorderCallback {
    void onScreenshotRecorded(@NotNull Bitmap bitmap);

    void onScreenshotRecorded(@NotNull File file, long j);
}
