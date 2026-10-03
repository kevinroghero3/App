package com.google.android.gms.internal.stats;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.protobuf.BytesValue;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class zzi extends RuntimeException {
    private static final byte[] $$c = {SignedBytes.MAX_POWER_OF_TWO, -46, -98, Ascii.DC2};
    private static final int $$d = 19;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {91, 68, -61, -13, Ascii.VT, 2, -12};
    private static final int $$b = 104;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] ArtificialStackFrames = {44390, 44388, 44402, 44355, 44702, 44400, 44383, 44700, 44334, 44698, 44696, 44393, 44701, 44690, 44399, 44699, 44386, 44405, 44691, 44335, 44703, 44396, 44697, 44391, 44358, 44398, 44387, 44337, 44403, 44356, 44385, 44409, 44404, 44407, 44395, 44389};
    private static char coroutineCreation = 39068;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, short r8, short r9) {
        /*
            int r7 = 105 - r7
            byte[] r0 = com.google.android.gms.internal.stats.zzi.$$c
            int r8 = r8 * 3
            int r8 = r8 + 1
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r7 = r8
            r3 = r9
            r5 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r9 = r9 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L28:
            int r9 = -r9
            int r7 = r7 + r9
            r9 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.stats.zzi.$$e(int, short, short):java.lang.String");
    }

    public zzi() {
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
    private static void b(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.android.gms.internal.stats.zzi.$$a
            int r8 = r8 + 4
            int r9 = r9 * 4
            int r9 = r9 + 4
            int r7 = r7 * 3
            int r7 = r7 + 109
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r7 = r9
            r4 = r2
            goto L2c
        L15:
            r3 = r2
        L16:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r3
            r3 = r8
            r8 = r6
        L2c:
            int r7 = r7 + r8
            int r7 = r7 + (-3)
            r8 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.stats.zzi.b(int, byte, byte, java.lang.Object[]):void");
    }

    public zzi(@CheckForNull String str) {
        super(str);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        int i3 = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i5 = -1819279892;
        float f = 0.0f;
        Object obj2 = null;
        int i6 = 8;
        if (cArr2 != null) {
            int i7 = $10 + 45;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                int i10 = $11 + 63;
                $10 = i10 % 128;
                int i11 = i10 % i3;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i9])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 15;
                        char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 20488);
                        int i12 = 2149 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1));
                        byte b2 = (byte) i6;
                        byte b3 = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, jumpTapTimeout, i12, 216710116, false, $$e(b2, b3, (byte) (b3 - 1)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = 2;
                    i5 = -1819279892;
                    f = 0.0f;
                    i6 = 8;
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
            byte b4 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.lastIndexOf("", '0', 0), (char) (20488 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), 2149 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 216710116, false, $$e((byte) 8, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i13 = $10 + 77;
            $11 = i13 % 128;
            if (i13 % 2 == 0) {
                i2 = i + 52;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i14 = $10 + 23;
            $11 = i14 % 128;
            int i15 = i14 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                    obj = obj2;
                } else {
                    try {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            int iMyPid = (Process.myPid() >> 22) + 46;
                            char cGreen = (char) (Color.green(0) + 58859);
                            int i16 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2464;
                            byte b5 = (byte) ($$d & 15);
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iMyPid, cGreen, i16, 276640984, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = b7;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 792, -834291897, false, $$e(b7, b8, (byte) (b8 - 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i17 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i17];
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i18 = (extracallback.b * cCharValue) + extracallback.j;
                                int i19 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i18];
                                cArr4[extracallback.a + 1] = cArr2[i19];
                            } else {
                                int i20 = (extracallback.b * cCharValue) + extracallback.g;
                                int i21 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i20];
                                cArr4[extracallback.a + 1] = cArr2[i21];
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
                extracallback.a += 2;
                obj2 = obj;
            }
        }
        for (int i22 = 0; i22 < i; i22++) {
            cArr4[i22] = (char) (cArr4[i22] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        char c;
        int i3;
        int i4;
        Object[] objArr2;
        String line;
        int i5;
        boolean zEquals;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iINotificationSideChannelStubProxy;
        int i11;
        int i12 = 2 % 2;
        int i13 = artificialFrame + 55;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
        int i14 = i13 % 2;
        int i15 = 0;
        try {
            int i16 = -((byte) KeyEvent.getModifierMetaStateMask());
            int i17 = i16 * 659;
            int i18 = (i17 ^ (-57816)) + ((i17 & (-57816)) << 1);
            int i19 = ~((~i16) | 88);
            int i20 = ~(((-89) ^ i16) | ((-89) & i16));
            int i21 = ~((i16 ^ i) | (i16 & i));
            int i22 = ((i18 + (((i19 | i20) | i21) * (-658))) - (~(i20 * 658))) - 1;
            int i23 = ~(((-89) & i16) | ((-89) ^ i16));
            byte b = (byte) (i22 + (((i21 & i23) | (i23 ^ i21)) * 658));
            Object[] objArr3 = new Object[1];
            a(18 - TextUtils.lastIndexOf("", '0', 0), new char[]{'\n', 29, '#', 5, 17, '\f', 13910, 13910, ' ', 5, 2, 15, 13901, 13901, ' ', 29, '!', 30, 13911}, b, objArr3);
            int i24 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            int iINotificationSideChannelStubProxy2 = BytesValue.Builder.INotificationSideChannelStubProxy();
            int i25 = ~iINotificationSideChannelStubProxy2;
            int i26 = ~((i25 & (-20)) | ((-20) ^ i25));
            int i27 = ~(((-20) ^ i24) | ((-20) & i24));
            int i28 = (i26 ^ i27) | (i26 & i27);
            int i29 = ~iINotificationSideChannelStubProxy2;
            int i30 = (i29 ^ i24) | (i29 & i24);
            int i31 = ~i30;
            int i32 = (i28 ^ i31) | (i31 & i28);
            int i33 = (~i24) | 19;
            int i34 = ~((i33 ^ iINotificationSideChannelStubProxy2) | (iINotificationSideChannelStubProxy2 & i33));
            int i35 = (((i24 * (-589)) + 11229) - (~(-(-(((i32 & i34) | (i32 ^ i34)) * 590))))) - 1;
            int i36 = ~(((-20) ^ i29) | ((-20) & i29));
            int i37 = ~((-20) | i24);
            int i38 = (i36 & i37) | (i36 ^ i37);
            int i39 = ~i30;
            int i40 = ((i38 & i39) | (i38 ^ i39)) * (-1180);
            int i41 = (i35 & i40) + (i40 | i35);
            int i42 = ~i24;
            int i43 = ~((i42 & i29) | (i42 ^ i29));
            int i44 = ~((i29 ^ 19) | (i29 & 19));
            int i45 = i43 ^ i44;
            int i46 = -(ViewConfiguration.getLongPressTimeout() >> 16);
            int i47 = i46 * 85;
            int i48 = (i47 ^ 1275) + ((i47 & 1275) << 1);
            int i49 = ~i46;
            int i50 = ~((i49 & (-16)) | (i49 ^ (-16)));
            int i51 = ~i46;
            int i52 = ~i;
            int i53 = ~((i51 & i52) | (i51 ^ i52));
            int i54 = (i50 & i53) | (i50 ^ i53);
            int i55 = ~((-16) | i52);
            int i56 = (i54 & i55) | (i54 ^ i55);
            int i57 = (i46 ^ 15) | (i46 & 15);
            int i58 = ~((i57 ^ i) | (i57 & i));
            int i59 = (i48 - (~(-(-(((i56 ^ i58) | (i56 & i58)) * (-84)))))) - 1;
            int i60 = i46 | (~(((-16) ^ i) | ((-16) & i)));
            int i61 = ~((i52 ^ 15) | (i52 & 15));
            byte b2 = (byte) (i59 + (((i60 & i61) | (i60 ^ i61)) * (-84)) + (((~(i52 | 15)) | (~i57)) * 84));
            Object[] objArr4 = new Object[1];
            a((i41 - (~(-(-(((i43 & i44) | i45) * 590))))) - 1, new char[]{'\"', 31, '\b', '#', 7, 29, 18, 29, 20, '\b', '#', 5, 17, '\f', 13836, 13836, ' ', 5}, b2, objArr4);
            String[] strArr = {(String) objArr3[0], (String) objArr4[0]};
            int i62 = 0;
            int i63 = 2;
            while (true) {
                if (i62 >= i63) {
                    objArr = new Object[4];
                    int[] iArr = new int[1];
                    objArr[0] = iArr;
                    int[] iArr2 = new int[1];
                    objArr[1] = iArr2;
                    int i64 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i65 = i64 + 13;
                    artificialFrame = i65 % 128;
                    if (i65 % 2 == 0) {
                        objArr[2] = new int[1];
                    } else {
                        objArr[2] = new int[1];
                    }
                    iArr[0] = i;
                    iArr2[0] = i;
                    int i66 = i64 + b.i;
                    artificialFrame = i66 % 128;
                    if (i66 % 2 == 0) {
                        objArr[3] = null;
                        i10 = 1313543516 + ((967540731 | i52) * (-369)) + (((~((-413736364) | i52)) | 564887411) * (-369)) + (((~(413736363 | i)) | 553804368 | (~((-402653321) | i52))) * 369);
                        iINotificationSideChannelStubProxy = BytesValue.Builder.INotificationSideChannelStubProxy();
                    } else {
                        objArr[3] = null;
                        i10 = (-435822792) + (((~(i52 | 717371050)) | 261252724) * (-1042)) + ((717371050 | i) * 521) + (((~((-261252725) | i)) | 176301600 | (~(802322174 | i52))) * 521);
                        iINotificationSideChannelStubProxy = BytesValue.Builder.INotificationSideChannelStubProxy();
                    }
                    int i67 = -(-(i10 * (-747)));
                    int i68 = ~(((-1) ^ i10) | i10);
                    int i69 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    artificialFrame = i69 % 128;
                    int i70 = i69 % 2;
                    int i71 = ~(~iINotificationSideChannelStubProxy);
                    int i72 = (-374) * ((i68 & i71) | (i68 ^ i71));
                    int i73 = ((((i67 | i72) << 1) - (i67 ^ i72)) - (~(-(-((~(~i10)) * 748))))) - 1;
                    int i74 = -(-((~(~iINotificationSideChannelStubProxy)) * 374));
                    int i75 = -(-((i73 & i74) + (i74 | i73)));
                    int i76 = (i2 & i75) + (i75 | i2);
                    int i77 = i76 << 13;
                    int i78 = (i77 & (~i76)) | ((~i77) & i76);
                    int i79 = i78 ^ (i78 >>> 17);
                    int i80 = i79 << 5;
                    ((int[]) objArr[2])[0] = ((~i79) & i80) | ((~i80) & i79);
                    break;
                }
                int i81 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i82 = (i81 & 105) + (i81 | 105);
                artificialFrame = i82 % 128;
                int i83 = i82 % i63;
                String str = strArr[i62];
                int i84 = -KeyEvent.normalizeMetaState(i15);
                int iINotificationSideChannelStubProxy3 = BytesValue.Builder.INotificationSideChannelStubProxy();
                int i85 = i84 * (-665);
                int i86 = ((i85 | 5344) << 1) - (i85 ^ 5344);
                int i87 = artificialFrame;
                int i88 = ((i87 | 57) << 1) - (i87 ^ 57);
                int i89 = i88 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i89;
                int i90 = i88 % 2;
                int i91 = -(-((-333) * (~i84)));
                int i92 = (i86 ^ i91) + ((i86 & i91) << 1);
                int i93 = ~i84;
                int i94 = ~iINotificationSideChannelStubProxy3;
                int i95 = (i93 ^ i94) | (i93 & i94);
                int i96 = ((i89 | 5) << 1) - (i89 ^ 5);
                artificialFrame = i96 % 128;
                if (i96 % 2 == 0) {
                    int i97 = ~i95;
                    int i98 = ~((iINotificationSideChannelStubProxy3 ^ 16) | (iINotificationSideChannelStubProxy3 & 16));
                    i11 = (i92 - (~(-(333 >>> ((i97 ^ i98) | (i97 & i98)))))) - 1;
                } else {
                    int i99 = ~i95;
                    int i100 = ~(iINotificationSideChannelStubProxy3 | 16);
                    int i101 = -(-(((i99 ^ i100) | (i99 & i100)) * 333));
                    i11 = ((i92 | i101) << 1) - (i101 ^ i92);
                }
                int i102 = i84 ^ (-1);
                int i103 = 333 * ((~((i102 & iINotificationSideChannelStubProxy3) | (i102 ^ iINotificationSideChannelStubProxy3))) | (~((i94 ^ 16) | (i94 & 16))));
                int i104 = (i89 ^ 99) + ((i89 & 99) << 1);
                artificialFrame = i104 % 128;
                int i105 = i104 % 2;
                int i106 = i11 + i103;
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                Object[] objArr5 = new Object[1];
                a(i106, new char[]{31, 24, 2, 3, 17, '\b', 2, 7, 16, 26, 11, 26, '\"', 17, 23, 29}, (byte) ((packedPositionChild ^ 11) + ((packedPositionChild & 11) << 1)), objArr5);
                Class<?> cls = Class.forName((String) objArr5[0]);
                if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                    objArr = new Object[]{new int[]{i}, new int[]{(i & (-2)) | (i52 & 1)}, new int[]{i ^ (i << 5)}, null};
                    int i107 = (-104172642) + ((805461122 | i52) * (-192)) + (((~((-86843517) | i52)) | 86319136) * (-384)) + (((~((-86319137) | i)) | (~((-524381) | i52)) | (~(892304638 | i))) * JfifUtil.MARKER_SOFn);
                    int i108 = i107 * (-987);
                    int i109 = ((15824 | i108) << 1) - (i108 ^ 15824);
                    int i110 = ~i107;
                    int i111 = ~i;
                    int i112 = (i107 ^ 16) | (i107 & 16);
                    int i113 = i109 + (((~((i110 & i111) | (i110 ^ i111) | 16)) | (~((i112 & i) | (i112 ^ i)))) * 988);
                    int i114 = ~i107;
                    int i115 = i113 + (((i114 ^ 16) | (i114 & 16)) * (-988));
                    int i116 = ~((-17) | i114);
                    int i117 = ~((i114 & i) | (i114 ^ i));
                    int i118 = -(-(((i117 & i116) | (i116 ^ i117) | (~(i107 | (i111 & 16) | (i111 ^ 16)))) * 988));
                    int i119 = (i115 ^ i118) + ((i118 & i115) << 1);
                    int i120 = ((i119 * (-1965)) - (~(-(-(i2 * 984))))) - 1;
                    int i121 = ~i2;
                    int i122 = i120 + (((i121 & i119) | (i119 ^ i121)) * 983);
                    int i123 = ~i119;
                    int i124 = ~i2;
                    int i125 = i122 + (((~((i124 & i52) | (i124 ^ i52))) | i123) * (-983));
                    int i126 = ~i119;
                    int i127 = ~((i126 & i52) | (i126 ^ i52));
                    int i128 = ~((i123 & i2) | (i123 ^ i2));
                    int i129 = ((i127 & i128) | (i127 ^ i128)) * 983;
                    int i130 = (i125 & i129) + (i125 | i129);
                    int i131 = i130 << 13;
                    int i132 = (i131 | i130) & (~(i130 & i131));
                    int i133 = i132 >>> 17;
                    int i134 = (i132 | i133) & (~(i132 & i133));
                    int i135 = artificialFrame;
                    int i136 = ((i135 | 97) << 1) - (i135 ^ 97);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i136 % 128;
                    int i137 = i136 % 2;
                    break;
                }
                i62++;
                i63 = 2;
                i15 = 0;
            }
            c = 0;
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[1], null};
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i138 = ((~((~startUptimeMillis) | (-553913351))) * 130) + 761058274 + (((~(startUptimeMillis | (-553913351))) | 273715480) * 130);
            int iINotificationSideChannelStubProxy4 = BytesValue.Builder.INotificationSideChannelStubProxy();
            int i139 = i138 * (-756);
            int i140 = (12128 & i139) + (i139 | 12128);
            int i141 = ~iINotificationSideChannelStubProxy4;
            int i142 = (i140 - (~(((i141 ^ 16) | (i141 & 16)) * (-757)))) - 1;
            int i143 = ~i138;
            int i144 = i142 + ((~((i143 ^ 16) | (i143 & 16) | iINotificationSideChannelStubProxy4)) * 1514);
            int i145 = ~i138;
            int i146 = (~((i141 & i143) | (i143 ^ i141))) | (~((i145 & (-17)) | ((-17) ^ i145)));
            int i147 = (i138 & 16) | (i138 ^ 16);
            int i148 = ~((iINotificationSideChannelStubProxy4 & i147) | (i147 ^ iINotificationSideChannelStubProxy4));
            int i149 = ((i148 & i146) | (i146 ^ i148)) * 757;
            int i150 = -(-((i144 & i149) + (i149 | i144)));
            int i151 = ((i2 | i150) << 1) - (i150 ^ i2);
            int i152 = i151 << 13;
            int i153 = (i152 | i151) & (~(i151 & i152));
            int i154 = i153 ^ (i153 >>> 17);
            int i155 = i154 << 5;
            int i156 = (i154 | i155) & (~(i154 & i155));
            c = 0;
            ((int[]) objArr[2])[0] = i156;
        }
        if (i != ((int[]) objArr[1])[c]) {
            int i157 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i158 = (i157 & 59) + (i157 | 59);
            artificialFrame = i158 % 128;
            int i159 = i158 % 2;
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 9;
                char deadChar = (char) (64610 - KeyEvent.getDeadChar(0, 0));
                int mode = 1806 - View.MeasureSpec.getMode(0);
                byte b3 = (byte) 0;
                byte b4 = (byte) (b3 - 1);
                Object[] objArr6 = new Object[1];
                b(b3, b4, (byte) (b4 + 1), objArr6);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, deadChar, mode, -1135716921, false, (String) objArr6[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j = -239408885;
            long jMyUid = Process.myUid();
            long j2 = -1;
            long j3 = j ^ j2;
            long j4 = 381;
            long j5 = (((long) (-380)) * j) + (((long) 382) * jLongValue) + ((jLongValue | jMyUid | j3) * ((long) (-381))) + ((((j | jLongValue) ^ j2) | ((j3 | (jLongValue ^ j2)) ^ j2) | (((jMyUid ^ j2) | jLongValue) ^ j2)) * j4) + (j4 * ((j3 | jLongValue) ^ j2)) + ((long) 579616919);
            int i160 = ~((int) Runtime.getRuntime().freeMemory());
            int i161 = ((int) (j5 >> 32)) & (915515466 + (((~(i160 | 203515159)) | (-1302984088)) * (-160)) + (((~(i160 | (-1233711252))) | 203515159) * SyslogConstants.LOG_LOCAL4));
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i162 = ((int) j5) & (1655982725 + (((~((-8962689) | (~iElapsedRealtime))) | (~((-1446189099) | iElapsedRealtime))) * (-272)) + (((~(1999838315 | iElapsedRealtime)) | (-2008801004)) * (-272)) + (((~(iElapsedRealtime | (-1999838316))) | 562611905) * 272));
            if (((i161 & i162) | (i161 ^ i162)) == 1) {
                Object[] objArr7 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[]{((~i) & i) | ((~i) & i)}, null};
                int i163 = ~(604350212 | i);
                int i164 = ((843796766 | i163) * (-658)) + 2095659366 + ((i163 | 306860058) * 658);
                int i165 = 4047 - (~(-(-(i164 * 253))));
                int i166 = ~i164;
                int i167 = ~((-17) | i166);
                int i168 = ~i164;
                int i169 = ~i;
                int i170 = ~((i168 & i169) | (i168 ^ i169));
                int i171 = (i167 & i170) | (i167 ^ i170);
                int i172 = ~(i164 | 16 | i);
                int i173 = -(-(((i171 & i172) | (i171 ^ i172)) * (-252)));
                int i174 = (i165 & i173) + (i165 | i173);
                int i175 = (i164 ^ 16) | (i164 & 16);
                int i176 = i175 * (-252);
                int i177 = -(-(((((i174 | i176) << 1) - (i176 ^ i174)) - (~(((~((i175 & i) | (i175 ^ i))) | (~(((i166 ^ i169) | (i166 & i169)) | 16))) * 252))) - 1));
                i3 = i2;
                int i178 = ((i3 | i177) << 1) - (i177 ^ i3);
                int i179 = i178 << 13;
                int i180 = (i179 & (~i178)) | ((~i179) & i178);
                int i181 = i180 >>> 17;
                int i182 = ((~i180) & i181) | ((~i181) & i180);
                int i183 = i182 << 5;
                objArr2 = objArr7;
                i4 = 0;
            } else {
                i3 = i2;
                Object[] objArr8 = {new int[]{i}, new int[]{i}, new int[1], null};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i184 = ~iMaxMemory;
                int i185 = 1825303134 + ((~((-385782704) | i184)) * 979) + ((iMaxMemory | 592841071) * (-979)) + (((~(iMaxMemory | (-385782704))) | (~(i184 | 592841071))) * 979);
                int iINotificationSideChannelStubProxy5 = BytesValue.Builder.INotificationSideChannelStubProxy();
                int i186 = (i185 * (-919)) + (i3 * (-919));
                int i187 = ~i185;
                int i188 = ~i3;
                int i189 = ~((i187 ^ i188) | (i187 & i188) | iINotificationSideChannelStubProxy5);
                int i190 = ~i3;
                int i191 = ~iINotificationSideChannelStubProxy5;
                int i192 = (i190 ^ i191) | (i190 & i191);
                int i193 = -(-((i189 | (~((i192 & i185) | (i192 ^ i185)))) * 920));
                int i194 = (i186 & i193) + (i186 | i193);
                int i195 = ~(i187 | i188);
                int i196 = ~i185;
                int i197 = ~((i196 ^ i191) | (i191 & i196));
                int i198 = i194 + (((i195 & i197) | (i195 ^ i197)) * 920);
                int i199 = (i196 ^ i190) | (i196 & i190);
                int i200 = ~iINotificationSideChannelStubProxy5;
                int i201 = ~((i199 & i200) | (i199 ^ i200));
                int i202 = ~((i196 & i3) | (i196 ^ i3) | iINotificationSideChannelStubProxy5);
                int i203 = (i201 & i202) | (i201 ^ i202);
                int i204 = (i188 ^ i185) | (i188 & i185);
                int i205 = ((~((iINotificationSideChannelStubProxy5 & i204) | (i204 ^ iINotificationSideChannelStubProxy5))) | i203) * 920;
                int i206 = (i198 ^ i205) + ((i205 & i198) << 1);
                int i207 = i206 << 13;
                int i208 = (i207 & (~i206)) | ((~i207) & i206);
                int i209 = i208 ^ (i208 >>> 17);
                i4 = 0;
                ((int[]) objArr8[2])[0] = i209 ^ (i209 << 5);
                objArr2 = objArr8;
            }
            if (i != ((int[]) objArr2[1])[i4]) {
                return objArr2;
            }
            try {
                int i210 = (ExpandableListView.getPackedPositionForGroup(i4) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i4) == 0L ? 0 : -1));
                int i211 = (i210 * (-432)) + 17360;
                int i212 = ~i210;
                int i213 = (~i) | i212;
                int i214 = (~((i213 & 40) | (i213 ^ 40))) * 433;
                int i215 = (i211 ^ i214) + ((i211 & i214) << 1) + (((~(((-41) & i) | ((-41) ^ i))) | i212) * (-433));
                int i216 = ~i210;
                int i217 = ~((i216 & i) | (i216 ^ i));
                int i218 = ~((i210 & 40) | (i210 ^ 40));
                int i219 = -(-(((i218 & i217) | (i217 ^ i218)) * 433));
                int capsMode = TextUtils.getCapsMode("", 0, 0);
                Object[] objArr9 = new Object[1];
                a(((i215 | i219) << 1) - (i219 ^ i215), new char[]{22, 25, '\"', 25, 22, 31, ' ', 5, 29, 31, 22, 20, 5, 31, 17, '\f', 18, 20, 2, '\b', ' ', 24, 7, 29, 18, 20, 29, 14, 13920, 13920, 31, 29, 30, '\b', 2, '\b', ' ', 24, ' ', 5}, (byte) ((capsMode & SyslogConstants.LOG_CLOCK) + (capsMode | SyslogConstants.LOG_CLOCK)), objArr9);
                File file = new File((String) objArr9[0]);
                if (file.canRead()) {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    int i220 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
                    artificialFrame = i220 % 128;
                    int i221 = i220 % 2;
                    try {
                        line = bufferedReader.readLine();
                        int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                        int i222 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                        int i223 = i222 % 128;
                        artificialFrame = i223;
                        int i224 = i222 % 2 == 0 ? (-317) >>> pressedStateDuration : pressedStateDuration * (-317);
                        int i225 = ((i224 | 957) << 1) - (i224 ^ 957);
                        int i226 = ~pressedStateDuration;
                        int i227 = (i226 & (-4)) | (i226 ^ (-4));
                        int i228 = (i223 ^ 95) + ((i223 & 95) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i228 % 128;
                        int i229 = i228 % 2;
                        int i230 = ~((i227 & i) | (i227 ^ i));
                        int i231 = ~i;
                        if (i229 != 0) {
                            int i232 = (i231 & pressedStateDuration) | (i231 ^ pressedStateDuration);
                            int i233 = ~((i232 & 3) | (i232 ^ 3));
                            int i234 = -((i230 & i233) | (i230 ^ i233));
                            i9 = i225 << ((i234 ^ (-318)) + ((i234 & (-318)) << 1));
                        } else {
                            int i235 = (i231 & pressedStateDuration) | (i231 ^ pressedStateDuration);
                            int i236 = ~((i235 & 3) | (i235 ^ 3));
                            i9 = (((i230 & i236) | (i230 ^ i236)) * (-318)) + i225;
                        }
                        int i237 = ~(((-4) ^ pressedStateDuration) | ((-4) & pressedStateDuration));
                        int i238 = ~((pressedStateDuration ^ i) | (pressedStateDuration & i));
                        int i239 = (i9 - (~((-318) * ((i237 & i238) | (i237 ^ i238))))) - 1;
                        int i240 = ~pressedStateDuration;
                        int i241 = ~((i240 & i) | (i240 ^ i));
                        int i242 = -(-(((i241 & (-4)) | ((-4) ^ i241)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                        Object[] objArr10 = new Object[1];
                        a(((i239 | i242) << 1) - (i242 ^ i239), new char[]{26, CharUtils.CR, 13862}, (byte) (59 - ImageFormat.getBitsPerPixel(0)), objArr10);
                        if (!line.equals((String) objArr10[0])) {
                            int i243 = artificialFrame + 117;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i243 % 128;
                            int i244 = i243 % 2;
                            fileReader.close();
                            bufferedReader.close();
                            int i245 = artificialFrame;
                            int i246 = (i245 & 3) + (i245 | 3);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i246 % 128;
                            int i247 = i246 % 2;
                        } else {
                            fileReader.close();
                            bufferedReader.close();
                            int i248 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                            artificialFrame = i248 % 128;
                            int i249 = i248 % 2;
                            line = null;
                        }
                    } catch (Throwable th) {
                        fileReader.close();
                        bufferedReader.close();
                        throw th;
                    }
                } else {
                    line = null;
                }
            } catch (Exception unused2) {
            }
            try {
                int i250 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                int iINotificationSideChannelStubProxy6 = BytesValue.Builder.INotificationSideChannelStubProxy();
                int i251 = ~i250;
                int i252 = ~((~iINotificationSideChannelStubProxy6) | i251);
                int i253 = (i250 * 236) + 39564 + (((i252 & 84) | (i252 ^ 84)) * (-235));
                int i254 = ~(i251 | iINotificationSideChannelStubProxy6);
                int i255 = -(-(((i254 & 84) | (i254 ^ 84)) * (-470)));
                int i256 = (i253 & i255) + (i253 | i255);
                int i257 = ~((-85) | i250);
                int i258 = ~i250;
                int i259 = (i258 & 84) | (i258 ^ 84);
                int i260 = ~((i259 & iINotificationSideChannelStubProxy6) | (i259 ^ iINotificationSideChannelStubProxy6));
                int i261 = -(-(((i260 & i257) | (i257 ^ i260)) * 235));
                Object[] objArr11 = new Object[1];
                a(TextUtils.indexOf("", "", 0) + 31, new char[]{23, 1, '\b', 20, 25, 20, 25, '\"', 25, 22, '#', 30, 1, 26, '!', 23, 18, 1, 2, '\b', ' ', 24, 30, 11, 31, 29, '\"', '\f', 23, '!', 13907}, (byte) ((i256 & i261) + (i261 | i256)), objArr11);
                File file2 = new File((String) objArr11[0]);
                if (file2.canRead()) {
                    FileReader fileReader2 = new FileReader(file2);
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                    try {
                        String line2 = bufferedReader2.readLine();
                        int i262 = -(-(ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr12 = new Object[1];
                        a((i262 ^ 1) + ((i262 & 1) << 1), new char[]{13793}, (byte) (55 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr12);
                        boolean zEquals2 = line2.equals((String) objArr12[0]);
                        fileReader2.close();
                        bufferedReader2.close();
                        BytesValue.Builder.INotificationSideChannelStubProxy();
                        int i263 = artificialFrame;
                        int i264 = (i263 ^ 45) + ((i263 & 45) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i264 % 128;
                        int i265 = i264 % 2;
                        if (zEquals2) {
                            try {
                                int i266 = 34 - (~(-(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))));
                                char[] cArr = {22, 25, '\"', 25, 22, 31, ' ', 5, 29, 31, 22, 20, 5, 31, 17, '\f', 18, 20, 2, '\b', ' ', 24, 7, 29, 18, 20, 2, '\b', ' ', 24, 7, 29, 18, 11, CharUtils.CR, 26};
                                int i267 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                int i268 = i267 * 495;
                                int i269 = (((i268 ^ (-14297)) + ((i268 & (-14297)) << 1)) - (~(-(-((i267 | (-30)) * (-988)))))) - 1;
                                int i270 = (~i267) | 29;
                                int i271 = ~i;
                                int i272 = -(-(((i270 & i271) | (i270 ^ i271)) * 494));
                                int i273 = (i269 & i272) + (i272 | i269);
                                int i274 = ~i267;
                                int i275 = ~((i274 & (-30)) | (i274 ^ (-30)));
                                int i276 = ~i;
                                int i277 = ~((i276 & 29) | (i276 ^ 29));
                                int i278 = (i275 & i277) | (i275 ^ i277);
                                int i279 = ~((i267 & 29) | (i267 ^ 29));
                                int i280 = ((i279 & i278) | (i278 ^ i279)) * 494;
                                Object[] objArr13 = new Object[1];
                                a(i266, cArr, (byte) (((i273 | i280) << 1) - (i280 ^ i273)), objArr13);
                                File file3 = new File((String) objArr13[0]);
                                if (file3.canRead()) {
                                    FileReader fileReader3 = new FileReader(file3);
                                    BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                    int i281 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i282 = ((i281 | b.i) << 1) - (i281 ^ b.i);
                                    artificialFrame = i282 % 128;
                                    int i283 = i282 % 2;
                                    try {
                                        String line3 = bufferedReader3.readLine();
                                        int i284 = -Color.argb(0, 0, 0, 0);
                                        int iINotificationSideChannelStubProxy7 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                        int i285 = (i284 * 70) - 68;
                                        int i286 = ~i284;
                                        int i287 = i286 | (-2);
                                        int i288 = ~((i287 & iINotificationSideChannelStubProxy7) | (i287 ^ iINotificationSideChannelStubProxy7));
                                        int i289 = (i284 ^ 1) | (i284 & 1);
                                        int i290 = ~((i289 & iINotificationSideChannelStubProxy7) | (i289 ^ iINotificationSideChannelStubProxy7));
                                        int iINotificationSideChannelStubProxy8 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                        int i291 = ~iINotificationSideChannelStubProxy8;
                                        int i292 = ~(((-1740949108) ^ i291) | ((-1740949108) & i291));
                                        int i293 = (-1176484200) + ((((-917825079) ^ i292) | ((-917825079) & i292)) * 519);
                                        int i294 = ((-1740949108) ^ i291) | (i291 & (-1740949108));
                                        int i295 = ~((i294 & (-917825079)) | (i294 ^ (-917825079)));
                                        int i296 = ~(((-271589381) ^ iINotificationSideChannelStubProxy8) | ((-271589381) & iINotificationSideChannelStubProxy8));
                                        int i297 = i293 + (((i295 ^ i296) | (i295 & i296)) * (-519));
                                        int i298 = -(-(((~(((-917825079) & iINotificationSideChannelStubProxy8) | ((-917825079) ^ iINotificationSideChannelStubProxy8))) | 1740949107) * 519));
                                        int i299 = (i297 ^ i298) + ((i297 & i298) << 1);
                                        int iINotificationSideChannelStubProxy9 = BytesValue.Builder.INotificationSideChannelStubProxy();
                                        int i300 = ~iINotificationSideChannelStubProxy9;
                                        int i301 = ~((i300 ^ (-2083936980)) | (i300 & (-2083936980)));
                                        int i302 = (-150334357) + (((539103745 ^ i301) | (539103745 & i301)) * (-108));
                                        int i303 = ~((1558047958 ^ iINotificationSideChannelStubProxy9) | (1558047958 & iINotificationSideChannelStubProxy9));
                                        int i304 = (i303 ^ 13214724) | (i303 & 13214724);
                                        int i305 = ~iINotificationSideChannelStubProxy9;
                                        int i306 = ~((i305 ^ (-1558047959)) | (i305 & (-1558047959)));
                                        if (i299 <= i302 + (((i304 ^ i306) | (i304 & i306)) * 54) + (((iINotificationSideChannelStubProxy9 & 13214724) | (iINotificationSideChannelStubProxy9 ^ 13214724)) * 54)) {
                                            i6 = i285 / (68 - (~((i288 ^ i290) | (i288 & i290))));
                                            i8 = ~i284;
                                            i7 = ~((i8 ^ 1) | (i8 & 1));
                                        } else {
                                            int i307 = -(-(((i288 & i290) | (i288 ^ i290)) * 69));
                                            i6 = (i285 | i307) + (i285 & i307);
                                            i7 = ~((i286 & 1) | (i286 ^ 1));
                                            i8 = ~i284;
                                        }
                                        int i308 = ~((i8 & iINotificationSideChannelStubProxy7) | (i8 ^ iINotificationSideChannelStubProxy7));
                                        int i309 = (i308 & i7) | (i7 ^ i308);
                                        int i310 = ~((iINotificationSideChannelStubProxy7 & 1) | (1 ^ iINotificationSideChannelStubProxy7));
                                        int i311 = (-69) * ((i310 & i309) | (i309 ^ i310));
                                        int i312 = (i6 ^ i311) + ((i6 & i311) << 1);
                                        int i313 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i314 = (i313 & 61) + (i313 | 61);
                                        artificialFrame = i314 % 128;
                                        if (i314 % 2 == 0) {
                                            Object[] objArr14 = new Object[1];
                                            a(i312 - (69 >> (~((i284 & (-2)) | ((-2) ^ i284)))), new char[]{13793}, (byte) (Color.alpha(0) * 63), objArr14);
                                            zEquals = line3.equals((String) objArr14[0]);
                                        } else {
                                            int i315 = (~((i284 & (-2)) | ((-2) ^ i284))) * 69;
                                            int i316 = -Color.alpha(0);
                                            Object[] objArr15 = new Object[1];
                                            a((i312 ^ i315) + ((i315 & i312) << 1), new char[]{13793}, (byte) (((i316 | 54) << 1) - (i316 ^ 54)), objArr15);
                                            zEquals = line3.equals((String) objArr15[0]);
                                        }
                                        fileReader3.close();
                                        bufferedReader3.close();
                                    } catch (Throwable th2) {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        throw th2;
                                    }
                                } else {
                                    zEquals = false;
                                }
                            } catch (Exception unused3) {
                            }
                            if (!(!zEquals) && line != null) {
                                int i317 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
                                artificialFrame = i317 % 128;
                                int i318 = i317 % 2;
                                Object[] objArr16 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[]{i ^ (i << 5)}, line};
                                int i319 = ~i;
                                int i320 = 1269597918 + (((-303055381) | i319) * 494) + (((~(i319 | 673429898)) | (-974346783)) * 494);
                                int i321 = ((i320 | 16) << 1) - (i320 ^ 16);
                                int i322 = (i3 ^ i321) + ((i321 & i3) << 1);
                                int i323 = i322 << 13;
                                int i324 = (i323 & (~i322)) | ((~i323) & i322);
                                int i325 = i324 >>> 17;
                                int i326 = ((~i324) & i325) | ((~i325) & i324);
                                return objArr16;
                            }
                        }
                    } catch (Throwable th3) {
                        fileReader2.close();
                        bufferedReader2.close();
                        throw th3;
                    }
                }
            } catch (Exception unused4) {
            }
            int i327 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i328 = ((i327 | 11) << 1) - (i327 ^ 11);
            artificialFrame = i328 % 128;
            int i329 = i328 % 2;
            Object[] objArr17 = {new int[]{i}, new int[]{i}, new int[1], null};
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i330 = ~iMaxMemory2;
            int i331 = 718342326 + (((~(490105428 | i330)) | 488518346) * (-328)) + ((iMaxMemory2 | 488518346) * 164) + (((~(iMaxMemory2 | (-490105429))) | 487989824 | (~(i330 | 490633950))) * 164);
            int iINotificationSideChannelStubProxy10 = BytesValue.Builder.INotificationSideChannelStubProxy();
            int i332 = ((~iINotificationSideChannelStubProxy10) | 1132079126) * 1324;
            int i333 = (952378887 ^ i332) + ((i332 & 952378887) << 1);
            int i334 = ~((1199221951 & iINotificationSideChannelStubProxy10) | (1199221951 ^ iINotificationSideChannelStubProxy10));
            int i335 = ~((iINotificationSideChannelStubProxy10 & 1937717270) | (1937717270 ^ iINotificationSideChannelStubProxy10));
            int i336 = i333 + (((i335 & i334) | (i334 ^ i335)) * (-1324));
            int i337 = (i336 & (-2039583482)) + ((-2039583482) | i336);
            int i338 = ~(((-788499079) & i) | ((-788499079) ^ i));
            int i339 = -(-(((i338 & (-1623977232)) | ((-1623977232) ^ i338)) * (-318)));
            int i340 = (((-1276571289) | i339) << 1) - (i339 ^ (-1276571289));
            int i341 = ~(((-1623977232) ^ i) | ((-1623977232) & i));
            int i342 = ~i;
            int i343 = (i342 ^ 788499078) | (i342 & 788499078);
            int i344 = ~((i343 & 1623977231) | (i343 ^ 1623977231));
            int i345 = -(-(((i341 & i344) | (i341 ^ i344)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
            int i346 = (i340 ^ i345) + ((i345 & i340) << 1);
            int i347 = ~i;
            int i348 = (-1623977232) | i347;
            int i349 = ~((i348 & 788499078) | (i348 ^ 788499078));
            int i350 = ~((1862266767 & i) | (1862266767 ^ i));
            if (i337 <= (i346 - (~(((i349 & i350) | (i349 ^ i350)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET))) - 1) {
                int i351 = -i331;
                int i352 = (i351 ^ 69) + ((i351 & 69) << 1);
                int i353 = (-67) >> i3;
                i5 = ((i352 | i353) << 1) - (i353 ^ i352);
            } else {
                int i354 = i331 * 69;
                int i355 = -(-(i3 * (-67)));
                i5 = ((i354 | i355) << 1) - (i354 ^ i355);
            }
            int i356 = (~i331) | (~i3);
            int i357 = ~((i356 & i347) | (i356 ^ i347));
            int i358 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i359 = (i358 & 125) + (i358 | 125);
            artificialFrame = i359 % 128;
            int i360 = i359 % 2;
            int i361 = ~((i331 ^ i3) | (i331 & i3));
            int i362 = (i357 & i361) | (i357 ^ i361);
            int i363 = ~((i & i3) | (i3 ^ i));
            int i364 = i347 | (~i331);
            int i365 = ((i5 + ((-68) * ((i363 & i362) | (i362 ^ i363)))) - (~(-(-((~((i364 & i3) | (i364 ^ i3))) * (-68)))))) - 1;
            int i366 = ~i331;
            int i367 = ~((~i3) | i342);
            int i368 = ((i366 & i367) | (i366 ^ i367)) * 68;
            int i369 = ((i365 | i368) << 1) - (i368 ^ i365);
            int i370 = (i369 << 13) ^ i369;
            int i371 = i370 >>> 17;
            int i372 = ((~i370) & i371) | ((~i371) & i370);
            int i373 = i372 << 5;
            ((int[]) objArr17[2])[0] = ((~i372) & i373) | ((~i373) & i372);
            return objArr17;
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }
}
