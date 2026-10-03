package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ReusableComposition extends Composition {
    void deactivate();

    void setContentWithReuse(@NotNull Function2<? super Composer, ? super Integer, Unit> function2);
}
