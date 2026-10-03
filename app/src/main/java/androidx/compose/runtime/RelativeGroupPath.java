package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class RelativeGroupPath extends SourceInformationGroupPath {
    private final int index;
    private final SourceInformationGroupPath parent;

    public final SourceInformationGroupPath getParent() {
        return this.parent;
    }

    public final int getIndex() {
        return this.index;
    }

    public RelativeGroupPath(@NotNull SourceInformationGroupPath sourceInformationGroupPath, int i) {
        super(null);
        this.parent = sourceInformationGroupPath;
        this.index = i;
    }

    @Override // androidx.compose.runtime.SourceInformationGroupPath
    public Object getIdentity(@NotNull SlotTable slotTable) {
        return new SourceInformationSlotTableGroupIdentity(this.parent.getIdentity(slotTable), this.index);
    }
}
