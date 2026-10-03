package com.transistorsoft.locationmanager.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.SystemClock;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.util.BackgroundTaskManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import org.apache.commons.lang3.CharEncoding;
import org.joda.time.LocalDateTime;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleJobService extends JobService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static byte[] ICustomTabsCallbackStubProxy;
    private static short[] ICustomTabsService;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int getInterfaceDescriptor;
    private static int mayLaunchUrl;
    private static int onTransact;
    private static final byte[] $$c = {55, -4, -8, -76};
    private static final int $$f = 156;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX INFO: loaded from: classes3.dex */
    class a implements Runnable {
        final /* synthetic */ JobParameters a;

        /* JADX INFO: renamed from: com.transistorsoft.locationmanager.scheduler.ScheduleJobService$a$a, reason: collision with other inner class name */
        class C0128a implements ScheduleEvent.Callback {
            C0128a() {
            }

            @Override // com.transistorsoft.locationmanager.scheduler.ScheduleEvent.Callback
            public void onFinish() {
                a aVar = a.this;
                ScheduleJobService.this.jobFinished(aVar.a, false);
            }
        }

        class b implements BackgroundTaskManager.Callback {
            b() {
            }

            @Override // com.transistorsoft.locationmanager.util.BackgroundTaskManager.Callback
            public void onFinish() {
                a aVar = a.this;
                ScheduleJobService.this.jobFinished(aVar.a, false);
            }
        }

        a(JobParameters jobParameters) {
            this.a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            PersistableBundle extras = this.a.getExtras();
            if (extras.containsKey(TSScheduleManager.ACTION_ONESHOT)) {
                ScheduleEvent.a(ScheduleJobService.this.getApplicationContext(), extras.getString("action", ""), new C0128a());
                return;
            }
            if (extras.containsKey(BackgroundTaskManager.ACTION)) {
                BackgroundTaskManager.getInstance().onStartJob(ScheduleJobService.this.getApplicationContext(), extras.getInt(BackgroundTaskManager.TASK_ID_FIELD), new b());
            } else {
                ScheduleEvent.a(ScheduleJobService.this.getApplicationContext(), this.a.getExtras().getBoolean(ViewProps.ENABLED), this.a.getExtras().getInt("trackingMode", 1));
                ScheduleJobService.this.jobFinished(this.a, false);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r6, byte r7, int r8) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 5
            int r6 = r6 + 112
            int r8 = r8 * 4
            int r0 = 1 - r8
            byte[] r1 = com.transistorsoft.locationmanager.scheduler.ScheduleJobService.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L17
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L1b:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L28:
            int r6 = r6 + 1
            r3 = r1[r6]
        L2c:
            int r7 = r7 + r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.scheduler.ScheduleJobService.$$g(short, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.transistorsoft.locationmanager.scheduler.ScheduleJobService.$$a
            int r9 = 112 - r9
            int r8 = 112 - r8
            int r7 = r7 + 8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r7
            r4 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L22:
            r3 = r0[r8]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r9 = -r9
            int r9 = r9 + r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.scheduler.ScheduleJobService.a(short, short, int, java.lang.Object[]):void");
    }

    private static void c(short s, int i, byte b, Object[] objArr) {
        int i2 = i + 36;
        byte[] bArr = $$d;
        int i3 = s + 4;
        byte[] bArr2 = new byte[67 - b];
        int i4 = 66 - b;
        int i5 = -1;
        if (bArr == null) {
            i2 = (i4 + i2) - 4;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            i3++;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (i2 + bArr[i3]) - 4;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        BackgroundGeolocation.getThreadPool().execute(new a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        TSLog.logger.debug("");
        return true;
    }

    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        int i4;
        int length;
        byte[] bArr;
        int i5;
        int i6;
        int i7 = 2;
        int i8 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = (byte) (b2 - 1);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - TextUtils.getTrimmedLength(""), (char) (36241 - KeyEvent.keyCodeFromString("")), TextUtils.lastIndexOf("", '0') + 2343, 371880939, false, $$g(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            boolean z = iIntValue == -1;
            long j = 0;
            if (z) {
                byte[] bArr2 = ICustomTabsCallbackStubProxy;
                if (bArr2 != null) {
                    int length2 = bArr2.length;
                    byte[] bArr3 = new byte[length2];
                    int i9 = 0;
                    while (i9 < length2) {
                        int i10 = $10 + 61;
                        $11 = i10 % 128;
                        int i11 = i10 % i7;
                        Object[] objArr3 = {Integer.valueOf(bArr2[i9])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            int absoluteGravity = 44 - Gravity.getAbsoluteGravity(0, 0);
                            char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                            int packedPositionType = ExpandableListView.getPackedPositionType(j) + 1215;
                            byte b4 = (byte) 1;
                            byte b5 = (byte) (-b4);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cMakeMeasureSpec, packedPositionType, 1011328145, false, $$g(b4, b5, (byte) (b5 + 1)), new Class[]{Integer.TYPE});
                        }
                        bArr3[i9] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i9++;
                        i7 = 2;
                        j = 0;
                    }
                    bArr2 = bArr3;
                }
                if (bArr2 != null) {
                    int i12 = $11 + 107;
                    $10 = i12 % 128;
                    if (i12 % 2 != 0) {
                        byte[] bArr4 = ICustomTabsCallbackStubProxy;
                        Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 - 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - View.resolveSizeAndState(0, 0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 36242), TextUtils.indexOf("", "", 0) + 2342, 371880939, false, $$g(b6, b7, (byte) (b7 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        i6 = ((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) % ((int) (((long) mayLaunchUrl) - 4629754035390455669L));
                    } else {
                        byte[] bArr5 = ICustomTabsCallbackStubProxy;
                        Object[] objArr5 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame4 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = (byte) (b8 - 1);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 36241), 2342 - KeyEvent.normalizeMetaState(0), 371880939, false, $$g(b8, b9, (byte) (b9 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        i6 = ((byte) (((long) bArr5[((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L)));
                    }
                    iIntValue = (byte) i6;
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i13 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                if (z) {
                    int i14 = $11 + 89;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                iCustomTabsCallback.c = i13 + i4;
                try {
                    Object[] objArr6 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(216546027);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(42 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4065, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    byte[] bArr6 = ICustomTabsCallbackStubProxy;
                    if (bArr6 != null) {
                        int i16 = $11 + 105;
                        $10 = i16 % 128;
                        if (i16 % 2 != 0) {
                            length = bArr6.length;
                            bArr = new byte[length];
                            i5 = 1;
                        } else {
                            length = bArr6.length;
                            bArr = new byte[length];
                            i5 = 0;
                        }
                        while (i5 < length) {
                            bArr[i5] = (byte) (((long) bArr6[i5]) ^ (-4629754035390455669L));
                            i5++;
                        }
                        bArr6 = bArr;
                    }
                    boolean z2 = bArr6 != null;
                    iCustomTabsCallback.a = 1;
                    while (iCustomTabsCallback.a < iIntValue) {
                        if (z2) {
                            byte[] bArr7 = ICustomTabsCallbackStubProxy;
                            int i17 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i17 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i17]) ^ (-4629754035390455669L))) + s)) ^ b));
                        } else {
                            short[] sArr = ICustomTabsService;
                            int i18 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i18 - 1;
                            iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i18]) ^ (-4629754035390455669L))) + s)) ^ b));
                        }
                        sb.append(iCustomTabsCallback.createConnectionCallback);
                        iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                        iCustomTabsCallback.a++;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:16:0x040c A[Catch: all -> 0x0ef2, TryCatch #0 {all -> 0x0ef2, blocks: (B:53:0x0b42, B:55:0x0b56, B:56:0x0b88, B:14:0x03ec, B:16:0x040c, B:17:0x0455), top: B:93:0x03ec }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0467  */
    /* JADX WARN: Code duplicated, block: B:25:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:52:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0b56 A[Catch: all -> 0x0ef2, TryCatch #0 {all -> 0x0ef2, blocks: (B:53:0x0b42, B:55:0x0b56, B:56:0x0b88, B:14:0x03ec, B:16:0x040c, B:17:0x0455), top: B:93:0x03ec }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0b9e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0d40  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int i2 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
            char c = (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30068);
            int i3 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
            byte b = $$a[5];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b2, (byte) (b2 | 108), (byte) (b - 1), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i2, c, i3, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2024;
            Object[] objArr3 = new Object[1];
            b(KeyEvent.keyCodeFromString("") - 302499201, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 57), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 94063496, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 302499201, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 82, (short) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 24), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 94063457, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i4 = artificialFrame + 75;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                int i5 = i4 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iAlpha = 25 - Color.alpha(0);
                    char gidForName = (char) (30067 - Process.getGidForName(""));
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                    byte b3 = $$a[5];
                    byte b4 = b3;
                    Object[] objArr5 = new Object[1];
                    a(b4, (byte) (b4 | 100), (byte) (b3 - 1), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iAlpha, gidForName, scrollBarFadeDuration, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i6 = ((int[]) objArr6[0])[0];
                int i7 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i8 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                int i9 = ~i8;
                int i10 = 8446847 + (((~((-518549547) | i9)) | (~(i8 | (-320377181)))) * 333) + (((~(i8 | (-518549547))) | (~(i9 | (-320377181)))) * 333) + 1947712954;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArr[3])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 302499308, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), TextUtils.getOffsetAfter("", 0) - 33, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 49), (-94063438) - KeyEvent.normalizeMetaState(0), objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499228, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 148, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 136), ExpandableListView.getPackedPositionType(0L) - 94063422, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, 1947712954};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iAxisFromString = 24 - MotionEvent.axisFromString("");
                        char cResolveSize = (char) (View.resolveSize(0, 0) + 30068);
                        int defaultSize = View.getDefaultSize(0, 0) + 816;
                        byte[] bArr = $$a;
                        byte b5 = bArr[117];
                        Object[] objArr10 = new Object[1];
                        a(b5, (byte) (b5 | 89), bArr[1], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iAxisFromString, cResolveSize, defaultSize, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i13 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        char c2 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 30067);
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                        byte b6 = $$a[5];
                        byte b7 = b6;
                        Object[] objArr11 = new Object[1];
                        a(b7, (byte) (b7 | 100), (byte) (b6 - 1), objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i13, c2, scrollBarSize, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-33) - TextUtils.getTrimmedLength(""), (short) ((-53) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 94063475, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 302499233, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 117), (-33) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 44), TextUtils.getTrimmedLength("") - 94063453, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int jumpTapTimeout = 25 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char c3 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
                            byte b8 = $$a[5];
                            byte b9 = b8;
                            Object[] objArr14 = new Object[1];
                            a(b9, (byte) (b9 | 108), (byte) (b8 - 1), objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, c3, iResolveSizeAndState, 721586079, false, (String) objArr14[0], null);
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
            Object[] objArr15 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(2) - 302499308, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), TextUtils.getOffsetAfter("", 0) - 33, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 49), (-94063438) - KeyEvent.normalizeMetaState(0), objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499228, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 148, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 136), ExpandableListView.getPackedPositionType(0L) - 94063422, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, 1947712954};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iAxisFromString2 = 24 - MotionEvent.axisFromString("");
                char cResolveSize2 = (char) (View.resolveSize(0, 0) + 30068);
                int defaultSize2 = View.getDefaultSize(0, 0) + 816;
                byte[] bArr2 = $$a;
                byte b10 = bArr2[117];
                Object[] objArr18 = new Object[1];
                a(b10, (byte) (b10 | 89), bArr2[1], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cResolveSize2, defaultSize2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i14 = 26 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                char c4 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 30067);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
                byte b11 = $$a[5];
                byte b12 = b11;
                Object[] objArr19 = new Object[1];
                a(b12, (byte) (b12 | 100), (byte) (b11 - 1), objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i14, c4, scrollBarSize2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-33) - TextUtils.getTrimmedLength(""), (short) ((-53) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 94063475, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 302499233, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 117), (-33) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 44), TextUtils.getTrimmedLength("") - 94063453, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int jumpTapTimeout2 = 25 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                char c5 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int iResolveSizeAndState2 = 816 - View.resolveSizeAndState(0, 0, 0);
                byte b13 = $$a[5];
                byte b14 = b13;
                Object[] objArr112 = new Object[1];
                a(b14, (byte) (b14 | 108), (byte) (b13 - 1), objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, c5, iResolveSizeAndState2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArr[1])[0];
        int i16 = ((int[]) objArr[0])[0];
        if (i16 == i15) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i17 = ((int[]) objArr[3])[0];
            int i18 = ((int[]) objArr[0])[0];
            int i19 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i20 = i17 + (-1300192843) + ((1037050578 | elapsedCpuTime) * 376) + (((~((~elapsedCpuTime) | 619857400)) | 419439106) * (-376)) + (((~(elapsedCpuTime | (-619857401))) | (-421685035)) * 376);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[3])[0] = i22 ^ (i22 << 5);
            int i23 = artificialFrame + 91;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
            int i24 = i23 % 2;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) 542741364) << 32) ^ ((long) (i15 ^ i16))), Long.valueOf(542741365)};
                byte[] bArr3 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr3[1], bArr3[16], bArr3[5], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr3[16], bArr3[14], (byte) (-bArr3[442]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i25 = ((int[]) objArr[3])[0];
                int i26 = ((int[]) objArr[0])[0];
                int i27 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 1051874418;
                int i28 = i25 + (-372424089) + (((~(393435565 | iCodePointAt)) | 338706820) * (-502)) + ((~((~iCodePointAt) | 930314751)) * (-502)) + (((~(iCodePointAt | (-591607932))) | 393435565) * TypedValues.PositionType.TYPE_DRAWPATH);
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[3])[0] = i30 ^ (i30 << 5);
                int i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                artificialFrame = i31 % 128;
                if (i31 % 2 == 0) {
                    int i32 = 4 % 5;
                }
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
            int iIndexOf = 26 - TextUtils.indexOf("", "");
            char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
            int capsMode = TextUtils.getCapsMode("", 0, 0) + 1041;
            byte b15 = $$a[5];
            byte b16 = b15;
            Object[] objArr25 = new Object[1];
            a(b16, (byte) (b16 | 108), (byte) (b15 - 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf, fadingEdgeLength, capsMode, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i33 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
            artificialFrame = i33 % 128;
            int i34 = i33 % 2;
            long j4 = j3 + 4611686018427387882L;
            Object[] objArr26 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 302499250, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 49), (-32) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 74), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 94063510, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b((KeyEvent.getMaxKeyCode() >> 16) - 302499197, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), (-33) - TextUtils.getTrimmedLength(""), (short) (ExpandableListView.getPackedPositionType(0L) - 23), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 94063554, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i35 = 26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char cRed = (char) Color.red(0);
                    int minimumFlingVelocity = 1041 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    byte b17 = $$a[5];
                    byte b18 = b17;
                    Object[] objArr28 = new Object[1];
                    a(b18, (byte) (b18 | 100), (byte) (b17 - 1), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i35, cRed, minimumFlingVelocity, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i36 = ((int[]) objArr29[3])[0];
                int i37 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 290443275;
                int i38 = ~iCodePointAt2;
                int i39 = ~(533666209 | i38);
                int i40 = (((121968606 + (((-535780772) | i39) * (-712))) + (((~(iCodePointAt2 | (-2114563))) | (~(i38 | 535780771))) * (-712))) + ((455562402 | i39) * 712)) - 901358300;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i42 ^ (i42 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 302499307, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 46), (ViewConfiguration.getDoubleTapTimeout() >> 16) - 33, (short) (Color.rgb(0, 0, 0) + 16777202), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 94063487, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b((-302499194) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 94063533, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {1669680362};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (Process.myPid() >> 22), (char) (22251 - Drawable.resolveOpacity(0, 0)), ((Process.getThreadPriority(0) + 20) >> 6) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -901358300, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                    char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                    int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 1041;
                    byte b19 = $$a[5];
                    byte b20 = b19;
                    Object[] objArr33 = new Object[1];
                    a(b20, (byte) (b20 | 100), (byte) (b19 - 1), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, c6, capsMode2, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 302499313, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 112), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) ((-53) - Color.argb(0, 0, 0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 94063510, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 302499233, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 101), (ViewConfiguration.getPressedStateDuration() >> 16) - 33, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 72), (ViewConfiguration.getJumpTapTimeout() >> 16) - 94063453, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int scrollBarSize4 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                        char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int absoluteGravity = 1041 - Gravity.getAbsoluteGravity(0, 0);
                        byte b21 = $$a[5];
                        byte b22 = b21;
                        Object[] objArr36 = new Object[1];
                        a(b22, (byte) (b22 | 108), (byte) (b21 - 1), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize4, windowTouchSlop, absoluteGravity, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 302499307, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 46), (ViewConfiguration.getDoubleTapTimeout() >> 16) - 33, (short) (Color.rgb(0, 0, 0) + 16777202), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 94063487, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b((-302499194) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 94063533, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1669680362};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (Process.myPid() >> 22), (char) (22251 - Drawable.resolveOpacity(0, 0)), ((Process.getThreadPriority(0) + 20) >> 6) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -901358300, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int scrollBarSize5 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                char c7 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 1041;
                byte b110 = $$a[5];
                byte b23 = b110;
                Object[] objArr310 = new Object[1];
                a(b23, (byte) (b23 | 100), (byte) (b110 - 1), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize5, c7, capsMode3, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 302499313, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 112), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) ((-53) - Color.argb(0, 0, 0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 94063510, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 302499233, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 101), (ViewConfiguration.getPressedStateDuration() >> 16) - 33, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 72), (ViewConfiguration.getJumpTapTimeout() >> 16) - 94063453, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int scrollBarSize6 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int absoluteGravity2 = 1041 - Gravity.getAbsoluteGravity(0, 0);
                byte b24 = $$a[5];
                byte b25 = b24;
                Object[] objArr313 = new Object[1];
                a(b25, (byte) (b25 | 108), (byte) (b24 - 1), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize6, windowTouchSlop2, absoluteGravity2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i44 == i43) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i46 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i47 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i48 = ~((-79693057) | iIdentityHashCode);
            int i49 = ~iIdentityHashCode;
            int i50 = i45 + 867961056 + ((i48 | (~(249219037 | i49))) * 497) + (((~(iIdentityHashCode | 249219037)) | (~((-247629789) | i49)) | 167936732) * 497);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[1])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i43 ^ i44)) ^ (((long) (-1838206916)) << 32)), Long.valueOf(-1838206914)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr4[69], bArr4[16], bArr4[213], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr4[16], bArr4[14], (byte) (-bArr4[442]), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i55 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
        int i56 = ~iMaxMemory;
        int i57 = (-323717492) + (((~((-152094331) | i56)) | 152076920) * (-1188));
        int i58 = (~(iMaxMemory | 152094330)) | 152076920;
        int i59 = ~(230198137 | i56);
        int i60 = i53 + i57 + ((i58 | i59) * 594) + (((~(152094330 | i56)) | (-230215548) | i59) * 594);
        int i61 = (i60 << 13) ^ i60;
        int i62 = i61 ^ (i61 >>> 17);
        ((int[]) objArr44[1])[0] = i62 ^ (i62 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0415  */
    /* JADX WARN: Code duplicated, block: B:207:0x19ac  */
    /* JADX WARN: Code duplicated, block: B:208:0x1a17  */
    /* JADX WARN: Code duplicated, block: B:20:0x041b  */
    /* JADX WARN: Code duplicated, block: B:213:0x1ae2  */
    /* JADX WARN: Code duplicated, block: B:222:0x1c01  */
    /* JADX WARN: Code duplicated, block: B:225:0x1c41 A[Catch: all -> 0x2b69, TryCatch #5 {all -> 0x2b69, blocks: (B:343:0x29eb, B:345:0x29f8, B:346:0x2a2a, B:348:0x2a34, B:350:0x2a41, B:351:0x2a72, B:223:0x1c1f, B:225:0x1c41, B:226:0x1c95, B:189:0x17f2, B:191:0x17f8, B:192:0x1823, B:194:0x184d, B:195:0x18dc, B:81:0x0b38, B:83:0x0b4d, B:84:0x0b78), top: B:392:0x0b38 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x1ca8  */
    /* JADX WARN: Code duplicated, block: B:22:0x0580  */
    /* JADX WARN: Code duplicated, block: B:234:0x1d13  */
    /* JADX WARN: Code duplicated, block: B:238:0x1d65  */
    /* JADX WARN: Code duplicated, block: B:239:0x1ddd  */
    /* JADX WARN: Code duplicated, block: B:241:0x1de9  */
    /* JADX WARN: Code duplicated, block: B:244:0x1ded A[LOOP:0: B:242:0x1dea->B:244:0x1ded, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x058c  */
    /* JADX WARN: Code duplicated, block: B:250:0x1eeb  */
    /* JADX WARN: Code duplicated, block: B:259:0x2046  */
    /* JADX WARN: Code duplicated, block: B:261:0x204d  */
    /* JADX WARN: Code duplicated, block: B:263:0x21d5  */
    /* JADX WARN: Code duplicated, block: B:265:0x21e1  */
    /* JADX WARN: Code duplicated, block: B:267:0x21e5  */
    /* JADX WARN: Code duplicated, block: B:271:0x21f1  */
    /* JADX WARN: Code duplicated, block: B:272:0x21f6  */
    /* JADX WARN: Code duplicated, block: B:277:0x2286  */
    /* JADX WARN: Code duplicated, block: B:279:0x2292  */
    /* JADX WARN: Code duplicated, block: B:281:0x229b  */
    /* JADX WARN: Code duplicated, block: B:286:0x2309  */
    /* JADX WARN: Code duplicated, block: B:287:0x234b  */
    /* JADX WARN: Code duplicated, block: B:289:0x2354  */
    /* JADX WARN: Code duplicated, block: B:294:0x23bf  */
    /* JADX WARN: Code duplicated, block: B:301:0x2421  */
    /* JADX WARN: Code duplicated, block: B:302:0x2496  */
    /* JADX WARN: Code duplicated, block: B:307:0x2585  */
    /* JADX WARN: Code duplicated, block: B:30:0x059d  */
    /* JADX WARN: Code duplicated, block: B:317:0x26a9  */
    /* JADX WARN: Code duplicated, block: B:319:0x26b0  */
    /* JADX WARN: Code duplicated, block: B:31:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:321:0x2816  */
    /* JADX WARN: Code duplicated, block: B:323:0x281a  */
    /* JADX WARN: Code duplicated, block: B:327:0x2826  */
    /* JADX WARN: Code duplicated, block: B:332:0x28c1  */
    /* JADX WARN: Code duplicated, block: B:337:0x292a  */
    /* JADX WARN: Code duplicated, block: B:341:0x297f  */
    /* JADX WARN: Code duplicated, block: B:342:0x29e6  */
    /* JADX WARN: Code duplicated, block: B:345:0x29f8 A[Catch: all -> 0x2b69, TryCatch #5 {all -> 0x2b69, blocks: (B:343:0x29eb, B:345:0x29f8, B:346:0x2a2a, B:348:0x2a34, B:350:0x2a41, B:351:0x2a72, B:223:0x1c1f, B:225:0x1c41, B:226:0x1c95, B:189:0x17f2, B:191:0x17f8, B:192:0x1823, B:194:0x184d, B:195:0x18dc, B:81:0x0b38, B:83:0x0b4d, B:84:0x0b78), top: B:392:0x0b38 }] */
    /* JADX WARN: Code duplicated, block: B:350:0x2a41 A[Catch: all -> 0x2b69, TryCatch #5 {all -> 0x2b69, blocks: (B:343:0x29eb, B:345:0x29f8, B:346:0x2a2a, B:348:0x2a34, B:350:0x2a41, B:351:0x2a72, B:223:0x1c1f, B:225:0x1c41, B:226:0x1c95, B:189:0x17f2, B:191:0x17f8, B:192:0x1823, B:194:0x184d, B:195:0x18dc, B:81:0x0b38, B:83:0x0b4d, B:84:0x0b78), top: B:392:0x0b38 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0728  */
    /* JADX WARN: Code duplicated, block: B:39:0x0731  */
    /* JADX WARN: Code duplicated, block: B:44:0x0797  */
    /* JADX WARN: Code duplicated, block: B:45:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:49:0x07e8  */
    /* JADX WARN: Code duplicated, block: B:80:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0b4d A[Catch: all -> 0x2b69, TryCatch #5 {all -> 0x2b69, blocks: (B:343:0x29eb, B:345:0x29f8, B:346:0x2a2a, B:348:0x2a34, B:350:0x2a41, B:351:0x2a72, B:223:0x1c1f, B:225:0x1c41, B:226:0x1c95, B:189:0x17f2, B:191:0x17f8, B:192:0x1823, B:194:0x184d, B:195:0x18dc, B:81:0x0b38, B:83:0x0b4d, B:84:0x0b78), top: B:392:0x0b38 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0b8f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0bf6  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Context baseContext;
        Object[] objArr;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i;
        int i2;
        Object objAccessartificialFrame3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        int i3;
        Object[] objArr3;
        Object[] objArr4;
        int i4;
        int i5;
        Object[] objArr5;
        Object obj;
        int i6;
        Object obj2;
        int i7;
        int i8;
        Object objAccessartificialFrame6;
        long j;
        Object objAccessartificialFrame7;
        Object[] objArr6;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        int i9;
        int i10;
        ArrayList arrayList;
        String[] strArr;
        int i11;
        Object objAccessartificialFrame10;
        long j2;
        Context baseContext2;
        Object[] objArr7;
        int i12;
        Object objAccessartificialFrame11;
        Long lValueOf;
        Object objAccessartificialFrame12;
        int iLastIndexOf;
        int i13;
        boolean z;
        String str;
        Class[] clsArr;
        char c;
        int i14;
        Object objAccessartificialFrame13;
        int i15;
        int i16;
        int i17;
        int i18;
        Object objAccessartificialFrame14;
        long j3;
        Context baseContext3;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        Object[] objArr8;
        int i19;
        int i20;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        int i21 = 2 % 2;
        Object obj3 = null;
        Object[] objArr9 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 82, (short) (KeyEvent.getDeadChar(0, 0) - 53), (-94063524) + ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499232, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 148, (short) ((-23) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (-94063457) + ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length(), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 302499307, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), (-33) - ((Process.getThreadPriority(0) + 20) >> 6), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 94063473, objArr11);
        String str4 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 302499197, (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 37, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 104), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 94063426, objArr12);
        String str5 = (String) objArr12[0];
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame19 == null) {
            int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 21;
            char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
            int scrollBarSize = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
            byte b = $$a[5];
            byte b2 = b;
            Object[] objArr13 = new Object[1];
            a(b2, (byte) (b2 | 108), (byte) (b - 1), objArr13);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cResolveSizeAndState, scrollBarSize, -785931255, false, (String) objArr13[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j4 != -1) {
            int i22 = artificialFrame + 31;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
            if (i22 % 2 == 0 ? j4 + 1901 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue() : j4 - 1901 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[1]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr14 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499236, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 37, (short) ((-11) - ((Process.getThreadPriority(0) + 20) >> 6)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 94063521, objArr14);
                    Class<?> cls = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 302499314, (byte) (TextUtils.lastIndexOf("", '0') + 1), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 37, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + b.i), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 94063429, objArr15);
                    baseContext = (Context) cls.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                    artificialFrame = i % 128;
                    if (i % 2 != 0) {
                        boolean z2 = baseContext instanceof ContextWrapper;
                        obj3.hashCode();
                        throw null;
                    }
                    if ((!(baseContext instanceof ContextWrapper)) && ((ContextWrapper) baseContext).getBaseContext() == null) {
                        baseContext = null;
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                int iIntValue = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                Object[] objArr16 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 302499242, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (15 - View.getDefaultSize(0, 0)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 94063363, objArr16);
                String str6 = (String) objArr16[0];
                Object[] objArr17 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499280, (byte) (Process.myPid() >> 22), (-33) - (Process.myTid() >> 22), (short) ((-114) - Gravity.getAbsoluteGravity(0, 0)), KeyEvent.keyCodeFromString("") - 94063298, objArr17);
                try {
                    Object[] objArr18 = {baseContext, new String[]{str6, (String) objArr17[0]}, Integer.valueOf(iIntValue), 1, 1982145590};
                    byte[] bArr = $$d;
                    Object[] objArr19 = new Object[1];
                    c((short) 107, bArr[190], bArr[23], objArr19);
                    Class<?> cls2 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    c((short) ($$e & 938), bArr[190], (byte) (bArr[443] - 1), objArr20);
                    objArr = (Object[]) cls2.getMethod((String) objArr20[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr18);
                    int i23 = ((int[]) objArr[0])[0];
                    int i24 = ((int[]) objArr[3])[0];
                    if (baseContext != null) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame == null) {
                            int i25 = 22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                            int i26 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 465;
                            byte b3 = $$a[5];
                            byte b4 = b3;
                            Object[] objArr21 = new Object[1];
                            a(b4, (byte) (b4 | 100), (byte) (b3 - 1), objArr21);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i25, cIndexOf, i26, -612765161, false, (String) objArr21[0], null);
                        }
                        ((Field) objAccessartificialFrame).set(null, objArr);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame2 == null) {
                                int iMyTid = 21 - (Process.myTid() >> 22);
                                char c2 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                                int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                                byte b5 = $$a[5];
                                byte b6 = b5;
                                Object[] objArr22 = new Object[1];
                                a(b6, (byte) (b6 | 108), (byte) (b5 - 1), objArr22);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, c2, minimumFlingVelocity, -785931255, false, (String) objArr22[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, lValueOf2);
                        } catch (Exception unused) {
                            throw new RuntimeException();
                        }
                    } else {
                        objArr = objArr;
                    }
                    objArr2 = objArr;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame20 == null) {
                    int packedPositionChild = 20 - ExpandableListView.getPackedPositionChild(0L);
                    char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                    int keyRepeatDelay = 465 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    byte b7 = $$a[5];
                    byte b8 = b7;
                    Object[] objArr23 = new Object[1];
                    a(b8, (byte) (b8 | 100), (byte) (b7 - 1), objArr23);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cNormalizeMetaState, keyRepeatDelay, -612765161, false, (String) objArr23[0], null);
                }
                Object[] objArr24 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                objArr2 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i27 = ((int[]) objArr24[3])[0];
                int i28 = ((int[]) objArr24[0])[0];
                String[] strArr2 = (String[]) objArr24[1];
                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                int i29 = ~(51564872 | startUptimeMillis);
                int i30 = ~startUptimeMillis;
                int i31 = 561866899 + ((i29 | (~((-51531785) | i30))) * (-406)) + ((~(263446382 | i30)) * (-406)) + (((~(startUptimeMillis | (-211914599))) | (~((-51564873) | i30))) * 406) + 1982145590;
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr2[2])[0] = i33 ^ (i33 << 5);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr110 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499236, (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 37, (short) ((-11) - ((Process.getThreadPriority(0) + 20) >> 6)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 94063521, objArr110);
                Class<?> cls3 = Class.forName((String) objArr110[0]);
                Object[] objArr111 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 302499314, (byte) (TextUtils.lastIndexOf("", '0') + 1), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 37, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + b.i), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 94063429, objArr111);
                baseContext = (Context) cls3.getMethod((String) objArr111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                i = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                artificialFrame = i % 128;
                if (i % 2 != 0) {
                    boolean z3 = baseContext instanceof ContextWrapper;
                    obj3.hashCode();
                    throw null;
                }
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr112 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 302499242, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (15 - View.getDefaultSize(0, 0)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 94063363, objArr112);
            String str7 = (String) objArr112[0];
            Object[] objArr113 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499280, (byte) (Process.myPid() >> 22), (-33) - (Process.myTid() >> 22), (short) ((-114) - Gravity.getAbsoluteGravity(0, 0)), KeyEvent.keyCodeFromString("") - 94063298, objArr113);
            Object[] objArr114 = {baseContext, new String[]{str7, (String) objArr113[0]}, Integer.valueOf(iIntValue2), 1, 1982145590};
            byte[] bArr2 = $$d;
            Object[] objArr115 = new Object[1];
            c((short) 107, bArr2[190], bArr2[23], objArr115);
            Class<?> cls4 = Class.forName((String) objArr115[0]);
            Object[] objArr25 = new Object[1];
            c((short) ($$e & 938), bArr2[190], (byte) (bArr2[443] - 1), objArr25);
            objArr = (Object[]) cls4.getMethod((String) objArr25[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr114);
            int i210 = ((int[]) objArr[0])[0];
            int i211 = ((int[]) objArr[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int i212 = 22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                    int i213 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 465;
                    byte b9 = $$a[5];
                    byte b10 = b9;
                    Object[] objArr26 = new Object[1];
                    a(b10, (byte) (b10 | 100), (byte) (b9 - 1), objArr26);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i212, cIndexOf2, i213, -612765161, false, (String) objArr26[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr);
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int iMyTid2 = 21 - (Process.myTid() >> 22);
                    char c3 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1);
                    int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                    byte b11 = $$a[5];
                    byte b12 = b11;
                    Object[] objArr27 = new Object[1];
                    a(b12, (byte) (b12 | 108), (byte) (b11 - 1), objArr27);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid2, c3, minimumFlingVelocity2, -785931255, false, (String) objArr27[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf3);
            } else {
                objArr = objArr;
            }
            objArr2 = objArr;
        }
        int i34 = ((int[]) objArr2[0])[0];
        int i35 = ((int[]) objArr2[3])[0];
        if (i35 == i34) {
            Object[] objArr28 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i36 = ((int[]) objArr2[2])[0];
            int i37 = ((int[]) objArr2[3])[0];
            int i38 = ((int[]) objArr2[0])[0];
            String[] strArr3 = (String[]) objArr2[1];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 2144683315;
            int i39 = i36 + (-188925037) + (((~((-214097473) | iCodePointAt)) | (~((~iCodePointAt) | (-53747747)))) * (-318)) + (((~(1019403996 | iCodePointAt)) | (-1073151743)) * (-318)) + (((~(iCodePointAt | (-1019403997))) | 859054270) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i40 = (i39 << 13) ^ i39;
            int i41 = i40 ^ (i40 >>> 17);
            ((int[]) objArr28[2])[0] = i41 ^ (i41 << 5);
            i2 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr2[1];
            if (strArr4 != null) {
                for (String str8 : strArr4) {
                    arrayList2.add(str8);
                }
            }
            try {
                Object[] objArr29 = {Long.valueOf(((long) (i34 ^ i35)) ^ (((long) (-1123613282)) << 32)), Long.valueOf(-1123613218)};
                short s = (short) ($$e & 958);
                byte[] bArr3 = $$d;
                Object[] objArr30 = new Object[1];
                c(s, bArr3[16], bArr3[11], objArr30);
                Class<?> cls5 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                c(bArr3[16], bArr3[14], (byte) (-bArr3[442]), objArr31);
                cls5.getMethod((String) objArr31[0], Long.TYPE, Long.TYPE).invoke(null, objArr29);
                Object[] objArr32 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i42 = ((int[]) objArr2[2])[0];
                int i43 = ((int[]) objArr2[3])[0];
                int i44 = ((int[]) objArr2[0])[0];
                String[] strArr5 = (String[]) objArr2[1];
                int i45 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1519524299;
                int i46 = ~i45;
                int i47 = i42 + 858914413 + (((~((-269007945) | i46)) | 268449856) * (-108)) + (((~(i46 | 429357670)) | (~((-429357671) | i45)) | (-429915759)) * 54) + ((i45 | (-429915759)) * 54);
                int i48 = (i47 << 13) ^ i47;
                int i49 = i48 ^ (i48 >>> 17);
                i2 = 0;
                ((int[]) objArr32[2])[0] = i49 ^ (i49 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame21 == null) {
            int i50 = (TypedValue.complexToFraction(i2, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i2, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char defaultSize = (char) View.getDefaultSize(i2, i2);
            int iIndexOf = 1041 - TextUtils.indexOf("", "", i2, i2);
            byte b13 = $$a[5];
            byte b14 = b13;
            Object[] objArr33 = new Object[1];
            a(b14, (byte) (b14 | 108), (byte) (b13 - 1), objArr33);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i50, defaultSize, iIndexOf, 2061780482, false, (String) objArr33[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j5 != -1) {
            int i51 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
            artificialFrame = i51 % 128;
            if (i51 % 2 != 0 ? j5 + 4611686018427387826L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue() : (j5 ^ 4611686018427387826L) < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[1])).longValue()) {
                int iIntValue3 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr34 = {1121371831};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(7 - ImageFormat.getBitsPerPixel(0), (char) (View.resolveSize(0, 0) + 22251), Process.getGidForName("") + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr34), 466952394, false);
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame4 == null) {
                        int scrollBarFadeDuration = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char c4 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int scrollBarFadeDuration2 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte b15 = $$a[5];
                        byte b16 = b15;
                        Object[] objArr35 = new Object[1];
                        a(b16, (byte) (b16 | 100), (byte) (b15 - 1), objArr35);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c4, scrollBarFadeDuration2, 1145017376, false, (String) objArr35[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf4 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame5 == null) {
                            int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                            char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                            int i52 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040;
                            byte b17 = $$a[5];
                            byte b18 = b17;
                            Object[] objArr36 = new Object[1];
                            a(b18, (byte) (b18 | 108), (byte) (b17 - 1), objArr36);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, jumpTapTimeout, i52, 2061780482, false, (String) objArr36[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf4);
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
            } else {
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame22 == null) {
                    int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26;
                    char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                    int pressedStateDuration = 1041 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    byte b19 = $$a[5];
                    byte b20 = b19;
                    Object[] objArr37 = new Object[1];
                    a(b20, (byte) (b20 | 100), (byte) (b19 - 1), objArr37);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cAxisFromString, pressedStateDuration, 1145017376, false, (String) objArr37[0], null);
                }
                Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i53 = ((int[]) objArr38[3])[0];
                int i54 = ((int[]) objArr38[2])[0];
                String[] strArr6 = (String[]) objArr38[0];
                int i55 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i56 = ~(334658420 | i55);
                int i57 = ~i55;
                int i58 = 1567998734 + ((i56 | (~((-56638213) | i57))) * (-406)) + ((~(469400439 | i57)) * (-406)) + (((~(i55 | (-412762228))) | (~((-334658421) | i57))) * 406) + 466952394;
                int i59 = (i58 << 13) ^ i58;
                int i60 = i59 ^ (i59 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i60 ^ (i60 << 5);
            }
        } else {
            int iIntValue4 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {1121371831};
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(7 - ImageFormat.getBitsPerPixel(0), (char) (View.resolveSize(0, 0) + 22251), Process.getGidForName("") + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr39), 466952394, false);
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame4 == null) {
                int scrollBarFadeDuration3 = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char c5 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int scrollBarFadeDuration4 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte b110 = $$a[5];
                byte b111 = b110;
                Object[] objArr310 = new Object[1];
                a(b111, (byte) (b111 | 100), (byte) (b110 - 1), objArr310);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, c5, scrollBarFadeDuration4, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame5 == null) {
                int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 26;
                char jumpTapTimeout2 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int i510 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040;
                byte b112 = $$a[5];
                byte b113 = b112;
                Object[] objArr311 = new Object[1];
                a(b113, (byte) (b113 | 108), (byte) (b112 - 1), objArr311);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, jumpTapTimeout2, i510, 2061780482, false, (String) objArr311[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, lValueOf5);
        }
        int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i62 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i62 == i61) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i63 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i64 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i65 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iNextInt = new Random().nextInt(304370951);
            int i66 = ~iNextInt;
            int i67 = i63 + (-305630840) + (((~((-328710411) | i66)) | (-250606604)) * (-602)) + (((~(iNextInt | (-328710411))) | 286263552 | (~((-208159746) | i66))) * (-301)) + ((~(i66 | (-250606604))) * 301);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            i3 = 0;
            ((int[]) objArr40[1])[0] = i69 ^ (i69 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr8 != null) {
                int i70 = artificialFrame + 89;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
                int i71 = i70 % 2;
                for (String str9 : strArr8) {
                    arrayList3.add(str9);
                }
            }
            Object[] objArr41 = {Long.valueOf(((long) (i61 ^ i62)) ^ (((long) (-1562467424)) << 32)), Long.valueOf(-1562467422)};
            byte[] bArr4 = $$d;
            Object[] objArr42 = new Object[1];
            c(bArr4[69], bArr4[16], bArr4[213], objArr42);
            Class<?> cls6 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            c(bArr4[16], bArr4[14], (byte) (-bArr4[442]), objArr43);
            cls6.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i72 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i73 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i74 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr9 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iMyPid = Process.myPid();
            int i75 = i72 + (-977799262) + (((~(228817379 | iMyPid)) | (-306921187)) * (-964)) + (((~((~iMyPid) | 228817379)) | (-535527396)) * (-964));
            int i76 = (i75 << 13) ^ i75;
            int i77 = i76 ^ (i76 >>> 17);
            i3 = 0;
            ((int[]) objArr44[1])[0] = i77 ^ (i77 << 5);
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame23 == null) {
            int size = 30 - View.MeasureSpec.getSize(i3);
            char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0', i3, i3) + 49363);
            int scrollDefaultDelay = 684 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            byte[] bArr5 = $$a;
            Object[] objArr45 = new Object[1];
            a(bArr5[2], (byte) 82, bArr5[8], objArr45);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(size, cIndexOf3, scrollDefaultDelay, 752929587, false, (String) objArr45[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j6 == -1 || j6 + 1885 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr46 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 302499318, (byte) (Process.myTid() >> 22), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 54, (short) ((ViewConfiguration.getPressedStateDuration() >> 16) - 11), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 94063427, objArr46);
                Class<?> cls7 = Class.forName((String) objArr46[0]);
                Object[] objArr47 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 302499248, (byte) View.MeasureSpec.getMode(0), (-34) - Process.getGidForName(""), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 70), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 94063415, objArr47);
                baseContext4 = (Context) cls7.getMethod((String) objArr47[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                int i78 = artificialFrame + 27;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i78 % 128;
                int i79 = i78 % 2;
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr48 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1319494804};
            short s2 = (short) $$e;
            byte[] bArr6 = $$d;
            Object[] objArr49 = new Object[1];
            c(s2, (byte) (s2 & 333), bArr6[13], objArr49);
            Class<?> cls8 = Class.forName((String) objArr49[0]);
            Object[] objArr50 = new Object[1];
            c((short) 309, bArr6[52], bArr6[443], objArr50);
            objArr3 = (Object[]) cls8.getMethod((String) objArr50[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr48);
            if (baseContext4 != null) {
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame24 == null) {
                    int i80 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29;
                    char size2 = (char) (49362 - View.MeasureSpec.getSize(0));
                    int iIndexOf2 = 683 - TextUtils.indexOf((CharSequence) "", '0');
                    byte[] bArr7 = $$a;
                    Object[] objArr51 = new Object[1];
                    a(bArr7[2], (byte) 67, bArr7[9], objArr51);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i80, size2, iIndexOf2, 1944867703, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, objArr3);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame25 == null) {
                        int iIndexOf3 = 30 - TextUtils.indexOf("", "", 0, 0);
                        char longPressTimeout = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49362);
                        int iResolveSizeAndState = 684 - View.resolveSizeAndState(0, 0, 0);
                        byte[] bArr8 = $$a;
                        Object[] objArr52 = new Object[1];
                        a(bArr8[2], (byte) 82, bArr8[8], objArr52);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf3, longPressTimeout, iResolveSizeAndState, 752929587, false, (String) objArr52[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf6);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame26 == null) {
                int scrollBarFadeDuration5 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30;
                char c6 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                int iMakeMeasureSpec = 684 - View.MeasureSpec.makeMeasureSpec(0, 0);
                byte[] bArr9 = $$a;
                Object[] objArr53 = new Object[1];
                a(bArr9[2], (byte) 67, bArr9[9], objArr53);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, c6, iMakeMeasureSpec, 1944867703, false, (String) objArr53[0], null);
            }
            Object[] objArr54 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr54[0])[0]}, new int[]{((int[]) objArr54[1])[0]}, new int[1], (String) objArr54[3]};
            int i81 = ~Process.myUid();
            int i82 = 315770640 + (((~((-895635646) | i81)) | (-82988130)) * (-983)) + (((~(i81 | (-82988130))) | 9440320) * 983) + 1319494804;
            int i83 = (i82 << 13) ^ i82;
            int i84 = i83 ^ (i83 >>> 17);
            ((int[]) objArr3[2])[0] = i84 ^ (i84 << 5);
        }
        int i85 = ((int[]) objArr3[1])[0];
        int i86 = ((int[]) objArr3[0])[0];
        if (i86 == i85) {
            int i87 = ((int[]) objArr3[2])[0];
            Object[] objArr55 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i88 = ~System.identityHashCode(this);
            int i89 = i87 + ((((~((-743712645) | i88)) | 201336192) * (-241)) - 1540586972) + (((~(i88 | (-542376453))) | 33574938) * 241);
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            ((int[]) objArr55[2])[0] = i91 ^ (i91 << 5);
        } else {
            Object[] objArr56 = {Long.valueOf(((long) (i85 ^ i86)) ^ (((long) 562801605) << 32)), Long.valueOf(562801601)};
            byte[] bArr10 = $$d;
            Object[] objArr57 = new Object[1];
            c((short) 328, bArr10[16], (byte) (-bArr10[279]), objArr57);
            Class<?> cls9 = Class.forName((String) objArr57[0]);
            Object[] objArr58 = new Object[1];
            c(bArr10[16], bArr10[14], (byte) (-bArr10[442]), objArr58);
            cls9.getMethod((String) objArr58[0], Long.TYPE, Long.TYPE).invoke(null, objArr56);
            int i92 = ((int[]) objArr3[2])[0];
            Object[] objArr59 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i93 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1425168547;
            int i94 = i92 + (-1267991058) + (((~(775543762 | i93)) | (-775674847) | (~(203080012 | i93))) * (-744)) + (((~i93) | 202948928) * 744) + ((i93 | 775674846) * 744);
            int i95 = (i94 << 13) ^ i94;
            int i96 = i95 ^ (i95 >>> 17);
            ((int[]) objArr59[2])[0] = i96 ^ (i96 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame27 == null) {
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
            char cMyTid = (char) (49362 - (Process.myTid() >> 22));
            int deadChar = KeyEvent.getDeadChar(0, 0) + 684;
            byte[] bArr11 = $$a;
            Object[] objArr60 = new Object[1];
            a((byte) (-bArr11[4]), (byte) 52, bArr11[9], objArr60);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, cMyTid, deadChar, -1583976536, false, (String) objArr60[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j7 == -1 || j7 + 1932 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr61 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 145156340};
            byte[] bArr12 = $$d;
            Object[] objArr62 = new Object[1];
            c((short) 362, bArr12[16], bArr12[106], objArr62);
            Class<?> cls10 = Class.forName((String) objArr62[0]);
            Object[] objArr63 = new Object[1];
            c((short) 394, bArr12[16], (byte) (-bArr12[118]), objArr63);
            objArr4 = (Object[]) cls10.getMethod((String) objArr63[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr61);
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame28 == null) {
                int absoluteGravity = 30 - Gravity.getAbsoluteGravity(0, 0);
                char modifierMetaStateMask = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 684;
                byte[] bArr13 = $$a;
                Object[] objArr64 = new Object[1];
                a(bArr13[5], (byte) 40, bArr13[11], objArr64);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(absoluteGravity, modifierMetaStateMask, tapTimeout, -1456483158, false, (String) objArr64[0], null);
            }
            ((Field) objAccessartificialFrame28).set(null, objArr4);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame29 == null) {
                    int capsMode = TextUtils.getCapsMode("", 0, 0) + 30;
                    char pressedStateDuration2 = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int i97 = 685 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    byte[] bArr14 = $$a;
                    Object[] objArr65 = new Object[1];
                    a((byte) (-bArr14[4]), (byte) 52, bArr14[9], objArr65);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(capsMode, pressedStateDuration2, i97, -1583976536, false, (String) objArr65[0], null);
                }
                ((Field) objAccessartificialFrame29).set(null, lValueOf7);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame30 == null) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 31;
                char c7 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 49362);
                int i98 = 684 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr15 = $$a;
                Object[] objArr66 = new Object[1];
                a(bArr15[5], (byte) 40, bArr15[11], objArr66);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, c7, i98, -1456483158, false, (String) objArr66[0], null);
            }
            Object[] objArr67 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr67[0])[0]}, new int[]{((int[]) objArr67[1])[0]}, new int[1], (String) objArr67[3]};
            int i99 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1176722128;
            int i100 = (-1639129168) + (((~((-624267710) | i99)) | 85262625) * 345) + (((~((-624267710) | (~i99))) | 269093440) * 345) + ((~(i99 | (-85262626))) * 345) + 145156340;
            int i101 = (i100 << 13) ^ i100;
            int i102 = i101 ^ (i101 >>> 17);
            ((int[]) objArr4[2])[0] = i102 ^ (i102 << 5);
        }
        int i103 = ((int[]) objArr4[1])[0];
        int i104 = ((int[]) objArr4[0])[0];
        if (i104 == i103) {
            int i105 = ((int[]) objArr4[2])[0];
            Object[] objArr68 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i106 = i105 + ((((~((-867569646) | elapsedCpuTime)) | 891847388) * 262) - 975744248) + (((~((~elapsedCpuTime) | (-867569646))) | 891847388) * 262);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            i4 = 0;
            ((int[]) objArr68[2])[0] = i108 ^ (i108 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr69 = {Long.valueOf(((long) (i103 ^ i104)) ^ (((long) (-180853794)) << 32)), Long.valueOf(-180853810)};
            byte[] bArr16 = $$d;
            Object[] objArr70 = new Object[1];
            c((short) 328, bArr16[16], (byte) (-bArr16[279]), objArr70);
            Class<?> cls11 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            c(bArr16[16], bArr16[14], (byte) (-bArr16[442]), objArr71);
            cls11.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            int i109 = ((int[]) objArr4[2])[0];
            Object[] objArr72 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i110 = ~iIdentityHashCode;
            int i111 = i109 + 1243993282 + (((~((-775260329) | i110)) | (~((-203363447) | iIdentityHashCode))) * 210) + (((~(iIdentityHashCode | (-572557449))) | (~(i110 | (-660567)))) * 210);
            int i112 = (i111 << 13) ^ i111;
            int i113 = i112 ^ (i112 >>> 17);
            i4 = 0;
            ((int[]) objArr72[2])[0] = i113 ^ (i113 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame31 == null) {
            int iResolveSizeAndState2 = 36 - View.resolveSizeAndState(i4, i4, i4);
            char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
            int i114 = 540 - (ExpandableListView.getPackedPositionForGroup(i4) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i4) == 0L ? 0 : -1));
            byte b21 = $$a[5];
            byte b22 = b21;
            Object[] objArr73 = new Object[1];
            a(b22, (byte) (b22 | 108), (byte) (b21 - 1), objArr73);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, packedPositionGroup, i114, 624296913, false, (String) objArr73[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame31).getLong(null);
        try {
            if (j8 != -1) {
                i5 = 0;
                if (j8 + 1995 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame32 == null) {
                        int iGreen = 36 - Color.green(0);
                        char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                        int iIndexOf4 = TextUtils.indexOf("", "", 0, 0) + 540;
                        byte b23 = $$a[5];
                        byte b24 = b23;
                        Object[] objArr74 = new Object[1];
                        a(b24, (byte) (b24 | 100), (byte) (b23 - 1), objArr74);
                        objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iGreen, cResolveOpacity, iIndexOf4, 793268735, false, (String) objArr74[0], null);
                    }
                    Object[] objArr75 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                    objArr5 = new Object[]{new int[1], new int[1], new int[1]};
                    int i115 = ((int[]) objArr75[2])[0];
                    int i116 = ((int[]) objArr75[1])[0];
                    ((int[]) objArr5[2])[0] = i115;
                    ((int[]) objArr5[1])[0] = i116;
                    int iMyPid2 = Process.myPid();
                    int i117 = ((((-817678479) + ((~((~iMyPid2) | 1073739635)) * (-116))) + ((989783314 | iMyPid2) * 116)) + (((~(iMyPid2 | (-361838436))) | 277882114) * 116)) - 1827595177;
                    int i118 = (i117 << 13) ^ i117;
                    int i119 = i118 ^ (i118 >>> 17);
                    ((int[]) objArr5[0])[0] = i119 ^ (i119 << 5);
                }
                obj = objArr5[1];
                i6 = ((int[]) obj)[0];
                obj2 = objArr5[2];
                i7 = ((int[]) obj2)[0];
                if (i7 == i6) {
                    Object[] objArr76 = {new int[1], new int[1], new int[1]};
                    int i120 = ((int[]) objArr5[0])[0];
                    int i121 = ((int[]) obj2)[0];
                    int i122 = ((int[]) obj)[0];
                    ((int[]) objArr76[2])[0] = i121;
                    ((int[]) objArr76[1])[0] = i122;
                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                    int i123 = ~iFreeMemory;
                    int i124 = i120 + 464106585 + (((-1175290705) | iFreeMemory) * (-676)) + (((~(166874275 | i123)) | 1175290704) * 676) + (((~(iFreeMemory | 1342164979)) | (~(i123 | (-1184747475))) | 9456770) * 676);
                    int i125 = (i124 << 13) ^ i124;
                    int i126 = i125 ^ (i125 >>> 17);
                    ((int[]) objArr76[0])[0] = i126 ^ (i126 << 5);
                    i8 = 0;
                } else {
                    Object[] objArr77 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-1975789101)) << 32)), Long.valueOf(-1975793197)};
                    byte[] bArr17 = $$d;
                    Object[] objArr78 = new Object[1];
                    c((short) 410, bArr17[16], bArr17[14], objArr78);
                    Class<?> cls12 = Class.forName((String) objArr78[0]);
                    Object[] objArr79 = new Object[1];
                    c(bArr17[16], bArr17[14], (byte) (-bArr17[442]), objArr79);
                    cls12.getMethod((String) objArr79[0], Long.TYPE, Long.TYPE).invoke(null, objArr77);
                    Object[] objArr80 = {new int[1], new int[1], new int[1]};
                    int i127 = ((int[]) objArr5[0])[0];
                    int i128 = ((int[]) objArr5[2])[0];
                    int i129 = ((int[]) objArr5[1])[0];
                    ((int[]) objArr80[2])[0] = i128;
                    ((int[]) objArr80[1])[0] = i129;
                    int i130 = ~System.identityHashCode(this);
                    int i131 = i127 + 1505370408 + (((~((-968069501) | i130)) | (-383552250)) * (-983)) + (((~(i130 | (-383552250))) | 105646721) * 983);
                    int i132 = (i131 << 13) ^ i131;
                    int i133 = i132 ^ (i132 >>> 17);
                    i8 = 0;
                    ((int[]) objArr80[0])[0] = i133 ^ (i133 << 5);
                }
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame6 == null) {
                    int iAlpha = 25 - Color.alpha(i8);
                    char cIndexOf4 = (char) (TextUtils.indexOf("", "", i8) + 30068);
                    int iBlue = 816 - Color.blue(i8);
                    byte b25 = $$a[5];
                    byte b26 = b25;
                    Object[] objArr81 = new Object[1];
                    a(b26, (byte) (b26 | 108), (byte) (b25 - 1), objArr81);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iAlpha, cIndexOf4, iBlue, 721586079, false, (String) objArr81[0], null);
                }
                j = ((Field) objAccessartificialFrame6).getLong(null);
                if (j != -1 || j + 1929 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr82 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1909342602};
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame7 == null) {
                        int keyRepeatDelay2 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                        int iIndexOf5 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        byte[] bArr18 = $$a;
                        byte b27 = bArr18[117];
                        Object[] objArr83 = new Object[1];
                        a(b27, (byte) (b27 | 89), bArr18[1], objArr83);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, touchSlop, iIndexOf5, -797394565, false, (String) objArr83[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr6 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr82);
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame8 == null) {
                        int i134 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                        char cRed = (char) (Color.red(0) + 30068);
                        int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        byte b28 = $$a[5];
                        byte b29 = b28;
                        Object[] objArr84 = new Object[1];
                        a(b29, (byte) (b29 | 100), (byte) (b28 - 1), objArr84);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i134, cRed, maximumFlingVelocity2, 891606461, false, (String) objArr84[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, objArr6);
                    try {
                        Long lValueOf8 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame9 == null) {
                            int keyRepeatDelay3 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            char packedPositionType = (char) (ExpandableListView.getPackedPositionType(0L) + 30068);
                            int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                            byte b30 = $$a[5];
                            byte b31 = b30;
                            Object[] objArr85 = new Object[1];
                            a(b31, (byte) (b31 | 108), (byte) (b30 - 1), objArr85);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, packedPositionType, maximumFlingVelocity3, 721586079, false, (String) objArr85[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, lValueOf8);
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame33 == null) {
                        int i135 = 25 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char cMyPid = (char) (30068 - (Process.myPid() >> 22));
                        int iArgb = Color.argb(0, 0, 0, 0) + 816;
                        byte b32 = $$a[5];
                        byte b33 = b32;
                        Object[] objArr86 = new Object[1];
                        a(b33, (byte) (b33 | 100), (byte) (b32 - 1), objArr86);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i135, cMyPid, iArgb, 891606461, false, (String) objArr86[0], null);
                    }
                    Object[] objArr87 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                    objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i136 = ((int[]) objArr87[0])[0];
                    int i137 = ((int[]) objArr87[1])[0];
                    String[] strArr10 = (String[]) objArr87[2];
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i138 = (-477645683) + (((~((~iIdentityHashCode2) | (-984067163))) | (-785894797)) * (-235)) + (((~((-984067163) | iIdentityHashCode2)) | (-785894797)) * (-470)) + (((~(iIdentityHashCode2 | (-713526281))) | (-1056435679)) * 235) + 1909342602;
                    int i139 = (i138 << 13) ^ i138;
                    int i140 = i139 ^ (i139 >>> 17);
                    ((int[]) objArr6[3])[0] = i140 ^ (i140 << 5);
                }
                i9 = ((int[]) objArr6[1])[0];
                i10 = ((int[]) objArr6[0])[0];
                if (i10 == i9) {
                    int i141 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                    artificialFrame = i141 % 128;
                    int i142 = i141 % 2;
                    Object[] objArr88 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i143 = ((int[]) objArr6[3])[0];
                    int i144 = ((int[]) objArr6[0])[0];
                    int i145 = ((int[]) objArr6[1])[0];
                    String[] strArr11 = (String[]) objArr6[2];
                    int iIdentityHashCode3 = System.identityHashCode(this);
                    int i146 = i143 + 1106474303 + (((~(184633325 | iIdentityHashCode3)) | 13537280) * (-140)) + ((~(198170605 | iIdentityHashCode3)) * 70) + (((~(iIdentityHashCode3 | 13539040)) | 198168845) * 70);
                    int i147 = (i146 << 13) ^ i146;
                    int i148 = i147 ^ (i147 >>> 17);
                    ((int[]) objArr88[3])[0] = i148 ^ (i148 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr6[2];
                    if (strArr != null) {
                        for (String str10 : strArr) {
                            arrayList.add(str10);
                        }
                    }
                    Object[] objArr89 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-726714696)) << 32)), Long.valueOf(-726714695)};
                    byte[] bArr19 = $$d;
                    Object[] objArr90 = new Object[1];
                    c(bArr19[1], bArr19[16], bArr19[5], objArr90);
                    Class<?> cls13 = Class.forName((String) objArr90[0]);
                    Object[] objArr91 = new Object[1];
                    c(bArr19[16], bArr19[14], (byte) (-bArr19[442]), objArr91);
                    cls13.getMethod((String) objArr91[0], Long.TYPE, Long.TYPE).invoke(null, objArr89);
                    Object[] objArr92 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i149 = ((int[]) objArr6[3])[0];
                    int i150 = ((int[]) objArr6[0])[0];
                    int i151 = ((int[]) objArr6[1])[0];
                    String[] strArr12 = (String[]) objArr6[2];
                    int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                    int i152 = i149 + 2015007117 + (((~(862069752 | layoutDirection)) | 202375174) * 576) + (((~((~layoutDirection) | 1064444926)) | 857866944) * 576) + 603983232;
                    int i153 = (i152 << 13) ^ i152;
                    int i154 = i153 ^ (i153 >>> 17);
                    ((int[]) objArr92[3])[0] = i154 ^ (i154 << 5);
                }
                super.onCreate();
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame10 == null) {
                    int i155 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                    char c8 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                    byte[] bArr20 = $$a;
                    byte b34 = (byte) (-bArr20[4]);
                    byte b35 = bArr20[18];
                    byte b36 = bArr20[8];
                    Object[] objArr93 = new Object[1];
                    a(b34, b35, b36, objArr93);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i155, c8, touchSlop2, 508509282, false, (String) objArr93[0], null);
                }
                j2 = ((Field) objAccessartificialFrame10).getLong(null);
                if (j2 != -1 || j2 + 1945 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr94 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 46), (-110840622) - Color.rgb(0, 0, 0), objArr94);
                        Class<?> cls14 = Class.forName((String) objArr94[0]);
                        Object[] objArr95 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 302499235, (byte) Color.argb(0, 0, 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 82, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + b.i), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 94063384, objArr95);
                        baseContext2 = (Context) cls14.getMethod((String) objArr95[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                        artificialFrame = i15 % 128;
                        if (i15 % 2 == 0) {
                            boolean z4 = baseContext2 instanceof ContextWrapper;
                            Object obj4 = null;
                            obj4.hashCode();
                            throw null;
                        }
                        if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    }
                    Object[] objArr96 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), -1003709378};
                    byte[] bArr21 = $$d;
                    Object[] objArr97 = new Object[1];
                    c((short) 476, bArr21[16], bArr21[52], objArr97);
                    Class<?> cls15 = Class.forName((String) objArr97[0]);
                    Object[] objArr98 = new Object[1];
                    c((short) ($$e & 938), bArr21[190], (byte) (bArr21[443] - 1), objArr98);
                    objArr7 = (Object[]) cls15.getMethod((String) objArr98[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr96);
                    if (baseContext2 != null) {
                        i12 = artificialFrame + 35;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                        try {
                            if (i12 % 2 != 0) {
                                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(777251007);
                                if (objAccessartificialFrame13 == null) {
                                    int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 31;
                                    char c9 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                                    int i156 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                                    byte[] bArr22 = $$a;
                                    byte b37 = (byte) (bArr22[5] - 1);
                                    Object[] objArr99 = new Object[1];
                                    a(b37, b37, bArr22[2], objArr99);
                                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, c9, i156, -1321816393, false, (String) objArr99[0], null);
                                }
                                ((Field) objAccessartificialFrame13).set(null, objArr7);
                                lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                                if (objAccessartificialFrame12 == null) {
                                    iLastIndexOf = 30 - Gravity.getAbsoluteGravity(0, 0);
                                    char cResolveOpacity2 = (char) (49362 - Drawable.resolveOpacity(0, 0));
                                    int iIndexOf6 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
                                    i13 = 508509282;
                                    z = false;
                                    byte[] bArr23 = $$a;
                                    Object[] objArr100 = new Object[1];
                                    a((byte) (-bArr23[4]), bArr23[18], bArr23[8], objArr100);
                                    str = (String) objArr100[0];
                                    clsArr = null;
                                    c = cResolveOpacity2;
                                    i14 = iIndexOf6;
                                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                                }
                            } else {
                                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(777251007);
                                if (objAccessartificialFrame11 == null) {
                                    int scrollBarFadeDuration6 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                    char pressedStateDuration3 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                                    int scrollBarFadeDuration7 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 684;
                                    byte[] bArr24 = $$a;
                                    byte b38 = (byte) (bArr24[5] - 1);
                                    Object[] objArr101 = new Object[1];
                                    a(b38, b38, bArr24[2], objArr101);
                                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration6, pressedStateDuration3, scrollBarFadeDuration7, -1321816393, false, (String) objArr101[0], null);
                                }
                                ((Field) objAccessartificialFrame11).set(null, objArr7);
                                lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                                if (objAccessartificialFrame12 == null) {
                                    iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0', 0, 0);
                                    char cLastIndexOf = (char) (49361 - TextUtils.lastIndexOf("", '0', 0));
                                    int iMyPid3 = (Process.myPid() >> 22) + 684;
                                    i13 = 508509282;
                                    z = false;
                                    byte[] bArr25 = $$a;
                                    Object[] objArr102 = new Object[1];
                                    a((byte) (-bArr25[4]), bArr25[18], bArr25[8], objArr102);
                                    str = (String) objArr102[0];
                                    clsArr = null;
                                    c = cLastIndexOf;
                                    i14 = iMyPid3;
                                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                                }
                            }
                            ((Field) objAccessartificialFrame12).set(null, lValueOf);
                        } catch (Exception unused6) {
                            throw new RuntimeException();
                        }
                    }
                } else {
                    int i157 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
                    artificialFrame = i157 % 128;
                    int i158 = i157 % 2;
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame34 == null) {
                        int maxKeyCode = 30 - (KeyEvent.getMaxKeyCode() >> 16);
                        char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
                        int iBlue2 = 684 - Color.blue(0);
                        byte[] bArr26 = $$a;
                        byte b39 = (byte) (bArr26[5] - 1);
                        Object[] objArr103 = new Object[1];
                        a(b39, b39, bArr26[2], objArr103);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(maxKeyCode, cKeyCodeFromString, iBlue2, -1321816393, false, (String) objArr103[0], null);
                    }
                    Object[] objArr104 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr7 = new Object[]{new int[]{((int[]) objArr104[0])[0]}, new int[]{((int[]) objArr104[1])[0]}, new int[1], (String) objArr104[3]};
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) + 1351487536;
                    int i159 = ~iCodePointAt2;
                    int i160 = ((((-120974004) + (((~((-959093157) | i159)) | 19530618) * 519)) + (((~(i159 | (-939563141))) | (~(959093758 | iCodePointAt2))) * (-519))) + (((~(iCodePointAt2 | 19530618)) | 959093156) * 519)) - 1003709378;
                    int i161 = (i160 << 13) ^ i160;
                    int i162 = i161 ^ (i161 >>> 17);
                    ((int[]) objArr7[2])[0] = i162 ^ (i162 << 5);
                }
                i16 = ((int[]) objArr7[1])[0];
                i17 = ((int[]) objArr7[0])[0];
                if (i17 == i16) {
                    int i163 = ((int[]) objArr7[2])[0];
                    Object[] objArr105 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int iIdentityHashCode4 = System.identityHashCode(this);
                    int i164 = ~iIdentityHashCode4;
                    int i165 = ~((-326579747) | i164);
                    int i166 = ~((-652044029) | iIdentityHashCode4);
                    int i167 = i163 + 910669500 + ((i165 | i166) * 1150) + (((~(652044028 | i164)) | i166) * (-575)) + (((~(iIdentityHashCode4 | (-326579747))) | (~(i164 | 326579746))) * 575);
                    int i168 = (i167 << 13) ^ i167;
                    int i169 = i168 ^ (i168 >>> 17);
                    i18 = 0;
                    ((int[]) objArr105[2])[0] = i169 ^ (i169 << 5);
                } else {
                    long j9 = ((long) (i16 ^ i17)) ^ (((long) (-195508709)) << 32);
                    long j10 = -195509221;
                    int i170 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i170 % 128;
                    int i171 = i170 % 2;
                    Object[] objArr106 = {Long.valueOf(j9), Long.valueOf(j10)};
                    short s3 = (short) ($$e | 264);
                    byte[] bArr27 = $$d;
                    Object[] objArr107 = new Object[1];
                    c(s3, bArr27[16], bArr27[299], objArr107);
                    Class<?> cls16 = Class.forName((String) objArr107[0]);
                    Object[] objArr108 = new Object[1];
                    c(bArr27[16], bArr27[14], (byte) (-bArr27[442]), objArr108);
                    cls16.getMethod((String) objArr108[0], Long.TYPE, Long.TYPE).invoke(null, objArr106);
                    int i172 = ((int[]) objArr7[2])[0];
                    Object[] objArr109 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int i173 = ~Process.myUid();
                    int i174 = i172 + (-1609993754) + ((~(973077726 | i173)) * 52) + (((~(142522578 | i173)) | (~((-836101197) | i173)) | 830555148) * (-52)) + (((~(i173 | (-142522579))) | 136976530) * 52);
                    int i175 = (i174 << 13) ^ i174;
                    int i176 = i175 ^ (i175 >>> 17);
                    i18 = 0;
                    ((int[]) objArr109[2])[0] = i176 ^ (i176 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int keyRepeatDelay4 = 17 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char cRgb = (char) (Color.rgb(i18, i18, i18) + 16777216);
                    int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 748;
                    byte b40 = $$a[5];
                    byte b41 = b40;
                    Object[] objArr116 = new Object[1];
                    a(b41, (byte) (b41 | 108), (byte) (b40 - 1), objArr116);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay4, cRgb, packedPositionChild2, -144068856, false, (String) objArr116[0], null);
                }
                j3 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j3 != -1 || j3 + 4611686018427387910L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr117 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499236, (byte) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 47), (-94063406) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr117);
                        Class<?> cls17 = Class.forName((String) objArr117[0]);
                        Object[] objArr118 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 302499220, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 72), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 94063416, objArr118);
                        baseContext3 = (Context) cls17.getMethod((String) objArr118[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        if ((baseContext3 instanceof ContextWrapper) || ((ContextWrapper) baseContext3).getBaseContext() != null) {
                            baseContext3 = baseContext3.getApplicationContext();
                        } else {
                            baseContext3 = null;
                        }
                    }
                    Object[] objArr119 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1301227962};
                    byte[] bArr28 = $$d;
                    Object[] objArr120 = new Object[1];
                    c((short) 535, bArr28[16], bArr28[114], objArr120);
                    Class<?> cls18 = Class.forName((String) objArr120[0]);
                    Object[] objArr121 = new Object[1];
                    c((short) 309, bArr28[52], bArr28[443], objArr121);
                    Object[] objArr122 = (Object[]) cls18.getMethod((String) objArr121[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr119);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int iLastIndexOf3 = 16 - TextUtils.lastIndexOf("", '0');
                        char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int i177 = 748 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte b42 = $$a[5];
                        byte b43 = b42;
                        Object[] objArr123 = new Object[1];
                        a(b43, (byte) (b43 | 100), (byte) (b42 - 1), objArr123);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, maxKeyCode2, i177, -1031537386, false, (String) objArr123[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr122);
                    try {
                        Long lValueOf9 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i178 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 16;
                            char scrollBarFadeDuration8 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 747;
                            byte b44 = $$a[5];
                            byte b45 = b44;
                            Object[] objArr124 = new Object[1];
                            a(b45, (byte) (b45 | 108), (byte) (b44 - 1), objArr124);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i178, scrollBarFadeDuration8, packedPositionGroup2, -144068856, false, (String) objArr124[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf9);
                        objArr8 = objArr122;
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame35 == null) {
                        int i179 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 16;
                        char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iRed = 747 - Color.red(0);
                        byte b46 = $$a[5];
                        byte b47 = b46;
                        Object[] objArr125 = new Object[1];
                        a(b47, (byte) (b47 | 100), (byte) (b46 - 1), objArr125);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i179, cMakeMeasureSpec, iRed, -1031537386, false, (String) objArr125[0], null);
                    }
                    Object[] objArr126 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArr8 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i180 = ((int[]) objArr126[3])[0];
                    int i181 = ((int[]) objArr126[4])[0];
                    List list = (List) objArr126[0];
                    List list2 = (List) objArr126[2];
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i182 = ~iIdentityHashCode5;
                    int i183 = (((-643957651) + (((~((-930143500) | i182)) | (~(iIdentityHashCode5 | (-324695042)))) * 333)) + (((~(iIdentityHashCode5 | (-930143500))) | (~(i182 | (-324695042)))) * 333)) - 1301227962;
                    int i184 = (i183 << 13) ^ i183;
                    int i185 = i184 ^ (i184 >>> 17);
                    ((int[]) objArr8[1])[0] = i185 ^ (i185 << 5);
                }
                i19 = ((int[]) objArr8[4])[0];
                i20 = ((int[]) objArr8[3])[0];
                if (i20 == i19) {
                    Object[] objArr127 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i186 = ((int[]) objArr8[1])[0];
                    int i187 = ((int[]) objArr8[3])[0];
                    int i188 = ((int[]) objArr8[4])[0];
                    List list3 = (List) objArr8[0];
                    List list4 = (List) objArr8[2];
                    int i189 = ~Process.myPid();
                    int i190 = i186 + 1510639305 + (((~(i189 | 1014659434)) | 262144) * (-160)) + (((~(i189 | 409210976)) | 1014659434) * SyslogConstants.LOG_LOCAL4);
                    int i191 = (i190 << 13) ^ i190;
                    int i192 = i191 ^ (i191 >>> 17);
                    ((int[]) objArr127[1])[0] = i192 ^ (i192 << 5);
                    return;
                }
                ArrayList arrayList4 = new ArrayList();
                Object[] objArr128 = {objArr8};
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 41, (char) (12516 - AndroidCharacter.getMirror('0')), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame17).invoke(null, objArr128));
                Object[] objArr129 = {objArr8};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame18 == null) {
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41, (char) (12468 - Drawable.resolveOpacity(0, 0)), 3641 - TextUtils.indexOf((CharSequence) "", '0'), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame18).invoke(null, objArr129));
                Object[] objArr130 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) 1632895212) << 32)), Long.valueOf(1632895204)};
                byte[] bArr29 = $$d;
                Object[] objArr131 = new Object[1];
                c((short) 583, bArr29[16], bArr29[67], objArr131);
                Class<?> cls19 = Class.forName((String) objArr131[0]);
                Object[] objArr132 = new Object[1];
                c(bArr29[16], bArr29[14], (byte) (-bArr29[442]), objArr132);
                cls19.getMethod((String) objArr132[0], Long.TYPE, Long.TYPE).invoke(null, objArr130);
                Object[] objArr133 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i193 = ((int[]) objArr8[1])[0];
                int i194 = ((int[]) objArr8[3])[0];
                int i195 = ((int[]) objArr8[4])[0];
                List list5 = (List) objArr8[0];
                List list6 = (List) objArr8[2];
                int i196 = ~(((int) SystemClock.uptimeMillis()) | 62928901);
                int i197 = i193 + (((58722305 | i196) * (-196)) - 1594374467) + ((i196 | 4206596) * 196);
                int i198 = (i197 << 13) ^ i197;
                int i199 = i198 ^ (i198 >>> 17);
                ((int[]) objArr133[1])[0] = i199 ^ (i199 << 5);
                return;
            }
            i5 = 0;
            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame36 == null) {
                int i200 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 35;
                char keyRepeatDelay5 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int scrollBarSize4 = 540 - (ViewConfiguration.getScrollBarSize() >> 8);
                byte b48 = $$a[5];
                byte b49 = b48;
                Object[] objArr134 = new Object[1];
                a(b49, (byte) (b49 | 108), (byte) (b48 - 1), objArr134);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i200, keyRepeatDelay5, scrollBarSize4, 624296913, false, (String) objArr134[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, lValueOf10);
            obj = objArr5[1];
            i6 = ((int[]) obj)[0];
            obj2 = objArr5[2];
            i7 = ((int[]) obj2)[0];
            if (i7 == i6) {
                Object[] objArr710 = {new int[1], new int[1], new int[1]};
                int i1210 = ((int[]) objArr5[0])[0];
                int i1211 = ((int[]) obj2)[0];
                int i1212 = ((int[]) obj)[0];
                ((int[]) objArr710[2])[0] = i1211;
                ((int[]) objArr710[1])[0] = i1212;
                int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                int i1213 = ~iFreeMemory2;
                int i1214 = i1210 + 464106585 + (((-1175290705) | iFreeMemory2) * (-676)) + (((~(166874275 | i1213)) | 1175290704) * 676) + (((~(iFreeMemory2 | 1342164979)) | (~(i1213 | (-1184747475))) | 9456770) * 676);
                int i1215 = (i1214 << 13) ^ i1214;
                int i1216 = i1215 ^ (i1215 >>> 17);
                ((int[]) objArr710[0])[0] = i1216 ^ (i1216 << 5);
                i8 = 0;
            } else {
                Object[] objArr711 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) (-1975789101)) << 32)), Long.valueOf(-1975793197)};
                byte[] bArr110 = $$d;
                Object[] objArr712 = new Object[1];
                c((short) 410, bArr110[16], bArr110[14], objArr712);
                Class<?> cls110 = Class.forName((String) objArr712[0]);
                Object[] objArr713 = new Object[1];
                c(bArr110[16], bArr110[14], (byte) (-bArr110[442]), objArr713);
                cls110.getMethod((String) objArr713[0], Long.TYPE, Long.TYPE).invoke(null, objArr711);
                Object[] objArr810 = {new int[1], new int[1], new int[1]};
                int i1217 = ((int[]) objArr5[0])[0];
                int i1218 = ((int[]) objArr5[2])[0];
                int i1219 = ((int[]) objArr5[1])[0];
                ((int[]) objArr810[2])[0] = i1218;
                ((int[]) objArr810[1])[0] = i1219;
                int i1310 = ~System.identityHashCode(this);
                int i1311 = i1217 + 1505370408 + (((~((-968069501) | i1310)) | (-383552250)) * (-983)) + (((~(i1310 | (-383552250))) | 105646721) * 983);
                int i1312 = (i1311 << 13) ^ i1311;
                int i1313 = i1312 ^ (i1312 >>> 17);
                i8 = 0;
                ((int[]) objArr810[0])[0] = i1313 ^ (i1313 << 5);
            }
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iAlpha2 = 25 - Color.alpha(i8);
                char cIndexOf5 = (char) (TextUtils.indexOf("", "", i8) + 30068);
                int iBlue3 = 816 - Color.blue(i8);
                byte b210 = $$a[5];
                byte b211 = b210;
                Object[] objArr811 = new Object[1];
                a(b211, (byte) (b211 | 108), (byte) (b210 - 1), objArr811);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iAlpha2, cIndexOf5, iBlue3, 721586079, false, (String) objArr811[0], null);
            }
            j = ((Field) objAccessartificialFrame6).getLong(null);
            if (j != -1) {
                Object[] objArr812 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1909342602};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame7 == null) {
                    int keyRepeatDelay6 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char touchSlop3 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                    int iIndexOf7 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte[] bArr111 = $$a;
                    byte b212 = bArr111[117];
                    Object[] objArr813 = new Object[1];
                    a(b212, (byte) (b212 | 89), bArr111[1], objArr813);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay6, touchSlop3, iIndexOf7, -797394565, false, (String) objArr813[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr812);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i1314 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                    char cRed2 = (char) (Color.red(0) + 30068);
                    int maximumFlingVelocity4 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b213 = $$a[5];
                    byte b214 = b213;
                    Object[] objArr814 = new Object[1];
                    a(b214, (byte) (b214 | 100), (byte) (b213 - 1), objArr814);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i1314, cRed2, maximumFlingVelocity4, 891606461, false, (String) objArr814[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr6);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame9 == null) {
                    int keyRepeatDelay7 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char packedPositionType2 = (char) (ExpandableListView.getPackedPositionType(0L) + 30068);
                    int maximumFlingVelocity5 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b310 = $$a[5];
                    byte b311 = b310;
                    Object[] objArr815 = new Object[1];
                    a(b311, (byte) (b311 | 108), (byte) (b310 - 1), objArr815);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay7, packedPositionType2, maximumFlingVelocity5, 721586079, false, (String) objArr815[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf11);
            } else {
                Object[] objArr816 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1909342602};
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame7 == null) {
                    int keyRepeatDelay8 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char touchSlop4 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                    int iIndexOf8 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte[] bArr112 = $$a;
                    byte b215 = bArr112[117];
                    Object[] objArr817 = new Object[1];
                    a(b215, (byte) (b215 | 89), bArr112[1], objArr817);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay8, touchSlop4, iIndexOf8, -797394565, false, (String) objArr817[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr816);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i1315 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 24;
                    char cRed3 = (char) (Color.red(0) + 30068);
                    int maximumFlingVelocity6 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b216 = $$a[5];
                    byte b217 = b216;
                    Object[] objArr818 = new Object[1];
                    a(b217, (byte) (b217 | 100), (byte) (b216 - 1), objArr818);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i1315, cRed3, maximumFlingVelocity6, 891606461, false, (String) objArr818[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr6);
                Long lValueOf12 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame9 == null) {
                    int keyRepeatDelay9 = 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    char packedPositionType3 = (char) (ExpandableListView.getPackedPositionType(0L) + 30068);
                    int maximumFlingVelocity7 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b312 = $$a[5];
                    byte b313 = b312;
                    Object[] objArr819 = new Object[1];
                    a(b313, (byte) (b313 | 108), (byte) (b312 - 1), objArr819);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay9, packedPositionType3, maximumFlingVelocity7, 721586079, false, (String) objArr819[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf12);
            }
            i9 = ((int[]) objArr6[1])[0];
            i10 = ((int[]) objArr6[0])[0];
            if (i10 == i9) {
                int i1410 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                artificialFrame = i1410 % 128;
                int i1411 = i1410 % 2;
                Object[] objArr820 = {new int[]{i144}, new int[]{i145}, strArr11, new int[1]};
                int i1412 = ((int[]) objArr6[3])[0];
                int i1413 = ((int[]) objArr6[0])[0];
                int i1414 = ((int[]) objArr6[1])[0];
                String[] strArr13 = (String[]) objArr6[2];
                int iIdentityHashCode6 = System.identityHashCode(this);
                int i1415 = i1412 + 1106474303 + (((~(184633325 | iIdentityHashCode6)) | 13537280) * (-140)) + ((~(198170605 | iIdentityHashCode6)) * 70) + (((~(iIdentityHashCode6 | 13539040)) | 198168845) * 70);
                int i1416 = (i1415 << 13) ^ i1415;
                int i1417 = i1416 ^ (i1416 >>> 17);
                ((int[]) objArr820[3])[0] = i1417 ^ (i1417 << 5);
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr6[2];
                if (strArr != null) {
                    while (i11 < strArr.length) {
                        arrayList.add(str10);
                    }
                }
                Object[] objArr821 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-726714696)) << 32)), Long.valueOf(-726714695)};
                byte[] bArr113 = $$d;
                Object[] objArr910 = new Object[1];
                c(bArr113[1], bArr113[16], bArr113[5], objArr910);
                Class<?> cls111 = Class.forName((String) objArr910[0]);
                Object[] objArr911 = new Object[1];
                c(bArr113[16], bArr113[14], (byte) (-bArr113[442]), objArr911);
                cls111.getMethod((String) objArr911[0], Long.TYPE, Long.TYPE).invoke(null, objArr821);
                Object[] objArr912 = {new int[]{i150}, new int[]{i151}, strArr12, new int[1]};
                int i1418 = ((int[]) objArr6[3])[0];
                int i1510 = ((int[]) objArr6[0])[0];
                int i1511 = ((int[]) objArr6[1])[0];
                String[] strArr14 = (String[]) objArr6[2];
                int layoutDirection2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i1512 = i1418 + 2015007117 + (((~(862069752 | layoutDirection2)) | 202375174) * 576) + (((~((~layoutDirection2) | 1064444926)) | 857866944) * 576) + 603983232;
                int i1513 = (i1512 << 13) ^ i1512;
                int i1514 = i1513 ^ (i1513 >>> 17);
                ((int[]) objArr912[3])[0] = i1514 ^ (i1514 << 5);
            }
            super.onCreate();
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-2127922582);
            if (objAccessartificialFrame10 == null) {
                int i1515 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char c10 = (char) (49363 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int touchSlop5 = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                byte[] bArr210 = $$a;
                byte b314 = (byte) (-bArr210[4]);
                byte b315 = bArr210[18];
                byte b316 = bArr210[8];
                Object[] objArr913 = new Object[1];
                a(b314, b315, b316, objArr913);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i1515, c10, touchSlop5, 508509282, false, (String) objArr913[0], null);
            }
            j2 = ((Field) objAccessartificialFrame10).getLong(null);
            if (j2 != -1) {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr914 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 46), (-110840622) - Color.rgb(0, 0, 0), objArr914);
                    Class<?> cls112 = Class.forName((String) objArr914[0]);
                    Object[] objArr915 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 302499235, (byte) Color.argb(0, 0, 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 82, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + b.i), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 94063384, objArr915);
                    baseContext2 = (Context) cls112.getMethod((String) objArr915[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                    artificialFrame = i15 % 128;
                    if (i15 % 2 == 0) {
                        boolean z5 = baseContext2 instanceof ContextWrapper;
                        Object obj5 = null;
                        obj5.hashCode();
                        throw null;
                    }
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr916 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), -1003709378};
                byte[] bArr211 = $$d;
                Object[] objArr917 = new Object[1];
                c((short) 476, bArr211[16], bArr211[52], objArr917);
                Class<?> cls113 = Class.forName((String) objArr917[0]);
                Object[] objArr918 = new Object[1];
                c((short) ($$e & 938), bArr211[190], (byte) (bArr211[443] - 1), objArr918);
                objArr7 = (Object[]) cls113.getMethod((String) objArr918[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr916);
                if (baseContext2 != null) {
                    i12 = artificialFrame + 35;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                    if (i12 % 2 != 0) {
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame13 == null) {
                            int iLastIndexOf4 = TextUtils.lastIndexOf("", '0', 0, 0) + 31;
                            char c11 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                            int i1516 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                            byte[] bArr212 = $$a;
                            byte b317 = (byte) (bArr212[5] - 1);
                            Object[] objArr919 = new Object[1];
                            a(b317, b317, bArr212[2], objArr919);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, c11, i1516, -1321816393, false, (String) objArr919[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, objArr7);
                        lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame12 == null) {
                            iLastIndexOf = 30 - Gravity.getAbsoluteGravity(0, 0);
                            char cResolveOpacity3 = (char) (49362 - Drawable.resolveOpacity(0, 0));
                            int iIndexOf9 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
                            i13 = 508509282;
                            z = false;
                            byte[] bArr213 = $$a;
                            Object[] objArr1010 = new Object[1];
                            a((byte) (-bArr213[4]), bArr213[18], bArr213[8], objArr1010);
                            str = (String) objArr1010[0];
                            clsArr = null;
                            c = cResolveOpacity3;
                            i14 = iIndexOf9;
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                        }
                    } else {
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame11 == null) {
                            int scrollBarFadeDuration9 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char pressedStateDuration4 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                            int scrollBarFadeDuration10 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 684;
                            byte[] bArr214 = $$a;
                            byte b318 = (byte) (bArr214[5] - 1);
                            Object[] objArr1011 = new Object[1];
                            a(b318, b318, bArr214[2], objArr1011);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration9, pressedStateDuration4, scrollBarFadeDuration10, -1321816393, false, (String) objArr1011[0], null);
                        }
                        ((Field) objAccessartificialFrame11).set(null, objArr7);
                        lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame12 == null) {
                            iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0', 0, 0);
                            char cLastIndexOf2 = (char) (49361 - TextUtils.lastIndexOf("", '0', 0));
                            int iMyPid4 = (Process.myPid() >> 22) + 684;
                            i13 = 508509282;
                            z = false;
                            byte[] bArr215 = $$a;
                            Object[] objArr1012 = new Object[1];
                            a((byte) (-bArr215[4]), bArr215[18], bArr215[8], objArr1012);
                            str = (String) objArr1012[0];
                            clsArr = null;
                            c = cLastIndexOf2;
                            i14 = iMyPid4;
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                        }
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf);
                }
            } else {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr9110 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 302499205, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 46), (-110840622) - Color.rgb(0, 0, 0), objArr9110);
                    Class<?> cls114 = Class.forName((String) objArr9110[0]);
                    Object[] objArr9111 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 302499235, (byte) Color.argb(0, 0, 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 82, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + b.i), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 94063384, objArr9111);
                    baseContext2 = (Context) cls114.getMethod((String) objArr9111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                    artificialFrame = i15 % 128;
                    if (i15 % 2 == 0) {
                        boolean z6 = baseContext2 instanceof ContextWrapper;
                        Object obj6 = null;
                        obj6.hashCode();
                        throw null;
                    }
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr9112 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), -1003709378};
                byte[] bArr216 = $$d;
                Object[] objArr9113 = new Object[1];
                c((short) 476, bArr216[16], bArr216[52], objArr9113);
                Class<?> cls115 = Class.forName((String) objArr9113[0]);
                Object[] objArr9114 = new Object[1];
                c((short) ($$e & 938), bArr216[190], (byte) (bArr216[443] - 1), objArr9114);
                objArr7 = (Object[]) cls115.getMethod((String) objArr9114[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr9112);
                if (baseContext2 != null) {
                    i12 = artificialFrame + 35;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                    if (i12 % 2 != 0) {
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame13 == null) {
                            int iLastIndexOf5 = TextUtils.lastIndexOf("", '0', 0, 0) + 31;
                            char c12 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                            int i1517 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                            byte[] bArr217 = $$a;
                            byte b319 = (byte) (bArr217[5] - 1);
                            Object[] objArr9115 = new Object[1];
                            a(b319, b319, bArr217[2], objArr9115);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf5, c12, i1517, -1321816393, false, (String) objArr9115[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, objArr7);
                        lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame12 == null) {
                            iLastIndexOf = 30 - Gravity.getAbsoluteGravity(0, 0);
                            char cResolveOpacity4 = (char) (49362 - Drawable.resolveOpacity(0, 0));
                            int iIndexOf10 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
                            i13 = 508509282;
                            z = false;
                            byte[] bArr218 = $$a;
                            Object[] objArr1013 = new Object[1];
                            a((byte) (-bArr218[4]), bArr218[18], bArr218[8], objArr1013);
                            str = (String) objArr1013[0];
                            clsArr = null;
                            c = cResolveOpacity4;
                            i14 = iIndexOf10;
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                        }
                    } else {
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame11 == null) {
                            int scrollBarFadeDuration11 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char pressedStateDuration5 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                            int scrollBarFadeDuration12 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 684;
                            byte[] bArr219 = $$a;
                            byte b3110 = (byte) (bArr219[5] - 1);
                            Object[] objArr1014 = new Object[1];
                            a(b3110, b3110, bArr219[2], objArr1014);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration11, pressedStateDuration5, scrollBarFadeDuration12, -1321816393, false, (String) objArr1014[0], null);
                        }
                        ((Field) objAccessartificialFrame11).set(null, objArr7);
                        lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame12 == null) {
                            iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0', 0, 0);
                            char cLastIndexOf3 = (char) (49361 - TextUtils.lastIndexOf("", '0', 0));
                            int iMyPid5 = (Process.myPid() >> 22) + 684;
                            i13 = 508509282;
                            z = false;
                            byte[] bArr2110 = $$a;
                            Object[] objArr1015 = new Object[1];
                            a((byte) (-bArr2110[4]), bArr2110[18], bArr2110[8], objArr1015);
                            str = (String) objArr1015[0];
                            clsArr = null;
                            c = cLastIndexOf3;
                            i14 = iMyPid5;
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, i14, i13, z, str, clsArr);
                        }
                    }
                    ((Field) objAccessartificialFrame12).set(null, lValueOf);
                }
            }
            i16 = ((int[]) objArr7[1])[0];
            i17 = ((int[]) objArr7[0])[0];
            if (i17 == i16) {
                int i1610 = ((int[]) objArr7[2])[0];
                Object[] objArr1016 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i1611 = ~iIdentityHashCode7;
                int i1612 = ~((-326579747) | i1611);
                int i1613 = ~((-652044029) | iIdentityHashCode7);
                int i1614 = i1610 + 910669500 + ((i1612 | i1613) * 1150) + (((~(652044028 | i1611)) | i1613) * (-575)) + (((~(iIdentityHashCode7 | (-326579747))) | (~(i1611 | 326579746))) * 575);
                int i1615 = (i1614 << 13) ^ i1614;
                int i1616 = i1615 ^ (i1615 >>> 17);
                i18 = 0;
                ((int[]) objArr1016[2])[0] = i1616 ^ (i1616 << 5);
            } else {
                long j11 = ((long) (i16 ^ i17)) ^ (((long) (-195508709)) << 32);
                long j12 = -195509221;
                int i1710 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1710 % 128;
                int i1711 = i1710 % 2;
                Object[] objArr1017 = {Long.valueOf(j11), Long.valueOf(j12)};
                short s4 = (short) ($$e | 264);
                byte[] bArr220 = $$d;
                Object[] objArr1018 = new Object[1];
                c(s4, bArr220[16], bArr220[299], objArr1018);
                Class<?> cls116 = Class.forName((String) objArr1018[0]);
                Object[] objArr1019 = new Object[1];
                c(bArr220[16], bArr220[14], (byte) (-bArr220[442]), objArr1019);
                cls116.getMethod((String) objArr1019[0], Long.TYPE, Long.TYPE).invoke(null, objArr1017);
                int i1712 = ((int[]) objArr7[2])[0];
                Object[] objArr1020 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int i1713 = ~Process.myUid();
                int i1714 = i1712 + (-1609993754) + ((~(973077726 | i1713)) * 52) + (((~(142522578 | i1713)) | (~((-836101197) | i1713)) | 830555148) * (-52)) + (((~(i1713 | (-142522579))) | 136976530) * 52);
                int i1715 = (i1714 << 13) ^ i1714;
                int i1716 = i1715 ^ (i1715 >>> 17);
                i18 = 0;
                ((int[]) objArr1020[2])[0] = i1716 ^ (i1716 << 5);
            }
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame14 == null) {
                int keyRepeatDelay10 = 17 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char cRgb2 = (char) (Color.rgb(i18, i18, i18) + 16777216);
                int packedPositionChild3 = ExpandableListView.getPackedPositionChild(0L) + 748;
                byte b410 = $$a[5];
                byte b411 = b410;
                Object[] objArr1110 = new Object[1];
                a(b411, (byte) (b411 | 108), (byte) (b410 - 1), objArr1110);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay10, cRgb2, packedPositionChild3, -144068856, false, (String) objArr1110[0], null);
            }
            j3 = ((Field) objAccessartificialFrame14).getLong(null);
            if (j3 != -1) {
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr1111 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499236, (byte) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 47), (-94063406) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr1111);
                    Class<?> cls117 = Class.forName((String) objArr1111[0]);
                    Object[] objArr1112 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 302499220, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 72), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 94063416, objArr1112);
                    baseContext3 = (Context) cls117.getMethod((String) objArr1112[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    if (baseContext3 instanceof ContextWrapper) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = baseContext3.getApplicationContext();
                    }
                }
                Object[] objArr1113 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1301227962};
                byte[] bArr221 = $$d;
                Object[] objArr1210 = new Object[1];
                c((short) 535, bArr221[16], bArr221[114], objArr1210);
                Class<?> cls118 = Class.forName((String) objArr1210[0]);
                Object[] objArr1211 = new Object[1];
                c((short) 309, bArr221[52], bArr221[443], objArr1211);
                Object[] objArr1212 = (Object[]) cls118.getMethod((String) objArr1211[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1113);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int iLastIndexOf6 = 16 - TextUtils.lastIndexOf("", '0');
                    char maxKeyCode3 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int i1717 = 748 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte b412 = $$a[5];
                    byte b413 = b412;
                    Object[] objArr1213 = new Object[1];
                    a(b413, (byte) (b413 | 100), (byte) (b412 - 1), objArr1213);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iLastIndexOf6, maxKeyCode3, i1717, -1031537386, false, (String) objArr1213[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr1212);
                Long lValueOf13 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int i1718 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 16;
                    char scrollBarFadeDuration13 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 747;
                    byte b414 = $$a[5];
                    byte b415 = b414;
                    Object[] objArr1214 = new Object[1];
                    a(b415, (byte) (b415 | 108), (byte) (b414 - 1), objArr1214);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1718, scrollBarFadeDuration13, packedPositionGroup3, -144068856, false, (String) objArr1214[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf13);
                objArr8 = objArr1212;
            } else {
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr1114 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 302499236, (byte) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 47), (-94063406) - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr1114);
                    Class<?> cls119 = Class.forName((String) objArr1114[0]);
                    Object[] objArr1115 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 302499220, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 68, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 72), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 94063416, objArr1115);
                    baseContext3 = (Context) cls119.getMethod((String) objArr1115[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    if (baseContext3 instanceof ContextWrapper) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = baseContext3.getApplicationContext();
                    }
                }
                Object[] objArr1116 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1301227962};
                byte[] bArr222 = $$d;
                Object[] objArr1215 = new Object[1];
                c((short) 535, bArr222[16], bArr222[114], objArr1215);
                Class<?> cls1110 = Class.forName((String) objArr1215[0]);
                Object[] objArr1216 = new Object[1];
                c((short) 309, bArr222[52], bArr222[443], objArr1216);
                Object[] objArr1217 = (Object[]) cls1110.getMethod((String) objArr1216[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1116);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int iLastIndexOf7 = 16 - TextUtils.lastIndexOf("", '0');
                    char maxKeyCode4 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int i1719 = 748 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte b416 = $$a[5];
                    byte b417 = b416;
                    Object[] objArr1218 = new Object[1];
                    a(b417, (byte) (b417 | 100), (byte) (b416 - 1), objArr1218);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iLastIndexOf7, maxKeyCode4, i1719, -1031537386, false, (String) objArr1218[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr1217);
                Long lValueOf14 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int i17110 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 16;
                    char scrollBarFadeDuration14 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 747;
                    byte b418 = $$a[5];
                    byte b419 = b418;
                    Object[] objArr1219 = new Object[1];
                    a(b419, (byte) (b419 | 108), (byte) (b418 - 1), objArr1219);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i17110, scrollBarFadeDuration14, packedPositionGroup4, -144068856, false, (String) objArr1219[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf14);
                objArr8 = objArr1217;
            }
            i19 = ((int[]) objArr8[4])[0];
            i20 = ((int[]) objArr8[3])[0];
            if (i20 == i19) {
                Object[] objArr1220 = {list3, new int[1], list4, new int[]{i187}, new int[]{i188}};
                int i1810 = ((int[]) objArr8[1])[0];
                int i1811 = ((int[]) objArr8[3])[0];
                int i1812 = ((int[]) objArr8[4])[0];
                List list7 = (List) objArr8[0];
                List list8 = (List) objArr8[2];
                int i1813 = ~Process.myPid();
                int i1910 = i1810 + 1510639305 + (((~(i1813 | 1014659434)) | 262144) * (-160)) + (((~(i1813 | 409210976)) | 1014659434) * SyslogConstants.LOG_LOCAL4);
                int i1911 = (i1910 << 13) ^ i1910;
                int i1912 = i1911 ^ (i1911 >>> 17);
                ((int[]) objArr1220[1])[0] = i1912 ^ (i1912 << 5);
                return;
            }
            ArrayList arrayList5 = new ArrayList();
            Object[] objArr1221 = {objArr8};
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame17 == null) {
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 41, (char) (12516 - AndroidCharacter.getMirror('0')), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame17).invoke(null, objArr1221));
            Object[] objArr1222 = {objArr8};
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame18 == null) {
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41, (char) (12468 - Drawable.resolveOpacity(0, 0)), 3641 - TextUtils.indexOf((CharSequence) "", '0'), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame18).invoke(null, objArr1222));
            Object[] objArr135 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) 1632895212) << 32)), Long.valueOf(1632895204)};
            byte[] bArr223 = $$d;
            Object[] objArr136 = new Object[1];
            c((short) 583, bArr223[16], bArr223[67], objArr136);
            Class<?> cls120 = Class.forName((String) objArr136[0]);
            Object[] objArr137 = new Object[1];
            c(bArr223[16], bArr223[14], (byte) (-bArr223[442]), objArr137);
            cls120.getMethod((String) objArr137[0], Long.TYPE, Long.TYPE).invoke(null, objArr135);
            Object[] objArr138 = {list5, new int[1], list6, new int[]{i194}, new int[]{i195}};
            int i1913 = ((int[]) objArr8[1])[0];
            int i1914 = ((int[]) objArr8[3])[0];
            int i1915 = ((int[]) objArr8[4])[0];
            List list9 = (List) objArr8[0];
            List list10 = (List) objArr8[2];
            int i1916 = ~(((int) SystemClock.uptimeMillis()) | 62928901);
            int i1917 = i1913 + (((58722305 | i1916) * (-196)) - 1594374467) + ((i1916 | 4206596) * 196);
            int i1918 = (i1917 << 13) ^ i1917;
            int i1919 = i1918 ^ (i1918 >>> 17);
            ((int[]) objArr138[1])[0] = i1919 ^ (i1919 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1717965552);
        if (objAccessartificialFrame37 == null) {
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(19 - ImageFormat.getBitsPerPixel(i5), (char) (39516 - View.MeasureSpec.getSize(i5)), 982 - (Process.myPid() >> 22), 117222168, false, null, new Class[0]);
        }
        Object[] objArr139 = {null, ((Constructor) objAccessartificialFrame37).newInstance(null), -1827595177, 0};
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-501205803);
        if (objAccessartificialFrame38 == null) {
            int threadPriority = 36 - ((Process.getThreadPriority(0) + 20) >> 6);
            char cIndexOf6 = (char) TextUtils.indexOf("", "", 0, 0);
            int keyRepeatTimeout2 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            byte[] bArr30 = $$a;
            byte b50 = bArr30[79];
            byte b51 = bArr30[67];
            Object[] objArr140 = new Object[1];
            a(b50, b51, (byte) (b51 | Ascii.SI), objArr140);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(threadPriority, cIndexOf6, keyRepeatTimeout2, 2101703389, false, (String) objArr140[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 832), 576 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 54, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), ExpandableListView.getPackedPositionType(0L) + 630), Integer.TYPE, Integer.TYPE});
        }
        objArr5 = (Object[]) ((Method) objAccessartificialFrame38).invoke(null, objArr139);
        Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-1339222025);
        if (objAccessartificialFrame39 == null) {
            int iIndexOf11 = 36 - TextUtils.indexOf("", "", 0, 0);
            char pressedStateDuration6 = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
            int keyRepeatTimeout3 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 540;
            byte b52 = $$a[5];
            byte b53 = b52;
            Object[] objArr141 = new Object[1];
            a(b53, (byte) (b53 | 100), (byte) (b52 - 1), objArr141);
            objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(iIndexOf11, pressedStateDuration6, keyRepeatTimeout3, 793268735, false, (String) objArr141[0], null);
        }
        ((Field) objAccessartificialFrame39).set(null, objArr5);
    }

    static {
        byte[] bArr = new byte[651];
        System.arraycopy("\u000fÿ±\u0099\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0004A\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\u0010\u0007÷ÍI\u0001ýÉ\u0019:î\r\u0001þã7õ\u0004\u0003\u0011æ\"ó\u0006\fþ\u0011\u0011ú\u0012\u0001þÿÎI\u0006ÿ\u0004\u0003\u0007\u0006¾LÂþCü\u0003\tüÑ#\u001c\u0003\tüå4\u0001\f\u0000ö\u0011Õ0\u0002\u0007õ\u0017´3&ñ\u0015ô\u0013û\u000b\bù\n\u0003\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍ9\u0010\u0002\u0004\u0006\u0003Ä9\u0010\u0001\u0004ý\u0002\u0015¾#\u0018\u0013á\u0018\u000eþ\u0011Û)\nõ\u0011\u0000÷\u000få\u0018\u0013¸!%\u0015\u0005\u0002ó\u0006\u0015ç\u0012\u0000\u000eä\u001e\u0018Ð-\n\u0002\u000b\nÃ?\t\fó\u0011\u0006ñ\u0016öÍD\u0005\tù\u0001\u0003\u0004Í$%\tù\u0001\u0003\u0004à3ýè&ù\u0015ûýÃ\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ú0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001ÇCø\u0006Ï#\u0018\u0006ì\u001e\u0018\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002ÅIò\u000fý\u0012÷\r\u0007õ\u0006ÍCø\u0015ýþ\u0013ù\tý\u0000\r\u0007\nóÎ(ÖA\u0017\u0004\u0002\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç?\t\nõ\u0011\u0000÷\u000fÆ&&÷\u0005\u0007\u0013Ù\u0018\u0013¸\"7ø\u0007ü\u0005\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 651);
        $$d = bArr;
        $$e = 247;
        $$a = new byte[]{6, Ascii.FS, 8, -86, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2};
        $$b = 158;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onTransact = -24794120;
        mayLaunchUrl = -81862485;
        getInterfaceDescriptor = -384227991;
        ICustomTabsCallbackStubProxy = new byte[]{125, -74, -94, -77, -43, -128, -74, -83, -67, -92, -48, -47, 123, -78, -3, 116, -69, -92, -71, -56, -96, -55, 100, -124, -112, -121, -108, -87, -104, -95, -114, -99, -126, -111, -83, -121, -107, 123, -99, 116, -124, -125, -65, -72, 94, -116, -112, -120, -57, 80, 114, -88, -114, 123, -18, -46, Ascii.ESC, -76, -46, -3, -10, -72, -30, -28, -46, -31, -26, -18, -44, 113, -123, -116, 117, -98, -108, 109, -101, -99, 117, -109, -117, -105, -90, -107, 66, -128, -111, -75, 94, -115, -114, -125, -110, -118, -109, 121, Ascii.US, Ascii.DLE, 1, 35, Ascii.CAN, 4, Ascii.EM, Ascii.SUB, Ascii.RS, 79, -23, Ascii.DLE, Ascii.NAK, 3, Ascii.RS, Ascii.EM, 44, -85, 75, 121, -106, 72, 126, 100, -81, 75, -105, 120, 103, 120, 76, 122, 103, -84, 53, -85, 102, 127, 75, 127, -81, 48, -107, 79, -108, 78, -85, 122, 75, 122, 121, -107, 78, -82, 101, 72, -112, 73, -108, 123, 126, 122, 123, 72, 123, 123, -108, 120, 124, 75, -106, 102, 76, -106, 73, 121, -88, 121, 103, 124, 55, -85, -6, -4, 40, -28, -26, -62, -6, Ascii.NAK, -7, -56, -2, -27, -4, 43, -27, -4, -26, -14, -28, -8, -28, -2, -32, -3, -55, -3, Ascii.NAK, -2, -7, -6, -5, -2, -55, Ascii.DC4, -56, 47, -27, -1, -26, -63, Ascii.NAK, -54, -4, -27, 45, -26, -2, -25, -52, 40, -28, -51, Ascii.DC4, -27, -15, -28, -3, -73, -8, -7, -7, 43, -1};
    }
}
