package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class EventManager {
    public static final String TAG = "~$EventManager";
    private final String moduleName;
    public static final Companion Companion = new Companion(null);
    private static final List<EventSubscriber> subscribers = new ArrayList();

    @JvmStatic
    public static final Event customEvent(@NotNull String str) {
        return Companion.customEvent(str);
    }

    @JvmStatic
    public static final Event customEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        return Companion.customEvent(str, map);
    }

    @JvmStatic
    public static final Event customEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull Event.Producer producer) {
        return Companion.customEvent(str, map, producer);
    }

    @JvmStatic
    public static final Event customEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull Event.Producer producer, @NotNull Event.Category category) {
        return Companion.customEvent(str, map, producer, category);
    }

    public EventManager(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.moduleName = moduleName;
    }

    public static final class Companion {
        public static int MediaControllerCompatApi23TransportControls;
        public static int toLegacyStreamType;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return customEvent$default(this, name, null, null, null, 14, null);
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return customEvent$default(this, name, attributes, null, null, 12, null);
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes, @NotNull Event.Producer producer) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            return customEvent$default(this, name, attributes, producer, null, 8, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Event customEvent$default(Companion companion, String str, Map map, Event.Producer producer, Event.Category category, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt__MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                producer = Event.Producer.SFMC_SDK;
            }
            if ((i & 8) != 0) {
                category = Event.Category.ENGAGEMENT;
            }
            return companion.customEvent(str, map, producer, category);
        }

        @JvmStatic
        public final Event customEvent(@NotNull String name, @NotNull Map<String, ? extends Object> attributes, @NotNull Event.Producer producer, @NotNull Event.Category category) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(producer, "producer");
            Intrinsics.checkNotNullParameter(category, "category");
            String validatedName$default = getValidatedName$default(this, name, null, 2, null);
            if (validatedName$default == null) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
                String validatedAttributeKey$default = getValidatedAttributeKey$default(EventManager.Companion, entry.getKey(), null, 2, null);
                if (validatedAttributeKey$default != null) {
                    linkedHashMap.put(validatedAttributeKey$default, entry.getValue());
                }
            }
            return new CustomEvent(validatedName$default, linkedHashMap, producer, category);
        }

        public final void publish$sfmcsdk_release(@NotNull SdkExecutors executors, @NotNull final Event... events) {
            Intrinsics.checkNotNullParameter(executors, "executors");
            Intrinsics.checkNotNullParameter(events, "events");
            if (ArraysKt___ArraysKt.filterNotNull(events).isEmpty()) {
                return;
            }
            synchronized (EventManager.subscribers) {
                for (final EventSubscriber eventSubscriber : EventManager.subscribers) {
                    try {
                        SFMCSdkLogger.INSTANCE.d(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                String str = "";
                                for (Event event : ArraysKt___ArraysKt.filterNotNull(events)) {
                                    String str2 = StringsKt__StringsKt.isBlank(str) ? "" : ", ";
                                    str = str + str2 + Reflection.getOrCreateKotlinClass(event.getClass()).getSimpleName() + "( " + event.name() + " )";
                                }
                                return "Publishing events: " + ((Object) str) + " to subscriber: " + eventSubscriber;
                            }
                        });
                    } catch (Exception unused) {
                    }
                    try {
                        ExecutorService diskIO = executors.getDiskIO();
                        String name = eventSubscriber.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        SdkExecutorsKt.namedRunnable(diskIO, name, new Function0<Unit>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                EventSubscriber eventSubscriber2 = eventSubscriber;
                                Event[] eventArr = events;
                                eventSubscriber2.onEventPublished((Event[]) Arrays.copyOf(eventArr, eventArr.length));
                            }
                        });
                    } catch (Exception unused2) {
                        SFMCSdkLogger.INSTANCE.e(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$publish$1$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to publish event(s) " + events + " to subscriber " + eventSubscriber + ".";
                            }
                        });
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void staticTearDown$sfmcsdk_release() {
            synchronized (EventManager.subscribers) {
                EventManager.subscribers.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        static /* synthetic */ String getValidatedAttributeKey$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "Attribute Key";
            }
            return companion.getValidatedAttributeKey(str, str2);
        }

        private final String getValidatedAttributeKey(final String str, final String str2) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null)) {
                SFMCSdkLogger.INSTANCE.w(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$getValidatedAttributeKey$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return str2 + " '" + str + "' contains a \".\" and will be dropped.";
                    }
                });
                return null;
            }
            return getValidatedName(str, str2);
        }

        static /* synthetic */ String getValidatedName$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "Event Name";
            }
            return companion.getValidatedName(str, str2);
        }

        private final String getValidatedName(final String str, final String str2) {
            String string = StringsKt__StringsKt.trim((CharSequence) str).toString();
            if (!StringsKt__StringsKt.isBlank(string) && !StringsKt__StringsJVMKt.startsWith$default(string, "$", false, 2, null) && !StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "\n", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) StringUtils.CR, false, 2, (Object) null)) {
                return string;
            }
            SFMCSdkLogger.INSTANCE.w(EventManager.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager$Companion$getValidatedName$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return str2 + " '" + str + "' is null, blank, starts with a \"$\", or contains a line break and will be dropped.";
                }
            });
            return null;
        }

        public final Event identityEvent$sfmcsdk_release() {
            return customEvent$default(this, "IdentityUpdate", Identity.Companion.toEvent$sfmcsdk_release(), null, Event.Category.IDENTITY, 4, null);
        }

        public static int onLoadChildren() {
            int i = MediaControllerCompatApi23TransportControls;
            int i2 = i % 5637598;
            MediaControllerCompatApi23TransportControls = i + 1;
            if (i2 != 0) {
                return toLegacyStreamType;
            }
            int iNextInt = new Random().nextInt(2092493254);
            toLegacyStreamType = iNextInt;
            return iNextInt;
        }
    }

    public final void track(@NotNull Event... events) {
        Event.Producer producer;
        Intrinsics.checkNotNullParameter(events, "events");
        String str = this.moduleName;
        if (Intrinsics.areEqual(str, "PUSH")) {
            producer = Event.Producer.PUSH;
        } else {
            producer = Intrinsics.areEqual(str, "CDP") ? Event.Producer.CDP : Event.Producer.SFMC_SDK;
        }
        ArrayList arrayList = new ArrayList();
        for (Event event : events) {
            Event eventCustomEvent$default = Companion.customEvent$default(Companion, event.name(), event.attributes(), producer, null, 8, null);
            if (eventCustomEvent$default != null) {
                arrayList.add(eventCustomEvent$default);
            }
        }
        SFMCSdk.Companion companion = SFMCSdk.Companion;
        Event[] eventArr = (Event[]) arrayList.toArray(new Event[0]);
        companion.track((Event[]) Arrays.copyOf(eventArr, eventArr.length));
    }

    public final void subscribe(@NotNull EventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        List<EventSubscriber> list = subscribers;
        synchronized (list) {
            list.add(subscriber);
        }
    }

    public final void unsubscribe(@NotNull EventSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        List<EventSubscriber> list = subscribers;
        synchronized (list) {
            list.remove(subscriber);
        }
    }
}
