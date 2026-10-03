package com.facebook.cache.disk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.build;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private final float mAgeWeight;
    private final float mSizeWeight;
    private static final byte[] $$a = {73, Ascii.DC4, -45, 126};
    private static final int $$b = 42;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56016, 56025, 56012, 56002, 55956, 56015, 56029, 56031, 56013, 56008, 56017, 56014, 56001, 56018, 55949, 55946, 56034, 56042, 56020, 56010, 56022, 56063, 56052, 55941, 56057, 56030, 56011, 55962, 56062, 56024, 56019, 55958, 56043, 56045, 56047, 56023, 56053, 56021, 56049};
    private static int warmup = -1044260166;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;
    private static char TopicBuilder = 63368;
    private static char ICustomTabsCallback = 1994;
    private static char extraCallbackWithResult = 60266;
    private static char onMessageChannelReady = 11981;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r5, byte r6, int r7) {
        /*
            int r5 = r5 * 3
            int r5 = r5 + 1
            int r7 = r7 + 66
            byte[] r0 = com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.$$a
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L14
            r4 = r5
            r3 = r2
            goto L24
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L22:
            r4 = r0[r6]
        L24:
            int r4 = -r4
            int r7 = r7 + r4
            int r6 = r6 + 1
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.$$c(int, byte, int):java.lang.String");
    }

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        this.mAgeWeight = f;
        this.mSizeWeight = f2;
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new EntryEvictionComparator() { // from class: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.1
            long now = System.currentTimeMillis();

            @Override // java.util.Comparator
            public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                float fCalculateScore = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry, this.now);
                float fCalculateScore2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry2, this.now);
                if (fCalculateScore < fCalculateScore2) {
                    return 1;
                }
                return fCalculateScore2 == fCalculateScore ? 0 : -1;
            }
        };
    }

    float calculateScore(DiskStorage.Entry entry, long j) {
        return (this.mAgeWeight * (j - entry.getTimestamp())) + (this.mSizeWeight * entry.getSize());
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i3 = $10 + 73;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i5 = 58224;
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = $11 + 55;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i5) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 28, (char) (TextUtils.indexOf((CharSequence) "", '0') + 17264), View.resolveSizeAndState(0, 0, 0) + 1067, 1042277788, false, $$c(b, b, (byte) $$b), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i5) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(27 - ImageFormat.getBitsPerPixel(0), (char) (17263 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 1067 - View.combineMeasuredStates(0, 0), 1042277788, false, $$c(b2, b2, (byte) $$b), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i5 -= 40503;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b3 = (byte) 0;
                byte b4 = b3;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 25, (char) (View.combineMeasuredStates(0, 0) + 63928), 486 - Color.blue(0), 1554985764, false, $$c(b3, b4, (byte) (b4 | 44)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        long j = 0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i4 = 0;
            while (i4 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i4])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        int i5 = 25 - (ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1));
                        char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                        int i6 = (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) + 1040;
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i5, longPressTimeout, i6, -1719489573, false, $$c(b, b2, (byte) (b2 | 55)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i4++;
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
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            byte b4 = b3;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 15, (char) (20488 - TextUtils.getOffsetBefore("", 0)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2147, 216472770, false, $$c(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i7 = -2083387879;
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                try {
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i7);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21, (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 59174), 1943 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 481771537, false, $$c(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    i7 = -2083387879;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = iArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i8 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c >> 1) % onmessagechannelready.a] >> i] * iIntValue);
                    i2 = onmessagechannelready.a;
                } else {
                    cArr5[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i2 = onmessagechannelready.a + 1;
                }
                onmessagechannelready.a = i2;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        int i9 = $10 + b.f40o;
        $11 = i9 % 128;
        int i10 = i9 % 2;
        onmessagechannelready.c = cArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            cArr6[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
            if (objAccessartificialFrame4 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 22, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 59173), (ViewConfiguration.getEdgeSlop() >> 16) + 1943, 481771537, false, $$c(b7, b8, b8), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr6);
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        Object[] objArr;
        int i3;
        int i4;
        int i5;
        String str;
        Object[] objArr2;
        Class<?> cls;
        String str2;
        Class<?> cls2;
        Class<?>[] clsArr;
        int i6;
        int i7;
        String str3;
        int i8;
        int i9;
        int i10;
        int i11 = 2 % 2;
        int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i13 = (i12 & 31) + (i12 | 31);
        artificialFrame = i13 % 128;
        int i14 = i13 % 2;
        char[] cArr = null;
        int i15 = 1;
        if (context == null) {
            objArr = new Object[4];
            int[] iArr = new int[1];
            objArr[0] = iArr;
            int[] iArr2 = new int[1];
            objArr[1] = iArr2;
            objArr[2] = new int[1];
            int i16 = ((i12 | 77) << 1) - (i12 ^ 77);
            artificialFrame = i16 % 128;
            if (i16 % 2 == 0) {
                iArr2[1] = i;
            } else {
                iArr[0] = i;
            }
            iArr2[0] = i;
            objArr[3] = null;
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i17 = -(-(670412542 + (((~(startElapsedRealtime | 365622298)) | (-613001477)) * (-668)) + ((365622298 | (~((-613001477) | startElapsedRealtime))) * 1336) + ((startElapsedRealtime | (-536938757)) * 668)));
            int i18 = (i2 & i17) + (i17 | i2);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 >>> 17;
            int i21 = (i19 | i20) & (~(i19 & i20));
            int i22 = artificialFrame;
            int i23 = (i22 & 1) + (i22 | 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
            if (i23 % 2 != 0) {
                int i24 = i21 >>> 5;
                ((int[]) objArr[2])[1] = ((~i21) & i24) | ((~i24) & i21);
            } else {
                int i25 = i21 << 5;
                ((int[]) objArr[2])[0] = ((~i21) & i25) | ((~i25) & i21);
            }
        } else {
            try {
                int i26 = 126 - (~(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                byte[] bArr = {-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127};
                int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                artificialFrame = i27 % 128;
                if (i27 % 2 == 0) {
                    Object[] objArr3 = new Object[1];
                    a(i26, bArr, null, null, objArr3);
                    throw null;
                }
                Object[] objArr4 = new Object[1];
                a(i26, bArr, null, null, objArr4);
                Object[] objArr5 = (Object[]) Array.newInstance(Class.forName((String) objArr4[0]), 2);
                int i28 = -(-MotionEvent.axisFromString(""));
                Object[] objArr6 = new Object[1];
                a((i28 & 128) + (i28 | 128), new byte[]{-93, -94, -104, -106, -96, -102, -117, -101, -118, -102, -109, -103, -104, -95, -96, -97, -119, -98, -121, -99, -100, -102, -117, -101, -118, -102, -109, -103, -104, -105, -106}, null, null, objArr6);
                String str4 = (String) objArr6[0];
                int i29 = ~i;
                int i30 = ~i;
                try {
                    Object[] objArr7 = {str4};
                    int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                    int iITrustedWebActivityService = RsaSsaPkcs1PublicKey.Builder.ITrustedWebActivityService();
                    int i31 = doubleTapTimeout * 236;
                    int i32 = artificialFrame;
                    int i33 = ((i32 | 55) << 1) - (i32 ^ 55);
                    int i34 = i33 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i34;
                    int i35 = i33 % 2;
                    int i36 = (i31 & 59817) + (i31 | 59817);
                    int i37 = ~doubleTapTimeout;
                    int i38 = ~iITrustedWebActivityService;
                    int i39 = ~((i37 ^ i38) | (i37 & i38));
                    int i40 = (i36 - (~(((127 ^ i39) | (i39 & 127)) * (-235)))) - 1;
                    int i41 = ~doubleTapTimeout;
                    int i42 = i34 + 93;
                    artificialFrame = i42 % 128;
                    int i43 = i42 % 2;
                    int i44 = ~((i41 ^ iITrustedWebActivityService) | (i41 & iITrustedWebActivityService));
                    int i45 = -(-((-470) * ((i44 & 127) | (127 ^ i44))));
                    int i46 = (i40 ^ i45) + ((i40 & i45) << 1);
                    int i47 = ~(((-128) ^ doubleTapTimeout) | (doubleTapTimeout & (-128)));
                    int i48 = (i41 ^ 127) | (i41 & 127);
                    int i49 = ~((i48 ^ iITrustedWebActivityService) | (iITrustedWebActivityService & i48));
                    int i50 = -(-(((i47 & i49) | (i47 ^ i49)) * 235));
                    Object[] objArr8 = new Object[1];
                    a((i46 & i50) + (i50 | i46), new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127}, null, null, objArr8);
                    objArr5[0] = Class.forName((String) objArr8[0]).getDeclaredConstructor(String.class).newInstance(objArr7);
                    int i51 = -(ViewConfiguration.getTouchSlop() >> 8);
                    int i52 = i51 * (-523);
                    int i53 = (i52 & 33401) + (i52 | 33401);
                    int i54 = ~i51;
                    int i55 = (~(i54 | 127)) | (~((-128) | i51));
                    int i56 = ~((-128) | i);
                    int i57 = ((i53 - (~(((i55 ^ i56) | (i56 & i55)) * 262))) - 1) + ((~(((-128) ^ i51) | ((-128) & i51))) * (-786));
                    int i58 = (~((i54 ^ 127) | (i54 & 127))) | (~(((-128) ^ i30) | ((-128) & i30)));
                    int i59 = ~((i51 & (-128)) | ((-128) ^ i51));
                    int i60 = i58 ^ i59;
                    Object[] objArr9 = new Object[1];
                    a((i57 - (~(-(-(((i59 & i58) | i60) * 262))))) - 1, new byte[]{-97, -119, -98, -121, -99, -100, -102, -117, -101, -118, -102, -109, -103, -104, -105, -106, -96, -102, -117, -101, -118, -102, -109, -103, -104, -95, -96, -93, -94, -104, -106}, null, null, objArr9);
                    String str5 = (String) objArr9[0];
                    int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
                    artificialFrame = i61 % 128;
                    int i62 = i61 % 2;
                    try {
                        Object[] objArr10 = {str5};
                        int iNormalizeMetaState = KeyEvent.normalizeMetaState(0);
                        int i63 = (iNormalizeMetaState * 284) - 35814;
                        int i64 = ~iNormalizeMetaState;
                        int i65 = ~((i64 ^ 127) | (i64 & 127));
                        int i66 = ~((i64 ^ i) | (i64 & i));
                        int i67 = -(-(((i65 ^ i66) | (i66 & i65)) * (-283)));
                        Object[] objArr11 = new Object[1];
                        a(((((i63 ^ i67) + ((i63 & i67) << 1)) + ((~(((-128) ^ iNormalizeMetaState) | ((-128) & iNormalizeMetaState))) * 283)) - (~((~(((~iNormalizeMetaState) | (-128)) | i)) * 283))) - 1, new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127}, null, null, objArr11);
                        objArr5[1] = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class).newInstance(objArr10);
                        int i68 = artificialFrame + 45;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i68 % 128;
                        int i69 = i68 % 2;
                        try {
                            int i70 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i71 = (i70 * 677) - 85725;
                            int i72 = (i70 ^ i) | (i70 & i);
                            int i73 = -(-(((i72 & (-128)) | (i72 ^ (-128))) * (-676)));
                            int i74 = (i71 & i73) + (i71 | i73);
                            int i75 = ~(((-128) ^ i70) | ((-128) & i70));
                            int i76 = ~((i30 ^ i70) | (i30 & i70));
                            int i77 = -(-(((i75 & i76) | (i75 ^ i76)) * 676));
                            int i78 = (i74 ^ i77) + ((i77 & i74) << 1);
                            int i79 = ~i70;
                            int i80 = ~(((-128) & i79) | (i79 ^ (-128)));
                            int i81 = ~(((-128) ^ i30) | ((-128) & i30));
                            Object[] objArr12 = new Object[1];
                            a(i78 + (((i80 & i81) | (i80 ^ i81) | (~(i70 | 127 | i))) * 676), new byte[]{-116, -124, -121, -116, -109, -101, -106, -123, -116, -109, -121, -116, -109, -101, -120, -123, -102, -117, -101, -118, -102, -109, -126}, null, null, objArr12);
                            Class<?> cls3 = Class.forName((String) objArr12[0]);
                            int i82 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                            Object[] objArr13 = new Object[1];
                            a((i82 ^ WebSocketProtocol.PAYLOAD_SHORT) + ((i82 & WebSocketProtocol.PAYLOAD_SHORT) << 1), new byte[]{-118, -121, -97, -126, -109, -126, -91, -121, -97, -126, -92, -120, -126, -110, -116, -121, -97}, null, null, objArr13);
                            Object objInvoke = cls3.getMethod((String) objArr13[0], null).invoke(context, null);
                            try {
                                int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                                int i83 = scrollBarFadeDuration * 567;
                                int i84 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                                int i85 = i84 % 128;
                                artificialFrame = i85;
                                if (i84 % 2 == 0) {
                                    i3 = i83 & 71755;
                                    i4 = i83 | 71755;
                                } else {
                                    i3 = i83 ^ (-71755);
                                    i4 = (i83 & (-71755)) << 1;
                                }
                                int i86 = i3 + i4;
                                int i87 = ~scrollBarFadeDuration;
                                int i88 = ~((i87 & 127) | (i87 ^ 127));
                                int i89 = ~scrollBarFadeDuration;
                                int i90 = ~((i89 ^ i) | (i89 & i));
                                int i91 = -(-((-566) * ((i88 ^ i90) | (i88 & i90))));
                                int i92 = (i86 ^ i91) + ((i91 & i86) << 1);
                                int i93 = i85 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
                                if (i93 % 2 != 0) {
                                    i5 = i92 >> ((~((-128) | scrollBarFadeDuration)) * 566);
                                } else {
                                    int i94 = -(-((~(((-128) ^ scrollBarFadeDuration) | ((-128) & scrollBarFadeDuration))) * 566));
                                    i5 = ((i94 & i92) << 1) + (i92 ^ i94);
                                }
                                int i95 = ~scrollBarFadeDuration;
                                int i96 = -(-(566 * (~((i95 & (-128)) | (i95 ^ (-128)) | i))));
                                int i97 = ((i5 | i96) << 1) - (i96 ^ i5);
                                Object[] objArr14 = new Object[1];
                                a(i97, new byte[]{-116, -124, -121, -116, -109, -101, -106, -123, -116, -109, -121, -116, -109, -101, -120, -123, -102, -117, -101, -118, -102, -109, -126}, null, null, objArr14);
                                Class<?> cls4 = Class.forName((String) objArr14[0]);
                                int i98 = -(ViewConfiguration.getTouchSlop() >> 8);
                                Object[] objArr15 = new Object[1];
                                a(((i98 | 127) << 1) - (i98 ^ 127), new byte[]{-121, -90, -126, -105, -121, -97, -126, -92, -120, -126, -110, -116, -121, -97}, null, null, objArr15);
                                Object objInvoke2 = cls4.getMethod((String) objArr15[0], null).invoke(context, null);
                                int i99 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i100 = ((i99 | 59) << 1) - (i99 ^ 59);
                                int i101 = i100 % 128;
                                artificialFrame = i101;
                                int i102 = i100 % 2;
                                int i103 = ((i101 | 67) << 1) - (i101 ^ 67);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i103 % 128;
                                try {
                                    if (i103 % 2 != 0) {
                                        objArr2 = new Object[5];
                                        objArr2[1] = 64;
                                        objArr2[1] = objInvoke2;
                                        Object[] objArr16 = new Object[1];
                                        b(TextUtils.lastIndexOf("", (char) 11, 1) * 60, new char[]{31488, 31392, 28962, 56284, 11372, 59122, 53348, 63558, 58908, 52095, 51513, 8570, 63381, 38343, 57158, 13115, 45145, 2655, 16100, 30307, 31354, 28339, 58444, 41467, 28666, 26326, 2016, 41326, 22713, 15462, 28666, 26326, 13623, 57098}, objArr16);
                                        str = (String) objArr16[0];
                                    } else {
                                        Object[] objArr17 = {objInvoke2, 64};
                                        Object[] objArr18 = new Object[1];
                                        b(33 - (~(-(-TextUtils.lastIndexOf("", '0', 0)))), new char[]{31488, 31392, 28962, 56284, 11372, 59122, 53348, 63558, 58908, 52095, 51513, 8570, 63381, 38343, 57158, 13115, 45145, 2655, 16100, 30307, 31354, 28339, 58444, 41467, 28666, 26326, 2016, 41326, 22713, 15462, 28666, 26326, 13623, 57098}, objArr18);
                                        str = (String) objArr18[0];
                                        objArr2 = objArr17;
                                    }
                                    int i104 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i105 = (i104 ^ 39) + ((i104 & 39) << 1);
                                    artificialFrame = i105 % 128;
                                    if (i105 % 2 == 0) {
                                        cls = Class.forName(str);
                                        Object[] objArr19 = new Object[1];
                                        b(43 % View.resolveSizeAndState(0, 0, 1), new char[]{28666, 26326, 7146, 21784, 31354, 28339, 58444, 41467, 28666, 26326, 25432, 60530, 1276, 7828}, objArr19);
                                        str2 = (String) objArr19[0];
                                        clsArr = new Class[3];
                                        clsArr[1] = String.class;
                                        cls2 = Integer.TYPE;
                                    } else {
                                        cls = Class.forName(str);
                                        Object[] objArr20 = new Object[1];
                                        b(View.resolveSizeAndState(0, 0, 0) + 14, new char[]{28666, 26326, 7146, 21784, 31354, 28339, 58444, 41467, 28666, 26326, 25432, 60530, 1276, 7828}, objArr20);
                                        str2 = (String) objArr20[0];
                                        Class<?>[] clsArr2 = new Class[2];
                                        clsArr2[0] = String.class;
                                        cls2 = Integer.TYPE;
                                        clsArr = clsArr2;
                                    }
                                    clsArr[1] = cls2;
                                    Object objInvoke3 = cls.getMethod(str2, clsArr).invoke(objInvoke, objArr2);
                                    int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                    int i106 = (longPressTimeout * 141) - 4170;
                                    int i107 = ~longPressTimeout;
                                    int i108 = ~((i107 ^ 30) | (i107 & 30));
                                    int i109 = ~((i107 ^ i) | (i107 & i));
                                    int i110 = ((i108 & i109) | (i108 ^ i109)) * (-280);
                                    int i111 = (i106 & i110) + (i106 | i110);
                                    int i112 = ~((i107 ^ i) | (i107 & i));
                                    int i113 = ~(((-31) & i) | ((-31) ^ i));
                                    int i114 = i111 + (((i112 & i113) | (i112 ^ i113)) * 140);
                                    int i115 = artificialFrame + 95;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i115 % 128;
                                    if (i115 % 2 != 0) {
                                        int i116 = i107 | (-31);
                                        int i117 = ~((i116 & i) | (i116 ^ i));
                                        int i118 = ~longPressTimeout;
                                        int i119 = (i118 & i29) | (i118 ^ i29);
                                        int i120 = ~((i119 & 30) | (i119 ^ 30));
                                        i6 = (i117 & i120) | (i117 ^ i120);
                                        int i121 = 47 / 0;
                                    } else {
                                        int i122 = i107 | (-31);
                                        int i123 = ~((i122 & i) | (i122 ^ i));
                                        int i124 = (i107 & i30) | (i107 ^ i30);
                                        int i125 = ~((i124 & 30) | (i124 ^ 30));
                                        i6 = (i123 & i125) | (i123 ^ i125);
                                    }
                                    int i126 = (-31) | i29;
                                    int i127 = ~((longPressTimeout & i126) | (i126 ^ longPressTimeout));
                                    int i128 = 140 * ((i127 & i6) | (i6 ^ i127));
                                    Object[] objArr21 = new Object[1];
                                    b(((i114 | i128) << 1) - (i128 ^ i114), new char[]{31488, 31392, 28962, 56284, 11372, 59122, 53348, 63558, 58908, 52095, 51513, 8570, 63381, 38343, 57158, 13115, 45145, 2655, 16100, 30307, 31354, 28339, 58444, 41467, 28666, 26326, 25432, 60530, 1276, 7828}, objArr21);
                                    Class<?> cls5 = Class.forName((String) objArr21[0]);
                                    int i129 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    Object[] objArr22 = new Object[1];
                                    a(((i129 | 127) << 1) - (i129 ^ 127), new byte[]{-122, -121, -118, -119, -116, -126, -109, -97, -117, -122}, null, null, objArr22);
                                    Object[] objArr23 = (Object[]) cls5.getField((String) objArr22[0]).get(objInvoke3);
                                    int length = objArr23.length;
                                    int i130 = 0;
                                    while (i130 < length) {
                                        int i131 = artificialFrame;
                                        int i132 = ((i131 | 87) << i15) - (i131 ^ 87);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i132 % 128;
                                        int i133 = i132 % 2;
                                        Object obj = objArr23[i130];
                                        Object[] objArr24 = new Object[i15];
                                        b(4 - (~(-View.MeasureSpec.getSize(0))), new char[]{22708, 9316, 6529, 64822, 7403, 15636}, objArr24);
                                        String str6 = (String) objArr24[0];
                                        int i134 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                                        artificialFrame = i134 % 128;
                                        int i135 = i134 % 2;
                                        try {
                                            Object[] objArr25 = {str6};
                                            int i136 = -ExpandableListView.getPackedPositionChild(0L);
                                            Object[] objArr26 = new Object[i15];
                                            b((i136 ^ 36) + ((i136 & 36) << i15), new char[]{11056, 40133, 65274, 50282, 64228, 27693, 22847, 28740, 63339, 13016, 9855, 47657, 41207, 34650, 21067, 32314, 598, 49689, 52202, 48358, 9909, 4065, 50813, 2557, 62012, 37977, 19192, 42419, 55843, 30926, 30838, 12187, 25075, 42040, 35110, 4646, 50182, 42390}, objArr26);
                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                            int i137 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i138 = ((i137 | 117) << i15) - (i137 ^ 117);
                                            artificialFrame = i138 % 128;
                                            if (i138 % 2 == 0) {
                                                Object[] objArr27 = new Object[i15];
                                                a(127 / View.MeasureSpec.makeMeasureSpec(0, 0), new byte[]{-121, -120, -109, -126, -116, -122, -109, -89, -116, -121, -97}, cArr, cArr, objArr27);
                                                str3 = (String) objArr27[0];
                                                i7 = 0;
                                            } else {
                                                Object[] objArr28 = new Object[i15];
                                                a(127 - View.MeasureSpec.makeMeasureSpec(0, 0), new byte[]{-121, -120, -109, -126, -116, -122, -109, -89, -116, -121, -97}, cArr, cArr, objArr28);
                                                i7 = 0;
                                                str3 = (String) objArr28[0];
                                            }
                                            Class<?>[] clsArr3 = new Class[i15];
                                            clsArr3[i7] = String.class;
                                            Object objInvoke4 = cls6.getMethod(str3, clsArr3).invoke(cArr, objArr25);
                                            try {
                                                int i139 = -View.combineMeasuredStates(i7, i7);
                                                int i140 = ~i139;
                                                int i141 = ((-128) ^ i) | ((-128) & i);
                                                int i142 = ((i139 * (-574)) - 72898) + (((~i141) | (~((i140 ^ i29) | (i140 & i29)))) * 1150);
                                                int i143 = ~i141;
                                                int i144 = ~((i30 ^ 127) | (i30 & 127));
                                                int i145 = (i142 - (~(-(-(((i143 & i144) | (i143 ^ i144)) * (-575)))))) - 1;
                                                int i146 = ~i139;
                                                int i147 = ~((i146 & i) | (i146 ^ i));
                                                int i148 = ~(i29 | i139);
                                                int i149 = -(-(((i147 & i148) | (i147 ^ i148)) * 575));
                                                Object[] objArr29 = new Object[1];
                                                a(((i145 | i149) << 1) - (i149 ^ i145), new byte[]{-121, -118, -119, -116, -126, -109, -97, -117, -93, -123, -90, -108, -123, -116, -109, -121, -116, -109, -101, -120, -123, -102, -117, -101, -118, -102, -109, -126}, null, null, objArr29);
                                                Class<?> cls7 = Class.forName((String) objArr29[0]);
                                                int i150 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
                                                artificialFrame = i150 % 128;
                                                int i151 = i150 % 2;
                                                int trimmedLength = TextUtils.getTrimmedLength("");
                                                int iITrustedWebActivityService2 = RsaSsaPkcs1PublicKey.Builder.ITrustedWebActivityService();
                                                int i152 = trimmedLength * 758;
                                                int i153 = (i152 & (-8316)) + (i152 | (-8316));
                                                int i154 = artificialFrame;
                                                int i155 = (i154 & 45) + (i154 | 45);
                                                Object[] objArr30 = objArr23;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                                                if (i155 % 2 != 0) {
                                                    int i156 = i153 / ((-757) % ((~iITrustedWebActivityService2) | trimmedLength));
                                                    int i157 = ((-12) & trimmedLength) | ((-12) ^ trimmedLength);
                                                    int i158 = ~((i157 & iITrustedWebActivityService2) | (i157 ^ iITrustedWebActivityService2));
                                                    i8 = i156 - ((i158 & 1514) + (i158 | 1514));
                                                } else {
                                                    int i159 = ~iITrustedWebActivityService2;
                                                    int i160 = ((trimmedLength ^ i159) | (i159 & trimmedLength)) * (-757);
                                                    int i161 = ((i153 | i160) << 1) - (i160 ^ i153);
                                                    int i162 = (~((-12) | trimmedLength | iITrustedWebActivityService2)) * 1514;
                                                    i8 = ((i161 | i162) << 1) - (i161 ^ i162);
                                                }
                                                int i163 = ~trimmedLength;
                                                int i164 = ~((i163 & (-12)) | (i163 ^ (-12)));
                                                int i165 = ~iITrustedWebActivityService2;
                                                int i166 = ~(((-12) ^ i165) | ((-12) & i165));
                                                int i167 = (i164 ^ i166) | (i164 & i166);
                                                int i168 = (trimmedLength & 11) | (trimmedLength ^ 11);
                                                int i169 = i168 ^ iITrustedWebActivityService2;
                                                Object[] objArr31 = new Object[1];
                                                b((i8 - (~(-(-(757 * (i167 | (~((i168 & iITrustedWebActivityService2) | i169)))))))) - 1, new char[]{57504, 33054, 48526, 62664, 55843, 30926, 54697, 12632, 54075, 35948, 50182, 42390}, objArr31);
                                                try {
                                                    Object[] objArr32 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr31[0], null).invoke(obj, null))};
                                                    int i170 = -TextUtils.lastIndexOf("", '0');
                                                    int i171 = i170 * 71;
                                                    int i172 = ((i171 | (-2484)) << 1) - (i171 ^ (-2484));
                                                    int i173 = ~i170;
                                                    int i174 = ~((i173 & 36) | (i173 ^ 36));
                                                    int i175 = ~((i ^ 36) | (i & 36));
                                                    int i176 = -(-(((i174 & i175) | (i174 ^ i175)) * (-140)));
                                                    int i177 = (i172 & i176) + (i176 | i172);
                                                    int i178 = i170 | 36;
                                                    int i179 = i177 + ((~((i178 & i) | (i178 ^ i))) * 70);
                                                    int i180 = artificialFrame;
                                                    int i181 = (i180 & 95) + (i180 | 95);
                                                    int i182 = i181 % 128;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i182;
                                                    int i183 = i181 % 2;
                                                    int i184 = ~((~i170) | 36);
                                                    int i185 = ~(((-37) & i170) | ((-37) ^ i170));
                                                    int i186 = (i184 & i185) | (i184 ^ i185);
                                                    int i187 = ((i182 | 115) << 1) - (i182 ^ 115);
                                                    artificialFrame = i187 % 128;
                                                    int i188 = i187 % 2;
                                                    int i189 = ~((i170 & i) | (i170 ^ i));
                                                    int i190 = i179 + (70 * ((i189 & i186) | (i186 ^ i189)));
                                                    Object[] objArr33 = new Object[1];
                                                    b(i190, new char[]{11056, 40133, 65274, 50282, 64228, 27693, 22847, 28740, 63339, 13016, 9855, 47657, 41207, 34650, 21067, 32314, 598, 49689, 52202, 48358, 9909, 4065, 50813, 2557, 62012, 37977, 19192, 42419, 55843, 30926, 30838, 12187, 25075, 42040, 35110, 4646, 50182, 42390}, objArr33);
                                                    Class<?> cls8 = Class.forName((String) objArr33[0]);
                                                    Object[] objArr34 = new Object[1];
                                                    b(17 - (~(-((byte) KeyEvent.getModifierMetaStateMask()))), new char[]{28666, 26326, 47265, 32432, 54075, 35948, 55843, 30926, 18046, 53383, 598, 49689, 46674, 41424, 11262, 40411, 7352, 31363, 18420, 63875}, objArr34);
                                                    Object objInvoke5 = cls8.getMethod((String) objArr34[0], InputStream.class).invoke(objInvoke4, objArr32);
                                                    int length2 = objArr5.length;
                                                    int i191 = 0;
                                                    while (i191 < 2) {
                                                        Object obj2 = objArr5[i191];
                                                        int i192 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i193 = ((i192 | 79) << 1) - (i192 ^ 79);
                                                        artificialFrame = i193 % 128;
                                                        int i194 = i193 % 2;
                                                        try {
                                                            int i195 = -AndroidCharacter.getMirror('0');
                                                            int iITrustedWebActivityService3 = RsaSsaPkcs1PublicKey.Builder.ITrustedWebActivityService();
                                                            int i196 = i195 * (-523);
                                                            int i197 = (i196 & 21566) + (i196 | 21566);
                                                            int i198 = ~i195;
                                                            int i199 = (i198 & 82) | (i198 ^ 82);
                                                            int i200 = ~i199;
                                                            int i201 = ((-83) ^ i195) | ((-83) & i195);
                                                            int i202 = length;
                                                            int i203 = ~i201;
                                                            int i204 = (i200 ^ i203) | (i203 & i200);
                                                            Object[] objArr35 = objArr5;
                                                            int i205 = ~((-83) | iITrustedWebActivityService3);
                                                            int i206 = i197 + (((i204 ^ i205) | (i204 & i205)) * 262);
                                                            int i207 = -(-((~((-83) | i195)) * (-786)));
                                                            int i208 = (i206 & i207) + (i207 | i206);
                                                            int i209 = ~iITrustedWebActivityService3;
                                                            int i210 = ~((i209 & (-83)) | ((-83) ^ i209));
                                                            int i211 = ~i199;
                                                            int i212 = (i210 & i211) | (i210 ^ i211);
                                                            int i213 = ~i201;
                                                            Object[] objArr36 = new Object[1];
                                                            b((i208 - (~(-(-(((i212 & i213) | (i212 ^ i213)) * 262))))) - 1, new char[]{11056, 40133, 65274, 50282, 64228, 27693, 22847, 28740, 63339, 13016, 9855, 47657, 41207, 34650, 21067, 32314, 598, 49689, 18981, 29612, 6529, 64822, 15947, 57718, 9909, 4065, 50813, 2557, 62012, 37977, 19192, 42419, 55843, 30926}, objArr36);
                                                            Class<?> cls9 = Class.forName((String) objArr36[0]);
                                                            int mode = View.MeasureSpec.getMode(0);
                                                            Object[] objArr37 = new Object[1];
                                                            b(((mode | 23) << 1) - (mode ^ 23), new char[]{28666, 26326, 1811, 63589, 19542, 11883, 4666, 2444, 25075, 42040, 21774, 22481, 16646, 52796, 46041, 48683, 60118, 58675, 46243, 61650, 41765, 42772, 34373, 61880}, objArr37);
                                                            if (obj2.equals(cls9.getMethod((String) objArr37[0], null).invoke(objInvoke5, null))) {
                                                                int[] iArr3 = new int[1];
                                                                Object[] objArr38 = {new int[]{i}, new int[]{(i & (-2)) | (i30 & 1)}, iArr3, null};
                                                                int i214 = (-469497489) + (((~((-537846154) | i30)) | 440777621) * (-235)) + (((~((-537846154) | i)) | 440777621) * (-470)) + (((~((-537542665) | i)) | 440474132) * 235);
                                                                int i215 = -(-(i214 * JfifUtil.MARKER_SOFn));
                                                                int i216 = ((-6096) & i215) + (i215 | (-6096));
                                                                int i217 = ~((i214 ^ i) | (i214 & i));
                                                                int i218 = (((i216 | 3247) << 1) - (i216 ^ 3247)) + (((i217 & 16) | (i217 ^ 16)) * 191);
                                                                int i219 = ~((-17) | i214);
                                                                int i220 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.f40o;
                                                                artificialFrame = i220 % 128;
                                                                if (i220 % 2 == 0) {
                                                                    int i221 = ~((i30 ^ i214) | (i214 & i30));
                                                                    i9 = i218 * ((i219 & i221) | (i219 ^ i221)) * 191;
                                                                    int i222 = -(-i9);
                                                                    i10 = (((i222 & (-919)) + (i222 | (-919))) - (~(-((-919) % i2)))) - 1;
                                                                } else {
                                                                    int i223 = ~((i29 ^ i214) | (i214 & i29));
                                                                    int i224 = -(-(((i219 & i223) | (i219 ^ i223)) * 191));
                                                                    i9 = ((i218 | i224) << 1) - (i218 ^ i224);
                                                                    int i225 = i9 * (-919);
                                                                    int i226 = -(-(i2 * (-919)));
                                                                    i10 = (i225 ^ i226) + ((i225 & i226) << 1);
                                                                }
                                                                int i227 = ~i9;
                                                                int i228 = i2 ^ (-1);
                                                                int i229 = (i227 & i228) | (i227 ^ i228);
                                                                int i230 = ~((i229 & i) | (i229 ^ i));
                                                                int i231 = ~i2;
                                                                int i232 = (i231 ^ i29) | (i231 & i29);
                                                                int i233 = ~((i232 & i9) | (i232 ^ i9));
                                                                int i234 = -(-(920 * ((i230 & i233) | (i230 ^ i233))));
                                                                int i235 = ((i10 | i234) << 1) - (i234 ^ i10);
                                                                int i236 = ~i9;
                                                                int i237 = ~((~i2) | i236);
                                                                int i238 = ~((i30 & i236) | (i236 ^ i30));
                                                                int i239 = i235 + (((i237 & i238) | (i237 ^ i238)) * 920);
                                                                int i240 = i236 | i231;
                                                                int i241 = ~((i240 & i29) | (i240 ^ i29));
                                                                int i242 = (i236 & i2) | (i236 ^ i2);
                                                                int i243 = ~((i242 & i) | (i242 ^ i));
                                                                int i244 = (i239 - (~(((~(((i9 & i231) | (i231 ^ i9)) | i)) | ((i243 & i241) | (i241 ^ i243))) * 920))) - 1;
                                                                int i245 = i244 << 13;
                                                                int i246 = (i245 & (~i244)) | ((~i245) & i244);
                                                                int i247 = i246 ^ (i246 >>> 17);
                                                                int i248 = i247 << 5;
                                                                iArr3[0] = ((~i247) & i248) | ((~i248) & i247);
                                                                objArr = objArr38;
                                                            } else {
                                                                i191 = (i191 & 1) + (i191 | 1);
                                                                length = i202;
                                                                objArr5 = objArr35;
                                                            }
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    int i249 = i130 + 5;
                                                    i130 = (i249 & (-4)) + (i249 | (-4));
                                                    objArr23 = objArr30;
                                                    length = length;
                                                    cArr = null;
                                                    i15 = 1;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
            int[] iArr4 = new int[1];
            objArr = new Object[]{new int[]{i}, new int[]{i}, iArr4, null};
            int i250 = ~i;
            int i251 = 1578642166 + (((~((-654648536) | i250)) | 50667591 | (~((-323975240) | i250)) | (~(927956183 | i))) * (-84));
            int i252 = (~((-323975240) | i)) | 654648535;
            int i253 = ~(323975239 | i250);
            int i254 = i251 + ((i252 | i253) * (-84)) + (((-927956184) | i253) * 84);
            int i255 = -(-(i254 * 434));
            int i256 = -(-((~(((-1) ^ i254) | i254)) * 433));
            int i257 = ((i255 | i256) << 1) - (i255 ^ i256);
            int i258 = ~((~i254) | i);
            int i259 = -(-((i258 | ((-1) ^ i258)) * (-433)));
            int i260 = (i257 ^ i259) + ((i259 & i257) << 1);
            int i261 = ~(((-1) ^ i) | i);
            int i262 = ~i254;
            int i263 = ((i261 & i262) | (i261 ^ i262)) * 433;
            int i264 = (i260 & i263) + (i263 | i260);
            int i265 = i264 * (-518);
            int i266 = i2 * (-518);
            int i267 = ((i265 | i266) << 1) - (i265 ^ i266);
            int i268 = ~((~i264) | i250);
            int i269 = i267 + (((i268 & i2) | (i2 ^ i268)) * 519);
            int i270 = ~i264;
            int i271 = ~((i250 & i270) | (i270 ^ i250) | i2);
            int i272 = (i264 ^ i2) | (i264 & i2);
            int i273 = ~((i272 & i) | (i272 ^ i));
            int i274 = (i269 - (~(((i271 & i273) | (i271 ^ i273)) * (-519)))) - 1;
            int i275 = ~((i & i2) | (i2 ^ i));
            int i276 = -(-(((i275 & i264) | (i264 ^ i275)) * 519));
            int i277 = (i274 ^ i276) + ((i276 & i274) << 1);
            int i278 = i277 << 13;
            int i279 = (i278 & (~i277)) | ((~i278) & i277);
            int i280 = i279 >>> 17;
            int i281 = (i279 | i280) & (~(i279 & i280));
            int i282 = i281 << 5;
            iArr4[0] = ((~i281) & i282) | ((~i282) & i281);
        }
        int i283 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
        artificialFrame = i283 % 128;
        int i284 = i283 % 2;
        return objArr;
    }
}
