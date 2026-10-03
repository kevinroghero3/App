package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    public /* synthetic */ SizeElement(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m3670getUnspecifiedD9Ej5fM() : f4, z, function1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SizeElement(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
        this.inspectorInfo = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(@NotNull SizeNode sizeNode) {
        sizeNode.m582setMinWidth0680j_4(this.minWidth);
        sizeNode.m581setMinHeight0680j_4(this.minHeight);
        sizeNode.m580setMaxWidth0680j_4(this.maxWidth);
        sizeNode.m579setMaxHeight0680j_4(this.maxHeight);
        sizeNode.setEnforceIncoming(this.enforceIncoming);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return Dp.m3655equalsimpl0(this.minWidth, sizeElement.minWidth) && Dp.m3655equalsimpl0(this.minHeight, sizeElement.minHeight) && Dp.m3655equalsimpl0(this.maxWidth, sizeElement.maxWidth) && Dp.m3655equalsimpl0(this.maxHeight, sizeElement.maxHeight) && this.enforceIncoming == sizeElement.enforceIncoming;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iM3656hashCodeimpl = Dp.m3656hashCodeimpl(this.minWidth);
        int iM3656hashCodeimpl2 = Dp.m3656hashCodeimpl(this.minHeight);
        return (((((((iM3656hashCodeimpl * 31) + iM3656hashCodeimpl2) * 31) + Dp.m3656hashCodeimpl(this.maxWidth)) * 31) + Dp.m3656hashCodeimpl(this.maxHeight)) * 31) + Boolean.hashCode(this.enforceIncoming);
    }
}
