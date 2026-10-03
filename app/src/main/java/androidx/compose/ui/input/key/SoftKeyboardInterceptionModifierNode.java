package androidx.compose.ui.input.key;

import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface SoftKeyboardInterceptionModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onInterceptKeyBeforeSoftKeyboard-ZmokQxo */
    boolean mo1923onInterceptKeyBeforeSoftKeyboardZmokQxo(@NotNull android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo */
    boolean mo1924onPreInterceptKeyBeforeSoftKeyboardZmokQxo(@NotNull android.view.KeyEvent keyEvent);
}
