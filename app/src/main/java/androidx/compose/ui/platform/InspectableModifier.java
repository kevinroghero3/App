package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class InspectableModifier extends InspectorValueInfo implements Modifier.Element {
    public static final int $stable = 0;
    private final End end;

    /* JADX INFO: loaded from: classes4.dex */
    public final class End implements Modifier.Element {
        public End() {
        }
    }

    public InspectableModifier(@NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.end = new End();
    }

    public final End getEnd() {
        return this.end;
    }
}
