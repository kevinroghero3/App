package io.sentry.util;

import io.sentry.EventProcessor;
import io.sentry.internal.eventprocessor.EventProcessorAndOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class EventProcessorUtils {
    public static List<EventProcessor> unwrap(@Nullable List<EventProcessorAndOrder> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<EventProcessorAndOrder> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getEventProcessor());
            }
        }
        return new CopyOnWriteArrayList(arrayList);
    }
}
