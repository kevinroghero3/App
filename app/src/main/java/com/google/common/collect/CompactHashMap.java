package com.google.common.collect;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onRelationshipValidationResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();

    @CheckForNull
    transient int[] entries;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;

    @CheckForNull
    private transient Set<K> keySetView;

    @CheckForNull
    transient Object[] keys;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    @CheckForNull
    transient Object[] values;

    @CheckForNull
    private transient Collection<V> valuesView;

    void accessEntry(int i) {
    }

    int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;
        private static final byte[] $$c = {118, 52, 73, 45};
        private static final int $$d = 254;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.DC2, -20, 124, 53, 3, Ascii.DC4, -49, Ascii.SYN, -3, 8, 50, Ascii.SO, 36, 8, 3, -9, Ascii.SO, -5, 8, 5, Ascii.ESC, Ascii.SYN, -16, -2, Ascii.DC2, 3, -9, 5, Ascii.VT, 0, -8, Ascii.DC4, Ascii.US, 5, Ascii.DLE, -50, 32, 8, 6, 1, 1, -6, Ascii.GS, 10, 2, 5, -5, Ascii.SYN, -16, 10, Ascii.DC2, 10, 4, Ascii.DLE, 5};
        private static final int $$b = 236;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long onPostMessage = 3935185670522616604L;
        private static char[] ArtificialStackFrames = {44335, 44403, 44408, 44409, 44334, 44345, 44386, 44400, 44389, 44398, 44402, 44396, 44385, 44410, 44395, 44381, 44342, 44333, 44407, 44339, 44397, 44393, 44337, 44391, 44406, 44331, 44383, 44387, 44336, 44399, 44404, 44388, 44379, 44392, 44405, 44390};
        private static char coroutineCreation = 39068;

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, int r7, byte r8) {
            /*
                int r8 = r8 * 2
                int r0 = r8 + 1
                int r7 = r7 * 2
                int r7 = 4 - r7
                int r6 = r6 + 97
                byte[] r1 = com.google.common.collect.CompactHashMap.Itr.$$c
                byte[] r0 = new byte[r0]
                r2 = 0
                if (r1 != 0) goto L15
                r3 = r7
                r7 = r8
                r4 = r2
                goto L2a
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r0[r3] = r4
                if (r3 != r8) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L21:
                int r3 = r3 + 1
                r4 = r1[r7]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2a:
                int r6 = -r6
                int r6 = r6 + r7
                int r7 = r3 + 1
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.Itr.$$e(int, int, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 + 4
                int r8 = 4 - r8
                byte[] r0 = com.google.common.collect.CompactHashMap.Itr.$$a
                int r9 = 115 - r9
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L11
                r9 = r7
                r3 = r8
                r4 = r2
                goto L29
            L11:
                r3 = r2
            L12:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r8) goto L21
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L21:
                int r7 = r7 + 1
                r3 = r0[r7]
                r6 = r9
                r9 = r7
                r7 = r3
                r3 = r6
            L29:
                int r3 = r3 + r7
                int r7 = r3 + (-5)
                r3 = r4
                r6 = r9
                r9 = r7
                r7 = r6
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.Itr.b(byte, byte, byte, java.lang.Object[]):void");
        }

        @ParametricNullness
        abstract T getOutput(int i);

        private static void c(int i, char[] cArr, Object[] objArr) {
            int i2 = 2 % 2;
            onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
            char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
            onrelationshipvalidationresult.e = 4;
            int i3 = $11 + 17;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                int i5 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                int i7 = onrelationshipvalidationresult.e;
                try {
                    Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 27, (char) (30689 - ImageFormat.getBitsPerPixel(0)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - KeyEvent.keyCodeFromString(""), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 1483 - ((Process.getThreadPriority(0) + 20) >> 6), -1940971975, false, $$e((byte) ($$d & 15), b, b), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0124  */
        /* JADX WARN: Code duplicated, block: B:40:0x013c  */
        /* JADX WARN: Code duplicated, block: B:43:0x0187 A[Catch: all -> 0x032a, TryCatch #0 {all -> 0x032a, blocks: (B:41:0x013e, B:43:0x0187, B:44:0x01fa, B:48:0x020f, B:50:0x024b, B:52:0x02b6), top: B:77:0x013e }] */
        /* JADX WARN: Code duplicated, block: B:47:0x020d  */
        /* JADX WARN: Code duplicated, block: B:50:0x024b A[Catch: all -> 0x032a, TryCatch #0 {all -> 0x032a, blocks: (B:41:0x013e, B:43:0x0187, B:44:0x01fa, B:48:0x020f, B:50:0x024b, B:52:0x02b6), top: B:77:0x013e }] */
        /* JADX WARN: Code duplicated, block: B:51:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:54:0x02d7  */
        /* JADX WARN: Code duplicated, block: B:56:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:57:0x0308  */
        private static void a(byte b, int i, char[] cArr, Object[] objArr) {
            int i2;
            Object obj;
            Object[] objArr2;
            Object objAccessartificialFrame;
            Object objAccessartificialFrame2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            long j = 0;
            Object obj2 = null;
            if (cArr2 != null) {
                int i4 = $10 + 11;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i6 = 0;
                while (i6 < length) {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame3 == null) {
                            int packedPositionType = 15 - ExpandableListView.getPackedPositionType(j);
                            char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 20488);
                            int i7 = 2149 - (SystemClock.elapsedRealtime() > j ? 1 : (SystemClock.elapsedRealtime() == j ? 0 : -1));
                            byte b2 = (byte) 0;
                            byte b3 = b2;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType, maximumDrawingCacheSize, i7, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                        i6++;
                        j = 0;
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
                Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                if (objAccessartificialFrame4 == null) {
                    byte b4 = (byte) 0;
                    byte b5 = b4;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 15, (char) (20489 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), Process.getGidForName("") + 2149, 216710116, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                }
                char cCharValue = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr4)).charValue();
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
                        int i8 = $11 + 11;
                        $10 = i8 % 128;
                        if (i8 % 2 != 0) {
                            extracallback.createBrowser = cArr[extracallback.a];
                            extracallback.c = cArr[extracallback.a + 1];
                            if (extracallback.createBrowser == extracallback.c) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                                obj = obj2;
                            } else {
                                try {
                                    objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                    if (objAccessartificialFrame == null) {
                                        byte b6 = (byte) 5;
                                        byte b7 = (byte) (b6 - 5);
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 46, (char) (58860 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 2464 - TextUtils.indexOf("", "", 0, 0), 276640984, false, $$e(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                    }
                                    if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                        if (objAccessartificialFrame2 == null) {
                                            byte b8 = (byte) 0;
                                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(24 - View.resolveSizeAndState(0, 0, 0), (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), 793 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -834291897, false, $$e((byte) ($$d & 8), b8, b8), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                        }
                                        obj = null;
                                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr5)).intValue();
                                        int i9 = (extracallback.d * cCharValue) + extracallback.g;
                                        cArr4[extracallback.a] = cArr2[iIntValue];
                                        cArr4[extracallback.a + 1] = cArr2[i9];
                                    } else {
                                        obj = null;
                                        if (extracallback.b == extracallback.d) {
                                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                            int i10 = (extracallback.b * cCharValue) + extracallback.j;
                                            int i11 = (extracallback.d * cCharValue) + extracallback.g;
                                            cArr4[extracallback.a] = cArr2[i10];
                                            cArr4[extracallback.a + 1] = cArr2[i11];
                                        } else {
                                            int i12 = (extracallback.b * cCharValue) + extracallback.g;
                                            int i13 = (extracallback.d * cCharValue) + extracallback.j;
                                            cArr4[extracallback.a] = cArr2[i12];
                                            cArr4[extracallback.a + 1] = cArr2[i13];
                                        }
                                    }
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 == null) {
                                        throw th2;
                                    }
                                    throw cause2;
                                }
                            }
                        } else {
                            extracallback.createBrowser = cArr[extracallback.a];
                            extracallback.c = cArr[extracallback.a + 1];
                            if (extracallback.createBrowser == extracallback.c) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                                obj = obj2;
                            } else {
                                objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                if (objAccessartificialFrame == null) {
                                    byte b9 = (byte) 5;
                                    byte b10 = (byte) (b9 - 5);
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 46, (char) (58860 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 2464 - TextUtils.indexOf("", "", 0, 0), 276640984, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                    Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame2 == null) {
                                        byte b11 = (byte) 0;
                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(24 - View.resolveSizeAndState(0, 0, 0), (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), 793 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -834291897, false, $$e((byte) ($$d & 8), b11, b11), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    obj = null;
                                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                                    int i14 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[iIntValue2];
                                    cArr4[extracallback.a + 1] = cArr2[i14];
                                } else {
                                    obj = null;
                                    if (extracallback.b == extracallback.d) {
                                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                        int i15 = (extracallback.b * cCharValue) + extracallback.j;
                                        int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                        cArr4[extracallback.a] = cArr2[i15];
                                        cArr4[extracallback.a + 1] = cArr2[i16];
                                    } else {
                                        int i17 = (extracallback.b * cCharValue) + extracallback.g;
                                        int i18 = (extracallback.d * cCharValue) + extracallback.j;
                                        cArr4[extracallback.a] = cArr2[i17];
                                        cArr4[extracallback.a + 1] = cArr2[i18];
                                    }
                                }
                            }
                        }
                        extracallback.a += 2;
                        obj2 = obj;
                    }
                }
                int i19 = 0;
                while (i19 < i) {
                    int i20 = $10 + 73;
                    $11 = i20 % 128;
                    if (i20 % 2 == 0) {
                        cArr4[i19] = (char) (cArr4[i19] ^ 4602);
                        i19 += 100;
                    } else {
                        cArr4[i19] = (char) (cArr4[i19] ^ 13722);
                        i19++;
                    }
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

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.currentIndex;
            this.indexToRemove = i;
            T output = getOutput(i);
            this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
            return output;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            incrementExpectedModCount();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.indexToRemove));
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }

        void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6814 (expected less than 5000) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v100 */
        /* JADX WARN: Type inference failed for: r10v101 */
        /* JADX WARN: Type inference failed for: r10v102 */
        /* JADX WARN: Type inference failed for: r10v103 */
        /* JADX WARN: Type inference failed for: r10v104 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r10v21 */
        /* JADX WARN: Type inference failed for: r10v26, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r10v27 */
        /* JADX WARN: Type inference failed for: r10v28, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v79 */
        /* JADX WARN: Type inference failed for: r10v80 */
        /* JADX WARN: Type inference failed for: r10v81 */
        /* JADX WARN: Type inference failed for: r10v83 */
        /* JADX WARN: Type inference failed for: r10v84, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r10v96 */
        /* JADX WARN: Type inference failed for: r10v97 */
        /* JADX WARN: Type inference failed for: r10v98 */
        /* JADX WARN: Type inference failed for: r10v99 */
        /* JADX WARN: Type inference failed for: r2v239, types: [java.util.regex.Pattern] */
        /* JADX WARN: Type inference failed for: r60v10, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r60v14 */
        /* JADX WARN: Type inference failed for: r60v16 */
        /* JADX WARN: Type inference failed for: r60v18 */
        /* JADX WARN: Type inference failed for: r60v19 */
        /* JADX WARN: Type inference failed for: r60v21 */
        /* JADX WARN: Type inference failed for: r60v22 */
        /* JADX WARN: Type inference failed for: r60v23 */
        /* JADX WARN: Type inference failed for: r60v24 */
        /* JADX WARN: Type inference failed for: r60v26 */
        /* JADX WARN: Type inference failed for: r60v32 */
        /* JADX WARN: Type inference failed for: r60v33 */
        /* JADX WARN: Type inference failed for: r60v34 */
        /* JADX WARN: Type inference failed for: r60v35 */
        /* JADX WARN: Type inference failed for: r60v36 */
        /* JADX WARN: Type inference failed for: r60v37 */
        /* JADX WARN: Type inference failed for: r60v38 */
        /* JADX WARN: Type inference failed for: r60v39 */
        /* JADX WARN: Type inference failed for: r60v5 */
        /* JADX WARN: Type inference failed for: r60v6 */
        /* JADX WARN: Type inference failed for: r6v326 */
        /* JADX WARN: Type inference failed for: r6v327, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r6v360 */
        /* JADX WARN: Type inference failed for: r6v361 */
        /* JADX WARN: Type inference failed for: r6v378, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r6v734 */
        /* JADX WARN: Type inference failed for: r6v735 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame$78cbbd35(int r77, int r78, java.lang.Object r79, int r80, boolean r81) {
            /*
                Method dump skipped, instruction units count: 18647
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.Itr.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
        }
    }

    static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i = compactHashMap.size;
        compactHashMap.size = i - 1;
        return i;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int i) {
        init(i);
    }

    void init(int i) {
        Preconditions.checkArgument(i >= 0, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    boolean needsAllocArrays() {
        return this.table == null;
    }

    int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i = this.metadata;
        int iTableSize = CompactHashing.tableSize(i);
        this.table = CompactHashing.createTable(iTableSize);
        setHashTableMask(iTableSize - 1);
        this.entries = new int[i];
        this.keys = new Object[i];
        this.values = new Object[i];
        return i;
    }

    @CheckForNull
    Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    Map<K, V> createHashFloodingResistantDelegate(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            mapCreateHashFloodingResistantDelegate.put(key(iFirstEntryIndex), value(iFirstEntryIndex));
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.table = mapCreateHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return mapCreateHashFloodingResistantDelegate;
    }

    private void setHashTableMask(int i) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V put(@ParametricNullness K k, @ParametricNullness V v) {
        int iResizeTable;
        int i;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(k, v);
        }
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireKeys = requireKeys();
        Object[] objArrRequireValues = requireValues();
        int i2 = this.size;
        int i3 = i2 + 1;
        int iSmearedHash = Hashing.smearedHash(k);
        int iHashTableMask = hashTableMask();
        int i4 = iSmearedHash & iHashTableMask;
        int iTableGet = CompactHashing.tableGet(requireTable(), i4);
        if (iTableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(iSmearedHash, iHashTableMask);
            int i5 = 0;
            while (true) {
                int i6 = iTableGet - 1;
                int i7 = iArrRequireEntries[i6];
                if (CompactHashing.getHashPrefix(i7, iHashTableMask) == hashPrefix && Objects.equal(k, objArrRequireKeys[i6])) {
                    V v2 = (V) objArrRequireValues[i6];
                    objArrRequireValues[i6] = v;
                    accessEntry(i6);
                    return v2;
                }
                int next = CompactHashing.getNext(i7, iHashTableMask);
                i5++;
                if (next != 0) {
                    iTableGet = next;
                } else {
                    if (i5 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k, v);
                    }
                    if (i3 > iHashTableMask) {
                        iResizeTable = resizeTable(iHashTableMask, CompactHashing.newCapacity(iHashTableMask), iSmearedHash, i2);
                        i = iResizeTable;
                    } else {
                        iArrRequireEntries[i6] = CompactHashing.maskCombine(i7, i3, iHashTableMask);
                        i = iHashTableMask;
                    }
                }
            }
        } else if (i3 > iHashTableMask) {
            iResizeTable = resizeTable(iHashTableMask, CompactHashing.newCapacity(iHashTableMask), iSmearedHash, i2);
            i = iResizeTable;
        } else {
            CompactHashing.tableSet(requireTable(), i4, i3);
            i = iHashTableMask;
        }
        resizeMeMaybe(i3);
        insertEntry(i2, k, v, iSmearedHash, i);
        this.size = i3;
        incrementModCount();
        return null;
    }

    void insertEntry(int i, @ParametricNullness K k, @ParametricNullness V v, int i2, int i3) {
        setEntry(i, CompactHashing.maskCombine(i2, 0, i3));
        setKey(i, k);
        setValue(i, v);
    }

    private void resizeMeMaybe(int i) {
        int iMin;
        int length = requireEntries().length;
        if (i <= length || (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    void resizeEntries(int i) {
        this.entries = Arrays.copyOf(requireEntries(), i);
        this.keys = Arrays.copyOf(requireKeys(), i);
        this.values = Arrays.copyOf(requireValues(), i);
    }

    private int resizeTable(int i, int i2, int i3, int i4) {
        Object objCreateTable = CompactHashing.createTable(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            CompactHashing.tableSet(objCreateTable, i3 & i5, i4 + 1);
        }
        Object objRequireTable = requireTable();
        int[] iArrRequireEntries = requireEntries();
        for (int i6 = 0; i6 <= i; i6++) {
            int iTableGet = CompactHashing.tableGet(objRequireTable, i6);
            while (iTableGet != 0) {
                int i7 = iTableGet - 1;
                int i8 = iArrRequireEntries[i7];
                int hashPrefix = CompactHashing.getHashPrefix(i8, i) | i6;
                int i9 = hashPrefix & i5;
                int iTableGet2 = CompactHashing.tableGet(objCreateTable, i9);
                CompactHashing.tableSet(objCreateTable, i9, iTableGet);
                iArrRequireEntries[i7] = CompactHashing.maskCombine(hashPrefix, iTableGet2, i5);
                iTableGet = CompactHashing.getNext(i8, i);
            }
        }
        this.table = objCreateTable;
        setHashTableMask(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iSmearedHash = Hashing.smearedHash(obj);
        int iHashTableMask = hashTableMask();
        int iTableGet = CompactHashing.tableGet(requireTable(), iSmearedHash & iHashTableMask);
        if (iTableGet == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(iSmearedHash, iHashTableMask);
        do {
            int i = iTableGet - 1;
            int iEntry = entry(i);
            if (CompactHashing.getHashPrefix(iEntry, iHashTableMask) == hashPrefix && Objects.equal(obj, key(i))) {
                return i;
            }
            iTableGet = CompactHashing.getNext(iEntry, iHashTableMask);
        } while (iTableGet != 0);
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        accessEntry(iIndexOf);
        return value(iIndexOf);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        V v = (V) removeHelper(obj);
        if (v == NOT_FOUND) {
            return null;
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object removeHelper(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int iHashTableMask = hashTableMask();
        int iRemove = CompactHashing.remove(obj, null, iHashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (iRemove == -1) {
            return NOT_FOUND;
        }
        V vValue = value(iRemove);
        moveLastEntry(iRemove, iHashTableMask);
        this.size--;
        incrementModCount();
        return vValue;
    }

    void moveLastEntry(int i, int i2) {
        Object objRequireTable = requireTable();
        int[] iArrRequireEntries = requireEntries();
        Object[] objArrRequireKeys = requireKeys();
        Object[] objArrRequireValues = requireValues();
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            Object obj = objArrRequireKeys[i3];
            objArrRequireKeys[i] = obj;
            objArrRequireValues[i] = objArrRequireValues[i3];
            objArrRequireKeys[i3] = null;
            objArrRequireValues[i3] = null;
            iArrRequireEntries[i] = iArrRequireEntries[i3];
            iArrRequireEntries[i3] = 0;
            int iSmearedHash = Hashing.smearedHash(obj) & i2;
            int iTableGet = CompactHashing.tableGet(objRequireTable, iSmearedHash);
            if (iTableGet == size) {
                CompactHashing.tableSet(objRequireTable, iSmearedHash, i + 1);
                return;
            }
            while (true) {
                int i4 = iTableGet - 1;
                int i5 = iArrRequireEntries[i4];
                int next = CompactHashing.getNext(i5, i2);
                if (next == size) {
                    iArrRequireEntries[i4] = CompactHashing.maskCombine(i5, i + 1, i2);
                    return;
                }
                iTableGet = next;
            }
        } else {
            objArrRequireKeys[i] = null;
            objArrRequireValues[i] = null;
            iArrRequireEntries[i] = 0;
        }
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySetView = setCreateKeySet;
        return setCreateKeySet;
    }

    Set<K> createKeySet() {
        return new KeySetView();
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.keySet().remove(obj);
            }
            return CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }
    }

    Iterator<K> keySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.keySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            K getOutput(int i) {
                return (K) CompactHashMap.this.key(i);
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
        this.entrySetView = setCreateEntrySet;
        return setCreateEntrySet;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iIndexOf = CompactHashMap.this.indexOf(entry.getKey());
                if (iIndexOf != -1 && Objects.equal(CompactHashMap.this.value(iIndexOf), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int iHashTableMask = CompactHashMap.this.hashTableMask();
            int iRemove = CompactHashing.remove(entry.getKey(), entry.getValue(), iHashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (iRemove == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(iRemove, iHashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.entrySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int i) {
                return new MapEntry(i);
            }
        };
    }

    final class MapEntry extends AbstractMapEntry<K, V> {

        @ParametricNullness
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i) {
            this.key = (K) CompactHashMap.this.key(i);
            this.lastKnownIndex = i;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            if (i == -1 || i >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.key(this.lastKnownIndex))) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(mapDelegateOrNull.get(this.key));
            }
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            return i == -1 ? (V) NullnessCasts.unsafeNull() : (V) CompactHashMap.this.value(i);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            Map<K, V> mapDelegateOrNull = CompactHashMap.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(mapDelegateOrNull.put(this.key, v));
            }
            updateLastKnownIndex();
            int i = this.lastKnownIndex;
            if (i != -1) {
                V v2 = (V) CompactHashMap.this.value(i);
                CompactHashMap.this.setValue(this.lastKnownIndex, v);
                return v2;
            }
            CompactHashMap.this.put(this.key, v);
            return (V) NullnessCasts.unsafeNull();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(obj);
        }
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(obj, value(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.valuesView = collectionCreateValues;
        return collectionCreateValues;
    }

    Collection<V> createValues() {
        return new ValuesView();
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }
    }

    Iterator<V> valuesIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.values().iterator();
        }
        return new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            V getOutput(int i) {
                return (V) CompactHashMap.this.value(i);
            }
        };
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            mapCreateHashFloodingResistantDelegate.putAll(mapDelegateOrNull);
            this.table = mapCreateHashFloodingResistantDelegate;
            return;
        }
        int i = this.size;
        if (i < requireEntries().length) {
            resizeEntries(i);
        }
        int iTableSize = CompactHashing.tableSize(i);
        int iHashTableMask = hashTableMask();
        if (iTableSize < iHashTableMask) {
            resizeTable(iHashTableMask, iTableSize, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapDelegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        CompactHashing.tableClear(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itEntrySetIterator = entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<K, V> next = itEntrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid size: ");
            sb.append(i);
            throw new InvalidObjectException(sb.toString());
        }
        init(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K key(int i) {
        return (K) requireKeys()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V value(int i) {
        return (V) requireValues()[i];
    }

    private int entry(int i) {
        return requireEntries()[i];
    }

    private void setKey(int i, K k) {
        requireKeys()[i] = k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, V v) {
        requireValues()[i] = v;
    }

    private void setEntry(int i, int i2) {
        requireEntries()[i] = i2;
    }
}
