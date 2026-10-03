package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.common.base.Ascii;
import io.sentry.protocol.SentryThread;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class JobInfoSchedulerService extends JobService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char CoroutineDebuggingKt;
    private static int accessartificialFrame;
    private static int artificialFrame;
    private static long coroutineBoundary;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {125, 126, -45, -128};
    private static final int $$f = 243;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r6, byte r7, short r8) {
        /*
            byte[] r0 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.$$c
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = r7 + 1
            int r8 = r8 + 98
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r7
            r4 = r2
            goto L24
        L12:
            r3 = r2
        L13:
            int r6 = r6 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L22:
            r3 = r0[r6]
        L24:
            int r8 = r8 + r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.$$g(int, byte, short):java.lang.String");
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
    private static void a(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.$$a
            int r6 = r6 + 8
            int r5 = r5 + 4
            int r7 = 112 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r7
            r3 = r2
            r7 = r6
            goto L25
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L21:
            int r5 = r5 + 1
            r4 = r0[r5]
        L25:
            int r7 = r7 + r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 111 - r6
            int r7 = r7 + 4
            byte[] r0 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.$$d
            int r1 = r8 + 3
            byte[] r1 = new byte[r1]
            int r8 = r8 + 2
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r6 = r8
            r4 = r2
            goto L29
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L29:
            int r7 = -r7
            int r3 = r3 + 1
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.c(short, int, short, java.lang.Object[]):void");
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt(SentryThread.JsonKeys.PRIORITY);
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder priority = TransportContext.builder().setBackendName(string).setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            priority.setExtras(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(priority.build(), i2, new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStartJob$0(jobParameters);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    private static void b(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        int i4 = 0;
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i5 = $10 + 47;
            $11 = i5 % 128;
            int i6 = i5 % i2;
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int maximumDrawingCacheSize = 33 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char c2 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int i7 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1483;
                    byte b = (byte) (-1);
                    byte b2 = (byte) (b + 1);
                    String str$$g = $$g(b, b2, (byte) (b2 + 1));
                    Class[] clsArr = new Class[1];
                    clsArr[i4] = Object.class;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c2, i7, 1614432829, false, str$$g, clsArr);
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                try {
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        int i8 = 33 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        char cResolveSize = (char) (49168 - View.resolveSize(i4, i4));
                        int i9 = 900 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        String str$$g2 = $$g(b3, b4, (byte) (b4 + 3));
                        Class[] clsArr2 = new Class[1];
                        clsArr2[i4] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i8, cResolveSize, i9, 214239564, false, str$$g2, clsArr2);
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    int i10 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                    try {
                        Object[] objArr4 = new Object[3];
                        objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                        objArr4[1] = Integer.valueOf(i10);
                        objArr4[i4] = iCustomTabsCallbackDefault;
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) (-1);
                            byte b6 = (byte) (b5 + 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - View.combineMeasuredStates(i4, i4), (char) (TextUtils.lastIndexOf("", '0', i4) + 1), 2442 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -1003383455, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        try {
                            Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) (-1);
                                byte b8 = (byte) (b7 + 1);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 29754), 1748 - TextUtils.getOffsetAfter("", 0), 1479752515, false, $$g(b7, b8, (byte) (b8 + 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                            cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                            cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                            iCustomTabsCallbackDefault.a++;
                            i2 = 2;
                            i4 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
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
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        String str = new String(cArr6);
        int i11 = $10 + 81;
        $11 = i11 % 128;
        if (i11 % 2 != 0) {
            objArr[0] = str;
        } else {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0504  */
    /* JADX WARN: Code duplicated, block: B:32:0x057a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0586  */
    /* JADX WARN: Code duplicated, block: B:37:0x0593  */
    /* JADX WARN: Code duplicated, block: B:39:0x059e  */
    /* JADX WARN: Code duplicated, block: B:40:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:47:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x06ef  */
    /* JADX WARN: Code duplicated, block: B:52:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:54:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:57:0x089d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0972 A[Catch: all -> 0x0c79, TryCatch #0 {all -> 0x0c79, blocks: (B:58:0x095e, B:60:0x0972, B:61:0x099d, B:16:0x02dc, B:18:0x02fd, B:19:0x034f), top: B:98:0x02dc }] */
    /* JADX WARN: Code duplicated, block: B:64:0x09b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x0ad2  */
    /* JADX WARN: Code duplicated, block: B:73:0x0b1d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0b7e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0b89  */
    /* JADX WARN: Code duplicated, block: B:79:0x0b8d A[LOOP:0: B:77:0x0b8a->B:79:0x0b8d, LOOP_END] */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        int i;
        Class<?> cls;
        Object[] objArr;
        Object[] objArr2;
        int i2;
        int i3;
        ArrayList arrayList;
        int i4;
        String[] strArr;
        int i5;
        int i6;
        Object objAccessartificialFrame;
        long j;
        Object objAccessartificialFrame2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i7;
        int i8;
        ArrayList arrayList2;
        String[] strArr2;
        int i9;
        long j2;
        Class<?> cls2;
        Object[] objArr3;
        Object objAccessartificialFrame5;
        int i10 = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame6 == null) {
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 25;
            char size = (char) (View.MeasureSpec.getSize(0) + 30068);
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
            byte[] bArr = $$a;
            byte b = bArr[5];
            byte b2 = bArr[21];
            Object[] objArr4 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr4);
            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetBefore, size, iIndexOf, 721586079, false, (String) objArr4[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame6).getLong(null);
        try {
            try {
                if (j3 != -1) {
                    int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                    artificialFrame = i11 % 128;
                    int i12 = i11 % 2;
                    long j4 = j3 + 1949;
                    Object[] objArr5 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 114), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1593414382, new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) + 8894), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr6);
                    if (j4 >= ((Long) cls3.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame7 == null) {
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 25;
                            char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 30068);
                            int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                            byte[] bArr2 = $$a;
                            byte b3 = (byte) (-bArr2[11]);
                            byte b4 = bArr2[21];
                            Object[] objArr7 = new Object[1];
                            a(b3, b4, (byte) (b4 - 1), objArr7);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(threadPriority, cResolveOpacity, scrollDefaultDelay, 891606461, false, (String) objArr7[0], null);
                        }
                        Object[] objArr8 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i13 = ((int[]) objArr8[0])[0];
                        int i14 = ((int[]) objArr8[1])[0];
                        String[] strArr3 = (String[]) objArr8[2];
                        int i15 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1841011162);
                        int i16 = 453638901 + ((1056797631 | i15) * SyslogConstants.LOG_LOCAL7) + (((~(i15 | 1051538055)) | 208691518) * SyslogConstants.LOG_LOCAL7) + 224750778;
                        int i17 = (i16 << 13) ^ i16;
                        int i18 = i17 ^ (i17 >>> 17);
                        ((int[]) objArr2[3])[0] = i18 ^ (i18 << 5);
                    } else {
                        i = 4;
                    }
                    i2 = ((int[]) objArr2[1])[0];
                    i3 = ((int[]) objArr2[0])[0];
                    if (i3 == i2) {
                        int i19 = artificialFrame + 101;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i19 % 128;
                        int i20 = i19 % 2;
                        Object[] objArr9 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i21 = ((int[]) objArr2[3])[0];
                        int i22 = ((int[]) objArr2[0])[0];
                        int i23 = ((int[]) objArr2[1])[0];
                        String[] strArr4 = (String[]) objArr2[2];
                        int startUptimeMillis = (int) Process.getStartUptimeMillis();
                        int i24 = i21 + (-1300192843) + ((888152914 | startUptimeMillis) * 376) + (((~((~startUptimeMillis) | 594281744)) | 344990274) * (-376)) + (((~(startUptimeMillis | (-594281745))) | (-396109379)) * 376);
                        int i25 = (i24 << 13) ^ i24;
                        int i26 = i25 ^ (i25 >>> 17);
                        ((int[]) objArr9[3])[0] = i26 ^ (i26 << 5);
                    } else {
                        arrayList = new ArrayList();
                        i4 = 2;
                        strArr = (String[]) objArr2[2];
                        if (strArr != null) {
                            int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                            artificialFrame = i27 % 128;
                            int i28 = i27 % 2;
                            i5 = 0;
                            while (i5 < strArr.length) {
                                i6 = artificialFrame + 43;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                                if (i6 % i4 != 0) {
                                    arrayList.add(strArr[i5]);
                                    i5 += 58;
                                } else {
                                    arrayList.add(strArr[i5]);
                                    i5++;
                                }
                                i4 = 2;
                            }
                        }
                        try {
                            Object[] objArr10 = {Long.valueOf(((long) (i2 ^ i3)) ^ (((long) 1531539885) << 32)), Long.valueOf(1531539884)};
                            byte b5 = (byte) $$e;
                            byte[] bArr3 = $$d;
                            Object[] objArr11 = new Object[1];
                            c(b5, bArr3[14], bArr3[525], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            c((byte) (-bArr3[361]), bArr3[238], bArr3[14], objArr12);
                            cls4.getMethod((String) objArr12[0], Long.TYPE, Long.TYPE).invoke(null, objArr10);
                            Object[] objArr13 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                            int i29 = ((int[]) objArr2[3])[0];
                            int i30 = ((int[]) objArr2[0])[0];
                            int i31 = ((int[]) objArr2[1])[0];
                            String[] strArr5 = (String[]) objArr2[2];
                            int i32 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                            int i33 = i29 + (-1217195063) + ((~((-70263379) | i32)) * 52) + (((~(856055209 | i32)) | (~(657882843 | i32)) | (-926318588)) * (-52)) + (((~(i32 | (-856055210))) | 587619465) * 52);
                            int i34 = (i33 << 13) ^ i33;
                            int i35 = i34 ^ (i34 >>> 17);
                            ((int[]) objArr13[3])[0] = i35 ^ (i35 << 5);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame == null) {
                        int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 26;
                        char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 1041;
                        byte[] bArr4 = $$a;
                        byte b6 = bArr4[5];
                        byte b7 = bArr4[21];
                        Object[] objArr14 = new Object[1];
                        a(b6, b7, (byte) (b7 - 1), objArr14);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore2, maximumFlingVelocity, windowTouchSlop, 2061780482, false, (String) objArr14[0], null);
                    }
                    j = ((Field) objAccessartificialFrame).getLong(null);
                    if (j != -1) {
                        int i36 = artificialFrame + 87;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
                        int i37 = i36 % 2;
                        j2 = j + 4611686018427387918L;
                        Object[] objArr15 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr15);
                        cls2 = Class.forName((String) objArr15[0]);
                        objArr3 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1593414413, new char[]{4571, 63891, 11358, 8995}, (char) (9003 - TextUtils.lastIndexOf("", '0', 0, 0)), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr3);
                        if (j2 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame5 == null) {
                                int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
                                char threadPriority2 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                                int gidForName = 1040 - Process.getGidForName("");
                                byte[] bArr5 = $$a;
                                byte b8 = (byte) (-bArr5[11]);
                                byte b9 = bArr5[21];
                                Object[] objArr16 = new Object[1];
                                a(b8, b9, (byte) (b9 - 1), objArr16);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, threadPriority2, gidForName, 1145017376, false, (String) objArr16[0], null);
                            }
                            Object[] objArr17 = (Object[]) ((Field) objAccessartificialFrame5).get(null);
                            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                            int i38 = ((int[]) objArr17[3])[0];
                            int i39 = ((int[]) objArr17[2])[0];
                            String[] strArr6 = (String[]) objArr17[0];
                            int iUptimeMillis = (int) SystemClock.uptimeMillis();
                            int i40 = ((((-392003098) + ((~((~iUptimeMillis) | (-461390865))) * (-116))) + ((540818287 | iUptimeMillis) * 116)) + (((~(iUptimeMillis | 462714480)) | 539494671) * 116)) - 1442115999;
                            int i41 = (i40 << 13) ^ i40;
                            int i42 = i41 ^ (i41 >>> 17);
                            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i42 ^ (i42 << 5);
                        } else {
                            Object[] objArr18 = new Object[1];
                            b(new char[]{57419, 24532, 56812, 12053}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{21815, 37575, 56939, 41077}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 30170), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr18);
                            Class<?> cls5 = Class.forName((String) objArr18[0]);
                            Object[] objArr19 = new Object[1];
                            b(new char[]{57419, 24532, 56812, 12053}, ViewConfiguration.getTouchSlop() >> 8, new char[]{21327, 10495, 37113, 20237}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 3373), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr19);
                            int iIntValue = ((Integer) cls5.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue();
                            Object[] objArr20 = {753181069};
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                            if (objAccessartificialFrame2 == null) {
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 22251), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                            }
                            objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr20), -1442115999, false);
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame3 == null) {
                                int iGreen = 26 - Color.green(0);
                                char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                                int iMyPid = 1041 - (Process.myPid() >> 22);
                                byte[] bArr6 = $$a;
                                byte b10 = (byte) (-bArr6[11]);
                                byte b11 = bArr6[21];
                                Object[] objArr21 = new Object[1];
                                a(b10, b11, (byte) (b11 - 1), objArr21);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iGreen, cLastIndexOf, iMyPid, 1145017376, false, (String) objArr21[0], null);
                            }
                            ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                            try {
                                Object[] objArr22 = new Object[1];
                                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 101), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr22);
                                Class<?> cls6 = Class.forName((String) objArr22[0]);
                                Object[] objArr23 = new Object[1];
                                b(new char[]{57419, 24532, 56812, 12053}, 1593414418 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 8983), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr23);
                                Long lValueOf = Long.valueOf(((Long) cls6.getDeclaredMethod((String) objArr23[0], new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                                if (objAccessartificialFrame4 == null) {
                                    int gidForName2 = 25 - Process.getGidForName("");
                                    char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
                                    int iMyPid2 = 1041 - (Process.myPid() >> 22);
                                    byte[] bArr7 = $$a;
                                    byte b12 = bArr7[5];
                                    byte b13 = bArr7[21];
                                    Object[] objArr24 = new Object[1];
                                    a(b12, b13, (byte) (b13 - 1), objArr24);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName2, cIndexOf, iMyPid2, 2061780482, false, (String) objArr24[0], null);
                                }
                                ((Field) objAccessartificialFrame4).set(null, lValueOf);
                            } catch (Exception unused) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object[] objArr110 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{21815, 37575, 56939, 41077}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 30170), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr110);
                        Class<?> cls7 = Class.forName((String) objArr110[0]);
                        Object[] objArr111 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ViewConfiguration.getTouchSlop() >> 8, new char[]{21327, 10495, 37113, 20237}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 3373), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr111);
                        int iIntValue2 = ((Integer) cls7.getMethod((String) objArr111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr25 = {753181069};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 22251), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr25), -1442115999, false);
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame3 == null) {
                            int iGreen2 = 26 - Color.green(0);
                            char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                            int iMyPid3 = 1041 - (Process.myPid() >> 22);
                            byte[] bArr8 = $$a;
                            byte b14 = (byte) (-bArr8[11]);
                            byte b15 = bArr8[21];
                            Object[] objArr26 = new Object[1];
                            a(b14, b15, (byte) (b15 - 1), objArr26);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iGreen2, cLastIndexOf2, iMyPid3, 1145017376, false, (String) objArr26[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr27 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 101), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr27);
                        Class<?> cls8 = Class.forName((String) objArr27[0]);
                        Object[] objArr28 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, 1593414418 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 8983), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr28);
                        Long lValueOf2 = Long.valueOf(((Long) cls8.getDeclaredMethod((String) objArr28[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame4 == null) {
                            int gidForName3 = 25 - Process.getGidForName("");
                            char cIndexOf2 = (char) TextUtils.indexOf("", "", 0, 0);
                            int iMyPid4 = 1041 - (Process.myPid() >> 22);
                            byte[] bArr9 = $$a;
                            byte b16 = bArr9[5];
                            byte b17 = bArr9[21];
                            Object[] objArr29 = new Object[1];
                            a(b16, b17, (byte) (b17 - 1), objArr29);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName3, cIndexOf2, iMyPid4, 2061780482, false, (String) objArr29[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, lValueOf2);
                    }
                    i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i8 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i8 == i7) {
                        Object[] objArr30 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i43 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i44 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i45 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iIdentityHashCode = System.identityHashCode(this);
                        int i46 = (-407812404) + (((~((~iIdentityHashCode) | 706985109)) | (-787201430)) * (-245));
                        int i47 = ~(iIdentityHashCode | 706985109);
                        int i48 = i43 + i46 + (i47 * (-245)) + ((i47 | 785088916) * 245);
                        int i49 = (i48 << 13) ^ i48;
                        int i50 = i49 ^ (i49 >>> 17);
                        ((int[]) objArr30[1])[0] = i50 ^ (i50 << 5);
                        return;
                    }
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr2 != null) {
                        for (String str : strArr2) {
                            arrayList2.add(str);
                        }
                    }
                    Object[] objArr31 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) (-990229237)) << 32)), Long.valueOf(-990229239)};
                    byte[] bArr10 = $$d;
                    Object[] objArr32 = new Object[1];
                    c(bArr10[14], bArr10[130], bArr10[185], objArr32);
                    Class<?> cls9 = Class.forName((String) objArr32[0]);
                    Object[] objArr33 = new Object[1];
                    c((byte) (-bArr10[361]), bArr10[238], bArr10[14], objArr33);
                    cls9.getMethod((String) objArr33[0], Long.TYPE, Long.TYPE).invoke(null, objArr31);
                    Object[] objArr34 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int i54 = ~System.identityHashCode(this);
                    int i55 = i51 + (-323147941) + ((~((-43188947) | i54)) * (-783)) + (((~(i54 | (-519278292))) | (-597382099)) * 783);
                    int i56 = (i55 << 13) ^ i55;
                    int i57 = i56 ^ (i56 >>> 17);
                    ((int[]) objArr34[1])[0] = i57 ^ (i57 << 5);
                    int i58 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                    artificialFrame = i58 % 128;
                    int i59 = i58 % 2;
                    return;
                }
                i = 4;
                Object[] objArr35 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr35);
                Class<?> cls10 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1593414396, new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 8969), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr36);
                Long lValueOf3 = Long.valueOf(((Long) cls10.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame8 == null) {
                    int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                    char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 30067);
                    int iIndexOf2 = 816 - TextUtils.indexOf("", "");
                    byte[] bArr11 = $$a;
                    byte b18 = bArr11[5];
                    byte b19 = bArr11[21];
                    Object[] objArr37 = new Object[1];
                    a(b18, b19, (byte) (b19 - 1), objArr37);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, c, iIndexOf2, 721586079, false, (String) objArr37[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf3);
                i2 = ((int[]) objArr2[1])[0];
                i3 = ((int[]) objArr2[0])[0];
                if (i3 == i2) {
                    int i110 = artificialFrame + 101;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i110 % 128;
                    int i210 = i110 % 2;
                    Object[] objArr38 = {new int[]{i22}, new int[]{i23}, strArr4, new int[1]};
                    int i211 = ((int[]) objArr2[3])[0];
                    int i212 = ((int[]) objArr2[0])[0];
                    int i213 = ((int[]) objArr2[1])[0];
                    String[] strArr9 = (String[]) objArr2[2];
                    int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                    int i214 = i211 + (-1300192843) + ((888152914 | startUptimeMillis2) * 376) + (((~((~startUptimeMillis2) | 594281744)) | 344990274) * (-376)) + (((~(startUptimeMillis2 | (-594281745))) | (-396109379)) * 376);
                    int i215 = (i214 << 13) ^ i214;
                    int i216 = i215 ^ (i215 >>> 17);
                    ((int[]) objArr38[3])[0] = i216 ^ (i216 << 5);
                } else {
                    arrayList = new ArrayList();
                    i4 = 2;
                    strArr = (String[]) objArr2[2];
                    if (strArr != null) {
                        int i217 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                        artificialFrame = i217 % 128;
                        int i218 = i217 % 2;
                        i5 = 0;
                        while (i5 < strArr.length) {
                            i6 = artificialFrame + 43;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                            if (i6 % i4 != 0) {
                                arrayList.add(strArr[i5]);
                                i5 += 58;
                            } else {
                                arrayList.add(strArr[i5]);
                                i5++;
                            }
                            i4 = 2;
                        }
                    }
                    Object[] objArr112 = {Long.valueOf(((long) (i2 ^ i3)) ^ (((long) 1531539885) << 32)), Long.valueOf(1531539884)};
                    byte b20 = (byte) $$e;
                    byte[] bArr12 = $$d;
                    Object[] objArr113 = new Object[1];
                    c(b20, bArr12[14], bArr12[525], objArr113);
                    Class<?> cls11 = Class.forName((String) objArr113[0]);
                    Object[] objArr114 = new Object[1];
                    c((byte) (-bArr12[361]), bArr12[238], bArr12[14], objArr114);
                    cls11.getMethod((String) objArr114[0], Long.TYPE, Long.TYPE).invoke(null, objArr112);
                    Object[] objArr115 = {new int[]{i30}, new int[]{i31}, strArr5, new int[1]};
                    int i219 = ((int[]) objArr2[3])[0];
                    int i310 = ((int[]) objArr2[0])[0];
                    int i311 = ((int[]) objArr2[1])[0];
                    String[] strArr10 = (String[]) objArr2[2];
                    int i312 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
                    int i313 = i219 + (-1217195063) + ((~((-70263379) | i312)) * 52) + (((~(856055209 | i312)) | (~(657882843 | i312)) | (-926318588)) * (-52)) + (((~(i312 | (-856055210))) | 587619465) * 52);
                    int i314 = (i313 << 13) ^ i313;
                    int i315 = i314 ^ (i314 >>> 17);
                    ((int[]) objArr115[3])[0] = i315 ^ (i315 << 5);
                }
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame == null) {
                    int offsetBefore3 = TextUtils.getOffsetBefore("", 0) + 26;
                    char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 1041;
                    byte[] bArr13 = $$a;
                    byte b21 = bArr13[5];
                    byte b22 = bArr13[21];
                    Object[] objArr116 = new Object[1];
                    a(b21, b22, (byte) (b22 - 1), objArr116);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore3, maximumFlingVelocity2, windowTouchSlop2, 2061780482, false, (String) objArr116[0], null);
                }
                j = ((Field) objAccessartificialFrame).getLong(null);
                if (j != -1) {
                    int i316 = artificialFrame + 87;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i316 % 128;
                    int i317 = i316 % 2;
                    j2 = j + 4611686018427387918L;
                    Object[] objArr117 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr117);
                    cls2 = Class.forName((String) objArr117[0]);
                    objArr3 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1593414413, new char[]{4571, 63891, 11358, 8995}, (char) (9003 - TextUtils.lastIndexOf("", '0', 0, 0)), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr3);
                    if (j2 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame5 == null) {
                            int iNormalizeMetaState2 = 26 - KeyEvent.normalizeMetaState(0);
                            char threadPriority3 = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                            int gidForName4 = 1040 - Process.getGidForName("");
                            byte[] bArr14 = $$a;
                            byte b23 = (byte) (-bArr14[11]);
                            byte b24 = bArr14[21];
                            Object[] objArr118 = new Object[1];
                            a(b23, b24, (byte) (b24 - 1), objArr118);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, threadPriority3, gidForName4, 1145017376, false, (String) objArr118[0], null);
                        }
                        Object[] objArr119 = (Object[]) ((Field) objAccessartificialFrame5).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr6, new int[1], new int[]{i39}, new int[]{i38}};
                        int i318 = ((int[]) objArr119[3])[0];
                        int i319 = ((int[]) objArr119[2])[0];
                        String[] strArr11 = (String[]) objArr119[0];
                        int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                        int i410 = ((((-392003098) + ((~((~iUptimeMillis2) | (-461390865))) * (-116))) + ((540818287 | iUptimeMillis2) * 116)) + (((~(iUptimeMillis2 | 462714480)) | 539494671) * 116)) - 1442115999;
                        int i411 = (i410 << 13) ^ i410;
                        int i412 = i411 ^ (i411 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i412 ^ (i412 << 5);
                    } else {
                        Object[] objArr1110 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{21815, 37575, 56939, 41077}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 30170), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr1110);
                        Class<?> cls12 = Class.forName((String) objArr1110[0]);
                        Object[] objArr1111 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ViewConfiguration.getTouchSlop() >> 8, new char[]{21327, 10495, 37113, 20237}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 3373), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr1111);
                        int iIntValue3 = ((Integer) cls12.getMethod((String) objArr1111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr210 = {753181069};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 22251), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr210), -1442115999, false);
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame3 == null) {
                            int iGreen3 = 26 - Color.green(0);
                            char cLastIndexOf3 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                            int iMyPid5 = 1041 - (Process.myPid() >> 22);
                            byte[] bArr15 = $$a;
                            byte b110 = (byte) (-bArr15[11]);
                            byte b111 = bArr15[21];
                            Object[] objArr211 = new Object[1];
                            a(b110, b111, (byte) (b111 - 1), objArr211);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iGreen3, cLastIndexOf3, iMyPid5, 1145017376, false, (String) objArr211[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr212 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 101), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr212);
                        Class<?> cls13 = Class.forName((String) objArr212[0]);
                        Object[] objArr213 = new Object[1];
                        b(new char[]{57419, 24532, 56812, 12053}, 1593414418 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 8983), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr213);
                        Long lValueOf4 = Long.valueOf(((Long) cls13.getDeclaredMethod((String) objArr213[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame4 == null) {
                            int gidForName5 = 25 - Process.getGidForName("");
                            char cIndexOf3 = (char) TextUtils.indexOf("", "", 0, 0);
                            int iMyPid6 = 1041 - (Process.myPid() >> 22);
                            byte[] bArr16 = $$a;
                            byte b112 = bArr16[5];
                            byte b113 = bArr16[21];
                            Object[] objArr214 = new Object[1];
                            a(b112, b113, (byte) (b113 - 1), objArr214);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName5, cIndexOf3, iMyPid6, 2061780482, false, (String) objArr214[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, lValueOf4);
                    }
                } else {
                    Object[] objArr1112 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{21815, 37575, 56939, 41077}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 30170), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr1112);
                    Class<?> cls14 = Class.forName((String) objArr1112[0]);
                    Object[] objArr1113 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ViewConfiguration.getTouchSlop() >> 8, new char[]{21327, 10495, 37113, 20237}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 3373), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr1113);
                    int iIntValue4 = ((Integer) cls14.getMethod((String) objArr1113[0], Object.class).invoke(null, this)).intValue();
                    Object[] objArr215 = {753181069};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 22251), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame2).newInstance(objArr215), -1442115999, false);
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame3 == null) {
                        int iGreen4 = 26 - Color.green(0);
                        char cLastIndexOf4 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                        int iMyPid7 = 1041 - (Process.myPid() >> 22);
                        byte[] bArr17 = $$a;
                        byte b114 = (byte) (-bArr17[11]);
                        byte b115 = bArr17[21];
                        Object[] objArr216 = new Object[1];
                        a(b114, b115, (byte) (b115 - 1), objArr216);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iGreen4, cLastIndexOf4, iMyPid7, 1145017376, false, (String) objArr216[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArrAccessartificialFrame$78cbbd35);
                    Object[] objArr217 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 101), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr217);
                    Class<?> cls15 = Class.forName((String) objArr217[0]);
                    Object[] objArr218 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, 1593414418 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 8983), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr218);
                    Long lValueOf5 = Long.valueOf(((Long) cls15.getDeclaredMethod((String) objArr218[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame4 == null) {
                        int gidForName6 = 25 - Process.getGidForName("");
                        char cIndexOf4 = (char) TextUtils.indexOf("", "", 0, 0);
                        int iMyPid8 = 1041 - (Process.myPid() >> 22);
                        byte[] bArr18 = $$a;
                        byte b116 = bArr18[5];
                        byte b117 = bArr18[21];
                        Object[] objArr219 = new Object[1];
                        a(b116, b117, (byte) (b117 - 1), objArr219);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(gidForName6, cIndexOf4, iMyPid8, 2061780482, false, (String) objArr219[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf5);
                }
                i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i8 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i8 == i7) {
                    Object[] objArr39 = {strArr7, new int[1], new int[]{i45}, new int[]{i44}};
                    int i413 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i414 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i415 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i416 = (-407812404) + (((~((~iIdentityHashCode2) | 706985109)) | (-787201430)) * (-245));
                    int i417 = ~(iIdentityHashCode2 | 706985109);
                    int i418 = i413 + i416 + (i417 * (-245)) + ((i417 | 785088916) * 245);
                    int i419 = (i418 << 13) ^ i418;
                    int i510 = i419 ^ (i419 >>> 17);
                    ((int[]) objArr39[1])[0] = i510 ^ (i510 << 5);
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr2 != null) {
                    while (i9 < strArr2.length) {
                        arrayList2.add(str);
                    }
                }
                Object[] objArr310 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) (-990229237)) << 32)), Long.valueOf(-990229239)};
                byte[] bArr19 = $$d;
                Object[] objArr311 = new Object[1];
                c(bArr19[14], bArr19[130], bArr19[185], objArr311);
                Class<?> cls16 = Class.forName((String) objArr311[0]);
                Object[] objArr312 = new Object[1];
                c((byte) (-bArr19[361]), bArr19[238], bArr19[14], objArr312);
                cls16.getMethod((String) objArr312[0], Long.TYPE, Long.TYPE).invoke(null, objArr310);
                Object[] objArr313 = {strArr8, new int[1], new int[]{i53}, new int[]{i52}};
                int i511 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i512 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i513 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i514 = ~System.identityHashCode(this);
                int i515 = i511 + (-323147941) + ((~((-43188947) | i514)) * (-783)) + (((~(i514 | (-519278292))) | (-597382099)) * 783);
                int i516 = (i515 << 13) ^ i515;
                int i517 = i516 ^ (i516 >>> 17);
                ((int[]) objArr313[1])[0] = i517 ^ (i517 << 5);
                int i518 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                artificialFrame = i518 % 128;
                int i519 = i518 % 2;
                return;
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
            Object[] objArr40 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr[0], Object.class).invoke(null, this)).intValue()), 0, 224750778};
            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame9 == null) {
                int iRed = Color.red(0) + 25;
                char cLastIndexOf5 = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                int iMyTid = (Process.myTid() >> 22) + 816;
                byte[] bArr20 = $$a;
                Object[] objArr41 = new Object[1];
                a(bArr20[19], bArr20[94], (byte) (-bArr20[1]), objArr41);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iRed, cLastIndexOf5, iMyTid, -797394565, false, (String) objArr41[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame9).invoke(null, objArr40);
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame10 == null) {
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 25;
                char c2 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067);
                int trimmedLength = 816 - TextUtils.getTrimmedLength("");
                byte[] bArr21 = $$a;
                byte b25 = (byte) (-bArr21[11]);
                byte b26 = bArr21[21];
                Object[] objArr42 = new Object[1];
                a(b25, b26, (byte) (b26 - 1), objArr42);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, c2, trimmedLength, 891606461, false, (String) objArr42[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, objArr2);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
        char[] cArr = new char[i];
        // fill-array-data instruction
        cArr[0] = 57419;
        cArr[1] = 24532;
        cArr[2] = 56812;
        cArr[3] = 12053;
        char[] cArr2 = new char[i];
        // fill-array-data instruction
        cArr2[0] = 21815;
        cArr2[1] = 37575;
        cArr2[2] = 56939;
        cArr2[3] = 41077;
        Object[] objArr43 = new Object[1];
        b(cArr, ViewConfiguration.getScrollBarFadeDuration() >> 16, cArr2, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) + 30075), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr43);
        cls = Class.forName((String) objArr43[0]);
        objArr = new Object[1];
        b(new char[]{57419, 24532, 56812, 12053}, View.resolveSizeAndState(0, 0, 0), new char[]{21327, 10495, 37113, 20237}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 3468), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr);
    }

    /* JADX WARN: Code duplicated, block: B:139:0x1123  */
    /* JADX WARN: Code duplicated, block: B:171:0x1503  */
    /* JADX WARN: Code duplicated, block: B:173:0x150a  */
    /* JADX WARN: Code duplicated, block: B:175:0x1605  */
    /* JADX WARN: Code duplicated, block: B:180:0x1613  */
    /* JADX WARN: Code duplicated, block: B:186:0x1777  */
    /* JADX WARN: Code duplicated, block: B:188:0x1780  */
    /* JADX WARN: Code duplicated, block: B:193:0x17ee  */
    /* JADX WARN: Code duplicated, block: B:269:0x1f1f A[Catch: all -> 0x26e5, TryCatch #4 {all -> 0x26e5, blocks: (B:267:0x1f19, B:269:0x1f1f, B:270:0x1f4b, B:272:0x1f75, B:273:0x1fff, B:223:0x1b38, B:225:0x1b4d, B:226:0x1b79, B:65:0x0800, B:67:0x0822, B:68:0x0875, B:41:0x054f, B:43:0x055c, B:44:0x0590, B:46:0x059a, B:48:0x05a7, B:49:0x05da), top: B:367:0x054f }] */
    /* JADX WARN: Code duplicated, block: B:272:0x1f75 A[Catch: all -> 0x26e5, TryCatch #4 {all -> 0x26e5, blocks: (B:267:0x1f19, B:269:0x1f1f, B:270:0x1f4b, B:272:0x1f75, B:273:0x1fff, B:223:0x1b38, B:225:0x1b4d, B:226:0x1b79, B:65:0x0800, B:67:0x0822, B:68:0x0875, B:41:0x054f, B:43:0x055c, B:44:0x0590, B:46:0x059a, B:48:0x05a7, B:49:0x05da), top: B:367:0x054f }] */
    /* JADX WARN: Code duplicated, block: B:276:0x2012  */
    /* JADX WARN: Code duplicated, block: B:281:0x207e  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        Object[] objArr3;
        int i2;
        Object[] objArr4;
        Context baseContext;
        Object[] objArr5;
        int i3;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i5;
        int i6;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr6;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i7;
        int i8;
        Object[] objArr7;
        int i9;
        int i10 = 2 % 2;
        Object[] objArr8 = new Object[1];
        b(new char[]{57419, 24532, 56812, 12053}, (-1) - Process.getGidForName(""), new char[]{61970, 41924, 32893, 61378}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), new char[]{61289, 11528, 49337, 15987, 62446, 23220, 35547, 56535, 47857, 48038, 16586, 50492, 34588, 31579, 7936, 48273, 26350, 47275, 16053, 36748, 27280, 55748}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1593414413, new char[]{4571, 63891, 11358, 8995}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) + 8894), new char[]{63007, 44873, 25873, 21024, 23145, 10303, 55139, 23468, 51541, 19437, 30745, 30325, 18104, 17596, 42616}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(new char[]{57419, 24532, 56812, 12053}, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{21815, 37575, 56939, 41077}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) + 30057), new char[]{57592, 36527, 28335, 32635, 28760, 36658, 2254, 864, 46280, 57306, 9577, 59949, 32196, 40157, 19196, 13855}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{21327, 10495, 37113, 20237}, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3472), new char[]{58782, 23054, 18229, 6334, 10981, 54054, 11004, 64045, 32462, 20544, 27724, 53339, 4192, 50842, 6394, 10746}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame7 == null) {
            int i11 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 16;
            char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
            int iAlpha = Color.alpha(0) + 747;
            byte[] bArr = $$a;
            byte b = bArr[5];
            byte b2 = bArr[21];
            Object[] objArr12 = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr12);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i11, cKeyCodeFromString, iAlpha, -144068856, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j == -1 || j + 4611686018427387861L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr13 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{11331, 1014, 8231, 35855}, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 3871), new char[]{26219, 25086, 47670, 27767, 37951, 46909, 65419, 55753, 3414, 64384, 58506, 50241, 40982, 61054, 61668, 31938, 44122, 48519, 20870, 8770, 21192, 43166, 30155, 42027, 12370, 47822}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{48434, 38195, 46342, 50833}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 37266), new char[]{8673, 59799, 62806, 45504, 7198, 23521, 19234, 42800, 14938, 1937, 30686, 31651, 47147, 27241, 551, 10011, 61879, 37893}, objArr14);
                baseContext2 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -739421477};
                int i12 = $$e;
                byte b3 = (byte) i12;
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c(b3, (short) (b3 | 97), bArr2[310], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                byte b4 = bArr2[93];
                Object[] objArr17 = new Object[1];
                c((byte) (i12 | 32), (short) 182, b4, objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame8 == null) {
                    int scrollBarFadeDuration = 17 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char defaultSize = (char) View.getDefaultSize(0, 0);
                    int i13 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 747;
                    byte[] bArr3 = $$a;
                    byte b5 = (byte) (-bArr3[11]);
                    byte b6 = bArr3[21];
                    Object[] objArr19 = new Object[1];
                    a(b5, b6, (byte) (b6 - 1), objArr19);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, defaultSize, i13, -1031537386, false, (String) objArr19[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr18);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame9 == null) {
                        int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 17;
                        char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int mode = 747 - View.MeasureSpec.getMode(0);
                        byte[] bArr4 = $$a;
                        byte b7 = bArr4[5];
                        byte b8 = bArr4[21];
                        Object[] objArr20 = new Object[1];
                        a(b7, b8, (byte) (b8 - 1), objArr20);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, keyRepeatDelay, mode, -144068856, false, (String) objArr20[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, lValueOf);
                    objArr = objArr18;
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
            int i14 = artificialFrame + 99;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
            int i15 = i14 % 2;
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame10 == null) {
                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 17;
                char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 747;
                byte[] bArr5 = $$a;
                byte b9 = (byte) (-bArr5[11]);
                byte b10 = bArr5[21];
                Object[] objArr21 = new Object[1];
                a(b9, b10, (byte) (b10 - 1), objArr21);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, absoluteGravity, windowTouchSlop, -1031537386, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
            objArr = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArr22[3])[0];
            int i17 = ((int[]) objArr22[4])[0];
            List list = (List) objArr22[0];
            List list2 = (List) objArr22[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i18 = (-1230575397) + (((-742025483) | iIdentityHashCode) * 614);
            int i19 = ~iIdentityHashCode;
            int i20 = ((i18 + ((((~((-724430271) | i19)) | 50693300) | (~((-118981813) | i19))) * (-1228))) + (((~(i19 | (-68288513))) | (~((-673736971) | i19))) * 614)) - 739421477;
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr[1])[0] = i22 ^ (i22 << 5);
        }
        int i23 = ((int[]) objArr[4])[0];
        int i24 = ((int[]) objArr[3])[0];
        if (i24 == i23) {
            Object[] objArr23 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i25 = ((int[]) objArr[1])[0];
            int i26 = ((int[]) objArr[3])[0];
            int i27 = ((int[]) objArr[4])[0];
            List list3 = (List) objArr[0];
            List list4 = (List) objArr[2];
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i28 = ~(754950015 | startElapsedRealtime);
            int i29 = i25 + (-1085361003) + ((8456309 | i28) * (-476)) + (i28 * 952) + ((~((~startElapsedRealtime) | 754950015)) * 476);
            int i30 = i29 ^ (i29 << 13);
            int i31 = i30 ^ (i30 >>> 17);
            ((int[]) objArr23[1])[0] = i31 ^ (i31 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            try {
                Object[] objArr24 = {objArr};
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame11 == null) {
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 42, (char) (12468 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 3642 - (ViewConfiguration.getJumpTapTimeout() >> 16), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame11).invoke(null, objArr24));
                Object[] objArr25 = {objArr};
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame12 == null) {
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(41 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 12469), Color.blue(0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList.add(((Method) objAccessartificialFrame12).invoke(null, objArr25));
                try {
                    Object[] objArr26 = {Long.valueOf(((long) (i23 ^ i24)) ^ (((long) 488386089) << 32)), Long.valueOf(488386081)};
                    byte[] bArr6 = $$d;
                    Object[] objArr27 = new Object[1];
                    c((byte) $$e, (short) 201, bArr6[15], objArr27);
                    Class<?> cls3 = Class.forName((String) objArr27[0]);
                    Object[] objArr28 = new Object[1];
                    c((byte) (-bArr6[361]), bArr6[238], bArr6[14], objArr28);
                    cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                    Object[] objArr29 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i32 = ((int[]) objArr[1])[0];
                    int i33 = ((int[]) objArr[3])[0];
                    int i34 = ((int[]) objArr[4])[0];
                    List list5 = (List) objArr[0];
                    List list6 = (List) objArr[2];
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i35 = ~iIdentityHashCode2;
                    int i36 = i32 + (-1736283130) + ((~(424337778 | i35)) * 979) + ((iIdentityHashCode2 | 1029786236) * (-979)) + (((~(iIdentityHashCode2 | 424337778)) | (~(i35 | 1029786236))) * 979);
                    int i37 = (i36 << 13) ^ i36;
                    int i38 = i37 ^ (i37 >>> 17);
                    i = 0;
                    ((int[]) objArr29[1])[0] = i38 ^ (i38 << 5);
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
        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame13 == null) {
            int iIndexOf = 25 - TextUtils.indexOf("", "", i, i);
            char c = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int i39 = 816 - (TypedValue.complexToFraction(i, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            byte[] bArr7 = $$a;
            byte b11 = bArr7[5];
            byte b12 = bArr7[21];
            Object[] objArr30 = new Object[1];
            a(b11, b12, (byte) (b12 - 1), objArr30);
            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf, c, i39, 721586079, false, (String) objArr30[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame13).getLong(null);
        if (j2 == -1 || j2 + 1996 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr31 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1982088334};
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame14 == null) {
                int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char maximumFlingVelocity = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30068);
                int pressedStateDuration = 816 - (ViewConfiguration.getPressedStateDuration() >> 16);
                byte[] bArr8 = $$a;
                Object[] objArr32 = new Object[1];
                a(bArr8[19], bArr8[94], (byte) (-bArr8[1]), objArr32);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, maximumFlingVelocity, pressedStateDuration, -797394565, false, (String) objArr32[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame14).invoke(null, objArr31);
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame15 == null) {
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                int keyRepeatTimeout2 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr9 = $$a;
                byte b13 = (byte) (-bArr9[11]);
                byte b14 = bArr9[21];
                Object[] objArr33 = new Object[1];
                a(b13, b14, (byte) (b14 - 1), objArr33);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, touchSlop, keyRepeatTimeout2, 891606461, false, (String) objArr33[0], null);
            }
            ((Field) objAccessartificialFrame15).set(null, objArr2);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame16 == null) {
                    int scrollBarFadeDuration3 = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char minimumFlingVelocity = (char) (30068 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    int pressedStateDuration2 = 816 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    byte[] bArr10 = $$a;
                    byte b15 = bArr10[5];
                    byte b16 = bArr10[21];
                    Object[] objArr34 = new Object[1];
                    a(b15, b16, (byte) (b16 - 1), objArr34);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, minimumFlingVelocity, pressedStateDuration2, 721586079, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf2);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame17 == null) {
                int iAxisFromString = 24 - MotionEvent.axisFromString("");
                char gidForName = (char) (Process.getGidForName("") + 30069);
                int iResolveOpacity = 816 - Drawable.resolveOpacity(0, 0);
                byte[] bArr11 = $$a;
                byte b17 = (byte) (-bArr11[11]);
                byte b18 = bArr11[21];
                Object[] objArr35 = new Object[1];
                a(b17, b18, (byte) (b18 - 1), objArr35);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iAxisFromString, gidForName, iResolveOpacity, 891606461, false, (String) objArr35[0], null);
            }
            Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i40 = ((int[]) objArr36[0])[0];
            int i41 = ((int[]) objArr36[1])[0];
            String[] strArr = (String[]) objArr36[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i42 = ~iIdentityHashCode3;
            int i43 = (~((-553470424) | i42)) | 550502614;
            int i44 = ~(iIdentityHashCode3 | (-352330249));
            int i45 = ((1672577649 + ((i43 | i44) * (-502))) + ((i44 | (~(i42 | (-2967810)))) * TypedValues.PositionType.TYPE_DRAWPATH)) - 1982088334;
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr2[3])[0] = i47 ^ (i47 << 5);
        }
        int i48 = ((int[]) objArr2[1])[0];
        int i49 = ((int[]) objArr2[0])[0];
        if (i49 == i48) {
            int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i50 % 128;
            int i51 = i50 % 2;
            Object[] objArr37 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i52 = ((int[]) objArr2[3])[0];
            int i53 = ((int[]) objArr2[0])[0];
            int i54 = ((int[]) objArr2[1])[0];
            String[] strArr2 = (String[]) objArr2[2];
            int i55 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i56 = ~i55;
            int i57 = i52 + (-1276987190) + (((~((-272018294) | i56)) | 73845927) * (-865)) + ((~(i55 | 272018293)) * 865) + (((~(73845927 | i56)) | (~(i56 | 272018293))) * 865);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr37[3])[0] = i59 ^ (i59 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArr2[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList2.add(str5);
                }
            }
            long j3 = ((long) (i48 ^ i49)) ^ (((long) 1859635845) << 32);
            long j4 = 1859635844;
            int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
            artificialFrame = i60 % 128;
            int i61 = i60 % 2;
            Object[] objArr38 = {Long.valueOf(j3), Long.valueOf(j4)};
            Object[] objArr39 = new Object[1];
            c((byte) $$e, (short) 260, (byte) 36, objArr39);
            Class<?> cls4 = Class.forName((String) objArr39[0]);
            byte[] bArr12 = $$d;
            Object[] objArr40 = new Object[1];
            c((byte) (-bArr12[361]), bArr12[238], bArr12[14], objArr40);
            cls4.getMethod((String) objArr40[0], Long.TYPE, Long.TYPE).invoke(null, objArr38);
            Object[] objArr41 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i62 = ((int[]) objArr2[3])[0];
            int i63 = ((int[]) objArr2[0])[0];
            int i64 = ((int[]) objArr2[1])[0];
            String[] strArr4 = (String[]) objArr2[2];
            int i65 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1345184435;
            int i66 = ~i65;
            int i67 = i62 + (-26523855) + ((803025887 | i65) * (-676)) + (((~(794628447 | i66)) | (-803025888)) * 676) + (((~(i65 | (-8397441))) | (~(i66 | 596456081)) | 206569806) * 676);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr41[3])[0] = i69 ^ (i69 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame18 == null) {
            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
            char cKeyCodeFromString2 = (char) (KeyEvent.keyCodeFromString("") + 49362);
            int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684;
            byte[] bArr13 = $$a;
            Object[] objArr42 = new Object[1];
            a((byte) (bArr13[20] - 1), bArr13[4], bArr13[112], objArr42);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, cKeyCodeFromString2, keyRepeatDelay2, -1583976536, false, (String) objArr42[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j5 == -1 || j5 + 2026 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr43 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 743171526};
            byte[] bArr14 = $$d;
            Object[] objArr44 = new Object[1];
            c(bArr14[213], (short) 298, (byte) (-bArr14[90]), objArr44);
            Class<?> cls5 = Class.forName((String) objArr44[0]);
            Object[] objArr45 = new Object[1];
            c((byte) $$e, (short) 323, bArr14[40], objArr45);
            objArr3 = (Object[]) cls5.getMethod((String) objArr45[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr43);
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame19 == null) {
                int i70 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char cMyPid = (char) (49362 - (Process.myPid() >> 22));
                int deadChar = KeyEvent.getDeadChar(0, 0) + 684;
                byte b19 = (byte) ($$b - 3);
                byte[] bArr15 = $$a;
                Object[] objArr46 = new Object[1];
                a(b19, bArr15[21], (byte) (-bArr15[11]), objArr46);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(i70, cMyPid, deadChar, -1456483158, false, (String) objArr46[0], null);
            }
            ((Field) objAccessartificialFrame19).set(null, objArr3);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame20 == null) {
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                    char absoluteGravity2 = (char) (Gravity.getAbsoluteGravity(0, 0) + 49362);
                    int i71 = 685 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr16 = $$a;
                    Object[] objArr47 = new Object[1];
                    a((byte) (bArr16[20] - 1), bArr16[4], bArr16[112], objArr47);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, absoluteGravity2, i71, -1583976536, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame20).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame21 == null) {
                int i72 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                char packedPositionChild = (char) (49361 - ExpandableListView.getPackedPositionChild(0L));
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 685;
                byte b20 = (byte) ($$b - 3);
                byte[] bArr17 = $$a;
                Object[] objArr48 = new Object[1];
                a(b20, bArr17[21], (byte) (-bArr17[11]), objArr48);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i72, packedPositionChild, iIndexOf2, -1456483158, false, (String) objArr48[0], null);
            }
            Object[] objArr49 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr49[0])[0]}, new int[]{((int[]) objArr49[1])[0]}, new int[1], (String) objArr49[3]};
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i73 = ~streamMaxVolume;
            int i74 = 1578642166 + (((~((-638229459) | i73)) | 67764544 | (~((-340394317) | i73)) | (~(910859230 | streamMaxVolume))) * (-84));
            int i75 = (~(streamMaxVolume | (-340394317))) | 638229458;
            int i76 = ~(i73 | 340394316);
            int i77 = i74 + ((i75 | i76) * (-84)) + (((-910859231) | i76) * 84) + 743171526;
            int i78 = (i77 << 13) ^ i77;
            int i79 = i78 ^ (i78 >>> 17);
            ((int[]) objArr3[2])[0] = i79 ^ (i79 << 5);
        }
        int i80 = ((int[]) objArr3[1])[0];
        int i81 = ((int[]) objArr3[0])[0];
        if (i81 == i80) {
            int i82 = ((int[]) objArr3[2])[0];
            Object[] objArr50 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i83 = ~iIdentityHashCode4;
            int i84 = i82 + (-1508821074) + (((~((-816544493) | i83)) | 11084320 | (~((-162079283) | i83))) * (-1136)) + (((~((-816544493) | iIdentityHashCode4)) | (~((-162079283) | iIdentityHashCode4)) | (~(967539454 | i83))) * (-568)) + (((~(iIdentityHashCode4 | (-11084321))) | (~(i83 | 162079282)) | (~(816544492 | i83))) * 568);
            int i85 = (i84 << 13) ^ i84;
            int i86 = i85 ^ (i85 >>> 17);
            i2 = 0;
            ((int[]) objArr50[2])[0] = i86 ^ (i86 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            Object[] objArr51 = {Long.valueOf(((long) (i80 ^ i81)) ^ (((long) (-1968602685)) << 32)), Long.valueOf(-1968602669)};
            byte[] bArr18 = $$d;
            Object[] objArr52 = new Object[1];
            c((byte) $$e, (short) 339, bArr18[238], objArr52);
            Class<?> cls6 = Class.forName((String) objArr52[0]);
            Object[] objArr53 = new Object[1];
            c((byte) (-bArr18[361]), bArr18[238], bArr18[14], objArr53);
            cls6.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            int i87 = ((int[]) objArr3[2])[0];
            Object[] objArr54 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i88 = ~(((int) SystemClock.elapsedRealtime()) | 744318687);
            int i89 = i87 + (((564809952 | i88) * (-658)) - 1886713186) + ((i88 | 27398176) * 658);
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            i2 = 0;
            ((int[]) objArr54[2])[0] = i91 ^ (i91 << 5);
        }
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame22 == null) {
            int i92 = 29 - (ExpandableListView.getPackedPositionForChild(i2, i2) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i2, i2) == 0L ? 0 : -1));
            char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0') + 49363);
            int iKeyCodeFromString = 684 - KeyEvent.keyCodeFromString("");
            byte b21 = (byte) ($$b + 5);
            byte[] bArr19 = $$a;
            Object[] objArr55 = new Object[1];
            a(b21, bArr19[4], bArr19[69], objArr55);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i92, cIndexOf, iKeyCodeFromString, 508509282, false, (String) objArr55[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j6 == -1 || j6 + 2019 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr56 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{11331, 1014, 8231, 35855}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 3868), new char[]{26219, 25086, 47670, 27767, 37951, 46909, 65419, 55753, 3414, 64384, 58506, 50241, 40982, 61054, 61668, 31938, 44122, 48519, 20870, 8770, 21192, 43166, 30155, 42027, 12370, 47822}, objArr56);
                Class<?> cls7 = Class.forName((String) objArr56[0]);
                Object[] objArr57 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{48434, 38195, 46342, 50833}, (char) (37302 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), new char[]{8673, 59799, 62806, 45504, 7198, 23521, 19234, 42800, 14938, 1937, 30686, 31651, 47147, 27241, 551, 10011, 61879, 37893}, objArr57);
                baseContext3 = (Context) cls7.getMethod((String) objArr57[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i93 = artificialFrame + 69;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
                    int i94 = i93 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            Object[] objArr58 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -289355488};
            int i95 = $$e;
            byte[] bArr20 = $$d;
            Object[] objArr59 = new Object[1];
            c((byte) i95, (short) 405, bArr20[624], objArr59);
            Class<?> cls8 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c(bArr20[40], (short) (i95 | 449), bArr20[648], objArr60);
            objArr4 = (Object[]) cls8.getMethod((String) objArr60[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr58);
            if (baseContext3 != null) {
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame23 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 30;
                    char cIndexOf2 = (char) (49362 - TextUtils.indexOf("", "", 0));
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 684;
                    byte[] bArr21 = $$a;
                    Object[] objArr61 = new Object[1];
                    a((byte) 58, (byte) (bArr21[21] - 1), bArr21[83], objArr61);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iMyTid, cIndexOf2, maxKeyCode, -1321816393, false, (String) objArr61[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, objArr4);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame24 == null) {
                        int iIndexOf3 = TextUtils.indexOf("", "") + 30;
                        char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                        int iNormalizeMetaState = 684 - KeyEvent.normalizeMetaState(0);
                        byte b22 = (byte) ($$b + 5);
                        byte[] bArr22 = $$a;
                        Object[] objArr62 = new Object[1];
                        a(b22, bArr22[4], bArr22[69], objArr62);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c2, iNormalizeMetaState, 508509282, false, (String) objArr62[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame25 == null) {
                int iIndexOf4 = 29 - TextUtils.indexOf((CharSequence) "", '0');
                char c3 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 49361);
                int iResolveSize = 684 - View.resolveSize(0, 0);
                byte[] bArr23 = $$a;
                Object[] objArr63 = new Object[1];
                a((byte) 58, (byte) (bArr23[21] - 1), bArr23[83], objArr63);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c3, iResolveSize, -1321816393, false, (String) objArr63[0], null);
            }
            Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame25).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr64[0])[0]}, new int[]{((int[]) objArr64[1])[0]}, new int[1], (String) objArr64[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i96 = (-621671494) + (((-1037870946) | iIdentityHashCode5) * 614);
            int i97 = ~iIdentityHashCode5;
            int i98 = ((i96 + ((((~((-1044116045) | i97)) | 35868684) | (~((-65492270) | i97))) * (-1228))) + (((~(i97 | (-29623586))) | (~((-1008247361) | i97))) * 614)) - 289355488;
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArr4[2])[0] = i100 ^ (i100 << 5);
        }
        int i101 = ((int[]) objArr4[1])[0];
        int i102 = ((int[]) objArr4[0])[0];
        if (i102 == i101) {
            int i103 = ((int[]) objArr4[2])[0];
            Object[] objArr65 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i104 = ~iIdentityHashCode6;
            int i105 = ~(226707252 | i104);
            int i106 = i103 + 1265469262 + ((542118090 | i105) * (-712)) + (((~(iIdentityHashCode6 | 768825342)) | (~(i104 | (-542118091)))) * (-712)) + (((-751916523) | i105) * 712);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr65[2])[0] = i108 ^ (i108 << 5);
        } else {
            Object[] objArr66 = {Long.valueOf(((long) (i101 ^ i102)) ^ (((long) (-218369307)) << 32)), Long.valueOf(-218369819)};
            byte[] bArr24 = $$d;
            Object[] objArr67 = new Object[1];
            c((byte) $$e, (short) 481, (byte) (-bArr24[44]), objArr67);
            Class<?> cls9 = Class.forName((String) objArr67[0]);
            Object[] objArr68 = new Object[1];
            c((byte) (-bArr24[361]), bArr24[238], bArr24[14], objArr68);
            cls9.getMethod((String) objArr68[0], Long.TYPE, Long.TYPE).invoke(null, objArr66);
            int i109 = ((int[]) objArr4[2])[0];
            Object[] objArr69 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyTid2 = Process.myTid();
            int i110 = ~iMyTid2;
            int i111 = i109 + 1190377054 + ((1073737087 | iMyTid2) * (-676)) + (((~(1045399927 | i110)) | (-1073737088)) * 676) + (((~(iMyTid2 | (-28337161))) | (~(i110 | 66776152)) | 1006960935) * 676);
            int i112 = (i111 << 13) ^ i111;
            int i113 = i112 ^ (i112 >>> 17);
            ((int[]) objArr69[2])[0] = i113 ^ (i113 << 5);
        }
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame26 == null) {
            int i114 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            char c4 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
            int jumpTapTimeout2 = 465 - (ViewConfiguration.getJumpTapTimeout() >> 16);
            byte[] bArr25 = $$a;
            byte b23 = bArr25[5];
            byte b24 = bArr25[21];
            Object[] objArr70 = new Object[1];
            a(b23, b24, (byte) (b24 - 1), objArr70);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i114, c4, jumpTapTimeout2, -785931255, false, (String) objArr70[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j7 != -1) {
            int i115 = artificialFrame + 51;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i115 % 128;
            int i116 = i115 % 2;
            if (j7 + 2035 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame27 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 22;
                    char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 465;
                    byte[] bArr26 = $$a;
                    byte b25 = (byte) (-bArr26[11]);
                    byte b26 = bArr26[21];
                    Object[] objArr71 = new Object[1];
                    a(b25, b26, (byte) (b26 - 1), objArr71);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, edgeSlop, threadPriority, -612765161, false, (String) objArr71[0], null);
                }
                Object[] objArr72 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
                objArr5 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i117 = ((int[]) objArr72[3])[0];
                int i118 = ((int[]) objArr72[0])[0];
                String[] strArr5 = (String[]) objArr72[1];
                int iMyTid3 = Process.myTid();
                int i119 = ((((~(iMyTid3 | (-316131378))) * TypedValues.CycleType.TYPE_EASING) + 989853121) + (((~((~iMyTid3) | (-316131378))) | 203425358) * TypedValues.CycleType.TYPE_EASING)) - 2023985638;
                int i120 = (i119 << 13) ^ i119;
                int i121 = i120 ^ (i120 >>> 17);
                ((int[]) objArr5[2])[0] = i121 ^ (i121 << 5);
                i3 = 0;
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr73 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{11331, 1014, 8231, 35855}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) + 3771), new char[]{26219, 25086, 47670, 27767, 37951, 46909, 65419, 55753, 3414, 64384, 58506, 50241, 40982, 61054, 61668, 31938, 44122, 48519, 20870, 8770, 21192, 43166, 30155, 42027, 12370, 47822}, objArr73);
                    Class<?> cls10 = Class.forName((String) objArr73[0]);
                    Object[] objArr74 = new Object[1];
                    b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 99, new char[]{48434, 38195, 46342, 50833}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 37297), new char[]{8673, 59799, 62806, 45504, 7198, 23521, 19234, 42800, 14938, 1937, 30686, 31651, 47147, 27241, 551, 10011, 61879, 37893}, objArr74);
                    baseContext = (Context) cls10.getMethod((String) objArr74[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if (!(baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) {
                        baseContext = null;
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr75 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{49096, 43825, 26017, 55104}, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), new char[]{10422, 12582, 55670, 60193, 22322, 48258, 54994, 19451, 64125, 55642, 25590, 25642, 43040, 32322, 30237, 9262, 51383, 60818, 2107, 4354, 55731, 51965, 46401, 9962, 23964, 17333, 50662, 37864, 57328, 63684, 39043, 55600, 4710, 43558, 24913, 672, 23555, 7787, 13881, 12444, 42522, 36418, 17597, 44883, 61167, 45396, 34804, 40576, 5515, 4614, 64206, 21613, 35782, 42999, 50950, 55840, 25968, 62301, 2705, 14805, 14761, 48957, 33708, 13870}, objArr75);
                String str6 = (String) objArr75[0];
                Object[] objArr76 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{10551, 6882, 57798, 51866}, (char) Color.green(0), new char[]{34236, 53778, 36016, 32890, 20550, 53766, 39079, 63875, 7366, 6402, 62131, 48610, 12765, 48126, 14746, 24760, 39968, 12160, 42739, 33210, 26770, 64164, 27099, 21410, 28486, 50880, 46637, 29812, 48004, 30347, 4766, 4365, 30995, 24394, 31545, 44546, 24645, 42929, 21170, 57983, 11989, 22222, 41203, 961, 52226, 35744, 45700, 26339, 63167, 60232, 52957, 41630, 63808, 38591, 32662, 19938, 21506, 16565, 51362, 6426, 10155, 5547, 63392, 37295}, objArr76);
                Object[] objArr77 = {baseContext, new String[]{str6, (String) objArr76[0]}, Integer.valueOf(iIntValue), 1, -2023985638};
                byte[] bArr27 = $$d;
                Object[] objArr78 = new Object[1];
                c(bArr27[40], (short) TypedValues.PositionType.TYPE_SIZE_PERCENT, bArr27[262], objArr78);
                Class<?> cls11 = Class.forName((String) objArr78[0]);
                Object[] objArr79 = new Object[1];
                c(bArr27[40], (short) ($$e | 449), bArr27[648], objArr79);
                objArr5 = (Object[]) cls11.getMethod((String) objArr79[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr77);
                int i122 = ((int[]) objArr5[0])[0];
                int i123 = ((int[]) objArr5[3])[0];
                if (baseContext != null) {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame == null) {
                        int scrollDefaultDelay2 = 21 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        char cRgb = (char) (Color.rgb(0, 0, 0) + 16777216);
                        int iRed = Color.red(0) + 465;
                        byte[] bArr28 = $$a;
                        byte b27 = (byte) (-bArr28[11]);
                        byte b28 = bArr28[21];
                        Object[] objArr80 = new Object[1];
                        a(b27, b28, (byte) (b28 - 1), objArr80);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, cRgb, iRed, -612765161, false, (String) objArr80[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr5);
                    try {
                        Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame2 == null) {
                            int scrollBarFadeDuration4 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21;
                            char size = (char) View.MeasureSpec.getSize(0);
                            int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 465;
                            byte[] bArr29 = $$a;
                            byte b29 = bArr29[5];
                            byte b30 = bArr29[21];
                            Object[] objArr81 = new Object[1];
                            a(b29, b30, (byte) (b30 - 1), objArr81);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, size, maximumFlingVelocity2, -785931255, false, (String) objArr81[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf5);
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                }
                i3 = 0;
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr710 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{11331, 1014, 8231, 35855}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) + 3771), new char[]{26219, 25086, 47670, 27767, 37951, 46909, 65419, 55753, 3414, 64384, 58506, 50241, 40982, 61054, 61668, 31938, 44122, 48519, 20870, 8770, 21192, 43166, 30155, 42027, 12370, 47822}, objArr710);
                Class<?> cls12 = Class.forName((String) objArr710[0]);
                Object[] objArr711 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 99, new char[]{48434, 38195, 46342, 50833}, (char) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 37297), new char[]{8673, 59799, 62806, 45504, 7198, 23521, 19234, 42800, 14938, 1937, 30686, 31651, 47147, 27241, 551, 10011, 61879, 37893}, objArr711);
                baseContext = (Context) cls12.getMethod((String) objArr711[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = null;
                }
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr712 = new Object[1];
            b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{49096, 43825, 26017, 55104}, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), new char[]{10422, 12582, 55670, 60193, 22322, 48258, 54994, 19451, 64125, 55642, 25590, 25642, 43040, 32322, 30237, 9262, 51383, 60818, 2107, 4354, 55731, 51965, 46401, 9962, 23964, 17333, 50662, 37864, 57328, 63684, 39043, 55600, 4710, 43558, 24913, 672, 23555, 7787, 13881, 12444, 42522, 36418, 17597, 44883, 61167, 45396, 34804, 40576, 5515, 4614, 64206, 21613, 35782, 42999, 50950, 55840, 25968, 62301, 2705, 14805, 14761, 48957, 33708, 13870}, objArr712);
            String str7 = (String) objArr712[0];
            Object[] objArr713 = new Object[1];
            b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 4, new char[]{10551, 6882, 57798, 51866}, (char) Color.green(0), new char[]{34236, 53778, 36016, 32890, 20550, 53766, 39079, 63875, 7366, 6402, 62131, 48610, 12765, 48126, 14746, 24760, 39968, 12160, 42739, 33210, 26770, 64164, 27099, 21410, 28486, 50880, 46637, 29812, 48004, 30347, 4766, 4365, 30995, 24394, 31545, 44546, 24645, 42929, 21170, 57983, 11989, 22222, 41203, 961, 52226, 35744, 45700, 26339, 63167, 60232, 52957, 41630, 63808, 38591, 32662, 19938, 21506, 16565, 51362, 6426, 10155, 5547, 63392, 37295}, objArr713);
            Object[] objArr714 = {baseContext, new String[]{str7, (String) objArr713[0]}, Integer.valueOf(iIntValue2), 1, -2023985638};
            byte[] bArr210 = $$d;
            Object[] objArr715 = new Object[1];
            c(bArr210[40], (short) TypedValues.PositionType.TYPE_SIZE_PERCENT, bArr210[262], objArr715);
            Class<?> cls13 = Class.forName((String) objArr715[0]);
            Object[] objArr716 = new Object[1];
            c(bArr210[40], (short) ($$e | 449), bArr210[648], objArr716);
            objArr5 = (Object[]) cls13.getMethod((String) objArr716[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr714);
            int i124 = ((int[]) objArr5[0])[0];
            int i125 = ((int[]) objArr5[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame == null) {
                    int scrollDefaultDelay3 = 21 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16777216);
                    int iRed2 = Color.red(0) + 465;
                    byte[] bArr211 = $$a;
                    byte b210 = (byte) (-bArr211[11]);
                    byte b211 = bArr211[21];
                    Object[] objArr82 = new Object[1];
                    a(b210, b211, (byte) (b211 - 1), objArr82);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay3, cRgb2, iRed2, -612765161, false, (String) objArr82[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr5);
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int scrollBarFadeDuration5 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21;
                    char size2 = (char) View.MeasureSpec.getSize(0);
                    int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 465;
                    byte[] bArr212 = $$a;
                    byte b212 = bArr212[5];
                    byte b31 = bArr212[21];
                    Object[] objArr83 = new Object[1];
                    a(b212, b31, (byte) (b31 - 1), objArr83);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, size2, maximumFlingVelocity3, -785931255, false, (String) objArr83[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf6);
            }
            i3 = 0;
        }
        int i126 = ((int[]) objArr5[i3])[i3];
        int i127 = ((int[]) objArr5[3])[i3];
        if (i127 == i126) {
            Object[] objArr84 = new Object[4];
            int[] iArr = new int[1];
            objArr84[i3] = iArr;
            objArr84[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr84[3] = iArr2;
            int i128 = ((int[]) objArr5[2])[i3];
            int i129 = ((int[]) objArr5[3])[i3];
            int i130 = ((int[]) objArr5[i3])[i3];
            String[] strArr6 = (String[]) objArr5[1];
            iArr2[i3] = i129;
            iArr[i3] = i130;
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(i3, 4).length() - 558689993;
            int i131 = i128 + 674269448 + (((~((-648070468) | length)) | 580960322) * 345) + (((~((-648070468) | (~length))) | (-1068681064)) * 345) + ((~(length | (-580960323))) * 345);
            int i132 = (i131 << 13) ^ i131;
            int i133 = i132 ^ (i132 >>> 17);
            ((int[]) objArr84[2])[0] = i133 ^ (i133 << 5);
            objArr84[1] = strArr6;
            i4 = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArr5[1];
            if (strArr7 != null) {
                for (String str8 : strArr7) {
                    arrayList3.add(str8);
                }
            }
            Object[] objArr85 = {Long.valueOf(((long) (i126 ^ i127)) ^ (((long) 893313166) << 32)), Long.valueOf(893313230)};
            Object[] objArr86 = new Object[1];
            c((byte) $$e, (short) 581, (byte) 36, objArr86);
            Class<?> cls14 = Class.forName((String) objArr86[0]);
            byte[] bArr30 = $$d;
            Object[] objArr87 = new Object[1];
            c((byte) (-bArr30[361]), bArr30[238], bArr30[14], objArr87);
            cls14.getMethod((String) objArr87[0], Long.TYPE, Long.TYPE).invoke(null, objArr85);
            Object[] objArr88 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i134 = ((int[]) objArr5[2])[0];
            int i135 = ((int[]) objArr5[3])[0];
            int i136 = ((int[]) objArr5[0])[0];
            String[] strArr8 = (String[]) objArr5[1];
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1443191950;
            int i137 = i134 + 769589516 + ((~((-23468289) | length2)) * 623) + (((~length2) | 134750337) * (-623)) + (((~(length2 | 135815887)) | (~((-24533839) | length2)) | 23468288) * 623);
            int i138 = (i137 << 13) ^ i137;
            int i139 = i138 ^ (i138 >>> 17);
            i4 = 0;
            ((int[]) objArr88[2])[0] = i139 ^ (i139 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame28 == null) {
            int i140 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char threadPriority2 = (char) ((Process.getThreadPriority(i4) + 20) >> 6);
            int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
            byte[] bArr31 = $$a;
            byte b32 = bArr31[5];
            byte b33 = bArr31[21];
            Object[] objArr89 = new Object[1];
            a(b32, b33, (byte) (b33 - 1), objArr89);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i140, threadPriority2, iIndexOf5, 2061780482, false, (String) objArr89[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j8 == -1 || j8 + 4611686018427387888L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr90 = {-1813825281};
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame29 == null) {
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 8, (char) (TextUtils.indexOf((CharSequence) "", '0') + 22252), ImageFormat.getBitsPerPixel(0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame29).newInstance(objArr90), 2099871088, false);
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame30 == null) {
                int mirror = AndroidCharacter.getMirror('0') - 22;
                char c5 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 1042;
                byte[] bArr32 = $$a;
                byte b34 = (byte) (-bArr32[11]);
                byte b35 = bArr32[21];
                Object[] objArr91 = new Object[1];
                a(b34, b35, (byte) (b35 - 1), objArr91);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(mirror, c5, packedPositionChild2, 1145017376, false, (String) objArr91[0], null);
            }
            ((Field) objAccessartificialFrame30).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame31 == null) {
                    int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 26;
                    char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int iLastIndexOf2 = 1040 - TextUtils.lastIndexOf("", '0', 0, 0);
                    byte[] bArr33 = $$a;
                    byte b36 = bArr33[5];
                    byte b37 = bArr33[21];
                    Object[] objArr92 = new Object[1];
                    a(b36, b37, (byte) (b37 - 1), objArr92);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, doubleTapTimeout, iLastIndexOf2, 2061780482, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            int i141 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i141 % 128;
            int i142 = i141 % 2;
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame32 == null) {
                int iCombineMeasuredStates = 26 - View.combineMeasuredStates(0, 0);
                char cIndexOf3 = (char) TextUtils.indexOf("", "", 0, 0);
                int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                byte[] bArr34 = $$a;
                byte b38 = (byte) (-bArr34[11]);
                byte b39 = bArr34[21];
                Object[] objArr93 = new Object[1];
                a(b38, b39, (byte) (b39 - 1), objArr93);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cIndexOf3, iIndexOf6, 1145017376, false, (String) objArr93[0], null);
            }
            Object[] objArr94 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i143 = ((int[]) objArr94[3])[0];
            int i144 = ((int[]) objArr94[2])[0];
            String[] strArr9 = (String[]) objArr94[0];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i145 = ((((~(363855679 | iIdentityHashCode7)) | 268894776) * 449) - 708793394) + (((~((~iIdentityHashCode7) | 363855679)) | 268894776) * 449) + 2099871088;
            int i146 = (i145 << 13) ^ i145;
            int i147 = i146 ^ (i146 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i147 ^ (i147 << 5);
        }
        int i148 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i149 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i149 == i148) {
            Object[] objArr95 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i150 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i151 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i152 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr10 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i153 = ~((-556795140) | iFreeMemory);
            int i154 = ~iFreeMemory;
            int i155 = i150 + 1237046318 + ((i153 | (~(1039986087 | i154))) * 920) + (((~((-561294756) | i154)) | 556795139) * 920) + (((~(iFreeMemory | 1039986087)) | (~((-556795140) | i154)) | (~((-4499617) | iFreeMemory))) * 920);
            int i156 = (i155 << 13) ^ i155;
            int i157 = i156 ^ (i156 >>> 17);
            ((int[]) objArr95[1])[0] = i157 ^ (i157 << 5);
            i5 = 0;
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr11 != null) {
                int i158 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i158 % 128;
                int i159 = i158 % 2;
                for (String str9 : strArr11) {
                    arrayList4.add(str9);
                }
            }
            Object[] objArr96 = {Long.valueOf(((long) (i148 ^ i149)) ^ (((long) (-1766447361)) << 32)), Long.valueOf(-1766447363)};
            byte[] bArr35 = $$d;
            Object[] objArr97 = new Object[1];
            c((byte) $$e, (short) 619, (byte) (-bArr35[89]), objArr97);
            Class<?> cls15 = Class.forName((String) objArr97[0]);
            Object[] objArr98 = new Object[1];
            c((byte) (-bArr35[361]), bArr35[238], bArr35[14], objArr98);
            cls15.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            Object[] objArr99 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i160 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i161 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i162 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i163 = ~iUptimeMillis;
            int i164 = i160 + (-661969496) + ((778976864 | i163) * (-757)) + ((~(804159329 | iUptimeMillis)) * 1514) + (((~(iUptimeMillis | (-25182466))) | (~(i163 | 700873057)) | 103286272) * 757);
            int i165 = (i164 << 13) ^ i164;
            int i166 = i165 ^ (i165 >>> 17);
            i5 = 0;
            ((int[]) objArr99[1])[0] = i166 ^ (i166 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0', i5, i5) + 37;
            char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
            int touchSlop2 = 540 - (ViewConfiguration.getTouchSlop() >> 8);
            byte[] bArr36 = $$a;
            byte b40 = bArr36[5];
            byte b41 = bArr36[21];
            Object[] objArr100 = new Object[1];
            a(b40, b41, (byte) (b41 - 1), objArr100);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iIndexOf7, cLastIndexOf, touchSlop2, 624296913, false, (String) objArr100[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame33).getLong(null);
        if (j9 != -1) {
            int i167 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
            artificialFrame = i167 % 128;
            if (i167 % 2 == 0) {
                i9 = (1906 & j9) >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[1])).longValue() ? 0 : 0;
                i6 = 0;
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.indexOf("", "", i6, i6), (char) (39515 - ((byte) KeyEvent.getModifierMetaStateMask())), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
                }
                Object[] objArr101 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 1417613720, 0};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame4 == null) {
                    int absoluteGravity3 = 36 - Gravity.getAbsoluteGravity(0, 0);
                    char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                    int iIndexOf8 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                    byte b42 = $$a[30];
                    Object[] objArr102 = new Object[1];
                    a((byte) 65, b42, (byte) (b42 | 34), objArr102);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, offsetBefore, iIndexOf8, 2101703389, false, (String) objArr102[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (833 - (ViewConfiguration.getPressedStateDuration() >> 16)), 576 - (KeyEvent.getMaxKeyCode() >> 16)), (Class) ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 54, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 629 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr101);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf9 = 36 - TextUtils.indexOf("", "", 0, 0);
                    char longPressTimeout = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int scrollBarFadeDuration6 = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    byte[] bArr37 = $$a;
                    byte b43 = (byte) (-bArr37[11]);
                    byte b44 = bArr37[21];
                    Object[] objArr103 = new Object[1];
                    a(b43, b44, (byte) (b44 - 1), objArr103);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf9, longPressTimeout, scrollBarFadeDuration6, 793268735, false, (String) objArr103[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame6 == null) {
                        int i168 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36;
                        char cKeyCodeFromString3 = (char) KeyEvent.keyCodeFromString("");
                        int iIndexOf10 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                        byte[] bArr38 = $$a;
                        byte b45 = bArr38[5];
                        byte b46 = bArr38[21];
                        Object[] objArr104 = new Object[1];
                        a(b45, b46, (byte) (b46 - 1), objArr104);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i168, cKeyCodeFromString3, iIndexOf10, 624296913, false, (String) objArr104[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf8);
                    i7 = 1;
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else if (j9 + 1906 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                i6 = 0;
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.indexOf("", "", i6, i6), (char) (39515 - ((byte) KeyEvent.getModifierMetaStateMask())), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
                }
                Object[] objArr105 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 1417613720, 0};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame4 == null) {
                    int absoluteGravity4 = 36 - Gravity.getAbsoluteGravity(0, 0);
                    char offsetBefore2 = (char) TextUtils.getOffsetBefore("", 0);
                    int iIndexOf11 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                    byte b47 = $$a[30];
                    Object[] objArr106 = new Object[1];
                    a((byte) 65, b47, (byte) (b47 | 34), objArr106);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(absoluteGravity4, offsetBefore2, iIndexOf11, 2101703389, false, (String) objArr106[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (833 - (ViewConfiguration.getPressedStateDuration() >> 16)), 576 - (KeyEvent.getMaxKeyCode() >> 16)), (Class) ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 54, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 629 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr105);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame5 == null) {
                    int iIndexOf12 = 36 - TextUtils.indexOf("", "", 0, 0);
                    char longPressTimeout2 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                    int scrollBarFadeDuration7 = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    byte[] bArr39 = $$a;
                    byte b48 = (byte) (-bArr39[11]);
                    byte b49 = bArr39[21];
                    Object[] objArr107 = new Object[1];
                    a(b48, b49, (byte) (b49 - 1), objArr107);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf12, longPressTimeout2, scrollBarFadeDuration7, 793268735, false, (String) objArr107[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr6);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame6 == null) {
                    int i169 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36;
                    char cKeyCodeFromString4 = (char) KeyEvent.keyCodeFromString("");
                    int iIndexOf13 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                    byte[] bArr310 = $$a;
                    byte b410 = bArr310[5];
                    byte b411 = bArr310[21];
                    Object[] objArr108 = new Object[1];
                    a(b410, b411, (byte) (b411 - 1), objArr108);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i169, cKeyCodeFromString4, iIndexOf13, 624296913, false, (String) objArr108[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, lValueOf9);
                i7 = 1;
            }
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame34 == null) {
                int iLastIndexOf3 = 35 - TextUtils.lastIndexOf("", '0', i9, i9);
                char cIndexOf4 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', i9));
                int iMyPid = (Process.myPid() >> 22) + 540;
                byte[] bArr40 = $$a;
                byte b50 = (byte) (-bArr40[11]);
                byte b51 = bArr40[21];
                Object[] objArr109 = new Object[1];
                a(b50, b51, (byte) (b51 - 1), objArr109);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, cIndexOf4, iMyPid, 793268735, false, (String) objArr109[0], null);
            }
            Object[] objArr110 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[1], new int[1], new int[1]};
            int i170 = ((int[]) objArr110[2])[0];
            int i171 = ((int[]) objArr110[1])[0];
            ((int[]) objArr6[2])[0] = i170;
            ((int[]) objArr6[1])[0] = i171;
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i172 = (((~((-604082690) | iIdentityHashCode8)) * 521) - 1605427740) + (((~((~iIdentityHashCode8) | (-604082690))) | 143525960) * 521) + 1417613720;
            int i173 = (i172 << 13) ^ i172;
            int i174 = i173 ^ (i173 >>> 17);
            ((int[]) objArr6[0])[0] = i174 ^ (i174 << 5);
            i7 = 1;
        } else {
            i6 = 0;
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.indexOf("", "", i6, i6), (char) (39515 - ((byte) KeyEvent.getModifierMetaStateMask())), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
            }
            Object[] objArr1010 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 1417613720, 0};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame4 == null) {
                int absoluteGravity5 = 36 - Gravity.getAbsoluteGravity(0, 0);
                char offsetBefore3 = (char) TextUtils.getOffsetBefore("", 0);
                int iIndexOf14 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                byte b412 = $$a[30];
                Object[] objArr1011 = new Object[1];
                a((byte) 65, b412, (byte) (b412 | 34), objArr1011);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(absoluteGravity5, offsetBefore3, iIndexOf14, 2101703389, false, (String) objArr1011[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.resolveSize(0, 0), (char) (833 - (ViewConfiguration.getPressedStateDuration() >> 16)), 576 - (KeyEvent.getMaxKeyCode() >> 16)), (Class) ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 54, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 629 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr1010);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame5 == null) {
                int iIndexOf15 = 36 - TextUtils.indexOf("", "", 0, 0);
                char longPressTimeout3 = (char) (ViewConfiguration.getLongPressTimeout() >> 16);
                int scrollBarFadeDuration8 = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte[] bArr311 = $$a;
                byte b413 = (byte) (-bArr311[11]);
                byte b414 = bArr311[21];
                Object[] objArr1012 = new Object[1];
                a(b413, b414, (byte) (b414 - 1), objArr1012);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iIndexOf15, longPressTimeout3, scrollBarFadeDuration8, 793268735, false, (String) objArr1012[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr6);
            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame6 == null) {
                int i1610 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 36;
                char cKeyCodeFromString5 = (char) KeyEvent.keyCodeFromString("");
                int iIndexOf16 = 539 - TextUtils.indexOf((CharSequence) "", '0');
                byte[] bArr312 = $$a;
                byte b415 = bArr312[5];
                byte b416 = bArr312[21];
                Object[] objArr1013 = new Object[1];
                a(b415, b416, (byte) (b416 - 1), objArr1013);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i1610, cKeyCodeFromString5, iIndexOf16, 624296913, false, (String) objArr1013[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf10);
            i7 = 1;
        }
        Object obj = objArr6[i7];
        int i175 = ((int[]) obj)[0];
        Object obj2 = objArr6[2];
        int i176 = ((int[]) obj2)[0];
        if (i176 == i175) {
            Object[] objArr111 = {new int[i7], new int[i7], new int[i7]};
            int i177 = ((int[]) objArr6[0])[0];
            int i178 = ((int[]) obj2)[0];
            int i179 = ((int[]) obj)[0];
            ((int[]) objArr111[2])[0] = i178;
            ((int[]) objArr111[1])[0] = i179;
            int i180 = ~System.identityHashCode(this);
            int i181 = i177 + 1761299549 + (((-103727106) | i180) * SyslogConstants.LOG_LOCAL7) + (((~(i180 | 970014654)) | (-795861770)) * SyslogConstants.LOG_LOCAL7);
            int i182 = i181 ^ (i181 << 13);
            int i183 = i182 ^ (i182 >>> 17);
            ((int[]) objArr111[0])[0] = i183 ^ (i183 << 5);
            i8 = 0;
        } else {
            long j10 = ((long) (i175 ^ i176)) ^ (((long) (-1578060467)) << 32);
            long j11 = -1578064563;
            int i184 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i184 % 128;
            int i185 = i184 % 2;
            Object[] objArr112 = {Long.valueOf(j10), Long.valueOf(j11)};
            byte[] bArr41 = $$d;
            Object[] objArr113 = new Object[1];
            c((byte) $$e, (short) 481, (byte) (-bArr41[44]), objArr113);
            Class<?> cls16 = Class.forName((String) objArr113[0]);
            Object[] objArr114 = new Object[1];
            c((byte) (-bArr41[361]), bArr41[238], bArr41[14], objArr114);
            cls16.getMethod((String) objArr114[0], Long.TYPE, Long.TYPE).invoke(null, objArr112);
            Object[] objArr115 = {new int[1], new int[1], new int[1]};
            int i186 = ((int[]) objArr6[0])[0];
            int i187 = ((int[]) objArr6[2])[0];
            int i188 = ((int[]) objArr6[1])[0];
            ((int[]) objArr115[2])[0] = i187;
            ((int[]) objArr115[1])[0] = i188;
            int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
            int i189 = i186 + (-1455651643) + (((~((-358697321) | iFreeMemory2)) | 287326472) * 1504) + ((~(iFreeMemory2 | (-71370849))) * (-1504)) + 164989104;
            int i190 = (i189 << 13) ^ i189;
            int i191 = i190 ^ (i190 >>> 17);
            i8 = 0;
            ((int[]) objArr115[0])[0] = i191 ^ (i191 << 5);
        }
        super.onCreate();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame35 == null) {
            int iIndexOf17 = 29 - TextUtils.indexOf((CharSequence) "", '0');
            char cAlpha = (char) (49362 - Color.alpha(i8));
            int iCombineMeasuredStates2 = View.combineMeasuredStates(i8, i8) + 684;
            byte[] bArr42 = $$a;
            Object[] objArr116 = new Object[1];
            a((byte) 85, bArr42[83], bArr42[69], objArr116);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf17, cAlpha, iCombineMeasuredStates2, 752929587, false, (String) objArr116[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j12 == -1 || j12 + 1912 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                int i192 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i192 % 128;
                int i193 = i192 % 2;
                Object[] objArr117 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{11331, 1014, 8231, 35855}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 3872), new char[]{26219, 25086, 47670, 27767, 37951, 46909, 65419, 55753, 3414, 64384, 58506, 50241, 40982, 61054, 61668, 31938, 44122, 48519, 20870, 8770, 21192, 43166, 30155, 42027, 12370, 47822}, objArr117);
                Class<?> cls17 = Class.forName((String) objArr117[0]);
                Object[] objArr118 = new Object[1];
                b(new char[]{57419, 24532, 56812, 12053}, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 115, new char[]{48434, 38195, 46342, 50833}, (char) (View.MeasureSpec.getSize(0) + 37301), new char[]{8673, 59799, 62806, 45504, 7198, 23521, 19234, 42800, 14938, 1937, 30686, 31651, 47147, 27241, 551, 10011, 61879, 37893}, objArr118);
                baseContext4 = (Context) cls17.getMethod((String) objArr118[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            Object[] objArr119 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 85614014};
            int i194 = $$e;
            byte[] bArr43 = $$d;
            Object[] objArr120 = new Object[1];
            c((byte) i194, (short) 661, bArr43[580], objArr120);
            Class<?> cls18 = Class.forName((String) objArr120[0]);
            Object[] objArr121 = new Object[1];
            c((byte) (i194 | 32), (short) 182, bArr43[93], objArr121);
            Object[] objArr122 = (Object[]) cls18.getMethod((String) objArr121[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr119);
            if (baseContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame36 == null) {
                    int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
                    char cIndexOf5 = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                    int iIndexOf18 = 684 - TextUtils.indexOf("", "", 0, 0);
                    byte[] bArr44 = $$a;
                    Object[] objArr123 = new Object[1];
                    a((byte) 100, bArr44[83], bArr44[112], objArr123);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(offsetAfter, cIndexOf5, iIndexOf18, 1944867703, false, (String) objArr123[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr122);
                try {
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame37 == null) {
                        int absoluteGravity6 = 30 - Gravity.getAbsoluteGravity(0, 0);
                        char mirror2 = (char) (AndroidCharacter.getMirror('0') + 49314);
                        int iLastIndexOf4 = TextUtils.lastIndexOf("", '0') + 685;
                        byte[] bArr45 = $$a;
                        Object[] objArr124 = new Object[1];
                        a((byte) 85, bArr45[83], bArr45[69], objArr124);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(absoluteGravity6, mirror2, iLastIndexOf4, 752929587, false, (String) objArr124[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf11);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr122;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame38 == null) {
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                char cRgb3 = (char) ((-16727854) - Color.rgb(0, 0, 0));
                int i195 = 685 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte[] bArr46 = $$a;
                Object[] objArr125 = new Object[1];
                a((byte) 100, bArr46[83], bArr46[112], objArr125);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cRgb3, i195, 1944867703, false, (String) objArr125[0], null);
            }
            Object[] objArr126 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr126[0])[0]}, new int[]{((int[]) objArr126[1])[0]}, new int[1], (String) objArr126[3]};
            int i196 = ~((int) Process.getStartElapsedRealtime());
            int i197 = 1162535790 + ((~(802455325 | i196)) * 52) + (((~(198459165 | i196)) | (~((-780164610) | i196)) | 603996160) * (-52)) + (((~(i196 | (-198459166))) | 22290716) * 52) + 85614014;
            int i198 = (i197 << 13) ^ i197;
            int i199 = i198 ^ (i198 >>> 17);
            ((int[]) objArr7[2])[0] = i199 ^ (i199 << 5);
        }
        int i200 = ((int[]) objArr7[1])[0];
        int i201 = ((int[]) objArr7[0])[0];
        if (i201 == i200) {
            int i202 = ((int[]) objArr7[2])[0];
            Object[] objArr127 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i203 = (-1262423110) + (((~((-915044015) | iIdentityHashCode9)) | 872435854 | (~(63579760 | iIdentityHashCode9))) * (-754));
            int i204 = ~((-872435855) | iIdentityHashCode9);
            int i205 = ~iIdentityHashCode9;
            int i206 = i202 + i203 + ((i204 | (~(936015614 | i205))) * (-754)) + ((i205 | (-915044015)) * 754);
            int i207 = (i206 << 13) ^ i206;
            int i208 = i207 ^ (i207 >>> 17);
            ((int[]) objArr127[2])[0] = i208 ^ (i208 << 5);
            return;
        }
        Object[] objArr128 = {Long.valueOf(((long) (i200 ^ i201)) ^ (((long) 1618732289) << 32)), Long.valueOf(1618732293)};
        byte[] bArr47 = $$d;
        Object[] objArr129 = new Object[1];
        c((byte) $$e, (short) 339, bArr47[238], objArr129);
        Class<?> cls19 = Class.forName((String) objArr129[0]);
        Object[] objArr130 = new Object[1];
        c((byte) (-bArr47[361]), bArr47[238], bArr47[14], objArr130);
        cls19.getMethod((String) objArr130[0], Long.TYPE, Long.TYPE).invoke(null, objArr128);
        int i209 = ((int[]) objArr7[2])[0];
        Object[] objArr131 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
        int iIdentityHashCode10 = System.identityHashCode(this);
        int i210 = ~iIdentityHashCode10;
        int i211 = (~((-679528163) | i210)) | 8439328;
        int i212 = ~(iIdentityHashCode10 | 970184446);
        int i213 = i209 + 920199134 + ((i211 | i212) * (-502)) + ((i212 | (~(i210 | (-671088835)))) * TypedValues.PositionType.TYPE_DRAWPATH);
        int i214 = (i213 << 13) ^ i213;
        int i215 = i214 ^ (i214 >>> 17);
        ((int[]) objArr131[2])[0] = i215 ^ (i215 << 5);
    }

    static {
        byte[] bArr = new byte[713];
        System.arraycopy("UßÙâðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýü¿\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:³\u0000AØé\u0000ñ\u0011îÿ\u000bà\bô\u0002íLÉá\u0005ñ\u000bï\u001aïê\u0004ðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëB´\t\u0000ê\u0000A¶\u000bé\u0000\u0007÷ú÷ýBØé\u0000úë+Ý÷ñ\u001cëé\u0000LüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ)Ðùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@¾ù\u0004üþï@Öýüþ\u0001ßñ\u000b Íü\u0007ó\u0006ûïJ½ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïö=·\nóöþõGàÓ\u0000ý\u001béô\u0001þë\u001eé\u0000ùûïðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û3°ü\u0001\u0002úüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ï\u0006îÿ\u0002\u00012·ú\u0001üýùúB´>\u0002½\u0004ý÷\u0004/·\nîü\u0006öý<Ýäý÷\u0004\u001aÐýöþÿÿü\u0003ï+Ðþù\u000béLÌÞ\rï÷ÿýùú-Ðýöþÿÿõ.Í\u00033úðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011øðþüúý<°ü\u0004÷".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 713);
        $$d = bArr;
        $$e = 12;
        $$a = new byte[]{89, -28, 106, -128, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7};
        $$b = 41;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        coroutineBoundary = -2551529299509916409L;
        accessartificialFrame = -1151259316;
        CoroutineDebuggingKt = (char) 11596;
    }
}
