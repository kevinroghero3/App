package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.sfmcsdk.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class EventManager {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = com.salesforce.marketingcloud.g.a("EventManager");

    public enum AuthEventType {
        LOGIN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<AuthEventType> getEntries() {
            return $ENTRIES;
        }
    }

    public static final class Companion {

        static final class a extends Lambda implements Function0<String> {
            final /* synthetic */ String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return this.b + " contains a \".\" and will be dropped.";
            }
        }

        static final class b extends Lambda implements Function0<String> {
            final /* synthetic */ String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(0);
                this.b = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return this.b + " is null, blank, starts with a \"$\", or contains a line break and will be dropped.";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Event a(Companion companion, String str, Map map, com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer producer, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt__MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                producer = com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH;
            }
            return companion.customEvent(str, map, producer);
        }

        public final String b(@NotNull String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            String string = StringsKt__StringsKt.trim((CharSequence) input).toString();
            if (!StringsKt__StringsKt.isBlank(string) && !StringsKt__StringsJVMKt.startsWith$default(string, "$", false, 2, null) && !StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "\n", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) StringUtils.CR, false, 2, (Object) null)) {
                return string;
            }
            com.salesforce.marketingcloud.g.e(com.salesforce.marketingcloud.g.a, EventManager.TAG, null, new b(input), 2, null);
            return null;
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes, @NotNull com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer producer) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            String strB = b(name);
            if (strB == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                String strA = EventManager.Companion.a(key);
                if (strA != null) {
                    linkedHashMap.put(strA, value);
                }
            }
            return new com.salesforce.marketingcloud.events.b(strB, linkedHashMap, producer);
        }

        private Companion() {
        }

        public final String a(@NotNull String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            if (StringsKt__StringsKt.contains$default((CharSequence) input, (CharSequence) ".", false, 2, (Object) null)) {
                com.salesforce.marketingcloud.g.e(com.salesforce.marketingcloud.g.a, EventManager.TAG, null, new a(input), 2, null);
                return null;
            }
            return b(input);
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return customEvent(name, attributes, com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH);
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return customEvent(name, MapsKt__MapsKt.emptyMap(), com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer.PUSH);
        }
    }

    @JvmStatic
    public static final Event customEvent(@NotNull String str) {
        return Companion.customEvent(str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "To leverage the benefits of the Unified SDK propagating your tracked events across all configured products, please use its event tracking API rather than the Push specific event tracking.", replaceWith = @ReplaceWith(expression = "SFMCSdk.track(event)", imports = {BuildConfig.LIBRARY_PACKAGE_NAME}))
    public abstract void track(@NotNull Event... eventArr);

    @JvmStatic
    public static final Event customEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        return Companion.customEvent(str, map);
    }

    @JvmStatic
    public static final Event customEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull com.salesforce.marketingcloud.sfmcsdk.components.events.Event.Producer producer) {
        return Companion.customEvent(str, map, producer);
    }
}
