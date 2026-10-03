package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char c, @NotNull ArrayList<PathNode> arrayList, @NotNull float[] fArr, int i) {
        if (c == 'z' || c == 'Z') {
            arrayList.add(PathNode.Close.INSTANCE);
            return;
        }
        if (c == 'm') {
            pathRelativeMoveNodeFromArgs(arrayList, fArr, i);
            return;
        }
        if (c == 'M') {
            pathMoveNodeFromArgs(arrayList, fArr, i);
            return;
        }
        int i2 = 0;
        if (c == 'l') {
            while (i2 <= i - 2) {
                arrayList.add(new PathNode.RelativeLineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'L') {
            while (i2 <= i - 2) {
                arrayList.add(new PathNode.LineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'h') {
            while (i2 <= i - 1) {
                arrayList.add(new PathNode.RelativeHorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'H') {
            while (i2 <= i - 1) {
                arrayList.add(new PathNode.HorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'v') {
            while (i2 <= i - 1) {
                arrayList.add(new PathNode.RelativeVerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'V') {
            while (i2 <= i - 1) {
                arrayList.add(new PathNode.VerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'c') {
            while (i2 <= i - 6) {
                arrayList.add(new PathNode.RelativeCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 'C') {
            while (i2 <= i - 6) {
                arrayList.add(new PathNode.CurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 's') {
            while (i2 <= i - 4) {
                arrayList.add(new PathNode.RelativeReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'S') {
            while (i2 <= i - 4) {
                arrayList.add(new PathNode.ReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'q') {
            while (i2 <= i - 4) {
                arrayList.add(new PathNode.RelativeQuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'Q') {
            while (i2 <= i - 4) {
                arrayList.add(new PathNode.QuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 't') {
            while (i2 <= i - 2) {
                arrayList.add(new PathNode.RelativeReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'T') {
            while (i2 <= i - 2) {
                arrayList.add(new PathNode.ReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'a') {
            for (int i3 = 0; i3 <= i - 7; i3 += 7) {
                arrayList.add(new PathNode.RelativeArcTo(fArr[i3], fArr[i3 + 1], fArr[i3 + 2], Float.compare(fArr[i3 + 3], 0.0f) != 0, Float.compare(fArr[i3 + 4], 0.0f) != 0, fArr[i3 + 5], fArr[i3 + 6]));
            }
            return;
        }
        if (c != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c);
        }
        for (int i4 = 0; i4 <= i - 7; i4 += 7) {
            arrayList.add(new PathNode.ArcTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], Float.compare(fArr[i4 + 3], 0.0f) != 0, Float.compare(fArr[i4 + 4], 0.0f) != 0, fArr[i4 + 5], fArr[i4 + 6]));
        }
    }

    private static final void pathNodesFromArgs(List<PathNode> list, float[] fArr, int i, int i2, Function2<? super float[], ? super Integer, ? extends PathNode> function2) {
        int i3 = 0;
        while (i3 <= i - i2) {
            list.add(function2.invoke(fArr, Integer.valueOf(i3)));
            i3 += i2;
        }
    }

    private static final void pathMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new PathNode.MoveTo(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new PathNode.LineTo(fArr[i3], fArr[i3 + 1]));
            }
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List<PathNode> list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new PathNode.RelativeMoveTo(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new PathNode.RelativeLineTo(fArr[i3], fArr[i3 + 1]));
            }
        }
    }
}
