package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class VectorKt {
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0.0f;
    public static final float DefaultPivotY = 0.0f;
    public static final float DefaultRotation = 0.0f;
    public static final float DefaultScaleX = 1.0f;
    public static final float DefaultScaleY = 1.0f;
    public static final float DefaultStrokeLineMiter = 4.0f;
    public static final float DefaultStrokeLineWidth = 0.0f;
    public static final float DefaultTranslationX = 0.0f;
    public static final float DefaultTranslationY = 0.0f;
    public static final float DefaultTrimPathEnd = 1.0f;
    public static final float DefaultTrimPathOffset = 0.0f;
    public static final float DefaultTrimPathStart = 0.0f;
    private static final List<PathNode> EmptyPath = CollectionsKt__CollectionsKt.emptyList();
    private static final int DefaultStrokeLineCap = StrokeCap.Companion.m1524getButtKaPHkGw();
    private static final int DefaultStrokeLineJoin = StrokeJoin.Companion.m1535getMiterLxFBmk8();
    private static final int DefaultTintBlendMode = BlendMode.Companion.m1109getSrcIn0nO6VwU();
    private static final long DefaultTintColor = Color.Companion.m1204getTransparent0d7_KjU();
    private static final int DefaultFillType = PathFillType.Companion.m1453getNonZeroRgk1Os();

    public static final List<PathNode> getEmptyPath() {
        return EmptyPath;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return DefaultTintColor;
    }

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    public static final List<PathNode> PathData(@NotNull Function1<? super PathBuilder, Unit> function1) {
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return pathBuilder.getNodes();
    }

    public static final List<PathNode> addPathNodes(@Nullable String str) {
        if (str == null) {
            return EmptyPath;
        }
        return new PathParser().parsePathString(str).toNodes();
    }

    /* JADX INFO: renamed from: rgbEqual--OWjLjI, reason: not valid java name */
    public static final boolean m1879rgbEqualOWjLjI(long j, long j2) {
        return Color.m1175getRedimpl(j) == Color.m1175getRedimpl(j2) && Color.m1174getGreenimpl(j) == Color.m1174getGreenimpl(j2) && Color.m1172getBlueimpl(j) == Color.m1172getBlueimpl(j2);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:11:0x0029 A[ORIG_RETURN, RETURN] */
    public static final boolean tintableWithAlphaMask(@Nullable ColorFilter colorFilter) {
        if (!(colorFilter instanceof BlendModeColorFilter)) {
            if (colorFilter == null) {
                return true;
            }
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) colorFilter;
        int iM1113getBlendMode0nO6VwU = blendModeColorFilter.m1113getBlendMode0nO6VwU();
        BlendMode.Companion companion = BlendMode.Companion;
        if (BlendMode.m1080equalsimpl0(iM1113getBlendMode0nO6VwU, companion.m1109getSrcIn0nO6VwU()) || BlendMode.m1080equalsimpl0(blendModeColorFilter.m1113getBlendMode0nO6VwU(), companion.m1111getSrcOver0nO6VwU())) {
            return true;
        }
        return false;
    }
}
