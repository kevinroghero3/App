package com.facebook.react.devsupport;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceActivity;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.react.R;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class DevSettingsActivity extends PreferenceActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static boolean ICustomTabsServiceDefault;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static boolean requestPostMessageChannelWithExtras;
    private static char[] validateRelationship;
    private static int warmup;
    private static final byte[] $$c = {67, 111, Ascii.EM, 19};
    private static final int $$f = 181;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, byte r6, short r7) {
        /*
            int r6 = r6 * 4
            int r0 = 1 - r6
            byte[] r1 = com.facebook.react.devsupport.DevSettingsActivity.$$c
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r5 = r5 + 66
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L16
            r3 = r6
            r4 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L24:
            r3 = r1[r7]
        L26:
            int r3 = -r3
            int r5 = r5 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevSettingsActivity.$$g(byte, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.facebook.react.devsupport.DevSettingsActivity.$$a
            int r1 = r8 + 8
            int r6 = r6 + 65
            int r7 = 112 - r7
            byte[] r1 = new byte[r1]
            int r8 = r8 + 7
            r2 = 0
            if (r0 != 0) goto L13
            r6 = r7
            r4 = r8
            r3 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r7 = r7 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevSettingsActivity.b(byte, byte, int, java.lang.Object[]):void");
    }

    private static void c(short s, int i, int i2, Object[] objArr) {
        int i3 = i2 + 36;
        byte[] bArr = $$d;
        int i4 = i + 4;
        byte[] bArr2 = new byte[84 - s];
        int i5 = 83 - s;
        int i6 = -1;
        if (bArr == null) {
            i3 = (i4 + (-i5)) - 2;
            i4 = i4;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            int i7 = i4 + 1;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i3 = (i3 + (-bArr[i7])) - 2;
                i4 = i7;
            }
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getApplication().getResources().getString(R.string.catalyst_settings_title));
        addPreferencesFromResource(R.xml.rn_dev_preferences);
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        char[] cArr2;
        int i2 = 2;
        int i3 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        char c = '0';
        int i4 = 0;
        if (cArr3 != null) {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = $10 + 3;
                $11 = i6 % 128;
                if (i6 % i2 == 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i4] = Integer.valueOf(cArr3[i5]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i4;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 26, (char) ('0' - AndroidCharacter.getMirror(c)), TextUtils.getCapsMode("", i4, i4) + 1041, -1719489573, false, $$g((byte) 55, b, b), new Class[]{Integer.TYPE});
                        }
                        cArr4[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr3[i5])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame2 == null) {
                            byte b2 = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25, (char) KeyEvent.keyCodeFromString(""), 1042 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -1719489573, false, $$g((byte) 55, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr4[i5] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i5++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i2 = 2;
                c = '0';
                i4 = 0;
            }
            cArr3 = cArr4;
        }
        Object[] objArr4 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame3 == null) {
            int i7 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14;
            char modifierMetaStateMask = (char) (20487 - ((byte) KeyEvent.getModifierMetaStateMask()));
            int mode = View.MeasureSpec.getMode(0) + 2148;
            byte b3 = (byte) ($$f & 3);
            byte b4 = (byte) (b3 - 1);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i7, modifierMetaStateMask, mode, 216472770, false, $$g(b3, b4, b4), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
        int i8 = -2083387879;
        if (ICustomTabsServiceDefault) {
            int i9 = $11 + 3;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            onmessagechannelready.c = bArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                int i11 = $11 + 41;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                cArr5[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                try {
                    Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i8);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation('E' - AndroidCharacter.getMirror('0'), (char) (59173 - Process.getGidForName("")), (-16775273) - Color.rgb(0, 0, 0), 481771537, false, $$g(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    i8 = -2083387879;
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
            objArr[0] = new String(cArr5);
            return;
        }
        if (!requestPostMessageChannelWithExtras) {
            int i13 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i13;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    break;
                }
                cArr6[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                i13 = onmessagechannelready.a + 1;
            }
            String str = new String(cArr6);
            int i14 = $10 + 53;
            $11 = i14 % 128;
            if (i14 % 2 != 0) {
                objArr[0] = str;
                return;
            } else {
                int i15 = 47 / 0;
                objArr[0] = str;
                return;
            }
        }
        int i16 = $11 + 7;
        $10 = i16 % 128;
        if (i16 % 2 != 0) {
            onmessagechannelready.c = cArr.length;
            cArr2 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 1;
        } else {
            onmessagechannelready.c = cArr.length;
            cArr2 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
        }
        while (onmessagechannelready.a < onmessagechannelready.c) {
            cArr2[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
            Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
            if (objAccessartificialFrame5 == null) {
                byte b7 = (byte) 0;
                byte b8 = b7;
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(21 - Drawable.resolveOpacity(0, 0), (char) (59175 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), Color.blue(0) + 1943, 481771537, false, $$g(b7, b8, b8), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:336:0x239a  */
    /* JADX WARN: Code duplicated, block: B:337:0x23fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x0716 A[Catch: all -> 0x250d, TryCatch #8 {all -> 0x250d, blocks: (B:265:0x1d3e, B:267:0x1d61, B:268:0x1db4, B:230:0x18c0, B:232:0x18c6, B:233:0x18f1, B:235:0x191c, B:236:0x19a6, B:133:0x0d1d, B:135:0x0d2a, B:136:0x0d57, B:138:0x0d61, B:140:0x0d6e, B:141:0x0d9e, B:67:0x0701, B:69:0x0716, B:70:0x0745), top: B:383:0x0701 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x075c  */
    /* JADX WARN: Code duplicated, block: B:78:0x07c7  */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        int i;
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        int i2;
        Object[] objArr2;
        int i3;
        Object[] objArr3;
        int i4;
        Object[] objArr4;
        Object[] objArr5;
        int i5;
        Object[] objArr6;
        int i6;
        int i7;
        Object obj;
        Object[] objArr7;
        int i8;
        int i9;
        int i10 = 2 % 2;
        int i11 = artificialFrame + 57;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
        int i12 = i11 % 2;
        Object[] objArr8 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(127 - TextUtils.getOffsetBefore("", 0), new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame4 == null) {
            int i13 = 22 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char defaultSize = (char) View.getDefaultSize(0, 0);
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 466;
            int i14 = $$b;
            Object[] objArr12 = new Object[1];
            b((byte) (i14 | 34), (byte) (i14 | 96), $$a[91], objArr12);
            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i13, defaultSize, iIndexOf, -785931255, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame4).getLong(null);
        if (j == -1 || j + 1853 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 91, new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(TextUtils.getOffsetBefore("", 0) + 127, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr15 = new Object[1];
            a((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, new byte[]{-96, -125, -112, -98, -116, -127, -112, -93, -127, -92, -90, -95, -98, -127, -127, -100, -93, -112, -90, -91, -94, -100, -112, -93, -100, -95, -100, -91, -125, -94, -94, -100, -100, -116, -91, -125, -93, -96, -127, -98, -100, -91, -95, -94, -94, -92, -125, -116, -100, -91, -92, -93, -127, -94, -95, -112, -98, -100, -116, -96, -97, -98, -99, -100}, null, null, objArr15);
            String str5 = (String) objArr15[0];
            Object[] objArr16 = new Object[1];
            a(MotionEvent.axisFromString("") + 128, new byte[]{-116, -100, -127, -93, -96, -91, -127, -89, -92, -92, -116, -89, -100, -127, -96, -98, -97, -98, -93, -96, -97, -94, -97, -95, -94, -116, -127, -94, -97, -97, -96, -94, -97, -89, -94, -125, -97, -92, -90, -95, -127, -94, -100, -127, -116, -99, -92, -96, -95, -125, -96, -92, -89, -94, -95, -99, -90, -93, -100, -116, -116, -116, -98, -94}, null, null, objArr16);
            try {
                Object[] objArr17 = {baseContext, new String[]{str5, (String) objArr16[0]}, Integer.valueOf(iIntValue), 1, -769720880};
                byte[] bArr = $$d;
                Object[] objArr18 = new Object[1];
                c((byte) (-bArr[191]), bArr[13], bArr[206], objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                c(bArr[206], bArr[394], bArr[6], objArr19);
                Object[] objArr20 = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                int i15 = ((int[]) objArr20[0])[0];
                int i16 = ((int[]) objArr20[3])[0];
                if (baseContext != null) {
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame5 == null) {
                        int offsetAfter = 21 - TextUtils.getOffsetAfter("", 0);
                        char c = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int scrollBarFadeDuration = 465 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte b = (byte) ($$b | 34);
                        byte[] bArr2 = $$a;
                        Object[] objArr21 = new Object[1];
                        b(b, (byte) (bArr2[2] + 1), bArr2[91], objArr21);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter, c, scrollBarFadeDuration, -612765161, false, (String) objArr21[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, objArr20);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame6 == null) {
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 21;
                            char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 465;
                            int i17 = $$b;
                            Object[] objArr22 = new Object[1];
                            b((byte) (i17 | 34), (byte) (i17 | 96), $$a[91], objArr22);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode, minimumFlingVelocity, maximumFlingVelocity, -785931255, false, (String) objArr22[0], null);
                        }
                        ((Field) objAccessartificialFrame6).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } else {
                    objArr20 = objArr20;
                }
                objArr = objArr20;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame7 == null) {
                int iIndexOf2 = TextUtils.indexOf("", "") + 21;
                char c2 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int iMakeMeasureSpec = 465 - View.MeasureSpec.makeMeasureSpec(0, 0);
                byte b2 = (byte) ($$b | 34);
                byte[] bArr3 = $$a;
                Object[] objArr23 = new Object[1];
                b(b2, (byte) (bArr3[2] + 1), bArr3[91], objArr23);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c2, iMakeMeasureSpec, -612765161, false, (String) objArr23[0], null);
            }
            Object[] objArr24 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i18 = ((int[]) objArr24[3])[0];
            int i19 = ((int[]) objArr24[0])[0];
            String[] strArr = (String[]) objArr24[1];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 27884684;
            int i20 = ~((-130907586) | (~iCodePointAt));
            int i21 = (((((i20 | 28) | (~(130907585 | iCodePointAt))) * (-338)) + 160359189) + (((~(iCodePointAt | 130907613)) | i20) * 338)) - 769720880;
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr[2])[0] = i23 ^ (i23 << 5);
        }
        int i24 = ((int[]) objArr[0])[0];
        int i25 = ((int[]) objArr[3])[0];
        if (i25 == i24) {
            Object[] objArr25 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i26 = ((int[]) objArr[2])[0];
            int i27 = ((int[]) objArr[3])[0];
            int i28 = ((int[]) objArr[0])[0];
            String[] strArr2 = (String[]) objArr[1];
            int iMyPid = Process.myPid();
            int i29 = ~iMyPid;
            int i30 = i26 + 1419977078 + (((~((-805833868) | i29)) | 645484141) * (-865)) + ((~(iMyPid | 805833867)) * 865) + (((~(645484141 | i29)) | (~(i29 | 805833867))) * 865);
            int i31 = (i30 << 13) ^ i30;
            int i32 = i31 ^ (i31 >>> 17);
            ((int[]) objArr25[2])[0] = i32 ^ (i32 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[1];
            if (strArr3 != null) {
                for (String str6 : strArr3) {
                    arrayList.add(str6);
                }
            }
            try {
                Object[] objArr26 = {Long.valueOf(((long) (i24 ^ i25)) ^ (((long) (-1615277021)) << 32)), Long.valueOf(-1615276957)};
                byte[] bArr4 = $$d;
                Object[] objArr27 = new Object[1];
                c((byte) (-bArr4[309]), (short) (-bArr4[142]), bArr4[206], objArr27);
                Class<?> cls3 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                c((byte) 81, (short) ($$e - 4), bArr4[5], objArr28);
                cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                Object[] objArr29 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i33 = ((int[]) objArr[2])[0];
                int i34 = ((int[]) objArr[3])[0];
                int i35 = ((int[]) objArr[0])[0];
                String[] strArr4 = (String[]) objArr[1];
                int i36 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i37 = ~i36;
                int i38 = i33 + 426803693 + (((~(i37 | 182282335)) | (~(21932609 | i37)) | (-199223904)) * 464) + (((-177291295) | i36) * (-464)) + (((~(i36 | 182282335)) | (-199223904)) * 464);
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                i = 0;
                ((int[]) objArr29[2])[0] = i40 ^ (i40 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame8 == null) {
            int offsetAfter2 = 26 - TextUtils.getOffsetAfter("", i);
            char c3 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int i41 = 1040 - (ExpandableListView.getPackedPositionForChild(i, i) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i, i) == 0L ? 0 : -1));
            int i42 = $$b;
            Object[] objArr30 = new Object[1];
            b((byte) (i42 | 34), (byte) (i42 | 96), $$a[91], objArr30);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(offsetAfter2, c3, i41, 2061780482, false, (String) objArr30[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame8).getLong(null);
        if (j2 != -1) {
            int i43 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i43 % 128;
            int i44 = i43 % 2;
            if (j2 + 4611686018427387918L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int i45 = 27 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    char size = (char) View.MeasureSpec.getSize(0);
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 1041;
                    byte b3 = (byte) ($$b | 34);
                    byte[] bArr5 = $$a;
                    Object[] objArr31 = new Object[1];
                    b(b3, (byte) (bArr5[2] + 1), bArr5[91], objArr31);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i45, size, iKeyCodeFromString, 1145017376, false, (String) objArr31[0], null);
                }
                Object[] objArr32 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i46 = ((int[]) objArr32[3])[0];
                int i47 = ((int[]) objArr32[2])[0];
                String[] strArr5 = (String[]) objArr32[0];
                int i48 = ~System.identityHashCode(this);
                int i49 = ((323545734 + (((~((-492864515) | i48)) | 570968321) * (-828))) + ((i48 | (-492864515)) * (-828))) - 1142390909;
                int i50 = (i49 << 13) ^ i49;
                int i51 = i50 ^ (i50 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i51 ^ (i51 << 5);
            } else {
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr33 = {783006730};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 8, (char) (Color.argb(0, 0, 0, 0) + 22251), 1032 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr33), -1212315381, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i52 = 26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                        int i53 = 1041 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte b4 = (byte) ($$b | 34);
                        byte[] bArr6 = $$a;
                        Object[] objArr34 = new Object[1];
                        b(b4, (byte) (bArr6[2] + 1), bArr6[91], objArr34);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i52, cAxisFromString, i53, 1145017376, false, (String) objArr34[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
                            char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 1041;
                            int i54 = $$b;
                            Object[] objArr35 = new Object[1];
                            b((byte) (i54 | 34), (byte) (i54 | 96), $$a[91], objArr35);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, edgeSlop, deadChar, 2061780482, false, (String) objArr35[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf2);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        } else {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr36 = {783006730};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 8, (char) (Color.argb(0, 0, 0, 0) + 22251), 1032 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr36), -1212315381, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i55 = 26 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 1);
                int i56 = 1041 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte b5 = (byte) ($$b | 34);
                byte[] bArr7 = $$a;
                Object[] objArr37 = new Object[1];
                b(b5, (byte) (bArr7[2] + 1), bArr7[91], objArr37);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i55, cAxisFromString2, i56, 1145017376, false, (String) objArr37[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int packedPositionGroup2 = 26 - ExpandableListView.getPackedPositionGroup(0L);
                char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 1041;
                int i57 = $$b;
                Object[] objArr38 = new Object[1];
                b((byte) (i57 | 34), (byte) (i57 | 96), $$a[91], objArr38);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, edgeSlop2, deadChar2, 2061780482, false, (String) objArr38[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf3);
        }
        int i58 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i59 == i58) {
            Object[] objArr39 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i60 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i62 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i63 = ~iIdentityHashCode;
            int i64 = i60 + (-257328162) + (((~((-476087045) | i63)) | 554190851) * 220) + (((~(i63 | (-477534085))) | 555637891) * (-440)) + ((iIdentityHashCode | (-476087045)) * 220);
            int i65 = (i64 << 13) ^ i64;
            int i66 = i65 ^ (i65 >>> 17);
            i2 = 0;
            ((int[]) objArr39[1])[0] = i66 ^ (i66 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                int i67 = 0;
                while (i67 < strArr7.length) {
                    int i68 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
                    artificialFrame = i68 % 128;
                    if (i68 % 2 == 0) {
                        arrayList2.add(strArr7[i67]);
                        i67 += 88;
                    } else {
                        arrayList2.add(strArr7[i67]);
                        i67++;
                    }
                }
            }
            Object[] objArr40 = {Long.valueOf(((long) (i58 ^ i59)) ^ (((long) 795376055) << 32)), Long.valueOf(795376053)};
            byte[] bArr8 = $$d;
            byte b6 = (byte) (bArr8[522] - 1);
            int i69 = $$e;
            Object[] objArr41 = new Object[1];
            c(b6, (short) (i69 - 2), bArr8[206], objArr41);
            Class<?> cls4 = Class.forName((String) objArr41[0]);
            Object[] objArr42 = new Object[1];
            c((byte) 81, (short) (i69 - 4), bArr8[5], objArr42);
            cls4.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            Object[] objArr43 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i70 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i71 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i72 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i73 = i70 + (-318801725) + (((~(iIdentityHashCode2 | (-594493619))) | (-672597426)) * (-465)) + (((-594493619) | (~((-672597426) | iIdentityHashCode2))) * 930) + ((iIdentityHashCode2 | (-537329841)) * 465);
            int i74 = (i73 << 13) ^ i73;
            int i75 = i74 ^ (i74 >>> 17);
            i2 = 0;
            ((int[]) objArr43[1])[0] = i75 ^ (i75 << 5);
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame10 == null) {
            int i76 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 16;
            char cCombineMeasuredStates = (char) View.combineMeasuredStates(i2, i2);
            int packedPositionGroup3 = 747 - ExpandableListView.getPackedPositionGroup(0L);
            int i77 = $$b;
            Object[] objArr44 = new Object[1];
            b((byte) (i77 | 34), (byte) (i77 | 96), $$a[91], objArr44);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i76, cCombineMeasuredStates, packedPositionGroup3, -144068856, false, (String) objArr44[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 == -1 || j3 + 4611686018427387826L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                int i78 = artificialFrame + 73;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i78 % 128;
                int i79 = i78 % 2;
                Object[] objArr45 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 78, new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr45);
                Class<?> cls5 = Class.forName((String) objArr45[0]);
                Object[] objArr46 = new Object[1];
                a((ViewConfiguration.getLongPressTimeout() >> 16) + 127, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr46);
                baseContext2 = (Context) cls5.getMethod((String) objArr46[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            Object[] objArr47 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1370118280};
            byte[] bArr9 = $$d;
            Object[] objArr48 = new Object[1];
            c(bArr9[78], (short) ($$e | 40), bArr9[206], objArr48);
            Class<?> cls6 = Class.forName((String) objArr48[0]);
            byte b7 = (byte) (-bArr9[142]);
            Object[] objArr49 = new Object[1];
            c(b7, (short) (b7 | 139), bArr9[165], objArr49);
            objArr2 = (Object[]) cls6.getMethod((String) objArr49[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr47);
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame11 == null) {
                int iBlue = 17 - Color.blue(0);
                char defaultSize2 = (char) View.getDefaultSize(0, 0);
                int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 747;
                byte b8 = (byte) ($$b | 34);
                byte[] bArr10 = $$a;
                Object[] objArr50 = new Object[1];
                b(b8, (byte) (bArr10[2] + 1), bArr10[91], objArr50);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iBlue, defaultSize2, iKeyCodeFromString2, -1031537386, false, (String) objArr50[0], null);
            }
            ((Field) objAccessartificialFrame11).set(null, objArr2);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame12 == null) {
                    int iCombineMeasuredStates = 17 - View.combineMeasuredStates(0, 0);
                    char cAxisFromString3 = (char) (MotionEvent.axisFromString("") + 1);
                    int i80 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 746;
                    int i81 = $$b;
                    Object[] objArr51 = new Object[1];
                    b((byte) (i81 | 34), (byte) (i81 | 96), $$a[91], objArr51);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cAxisFromString3, i80, -144068856, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, lValueOf4);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame13 == null) {
                int iLastIndexOf = 16 - TextUtils.lastIndexOf("", '0', 0, 0);
                char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                int i82 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 746;
                byte b9 = (byte) ($$b | 34);
                byte[] bArr11 = $$a;
                Object[] objArr52 = new Object[1];
                b(b9, (byte) (bArr11[2] + 1), bArr11[91], objArr52);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, scrollBarSize, i82, -1031537386, false, (String) objArr52[0], null);
            }
            Object[] objArr53 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr2 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i83 = ((int[]) objArr53[3])[0];
            int i84 = ((int[]) objArr53[4])[0];
            List list = (List) objArr53[0];
            List list2 = (List) objArr53[2];
            int i85 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i86 = (((-1234863932) + (((~((~i85) | 256871336)) | (-533716970)) * 529)) + (((~(i85 | 256871336)) | (-348577122)) * 529)) - 1370118280;
            int i87 = (i86 << 13) ^ i86;
            int i88 = i87 ^ (i87 >>> 17);
            ((int[]) objArr2[1])[0] = i88 ^ (i88 << 5);
        }
        int i89 = ((int[]) objArr2[4])[0];
        int i90 = ((int[]) objArr2[3])[0];
        if (i90 == i89) {
            Object[] objArr54 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i91 = ((int[]) objArr2[1])[0];
            int i92 = ((int[]) objArr2[3])[0];
            int i93 = ((int[]) objArr2[4])[0];
            List list3 = (List) objArr2[0];
            List list4 = (List) objArr2[2];
            int i94 = ~((~System.identityHashCode(this)) | 548332840);
            int i95 = i91 + ((545809416 | i94) * (-374)) + 1930946553 + ((i94 | 2523424) * 374);
            int i96 = (i95 << 13) ^ i95;
            int i97 = i96 ^ (i96 >>> 17);
            ((int[]) objArr54[1])[0] = i97 ^ (i97 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Object[] objArr55 = {objArr2};
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame14 == null) {
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(41 - KeyEvent.keyCodeFromString(""), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 12468), View.combineMeasuredStates(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame14).invoke(null, objArr55));
            Object[] objArr56 = {objArr2};
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame15 == null) {
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 41, (char) (View.getDefaultSize(0, 0) + 12468), View.MeasureSpec.makeMeasureSpec(0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList3.add(((Method) objAccessartificialFrame15).invoke(null, objArr56));
            Object[] objArr57 = {Long.valueOf(((long) (i89 ^ i90)) ^ (((long) 1978057130) << 32)), Long.valueOf(1978057122)};
            byte[] bArr12 = $$d;
            Object[] objArr58 = new Object[1];
            c(bArr12[18], (short) 222, bArr12[206], objArr58);
            Class<?> cls7 = Class.forName((String) objArr58[0]);
            Object[] objArr59 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr12[5], objArr59);
            cls7.getMethod((String) objArr59[0], Long.TYPE, Long.TYPE).invoke(null, objArr57);
            Object[] objArr60 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i98 = ((int[]) objArr2[1])[0];
            int i99 = ((int[]) objArr2[3])[0];
            int i100 = ((int[]) objArr2[4])[0];
            List list5 = (List) objArr2[0];
            List list6 = (List) objArr2[2];
            int i101 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1428775729;
            int i102 = i98 + (-1389116647) + (((~(244091928 | i101)) | (-849540387)) * (-964)) + (((~((~i101) | 244091928)) | (-1051655483)) * (-964));
            int i103 = (i102 << 13) ^ i102;
            int i104 = i103 ^ (i103 >>> 17);
            int[] iArr = (int[]) objArr60[1];
            i3 = 0;
            iArr[0] = i104 ^ (i104 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame16 == null) {
            int iLastIndexOf2 = 29 - TextUtils.lastIndexOf("", '0');
            char absoluteGravity = (char) (49362 - Gravity.getAbsoluteGravity(i3, i3));
            int iAlpha = 684 - Color.alpha(i3);
            int i105 = $$b;
            Object[] objArr61 = new Object[1];
            b((byte) (i105 | 32), (byte) (i105 | 80), $$a[83], objArr61);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, absoluteGravity, iAlpha, 752929587, false, (String) objArr61[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j4 == -1 || j4 + 2034 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i106 % 128;
                int i107 = i106 % 2;
                Object[] objArr62 = new Object[1];
                a(127 - ExpandableListView.getPackedPositionType(0L), new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr62);
                Class<?> cls8 = Class.forName((String) objArr62[0]);
                Object[] objArr63 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 90, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr63);
                baseContext3 = (Context) cls8.getMethod((String) objArr63[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr64 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 655766795};
            byte[] bArr13 = $$d;
            Object[] objArr65 = new Object[1];
            c((byte) (-bArr13[237]), (short) 294, bArr13[206], objArr65);
            Class<?> cls9 = Class.forName((String) objArr65[0]);
            byte b10 = (byte) (-bArr13[142]);
            Object[] objArr66 = new Object[1];
            c(b10, (short) (b10 | 139), bArr13[165], objArr66);
            objArr3 = (Object[]) cls9.getMethod((String) objArr66[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr64);
            if (baseContext3 != null) {
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame17 == null) {
                    int i108 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                    char pressedStateDuration = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int i109 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 684;
                    byte[] bArr14 = $$a;
                    Object[] objArr67 = new Object[1];
                    b((byte) (bArr14[15] - 1), (byte) 78, bArr14[83], objArr67);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i108, pressedStateDuration, i109, 1944867703, false, (String) objArr67[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr3);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame18 == null) {
                        int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
                        char c4 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 49361);
                        int i110 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 684;
                        int i111 = $$b;
                        Object[] objArr68 = new Object[1];
                        b((byte) (i111 | 32), (byte) (i111 | 80), $$a[83], objArr68);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(touchSlop, c4, i110, 752929587, false, (String) objArr68[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf5);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame19 == null) {
                int offsetAfter3 = 30 - TextUtils.getOffsetAfter("", 0);
                char deadChar3 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                int fadingEdgeLength = 684 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                byte[] bArr15 = $$a;
                Object[] objArr69 = new Object[1];
                b((byte) (bArr15[15] - 1), (byte) 78, bArr15[83], objArr69);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter3, deadChar3, fadingEdgeLength, 1944867703, false, (String) objArr69[0], null);
            }
            Object[] objArr70 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr70[0])[0]}, new int[]{((int[]) objArr70[1])[0]}, new int[1], (String) objArr70[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i112 = (-962957033) + (((~(iIdentityHashCode3 | 506715954)) | 471907820) * 191) + (((~((~iIdentityHashCode3) | 506715954)) | 8396) * 191) + 655766795;
            int i113 = (i112 << 13) ^ i112;
            int i114 = i113 ^ (i113 >>> 17);
            ((int[]) objArr3[2])[0] = i114 ^ (i114 << 5);
        }
        int i115 = ((int[]) objArr3[1])[0];
        int i116 = ((int[]) objArr3[0])[0];
        if (i116 == i115) {
            int i117 = ((int[]) objArr3[2])[0];
            Object[] objArr71 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i118 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1025340228;
            int i119 = ~i118;
            int i120 = i117 + (-958088776) + (((~(9681109 | i119)) | (~((-988304885) | i119))) * (-867)) + (((~((-988304885) | i118)) | 979911968 | (~(9681109 | i118))) * (-1734)) + (((~(i118 | 989593077)) | (~((-979911969) | i119)) | (~((-8392917) | i118))) * 867);
            int i121 = (i120 << 13) ^ i120;
            int i122 = i121 ^ (i121 >>> 17);
            ((int[]) objArr71[2])[0] = i122 ^ (i122 << 5);
            i4 = 0;
        } else {
            Object[] objArr72 = {Long.valueOf(((long) (i115 ^ i116)) ^ (((long) (-1641508939)) << 32)), Long.valueOf(-1641508943)};
            byte[] bArr16 = $$d;
            byte b11 = bArr16[149];
            Object[] objArr73 = new Object[1];
            c(b11, (short) (b11 | Ascii.EOT), bArr16[206], objArr73);
            Class<?> cls10 = Class.forName((String) objArr73[0]);
            Object[] objArr74 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr16[5], objArr74);
            cls10.getMethod((String) objArr74[0], Long.TYPE, Long.TYPE).invoke(null, objArr72);
            int i123 = ((int[]) objArr3[2])[0];
            Object[] objArr75 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i124 = ~iIdentityHashCode4;
            int i125 = i123 + 2140280002 + (((~((-752776245) | i124)) | (~((-225847531) | iIdentityHashCode4))) * 210) + (((~(iIdentityHashCode4 | (-545805333))) | (~(i124 | (-18876619)))) * 210);
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            i4 = 0;
            ((int[]) objArr75[2])[0] = i127 ^ (i127 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame20 == null) {
            int iCombineMeasuredStates2 = 30 - View.combineMeasuredStates(i4, i4);
            char doubleTapTimeout = (char) (49362 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
            int threadPriority = 684 - ((Process.getThreadPriority(i4) + 20) >> 6);
            byte[] bArr17 = $$a;
            byte b12 = (byte) (bArr17[15] - 1);
            Object[] objArr76 = new Object[1];
            b(b12, (byte) (b12 | Ascii.EM), bArr17[4], objArr76);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, doubleTapTimeout, threadPriority, -1583976536, false, (String) objArr76[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j5 == -1 || j5 + 1851 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr77 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -310889997};
            byte[] bArr18 = $$d;
            byte b13 = bArr18[54];
            Object[] objArr78 = new Object[1];
            c(b13, (short) (b13 | 327), bArr18[206], objArr78);
            Class<?> cls11 = Class.forName((String) objArr78[0]);
            Object[] objArr79 = new Object[1];
            c(bArr18[28], (short) 410, bArr18[206], objArr79);
            objArr4 = (Object[]) cls11.getMethod((String) objArr79[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr77);
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame21 == null) {
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 30;
                char cRgb = (char) ((-16727854) - Color.rgb(0, 0, 0));
                int iNormalizeMetaState = 684 - KeyEvent.normalizeMetaState(0);
                byte[] bArr19 = $$a;
                Object[] objArr80 = new Object[1];
                b((byte) (bArr19[15] + 1), bArr19[95], bArr19[91], objArr80);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cRgb, iNormalizeMetaState, -1456483158, false, (String) objArr80[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, objArr4);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame22 == null) {
                    int i128 = 31 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
                    int i129 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr20 = $$a;
                    byte b14 = (byte) (bArr20[15] - 1);
                    Object[] objArr81 = new Object[1];
                    b(b14, (byte) (b14 | Ascii.EM), bArr20[4], objArr81);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i128, jumpTapTimeout, i129, -1583976536, false, (String) objArr81[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame23 == null) {
                int iIndexOf3 = 29 - TextUtils.indexOf((CharSequence) "", '0');
                char c5 = (char) (49362 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 684;
                byte[] bArr21 = $$a;
                Object[] objArr82 = new Object[1];
                b((byte) (bArr21[15] + 1), bArr21[95], bArr21[91], objArr82);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c5, maximumDrawingCacheSize, -1456483158, false, (String) objArr82[0], null);
            }
            Object[] objArr83 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr83[0])[0]}, new int[]{((int[]) objArr83[1])[0]}, new int[1], (String) objArr83[3]};
            int i130 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i131 = (((-1192776644) + (((~((-207685185) | i130)) | (~(770938590 | i130))) * 69)) + (((~(i130 | 754030284)) | ((~((-224593491) | i130)) | android.R.id.tabhost)) * (-69))) - 1267783761;
            int i132 = (i131 << 13) ^ i131;
            int i133 = i132 ^ (i132 >>> 17);
            ((int[]) objArr4[2])[0] = i133 ^ (i133 << 5);
        }
        int i134 = ((int[]) objArr4[1])[0];
        int i135 = ((int[]) objArr4[0])[0];
        if (i135 == i134) {
            int i136 = ((int[]) objArr4[2])[0];
            Object[] objArr84 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i137 = ~elapsedCpuTime;
            int i138 = i136 + 1313543516 + ((976190462 | i137) * (-369)) + (((~((-271397879) | i137)) | 707225896) * (-369)) + (((~(elapsedCpuTime | 271397878)) | 704792584 | (~(i137 | (-268964567)))) * 369);
            int i139 = (i138 << 13) ^ i138;
            int i140 = i139 ^ (i139 >>> 17);
            ((int[]) objArr84[2])[0] = i140 ^ (i140 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr85 = {Long.valueOf(((long) (i134 ^ i135)) ^ (((long) 1505557263) << 32)), Long.valueOf(1505557279)};
            byte[] bArr22 = $$d;
            byte b15 = bArr22[149];
            Object[] objArr86 = new Object[1];
            c(b15, (short) (b15 | Ascii.EOT), bArr22[206], objArr86);
            Class<?> cls12 = Class.forName((String) objArr86[0]);
            Object[] objArr87 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr22[5], objArr87);
            cls12.getMethod((String) objArr87[0], Long.TYPE, Long.TYPE).invoke(null, objArr85);
            int i141 = ((int[]) objArr4[2])[0];
            Object[] objArr88 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i142 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 116744189;
            int i143 = i141 + 148065938 + (((~((-921051047) | i142)) | (-57572729)) * (-964)) + (((~((~i142) | (-921051047))) | 880804486) * (-964));
            int i144 = (i143 << 13) ^ i143;
            int i145 = i144 ^ (i144 >>> 17);
            ((int[]) objArr88[2])[0] = i145 ^ (i145 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame24 == null) {
            int windowTouchSlop = 36 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            char c6 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 540;
            int i146 = $$b;
            Object[] objArr89 = new Object[1];
            b((byte) (i146 | 34), (byte) (i146 | 96), $$a[91], objArr89);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c6, scrollBarFadeDuration2, 624296913, false, (String) objArr89[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j6 == -1 || j6 + 1907 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame25 == null) {
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 21, (char) (39516 - View.resolveSizeAndState(0, 0, 0)), View.MeasureSpec.getSize(0) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr90 = {null, ((Constructor) objAccessartificialFrame25).newInstance(null), -390801674, 0};
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame26 == null) {
                int modifierMetaStateMask = 35 - ((byte) KeyEvent.getModifierMetaStateMask());
                char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                int i147 = 540 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr23 = $$a;
                Object[] objArr91 = new Object[1];
                b((byte) (bArr23[91] - 1), (byte) (-bArr23[115]), (byte) $$b, objArr91);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cIndexOf, i147, 2101703389, false, (String) objArr91[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - KeyEvent.keyCodeFromString(""), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 833), 576 - TextUtils.indexOf("", "", 0, 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0), 630 - TextUtils.indexOf("", "")), Integer.TYPE, Integer.TYPE});
            }
            objArr5 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr90);
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame27 == null) {
                int i148 = 37 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char cAlpha = (char) Color.alpha(0);
                int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 540;
                byte b16 = (byte) ($$b | 34);
                byte[] bArr24 = $$a;
                Object[] objArr92 = new Object[1];
                b(b16, (byte) (bArr24[2] + 1), bArr24[91], objArr92);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i148, cAlpha, longPressTimeout, 793268735, false, (String) objArr92[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr5);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame28 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 36;
                    char c7 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int iIndexOf4 = TextUtils.indexOf("", "") + 540;
                    int i149 = $$b;
                    Object[] objArr93 = new Object[1];
                    b((byte) (i149 | 34), (byte) (i149 | 96), $$a[91], objArr93);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iMyTid, c7, iIndexOf4, 624296913, false, (String) objArr93[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            int i150 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i150 % 128;
            int i151 = i150 % 2;
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame29 == null) {
                int iKeyCodeFromString3 = KeyEvent.keyCodeFromString("") + 36;
                char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 540;
                byte b17 = (byte) ($$b | 34);
                byte[] bArr25 = $$a;
                Object[] objArr94 = new Object[1];
                b(b17, (byte) (bArr25[2] + 1), bArr25[91], objArr94);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString3, cIndexOf2, iResolveSizeAndState, 793268735, false, (String) objArr94[0], null);
            }
            Object[] objArr95 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr5 = new Object[]{new int[1], new int[1], new int[1]};
            int i152 = ((int[]) objArr95[2])[0];
            int i153 = ((int[]) objArr95[1])[0];
            ((int[]) objArr5[2])[0] = i152;
            ((int[]) objArr5[1])[0] = i153;
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 121862473;
            int i154 = ~((-286268555) | length);
            int i155 = ~length;
            int i156 = ((152061242 + ((i154 | (~((-776127265) | i155))) * 497)) + (((~(length | (-776127265))) | ((~((-289225932) | i155)) | 2957377)) * 497)) - 390801674;
            int i157 = (i156 << 13) ^ i156;
            int i158 = i157 ^ (i157 >>> 17);
            ((int[]) objArr5[0])[0] = i158 ^ (i158 << 5);
        }
        Object obj2 = objArr5[1];
        int i159 = ((int[]) obj2)[0];
        Object obj3 = objArr5[2];
        int i160 = ((int[]) obj3)[0];
        if (i160 == i159) {
            int i161 = artificialFrame + 11;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i161 % 128;
            int i162 = i161 % 2;
            Object[] objArr96 = {new int[1], new int[1], new int[1]};
            int i163 = ((int[]) objArr5[0])[0];
            int i164 = ((int[]) obj3)[0];
            int i165 = ((int[]) obj2)[0];
            ((int[]) objArr96[2])[0] = i164;
            ((int[]) objArr96[1])[0] = i165;
            int i166 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i167 = i163 + ((((-68778521) + (((~i166) | 277889144) * 1324)) + (((~(i166 | 469320061)) | (~(882301688 | i166))) * (-1324))) - 1432606226);
            int i168 = i167 ^ (i167 << 13);
            int i169 = i168 ^ (i168 >>> 17);
            i5 = 0;
            ((int[]) objArr96[0])[0] = i169 ^ (i169 << 5);
        } else {
            Object[] objArr97 = {Long.valueOf((((long) (-1809680089)) << 32) ^ ((long) (i159 ^ i160))), Long.valueOf(-1809684185)};
            byte[] bArr26 = $$d;
            byte b18 = bArr26[149];
            Object[] objArr98 = new Object[1];
            c(b18, (short) (b18 | Ascii.EOT), bArr26[206], objArr98);
            Class<?> cls13 = Class.forName((String) objArr98[0]);
            Object[] objArr99 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr26[5], objArr99);
            cls13.getMethod((String) objArr99[0], Long.TYPE, Long.TYPE).invoke(null, objArr97);
            Object[] objArr100 = {new int[1], new int[1], new int[1]};
            int i170 = ((int[]) objArr5[0])[0];
            int i171 = ((int[]) objArr5[2])[0];
            int i172 = ((int[]) objArr5[1])[0];
            ((int[]) objArr100[2])[0] = i171;
            ((int[]) objArr100[1])[0] = i172;
            int i173 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i174 = i170 + (-1740791728) + ((~((-189071377) | i173)) * 623) + (((~i173) | 604642149) * (-623)) + (((~(i173 | 883596261)) | (~((-468025489) | i173)) | 189071376) * 623);
            int i175 = (i174 << 13) ^ i174;
            int i176 = i175 ^ (i175 >>> 17);
            i5 = 0;
            ((int[]) objArr100[0])[0] = i176 ^ (i176 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame30 == null) {
            int iRed = Color.red(i5) + 25;
            char cIndexOf3 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', i5, i5));
            int iGreen = Color.green(i5) + 816;
            int i177 = $$b;
            Object[] objArr101 = new Object[1];
            b((byte) (i177 | 34), (byte) (i177 | 96), $$a[91], objArr101);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iRed, cIndexOf3, iGreen, 721586079, false, (String) objArr101[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j7 == -1 || j7 + 1981 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr102 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1910718692};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame31 == null) {
                int trimmedLength = TextUtils.getTrimmedLength("") + 25;
                char packedPositionChild = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                int i178 = 817 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                byte[] bArr27 = $$a;
                byte b19 = bArr27[26];
                Object[] objArr103 = new Object[1];
                b(b19, (byte) (b19 + 4), bArr27[24], objArr103);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(trimmedLength, packedPositionChild, i178, -797394565, false, (String) objArr103[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame31).invoke(null, objArr102);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame32 == null) {
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 30068);
                int iAlpha2 = Color.alpha(0) + 816;
                byte b20 = (byte) ($$b | 34);
                byte[] bArr28 = $$a;
                Object[] objArr104 = new Object[1];
                b(b20, (byte) (bArr28[2] + 1), bArr28[91], objArr104);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(tapTimeout, cKeyCodeFromString, iAlpha2, 891606461, false, (String) objArr104[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArr6);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame33 == null) {
                    int iLastIndexOf3 = 24 - TextUtils.lastIndexOf("", '0', 0, 0);
                    char pressedStateDuration2 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int i179 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    int i180 = $$b;
                    Object[] objArr105 = new Object[1];
                    b((byte) (i180 | 34), (byte) (i180 | 96), $$a[91], objArr105);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, pressedStateDuration2, i179, 721586079, false, (String) objArr105[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf8);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame34 == null) {
                int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                char cNormalizeMetaState = (char) (30068 - KeyEvent.normalizeMetaState(0));
                int iIndexOf5 = TextUtils.indexOf("", "", 0, 0) + 816;
                byte b21 = (byte) ($$b | 34);
                byte[] bArr29 = $$a;
                Object[] objArr106 = new Object[1];
                b(b21, (byte) (bArr29[2] + 1), bArr29[91], objArr106);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, cNormalizeMetaState, iIndexOf5, 891606461, false, (String) objArr106[0], null);
            }
            Object[] objArr107 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i181 = ((int[]) objArr107[0])[0];
            int i182 = ((int[]) objArr107[1])[0];
            String[] strArr9 = (String[]) objArr107[2];
            int i183 = (int) Runtime.getRuntime().totalMemory();
            int i184 = ~i183;
            int i185 = 1713221425 + (((~((-455498194) | i184)) | 653670559) * (-328)) + ((i183 | 653670559) * 164) + (((~(i183 | 455498193)) | 617619470 | (~(i184 | (-419447105)))) * 164) + 1910718692;
            int i186 = (i185 << 13) ^ i185;
            int i187 = i186 ^ (i186 >>> 17);
            ((int[]) objArr6[3])[0] = i187 ^ (i187 << 5);
        }
        int i188 = ((int[]) objArr6[1])[0];
        int i189 = ((int[]) objArr6[0])[0];
        if (i189 == i188) {
            Object[] objArr108 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i190 = ((int[]) objArr6[3])[0];
            int i191 = ((int[]) objArr6[0])[0];
            int i192 = ((int[]) objArr6[1])[0];
            String[] strArr10 = (String[]) objArr6[2];
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) + 1163945500;
            int i193 = ~(571426166 | iCodePointAt2);
            int i194 = ~iCodePointAt2;
            int i195 = i193 | (~(769598532 | i194));
            int i196 = ~((-571426167) | i194);
            int i197 = i190 + (-280837663) + ((i195 | i196) * (-516)) + (((~(iCodePointAt2 | (-231743489))) | (~((-537855045) | i194))) * 516) + ((537855044 | i196) * 516);
            int i198 = (i197 << 13) ^ i197;
            int i199 = i198 ^ (i198 >>> 17);
            ((int[]) objArr108[3])[0] = i199 ^ (i199 << 5);
            i6 = 0;
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr6[2];
            if (strArr11 != null) {
                for (String str7 : strArr11) {
                    arrayList4.add(str7);
                }
            }
            Object[] objArr109 = {Long.valueOf(((long) (i188 ^ i189)) ^ (((long) (-735971927)) << 32)), Long.valueOf(-735971928)};
            byte[] bArr30 = $$d;
            Object[] objArr110 = new Object[1];
            c(bArr30[524], (short) 426, bArr30[206], objArr110);
            Class<?> cls14 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr30[5], objArr111);
            cls14.getMethod((String) objArr111[0], Long.TYPE, Long.TYPE).invoke(null, objArr109);
            Object[] objArr112 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i200 = ((int[]) objArr6[3])[0];
            int i201 = ((int[]) objArr6[0])[0];
            int i202 = ((int[]) objArr6[1])[0];
            String[] strArr12 = (String[]) objArr6[2];
            int i203 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1180444188;
            int i204 = i200 + (((~((-511487608) | i203)) | 304909857) * (-283)) + 588315976 + ((~(i203 | (-206577751))) * 283);
            int i205 = (i204 << 13) ^ i204;
            int i206 = i205 ^ (i205 >>> 17);
            i6 = 0;
            ((int[]) objArr112[3])[0] = i206 ^ (i206 << 5);
        }
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame35 == null) {
            int i207 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char cResolveOpacity = (char) (49362 - Drawable.resolveOpacity(i6, i6));
            int windowTouchSlop2 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            byte b22 = (byte) ($$b | 32);
            byte[] bArr31 = $$a;
            Object[] objArr113 = new Object[1];
            b(b22, bArr31[87], bArr31[4], objArr113);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i207, cResolveOpacity, windowTouchSlop2, 508509282, false, (String) objArr113[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j8 != -1) {
            int i208 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i208 % 128;
            int i209 = i208 % 2;
            if (j8 + 1878 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame36 == null) {
                    int deadChar4 = KeyEvent.getDeadChar(0, 0) + 30;
                    char packedPositionType = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                    int keyRepeatTimeout = 684 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte[] bArr32 = $$a;
                    byte b23 = bArr32[15];
                    byte b24 = (byte) (bArr32[91] - 1);
                    Object[] objArr114 = new Object[1];
                    b(b23, b24, b24, objArr114);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(deadChar4, packedPositionType, keyRepeatTimeout, -1321816393, false, (String) objArr114[0], null);
                }
                Object[] objArr115 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr7 = new Object[]{new int[]{((int[]) objArr115[0])[0]}, new int[]{((int[]) objArr115[1])[0]}, new int[1], (String) objArr115[3]};
                int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                int i210 = ~streamVolume;
                int i211 = (-120395610) + (((~(streamVolume | (-71058642))) | (~((-981508385) | i210)) | 2884609) * (-68)) + ((~((-68174033) | i210)) * (-68)) + (((~(71058641 | i210)) | (-1049682417)) * 68) + 68932032;
                int i212 = (i211 << 13) ^ i211;
                int i213 = i212 ^ (i212 >>> 17);
                ((int[]) objArr7[2])[0] = i213 ^ (i213 << 5);
            } else {
                i7 = 0;
            }
            i8 = ((int[]) objArr7[1])[0];
            i9 = ((int[]) objArr7[0])[0];
            if (i9 == i8) {
                int i214 = ((int[]) objArr7[2])[0];
                Object[] objArr116 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int i215 = ~((~System.identityHashCode(this)) | 830427152);
                int i216 = i214 + (((824840208 | i215) * (-374)) - 1858300802) + ((i215 | 5586944) * 374);
                int i217 = (i216 << 13) ^ i216;
                int i218 = i217 ^ (i217 >>> 17);
                ((int[]) objArr116[2])[0] = i218 ^ (i218 << 5);
            } else {
                Object[] objArr117 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) 514152061) << 32)), Long.valueOf(514151549)};
                byte[] bArr33 = $$d;
                byte b25 = bArr33[342];
                Object[] objArr118 = new Object[1];
                c(b25, (short) (b25 | 556), bArr33[206], objArr118);
                Class<?> cls15 = Class.forName((String) objArr118[0]);
                Object[] objArr119 = new Object[1];
                c((byte) 81, (short) ($$e - 4), bArr33[5], objArr119);
                cls15.getMethod((String) objArr119[0], Long.TYPE, Long.TYPE).invoke(null, objArr117);
                int i219 = ((int[]) objArr7[2])[0];
                Object[] objArr120 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) + 1509498224;
                int i220 = i219 + ((((-1213104510) + (((~iCodePointAt3) | (-873631897)) * 1444)) + (((~(iCodePointAt3 | 656508635)) | ((~(322115139 | iCodePointAt3)) | (-926127836))) * (-1444))) - 597963600);
                int i221 = (i220 << 13) ^ i220;
                int i222 = i221 ^ (i221 >>> 17);
                ((int[]) objArr120[2])[0] = i222 ^ (i222 << 5);
            }
            super.onStart();
        }
        i7 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr121 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i7]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) + 26, new byte[]{-125, -127, -116, -124, -105, -106, -118, -117, -122, -107, -122, -117, -112, -108, -121, -110, -110, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr121);
            Class<?> cls16 = Class.forName((String) objArr121[0]);
            Object[] objArr122 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 78, new byte[]{-126, -123, -122, -117, -127, -112, -122, -113, -110, -110, -108, -117, -126, -116, -124, -124, -104, -112}, null, null, objArr122);
            baseContext4 = (Context) cls16.getMethod((String) objArr122[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 == null) {
            obj = null;
        } else {
            if (baseContext4 instanceof ContextWrapper) {
                int i223 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                artificialFrame = i223 % 128;
                if (i223 % 2 == 0) {
                    ((ContextWrapper) baseContext4).getBaseContext();
                    throw null;
                }
                if (((ContextWrapper) baseContext4).getBaseContext() == null) {
                    baseContext4 = null;
                    obj = null;
                }
            }
            obj = null;
            baseContext4 = baseContext4.getApplicationContext();
        }
        int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue();
        int i224 = artificialFrame + 23;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i224 % 128;
        int i225 = i224 % 2;
        Object[] objArr123 = {baseContext4, Integer.valueOf(iIntValue4), 68932032};
        byte[] bArr34 = $$d;
        byte b26 = bArr34[5];
        Object[] objArr124 = new Object[1];
        c(b26, (short) (b26 | 490), bArr34[517], objArr124);
        Class<?> cls17 = Class.forName((String) objArr124[0]);
        Object[] objArr125 = new Object[1];
        c(bArr34[206], bArr34[394], bArr34[6], objArr125);
        objArr7 = (Object[]) cls17.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
        if (baseContext4 != null) {
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame37 == null) {
                int iAlpha3 = Color.alpha(0) + 30;
                char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                int iRed2 = Color.red(0) + 684;
                byte[] bArr35 = $$a;
                byte b27 = bArr35[15];
                byte b28 = (byte) (bArr35[91] - 1);
                Object[] objArr126 = new Object[1];
                b(b27, b28, b28, objArr126);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iAlpha3, cArgb, iRed2, -1321816393, false, (String) objArr126[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, objArr7);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame38 == null) {
                    int gidForName = 29 - Process.getGidForName("");
                    char trimmedLength2 = (char) (49362 - TextUtils.getTrimmedLength(""));
                    int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 684;
                    byte b29 = (byte) ($$b | 32);
                    byte[] bArr36 = $$a;
                    Object[] objArr127 = new Object[1];
                    b(b29, bArr36[87], bArr36[4], objArr127);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(gidForName, trimmedLength2, minimumFlingVelocity2, 508509282, false, (String) objArr127[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, lValueOf9);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i8 = ((int[]) objArr7[1])[0];
        i9 = ((int[]) objArr7[0])[0];
        if (i9 == i8) {
            int i2110 = ((int[]) objArr7[2])[0];
            Object[] objArr1110 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i2111 = ~((~System.identityHashCode(this)) | 830427152);
            int i2112 = i2110 + (((824840208 | i2111) * (-374)) - 1858300802) + ((i2111 | 5586944) * 374);
            int i2113 = (i2112 << 13) ^ i2112;
            int i2114 = i2113 ^ (i2113 >>> 17);
            ((int[]) objArr1110[2])[0] = i2114 ^ (i2114 << 5);
        } else {
            Object[] objArr1111 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) 514152061) << 32)), Long.valueOf(514151549)};
            byte[] bArr37 = $$d;
            byte b210 = bArr37[342];
            Object[] objArr1112 = new Object[1];
            c(b210, (short) (b210 | 556), bArr37[206], objArr1112);
            Class<?> cls18 = Class.forName((String) objArr1112[0]);
            Object[] objArr1113 = new Object[1];
            c((byte) 81, (short) ($$e - 4), bArr37[5], objArr1113);
            cls18.getMethod((String) objArr1113[0], Long.TYPE, Long.TYPE).invoke(null, objArr1111);
            int i2115 = ((int[]) objArr7[2])[0];
            Object[] objArr128 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iCodePointAt4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) + 1509498224;
            int i226 = i2115 + ((((-1213104510) + (((~iCodePointAt4) | (-873631897)) * 1444)) + (((~(iCodePointAt4 | 656508635)) | ((~(322115139 | iCodePointAt4)) | (-926127836))) * (-1444))) - 597963600);
            int i227 = (i226 << 13) ^ i226;
            int i228 = i227 ^ (i227 >>> 17);
            ((int[]) objArr128[2])[0] = i228 ^ (i228 << 5);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
        artificialFrame = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (49993 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf = 29 - TextUtils.indexOf((CharSequence) "", '0');
                    char cMyPid = (char) ((Process.myPid() >> 22) + 49993);
                    int defaultSize = View.getDefaultSize(0, 0) + 74;
                    byte[] bArr = $$d;
                    byte b = bArr[485];
                    Object[] objArr = new Object[1];
                    c(b, (short) (b | 556), bArr[85], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, cMyPid, defaultSize, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29, (char) (49993 - View.MeasureSpec.getMode(0)), TextUtils.indexOf("", "", 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 30;
                char cLastIndexOf = (char) (49992 - TextUtils.lastIndexOf("", '0'));
                int iIndexOf2 = 73 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte[] bArr2 = $$d;
                byte b2 = bArr2[485];
                Object[] objArr2 = new Object[1];
                c(b2, (short) (b2 | 556), bArr2[85], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, cLastIndexOf, iIndexOf2, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onResume();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 30, (char) (Color.argb(0, 0, 0, 0) + 49993), (-16777142) - Color.rgb(0, 0, 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int scrollBarSize = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                char cMyTid = (char) (49993 - (Process.myTid() >> 22));
                int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 74;
                byte[] bArr = $$d;
                byte b = bArr[485];
                Object[] objArr = new Object[1];
                c(b, (short) (b | 556), bArr[206], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cMyTid, doubleTapTimeout, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onPause();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0184  */
    /* JADX WARN: Code duplicated, block: B:16:0x0212 A[Catch: all -> 0x0a05, TryCatch #2 {all -> 0x0a05, blocks: (B:52:0x0713, B:54:0x0727, B:55:0x0752, B:14:0x01f2, B:16:0x0212, B:17:0x0262), top: B:98:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0274  */
    /* JADX WARN: Code duplicated, block: B:25:0x0310  */
    /* JADX WARN: Code duplicated, block: B:51:0x068b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0727 A[Catch: all -> 0x0a05, TryCatch #2 {all -> 0x0a05, blocks: (B:52:0x0713, B:54:0x0727, B:55:0x0752, B:14:0x01f2, B:16:0x0212, B:17:0x0262), top: B:98:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0768  */
    /* JADX WARN: Code duplicated, block: B:63:0x0839  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iIndexOf = 25 - TextUtils.indexOf("", "", 0);
            char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 816;
            int i2 = $$b;
            Object[] objArr3 = new Object[1];
            b((byte) (i2 | 34), (byte) (i2 | 96), $$a[91], objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, offsetBefore, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2044;
            Object[] objArr4 = new Object[1];
            a(127 - (ViewConfiguration.getTouchSlop() >> 8), new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 25;
                    char c = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int iIndexOf2 = 816 - TextUtils.indexOf("", "");
                    byte b = (byte) ($$b | 34);
                    byte[] bArr = $$a;
                    Object[] objArr6 = new Object[1];
                    b(b, (byte) (bArr[2] + 1), bArr[91], objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c, iIndexOf2, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr7[0])[0];
                int i4 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i5 = ~iIdentityHashCode;
                int i6 = (((112322012 + (((~(i5 | (-395453381))) | 593625746) * (-1042))) + (((-395453381) | iIdentityHashCode) * 521)) + ((((~(iIdentityHashCode | (-593625747))) | 543162386) | (~(i5 | (-344990021)))) * 521)) - 955998444;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArr[3])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                a(AndroidCharacter.getMirror('0') + 'O', new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -955998444};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 25;
                        char fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                        int i9 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        byte[] bArr2 = $$a;
                        byte b2 = bArr2[26];
                        Object[] objArr11 = new Object[1];
                        b(b2, (byte) (b2 + 4), bArr2[24], objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionGroup, fadingEdgeLength, i9, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i10 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        char c2 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int iIndexOf3 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        byte b3 = (byte) ($$b | 34);
                        byte[] bArr3 = $$a;
                        Object[] objArr12 = new Object[1];
                        b(b3, (byte) (bArr3[2] + 1), bArr3[91], objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, c2, iIndexOf3, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        a(View.combineMeasuredStates(0, 0) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        a(128 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25;
                            char keyRepeatDelay = (char) (30068 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                            int i11 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i12 = $$b;
                            Object[] objArr15 = new Object[1];
                            b((byte) (i12 | 34), (byte) (i12 | 96), $$a[91], objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, keyRepeatDelay, i11, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr16 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a(AndroidCharacter.getMirror('0') + 'O', new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -955998444};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                char fadingEdgeLength2 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                int i13 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr4 = $$a;
                byte b4 = bArr4[26];
                Object[] objArr19 = new Object[1];
                b(b4, (byte) (b4 + 4), bArr4[24], objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, fadingEdgeLength2, i13, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i14 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                char c3 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int iIndexOf4 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte b5 = (byte) ($$b | 34);
                byte[] bArr5 = $$a;
                Object[] objArr110 = new Object[1];
                b(b5, (byte) (bArr5[2] + 1), bArr5[91], objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i14, c3, iIndexOf4, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            a(View.combineMeasuredStates(0, 0) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            a(128 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int maximumDrawingCacheSize2 = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25;
                char keyRepeatDelay2 = (char) (30068 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                int i15 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int i16 = $$b;
                Object[] objArr113 = new Object[1];
                b((byte) (i16 | 34), (byte) (i16 | 96), $$a[91], objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, keyRepeatDelay2, i15, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i17 = ((int[]) objArr[1])[0];
        int i18 = ((int[]) objArr[0])[0];
        if (i18 == i17) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            int i21 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
            int i22 = ~ringerMode;
            int i23 = i19 + 1264953413 + (((~(698329303 | i22)) | 341837600) * 168) + ((~((-341837601) | ringerMode)) * 168) + (((~(ringerMode | 1040166903)) | (~(i22 | (-896501670))) | 554664069) * 168);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[3])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i17 ^ i18)) ^ (((long) 1688818522) << 32);
            long j4 = 1688818523;
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i27 = i26 + 61;
            artificialFrame = i27 % 128;
            int i28 = i27 % 2;
            int i29 = i26 + 29;
            artificialFrame = i29 % 128;
            int i30 = i29 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr6 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr6[524], (short) 426, bArr6[206], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) 81, (short) ($$e - 4), bArr6[5], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i31 = ((int[]) objArr[3])[0];
                int i32 = ((int[]) objArr[0])[0];
                int i33 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i34 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                int i35 = ~i34;
                int i36 = 1418780373 + (((~((-14681863) | i35)) | (~(149817159 | i34))) * 520);
                int i37 = ~((-149817160) | i35);
                int i38 = ~(i34 | 48355206);
                int i39 = i31 + i36 + ((i37 | i38) * (-1040)) + ((i38 | (~(i35 | (-48355207))) | 135135297) * 520);
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr24[3])[0] = i41 ^ (i41 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int capsMode = 26 - TextUtils.getCapsMode("", 0, 0);
            char c4 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 1042;
            int i42 = $$b;
            Object[] objArr25 = new Object[1];
            b((byte) (i42 | 34), (byte) (i42 | 96), $$a[91], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(capsMode, c4, iLastIndexOf, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 4611686018427387859L;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 10, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 81, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int fadingEdgeLength3 = 26 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    char cBlue = (char) Color.blue(0);
                    int offsetAfter = 1041 - TextUtils.getOffsetAfter("", 0);
                    byte b6 = (byte) ($$b | 34);
                    byte[] bArr7 = $$a;
                    Object[] objArr28 = new Object[1];
                    b(b6, (byte) (bArr7[2] + 1), bArr7[91], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength3, cBlue, offsetAfter, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i43 = ((int[]) objArr29[3])[0];
                int i44 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iNextInt = new Random().nextInt();
                int i45 = (-639189618) + (((~((-231929613) | iNextInt)) | 5420040) * (-140)) + ((~((-226509573) | iNextInt)) * 70) + (((~(iNextInt | 310033419)) | (-531122952)) * 70) + 1902764898;
                int i46 = (i45 << 13) ^ i45;
                int i47 = i46 ^ (i46 >>> 17);
                ((int[]) objArr2[1])[0] = i47 ^ (i47 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 10, new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1874395679};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 8, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22251), KeyEvent.normalizeMetaState(0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1902764898, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 26;
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int fadingEdgeLength4 = 1041 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    byte b7 = (byte) ($$b | 34);
                    byte[] bArr8 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(b7, (byte) (bArr8[2] + 1), bArr8[91], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cKeyCodeFromString, fadingEdgeLength4, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int mode = View.MeasureSpec.getMode(0) + 26;
                        char c5 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0) + 1042;
                        int i48 = $$b;
                        Object[] objArr36 = new Object[1];
                        b((byte) (i48 | 34), (byte) (i48 | 96), $$a[91], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode, c5, iIndexOf5, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -102, -126, -127, -113, -121, -127, -107, -127, -103}, null, null, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 10, new byte[]{-116, -125, -123, -114, -105, -120, -127, -101, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1874395679};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 8, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 22251), KeyEvent.normalizeMetaState(0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1902764898, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 26;
                char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                int fadingEdgeLength5 = 1041 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                byte b8 = (byte) ($$b | 34);
                byte[] bArr9 = $$a;
                Object[] objArr310 = new Object[1];
                b(b8, (byte) (bArr9[2] + 1), bArr9[91], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, cKeyCodeFromString2, fadingEdgeLength5, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int mode2 = View.MeasureSpec.getMode(0) + 26;
                char c6 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0) + 1042;
                int i49 = $$b;
                Object[] objArr313 = new Object[1];
                b((byte) (i49 | 34), (byte) (i49 | 96), $$a[91], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode2, c6, iIndexOf6, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i50 = ((int[]) objArr2[2])[0];
        int i51 = ((int[]) objArr2[3])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i54 = ((int[]) objArr2[1])[0];
            int i55 = ((int[]) objArr2[3])[0];
            int i56 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i57 = ~((int) Runtime.getRuntime().totalMemory());
            int i58 = ~(215024756 | i57);
            int i59 = i54 + (-89925762) + ((i58 | (-136920950)) * 764) + (((~(i57 | (-136920950))) | 134284404) * (-1528)) + (((-83376898) | i58) * 764);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr40[1])[0] = i61 ^ (i61 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j7 = ((long) (i50 ^ i51)) ^ (((long) 412689579) << 32);
        long j8 = 412689577;
        int i62 = artificialFrame + 59;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
        if (i62 % 2 != 0) {
            int i63 = 3 % 3;
        }
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr10 = $$d;
        byte b9 = bArr10[110];
        Object[] objArr42 = new Object[1];
        c(b9, (short) (b9 | 610), (byte) (-bArr10[302]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) 81, (short) ($$e - 4), bArr10[5], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i64 = ((int[]) objArr2[1])[0];
        int i65 = ((int[]) objArr2[3])[0];
        int i66 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int iUptimeMillis = (int) SystemClock.uptimeMillis();
        int i67 = i64 + 796745509 + (((~(iUptimeMillis | (-105230645))) | 183334451) * 191) + (((~((~iUptimeMillis) | (-105230645))) | 38088752) * 191);
        int i68 = (i67 << 13) ^ i67;
        int i69 = i68 ^ (i68 >>> 17);
        ((int[]) objArr44[1])[0] = i69 ^ (i69 << 5);
        int i70 = artificialFrame + 7;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
        int i71 = i70 % 2;
    }

    static {
        byte[] bArr = new byte[698];
        System.arraycopy(" \f/3ò\u0000=Êû\u00021´\tÿ<¹ý\u0000\u000b\u0002ò=Çí\u000fõøÿCçÕø\tóù%ëýÿñ\u000bõ\tü\u001eÍ\u000fõøüþüðþ\u0010íü\t\u0001û\u0004ø\u0006ó$Ò\u000fò\u0006ò\u0000=Åöþ\u0006ù\u00055Éò\u0000þüÿ>Éò\u0001þ\u0005\u0000íDßêï!êô\u0004ñ'Ùø\rñ\u0002\u000bó\u001dêïJáÝíý\u0000\u000füí\u001bð\u0002ô\u001eäê2Õø\u0000÷þÁù8»\u0000úCÀû\u0006\u0003ÿüö;Éòû\u000b5¹\u0001\u00059éÈ\u0014õ\u0001\u0004\u001fË\rþÿñ\u001cà\u000füö\u0004ñò\u0000=º\u0002\u000bïþ\rêÿ\n8Ú\u0002\u000bÏþ-Êÿ\n\u0019Ü\tí\u0007\u0005?ðÒû\u0001øÿ\tù\u0007\u001fÝ\u0001ë\fþüù\u0005\u001aÕò\u0000=Åöþ\u0006ù\u00055Æûõ\u000b\u0001ÿì\f5Éò\u0000ûÿÿ\u0007õøÿCÝÝú\tøÿ\u000bó\u001aÜ\u0001÷\u000b\u0003ýñLþÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001-ò\u0000=µ\u0000ÿ\u0007\b1Èî\u000e4èî\u000e\u0001Ëþ\u0000\u0007\u0005ëÿ\rò\u0000=Åöþ\u0006ù\u00055Ëï\u00059ÛÚ\u0004ù\u0011\u000fÜ\u0001ù\u0003ò\u0000=Æ\u0003üü\u0001ñþ\u0002;º\u000b\u0002üíDÉò\u0000þüÿ>¿\nï\fë\rþÿñBÕã\u0007ó\u0011ýô\u0005\u0016êï,Ë\rþÿñLÕêï,Ë\rþÿñ+Õø\u0000÷òû\u0001øÿ\tù\u0007 Ï\u000b\u0002ë\tøÿò\u0000=Æ\u0003üü\u0001ñþ\u0002;Ãú\nø\u0000ó\u0005÷\t÷\u0001ù\u00075Éòû\u000b5ÜÜ\u0001\tí\u0010üñ\u001dìòú\u000eõ\tü\u001dãüí\u0003û÷SßÒ\u0000û\rñ\u0003øÿúù\u0006\u0001ùôHÉòû\u0001øÿ\tù\u0007ðCÆøûöGæØûö*Õ\u0013þ\u0011áú\u0002ó'ÕN®\u0011ô\u0004\fíýû\u0005?¶\tò\tü\u0001;ì\u0010þ¹ù\u0000\u0001ù\u0007ÿ>¿ò\u0001þ\u0005\u0000í\u001bíýû\u0005?ñ\u000bñò\u0000=Æ\u0003üü\u0001ñþ\u0002;º\u000b\u0002üíD·\nú\nñ\u000bø\u0000ñBÓè\u0006\u0004\u0011Ý\tý\u0013ßþ\u0001FþÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001/\u0002\u0001òþ\u0002;\u0003Ãùø\rñ\u0002\u000bó<¼\u0002\të\fõû\u0003=Ëñ\bð\u0001\u0004\u00034èÝýÿñþ\u000bÿ\u000fâ\nö\u0004ï1Û\u0001ïú\rñ".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 698);
        $$d = bArr;
        $$e = 133;
        $$a = new byte[]{81, -123, 100, Ascii.RS, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2};
        $$b = 13;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        validateRelationship = new char[]{56286, 56265, 56275, 56269, 56264, 56278, 56201, 56268, 56300, 56262, 56259, 56274, 56266, 56316, 56267, 56284, 56276, 56271, 56301, 56318, 56257, 56291, 56279, 56258, 56277, 56272, 56311, 56273, 56206, 56192, 56205, 56204, 56198, 56194, 56207, 56193, 56199, 56195, 56285};
        warmup = -1044259905;
        requestPostMessageChannelWithExtras = true;
        ICustomTabsServiceDefault = true;
    }
}
