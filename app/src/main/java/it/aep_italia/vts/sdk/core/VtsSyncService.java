package it.aep_italia.vts.sdk.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.VtsSynchronization;
import it.aep_italia.vts.sdk.dto.domain.VtsSynchronizationDTO;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.properties.StoredProperty;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes6.dex */
public abstract class VtsSyncService extends Service {
    public static final String ACTION_SYNC_COMPLETE = "it.aep_italia.vts.nfc.SYNC_COMPLETE";
    public static final String ACTION_SYNC_FAILED = "it.aep_italia.vts.nfc.SYNC_FAILED";
    public static final String ACTION_SYNC_STARTED = "it.aep_italia.vts.nfc.SYNC_STARTED";
    private VtsSdk a;
    public ListenableFuture.OnResultReadyListener<Throwable> syncListener = new a();
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$f = 36;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {Ascii.EM, 104, 41, -86, 2, 3, Ascii.DC2, 6, 2, -55, 1, 65, Ascii.VT, Ascii.FF, -9, 19, 2, -7, 17, -56, 79, 2, -63, 42, Ascii.EM, 2, 17, -15, Ascii.DC4, 3, -9, 34, -6, Ascii.SO, 0, Ascii.NAK, -74, 57, 33, -3, 17, -9, 19, -24, 19, Ascii.CAN, -2, 6, 67, Ascii.DC2, 4, -57, 62, 1, 8, 8, 3, 19, 6, 2, -55, 65, 10, -6, Ascii.FF, 4, 17, -1, Ascii.CR, -5, Ascii.CR, 3, Ascii.VT, -3, -49, 59, Ascii.DC2, 9, -7, -49, 40, 40, 3, -5, Ascii.ETB, -12, 8, 19, -25, Ascii.CAN, Ascii.DC2, 10, -10, Ascii.SI, -5, 8, -25, 33, 8, Ascii.ETB, 1, 9, Ascii.CR, -79, 37, 50, 4, 9, -9, 19, 1, Ascii.FF, 5};
    private static final int $$e = 32;
    private static final byte[] $$a = {7, 40, -110, -80, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 53;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {56117, 56096, 56106, 56100, 56103, 56109, 56288, 56091, 56123, 56093, 56090, 56105, 56097, 56267, 56098, 56107, 56099, 56102, 56260, 56108, 56088, 56111, 56270, 56110};
    private static int warmup = -1044259946;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    class a implements ListenableFuture.OnResultReadyListener<Throwable> {
        a() {
        }

        @Override // it.aep_italia.vts.sdk.utils.ListenableFuture.OnResultReadyListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultReady(Throwable th) {
            long synchronizationRetryDelay;
            long time = new Date().getTime();
            VtsSdkConfiguration sdkConfiguration = VtsSyncService.this.a.getSdkConfiguration();
            VtsServerInfoDTO vtsServerInfoDTOC = VtsSyncService.this.a.c();
            if (th == null) {
                VtsLog.i("Synchronization completed successfully.", new Object[0]);
                synchronizationRetryDelay = vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.PARAM_SYNC_DELAY, 120L) * 1000;
            } else {
                VtsLog.w("Synchronization failed.", new Object[0]);
                synchronizationRetryDelay = sdkConfiguration.getSynchronizationRetryDelay() * 60000;
            }
            Long lValueOf = Long.valueOf(time + synchronizationRetryDelay);
            VtsSyncService.this.a(lValueOf.longValue());
            VtsSyncService.this.rescheduleService(lValueOf.longValue(), sdkConfiguration.synchronizeUseExactTimes());
            VtsSyncService.this.stopSelf();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, int r7, byte r8) {
        /*
            byte[] r0 = it.aep_italia.vts.sdk.core.VtsSyncService.$$c
            int r8 = r8 * 3
            int r8 = 4 - r8
            int r7 = r7 * 2
            int r1 = r7 + 1
            int r6 = 121 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r7
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L21:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = -r6
            int r6 = r6 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsSyncService.$$g(byte, int, byte):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        SharedDatabase.getInstance(this.a).propertyDao().putValue(StoredProperty.NEXT_SYNCHRONIZATION, j);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 8
            int r8 = 19 - r8
            int r6 = r6 * 28
            int r6 = 112 - r6
            byte[] r0 = it.aep_italia.vts.sdk.core.VtsSyncService.$$a
            int r7 = r7 * 3
            int r1 = 12 - r7
            byte[] r1 = new byte[r1]
            int r7 = 11 - r7
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2f
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2f:
            int r8 = -r8
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsSyncService.b(int, short, byte, java.lang.Object[]):void");
    }

    private static void d(int i, byte b, byte b2, Object[] objArr) {
        int i2 = 49 - b;
        byte[] bArr = $$d;
        int i3 = (b2 * 3) + 36;
        byte[] bArr2 = new byte[i + 3];
        int i4 = i + 2;
        int i5 = -1;
        if (bArr == null) {
            i5 = -1;
            i3 = (i3 + i2) - 6;
            i2++;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i3;
            int i8 = i2 + 1;
            i5 = i6;
            i3 = (i7 + bArr[i2]) - 6;
            i2 = i8;
        }
    }

    public static void forceSynchronization(Context context, Class<? extends VtsSyncService> cls) {
        forceSynchronization(context, cls, false);
    }

    public static void forceSynchronization(Context context, Class<? extends VtsSyncService> cls, boolean z) {
        Intent intent = new Intent(context, cls);
        context.getSharedPreferences("vtsSDK", 0).edit().putBoolean("it.aep_italia.vts.nfc.FORCE_SYNC", true).apply();
        context.getSharedPreferences("vtsSDK", 0).edit().putBoolean("it.aep_italia.vts.nfc.SKIP_REFRESH", z).apply();
        context.startService(intent);
    }

    public static VtsSynchronization getSynchronizationDetails(Context context) {
        VtsSynchronizationDTO vtsSynchronizationDTOA;
        if (context == null || (vtsSynchronizationDTOA = d.a(context)) == null) {
            return null;
        }
        return VtsSynchronization.fromDto(vtsSynchronizationDTOA);
    }

    public static void requestSynchronization(Context context, Class<? extends VtsSyncService> cls) {
        context.startService(new Intent(context, cls));
    }

    public abstract VtsSdk createSdk(Context context) throws VtsException;

    public Long getScheduledTime() {
        return SharedDatabase.getInstance(this.a).propertyDao().getValue(StoredProperty.NEXT_SYNCHRONIZATION);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
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
            VtsLog.e("VtsSyncService", "Could not load SDK within service.", e);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        VtsLog.i("VtsSyncService onStartCommand() started.", new Object[0]);
        new VtsSyncWorkerManager(this, intent);
        WorkManager.getInstance(this).enqueue(new OneTimeWorkRequest.Builder(VtsSyncWorker.class).addTag("worker_tag").build());
        VtsLog.i("VtsSyncService onStartCommand() finished.", new Object[0]);
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
    
        if (r9 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        r0.set(0, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
    
        r0.setExact(0, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        if (r9 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rescheduleService(long r7, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "alarm"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.app.AlarmManager r0 = (android.app.AlarmManager) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            r3 = 201326592(0xc000000, float:9.8607613E-32)
            java.lang.String r4 = "Scheduling next synchronization for: %s"
            r5 = 0
            if (r1 < r2) goto L39
            boolean r1 = app.notifee.core.Notifee$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r1 == 0) goto L69
            java.util.Date r1 = new java.util.Date
            r1.<init>(r7)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            it.aep_italia.vts.sdk.core.VtsLog.d(r4, r1)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class r2 = r6.getClass()
            r1.<init>(r6, r2)
            android.app.PendingIntent r1 = android.app.PendingIntent.getService(r6, r5, r1, r3)
            if (r9 != 0) goto L66
            goto L62
        L39:
            java.util.Date r1 = new java.util.Date
            r1.<init>(r7)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            it.aep_italia.vts.sdk.core.VtsLog.d(r4, r1)
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class r2 = r6.getClass()
            r1.<init>(r6, r2)
            android.app.PendingIntent r1 = android.app.PendingIntent.getService(r6, r5, r1, r3)
            if (r0 != 0) goto L60
            java.lang.String r7 = "Could not reach AlarmManager, service will NOT be scheduled"
            java.lang.Object[] r8 = new java.lang.Object[r5]
            it.aep_italia.vts.sdk.core.VtsLog.w(r7, r8)
            return
        L60:
            if (r9 != 0) goto L66
        L62:
            r0.set(r5, r7, r1)
            goto L69
        L66:
            r0.setExact(r5, r7, r1)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.core.VtsSyncService.rescheduleService(long, boolean):void");
    }

    private static void c(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        char[] cArr2;
        int i2 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        long j = 0;
        if (cArr3 != null) {
            int i3 = $11 + 23;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            int i4 = 0;
            while (i4 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr3[i4])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26, (char) ((Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) - 1), 1041 - (ViewConfiguration.getPressedStateDuration() >> 16), -1719489573, false, $$g(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr2[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
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
            int i5 = $11 + 23;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr3 = cArr2;
        }
        Object[] objArr3 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame2 == null) {
            byte b3 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (20488 - TextUtils.indexOf("", "", 0, 0)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2147, 216472770, false, $$g((byte) ($$f | 18), b3, b3), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
        int i7 = 59174;
        int i8 = -2083387879;
        if (ICustomTabsServiceDefault) {
            int i9 = $10 + com.salesforce.marketingcloud.analytics.stats.b.i;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i8);
                if (objAccessartificialFrame3 == null) {
                    byte b4 = (byte) 0;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.indexOf("", "", 0, 0), (char) (i7 - TextUtils.indexOf("", "", 0, 0)), 1943 - View.getDefaultSize(0, 0), 481771537, false, $$g((byte) ($$f | 19), b4, b4), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                i7 = 59174;
                i8 = -2083387879;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = iArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                onmessagechannelready.a++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        onmessagechannelready.c = cArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            cArr6[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
            try {
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b5 = (byte) 0;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 22, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 59174), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1943, 481771537, false, $$g((byte) ($$f | 19), b5, b5), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0191  */
    /* JADX WARN: Code duplicated, block: B:16:0x0204 A[Catch: all -> 0x09d5, TryCatch #2 {all -> 0x09d5, blocks: (B:51:0x06fc, B:53:0x071c, B:54:0x0762, B:14:0x01f0, B:16:0x0204, B:17:0x0234), top: B:95:0x01f0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x024a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0317  */
    /* JADX WARN: Code duplicated, block: B:50:0x0698  */
    /* JADX WARN: Code duplicated, block: B:53:0x071c A[Catch: all -> 0x09d5, TryCatch #2 {all -> 0x09d5, blocks: (B:51:0x06fc, B:53:0x071c, B:54:0x0762, B:14:0x01f0, B:16:0x0204, B:17:0x0234), top: B:95:0x01f0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0774  */
    /* JADX WARN: Code duplicated, block: B:62:0x0808  */
    @Override // android.app.Service, android.content.ContextWrapper
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
            int offsetAfter = 26 - TextUtils.getOffsetAfter("", 0);
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int i2 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            b((byte) (b - 1), b, bArr[8], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(offsetAfter, touchSlop, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387789L;
            Object[] objArr3 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int i3 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25;
                    char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
                    int packedPositionType = 1041 - ExpandableListView.getPackedPositionType(0L);
                    byte b2 = $$a[5];
                    byte b3 = (byte) (b2 - 1);
                    byte b4 = b2;
                    Object[] objArr5 = new Object[1];
                    b(b3, b4, b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i3, c, packedPositionType, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr6[3])[0];
                int i5 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i6 = ~iIdentityHashCode;
                int i7 = 401681694 + ((480892391 | iIdentityHashCode) * (-676)) + (((~(480859619 | i6)) | (-480892392)) * 676) + (((~(iIdentityHashCode | (-32773))) | (~(i6 | 402755812)) | 78136579) * 676) + 520849645;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i9 ^ (i9 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                c(View.combineMeasuredStates(0, 0) + 127, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {211635578};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 9, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 22251), (ViewConfiguration.getTapTimeout() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 520849645, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 27;
                        char cBlue = (char) Color.blue(0);
                        int iIndexOf = 1040 - TextUtils.indexOf((CharSequence) "", '0');
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        byte b7 = b5;
                        Object[] objArr10 = new Object[1];
                        b(b6, b7, b7, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cBlue, iIndexOf, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 90, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int touchSlop2 = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                            char size = (char) View.MeasureSpec.getSize(0);
                            int doubleTapTimeout = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            byte[] bArr2 = $$a;
                            byte b8 = bArr2[5];
                            Object[] objArr13 = new Object[1];
                            b((byte) (b8 - 1), b8, bArr2[8], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(touchSlop2, size, doubleTapTimeout, 2061780482, false, (String) objArr13[0], null);
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
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            c(View.combineMeasuredStates(0, 0) + 127, new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {211635578};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 9, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 22251), (ViewConfiguration.getTapTimeout() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 520849645, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 27;
                char cBlue2 = (char) Color.blue(0);
                int iIndexOf2 = 1040 - TextUtils.indexOf((CharSequence) "", '0');
                byte b9 = $$a[5];
                byte b10 = (byte) (b9 - 1);
                byte b11 = b9;
                Object[] objArr17 = new Object[1];
                b(b10, b11, b11, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cBlue2, iIndexOf2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 90, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int touchSlop3 = 26 - (ViewConfiguration.getTouchSlop() >> 8);
                char size2 = (char) View.MeasureSpec.getSize(0);
                int doubleTapTimeout2 = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                byte[] bArr3 = $$a;
                byte b12 = bArr3[5];
                Object[] objArr110 = new Object[1];
                b((byte) (b12 - 1), b12, bArr3[8], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(touchSlop3, size2, doubleTapTimeout2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i11 == i10) {
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
            artificialFrame = i12 % 128;
            int i13 = i12 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 1096499906;
            int i17 = ~(595706327 | iCodePointAt);
            int i18 = i14 + 293629533 + (((-1071250912) | i17) * (-814)) + ((i17 | (~((~iCodePointAt) | 517602520)) | 42057936) * 407) + (((~(iCodePointAt | (-517602521))) | (~((-595706328) | iCodePointAt)) | 42057936) * 407);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[1])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = (((long) (-1414871570)) << 32) ^ ((long) (i10 ^ i11));
            long j4 = -1414871572;
            int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
            artificialFrame = i21 % 128;
            int i22 = i21 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$d;
                byte b13 = bArr4[2];
                Object[] objArr22 = new Object[1];
                d(b13, (byte) (b13 + 4), bArr4[0], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b14 = bArr4[34];
                Object[] objArr23 = new Object[1];
                d(b14, bArr4[4], b14, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i26 = ~((-11587842) | iIdentityHashCode2);
                int i27 = ~iIdentityHashCode2;
                int i28 = i23 + 1237046318 + ((i26 | (~((-54927365) | i27))) * 920) + (((~((-11588602) | i27)) | 11587841) * 920) + (((~(iIdentityHashCode2 | (-54927365))) | (~((-11587842) | i27)) | (~((-761) | iIdentityHashCode2))) * 920);
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[1])[0] = i30 ^ (i30 << 5);
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
            int iGreen = 25 - Color.green(0);
            char mode = (char) (View.MeasureSpec.getMode(0) + 30068);
            int i31 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 816;
            byte[] bArr5 = $$a;
            byte b15 = bArr5[5];
            Object[] objArr25 = new Object[1];
            b((byte) (b15 - 1), b15, bArr5[8], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iGreen, mode, i31, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1910;
            Object[] objArr26 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 78, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 92, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i32 = artificialFrame + 61;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i32 % 128;
                int i33 = i32 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                    char tapTimeout = (char) (30068 - (ViewConfiguration.getTapTimeout() >> 16));
                    int keyRepeatTimeout = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b16 = $$a[5];
                    byte b17 = (byte) (b16 - 1);
                    byte b18 = b16;
                    Object[] objArr28 = new Object[1];
                    b(b17, b18, b18, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, tapTimeout, keyRepeatTimeout, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i34 = ((int[]) objArr29[0])[0];
                int i35 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i36 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                int i37 = (((1264953413 + (((~((-82820569) | i36)) | 81797328) * 336)) + (((~(i36 | 115351797)) | (-116375038)) * (-168))) + (((~((~i36) | 115351797)) | (-82820569)) * 168)) - 1804252021;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr[3])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(126 - MotionEvent.axisFromString(""), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1804252021};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int iAlpha = 25 - Color.alpha(0);
                    char offsetBefore = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                    int keyRepeatTimeout2 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b19 = $$a[5];
                    byte b20 = (byte) (b19 - 1);
                    Object[] objArr33 = new Object[1];
                    b(b19, b20, b20, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iAlpha, offsetBefore, keyRepeatTimeout2, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 25;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 30069);
                    int iMyTid = (Process.myTid() >> 22) + 816;
                    byte b21 = $$a[5];
                    byte b22 = (byte) (b21 - 1);
                    byte b23 = b21;
                    Object[] objArr34 = new Object[1];
                    b(b22, b23, b23, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cLastIndexOf, iMyTid, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    c((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    c((ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int keyRepeatDelay = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char keyRepeatDelay2 = (char) (30068 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        int i40 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
                        byte[] bArr6 = $$a;
                        byte b24 = bArr6[5];
                        Object[] objArr37 = new Object[1];
                        b((byte) (b24 - 1), b24, bArr6[8], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, keyRepeatDelay2, i40, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            c(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + com.salesforce.marketingcloud.analytics.stats.b.l, new byte[]{-115, -116, -117, -120, -118, -119, -121, -106, -126, -127, -113, -121, -127, -107, -127, -108}, null, null, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            c(126 - MotionEvent.axisFromString(""), new byte[]{-116, -125, -123, -114, -104, -120, -127, -105, -118, -117, -122, -117, -126, -116, -125, -122}, null, null, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1804252021};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int iAlpha2 = 25 - Color.alpha(0);
                char offsetBefore2 = (char) (30068 - TextUtils.getOffsetBefore("", 0));
                int keyRepeatTimeout3 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b110 = $$a[5];
                byte b25 = (byte) (b110 - 1);
                Object[] objArr311 = new Object[1];
                b(b110, b25, b25, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iAlpha2, offsetBefore2, keyRepeatTimeout3, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0) + 30069);
                int iMyTid2 = (Process.myTid() >> 22) + 816;
                byte b26 = $$a[5];
                byte b27 = (byte) (b26 - 1);
                byte b28 = b26;
                Object[] objArr312 = new Object[1];
                b(b27, b28, b28, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, cLastIndexOf2, iMyTid2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            c((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-111, -112, -123, -113, -114, -115, -116, -117, -120, -118, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, null, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            c((ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-116, -115, -122, -117, -113, -127, -116, -109, -125, -116, -120, -110, -127, -113, -116}, null, null, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int keyRepeatDelay3 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char keyRepeatDelay4 = (char) (30068 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                int i41 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
                byte[] bArr7 = $$a;
                byte b29 = bArr7[5];
                Object[] objArr315 = new Object[1];
                b((byte) (b29 - 1), b29, bArr7[8], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, keyRepeatDelay4, i41, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i42 = ((int[]) objArr[1])[0];
        int i43 = ((int[]) objArr[0])[0];
        if (i43 == i42) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i44 = ((int[]) objArr[3])[0];
            int i45 = ((int[]) objArr[0])[0];
            int i46 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i47 = ~iIdentityHashCode3;
            int i48 = ~(78330275 | i47);
            int i49 = i44 + (-310186427) + ((50627592 | i48) * (-712)) + (((~(iIdentityHashCode3 | 128957867)) | (~(i47 | (-50627593)))) * (-712)) + (((-119842091) | i48) * 712);
            int i50 = (i49 << 13) ^ i49;
            int i51 = i50 ^ (i50 >>> 17);
            ((int[]) objArr40[3])[0] = i51 ^ (i51 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i52 = artificialFrame + 37;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i52 % 128;
            int i53 = i52 % 2;
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i42 ^ i43)) ^ (((long) (-1297060029)) << 32)), Long.valueOf(-1297060030)};
        byte[] bArr8 = $$d;
        Object[] objArr42 = new Object[1];
        d(bArr8[52], bArr8[34], bArr8[35], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = bArr8[34];
        Object[] objArr43 = new Object[1];
        d(b30, bArr8[4], b30, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i54 = ((int[]) objArr[3])[0];
        int i55 = ((int[]) objArr[0])[0];
        int i56 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i57 = ~((~((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3)) | (-639510633));
        int i58 = i54 + (((-939405183) | i57) * (-970)) + 668274235 + ((i57 | 299894550) * 970);
        int i59 = (i58 << 13) ^ i58;
        int i60 = i59 ^ (i59 >>> 17);
        ((int[]) objArr44[3])[0] = i60 ^ (i60 << 5);
    }
}
