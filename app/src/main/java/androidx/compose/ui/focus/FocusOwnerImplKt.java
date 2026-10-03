package androidx.compose.ui.focus;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusOwnerImplKt {
    private static final String Warning = "FocusRelatedWarning";

    /* JADX INFO: renamed from: is1dFocusSearch-3ESFkO8, reason: not valid java name */
    public static final boolean m866is1dFocusSearch3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m840equalsimpl0(i, companion.m850getNextdhqQ8s())) {
            return true;
        }
        return FocusDirection.m840equalsimpl0(i, companion.m851getPreviousdhqQ8s());
    }
}
