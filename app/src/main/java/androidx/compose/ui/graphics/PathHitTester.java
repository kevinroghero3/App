package androidx.compose.ui.graphics;

import androidx.annotation.FloatRange;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathHitTester {
    private Path path = PathHitTesterKt.EmptyPath;
    private float tolerance = 0.5f;
    private Rect bounds = Rect.Companion.getZero();
    private final IntervalTree<PathSegment> intervals = new IntervalTree<>();
    private final float[] curves = new float[20];
    private final float[] roots = new float[2];

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void updatePath$default(PathHitTester pathHitTester, Path path, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        pathHitTester.updatePath(path, f);
    }

    public final void updatePath(@NotNull Path path, @FloatRange(from = 0.0d) float f) {
        this.path = path;
        this.tolerance = f;
        this.bounds = path.getBounds();
        this.intervals.clear();
        PathIterator it2 = path.iterator(PathIterator.ConicEvaluation.AsQuadratics, f);
        while (it2.hasNext()) {
            PathSegment next = it2.next();
            int i = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                long jComputeVerticalBounds$default = BezierKt.computeVerticalBounds$default(next, this.curves, 0, 4, null);
                this.intervals.addInterval(Float.intBitsToFloat((int) (jComputeVerticalBounds$default >> 32)), Float.intBitsToFloat((int) (jComputeVerticalBounds$default & 4294967295L)), next);
            } else if (i == 4) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m1454containsk4lQ0M(long j) {
        int i;
        int iLineWinding;
        if (!this.path.isEmpty() && this.bounds.m954containsk4lQ0M(j)) {
            float fM928getXimpl = Offset.m928getXimpl(j);
            float fM929getYimpl = Offset.m929getYimpl(j);
            float[] fArr = this.curves;
            float[] fArr2 = this.roots;
            IntervalTree<PathSegment> intervalTree = this.intervals;
            if (((IntervalTree) intervalTree).root != ((IntervalTree) intervalTree).terminator) {
                ArrayList arrayList = ((IntervalTree) intervalTree).stack;
                arrayList.add(((IntervalTree) intervalTree).root);
                i = 0;
                while (arrayList.size() > 0) {
                    IntervalTree.Node node = (IntervalTree.Node) CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                    if (node.overlaps(fM929getYimpl, fM929getYimpl)) {
                        T data = node.getData();
                        Intrinsics.checkNotNull(data);
                        PathSegment pathSegment = (PathSegment) data;
                        float[] points = pathSegment.getPoints();
                        int i2 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
                        if (i2 == 1) {
                            iLineWinding = BezierKt.lineWinding(points, fM928getXimpl, fM929getYimpl);
                        } else if (i2 == 2) {
                            iLineWinding = BezierKt.quadraticWinding(points, fM928getXimpl, fM929getYimpl, fArr, fArr2);
                        } else if (i2 == 3) {
                            iLineWinding = BezierKt.cubicWinding(points, fM928getXimpl, fM929getYimpl, fArr, fArr2);
                        }
                        i += iLineWinding;
                    }
                    if (node.getLeft() != ((IntervalTree) intervalTree).terminator && node.getLeft().getMax() >= fM929getYimpl) {
                        arrayList.add(node.getLeft());
                    }
                    if (node.getRight() != ((IntervalTree) intervalTree).terminator && node.getRight().getMin() <= fM929getYimpl) {
                        arrayList.add(node.getRight());
                    }
                }
                arrayList.clear();
            } else {
                i = 0;
            }
            if (PathFillType.m1448equalsimpl0(this.path.mo1060getFillTypeRgk1Os(), PathFillType.Companion.m1452getEvenOddRgk1Os())) {
                i &= 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }
}
