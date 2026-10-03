package io.sentry;

import java.net.URI;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class DsnUtil {
    public static boolean urlContainsDsnHost(@Nullable SentryOptions sentryOptions, @Nullable String str) {
        URI sentryUri;
        String host;
        if (sentryOptions == null || str == null || sentryOptions.getDsn() == null || (host = (sentryUri = sentryOptions.retrieveParsedDsn().getSentryUri()).getHost()) == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = host.toLowerCase(locale);
        int port = sentryUri.getPort();
        if (port > 0) {
            return str.toLowerCase(locale).contains(lowerCase + ":" + port);
        }
        return str.toLowerCase(locale).contains(lowerCase);
    }
}
