package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.hce.VtsExchangeError;
import it.aep_italia.vts.sdk.hce.VtsExchangeException;
import it.aep_italia.vts.sdk.hce.VtsExchangeHandler;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.hce.apdu.io.ApduByteParser;
import it.aep_italia.vts.sdk.hce.apdu.io.ApduByteSerializer;
import it.aep_italia.vts.sdk.hce.apdu.io.ApduResponseBuilder;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlinx.serialization.internal.HashMapClassDesc;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class VtsApduService extends HostApduService {
    public static final String ACTION_EXCHANGE_COMPLETE = "it.aep_italia.vts.nfc.EXCHANGE_COMPLETE";
    public static final String ACTION_EXCHANGE_ERROR = "it.aep_italia.vts.nfc.EXCHANGE_ERROR";
    public static final String ACTION_NEW_REQUEST = "it.aep_italia.vts.nfc_debug.NEW_REQUEST";
    public static final String ACTION_NEW_RESPONSE = "it.aep_italia.vts.nfc_debug.NEW_RESPONSE";
    public static final String INTENT_DATA = "it.aep_italia.vts.nfc_debug.DATA";
    private static ApduByteParser c;
    private static ApduByteSerializer d;
    private static int setDefaultImpl;
    private VtsSdk a;
    private VtsExchangeHandler b;
    private static final byte[] $$c = {102, -25, -78, -11};
    private static final int $$f = 98;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {33, -82, -25, 84, -3, -4, -19, -7, -3, 54, -2, -66, -12, -13, 8, -20, -3, 6, -18, 55, -73, -3, 4, -26, 7, -16, -10, -2, 56, -58, -20, 3, -21, -4, -1, -2, 47, -29, -40, -8, -6, -20, -7, 6, -6, 10, -35, 5, -15, -1, -22, 44, -42, -4, -22, -11, 8, -20, -7, -68, -19, -5, 56, -64, -15, -7, 1, -12, 0, 48, -60, -22, -14, 2, -11, -2, 58, -77, 4, -12, -4, 54, -58, -11, -3, -10, 47, -26, -43, -21, 39, -35, -30, 38, -33, -27, 78, -20};
    private static final int $$e = 195;
    private static final byte[] $$a = {52, -20, 7, -120, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = JfifUtil.MARKER_SOS;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r6, int r7, short r8) {
        /*
            int r7 = r7 * 2
            int r7 = 3 - r7
            int r6 = r6 * 2
            int r0 = 1 - r6
            int r8 = r8 * 2
            int r8 = r8 + 114
            byte[] r1 = it.aep_italia.vts.sdk.core.VtsApduService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L19
            r4 = r6
            r8 = r7
            r3 = r2
            goto L2e
        L19:
            r3 = r2
            r5 = r8
            r8 = r7
            r7 = r5
        L1d:
            byte r4 = (byte) r7
            int r8 = r8 + 1
            r0[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L2a:
            r4 = r1[r8]
            int r3 = r3 + 1
        L2e:
            int r4 = -r4
            int r7 = r7 + r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsApduService.$$g(short, int, short):java.lang.String");
    }

    static {
        accessartificialFrame();
        c = new ApduByteParser();
        d = new ApduByteSerializer();
    }

    private VtsExchangeHandler a() {
        try {
            return new a(this.a, b());
        } catch (VtsException unused) {
            throw new VtsExchangeException(VtsExchangeError.EXCHANGE_FAILED);
        }
    }

    private ApduResponseMessage a(ApduRequestMessage apduRequestMessage) throws VtsExchangeException {
        if (apduRequestMessage.isMatch("00", "A4")) {
            if (apduRequestMessage.getP1() != 4 || apduRequestMessage.getP2() != 0) {
                throw new VtsExchangeException(VtsExchangeError.WRONG_P1_P2_FIELDS);
            }
            VtsExchangeHandler vtsExchangeHandlerA = a();
            this.b = vtsExchangeHandlerA;
            vtsExchangeHandlerA.handlePhase0Request(apduRequestMessage);
            return this.b.generatePhase0Response();
        }
        if (apduRequestMessage.isMatch("80", "A5")) {
            if (apduRequestMessage.getP1() != 16 || apduRequestMessage.getP2() != 0) {
                throw new VtsExchangeException(VtsExchangeError.WRONG_P1_P2_FIELDS);
            }
            VtsExchangeHandler vtsExchangeHandler = this.b;
            if (vtsExchangeHandler == null) {
                throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND);
            }
            vtsExchangeHandler.handlePhase1Request(apduRequestMessage);
            return this.b.generatePhase1Response();
        }
        if (apduRequestMessage.isMatch("80", "A6")) {
            VtsExchangeHandler vtsExchangeHandler2 = this.b;
            if (vtsExchangeHandler2 == null) {
                throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND);
            }
            vtsExchangeHandler2.handlePhase2Request(apduRequestMessage);
            return this.b.generatePhase2Response();
        }
        if (!apduRequestMessage.isMatch("80", "A7")) {
            throw new VtsExchangeException(VtsExchangeError.UNRECOGNIZED_COMMAND);
        }
        VtsExchangeHandler vtsExchangeHandler3 = this.b;
        if (vtsExchangeHandler3 == null) {
            throw new VtsExchangeException(VtsExchangeError.OUT_OF_ORDER_COMMAND);
        }
        vtsExchangeHandler3.handlePhase3Request(apduRequestMessage);
        return this.b.generatePhase3Response();
    }

    private byte[][] b() throws VtsException {
        return this.a.d().c();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void e(byte r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 28
            int r5 = 112 - r5
            int r6 = r6 * 8
            int r6 = 19 - r6
            int r7 = r7 * 3
            int r0 = 12 - r7
            byte[] r1 = it.aep_italia.vts.sdk.core.VtsApduService.$$a
            byte[] r0 = new byte[r0]
            int r7 = 11 - r7
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r5
            r5 = r7
            r4 = r2
            goto L2d
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r5
            int r6 = r6 + 1
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L2b:
            r3 = r1[r6]
        L2d:
            int r5 = r5 + r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsApduService.e(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void g(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 111 - r7
            byte[] r0 = it.aep_italia.vts.sdk.core.VtsApduService.$$d
            int r8 = r8 * 4
            int r1 = 55 - r8
            int r6 = r6 * 2
            int r6 = 59 - r6
            byte[] r1 = new byte[r1]
            int r8 = 54 - r8
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = r2
            r7 = r6
            goto L31
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L31:
            int r6 = -r6
            int r3 = r3 + r6
            int r6 = r3 + (-7)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsApduService.g(int, byte, short, java.lang.Object[]):void");
    }

    public abstract VtsSdk createSdk(Context context) throws VtsException;

    protected void emit(String str, Parcelable parcelable) {
        Intent intent = new Intent(str);
        if (parcelable != null) {
            intent.putExtra(INTENT_DATA, parcelable);
        }
        sendBroadcast(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            VtsSdk vtsSdkCreateSdk = createSdk(this);
            this.a = vtsSdkCreateSdk;
            if (vtsSdkCreateSdk != null) {
            } else {
                throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SDK);
            }
        } catch (VtsException e) {
            VtsLog.e("VtsApduService", "Could not load SDK within service.", e);
        }
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i) {
        VtsLog.i("Service has been deactivated.", new Object[0]);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        ApduResponseMessage apduResponseMessageBuild;
        if (this.a == null) {
            return new byte[0];
        }
        VtsLog.d("APDU service has received a new APDU command.", new Object[0]);
        byte[] bArrSerialize = null;
        try {
            if (!this.a.isInitialized()) {
                VtsLog.w("Cannot proceed, SDK has not been initialized.", new Object[0]);
                throw new VtsExchangeException(VtsExchangeError.SDK_NOT_READY);
            }
            try {
                ApduRequestMessage request = c.parseRequest(bArr);
                if (VtsLog.isEnabled(VtsLog.Level.TRACE)) {
                    VtsLog.t("Received the following APDU request: %s", ByteUtils.bytesToHexString(bArr));
                }
                emit(ACTION_NEW_REQUEST, request);
                apduResponseMessageBuild = a(request);
            } catch (Exception e) {
                VtsLog.e(e, "Could not parse request command", new Object[0]);
                throw new VtsExchangeException(VtsExchangeError.COULD_NOT_PARSE_REQUEST, "Could not parse request command");
            }
        } catch (VtsExchangeException e2) {
            VtsLog.e(e2, "Could not complete APDU exchange.", new Object[0]);
            emit(ACTION_EXCHANGE_ERROR, null);
            apduResponseMessageBuild = ApduResponseBuilder.builder().SW1(e2.getError().getSW1()).SW2(e2.getError().getSW2()).build();
            this.b = null;
        }
        emit(ACTION_NEW_RESPONSE, apduResponseMessageBuild);
        VtsExchangeHandler vtsExchangeHandler = this.b;
        if (vtsExchangeHandler != null && vtsExchangeHandler.isExchangeCompleted()) {
            emit(ACTION_EXCHANGE_COMPLETE, null);
        }
        try {
            bArrSerialize = d.serialize(apduResponseMessageBuild);
            if (VtsLog.isEnabled(VtsLog.Level.TRACE)) {
                VtsLog.t("Sending back the following APDU response: %s", ByteUtils.bytesToHexString(bArrSerialize));
            }
        } catch (Exception e3) {
            VtsLog.e(e3, "Could not generate APDU response.", new Object[0]);
        }
        return bArrSerialize;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x016d  */
    /* JADX WARN: Code duplicated, block: B:34:0x016e  */
    private static void f(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        char c2;
        Throwable cause;
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (true) {
            c2 = '0';
            if (onnavigationevent.d >= i3) {
                break;
            }
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i5 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(21 - TextUtils.lastIndexOf("", '0', 0, 0), (char) Color.green(0), 1775 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), -2069783171, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - (Process.myPid() >> 22), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 56277), 1259 - TextUtils.indexOf("", ""), 711931141, false, $$g(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        if (i > 0) {
            int i6 = $10 + 117;
            $11 = i6 % 128;
            int i7 = i6 % 2;
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
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 37, (char) (56277 - View.combineMeasuredStates(0, 0)), TextUtils.lastIndexOf("", c2, 0, 0) + 1260, 711931141, false, $$g(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i8 = $10 + 21;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                c2 = '0';
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:16:0x02fc A[Catch: all -> 0x0d66, TryCatch #1 {all -> 0x0d66, blocks: (B:54:0x0986, B:56:0x09a7, B:57:0x09f6, B:14:0x02e8, B:16:0x02fc, B:17:0x032d), top: B:96:0x02e8 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0343  */
    /* JADX WARN: Code duplicated, block: B:25:0x0481  */
    /* JADX WARN: Code duplicated, block: B:53:0x0891  */
    /* JADX WARN: Code duplicated, block: B:56:0x09a7 A[Catch: all -> 0x0d66, TryCatch #1 {all -> 0x0d66, blocks: (B:54:0x0986, B:56:0x09a7, B:57:0x09f6, B:14:0x02e8, B:16:0x02fc, B:17:0x032d), top: B:96:0x02e8 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:65:0x0b71  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        char c2;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 26;
            char c3 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            int mode = 1041 - View.MeasureSpec.getMode(0);
            byte[] bArr = $$a;
            byte b = bArr[21];
            Object[] objArr2 = new Object[1];
            e((byte) (b - 1), (byte) (-bArr[8]), b, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c3, mode, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387840L;
            Object[] objArr3 = new Object[1];
            f(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 2, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 99, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 22, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 7, (ViewConfiguration.getWindowTouchSlop() >> 8) + com.salesforce.marketingcloud.analytics.stats.b.i, MotionEvent.axisFromString("") + 16, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int size = View.MeasureSpec.getSize(0) + 26;
                    char offsetAfter = (char) TextUtils.getOffsetAfter("", 0);
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 1041;
                    byte b2 = $$a[21];
                    byte b3 = (byte) (b2 - 1);
                    byte b4 = b2;
                    Object[] objArr5 = new Object[1];
                    e(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(size, offsetAfter, fadingEdgeLength, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i4 = ~iIdentityHashCode;
                int i5 = 1197017568 + (((~(945753387 | i4)) | (-1029693228)) * 98) + (((~(i4 | (-1023857195))) | 945753387 | (~(1023857194 | iIdentityHashCode))) * (-49)) + (((~(iIdentityHashCode | 945753387)) | 5836033) * 49) + 1131921413;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i7 ^ (i7 << 5);
                c2 = 2;
            } else {
                Object[] objArr7 = new Object[1];
                f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 62, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b', 11, 3, 18, 17, 23, 65521, 65484}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 98, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 92, new char[]{CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t', 65501, 2}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-1024897397};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (22250 - Process.getGidForName("")), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1131921413, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int size2 = View.MeasureSpec.getSize(0) + 26;
                        char c4 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int absoluteGravity = 1041 - Gravity.getAbsoluteGravity(0, 0);
                        byte b5 = $$a[21];
                        byte b6 = (byte) (b5 - 1);
                        byte b7 = b5;
                        Object[] objArr10 = new Object[1];
                        e(b6, b7, b7, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size2, c4, absoluteGravity, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        f(false, 19 - Color.alpha(0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 95, (-16777194) - Color.rgb(0, 0, 0), new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 7, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 99, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 26;
                            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 1041;
                            byte[] bArr2 = $$a;
                            byte b8 = bArr2[21];
                            Object[] objArr13 = new Object[1];
                            e((byte) (b8 - 1), (byte) (-bArr2[8]), b8, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, cLastIndexOf, threadPriority, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                        artificialFrame = i8 % 128;
                        c2 = 2;
                        int i9 = i8 % 2;
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
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 62, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b', 11, 3, 18, 17, 23, 65521, 65484}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 98, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(5) - 92, new char[]{CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t', 65501, 2}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-1024897397};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (22250 - Process.getGidForName("")), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1032, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HashMapClassDesc.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1131921413, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int size3 = View.MeasureSpec.getSize(0) + 26;
                char c5 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int absoluteGravity2 = 1041 - Gravity.getAbsoluteGravity(0, 0);
                byte b9 = $$a[21];
                byte b10 = (byte) (b9 - 1);
                byte b11 = b9;
                Object[] objArr17 = new Object[1];
                e(b10, b11, b11, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size3, c5, absoluteGravity2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            f(false, 19 - Color.alpha(0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 95, (-16777194) - Color.rgb(0, 0, 0), new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 7, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 99, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 26;
                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 1041;
                byte[] bArr3 = $$a;
                byte b12 = bArr3[21];
                Object[] objArr110 = new Object[1];
                e((byte) (b12 - 1), (byte) (-bArr3[8]), b12, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, cLastIndexOf2, threadPriority2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
            artificialFrame = i10 % 128;
            c2 = 2;
            int i11 = i10 % 2;
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[c2])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            int i14 = artificialFrame + 29;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i19 = i16 + 1028606714 + ((~(738121571 | startUptimeMillis)) * 623) + (((~startUptimeMillis) | 545689696) * (-623)) + (((~(startUptimeMillis | 680957537)) | (~(602853730 | startUptimeMillis)) | (-738121572)) * 623);
            int i20 = i19 ^ (i19 << 13);
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[1])[0] = i21 ^ (i21 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i22 = artificialFrame + 81;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                for (int i23 = i22 % 2 != 0 ? 1 : 0; i23 < strArr3.length; i23++) {
                    int i24 = artificialFrame + 29;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i24 % 128;
                    int i25 = i24 % 2;
                    arrayList.add(strArr3[i23]);
                }
            }
            long j3 = ((long) (i12 ^ i13)) ^ (((long) 1198386036) << 32);
            long j4 = 1198386038;
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$d;
                byte b13 = bArr4[68];
                Object[] objArr22 = new Object[1];
                g((byte) 28, b13, b13, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                g(bArr4[66], (byte) (-bArr4[2]), (byte) (-bArr4[13]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) + 246447759;
                int i31 = i28 + 1990730342 + ((~(64943355 | iCodePointAt)) * (-301)) + (((~((-63632516) | iCodePointAt)) | (~((~iCodePointAt) | 14471291))) * (-301)) + (((~(iCodePointAt | (-14471292))) | (-63632516)) * 301);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[1])[0] = i33 ^ (i33 << 5);
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
            int iIndexOf = TextUtils.indexOf("", "", 0) + 25;
            char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 816;
            byte[] bArr5 = $$a;
            byte b14 = bArr5[21];
            Object[] objArr25 = new Object[1];
            e((byte) (b14 - 1), (byte) (-bArr5[8]), b14, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, touchSlop, minimumFlingVelocity, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i34 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
            artificialFrame = i34 % 128;
            int i35 = i34 % 2;
            long j6 = j5 + 1951;
            Object[] objArr26 = new Object[1];
            f(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 98, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 95, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            f(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 11, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 99, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int size4 = View.MeasureSpec.getSize(0) + 25;
                    char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0'));
                    int doubleTapTimeout3 = 816 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    byte b15 = $$a[21];
                    byte b16 = (byte) (b15 - 1);
                    byte b17 = b15;
                    Object[] objArr28 = new Object[1];
                    e(b16, b17, b17, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(size4, cIndexOf, doubleTapTimeout3, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i36 = ((int[]) objArr29[0])[0];
                int i37 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i38 = ~System.identityHashCode(this);
                int i39 = (-1574179193) + (((-134367241) | i38) * 494) + (((~(i38 | 58561987)) | (-187686090)) * 494) + 796115050;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr[3])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 63, 16 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b', 11, 3, 18, 17, 23, 65521, 65484}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 25, 101 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t', 65501, 2}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 796115050};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 25;
                    char c6 = (char) (30069 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int i42 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte b18 = $$a[21];
                    byte b19 = (byte) (b18 - 1);
                    Object[] objArr33 = new Object[1];
                    e(b18, b19, b19, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetAfter2, c6, i42, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iRgb = Color.rgb(0, 0, 0) + 16777241;
                    char fadingEdgeLength2 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                    int scrollBarFadeDuration = 816 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    byte b20 = $$a[21];
                    byte b21 = (byte) (b20 - 1);
                    byte b22 = b20;
                    Object[] objArr34 = new Object[1];
                    e(b21, b22, b22, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb, fadingEdgeLength2, scrollBarFadeDuration, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    f(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 15, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 95, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 68, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int absoluteGravity3 = 25 - Gravity.getAbsoluteGravity(0, 0);
                        char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30068);
                        int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                        byte[] bArr6 = $$a;
                        byte b23 = bArr6[21];
                        Object[] objArr37 = new Object[1];
                        e((byte) (b23 - 1), (byte) (-bArr6[8]), b23, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, maximumFlingVelocity, iIndexOf2, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 63, 16 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b', 11, 3, 18, 17, 23, 65521, 65484}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 25, 101 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 12, new char[]{CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t', 65501, 2}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 796115050};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int offsetAfter3 = TextUtils.getOffsetAfter("", 0) + 25;
                char c7 = (char) (30069 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int i43 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte b110 = $$a[21];
                byte b111 = (byte) (b110 - 1);
                Object[] objArr311 = new Object[1];
                e(b110, b111, b111, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetAfter3, c7, i43, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iRgb2 = Color.rgb(0, 0, 0) + 16777241;
                char fadingEdgeLength3 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
                int scrollBarFadeDuration2 = 816 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte b24 = $$a[21];
                byte b25 = (byte) (b24 - 1);
                byte b26 = b24;
                Object[] objArr312 = new Object[1];
                e(b25, b26, b26, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb2, fadingEdgeLength3, scrollBarFadeDuration2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            f(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 15, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 95, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{15, '\f', 6, 1, 65483, '\f', 16, 65483, 65520, 22, 16, 17, 2, '\n', 65504, '\t', '\f', 0, '\b', 65534, 11, 1}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            f(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 68, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6, 2, CharUtils.CR}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int absoluteGravity4 = 25 - Gravity.getAbsoluteGravity(0, 0);
                char maximumFlingVelocity2 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30068);
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                byte[] bArr7 = $$a;
                byte b27 = bArr7[21];
                Object[] objArr315 = new Object[1];
                e((byte) (b27 - 1), (byte) (-bArr7[8]), b27, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(absoluteGravity4, maximumFlingVelocity2, iIndexOf3, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArr[1])[0];
        int i45 = ((int[]) objArr[0])[0];
        if (i45 == i44) {
            int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i46 % 128;
            int i47 = i46 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i48 = ((int[]) objArr[3])[0];
            int i49 = ((int[]) objArr[0])[0];
            int i50 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i51 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i52 = i48 + 748487249 + ((~((-142615043) | i51)) * 52) + (((~(341581268 | i51)) | (~(143408902 | i51)) | (-484196311)) * (-52)) + (((~(i51 | (-341581269))) | 793860) * 52);
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr40[3])[0] = i54 ^ (i54 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) 378902758) << 32) ^ ((long) (i44 ^ i45))), Long.valueOf(378902759)};
        byte[] bArr8 = $$d;
        byte b28 = bArr8[68];
        byte b29 = bArr8[22];
        Object[] objArr42 = new Object[1];
        g(b28, b29, b29, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        g(bArr8[66], (byte) (-bArr8[2]), (byte) (-bArr8[13]), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i55 = ((int[]) objArr[3])[0];
        int i56 = ((int[]) objArr[0])[0];
        int i57 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i58 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
        int i59 = i55 + 1063082885 + (((~(819834088 | i58)) | 203424534) * 104) + ((~((~i58) | (-5252169))) * (-104)) + ((i58 | 1018006454) * 104);
        int i60 = (i59 << 13) ^ i59;
        int i61 = i60 ^ (i60 >>> 17);
        ((int[]) objArr44[3])[0] = i61 ^ (i61 << 5);
    }

    static void accessartificialFrame() {
        setDefaultImpl = -260893963;
    }
}
