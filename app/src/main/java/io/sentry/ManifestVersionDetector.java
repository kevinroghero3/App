package io.sentry;

import io.sentry.internal.ManifestVersionReader;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ManifestVersionDetector implements IVersionDetector {
    private final SentryOptions options;

    public ManifestVersionDetector(@NotNull SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // io.sentry.IVersionDetector
    public boolean checkForMixedVersions() {
        ManifestVersionReader.getInstance().readManifestFiles();
        return SentryIntegrationPackageStorage.getInstance().checkForMixedVersions(this.options.getFatalLogger());
    }
}
