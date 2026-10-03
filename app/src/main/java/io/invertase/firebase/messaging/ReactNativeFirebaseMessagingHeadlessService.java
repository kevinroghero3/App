package io.invertase.firebase.messaging;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.firebase.messaging.RemoteMessage;
import com.google.maps.android.ui.AnimationUtil;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import o.ArtificialStackFrames;
import o.extraCallback;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeFirebaseMessagingHeadlessService extends HeadlessJsTaskService {
    private static final byte[] $$d;
    private static final int $$e;
    private static final byte[] $$j;
    private static final int $$k;
    private static final byte[] $$l = {SignedBytes.MAX_POWER_OF_TWO, -32, 40, -103};
    private static final int $$m = 44;
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] ArtificialStackFrames = null;
    private static final String TASK_KEY = "ReactNativeFirebaseMessagingHeadlessTask";
    private static final long TIMEOUT_DEFAULT = 60000;
    private static final String TIMEOUT_JSON_KEY = "messaging_android_headless_task_timeout";
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$n(int r5, short r6, byte r7) {
        /*
            int r5 = r5 + 97
            int r7 = r7 * 4
            int r7 = r7 + 4
            byte[] r0 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.$$l
            int r6 = r6 * 3
            int r1 = 1 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L16
            r4 = r6
            r3 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L22:
            int r3 = r3 + 1
            r4 = r0[r7]
        L26:
            int r4 = -r4
            int r5 = r5 + r4
            int r7 = r7 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.$$n(int, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void d(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.$$d
            int r7 = 112 - r7
            int r8 = r8 + 8
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r8
            r4 = r2
            goto L24
        L10:
            r3 = r2
        L11:
            int r6 = r6 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            r3 = r0[r6]
        L24:
            int r7 = r7 + r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.d(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void f(int r5, short r6, int r7, java.lang.Object[] r8) {
        /*
            int r6 = 711 - r6
            int r7 = 111 - r7
            int r0 = r5 + 3
            byte[] r1 = io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.$$j
            byte[] r0 = new byte[r0]
            int r5 = r5 + 2
            r2 = 0
            if (r1 != 0) goto L13
            r7 = r5
            r4 = r6
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r5) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r6]
        L25:
            int r6 = r6 + 1
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.ReactNativeFirebaseMessagingHeadlessService.f(int, short, int, java.lang.Object[]):void");
    }

    @Override // com.facebook.react.HeadlessJsTaskService
    @Nullable
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        if (intent.getExtras() == null) {
            return null;
        }
        return new HeadlessJsTaskConfig(TASK_KEY, ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap((RemoteMessage) intent.getParcelableExtra("message")), ReactNativeFirebaseJSON.getSharedInstance().getLongValue(TIMEOUT_JSON_KEY, 60000L), true);
    }

    private static void e(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int length;
        char[] cArr2;
        int i3;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr3 = ArtificialStackFrames;
        int i5 = -1819279892;
        if (cArr3 != null) {
            int i6 = $10 + 101;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
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
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 20489), TextUtils.lastIndexOf("", '0', 0) + 2149, 216710116, false, $$n(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr2[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i3++;
                    i5 = -1819279892;
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
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            byte b4 = (byte) 0;
            byte b5 = b4;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getTapTimeout() >> 16), (char) (KeyEvent.keyCodeFromString("") + 20488), 2147 - ((byte) KeyEvent.getModifierMetaStateMask()), 216710116, false, $$n(b4, b5, b5), new Class[]{Integer.TYPE});
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
            int i7 = $10 + 87;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    try {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 5;
                            byte b7 = (byte) (b6 - 5);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 46, (char) (Color.argb(0, 0, 0, 0) + 58859), 2464 - ((Process.getThreadPriority(0) + 20) >> 6), 276640984, false, $$n(b6, b7, b7), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i9 = $11 + 79;
                            $10 = i9 % 128;
                            int i10 = i9 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b8 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 24, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getJumpTapTimeout() >> 16) + 792, -834291897, false, $$n((byte) ($$m & 26), b8, b8), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i11 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr3[iIntValue];
                            cArr4[extracallback.a + 1] = cArr3[i11];
                        } else if (extracallback.b == extracallback.d) {
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i12 = (extracallback.b * cCharValue) + extracallback.j;
                            int i13 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr3[i12];
                            cArr4[extracallback.a + 1] = cArr3[i13];
                        } else {
                            int i14 = (extracallback.b * cCharValue) + extracallback.g;
                            int i15 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr3[i14];
                            cArr4[extracallback.a + 1] = cArr3[i15];
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
                int i16 = $11 + 3;
                $10 = i16 % 128;
                int i17 = i16 % 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:16:0x0261 A[Catch: all -> 0x0afa, TryCatch #0 {all -> 0x0afa, blocks: (B:54:0x07e8, B:56:0x0808, B:57:0x0859, B:14:0x024d, B:16:0x0261, B:17:0x0294), top: B:94:0x024d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:25:0x0390  */
    /* JADX WARN: Code duplicated, block: B:53:0x0724  */
    /* JADX WARN: Code duplicated, block: B:56:0x0808 A[Catch: all -> 0x0afa, TryCatch #0 {all -> 0x0afa, blocks: (B:54:0x07e8, B:56:0x0808, B:57:0x0859, B:14:0x024d, B:16:0x0261, B:17:0x0294), top: B:94:0x024d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x086b  */
    /* JADX WARN: Code duplicated, block: B:65:0x093a  */
    @Override // com.facebook.react.HeadlessJsTaskService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int iResolveSize = 26 - View.resolveSize(0, 0);
            char c = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
            int iIndexOf = 1041 - TextUtils.indexOf("", "", 0, 0);
            byte[] bArr = $$d;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            d(b, (byte) (b + 1), bArr[21], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize, c, iIndexOf, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387925L;
            Object[] objArr3 = new Object[1];
            e((byte) (102 - TextUtils.lastIndexOf("", '0', 0)), 23 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            e((byte) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 17), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int touchSlop = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                    char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int doubleTapTimeout = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    byte[] bArr2 = $$d;
                    byte b2 = (byte) (-bArr2[11]);
                    byte b3 = bArr2[21];
                    Object[] objArr5 = new Object[1];
                    d(b2, (byte) (b3 - 1), b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(touchSlop, fadingEdgeLength, doubleTapTimeout, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i5 = ~i4;
                int i6 = (((333539368 + (((~((-145953077) | i5)) | 67849269) * (-865))) + ((~(i4 | 145953076)) * 865)) + (((~(67849269 | i5)) | (~(i5 | 145953076))) * 865)) - 254190456;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                e((byte) (25 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, new char[]{4, '\t', '.', '\f', 30, '\"', '\b', 18, '$', 31, 31, 20, 26, 0, Typography.amp, 1}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 32), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{15, 7, '+', 22, 0, 19, 3, 19, 18, '\f', 22, 24, 26, '$', 15, '+'}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {1894493619};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (KeyEvent.normalizeMetaState(0) + 22251), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -254190456, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int modifierMetaStateMask = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
                        char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                        int i9 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040;
                        byte[] bArr3 = $$d;
                        byte b4 = (byte) (-bArr3[11]);
                        byte b5 = bArr3[21];
                        Object[] objArr10 = new Object[1];
                        d(b4, (byte) (b5 - 1), b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, absoluteGravity, i9, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        e((byte) (103 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 18), 15 - (Process.myPid() >> 22), new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                            char cBlue = (char) Color.blue(0);
                            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 1041;
                            byte[] bArr4 = $$d;
                            byte b6 = bArr4[5];
                            Object[] objArr13 = new Object[1];
                            d(b6, (byte) (b6 + 1), bArr4[21], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, cBlue, packedPositionType, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            e((byte) (25 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 99, new char[]{4, '\t', '.', '\f', 30, '\"', '\b', 18, '$', 31, 31, 20, 26, 0, Typography.amp, 1}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 32), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{15, 7, '+', 22, 0, 19, 3, 19, 18, '\f', 22, 24, 26, '$', 15, '+'}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {1894493619};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (KeyEvent.normalizeMetaState(0) + 22251), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -254190456, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int modifierMetaStateMask2 = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
                char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                int i10 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040;
                byte[] bArr5 = $$d;
                byte b7 = (byte) (-bArr5[11]);
                byte b8 = bArr5[21];
                Object[] objArr17 = new Object[1];
                d(b7, (byte) (b8 - 1), b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, absoluteGravity2, i10, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            e((byte) (103 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 18), 15 - (Process.myPid() >> 22), new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                char cBlue2 = (char) Color.blue(0);
                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 1041;
                byte[] bArr6 = $$d;
                byte b9 = bArr6[5];
                Object[] objArr110 = new Object[1];
                d(b9, (byte) (b9 + 1), bArr6[21], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, cBlue2, packedPositionType2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i12 == i11) {
            int i13 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
            int i14 = i13 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i18 = ~iIdentityHashCode;
            int i19 = i15 + (-158433714) + (((~(238430714 | i18)) | 281658881) * 168) + ((~((-281658882) | iIdentityHashCode)) * 168) + (((~(iIdentityHashCode | 520089595)) | (~(i18 | (-316534522))) | 34875640) * 168);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[1])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i22 = 0;
                while (i22 < strArr3.length) {
                    int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                    artificialFrame = i23 % 128;
                    if (i23 % 2 == 0) {
                        arrayList.add(strArr3[i22]);
                        i22 += 75;
                    } else {
                        arrayList.add(strArr3[i22]);
                        i22++;
                    }
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-1179093636)) << 32) ^ ((long) (i11 ^ i12))), Long.valueOf(-1179093634)};
                byte[] bArr7 = $$j;
                Object[] objArr22 = new Object[1];
                f((byte) (bArr7[367] - 1), (short) TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, bArr7[4], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b10 = bArr7[4];
                Object[] objArr23 = new Object[1];
                f(b10, (short) (b10 | 653), (byte) (-bArr7[490]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i27 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                int i28 = ~i27;
                int i29 = i24 + (-872483328) + ((63955548 | i28) * (-757)) + ((~((-1048739) | i27)) * 1514) + (((~(i27 | 65004286)) | (~(i28 | (-14148259))) | 13099520) * 757);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr24[1])[0] = i31 ^ (i31 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int i32 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
            char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
            int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 816;
            byte[] bArr8 = $$d;
            byte b11 = bArr8[5];
            Object[] objArr25 = new Object[1];
            d(b11, (byte) (b11 + 1), bArr8[21], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i32, cResolveSize, fadingEdgeLength2, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1863;
            Object[] objArr26 = new Object[1];
            e((byte) (Color.rgb(0, 0, 0) + 16777319), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 19), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i33 = artificialFrame + 67;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                int i34 = i33 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int size = 25 - View.MeasureSpec.getSize(0);
                    char gidForName = (char) (30067 - Process.getGidForName(""));
                    int i35 = 817 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr9 = $$d;
                    byte b12 = (byte) (-bArr9[11]);
                    byte b13 = bArr9[21];
                    Object[] objArr28 = new Object[1];
                    d(b12, (byte) (b13 - 1), b13, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(size, gidForName, i35, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i36 = ((int[]) objArr29[0])[0];
                int i37 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i38 = ~System.identityHashCode(this);
                int i39 = ((((~((-426527661) | i38)) | 274727712) * (-241)) - 1328005380) + (((~(i38 | (-151799949))) | (-503083007)) * 241) + 1481007131;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr[3])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 83), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 30, new char[]{4, '\t', '.', '\f', 30, '\"', '\b', 18, '$', 31, 31, 20, 26, 0, Typography.amp, 1}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 63), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{15, 7, '+', 22, 0, 19, 3, 19, 18, '\f', 22, 24, 26, '$', 15, '+'}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 1481007131};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                    char size2 = (char) (View.MeasureSpec.getSize(0) + 30068);
                    int packedPositionType3 = ExpandableListView.getPackedPositionType(0L) + 816;
                    byte[] bArr10 = $$d;
                    Object[] objArr33 = new Object[1];
                    d(bArr10[19], (byte) (bArr10[76] - 1), bArr10[35], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, size2, packedPositionType3, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                    char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                    int scrollDefaultDelay = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    byte[] bArr11 = $$d;
                    byte b14 = (byte) (-bArr11[11]);
                    byte b15 = bArr11[21];
                    Object[] objArr34 = new Object[1];
                    d(b14, (byte) (b15 - 1), b15, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cCombineMeasuredStates, scrollDefaultDelay, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    e((byte) (102 - ((byte) KeyEvent.getModifierMetaStateMask())), TextUtils.indexOf((CharSequence) "", '0', 0) + 23, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 13), 15 - (Process.myTid() >> 22), new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int fadingEdgeLength3 = 25 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        char bitsPerPixel = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
                        int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 816;
                        byte[] bArr12 = $$d;
                        byte b16 = bArr12[5];
                        Object[] objArr37 = new Object[1];
                        d(b16, (byte) (b16 + 1), bArr12[21], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength3, bitsPerPixel, maxKeyCode, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 83), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 30, new char[]{4, '\t', '.', '\f', 30, '\"', '\b', 18, '$', 31, 31, 20, 26, 0, Typography.amp, 1}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 63), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, new char[]{15, 7, '+', 22, 0, 19, 3, 19, 18, '\f', 22, 24, 26, '$', 15, '+'}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 1481007131};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                char size3 = (char) (View.MeasureSpec.getSize(0) + 30068);
                int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 816;
                byte[] bArr13 = $$d;
                Object[] objArr311 = new Object[1];
                d(bArr13[19], (byte) (bArr13[76] - 1), bArr13[35], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, size3, packedPositionType4, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int scrollDefaultDelay2 = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte[] bArr14 = $$d;
                byte b17 = (byte) (-bArr14[11]);
                byte b18 = bArr14[21];
                Object[] objArr312 = new Object[1];
                d(b17, (byte) (b18 - 1), b18, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cCombineMeasuredStates2, scrollDefaultDelay2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            e((byte) (102 - ((byte) KeyEvent.getModifierMetaStateMask())), TextUtils.indexOf((CharSequence) "", '0', 0) + 23, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 13), 15 - (Process.myTid() >> 22), new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int fadingEdgeLength4 = 25 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(0) + 30069);
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 816;
                byte[] bArr15 = $$d;
                byte b19 = bArr15[5];
                Object[] objArr315 = new Object[1];
                d(b19, (byte) (b19 + 1), bArr15[21], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength4, bitsPerPixel2, maxKeyCode2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i42 = ((int[]) objArr[1])[0];
        int i43 = ((int[]) objArr[0])[0];
        if (i43 == i42) {
            int i44 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i44 % 128;
            int i45 = i44 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i46 = ((int[]) objArr[3])[0];
            int i47 = ((int[]) objArr[0])[0];
            int i48 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i49 = ~iIdentityHashCode2;
            int i50 = i46 + 425930034 + (((~((-958447084) | i49)) | (-760274718)) * 519) + (((~(i49 | (-687906058))) | (~((-72368661) | iIdentityHashCode2))) * (-519)) + (((~(iIdentityHashCode2 | (-760274718))) | 958447083) * 519);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[3])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i53 = 0;
            while (i53 < strArr7.length) {
                int i54 = artificialFrame + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i54 % 128;
                int i55 = i54 % 2;
                arrayList2.add(strArr7[i53]);
                i53++;
                int i56 = artificialFrame + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                int i57 = i56 % 2;
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) (-1779891141)) << 32) ^ ((long) (i42 ^ i43))), Long.valueOf(-1779891142)};
        byte[] bArr16 = $$j;
        Object[] objArr42 = new Object[1];
        f((byte) (bArr16[140] + 1), (short) 651, bArr16[103], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = bArr16[4];
        Object[] objArr43 = new Object[1];
        f(b20, (short) (b20 | 653), (byte) (-bArr16[490]), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i58 = ((int[]) objArr[3])[0];
        int i59 = ((int[]) objArr[0])[0];
        int i60 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i61 = ~System.identityHashCode(this);
        int i62 = i58 + (-1995838315) + ((909536723 | i61) * SyslogConstants.LOG_LOCAL7) + (((~(i61 | 570829969)) | 875585874) * SyslogConstants.LOG_LOCAL7);
        int i63 = (i62 << 13) ^ i62;
        int i64 = i63 ^ (i63 >>> 17);
        ((int[]) objArr44[3])[0] = i64 ^ (i64 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:160:0x1160  */
    /* JADX WARN: Code duplicated, block: B:163:0x116a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0281  */
    /* JADX WARN: Code duplicated, block: B:21:0x0287  */
    /* JADX WARN: Code duplicated, block: B:23:0x0321  */
    /* JADX WARN: Code duplicated, block: B:29:0x033b  */
    /* JADX WARN: Code duplicated, block: B:34:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:39:0x0441  */
    /* JADX WARN: Code duplicated, block: B:40:0x0484  */
    @Override // com.facebook.react.HeadlessJsTaskService, android.app.Service
    public void onCreate() throws Throwable {
        Context baseContext;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArr3;
        Object[] objArr4;
        int i3;
        Object[] objArr5;
        Object[] objArr6;
        int i4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr7;
        Object[] objArr8;
        int i5;
        int i6 = 2 % 2;
        Object[] objArr9 = new Object[1];
        e((byte) (103 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', '#', 26, 30, 28, 14, 24, 1, CoreConstants.LEFT_PARENTHESIS_CHAR, 1, 24, CoreConstants.LEFT_PARENTHESIS_CHAR, '/', 22, '0'}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 32), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{CoreConstants.LEFT_PARENTHESIS_CHAR, 29, CharUtils.CR, 4, 22, '#', 11, 15, CoreConstants.SINGLE_QUOTE_CHAR, '\b', CoreConstants.LEFT_PARENTHESIS_CHAR, '\f', 17, 0, 13840}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{4, '\t', '.', '\f', 30, '\"', '\b', 18, '$', 31, 31, 20, 26, 0, Typography.amp, 1}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        e((byte) (67 - (ViewConfiguration.getTapTimeout() >> 16)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 16, new char[]{15, 7, '+', 22, 0, 19, 3, 19, 18, '\f', 22, 24, 26, '$', 15, '+'}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame3 == null) {
            int maximumFlingVelocity = 17 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int iMyTid = (Process.myTid() >> 22) + 747;
            byte[] bArr = $$d;
            byte b = bArr[5];
            Object[] objArr13 = new Object[1];
            d(b, (byte) (b + 1), bArr[21], objArr13);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, keyRepeatTimeout, iMyTid, -144068856, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j != -1) {
            int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
            artificialFrame = i7 % 128;
            if (i7 % 2 != 0 ? j + 4611686018427387857L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : j / 4611686018427387857L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr14 = new Object[1];
                    e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 24), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', CharUtils.CR, 4, 1, '\"', 20, '\"', 0, 19, '*', 19, 3, 19, CoreConstants.PERCENT_CHAR, 25, 29, CoreConstants.PERCENT_CHAR, '\f', '\t'}, objArr14);
                    Class<?> cls = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    e((byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 78), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{21, '\"', 13878, 13878, '+', 22, 6, '\f', 13880, 13880, 28, 19, 25, CharUtils.CR, 0, 19, '$', 19}, objArr15);
                    baseContext = (Context) cls.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    int i8 = artificialFrame + 55;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                    int i9 = i8 % 2;
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                try {
                    Object[] objArr16 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1701094606};
                    byte[] bArr2 = $$j;
                    Object[] objArr17 = new Object[1];
                    f((byte) b.l, (short) 587, bArr2[103], objArr17);
                    Class<?> cls2 = Class.forName((String) objArr17[0]);
                    byte b2 = bArr2[287];
                    Object[] objArr18 = new Object[1];
                    f(b2, (short) (b2 | 462), bArr2[0], objArr18);
                    Object[] objArr19 = (Object[]) cls2.getMethod((String) objArr18[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr16);
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame == null) {
                        int i10 = 18 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        char c = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                        int tapTimeout = 747 - (ViewConfiguration.getTapTimeout() >> 16);
                        byte[] bArr3 = $$d;
                        byte b3 = (byte) (-bArr3[11]);
                        byte b4 = bArr3[21];
                        Object[] objArr20 = new Object[1];
                        d(b3, (byte) (b4 - 1), b4, objArr20);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i10, c, tapTimeout, -1031537386, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr19);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame2 == null) {
                            int i11 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 17;
                            char size = (char) View.MeasureSpec.getSize(0);
                            int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 747;
                            byte[] bArr4 = $$d;
                            byte b5 = bArr4[5];
                            Object[] objArr21 = new Object[1];
                            d(b5, (byte) (b5 + 1), bArr4[21], objArr21);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, size, scrollDefaultDelay, -144068856, false, (String) objArr21[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf);
                        objArr = objArr19;
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
            } else {
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame4 == null) {
                    int doubleTapTimeout = 17 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char c2 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 747;
                    byte[] bArr5 = $$d;
                    byte b6 = (byte) (-bArr5[11]);
                    byte b7 = bArr5[21];
                    Object[] objArr22 = new Object[1];
                    d(b6, (byte) (b7 - 1), b7, objArr22);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, c2, keyRepeatDelay, -1031537386, false, (String) objArr22[0], null);
                }
                Object[] objArr23 = (Object[]) ((Field) objAccessartificialFrame4).get(null);
                objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                int i12 = ((int[]) objArr23[3])[0];
                int i13 = ((int[]) objArr23[4])[0];
                List list = (List) objArr23[0];
                List list2 = (List) objArr23[2];
                int iMyUid = Process.myUid();
                int i14 = ~iMyUid;
                int i15 = (-1832277191) + (((~(i14 | 712006948)) | (~(106558490 | i14)) | (-779746623)) * 464) + (((-673188133) | iMyUid) * (-464)) + (((~(iMyUid | 712006948)) | (-779746623)) * 464) + 1701094606;
                int i16 = (i15 << 13) ^ i15;
                int i17 = i16 ^ (i16 >>> 17);
                ((int[]) objArr[1])[0] = i17 ^ (i17 << 5);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr110 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 24), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', CharUtils.CR, 4, 1, '\"', 20, '\"', 0, 19, '*', 19, 3, 19, CoreConstants.PERCENT_CHAR, 25, 29, CoreConstants.PERCENT_CHAR, '\f', '\t'}, objArr110);
                Class<?> cls3 = Class.forName((String) objArr110[0]);
                Object[] objArr111 = new Object[1];
                e((byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 78), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{21, '\"', 13878, 13878, '+', 22, 6, '\f', 13880, 13880, 28, 19, 25, CharUtils.CR, 0, 19, '$', 19}, objArr111);
                baseContext = (Context) cls3.getMethod((String) objArr111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                int i18 = artificialFrame + 55;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                int i19 = i18 % 2;
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr112 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1701094606};
            byte[] bArr6 = $$j;
            Object[] objArr113 = new Object[1];
            f((byte) b.l, (short) 587, bArr6[103], objArr113);
            Class<?> cls4 = Class.forName((String) objArr113[0]);
            byte b8 = bArr6[287];
            Object[] objArr114 = new Object[1];
            f(b8, (short) (b8 | 462), bArr6[0], objArr114);
            Object[] objArr115 = (Object[]) cls4.getMethod((String) objArr114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr112);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame == null) {
                int i110 = 18 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                char c3 = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                int tapTimeout2 = 747 - (ViewConfiguration.getTapTimeout() >> 16);
                byte[] bArr7 = $$d;
                byte b9 = (byte) (-bArr7[11]);
                byte b10 = bArr7[21];
                Object[] objArr24 = new Object[1];
                d(b9, (byte) (b10 - 1), b10, objArr24);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i110, c3, tapTimeout2, -1031537386, false, (String) objArr24[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr115);
            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame2 == null) {
                int i111 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 17;
                char size2 = (char) View.MeasureSpec.getSize(0);
                int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 747;
                byte[] bArr8 = $$d;
                byte b11 = bArr8[5];
                Object[] objArr25 = new Object[1];
                d(b11, (byte) (b11 + 1), bArr8[21], objArr25);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i111, size2, scrollDefaultDelay2, -144068856, false, (String) objArr25[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf2);
            objArr = objArr115;
        }
        int i20 = ((int[]) objArr[4])[0];
        int i21 = ((int[]) objArr[3])[0];
        if (i21 == i20) {
            Object[] objArr26 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i22 = ((int[]) objArr[1])[0];
            int i23 = ((int[]) objArr[3])[0];
            int i24 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i25 = ~iIdentityHashCode;
            int i26 = i22 + (-260226394) + ((914908681 | i25) * (-757)) + ((~(922353407 | iIdentityHashCode)) * 1514) + (((~(iIdentityHashCode | (-7444727))) | (~(i25 | 309460223)) | 612893184) * 757);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr26[1])[0] = i28 ^ (i28 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                Object[] objArr27 = {objArr};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(41 - KeyEvent.getDeadChar(0, 0), (char) (Color.rgb(0, 0, 0) + 16789684), 3642 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame5).invoke(null, objArr27));
                Object[] objArr28 = {objArr};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame6 == null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 41, (char) (KeyEvent.keyCodeFromString("") + 12468), 3642 - (ViewConfiguration.getScrollBarSize() >> 8), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame6).invoke(null, objArr28));
                try {
                    Object[] objArr29 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-920081795)) << 32)), Long.valueOf(-920081803)};
                    byte[] bArr9 = $$j;
                    Object[] objArr30 = new Object[1];
                    f(bArr9[140], (short) ($$k | 320), bArr9[103], objArr30);
                    Class<?> cls5 = Class.forName((String) objArr30[0]);
                    byte b12 = bArr9[4];
                    Object[] objArr31 = new Object[1];
                    f(b12, (short) (b12 | 653), (byte) (-bArr9[490]), objArr31);
                    cls5.getMethod((String) objArr31[0], Long.TYPE, Long.TYPE).invoke(null, objArr29);
                    Object[] objArr32 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i29 = ((int[]) objArr[1])[0];
                    int i30 = ((int[]) objArr[3])[0];
                    int i31 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int i32 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                    int i33 = i29 + (((1972768808 + (((-268588182) | i32) * (-381))) + (((~((~i32) | (-276034710))) | 620341514) * 381)) - 747118143);
                    int i34 = (i33 << 13) ^ i33;
                    int i35 = i34 ^ (i34 >>> 17);
                    i = 0;
                    ((int[]) objArr32[1])[0] = i35 ^ (i35 << 5);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i36 = (CdmaCellLocation.convertQuartSecToDecDegrees(i) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i) == 0.0d ? 0 : -1)) + 25;
            char c4 = (char) (30069 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
            int trimmedLength = 816 - TextUtils.getTrimmedLength("");
            byte[] bArr10 = $$d;
            byte b13 = bArr10[5];
            Object[] objArr33 = new Object[1];
            d(b13, (byte) (b13 + 1), bArr10[21], objArr33);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i36, c4, trimmedLength, 721586079, false, (String) objArr33[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 == -1 || j2 + 2013 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr34 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 253293989};
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame8 == null) {
                int iIndexOf = 25 - TextUtils.indexOf("", "", 0);
                char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                int capsMode = TextUtils.getCapsMode("", 0, 0) + 816;
                byte[] bArr11 = $$d;
                Object[] objArr35 = new Object[1];
                d(bArr11[19], (byte) (bArr11[76] - 1), bArr11[35], objArr35);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, cLastIndexOf, capsMode, -797394565, false, (String) objArr35[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr34);
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame9 == null) {
                int edgeSlop = 25 - (ViewConfiguration.getEdgeSlop() >> 16);
                char keyRepeatDelay2 = (char) (30068 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                int i37 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                byte[] bArr12 = $$d;
                byte b14 = (byte) (-bArr12[11]);
                byte b15 = bArr12[21];
                Object[] objArr36 = new Object[1];
                d(b14, (byte) (b15 - 1), b15, objArr36);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(edgeSlop, keyRepeatDelay2, i37, 891606461, false, (String) objArr36[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr2);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame10 == null) {
                    int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char cArgb = (char) (Color.argb(0, 0, 0, 0) + 30068);
                    int i38 = 817 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr13 = $$d;
                    byte b16 = bArr13[5];
                    Object[] objArr37 = new Object[1];
                    d(b16, (byte) (b16 + 1), bArr13[21], objArr37);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cArgb, i38, 721586079, false, (String) objArr37[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, lValueOf3);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame11 == null) {
                int trimmedLength2 = 25 - TextUtils.getTrimmedLength("");
                char fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                int i39 = 817 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr14 = $$d;
                byte b17 = (byte) (-bArr14[11]);
                byte b18 = bArr14[21];
                Object[] objArr38 = new Object[1];
                d(b17, (byte) (b18 - 1), b18, objArr38);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(trimmedLength2, fadingEdgeLength, i39, 891606461, false, (String) objArr38[0], null);
            }
            Object[] objArr39 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i40 = ((int[]) objArr39[0])[0];
            int i41 = ((int[]) objArr39[1])[0];
            String[] strArr = (String[]) objArr39[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i42 = 965147799 + (((~(iIdentityHashCode2 | 160401289)) | (-37771077)) * (-465)) + ((160401289 | (~((-37771077) | iIdentityHashCode2))) * 930) + ((iIdentityHashCode2 | (-37769285)) * 465) + 253293989;
            int i43 = (i42 << 13) ^ i42;
            int i44 = i43 ^ (i43 >>> 17);
            ((int[]) objArr2[3])[0] = i44 ^ (i44 << 5);
        }
        int i45 = ((int[]) objArr2[1])[0];
        int i46 = ((int[]) objArr2[0])[0];
        if (i46 == i45) {
            int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
            artificialFrame = i47 % 128;
            int i48 = i47 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i49 = ((int[]) objArr2[3])[0];
            int i50 = ((int[]) objArr2[0])[0];
            int i51 = ((int[]) objArr2[1])[0];
            String[] strArr2 = (String[]) objArr2[2];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i52 = ~iUptimeMillis;
            int i53 = ~((-648047862) | i52);
            int i54 = ~(449875495 | iUptimeMillis);
            int i55 = i49 + (-2081787814) + ((i53 | i54) * 1150) + (((~((-449875496) | i52)) | i54) * (-575)) + (((~(iUptimeMillis | (-648047862))) | (~(i52 | 648047861))) * 575);
            int i56 = (i55 << 13) ^ i55;
            int i57 = i56 ^ (i56 >>> 17);
            i2 = 0;
            ((int[]) objArr40[3])[0] = i57 ^ (i57 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArr2[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList2.add(str5);
                }
            }
            Object[] objArr41 = {Long.valueOf(((long) (i45 ^ i46)) ^ (((long) (-1371804059)) << 32)), Long.valueOf(-1371804060)};
            byte[] bArr15 = $$j;
            Object[] objArr42 = new Object[1];
            f((byte) (bArr15[417] + 1), (short) ($$k | 257), bArr15[103], objArr42);
            Class<?> cls6 = Class.forName((String) objArr42[0]);
            byte b19 = bArr15[4];
            Object[] objArr43 = new Object[1];
            f(b19, (short) (b19 | 653), (byte) (-bArr15[490]), objArr43);
            cls6.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i58 = ((int[]) objArr2[3])[0];
            int i59 = ((int[]) objArr2[0])[0];
            int i60 = ((int[]) objArr2[1])[0];
            String[] strArr4 = (String[]) objArr2[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i61 = i58 + (-292487998) + ((~((-338698757) | iIdentityHashCode3)) * (-301)) + (((~(493892132 | iIdentityHashCode3)) | (~((~iIdentityHashCode3) | 692064498))) * (-301)) + (((~(iIdentityHashCode3 | (-692064499))) | 493892132) * 301);
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            i2 = 0;
            ((int[]) objArr44[3])[0] = i63 ^ (i63 << 5);
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame12 == null) {
            int windowTouchSlop = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            char cCombineMeasuredStates = (char) (49362 - View.combineMeasuredStates(i2, i2));
            int iLastIndexOf = TextUtils.lastIndexOf("", '0', i2, i2) + 685;
            byte b20 = (byte) ($$e & WebSocketProtocol.PAYLOAD_SHORT);
            byte[] bArr16 = $$d;
            Object[] objArr45 = new Object[1];
            d(b20, bArr16[52], bArr16[113], objArr45);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, cCombineMeasuredStates, iLastIndexOf, 752929587, false, (String) objArr45[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 1957 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr46 = new Object[1];
                e((byte) (28 - (Process.myTid() >> 22)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', CharUtils.CR, 4, 1, '\"', 20, '\"', 0, 19, '*', 19, 3, 19, CoreConstants.PERCENT_CHAR, 25, 29, CoreConstants.PERCENT_CHAR, '\f', '\t'}, objArr46);
                Class<?> cls7 = Class.forName((String) objArr46[0]);
                Object[] objArr47 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 43), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 81, new char[]{21, '\"', 13878, 13878, '+', 22, 6, '\f', 13880, 13880, 28, 19, 25, CharUtils.CR, 0, 19, '$', 19}, objArr47);
                baseContext2 = (Context) cls7.getMethod((String) objArr47[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            Object[] objArr48 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1917512122};
            byte[] bArr17 = $$j;
            byte b21 = bArr17[417];
            Object[] objArr49 = new Object[1];
            f(b21, (short) (b21 | 324), bArr17[103], objArr49);
            Class<?> cls8 = Class.forName((String) objArr49[0]);
            byte b22 = bArr17[287];
            Object[] objArr50 = new Object[1];
            f(b22, (short) (b22 | 462), bArr17[0], objArr50);
            objArr3 = (Object[]) cls8.getMethod((String) objArr50[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr48);
            if (baseContext2 != null) {
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame13 == null) {
                    int iIndexOf2 = 30 - TextUtils.indexOf("", "", 0, 0);
                    char windowTouchSlop2 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int offsetBefore = TextUtils.getOffsetBefore("", 0) + 684;
                    byte[] bArr18 = $$d;
                    Object[] objArr51 = new Object[1];
                    d((byte) 41, bArr18[53], bArr18[113], objArr51);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf2, windowTouchSlop2, offsetBefore, 1944867703, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame14 == null) {
                        int iGreen = Color.green(0) + 30;
                        char c5 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int fadingEdgeLength2 = 684 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte b23 = (byte) ($$e & WebSocketProtocol.PAYLOAD_SHORT);
                        byte[] bArr19 = $$d;
                        Object[] objArr52 = new Object[1];
                        d(b23, bArr19[52], bArr19[113], objArr52);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iGreen, c5, fadingEdgeLength2, 752929587, false, (String) objArr52[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, lValueOf4);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame15 == null) {
                int iResolveSize = View.resolveSize(0, 0) + 30;
                char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                int packedPositionType = 684 - ExpandableListView.getPackedPositionType(0L);
                byte[] bArr20 = $$d;
                Object[] objArr53 = new Object[1];
                d((byte) 41, bArr20[53], bArr20[113], objArr53);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iResolveSize, cKeyCodeFromString, packedPositionType, 1944867703, false, (String) objArr53[0], null);
            }
            Object[] objArr54 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr54[0])[0]}, new int[]{((int[]) objArr54[1])[0]}, new int[1], (String) objArr54[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i64 = (~((-207289731) | iIdentityHashCode4)) | 207134080;
            int i65 = ~((~iIdentityHashCode4) | 771489694);
            int i66 = (-452606434) + ((i64 | i65) * (-470)) + (((~(iIdentityHashCode4 | (-155651))) | i65) * 470) + 1917512122;
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr3[2])[0] = i68 ^ (i68 << 5);
        }
        int i69 = ((int[]) objArr3[1])[0];
        int i70 = ((int[]) objArr3[0])[0];
        if (i70 == i69) {
            int i71 = ((int[]) objArr3[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i72 = (~((-472387082) | iElapsedRealtime)) | 472387073;
            int i73 = ~((~iElapsedRealtime) | 506236701);
            int i74 = i71 + (-337751308) + ((i72 | i73) * (-470)) + (((~(iElapsedRealtime | (-9))) | i73) * 470);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr55[2])[0] = i76 ^ (i76 << 5);
        } else {
            long j4 = ((long) (i69 ^ i70)) ^ (((long) 828286030) << 32);
            long j5 = 828286026;
            int i77 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i77 % 128;
            int i78 = i77 % 2;
            Object[] objArr56 = {Long.valueOf(j4), Long.valueOf(j5)};
            byte[] bArr21 = $$j;
            Object[] objArr57 = new Object[1];
            f(bArr21[413], (short) 322, bArr21[103], objArr57);
            Class<?> cls9 = Class.forName((String) objArr57[0]);
            byte b24 = bArr21[4];
            Object[] objArr58 = new Object[1];
            f(b24, (short) (b24 | 653), (byte) (-bArr21[490]), objArr58);
            cls9.getMethod((String) objArr58[0], Long.TYPE, Long.TYPE).invoke(null, objArr56);
            int i79 = ((int[]) objArr3[2])[0];
            Object[] objArr59 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i80 = ~streamMaxVolume;
            int i81 = i79 + (-1508821074) + (((~((-850170389) | i80)) | 44564992 | (~((-128453387) | i80))) * (-1136)) + (((~((-850170389) | streamMaxVolume)) | (~((-128453387) | streamMaxVolume)) | (~(934058782 | i80))) * (-568)) + (((~(streamMaxVolume | (-44564993))) | (~(i80 | 128453386)) | (~(850170388 | i80))) * 568);
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr59[2])[0] = i83 ^ (i83 << 5);
        }
        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame16 == null) {
            int i84 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29;
            char edgeSlop2 = (char) (49362 - (ViewConfiguration.getEdgeSlop() >> 16));
            int offsetAfter = TextUtils.getOffsetAfter("", 0) + 684;
            byte[] bArr22 = $$d;
            Object[] objArr60 = new Object[1];
            d((byte) 56, bArr22[52], bArr22[4], objArr60);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i84, edgeSlop2, offsetAfter, 508509282, false, (String) objArr60[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j6 == -1 || j6 + 1961 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i85 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i85 % 128;
                int i86 = i85 % 2;
                Object[] objArr61 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 86), 25 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', CharUtils.CR, 4, 1, '\"', 20, '\"', 0, 19, '*', 19, 3, 19, CoreConstants.PERCENT_CHAR, 25, 29, CoreConstants.PERCENT_CHAR, '\f', '\t'}, objArr61);
                Class<?> cls10 = Class.forName((String) objArr61[0]);
                Object[] objArr62 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 43), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{21, '\"', 13878, 13878, '+', 22, 6, '\f', 13880, 13880, 28, 19, 25, CharUtils.CR, 0, 19, '$', 19}, objArr62);
                baseContext3 = (Context) cls10.getMethod((String) objArr62[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i87 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                artificialFrame = i87 % 128;
                if (i87 % 2 == 0) {
                    int i88 = 84 / 0;
                    if (baseContext3 instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                            baseContext3 = null;
                        }
                    }
                } else if (baseContext3 instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = null;
                    }
                }
                baseContext3 = baseContext3.getApplicationContext();
            }
            Object[] objArr63 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -466189487};
            byte[] bArr23 = $$j;
            Object[] objArr64 = new Object[1];
            f(bArr23[99], (short) 288, bArr23[31], objArr64);
            Class<?> cls11 = Class.forName((String) objArr64[0]);
            Object[] objArr65 = new Object[1];
            f(bArr23[643], (short) 259, bArr23[96], objArr65);
            objArr4 = (Object[]) cls11.getMethod((String) objArr65[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr63);
            if (baseContext3 != null) {
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame17 == null) {
                    int i89 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                    char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 49362);
                    int iMakeMeasureSpec = 684 - View.MeasureSpec.makeMeasureSpec(0, 0);
                    byte[] bArr24 = $$d;
                    Object[] objArr66 = new Object[1];
                    d((byte) 68, bArr24[113], (byte) (bArr24[21] - 1), objArr66);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i89, cResolveOpacity, iMakeMeasureSpec, -1321816393, false, (String) objArr66[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr4);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame18 == null) {
                        int iRgb = Color.rgb(0, 0, 0) + 16777246;
                        char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49361);
                        int i90 = 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte[] bArr25 = $$d;
                        Object[] objArr67 = new Object[1];
                        d((byte) 56, bArr25[52], bArr25[4], objArr67);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iRgb, c6, i90, 508509282, false, (String) objArr67[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf5);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame19 == null) {
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
                char cMyTid = (char) ((Process.myTid() >> 22) + 49362);
                int iRgb2 = (-16776532) - Color.rgb(0, 0, 0);
                byte[] bArr26 = $$d;
                Object[] objArr68 = new Object[1];
                d((byte) 68, bArr26[113], (byte) (bArr26[21] - 1), objArr68);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cMyTid, iRgb2, -1321816393, false, (String) objArr68[0], null);
            }
            Object[] objArr69 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr69[0])[0]}, new int[]{((int[]) objArr69[1])[0]}, new int[1], (String) objArr69[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i91 = ((((-915248112) + (((~((~iIdentityHashCode5) | (-850442727))) | 128181048) * (-235))) + (((~((-850442727) | iIdentityHashCode5)) | 128181048) * (-470))) + (((~(iIdentityHashCode5 | (-806361287))) | 84099608) * 235)) - 466189487;
            int i92 = (i91 << 13) ^ i91;
            int i93 = i92 ^ (i92 >>> 17);
            ((int[]) objArr4[2])[0] = i93 ^ (i93 << 5);
        }
        int i94 = ((int[]) objArr4[1])[0];
        int i95 = ((int[]) objArr4[0])[0];
        if (i95 == i94) {
            int i96 = ((int[]) objArr4[2])[0];
            Object[] objArr70 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i97 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i98 = ~i97;
            int i99 = i96 + (-158063010) + (((~(i98 | 219651553)) | (~((-758972222) | i98)) | 539517468) * 464) + (((-219454754) | i97) * (-464)) + (((~(i97 | 219651553)) | 539517468) * 464);
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            ((int[]) objArr70[2])[0] = i101 ^ (i101 << 5);
            i3 = 0;
        } else {
            Object[] objArr71 = {Long.valueOf(((long) (i94 ^ i95)) ^ (((long) (-1977794017)) << 32)), Long.valueOf(-1977794529)};
            byte[] bArr27 = $$j;
            byte b25 = bArr27[499];
            Object[] objArr72 = new Object[1];
            f(b25, (short) (b25 | 175), bArr27[103], objArr72);
            Class<?> cls12 = Class.forName((String) objArr72[0]);
            byte b26 = bArr27[4];
            Object[] objArr73 = new Object[1];
            f(b26, (short) (b26 | 653), (byte) (-bArr27[490]), objArr73);
            cls12.getMethod((String) objArr73[0], Long.TYPE, Long.TYPE).invoke(null, objArr71);
            int i102 = ((int[]) objArr4[2])[0];
            Object[] objArr74 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyTid2 = Process.myTid();
            int i103 = i102 + 1934524690 + ((~((-10488521) | iMyTid2)) * 623) + (((~iMyTid2) | 956502036) * (-623)) + (((~(iMyTid2 | 962318645)) | (~((-16305130) | iMyTid2)) | 10488520) * 623);
            int i104 = (i103 << 13) ^ i103;
            int i105 = i104 ^ (i104 >>> 17);
            i3 = 0;
            ((int[]) objArr74[2])[0] = i105 ^ (i105 << 5);
        }
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame20 == null) {
            int absoluteGravity = 30 - Gravity.getAbsoluteGravity(i3, i3);
            char c7 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49361);
            int mode = 684 - View.MeasureSpec.getMode(i3);
            byte[] bArr28 = $$d;
            Object[] objArr75 = new Object[1];
            d((byte) 75, bArr28[53], bArr28[4], objArr75);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c7, mode, -1583976536, false, (String) objArr75[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j7 == -1 || j7 + 1920 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr76 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 870431785};
            byte[] bArr29 = $$j;
            Object[] objArr77 = new Object[1];
            f(bArr29[619], (short) ($$k | 33), bArr29[103], objArr77);
            Class<?> cls13 = Class.forName((String) objArr77[0]);
            byte b27 = bArr29[287];
            Object[] objArr78 = new Object[1];
            f(b27, (short) (b27 | 462), bArr29[0], objArr78);
            objArr5 = (Object[]) cls13.getMethod((String) objArr78[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr76);
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame21 == null) {
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 30;
                char maxKeyCode = (char) ((KeyEvent.getMaxKeyCode() >> 16) + 49362);
                int bitsPerPixel = 683 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr30 = $$d;
                Object[] objArr79 = new Object[1];
                d((byte) 87, (byte) (-bArr30[11]), bArr30[21], objArr79);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(scrollBarSize, maxKeyCode, bitsPerPixel, -1456483158, false, (String) objArr79[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, objArr5);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame22 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 30;
                    char maximumDrawingCacheSize = (char) (49362 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 684;
                    byte[] bArr31 = $$d;
                    Object[] objArr80 = new Object[1];
                    d((byte) 75, bArr31[53], bArr31[4], objArr80);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(offsetBefore2, maximumDrawingCacheSize, packedPositionType2, -1583976536, false, (String) objArr80[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, lValueOf6);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame23 == null) {
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 31;
                char cResolveOpacity2 = (char) (49362 - Drawable.resolveOpacity(0, 0));
                int iAxisFromString = 683 - MotionEvent.axisFromString("");
                byte[] bArr32 = $$d;
                Object[] objArr81 = new Object[1];
                d((byte) 87, (byte) (-bArr32[11]), bArr32[21], objArr81);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cResolveOpacity2, iAxisFromString, -1456483158, false, (String) objArr81[0], null);
            }
            Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr82[0])[0]}, new int[]{((int[]) objArr82[1])[0]}, new int[1], (String) objArr82[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i106 = (-1213104510) + (((~iIdentityHashCode6) | (-959126047)) * 1444) + (((~(iIdentityHashCode6 | 162976656)) | (~(815647118 | iIdentityHashCode6)) | (-968874911)) * (-1444)) + 1869702341;
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr5[2])[0] = i108 ^ (i108 << 5);
        }
        int i109 = ((int[]) objArr5[1])[0];
        int i112 = ((int[]) objArr5[0])[0];
        if (i112 == i109) {
            int i113 = ((int[]) objArr5[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i114 = 937233194 + (((~((-185357613) | iIdentityHashCode7)) | (-793266163)) * (-318));
            int i115 = ~((-793266163) | iIdentityHashCode7);
            int i116 = ~iIdentityHashCode7;
            int i117 = i113 + i114 + ((i115 | (~(793532414 | i116))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(iIdentityHashCode7 | 793532414)) | (~((-608174803) | i116))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i118 = (i117 << 13) ^ i117;
            int i119 = i118 ^ (i118 >>> 17);
            ((int[]) objArr83[2])[0] = i119 ^ (i119 << 5);
        } else {
            new ArrayList().add((String) objArr5[3]);
            Object[] objArr84 = {Long.valueOf(((long) (i109 ^ i112)) ^ (((long) (-1279714454)) << 32)), Long.valueOf(-1279714438)};
            byte[] bArr33 = $$j;
            Object[] objArr85 = new Object[1];
            f((byte) (-bArr33[100]), (short) 117, bArr33[103], objArr85);
            Class<?> cls14 = Class.forName((String) objArr85[0]);
            byte b28 = bArr33[4];
            Object[] objArr86 = new Object[1];
            f(b28, (short) (b28 | 653), (byte) (-bArr33[490]), objArr86);
            cls14.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
            int i120 = ((int[]) objArr5[2])[0];
            Object[] objArr87 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i121 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 324865169;
            int i122 = ~i121;
            int i123 = i120 + 1699670302 + (((~(i122 | 545627247)) | (~((-432996528) | i122)) | 424280192) * 464) + (((-8716336) | i121) * (-464)) + (((~(i121 | 545627247)) | 424280192) * 464);
            int i124 = (i123 << 13) ^ i123;
            int i125 = i124 ^ (i124 >>> 17);
            ((int[]) objArr87[2])[0] = i125 ^ (i125 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame24 == null) {
            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 36;
            char scrollBarFadeDuration = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            int threadPriority = 540 - ((Process.getThreadPriority(0) + 20) >> 6);
            byte[] bArr34 = $$d;
            byte b29 = bArr34[5];
            Object[] objArr88 = new Object[1];
            d(b29, (byte) (b29 + 1), bArr34[21], objArr88);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarFadeDuration, threadPriority, 624296913, false, (String) objArr88[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j8 == -1 || j8 + 1894 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame25 == null) {
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(20 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (39517 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 982 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 117222168, false, null, new Class[0]);
            }
            Object[] objArr89 = {null, ((Constructor) objAccessartificialFrame25).newInstance(null), 1297783843, 0};
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame26 == null) {
                int capsMode2 = 36 - TextUtils.getCapsMode("", 0, 0);
                char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                int iMyTid3 = (Process.myTid() >> 22) + 540;
                byte b30 = (byte) 95;
                Object[] objArr90 = new Object[1];
                d(b30, (byte) (b30 >>> 1), $$d[30], objArr90);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(capsMode2, cAxisFromString, iMyTid3, 2101703389, false, (String) objArr90[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 54, (char) (834 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 576 - Color.red(0)), (Class) ArtificialStackFrames.coroutineCreation(Color.red(0) + 54, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 630), Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr89);
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame27 == null) {
                int defaultSize = View.getDefaultSize(0, 0) + 36;
                char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                int iMyPid = (Process.myPid() >> 22) + 540;
                byte[] bArr35 = $$d;
                byte b31 = (byte) (-bArr35[11]);
                byte b32 = bArr35[21];
                Object[] objArr91 = new Object[1];
                d(b31, (byte) (b32 - 1), b32, objArr91);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(defaultSize, cArgb2, iMyPid, 793268735, false, (String) objArr91[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr6);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame28 == null) {
                    int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 36;
                    char cResolveSize = (char) View.resolveSize(0, 0);
                    int fadingEdgeLength3 = 540 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    byte[] bArr36 = $$d;
                    byte b33 = bArr36[5];
                    Object[] objArr92 = new Object[1];
                    d(b33, (byte) (b33 + 1), bArr36[21], objArr92);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(edgeSlop3, cResolveSize, fadingEdgeLength3, 624296913, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame29 == null) {
                int trimmedLength3 = 36 - TextUtils.getTrimmedLength("");
                char cArgb3 = (char) Color.argb(0, 0, 0, 0);
                int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 540;
                byte[] bArr37 = $$d;
                byte b34 = (byte) (-bArr37[11]);
                byte b35 = bArr37[21];
                Object[] objArr93 = new Object[1];
                d(b34, (byte) (b35 - 1), b35, objArr93);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(trimmedLength3, cArgb3, capsMode3, 793268735, false, (String) objArr93[0], null);
            }
            Object[] objArr94 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr6 = new Object[]{new int[1], new int[1], new int[1]};
            int i126 = ((int[]) objArr94[2])[0];
            int i127 = ((int[]) objArr94[1])[0];
            ((int[]) objArr6[2])[0] = i126;
            ((int[]) objArr6[1])[0] = i127;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i128 = ((((~((-834702069) | iIdentityHashCode8)) | 789519221) * 262) - 660576775) + (((~((~iIdentityHashCode8) | (-834702069))) | 789519221) * 262) + 1297783843;
            int i129 = (i128 << 13) ^ i128;
            int i130 = i129 ^ (i129 >>> 17);
            ((int[]) objArr6[0])[0] = i130 ^ (i130 << 5);
        }
        Object obj = objArr6[1];
        int i131 = ((int[]) obj)[0];
        Object obj2 = objArr6[2];
        int i132 = ((int[]) obj2)[0];
        if (i132 == i131) {
            Object[] objArr95 = {new int[1], new int[1], new int[1]};
            int i133 = ((int[]) objArr6[0])[0];
            int i134 = ((int[]) obj2)[0];
            int i135 = ((int[]) obj)[0];
            ((int[]) objArr95[2])[0] = i134;
            ((int[]) objArr95[1])[0] = i135;
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i136 = i133 + (-1933244831) + (((~(1064303215 | iIdentityHashCode9)) | 287318534) * (-756)) + (((~iIdentityHashCode9) | 1064303215) * 756);
            int i137 = (i136 << 13) ^ i136;
            int i138 = i137 ^ (i137 >>> 17);
            ((int[]) objArr95[0])[0] = i138 ^ (i138 << 5);
            int i139 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
            artificialFrame = i139 % 128;
            int i140 = i139 % 2;
            i4 = 0;
        } else {
            Object[] objArr96 = {Long.valueOf((((long) (-970378785)) << 32) ^ ((long) (i131 ^ i132))), Long.valueOf(-970382881)};
            byte[] bArr38 = $$j;
            Object[] objArr97 = new Object[1];
            f((byte) (-bArr38[100]), (short) 117, bArr38[103], objArr97);
            Class<?> cls15 = Class.forName((String) objArr97[0]);
            byte b36 = bArr38[4];
            Object[] objArr98 = new Object[1];
            f(b36, (short) (b36 | 653), (byte) (-bArr38[490]), objArr98);
            cls15.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            Object[] objArr99 = {new int[1], new int[1], new int[1]};
            int i141 = ((int[]) objArr6[0])[0];
            int i142 = ((int[]) objArr6[2])[0];
            int i143 = ((int[]) objArr6[1])[0];
            ((int[]) objArr99[2])[0] = i142;
            ((int[]) objArr99[1])[0] = i143;
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i144 = 5205779 + (((~((-256244159) | iIdentityHashCode10)) | 235264264 | (~(1095377591 | iIdentityHashCode10))) * (-754));
            int i145 = ~((-235264265) | iIdentityHashCode10);
            int i146 = ~iIdentityHashCode10;
            int i147 = i141 + i144 + ((i145 | (~(1330641855 | i146))) * (-754)) + ((i146 | (-256244159)) * 754);
            int i148 = (i147 << 13) ^ i147;
            int i149 = i148 ^ (i148 >>> 17);
            i4 = 0;
            ((int[]) objArr99[0])[0] = i149 ^ (i149 << 5);
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame30 == null) {
            int i150 = 26 - (CdmaCellLocation.convertQuartSecToDecDegrees(i4) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i4) == 0.0d ? 0 : -1));
            char c8 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(i4) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i4) == 0.0d ? 0 : -1));
            int i151 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1040;
            byte[] bArr39 = $$d;
            byte b37 = bArr39[5];
            Object[] objArr100 = new Object[1];
            d(b37, (byte) (b37 + 1), bArr39[21], objArr100);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(i150, c8, i151, 2061780482, false, (String) objArr100[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j9 == -1 || j9 + 4611686018427387820L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr101 = {-1385452271};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame31 == null) {
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 9, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 22250), 1033 - (KeyEvent.getMaxKeyCode() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame31).newInstance(objArr101), 341025299, false);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame32 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 27;
                char maximumDrawingCacheSize2 = (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int i152 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                byte[] bArr40 = $$d;
                byte b38 = (byte) (-bArr40[11]);
                byte b39 = bArr40[21];
                Object[] objArr102 = new Object[1];
                d(b38, (byte) (b39 - 1), b39, objArr102);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, maximumDrawingCacheSize2, i152, 1145017376, false, (String) objArr102[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame33 == null) {
                    int iAxisFromString2 = MotionEvent.axisFromString("") + 27;
                    char c9 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1);
                    int packedPositionChild = 1040 - ExpandableListView.getPackedPositionChild(0L);
                    byte[] bArr41 = $$d;
                    byte b40 = bArr41[5];
                    Object[] objArr103 = new Object[1];
                    d(b40, (byte) (b40 + 1), bArr41[21], objArr103);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, c9, packedPositionChild, 2061780482, false, (String) objArr103[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf8);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            int i153 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
            artificialFrame = i153 % 128;
            int i154 = i153 % 2;
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame34 == null) {
                int iLastIndexOf3 = 25 - TextUtils.lastIndexOf("", '0', 0, 0);
                char c10 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
                int i155 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                byte[] bArr42 = $$d;
                byte b41 = (byte) (-bArr42[11]);
                byte b42 = bArr42[21];
                Object[] objArr104 = new Object[1];
                d(b41, (byte) (b42 - 1), b42, objArr104);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, c10, i155, 1145017376, false, (String) objArr104[0], null);
            }
            Object[] objArr105 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i156 = ((int[]) objArr105[3])[0];
            int i157 = ((int[]) objArr105[2])[0];
            String[] strArr5 = (String[]) objArr105[0];
            int i158 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i159 = 891580060 + (((~((-79710209) | (~i158))) | 1606401) * (-591)) + ((i158 | (-79710209)) * 591) + 341025299;
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i161 ^ (i161 << 5);
        }
        int i162 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i163 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i163 == i162) {
            Object[] objArr106 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i164 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i165 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i166 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i167 = i164 + ((((-1960015490) + (((~(128586234 | iIdentityHashCode11)) | 139576833) * 576)) + (((~((~iIdentityHashCode11) | 268163067)) | 67113208) * 576)) - 1208122816);
            int i168 = (i167 << 13) ^ i167;
            int i169 = i168 ^ (i168 >>> 17);
            ((int[]) objArr106[1])[0] = i169 ^ (i169 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr7 != null) {
                for (String str6 : strArr7) {
                    arrayList3.add(str6);
                }
            }
            Object[] objArr107 = {Long.valueOf(((long) (i162 ^ i163)) ^ (((long) (-35585349)) << 32)), Long.valueOf(-35585351)};
            byte[] bArr43 = $$j;
            Object[] objArr108 = new Object[1];
            f(bArr43[172], (short) 93, bArr43[103], objArr108);
            Class<?> cls16 = Class.forName((String) objArr108[0]);
            byte b43 = bArr43[4];
            Object[] objArr109 = new Object[1];
            f(b43, (short) (b43 | 653), (byte) (-bArr43[490]), objArr109);
            cls16.getMethod((String) objArr109[0], Long.TYPE, Long.TYPE).invoke(null, objArr107);
            Object[] objArr116 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i170 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i171 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i172 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iNextInt = new Random().nextInt();
            int i173 = i170 + ((((~((-922513958) | iNextInt)) | 844374052) * (-283)) - 1482208054) + ((~(iNextInt | (-78139906))) * 283);
            int i174 = (i173 << 13) ^ i173;
            int i175 = i174 ^ (i174 >>> 17);
            ((int[]) objArr116[1])[0] = i175 ^ (i175 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int i176 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 20;
            char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
            int i177 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 464;
            byte[] bArr44 = $$d;
            byte b44 = bArr44[5];
            Object[] objArr117 = new Object[1];
            d(b44, (byte) (b44 + 1), bArr44[21], objArr117);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i176, cKeyCodeFromString2, i177, -785931255, false, (String) objArr117[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j10 == -1 || j10 + 1871 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr118 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 8), 26 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{'\b', 18, '\t', 29, '#', 19, 15, '$', CharUtils.CR, 4, 1, '\"', 20, '\"', 0, 19, '*', 19, 3, 19, CoreConstants.PERCENT_CHAR, 25, 29, CoreConstants.PERCENT_CHAR, '\f', '\t'}, objArr118);
                Class<?> cls17 = Class.forName((String) objArr118[0]);
                Object[] objArr119 = new Object[1];
                e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 37), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{21, '\"', 13878, 13878, '+', 22, 6, '\f', 13880, 13880, 28, 19, 25, CharUtils.CR, 0, 19, '$', 19}, objArr119);
                baseContext4 = (Context) cls17.getMethod((String) objArr119[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 == null) {
                objArr7 = null;
            } else {
                if (baseContext4 instanceof ContextWrapper) {
                    int i178 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                    artificialFrame = i178 % 128;
                    if (i178 % 2 == 0) {
                        ((ContextWrapper) baseContext4).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext4).getBaseContext() == null) {
                        baseContext4 = null;
                        objArr7 = null;
                    }
                }
                objArr7 = null;
                baseContext4 = baseContext4.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(objArr7, this)).intValue();
            Object[] objArr120 = new Object[1];
            e((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(objArr7, objArr7)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 20), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{4, '+', CoreConstants.PERCENT_CHAR, 14, '+', CoreConstants.PERCENT_CHAR, 0, '$', 25, '\"', CharUtils.CR, '\f', 14, '0', '+', 3, '+', 15, '/', 7, 11, '!', '+', 3, CoreConstants.SINGLE_QUOTE_CHAR, 7, '0', 16, '\n', '+', '+', '\b', 5, '\b', CharUtils.CR, '\t', '+', 3, 29, 4, 27, '\"', 5, '\b', '/', 24, '\"', 27, 4, '\b', 7, CoreConstants.SINGLE_QUOTE_CHAR, '!', 25, '.', 7, 27, '\"', '\b', CoreConstants.SINGLE_QUOTE_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 21, '\t', '+'}, objArr120);
            String str7 = (String) objArr120[0];
            Object[] objArr121 = new Object[1];
            e((byte) (40 - TextUtils.lastIndexOf("", '0', 0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 15, new char[]{7, CoreConstants.LEFT_PARENTHESIS_CHAR, 13864, 13864, '+', '\b', 19, 27, 4, CoreConstants.SINGLE_QUOTE_CHAR, 11, 26, '+', CoreConstants.DASH_CHAR, 11, 29, CoreConstants.DASH_CHAR, '+', '+', CoreConstants.SINGLE_QUOTE_CHAR, '\b', 4, CharUtils.CR, '\f', '!', 25, CoreConstants.COMMA_CHAR, 14, '\t', CharUtils.CR, 23, 18, '\t', '/', 13777, 13777, CharUtils.CR, '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, '\b', 30, 18, '\t', 19, '0', 16, CoreConstants.PERCENT_CHAR, 14, CoreConstants.PERCENT_CHAR, '*', '\b', 4, 22, CoreConstants.SINGLE_QUOTE_CHAR, 13781, 13781, ' ', 18, '.', CoreConstants.DASH_CHAR, 18, CharUtils.CR, '\b', '+'}, objArr121);
            Object[] objArr122 = {baseContext4, new String[]{str7, (String) objArr121[0]}, Integer.valueOf(iIntValue2), 1, -1966575755};
            byte[] bArr45 = $$j;
            Object[] objArr123 = new Object[1];
            f((byte) (bArr45[36] - 1), bArr45[85], bArr45[31], objArr123);
            Class<?> cls18 = Class.forName((String) objArr123[0]);
            Object[] objArr124 = new Object[1];
            f(bArr45[643], (short) 259, bArr45[96], objArr124);
            Object[] objArr125 = (Object[]) cls18.getMethod((String) objArr124[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr122);
            int i179 = ((int[]) objArr125[0])[0];
            int i180 = ((int[]) objArr125[3])[0];
            if (baseContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame36 == null) {
                    int iArgb = 21 - Color.argb(0, 0, 0, 0);
                    char defaultSize2 = (char) View.getDefaultSize(0, 0);
                    int i181 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                    byte[] bArr46 = $$d;
                    byte b45 = (byte) (-bArr46[11]);
                    byte b46 = bArr46[21];
                    Object[] objArr126 = new Object[1];
                    d(b45, (byte) (b46 - 1), b46, objArr126);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iArgb, defaultSize2, i181, -612765161, false, (String) objArr126[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr125);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame37 == null) {
                        int windowTouchSlop3 = 21 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char cArgb4 = (char) Color.argb(0, 0, 0, 0);
                        int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 465;
                        byte[] bArr47 = $$d;
                        byte b47 = bArr47[5];
                        Object[] objArr127 = new Object[1];
                        d(b47, (byte) (b47 + 1), bArr47[21], objArr127);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, cArgb4, threadPriority2, -785931255, false, (String) objArr127[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf9);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr8 = objArr125;
            i5 = 0;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame38 == null) {
                int i182 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 20;
                char offsetBefore3 = (char) TextUtils.getOffsetBefore("", 0);
                int keyRepeatDelay3 = 465 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr48 = $$d;
                byte b48 = (byte) (-bArr48[11]);
                byte b49 = bArr48[21];
                Object[] objArr128 = new Object[1];
                d(b48, (byte) (b49 - 1), b49, objArr128);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i182, offsetBefore3, keyRepeatDelay3, -612765161, false, (String) objArr128[0], null);
            }
            Object[] objArr129 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr8 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i183 = ((int[]) objArr129[3])[0];
            int i184 = ((int[]) objArr129[0])[0];
            String[] strArr9 = (String[]) objArr129[1];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i185 = 425896791 + ((iFreeMemory | 254629025) * (-50));
            int i186 = ~((-169951265) | iFreeMemory);
            int i187 = ~iFreeMemory;
            int i188 = ((i185 + ((i186 | (~(264230563 | i187))) * 50)) + (((~(i187 | 254629025)) | ((~(94279299 | i187)) | (-264230564))) * 50)) - 1966575755;
            int i189 = (i188 << 13) ^ i188;
            int i190 = i189 ^ (i189 >>> 17);
            ((int[]) objArr8[2])[0] = i190 ^ (i190 << 5);
            i5 = 0;
        }
        int i191 = ((int[]) objArr8[i5])[i5];
        int i192 = ((int[]) objArr8[3])[i5];
        if (i192 == i191) {
            Object[] objArr130 = new Object[4];
            int[] iArr = new int[1];
            objArr130[i5] = iArr;
            objArr130[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr130[3] = iArr2;
            int i193 = ((int[]) objArr8[2])[i5];
            int i194 = ((int[]) objArr8[3])[i5];
            int i195 = ((int[]) objArr8[i5])[i5];
            String[] strArr10 = (String[]) objArr8[1];
            iArr2[i5] = i194;
            iArr[i5] = i195;
            int i196 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i5]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i197 = ~i196;
            int i198 = 1790273189 + (((~((-172035623) | i197)) | (~((-616190089) | i196))) * 520);
            int i199 = ~(616190088 | i197);
            int i200 = ~(i196 | 776539814);
            int i201 = i193 + i198 + ((i199 | i200) * (-1040)) + ((i200 | (~(i197 | (-776539815))) | (-788225711)) * 520);
            int i202 = (i201 << 13) ^ i201;
            int i203 = i202 ^ (i202 >>> 17);
            ((int[]) objArr130[2])[0] = i203 ^ (i203 << 5);
            objArr130[1] = strArr10;
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr11 = (String[]) objArr8[1];
        if (strArr11 != null) {
            int i204 = 0;
            while (i204 < strArr11.length) {
                int i205 = artificialFrame + 115;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i205 % 128;
                if (i205 % 2 != 0) {
                    arrayList4.add(strArr11[i204]);
                    i204 += 9;
                } else {
                    arrayList4.add(strArr11[i204]);
                    i204++;
                }
            }
        }
        Object[] objArr131 = {Long.valueOf(((long) (i191 ^ i192)) ^ (((long) 707271899) << 32)), Long.valueOf(707271835)};
        byte[] bArr49 = $$j;
        Object[] objArr132 = new Object[1];
        f((byte) (bArr49[417] + 1), bArr49[4], bArr49[103], objArr132);
        Class<?> cls19 = Class.forName((String) objArr132[0]);
        byte b50 = bArr49[4];
        Object[] objArr133 = new Object[1];
        f(b50, (short) (b50 | 653), (byte) (-bArr49[490]), objArr133);
        cls19.getMethod((String) objArr133[0], Long.TYPE, Long.TYPE).invoke(null, objArr131);
        Object[] objArr134 = {new int[]{i}, strArr, new int[1], new int[]{i}};
        int i206 = ((int[]) objArr8[2])[0];
        int i207 = ((int[]) objArr8[3])[0];
        int i208 = ((int[]) objArr8[0])[0];
        String[] strArr12 = (String[]) objArr8[1];
        int i209 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 971983739);
        int i210 = i206 + 1367435239 + (((-541111810) | i209) * 494) + (((~(i209 | (-659683314))) | 397492734) * 494);
        int i211 = (i210 << 13) ^ i210;
        int i212 = i211 ^ (i211 >>> 17);
        ((int[]) objArr134[2])[0] = i212 ^ (i212 << 5);
    }

    static {
        byte[] bArr = new byte[749];
        System.arraycopy(",<Äq\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïü¿ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9·ûþ\t\u0000ð\u0000÷\u0003\u0002ø\u0000ù2Á÷ö\u000bï\u0000\tñ:éØî(àò!Ù\u0003ú\u000fÛþ\t\u0000ð\u0000÷\u0003\u0013Úÿ÷\u0001\u0018êï\u0005\u0004ñÿë\u0015é\u0007öýFüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ,Ðùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïðþ;Ãôü\u0004÷\u00033°þ\u000b÷\u00035Çðþüúý<æÛí\u000bþë\u0001ù\u001céîú\u0005ôðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïö=·\nóöþõG¸\t\u0000úëBØ\u0000÷êóöþõ(Ú\u0007ë\u0005\u0003úüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û3°ü\u0013úðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïö=·\nóöþõGÉï\u0006îÿ\u0002\u00012Çðù\t3Á÷ö\u000bï\u0000\tñ:µý\u0007ù:×ìí\tüó÷\u0007õ÷\u001bÝ\u0007ùõðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 749);
        $$j = bArr;
        $$k = 140;
        $$d = new byte[]{66, -118, -118, 77, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO};
        $$e = 155;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{39065, 44390, 44394, 44397, 39059, 44404, 44400, 39071, 44388, 39064, 39070, 44385, 44341, 44353, 44393, 44398, 44338, 44409, 44370, 44360, 44336, 44403, 44355, 44392, 39067, 44386, 44340, 44387, 44405, 44334, 44402, 39069, 44345, 44396, 44371, 44343, 44389, 39068, 44391, 44372, 44399, 39058, 44342, 44395, 44339, 44344, 44337, 44406, 39056};
        coroutineCreation = (char) 39069;
    }
}
