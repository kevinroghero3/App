package io.sentry.react;

import com.facebook.react.bridge.ReadableMap;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class RNSentryBreadcrumb {
    private RNSentryBreadcrumb() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static String getCurrentScreenFrom(ReadableMap readableMap) {
        String string = readableMap.hasKey("category") ? readableMap.getString("category") : null;
        if (string == null || !"navigation".equals(string)) {
            return null;
        }
        ReadableMap map = readableMap.hasKey("data") ? readableMap.getMap("data") : null;
        if (map == null) {
            return null;
        }
        try {
            if (map.hasKey("to")) {
                return map.getString("to");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0090  */
    public static Breadcrumb fromMap(ReadableMap readableMap) {
        byte b;
        Breadcrumb breadcrumb = new Breadcrumb();
        if (readableMap.hasKey("message")) {
            breadcrumb.setMessage(readableMap.getString("message"));
        }
        if (readableMap.hasKey("type")) {
            breadcrumb.setType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("category")) {
            breadcrumb.setCategory(readableMap.getString("category"));
        }
        if (readableMap.hasKey("origin")) {
            breadcrumb.setOrigin(readableMap.getString("origin"));
        } else {
            breadcrumb.setOrigin("react-native");
        }
        if (readableMap.hasKey("level")) {
            switch (readableMap.getString("level")) {
                case "info":
                    b = 4;
                    break;
                case "debug":
                    b = 2;
                    break;
                case "error":
                    b = 3;
                    break;
                case "fatal":
                    b = 0;
                    break;
                case "warning":
                    b = 1;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                breadcrumb.setLevel(SentryLevel.FATAL);
            } else if (b == 1) {
                breadcrumb.setLevel(SentryLevel.WARNING);
            } else if (b == 2) {
                breadcrumb.setLevel(SentryLevel.DEBUG);
            } else if (b == 3) {
                breadcrumb.setLevel(SentryLevel.ERROR);
            } else {
                breadcrumb.setLevel(SentryLevel.INFO);
            }
        }
        if (readableMap.hasKey("data")) {
            for (Map.Entry<String, Object> entry : readableMap.getMap("data").toHashMap().entrySet()) {
                if (entry.getValue() != null) {
                    breadcrumb.setData(entry.getKey(), entry.getValue());
                }
            }
        }
        return breadcrumb;
    }
}
