package androidx.compose.ui.modifier;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModifierLocalMap {
    public static final int $stable = 0;

    public /* synthetic */ ModifierLocalMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal);

    public abstract <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal);

    /* JADX INFO: renamed from: set$ui_release */
    public abstract <T> void mo2632set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t);

    private ModifierLocalMap() {
    }
}
