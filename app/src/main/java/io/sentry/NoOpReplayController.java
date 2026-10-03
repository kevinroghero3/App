package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpReplayController implements ReplayController {
    private static final NoOpReplayController instance = new NoOpReplayController();

    @Override // io.sentry.ReplayController
    public void captureReplay(@Nullable Boolean bool) {
    }

    @Override // io.sentry.IReplayApi
    public void disableDebugMaskingOverlay() {
    }

    @Override // io.sentry.IReplayApi
    public void enableDebugMaskingOverlay() {
    }

    @Override // io.sentry.ReplayController
    public boolean isDebugMaskingOverlayEnabled() {
        return false;
    }

    @Override // io.sentry.ReplayController
    public boolean isRecording() {
        return false;
    }

    @Override // io.sentry.ReplayController
    public void pause() {
    }

    @Override // io.sentry.ReplayController
    public void resume() {
    }

    @Override // io.sentry.ReplayController
    public void setBreadcrumbConverter(@NotNull ReplayBreadcrumbConverter replayBreadcrumbConverter) {
    }

    @Override // io.sentry.ReplayController
    public void start() {
    }

    @Override // io.sentry.ReplayController
    public void stop() {
    }

    public static NoOpReplayController getInstance() {
        return instance;
    }

    private NoOpReplayController() {
    }

    @Override // io.sentry.ReplayController
    public SentryId getReplayId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.ReplayController
    public ReplayBreadcrumbConverter getBreadcrumbConverter() {
        return NoOpReplayBreadcrumbConverter.getInstance();
    }
}
