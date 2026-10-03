package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface FocusOwner extends FocusManager {
    /* JADX INFO: renamed from: clearFocus-I7lrPNg, reason: not valid java name */
    boolean mo857clearFocusI7lrPNg(boolean z, boolean z2, boolean z3, int i);

    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo, reason: not valid java name */
    boolean mo858dispatchInterceptedSoftKeyboardEventZmokQxo(@NotNull KeyEvent keyEvent);

    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w, reason: not valid java name */
    boolean mo859dispatchKeyEventYhN2O0w(@NotNull KeyEvent keyEvent, @NotNull Function0<Boolean> function0);

    boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);

    /* JADX INFO: renamed from: focusSearch-ULY8qGw, reason: not valid java name */
    Boolean mo860focusSearchULY8qGw(int i, @Nullable Rect rect, @NotNull Function1<? super FocusTargetNode, Boolean> function1);

    Rect getFocusRect();

    FocusTransactionManager getFocusTransactionManager();

    Modifier getModifier();

    FocusState getRootState();

    void releaseFocus();

    /* JADX INFO: renamed from: requestFocusForOwner-7o62pno, reason: not valid java name */
    boolean mo861requestFocusForOwner7o62pno(@Nullable FocusDirection focusDirection, @Nullable Rect rect);

    void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode);

    void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode);

    void scheduleInvalidation(@NotNull FocusTargetNode focusTargetNode);

    /* JADX INFO: renamed from: takeFocus-aToIllA, reason: not valid java name */
    boolean mo862takeFocusaToIllA(int i, @Nullable Rect rect);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w$default, reason: not valid java name */
    static /* synthetic */ boolean m856dispatchKeyEventYhN2O0w$default(FocusOwner focusOwner, KeyEvent keyEvent, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.ui.focus.FocusOwner$dispatchKeyEvent$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        return focusOwner.mo859dispatchKeyEventYhN2O0w(keyEvent, function0);
    }
}
