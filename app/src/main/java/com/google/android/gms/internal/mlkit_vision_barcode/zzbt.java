package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.datepicker.SmoothCalendarLayoutManager;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Random;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public class zzbt extends zzdh {
    final /* synthetic */ zzbv zza;
    private static final byte[] $$c = {125, -90, -45, 56};
    private static final int $$d = 181;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {85, -33, -39, -30, -11, -2, Ascii.FF};
    private static final int $$b = 67;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260894111;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r7, byte r8, short r9) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            int r7 = r7 * 2
            int r7 = 116 - r7
            int r9 = r9 * 3
            int r9 = 1 - r9
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzbt.$$c
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r8 = r9
            r4 = r2
            goto L2d
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L2d:
            int r7 = -r7
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbt.$$e(short, byte, short):java.lang.String");
    }

    zzbt(zzbv zzbvVar) {
        this.zza = zzbvVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r0 = 4 - r6
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzbt.$$a
            int r8 = r8 * 4
            int r8 = r8 + 109
            int r7 = r7 + 4
            byte[] r0 = new byte[r0]
            int r6 = 3 - r6
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r7
            goto L30
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            r4 = r1[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L30:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-3)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbt.b(int, short, int, java.lang.Object[]):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh
    final zzdg zza() {
        return this.zza;
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i5 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 22;
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 1775;
                    byte b = (byte) ($$d & 3);
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(deadChar, modifierMetaStateMask, capsMode, -2069783171, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 37, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 56277), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1259, 711931141, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
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
            int i6 = $10 + 125;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i8 = $11 + 3;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                int i10 = $11 + 45;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(38 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (56277 - Drawable.resolveOpacity(0, 0)), 1258 - TextUtils.indexOf((CharSequence) "", '0'), 711931141, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0b72  */
    /* JADX WARN: Code duplicated, block: B:105:0x0b82  */
    /* JADX WARN: Code duplicated, block: B:107:0x0b8b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0b98  */
    /* JADX WARN: Code duplicated, block: B:86:0x0a1b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0a1d A[Catch: Exception -> 0x0cb0, TRY_LEAVE, TryCatch #1 {Exception -> 0x0cb0, blocks: (B:84:0x091b, B:87:0x0a1d, B:89:0x0a69, B:91:0x0a71, B:94:0x0af5, B:101:0x0b6a, B:111:0x0ca1, B:112:0x0ca7, B:114:0x0ca9, B:115:0x0caf, B:96:0x0b0d, B:98:0x0b2d, B:100:0x0b66, B:88:0x0a27), top: B:127:0x091b, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0a71 A[Catch: Exception -> 0x0cb0, TryCatch #1 {Exception -> 0x0cb0, blocks: (B:84:0x091b, B:87:0x0a1d, B:89:0x0a69, B:91:0x0a71, B:94:0x0af5, B:101:0x0b6a, B:111:0x0ca1, B:112:0x0ca7, B:114:0x0ca9, B:115:0x0caf, B:96:0x0b0d, B:98:0x0b2d, B:100:0x0b66, B:88:0x0a27), top: B:127:0x091b, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0af3  */
    /* JADX WARN: Code duplicated, block: B:94:0x0af5 A[Catch: Exception -> 0x0cb0, TRY_LEAVE, TryCatch #1 {Exception -> 0x0cb0, blocks: (B:84:0x091b, B:87:0x0a1d, B:89:0x0a69, B:91:0x0a71, B:94:0x0af5, B:101:0x0b6a, B:111:0x0ca1, B:112:0x0ca7, B:114:0x0ca9, B:115:0x0caf, B:96:0x0b0d, B:98:0x0b2d, B:100:0x0b66, B:88:0x0a27), top: B:127:0x091b, inners: #0, #4 }] */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        char c;
        Object[] objArr;
        int i3;
        char c2;
        Object[] objArr2;
        CharSequence charSequence;
        String line;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        boolean zEquals2;
        int i4;
        int i5;
        int i6;
        Object[] objArr3;
        char c3;
        char c4;
        int i7;
        int i8;
        String str;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iIndexOf;
        int i15;
        int i16 = 2 % 2;
        try {
            int i17 = 15 - (~(-(ViewConfiguration.getScrollBarSize() >> 8)));
            int iBlue = Color.blue(0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            int i18 = -(TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            int iValidateRelationship = SmoothCalendarLayoutManager.validateRelationship();
            int i19 = i18 * (-501);
            int i20 = (i19 ^ 9557) + ((i19 & 9557) << 1);
            int i21 = -(-(((~((i18 ^ 19) | (i18 & 19))) | (~(((-20) ^ iValidateRelationship) | ((-20) & iValidateRelationship)))) * (-502)));
            int i22 = (i20 ^ i21) + ((i21 & i20) << 1) + ((~((~iValidateRelationship) | (-20) | i18)) * (-502));
            int i23 = ~(iValidateRelationship | (~i18));
            int i24 = -(-(((i23 & (-20)) | ((-20) ^ i23)) * TypedValues.PositionType.TYPE_DRAWPATH));
            Object[] objArr4 = new Object[1];
            a(false, i17, iBlue, (i22 & i24) + (i24 | i22), new char[]{65535, 65532, 15, 1, 1, 65535, '\f', 65501, '\t', '\b', '\b', 65535, 65533, 14, 65535, 65534, 3, CharUtils.CR, 65502}, objArr4);
            int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
            int i25 = (longPressTimeout * 398) - 3168;
            int i26 = ~longPressTimeout;
            int i27 = ~i;
            int i28 = ~((i26 ^ i27) | (i26 & i27));
            int i29 = ~longPressTimeout;
            int i30 = (i29 & 8) | (i29 ^ 8);
            int i31 = ~i30;
            int i32 = (i28 ^ i31) | (i28 & i31);
            int i33 = ~i;
            int i34 = ~((i33 ^ 8) | (i33 & 8));
            int i35 = -(-(((i32 ^ i34) | (i32 & i34)) * (-397)));
            int i36 = (i25 ^ i35) + ((i25 & i35) << 1);
            int i37 = -(-((~((i26 ^ 8) | (i26 & 8))) * (-397)));
            int i38 = (i36 & i37) + (i37 | i36);
            int i39 = ~i30;
            int i40 = (i39 & i) | (i ^ i39);
            int i41 = ~((longPressTimeout & (-9)) | ((-9) ^ longPressTimeout));
            int i42 = -(-(((i41 & i40) | (i40 ^ i41)) * 397));
            int i43 = (i38 & i42) + (i42 | i38);
            int i44 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            int i45 = i44 * (-947);
            int i46 = (i45 & 237250) + (i45 | 237250);
            int i47 = ~i44;
            int i48 = ~((-251) | i);
            int i49 = i46 + (((i47 & i48) | (i47 ^ i48)) * (-948));
            int i50 = (~i44) | (-251);
            int i51 = i49 + ((~((i50 & i27) | (i50 ^ i27))) * (-948));
            int i52 = ((i44 & (-251)) | (i44 ^ (-251))) * 948;
            int i53 = ((i51 | i52) << 1) - (i52 ^ i51);
            int iAlpha = Color.alpha(0);
            int i54 = ~iAlpha;
            int i55 = ~((i54 ^ i33) | (i54 & i33));
            int i56 = ~(((-19) ^ i33) | ((-19) & i33));
            int i57 = (((iAlpha * 868) + 15624) - (~(((i55 ^ i56) | (i56 & i55)) * (-867)))) - 1;
            int i58 = ~((i54 ^ (-19)) | (i54 & (-19)));
            int i59 = ~(i54 | i);
            int i60 = (i58 & i59) | (i58 ^ i59);
            int i61 = ~((-19) | i);
            int i62 = i57 + (((i60 & i61) | (i60 ^ i61)) * (-1734));
            int i63 = ~iAlpha;
            int i64 = (i63 ^ (-19)) | (i63 & (-19));
            int i65 = ~((i64 & i33) | (i64 ^ i33));
            int i66 = (i63 & 18) | (i63 ^ 18);
            int i67 = ~((i66 & i) | (i66 ^ i));
            int i68 = (i67 & i65) | (i65 ^ i67);
            int i69 = (iAlpha & (-19)) | ((-19) ^ iAlpha);
            int i70 = ~((i69 & i) | (i69 ^ i));
            int i71 = ((i68 & i70) | (i68 ^ i70)) * 867;
            Object[] objArr5 = new Object[1];
            a(false, i43, i53, ((i62 | i71) << 1) - (i71 ^ i62), new char[]{65501, 65534, 65531, 14, 0, 0, 65534, 11, 16, 65530, 2, CharUtils.CR, 2, 7, 0, 65503, '\b', 11}, objArr5);
            String[] strArr = {(String) objArr4[0], (String) objArr5[0]};
            int i72 = 0;
            while (true) {
                if (i72 >= 2) {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i73 = (-704675382) + (((-4726801) | i33) * 494) + (((~(956718827 | i33)) | (-944267481)) * 494);
                    int i74 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i75 = ((i74 | 75) << 1) - (i74 ^ 75);
                    int i76 = i75 % 128;
                    artificialFrame = i76;
                    int i77 = i75 % 2;
                    int i78 = i73 * (-112);
                    int i79 = ~i73;
                    int i80 = -(-((~((i79 & i27) | (i79 ^ i27))) * 226));
                    int i81 = (i78 & i80) + (i78 | i80);
                    int i82 = i76 + 67;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i82 % 128;
                    int i83 = i82 % 2;
                    int i84 = ~(((-1) ^ i) | i);
                    int i85 = ~i73;
                    int i86 = ~((i85 ^ i27) | (i85 & i27));
                    int i87 = (-113) * ((i84 & i86) | (i84 ^ i86));
                    int i88 = (i81 & i87) + (i87 | i81);
                    int i89 = (~((i85 & i) | (i85 ^ i))) * 113;
                    int i90 = ((i88 | i89) << 1) - (i88 ^ i89);
                    int iValidateRelationship2 = SmoothCalendarLayoutManager.validateRelationship();
                    int i91 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
                    int i92 = i91 % 128;
                    artificialFrame = i92;
                    if (i91 % 2 == 0) {
                        int i93 = (~i2) | (~iValidateRelationship2);
                        int i94 = ~((i93 & i90) | (i93 ^ i90));
                        int i95 = i90 | i2;
                        int i96 = ~((i95 & iValidateRelationship2) | (i95 ^ iValidateRelationship2));
                        i8 = ((989 >> i90) << ((-987) << i2)) >>> (988 << ((i94 & i96) | (i94 ^ i96)));
                    } else {
                        int i97 = ~i2;
                        int i98 = ~iValidateRelationship2;
                        int i99 = (i97 & i98) | (i97 ^ i98);
                        int i100 = ~((i99 & i90) | (i99 ^ i90));
                        int i101 = (i90 ^ i2) | (i90 & i2);
                        int i102 = ~((i101 & iValidateRelationship2) | (i101 ^ iValidateRelationship2));
                        i8 = (((i90 * 989) + (i2 * (-987))) - (~(((i100 & i102) | (i100 ^ i102)) * 988))) - 1;
                    }
                    int i103 = ~i2;
                    int i104 = (-988) * (i90 | i103);
                    int i105 = (i8 & i104) + (i8 | i104);
                    int i106 = ~i90;
                    int i107 = ~((i106 & i103) | (i106 ^ i103));
                    int i108 = ~((i103 & iValidateRelationship2) | (i103 ^ iValidateRelationship2));
                    int i109 = (i107 & i108) | (i107 ^ i108);
                    int i110 = ~iValidateRelationship2;
                    int i111 = (i110 & i90) | (i110 ^ i90);
                    int i112 = ((i92 | b.f40o) << 1) - (i92 ^ b.f40o);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i112 % 128;
                    int i113 = i112 % 2;
                    int i114 = ~((i111 & i2) | (i111 ^ i2));
                    if (i113 == 0) {
                        int i115 = (i105 - (~(((i114 & i109) | (i109 ^ i114)) * 988))) - 1;
                        int i116 = (i115 << 13) ^ i115;
                        int i117 = i116 >>> 17;
                        int i118 = ((~i116) & i117) | ((~i117) & i116);
                        int i119 = i118 << 5;
                        ((int[]) objArr[2])[0] = ((~i118) & i119) | ((~i119) & i118);
                        break;
                    }
                    int i120 = i105 >> (((i114 & i109) | (i109 ^ i114)) * 988);
                    int i121 = i120 ^ (i120 % 36);
                    int i122 = i121 >>> 63;
                    int i123 = ((~i121) & i122) | ((~i122) & i121);
                    ((int[]) objArr[2])[1] = i123 ^ ((i123 & (-4)) + (i123 | (-4)));
                    break;
                }
                int i124 = artificialFrame;
                int i125 = ((i124 | 53) << 1) - (i124 ^ 53);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i125 % 128;
                if (i125 % 2 != 0) {
                    str = strArr[i72];
                    i9 = -(ViewConfiguration.getScrollDefaultDelay() >> 100);
                    i10 = 5;
                } else {
                    str = strArr[i72];
                    i9 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                    i10 = 4;
                }
                int i126 = i9 * 236;
                int i127 = i10 * 471;
                int iValidateRelationship3 = SmoothCalendarLayoutManager.validateRelationship();
                int i128 = ~iValidateRelationship3;
                int i129 = (((-1627518211) - (~(((i128 ^ (-1606843261)) | (i128 & (-1606843261))) * 1324))) - (~(-(-(((~(((-1203911257) ^ iValidateRelationship3) | ((-1203911257) & iValidateRelationship3))) | (~((-1594127149) | iValidateRelationship3))) * (-1324)))))) - 1;
                int i130 = ((i129 | 281145848) << 1) - (i129 ^ 281145848);
                int i131 = (i33 ^ 203031139) | (203031139 & i33);
                int i132 = ((i131 ^ (-1549696892)) | (i131 & (-1549696892))) * 1444;
                int i133 = ((-996524606) ^ i132) + (((-996524606) & i132) << 1);
                int i134 = (-1549696892) | (~(471474787 | i));
                int i135 = ~((1281253243 ^ i) | (1281253243 & i));
                int i136 = i133 + (((i134 ^ i135) | (i135 & i134)) * (-1444));
                if (i130 > (i136 & 1630064048) + (i136 | 1630064048)) {
                    int i137 = -(-i127);
                    i11 = ((i126 & i137) + (i126 | i137)) >>> ((-235) % ((~((~i9) | i33)) | i10));
                } else {
                    int i138 = ((i126 | i127) << 1) - (i126 ^ i127);
                    int i139 = ~i9;
                    int i140 = ~((i139 & i33) | (i139 ^ i33));
                    int i141 = ((i140 & i10) | (i10 ^ i140)) * (-235);
                    i11 = ((i141 & i138) << 1) + (i138 ^ i141);
                }
                int i142 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                int i143 = i142 % 128;
                artificialFrame = i143;
                if (i142 % 2 == 0) {
                    int i144 = ~i9;
                    i12 = i11 % (((~((i144 & i) | (i144 ^ i))) | i10) * (-470));
                } else {
                    int i145 = ~i9;
                    int i146 = ~((i145 & i) | (i145 ^ i));
                    i12 = i11 + (((i146 & i10) | (i10 ^ i146)) * (-470));
                }
                int i147 = ~i10;
                int i148 = ~((i147 & i9) | (i147 ^ i9));
                int i149 = ~i9;
                int i150 = (i149 & i10) | (i149 ^ i10);
                int i151 = (i143 & 97) + (i143 | 97);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i151 % 128;
                int i152 = i151 % 2;
                int i153 = ~((i150 & i) | (i150 ^ i));
                if (i152 != 0) {
                    i14 = i12 >> (235 >>> ((i153 & i148) | (i148 ^ i153)));
                    i15 = 20;
                    iIndexOf = 30718 / TextUtils.indexOf("", Typography.amp, 0, 1);
                    i13 = 0;
                } else {
                    int i154 = i12 + (235 * ((i153 & i148) | (i148 ^ i153)));
                    i13 = 0;
                    int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    i14 = i154;
                    iIndexOf = (iIndexOf2 & 245) + (iIndexOf2 | 245);
                    i15 = 16;
                }
                Object[] objArr6 = new Object[1];
                a(true, i14, iIndexOf, i15 - KeyEvent.normalizeMetaState(i13), new char[]{18, 4, 14, 1, 7, 21, 2, 5, 65508, 65486, 19, 15, 65486, 4, '\t', 15}, objArr6);
                Class<?> cls = Class.forName((String) objArr6[0]);
                if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue()) {
                    objArr = new Object[]{new int[]{i}, new int[]{(~(i & 1)) & (i | 1)}, new int[1], null};
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i155 = (-519950838) + ((iElapsedRealtime | 345477122) * (-50));
                    int i156 = ~((-76873729) | iElapsedRealtime);
                    int i157 = ~iElapsedRealtime;
                    int i158 = i155 + ((i156 | (~((-556272925) | i157))) * 50) + (((~(i157 | 345477122)) | (~((-633146653) | i157)) | 556272924) * 50);
                    int i159 = -(-(i158 * 971));
                    int i160 = ((-31024) ^ i159) + ((i159 & (-31024)) << 1);
                    int i161 = ~i158;
                    int i162 = ~((i161 & 16) | (i161 ^ 16));
                    int i163 = ~((i27 ^ i158) | (i27 & i158));
                    int i164 = -(-(((i162 & i163) | (i162 ^ i163)) * (-970)));
                    int i165 = (i160 & i164) + (i164 | i160);
                    int i166 = (~(((-17) & i158) | ((-17) ^ i158))) * 1940;
                    int i167 = (i165 ^ i166) + ((i166 & i165) << 1);
                    int i168 = ~i158;
                    int i169 = ~((i168 & (-17)) | ((-17) ^ i168));
                    int i170 = ((i169 & i163) | (i169 ^ i163)) * 970;
                    int i171 = (i2 - (~(-(-(((i167 | i170) << 1) - (i170 ^ i167)))))) - 1;
                    int i172 = i171 ^ (i171 << 13);
                    int i173 = i172 >>> 17;
                    int i174 = ((~i172) & i173) | ((~i173) & i172);
                    int i175 = i174 << 5;
                    ((int[]) objArr[2])[0] = ((~i174) & i175) | ((~i175) & i174);
                    break;
                }
                i72++;
            }
            c = 0;
        } catch (Exception unused) {
            int i176 = ~i;
            Object[] objArr7 = {new int[]{i}, new int[]{(i & (-3)) | (i176 & 2)}, new int[1], null};
            int i177 = 597161214 + ((~(949827546 | i176)) * (-560)) + ((~((-19021829) | i)) * (-560)) + (((~(28796228 | i176)) | 940053146) * 560) + 16;
            int iValidateRelationship4 = SmoothCalendarLayoutManager.validateRelationship();
            int i178 = ((i177 * (-433)) - (~(-(-(i2 * (-216)))))) - 1;
            int i179 = ~i177;
            int i180 = ~iValidateRelationship4;
            int i181 = ~((i180 & i179) | (i179 ^ i180));
            int i182 = ~i2;
            int i183 = ~((i182 ^ iValidateRelationship4) | (i182 & iValidateRelationship4));
            int i184 = -(-(((i181 & i183) | (i181 ^ i183)) * JfifUtil.MARKER_EOI));
            int i185 = ((i178 | i184) << 1) - (i178 ^ i184);
            int i186 = ~((i179 ^ i182) | (i179 & i182));
            int i187 = ~((i179 & iValidateRelationship4) | (i179 ^ iValidateRelationship4));
            int i188 = (i185 - (~(((i186 & i187) | (i186 ^ i187)) * JfifUtil.MARKER_EOI))) - 1;
            int i189 = ~i2;
            int i190 = ~iValidateRelationship4;
            int i191 = ~((i190 & i189) | (i189 ^ i190));
            int i192 = -(-(((i191 & i177) | (i177 ^ i191)) * JfifUtil.MARKER_EOI));
            int i193 = ((i188 | i192) << 1) - (i192 ^ i188);
            int i194 = i193 << 13;
            int i195 = (i194 & (~i193)) | ((~i194) & i193);
            int i196 = i195 >>> 17;
            int i197 = (i195 | i196) & (~(i195 & i196));
            c = 0;
            ((int[]) objArr7[2])[0] = i197 ^ (i197 << 5);
            objArr = objArr7;
        }
        if (i != ((int[]) objArr[1])[c]) {
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int scrollBarSize = 9 - (ViewConfiguration.getScrollBarSize() >> 8);
                char longPressTimeout2 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 64610);
                int mode = View.MeasureSpec.getMode(0) + 1806;
                byte b = (byte) 0;
                byte b2 = (byte) (b - 1);
                Object[] objArr8 = new Object[1];
                b(b, b2, (byte) (b2 + 1), objArr8);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarSize, longPressTimeout2, mode, -1135716921, false, (String) objArr8[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j = -1708791018;
            long j2 = (((long) (-947)) * j) + (((long) 949) * jLongValue);
            long j3 = -948;
            long j4 = -1;
            long j5 = j ^ j4;
            long j6 = jLongValue ^ j4;
            long j7 = i;
            long j8 = j2 + ((j5 | ((j6 | j7) ^ j4)) * j3) + (j3 * (((j7 ^ j4) | (j5 | j6)) ^ j4)) + (((long) 948) * (j6 | j)) + ((long) 2048999052);
            int i198 = ~i;
            int i199 = ((int) (j8 >> 32)) & (1393587336 + (((~(507153857 | i198)) | 1944380268) * (-602)) + (((~(507153857 | i)) | 1640260140 | (~((-203033730) | i198))) * (-301)) + ((~(i198 | 1944380268)) * 301));
            int iNextInt = new Random().nextInt(1623769982);
            if ((i199 | (((int) j8) & ((-1209141018) + (((~((~iNextInt) | 1449859784)) | 12633374) * (-235)) + (((~(1449859784 | iNextInt)) | 12633374) * (-470)) + (((~(iNextInt | 1458298846)) | 4194312) * 235)))) == 1) {
                Object[] objArr9 = {new int[]{i}, new int[]{(i & (-11)) | (i198 & 10)}, new int[1], null};
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i200 = (-872584314) + ((~((~startElapsedRealtime) | 901775261)) * (-116)) + ((899480985 | startElapsedRealtime) * 116) + (((~(startElapsedRealtime | (-79142790))) | 76848513) * 116);
                int iValidateRelationship5 = SmoothCalendarLayoutManager.validateRelationship();
                int i201 = artificialFrame;
                int i202 = (i201 ^ 17) + ((i201 & 17) << 1);
                int i203 = i202 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i203;
                int i204 = i202 % 2;
                int i205 = ((3088 + (193 * i200)) - (~(((~iValidateRelationship5) | (~(((-17) ^ i200) | ((-17) & i200)))) * (-192)))) - 1;
                int i206 = ~i200;
                int i207 = ~((-17) | i206);
                int i208 = ~i200;
                int i209 = ~iValidateRelationship5;
                int i210 = (i207 | (~(i208 | i209))) * (-384);
                int i211 = (i205 & i210) + (i205 | i210);
                int i212 = ~(((-17) & i208) | ((-17) ^ i208) | iValidateRelationship5);
                int i213 = (i203 ^ 27) + ((i203 & 27) << 1);
                int i214 = i213 % 128;
                artificialFrame = i214;
                int i215 = i213 % 2;
                int i216 = i206 | i209;
                int i217 = ~((i216 & 16) | (i216 ^ 16));
                int i218 = (i217 & i212) | (i212 ^ i217);
                int i219 = (i200 & 16) | (16 ^ i200);
                int i220 = ~((iValidateRelationship5 & i219) | (i219 ^ iValidateRelationship5));
                int i221 = -(-(JfifUtil.MARKER_SOFn * ((i220 & i218) | (i218 ^ i220))));
                int i222 = (i211 ^ i221) + ((i221 & i211) << 1);
                i3 = i2;
                int i223 = (i3 ^ i222) + ((i222 & i3) << 1);
                int i224 = i223 << 13;
                int i225 = ((~i223) & i224) | ((~i224) & i223);
                int i226 = i225 >>> 17;
                int i227 = (i225 | i226) & (~(i225 & i226));
                int i228 = i227 << 5;
                ((int[]) objArr9[2])[0] = (i227 | i228) & (~(i227 & i228));
                int i229 = ((i214 | 87) << 1) - (i214 ^ 87);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i229 % 128;
                int i230 = i229 % 2;
                objArr2 = objArr9;
                c2 = 0;
            } else {
                i3 = i2;
                Object[] objArr10 = {new int[]{i}, new int[]{i}, new int[1], null};
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i231 = (((~((-27918529) | iUptimeMillis)) | 536956960) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1443845822 + ((~((~iUptimeMillis) | (-27918529))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
                int i232 = (-1) - (~(-(-(i231 * (-282)))));
                int i233 = ~i231;
                int i234 = (i232 - (~((~i233) * 283))) - 1;
                int i235 = i233 | ((-1) ^ i233);
                int i236 = -(-(i234 + ((~((i235 & i) | (i235 ^ i))) * 283)));
                int i237 = (i3 ^ i236) + ((i236 & i3) << 1);
                int i238 = i237 << 13;
                int i239 = (i238 | i237) & (~(i237 & i238));
                int i240 = i239 ^ (i239 >>> 17);
                int i241 = i240 << 5;
                int i242 = ((~i240) & i241) | ((~i241) & i240);
                c2 = 0;
                ((int[]) objArr10[2])[0] = i242;
                objArr2 = objArr10;
            }
            if (i != ((int[]) objArr2[1])[c2]) {
                SmoothCalendarLayoutManager.validateRelationship();
                int i243 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                artificialFrame = i243 % 128;
                int i244 = i243 % 2;
                return objArr2;
            }
            try {
                charSequence = "";
                try {
                    int i245 = -TextUtils.getCapsMode(charSequence, 0, 0);
                    int i246 = ((i245 | 16) << 1) - (i245 ^ 16);
                    int i247 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    Object[] objArr11 = new Object[1];
                    a(true, i246, ((i247 | 247) << 1) - (i247 ^ 247), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 40, new char[]{18, 65535, 2, 1, 65484, '\t', 2, 11, 15, 2, '\b', 65484, 16, 22, 16, 65484, 15, 2, 0, 65534, 15, 17, 65532, 17, 11, 2, 15, 15, 18, 0, 65484, 4, 11, 6, 0, 65534, 15, 17, 65484, 4}, objArr11);
                    File file3 = new File((String) objArr11[0]);
                    try {
                        if (!(!file3.canRead())) {
                            FileReader fileReader3 = new FileReader(file3);
                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                            try {
                                line = bufferedReader3.readLine();
                                int i248 = -TextUtils.getOffsetBefore(charSequence, 0);
                                int i249 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i250 = ((i249 | 11) << 1) - (i249 ^ 11);
                                artificialFrame = i250 % 128;
                                if (i250 % 2 == 0) {
                                    int i251 = -i248;
                                    i7 = (i251 ^ 370) + ((i251 & 370) << 1);
                                } else {
                                    i7 = i248 * 370;
                                }
                                int i252 = (i7 ^ 370) + ((i7 & 370) << 1);
                                int i253 = ~i;
                                int i254 = ((i248 ^ 1) | (i248 & 1) | i253) * (-369);
                                int i255 = (i252 ^ i254) + ((i252 & i254) << 1);
                                int i256 = ~i248;
                                int i257 = ~((i256 ^ i253) | (i253 & i256));
                                int i258 = ((i257 & 1) | (i257 ^ 1)) * (-369);
                                int i259 = (~((i248 & i) | (i248 ^ i))) | (~((-2) | i248));
                                int i260 = ~((i256 & i198) | (i256 ^ i198) | 1);
                                int i261 = (i255 & i258) + (i258 | i255) + (((i259 & i260) | (i259 ^ i260)) * 369);
                                int i262 = -View.combineMeasuredStates(0, 0);
                                int i263 = (i262 & 259) + (i262 | 259);
                                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L);
                                Object[] objArr12 = new Object[1];
                                a(true, i261, i263, (packedPositionGroup ^ 3) + ((packedPositionGroup & 3) << 1), new char[]{65535, 1, 0}, objArr12);
                                if (line.equals((String) objArr12[0])) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                } else {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                }
                                int i264 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                int i265 = i264 * (-433);
                                int i266 = (i265 & (-3024)) + (i265 | (-3024));
                                int i267 = ~i264;
                                int i268 = ~i;
                                int i269 = ((~(i267 | i268)) | (~(((-15) ^ i) | ((-15) & i)))) * JfifUtil.MARKER_EOI;
                                int i270 = ((i266 | i269) << 1) - (i266 ^ i269);
                                int i271 = ~i264;
                                int i272 = i270 + (((~(i267 | i)) | (~((i271 & (-15)) | (i271 ^ (-15))))) * JfifUtil.MARKER_EOI);
                                int i273 = ~(((-15) & i268) | ((-15) ^ i268));
                                int i274 = -(-(((i264 & i273) | (i264 ^ i273)) * JfifUtil.MARKER_EOI));
                                int i275 = (i272 ^ i274) + ((i274 & i272) << 1);
                                int i276 = -(ViewConfiguration.getTapTimeout() >> 16);
                                int iValidateRelationship6 = SmoothCalendarLayoutManager.validateRelationship();
                                int i277 = (i276 * 236) + 115866;
                                int i278 = ~i276;
                                int i279 = ~iValidateRelationship6;
                                int i280 = ~((i279 & i278) | (i278 ^ i279));
                                int i281 = -(-(((i280 & 246) | (i280 ^ 246)) * (-235)));
                                int i282 = (i277 ^ i281) + ((i277 & i281) << 1);
                                int i283 = ~i276;
                                int i284 = ~((i283 & iValidateRelationship6) | (i283 ^ iValidateRelationship6));
                                int i285 = (i282 - (~(((i284 & 246) | (i284 ^ 246)) * (-470)))) - 1;
                                int i286 = ~((i276 & (-247)) | ((-247) ^ i276));
                                int i287 = (i278 ^ 246) | (i278 & 246);
                                int i288 = ~((iValidateRelationship6 & i287) | (i287 ^ iValidateRelationship6));
                                int i289 = ((i286 & i288) | (i286 ^ i288)) * 235;
                                int i290 = ((i285 | i289) << 1) - (i289 ^ i285);
                                int i291 = -TextUtils.lastIndexOf(charSequence, '0');
                                int iValidateRelationship7 = SmoothCalendarLayoutManager.validateRelationship();
                                int i292 = ~iValidateRelationship7;
                                int i293 = ~((-31) | i292);
                                int i294 = (i291 * 46) + 1380 + (((i293 & i291) | (i291 ^ i293)) * (-90));
                                int i295 = ~(((-31) & iValidateRelationship7) | ((-31) ^ iValidateRelationship7));
                                int i296 = ~((i291 ^ 30) | (i291 & 30));
                                int i297 = ((i295 ^ i296) | (i295 & i296)) * (-45);
                                int i298 = (i294 ^ i297) + ((i294 & i297) << 1);
                                int i299 = ~i291;
                                int i300 = (~((iValidateRelationship7 & i299) | (i299 ^ iValidateRelationship7))) | (-31);
                                Object[] objArr13 = new Object[1];
                                a(false, i275, i290, i298 + (((~(i291 | i292)) | i300) * 45), new char[]{18, 16, 65535, 1, 3, 65533, 3, '\f', 65535, 0, '\n', 3, 2, 65485, 14, 16, CharUtils.CR, 1, 65485, 17, 23, 17, 65485, '\t', 3, 16, '\f', 3, '\n', 65485, 4}, objArr13);
                                file = new File((String) objArr13[0]);
                                if (!file.canRead()) {
                                    fileReader = new FileReader(file);
                                    bufferedReader = new BufferedReader(fileReader);
                                    try {
                                        String line2 = bufferedReader.readLine();
                                        int i301 = -TextUtils.lastIndexOf(charSequence, '0');
                                        int i302 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                        int i303 = (i302 & 197) + (i302 | 197);
                                        int i304 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                                        Object[] objArr14 = new Object[1];
                                        a(true, i301, i303, (i304 ^ 1) + ((i304 & 1) << 1), new char[]{0}, objArr14);
                                        zEquals = line2.equals((String) objArr14[0]);
                                        fileReader.close();
                                        bufferedReader.close();
                                        if (zEquals) {
                                            int i305 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                            int iValidateRelationship8 = SmoothCalendarLayoutManager.validateRelationship();
                                            int i306 = i305 * (-300);
                                            int i307 = (i306 ^ TypedValues.Custom.TYPE_REFERENCE) + ((i306 & TypedValues.Custom.TYPE_REFERENCE) << 1);
                                            int i308 = (i305 ^ 3) | (i305 & 3);
                                            int i309 = i307 + ((~((i308 & iValidateRelationship8) | (i308 ^ iValidateRelationship8))) * (-301));
                                            int i310 = ~(((-4) ^ iValidateRelationship8) | ((-4) & iValidateRelationship8));
                                            int i311 = ~iValidateRelationship8;
                                            int i312 = ~((i311 & i305) | (i311 ^ i305));
                                            int i313 = i309 + (((i310 & i312) | (i310 ^ i312)) * (-301));
                                            int i314 = ~i305;
                                            int i315 = ~((i314 & iValidateRelationship8) | (i314 ^ iValidateRelationship8));
                                            int i316 = ((i315 & (-4)) | ((-4) ^ i315)) * 301;
                                            int i317 = (i313 ^ i316) + ((i316 & i313) << 1);
                                            int i318 = 246 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                                            int i319 = -(ViewConfiguration.getTapTimeout() >> 16);
                                            Object[] objArr15 = new Object[1];
                                            a(true, i317, i318, (i319 ^ 36) + ((i319 & 36) << 1), new char[]{17, 23, 17, 65485, '\f', CharUtils.CR, 65533, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, 19, 0, 3, 2, 65485, '\n', 3, '\f', 16, 3, '\t', 65485}, objArr15);
                                            file2 = new File((String) objArr15[0]);
                                            if (!file2.canRead()) {
                                                fileReader2 = new FileReader(file2);
                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                int i320 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i321 = (i320 ^ 25) + ((i320 & 25) << 1);
                                                artificialFrame = i321 % 128;
                                                int i322 = i321 % 2;
                                                try {
                                                    String line3 = bufferedReader2.readLine();
                                                    float minVolume = AudioTrack.getMinVolume();
                                                    int i323 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i324 = (i323 & 27) + (i323 | 27);
                                                    artificialFrame = i324 % 128;
                                                    int i325 = i324 % 2;
                                                    int i326 = -(minVolume > 0.0f ? 1 : (minVolume == 0.0f ? 0 : -1));
                                                    int i327 = ((1 | i326) << 1) - (i326 ^ 1);
                                                    int i328 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    int i329 = (i328 & 197) + (i328 | 197);
                                                    int i330 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                                    Object[] objArr16 = new Object[1];
                                                    a(true, i327, i329, (i330 & 1) + (i330 | 1), new char[]{0}, objArr16);
                                                    String str2 = (String) objArr16[0];
                                                    int i331 = artificialFrame + 51;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i331 % 128;
                                                    int i332 = i331 % 2;
                                                    zEquals2 = line3.equals(str2);
                                                    fileReader2.close();
                                                    bufferedReader2.close();
                                                    if (zEquals2) {
                                                        int i333 = artificialFrame;
                                                        int i334 = ((i333 | 35) << 1) - (i333 ^ 35);
                                                        i4 = i334 % 128;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i4;
                                                        int i335 = i334 % 2;
                                                        if (line != null) {
                                                            i5 = i4 + 21;
                                                            artificialFrame = i5 % 128;
                                                            if (i5 % 2 == 0) {
                                                                i6 = i ^ 89;
                                                                objArr3 = new Object[]{new int[1], new int[1]};
                                                                c4 = 3;
                                                                c3 = 0;
                                                            } else {
                                                                i6 = (~(i & 20)) & (i | 20);
                                                                objArr3 = new Object[4];
                                                                c3 = 0;
                                                                objArr3[0] = new int[1];
                                                                objArr3[1] = new int[1];
                                                                c4 = 2;
                                                            }
                                                            objArr3[c4] = new int[1];
                                                            ((int[]) objArr3[c3])[c3] = i;
                                                            ((int[]) objArr3[1])[c3] = i6;
                                                            objArr3[3] = line;
                                                            int i336 = (-1267991058) + (((~(1020411061 | i)) | 36537090 | (~((-41787287) | i))) * (-744)) + ((1015160865 | i198) * 744) + (((-36537091) | i) * 744);
                                                            int iValidateRelationship9 = SmoothCalendarLayoutManager.validateRelationship();
                                                            int i337 = (-11888) + (i336 * (-743));
                                                            int i338 = (~(i336 | 16)) | (~((iValidateRelationship9 ^ 16) | (iValidateRelationship9 & 16)));
                                                            int i339 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                                                            artificialFrame = i339 % 128;
                                                            int i340 = i339 % 2;
                                                            int i341 = ~((i336 ^ iValidateRelationship9) | (i336 & iValidateRelationship9));
                                                            int i342 = -(-((-744) * ((i338 & i341) | (i338 ^ i341))));
                                                            int i343 = (i337 ^ i342) + ((i342 & i337) << 1);
                                                            int i344 = ~iValidateRelationship9;
                                                            int i345 = ~i336;
                                                            int i346 = ~((i345 & (-17)) | ((-17) ^ i345));
                                                            int i347 = i343 + (((i344 & i346) | (i344 ^ i346)) * 744);
                                                            int i348 = (16 & i336) | (16 ^ i336);
                                                            int i349 = (i347 - (~(-(-(((iValidateRelationship9 & i348) | (i348 ^ iValidateRelationship9)) * 744))))) - 1;
                                                            int iValidateRelationship10 = SmoothCalendarLayoutManager.validateRelationship();
                                                            int i350 = i349 * 483;
                                                            int i351 = i3 * 242;
                                                            int i352 = (i350 & i351) + (i350 | i351);
                                                            int i353 = ~i349;
                                                            int i354 = ~i3;
                                                            int i355 = ~((i354 & i353) | (i353 ^ i354));
                                                            int i356 = ~iValidateRelationship10;
                                                            int i357 = (i356 & i353) | (i353 ^ i356);
                                                            int i358 = ~i357;
                                                            int i359 = -(-(((i358 & i355) | (i355 ^ i358)) * (-241)));
                                                            int i360 = (((i352 & i359) + (i359 | i352)) - (~(((i349 ^ i3) | (i349 & i3)) * (-482)))) - 1;
                                                            int i361 = ~i3;
                                                            int i362 = ~((i361 & i349) | (i361 ^ i349));
                                                            int i363 = artificialFrame;
                                                            int i364 = (i363 & 5) + (i363 | 5);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i364 % 128;
                                                            int i365 = i364 % 2;
                                                            int i366 = ~((i357 & i3) | (i357 ^ i3));
                                                            int i367 = -(-(241 * ((i366 & i362) | (i362 ^ i366))));
                                                            int i368 = (i360 ^ i367) + ((i367 & i360) << 1);
                                                            int i369 = (i368 << 13) ^ i368;
                                                            int i370 = i369 >>> 17;
                                                            int i371 = ((~i369) & i370) | ((~i370) & i369);
                                                            ((int[]) objArr3[2])[0] = i371 ^ (i371 << 5);
                                                            return objArr3;
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    fileReader2.close();
                                                    bufferedReader2.close();
                                                    throw th;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        fileReader.close();
                                        bufferedReader.close();
                                        throw th2;
                                    }
                                }
                                Object[] objArr17 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int i372 = ~(885405656 | i198);
                                int i373 = (((809505432 | i372) * (-970)) - 388895602) + ((i372 | 75900224) * 970);
                                int i374 = -(-(i373 * (-1917)));
                                int i375 = ~i373;
                                int i376 = ~i;
                                int i377 = ~((i376 & i375) | (i375 ^ i376));
                                int i378 = ~i;
                                int i379 = ((i377 & i378) | (i377 ^ i378)) * 959;
                                int i380 = (i374 ^ i379) + ((i374 & i379) << 1);
                                int i381 = -(-((~i373) * (-959)));
                                int i382 = ((i380 | i381) << 1) - (i381 ^ i380);
                                int i383 = ~(i375 | i);
                                int i384 = ~i198;
                                int i385 = -(-(((i383 & i384) | (i383 ^ i384)) * 959));
                                int i386 = (i382 ^ i385) + ((i385 & i382) << 1);
                                int iValidateRelationship11 = SmoothCalendarLayoutManager.validateRelationship();
                                int i387 = i386 * 370;
                                int i388 = -(-(i3 * 370));
                                int i389 = (i387 & i388) + (i387 | i388);
                                int i390 = ~iValidateRelationship11;
                                int i391 = -(-(((i386 ^ i3) | (i386 & i3) | i390) * (-369)));
                                int i392 = (i389 ^ i391) + ((i391 & i389) << 1);
                                int i393 = ~i386;
                                int i394 = ~((~iValidateRelationship11) | i393);
                                int i395 = artificialFrame + 95;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i395 % 128;
                                int i396 = i395 % 2;
                                int i397 = (-369) * ((i394 & i3) | (i3 ^ i394));
                                int i398 = (i392 & i397) + (i392 | i397);
                                int i399 = ~i3;
                                int i400 = (~((iValidateRelationship11 & i386) | (i386 ^ iValidateRelationship11))) | (~((i399 & i386) | (i399 ^ i386)));
                                int i401 = i393 | i390;
                                int i402 = ~((i401 & i3) | (i401 ^ i3));
                                int i403 = -(-(((i400 & i402) | (i400 ^ i402)) * 369));
                                int i404 = (i398 ^ i403) + ((i403 & i398) << 1);
                                int i405 = i404 << 13;
                                int i406 = (i405 | i404) & (~(i404 & i405));
                                int i407 = i406 >>> 17;
                                int i408 = (i406 | i407) & (~(i406 & i407));
                                int i409 = i408 << 5;
                                ((int[]) objArr17[2])[0] = ((~i408) & i409) | ((~i409) & i408);
                                return objArr17;
                            } catch (Throwable th3) {
                                fileReader3.close();
                                bufferedReader3.close();
                                throw th3;
                            }
                        }
                        int i410 = artificialFrame;
                        int i411 = (i410 & 101) + (i410 | 101);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i411 % 128;
                        int i412 = i411 % 2;
                        int i2610 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        int i2611 = i2610 * (-433);
                        int i2612 = (i2611 & (-3024)) + (i2611 | (-3024));
                        int i2613 = ~i2610;
                        int i2614 = ~i;
                        int i2615 = ((~(i2613 | i2614)) | (~(((-15) ^ i) | ((-15) & i)))) * JfifUtil.MARKER_EOI;
                        int i2710 = ((i2612 | i2615) << 1) - (i2612 ^ i2615);
                        int i2711 = ~i2610;
                        int i2712 = i2710 + (((~(i2613 | i)) | (~((i2711 & (-15)) | (i2711 ^ (-15))))) * JfifUtil.MARKER_EOI);
                        int i2713 = ~(((-15) & i2614) | ((-15) ^ i2614));
                        int i2714 = -(-(((i2610 & i2713) | (i2610 ^ i2713)) * JfifUtil.MARKER_EOI));
                        int i2715 = (i2712 ^ i2714) + ((i2714 & i2712) << 1);
                        int i2716 = -(ViewConfiguration.getTapTimeout() >> 16);
                        int iValidateRelationship12 = SmoothCalendarLayoutManager.validateRelationship();
                        int i2717 = (i2716 * 236) + 115866;
                        int i2718 = ~i2716;
                        int i2719 = ~iValidateRelationship12;
                        int i2810 = ~((i2719 & i2718) | (i2718 ^ i2719));
                        int i2811 = -(-(((i2810 & 246) | (i2810 ^ 246)) * (-235)));
                        int i2812 = (i2717 ^ i2811) + ((i2717 & i2811) << 1);
                        int i2813 = ~i2716;
                        int i2814 = ~((i2813 & iValidateRelationship12) | (i2813 ^ iValidateRelationship12));
                        int i2815 = (i2812 - (~(((i2814 & 246) | (i2814 ^ 246)) * (-470)))) - 1;
                        int i2816 = ~((i2716 & (-247)) | ((-247) ^ i2716));
                        int i2817 = (i2718 ^ 246) | (i2718 & 246);
                        int i2818 = ~((iValidateRelationship12 & i2817) | (i2817 ^ iValidateRelationship12));
                        int i2819 = ((i2816 & i2818) | (i2816 ^ i2818)) * 235;
                        int i2910 = ((i2815 | i2819) << 1) - (i2819 ^ i2815);
                        int i2911 = -TextUtils.lastIndexOf(charSequence, '0');
                        int iValidateRelationship13 = SmoothCalendarLayoutManager.validateRelationship();
                        int i2912 = ~iValidateRelationship13;
                        int i2913 = ~((-31) | i2912);
                        int i2914 = (i2911 * 46) + 1380 + (((i2913 & i2911) | (i2911 ^ i2913)) * (-90));
                        int i2915 = ~(((-31) & iValidateRelationship13) | ((-31) ^ iValidateRelationship13));
                        int i2916 = ~((i2911 ^ 30) | (i2911 & 30));
                        int i2917 = ((i2915 ^ i2916) | (i2915 & i2916)) * (-45);
                        int i2918 = (i2914 ^ i2917) + ((i2914 & i2917) << 1);
                        int i2919 = ~i2911;
                        int i3010 = (~((iValidateRelationship13 & i2919) | (i2919 ^ iValidateRelationship13))) | (-31);
                        Object[] objArr18 = new Object[1];
                        a(false, i2715, i2910, i2918 + (((~(i2911 | i2912)) | i3010) * 45), new char[]{18, 16, 65535, 1, 3, 65533, 3, '\f', 65535, 0, '\n', 3, 2, 65485, 14, 16, CharUtils.CR, 1, 65485, 17, 23, 17, 65485, '\t', 3, 16, '\f', 3, '\n', 65485, 4}, objArr18);
                        file = new File((String) objArr18[0]);
                        if (!file.canRead()) {
                            fileReader = new FileReader(file);
                            bufferedReader = new BufferedReader(fileReader);
                            String line4 = bufferedReader.readLine();
                            int i3011 = -TextUtils.lastIndexOf(charSequence, '0');
                            int i3012 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                            int i3013 = (i3012 & 197) + (i3012 | 197);
                            int i3014 = -(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                            Object[] objArr19 = new Object[1];
                            a(true, i3011, i3013, (i3014 ^ 1) + ((i3014 & 1) << 1), new char[]{0}, objArr19);
                            zEquals = line4.equals((String) objArr19[0]);
                            fileReader.close();
                            bufferedReader.close();
                            if (zEquals) {
                                int i3015 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                int iValidateRelationship14 = SmoothCalendarLayoutManager.validateRelationship();
                                int i3016 = i3015 * (-300);
                                int i3017 = (i3016 ^ TypedValues.Custom.TYPE_REFERENCE) + ((i3016 & TypedValues.Custom.TYPE_REFERENCE) << 1);
                                int i3018 = (i3015 ^ 3) | (i3015 & 3);
                                int i3019 = i3017 + ((~((i3018 & iValidateRelationship14) | (i3018 ^ iValidateRelationship14))) * (-301));
                                int i3110 = ~(((-4) ^ iValidateRelationship14) | ((-4) & iValidateRelationship14));
                                int i3111 = ~iValidateRelationship14;
                                int i3112 = ~((i3111 & i3015) | (i3111 ^ i3015));
                                int i3113 = i3019 + (((i3110 & i3112) | (i3110 ^ i3112)) * (-301));
                                int i3114 = ~i3015;
                                int i3115 = ~((i3114 & iValidateRelationship14) | (i3114 ^ iValidateRelationship14));
                                int i3116 = ((i3115 & (-4)) | ((-4) ^ i3115)) * 301;
                                int i3117 = (i3113 ^ i3116) + ((i3116 & i3113) << 1);
                                int i3118 = 246 - (~(-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                                int i3119 = -(ViewConfiguration.getTapTimeout() >> 16);
                                Object[] objArr110 = new Object[1];
                                a(true, i3117, i3118, (i3119 ^ 36) + ((i3119 & 36) << 1), new char[]{17, 23, 17, 65485, '\f', CharUtils.CR, 65533, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, '\f', 7, 1, 65535, 16, 18, 65485, 5, 19, 0, 3, 2, 65485, '\n', 3, '\f', 16, 3, '\t', 65485}, objArr110);
                                file2 = new File((String) objArr110[0]);
                                if (!file2.canRead()) {
                                    fileReader2 = new FileReader(file2);
                                    bufferedReader2 = new BufferedReader(fileReader2);
                                    int i3210 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i3211 = (i3210 ^ 25) + ((i3210 & 25) << 1);
                                    artificialFrame = i3211 % 128;
                                    int i3212 = i3211 % 2;
                                    String line5 = bufferedReader2.readLine();
                                    float minVolume2 = AudioTrack.getMinVolume();
                                    int i3213 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i3214 = (i3213 & 27) + (i3213 | 27);
                                    artificialFrame = i3214 % 128;
                                    int i3215 = i3214 % 2;
                                    int i3216 = -(minVolume2 > 0.0f ? 1 : (minVolume2 == 0.0f ? 0 : -1));
                                    int i3217 = ((1 | i3216) << 1) - (i3216 ^ 1);
                                    int i3218 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                    int i3219 = (i3218 & 197) + (i3218 | 197);
                                    int i3310 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                    Object[] objArr111 = new Object[1];
                                    a(true, i3217, i3219, (i3310 & 1) + (i3310 | 1), new char[]{0}, objArr111);
                                    String str3 = (String) objArr111[0];
                                    int i3311 = artificialFrame + 51;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3311 % 128;
                                    int i3312 = i3311 % 2;
                                    zEquals2 = line5.equals(str3);
                                    fileReader2.close();
                                    bufferedReader2.close();
                                    if (zEquals2) {
                                        int i3313 = artificialFrame;
                                        int i3314 = ((i3313 | 35) << 1) - (i3313 ^ 35);
                                        i4 = i3314 % 128;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i4;
                                        int i3315 = i3314 % 2;
                                        if (line != null) {
                                            i5 = i4 + 21;
                                            artificialFrame = i5 % 128;
                                            if (i5 % 2 == 0) {
                                                i6 = i ^ 89;
                                                objArr3 = new Object[]{new int[1], new int[1]};
                                                c4 = 3;
                                                c3 = 0;
                                            } else {
                                                i6 = (~(i & 20)) & (i | 20);
                                                objArr3 = new Object[4];
                                                c3 = 0;
                                                objArr3[0] = new int[1];
                                                objArr3[1] = new int[1];
                                                c4 = 2;
                                            }
                                            objArr3[c4] = new int[1];
                                            ((int[]) objArr3[c3])[c3] = i;
                                            ((int[]) objArr3[1])[c3] = i6;
                                            objArr3[3] = line;
                                            int i3316 = (-1267991058) + (((~(1020411061 | i)) | 36537090 | (~((-41787287) | i))) * (-744)) + ((1015160865 | i198) * 744) + (((-36537091) | i) * 744);
                                            int iValidateRelationship15 = SmoothCalendarLayoutManager.validateRelationship();
                                            int i3317 = (-11888) + (i3316 * (-743));
                                            int i3318 = (~(i3316 | 16)) | (~((iValidateRelationship15 ^ 16) | (iValidateRelationship15 & 16)));
                                            int i3319 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                                            artificialFrame = i3319 % 128;
                                            int i3410 = i3319 % 2;
                                            int i3411 = ~((i3316 ^ iValidateRelationship15) | (i3316 & iValidateRelationship15));
                                            int i3412 = -(-((-744) * ((i3318 & i3411) | (i3318 ^ i3411))));
                                            int i3413 = (i3317 ^ i3412) + ((i3412 & i3317) << 1);
                                            int i3414 = ~iValidateRelationship15;
                                            int i3415 = ~i3316;
                                            int i3416 = ~((i3415 & (-17)) | ((-17) ^ i3415));
                                            int i3417 = i3413 + (((i3414 & i3416) | (i3414 ^ i3416)) * 744);
                                            int i3418 = (16 & i3316) | (16 ^ i3316);
                                            int i3419 = (i3417 - (~(-(-(((iValidateRelationship15 & i3418) | (i3418 ^ iValidateRelationship15)) * 744))))) - 1;
                                            int iValidateRelationship16 = SmoothCalendarLayoutManager.validateRelationship();
                                            int i3510 = i3419 * 483;
                                            int i3511 = i3 * 242;
                                            int i3512 = (i3510 & i3511) + (i3510 | i3511);
                                            int i3513 = ~i3419;
                                            int i3514 = ~i3;
                                            int i3515 = ~((i3514 & i3513) | (i3513 ^ i3514));
                                            int i3516 = ~iValidateRelationship16;
                                            int i3517 = (i3516 & i3513) | (i3513 ^ i3516);
                                            int i3518 = ~i3517;
                                            int i3519 = -(-(((i3518 & i3515) | (i3515 ^ i3518)) * (-241)));
                                            int i3610 = (((i3512 & i3519) + (i3519 | i3512)) - (~(((i3419 ^ i3) | (i3419 & i3)) * (-482)))) - 1;
                                            int i3611 = ~i3;
                                            int i3612 = ~((i3611 & i3419) | (i3611 ^ i3419));
                                            int i3613 = artificialFrame;
                                            int i3614 = (i3613 & 5) + (i3613 | 5);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3614 % 128;
                                            int i3615 = i3614 % 2;
                                            int i3616 = ~((i3517 & i3) | (i3517 ^ i3));
                                            int i3617 = -(-(241 * ((i3616 & i3612) | (i3612 ^ i3616))));
                                            int i3618 = (i3610 ^ i3617) + ((i3617 & i3610) << 1);
                                            int i3619 = (i3618 << 13) ^ i3618;
                                            int i3710 = i3619 >>> 17;
                                            int i3711 = ((~i3619) & i3710) | ((~i3710) & i3619);
                                            ((int[]) objArr3[2])[0] = i3711 ^ (i3711 << 5);
                                            return objArr3;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                charSequence = "";
            }
            line = null;
            Object[] objArr112 = {new int[]{i}, new int[]{i}, new int[1], null};
            int i3712 = ~(885405656 | i198);
            int i3713 = (((809505432 | i3712) * (-970)) - 388895602) + ((i3712 | 75900224) * 970);
            int i3714 = -(-(i3713 * (-1917)));
            int i3715 = ~i3713;
            int i3716 = ~i;
            int i3717 = ~((i3716 & i3715) | (i3715 ^ i3716));
            int i3718 = ~i;
            int i3719 = ((i3717 & i3718) | (i3717 ^ i3718)) * 959;
            int i3810 = (i3714 ^ i3719) + ((i3714 & i3719) << 1);
            int i3811 = -(-((~i3713) * (-959)));
            int i3812 = ((i3810 | i3811) << 1) - (i3811 ^ i3810);
            int i3813 = ~(i3715 | i);
            int i3814 = ~i198;
            int i3815 = -(-(((i3813 & i3814) | (i3813 ^ i3814)) * 959));
            int i3816 = (i3812 ^ i3815) + ((i3815 & i3812) << 1);
            int iValidateRelationship17 = SmoothCalendarLayoutManager.validateRelationship();
            int i3817 = i3816 * 370;
            int i3818 = -(-(i3 * 370));
            int i3819 = (i3817 & i3818) + (i3817 | i3818);
            int i3910 = ~iValidateRelationship17;
            int i3911 = -(-(((i3816 ^ i3) | (i3816 & i3) | i3910) * (-369)));
            int i3912 = (i3819 ^ i3911) + ((i3911 & i3819) << 1);
            int i3913 = ~i3816;
            int i3914 = ~((~iValidateRelationship17) | i3913);
            int i3915 = artificialFrame + 95;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3915 % 128;
            int i3916 = i3915 % 2;
            int i3917 = (-369) * ((i3914 & i3) | (i3 ^ i3914));
            int i3918 = (i3912 & i3917) + (i3912 | i3917);
            int i3919 = ~i3;
            int i4010 = (~((iValidateRelationship17 & i3816) | (i3816 ^ iValidateRelationship17))) | (~((i3919 & i3816) | (i3919 ^ i3816)));
            int i4011 = i3913 | i3910;
            int i4012 = ~((i4011 & i3) | (i4011 ^ i3));
            int i4013 = -(-(((i4010 & i4012) | (i4010 ^ i4012)) * 369));
            int i4014 = (i3918 ^ i4013) + ((i4013 & i3918) << 1);
            int i4015 = i4014 << 13;
            int i4016 = (i4015 | i4014) & (~(i4014 & i4015));
            int i4017 = i4016 >>> 17;
            int i4018 = (i4016 | i4017) & (~(i4016 & i4017));
            int i4019 = i4018 << 5;
            ((int[]) objArr112[2])[0] = ((~i4018) & i4019) | ((~i4019) & i4018);
            return objArr112;
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }
}
