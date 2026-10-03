package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularList {
    private final int size;

    public CircularList(int i) {
        this.size = i;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isTargetAhead(int i, int i2, int i3) {
        int position = getPosition(i3 + i);
        return i >= position ? !((i > i2 || i2 > this.size) && (i2 < 0 || i2 > position)) : !(i > i2 || i2 > position);
    }

    public final int getPosition(int i) {
        int i2 = i % this.size;
        Integer numValueOf = Integer.valueOf(i2);
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i2 + this.size;
    }

    public final List<Integer> sublist(int i, int i2) {
        IntRange intRangeUntil = RangesKt___RangesKt.until(0, i2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(getPosition(((IntIterator) it2).nextInt() + i)));
        }
        return arrayList;
    }
}
