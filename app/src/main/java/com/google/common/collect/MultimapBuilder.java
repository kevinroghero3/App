package com.google.common.collect;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onNavigationEvent;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(final int i) {
        CollectPreconditions.checkNonnegative(i, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.1
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newHashMapWithExpectedSize(i);
            }
        };
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int i) {
        CollectPreconditions.checkNonnegative(i, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.2
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newLinkedHashMapWithExpectedSize(i);
            }
        };
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new MultimapBuilderWithKeys<K0>() { // from class: com.google.common.collect.MultimapBuilder.3
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new TreeMap(comparator);
            }
        };
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> cls) {
        Preconditions.checkNotNull(cls);
        return new MultimapBuilderWithKeys<K0>() { // from class: com.google.common.collect.MultimapBuilder.4
            private static final byte[] $$a = {Ascii.RS, -66, -95, 114};
            private static final int $$b = 93;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static int setDefaultImpl = -260894087;
            private static char[] ArtificialStackFrames = {44371, 44404, 44402, 44332, 44391, 44400, 44336, 44375, 44387, 44398, 44345, 44406, 44334, 44349, 44399, 44362, 44393, 44388, 44341, 44366, 44385, 44367, 44376, 44320, 44369, 44358, 44408, 44354, 44364, 44386, 44374, 44373, 44405, 44403, 44365, 44361, 44355, 44363, 44395, 44356, 44409, 44389, 44394, 44353, 44368, 44372, 44390, 44360, 44397};
            private static char coroutineCreation = 39069;

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            /* JADX WARN: Code duplicated, block: B:8:0x001c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$c(byte r6, byte r7, int r8) {
                /*
                    int r8 = r8 * 4
                    int r8 = 1 - r8
                    int r6 = 116 - r6
                    int r7 = r7 * 4
                    int r7 = 4 - r7
                    byte[] r0 = com.google.common.collect.MultimapBuilder.AnonymousClass4.$$a
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L14
                    r3 = r8
                    r4 = r2
                    goto L24
                L14:
                    r3 = r2
                L15:
                    int r4 = r3 + 1
                    byte r5 = (byte) r6
                    r1[r3] = r5
                    if (r4 != r8) goto L22
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    return r6
                L22:
                    r3 = r0[r7]
                L24:
                    int r3 = -r3
                    int r6 = r6 + r3
                    int r7 = r7 + 1
                    r3 = r4
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MultimapBuilder.AnonymousClass4.$$c(byte, byte, int):java.lang.String");
            }

            private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
                int i4 = 2 % 2;
                onNavigationEvent onnavigationevent = new onNavigationEvent();
                char[] cArr2 = new char[i3];
                onnavigationevent.d = 0;
                int i5 = $10 + 17;
                $11 = i5 % 128;
                int i6 = i5 % 2;
                while (onnavigationevent.d < i3) {
                    onnavigationevent.c = cArr[onnavigationevent.d];
                    cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                    int i7 = onnavigationevent.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 2;
                            byte b2 = (byte) (b - 2);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 23, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 1775 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -2069783171, false, $$c(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        Object[] objArr3 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(36 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 56277), TextUtils.getTrimmedLength("") + 1259, 711931141, false, $$c(b3, b4, b4), new Class[]{Object.class, Object.class});
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
                if (i > 0) {
                    int i8 = $11 + 45;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    onnavigationevent.b = i;
                    char[] cArr3 = new char[i3];
                    System.arraycopy(cArr2, 0, cArr3, 0, i3);
                    System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                    System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
                }
                if (z) {
                    char[] cArr4 = new char[i3];
                    onnavigationevent.d = 0;
                    while (onnavigationevent.d < i3) {
                        cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 36, (char) (56277 - (Process.myTid() >> 22)), ((byte) KeyEvent.getModifierMetaStateMask()) + 1260, 711931141, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        int i10 = $11 + 57;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }

            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new EnumMap(cls);
            }

            private static void b(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2;
                Object obj;
                int length;
                char[] cArr2;
                int i3;
                int i4 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr3 = ArtificialStackFrames;
                int i5 = 19;
                int i6 = -1819279892;
                Object obj2 = null;
                if (cArr3 != null) {
                    int i7 = $10 + 49;
                    $11 = i7 % 128;
                    if (i7 % 2 == 0) {
                        length = cArr3.length;
                        cArr2 = new char[length];
                        i3 = 1;
                    } else {
                        length = cArr3.length;
                        cArr2 = new char[length];
                        i3 = 0;
                    }
                    while (i3 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr3[i3])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i6);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) i5;
                                byte b3 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 15, (char) (20489 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 2148 - Gravity.getAbsoluteGravity(0, 0), 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                            }
                            cArr2[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i3++;
                            i5 = 19;
                            i6 = -1819279892;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr3 = cArr2;
                }
                try {
                    Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15, (char) (20489 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 2147 - TextUtils.indexOf((CharSequence) "", '0', 0), 216710116, false, $$c((byte) 19, b4, b4), new Class[]{Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    char[] cArr4 = new char[i];
                    if (i % 2 != 0) {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    } else {
                        i2 = i;
                    }
                    char c = 7;
                    if (i2 > 1) {
                        extracallback.a = 0;
                        while (extracallback.a < i2) {
                            extracallback.createBrowser = cArr[extracallback.a];
                            extracallback.c = cArr[extracallback.a + 1];
                            if (extracallback.createBrowser == extracallback.c) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                                obj = obj2;
                            } else {
                                Object[] objArr4 = new Object[13];
                                objArr4[12] = extracallback;
                                objArr4[11] = Integer.valueOf(cCharValue);
                                objArr4[10] = extracallback;
                                objArr4[9] = extracallback;
                                objArr4[8] = Integer.valueOf(cCharValue);
                                objArr4[c] = extracallback;
                                objArr4[6] = extracallback;
                                objArr4[5] = Integer.valueOf(cCharValue);
                                objArr4[4] = extracallback;
                                objArr4[3] = extracallback;
                                objArr4[2] = Integer.valueOf(cCharValue);
                                objArr4[1] = extracallback;
                                objArr4[0] = extracallback;
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                if (objAccessartificialFrame3 == null) {
                                    byte b5 = (byte) 0;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 46, (char) (TextUtils.getOffsetAfter("", 0) + 58859), KeyEvent.keyCodeFromString("") + 2464, 276640984, false, $$c((byte) 14, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                    int i8 = $11 + 115;
                                    $10 = i8 % 128;
                                    int i9 = i8 % 2;
                                    Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b6 = (byte) 0;
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - Color.argb(0, 0, 0, 0), (char) Drawable.resolveOpacity(0, 0), TextUtils.getCapsMode("", 0, 0) + 792, -834291897, false, $$c((byte) 11, b6, b6), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    obj = null;
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                    int i10 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr3[iIntValue];
                                    cArr4[extracallback.a + 1] = cArr3[i10];
                                } else {
                                    obj = null;
                                    if (extracallback.b == extracallback.d) {
                                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                        int i11 = (extracallback.b * cCharValue) + extracallback.j;
                                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                                        cArr4[extracallback.a] = cArr3[i11];
                                        cArr4[extracallback.a + 1] = cArr3[i12];
                                    } else {
                                        int i13 = (extracallback.b * cCharValue) + extracallback.g;
                                        int i14 = (extracallback.d * cCharValue) + extracallback.j;
                                        cArr4[extracallback.a] = cArr3[i13];
                                        cArr4[extracallback.a + 1] = cArr3[i14];
                                    }
                                }
                            }
                            extracallback.a += 2;
                            int i15 = $11 + 87;
                            $10 = i15 % 128;
                            int i16 = i15 % 2;
                            obj2 = obj;
                            c = 7;
                        }
                    }
                    for (int i17 = 0; i17 < i; i17++) {
                        int i18 = $10 + 7;
                        $11 = i18 % 128;
                        int i19 = i18 % 2;
                        cArr4[i17] = (char) (cArr4[i17] ^ 13722);
                    }
                    objArr[0] = new String(cArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
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
            public static java.lang.Object[] accessartificialFrame(android.content.Context r36, int r37, int r38) {
                /*
                    Method dump skipped, instruction units count: 4373
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MultimapBuilder.AnonymousClass4.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
            }
        };
    }

    static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        HashSetSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.base.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1
                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), new ArrayListSupplier(i));
                }
            };
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new ListMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.2
                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), LinkedListSupplier.instance());
                }
            };
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.3
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new HashSetSupplier(i));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.4
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new LinkedHashSetSupplier(i));
                }
            };
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new SortedSetMultimapBuilder<K0, V0>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.5
                @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
                    return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.createMap(), new TreeSetSupplier(comparator));
                }
            };
        }

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> cls) {
            Preconditions.checkNotNull(cls, "valueClass");
            return new SetMultimapBuilder<K0, V0>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.6
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V extends V0> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new EnumSetSupplier(cls));
                }
            };
        }
    }

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> multimapBuild = build();
        multimapBuild.putAll(multimap);
        return multimapBuild;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        ListMultimapBuilder() {
            super();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        SetMultimapBuilder() {
            super();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        SortedSetMultimapBuilder() {
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}
