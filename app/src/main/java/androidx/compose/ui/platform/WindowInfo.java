package androidx.compose.ui.platform;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInfo {
    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A$annotations, reason: not valid java name */
    static /* synthetic */ void m2924getKeyboardModifiersk7X9c1A$annotations() {
    }

    boolean isWindowFocused();

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    default int mo2925getKeyboardModifiersk7X9c1A() {
        return WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui_release().getValue().m2451unboximpl();
    }
}
