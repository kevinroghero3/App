package com.salesforce.marketingcloud.registration;

import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import o.ArtificialStackFrames;
import o.extraCallback;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Map<String, String> {
    private final HashMap<String, String> b;
    private final TreeMap<String, String> c;
    private static final byte[] $$c = {2, -89, -33, -54};
    private static final int $$d = 187;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, -46, -98, Ascii.DC2, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, 50, Ascii.SO};
    private static final int $$b = 28;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44393, 44405, 44702, 44395, 44391, 44399, 44396, 44361, 44387, 44400, 44386, 44334, 44390, 44397, 44353, 44333, 44701, 44404, 44698, 44337, 44403, 44388, 44699, 44402, 44703, 44385, 44389, 44408, 44690, 44384, 44697, 44696, 44335, 44355, 44398, 44700};
    private static char coroutineCreation = 39068;

    private static String $$e(byte b, int i, int i2) {
        byte[] bArr = $$c;
        int i3 = 105 - i2;
        int i4 = i * 3;
        int i5 = b + 4;
        byte[] bArr2 = new byte[i4 + 1];
        int i6 = -1;
        if (bArr == null) {
            i3 = i4 + i3;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            if (i6 == i4) {
                return new String(bArr2, 0);
            }
            i5++;
            i3 += bArr[i5];
        }
    }

    b() {
        this.b = new HashMap<>();
        this.c = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 115 - r8
            byte[] r0 = com.salesforce.marketingcloud.registration.b.$$a
            int r6 = r6 + 4
            int r1 = 28 - r7
            byte[] r1 = new byte[r1]
            int r7 = 27 - r7
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2b
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r5
        L2b:
            int r3 = r3 + r6
            int r6 = r3 + (-5)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.registration.b.d(int, int, short, java.lang.Object[]):void");
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String get(Object obj) {
        String str = this.c.get(obj);
        if (str != null) {
            return this.b.get(str);
        }
        return null;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String remove(Object obj) {
        return this.b.remove(this.c.remove(obj));
    }

    @Override // java.util.Map
    public void clear() {
        this.b.clear();
        this.c.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.c.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.b.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, String>> entrySet() {
        return this.b.entrySet();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.b.keySet();
    }

    @Override // java.util.Map
    public void putAll(@NonNull Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.b.size();
    }

    @Override // java.util.Map
    public Collection<String> values() {
        return this.b.values();
    }

    b(Map<String, String> map) {
        this();
        if (map != null) {
            this.b.putAll(map);
            for (String str : this.b.keySet()) {
                this.c.put(str, str);
            }
        }
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String put(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = this.c.get(str);
        String strRemove = str3 != null ? this.b.remove(str3) : null;
        this.c.put(str, str);
        this.b.put(str, str2);
        return strRemove;
    }

    private static void e(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        float f = 0.0f;
        Object obj2 = null;
        int i4 = -1;
        int i5 = 6;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) i4;
                        byte b3 = (byte) (b2 + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > f ? 1 : (TypedValue.complexToFloat(0) == f ? 0 : -1)) + 15, (char) (20488 - ((Process.getThreadPriority(0) + 20) >> i5)), 2148 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 216710116, false, $$e(b2, b3, (byte) (b3 | 8)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i6++;
                    f = 0.0f;
                    i4 = -1;
                    i5 = 6;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        try {
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) (-1);
                byte b5 = (byte) (b4 + 1);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - TextUtils.getOffsetBefore("", 0), (char) (20487 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), Color.argb(0, 0, 0, 0) + 2148, 216710116, false, $$e(b4, b5, (byte) (b5 | 8)), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i7 = $10 + 75;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i9 = $10 + 81;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) (-1);
                            byte b7 = (byte) (b6 + 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(45 - TextUtils.lastIndexOf("", '0', 0), (char) (58859 - TextUtils.indexOf("", "", 0, 0)), 2464 - ((Process.getThreadPriority(0) + 20) >> 6), 276640984, false, $$e(b6, b7, (byte) (b7 + 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i11 = $11 + 15;
                            $10 = i11 % 128;
                            int i12 = i11 % 2;
                            try {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b8 = (byte) (-1);
                                    byte b9 = (byte) (b8 + 1);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 24, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 792 - ((Process.getThreadPriority(0) + 20) >> 6), -834291897, false, $$e(b8, b9, b9), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i13];
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i14 = (extracallback.b * cCharValue) + extracallback.j;
                                int i15 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i14];
                                cArr4[extracallback.a + 1] = cArr2[i15];
                            } else {
                                int i16 = (extracallback.b * cCharValue) + extracallback.g;
                                int i17 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i16];
                                cArr4[extracallback.a + 1] = cArr2[i17];
                            }
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                }
            }
            for (int i18 = 0; i18 < i; i18++) {
                int i19 = $10 + 35;
                $11 = i19 % 128;
                int i20 = i19 % 2;
                cArr4[i18] = (char) (cArr4[i18] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineBoundary(android.content.Context r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 3191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.registration.b.coroutineBoundary(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
