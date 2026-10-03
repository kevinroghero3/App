package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StateObjectImpl implements StateObject {
    public static final int $stable = 0;
    private final AtomicInt readerKind = new AtomicInt(0);

    /* JADX INFO: renamed from: recordReadIn-h_f27i8$runtime_release, reason: not valid java name */
    public final void m773recordReadInh_f27i8$runtime_release(int i) {
        int iM760constructorimpl;
        do {
            iM760constructorimpl = ReaderKind.m760constructorimpl(this.readerKind.get());
            if ((iM760constructorimpl & i) != 0) {
                return;
            }
        } while (!this.readerKind.compareAndSet(iM760constructorimpl, ReaderKind.m760constructorimpl(iM760constructorimpl | i)));
    }

    /* JADX INFO: renamed from: isReadIn-h_f27i8$runtime_release, reason: not valid java name */
    public final boolean m772isReadInh_f27i8$runtime_release(int i) {
        return (i & ReaderKind.m760constructorimpl(this.readerKind.get())) != 0;
    }
}
