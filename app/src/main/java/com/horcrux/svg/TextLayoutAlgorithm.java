package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes6.dex */
public class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        double advance;
        char character;
        TextView element;
        int index;
        double x = 0.0d;
        double y = 0.0d;
        double rotate = 0.0d;
        boolean hidden = false;
        boolean middle = false;
        boolean resolved = false;
        boolean xSpecified = false;
        boolean ySpecified = false;
        boolean addressable = true;
        boolean anchoredChunk = false;
        boolean rotateSpecified = false;
        boolean firstCharacterInResolvedDescendant = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    public class LayoutInput {
        public static int MediaControllerCompatApi21TransportControls;
        public static int fromToken;
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }

        public static int MediaBrowserCompatItemCallback() {
            int i = fromToken;
            int i2 = i % 7444381;
            fromToken = i + 1;
            if (i2 != 0) {
                return MediaControllerCompatApi21TransportControls;
            }
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            MediaControllerCompatApi21TransportControls = iUptimeMillis;
            return iUptimeMillis;
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            } else {
                while (i < str.length()) {
                    arrayList2.add(tSpanView);
                    arrayList.add(textPathView);
                    i++;
                }
                sb.append(str);
                return;
            }
        }
        if (view instanceof TextPathView) {
            textPathView = (TextPathView) view;
        }
        while (i < textPathView.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView.getChildAt(i), textPathView);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x0183  */
    /* JADX WARN: Code duplicated, block: B:67:0x018b  */
    /* JADX WARN: Code duplicated, block: B:70:0x019e  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:77:0x01af  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b9 A[LOOP:6: B:81:0x01b7->B:82:0x01b9, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.horcrux.svg.TextLayoutAlgorithm] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.horcrux.svg.TextPathView] */
    CharacterInformation[] layoutText(LayoutInput layoutInput) {
        boolean z;
        int i;
        ?? r18;
        int i2;
        Object obj;
        Path path;
        ?? r19;
        char c;
        double d;
        double d2;
        double d3;
        double d4;
        int i3;
        double d5;
        int i4;
        int i5;
        TextView textView = layoutInput.text;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        getSubTreeTypographicCharacterPositions(arrayList2, arrayList, sb, textView, null);
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        final CharacterInformation[] characterInformationArr = new CharacterInformation[length];
        for (int i6 = 0; i6 < length; i6++) {
            characterInformationArr[i6] = new CharacterInformation(i6, charArray[i6]);
        }
        if (length == 0) {
            return characterInformationArr;
        }
        PointF[] pointFArr = new PointF[length];
        for (int i7 = 0; i7 < length; i7++) {
            pointFArr[i7] = new PointF(0.0f, 0.0f);
        }
        int i8 = 0;
        while (true) {
            boolean z2 = true;
            if (i8 >= length) {
                break;
            }
            CharacterInformation characterInformation = characterInformationArr[i8];
            characterInformation.addressable = true;
            characterInformation.middle = false;
            if (i8 != 0) {
                z2 = false;
            }
            characterInformation.anchoredChunk = z2;
            pointFArr[i8].set(0.0f, 0.0f);
            i8++;
        }
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        new C1CharacterPositioningResolver(characterInformationArr, strArr, strArr2, new String[length], new String[length]);
        PointF pointF = new PointF(0.0f, 0.0f);
        for (int i9 = 0; i9 < length; i9++) {
            if (strArr[i9].equals("")) {
                strArr[i9] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (strArr2[i9].equals("")) {
                strArr2[i9] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            pointF.x += Float.parseFloat(strArr[i9]);
            float f = pointF.y + Float.parseFloat(strArr2[i9]);
            pointF.y = f;
            CharacterInformation characterInformation2 = characterInformationArr[i9];
            PointF pointF2 = pointFArr[i9];
            characterInformation2.x = pointF2.x + pointF.x;
            characterInformation2.y = pointF2.y + f;
        }
        new Object() { // from class: com.horcrux.svg.TextLayoutAlgorithm.1TextLengthResolver
            int global;

            /* JADX INFO: Access modifiers changed from: private */
            public void resolveTextLength(TextView textView2) {
                Class<?> cls = textView2.getClass();
                boolean z3 = textView2.mTextLength != null;
                if (cls == TSpanView.class && z3) {
                    TSpanView tSpanView = (TSpanView) textView2;
                    String str = tSpanView.mContent;
                    int i10 = this.global;
                    int length2 = (str == null ? 0 : str.length()) + i10;
                    double dMax = Double.NEGATIVE_INFINITY;
                    int i11 = i10;
                    double dMin = Double.POSITIVE_INFINITY;
                    while (i11 <= length2) {
                        CharacterInformation[] characterInformationArr2 = characterInformationArr;
                        CharacterInformation characterInformation3 = characterInformationArr2[i10];
                        if (characterInformation3.addressable) {
                            char c2 = characterInformation3.character;
                            if (c2 == '\n' || c2 == '\r') {
                                return;
                            }
                            CharacterInformation characterInformation4 = characterInformationArr2[i11];
                            double d6 = characterInformation4.x;
                            double d7 = characterInformation4.advance + d6;
                            dMin = Math.min(dMin, Math.min(d6, d7));
                            dMax = Math.max(dMax, Math.max(d6, d7));
                        }
                        i11++;
                        i10 = i10;
                    }
                    int i12 = i10;
                    if (dMin != Double.POSITIVE_INFINITY) {
                        double d8 = textView2.mTextLength.value;
                        int length3 = 0;
                        int i13 = 0;
                        for (int i14 = 0; i14 < textView2.getChildCount(); i14++) {
                            if (((TextPathView) textView2.getChildAt(i14)).mTextLength == null) {
                                String str2 = tSpanView.mContent;
                                length3 += str2 == null ? 0 : str2.length();
                            } else {
                                characterInformationArr[length3].firstCharacterInResolvedDescendant = true;
                                i13++;
                            }
                        }
                        double d9 = (d8 - (dMax - dMin)) / ((double) (length3 + (i13 - 1)));
                        double d10 = 0.0d;
                        for (int i15 = i12; i15 <= length2; i15++) {
                            CharacterInformation characterInformation5 = characterInformationArr[i15];
                            characterInformation5.x += d10;
                            if (!characterInformation5.middle && (!characterInformation5.resolved || characterInformation5.firstCharacterInResolvedDescendant)) {
                                d10 += d9;
                            }
                        }
                    }
                }
            }
        }.resolveTextLength(textView);
        pointF.set(0.0f, 0.0f);
        int i10 = 1;
        while (i10 < length) {
            String str = strArr[i10];
            if (str != null) {
                pointF.x = (float) (Double.parseDouble(str) - characterInformationArr[i10].x);
            }
            String str2 = strArr2[i10];
            if (str2 != null) {
                pointF.y = (float) (Double.parseDouble(str2) - characterInformationArr[i10].y);
            }
            CharacterInformation characterInformation3 = characterInformationArr[i10];
            characterInformation3.x += (double) pointF.x;
            characterInformation3.y += (double) pointF.y;
            if (characterInformation3.middle && characterInformation3.anchoredChunk) {
                characterInformation3.anchoredChunk = false;
            }
            i10++;
            if (i10 < length) {
                characterInformationArr[i10].anchoredChunk = true;
            }
        }
        int i11 = 0;
        int i12 = 0;
        double d6 = Double.POSITIVE_INFINITY;
        double d7 = Double.NEGATIVE_INFINITY;
        double d8 = Double.POSITIVE_INFINITY;
        double d9 = Double.NEGATIVE_INFINITY;
        while (i11 < length) {
            CharacterInformation characterInformation4 = characterInformationArr[i11];
            if (characterInformation4.addressable) {
                if (characterInformation4.anchoredChunk) {
                    d = Double.POSITIVE_INFINITY;
                    d2 = Double.NEGATIVE_INFINITY;
                } else {
                    d = d6;
                    d2 = d7;
                    d6 = d8;
                    d7 = d9;
                }
                double d10 = characterInformation4.x;
                double d11 = characterInformation4.advance + d10;
                double dMin = Math.min(d, Math.min(d10, d11));
                double dMax = Math.max(d2, Math.max(d10, d11));
                if (i11 > 0 && characterInformationArr[i11].anchoredChunk) {
                    if (d6 != Double.POSITIVE_INFINITY) {
                        TextProperties.TextAnchor textAnchor = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction = TextProperties.Direction.ltr;
                        i3 = length - 1;
                        if (i11 == i3) {
                            d6 = dMin;
                            d7 = dMax;
                        }
                        d5 = characterInformationArr[i12].x;
                        i4 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                        if (i4 != 1) {
                            d5 -= d6;
                        } else if (i4 != 2) {
                            d5 -= (d6 + d7) / 2.0d;
                        } else if (i4 == 3) {
                            d5 -= d7;
                        }
                        if (i11 == i3) {
                            i5 = i11;
                        } else {
                            i5 = i11 - 1;
                        }
                        while (i12 <= i5) {
                            characterInformationArr[i12].x += d5;
                            i12++;
                        }
                        i12 = i11;
                    }
                    d3 = d7;
                    d7 = dMax;
                    d4 = d6;
                    d6 = dMin;
                }
                if (i11 == length - 1) {
                    TextProperties.TextAnchor textAnchor2 = TextProperties.TextAnchor.start;
                    TextProperties.Direction direction2 = TextProperties.Direction.ltr;
                    i3 = length - 1;
                    if (i11 == i3) {
                        d6 = dMin;
                        d7 = dMax;
                    }
                    d5 = characterInformationArr[i12].x;
                    i4 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor2.ordinal()];
                    if (i4 != 1) {
                        d5 -= d6;
                    } else if (i4 != 2) {
                        d5 -= (d6 + d7) / 2.0d;
                    } else if (i4 == 3) {
                        d5 -= d7;
                    }
                    if (i11 == i3) {
                        i5 = i11;
                    } else {
                        i5 = i11 - 1;
                    }
                    while (i12 <= i5) {
                        characterInformationArr[i12].x += d5;
                        i12++;
                    }
                    i12 = i11;
                }
                d3 = d7;
                d7 = dMax;
                d4 = d6;
                d6 = dMin;
            } else {
                d4 = d8;
                d3 = d9;
                arrayList2 = arrayList2;
            }
            i11++;
            d9 = d3;
            arrayList2 = arrayList2;
            d8 = d4;
        }
        ArrayList arrayList3 = arrayList2;
        PointF pointF3 = new PointF(0.0f, 0.0f);
        PathMeasure pathMeasure = new PathMeasure();
        ?? r2 = 0;
        Path path2 = null;
        boolean z3 = false;
        int i13 = 0;
        boolean z4 = false;
        while (i13 < length) {
            ArrayList arrayList4 = arrayList3;
            ?? r9 = (TextPathView) arrayList4.get(i13);
            if (r9 == 0 || !characterInformationArr[i13].addressable) {
                z = z3;
                i = i12;
                arrayList3 = arrayList4;
                r18 = r9;
                i2 = length;
            } else {
                Path textPath = r9.getTextPath(r2, r2);
                CharacterInformation characterInformation5 = characterInformationArr[i13];
                if (!characterInformation5.middle) {
                    r9.getSide();
                    TextProperties.TextPathSide textPathSide = TextProperties.TextPathSide.right;
                    pathMeasure.setPath(textPath, false);
                    double length2 = pathMeasure.getLength();
                    z = z3;
                    double d12 = r9.getStartOffset().value;
                    CharacterInformation characterInformation6 = characterInformationArr[i13];
                    i2 = length;
                    double d13 = characterInformation6.advance;
                    arrayList3 = arrayList4;
                    ?? r110 = r9;
                    double d14 = characterInformation6.x;
                    path = textPath;
                    i = i12;
                    double d15 = characterInformation6.y;
                    double d16 = characterInformation6.rotate;
                    double d17 = d14 + (d13 / 2.0d) + d12;
                    if (!pathMeasure.isClosed() && (d17 < 0.0d || d17 > length2)) {
                        characterInformationArr[i13].hidden = true;
                    }
                    if (pathMeasure.isClosed()) {
                        TextProperties.TextAnchor textAnchor3 = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction3 = TextProperties.Direction.ltr;
                        double d18 = characterInformationArr[i].x;
                        int i14 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor3.ordinal()];
                        if (i14 == 1) {
                            c = 1;
                            if (d17 < 0.0d || d17 > length2) {
                                characterInformationArr[i13].hidden = true;
                            }
                        } else if (i14 != 2) {
                            if (i14 == 3 && (d17 < (-length2) || d17 > 0.0d)) {
                                characterInformationArr[i13].hidden = true;
                                c = 1;
                            }
                        } else if (d17 < (-length2) / 2.0d || d17 > length2 / 2.0d) {
                            c = 1;
                            characterInformationArr[i13].hidden = true;
                        }
                        r19 = r110;
                        if (!characterInformationArr[i13].hidden) {
                            float[] fArr = new float[2];
                            pathMeasure.getPosTan((float) (d17 % length2), new float[2], fArr);
                            double dAtan2 = Math.atan2(fArr[c], fArr[0]) * 57.29577951308232d;
                            double d19 = 90.0d + dAtan2;
                            Math.cos(d19);
                            Math.sin(d19);
                            characterInformationArr[i13].rotate += dAtan2;
                            r19 = r110;
                        }
                    }
                    c = 1;
                    r19 = r110;
                    if (!characterInformationArr[i13].hidden) {
                        float[] fArr2 = new float[2];
                        pathMeasure.getPosTan((float) (d17 % length2), new float[2], fArr2);
                        double dAtan3 = Math.atan2(fArr2[c], fArr2[0]) * 57.29577951308232d;
                        double d110 = 90.0d + dAtan3;
                        Math.cos(d110);
                        Math.sin(d110);
                        characterInformationArr[i13].rotate += dAtan3;
                        r19 = r110;
                    }
                } else {
                    z = z3;
                    path = textPath;
                    i = i12;
                    arrayList3 = arrayList4;
                    r19 = r9;
                    i2 = length;
                    CharacterInformation characterInformation7 = characterInformationArr[i13 - 1];
                    characterInformation5.x = characterInformation7.x;
                    characterInformation5.y = characterInformation7.y;
                    characterInformation5.rotate = characterInformation7.rotate;
                }
                path2 = path;
                z4 = true;
                r18 = r19;
            }
            if (r18 == 0 && characterInformationArr[i13].addressable) {
                if (z4) {
                    pathMeasure.setPath(path2, false);
                    float[] fArr3 = new float[2];
                    obj = null;
                    pathMeasure.getPosTan(pathMeasure.getLength(), fArr3, null);
                    pointF3.set(fArr3[0], fArr3[1]);
                    z4 = false;
                    z = true;
                } else {
                    obj = null;
                }
                if (z) {
                    CharacterInformation characterInformation8 = characterInformationArr[i13];
                    if (characterInformation8.anchoredChunk) {
                        z3 = false;
                    } else {
                        characterInformation8.x += (double) pointF3.x;
                        characterInformation8.y += (double) pointF3.y;
                    }
                }
                i13++;
                r2 = obj;
                length = i2;
                i12 = i;
            } else {
                obj = null;
            }
            z3 = z;
            i13++;
            r2 = obj;
            length = i2;
            i12 = i;
        }
        return characterInformationArr;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver, reason: invalid class name */
    class C1CharacterPositioningResolver {
        private int global;
        private boolean horizontal;
        private boolean in_text_path;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        private C1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.global = 0;
            this.horizontal = true;
            this.in_text_path = false;
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            boolean z = false;
            if (textView.getClass() == TextView.class || textView.getClass() == TSpanView.class) {
                int i = this.global;
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                String[] strArr3 = new String[0];
                String[] strArr4 = new String[0];
                double[] dArr = new double[0];
                int iMax = !this.in_text_path ? Math.max(0, 0) : 0;
                String str = ((TSpanView) textView).mContent;
                int length = str == null ? 0 : str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    CharacterInformation[] characterInformationArr = this.result;
                    int i4 = i + i2;
                    CharacterInformation characterInformation = characterInformationArr[i4];
                    if (characterInformation.addressable) {
                        characterInformation.anchoredChunk = i3 < iMax ? true : z;
                        if (i3 < 0) {
                            this.resolve_x[i4] = strArr[i3];
                        }
                        boolean z2 = this.in_text_path;
                        if (z2 && !this.horizontal) {
                            this.resolve_x[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_y[i4] = strArr2[i3];
                        }
                        if (z2 && this.horizontal) {
                            this.resolve_y[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_dx[i4] = strArr3[i3];
                        }
                        if (i3 < 0) {
                            this.resolve_dy[i4] = strArr4[i3];
                        }
                        if (i3 < 0) {
                            characterInformationArr[i4].rotate = dArr[i3];
                        }
                    }
                    i3++;
                    i2++;
                    z = false;
                }
                return;
            }
            if (textView.getClass() == TextPathView.class) {
                this.result[this.global].anchoredChunk = true;
                this.in_text_path = true;
                for (int i5 = 0; i5 < textView.getChildCount(); i5++) {
                    resolveCharacterPositioning((TextView) textView.getChildAt(i5));
                }
                if (textView instanceof TextPathView) {
                    this.in_text_path = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;

        static {
            int[] iArr = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr;
            try {
                iArr[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
