package androidx.compose.ui.focus;

/* JADX INFO: loaded from: classes.dex */
public interface FocusManager {
    void clearFocus(boolean z);

    /* JADX INFO: renamed from: moveFocus-3ESFkO8, reason: not valid java name */
    boolean mo855moveFocus3ESFkO8(int i);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ void clearFocus$default(FocusManager focusManager, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        focusManager.clearFocus(z);
    }
}
