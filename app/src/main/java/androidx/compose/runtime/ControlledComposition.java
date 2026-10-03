package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ControlledComposition extends Composition {
    void abandonChanges();

    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2);

    <R> R delegateInvalidations(@Nullable ControlledComposition controlledComposition, int i, @NotNull Function0<? extends R> function0);

    void disposeUnusedMovableContent(@NotNull MovableContentState movableContentState);

    boolean getHasPendingChanges();

    void insertMovableContent(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> list);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(@NotNull Set<? extends Object> set);

    void prepareCompose(@NotNull Function0<Unit> function0);

    boolean recompose();

    void recordModificationsOf(@NotNull Set<? extends Object> set);

    void recordReadOf(@NotNull Object obj);

    void recordWriteOf(@NotNull Object obj);

    void verifyConsistent();
}
