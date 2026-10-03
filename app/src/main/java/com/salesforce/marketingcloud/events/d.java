package com.salesforce.marketingcloud.events;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String a = com.salesforce.marketingcloud.g.a("EventUtilsKt");

    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ com.salesforce.marketingcloud.sfmcsdk.components.events.Event b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.salesforce.marketingcloud.sfmcsdk.components.events.Event event) {
            super(0);
            this.b = event;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "(" + this.b + ") returned null during conversion to Push SDK Event.";
        }
    }

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj) {
            super(0);
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert event '" + this.b + "' to Push SDK Event.";
        }
    }

    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ Event b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Event event) {
            super(0);
            this.b = event;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "(" + this.b + ") returned null during conversion to SFMC SDK Event.";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.d$d, reason: collision with other inner class name */
    static final class C0074d extends Lambda implements Function0<String> {
        final /* synthetic */ Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0074d(Object obj) {
            super(0);
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to convert event '" + this.b + "' to SFMCSdk Event.";
        }
    }

    public static final Event[] a(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return a(objArr, (EnumSet) null, (EnumSet) null, 3, (Object) null);
    }

    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] b(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return a(objArr, null, 1, null);
    }

    public static final Event[] a(@NotNull Object[] objArr, @NotNull EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer> producers) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        return a(objArr, producers, (EnumSet) null, 2, (Object) null);
    }

    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event b(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.Companion.customEvent$default(com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager.Companion, event.name(), event.attributes(), com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH, null, 8, null);
    }

    public static final Map<String, List<Object>> a(@NotNull Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return a(new LinkedHashMap(), event.attributes(), (String) null, 4, (Object) null);
    }

    public static final Event a(@NotNull com.salesforce.marketingcloud.sfmcsdk.components.events.Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return EventManager.Companion.customEvent(event.name(), event.attributes(), event.getProducer());
    }

    public static final com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] b(@NotNull Object[] objArr, @NotNull EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer> producers) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                try {
                    Event event = (Event) obj;
                    if (producers.contains(event.getProducer())) {
                        com.salesforce.marketingcloud.sfmcsdk.components.events.Event eventB = b(event);
                        if ((eventB != null ? Boolean.valueOf(arrayList.add(eventB)) : null) == null) {
                            com.salesforce.marketingcloud.g.c(com.salesforce.marketingcloud.g.a, a, null, new c(event), 2, null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Exception unused) {
                    com.salesforce.marketingcloud.g.e(com.salesforce.marketingcloud.g.a, a, null, new C0074d(obj), 2, null);
                }
            }
        }
        return (com.salesforce.marketingcloud.sfmcsdk.components.events.Event[]) arrayList.toArray(new com.salesforce.marketingcloud.sfmcsdk.components.events.Event[0]);
    }

    public static /* synthetic */ Event[] a(Object[] objArr, EnumSet enumSet, EnumSet enumSet2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.allOf(com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.class);
            Intrinsics.checkNotNullExpressionValue(enumSet, "allOf(...)");
        }
        if ((i & 2) != 0) {
            enumSet2 = EnumSet.allOf(com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Category.class);
            Intrinsics.checkNotNullExpressionValue(enumSet2, "allOf(...)");
        }
        return a(objArr, (EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer>) enumSet, (EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Category>) enumSet2);
    }

    public static final Event[] a(@NotNull Object[] objArr, @NotNull EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer> producers, @NotNull EnumSet<com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Category> categories) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(producers, "producers");
        Intrinsics.checkNotNullParameter(categories, "categories");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                try {
                    com.salesforce.marketingcloud.sfmcsdk.components.events.Event event = (com.salesforce.marketingcloud.sfmcsdk.components.events.Event) obj;
                    if (producers.contains(event.getProducer()) && categories.contains(event.getCategory())) {
                        Event eventA = a(event);
                        if ((eventA != null ? Boolean.valueOf(arrayList.add(eventA)) : null) == null) {
                            com.salesforce.marketingcloud.g.c(com.salesforce.marketingcloud.g.a, a, null, new a(event), 2, null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Exception unused) {
                    com.salesforce.marketingcloud.g.b(com.salesforce.marketingcloud.g.a, a, null, new b(obj), 2, null);
                }
            }
        }
        return (Event[]) arrayList.toArray(new Event[0]);
    }

    public static /* synthetic */ com.salesforce.marketingcloud.sfmcsdk.components.events.Event[] a(Object[] objArr, EnumSet enumSet, int i, Object obj) {
        if ((i & 1) != 0) {
            enumSet = EnumSet.allOf(com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.class);
            Intrinsics.checkNotNullExpressionValue(enumSet, "allOf(...)");
        }
        return b(objArr, enumSet);
    }

    static /* synthetic */ Map a(Map map, Object obj, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = "";
        }
        return a((Map<String, List<Object>>) map, obj, str);
    }

    private static final Map<String, List<Object>> a(Map<String, List<Object>> map, Object obj, String str) {
        try {
            if (obj instanceof List) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                return a(map, (List<Object>) TypeIntrinsics.asMutableList(obj), str);
            }
            if (!(obj instanceof Map)) {
                return map;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any, kotlin.Any>");
            return a(map, (Map<Object, Object>) TypeIntrinsics.asMutableMap(obj), str);
        } catch (Exception unused) {
            return map;
        }
    }

    private static final Map<String, List<Object>> a(Map<String, List<Object>> map, Map<Object, Object> map2, String str) {
        String lowerCase;
        for (Map.Entry<Object, Object> entry : map2.entrySet()) {
            if (!StringsKt__StringsKt.isBlank(str)) {
                String str2 = str + "." + entry.getKey();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                lowerCase = str2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                Object key = entry.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                lowerCase = ((String) key).toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            if (a(entry.getValue())) {
                map.putAll(a(map, entry.getValue(), lowerCase));
            } else {
                List<Object> list = map.get(lowerCase);
                if (list != null && !list.isEmpty()) {
                    List<Object> list2 = map.get(lowerCase);
                    if (list2 != null) {
                        list2.add(entry.getValue());
                    }
                } else {
                    map.put(lowerCase, CollectionsKt__CollectionsKt.mutableListOf(entry.getValue()));
                }
            }
        }
        return map;
    }

    private static final Map<String, List<Object>> a(Map<String, List<Object>> map, List<Object> list, String str) {
        for (Object obj : list) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (obj != null) {
                if (a(obj)) {
                    map.putAll(a(map, obj, str));
                } else {
                    List<Object> list2 = map.get(lowerCase);
                    if (list2 != null && !list2.isEmpty()) {
                        List<Object> list3 = map.get(lowerCase);
                        if (list3 != null) {
                            list3.add(obj);
                        }
                    } else {
                        map.put(lowerCase, CollectionsKt__CollectionsKt.mutableListOf(obj));
                    }
                }
            }
        }
        return map;
    }

    private static final boolean a(Object obj) {
        if (obj instanceof Map) {
            return true;
        }
        if (obj instanceof List) {
            int i = 0;
            for (Object obj2 : (Iterable) obj) {
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (obj2 != null && a(obj2)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
