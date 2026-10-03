package androidx.compose.ui.layout;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class FixedCountSubcomposeSlotReusePolicy implements SubcomposeSlotReusePolicy {
    private final int maxSlotsToRetainForReuse;

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(@Nullable Object obj, @Nullable Object obj2) {
        return true;
    }

    public FixedCountSubcomposeSlotReusePolicy(int i) {
        this.maxSlotsToRetainForReuse = i;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(@NotNull SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet) {
        if (slotIdsSet.size() > this.maxSlotsToRetainForReuse) {
            Iterator<Object> it2 = slotIdsSet.iterator();
            int i = 0;
            while (it2.hasNext()) {
                it2.next();
                i++;
                if (i > this.maxSlotsToRetainForReuse) {
                    it2.remove();
                }
            }
        }
    }
}
