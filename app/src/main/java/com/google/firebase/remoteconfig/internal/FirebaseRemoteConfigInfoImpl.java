package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.location.TSLocation$$ExternalSyntheticApiModelOutline0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {
    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    /* synthetic */ FirebaseRemoteConfigInfoImpl(long j, int i, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings, AnonymousClass1 anonymousClass1) {
        this(j, i, firebaseRemoteConfigSettings);
    }

    private FirebaseRemoteConfigInfoImpl(long j, int i, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.lastSuccessfulFetchTimeInMillis = j;
        this.lastFetchStatus = i;
        this.configSettings = firebaseRemoteConfigSettings;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public long getFetchTimeMillis() {
        return this.lastSuccessfulFetchTimeInMillis;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public static class Builder {
        private FirebaseRemoteConfigSettings builderConfigSettings;
        private int builderLastFetchStatus;
        private long builderLastSuccessfulFetchTimeInMillis;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j) {
            this.builderLastSuccessfulFetchTimeInMillis = j;
            return this;
        }

        Builder withLastFetchStatus(int i) {
            this.builderLastFetchStatus = i;
            return this;
        }

        Builder withConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.builderConfigSettings = firebaseRemoteConfigSettings;
            return this;
        }

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.builderLastSuccessfulFetchTimeInMillis, this.builderLastFetchStatus, this.builderConfigSettings, null);
        }
    }

    static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX INFO: renamed from: com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        private static final byte[] $$a = {4, Ascii.VT, 101, -73};
        private static final int $$b = 127;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int[] ICustomTabsCallbackStub = {990798998, -1574271000, -1833880247, -1567860032, -1851360380, 1430078781, 664041155, -938149726, 1554565415, 338709831, -878651503, 476449992, -1305548648, -1438001188, 1099905926, 1737287130, 1581591316, 1705825595};
        private static char[] ArtificialStackFrames = {44353, 44390, 44365, 44349, 44376, 44410, 44355, 44394, 44397, 44345, 44399, 44403, 44406, 44398, 44387, 44409, 44402, 44341, 44385, 44400, 44396, 44388, 44408, 44412, 44367, 44371, 44357, 44415, 44414, 44332, 44389, 44361, 44336, 44356, 44393, 44404, 44368, 44411, 44405, 44395, 44320, 44373, 44413, 44334, 44391, 44359, 44358, 44386, 44366};
        private static char coroutineCreation = 39069;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r7, short r8, byte r9) {
            /*
                int r9 = r9 * 3
                int r9 = r9 + 1
                int r7 = 115 - r7
                int r8 = r8 + 4
                byte[] r0 = com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.AnonymousClass1.$$a
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L13
                r7 = r8
                r3 = r9
                r4 = r2
                goto L28
            L13:
                r3 = r2
            L14:
                int r8 = r8 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L23
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L23:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r6
            L28:
                int r3 = -r3
                int r8 = r8 + r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.AnonymousClass1.$$c(byte, short, byte):java.lang.String");
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = ICustomTabsCallbackStub;
            double d = 0.0d;
            int i3 = -1780896814;
            int i4 = -1;
            int i5 = 1;
            int i6 = 0;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                int i7 = 0;
                while (i7 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i6] = Integer.valueOf(iArr2[i7]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSize(i6, i6) + 11, (char) KeyEvent.keyCodeFromString(""), 1562 - (CdmaCellLocation.convertQuartSecToDecDegrees(i6) > d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i6) == d ? 0 : -1)), 180153818, false, $$c((byte) ($$b & 6), b, (byte) (b + 1)), new Class[]{Integer.TYPE});
                        }
                        iArr3[i7] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        i7++;
                        d = 0.0d;
                        i3 = -1780896814;
                        i4 = -1;
                        i6 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = ICustomTabsCallbackStub;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i8 = $10 + 73;
                $11 = i8 % 128;
                int i9 = 2;
                int i10 = i8 % 2;
                int i11 = 0;
                while (i11 < length3) {
                    int i12 = $11 + 27;
                    $10 = i12 % 128;
                    if (i12 % i9 != 0) {
                        try {
                            Object[] objArr3 = new Object[i5];
                            objArr3[0] = Integer.valueOf(iArr5[i11]);
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                            if (objAccessartificialFrame2 == null) {
                                byte b2 = (byte) (-1);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(12 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1562, 180153818, false, $$c((byte) ($$b & 6), b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                            }
                            iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                            i11 %= 0;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } else {
                        length3 = length3;
                        try {
                            Object[] objArr4 = {Integer.valueOf(iArr5[i11])};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                            if (objAccessartificialFrame3 == null) {
                                byte b3 = (byte) (-1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), 1561 - Process.getGidForName(""), 180153818, false, $$c((byte) ($$b & 6), b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE});
                            }
                            iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                            i11++;
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                    length3 = length3;
                    i5 = 1;
                    i9 = 2;
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            artificialframe.e = 0;
            while (artificialframe.e < iArr.length) {
                int i13 = $11 + 119;
                $10 = i13 % 128;
                int i14 = i13 % 2;
                cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i15 = 0;
                for (int i16 = 16; i15 < i16; i16 = 16) {
                    int i17 = $10 + 21;
                    $11 = i17 % 128;
                    if (i17 % 2 == 0) {
                        artificialframe.c ^= iArr4[i15];
                        Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                        if (objAccessartificialFrame4 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = (byte) (b4 - 1);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 26, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1041 - (Process.myTid() >> 22), 995482881, false, $$c(b4, b5, (byte) (b5 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        artificialframe.c = artificialframe.b;
                        artificialframe.b = iIntValue;
                        i15 += 24;
                    } else {
                        artificialframe.c ^= iArr4[i15];
                        Object[] objArr6 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                        if (objAccessartificialFrame5 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 - 1);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 26, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040, 995482881, false, $$c(b6, b7, (byte) (b7 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                        }
                        int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                        artificialframe.c = artificialframe.b;
                        artificialframe.b = iIntValue2;
                        i15++;
                    }
                }
                int i18 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i18;
                artificialframe.b ^= iArr4[16];
                artificialframe.c ^= iArr4[17];
                int i19 = artificialframe.c;
                int i20 = artificialframe.b;
                cArr[0] = (char) (artificialframe.c >>> 16);
                cArr[1] = (char) artificialframe.c;
                cArr[2] = (char) (artificialframe.b >>> 16);
                cArr[3] = (char) artificialframe.b;
                artificialFrame.coroutineBoundary(iArr4);
                cArr2[artificialframe.e * 2] = cArr[0];
                cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                Object[] objArr7 = {artificialframe, artificialframe};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1348396126);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(36 - MotionEvent.axisFromString(""), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 28010), (Process.myTid() >> 22) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0124  */
        /* JADX WARN: Code duplicated, block: B:34:0x013b  */
        /* JADX WARN: Code duplicated, block: B:37:0x0187 A[Catch: all -> 0x0349, TryCatch #0 {all -> 0x0349, blocks: (B:7:0x002d, B:9:0x003b, B:10:0x0070, B:14:0x0089, B:16:0x009a, B:17:0x00cd, B:35:0x013d, B:37:0x0187, B:38:0x01fe, B:42:0x0213, B:44:0x024d, B:46:0x02b7), top: B:63:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0211  */
        /* JADX WARN: Code duplicated, block: B:44:0x024d A[Catch: all -> 0x0349, TryCatch #0 {all -> 0x0349, blocks: (B:7:0x002d, B:9:0x003b, B:10:0x0070, B:14:0x0089, B:16:0x009a, B:17:0x00cd, B:35:0x013d, B:37:0x0187, B:38:0x01fe, B:42:0x0213, B:44:0x024d, B:46:0x02b7), top: B:63:0x002d }] */
        /* JADX WARN: Code duplicated, block: B:45:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:48:0x02d8  */
        /* JADX WARN: Code duplicated, block: B:50:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:51:0x0308  */
        private static void b(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2;
            Object obj;
            Object[] objArr2;
            Object objAccessartificialFrame;
            Object objAccessartificialFrame2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i4 = -1819279892;
            Object obj2 = null;
            int i5 = -1;
            if (cArr2 != null) {
                int i6 = $10;
                int i7 = i6 + 97;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i9 = i6 + 35;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                int i11 = 0;
                while (i11 < length) {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i11])};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame3 == null) {
                            byte b2 = (byte) i5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) (KeyEvent.normalizeMetaState(0) + 20488), 2148 - Color.argb(0, 0, 0, 0), 216710116, false, $$c((byte) ($$b & 18), b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE});
                        }
                        cArr3[i11] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr3)).charValue();
                        i11++;
                        i4 = -1819279892;
                        i5 = -1;
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
            Object[] objArr4 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame4 == null) {
                byte b3 = (byte) (-1);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(14 - ExpandableListView.getPackedPositionChild(0L), (char) (20488 - Color.green(0)), (Process.myTid() >> 22) + 2148, 216710116, false, $$c((byte) ($$b & 18), b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE});
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
                    int i12 = $10 + 113;
                    $11 = i12 % 128;
                    if (i12 % 2 == 0) {
                        extracallback.createBrowser = cArr[extracallback.a];
                        extracallback.c = cArr[extracallback.a];
                        if (extracallback.createBrowser == extracallback.c) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                            obj = obj2;
                        } else {
                            objArr2 = new Object[]{extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1894223152);
                            if (objAccessartificialFrame == null) {
                                byte b4 = (byte) (-1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (View.MeasureSpec.getSize(0) + 58859), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2464, 276640984, false, $$c((byte) ($$b & 13), b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame2 == null) {
                                    byte b5 = (byte) (-1);
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 24, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 792 - Color.green(0), -834291897, false, $$c((byte) ($$b & 10), b5, (byte) (b5 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr5)).intValue();
                                int i13 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i13];
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
                                byte b6 = (byte) (-1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (View.MeasureSpec.getSize(0) + 58859), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2464, 276640984, false, $$c((byte) ($$b & 13), b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                            }
                            if (((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue() == extracallback.g) {
                                Object[] objArr6 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame2 == null) {
                                    byte b7 = (byte) (-1);
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 24, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 792 - Color.green(0), -834291897, false, $$c((byte) ($$b & 10), b7, (byte) (b7 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr6)).intValue();
                                int i18 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue2];
                                cArr4[extracallback.a + 1] = cArr2[i18];
                            } else {
                                obj = null;
                                if (extracallback.b == extracallback.d) {
                                    extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                    extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                    int i19 = (extracallback.b * cCharValue) + extracallback.j;
                                    int i110 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[i19];
                                    cArr4[extracallback.a + 1] = cArr2[i110];
                                } else {
                                    int i111 = (extracallback.b * cCharValue) + extracallback.g;
                                    int i112 = (extracallback.d * cCharValue) + extracallback.j;
                                    cArr4[extracallback.a] = cArr2[i111];
                                    cArr4[extracallback.a + 1] = cArr2[i112];
                                }
                            }
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                }
            }
            for (int i20 = 0; i20 < i; i20++) {
                int i21 = $11 + 53;
                $10 = i21 % 128;
                int i22 = i21 % 2;
                cArr4[i20] = (char) (cArr4[i20] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            int i3;
            int i4;
            String str;
            Object objInvoke;
            int i5;
            int i6;
            int i7 = 2;
            int i8 = 2 % 2;
            int i9 = 1;
            if (context == null) {
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                artificialFrame = i10 % 128;
                int i11 = i10 % 2;
                int i12 = ~((int) Runtime.getRuntime().totalMemory());
                int i13 = (((~((-578690632) | i12)) | 39198279) * (-241)) + 797718117 + (((~(i12 | (-539492353))) | 360734864) * 241);
                int i14 = -(-((i13 << 1) - i13));
                int i15 = ((i2 | i14) << 1) - (i2 ^ i14);
                int i16 = (i15 << 13) ^ i15;
                int i17 = i16 >>> 17;
                int i18 = (i16 | i17) & (~(i16 & i17));
                int i19 = artificialFrame;
                int i20 = ((i19 | b.f40o) << 1) - (i19 ^ b.f40o);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                int i21 = i20 % 2;
                int i22 = i18 << 5;
                ((int[]) objArr[2])[0] = (i18 | i22) & (~(i18 & i22));
                return objArr;
            }
            try {
                int i23 = -(-(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                Object[] objArr2 = new Object[1];
                a(((i23 | 37) << 1) - (i23 ^ 37), new int[]{-1675113324, 672278040, 2126166813, 1180679048, -1291473036, -1108462516, -543113312, 122177531, -1089984371, 520017712, 892853723, 155898110, 1052841575, 287711335, 1682090127, 163508336, 1387847733, -1423556017, -1697027028, -1779504772}, objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity() >> 16;
                byte b = (byte) (((minimumFlingVelocity | b.i) << 1) - (minimumFlingVelocity ^ b.i));
                int i24 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                Object[] objArr4 = new Object[1];
                b(b, ((i24 | 31) << 1) - (i24 ^ 31), new char[]{CharUtils.CR, 6, 4, 1, 7, 27, 17, '\t', 28, 27, '/', CoreConstants.LEFT_PARENTHESIS_CHAR, '!', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, CoreConstants.DASH_CHAR, 31, 22, 4, 1, 7, 27, 17, '\t', 28, 27, '\"', 1, 6, Typography.amp, 13872}, objArr4);
                String str2 = (String) objArr4[0];
                int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i26 = (i25 ^ 41) + ((i25 & 41) << 1);
                artificialFrame = i26 % 128;
                int i27 = i26 % 2;
                try {
                    int iRgb = Color.rgb(0, 0, 0);
                    Object[] objArr5 = new Object[1];
                    a(((iRgb | 16777254) << 1) - (iRgb ^ 16777254), new int[]{-1675113324, 672278040, 2126166813, 1180679048, -1291473036, -1108462516, -543113312, 122177531, -1089984371, 520017712, 892853723, 155898110, 1052841575, 287711335, 1682090127, 163508336, 1387847733, -1423556017, -1697027028, -1779504772}, objArr5);
                    objArr3[0] = Class.forName((String) objArr5[0]).getDeclaredConstructor(String.class).newInstance(str2);
                    int i28 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    int i29 = -View.resolveSize(0, 0);
                    Object[] objArr6 = new Object[1];
                    b((byte) (((i28 | 61) << 1) - (i28 ^ 61)), (i29 ^ 31) + ((i29 & 31) << 1), new char[]{0, 4, CoreConstants.SINGLE_QUOTE_CHAR, 27, 31, 22, 4, 1, 7, 27, 17, '\t', 28, 27, '\"', 1, CoreConstants.DASH_CHAR, 6, 6, 7, 23, 14, CharUtils.CR, 31, 26, '#', '\"', 31, CoreConstants.DASH_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, 13881}, objArr6);
                    String str3 = (String) objArr6[0];
                    int i30 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i31 = (i30 ^ 5) + ((i30 & 5) << 1);
                    int i32 = i31 % 128;
                    artificialFrame = i32;
                    int i33 = i31 % 2;
                    int i34 = ((i32 | 85) << 1) - (i32 ^ 85);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i34 % 128;
                    int i35 = i34 % 2;
                    try {
                        int i36 = -TextUtils.indexOf("", "", 0);
                        int i37 = (i36 * 306) + TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
                        int i38 = ((i37 | 11628) << 1) - (i37 ^ 11628);
                        int i39 = -(-(((~((i36 ^ 38) | (i36 & 38))) | (~(i36 | i))) * 305));
                        int i40 = (i38 ^ i39) + ((i39 & i38) << 1);
                        int i41 = ~i;
                        int i42 = ((~(i36 | i41)) | (-39)) * 305;
                        Object[] objArr7 = new Object[1];
                        a((i40 ^ i42) + ((i42 & i40) << 1), new int[]{-1675113324, 672278040, 2126166813, 1180679048, -1291473036, -1108462516, -543113312, 122177531, -1089984371, 520017712, 892853723, 155898110, 1052841575, 287711335, 1682090127, 163508336, 1387847733, -1423556017, -1697027028, -1779504772}, objArr7);
                        objArr3[1] = Class.forName((String) objArr7[0]).getDeclaredConstructor(String.class).newInstance(str3);
                        int i43 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i44 = (i43 & 51) + (i43 | 51);
                        artificialFrame = i44 % 128;
                        int i45 = i44 % 2;
                        try {
                            int defaultSize = View.getDefaultSize(0, 0);
                            int i46 = defaultSize * (-813);
                            int i47 = (i46 & 9384) + (i46 | 9384);
                            int i48 = ~((-24) | defaultSize);
                            int i49 = ~(defaultSize | i);
                            int i50 = ((i48 ^ i49) | (i49 & i48)) * (-814);
                            int i51 = (i47 & i50) + (i50 | i47);
                            int i52 = ~(((-24) ^ i41) | ((-24) & i41));
                            int i53 = ~defaultSize;
                            int i54 = ~((i53 ^ 23) | (i53 & 23));
                            int i55 = (i52 ^ i54) | (i52 & i54);
                            int i56 = ~((defaultSize ^ i) | (defaultSize & i));
                            int i57 = ((i55 ^ i56) | (i55 & i56)) * 407;
                            int i58 = (i51 ^ i57) + ((i57 & i51) << 1);
                            int i59 = ~defaultSize;
                            int i60 = ~(i59 | 23);
                            int i61 = ~((i59 & i) | (i59 ^ i));
                            int i62 = (i61 & i60) | (i60 ^ i61);
                            int i63 = ~((i ^ 23) | (i & 23));
                            int i64 = i62 ^ i63;
                            Object[] objArr8 = new Object[1];
                            a(i58 + (((i62 & i63) | i64) * 407), new int[]{-36396715, 1103743459, -2131288319, 111749279, -156848856, 242831879, 59247307, 183267482, -383169925, -225349390, -1106423913, -613002605}, objArr8);
                            Class<?> cls = Class.forName((String) objArr8[0]);
                            int i65 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                            Object[] objArr9 = new Object[1];
                            b((byte) ((i65 & 18) + (i65 | 18)), 18 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{2, CoreConstants.PERCENT_CHAR, '$', CoreConstants.PERCENT_CHAR, 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, 4, 16, 11, 20, 2, CoreConstants.PERCENT_CHAR, 13818}, objArr9);
                            Object objInvoke2 = cls.getMethod((String) objArr9[0], null).invoke(context, null);
                            try {
                                int i66 = -View.combineMeasuredStates(0, 0);
                                int iMediaBrowserCompatItemReceiver = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                int i67 = i66 * (-519);
                                int i68 = ((i67 | 11983) << 1) - (i67 ^ 11983);
                                int i69 = ~i66;
                                int i70 = ~iMediaBrowserCompatItemReceiver;
                                int i71 = ~((i69 ^ (-24)) | (i69 & (-24)) | i70);
                                int i72 = ~((iMediaBrowserCompatItemReceiver ^ 23) | (iMediaBrowserCompatItemReceiver & 23));
                                int i73 = i68 + (((i71 ^ i72) | (i72 & i71)) * 520);
                                int i74 = artificialFrame;
                                int i75 = (i74 & 25) + (i74 | 25);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i75 % 128;
                                int i76 = i75 % 2;
                                int i77 = ~iMediaBrowserCompatItemReceiver;
                                int i78 = ~((i77 & (-24)) | ((-24) ^ i77));
                                int i79 = ~((i66 ^ iMediaBrowserCompatItemReceiver) | (i66 & iMediaBrowserCompatItemReceiver));
                                int i80 = -(-((i78 | i79) * (-1040)));
                                int i81 = (i73 & i80) + (i80 | i73);
                                int i82 = (i74 & 119) + (i74 | 119);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i82 % 128;
                                if (i82 % 2 != 0) {
                                    int i83 = ~((i69 ^ i70) | (i69 & i70));
                                    int i84 = ~(((-24) ^ i66) | ((-24) & i66));
                                    int i85 = (i83 & i84) | (i83 ^ i84);
                                    int i86 = ~(i66 | iMediaBrowserCompatItemReceiver);
                                    Object[] objArr10 = new Object[1];
                                    a(i81 / (((i85 & i86) | (i85 ^ i86)) * 520), new int[]{-36396715, 1103743459, -2131288319, 111749279, -156848856, 242831879, 59247307, 183267482, -383169925, -225349390, -1106423913, -613002605}, objArr10);
                                    str = (String) objArr10[0];
                                    i4 = 0;
                                } else {
                                    int i87 = ~((i69 ^ i70) | (i69 & i70));
                                    int i88 = ~((-24) | i66);
                                    int i89 = (i87 & i88) | (i87 ^ i88);
                                    int i90 = -(-(((i89 & i79) | (i89 ^ i79)) * 520));
                                    Object[] objArr11 = new Object[1];
                                    a((i81 & i90) + (i81 | i90), new int[]{-36396715, 1103743459, -2131288319, 111749279, -156848856, 242831879, 59247307, 183267482, -383169925, -225349390, -1106423913, -613002605}, objArr11);
                                    i4 = 0;
                                    str = (String) objArr11[0];
                                }
                                Class<?> cls2 = Class.forName(str);
                                byte b2 = (byte) (86 - (~(-KeyEvent.normalizeMetaState(i4))));
                                int iAxisFromString = MotionEvent.axisFromString("");
                                int iMediaBrowserCompatItemReceiver2 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                int i91 = (iAxisFromString * (-755)) - 11325;
                                int i92 = ~iAxisFromString;
                                int i93 = -(-((~((i92 & (-16)) | (i92 ^ (-16)))) * 1512));
                                int i94 = (i91 ^ i93) + ((i91 & i93) << 1);
                                int i95 = ~((~iAxisFromString) | (-16));
                                int i96 = (iAxisFromString & 15) | (iAxisFromString ^ 15);
                                int i97 = ~((i96 ^ iMediaBrowserCompatItemReceiver2) | (i96 & iMediaBrowserCompatItemReceiver2));
                                int i98 = ((i95 & i97) | (i95 ^ i97)) * (-756);
                                int i99 = ((i94 | i98) << 1) - (i98 ^ i94);
                                int i100 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i101 = (i100 ^ 35) + ((i100 & 35) << 1);
                                artificialFrame = i101 % 128;
                                int i102 = i101 % 2;
                                int i103 = ~iMediaBrowserCompatItemReceiver2;
                                if (i102 == 0) {
                                    int i104 = i99 >> (756 >>> ((i96 & i103) | (i96 ^ i103)));
                                    Object[] objArr12 = new Object[1];
                                    b(b2, i104, new char[]{2, CoreConstants.PERCENT_CHAR, '$', CoreConstants.PERCENT_CHAR, 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, '.', 20, '\t', 29}, objArr12);
                                    objInvoke = cls2.getMethod((String) objArr12[0], null).invoke(context, null);
                                    i5 = 45;
                                } else {
                                    int i105 = -(-(((i96 & i103) | (i96 ^ i103)) * 756));
                                    Object[] objArr13 = new Object[1];
                                    b(b2, (i99 & i105) + (i105 | i99), new char[]{2, CoreConstants.PERCENT_CHAR, '$', CoreConstants.PERCENT_CHAR, 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, '.', 20, '\t', 29}, objArr13);
                                    objInvoke = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                                    i5 = 64;
                                }
                                try {
                                    Object[] objArr14 = {objInvoke, Integer.valueOf(i5)};
                                    int scrollDefaultDelay = ViewConfiguration.getScrollDefaultDelay() >> 16;
                                    int iMediaBrowserCompatItemReceiver3 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                    int i106 = scrollDefaultDelay * 471;
                                    int i107 = (((i106 & 25905) + (i106 | 25905)) - (~(-(-(((scrollDefaultDelay ^ 55) | (scrollDefaultDelay & 55)) * (-470)))))) - 1;
                                    int i108 = ~scrollDefaultDelay;
                                    int i109 = ~((i108 & (-56)) | (i108 ^ (-56)));
                                    int i110 = ~(((-56) ^ iMediaBrowserCompatItemReceiver3) | ((-56) & iMediaBrowserCompatItemReceiver3));
                                    int i111 = (i109 & i110) | (i109 ^ i110);
                                    int i112 = ~iMediaBrowserCompatItemReceiver3;
                                    int i113 = (i112 & scrollDefaultDelay) | (i112 ^ scrollDefaultDelay);
                                    int i114 = ~(i113 | 55);
                                    int i115 = (i107 - (~(-(-(((i111 & i114) | (i111 ^ i114)) * (-470)))))) - 1;
                                    int i116 = (scrollDefaultDelay & (-56)) | ((-56) ^ scrollDefaultDelay);
                                    int i117 = ~((i116 & iMediaBrowserCompatItemReceiver3) | (i116 ^ iMediaBrowserCompatItemReceiver3));
                                    int i118 = ~((i113 ^ 55) | (i113 & 55));
                                    byte b3 = (byte) (i115 + (((i117 & i118) | (i117 ^ i118)) * 470));
                                    int iLastIndexOf = TextUtils.lastIndexOf("", '0');
                                    int i119 = iLastIndexOf * 624;
                                    int i120 = ((-35) ^ iLastIndexOf) | ((-35) & iLastIndexOf);
                                    int i121 = (i119 & (-21148)) + (i119 | (-21148)) + ((~((i120 ^ i) | (i120 & i))) * 623);
                                    int i122 = ~i;
                                    int i123 = ~iLastIndexOf;
                                    int i124 = i121 + (((~((i123 & 34) | (i123 ^ 34))) | i122) * (-623));
                                    int i125 = (~((-35) | i)) | (~i120);
                                    int i126 = ~((iLastIndexOf & i) | (iLastIndexOf ^ i));
                                    int i127 = i125 ^ i126;
                                    Object[] objArr15 = new Object[1];
                                    b(b3, (i124 - (~(((i126 & i125) | i127) * 623))) - 1, new char[]{20, 11, 23, 14, CharUtils.CR, 31, 22, '*', 17, 7, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\"', '\t', '$', '*', 15, '\f', 1, '+', 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, 4, 16, 11, 20, 2, CoreConstants.PERCENT_CHAR, 13855}, objArr15);
                                    Class<?> cls3 = Class.forName((String) objArr15[0]);
                                    int i128 = -View.resolveSize(0, 0);
                                    int iMediaBrowserCompatItemReceiver4 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                    int i129 = i128 * (-520);
                                    int i130 = (i129 ^ 59508) + ((i129 & 59508) << 1);
                                    int i131 = ~i128;
                                    int i132 = i131 | 114;
                                    int i133 = (i130 - (~(-(-((~((i132 & iMediaBrowserCompatItemReceiver4) | (i132 ^ iMediaBrowserCompatItemReceiver4))) * 521))))) - 1;
                                    int i134 = (~((-115) | i128)) * (-1042);
                                    int i135 = (i133 ^ i134) + ((i134 & i133) << 1);
                                    int i136 = ~(i128 | (-115));
                                    int i137 = ~iMediaBrowserCompatItemReceiver4;
                                    int i138 = (i137 & i131) | (i131 ^ i137);
                                    int i139 = ~((i138 & 114) | (i138 ^ 114));
                                    int i140 = ((i136 & i139) | (i136 ^ i139)) * 521;
                                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
                                    int i141 = bitsPerPixel * (-183);
                                    int i142 = (i141 & 2775) + (i141 | 2775);
                                    int i143 = ~bitsPerPixel;
                                    int i144 = -(-(((i143 & 15) | (i143 ^ 15)) * (-368)));
                                    int i145 = ((i142 | i144) << 1) - (i144 ^ i142);
                                    int i146 = bitsPerPixel | (-16);
                                    int i147 = i145 + (((i146 & i122) | (i146 ^ i122)) * SyslogConstants.LOG_LOCAL7);
                                    int i148 = ~bitsPerPixel;
                                    int i149 = ~((i148 & (-16)) | (i148 ^ (-16)));
                                    int i150 = ~(i41 | bitsPerPixel);
                                    int i151 = (i149 & i150) | (i149 ^ i150);
                                    int i152 = ~((bitsPerPixel & 15) | (bitsPerPixel ^ 15));
                                    int i153 = i151 ^ i152;
                                    Object[] objArr16 = new Object[1];
                                    b((byte) ((i135 & i140) + (i140 | i135)), i147 + (((i151 & i152) | i153) * SyslogConstants.LOG_LOCAL7), new char[]{2, CoreConstants.PERCENT_CHAR, '$', CoreConstants.PERCENT_CHAR, 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, '\"', '\n', 3, '\b'}, objArr16);
                                    Object objInvoke3 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke2, objArr14);
                                    int i154 = -ExpandableListView.getPackedPositionChild(0L);
                                    int iMediaBrowserCompatItemReceiver5 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                    int i155 = i154 * 367;
                                    int i156 = (i155 & 45508) + (i155 | 45508);
                                    int i157 = artificialFrame;
                                    int i158 = ((i157 | 81) << 1) - (i157 ^ 81);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i158 % 128;
                                    int i159 = i158 % 2;
                                    int i160 = (-366) * ((i154 ^ 124) | (i154 & 124));
                                    int i161 = ((i156 | i160) << 1) - (i160 ^ i156);
                                    int i162 = ((~((-125) | iMediaBrowserCompatItemReceiver5)) | i154) * (-366);
                                    int i163 = (i161 ^ i162) + ((i161 & i162) << 1);
                                    int i164 = ~i154;
                                    int i165 = ~((i164 & 124) | (i164 ^ 124));
                                    int i166 = (i154 & (-125)) | ((-125) ^ i154);
                                    int i167 = ~((i166 & iMediaBrowserCompatItemReceiver5) | (i166 ^ iMediaBrowserCompatItemReceiver5));
                                    int i168 = ((i167 & i165) | (i165 ^ i167)) * 366;
                                    byte b4 = (byte) (((i163 | i168) << 1) - (i168 ^ i163));
                                    int i169 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                    int iMediaBrowserCompatItemReceiver6 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                    int i170 = ~i169;
                                    int i171 = ~(iMediaBrowserCompatItemReceiver6 | 29);
                                    int i172 = (((i169 * (-109)) + 3219) - (~(-(-(((i171 & i170) | (i170 ^ i171)) * (-220)))))) - 1;
                                    int i173 = ((~((iMediaBrowserCompatItemReceiver6 & 29) | (iMediaBrowserCompatItemReceiver6 ^ 29))) | (~(i169 | 29))) * 220;
                                    int i174 = ((i172 | i173) << 1) - (i173 ^ i172);
                                    int i175 = ~(i170 | 29);
                                    int i176 = ~(i169 | (-30));
                                    int i177 = i175 ^ i176;
                                    Object[] objArr17 = new Object[1];
                                    b(b4, (i174 - (~(((i176 & i175) | i177) * b.f39n))) - 1, new char[]{20, 11, 23, 14, CharUtils.CR, 31, 22, '*', 17, 7, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\"', '\t', '$', '*', 15, '\f', 1, '+', 19, 15, '.', 25, 2, CoreConstants.PERCENT_CHAR, '\"', '\n', 3, '\b'}, objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    int offsetBefore = TextUtils.getOffsetBefore("", 0);
                                    int i178 = offsetBefore * 236;
                                    int i179 = (i178 ^ 56520) + ((i178 & 56520) << 1);
                                    int i180 = ~offsetBefore;
                                    int i181 = -(-(((~((i180 ^ i41) | (i180 & i41))) | SyslogConstants.LOG_CLOCK) * (-235)));
                                    int i182 = (i179 & i181) + (i181 | i179);
                                    int i183 = ~offsetBefore;
                                    int i184 = ~((i183 & i) | (i183 ^ i));
                                    int i185 = i182 + (((i184 & SyslogConstants.LOG_CLOCK) | (i184 ^ SyslogConstants.LOG_CLOCK)) * (-470));
                                    int i186 = ~((offsetBefore & (-121)) | ((-121) ^ offsetBefore));
                                    int i187 = (i180 & SyslogConstants.LOG_CLOCK) | (i180 ^ SyslogConstants.LOG_CLOCK);
                                    int i188 = ~((i187 & i) | (i187 ^ i));
                                    int i189 = ((i188 & i186) | (i186 ^ i188)) * 235;
                                    Object[] objArr18 = new Object[1];
                                    b((byte) ((i185 & i189) + (i189 | i185)), 9 - (~TextUtils.getCapsMode("", 0, 0)), new char[]{CharUtils.CR, ' ', '0', '\t', 14, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.PERCENT_CHAR, 17, ' ', '\t'}, objArr18);
                                    Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke3);
                                    int length = objArr19.length;
                                    int i190 = 0;
                                    while (i190 < length) {
                                        Object obj = objArr19[i190];
                                        int i191 = -ExpandableListView.getPackedPositionType(0L);
                                        int i192 = i191 * 465;
                                        int i193 = ((i192 | (-2315)) << i9) - (i192 ^ (-2315));
                                        int i194 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i195 = ((i194 | 89) << i9) - (i194 ^ 89);
                                        int i196 = i195 % 128;
                                        artificialFrame = i196;
                                        int i197 = i195 % i7;
                                        int i198 = ~(((-6) ^ i122) | ((-6) & i122));
                                        int i199 = ~(((-6) ^ i191) | ((-6) & i191));
                                        int i200 = (i198 ^ i199) | (i199 & i198);
                                        int i201 = ~((i41 ^ i191) | (i41 & i191));
                                        int i202 = i193 + (((i200 ^ i201) | (i200 & i201)) * 464);
                                        int i203 = ((i196 | 25) << i9) - (i196 ^ 25);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i203 % 128;
                                        if (i203 % i7 != 0) {
                                            int i204 = ~i191;
                                            i6 = i202 / ((-464) % (((i204 & i) | (i ^ i204)) | (-6)));
                                        } else {
                                            int i205 = ~i191;
                                            int i206 = (i205 & i) | (i ^ i205);
                                            i6 = (i202 - (~(-(-(((i206 & (-6)) | (i206 ^ (-6))) * (-464)))))) - i9;
                                        }
                                        int i207 = ~(((-6) & i191) | ((-6) ^ i191));
                                        int i208 = ~((i191 & i) | (i191 ^ i));
                                        int i209 = i207 ^ i208;
                                        Object[] objArr20 = new Object[i9];
                                        a(i6 + (464 * ((i207 & i208) | i209)), new int[]{-336571360, 1874977832, 1255667235, 1045272247}, objArr20);
                                        String str4 = (String) objArr20[0];
                                        int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i211 = (i210 ^ 101) + ((i210 & 101) << i9);
                                        artificialFrame = i211 % 128;
                                        int i212 = i211 % i7;
                                        try {
                                            Object[] objArr21 = {str4};
                                            int offsetAfter = TextUtils.getOffsetAfter("", 0);
                                            int iMediaBrowserCompatItemReceiver7 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                            int i213 = offsetAfter * (-813);
                                            int i214 = (offsetAfter ^ iMediaBrowserCompatItemReceiver7) | (offsetAfter & iMediaBrowserCompatItemReceiver7);
                                            int i215 = ((((i213 | 18768) << i9) - (i213 ^ 18768)) - (~(((~i214) | (~(((-47) & offsetAfter) | ((-47) ^ offsetAfter)))) * (-814)))) - i9;
                                            int i216 = ~((-47) | (~iMediaBrowserCompatItemReceiver7));
                                            int i217 = ~offsetAfter;
                                            int i218 = (i217 ^ 46) | (i217 & 46);
                                            int i219 = ~i218;
                                            int i220 = (i216 ^ i219) | (i216 & i219);
                                            int i221 = ~i214;
                                            int i222 = -(-(((i220 & i221) | (i220 ^ i221)) * 407));
                                            int i223 = (i215 & i222) + (i222 | i215);
                                            int i224 = ((~i218) | (~((i217 & iMediaBrowserCompatItemReceiver7) | (i217 ^ iMediaBrowserCompatItemReceiver7))) | (~((iMediaBrowserCompatItemReceiver7 ^ 46) | (iMediaBrowserCompatItemReceiver7 & 46)))) * 407;
                                            byte b5 = (byte) ((i223 ^ i224) + ((i224 & i223) << 1));
                                            int gidForName = Process.getGidForName("");
                                            int iMediaBrowserCompatItemReceiver8 = TSLocation$$ExternalSyntheticApiModelOutline0.MediaBrowserCompatItemReceiver();
                                            int i225 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            int i226 = ((i225 | 63) << 1) - (i225 ^ 63);
                                            artificialFrame = i226 % 128;
                                            int i227 = i226 % 2;
                                            int i228 = (-183) * gidForName;
                                            int i229 = (i228 ^ (-6954)) + ((i228 & (-6954)) << 1);
                                            int i230 = ~gidForName;
                                            int i231 = ~iMediaBrowserCompatItemReceiver8;
                                            int i232 = (i230 ^ i231) | (i230 & i231);
                                            int i233 = ~((i232 ^ 38) | (i232 & 38));
                                            int i234 = ~iMediaBrowserCompatItemReceiver8;
                                            int i235 = (-39) | i234;
                                            Object[] objArr22 = objArr19;
                                            int i236 = ~((i235 ^ gidForName) | (i235 & gidForName));
                                            int i237 = i229 + (((i233 ^ i236) | (i236 & i233)) * (-184));
                                            int i238 = ~((i230 ^ (-39)) | (i230 & (-39)));
                                            int i239 = ~gidForName;
                                            int i240 = ~((i239 & i231) | (i239 ^ i231));
                                            int i241 = -(-(((i238 & i240) | (i238 ^ i240) | (~(i234 | (-39)))) * SyslogConstants.LOG_LOCAL7));
                                            int i242 = ((i237 | i241) << 1) - (i241 ^ i237);
                                            int i243 = ((gidForName ^ 38) | (gidForName & 38)) * SyslogConstants.LOG_LOCAL7;
                                            int i244 = (i242 ^ i243) + ((i243 & i242) << 1);
                                            Object[] objArr23 = new Object[1];
                                            b(b5, i244, new char[]{11, 14, 11, 19, '.', '\b', 28, 16, CoreConstants.PERCENT_CHAR, 17, 28, CoreConstants.RIGHT_PARENTHESIS_CHAR, 22, 1, 16, 28, 14, CoreConstants.PERCENT_CHAR, '0', 1, CoreConstants.PERCENT_CHAR, 23, CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, 6, 29, 15, 19, CoreConstants.PERCENT_CHAR, 28, 4, 25, 21, '*', '\t', 17, 13841}, objArr23);
                                            Class<?> cls5 = Class.forName((String) objArr23[0]);
                                            int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                            Object[] objArr24 = new Object[1];
                                            a(((jumpTapTimeout | 11) << 1) - (jumpTapTimeout ^ 11), new int[]{-1899270351, 611139918, 1860830863, 1957726880, -331529002, -988206788}, objArr24);
                                            Object objInvoke4 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr21);
                                            try {
                                                int trimmedLength = TextUtils.getTrimmedLength("");
                                                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                                                int i245 = packedPositionChild * 659;
                                                int i246 = (i245 & (-19053)) + (i245 | (-19053));
                                                int i247 = ~packedPositionChild;
                                                int i248 = ~((i247 & 29) | (i247 ^ 29));
                                                int i249 = ((-30) ^ packedPositionChild) | ((-30) & packedPositionChild);
                                                int i250 = ~i249;
                                                int i251 = (i248 ^ i250) | (i250 & i248);
                                                int i252 = ~((packedPositionChild ^ i) | (packedPositionChild & i));
                                                int i253 = (i251 | i252) * (-658);
                                                int i254 = ((i246 | i253) << 1) - (i253 ^ i246);
                                                int i255 = -(-((~((packedPositionChild & (-30)) | ((-30) ^ packedPositionChild))) * 658));
                                                int i256 = (i254 & i255) + (i254 | i255);
                                                int i257 = ~i249;
                                                Object[] objArr25 = new Object[1];
                                                b((byte) (((trimmedLength | 20) << 1) - (trimmedLength ^ 20)), i256 + (((i257 & i252) | (i257 ^ i252)) * 658), new char[]{20, 11, 23, 14, CharUtils.CR, 31, 22, '*', 17, 7, 7, CoreConstants.RIGHT_PARENTHESIS_CHAR, '\"', '\t', '$', '*', 15, '\f', '.', 22, 30, '0', 11, 20, '$', CoreConstants.SINGLE_QUOTE_CHAR, 23, CoreConstants.PERCENT_CHAR}, objArr25);
                                                Class<?> cls6 = Class.forName((String) objArr25[0]);
                                                int i258 = -Color.alpha(0);
                                                Object[] objArr26 = new Object[1];
                                                a((i258 & 11) + (i258 | 11), new int[]{1164945835, 235432811, 1283228510, 2005130417, -189712228, -19782893}, objArr26);
                                                try {
                                                    Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj, null))};
                                                    byte bAxisFromString = (byte) (MotionEvent.axisFromString("") + 47);
                                                    int i259 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                    int i260 = i259 * 55;
                                                    int i261 = (i260 ^ (-3959)) + ((i260 & (-3959)) << 1);
                                                    int i262 = ((~((~i259) | 37)) | (~((i41 ^ 37) | (i41 & 37)))) * (-108);
                                                    int i263 = ((i261 | i262) << 1) - (i262 ^ i261);
                                                    int i264 = ~i259;
                                                    int i265 = (~((i264 & i) | (i264 ^ i))) | (~(((-38) & i259) | ((-38) ^ i259)));
                                                    int i266 = ~((i122 ^ i259) | (i122 & i259));
                                                    int i267 = -(-(((i265 & i266) | (i265 ^ i266)) * 54));
                                                    int i268 = ((i263 | i267) << 1) - (i267 ^ i263);
                                                    int i269 = ~((i259 & (-38)) | ((-38) ^ i259));
                                                    int i270 = -(-(((i269 & i) | (i ^ i269)) * 54));
                                                    Object[] objArr28 = new Object[1];
                                                    b(bAxisFromString, (i268 ^ i270) + ((i270 & i268) << 1), new char[]{11, 14, 11, 19, '.', '\b', 28, 16, CoreConstants.PERCENT_CHAR, 17, 28, CoreConstants.RIGHT_PARENTHESIS_CHAR, 22, 1, 16, 28, 14, CoreConstants.PERCENT_CHAR, '0', 1, CoreConstants.PERCENT_CHAR, 23, CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, 6, 29, 15, 19, CoreConstants.PERCENT_CHAR, 28, 4, 25, 21, '*', '\t', 17, 13841}, objArr28);
                                                    Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                    int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
                                                    int i271 = ~touchSlop;
                                                    int i272 = ~((i271 & (-20)) | (i271 ^ (-20)));
                                                    int i273 = ~((-20) | i);
                                                    int i274 = (i272 & i273) | (i272 ^ i273);
                                                    int i275 = i122 | touchSlop;
                                                    int i276 = ~((i275 & 19) | (i275 ^ 19));
                                                    int i277 = (((touchSlop * 1773) - 16815) - (~(((i274 & i276) | (i274 ^ i276)) * 886))) - 1;
                                                    int i278 = -(-(((~(i41 | 19)) | touchSlop) * (-1772)));
                                                    Object[] objArr29 = new Object[1];
                                                    a((((i277 | i278) << 1) - (i277 ^ i278)) + ((~(touchSlop | i41)) * 886), new int[]{-331878413, -2012913612, -1445671655, -202955508, -24046981, 852495403, -839420045, -1847965006, -464153011, -2144893486}, objArr29);
                                                    Object objInvoke5 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke4, objArr27);
                                                    int length2 = objArr3.length;
                                                    int i279 = 0;
                                                    for (int i280 = 2; i279 < i280; i280 = 2) {
                                                        Object obj2 = objArr3[i279];
                                                        int i281 = artificialFrame;
                                                        int i282 = (i281 ^ 17) + ((i281 & 17) << 1);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i282 % 128;
                                                        int i283 = i282 % 2;
                                                        try {
                                                            int i284 = -Drawable.resolveOpacity(0, 0);
                                                            byte b6 = (byte) ((i284 & b.f40o) + (i284 | b.f40o));
                                                            int i285 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                            int i286 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                                                            int i287 = i286 % 128;
                                                            artificialFrame = i287;
                                                            int i288 = i286 % 2 == 0 ? ((-519) >> i285) / 18235 : (i285 * (-519)) + 18235;
                                                            int i289 = ~i285;
                                                            int i290 = (i289 ^ (-36)) | (i289 & (-36));
                                                            int i291 = ~((i290 ^ i41) | (i290 & i41));
                                                            int i292 = (i287 & 87) + (i287 | 87);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i292 % 128;
                                                            int i293 = i292 % 2;
                                                            int i294 = (i | 35) ^ (-1);
                                                            int i295 = 520 * ((i291 & i294) | (i291 ^ i294));
                                                            int i296 = ((i288 | i295) << 1) - (i295 ^ i288);
                                                            int i297 = ~(((-36) ^ i41) | ((-36) & i41));
                                                            int i298 = i287 + 51;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i298 % 128;
                                                            int i299 = i298 % 2;
                                                            int i300 = ~((i285 ^ i) | (i285 & i));
                                                            int i301 = (-1040) * ((i297 & i300) | (i297 ^ i300));
                                                            int i302 = ((i296 | i301) << 1) - (i296 ^ i301);
                                                            int i303 = ~i285;
                                                            int i304 = ~((i303 & i41) | (i303 ^ i41));
                                                            int i305 = ((i287 | 13) << 1) - (i287 ^ 13);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i305 % 128;
                                                            int i306 = i305 % 2;
                                                            int i307 = ~((i285 & (-36)) | ((-36) ^ i285));
                                                            int i308 = -(-(520 * ((i304 & i307) | (i304 ^ i307) | i300)));
                                                            Object[] objArr30 = new Object[1];
                                                            b(b6, (i302 & i308) + (i308 | i302), new char[]{11, 14, 11, 19, '.', '\b', 28, 16, CoreConstants.PERCENT_CHAR, 17, 28, CoreConstants.RIGHT_PARENTHESIS_CHAR, 22, 1, 16, 28, 14, CoreConstants.PERCENT_CHAR, '.', 1, 18, 31, CharUtils.CR, 2, CoreConstants.PERCENT_CHAR, 23, CoreConstants.RIGHT_PARENTHESIS_CHAR, 28, 6, 29, 15, 19, CoreConstants.PERCENT_CHAR, 28}, objArr30);
                                                            Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                            byte b7 = (byte) (96 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                                                            int i309 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                                            Object[] objArr31 = new Object[1];
                                                            b(b7, (i309 & 24) + (i309 | 24), new char[]{2, CoreConstants.PERCENT_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.DASH_CHAR, '\t', 28, 21, '*', 3, 18, 13833, 13833, CoreConstants.PERCENT_CHAR, 15, CoreConstants.RIGHT_PARENTHESIS_CHAR, 20, 20, 28, 20, 19, 13909}, objArr31);
                                                            if (!(!obj2.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke5, null)))) {
                                                                Object[] objArr32 = {new int[]{i}, new int[]{i ^ 1}, new int[1], null};
                                                                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                                                int i310 = ~iUptimeMillis;
                                                                int i311 = 1222716734 + (((~(11459805 | i310)) | 956366848) * SyslogConstants.LOG_LOCAL7) + ((iUptimeMillis | 662684) * (-184)) + ((~((-967163970) | i310)) * SyslogConstants.LOG_LOCAL7);
                                                                int i312 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i313 = (i312 ^ 27) + ((i312 & 27) << 1);
                                                                artificialFrame = i313 % 128;
                                                                int i314 = i313 % 2;
                                                                int i315 = i311 * (-167);
                                                                int i316 = (((-2672) | i315) << 1) - (i315 ^ (-2672));
                                                                int i317 = ~i311;
                                                                int i318 = ~(((-17) & i317) | ((-17) ^ i317));
                                                                int i319 = ~((i317 ^ i122) | (i317 & i122));
                                                                int i320 = i316 + (((i318 & i319) | (i318 ^ i319)) * 168) + ((~(((-17) & i317) | ((-17) ^ i317) | i)) * 168);
                                                                int i321 = (i312 ^ 39) + ((i312 & 39) << 1);
                                                                artificialFrame = i321 % 128;
                                                                int i322 = i321 % 2;
                                                                int i323 = ~((-17) | i41);
                                                                int i324 = ~((-17) | i311);
                                                                int i325 = (i324 & i323) | (i323 ^ i324);
                                                                int i326 = (i317 & 16) | (i317 ^ 16);
                                                                int i327 = ~((i326 & i) | (i326 ^ i));
                                                                int i328 = -(-((i320 - (~(168 * ((i327 & i325) | (i325 ^ i327))))) - 1));
                                                                int i329 = (i2 & i328) + (i2 | i328);
                                                                int i330 = (i312 ^ 3) + ((i312 & 3) << 1);
                                                                artificialFrame = i330 % 128;
                                                                int i331 = i330 % 2;
                                                                int i332 = i329 << 13;
                                                                int i333 = (i332 | i329) & (~(i329 & i332));
                                                                int i334 = i333 >>> 17;
                                                                int i335 = (i333 | i334) & (~(i333 & i334));
                                                                ((int[]) objArr32[2])[0] = i335 ^ (i335 << 5);
                                                                return objArr32;
                                                            }
                                                            i279++;
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    int i336 = (i190 ^ (-75)) + ((i190 & (-75)) << 1);
                                                    i190 = (i336 ^ 76) + ((i336 & 76) << 1);
                                                    objArr19 = objArr22;
                                                    i7 = 2;
                                                    i9 = 1;
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
            int i337 = artificialFrame + 9;
            int i338 = i337 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i338;
            int i339 = i337 % 2;
            int[] iArr = new int[1];
            int i340 = (i338 & 63) + (i338 | 63);
            int i341 = i340 % 128;
            artificialFrame = i341;
            int i342 = i340 % 2;
            Object[] objArr33 = {new int[]{i}, new int[]{i}, iArr, null};
            int i343 = (-1120881602) + (((~((-43178249) | i)) | 41992192 | (~((-935445527) | i))) * (-880));
            int i344 = (~((-43178249) | (~i))) | 935445526;
            int i345 = ~(i | 43178248);
            int i346 = i343 + ((i344 | i345) * (-880)) + (i345 * 880);
            int i347 = (i346 << 1) - i346;
            int i348 = (i2 ^ i347) + ((i2 & i347) << 1);
            int i349 = i341 + 71;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i349 % 128;
            if (i349 % 2 != 0) {
                int i350 = (i348 >> 42) ^ i348;
                int i351 = i350 % 71;
                i3 = (i350 | i351) & (~(i350 & i351));
            } else {
                int i352 = (i348 << 13) ^ i348;
                i3 = i352 ^ (i352 >>> 17);
            }
            int i353 = i3 << 5;
            iArr[0] = (i3 | i353) & (~(i3 & i353));
            return objArr33;
        }
    }
}
