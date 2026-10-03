package com.google.common.collect;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.SentryEnvelope;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;

    @CheckForNull
    Equivalence<Object> keyEquivalence;

    @CheckForNull
    MapMakerInternalMap.Strength keyStrength;
    boolean useCustomMap;

    @CheckForNull
    MapMakerInternalMap.Strength valueStrength;
    private static final byte[] $$c = {10, -69, -10, 57};
    private static final int $$d = 146;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {52, -111, -122, 98, -11, -2, Ascii.FF};
    private static final int $$b = 56;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44388, 44386, 44387, 44337, 44385, 44395, 44691, 44355, 44703, 44393, 44402, 44698, 44334, 44389, 44700, 44403, 44696, 44399, 44697, 44390, 44398, 44396, 44701, 44702, 44407, 44335, 44405, 44358, 44404, 44699, 44690, 44391, 44409, 44356, 44400, 44383};
    private static char coroutineCreation = 39068;
    int initialCapacity = -1;
    int concurrencyLevel = -1;

    enum Dummy {
        VALUE
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, int r7, short r8) {
        /*
            int r6 = 105 - r6
            byte[] r0 = com.google.common.collect.MapMaker.$$c
            int r7 = r7 * 4
            int r7 = 4 - r7
            int r8 = r8 * 4
            int r8 = 1 - r8
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
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMaker.$$e(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 4
            int r9 = 109 - r9
            byte[] r0 = com.google.common.collect.MapMaker.$$a
            int r8 = r8 * 4
            int r8 = 4 - r8
            int r7 = r7 * 2
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r7
            goto L2c
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r6
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-3)
            int r9 = r9 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMaker.b(int, short, short, java.lang.Object[]):void");
    }

    MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public MapMaker initialCapacity(int i) {
        int i2 = this.initialCapacity;
        Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        Preconditions.checkArgument(i >= 0);
        this.initialCapacity = i;
        return this;
    }

    int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public MapMaker concurrencyLevel(int i) {
        int i2 = this.concurrencyLevel;
        Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        Preconditions.checkArgument(i > 0);
        this.concurrencyLevel = i;
        return this;
    }

    int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public MapMaker weakKeys() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setKeyStrength(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.keyStrength;
        Preconditions.checkState(strength2 == null, "Key strength was already set to %s", strength2);
        this.keyStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker weakValues() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setValueStrength(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.valueStrength;
        Preconditions.checkState(strength2 == null, "Value strength was already set to %s", strength2);
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        long j = 0;
        int i4 = 8;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 15, (char) (20488 - View.MeasureSpec.getMode(0)), 2149 - (SystemClock.elapsedRealtime() > j ? 1 : (SystemClock.elapsedRealtime() == j ? 0 : -1)), 216710116, false, $$e((byte) i4, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i5++;
                    j = 0;
                    i4 = 8;
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
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 15, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 20488), 2148 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 216710116, false, $$e((byte) 8, b3, b3), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i6 = $10 + b.i;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    int i8 = $11 + 41;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 3;
                        byte b5 = (byte) (b4 - 3);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 46, (char) (Color.green(0) + 58859), Process.getGidForName("") + 2465, 276640984, false, $$e(b4, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        int i10 = $11 + 91;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1), KeyEvent.normalizeMetaState(0) + 792, -834291897, false, $$e(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[iIntValue];
                        cArr4[extracallback.a + 1] = cArr2[i12];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i13 = (extracallback.b * cCharValue) + extracallback.j;
                        int i14 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr2[i13];
                        cArr4[extracallback.a + 1] = cArr2[i14];
                    } else {
                        int i15 = (extracallback.b * cCharValue) + extracallback.g;
                        int i16 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr2[i15];
                        cArr4[extracallback.a + 1] = cArr2[i16];
                    }
                }
                extracallback.a += 2;
            }
        }
        for (int i17 = 0; i17 < i; i17++) {
            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
        }
        return MapMakerInternalMap.create(this);
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x09c4  */
    /* JADX WARN: Code duplicated, block: B:104:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:106:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:108:0x0a3b A[Catch: all -> 0x0bae, TryCatch #5 {all -> 0x0bae, blocks: (B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:142:0x0980, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:125:0x0c57  */
    /* JADX WARN: Code duplicated, block: B:126:0x0c84  */
    /* JADX WARN: Code duplicated, block: B:82:0x0857  */
    /* JADX WARN: Code duplicated, block: B:83:0x0859 A[Catch: Exception -> 0x0bbe, TRY_LEAVE, TryCatch #1 {Exception -> 0x0bbe, blocks: (B:80:0x081e, B:83:0x0859, B:85:0x08da, B:87:0x08e2, B:90:0x096c, B:110:0x0a61, B:118:0x0baf, B:119:0x0bb5, B:121:0x0bb7, B:122:0x0bbd, B:84:0x0863, B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:137:0x081e, inners: #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x08e2 A[Catch: Exception -> 0x0bbe, TRY_LEAVE, TryCatch #1 {Exception -> 0x0bbe, blocks: (B:80:0x081e, B:83:0x0859, B:85:0x08da, B:87:0x08e2, B:90:0x096c, B:110:0x0a61, B:118:0x0baf, B:119:0x0bb5, B:121:0x0bb7, B:122:0x0bbd, B:84:0x0863, B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:137:0x081e, inners: #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x095b  */
    /* JADX WARN: Code duplicated, block: B:90:0x096c A[Catch: Exception -> 0x0bbe, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0bbe, blocks: (B:80:0x081e, B:83:0x0859, B:85:0x08da, B:87:0x08e2, B:90:0x096c, B:110:0x0a61, B:118:0x0baf, B:119:0x0bb5, B:121:0x0bb7, B:122:0x0bbd, B:84:0x0863, B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:137:0x081e, inners: #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0982 A[Catch: all -> 0x0bae, TRY_ENTER, TryCatch #5 {all -> 0x0bae, blocks: (B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:142:0x0980, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0992 A[Catch: all -> 0x0bae, TRY_LEAVE, TryCatch #5 {all -> 0x0bae, blocks: (B:93:0x0982, B:99:0x09c2, B:107:0x0a1c, B:109:0x0a5d, B:108:0x0a3b, B:115:0x0baa, B:116:0x0bad, B:94:0x0992), top: B:142:0x0980, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x09b6  */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        char c;
        int i3;
        Object[] objArr2;
        String line;
        Object[] objArr3;
        int i4;
        int i5;
        int i6;
        int i7;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        int i8;
        String line2;
        int iCombineMeasuredStates;
        int iMediaBrowserCompatMediaBrowserImplApi212;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str;
        boolean zEquals2;
        int i21;
        String str2;
        int i22;
        int iMediaBrowserCompatMediaBrowserImplApi213;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iMediaBrowserCompatMediaBrowserImplApi214;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32 = 2;
        int i33 = 2 % 2;
        try {
            String[] strArr = new String[2];
            int i34 = -TextUtils.indexOf((CharSequence) "", '0');
            int i35 = i34 * TypedValues.PositionType.TYPE_PERCENT_WIDTH;
            int i36 = ((i35 | 9054) << 1) - (i35 ^ 9054);
            int i37 = (i34 ^ 18) | (i34 & 18);
            int i38 = i37 * (-502);
            int i39 = (i36 ^ i38) + ((i36 & i38) << 1);
            int i40 = ~i34;
            int i41 = ~(i40 | (-19));
            int i42 = ~i34;
            int i43 = ~i;
            int i44 = ~(i42 | i43);
            int i45 = (i41 ^ i44) | (i44 & i41);
            int i46 = i34 | 18;
            int i47 = (i46 & i) | (i46 ^ i);
            int i48 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
            artificialFrame = i48 % 128;
            if (i48 % 2 == 0) {
                int i49 = ~i47;
                int i50 = i40 | i43;
                i21 = ((i39 << ((-502) >>> ((i45 & i49) | (i45 ^ i49)))) - (~(-(-(TypedValues.PositionType.TYPE_DRAWPATH % ((~((i50 & 18) | (i50 ^ 18))) | (~((i37 ^ i) | (i37 & i))))))))) - 1;
            } else {
                int i51 = (i39 - (~(-(-((i45 | (~i47)) * (-502)))))) - 1;
                int i52 = ~((i40 ^ i43) | (i40 & i43) | 18);
                int i53 = ~((i37 ^ i) | (i37 & i));
                i21 = (((i52 & i53) | (i52 ^ i53)) * TypedValues.PositionType.TYPE_DRAWPATH) + i51;
            }
            char[] cArr = {15, 21, 31, 15, 2, 25, 13909, 13909, 16, 7, 11, CharUtils.CR, 13900, 13900, 14, 1, 25, 16, 13910};
            int i54 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            int i55 = i54 * (-501);
            int i56 = artificialFrame;
            int i57 = ((i56 | 71) << 1) - (i56 ^ 71);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
            int i58 = i57 % 2;
            int i59 = ((((i55 & 44767) + (i55 | 44767)) - (~(((~(((-90) ^ i) | ((-90) & i))) | (~((i54 ^ 89) | (i54 & 89)))) * (-502)))) - 1) + ((~((-90) | i43 | i54)) * (-502));
            int i60 = ~i54;
            Object[] objArr4 = new Object[1];
            a(i21, cArr, (byte) (i59 + (((~((i60 & i) | (i60 ^ i))) | (-90)) * TypedValues.PositionType.TYPE_DRAWPATH)), objArr4);
            strArr[0] = (String) objArr4[0];
            int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
            artificialFrame = i61 % 128;
            int i62 = i61 % 2;
            int i63 = -(ViewConfiguration.getWindowTouchSlop() >> 8);
            Object[] objArr5 = new Object[1];
            a(18 - Color.blue(0), new char[]{28, 0, '\n', 27, '\b', 21, '!', 25, 16, 11, 31, 15, 2, 25, 13827, 13827, 16, 7}, (byte) ((i63 & 6) + (i63 | 6)), objArr5);
            strArr[1] = (String) objArr5[0];
            int i64 = 0;
            while (true) {
                if (i64 >= i32) {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int iMyPid = Process.myPid();
                    int i65 = ~(67754157 | iMyPid);
                    int i66 = ~iMyPid;
                    int i67 = i65 | (~(1046377932 | i66));
                    int i68 = ~((-67754158) | i66);
                    int i69 = 1612082998 + ((i67 | i68) * (-516)) + (((~(iMyPid | (-978724161))) | (~((-67653773) | i66))) * 516) + ((67653772 | i68) * 516);
                    int i70 = ((i69 * (-244)) - (~(i2 * 246))) - 1;
                    int i71 = ~i2;
                    int i72 = ~((i71 ^ i43) | (i71 & i43));
                    int i73 = ~i2;
                    int i74 = ~((i73 ^ i69) | (i73 & i69));
                    int i75 = (((i70 - (~(((i72 & i74) | (i72 ^ i74)) * (-245)))) - 1) - (~((~((i73 ^ i) | (i73 & i))) * (-245)))) - 1;
                    int i76 = ~((i71 & i) | (i71 ^ i));
                    int i77 = i75 + (((i76 & i69) | (i69 ^ i76)) * 245);
                    int i78 = i77 ^ (i77 << 13);
                    int i79 = i78 >>> 17;
                    int i80 = ((~i78) & i79) | ((~i79) & i78);
                    int i81 = i80 << 5;
                    ((int[]) objArr[2])[0] = (i80 | i81) & (~(i80 & i81));
                    break;
                }
                int iMediaBrowserCompatMediaBrowserImplApi215 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                int i82 = ~iMediaBrowserCompatMediaBrowserImplApi215;
                int i83 = ~(((-67506313) & i82) | ((-67506313) ^ i82));
                int i84 = (i83 & (-1739571168)) | (i83 ^ (-1739571168));
                int i85 = ~(iMediaBrowserCompatMediaBrowserImplApi215 | 84844492);
                int i86 = 1480345443 + (((i85 & i84) | (i84 ^ i85)) * (-68));
                int i87 = ((-1722232988) ^ i82) | ((-1722232988) & i82);
                int i88 = (~((84844492 & i87) | (i87 ^ 84844492))) * (-68);
                int i89 = ~((i82 & (-84844493)) | ((-84844493) ^ i82));
                int i90 = (i86 ^ i88) + ((i86 & i88) << 1) + ((((-1722232988) & i89) | ((-1722232988) ^ i89)) * 68);
                int i91 = 1059851532 - (~(((~((~i) | 737777813)) | 62462081) * (-970)));
                int i92 = ~((i43 ^ 737777813) | (737777813 & i43));
                int i93 = -(-(((i92 & 675315732) | (675315732 ^ i92)) * 970));
                if (i90 <= (i91 & i93) + (i93 | i91)) {
                    str2 = strArr[i64];
                    i22 = -ExpandableListView.getPackedPositionGroup(0L);
                    iMediaBrowserCompatMediaBrowserImplApi213 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                    i23 = 100;
                } else {
                    str2 = strArr[i64];
                    i22 = -ExpandableListView.getPackedPositionGroup(0L);
                    iMediaBrowserCompatMediaBrowserImplApi213 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                    i23 = 16;
                }
                int i94 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i95 = ((i94 | 107) << 1) - (i94 ^ 107);
                artificialFrame = i95 % 128;
                if (i95 % i32 == 0) {
                    int i96 = -(-i23);
                    i24 = ((-711) / i22) + (i96 & 713) + (i96 | 713);
                    int i97 = ~i23;
                    i25 = ~((i97 & i22) | (i97 ^ i22));
                    int i98 = ~iMediaBrowserCompatMediaBrowserImplApi213;
                    i26 = (i98 ^ i22) | (i98 & i22);
                } else {
                    int i99 = (-711) * i22;
                    int i100 = i23 * 713;
                    i24 = ((i99 | i100) << 1) - (i99 ^ i100);
                    int i101 = ~i23;
                    i25 = ~((i101 & i22) | (i101 ^ i22));
                    i26 = (~iMediaBrowserCompatMediaBrowserImplApi213) | i22;
                }
                int i102 = ~i26;
                int i103 = -(-((-712) * ((i25 ^ i102) | (i25 & i102))));
                int i104 = (i24 ^ i103) + ((i24 & i103) << 1);
                int i105 = ~i23;
                int i106 = ~iMediaBrowserCompatMediaBrowserImplApi213;
                int i107 = (i105 ^ i106) | (i105 & i106);
                int i108 = ~((i107 ^ i22) | (i107 & i22));
                int i109 = ~(iMediaBrowserCompatMediaBrowserImplApi213 | (i22 ^ i23) | (i23 & i22));
                int i110 = (i104 - (~(((i108 & i109) | (i108 ^ i109)) * (-712)))) - 1;
                int i111 = ~((i106 ^ i22) | (i106 & i22));
                int i112 = -(-(((i111 & i105) | (i105 ^ i111)) * 712));
                int i113 = (i110 ^ i112) + ((i112 & i110) << 1);
                char[] cArr2 = {2, 22, 4, 6, 15, 11, 6, 18, '\f', 16, 15, 30, 19, 7, 25, ' '};
                int i114 = i94 + 107;
                artificialFrame = i114 % 128;
                if (i114 % 2 == 0) {
                    i27 = -((byte) KeyEvent.getModifierMetaStateMask());
                    iMediaBrowserCompatMediaBrowserImplApi214 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                    i28 = (-494) >>> i27;
                    i29 = 69;
                    i30 = -16;
                } else {
                    i27 = -((byte) KeyEvent.getModifierMetaStateMask());
                    iMediaBrowserCompatMediaBrowserImplApi214 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                    i28 = i27 * (-494);
                    i29 = 42;
                    i30 = -20748;
                }
                int i115 = (i28 - (~(-(-i30)))) - 1;
                int i116 = (~((i27 ^ i29) | (i27 & i29))) * (-495);
                int i117 = ~iMediaBrowserCompatMediaBrowserImplApi214;
                int i118 = (i115 & i116) + (i115 | i116) + (((i27 ^ i117) | (i27 & i117)) * 495);
                int i119 = artificialFrame;
                int i120 = ((i119 | 1) << 1) - (i119 ^ 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i120 % 128;
                int i121 = i120 % 2;
                int i122 = ~((~i27) | (~i29));
                int i123 = ~((i27 & i117) | (i117 ^ i27));
                int i124 = 495 * ((i123 & i122) | (i122 ^ i123));
                byte b = (byte) ((i118 ^ i124) + ((i124 & i118) << 1));
                Object[] objArr6 = new Object[1];
                a(i113, cArr2, b, objArr6);
                Class<?> cls = Class.forName((String) objArr6[0]);
                if (((Boolean) cls.getMethod(str2, new Class[0]).invoke(cls, null)).booleanValue()) {
                    int i125 = artificialFrame + 3;
                    int i126 = i125 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i126;
                    if (i125 % 2 != 0) {
                        i31 = i ^ 1;
                        objArr = new Object[5];
                    } else {
                        i31 = (~(i & 1)) & (i | 1);
                        objArr = new Object[4];
                    }
                    objArr[0] = new int[]{i};
                    objArr[1] = new int[]{i31};
                    int[] iArr = new int[1];
                    objArr[2] = iArr;
                    objArr[3] = null;
                    int i127 = 1475583938 + (((~((-5546049) | i)) | (~(973077726 | i43))) * (-318)) + (((~(427752664 | i)) | 545325062) * (-318)) + (((~((-427752665) | i)) | (-550871111)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                    int i128 = (i127 & 16) + (i127 | 16);
                    int i129 = i126 + 91;
                    int i130 = i129 % 128;
                    artificialFrame = i130;
                    int i131 = i129 % 2;
                    int i132 = i128 + i2;
                    int i133 = i132 << 13;
                    int i134 = ((~i132) & i133) | ((~i133) & i132);
                    int i135 = i134 >>> 17;
                    int i136 = (i134 | i135) & (~(i134 & i135));
                    int i137 = i130 + 79;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i137 % 128;
                    int i138 = i137 % 2;
                    int i139 = i136 << 5;
                    iArr[0] = ((~i136) & i139) | ((~i139) & i136);
                    break;
                }
                i64 = ((i64 | 1) << 1) - (i64 ^ 1);
                i32 = 2;
            }
            c = 0;
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[]{i}, null};
            int i140 = ~(48858409 | i);
            int i141 = ~i;
            int i142 = i140 | (~(1027482184 | i141));
            int i143 = ~((-48858410) | i141);
            int i144 = (-362341546) + ((i142 | i143) * (-516)) + (((~((-1024860737) | i)) | (~(i141 | (-2621449)))) * 516) + ((2621448 | i143) * 516) + 16;
            int i145 = (i2 & i144) + (i2 | i144);
            int i146 = i145 ^ (i145 << 13);
            int i147 = i146 >>> 17;
            int i148 = ((~i146) & i147) | ((~i147) & i146);
            int i149 = i148 << 5;
            int i150 = (i148 | i149) & (~(i148 & i149));
            c = 0;
        }
        if (i != ((int[]) objArr[1])[c]) {
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int i151 = 10 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char c2 = (char) (64610 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                int i152 = 1806 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                byte b2 = (byte) 0;
                byte b3 = b2;
                Object[] objArr7 = new Object[1];
                b(b2, b3, b3, objArr7);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i151, c2, i152, -1135716921, false, (String) objArr7[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            int i153 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i154 = ((i153 | 99) << 1) - (i153 ^ 99);
            artificialFrame = i154 % 128;
            int i155 = i154 % 2;
            long j = -1048449172;
            long j2 = (((long) (-433)) * j) + (((long) (-216)) * jLongValue);
            long j3 = JfifUtil.MARKER_EOI;
            long j4 = -1;
            long j5 = j ^ j4;
            long j6 = i;
            long j7 = j6 ^ j4;
            long j8 = jLongValue ^ j4;
            long j9 = j2 + ((((j5 | j7) ^ j4) | ((j8 | j6) ^ j4)) * j3) + ((((j5 | j8) ^ j4) | ((j5 | j6) ^ j4)) * j3) + (j3 * (((j8 | j7) ^ j4) | j)) + ((long) 1388657206);
            int i156 = ~i;
            if (((((int) j9) & ((-1117649359) + (((~((-1097892981) | i156)) | (-1759847906) | (~(1097892980 | i))) * (-564)) + ((~((-679813506) | i)) * 1128) + (((~((-1759847906) | i156)) | (-1777706486)) * 564))) | (((int) (j9 >> 32)) & ((-1729999836) + ((~((-1241547145) | i156)) * 433) + (((~((-99972131) | i)) | (-1337254281)) * (-433)) + (((~((-1337254281) | i)) | (-1341519275)) * 433)))) == 1) {
                int i157 = i153 + 79;
                artificialFrame = i157 % 128;
                int i158 = i157 % 2;
                Object[] objArr8 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                int i159 = ~(133385795 | i);
                int i160 = 191242817 + ((805306520 | i159) * (-814)) + ((i159 | (~((-845237980) | i156)) | 93454336) * 407) + (((~((-133385796) | i)) | 93454336 | (~(845237979 | i))) * 407);
                int i161 = i160 * (-219);
                int i162 = (3536 & i161) + (i161 | 3536);
                int i163 = ~i160;
                int i164 = (i156 ^ 16) | (i156 & 16);
                int i165 = (i162 - (~(((~((i163 & (-17)) | ((-17) ^ i163))) | (~((i164 & i160) | (i164 ^ i160)))) * 220))) - 1;
                int i166 = ~(i156 | i160);
                int i167 = -(-(((i166 & 16) | (i166 ^ 16)) * (-440)));
                int i168 = (i165 & i167) + (i167 | i165);
                int i169 = (i160 ^ 16) | (i160 & 16);
                int i170 = (i168 - (~(-(-(((i169 & i) | (i169 ^ i)) * 220))))) - 1;
                int iMediaBrowserCompatMediaBrowserImplApi216 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                int i171 = i170 * (-518);
                int i172 = i2 * (-518);
                int i173 = (i171 & i172) + (i171 | i172);
                int i174 = ~i170;
                int i175 = ~iMediaBrowserCompatMediaBrowserImplApi216;
                int i176 = ~((i174 ^ i175) | (i174 & i175));
                int i177 = (i173 - (~(-(-(((i176 & i2) | (i2 ^ i176)) * 519))))) - 1;
                int i178 = ~((i174 & i175) | (i174 ^ i175) | i2);
                int i179 = (i170 ^ i2) | (i170 & i2);
                int i180 = ~((i179 & iMediaBrowserCompatMediaBrowserImplApi216) | (i179 ^ iMediaBrowserCompatMediaBrowserImplApi216));
                int i181 = (i177 - (~(((i178 & i180) | (i178 ^ i180)) * (-519)))) - 1;
                int i182 = ~((iMediaBrowserCompatMediaBrowserImplApi216 & i2) | (i2 ^ iMediaBrowserCompatMediaBrowserImplApi216));
                int i183 = -(-(((i182 & i170) | (i170 ^ i182)) * 519));
                int i184 = ((i181 | i183) << 1) - (i183 ^ i181);
                int i185 = i184 << 13;
                int i186 = (i185 | i184) & (~(i184 & i185));
                int i187 = i186 >>> 17;
                int i188 = (i186 | i187) & (~(i186 & i187));
                int i189 = i188 << 5;
                ((int[]) objArr8[2])[0] = ((~i188) & i189) | ((~i189) & i188);
                objArr2 = objArr8;
                i3 = 2;
            } else {
                Object[] objArr9 = {new int[]{i}, new int[]{i}, new int[1], null};
                int iNextInt = new Random().nextInt(1338053489);
                int i190 = ~iNextInt;
                int i191 = (-78468566) + ((iNextInt | 138240) * 988) + (((~(982981635 | i190)) | (-987201256)) * (-1976)) + (((~(iNextInt | 4357860)) | 138240 | (~((-4357861) | i190))) * 988);
                int iMediaBrowserCompatMediaBrowserImplApi217 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                int i192 = (-1) - (~(i191 * (-919)));
                int i193 = ~i191;
                int i194 = i193 | ((-1) ^ i193);
                int i195 = ~((i194 & iMediaBrowserCompatMediaBrowserImplApi217) | (i194 ^ iMediaBrowserCompatMediaBrowserImplApi217));
                int i196 = ~i191;
                int i197 = ~iMediaBrowserCompatMediaBrowserImplApi217;
                int i198 = -(-((i195 | (~((i196 ^ i197) | (i196 & i197)))) * 920));
                int i199 = ((i192 | i198) << 1) - (i192 ^ i198);
                int i200 = (~(((-1) ^ i197) | i197)) * 920;
                int i201 = (i199 ^ i200) + ((i200 & i199) << 1);
                int i202 = ~(((-1) ^ i196) | i196 | i197);
                int i203 = ~(((-1) ^ i191) | i191 | iMediaBrowserCompatMediaBrowserImplApi217);
                int i204 = (i202 & i203) | (i202 ^ i203);
                int i205 = ~((iMediaBrowserCompatMediaBrowserImplApi217 & i196) | (i196 ^ iMediaBrowserCompatMediaBrowserImplApi217));
                int i206 = i201 + (((i205 & i204) | (i204 ^ i205)) * 920);
                int i207 = (i2 & i206) + (i2 | i206);
                int i208 = i207 ^ (i207 << 13);
                int i209 = i208 ^ (i208 >>> 17);
                i3 = 2;
                ((int[]) objArr9[2])[0] = i209 ^ (i209 << 5);
                objArr2 = objArr9;
            }
            int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i211 = i210 + 3;
            artificialFrame = i211 % 128;
            int i212 = i211 % i3;
            if (i != ((int[]) objArr2[1])[0]) {
                int i213 = ((i210 | 69) << 1) - (i210 ^ 69);
                artificialFrame = i213 % 128;
                int i214 = i213 % 2;
                return objArr2;
            }
            try {
                int i215 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                int iMediaBrowserCompatMediaBrowserImplApi218 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                int i216 = i215 * (-405);
                int i217 = (i216 & 16280) + (i216 | 16280);
                int i218 = ~(((-41) & iMediaBrowserCompatMediaBrowserImplApi218) | ((-41) ^ iMediaBrowserCompatMediaBrowserImplApi218));
                int i219 = ~iMediaBrowserCompatMediaBrowserImplApi218;
                int i220 = ~((i219 ^ i215) | (i219 & i215) | 40);
                int i221 = i217 + (((i218 & i220) | (i218 ^ i220)) * (-406));
                int i222 = ((-41) & i219) | ((-41) ^ i219);
                Object[] objArr10 = new Object[1];
                a(((i221 - (~(-(-((~((i222 & i215) | (i222 ^ i215))) * (-406)))))) - 1) + (((~((~i215) | iMediaBrowserCompatMediaBrowserImplApi218)) | (~(i219 | 40))) * 406), new char[]{27, CharUtils.CR, '!', 14, 29, 1, 16, 7, 19, 14, 19, 27, 1, '\f', 2, 25, 1, 31, '\"', 16, 5, 3, '\b', 21, 1, 31, '\b', ' ', 13874, 13874, 14, 19, 29, '\"', '\"', 16, 5, 3, 16, 7}, (byte) (73 - (~(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), objArr10);
                File file3 = new File((String) objArr10[0]);
                try {
                    if (file3.canRead()) {
                        FileReader fileReader3 = new FileReader(file3);
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                        try {
                            line = bufferedReader3.readLine();
                            int touchSlop = 3 - (ViewConfiguration.getTouchSlop() >> 8);
                            char[] cArr3 = {23, 14, 13841};
                            float scrollFriction = ViewConfiguration.getScrollFriction();
                            int i223 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                            artificialFrame = i223 % 128;
                            int i224 = (scrollFriction > 0.0f ? 1 : (scrollFriction == 0.0f ? 0 : -1));
                            if (i223 % 2 == 0) {
                                Object[] objArr11 = new Object[1];
                                a(touchSlop, cArr3, (byte) (38 >>> i224), objArr11);
                                if (!line.equals((String) objArr11[0])) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                }
                                fileReader3.close();
                                bufferedReader3.close();
                            } else {
                                int i225 = -(-i224);
                                Object[] objArr12 = new Object[1];
                                a(touchSlop, cArr3, (byte) ((i225 & 38) + (i225 | 38)), objArr12);
                                if (line.equals((String) objArr12[0])) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                } else {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                }
                            }
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                            Object[] objArr13 = new Object[1];
                            a(((iIndexOf | 32) << 1) - (iIndexOf ^ 32), new char[]{28, 31, 11, 16, 1, 26, 14, '!', CharUtils.CR, 27, 1, 17, '\b', 22, 15, 19, 31, 25, '\"', 16, 5, 3, 17, 31, 14, 19, 5, 2, 19, 15, 13939}, (byte) (116 - (~(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), objArr13);
                            file = new File((String) objArr13[0]);
                            if (!file.canRead()) {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                try {
                                    String line3 = bufferedReader.readLine();
                                    int i226 = -((byte) KeyEvent.getModifierMetaStateMask());
                                    int iMediaBrowserCompatMediaBrowserImplApi219 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                    int i227 = i226 * 46;
                                    int i228 = ((i227 | 3266) << 1) - (i227 ^ 3266);
                                    int i229 = ~iMediaBrowserCompatMediaBrowserImplApi219;
                                    int i230 = -(-(((~((i229 & (-72)) | ((-72) ^ i229))) | i226) * (-90)));
                                    int i231 = (i228 & i230) + (i230 | i228);
                                    int i232 = ~(((-72) ^ iMediaBrowserCompatMediaBrowserImplApi219) | ((-72) & iMediaBrowserCompatMediaBrowserImplApi219));
                                    int i233 = ~(i226 | 71);
                                    int i234 = -(-(((i232 ^ i233) | (i232 & i233)) * (-45)));
                                    int i235 = (i231 & i234) + (i234 | i231);
                                    int i236 = ~((~i226) | iMediaBrowserCompatMediaBrowserImplApi219);
                                    int i237 = (i236 & (-72)) | ((-72) ^ i236);
                                    int i238 = ~iMediaBrowserCompatMediaBrowserImplApi219;
                                    int i239 = ~((i226 & i238) | (i238 ^ i226));
                                    int i240 = ((i239 & i237) | (i237 ^ i239)) * 45;
                                    Object[] objArr14 = new Object[1];
                                    a(-TextUtils.lastIndexOf("", '0', 0, 0), new char[]{13811}, (byte) ((i235 ^ i240) + ((i240 & i235) << 1)), objArr14);
                                    zEquals = line3.equals((String) objArr14[0]);
                                    fileReader.close();
                                    bufferedReader.close();
                                    if (zEquals) {
                                        int i241 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                        int i242 = (i241 & 37) + (i241 | 37);
                                        char[] cArr4 = {27, CharUtils.CR, '!', 14, 29, 1, 16, 7, 19, 14, 19, 27, 1, '\f', 2, 25, 1, 31, '\"', 16, 5, 3, '\b', 21, 1, 31, '\"', 16, 5, 3, '\b', 21, ' ', 30, 14, 23};
                                        int i243 = -Process.getGidForName("");
                                        int i244 = (i243 * (-495)) - 36135;
                                        int i245 = ~i243;
                                        int i246 = ~((i245 ^ (-74)) | (i245 & (-74)));
                                        int i247 = ~i243;
                                        int i248 = (i246 | (~((i247 ^ i) | (i247 & i)))) * 992;
                                        int i249 = ((i244 | i248) << 1) - (i244 ^ i248);
                                        int i250 = (~((i245 ^ (-74)) | (i245 & (-74)))) | (~((i247 ^ i) | (i247 & i)));
                                        int i251 = ~i;
                                        int i252 = (i243 & i251) | (i251 ^ i243);
                                        int i253 = ~((i252 & 73) | (i252 ^ 73));
                                        int i254 = ((i253 & i250) | (i250 ^ i253)) * (-496);
                                        Object[] objArr15 = new Object[1];
                                        a(i242, cArr4, (byte) ((i249 & i254) + (i254 | i249) + (((i ^ 73) | (i & 73)) * 496)), objArr15);
                                        file2 = new File((String) objArr15[0]);
                                        if (file2.canRead()) {
                                            fileReader2 = new FileReader(file2);
                                            bufferedReader2 = new BufferedReader(fileReader2);
                                            i8 = artificialFrame + 115;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                                            try {
                                                if (i8 % 2 != 0) {
                                                    line2 = bufferedReader2.readLine();
                                                    iCombineMeasuredStates = View.combineMeasuredStates(1, 0);
                                                    iMediaBrowserCompatMediaBrowserImplApi212 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                                    i9 = 0;
                                                } else {
                                                    line2 = bufferedReader2.readLine();
                                                    iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                                                    iMediaBrowserCompatMediaBrowserImplApi212 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                                    i9 = 1;
                                                }
                                                i10 = (iCombineMeasuredStates * 370) + (i9 * 370);
                                                i11 = artificialFrame;
                                                i12 = ((i11 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i11 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                                                if (i12 % 2 != 0) {
                                                    int i255 = (iCombineMeasuredStates ^ i9) | (iCombineMeasuredStates & i9);
                                                    int i256 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                                    i13 = i10 / (((i255 & i256) | (i255 ^ i256)) * (-369));
                                                } else {
                                                    int i257 = iCombineMeasuredStates | i9;
                                                    int i258 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                                    i13 = (i10 - (~(((i257 & i258) | (i257 ^ i258)) * (-369)))) - 1;
                                                }
                                                int i259 = ~iCombineMeasuredStates;
                                                i14 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                                int i260 = ~((i259 & i14) | (i259 ^ i14));
                                                int i261 = -(-((-369) * ((i260 & i9) | (i9 ^ i260))));
                                                i15 = (i13 ^ i261) + ((i13 & i261) << 1);
                                                int i262 = ~i9;
                                                i16 = ~((i262 & iCombineMeasuredStates) | (i262 ^ iCombineMeasuredStates));
                                                i17 = i11 + 49;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
                                                if (i17 % 2 == 0) {
                                                    Object obj = null;
                                                    obj.hashCode();
                                                    throw null;
                                                }
                                                int i263 = ~((iMediaBrowserCompatMediaBrowserImplApi212 & iCombineMeasuredStates) | (iCombineMeasuredStates ^ iMediaBrowserCompatMediaBrowserImplApi212));
                                                i18 = (i263 & i16) | (i16 ^ i263);
                                                int i264 = (~iCombineMeasuredStates) | i14;
                                                int i265 = (i9 & i264) | (i264 ^ i9);
                                                int i266 = ((i11 | 101) << 1) - (i11 ^ 101);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i266 % 128;
                                                i19 = i266 % 2;
                                                i20 = ~i265;
                                                if (i19 != 0) {
                                                    int i267 = i15 >> ((i18 | i20) + 369);
                                                    int i268 = -Gravity.getAbsoluteGravity(0, 0);
                                                    Object[] objArr16 = new Object[1];
                                                    a(i267, new char[]{13811}, (byte) ((i268 ^ 41) + ((i268 & 41) << 1)), objArr16);
                                                    str = (String) objArr16[0];
                                                } else {
                                                    Object[] objArr17 = new Object[1];
                                                    a((i15 - (~(((i18 & i20) | (i18 ^ i20)) * 369))) - 1, new char[]{13811}, (byte) (72 - Gravity.getAbsoluteGravity(0, 0)), objArr17);
                                                    str = (String) objArr17[0];
                                                }
                                                zEquals2 = line2.equals(str);
                                                fileReader2.close();
                                                bufferedReader2.close();
                                                if (zEquals2 && line != null) {
                                                    Object[] objArr18 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[1], line};
                                                    int startUptimeMillis = (int) Process.getStartUptimeMillis();
                                                    int i269 = 1676307006 + (((~(1066067307 | startUptimeMillis)) | (-87443533)) * 672);
                                                    int i270 = ~startUptimeMillis;
                                                    int i271 = i269 + (((~(startUptimeMillis | (-87443533))) | (~((-1066067308) | i270))) * (-672)) + (((~(87443532 | i270)) | (-1069477232)) * 672);
                                                    int iMediaBrowserCompatMediaBrowserImplApi2110 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                                    int i272 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i273 = (i272 ^ 53) + ((i272 & 53) << 1);
                                                    int i274 = i273 % 128;
                                                    artificialFrame = i274;
                                                    int i275 = i273 % 2;
                                                    int i276 = (-1187) * i271;
                                                    int i277 = ~(((-17) ^ i271) | ((-17) & i271));
                                                    int i278 = ~iMediaBrowserCompatMediaBrowserImplApi2110;
                                                    int i279 = ~((i278 ^ i271) | (i278 & i271));
                                                    int i280 = (((9520 | i276) << 1) - (i276 ^ 9520)) + (((i277 & i279) | (i277 ^ i279)) * (-1188));
                                                    int i281 = ~((-17) | i271);
                                                    int i282 = ~i271;
                                                    int i283 = ~((i282 & iMediaBrowserCompatMediaBrowserImplApi2110) | (i282 ^ iMediaBrowserCompatMediaBrowserImplApi2110));
                                                    int i284 = (i281 & i283) | (i281 ^ i283);
                                                    int i285 = ~(i278 | 16);
                                                    int i286 = ((i284 & i285) | (i284 ^ i285)) * 594;
                                                    int i287 = (i280 ^ i286) + ((i286 & i280) << 1);
                                                    int i288 = ~i271;
                                                    int i289 = ~(i288 | i278);
                                                    int i290 = ~((i288 & 16) | (i288 ^ 16));
                                                    int i291 = ~iMediaBrowserCompatMediaBrowserImplApi2110;
                                                    int i292 = (~((i291 & 16) | (i291 ^ 16))) | (i290 & i289) | (i289 ^ i290);
                                                    int i293 = (i274 ^ 117) + ((i274 & 117) << 1);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i293 % 128;
                                                    int i294 = i293 % 2;
                                                    int i295 = -(-(594 * i292));
                                                    int i296 = (i287 & i295) + (i295 | i287);
                                                    int i297 = i296 * 471;
                                                    int i298 = -(-(i2 * 471));
                                                    int i299 = ((i297 | i298) << 1) - (i297 ^ i298);
                                                    int i300 = ((i296 ^ i2) | (i296 & i2)) * (-470);
                                                    int i301 = (i299 & i300) + (i300 | i299);
                                                    int i302 = ~i296;
                                                    int i303 = ~i2;
                                                    int i304 = ~((i302 & i303) | (i302 ^ i303));
                                                    int i305 = ~i2;
                                                    int i306 = ~((i305 & i) | (i305 ^ i));
                                                    int i307 = (i304 & i306) | (i304 ^ i306);
                                                    int i308 = ~((i156 & i296) | (i156 ^ i296) | i2);
                                                    int i309 = (i301 - (~(-(-(((i307 & i308) | (i307 ^ i308)) * (-470)))))) - 1;
                                                    int i310 = (i303 ^ i296) | (i303 & i296);
                                                    int i311 = ~((i310 & i) | (i310 ^ i));
                                                    int i312 = ~i;
                                                    int i313 = (i312 & i296) | (i312 ^ i296);
                                                    int i314 = ~((i313 & i2) | (i313 ^ i2));
                                                    int i315 = ((i311 & i314) | (i311 ^ i314)) * 470;
                                                    int i316 = ((i309 | i315) << 1) - (i315 ^ i309);
                                                    int i317 = i316 << 13;
                                                    int i318 = (i317 & (~i316)) | ((~i317) & i316);
                                                    int i319 = i318 ^ (i318 >>> 17);
                                                    int i320 = i319 << 5;
                                                    ((int[]) objArr18[2])[0] = ((~i319) & i320) | ((~i320) & i319);
                                                    return objArr18;
                                                }
                                            } catch (Throwable th) {
                                                fileReader2.close();
                                                bufferedReader2.close();
                                                throw th;
                                            }
                                        } else {
                                            int i321 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i322 = ((i321 | 27) << 1) - (i321 ^ 27);
                                            artificialFrame = i322 % 128;
                                            int i323 = i322 % 2;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    fileReader.close();
                                    bufferedReader.close();
                                    throw th2;
                                }
                            }
                            objArr3 = new Object[4];
                            objArr3[0] = new int[]{i};
                            objArr3[1] = new int[]{i};
                            objArr3[2] = new int[1];
                            int i324 = ~((698141834 & i156) | (698141834 ^ i156));
                            int i325 = -(-(((i324 & 541676960) | (541676960 ^ i324) | (~((-698141835) | i))) * (-564)));
                            int i326 = (708305484 ^ i325) + ((i325 & 708305484) << 1) + ((~(((-160729099) & i) | ((-160729099) ^ i))) * 1128);
                            int i327 = ~((541676960 & i156) | (541676960 ^ i156));
                            int i328 = ((i327 & 537412736) | (i327 ^ 537412736)) * 564;
                            i4 = ((i326 | i328) << 1) - (i328 ^ i326);
                            int iMediaBrowserCompatMediaBrowserImplApi2111 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                            int i329 = 20190611 - (~(-(-((~(((-441712650) & iMediaBrowserCompatMediaBrowserImplApi2111) | ((-441712650) ^ iMediaBrowserCompatMediaBrowserImplApi2111))) * 521))));
                            i5 = ((i329 | 1425338260) << 1) - (1425338260 ^ i329);
                            int i330 = (~iMediaBrowserCompatMediaBrowserImplApi2111) | (-460784090);
                            i6 = -(-(((~((i330 & (-1523868202)) | (i330 ^ (-1523868202)))) | (-1542939642)) * 521));
                            if (i4 > ((i5 | i6) << 1) - (i6 ^ i5)) {
                                objArr3[5] = null;
                                int i331 = (int) Runtime.getRuntime().totalMemory();
                                i7 = (-2014000914) + (((~((-599356871) | i331)) | 43590976) * 104) + ((~((~i331) | 935032798)) * (-104)) + ((i331 | 379266904) * 104);
                            } else {
                                objArr3[3] = null;
                                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                i7 = (-221413010) + (((~((-392970789) | iFreeMemory)) | 40387104) * 336) + (((~(iFreeMemory | 585652986)) | (-938236671)) * (-168)) + (((~((~iFreeMemory) | 585652986)) | (-392970789)) * 168);
                            }
                            int i332 = artificialFrame;
                            int i333 = (i332 & 119) + (i332 | 119);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i333 % 128;
                            int i334 = i333 % 2;
                            int i335 = i7 * 860;
                            int i336 = -(-(i2 * (-858)));
                            int i337 = (((i335 | i336) << 1) - (i335 ^ i336)) + (((i7 ^ i) | (i7 & i)) * (-859));
                            int i338 = ~((i156 ^ i7) | (i156 & i7));
                            int i339 = ~i7;
                            int i340 = ~i2;
                            int i341 = i339 | i340;
                            int i342 = ~((i341 & i) | (i341 ^ i));
                            int i343 = (i337 - (~(((i338 & i342) | (i338 ^ i342)) * 859))) - 1;
                            int i344 = ((~((~i) | i340)) | (~((i340 ^ i7) | (i340 & i7)))) * 859;
                            int i345 = ((i343 | i344) << 1) - (i344 ^ i343);
                            int i346 = i345 << 13;
                            int i347 = (i346 & (~i345)) | ((~i346) & i345);
                            int i348 = i347 >>> 17;
                            int i349 = (i347 | i348) & (~(i347 & i348));
                            int i350 = i349 << 5;
                            ((int[]) objArr3[2])[0] = ((~i349) & i350) | ((~i350) & i349);
                            return objArr3;
                        } catch (Throwable th3) {
                            fileReader3.close();
                            bufferedReader3.close();
                            throw th3;
                        }
                    }
                    int i351 = artificialFrame;
                    int i352 = (i351 & 89) + (i351 | 89);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i352 % 128;
                    int i353 = i352 % 2;
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0);
                    Object[] objArr19 = new Object[1];
                    a(((iIndexOf2 | 32) << 1) - (iIndexOf2 ^ 32), new char[]{28, 31, 11, 16, 1, 26, 14, '!', CharUtils.CR, 27, 1, 17, '\b', 22, 15, 19, 31, 25, '\"', 16, 5, 3, 17, 31, 14, 19, 5, 2, 19, 15, 13939}, (byte) (116 - (~(-(ViewConfiguration.getScrollBarFadeDuration() >> 16)))), objArr19);
                    file = new File((String) objArr19[0]);
                    if (!file.canRead()) {
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        String line4 = bufferedReader.readLine();
                        int i2210 = -((byte) KeyEvent.getModifierMetaStateMask());
                        int iMediaBrowserCompatMediaBrowserImplApi2112 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                        int i2211 = i2210 * 46;
                        int i2212 = ((i2211 | 3266) << 1) - (i2211 ^ 3266);
                        int i2213 = ~iMediaBrowserCompatMediaBrowserImplApi2112;
                        int i2310 = -(-(((~((i2213 & (-72)) | ((-72) ^ i2213))) | i2210) * (-90)));
                        int i2311 = (i2212 & i2310) + (i2310 | i2212);
                        int i2312 = ~(((-72) ^ iMediaBrowserCompatMediaBrowserImplApi2112) | ((-72) & iMediaBrowserCompatMediaBrowserImplApi2112));
                        int i2313 = ~(i2210 | 71);
                        int i2314 = -(-(((i2312 ^ i2313) | (i2312 & i2313)) * (-45)));
                        int i2315 = (i2311 & i2314) + (i2314 | i2311);
                        int i2316 = ~((~i2210) | iMediaBrowserCompatMediaBrowserImplApi2112);
                        int i2317 = (i2316 & (-72)) | ((-72) ^ i2316);
                        int i2318 = ~iMediaBrowserCompatMediaBrowserImplApi2112;
                        int i2319 = ~((i2210 & i2318) | (i2318 ^ i2210));
                        int i2410 = ((i2319 & i2317) | (i2317 ^ i2319)) * 45;
                        Object[] objArr110 = new Object[1];
                        a(-TextUtils.lastIndexOf("", '0', 0, 0), new char[]{13811}, (byte) ((i2315 ^ i2410) + ((i2410 & i2315) << 1)), objArr110);
                        zEquals = line4.equals((String) objArr110[0]);
                        fileReader.close();
                        bufferedReader.close();
                        if (zEquals) {
                            int i2411 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            int i2412 = (i2411 & 37) + (i2411 | 37);
                            char[] cArr5 = {27, CharUtils.CR, '!', 14, 29, 1, 16, 7, 19, 14, 19, 27, 1, '\f', 2, 25, 1, 31, '\"', 16, 5, 3, '\b', 21, 1, 31, '\"', 16, 5, 3, '\b', 21, ' ', 30, 14, 23};
                            int i2413 = -Process.getGidForName("");
                            int i2414 = (i2413 * (-495)) - 36135;
                            int i2415 = ~i2413;
                            int i2416 = ~((i2415 ^ (-74)) | (i2415 & (-74)));
                            int i2417 = ~i2413;
                            int i2418 = (i2416 | (~((i2417 ^ i) | (i2417 & i)))) * 992;
                            int i2419 = ((i2414 | i2418) << 1) - (i2414 ^ i2418);
                            int i2510 = (~((i2415 ^ (-74)) | (i2415 & (-74)))) | (~((i2417 ^ i) | (i2417 & i)));
                            int i2511 = ~i;
                            int i2512 = (i2413 & i2511) | (i2511 ^ i2413);
                            int i2513 = ~((i2512 & 73) | (i2512 ^ 73));
                            int i2514 = ((i2513 & i2510) | (i2510 ^ i2513)) * (-496);
                            Object[] objArr111 = new Object[1];
                            a(i2412, cArr5, (byte) ((i2419 & i2514) + (i2514 | i2419) + (((i ^ 73) | (i & 73)) * 496)), objArr111);
                            file2 = new File((String) objArr111[0]);
                            if (file2.canRead()) {
                                int i3210 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i3211 = ((i3210 | 27) << 1) - (i3210 ^ 27);
                                artificialFrame = i3211 % 128;
                                int i3212 = i3211 % 2;
                            } else {
                                fileReader2 = new FileReader(file2);
                                bufferedReader2 = new BufferedReader(fileReader2);
                                i8 = artificialFrame + 115;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                                if (i8 % 2 != 0) {
                                    line2 = bufferedReader2.readLine();
                                    iCombineMeasuredStates = View.combineMeasuredStates(1, 0);
                                    iMediaBrowserCompatMediaBrowserImplApi212 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                    i9 = 0;
                                } else {
                                    line2 = bufferedReader2.readLine();
                                    iCombineMeasuredStates = View.combineMeasuredStates(0, 0);
                                    iMediaBrowserCompatMediaBrowserImplApi212 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                    i9 = 1;
                                }
                                i10 = (iCombineMeasuredStates * 370) + (i9 * 370);
                                i11 = artificialFrame;
                                i12 = ((i11 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i11 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                                if (i12 % 2 != 0) {
                                    int i2515 = (iCombineMeasuredStates ^ i9) | (iCombineMeasuredStates & i9);
                                    int i2516 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                    i13 = i10 / (((i2515 & i2516) | (i2515 ^ i2516)) * (-369));
                                } else {
                                    int i2517 = iCombineMeasuredStates | i9;
                                    int i2518 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                    i13 = (i10 - (~(((i2517 & i2518) | (i2517 ^ i2518)) * (-369)))) - 1;
                                }
                                int i2519 = ~iCombineMeasuredStates;
                                i14 = ~iMediaBrowserCompatMediaBrowserImplApi212;
                                int i2610 = ~((i2519 & i14) | (i2519 ^ i14));
                                int i2611 = -(-((-369) * ((i2610 & i9) | (i9 ^ i2610))));
                                i15 = (i13 ^ i2611) + ((i13 & i2611) << 1);
                                int i2612 = ~i9;
                                i16 = ~((i2612 & iCombineMeasuredStates) | (i2612 ^ iCombineMeasuredStates));
                                i17 = i11 + 49;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
                                if (i17 % 2 == 0) {
                                    Object obj2 = null;
                                    obj2.hashCode();
                                    throw null;
                                }
                                int i2613 = ~((iMediaBrowserCompatMediaBrowserImplApi212 & iCombineMeasuredStates) | (iCombineMeasuredStates ^ iMediaBrowserCompatMediaBrowserImplApi212));
                                i18 = (i2613 & i16) | (i16 ^ i2613);
                                int i2614 = (~iCombineMeasuredStates) | i14;
                                int i2615 = (i9 & i2614) | (i2614 ^ i9);
                                int i2616 = ((i11 | 101) << 1) - (i11 ^ 101);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i2616 % 128;
                                i19 = i2616 % 2;
                                i20 = ~i2615;
                                if (i19 != 0) {
                                    int i2617 = i15 >> ((i18 | i20) + 369);
                                    int i2618 = -Gravity.getAbsoluteGravity(0, 0);
                                    Object[] objArr112 = new Object[1];
                                    a(i2617, new char[]{13811}, (byte) ((i2618 ^ 41) + ((i2618 & 41) << 1)), objArr112);
                                    str = (String) objArr112[0];
                                } else {
                                    Object[] objArr113 = new Object[1];
                                    a((i15 - (~(((i18 & i20) | (i18 ^ i20)) * 369))) - 1, new char[]{13811}, (byte) (72 - Gravity.getAbsoluteGravity(0, 0)), objArr113);
                                    str = (String) objArr113[0];
                                }
                                zEquals2 = line2.equals(str);
                                fileReader2.close();
                                bufferedReader2.close();
                                if (zEquals2) {
                                    Object[] objArr114 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[1], line};
                                    int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                                    int i2619 = 1676307006 + (((~(1066067307 | startUptimeMillis2)) | (-87443533)) * 672);
                                    int i2710 = ~startUptimeMillis2;
                                    int i2711 = i2619 + (((~(startUptimeMillis2 | (-87443533))) | (~((-1066067308) | i2710))) * (-672)) + (((~(87443532 | i2710)) | (-1069477232)) * 672);
                                    int iMediaBrowserCompatMediaBrowserImplApi2113 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
                                    int i2712 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i2713 = (i2712 ^ 53) + ((i2712 & 53) << 1);
                                    int i2714 = i2713 % 128;
                                    artificialFrame = i2714;
                                    int i2715 = i2713 % 2;
                                    int i2716 = (-1187) * i2711;
                                    int i2717 = ~(((-17) ^ i2711) | ((-17) & i2711));
                                    int i2718 = ~iMediaBrowserCompatMediaBrowserImplApi2113;
                                    int i2719 = ~((i2718 ^ i2711) | (i2718 & i2711));
                                    int i2810 = (((9520 | i2716) << 1) - (i2716 ^ 9520)) + (((i2717 & i2719) | (i2717 ^ i2719)) * (-1188));
                                    int i2811 = ~((-17) | i2711);
                                    int i2812 = ~i2711;
                                    int i2813 = ~((i2812 & iMediaBrowserCompatMediaBrowserImplApi2113) | (i2812 ^ iMediaBrowserCompatMediaBrowserImplApi2113));
                                    int i2814 = (i2811 & i2813) | (i2811 ^ i2813);
                                    int i2815 = ~(i2718 | 16);
                                    int i2816 = ((i2814 & i2815) | (i2814 ^ i2815)) * 594;
                                    int i2817 = (i2810 ^ i2816) + ((i2816 & i2810) << 1);
                                    int i2818 = ~i2711;
                                    int i2819 = ~(i2818 | i2718);
                                    int i2910 = ~((i2818 & 16) | (i2818 ^ 16));
                                    int i2911 = ~iMediaBrowserCompatMediaBrowserImplApi2113;
                                    int i2912 = (~((i2911 & 16) | (i2911 ^ 16))) | (i2910 & i2819) | (i2819 ^ i2910);
                                    int i2913 = (i2714 ^ 117) + ((i2714 & 117) << 1);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2913 % 128;
                                    int i2914 = i2913 % 2;
                                    int i2915 = -(-(594 * i2912));
                                    int i2916 = (i2817 & i2915) + (i2915 | i2817);
                                    int i2917 = i2916 * 471;
                                    int i2918 = -(-(i2 * 471));
                                    int i2919 = ((i2917 | i2918) << 1) - (i2917 ^ i2918);
                                    int i3010 = ((i2916 ^ i2) | (i2916 & i2)) * (-470);
                                    int i3011 = (i2919 & i3010) + (i3010 | i2919);
                                    int i3012 = ~i2916;
                                    int i3013 = ~i2;
                                    int i3014 = ~((i3012 & i3013) | (i3012 ^ i3013));
                                    int i3015 = ~i2;
                                    int i3016 = ~((i3015 & i) | (i3015 ^ i));
                                    int i3017 = (i3014 & i3016) | (i3014 ^ i3016);
                                    int i3018 = ~((i156 & i2916) | (i156 ^ i2916) | i2);
                                    int i3019 = (i3011 - (~(-(-(((i3017 & i3018) | (i3017 ^ i3018)) * (-470)))))) - 1;
                                    int i3110 = (i3013 ^ i2916) | (i3013 & i2916);
                                    int i3111 = ~((i3110 & i) | (i3110 ^ i));
                                    int i3112 = ~i;
                                    int i3113 = (i3112 & i2916) | (i3112 ^ i2916);
                                    int i3114 = ~((i3113 & i2) | (i3113 ^ i2));
                                    int i3115 = ((i3111 & i3114) | (i3111 ^ i3114)) * 470;
                                    int i3116 = ((i3019 | i3115) << 1) - (i3115 ^ i3019);
                                    int i3117 = i3116 << 13;
                                    int i3118 = (i3117 & (~i3116)) | ((~i3117) & i3116);
                                    int i3119 = i3118 ^ (i3118 >>> 17);
                                    int i3213 = i3119 << 5;
                                    ((int[]) objArr114[2])[0] = ((~i3119) & i3213) | ((~i3213) & i3119);
                                    return objArr114;
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
            }
            line = null;
            objArr3 = new Object[4];
            objArr3[0] = new int[]{i};
            objArr3[1] = new int[]{i};
            objArr3[2] = new int[1];
            int i3214 = ~((698141834 & i156) | (698141834 ^ i156));
            int i3215 = -(-(((i3214 & 541676960) | (541676960 ^ i3214) | (~((-698141835) | i))) * (-564)));
            int i3216 = (708305484 ^ i3215) + ((i3215 & 708305484) << 1) + ((~(((-160729099) & i) | ((-160729099) ^ i))) * 1128);
            int i3217 = ~((541676960 & i156) | (541676960 ^ i156));
            int i3218 = ((i3217 & 537412736) | (i3217 ^ 537412736)) * 564;
            i4 = ((i3216 | i3218) << 1) - (i3218 ^ i3216);
            int iMediaBrowserCompatMediaBrowserImplApi2114 = SentryEnvelope.MediaBrowserCompatMediaBrowserImplApi212();
            int i3219 = 20190611 - (~(-(-((~(((-441712650) & iMediaBrowserCompatMediaBrowserImplApi2114) | ((-441712650) ^ iMediaBrowserCompatMediaBrowserImplApi2114))) * 521))));
            i5 = ((i3219 | 1425338260) << 1) - (1425338260 ^ i3219);
            int i3310 = (~iMediaBrowserCompatMediaBrowserImplApi2114) | (-460784090);
            i6 = -(-(((~((i3310 & (-1523868202)) | (i3310 ^ (-1523868202)))) | (-1542939642)) * 521));
            if (i4 > ((i5 | i6) << 1) - (i6 ^ i5)) {
                objArr3[5] = null;
                int i3311 = (int) Runtime.getRuntime().totalMemory();
                i7 = (-2014000914) + (((~((-599356871) | i3311)) | 43590976) * 104) + ((~((~i3311) | 935032798)) * (-104)) + ((i3311 | 379266904) * 104);
            } else {
                objArr3[3] = null;
                int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                i7 = (-221413010) + (((~((-392970789) | iFreeMemory2)) | 40387104) * 336) + (((~(iFreeMemory2 | 585652986)) | (-938236671)) * (-168)) + (((~((~iFreeMemory2) | 585652986)) | (-392970789)) * 168);
            }
            int i3312 = artificialFrame;
            int i3313 = (i3312 & 119) + (i3312 | 119);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3313 % 128;
            int i3314 = i3313 % 2;
            int i3315 = i7 * 860;
            int i3316 = -(-(i2 * (-858)));
            int i3317 = (((i3315 | i3316) << 1) - (i3315 ^ i3316)) + (((i7 ^ i) | (i7 & i)) * (-859));
            int i3318 = ~((i156 ^ i7) | (i156 & i7));
            int i3319 = ~i7;
            int i3410 = ~i2;
            int i3411 = i3319 | i3410;
            int i3412 = ~((i3411 & i) | (i3411 ^ i));
            int i3413 = (i3317 - (~(((i3318 & i3412) | (i3318 ^ i3412)) * 859))) - 1;
            int i3414 = ((~((~i) | i3410)) | (~((i3410 ^ i7) | (i3410 & i7)))) * 859;
            int i3415 = ((i3413 | i3414) << 1) - (i3414 ^ i3413);
            int i3416 = i3415 << 13;
            int i3417 = (i3416 & (~i3415)) | ((~i3416) & i3415);
            int i3418 = i3417 >>> 17;
            int i3419 = (i3417 | i3418) & (~(i3417 & i3418));
            int i354 = i3419 << 5;
            ((int[]) objArr3[2])[0] = ((~i3419) & i354) | ((~i354) & i3419);
            return objArr3;
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }
}
