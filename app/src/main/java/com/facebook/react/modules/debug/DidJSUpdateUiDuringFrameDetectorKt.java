package com.facebook.react.modules.debug;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DidJSUpdateUiDuringFrameDetectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long getLastEventBetweenTimestamps(ArrayList<Long> arrayList, long j, long j2) {
        Iterator<Long> it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        long j3 = -1;
        while (it2.hasNext()) {
            Long next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            long jLongValue = next.longValue();
            if (j <= jLongValue && jLongValue < j2) {
                j3 = jLongValue;
            } else if (jLongValue >= j2) {
                break;
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanUp(ArrayList<Long> arrayList, long j) {
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).longValue() < j) {
                i++;
            }
        }
        if (i > 0) {
            for (int i3 = 0; i3 < size - i; i3++) {
                arrayList.set(i3, arrayList.get(i3 + i));
            }
            CollectionsKt___CollectionsKt.dropLast(arrayList, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasEventBetweenTimestamps(ArrayList<Long> arrayList, long j, long j2) {
        if (arrayList == null || !arrayList.isEmpty()) {
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                if (j <= jLongValue && jLongValue < j2) {
                    return true;
                }
            }
        }
        return false;
    }
}
