package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch.qos.logback.core.net.SyslogConstants;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes3.dex */
class PathParser {
    static ArrayList<PathElement> elements;
    private static int i;
    private static int l;
    private static Path mPath;
    private static boolean mPenDown;
    private static float mPenDownX;
    private static float mPenDownY;
    private static float mPenX;
    private static float mPenY;
    private static float mPivotX;
    private static float mPivotY;
    static float mScale;
    private static String s;

    private static boolean is_cmd(char c) {
        switch (c) {
            case 'A':
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case SyslogConstants.LOG_CRON /* 72 */:
            case Base64.mimeLineLength /* 76 */:
            case 'M':
            case 'Q':
            case 'S':
            case 'T':
            case 'V':
            case 'Z':
            case TSGeofenceManager.MAX_GEOFENCES /* 97 */:
            case 'c':
            case 'h':
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
            case 'q':
            case 's':
            case 't':
            case 'v':
            case 'z':
                return true;
            default:
                return false;
        }
    }

    private static boolean is_number_start(char c) {
        return (c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+';
    }

    PathParser() {
    }

    static Path parse(String str) {
        elements = new ArrayList<>();
        Path path = new Path();
        mPath = path;
        if (str == null) {
            return path;
        }
        l = str.length();
        s = str;
        i = 0;
        mPenX = 0.0f;
        mPenY = 0.0f;
        mPivotX = 0.0f;
        mPivotY = 0.0f;
        mPenDownX = 0.0f;
        mPenDownY = 0.0f;
        mPenDown = false;
        char c = ' ';
        while (i < l) {
            skip_spaces();
            int i2 = i;
            if (i2 < l) {
                boolean z = true;
                boolean z2 = c != ' ';
                char cCharAt = s.charAt(i2);
                if (!z2 && cCharAt != 'M' && cCharAt != 'm') {
                    throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(i), s));
                }
                if (is_cmd(cCharAt)) {
                    i++;
                    z = false;
                    c = cCharAt;
                } else {
                    if (!is_number_start(cCharAt) || !z2) {
                        throw new IllegalArgumentException(String.format("Unexpected character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(i), s));
                    }
                    if (c == 'Z' || c == 'z') {
                        throw new IllegalArgumentException(String.format("Unexpected number after 'z' (s=%s)", s));
                    }
                    if (c == 'M' || c == 'm') {
                        c = is_absolute(c) ? 'L' : 'l';
                    } else {
                        z = false;
                    }
                }
                boolean zIs_absolute = is_absolute(c);
                switch (c) {
                    case 'A':
                        arcTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_flag(), parse_flag(), parse_list_number(), parse_list_number());
                        break;
                    case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                        curveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case SyslogConstants.LOG_CRON /* 72 */:
                        lineTo(parse_list_number(), mPenY);
                        break;
                    case Base64.mimeLineLength /* 76 */:
                        lineTo(parse_list_number(), parse_list_number());
                        break;
                    case 'M':
                        moveTo(parse_list_number(), parse_list_number());
                        break;
                    case 'Q':
                        quadraticBezierCurveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'S':
                        smoothCurveTo(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'T':
                        smoothQuadraticBezierCurveTo(parse_list_number(), parse_list_number());
                        break;
                    case 'V':
                        lineTo(mPenX, parse_list_number());
                        break;
                    case 'Z':
                    case 'z':
                        close();
                        break;
                    case TSGeofenceManager.MAX_GEOFENCES /* 97 */:
                        arc(parse_list_number(), parse_list_number(), parse_list_number(), parse_flag(), parse_flag(), parse_list_number(), parse_list_number());
                        break;
                    case 'c':
                        curve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 'h':
                        line(parse_list_number(), 0.0f);
                        break;
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                        line(parse_list_number(), parse_list_number());
                        break;
                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                        move(parse_list_number(), parse_list_number());
                        break;
                    case 'q':
                        quadraticBezierCurve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 's':
                        smoothCurve(parse_list_number(), parse_list_number(), parse_list_number(), parse_list_number());
                        break;
                    case 't':
                        smoothQuadraticBezierCurve(parse_list_number(), parse_list_number());
                        break;
                    case 'v':
                        line(0.0f, parse_list_number());
                        break;
                    default:
                        throw new IllegalArgumentException(String.format("Unexpected comand '%c' (s=%s)", Character.valueOf(c), s));
                }
                if (z) {
                    c = zIs_absolute ? 'M' : 'm';
                }
            } else {
                return mPath;
            }
        }
        return mPath;
    }

    private static void move(float f, float f2) {
        moveTo(f + mPenX, f2 + mPenY);
    }

    private static void moveTo(float f, float f2) {
        mPenX = f;
        mPivotX = f;
        mPenDownX = f;
        mPenY = f2;
        mPivotY = f2;
        mPenDownY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.moveTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(f, f2)}));
    }

    private static void line(float f, float f2) {
        lineTo(f + mPenX, f2 + mPenY);
    }

    private static void lineTo(float f, float f2) {
        setPenDown();
        mPenX = f;
        mPivotX = f;
        mPenY = f2;
        mPivotY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.lineTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point(f, f2)}));
    }

    private static void curve(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = mPenX;
        float f8 = mPenY;
        curveTo(f + f7, f2 + f8, f3 + f7, f4 + f8, f5 + f7, f6 + f8);
    }

    private static void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        mPivotX = f3;
        mPivotY = f4;
        cubicTo(f, f2, f3, f4, f5, f6);
    }

    private static void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        setPenDown();
        mPenX = f5;
        mPenY = f6;
        Path path = mPath;
        float f7 = mScale;
        path.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f, f2), new Point(f3, f4), new Point(f5, f6)}));
    }

    private static void smoothCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        smoothCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void smoothCurveTo(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPivotX;
        float f7 = mPenY;
        float f8 = mPivotY;
        mPivotX = f;
        mPivotY = f2;
        cubicTo((f5 * 2.0f) - f6, (f7 * 2.0f) - f8, f, f2, f3, f4);
    }

    private static void quadraticBezierCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        quadraticBezierCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void quadraticBezierCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        float f5 = f * 2.0f;
        float f6 = f2 * 2.0f;
        cubicTo((mPenX + f5) / 3.0f, (mPenY + f6) / 3.0f, (f3 + f5) / 3.0f, (f4 + f6) / 3.0f, f3, f4);
    }

    private static void smoothQuadraticBezierCurve(float f, float f2) {
        smoothQuadraticBezierCurveTo(f + mPenX, f2 + mPenY);
    }

    private static void smoothQuadraticBezierCurveTo(float f, float f2) {
        float f3 = mPenX;
        quadraticBezierCurveTo((f3 * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2);
    }

    private static void arc(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        arcTo(f, f2, f3, z, z2, f4 + mPenX, f5 + mPenY);
    }

    private static void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9 = mPenX;
        float f10 = mPenY;
        if (f2 == 0.0f) {
            f6 = f == 0.0f ? f5 - f10 : f;
        } else {
            f6 = f2;
        }
        float fAbs = Math.abs(f6);
        float fAbs2 = Math.abs(f == 0.0f ? f4 - f9 : f);
        if (fAbs2 == 0.0f || fAbs == 0.0f || (f4 == f9 && f5 == f10)) {
            lineTo(f4, f5);
            return;
        }
        float radians = (float) Math.toRadians(f3);
        double d = radians;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f11 = f4 - f9;
        float f12 = f5 - f10;
        float f13 = ((fCos * f11) / 2.0f) + ((fSin * f12) / 2.0f);
        float f14 = -fSin;
        float f15 = ((f14 * f11) / 2.0f) + ((fCos * f12) / 2.0f);
        float f16 = fAbs2 * fAbs2;
        float f17 = f16 * fAbs * fAbs;
        float f18 = fAbs * fAbs * f13 * f13;
        float f19 = f16 * f15 * f15;
        float f20 = (f17 - f19) - f18;
        if (f20 < 0.0f) {
            float fSqrt = (float) Math.sqrt(1.0f - (f20 / f17));
            fAbs2 *= fSqrt;
            fAbs *= fSqrt;
            f8 = f11 / 2.0f;
            f7 = f12 / 2.0f;
        } else {
            float fSqrt2 = (float) Math.sqrt(f20 / (f19 + f18));
            if (z == z2) {
                fSqrt2 = -fSqrt2;
            }
            float f21 = (((-fSqrt2) * f15) * fAbs2) / fAbs;
            float f22 = ((fSqrt2 * f13) * fAbs) / fAbs2;
            f7 = (f12 / 2.0f) + (f21 * fSin) + (f22 * fCos);
            f8 = ((fCos * f21) - (fSin * f22)) + (f11 / 2.0f);
        }
        float f23 = fCos / fAbs2;
        float f24 = fSin / fAbs2;
        float f25 = f14 / fAbs;
        float f26 = fCos / fAbs;
        float f27 = -f8;
        float f28 = -f7;
        float f29 = fAbs;
        float f30 = fAbs2;
        float fAtan2 = (float) Math.atan2((f25 * f27) + (f26 * f28), (f27 * f23) + (f28 * f24));
        float f31 = f11 - f8;
        float f32 = f12 - f7;
        float fAtan3 = (float) Math.atan2((f25 * f31) + (f26 * f32), (f23 * f31) + (f24 * f32));
        float f33 = f8 + f9;
        float f34 = f7 + f10;
        float f35 = f11 + f9;
        float f36 = f12 + f10;
        setPenDown();
        mPivotX = f35;
        mPenX = f35;
        mPivotY = f36;
        mPenY = f36;
        if (f30 != f29 || radians != 0.0f) {
            arcToBezier(f33, f34, f30, f29, fAtan2, fAtan3, z2, radians);
            return;
        }
        float degrees = (float) Math.toDegrees(fAtan2);
        float fAbs3 = Math.abs((degrees - ((float) Math.toDegrees(fAtan3))) % 360.0f);
        if (!z ? fAbs3 > 180.0f : fAbs3 < 180.0f) {
            fAbs3 = 360.0f - fAbs3;
        }
        if (!z2) {
            fAbs3 = -fAbs3;
        }
        float f37 = mScale;
        mPath.arcTo(new RectF((f33 - f30) * f37, (f34 - f30) * f37, (f33 + f30) * f37, (f34 + f30) * f37), degrees, fAbs3);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f35, f36)}));
    }

    private static void close() {
        if (mPenDown) {
            mPenX = mPenDownX;
            mPenY = mPenDownY;
            mPenDown = false;
            mPath.close();
            elements.add(new PathElement(ElementType.kCGPathElementCloseSubpath, new Point[]{new Point(mPenX, mPenY)}));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0066 A[LOOP:0: B:12:0x0064->B:13:0x0066, LOOP_END] */
    private static void arcToBezier(float f, float f2, float f3, float f4, float f5, float f6, boolean z, float f7) {
        double d;
        int iCeil;
        float f8;
        float fTan;
        float fCos;
        float fSin;
        int i2;
        float f9 = f5;
        double d2 = f7;
        float fCos2 = (float) Math.cos(d2);
        float fSin2 = (float) Math.sin(d2);
        float f10 = fCos2 * f3;
        float f11 = (-fSin2) * f4;
        float f12 = fSin2 * f3;
        float f13 = fCos2 * f4;
        float f14 = f6 - f9;
        if (f14 >= 0.0f || !z) {
            if (f14 > 0.0f && !z) {
                d = ((double) f14) - 6.283185307179586d;
            }
            iCeil = (int) Math.ceil(Math.abs(round(((double) f14) / 1.5707963267948966d)));
            f8 = f14 / iCeil;
            fTan = (float) (Math.tan(f8 / 4.0f) * 1.3333333333333333d);
            double d3 = f9;
            fCos = (float) Math.cos(d3);
            fSin = (float) Math.sin(d3);
            i2 = 0;
            while (i2 < iCeil) {
                float f15 = fCos - (fTan * fSin);
                float f16 = fSin + (fCos * fTan);
                float f17 = f9 + f8;
                double d4 = f17;
                fCos = (float) Math.cos(d4);
                float fSin3 = (float) Math.sin(d4);
                float f18 = (fTan * fSin3) + fCos;
                float f19 = fSin3 - (fTan * fCos);
                float f20 = f + (f10 * f15) + (f11 * f16);
                float f21 = f2 + (f15 * f12) + (f16 * f13);
                float f22 = f + (f10 * f18) + (f11 * f19);
                float f23 = f2 + (f18 * f12) + (f19 * f13);
                float f24 = f + (f10 * fCos) + (f11 * fSin3);
                float f25 = f2 + (f12 * fCos) + (f13 * fSin3);
                Path path = mPath;
                float f26 = mScale;
                path.cubicTo(f20 * f26, f21 * f26, f22 * f26, f23 * f26, f24 * f26, f25 * f26);
                float f27 = f11;
                elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f20, f21), new Point(f22, f23), new Point(f24, f25)}));
                i2++;
                f9 = f17;
                f13 = f13;
                f8 = f8;
                f12 = f12;
                fSin = fSin3;
                iCeil = iCeil;
                f10 = f10;
                f11 = f27;
                fTan = fTan;
            }
        }
        d = ((double) f14) + 6.283185307179586d;
        f14 = (float) d;
        iCeil = (int) Math.ceil(Math.abs(round(((double) f14) / 1.5707963267948966d)));
        f8 = f14 / iCeil;
        fTan = (float) (Math.tan(f8 / 4.0f) * 1.3333333333333333d);
        double d5 = f9;
        fCos = (float) Math.cos(d5);
        fSin = (float) Math.sin(d5);
        i2 = 0;
        while (i2 < iCeil) {
            float f110 = fCos - (fTan * fSin);
            float f111 = fSin + (fCos * fTan);
            float f112 = f9 + f8;
            double d6 = f112;
            fCos = (float) Math.cos(d6);
            float fSin4 = (float) Math.sin(d6);
            float f113 = (fTan * fSin4) + fCos;
            float f114 = fSin4 - (fTan * fCos);
            float f28 = f + (f10 * f110) + (f11 * f111);
            float f29 = f2 + (f110 * f12) + (f111 * f13);
            float f210 = f + (f10 * f113) + (f11 * f114);
            float f211 = f2 + (f113 * f12) + (f114 * f13);
            float f212 = f + (f10 * fCos) + (f11 * fSin4);
            float f213 = f2 + (f12 * fCos) + (f13 * fSin4);
            Path path2 = mPath;
            float f214 = mScale;
            path2.cubicTo(f28 * f214, f29 * f214, f210 * f214, f211 * f214, f212 * f214, f213 * f214);
            float f215 = f11;
            elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point(f28, f29), new Point(f210, f211), new Point(f212, f213)}));
            i2++;
            f9 = f112;
            f13 = f13;
            f8 = f8;
            f12 = f12;
            fSin = fSin4;
            iCeil = iCeil;
            f10 = f10;
            f11 = f215;
            fTan = fTan;
        }
    }

    private static void setPenDown() {
        if (mPenDown) {
            return;
        }
        mPenDownX = mPenX;
        mPenDownY = mPenY;
        mPenDown = true;
    }

    private static double round(double d) {
        double dPow = Math.pow(10.0d, 4.0d);
        return Math.round(d * dPow) / dPow;
    }

    private static void skip_spaces() {
        while (true) {
            int i2 = i;
            if (i2 >= l || !Character.isWhitespace(s.charAt(i2))) {
                return;
            } else {
                i++;
            }
        }
    }

    private static boolean is_absolute(char c) {
        return Character.isUpperCase(c);
    }

    private static boolean parse_flag() {
        skip_spaces();
        char cCharAt = s.charAt(i);
        if (cCharAt == '0' || cCharAt == '1') {
            int i2 = i + 1;
            i = i2;
            if (i2 < l && s.charAt(i2) == ',') {
                i++;
            }
            skip_spaces();
            return cCharAt == '1';
        }
        throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", Character.valueOf(cCharAt), Integer.valueOf(i), s));
    }

    private static float parse_list_number() {
        if (i == l) {
            throw new Error(String.format("Unexpected end (s=%s)", s));
        }
        float f = parse_number();
        skip_spaces();
        parse_list_separator();
        return f;
    }

    private static float parse_number() {
        int i2;
        char cCharAt;
        skip_spaces();
        int i3 = i;
        if (i3 == l) {
            throw new Error(String.format("Unexpected end (s=%s)", s));
        }
        char cCharAt2 = s.charAt(i3);
        if (cCharAt2 == '-' || cCharAt2 == '+') {
            int i4 = i + 1;
            i = i4;
            cCharAt2 = s.charAt(i4);
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            skip_digits();
            int i5 = i;
            if (i5 < l) {
                cCharAt2 = s.charAt(i5);
            }
        } else if (cCharAt2 != '.') {
            throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt2), Integer.valueOf(i), s));
        }
        if (cCharAt2 == '.') {
            i++;
            skip_digits();
            int i6 = i;
            if (i6 < l) {
                cCharAt2 = s.charAt(i6);
            }
        }
        if ((cCharAt2 == 'e' || cCharAt2 == 'E') && (i2 = i + 1) < l && (cCharAt = s.charAt(i2)) != 'm' && cCharAt != 'x') {
            int i7 = i + 1;
            i = i7;
            char cCharAt3 = s.charAt(i7);
            if (cCharAt3 == '+' || cCharAt3 == '-') {
                i++;
                skip_digits();
            } else if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                skip_digits();
            } else {
                throw new IllegalArgumentException(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(cCharAt3), Integer.valueOf(i), s));
            }
        }
        String strSubstring = s.substring(i3, i);
        float f = Float.parseFloat(strSubstring);
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            return f;
        }
        throw new IllegalArgumentException(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", strSubstring, Integer.valueOf(i3), Integer.valueOf(i), s));
    }

    private static void parse_list_separator() {
        int i2 = i;
        if (i2 >= l || s.charAt(i2) != ',') {
            return;
        }
        i++;
    }

    private static void skip_digits() {
        while (true) {
            int i2 = i;
            if (i2 >= l || !Character.isDigit(s.charAt(i2))) {
                return;
            } else {
                i++;
            }
        }
    }
}
