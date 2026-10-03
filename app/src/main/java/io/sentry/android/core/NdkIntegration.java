package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.IScopes;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class NdkIntegration implements Integration, Closeable {
    public static final String SENTRY_NDK_CLASS_NAME = "io.sentry.android.ndk.SentryNdk";
    private SentryAndroidOptions options;
    private final Class<?> sentryNdkClass;

    public NdkIntegration(@Nullable Class<?> cls) {
        this.sentryNdkClass = cls;
    }

    @Override // io.sentry.Integration
    public final void register(@NotNull IScopes iScopes, @NotNull SentryOptions sentryOptions) {
        Objects.requireNonNull(iScopes, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        ILogger logger = this.options.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.log(sentryLevel, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (zIsEnableNdk && this.sentryNdkClass != null) {
            if (this.options.getCacheDirPath() == null) {
                this.options.getLogger().log(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
                disableNdkIntegration(this.options);
                return;
            }
            try {
                this.sentryNdkClass.getMethod(Session.JsonKeys.INIT, SentryAndroidOptions.class).invoke(null, this.options);
                this.options.getLogger().log(sentryLevel, "NdkIntegration installed.", new Object[0]);
                IntegrationUtils.addIntegrationToSdkVersion("Ndk");
                return;
            } catch (NoSuchMethodException e) {
                disableNdkIntegration(this.options);
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to invoke the SentryNdk.init method.", e);
                return;
            } catch (Throwable th) {
                disableNdkIntegration(this.options);
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th);
                return;
            }
        }
        disableNdkIntegration(this.options);
    }

    private void disableNdkIntegration(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    Class<?> getSentryNdkClass() {
        return this.sentryNdkClass;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class<?> cls = this.sentryNdkClass;
        try {
            if (cls != null) {
                try {
                    cls.getMethod("close", null).invoke(null, null);
                    this.options.getLogger().log(SentryLevel.DEBUG, "NdkIntegration removed.", new Object[0]);
                } catch (NoSuchMethodException e) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Failed to invoke the SentryNdk.close method.", e);
                } catch (Throwable th) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Failed to close SentryNdk.", th);
                }
                disableNdkIntegration(this.options);
            }
        } catch (Throwable th2) {
            disableNdkIntegration(this.options);
            throw th2;
        }
    }
}
