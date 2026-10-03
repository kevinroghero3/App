package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawBackgroundModifier extends Modifier.Node implements DrawModifierNode {
    public static final int $stable = 8;
    private Function1<? super DrawScope, Unit> onDraw;

    public final Function1<DrawScope, Unit> getOnDraw() {
        return this.onDraw;
    }

    public final void setOnDraw(@NotNull Function1<? super DrawScope, Unit> function1) {
        this.onDraw = function1;
    }

    public DrawBackgroundModifier(@NotNull Function1<? super DrawScope, Unit> function1) {
        this.onDraw = function1;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        this.onDraw.invoke(contentDrawScope);
        contentDrawScope.drawContent();
    }
}
