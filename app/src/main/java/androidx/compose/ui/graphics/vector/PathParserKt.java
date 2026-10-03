package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final double toRadians(double d) {
        return (d / ((double) RotationOptions.ROTATE_180)) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(@NotNull List<? extends PathNode> list, @NotNull Path path) {
        PathNode pathNode;
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float x1;
        float y1;
        float dx;
        float dy;
        float x2;
        float y2;
        float dy2;
        float x3;
        float y3;
        float f4;
        float f5;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int iMo1060getFillTypeRgk1Os = path.mo1060getFillTypeRgk1Os();
        path.rewind();
        path2.mo1062setFillTypeoQ8Xj4U(iMo1060getFillTypeRgk1Os);
        PathNode pathNode2 = list.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list.size();
        float f6 = 0.0f;
        int i3 = 0;
        float x4 = 0.0f;
        float arcStartY = 0.0f;
        float arcStartX = 0.0f;
        float y = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (i3 < size) {
            PathNode pathNode3 = list2.get(i3);
            if (pathNode3 instanceof PathNode.Close) {
                path.close();
                pathNode = pathNode3;
                f = f6;
                i = i3;
                i2 = size;
                x4 = f7;
                arcStartX = x4;
                arcStartY = f8;
                y = arcStartY;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    float dx2 = arcStartX + relativeMoveTo.getDx();
                    float dy3 = y + relativeMoveTo.getDy();
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                    f7 = dx2;
                    f8 = dy3;
                } else if (pathNode3 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                    float x = moveTo.getX();
                    float y4 = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                    f7 = x;
                    f8 = y4;
                } else {
                    if (pathNode3 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        arcStartX += relativeLineTo.getDx();
                        dy2 = relativeLineTo.getDy();
                    } else {
                        if (pathNode3 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                            path2.lineTo(lineTo.getX(), lineTo.getY());
                            x2 = lineTo.getX();
                            y2 = lineTo.getY();
                        } else {
                            if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f6);
                                arcStartX += relativeHorizontalTo.getDx();
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), y);
                                arcStartX = horizontalTo.getX();
                            } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                path2.relativeLineTo(f6, relativeVerticalTo.getDy());
                                dy2 = relativeVerticalTo.getDy();
                            } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                path2.lineTo(arcStartX, verticalTo.getY());
                                y = verticalTo.getY();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                    PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                    path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                    x1 = relativeCurveTo.getDx2() + arcStartX;
                                    y1 = relativeCurveTo.getDy2() + y;
                                    dx = arcStartX + relativeCurveTo.getDx3();
                                    dy = relativeCurveTo.getDy3();
                                } else {
                                    if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        x1 = curveTo.getX2();
                                        y1 = curveTo.getY2();
                                        x3 = curveTo.getX3();
                                        y3 = curveTo.getY3();
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.isCurve()) {
                                            f4 = arcStartX - x4;
                                            f5 = y - arcStartY;
                                        } else {
                                            f4 = f6;
                                            f5 = f4;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f4, f5, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        x1 = relativeReflectiveCurveTo.getDx1() + arcStartX;
                                        y1 = relativeReflectiveCurveTo.getDy1() + y;
                                        dx = arcStartX + relativeReflectiveCurveTo.getDx2();
                                        dy = relativeReflectiveCurveTo.getDy2();
                                    } else if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                        if (pathNode2.isCurve()) {
                                            float f9 = 2;
                                            y = (y * f9) - arcStartY;
                                            arcStartX = (arcStartX * f9) - x4;
                                        }
                                        PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                        path.cubicTo(arcStartX, y, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                        x1 = reflectiveCurveTo.getX1();
                                        y1 = reflectiveCurveTo.getY1();
                                        x3 = reflectiveCurveTo.getX2();
                                        y3 = reflectiveCurveTo.getY2();
                                    } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                        PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                        path2.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                        x4 = relativeQuadTo.getDx1() + arcStartX;
                                        arcStartY = relativeQuadTo.getDy1() + y;
                                        arcStartX += relativeQuadTo.getDx2();
                                        dy2 = relativeQuadTo.getDy2();
                                    } else if (pathNode3 instanceof PathNode.QuadTo) {
                                        PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                        path2.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                        x4 = quadTo.getX1();
                                        arcStartY = quadTo.getY1();
                                        x2 = quadTo.getX2();
                                        y2 = quadTo.getY2();
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                        if (pathNode2.isQuad()) {
                                            f2 = arcStartX - x4;
                                            f3 = y - arcStartY;
                                        } else {
                                            f2 = f6;
                                            f3 = f2;
                                        }
                                        PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                        path2.relativeQuadraticTo(f2, f3, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                        x1 = f2 + arcStartX;
                                        y1 = f3 + y;
                                        dx = arcStartX + relativeReflectiveQuadTo.getDx();
                                        dy = relativeReflectiveQuadTo.getDy();
                                    } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                        if (pathNode2.isQuad()) {
                                            float f10 = 2;
                                            arcStartX = (arcStartX * f10) - x4;
                                            y = (f10 * y) - arcStartY;
                                        }
                                        PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                        path2.quadraticTo(arcStartX, y, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                        float x5 = reflectiveQuadTo.getX();
                                        arcStartY = y;
                                        pathNode = pathNode3;
                                        f = f6;
                                        i = i3;
                                        i2 = size;
                                        y = reflectiveQuadTo.getY();
                                        float f11 = arcStartX;
                                        arcStartX = x5;
                                        x4 = f11;
                                    } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                        PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                        float arcStartDx = relativeArcTo.getArcStartDx() + arcStartX;
                                        float arcStartDy = relativeArcTo.getArcStartDy() + y;
                                        pathNode = pathNode3;
                                        i = i3;
                                        f = 0.0f;
                                        i2 = size;
                                        drawArc(path, arcStartX, y, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                        arcStartY = arcStartDy;
                                        y = arcStartY;
                                        x4 = arcStartDx;
                                        arcStartX = x4;
                                    } else {
                                        pathNode = pathNode3;
                                        f = f6;
                                        i = i3;
                                        i2 = size;
                                        if (pathNode instanceof PathNode.ArcTo) {
                                            PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                            drawArc(path, arcStartX, y, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                            arcStartX = arcTo.getArcStartX();
                                            arcStartY = arcTo.getArcStartY();
                                            y = arcStartY;
                                            x4 = arcStartX;
                                        }
                                    }
                                    arcStartX = x3;
                                    y = y3;
                                    pathNode = pathNode3;
                                    f = f6;
                                    i = i3;
                                    i2 = size;
                                    arcStartY = y1;
                                    x4 = x1;
                                }
                                y3 = y + dy;
                                x3 = dx;
                                arcStartX = x3;
                                y = y3;
                                pathNode = pathNode3;
                                f = f6;
                                i = i3;
                                i2 = size;
                                arcStartY = y1;
                                x4 = x1;
                            }
                            pathNode = pathNode3;
                            f = f6;
                            i = i3;
                            i2 = size;
                        }
                        y = y2;
                        arcStartX = x2;
                        pathNode = pathNode3;
                        f = f6;
                        i = i3;
                        i2 = size;
                    }
                    y += dy2;
                    pathNode = pathNode3;
                    f = f6;
                    i = i3;
                    i2 = size;
                }
                arcStartX = f7;
                y = f8;
                pathNode = pathNode3;
                f = f6;
                i = i3;
                i2 = size;
            }
            i3 = i + 1;
            path2 = path;
            pathNode2 = pathNode;
            f6 = f;
            size = i2;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / ((double) RotationOptions.ROTATE_180)) * 3.141592653589793d;
        double dCos = Math.cos(d10);
        double dSin = Math.sin(d10);
        double d11 = ((d * dCos) + (d2 * dSin)) / d5;
        double d12 = (((-d) * dSin) + (d2 * dCos)) / d6;
        double d13 = ((d3 * dCos) + (d4 * dSin)) / d5;
        double d14 = (((-d3) * dSin) + (d4 * dCos)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d15 * d15) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d21);
        double d22 = d15 * dSqrt2;
        double d23 = dSqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d12 - d9, d11 - d8);
        double dAtan3 = Math.atan2(d14 - d9, d13 - d8) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d24 = d8 * d5;
        double d25 = d9 * d6;
        arcToBezier(path, (d24 * dCos) - (d25 * dSin), (d24 * dSin) + (d25 * dCos), d5, d6, d, d2, d10, dAtan2, dAtan3);
    }

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * dCos;
        double d14 = d4 * dSin;
        double d15 = d12 * dSin;
        double d16 = d4 * dCos;
        double d17 = d9 / ((double) iCeil);
        double d18 = d6;
        double d19 = (dSin2 * d13) - (dCos2 * d14);
        double d20 = (dSin2 * d15) + (dCos2 * d16);
        double d21 = d8;
        int i = 0;
        double d22 = d5;
        while (i < iCeil) {
            double d23 = d21 + d17;
            double dSin3 = Math.sin(d23);
            double dCos3 = Math.cos(d23);
            double d24 = d17;
            double d25 = (d + ((d10 * dCos) * dCos3)) - (d14 * dSin3);
            double d26 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
            double d27 = (d13 * dSin3) - (d14 * dCos3);
            double d28 = (dSin3 * d15) + (dCos3 * d16);
            double d29 = d23 - d21;
            int i2 = iCeil;
            double dTan = Math.tan(d29 / ((double) 2));
            double dSin4 = (Math.sin(d29) * (Math.sqrt(d11 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d22 + (d19 * dSin4)), (float) (d18 + (d20 * dSin4)), (float) (d25 - (dSin4 * d27)), (float) (d26 - (dSin4 * d28)), (float) d25, (float) d26);
            i++;
            d18 = d26;
            d22 = d25;
            d21 = d23;
            d20 = d28;
            iCeil = i2;
            d19 = d27;
            dCos = dCos;
            dSin = dSin;
            d10 = d3;
            d17 = d24;
        }
    }
}
