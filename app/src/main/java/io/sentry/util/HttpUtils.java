package io.sentry.util;

import com.transistorsoft.locationmanager.location.TSLocationManager;
import io.sentry.HttpStatusCodeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class HttpUtils {
    public static final String COOKIE_HEADER_NAME = "Cookie";
    private static final List<String> SENSITIVE_HEADERS = Arrays.asList("X-FORWARDED-FOR", "AUTHORIZATION", "COOKIE", "SET-COOKIE", "X-API-KEY", "X-REAL-IP", "REMOTE-ADDR", "FORWARDED", "PROXY-AUTHORIZATION", "X-CSRF-TOKEN", "X-CSRFTOKEN", "X-XSRF-TOKEN");
    private static final List<String> SECURITY_COOKIES = Arrays.asList("JSESSIONID", "JSESSIONIDSSO", "JSSOSESSIONID", "SESSIONID", "SID", "CSRFTOKEN", "XSRF-TOKEN");
    private static final HttpStatusCodeRange CLIENT_ERROR_STATUS_CODES = new HttpStatusCodeRange(400, TSLocationManager.LOCATION_ERROR_CANCELLED);
    private static final HttpStatusCodeRange SEVER_ERROR_STATUS_CODES = new HttpStatusCodeRange(500, HttpStatusCodeRange.DEFAULT_MAX);

    public static boolean containsSensitiveHeader(@NotNull String str) {
        return SENSITIVE_HEADERS.contains(str.toUpperCase(Locale.ROOT));
    }

    public static List<String> filterOutSecurityCookiesFromHeader(@Nullable Enumeration<String> enumeration, @Nullable String str, @Nullable List<String> list) {
        if (enumeration == null) {
            return null;
        }
        return filterOutSecurityCookiesFromHeader(Collections.list(enumeration), str, list);
    }

    public static List<String> filterOutSecurityCookiesFromHeader(@Nullable List<String> list, @Nullable String str, @Nullable List<String> list2) {
        if (list == null) {
            return null;
        }
        if (str != null && !"Cookie".equalsIgnoreCase(str)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(filterOutSecurityCookies(it2.next(), list2));
        }
        return arrayList;
    }

    public static String filterOutSecurityCookies(@Nullable String str, @Nullable List<String> list) {
        if (str == null) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(";", -1);
            StringBuilder sb = new StringBuilder();
            int length = strArrSplit.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                String str2 = strArrSplit[i];
                if (!z) {
                    sb.append(";");
                }
                String str3 = str2.split("=", -1)[0];
                if (isSecurityCookie(str3.trim(), list)) {
                    sb.append(str3 + "=" + UrlUtils.SENSITIVE_DATA_SUBSTITUTE);
                } else {
                    sb.append(str2);
                }
                i++;
                z = false;
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isSecurityCookie(@NotNull String str, @Nullable List<String> list) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if (SECURITY_COOKIES.contains(upperCase)) {
            return true;
        }
        if (list == null) {
            return false;
        }
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().toUpperCase(Locale.ROOT).equals(upperCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHttpClientError(int i) {
        return CLIENT_ERROR_STATUS_CODES.isInRange(i);
    }

    public static boolean isHttpServerError(int i) {
        return SEVER_ERROR_STATUS_CODES.isInRange(i);
    }
}
