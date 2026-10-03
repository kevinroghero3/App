package io.sentry.android.replay;

import com.facebook.react.uimanager.ViewProps;
import io.sentry.Breadcrumb;
import io.sentry.ReplayBreadcrumbConverter;
import io.sentry.SentryLevel;
import io.sentry.SpanDataConvention;
import io.sentry.protocol.Device;
import io.sentry.protocol.Response;
import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultReplayBreadcrumbConverter implements ReplayBreadcrumbConverter {
    private static final HashSet<String> supportedNetworkData;
    private String lastConnectivityState;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<Regex> snakecasePattern$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Regex>() { // from class: io.sentry.android.replay.DefaultReplayBreadcrumbConverter$Companion$snakecasePattern$2
        @Override // kotlin.jvm.functions.Function0
        public final Regex invoke() {
            return new Regex("_[a-z]");
        }
    });

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Regex getSnakecasePattern() {
            return (Regex) DefaultReplayBreadcrumbConverter.snakecasePattern$delegate.getValue();
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(Response.JsonKeys.STATUS_CODE);
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add(SpanDataConvention.HTTP_RESPONSE_CONTENT_LENGTH_KEY);
        hashSet.add("http.request_content_length");
        supportedNetworkData = hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00eb  */
    @Override // io.sentry.ReplayBreadcrumbConverter
    public RRWebEvent convert(@NotNull Breadcrumb breadcrumb) {
        String message;
        SentryLevel level;
        Object obj;
        String strSubstringAfterLast$default;
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Intrinsics.areEqual(breadcrumb.getCategory(), "http")) {
            if (isValidForRRWebSpan(breadcrumb)) {
                return toRRWebSpanEvent(breadcrumb);
            }
            return null;
        }
        String category = "navigation";
        if (Intrinsics.areEqual(breadcrumb.getType(), "navigation") && Intrinsics.areEqual(breadcrumb.getCategory(), "app.lifecycle")) {
            category = "app." + breadcrumb.getData().get("state");
        } else if (Intrinsics.areEqual(breadcrumb.getType(), "navigation") && Intrinsics.areEqual(breadcrumb.getCategory(), "device.orientation")) {
            category = breadcrumb.getCategory();
            Intrinsics.checkNotNull(category);
            Object obj2 = breadcrumb.getData().get(ViewProps.POSITION);
            if (!Intrinsics.areEqual(obj2, "landscape") && !Intrinsics.areEqual(obj2, "portrait")) {
                return null;
            }
            linkedHashMap.put(ViewProps.POSITION, obj2);
        } else if (Intrinsics.areEqual(breadcrumb.getType(), "navigation")) {
            if (Intrinsics.areEqual(breadcrumb.getData().get("state"), "resumed")) {
                Object obj3 = breadcrumb.getData().get("screen");
                String str = obj3 instanceof String ? (String) obj3 : null;
                if (str != null) {
                    strSubstringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null);
                } else {
                    strSubstringAfterLast$default = null;
                }
            } else {
                Map<String, Object> data = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data, "breadcrumb.data");
                if (data.containsKey("to")) {
                    Object obj4 = breadcrumb.getData().get("to");
                    if (obj4 instanceof String) {
                        strSubstringAfterLast$default = (String) obj4;
                    } else {
                        strSubstringAfterLast$default = null;
                    }
                } else {
                    strSubstringAfterLast$default = null;
                }
            }
            if (strSubstringAfterLast$default == null) {
                return null;
            }
            linkedHashMap.put("to", strSubstringAfterLast$default);
        } else {
            if (Intrinsics.areEqual(breadcrumb.getCategory(), "ui.click")) {
                Object obj5 = breadcrumb.getData().get("view.id");
                if (obj5 == null && (obj5 = breadcrumb.getData().get("view.tag")) == null) {
                    obj5 = breadcrumb.getData().get("view.class");
                }
                message = obj5 instanceof String ? (String) obj5 : null;
                if (message == null) {
                    return null;
                }
                Map<String, Object> data2 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "breadcrumb.data");
                linkedHashMap.putAll(data2);
                category = "ui.tap";
                level = null;
            } else if (Intrinsics.areEqual(breadcrumb.getType(), "system") && Intrinsics.areEqual(breadcrumb.getCategory(), "network.event")) {
                if (!Intrinsics.areEqual(breadcrumb.getData().get("action"), "NETWORK_LOST")) {
                    Map<String, Object> data3 = breadcrumb.getData();
                    Intrinsics.checkNotNullExpressionValue(data3, "breadcrumb.data");
                    if (data3.containsKey("network_type")) {
                        Object obj6 = breadcrumb.getData().get("network_type");
                        String str2 = obj6 instanceof String ? (String) obj6 : null;
                        obj = (str2 == null || str2.length() == 0) ? "offline" : breadcrumb.getData().get("network_type");
                    }
                    return null;
                }
                linkedHashMap.put("state", obj);
                if (Intrinsics.areEqual(this.lastConnectivityState, linkedHashMap.get("state"))) {
                    return null;
                }
                Object obj7 = linkedHashMap.get("state");
                this.lastConnectivityState = obj7 instanceof String ? (String) obj7 : null;
                category = "device.connectivity";
            } else if (Intrinsics.areEqual(breadcrumb.getData().get("action"), "BATTERY_CHANGED")) {
                Map<String, Object> data4 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data4, "breadcrumb.data");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, Object> entry : data4.entrySet()) {
                    String key = entry.getKey();
                    if (Intrinsics.areEqual(key, "level") || Intrinsics.areEqual(key, Device.JsonKeys.CHARGING)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                linkedHashMap.putAll(linkedHashMap2);
                category = "device.battery";
            } else {
                category = breadcrumb.getCategory();
                message = breadcrumb.getMessage();
                level = breadcrumb.getLevel();
                Map<String, Object> data5 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data5, "breadcrumb.data");
                linkedHashMap.putAll(data5);
            }
            if (category == null && category.length() != 0) {
                RRWebBreadcrumbEvent rRWebBreadcrumbEvent = new RRWebBreadcrumbEvent();
                rRWebBreadcrumbEvent.setTimestamp(breadcrumb.getTimestamp().getTime());
                rRWebBreadcrumbEvent.setBreadcrumbTimestamp(breadcrumb.getTimestamp().getTime() / 1000.0d);
                rRWebBreadcrumbEvent.setBreadcrumbType("default");
                rRWebBreadcrumbEvent.setCategory(category);
                rRWebBreadcrumbEvent.setMessage(message);
                rRWebBreadcrumbEvent.setLevel(level);
                rRWebBreadcrumbEvent.setData(linkedHashMap);
                return rRWebBreadcrumbEvent;
            }
        }
        message = null;
        level = null;
        return category == null ? null : null;
    }

    private final boolean isValidForRRWebSpan(Breadcrumb breadcrumb) {
        Object obj = breadcrumb.getData().get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null && str.length() != 0) {
            Map<String, Object> data = breadcrumb.getData();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            if (data.containsKey(SpanDataConvention.HTTP_START_TIMESTAMP)) {
                Map<String, Object> data2 = breadcrumb.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "data");
                if (data2.containsKey(SpanDataConvention.HTTP_END_TIMESTAMP)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String snakeToCamelCase(String str) {
        return Companion.getSnakecasePattern().replace(str, new Function1<MatchResult, CharSequence>() { // from class: io.sentry.android.replay.DefaultReplayBreadcrumbConverter.snakeToCamelCase.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(@NotNull MatchResult it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                String upperCase = String.valueOf(StringsKt___StringsKt.last(it2.getValue())).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return upperCase;
            }
        });
    }

    private final RRWebSpanEvent toRRWebSpanEvent(Breadcrumb breadcrumb) {
        double dLongValue;
        double dLongValue2;
        Object obj = breadcrumb.getData().get(SpanDataConvention.HTTP_START_TIMESTAMP);
        Object obj2 = breadcrumb.getData().get(SpanDataConvention.HTTP_END_TIMESTAMP);
        RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
        rRWebSpanEvent.setTimestamp(breadcrumb.getTimestamp().getTime());
        rRWebSpanEvent.setOp("resource.http");
        Object obj3 = breadcrumb.getData().get("url");
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        rRWebSpanEvent.setDescription((String) obj3);
        if (obj instanceof Double) {
            dLongValue = ((Number) obj).doubleValue();
        } else {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            dLongValue = ((Long) obj).longValue();
        }
        rRWebSpanEvent.setStartTimestamp(dLongValue / 1000.0d);
        if (obj2 instanceof Double) {
            dLongValue2 = ((Number) obj2).doubleValue();
        } else {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            dLongValue2 = ((Long) obj2).longValue();
        }
        rRWebSpanEvent.setEndTimestamp(dLongValue2 / 1000.0d);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Object> data = breadcrumb.getData();
        Intrinsics.checkNotNullExpressionValue(data, "breadcrumb.data");
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (supportedNetworkData.contains(key)) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(snakeToCamelCase(StringsKt__StringsKt.substringAfter$default(StringsKt__StringsJVMKt.replace$default(key, "content_length", "body_size", false, 4, (Object) null), ".", (String) null, 2, (Object) null)), value);
            }
        }
        rRWebSpanEvent.setData(linkedHashMap);
        return rRWebSpanEvent;
    }
}
