package androidx.compose.ui.focus;

import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use FocusProperties instead")
public final class FocusOrder {
    public static final int $stable = 8;
    private final FocusProperties focusProperties;

    public FocusOrder(@NotNull FocusProperties focusProperties) {
        this.focusProperties = focusProperties;
    }

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }

    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    public final void setNext(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setNext(focusRequester);
    }

    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    public final void setPrevious(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setPrevious(focusRequester);
    }

    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setUp(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setUp(focusRequester);
    }

    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    public final void setDown(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setDown(focusRequester);
    }

    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    public final void setLeft(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setLeft(focusRequester);
    }

    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    public final void setRight(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setRight(focusRequester);
    }

    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    public final void setStart(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setStart(focusRequester);
    }

    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    public final void setEnd(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setEnd(focusRequester);
    }
}
