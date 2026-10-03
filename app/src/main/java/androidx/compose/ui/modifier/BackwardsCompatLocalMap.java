package androidx.compose.ui.modifier;

import androidx.compose.ui.internal.InlineClassHelperKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    public static final int $stable = 8;
    private ModifierLocalProvider<?> element;

    public final ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    public final void setElement(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        this.element = modifierLocalProvider;
    }

    public BackwardsCompatLocalMap(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        super(null);
        this.element = modifierLocalProvider;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release */
    public <T> void mo2632set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        throw new IllegalStateException("Set is not allowed on a backwards compat provider");
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        if (modifierLocal != this.element.getKey()) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        return (T) this.element.getValue();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        return modifierLocal == this.element.getKey();
    }
}
