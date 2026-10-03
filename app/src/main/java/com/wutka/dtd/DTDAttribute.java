package com.wutka.dtd;

import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DTDAttribute implements DTDOutput {
    public DTDDecl decl;
    public String defaultValue;
    public String name;
    public Object type;
    private static final byte[] $$c = {47, 75, -118, 7};
    private static final int $$d = 219;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {71, -70, 54, 33, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, 50, Ascii.SO, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4};
    private static final int $$b = 235;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-2044724249, 1953001498, -527020050, -1932477614, 1718390347, 783755108, -1071211841, -441894739, 1860604332, -559958505, -342717779, -1413099842, 739655873, -7724316, -1052132542, 200495157, -1627550526, 753228822};

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r5, short r6, int r7) {
        /*
            int r5 = r5 * 3
            int r5 = 4 - r5
            int r6 = r6 * 4
            int r0 = r6 + 1
            byte[] r1 = com.wutka.dtd.DTDAttribute.$$c
            int r7 = r7 * 6
            int r7 = 115 - r7
            byte[] r0 = new byte[r0]
            r2 = -1
            if (r1 != 0) goto L16
            r3 = r7
            r7 = r5
            goto L29
        L16:
            r4 = r7
            r7 = r5
            r5 = r4
        L19:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r0[r2] = r3
            if (r2 != r6) goto L27
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r0, r6)
            return r5
        L27:
            r3 = r1[r7]
        L29:
            int r5 = r5 + r3
            int r7 = r7 + 1
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wutka.dtd.DTDAttribute.$$e(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0023). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 + 2
            int r7 = r7 + 4
            byte[] r0 = com.wutka.dtd.DTDAttribute.$$a
            int r6 = r6 + 66
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r6
            r3 = r2
            r6 = r5
            goto L23
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L21:
            r4 = r0[r7]
        L23:
            int r6 = r6 + r4
            int r6 = r6 + (-5)
            int r7 = r7 + 1
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wutka.dtd.DTDAttribute.a(int, int, short, java.lang.Object[]):void");
    }

    public DTDAttribute() {
    }

    public DTDAttribute(String str) {
        this.name = str;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(StringUtils.SPACE);
        printWriter.print(stringBuffer.toString());
        Object obj = this.type;
        if (obj instanceof String) {
            printWriter.print(obj);
        } else if (obj instanceof DTDEnumeration) {
            ((DTDEnumeration) obj).write(printWriter);
        } else if (obj instanceof DTDNotationList) {
            ((DTDNotationList) obj).write(printWriter);
        }
        DTDDecl dTDDecl = this.decl;
        if (dTDDecl != null) {
            dTDDecl.write(printWriter);
        }
        if (this.defaultValue != null) {
            printWriter.print(" \"");
            printWriter.print(this.defaultValue);
            printWriter.print("\"");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDAttribute)) {
            return false;
        }
        DTDAttribute dTDAttribute = (DTDAttribute) obj;
        String str = this.name;
        if (str == null) {
            if (dTDAttribute.name != null) {
                return false;
            }
        } else if (!str.equals(dTDAttribute.name)) {
            return false;
        }
        Object obj2 = this.type;
        if (obj2 == null) {
            if (dTDAttribute.type != null) {
                return false;
            }
        } else if (!obj2.equals(dTDAttribute.type)) {
            return false;
        }
        DTDDecl dTDDecl = this.decl;
        if (dTDDecl == null) {
            if (dTDAttribute.decl != null) {
                return false;
            }
        } else if (!dTDDecl.equals(dTDAttribute.decl)) {
            return false;
        }
        String str2 = this.defaultValue;
        if (str2 == null) {
            if (dTDAttribute.defaultValue != null) {
                return false;
            }
        } else if (!str2.equals(dTDAttribute.defaultValue)) {
            return false;
        }
        return true;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setType(Object obj) {
        if (!(obj instanceof String) && !(obj instanceof DTDEnumeration) && !(obj instanceof DTDNotationList)) {
            throw new IllegalArgumentException("Must be String, DTDEnumeration or DTDNotationList");
        }
        this.type = obj;
    }

    public Object getType() {
        return this.type;
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        String str = "";
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        long j = 0;
        int i3 = -1780896814;
        int i4 = 16;
        int i5 = 1;
        int i6 = 0;
        if (iArr3 != null) {
            int i7 = $11 + 61;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i9 = 0;
            while (i9 < length2) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i6] = Integer.valueOf(iArr3[i9]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        int i10 = 12 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1));
                        char mirror = (char) ('0' - AndroidCharacter.getMirror('0'));
                        int longPressTimeout = 1562 - (ViewConfiguration.getLongPressTimeout() >> i4);
                        byte b = (byte) i6;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i10, mirror, longPressTimeout, 180153818, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                    }
                    iArr4[i9] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i9++;
                    j = 0;
                    i3 = -1780896814;
                    i4 = 16;
                    i6 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = ICustomTabsCallbackStub;
        if (iArr6 != null) {
            int i11 = $10 + 33;
            $11 = i11 % 128;
            if (i11 % 2 == 0) {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i12 = 0;
            while (i12 < length) {
                int i13 = $11 + 63;
                $10 = i13 % 128;
                int i14 = i13 % 2;
                Object[] objArr3 = new Object[i5];
                objArr3[0] = Integer.valueOf(iArr6[i12]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.indexOf(str, str, 0) + 1562, 180153818, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
                }
                iArr2[i12] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i12++;
                str = str;
                i5 = 1;
            }
            iArr6 = iArr2;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            int i15 = $10 + 5;
            $11 = i15 % 128;
            int i16 = i15 % 2;
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            int i17 = $11 + 87;
            $10 = i17 % 128;
            if (i17 % 2 != 0) {
                int i18 = 2 % 4;
            }
            for (int i19 = 0; i19 < 16; i19++) {
                artificialframe.c ^= iArr5[i19];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1041, 995482881, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
            }
            int i20 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i20;
            artificialframe.b ^= iArr5[16];
            artificialframe.c ^= iArr5[17];
            int i21 = artificialframe.c;
            int i22 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr5);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            try {
                Object[] objArr5 = {artificialframe, artificialframe};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 37, (char) (Drawable.resolveOpacity(0, 0) + 28010), 306 - (ViewConfiguration.getScrollDefaultDelay() >> 16), -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        String str2 = new String(cArr2, 0, i);
        int i23 = $10 + 39;
        $11 = i23 % 128;
        int i24 = i23 % 2;
        objArr[0] = str2;
    }

    public void setDecl(DTDDecl dTDDecl) {
        this.decl = dTDDecl;
    }

    public DTDDecl getDecl() {
        return this.decl;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 2686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wutka.dtd.DTDAttribute.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
