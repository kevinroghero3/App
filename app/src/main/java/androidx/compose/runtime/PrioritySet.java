package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PrioritySet {
    public static final int $stable = 8;
    private final List<Integer> list;

    public PrioritySet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PrioritySet(@NotNull List<Integer> list) {
        this.list = list;
    }

    public /* synthetic */ PrioritySet(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final void add(int i) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() == i) {
                return;
            }
            List<Integer> list = this.list;
            if (list.get(list.size() - 1).intValue() == i) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i));
        while (size > 0) {
            int i2 = ((size + 1) >>> 1) - 1;
            int iIntValue = this.list.get(i2).intValue();
            if (i <= iIntValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(iIntValue));
            size = i2;
        }
        this.list.set(size, Integer.valueOf(i));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt___CollectionsKt.first((List) this.list)).intValue();
    }

    public final int takeMax() {
        int iIntValue;
        if (this.list.size() <= 0) {
            ComposerKt.composeImmediateRuntimeError("Set is empty");
        }
        int iIntValue2 = this.list.get(0).intValue();
        while (!this.list.isEmpty() && this.list.get(0).intValue() == iIntValue2) {
            List<Integer> list = this.list;
            list.set(0, (Integer) CollectionsKt___CollectionsKt.last((List) list));
            List<Integer> list2 = this.list;
            list2.remove(list2.size() - 1);
            int size = this.list.size();
            int size2 = this.list.size();
            int i = 0;
            while (i < (size2 >>> 1)) {
                int iIntValue3 = this.list.get(i).intValue();
                int i2 = (i + 1) * 2;
                int i3 = i2 - 1;
                int iIntValue4 = this.list.get(i3).intValue();
                if (i2 < size && (iIntValue = this.list.get(i2).intValue()) > iIntValue4) {
                    if (iIntValue <= iIntValue3) {
                        break;
                    }
                    this.list.set(i, Integer.valueOf(iIntValue));
                    this.list.set(i2, Integer.valueOf(iIntValue3));
                    i = i2;
                } else {
                    if (iIntValue4 <= iIntValue3) {
                        break;
                    }
                    this.list.set(i, Integer.valueOf(iIntValue4));
                    this.list.set(i3, Integer.valueOf(iIntValue3));
                    i = i3;
                }
            }
        }
        return iIntValue2;
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i = size / 2;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            int i4 = i3 * 2;
            if (this.list.get(i2).intValue() < this.list.get(i4 - 1).intValue()) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            if (i4 < size && this.list.get(i2).intValue() < this.list.get(i4).intValue()) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            i2 = i3;
        }
    }
}
