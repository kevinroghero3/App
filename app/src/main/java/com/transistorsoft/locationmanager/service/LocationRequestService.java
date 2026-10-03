package com.transistorsoft.locationmanager.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.geofence.TSGeofenceManager;
import com.transistorsoft.locationmanager.location.SingleLocationRequest;
import com.transistorsoft.locationmanager.location.SingleLocationResult;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.location.WatchPositionResult;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class LocationRequestService extends AbstractService {
    private static final byte[] $$c = {49, Ascii.SUB, -88, -35};
    private static final int $$f = SyslogConstants.LOG_LOCAL4;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$g = {81, -123, 100, Ascii.RS, 8, -55, 70, 1, 7, -66, 65, 6, -5, -2, 2, 5, Ascii.VT, -58, 56, Ascii.SI, 6, -10, -52, 72, 0, -4, -56, Ascii.CAN, 57, -19, Ascii.FF, 0, -3, -30, 54, -12, 3, 2, Ascii.DLE, -27, 33, -14, 5, Ascii.VT, -3, Ascii.DLE, 3, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, 1, -60, 60, Ascii.VT, 3, -5, 8, -4, -52, 54, Ascii.DLE, -7, 17, 0, -3, -2, -51, 66, -9, Ascii.SYN, -12, Ascii.DLE, -6, -5, Ascii.SO, -59, 56, Ascii.SI, 0, 6, 6, -65, 74, 2, -8, 6, 0, Ascii.SO, -8, -1, 17, -66, Ascii.EM, 56, -8, -10, Ascii.SI, -1, -3, -29, 47, 0, 6, 6, -75, 3, 36, 54, -1, -12, Ascii.DLE, -1, -10, Ascii.SO, -22, 41, -8, 9, -9, 0, Ascii.DC2, -8, -3, -20, Ascii.CAN, Ascii.SI, -8, 5, 0, -46};
    private static final int $$h = 65;
    private static final byte[] $$a = {43, Base64.padSymbol, 10, -87, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
    private static final int $$b = 70;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {55960, 55947, 55965, 55951, 55946, 55952, 56139, 55950, 55982, 55936, 55949, 55964, 55956, 55998, 55957, 55966, 55958, 55945, 55983, 55959, 55939, 55954, 55985, 55953};
    private static int warmup = -1044259975;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    class a implements Runnable {
        private final Intent a;
        private final int b;

        a(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String action = this.a.getAction();
            if (LocationResult.hasResult(this.a)) {
                LocationRequestService.this.a(true);
                LocationRequestService.this.c(this.a);
            } else if (LocationAvailability.hasLocationAvailability(this.a)) {
                LocationRequestService.this.b(this.a);
            } else if (action != null && action.equalsIgnoreCase("start")) {
                LocationRequestService.this.d(this.a);
            }
            LocationRequestService.this.a(this.b);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$i(int r6, int r7, int r8) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.service.LocationRequestService.$$c
            int r8 = r8 + 66
            int r6 = r6 * 3
            int r6 = 3 - r6
            int r7 = r7 * 2
            int r1 = r7 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r7
            r4 = r2
            goto L2a
        L14:
            r3 = r2
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L20:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2a:
            int r8 = -r8
            int r8 = r8 + r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.LocationRequestService.$$i(int, int, int):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        int intExtra = intent.getIntExtra("id", 0);
        SingleLocationRequest request = TSLocationManager.getInstance(getApplicationContext()).getRequest(intExtra);
        if (request != null) {
            request.startUpdatingLocation();
            return;
        }
        TSLog.logger.warn(TSLog.warn("Failed to find SingleLocationRequest in START action; requestId: " + intExtra + ".  This is likely from a timed-out location request; " + intent));
        a(false);
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
    private static void q(short r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 28
            int r6 = 112 - r6
            int r5 = r5 * 8
            int r5 = 19 - r5
            int r7 = r7 * 3
            int r0 = 12 - r7
            byte[] r1 = com.transistorsoft.locationmanager.service.LocationRequestService.$$a
            byte[] r0 = new byte[r0]
            int r7 = 11 - r7
            r2 = 0
            if (r1 != 0) goto L19
            r3 = r6
            r6 = r7
            r4 = r2
            goto L2d
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r5 = r5 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L2b:
            r3 = r1[r5]
        L2d:
            int r6 = r6 + r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.service.LocationRequestService.q(short, byte, int, java.lang.Object[]):void");
    }

    public static void stopService(Context context) {
        AbstractService.stop(context, LocationRequestService.class);
    }

    private static void t(short s, byte b, short s2, Object[] objArr) {
        byte[] bArr = $$g;
        int i = (s * 63) + 36;
        int i2 = s2 + 4;
        byte[] bArr2 = new byte[b + 3];
        int i3 = b + 2;
        int i4 = -1;
        if (bArr == null) {
            int i5 = (i2 + i3) - 3;
            i2 = i2;
            i = i5;
        }
        while (true) {
            i4++;
            int i6 = i2 + 1;
            bArr2[i4] = (byte) i;
            if (i4 == i3) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = i6;
            i = (i + bArr[i6]) - 3;
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= 29) {
            super.a(getClass().getSimpleName(), 8);
        } else {
            super.a(getClass().getSimpleName(), 0);
        }
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (!a(intent, i2, false)) {
            return 3;
        }
        BackgroundGeolocation.getThreadPool().execute(new a(intent, i2));
        return 3;
    }

    @Override // com.transistorsoft.locationmanager.service.AbstractService
    public void onTimeout(int i, int i2) {
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(getApplicationContext());
        for (Intent intent : this.h) {
            if ("start".equalsIgnoreCase(intent.getAction()) && getClass().getName().equals(intent.getComponent().getClassName()) && intent.hasExtra("id")) {
                tSLocationManager.cancelRequest(intent.getIntExtra("id", 0));
            }
        }
        super.onTimeout(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        LocationAvailability locationAvailabilityExtractLocationAvailability = LocationAvailability.extractLocationAvailability(intent);
        TSLog.logger.info(TSLog.info("Location availability: " + locationAvailabilityExtractLocationAvailability.isLocationAvailable()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        TSConfig tSConfig = TSConfig.getInstance(getApplicationContext());
        if (intent.getAction() == null) {
            TSLog.logger.error(TSLog.error("handleLocationResult with no action"));
            a(false);
            return;
        }
        String[] strArrSplit = intent.getAction().split(":");
        int iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
        int iIntValue2 = Integer.valueOf(strArrSplit[1]).intValue();
        Location lastLocation = LocationResult.extractResult(intent).getLastLocation();
        Bundle extras = lastLocation.getExtras();
        if (extras == null) {
            extras = new Bundle();
            lastLocation.setExtras(extras);
        }
        TSLocationManager tSLocationManager = TSLocationManager.getInstance(getApplicationContext());
        if (iIntValue == 5) {
            tSLocationManager.onWatchPositionResult(new WatchPositionResult(iIntValue2, lastLocation));
            return;
        }
        SingleLocationRequest request = tSLocationManager.getRequest(iIntValue2);
        if (request == null) {
            Logger logger = TSLog.logger;
            StringBuilder sb = new StringBuilder();
            sb.append(TSLog.info("Failed to find SingleLocationRequest: " + iIntValue2));
            sb.append(".  Ignored");
            logger.warn(sb.toString());
            SingleLocationRequest.forceStop(getApplicationContext(), iIntValue, iIntValue2);
            a(false);
            return;
        }
        if (iIntValue == 1 && !tSConfig.getEnabled().booleanValue()) {
            TSLog.logger.warn(TSLog.warn("Attempt to get motionchange position while disabled"));
            request.finish();
            return;
        }
        extras.putInt("requestId", iIntValue2);
        tSLocationManager.onSingleLocationResult(new SingleLocationResult(iIntValue2, lastLocation));
        if (request.isFinished()) {
            if (iIntValue == 2 || iIntValue == 1) {
                TSGeofenceManager.getInstance(getApplicationContext()).setLocation(lastLocation, tSConfig.getIsMoving().booleanValue());
            }
            a(false);
        }
    }

    private static void s(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        long j = 0;
        int i3 = 0;
        if (cArr2 != null) {
            int i4 = $11 + 123;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i6 = 0;
            while (i6 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i3] = Integer.valueOf(cArr2[i6]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 26;
                        char cIndexOf = (char) TextUtils.indexOf("", "", i3);
                        int i7 = (SystemClock.elapsedRealtime() > j ? 1 : (SystemClock.elapsedRealtime() == j ? 0 : -1)) + 1040;
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, cIndexOf, i7, -1719489573, false, $$i(b, b2, (byte) (b2 | 55)), new Class[]{Integer.TYPE});
                    }
                    cArr3[i6] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i6++;
                    j = 0;
                    i3 = 0;
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
        try {
            Object[] objArr3 = {Integer.valueOf(warmup)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
            if (objAccessartificialFrame2 == null) {
                byte b3 = (byte) 0;
                byte b4 = b3;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 15, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 20487), 2147 - ((byte) KeyEvent.getModifierMetaStateMask()), 216472770, false, $$i(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
            int i8 = -2083387879;
            if (ICustomTabsServiceDefault) {
                onmessagechannelready.c = bArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                    Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (KeyEvent.normalizeMetaState(0) + 59174), 1943 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 481771537, false, $$i(b5, b6, b6), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                }
                objArr[0] = new String(cArr4);
                return;
            }
            if (requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = cArr.length;
                char[] cArr5 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                int i9 = $11 + 81;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i11 = $10 + b.i;
                    $11 = i11 % 128;
                    if (i11 % 2 == 0) {
                        cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c % 0) / onmessagechannelready.a] >>> i] / iIntValue);
                        Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(i8);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (59173 - ((byte) KeyEvent.getModifierMetaStateMask())), 1942 - TextUtils.lastIndexOf("", '0', 0, 0), 481771537, false, $$i(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    } else {
                        cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(i8);
                        if (objAccessartificialFrame5 == null) {
                            byte b9 = (byte) 0;
                            byte b10 = b9;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 22, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 59173), 1943 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 481771537, false, $$i(b9, b10, b10), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                        i8 = -2083387879;
                    }
                }
                objArr[0] = new String(cArr5);
                return;
            }
            int i12 = 0;
            onmessagechannelready.c = iArr.length;
            char[] cArr6 = new char[onmessagechannelready.c];
            while (true) {
                onmessagechannelready.a = i12;
                if (onmessagechannelready.a >= onmessagechannelready.c) {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    i12 = onmessagechannelready.a + 1;
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

    /* JADX WARN: Code duplicated, block: B:13:0x0194  */
    /* JADX WARN: Code duplicated, block: B:16:0x01ef A[Catch: all -> 0x0a20, TryCatch #0 {all -> 0x0a20, blocks: (B:51:0x06c3, B:53:0x06e3, B:54:0x0732, B:14:0x01db, B:16:0x01ef, B:17:0x021d), top: B:91:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0233  */
    /* JADX WARN: Code duplicated, block: B:25:0x0302  */
    /* JADX WARN: Code duplicated, block: B:50:0x063d  */
    /* JADX WARN: Code duplicated, block: B:53:0x06e3 A[Catch: all -> 0x0a20, TryCatch #0 {all -> 0x0a20, blocks: (B:51:0x06c3, B:53:0x06e3, B:54:0x0732, B:14:0x01db, B:16:0x01ef, B:17:0x021d), top: B:91:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0744  */
    /* JADX WARN: Code duplicated, block: B:62:0x07ed  */
    @Override // com.transistorsoft.locationmanager.service.AbstractService, android.app.Service, android.content.ContextWrapper
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
            int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 27;
            char c = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
            int packedPositionGroup = 1041 - ExpandableListView.getPackedPositionGroup(0L);
            byte[] bArr = $$a;
            byte b = (byte) (-bArr[8]);
            Object[] objArr2 = new Object[1];
            q(b, (byte) (b - 2), bArr[21], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, packedPositionGroup, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387933L;
            Object[] objArr3 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            s(126 - ImageFormat.getBitsPerPixel(0), new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iAxisFromString = 25 - MotionEvent.axisFromString("");
                    char c2 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    int iArgb = Color.argb(0, 0, 0, 0) + 1041;
                    byte b2 = $$a[21];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    q(b3, (byte) (b3 - 1), b2, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iAxisFromString, c2, iArgb, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i4 = ~(601123103 | layoutDirection);
                int i5 = ~layoutDirection;
                int i6 = i4 | (~(679226910 | i5));
                int i7 = ~((-601123104) | i5);
                int i8 = (((842460166 + ((i6 | i7) * (-516))) + (((~(layoutDirection | (-136840705))) | (~((-542386207) | i5))) * 516)) + ((542386206 | i7) * 516)) - 402568402;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                s(127 - (ViewConfiguration.getFadingEdgeLength() >> 16), new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                s(127 - TextUtils.getOffsetAfter("", 0), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-508208592};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22250 - ((byte) KeyEvent.getModifierMetaStateMask())), 1032 - TextUtils.indexOf((CharSequence) "", '0'), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -402568402, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i11 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                        char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int capsMode = 1041 - TextUtils.getCapsMode("", 0, 0);
                        byte b4 = $$a[21];
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        q(b5, (byte) (b5 - 1), b4, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, keyRepeatDelay, capsMode, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 91, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = TextUtils.indexOf("", "", 0) + 26;
                            char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                            int defaultSize = View.getDefaultSize(0, 0) + 1041;
                            byte[] bArr2 = $$a;
                            byte b6 = (byte) (-bArr2[8]);
                            Object[] objArr13 = new Object[1];
                            q(b6, (byte) (b6 - 2), bArr2[21], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, pressedStateDuration, defaultSize, 2061780482, false, (String) objArr13[0], null);
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
            s(127 - (ViewConfiguration.getFadingEdgeLength() >> 16), new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            s(127 - TextUtils.getOffsetAfter("", 0), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-508208592};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22250 - ((byte) KeyEvent.getModifierMetaStateMask())), 1032 - TextUtils.indexOf((CharSequence) "", '0'), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HmacPrfKey.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -402568402, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i12 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int capsMode2 = 1041 - TextUtils.getCapsMode("", 0, 0);
                byte b7 = $$a[21];
                byte b8 = b7;
                Object[] objArr17 = new Object[1];
                q(b8, (byte) (b8 - 1), b7, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i12, keyRepeatDelay2, capsMode2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + b.l, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 91, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf2 = TextUtils.indexOf("", "", 0) + 26;
                char pressedStateDuration2 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                int defaultSize2 = View.getDefaultSize(0, 0) + 1041;
                byte[] bArr3 = $$a;
                byte b9 = (byte) (-bArr3[8]);
                Object[] objArr110 = new Object[1];
                q(b9, (byte) (b9 - 2), bArr3[21], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, pressedStateDuration2, defaultSize2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i14 == i13) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 1447731582;
            int i18 = (-487289814) + ((iCodePointAt | 892391426) * (-50));
            int i19 = ~((-87085057) | iCodePointAt);
            int i20 = ~iCodePointAt;
            int i21 = i15 + i18 + ((i19 | (~(901372675 | i20))) * 50) + (((~(i20 | 892391426)) | (~(814287619 | i20)) | (-901372676)) * 50);
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr20[1])[0] = i23 ^ (i23 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i24 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i24 % 128;
                int i25 = i24 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-1124253278)) << 32)), Long.valueOf(-1124253280)};
                byte[] bArr4 = $$g;
                Object[] objArr22 = new Object[1];
                t(bArr4[7], (byte) (bArr4[114] - 1), bArr4[88], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b10 = bArr4[24];
                Object[] objArr23 = new Object[1];
                t(b10, b10, bArr4[114], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i29 = (~(638050167 | iIdentityHashCode)) | 145235968;
                int i30 = ~((~iIdentityHashCode) | (-67132162));
                int i31 = i26 + (-380467970) + ((i29 | i30) * (-470)) + (((~(iIdentityHashCode | 783286135)) | i30) * 470);
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
            int i34 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
            char size = (char) (30068 - View.MeasureSpec.getSize(0));
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 816;
            byte[] bArr5 = $$a;
            byte b11 = (byte) (-bArr5[8]);
            Object[] objArr25 = new Object[1];
            q(b11, (byte) (b11 - 2), bArr5[21], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i34, size, iResolveSizeAndState, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i35 = artificialFrame + 67;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
            int i36 = i35 % 2;
            long j4 = j3 + 1994;
            Object[] objArr26 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            s((ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 25;
                    char c3 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int defaultSize3 = 816 - View.getDefaultSize(0, 0);
                    byte b12 = $$a[21];
                    byte b13 = b12;
                    Object[] objArr28 = new Object[1];
                    q(b13, (byte) (b13 - 1), b12, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c3, defaultSize3, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i37 = ((int[]) objArr29[0])[0];
                int i38 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iMyPid = Process.myPid();
                int i39 = ((((-101806364) + (((-170246417) | iMyPid) * (-627))) + (((~((-26876656) | iMyPid)) | 171295710) * (-627))) + (((~(iMyPid | 171295710)) | (~((~iMyPid) | 26876655))) * 627)) - 590724143;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr[3])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -590724143};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i42 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char c4 = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30068);
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b14 = $$a[21];
                    byte b15 = (byte) (b14 - 1);
                    byte b16 = b14;
                    Object[] objArr33 = new Object[1];
                    q(b15, b16, (byte) (b16 - 1), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i42, c4, maximumFlingVelocity, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int packedPositionType = 25 - ExpandableListView.getPackedPositionType(0L);
                    char c5 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int packedPositionType2 = 816 - ExpandableListView.getPackedPositionType(0L);
                    byte b17 = $$a[21];
                    byte b18 = b17;
                    Object[] objArr34 = new Object[1];
                    q(b18, (byte) (b18 - 1), b17, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionType, c5, packedPositionType2, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    s(Color.green(0) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int mode = View.MeasureSpec.getMode(0) + 25;
                        char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 30068);
                        int offsetBefore = TextUtils.getOffsetBefore("", 0) + 816;
                        byte[] bArr6 = $$a;
                        byte b19 = (byte) (-bArr6[8]);
                        Object[] objArr37 = new Object[1];
                        q(b19, (byte) (b19 - 2), bArr6[21], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode, cResolveOpacity, offsetBefore, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 123, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -590724143};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i43 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c6 = (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30068);
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                byte b110 = $$a[21];
                byte b111 = (byte) (b110 - 1);
                byte b112 = b110;
                Object[] objArr311 = new Object[1];
                q(b111, b112, (byte) (b112 - 1), objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i43, c6, maximumFlingVelocity2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int packedPositionType3 = 25 - ExpandableListView.getPackedPositionType(0L);
                char c7 = (char) (30069 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int packedPositionType4 = 816 - ExpandableListView.getPackedPositionType(0L);
                byte b113 = $$a[21];
                byte b114 = b113;
                Object[] objArr312 = new Object[1];
                q(b114, (byte) (b114 - 1), b113, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionType3, c7, packedPositionType4, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            s(Color.green(0) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            s(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int mode2 = View.MeasureSpec.getMode(0) + 25;
                char cResolveOpacity2 = (char) (Drawable.resolveOpacity(0, 0) + 30068);
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 816;
                byte[] bArr7 = $$a;
                byte b115 = (byte) (-bArr7[8]);
                Object[] objArr315 = new Object[1];
                q(b115, (byte) (b115 - 2), bArr7[21], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode2, cResolveOpacity2, offsetBefore2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArr[1])[0];
        int i45 = ((int[]) objArr[0])[0];
        if (i45 == i44) {
            int i46 = artificialFrame + 61;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i46 % 128;
            int i47 = i46 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i48 = ((int[]) objArr[3])[0];
            int i49 = ((int[]) objArr[0])[0];
            int i50 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 442321410;
            int i51 = 621177247 + (((~((-984406499) | iCodePointAt2)) | 786234132) * (-318));
            int i52 = ~(786234132 | iCodePointAt2);
            int i53 = ~iCodePointAt2;
            int i54 = i48 + i51 + ((i52 | (~((-72360469) | i53))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(iCodePointAt2 | (-72360469))) | (~(1056766966 | i53))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr40[3])[0] = i56 ^ (i56 << 5);
            int i57 = getARTIFICIAL_FRAME_PACKAGE_NAME + 63;
            artificialFrame = i57 % 128;
            int i58 = i57 % 2;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i59 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
            artificialFrame = i59 % 128;
            int i60 = i59 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        long j5 = ((long) (i44 ^ i45)) ^ (((long) (-261702273)) << 32);
        long j6 = -261702274;
        int i61 = artificialFrame;
        int i62 = i61 + 21;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
        int i63 = i62 % 2;
        int i64 = i61 + 31;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i64 % 128;
        int i65 = i64 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr8 = $$g;
        byte b20 = bArr8[7];
        Object[] objArr42 = new Object[1];
        t(b20, (byte) (b20 | 78), (byte) 43, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b21 = bArr8[24];
        Object[] objArr43 = new Object[1];
        t(b21, b21, bArr8[114], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i66 = ((int[]) objArr[3])[0];
        int i67 = ((int[]) objArr[0])[0];
        int i68 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 476680814;
        int i69 = ~length;
        int i70 = i66 + (-1314835191) + ((796831606 | length) * (-676)) + (((~(793675554 | i69)) | (-796831607)) * 676) + (((~(length | (-3156053))) | (~(i69 | 595503188)) | 201328418) * 676);
        int i71 = (i70 << 13) ^ i70;
        int i72 = i71 ^ (i71 >>> 17);
        ((int[]) objArr44[3])[0] = i72 ^ (i72 << 5);
    }
}
