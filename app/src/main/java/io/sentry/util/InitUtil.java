package io.sentry.util;

import io.sentry.ManifestVersionDetector;
import io.sentry.NoopVersionDetector;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class InitUtil {
    public static boolean shouldInit(@Nullable SentryOptions sentryOptions, @NotNull SentryOptions sentryOptions2, boolean z) {
        String str;
        if (Platform.isJvm() && (sentryOptions2.getVersionDetector() instanceof NoopVersionDetector)) {
            sentryOptions2.setVersionDetector(new ManifestVersionDetector(sentryOptions2));
        }
        if (!sentryOptions2.getVersionDetector().checkForMixedVersions()) {
            return !z || sentryOptions == null || sentryOptions2.isForceInit() || sentryOptions.getInitPriority().ordinal() <= sentryOptions2.getInitPriority().ordinal();
        }
        sentryOptions2.getLogger().log(SentryLevel.ERROR, "Not initializing Sentry because mixed SDK versions have been detected.", new Object[0]);
        if (Platform.isAndroid()) {
            str = "https://docs.sentry.io/platforms/android/troubleshooting/mixed-versions";
        } else {
            str = "https://docs.sentry.io/platforms/java/troubleshooting/mixed-versions";
        }
        throw new IllegalStateException("Sentry SDK has detected a mix of versions. This is not supported and likely leads to crashes. Please always use the same version of all SDK modules (dependencies). See " + str + " for more details.");
    }
}
