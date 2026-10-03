package io.sentry.config;

/* JADX INFO: loaded from: classes6.dex */
final class SystemPropertyPropertiesProvider extends AbstractPropertiesProvider {
    private static final String PREFIX = "sentry.";

    public SystemPropertyPropertiesProvider() {
        super(PREFIX, System.getProperties());
    }
}
