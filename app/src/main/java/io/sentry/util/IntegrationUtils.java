package io.sentry.util;

import io.sentry.SentryIntegrationPackageStorage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class IntegrationUtils {
    public static void addIntegrationToSdkVersion(@NotNull String str) {
        SentryIntegrationPackageStorage.getInstance().addIntegration(str);
    }
}
