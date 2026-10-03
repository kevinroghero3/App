package io.sentry.android.replay;

import java.io.Closeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface Recorder extends Closeable {
    void onConfigurationChanged(@NotNull ScreenshotRecorderConfig screenshotRecorderConfig);

    void pause();

    void reset();

    void resume();

    void start();

    void stop();
}
