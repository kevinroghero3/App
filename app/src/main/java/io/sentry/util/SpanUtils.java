package io.sentry.util;

import io.sentry.FilterString;
import io.sentry.SentryOpenTelemetryMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SpanUtils {
    private static final Map<String, Boolean> ignoredSpanDecisionsCache = new ConcurrentHashMap();

    public static List<String> ignoredSpanOriginsForOpenTelemetry(@NotNull SentryOpenTelemetryMode sentryOpenTelemetryMode) {
        ArrayList arrayList = new ArrayList();
        SentryOpenTelemetryMode sentryOpenTelemetryMode2 = SentryOpenTelemetryMode.AGENT;
        if (sentryOpenTelemetryMode2 == sentryOpenTelemetryMode || SentryOpenTelemetryMode.AGENTLESS_SPRING == sentryOpenTelemetryMode) {
            arrayList.add("auto.http.spring_jakarta.webmvc");
            arrayList.add("auto.http.spring.webmvc");
            arrayList.add("auto.spring_jakarta.webflux");
            arrayList.add("auto.spring.webflux");
            arrayList.add("auto.db.jdbc");
            arrayList.add("auto.http.spring_jakarta.webclient");
            arrayList.add("auto.http.spring.webclient");
            arrayList.add("auto.http.spring_jakarta.restclient");
            arrayList.add("auto.http.spring.restclient");
            arrayList.add("auto.http.spring_jakarta.resttemplate");
            arrayList.add("auto.http.spring.resttemplate");
            arrayList.add("auto.http.openfeign");
            arrayList.add("auto.http.ktor-client");
        }
        if (sentryOpenTelemetryMode2 == sentryOpenTelemetryMode) {
            arrayList.add("auto.graphql.graphql");
            arrayList.add("auto.graphql.graphql22");
        }
        return arrayList;
    }

    public static boolean isIgnored(@Nullable List<FilterString> list, @Nullable String str) {
        if (str == null || list == null || list.isEmpty()) {
            return false;
        }
        Map<String, Boolean> map = ignoredSpanDecisionsCache;
        if (map.containsKey(str)) {
            return map.get(str).booleanValue();
        }
        Iterator<FilterString> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().getFilterString().equalsIgnoreCase(str)) {
                ignoredSpanDecisionsCache.put(str, Boolean.TRUE);
                return true;
            }
        }
        Iterator<FilterString> it3 = list.iterator();
        while (it3.hasNext()) {
            try {
                if (it3.next().matches(str)) {
                    ignoredSpanDecisionsCache.put(str, Boolean.TRUE);
                    return true;
                }
                continue;
            } catch (Throwable unused) {
            }
        }
        ignoredSpanDecisionsCache.put(str, Boolean.FALSE);
        return false;
    }
}
