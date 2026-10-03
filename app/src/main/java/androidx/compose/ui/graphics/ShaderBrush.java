package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo1138createShaderuvyYCjk(long j);

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m1005getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo1116applyToPq9zytI(long j, @NotNull Paint paint, float f) {
        Shader shaderMo1138createShaderuvyYCjk = this.internalShader;
        if (shaderMo1138createShaderuvyYCjk == null || !Size.m993equalsimpl0(this.createdSize, j)) {
            if (Size.m999isEmptyimpl(j)) {
                shaderMo1138createShaderuvyYCjk = null;
                this.internalShader = null;
                this.createdSize = Size.Companion.m1005getUnspecifiedNHjbRc();
            } else {
                shaderMo1138createShaderuvyYCjk = mo1138createShaderuvyYCjk(j);
                this.internalShader = shaderMo1138createShaderuvyYCjk;
                this.createdSize = j;
            }
        }
        long jMo1042getColor0d7_KjU = paint.mo1042getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1170equalsimpl0(jMo1042getColor0d7_KjU, companion.m1195getBlack0d7_KjU())) {
            paint.mo1048setColor8_81llA(companion.m1195getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(paint.getShader(), shaderMo1138createShaderuvyYCjk)) {
            paint.setShader(shaderMo1138createShaderuvyYCjk);
        }
        if (paint.getAlpha() == f) {
            return;
        }
        paint.setAlpha(f);
    }
}
