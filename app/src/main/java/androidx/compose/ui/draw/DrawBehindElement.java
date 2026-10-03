package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class DrawBehindElement extends ModifierNodeElement<DrawBackgroundModifier> {
    private final Function1<DrawScope, Unit> onDraw;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrawBehindElement copy$default(DrawBehindElement drawBehindElement, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = drawBehindElement.onDraw;
        }
        return drawBehindElement.copy(function1);
    }

    public final Function1<DrawScope, Unit> component1() {
        return this.onDraw;
    }

    public final DrawBehindElement copy(@NotNull Function1<? super DrawScope, Unit> function1) {
        return new DrawBehindElement(function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DrawBehindElement) && Intrinsics.areEqual(this.onDraw, ((DrawBehindElement) obj).onDraw);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onDraw.hashCode();
    }

    public String toString() {
        return "DrawBehindElement(onDraw=" + this.onDraw + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public final Function1<DrawScope, Unit> getOnDraw() {
        return this.onDraw;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DrawBehindElement(@NotNull Function1<? super DrawScope, Unit> function1) {
        this.onDraw = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public DrawBackgroundModifier create() {
        return new DrawBackgroundModifier(this.onDraw);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(@NotNull DrawBackgroundModifier drawBackgroundModifier) {
        drawBackgroundModifier.setOnDraw(this.onDraw);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        inspectorInfo.setName("drawBehind");
        inspectorInfo.getProperties().set("onDraw", this.onDraw);
    }
}
