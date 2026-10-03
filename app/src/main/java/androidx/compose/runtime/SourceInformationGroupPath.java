package androidx.compose.runtime;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
abstract class SourceInformationGroupPath {
    public /* synthetic */ SourceInformationGroupPath(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object getIdentity(@NotNull SlotTable slotTable);

    private SourceInformationGroupPath() {
    }
}
