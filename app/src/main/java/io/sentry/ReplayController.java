package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ReplayController extends IReplayApi {
    void captureReplay(@Nullable Boolean bool);

    ReplayBreadcrumbConverter getBreadcrumbConverter();

    SentryId getReplayId();

    boolean isDebugMaskingOverlayEnabled();

    boolean isRecording();

    void pause();

    void resume();

    void setBreadcrumbConverter(@NotNull ReplayBreadcrumbConverter replayBreadcrumbConverter);

    void start();

    void stop();
}
