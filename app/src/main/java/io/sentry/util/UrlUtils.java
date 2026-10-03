package io.sentry.util;

import io.sentry.ISpan;
import io.sentry.SpanDataConvention;
import io.sentry.protocol.Request;
import java.net.URI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class UrlUtils {
    public static final String SENSITIVE_DATA_SUBSTITUTE = "[Filtered]";

    public static UrlDetails parseNullable(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return parse(str);
    }

    public static UrlDetails parse(@NotNull String str) {
        String str2;
        try {
            URI uri = new URI(str);
            if (uri.isAbsolute() && !isValidAbsoluteUrl(uri)) {
                return new UrlDetails(null, null, null);
            }
            String rawPath = "";
            if (uri.getScheme() == null) {
                str2 = "";
            } else {
                str2 = uri.getScheme() + "://";
            }
            String rawAuthority = uri.getRawAuthority() == null ? "" : uri.getRawAuthority();
            if (uri.getRawPath() != null) {
                rawPath = uri.getRawPath();
            }
            return new UrlDetails(str2 + filterUserInfo(rawAuthority) + rawPath, uri.getRawQuery(), uri.getRawFragment());
        } catch (Exception unused) {
            return new UrlDetails(null, null, null);
        }
    }

    private static boolean isValidAbsoluteUrl(@NotNull URI uri) {
        try {
            uri.toURL();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String filterUserInfo(@NotNull String str) {
        if (!str.contains("@")) {
            return str;
        }
        boolean zStartsWith = str.startsWith("@");
        String str2 = SENSITIVE_DATA_SUBSTITUTE;
        if (zStartsWith) {
            return SENSITIVE_DATA_SUBSTITUTE + str;
        }
        if (str.substring(0, str.indexOf(64)).contains(":")) {
            str2 = "[Filtered]:[Filtered]";
        }
        return str2 + str.substring(str.indexOf(64));
    }

    public static final class UrlDetails {
        private final String fragment;
        private final String query;
        private final String url;

        public UrlDetails(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.url = str;
            this.query = str2;
            this.fragment = str3;
        }

        public String getUrl() {
            return this.url;
        }

        public String getUrlOrFallback() {
            String str = this.url;
            return str == null ? "unknown" : str;
        }

        public String getQuery() {
            return this.query;
        }

        public String getFragment() {
            return this.fragment;
        }

        public void applyToRequest(@Nullable Request request) {
            if (request == null) {
                return;
            }
            request.setUrl(this.url);
            request.setQueryString(this.query);
            request.setFragment(this.fragment);
        }

        public void applyToSpan(@Nullable ISpan iSpan) {
            if (iSpan == null) {
                return;
            }
            String str = this.query;
            if (str != null) {
                iSpan.setData(SpanDataConvention.HTTP_QUERY_KEY, str);
            }
            String str2 = this.fragment;
            if (str2 != null) {
                iSpan.setData(SpanDataConvention.HTTP_FRAGMENT_KEY, str2);
            }
        }
    }
}
