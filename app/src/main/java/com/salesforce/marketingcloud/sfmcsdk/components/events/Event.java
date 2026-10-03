package com.salesforce.marketingcloud.sfmcsdk.components.events;

import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Event {
    private final Category category;
    public final String id;
    private final Producer producer;

    public enum Category {
        APPLICATION,
        ENGAGEMENT,
        IDENTITY,
        SYSTEM;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Category> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public enum Producer {
        APP,
        SFMC_SDK,
        PUSH,
        CDP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Producer> getEntries() {
            return $ENTRIES;
        }
    }

    public abstract Map<String, Object> attributes();

    public abstract String name();

    public Event() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.id = string;
        this.producer = Producer.SFMC_SDK;
        this.category = Category.ENGAGEMENT;
    }

    public Producer getProducer() {
        return this.producer;
    }

    public Category getCategory() {
        return this.category;
    }

    public final void track() {
        SFMCSdk.Companion.track(this);
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", name());
        jSONObject.put("id", this.id);
        jSONObject.put("producer", getProducer());
        jSONObject.put("category", getCategory());
        JSONObject jSONObject2 = new JSONObject();
        Iterator<T> it2 = attributes().entrySet().iterator();
        while (it2.hasNext()) {
            final Map.Entry entry = (Map.Entry) it2.next();
            try {
                Object value = entry.getValue();
                if (value instanceof SFMCSdkEvent) {
                    String str = (String) entry.getKey();
                    Object value2 = entry.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type com.salesforce.marketingcloud.sfmcsdk.components.events.SFMCSdkEvent");
                    jSONObject2.put(str, ((SFMCSdkEvent) value2).toJson());
                } else if ((value instanceof Number) || (value instanceof String) || (value instanceof Character) || (value instanceof Boolean)) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                } else {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
                SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
                String name = jSONObject2.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                sFMCSdkLogger.w(name, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.components.events.Event$toJson$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Could not convert attribute (" + entry + ") to JSON.";
                    }
                });
            }
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("attributes", jSONObject2);
        return jSONObject;
    }
}
