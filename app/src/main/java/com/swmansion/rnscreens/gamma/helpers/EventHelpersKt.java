package com.swmansion.rnscreens.gamma.helpers;

import com.swmansion.rnscreens.gamma.common.NamingAwareEventType;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class EventHelpersKt {
    public static final Pair<String, HashMap<String, String>> makeEventRegistrationInfo(@NotNull NamingAwareEventType event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return TuplesKt.to(event.getEventName(), MapsKt__MapsKt.hashMapOf(TuplesKt.to("registrationName", event.getEventRegistrationName())));
    }
}
