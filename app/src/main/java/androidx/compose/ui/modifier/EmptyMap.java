package androidx.compose.ui.modifier;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyMap extends ModifierLocalMap {
    public static final int $stable = 0;
    public static final EmptyMap INSTANCE = new EmptyMap();

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        return false;
    }

    private EmptyMap() {
        super(null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    /* JADX INFO: renamed from: set$ui_release, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo2632set$ui_release(ModifierLocal modifierLocal, Object obj) {
        set$ui_release((ModifierLocal<Object>) modifierLocal, obj);
    }

    public <T> Void set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        throw new IllegalStateException("");
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalMap
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        throw new IllegalStateException("");
    }
}
