package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface FocusProperties {
    static /* synthetic */ void getEnter$annotations() {
    }

    static /* synthetic */ void getExit$annotations() {
    }

    boolean getCanFocus();

    void setCanFocus(boolean z);

    default void setDown(@NotNull FocusRequester focusRequester) {
    }

    default void setEnd(@NotNull FocusRequester focusRequester) {
    }

    default void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
    }

    default void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1) {
    }

    default void setLeft(@NotNull FocusRequester focusRequester) {
    }

    default void setNext(@NotNull FocusRequester focusRequester) {
    }

    default void setPrevious(@NotNull FocusRequester focusRequester) {
    }

    default void setRight(@NotNull FocusRequester focusRequester) {
    }

    default void setStart(@NotNull FocusRequester focusRequester) {
    }

    default void setUp(@NotNull FocusRequester focusRequester) {
    }

    default FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    default Function1<FocusDirection, FocusRequester> getEnter() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m867invoke3ESFkO8(focusDirection.m843unboximpl());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m867invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }

    default Function1<FocusDirection, FocusRequester> getExit() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m868invoke3ESFkO8(focusDirection.m843unboximpl());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m868invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }
}
