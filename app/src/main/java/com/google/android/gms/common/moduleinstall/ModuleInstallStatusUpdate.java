package com.google.android.gms.common.moduleinstall;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import app.notifee.core.c$$ExternalSyntheticLambda9;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.asBinder;
import o.extraCallback;

/* JADX INFO: loaded from: classes2.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();
    private final int zaa;
    private final int zab;
    private final Long zac;
    private final Long zad;
    private final int zae;
    private final ProgressInfo zaf;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    public ModuleInstallStatusUpdate(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) @InstallState int i2, @Nullable @SafeParcelable.Param(id = 3) Long l, @Nullable @SafeParcelable.Param(id = 4) Long l2, @SafeParcelable.Param(id = 5) int i3) {
        this.zaa = i;
        this.zab = i2;
        this.zac = l;
        this.zad = l2;
        this.zae = i3;
        this.zaf = (l == null || l2 == null || l2.longValue() == 0) ? null : new ProgressInfo(l.longValue(), l2.longValue());
    }

    public int getErrorCode() {
        return this.zae;
    }

    public int getInstallState() {
        return this.zab;
    }

    public ProgressInfo getProgressInfo() {
        return this.zaf;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeInt(parcel, 2, getInstallState());
        SafeParcelWriter.writeLongObject(parcel, 3, this.zac, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zad, false);
        SafeParcelWriter.writeInt(parcel, 5, getErrorCode());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public static class ProgressInfo {
        private final long zaa;
        private final long zab;
        private static final byte[] $$a = {53, 69, 94, -115};
        private static final int $$b = 112;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] ArtificialStackFrames = {44393, 44361, 44399, 44384, 44402, 44387, 44406, 44368, 44404, 44699, 44334, 44409, 44332, 44354, 44355, 44386, 44385, 44696, 44376, 44345, 44396, 44400, 44371, 44398, 44353, 44336, 44403, 44391, 44397, 44703, 44700, 44405, 44395, 44392, 44702, 44697, 44367, 44390, 44388, 44320, 44356, 44349, 44698, 44408, 44341, 44394, 44389, 44366, 44373};
        private static char coroutineCreation = 39069;
        private static long extraCommand = -5944262491654845511L;

        /* JADX WARN: Code duplicated, block: B:10:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, short r7, int r8) {
            /*
                byte[] r0 = com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate.ProgressInfo.$$a
                int r6 = r6 * 4
                int r6 = r6 + 4
                int r8 = r8 * 2
                int r1 = 1 - r8
                int r7 = r7 + 97
                byte[] r1 = new byte[r1]
                r2 = 0
                int r8 = 0 - r8
                if (r0 != 0) goto L17
                r7 = r6
                r3 = r8
                r4 = r2
                goto L2d
            L17:
                r3 = r2
            L18:
                r5 = r7
                r7 = r6
                r6 = r5
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L28:
                r3 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r5
            L2d:
                int r6 = r6 + 1
                int r3 = -r3
                int r7 = r7 + r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate.ProgressInfo.$$c(int, short, int):java.lang.String");
        }

        ProgressInfo(long j, long j2) {
            Preconditions.checkNotZero(j2);
            this.zaa = j;
            this.zab = j2;
        }

        public long getBytesDownloaded() {
            return this.zaa;
        }

        public long getTotalBytesToDownload() {
            return this.zab;
        }

        private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 11, (char) View.resolveSize(0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1407, 1035473698, false, $$c(b, (byte) (b | Ascii.NAK), b), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 9, (char) Color.blue(0), 249 - TextUtils.getCapsMode("", 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
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
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            int i4 = $11 + 53;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            while (asbinder.d < cArr.length) {
                int i6 = $11 + 75;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.indexOf((CharSequence) "", '0'), (char) Drawable.resolveOpacity(0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 250, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            objArr[0] = new String(cArr2);
        }

        private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2;
            int i4 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            long j = 0;
            int i5 = -1819279892;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i6 = 0;
                while (i6 < length) {
                    int i7 = $11 + 51;
                    $10 = i7 % 128;
                    int i8 = i7 % i3;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i6])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 15;
                            char c = (char) (20489 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int i9 = (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 2147;
                            byte b2 = (byte) 0;
                            byte b3 = b2;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c, i9, 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i6++;
                        int i10 = $10 + 15;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        i3 = 2;
                        j = 0;
                        i5 = -1819279892;
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
                byte b5 = b4;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (20488 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), KeyEvent.getDeadChar(0, 0) + 2148, 216710116, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
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
                    int i12 = $10 + 21;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 + 5);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 46, (char) (58859 - TextUtils.indexOf("", "")), 2464 - TextUtils.indexOf("", "", 0), 276640984, false, $$c(b6, b7, (byte) (b7 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b8 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 23, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), 791 - TextUtils.lastIndexOf("", '0', 0, 0), -834291897, false, $$c(b8, (byte) (b8 | 8), b8), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i14 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i14];
                        } else if (extracallback.b == extracallback.d) {
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
                    extracallback.a += 2;
                    int i19 = $10 + 25;
                    $11 = i19 % 128;
                    int i20 = i19 % 2;
                }
            }
            for (int i21 = 0; i21 < i; i21++) {
                cArr4[i21] = (char) (cArr4[i21] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        public static Object[] accessartificialFrame(Context context, int i, int i2) {
            Object obj;
            int i3;
            char[] cArr;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            Object obj2;
            int i9;
            char[] cArr2;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17 = 2 % 2;
            int i18 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i19 = ((i18 | b.f40o) << 1) - (i18 ^ b.f40o);
            int i20 = i19 % 128;
            artificialFrame = i20;
            int i21 = i19 % 2;
            if (context == null) {
                Object[] objArr = new Object[4];
                int[] iArr = new int[1];
                objArr[0] = iArr;
                int[] iArr2 = new int[1];
                objArr[1] = iArr2;
                int i22 = i20 + 91;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                if (i22 % 2 != 0) {
                    objArr[5] = new int[1];
                } else {
                    objArr[2] = new int[1];
                }
                iArr[0] = i;
                iArr2[0] = i;
                objArr[3] = null;
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i23 = (-1150494274) + (((~((-627779176) | iFreeMemory)) | (-350844600)) * (-318));
                int i24 = ~((-350844600) | iFreeMemory);
                int i25 = ~iFreeMemory;
                int i26 = i23 + ((i24 | (~(904623863 | i25))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(iFreeMemory | 904623863)) | (~((-276844689) | i25))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                int i27 = -(-(i26 * 306));
                int i28 = (i27 & TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS) + (i27 | TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS) + (i2 * 306);
                int i29 = ~(i26 | i2);
                int i30 = ~(i26 | i);
                int i31 = ((i29 & i30) | (i29 ^ i30)) * 305;
                int i32 = ~i2;
                int i33 = ~i;
                int i34 = (((i28 & i31) + (i31 | i28)) - (~(((~((i33 & i26) | (i33 ^ i26))) | i32) * 305))) - 1;
                int i35 = i34 << 13;
                int i36 = (i35 & (~i34)) | ((~i35) & i34);
                int i37 = i36 >>> 17;
                int i38 = (i36 | i37) & (~(i36 & i37));
                int i39 = i38 << 5;
                ((int[]) objArr[2])[0] = (i38 | i39) & (~(i38 & i39));
                return objArr;
            }
            try {
                int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 38;
                char[] cArr3 = {CoreConstants.COMMA_CHAR, 17, 2, 20, CoreConstants.DASH_CHAR, '\b', 25, '/', 3, '!', 5, 1, '\t', '\f', '\t', 17, 29, '\n', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.DASH_CHAR, 13773, 13773, 11, 17, '.', 23, 21, 11, 5, 1, 26, 2, 7, 28, 17, 14};
                int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                Object[] objArr2 = new Object[1];
                a(iIndexOf, cArr3, (byte) ((jumpTapTimeout ^ 35) + ((jumpTapTimeout & 35) << 1)), objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int i40 = -(-(ViewConfiguration.getScrollDefaultDelay() >> 16));
                int i41 = (i40 & 31) + (i40 | 31);
                char[] cArr4 = {19, '*', Typography.amp, 27, 24, CoreConstants.PERCENT_CHAR, 5, 3, 3, '#', CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, '+', 18, '\"', 24, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, Typography.amp, 27, 24, CoreConstants.PERCENT_CHAR, 5, 3, 3, '#', 7, 19, '0', 6, 13829};
                int iLastIndexOf = TextUtils.lastIndexOf("", '0');
                int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i43 = ((i42 | 61) << 1) - (i42 ^ 61);
                artificialFrame = i43 % 128;
                if (i43 % 2 == 0) {
                    Object[] objArr4 = new Object[1];
                    a(i41, cArr4, (byte) (61 << iLastIndexOf), objArr4);
                    obj = objArr4[0];
                } else {
                    Object[] objArr5 = new Object[1];
                    a(i41, cArr4, (byte) ((iLastIndexOf ^ 61) + ((iLastIndexOf & 61) << 1)), objArr5);
                    obj = objArr5[0];
                }
                try {
                    int i44 = 37 - (~(ViewConfiguration.getKeyRepeatDelay() >> 16));
                    char[] cArr5 = {CoreConstants.COMMA_CHAR, 17, 2, 20, CoreConstants.DASH_CHAR, '\b', 25, '/', 3, '!', 5, 1, '\t', '\f', '\t', 17, 29, '\n', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.DASH_CHAR, 13773, 13773, 11, 17, '.', 23, 21, 11, 5, 1, 26, 2, 7, 28, 17, 14};
                    int i45 = -(-KeyEvent.getDeadChar(0, 0));
                    Object[] objArr6 = new Object[1];
                    a(i44, cArr5, (byte) ((i45 ^ 35) + ((i45 & 35) << 1)), objArr6);
                    objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance((String) obj);
                    int iMyTid = Process.myTid() >> 22;
                    int i46 = ~iMyTid;
                    int i47 = ~((i46 ^ (-32)) | (i46 & (-32)));
                    int i48 = ~(((-32) ^ i) | ((-32) & i));
                    int i49 = (((iMyTid * (-575)) - 17825) - (~(-(-(((i47 ^ i48) | (i48 & i47)) * 576))))) - 1;
                    int i50 = ~((i46 ^ 31) | (i46 & 31));
                    int i51 = ~i;
                    int i52 = ((-32) ^ i51) | ((-32) & i51);
                    int i53 = ~((i52 ^ iMyTid) | (i52 & iMyTid));
                    int i54 = i49 + (((i50 ^ i53) | (i50 & i53)) * 576);
                    int i55 = artificialFrame;
                    int i56 = (i55 ^ 35) + ((i55 & 35) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                    if (i56 % 2 != 0) {
                        i3 = (i54 - (~(576 >> (~(i46 | (-32)))))) - 1;
                        cArr = new char[]{20, '#', '+', 27, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, Typography.amp, 27, 24, CoreConstants.PERCENT_CHAR, 5, 3, 3, '#', 7, 19, '0', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 24, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, '/', 17, 29, 13943};
                        i4 = (ExpandableListView.getPackedPositionForGroup(1) > 1L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 1L ? 0 : -1));
                        i5 = (-920) - (~(-(-i4)));
                        i6 = 34;
                        i7 = -27;
                    } else {
                        i3 = (i54 - (~((~((i46 ^ (-32)) | (i46 & (-32)))) * 576))) - 1;
                        cArr = new char[]{20, '#', '+', 27, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, Typography.amp, 27, 24, CoreConstants.PERCENT_CHAR, 5, 3, 3, '#', 7, 19, '0', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 24, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, '/', 17, 29, 13943};
                        i4 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        i5 = i4 * (-919);
                        i6 = 122;
                        i7 = -112118;
                    }
                    int i57 = i7;
                    int i58 = artificialFrame + 37;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
                    if (i58 % 2 != 0) {
                        int i59 = ~i4;
                        int i60 = ~i6;
                        int i61 = ~(i59 | i60 | i);
                        int i62 = i60 | i51;
                        int i63 = ~((i62 & i4) | (i62 ^ i4));
                        i8 = (i5 / i57) % (920 % ((i61 & i63) | (i61 ^ i63)));
                    } else {
                        int i64 = -(-i57);
                        int i65 = (i5 ^ i64) + ((i64 & i5) << 1);
                        int i66 = ~i4;
                        int i67 = ~i6;
                        int i68 = ~(i66 | i67 | i);
                        int i69 = i67 | (~i);
                        i8 = (i65 - (~(-(-((i68 | (~((i69 & i4) | (i69 ^ i4)))) * 920))))) - 1;
                    }
                    int i70 = ~i4;
                    int i71 = ~i6;
                    int i72 = ~((i70 ^ i71) | (i70 & i71));
                    int i73 = ~i4;
                    int i74 = ~i;
                    int i75 = (i8 - (~(920 * ((~((i73 ^ i74) | (i73 & i74))) | i72)))) - 1;
                    int i76 = (~(i73 | i6 | i)) | (~((i70 & i71) | (i70 ^ i71) | i51));
                    int i77 = ~i6;
                    int i78 = ~((i77 & i4) | (i77 ^ i4) | i);
                    int i79 = ((i76 & i78) | (i76 ^ i78)) * 920;
                    Object[] objArr7 = new Object[1];
                    a(i3, cArr, (byte) (((i75 | i79) << 1) - (i79 ^ i75)), objArr7);
                    try {
                        Object[] objArr8 = {(String) objArr7[0]};
                        int i80 = -TextUtils.getCapsMode("", 0, 0);
                        int i81 = ((i80 | 38) << 1) - (i80 ^ 38);
                        char[] cArr6 = {CoreConstants.COMMA_CHAR, 17, 2, 20, CoreConstants.DASH_CHAR, '\b', 25, '/', 3, '!', 5, 1, '\t', '\f', '\t', 17, 29, '\n', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.DASH_CHAR, 13773, 13773, 11, 17, '.', 23, 21, 11, 5, 1, 26, 2, 7, 28, 17, 14};
                        int i82 = artificialFrame + 55;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i82 % 128;
                        int i83 = i82 % 2;
                        int scrollDefaultDelay = ViewConfiguration.getScrollDefaultDelay() >> 16;
                        int i84 = (scrollDefaultDelay * TypedValues.Custom.TYPE_DIMENSION) - 31605;
                        int i85 = ~scrollDefaultDelay;
                        int i86 = i84 + (((~((i85 ^ i) | (i85 & i))) | (~((i74 ^ 35) | (i74 & 35)))) * (-1808));
                        c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                        int i87 = ~((i85 ^ (-36)) | (i85 & (-36)) | i);
                        int i88 = i51 | scrollDefaultDelay;
                        int i89 = ~((i88 & 35) | (i88 ^ 35));
                        int i90 = i86 + (TypedValues.Custom.TYPE_BOOLEAN * ((i87 & i89) | (i87 ^ i89)));
                        int i91 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i92 = (i91 ^ 5) + ((i91 & 5) << 1);
                        artificialFrame = i92 % 128;
                        int i93 = i92 % 2;
                        int i94 = ~(i85 | 35);
                        int i95 = ~(((-36) & i) | ((-36) ^ i));
                        int i96 = -(-(((~((scrollDefaultDelay & i51) | (i51 ^ scrollDefaultDelay))) | (i94 & i95) | (i94 ^ i95)) * TypedValues.Custom.TYPE_BOOLEAN));
                        Object[] objArr9 = new Object[1];
                        a(i81, cArr6, (byte) ((i90 ^ i96) + ((i96 & i90) << 1)), objArr9);
                        objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                        int i97 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i98 = ((i97 | 23) << 1) - (i97 ^ 23);
                        artificialFrame = i98 % 128;
                        int i99 = i98 % 2;
                        try {
                            int deadChar = KeyEvent.getDeadChar(0, 0);
                            int i100 = deadChar * (-1939);
                            int i101 = (i74 ^ 23) | (i74 & 23);
                            int i102 = (i100 & 22333) + (i100 | 22333) + (((~(((-24) & deadChar) | ((-24) ^ deadChar))) | (~i101)) * (-970));
                            int i103 = ~deadChar;
                            int i104 = (~((i103 ^ 23) | (i103 & 23))) * 1940;
                            int i105 = (i102 ^ i104) + ((i104 & i102) << 1);
                            int i106 = ~((i103 & (-24)) | (i103 ^ (-24)));
                            int i107 = ~i101;
                            int i108 = i105 + (((i106 & i107) | (i106 ^ i107)) * 970);
                            char[] cArr7 = {23, 30, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.DASH_CHAR, 17, 6, 3, 22, '\t', CoreConstants.COMMA_CHAR, 25, '\t', 11, 16, 0, 22, '\t', '/', CoreConstants.COMMA_CHAR, 13913};
                            int iGreen = Color.green(0);
                            Object[] objArr10 = new Object[1];
                            a(i108, cArr7, (byte) ((iGreen & 107) + (iGreen | 107)), objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            int i109 = -(ViewConfiguration.getScrollBarSize() >> 8);
                            int iArtificialStackFrames = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                            int i110 = i109 * 303;
                            int i111 = (i110 ^ (-15802801)) + ((i110 & (-15802801)) << 1);
                            int i112 = (~i109) | (~iArtificialStackFrames);
                            int i113 = (i109 ^ 52501) | (i109 & 52501);
                            int i114 = (i111 - (~(-(-(((~((i112 & 52501) | (i112 ^ 52501))) | (~((i113 & iArtificialStackFrames) | (i113 ^ iArtificialStackFrames)))) * (-302)))))) - 1;
                            int i115 = ~i109;
                            int i116 = (~((i115 & 52501) | (i115 ^ 52501) | iArtificialStackFrames)) * (-604);
                            int i117 = ((i114 | i116) << 1) - (i114 ^ i116);
                            int i118 = ((~((i109 & (-52502)) | ((-52502) ^ i109))) | (~((iArtificialStackFrames & 52501) | (iArtificialStackFrames ^ 52501)))) * 302;
                            Object[] objArr11 = new Object[1];
                            b((i117 & i118) + (i118 | i117), new char[]{46033, 32454, 10728, 54489, 34691, 45756, 32163, 10308, 56185, 34414, 45353, 31792, 12068, 55750, 34039, 47080, 25236}, objArr11);
                            Object objInvoke = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                            try {
                                int i119 = -(-TextUtils.indexOf((CharSequence) "", '0'));
                                int i120 = (i119 & 24) + (i119 | 24);
                                char[] cArr8 = {23, 30, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.DASH_CHAR, 17, 6, 3, 22, '\t', CoreConstants.COMMA_CHAR, 25, '\t', 11, 16, 0, 22, '\t', '/', CoreConstants.COMMA_CHAR, 13913};
                                int size = View.MeasureSpec.getSize(0);
                                int i121 = size * 284;
                                int i122 = (i121 ^ (-30174)) + ((i121 & (-30174)) << 1);
                                int i123 = ~size;
                                int i124 = ~(i123 | 107);
                                int i125 = ~((i123 & i) | (i123 ^ i));
                                int i126 = -(-(((i125 & i124) | (i124 ^ i125)) * (-283)));
                                int i127 = (((i122 ^ i126) + ((i126 & i122) << 1)) - (~((~(((-108) ^ size) | ((-108) & size))) * 283))) - 1;
                                int i128 = ~size;
                                int i129 = artificialFrame;
                                int i130 = (i129 & 99) + (i129 | 99);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i130 % 128;
                                int i131 = i130 % 2;
                                int i132 = ((-108) & i128) | (i128 ^ (-108));
                                Object[] objArr12 = new Object[1];
                                a(i120, cArr8, (byte) (i127 + (283 * (~((i132 & i) | (i132 ^ i))))), objArr12);
                                Class<?> cls2 = Class.forName((String) objArr12[0]);
                                int i133 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i134 = ((i133 | 35) << 1) - (i133 ^ 35);
                                artificialFrame = i134 % 128;
                                int i135 = i134 % 2;
                                int i136 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                int i137 = (i136 & 14) + (i136 | 14);
                                char[] cArr9 = {25, '0', '\t', '\b', 19, 2, 30, 18, 25, '0', CoreConstants.COMMA_CHAR, 19, ' ', '*'};
                                int i138 = -(-ImageFormat.getBitsPerPixel(0));
                                Object[] objArr13 = new Object[1];
                                a(i137, cArr9, (byte) ((i138 & 127) + (i138 | 127)), objArr13);
                                Object objInvoke2 = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                                int i139 = artificialFrame;
                                int i140 = (i139 & 123) + (i139 | 123);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
                                int i141 = i140 % 2;
                                try {
                                    Object[] objArr14 = {objInvoke2, 64};
                                    int i142 = -TextUtils.lastIndexOf("", '0', 0);
                                    int i143 = i142 * (-813);
                                    int i144 = (i143 ^ 3023280) + ((i143 & 3023280) << 1);
                                    int i145 = ~(((-7411) & i142) | ((-7411) ^ i142));
                                    int i146 = ~((i142 ^ i) | (i142 & i));
                                    int i147 = (i144 - (~((i145 | i146) * (-814)))) - 1;
                                    int i148 = ~(((-7411) & i74) | ((-7411) ^ i74));
                                    int i149 = ~i142;
                                    int i150 = i148 | (~((i149 ^ 7410) | (i149 & 7410)));
                                    int i151 = ((i150 & i146) | (i150 ^ i146)) * 407;
                                    int i152 = (i147 ^ i151) + ((i151 & i147) << 1);
                                    int i153 = ~((~i142) | 7410);
                                    int i154 = ~((i149 ^ i) | (i149 & i));
                                    int i155 = (i153 & i154) | (i153 ^ i154);
                                    int i156 = ~(i | 7410);
                                    Object[] objArr15 = new Object[1];
                                    b(i152 + (((i155 & i156) | (i155 ^ i156)) * 407), new char[]{46039, 44843, 35380, 58653, 49173, 9056, 7776, 31037, 21581, 46930, 37542, 36275, 59575, 52111, 9864, 421, 31990, 24568, 47758, 38383, 61739, 60474, 53055, 10754, 1305, 24680, 17237, 48758, 39244, 62544, 55211, 12990, 11684}, objArr15);
                                    Class<?> cls3 = Class.forName((String) objArr15[0]);
                                    int i157 = -(KeyEvent.getMaxKeyCode() >> 16);
                                    int iArtificialStackFrames2 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                    int i158 = i157 * 399;
                                    int i159 = (i158 ^ 5586) + ((i158 & 5586) << 1);
                                    int i160 = ~i157;
                                    int i161 = ~((i160 ^ 14) | (i160 & 14));
                                    int i162 = ~(((-15) ^ i157) | ((-15) & i157));
                                    int i163 = (i161 ^ i162) | (i161 & i162);
                                    int i164 = ~((-15) | iArtificialStackFrames2);
                                    int i165 = ((i163 ^ i164) | (i164 & i163)) * 398;
                                    int i166 = (i159 ^ i165) + ((i165 & i159) << 1);
                                    int i167 = -(-((i157 | 14) * (-1194)));
                                    int i168 = (i166 & i167) + (i167 | i166);
                                    int i169 = ~iArtificialStackFrames2;
                                    int i170 = ~((i169 & (-15)) | ((-15) ^ i169));
                                    int i171 = ~((i160 ^ 14) | (i160 & 14));
                                    int i172 = (i170 & i171) | (i170 ^ i171);
                                    int i173 = ~(i157 | (-15));
                                    int i174 = i168 + (((i173 & i172) | (i172 ^ i173)) * 398);
                                    char[] cArr10 = {25, '0', '\t', '\b', 19, 2, 30, 18, 25, '0', 2, 22, CoreConstants.COMMA_CHAR, '\t'};
                                    int i175 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                                    int i176 = i175 * (-167);
                                    int i177 = (i176 ^ (-13193)) + ((i176 & (-13193)) << 1);
                                    int i178 = ~i175;
                                    int i179 = -(-(((~((i178 & (-80)) | (i178 ^ (-80)))) | (~((-80) | i))) * 336));
                                    int i180 = ((i177 | i179) << 1) - (i179 ^ i177);
                                    int i181 = ~(i175 | 79);
                                    int i182 = ~((i175 ^ i) | (i175 & i));
                                    int i183 = -(-(((i181 & i182) | (i181 ^ i182)) * (-168)));
                                    int i184 = (i180 & i183) + (i183 | i180);
                                    int i185 = ~((i175 & i74) | (i74 ^ i175));
                                    int i186 = -(-(((i185 & (-80)) | ((-80) ^ i185)) * 168));
                                    Object[] objArr16 = new Object[1];
                                    a(i174, cArr10, (byte) (((i184 | i186) << 1) - (i186 ^ i184)), objArr16);
                                    Object objInvoke3 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                    int i187 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                    int iArtificialStackFrames3 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                    int i188 = i187 * 714;
                                    int i189 = (i188 & (-20648)) + (i188 | (-20648));
                                    int i190 = ~i187;
                                    int i191 = ~iArtificialStackFrames3;
                                    int i192 = ~((i190 & i191) | (i190 ^ i191));
                                    int i193 = ~i187;
                                    int i194 = ~((i193 & 29) | (i193 ^ 29));
                                    int i195 = (i192 & i194) | (i192 ^ i194);
                                    int i196 = (i187 & (-30)) | ((-30) ^ i187);
                                    int i197 = ~(i196 | iArtificialStackFrames3);
                                    Object[] objArr17 = new Object[1];
                                    a(((i189 - (~(-(-(((i195 & i197) | (i195 ^ i197)) * (-713)))))) - 1) + ((~((i196 & iArtificialStackFrames3) | (i196 ^ iArtificialStackFrames3))) * 1426) + ((~(((-30) & i191) | ((-30) ^ i191))) * 713), new char[]{23, 30, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.DASH_CHAR, 17, 6, 3, 22, '\t', CoreConstants.COMMA_CHAR, 25, '\t', 11, 28, '#', 11, '\b', 19, 2, 30, 18, 25, '0', 2, 22, CoreConstants.COMMA_CHAR, '\t'}, (byte) Color.red(0), objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    Object[] objArr18 = new Object[1];
                                    b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 27673, new char[]{46021, 57286, 27619, 63379, 947, 44991, 15189, 18283, 54043, 32548}, objArr18);
                                    Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke3);
                                    int length = objArr19.length;
                                    int i198 = 0;
                                    while (i198 < length) {
                                        Object obj3 = objArr19[i198];
                                        int iNormalizeMetaState = 5 - KeyEvent.normalizeMetaState(0);
                                        char[] cArr11 = {17, 11, '.', 23, 13779};
                                        int i199 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                        int i200 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i201 = (i200 ^ 107) + ((i200 & 107) << 1);
                                        int i202 = i201 % 128;
                                        artificialFrame = i202;
                                        int i203 = i201 % 2;
                                        int i204 = (i202 ^ 1) + ((i202 & 1) << 1);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i204 % 128;
                                        int i205 = i204 % 2;
                                        int i206 = ~i199;
                                        int i207 = (i199 ^ (-49)) | (i199 & (-49));
                                        int i208 = (((((i199 * (-183)) + 8880) - (~(-(-(((48 ^ i206) | (48 & i206)) * (-368)))))) - 1) - (~(-(-(((i207 ^ i74) | (i207 & i74)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                        int i209 = (~((i206 & (-49)) | (i206 ^ (-49)))) | (~((i74 ^ i199) | (i74 & i199)));
                                        int i210 = i202 + 27;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i210 % 128;
                                        if (i210 % 2 != 0) {
                                            int i211 = ~((i199 & 48) | (i199 ^ 48));
                                            int i212 = -(SyslogConstants.LOG_LOCAL7 >> ((i211 & i209) | (i209 ^ i211)));
                                            Object[] objArr20 = new Object[1];
                                            a(iNormalizeMetaState, cArr11, (byte) (((i208 | i212) << 1) - (i212 ^ i208)), objArr20);
                                            obj2 = objArr20[0];
                                        } else {
                                            int i213 = ~(i199 | 48);
                                            Object[] objArr21 = new Object[1];
                                            a(iNormalizeMetaState, cArr11, (byte) ((i208 - (~(((i213 & i209) | (i209 ^ i213)) * SyslogConstants.LOG_LOCAL7))) - 1), objArr21);
                                            obj2 = objArr21[0];
                                        }
                                        try {
                                            Object[] objArr22 = {(String) obj2};
                                            char mirror = AndroidCharacter.getMirror('0');
                                            int iArtificialStackFrames4 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                            int i214 = (mirror * 65369) - 7864865;
                                            int i215 = ~((~mirror) | (-47096));
                                            int i216 = ~(((-47096) ^ iArtificialStackFrames4) | ((-47096) & iArtificialStackFrames4));
                                            int i217 = ((i215 ^ i216) | (i215 & i216)) * 336;
                                            int i218 = (i214 & i217) + (i214 | i217);
                                            int i219 = ~(47095 | mirror);
                                            int i220 = ~((mirror ^ iArtificialStackFrames4) | (mirror & iArtificialStackFrames4));
                                            int i221 = (i218 - (~(-(-(((i219 ^ i220) | (i219 & i220)) * (-168)))))) - 1;
                                            int i222 = ~iArtificialStackFrames4;
                                            int i223 = ~((i222 & mirror) | (i222 ^ mirror));
                                            int i224 = ((i223 & (-47096)) | ((-47096) ^ i223)) * 168;
                                            Object[] objArr23 = new Object[1];
                                            b((i221 & i224) + (i224 | i221), new char[]{46044, 3056, 50062, 39842, 21252, 11014, 58169, 47812, 29435, 51867, 33369, 23151, 4635, 60003, 41463, 31130, 12724, 35157, 16678, 6416, 53471, 43255, 24728, 14430, 61560, 18448, '#', 57290, 38790, 28600, 10082, 65390, 46901, 3781, 50935, 40593, 22195}, objArr23);
                                            Class<?> cls5 = Class.forName((String) objArr23[0]);
                                            int i225 = -(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                            int i226 = i225 * 624;
                                            int i227 = (i226 ^ (-25949840)) + ((i226 & (-25949840)) << 1);
                                            int i228 = ((-41721) ^ i225) | ((-41721) & i225);
                                            int i229 = (~((i228 & i) | (i228 ^ i))) * 623;
                                            int i230 = (i227 & i229) + (i229 | i227);
                                            int i231 = ~i225;
                                            int i232 = ~((i231 ^ 41720) | (i231 & 41720));
                                            int i233 = (i230 - (~(((i232 & i51) | (i51 ^ i232)) * (-623)))) - 1;
                                            int i234 = ~(((-41721) & i225) | ((-41721) ^ i225));
                                            int i235 = ~(((-41721) & i) | ((-41721) ^ i));
                                            int i236 = ((~((i225 & i) | (i225 ^ i))) | (i235 & i234) | (i234 ^ i235)) * 623;
                                            Object[] objArr24 = new Object[1];
                                            b((i233 ^ i236) + ((i236 & i233) << 1), new char[]{46033, 4388, 63020, 23322, 14340, 40214, 25096, 50966, 42080, 2426, 61045}, objArr24);
                                            Object objInvoke4 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                            try {
                                                Object[] objArr25 = new Object[1];
                                                a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 27, new char[]{23, 30, CoreConstants.SINGLE_QUOTE_CHAR, 3, 3, 1, CoreConstants.DASH_CHAR, 17, 6, 3, 22, '\t', CoreConstants.COMMA_CHAR, 25, '\t', 11, 28, '#', '\b', 24, 6, 21, 30, 23, '\n', 29, 11, 4}, (byte) (58 - (ViewConfiguration.getWindowTouchSlop() >> 8)), objArr25);
                                                Class<?> cls6 = Class.forName((String) objArr25[0]);
                                                int i237 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                int iArtificialStackFrames5 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                int i238 = i237 * (-519);
                                                int i239 = (i238 & 5731) + (i238 | 5731);
                                                int i240 = ~i237;
                                                int i241 = (i240 ^ (-12)) | (i240 & (-12));
                                                Object[] objArr26 = objArr19;
                                                int i242 = ~iArtificialStackFrames5;
                                                int i243 = length;
                                                int i244 = ~((i241 ^ i242) | (i241 & i242));
                                                int i245 = i198;
                                                int i246 = ~(iArtificialStackFrames5 | 11);
                                                int i247 = -(-(((i244 ^ i246) | (i244 & i246)) * 520));
                                                int i248 = (i239 & i247) + (i247 | i239);
                                                int i249 = ~iArtificialStackFrames5;
                                                int i250 = ~(((-12) ^ i249) | (i249 & (-12)));
                                                int i251 = ~((i237 ^ iArtificialStackFrames5) | (i237 & iArtificialStackFrames5));
                                                int i252 = ((i250 ^ i251) | (i250 & i251)) * (-1040);
                                                int i253 = (i248 ^ i252) + ((i252 & i248) << 1);
                                                int i254 = artificialFrame + 107;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i254 % 128;
                                                int i255 = i254 % 2;
                                                int i256 = ~((i242 & i240) | (i240 ^ i242));
                                                if (i255 != 0) {
                                                    int i257 = ~(((-12) & i237) | ((-12) ^ i237));
                                                    int i258 = -(-((i256 & i257) | (i256 ^ i257) | (~(i237 | iArtificialStackFrames5))));
                                                    i9 = i253 >>> ((i258 & 520) + (i258 | 520));
                                                    cArr2 = new char[]{'\t', 1, 7, '\f', 11, '+', 25, 3, 2, 18, 13917};
                                                    i10 = -KeyEvent.keyCodeFromString("");
                                                    i11 = 80;
                                                } else {
                                                    int i259 = ~(((-12) & i237) | ((-12) ^ i237));
                                                    int i260 = (i256 & i259) | (i256 ^ i259);
                                                    int i261 = ~(i237 | iArtificialStackFrames5);
                                                    i9 = (((i260 & i261) | (i260 ^ i261)) * 520) + i253;
                                                    cArr2 = new char[]{'\t', 1, 7, '\f', 11, '+', 25, 3, 2, 18, 13917};
                                                    i10 = -KeyEvent.keyCodeFromString("");
                                                    i11 = 122;
                                                }
                                                int i262 = i10 * 569;
                                                int i263 = -(-(i11 * 569));
                                                int i264 = ((i262 | i263) << 1) - (i262 ^ i263);
                                                int i265 = ~i10;
                                                int i266 = ~i11;
                                                int i267 = ~((i265 ^ i266) | (i265 & i266));
                                                int i268 = ~i10;
                                                Object[] objArr27 = objArr3;
                                                int i269 = artificialFrame;
                                                int i270 = ((i269 | 121) << 1) - (i269 ^ 121);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i270 % 128;
                                                int i271 = i270 % 2;
                                                int i272 = (~((i268 ^ i74) | (i268 & i74))) | i267;
                                                int i273 = ~((i266 ^ i74) | (i266 & i74));
                                                int i274 = -(-((-1136) * ((i272 & i273) | (i272 ^ i273))));
                                                int i275 = (i264 & i274) + (i274 | i264);
                                                int i276 = ~(i268 | i);
                                                int i277 = ~((i266 ^ i) | (i266 & i));
                                                int i278 = (i276 & i277) | (i276 ^ i277);
                                                int i279 = (1336688200 & i51) | (1336688200 ^ i51);
                                                int i280 = (~((i279 & 1999146454) | (i279 ^ 1999146454))) * 433;
                                                int i281 = (1969852412 & i280) + (i280 | 1969852412);
                                                int i282 = ~(((-1999146455) & i) | ((-1999146455) ^ i));
                                                int i283 = i281 + (((1336688200 ^ i282) | (i282 & 1336688200)) * (-433));
                                                int i284 = ~((1336688200 ^ i) | (1336688200 & i));
                                                int i285 = ((i284 ^ 142881288) | (i284 & 142881288)) * 433;
                                                int i286 = (i283 & i285) + (i285 | i283);
                                                int i287 = ~(918550398 | i);
                                                int i288 = (i74 ^ (-279691631)) | (i74 & (-279691631));
                                                int i289 = ~((i288 ^ (-907507291)) | (i288 & (-907507291)));
                                                int i290 = ((i287 ^ i289) | (i287 & i289)) * (-318);
                                                int i291 = (((1030884110 | i290) << 1) - (i290 ^ 1030884110)) + (((~(((-279691631) & i) | ((-279691631) ^ i))) | 11043108) * (-318));
                                                int i292 = ~(279691630 | i);
                                                if (i286 <= (i291 - (~(-(-(((907507290 ^ i292) | (i292 & 907507290)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET))))) - 1) {
                                                    int i293 = i51 | i10;
                                                    int i294 = ~((i293 & i11) | (i293 ^ i11));
                                                    i12 = i275 << ((-568) << ((i278 & i294) | (i278 ^ i294)));
                                                    i13 = (~(i10 | i74)) | (~((i74 ^ i11) | (i74 & i11)));
                                                    i14 = i268;
                                                } else {
                                                    int i295 = (i51 ^ i10) | (i51 & i10);
                                                    int i296 = ~((i295 & i11) | (i295 ^ i11));
                                                    i12 = (i275 - (~(-(-(((i296 & i278) | (i278 ^ i296)) * (-568)))))) - 1;
                                                    int i297 = ~((i74 ^ i10) | (i10 & i74));
                                                    int i298 = ~(i74 | i11);
                                                    i13 = (i297 ^ i298) | (i297 & i298);
                                                    i14 = i265;
                                                }
                                                int i299 = (i14 ^ i266) | (i14 & i266);
                                                int i300 = ~((i299 & i) | (i299 ^ i));
                                                byte b = (byte) (i12 + (568 * ((i300 & i13) | (i13 ^ i300))));
                                                Object[] objArr28 = new Object[1];
                                                a(i9, cArr2, b, objArr28);
                                                try {
                                                    Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr28[0], null).invoke(obj3, null))};
                                                    int threadPriority = Process.getThreadPriority(0);
                                                    int i301 = (threadPriority ^ 20) + ((threadPriority & 20) << 1);
                                                    int i302 = artificialFrame + 15;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i302 % 128;
                                                    int i303 = i302 % 2;
                                                    int i304 = -(i301 >> 6);
                                                    Object[] objArr30 = new Object[1];
                                                    b((47143 ^ i304) + ((i304 & 47143) << 1), new char[]{46044, 3056, 50062, 39842, 21252, 11014, 58169, 47812, 29435, 51867, 33369, 23151, 4635, 60003, 41463, 31130, 12724, 35157, 16678, 6416, 53471, 43255, 24728, 14430, 61560, 18448, '#', 57290, 38790, 28600, 10082, 65390, 46901, 3781, 50935, 40593, 22195}, objArr30);
                                                    Class<?> cls7 = Class.forName((String) objArr30[0]);
                                                    int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration() >> 16;
                                                    int iArtificialStackFrames6 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                    int i305 = (((scrollBarFadeDuration * (-381)) + 4156224) - (~((~scrollBarFadeDuration) * (-191)))) - 1;
                                                    int i306 = ~((iArtificialStackFrames6 ^ 21647) | (iArtificialStackFrames6 & 21647));
                                                    int i307 = ((i306 & scrollBarFadeDuration) | (scrollBarFadeDuration ^ i306)) * 191;
                                                    int i308 = ((i305 | i307) << 1) - (i305 ^ i307);
                                                    int i309 = ~scrollBarFadeDuration;
                                                    int i310 = ~((i309 & 21647) | (i309 ^ 21647));
                                                    int i311 = ~iArtificialStackFrames6;
                                                    int i312 = ~((i311 & 21647) | (i311 ^ 21647));
                                                    Object[] objArr31 = new Object[1];
                                                    b((i308 - (~(-(-(((i310 & i312) | (i310 ^ i312)) * 191))))) - 1, new char[]{46033, 59228, 6854, 20094, 57848, 5404, 18584, 64570, 6029, 19156, 65106, 4583, 17771, 63635, 11277, 18356, 64295, 11965, 16861}, objArr31);
                                                    Object objInvoke5 = cls7.getMethod((String) objArr31[0], InputStream.class).invoke(objInvoke4, objArr29);
                                                    int length2 = objArr27.length;
                                                    for (int i313 = 0; i313 < 2; i313 = ((i313 | 1) << 1) - (i313 ^ 1)) {
                                                        int i314 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.f40o;
                                                        artificialFrame = i314 % 128;
                                                        int i315 = i314 % 2;
                                                        Object obj4 = objArr27[i313];
                                                        try {
                                                            int i316 = -ExpandableListView.getPackedPositionGroup(0L);
                                                            int i317 = ~((~i316) | (-35));
                                                            int i318 = ~i316;
                                                            int i319 = ~((i318 ^ i) | (i318 & i));
                                                            int i320 = (i317 & i319) | (i317 ^ i319);
                                                            int i321 = ~(((-35) & i) | ((-35) ^ i));
                                                            int i322 = (((i316 * 881) + 29954) - (~(-(-(((i320 & i321) | (i320 ^ i321)) * (-880)))))) - 1;
                                                            int i323 = (i318 ^ i51) | (i318 & i51);
                                                            int i324 = artificialFrame + 19;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i324 % 128;
                                                            if (i324 % 2 != 0) {
                                                                int i325 = ~i323;
                                                                int i326 = (i325 & 34) | (i325 ^ 34);
                                                                int i327 = ~((i316 ^ i) | (i316 & i));
                                                                int i328 = -(-((-880) / ((i326 & i327) | (i326 ^ i327))));
                                                                i15 = ((i322 | i328) << 1) - (i322 ^ i328);
                                                            } else {
                                                                int i329 = ~i323;
                                                                int i330 = (i329 & 34) | (i329 ^ 34);
                                                                int i331 = ~(i316 | i);
                                                                i15 = i322 + (((i330 & i331) | (i330 ^ i331)) * (-880));
                                                            }
                                                            int i332 = i15 + (880 * (~((i316 & i) | (i316 ^ i))));
                                                            char[] cArr12 = {CoreConstants.COMMA_CHAR, 17, 2, 20, '\f', 24, '/', 4, ' ', 3, 1, 7, '\f', 11, 4, '/', 1, 11, 11, 17, '.', 23, 20, 15, 4, 11, 7, 1, '#', 2, 2, 19, 11, '+'};
                                                            int i333 = -(-ExpandableListView.getPackedPositionType(0L));
                                                            Object[] objArr32 = new Object[1];
                                                            a(i332, cArr12, (byte) ((i333 ^ 43) + ((i333 & 43) << 1)), objArr32);
                                                            Class<?> cls8 = Class.forName((String) objArr32[0]);
                                                            int i334 = -TextUtils.indexOf((CharSequence) "", '0');
                                                            Object[] objArr33 = new Object[1];
                                                            b((i334 ^ 38916) + ((i334 & 38916) << 1), new char[]{46033, 11222, 33736, 31722, 54231, 19405, 9154, 39920, 29693, 60399, 17372, 15284, 37818, 3015, 58272, 23439, 13199, 43917, 911, 64384, 21410, 52158, 41908}, objArr33);
                                                            if (obj4.equals(cls8.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                Object[] objArr34 = {new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, new int[1], null};
                                                                int i335 = (-1886264024) + (((~((-399888252) | i)) | 578735523) * (-366)) + (((~((-360776281) | i)) | 539623552) * 366);
                                                                int iArtificialStackFrames7 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                                int iArtificialStackFrames8 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                                int i336 = -(-(((1289321564 ^ iArtificialStackFrames8) | (1289321564 & iArtificialStackFrames8)) * (-50)));
                                                                int i337 = (1765798848 & i336) + (i336 | 1765798848);
                                                                int i338 = ~(((-207177813) & iArtificialStackFrames8) | ((-207177813) ^ iArtificialStackFrames8));
                                                                int i339 = ~iArtificialStackFrames8;
                                                                int i340 = ((-779995861) ^ i339) | ((-779995861) & i339);
                                                                int i341 = ~((i340 & 1289321564) | (i340 ^ 1289321564));
                                                                int i342 = ~iArtificialStackFrames8;
                                                                int i343 = (~((i342 & (-779995861)) | ((-779995861) ^ i342))) | 572818048;
                                                                int i344 = ~((1289321564 & i339) | (i339 ^ 1289321564));
                                                                int i345 = i337 + (((i338 & i341) | (i338 ^ i341)) * 50) + (((i343 & i344) | (i343 ^ i344)) * 50);
                                                                int iArtificialStackFrames9 = c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                                int i346 = ((-2654465) | iArtificialStackFrames9) * (-676);
                                                                int i347 = ((1385947006 | i346) << 1) - (i346 ^ 1385947006);
                                                                int i348 = ~iArtificialStackFrames9;
                                                                int i349 = ~((i348 & (-2732435)) | (i348 ^ (-2732435)));
                                                                int i350 = i347 + (((i349 & 2654464) | (2654464 ^ i349)) * 676);
                                                                int i351 = ~iArtificialStackFrames9;
                                                                int i352 = (~((i351 & 1557344926) | (1557344926 ^ i351))) | (-1559999391);
                                                                int i353 = ~((iArtificialStackFrames9 & (-77971)) | ((-77971) ^ iArtificialStackFrames9));
                                                                int i354 = -(-(((i353 & i352) | (i352 ^ i353)) * 676));
                                                                if (i345 <= (i350 & i354) + (i354 | i350)) {
                                                                    i16 = 7200 << ((-448) >> i335);
                                                                } else {
                                                                    int i355 = -(-(i335 * (-448)));
                                                                    i16 = ((7200 | i355) << 1) - (i355 ^ 7200);
                                                                }
                                                                int i356 = ~((-17) | i335);
                                                                int i357 = ~i335;
                                                                c$$ExternalSyntheticLambda9.ArtificialStackFrames();
                                                                int i358 = (i357 & 16) | (i357 ^ 16);
                                                                int i359 = ~((i358 & iArtificialStackFrames7) | (i358 ^ iArtificialStackFrames7));
                                                                int i360 = i16 + (449 * ((i356 & i359) | (i356 ^ i359)));
                                                                int i361 = ~(((-17) & i335) | ((-17) ^ i335));
                                                                int i362 = i360 + (i361 * (-1347));
                                                                int i363 = artificialFrame + 43;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i363 % 128;
                                                                int i364 = i363 % 2;
                                                                int i365 = ~i335;
                                                                int i366 = ~iArtificialStackFrames7;
                                                                int i367 = (i366 & i365) | (i365 ^ i366);
                                                                int i368 = ~((i367 & 16) | (i367 ^ 16));
                                                                int i369 = -(-(449 * ((i368 & i361) | (i361 ^ i368))));
                                                                int i370 = -(-((i362 ^ i369) + ((i369 & i362) << 1)));
                                                                int i371 = (i2 ^ i370) + ((i2 & i370) << 1);
                                                                int i372 = i371 << 13;
                                                                int i373 = (i372 & (~i371)) | ((~i372) & i371);
                                                                int i374 = i373 >>> 17;
                                                                int i375 = (i373 | i374) & (~(i373 & i374));
                                                                int i376 = i375 << 5;
                                                                ((int[]) objArr34[2])[0] = (i375 | i376) & (~(i375 & i376));
                                                                return objArr34;
                                                            }
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    int i377 = i245 + 117;
                                                    i198 = (i377 ^ (-116)) + ((i377 & (-116)) << 1);
                                                    objArr3 = objArr27;
                                                    objArr19 = objArr26;
                                                    length = i243;
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
            int[] iArr3 = new int[1];
            int i378 = artificialFrame;
            int i379 = (i378 & 3) + (i378 | 3);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i379 % 128;
            int i380 = i379 % 2;
            Object[] objArr35 = {new int[]{i}, new int[]{i}, iArr3, null};
            int i381 = ~i;
            int i382 = (-1217413411) + (((~((-105675251) | i381)) | (~(i | 872948524))) * 333) + (((~(i | (-105675251))) | (~(i381 | 872948524))) * 333);
            int i383 = (i382 << 1) - i382;
            int i384 = (i2 & i383) + (i2 | i383);
            int i385 = i384 << 13;
            int i386 = (i385 & (~i384)) | ((~i385) & i384);
            int i387 = i386 ^ (i386 >>> 17);
            int i388 = i387 << 5;
            iArr3[0] = (i387 | i388) & (~(i387 & i388));
            return objArr35;
        }
    }
}
