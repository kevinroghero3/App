package io.sentry.android.core;

import android.content.Context;
import io.sentry.Integration;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class AnrIntegrationFactory {
    public static Integration create(@NotNull Context context, @NotNull BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 30) {
            return new AnrV2Integration(context);
        }
        return new AnrIntegration(context);
    }
}
