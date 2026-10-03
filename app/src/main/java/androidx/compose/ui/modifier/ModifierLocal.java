package androidx.compose.ui.modifier;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModifierLocal<T> {
    public static final int $stable = 0;
    private final Function0<T> defaultFactory;

    public /* synthetic */ ModifierLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ModifierLocal(Function0<? extends T> function0) {
        this.defaultFactory = function0;
    }

    public final Function0<T> getDefaultFactory$ui_release() {
        return this.defaultFactory;
    }
}
