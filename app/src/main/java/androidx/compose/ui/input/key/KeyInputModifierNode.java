package androidx.compose.ui.input.key;

import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo2243onKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo2244onPreKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent);
}
