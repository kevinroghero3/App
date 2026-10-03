package com.transistorsoft.tsbackgroundfetch;

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
import android.os.PersistableBundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.internal.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.ArtificialStackFrames;
import o.asBinder;
import org.apache.commons.lang3.CharEncoding;
import org.joda.time.LocalDateTime;

/* JADX INFO: loaded from: classes6.dex */
public class FetchJobService extends JobService {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static long extraCommand;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final List<ExecutedJob> sExecutedJobs;
    private static final byte[] $$c = {7, 40, -110, -80};
    private static final int $$f = 175;
    private static int $10 = 0;
    private static int $11 = 1;

    public interface CompletionHandler {
        void finish();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r7, int r8, byte r9) {
        /*
            int r8 = r8 * 4
            int r8 = r8 + 118
            int r9 = r9 * 2
            int r9 = r9 + 4
            byte[] r0 = com.transistorsoft.tsbackgroundfetch.FetchJobService.$$c
            int r7 = r7 * 2
            int r7 = 1 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r7
            r8 = r9
            r4 = r2
            goto L2a
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
        L2a:
            int r9 = r9 + r3
            int r8 = r8 + 1
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.tsbackgroundfetch.FetchJobService.$$g(short, int, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.transistorsoft.tsbackgroundfetch.FetchJobService.$$a
            int r6 = 104 - r6
            int r1 = 21 - r7
            int r8 = r8 + 65
            byte[] r1 = new byte[r1]
            int r7 = 20 - r7
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2c
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2c:
            int r6 = r6 + r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.tsbackgroundfetch.FetchJobService.a(short, byte, int, java.lang.Object[]):void");
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
    private static void c(int r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.transistorsoft.tsbackgroundfetch.FetchJobService.$$d
            int r8 = r8 + 36
            int r9 = 82 - r9
            int r7 = 730 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r9
            r4 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L22:
            r3 = r0[r7]
            r6 = r3
            r3 = r8
            r8 = r6
        L27:
            int r8 = -r8
            int r3 = r3 + r8
            int r8 = r3 + (-2)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.tsbackgroundfetch.FetchJobService.c(int, int, byte, java.lang.Object[]):void");
    }

    static {
        byte[] bArr = new byte[765];
        System.arraycopy("I\u0080\u0096xò\u0000=Åöþ\u0006ù\u00055Ëñ\bð\u0001\u0004\u00034¿\në\rñ\u0007\u0006ó<Éò\u0001ûûB·ÿ\tû\u0001ó\t\u0002ðCèÉ\t\u000bò\u0002\u0004\u001eÒ\u0001ûûLþÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001/þÁù8»\u0000úCÀû\u0006\u0003ÿüö;Éòû\u000b5¹\u0001\u00059éÈ\u0014õ\u0001\u0004\u001fË\rþÿñ\u001cà\u000füö\u0004ñ\u0002\u0001òþ\u0002;\u0003Ãùø\rñ\u0002\u000bó<µ\u0002CÚë\u0002ó\u0013ð\u0001\râ\nö\u0004ïNËã\u0007ó\rñ\u001cñì\u0006ò\u0000=Åöþ\u0006ù\u00055Ëñ\bð\u0001\u0004\u00034ÅøøCÃùø\rñ\u0002\u000bó<¿\u0006\u0002ìü\u0001\u000bö\u0006õøD²þ\u0015úÒû\u0001øÿ\tù\u0007\u001fÝ\u0001ë\fþüù\u0005\u001aÕò\u0000=Åöþ\u0006ù\u00055Æûõ\u000b\u0001ÿì\f5Éò\u0000ûÿÿ\u0007õøÿCÝÝú\tøÿ\u000bó\u001aÜ\u0001÷\u000b\u0003ýñLþÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001-ò\u0000=Åöþ\u0006ù\u00055Ëñ\bð\u0001\u0004\u00034ÅøøCÉò\u0000þüÿ>Ãú\nø\u0000ðC²\u0017þòû\u0001øÿ\tù\u0007 Ï\u000b\u0002ë\tøÿò\u0000=Åöþ\u0006ù\u00055Ëï\u00059ÛÚ\u0004ù\u0011\u000fÜ\u0001ù\u0003ò\u0000=Åöþ\u0006ù\u00055Ëñ\bð\u0001\u0004\u00034ÅøøCÃùø\rñ\u0002\u000bó<¿ÿÿ\u0000ó\u0013ç\u000bô\bøÿ\rûÿí\rò\tý5²þ\u0016æüþüðþ\u0010íü\t\u0001û\u0004ø\u0006ó$Ò\u000fò\u0006ò\u0000=Åöþ\u0006ù\u00055¿ÿÿ\u0000óDÉò\u0000þüÿ>¹\r÷\u0000ùø\rñ\u0002\u000bó<²þ\u0007ò\u0000=Åöþ\u0006ù\u00055Ëñ\bð\u0001\u0004\u00034ÅøøCÉò\u0000þüÿ>¿ü\tí\u0007\u0005úùùý\u0011óþ<ßÜ\tí\u0007\u0005\u001aÙùý\u0011óþ\u0017Ý\u0011ëý\u0000\u001cã\n\u0001ë\r?ÒÜ\u0001\u0006ó\u000bðþ(Ù\u0006õò\u0000=Æ\u0003üü\u0001ñþ\u0002;º\u000b\u0002üíD·\nú\nñ\u000bø\u0000ñBÓè\u0006\u0004\u0011Ý\tý\u0013ßþ\u0001FþÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001/ø?Ãùö\u000fñü\u0011ì\f5Æûõ\u000b\u0001ÿì\f5¼\tñ\n6Úë\u0002üí$ëë\tñ\u000f\u001dÛõ\u000b\u0001ÿì\f\u0013éñ\n\u0017Ü\tí\u0007\u0005?þÝË\u0002\rñ\u0002\u000bó\u0017Ø\tø\n\u0001ï\t\u0004\u0015éò\tü\u0001,ò\u0000=Æ\u0003üü\u0001ñþ\u0002;Ëïþ\u0002\u0001ù\u0001öCëÏþ\"áù\u0001%áë\u0011;ñ".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 765);
        $$d = bArr;
        $$e = JfifUtil.MARKER_RST7;
        $$a = new byte[]{70, -105, 85, -56, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7};
        $$b = 68;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        sExecutedJobs = new ArrayList();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        if (System.currentTimeMillis() - extras.getLong("scheduled_at") < 1000) {
            jobFinished(jobParameters, false);
            return false;
        }
        String string = extras.getString(BackgroundFetchConfig.FIELD_TASK_ID);
        List<ExecutedJob> list = sExecutedJobs;
        synchronized (list) {
            Iterator<ExecutedJob> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().isDuplicate(string)) {
                    Log.d(BackgroundFetch.TAG, "- Caught duplicate Job " + string + ": [IGNORED]");
                    jobFinished(jobParameters, false);
                    return false;
                }
            }
            List<ExecutedJob> list2 = sExecutedJobs;
            list2.add(new ExecutedJob(string));
            if (list2.size() > 5) {
                list2.remove(0);
            }
            BackgroundFetch.getInstance(getApplicationContext()).onFetch(new BGTask(this, string, new CompletionHandler() { // from class: com.transistorsoft.tsbackgroundfetch.FetchJobService$$ExternalSyntheticLambda0
                @Override // com.transistorsoft.tsbackgroundfetch.FetchJobService.CompletionHandler
                public final void finish() {
                    this.f$0.lambda$onStartJob$0(jobParameters);
                }
            }, jobParameters.getJobId()));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        Log.d(BackgroundFetch.TAG, "- jobFinished");
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(BackgroundFetch.TAG, "- onStopJob");
        BGTask task = BGTask.getTask(jobParameters.getExtras().getString(BackgroundFetchConfig.FIELD_TASK_ID));
        if (task != null) {
            task.onTimeout(getApplicationContext());
        }
        jobFinished(jobParameters, false);
        return true;
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = $10 + 19;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - KeyEvent.keyCodeFromString(""), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 1407 - (KeyEvent.getMaxKeyCode() >> 16), 1035473698, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                try {
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), Gravity.getAbsoluteGravity(0, 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                    int i6 = $11 + 65;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
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
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        String str = new String(cArr2);
        int i8 = $11 + 11;
        $10 = i8 % 128;
        if (i8 % 2 == 0) {
            objArr[0] = str;
        } else {
            int i9 = 58 / 0;
            objArr[0] = str;
        }
    }

    static class ExecutedJob {
        private static final long OFFSET_TIME = 5000;
        private final String mTaskId;
        private final long mTimestamp = System.currentTimeMillis();

        ExecutedJob(String str) {
            this.mTaskId = str;
        }

        boolean isDuplicate(String str) {
            return str.equalsIgnoreCase(this.mTaskId) && System.currentTimeMillis() - this.mTimestamp < 5000;
        }

        public String toString() {
            return "[LastJob taskId: " + this.mTaskId + ", timestamp: " + this.mTimestamp + "]";
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x018b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0231 A[Catch: all -> 0x0a29, TryCatch #0 {all -> 0x0a29, blocks: (B:51:0x0705, B:53:0x0719, B:54:0x074a, B:14:0x0211, B:16:0x0231, B:17:0x0283), top: B:94:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0295  */
    /* JADX WARN: Code duplicated, block: B:25:0x036a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0680  */
    /* JADX WARN: Code duplicated, block: B:53:0x0719 A[Catch: all -> 0x0a29, TryCatch #0 {all -> 0x0a29, blocks: (B:51:0x0705, B:53:0x0719, B:54:0x074a, B:14:0x0211, B:16:0x0231, B:17:0x0283), top: B:94:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0760  */
    /* JADX WARN: Code duplicated, block: B:62:0x0838  */
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrCoroutineCreation$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 25;
            char c = (char) (30068 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
            byte b = (byte) ($$b | 33);
            byte b2 = $$a[68];
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | 35), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(touchSlop, c, maximumFlingVelocity, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 117;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 1989;
            Object[] objArr3 = new Object[1];
            b(40486 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 12338, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 25;
                    char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                    int i4 = 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte b3 = (byte) ($$b | 25);
                    byte b4 = $$a[68];
                    Object[] objArr5 = new Object[1];
                    a(b3, b4, (byte) (b4 | 35), objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(absoluteGravity, cCombineMeasuredStates, i4, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i5 = ((int[]) objArr6[0])[0];
                int i6 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int i7 = (int) Runtime.getRuntime().totalMemory();
                int i8 = ((((-101806364) + (((-573412641) | i7) * (-627))) + (((~(577623848 | i7)) | 775796214) * (-627))) + (((~(i7 | 775796214)) | (~((~i7) | (-577623849)))) * 627)) - 1355800395;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 832, new char[]{37493, 37163, 38083, 39809, 40805, 33498, 33152, 34082, 35024, 36812, 45854, 46785, 46480, 47418, 48348, 41865}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 10717, new char[]{37494, 47226, 50808, 60530, 14959, 16499, 28269, 46177, 49759, 59511, 13926, 23676, 27216, 45181, 56949, 58485}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -1355800395};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iRgb = (-16777191) - Color.rgb(0, 0, 0);
                        char cIndexOf = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int minimumFlingVelocity = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        byte[] bArr = $$a;
                        Object[] objArr10 = new Object[1];
                        a(bArr[2], bArr[112], bArr[39], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRgb, cIndexOf, minimumFlingVelocity, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf = 24 - TextUtils.indexOf((CharSequence) "", '0');
                        char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                        int iLastIndexOf = 815 - TextUtils.lastIndexOf("", '0');
                        byte b5 = (byte) ($$b | 25);
                        byte b6 = $$a[68];
                        Object[] objArr11 = new Object[1];
                        a(b5, b6, (byte) (b6 | 35), objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, scrollBarFadeDuration, iLastIndexOf, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 40483, new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 12338, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int offsetAfter = 25 - TextUtils.getOffsetAfter("", 0);
                            char scrollBarFadeDuration2 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 816;
                            byte b7 = (byte) ($$b | 33);
                            byte b8 = $$a[68];
                            Object[] objArr14 = new Object[1];
                            a(b7, b8, (byte) (b8 | 35), objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetAfter, scrollBarFadeDuration2, threadPriority, 721586079, false, (String) objArr14[0], null);
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
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 832, new char[]{37493, 37163, 38083, 39809, 40805, 33498, 33152, 34082, 35024, 36812, 45854, 46785, 46480, 47418, 48348, 41865}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 10717, new char[]{37494, 47226, 50808, 60530, 14959, 16499, 28269, 46177, 49759, 59511, 13926, 23676, 27216, 45181, 56949, 58485}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -1355800395};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iRgb2 = (-16777191) - Color.rgb(0, 0, 0);
                char cIndexOf2 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int minimumFlingVelocity2 = 816 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr2 = $$a;
                Object[] objArr18 = new Object[1];
                a(bArr2[2], bArr2[112], bArr2[39], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRgb2, cIndexOf2, minimumFlingVelocity2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0');
                char scrollBarFadeDuration3 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                int iLastIndexOf2 = 815 - TextUtils.lastIndexOf("", '0');
                byte b9 = (byte) ($$b | 25);
                byte b10 = $$a[68];
                Object[] objArr19 = new Object[1];
                a(b9, b10, (byte) (b10 | 35), objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf2, scrollBarFadeDuration3, iLastIndexOf2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 40483, new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 12338, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int offsetAfter2 = 25 - TextUtils.getOffsetAfter("", 0);
                char scrollBarFadeDuration4 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 816;
                byte b11 = (byte) ($$b | 33);
                byte b12 = $$a[68];
                Object[] objArr112 = new Object[1];
                a(b11, b12, (byte) (b12 | 35), objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetAfter2, scrollBarFadeDuration4, threadPriority2, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArr[1])[0];
        int i12 = ((int[]) objArr[0])[0];
        if (i12 == i11) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i13 = ((int[]) objArr[3])[0];
            int i14 = ((int[]) objArr[0])[0];
            int i15 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int i16 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1635339844;
            int i17 = i13 + 1569447879 + (((~(i16 | (-729333463))) | 927505828) * 191) + (((~((~i16) | (-729333463))) | 591961220) * 191);
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr20[3])[0] = i19 ^ (i19 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-811691332)) << 32)), Long.valueOf(-811691331)};
                short s = (short) ($$e | 512);
                byte[] bArr3 = $$d;
                Object[] objArr22 = new Object[1];
                c(s, bArr3[571], bArr3[5], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b13 = bArr3[5];
                Object[] objArr23 = new Object[1];
                c((short) 646, b13, (byte) (b13 | 79), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i20 = ((int[]) objArr[3])[0];
                int i21 = ((int[]) objArr[0])[0];
                int i22 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i23 = i20 + (-625979091) + (((~((-102746205) | iIdentityHashCode)) | 95426161) * (-366)) + (((~(iIdentityHashCode | (-34588685))) | 27268641) * 366);
                int i24 = (i23 << 13) ^ i23;
                int i25 = i24 ^ (i24 >>> 17);
                ((int[]) objArr24[3])[0] = i25 ^ (i25 << 5);
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
            int mirror = AndroidCharacter.getMirror('0') - 22;
            char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
            int capsMode = 1041 - TextUtils.getCapsMode("", 0, 0);
            byte b14 = (byte) ($$b | 33);
            byte b15 = $$a[68];
            Object[] objArr25 = new Object[1];
            a(b14, b15, (byte) (b15 | 35), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mirror, scrollBarSize, capsMode, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 2038;
            Object[] objArr26 = new Object[1];
            b(40488 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b(12373 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int defaultSize = View.getDefaultSize(0, 0) + 26;
                    char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 1041;
                    byte b16 = (byte) ($$b | 25);
                    byte b17 = $$a[68];
                    Object[] objArr28 = new Object[1];
                    a(b16, b17, (byte) (b17 | 35), objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(defaultSize, edgeSlop, deadChar, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrCoroutineCreation$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i26 = ((int[]) objArr29[3])[0];
                int i27 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i28 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i29 = ~i28;
                int i30 = ((((-702192220) + (((~(482524185 | i29)) | 560627992) * (-90))) + (((~(482524185 | i28)) | 478166017) * (-45))) + ((((~(i28 | (-560627993))) | 482524185) | (~(i29 | 560627992))) * 45)) - 297893972;
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArrCoroutineCreation$78cbbd35[1])[0] = i32 ^ (i32 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 818, new char[]{37493, 37163, 38083, 39809, 40805, 33498, 33152, 34082, 35024, 36812, 45854, 46785, 46480, 47418, 48348, 41865}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10749, new char[]{37494, 47226, 50808, 60530, 14959, 16499, 28269, 46177, 49759, 59511, 13926, 23676, 27216, 45181, 56949, 58485}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-779282044};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - ExpandableListView.getPackedPositionChild(0L), (char) (22251 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -297893972, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iRgb3 = Color.rgb(0, 0, 0) + 16777242;
                    char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                    int iMyTid = (Process.myTid() >> 22) + 1041;
                    byte b18 = (byte) ($$b | 25);
                    byte b19 = $$a[68];
                    Object[] objArr33 = new Object[1];
                    a(b18, b19, (byte) (b19 | 35), objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb3, deadChar2, iMyTid, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrCoroutineCreation$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 40438, new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 12352, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int scrollBarSize2 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c2 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int offsetBefore = 1041 - TextUtils.getOffsetBefore("", 0);
                        byte b20 = (byte) ($$b | 33);
                        byte b21 = $$a[68];
                        Object[] objArr36 = new Object[1];
                        a(b20, b21, (byte) (b21 | 35), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, c2, offsetBefore, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 818, new char[]{37493, 37163, 38083, 39809, 40805, 33498, 33152, 34082, 35024, 36812, 45854, 46785, 46480, 47418, 48348, 41865}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10749, new char[]{37494, 47226, 50808, 60530, 14959, 16499, 28269, 46177, 49759, 59511, 13926, 23676, 27216, 45181, 56949, 58485}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-779282044};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(7 - ExpandableListView.getPackedPositionChild(0L), (char) (22251 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrCoroutineCreation$78cbbd35 = b.coroutineCreation$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -297893972, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iRgb4 = Color.rgb(0, 0, 0) + 16777242;
                char deadChar3 = (char) KeyEvent.getDeadChar(0, 0);
                int iMyTid2 = (Process.myTid() >> 22) + 1041;
                byte b110 = (byte) ($$b | 25);
                byte b111 = $$a[68];
                Object[] objArr310 = new Object[1];
                a(b110, b111, (byte) (b111 | 35), objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iRgb4, deadChar3, iMyTid2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrCoroutineCreation$78cbbd35);
            Object[] objArr311 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 40438, new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 12352, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int scrollBarSize3 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                char c3 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int offsetBefore2 = 1041 - TextUtils.getOffsetBefore("", 0);
                byte b22 = (byte) ($$b | 33);
                byte b23 = $$a[68];
                Object[] objArr313 = new Object[1];
                a(b22, b23, (byte) (b23 | 35), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, c3, offsetBefore2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i33 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
        int i34 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
        if (i34 == i33) {
            int i35 = artificialFrame + 5;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
            int i36 = i35 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i37 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
            int i38 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
            int i39 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrCoroutineCreation$78cbbd35[0];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i40 = ~((-298750827) | iUptimeMillis);
            int i41 = ~iUptimeMillis;
            int i42 = i37 + 1462321326 + ((i40 | (~((-220647020) | i41))) * (-1808)) + (((~((-281547009) | iUptimeMillis)) | (~(i41 | (-203443202)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iUptimeMillis | 220647019)) | 17203818 | (~(298750826 | i41))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i43 = (i42 << 13) ^ i42;
            int i44 = i43 ^ (i43 >>> 17);
            ((int[]) objArr40[1])[0] = i44 ^ (i44 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArrCoroutineCreation$78cbbd35[0];
        if (strArr7 != null) {
            int i45 = 0;
            while (i45 < strArr7.length) {
                int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                artificialFrame = i46 % 128;
                if (i46 % 2 == 0) {
                    arrayList2.add(strArr7[i45]);
                    i45 += com.salesforce.marketingcloud.analytics.stats.b.l;
                } else {
                    arrayList2.add(strArr7[i45]);
                    i45++;
                }
            }
        }
        long j5 = ((long) (i33 ^ i34)) ^ (((long) 1851083338) << 32);
        long j6 = 1851083336;
        int i47 = artificialFrame + 115;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i47 % 128;
        int i48 = i47 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        c((short) 644, bArr4[571], (byte) (-bArr4[553]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b24 = bArr4[5];
        Object[] objArr43 = new Object[1];
        c((short) 646, b24, (byte) (b24 | 79), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i49 = ((int[]) objArrCoroutineCreation$78cbbd35[1])[0];
        int i50 = ((int[]) objArrCoroutineCreation$78cbbd35[3])[0];
        int i51 = ((int[]) objArrCoroutineCreation$78cbbd35[2])[0];
        String[] strArr8 = (String[]) objArrCoroutineCreation$78cbbd35[0];
        int i52 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
        int i53 = i49 + (((2003196032 + (((-671088875) | i52) * (-381))) + (((~((~i52) | (-696795372))) | 129516801) * 381)) - 2013176766);
        int i54 = (i53 << 13) ^ i53;
        int i55 = i54 ^ (i54 >>> 17);
        ((int[]) objArr44[1])[0] = i55 ^ (i55 << 5);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0a63  */
    /* JADX WARN: Code duplicated, block: B:103:0x0a8c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0a95  */
    /* JADX WARN: Code duplicated, block: B:107:0x0b66  */
    /* JADX WARN: Code duplicated, block: B:111:0x0bea  */
    /* JADX WARN: Code duplicated, block: B:116:0x0c59  */
    /* JADX WARN: Code duplicated, block: B:120:0x0cb1  */
    /* JADX WARN: Code duplicated, block: B:121:0x0d3d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0e50  */
    /* JADX WARN: Code duplicated, block: B:135:0x0f75  */
    /* JADX WARN: Code duplicated, block: B:138:0x0f7e A[Catch: all -> 0x24d7, TryCatch #4 {all -> 0x24d7, blocks: (B:267:0x1d81, B:269:0x1da3, B:270:0x1df9, B:136:0x0f78, B:138:0x0f7e, B:139:0x0fac, B:141:0x0fd6, B:142:0x1061, B:84:0x089b, B:86:0x08a8, B:87:0x08d5, B:89:0x08df, B:91:0x08ec, B:92:0x091d, B:15:0x0211, B:17:0x0225, B:18:0x0256), top: B:368:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0fd6 A[Catch: all -> 0x24d7, TryCatch #4 {all -> 0x24d7, blocks: (B:267:0x1d81, B:269:0x1da3, B:270:0x1df9, B:136:0x0f78, B:138:0x0f7e, B:139:0x0fac, B:141:0x0fd6, B:142:0x1061, B:84:0x089b, B:86:0x08a8, B:87:0x08d5, B:89:0x08df, B:91:0x08ec, B:92:0x091d, B:15:0x0211, B:17:0x0225, B:18:0x0256), top: B:368:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x1074  */
    /* JADX WARN: Code duplicated, block: B:150:0x10e2  */
    /* JADX WARN: Code duplicated, block: B:154:0x1138  */
    /* JADX WARN: Code duplicated, block: B:155:0x11be  */
    /* JADX WARN: Code duplicated, block: B:160:0x129b  */
    /* JADX WARN: Code duplicated, block: B:169:0x13ba  */
    /* JADX WARN: Code duplicated, block: B:171:0x13c1  */
    /* JADX WARN: Code duplicated, block: B:173:0x141e  */
    /* JADX WARN: Code duplicated, block: B:175:0x1422  */
    /* JADX WARN: Code duplicated, block: B:179:0x142e  */
    /* JADX WARN: Code duplicated, block: B:184:0x153a  */
    /* JADX WARN: Code duplicated, block: B:186:0x1543  */
    /* JADX WARN: Code duplicated, block: B:191:0x15ac  */
    /* JADX WARN: Code duplicated, block: B:198:0x1609  */
    /* JADX WARN: Code duplicated, block: B:199:0x1688  */
    /* JADX WARN: Code duplicated, block: B:201:0x1693  */
    /* JADX WARN: Code duplicated, block: B:204:0x16a1 A[LOOP:1: B:202:0x169e->B:204:0x16a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:210:0x1784  */
    /* JADX WARN: Code duplicated, block: B:219:0x18b3  */
    /* JADX WARN: Code duplicated, block: B:221:0x18ba  */
    /* JADX WARN: Code duplicated, block: B:223:0x1923  */
    /* JADX WARN: Code duplicated, block: B:225:0x1927  */
    /* JADX WARN: Code duplicated, block: B:227:0x1933  */
    /* JADX WARN: Code duplicated, block: B:230:0x1941  */
    /* JADX WARN: Code duplicated, block: B:233:0x194b  */
    /* JADX WARN: Code duplicated, block: B:234:0x194d  */
    /* JADX WARN: Code duplicated, block: B:238:0x19d1  */
    /* JADX WARN: Code duplicated, block: B:240:0x19da  */
    /* JADX WARN: Code duplicated, block: B:245:0x1a4c  */
    /* JADX WARN: Code duplicated, block: B:251:0x1ab0  */
    /* JADX WARN: Code duplicated, block: B:252:0x1b47  */
    /* JADX WARN: Code duplicated, block: B:257:0x1c40  */
    /* JADX WARN: Code duplicated, block: B:266:0x1d63  */
    /* JADX WARN: Code duplicated, block: B:269:0x1da3 A[Catch: all -> 0x24d7, TryCatch #4 {all -> 0x24d7, blocks: (B:267:0x1d81, B:269:0x1da3, B:270:0x1df9, B:136:0x0f78, B:138:0x0f7e, B:139:0x0fac, B:141:0x0fd6, B:142:0x1061, B:84:0x089b, B:86:0x08a8, B:87:0x08d5, B:89:0x08df, B:91:0x08ec, B:92:0x091d, B:15:0x0211, B:17:0x0225, B:18:0x0256), top: B:368:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x1e0c  */
    /* JADX WARN: Code duplicated, block: B:278:0x1e77  */
    /* JADX WARN: Code duplicated, block: B:282:0x1ece  */
    /* JADX WARN: Code duplicated, block: B:283:0x1f3f  */
    /* JADX WARN: Code duplicated, block: B:285:0x1f4b  */
    /* JADX WARN: Code duplicated, block: B:288:0x1f4f A[LOOP:0: B:286:0x1f4c->B:288:0x1f4f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:294:0x203d  */
    /* JADX WARN: Code duplicated, block: B:303:0x2164  */
    /* JADX WARN: Code duplicated, block: B:305:0x216a  */
    /* JADX WARN: Code duplicated, block: B:307:0x21b0  */
    /* JADX WARN: Code duplicated, block: B:309:0x21b4  */
    /* JADX WARN: Code duplicated, block: B:313:0x21c0  */
    /* JADX WARN: Code duplicated, block: B:317:0x2257  */
    /* JADX WARN: Code duplicated, block: B:319:0x2260  */
    /* JADX WARN: Code duplicated, block: B:324:0x22d4  */
    /* JADX WARN: Code duplicated, block: B:330:0x2331  */
    /* JADX WARN: Code duplicated, block: B:331:0x23be  */
    /* JADX WARN: Code duplicated, block: B:82:0x0818  */
    /* JADX WARN: Code duplicated, block: B:83:0x0895  */
    /* JADX WARN: Code duplicated, block: B:86:0x08a8 A[Catch: all -> 0x24d7, TryCatch #4 {all -> 0x24d7, blocks: (B:267:0x1d81, B:269:0x1da3, B:270:0x1df9, B:136:0x0f78, B:138:0x0f7e, B:139:0x0fac, B:141:0x0fd6, B:142:0x1061, B:84:0x089b, B:86:0x08a8, B:87:0x08d5, B:89:0x08df, B:91:0x08ec, B:92:0x091d, B:15:0x0211, B:17:0x0225, B:18:0x0256), top: B:368:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x08ec A[Catch: all -> 0x24d7, TryCatch #4 {all -> 0x24d7, blocks: (B:267:0x1d81, B:269:0x1da3, B:270:0x1df9, B:136:0x0f78, B:138:0x0f7e, B:139:0x0fac, B:141:0x0fd6, B:142:0x1061, B:84:0x089b, B:86:0x08a8, B:87:0x08d5, B:89:0x08df, B:91:0x08ec, B:92:0x091d, B:15:0x0211, B:17:0x0225, B:18:0x0256), top: B:368:0x0211 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0a10  */
    @Override // android.app.Service
    public void onCreate() throws Throwable {
        Object[] objArr;
        int i;
        int i2;
        Context baseContext;
        Object[] objArr2;
        int i3;
        int i4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i5;
        Object objAccessartificialFrame3;
        long j;
        Object[] objArr3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        int i6;
        int i7;
        int i8;
        Object objAccessartificialFrame6;
        long j2;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        Object[] objArr4;
        Object objAccessartificialFrame9;
        Object objAccessartificialFrame10;
        Object obj;
        int i9;
        Object obj2;
        int i10;
        int i11;
        Object objAccessartificialFrame11;
        long j3;
        Context baseContext2;
        Object[] objArr5;
        int i12;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i13;
        int i14;
        ArrayList arrayList;
        String[] strArr;
        int i15;
        Object objAccessartificialFrame14;
        long j4;
        Context baseContext3;
        Object[] objArr6;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        int i16;
        int i17;
        int i18;
        int i19;
        Object objAccessartificialFrame17;
        long j5;
        Object objAccessartificialFrame18;
        Object[] objArr7;
        Object objAccessartificialFrame19;
        Object objAccessartificialFrame20;
        int i20;
        int i21;
        ArrayList arrayList2;
        String[] strArr2;
        int i22;
        int i23;
        Object objAccessartificialFrame21;
        long j6;
        Context baseContext4;
        Object[] objArr8;
        Object objAccessartificialFrame22;
        Object objAccessartificialFrame23;
        int i24;
        int i25;
        Object objAccessartificialFrame24;
        int i26 = 2 % 2;
        Object[] objArr9 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 40466, new char[]{37502, 3158, 44597, 18456, 60140, 33973, 9873, 49440, 25416, 7475, 49079, 23009, 64434, 38295, 13385, 54835, 28674, 4811, 36045, 11925, 51568, 27463}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 12338, new char[]{37498, 41510, 62164, 656, 21304, 25555, 45957, 49182, 4306, 8323, 28961, 33228, 53642, 58915, 14044}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 738, new char[]{37493, 37163, 38083, 39809, 40805, 33498, 33152, 34082, 35024, 36812, 45854, 46785, 46480, 47418, 48348, 41865}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        b((ViewConfiguration.getKeyRepeatDelay() >> 16) + 10753, new char[]{37494, 47226, 50808, 60530, 14959, 16499, 28269, 46177, 49759, 59511, 13926, 23676, 27216, 45181, 56949, 58485}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame25 == null) {
            int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0', 0);
            char c = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1041;
            byte b = (byte) ($$b | 33);
            byte b2 = $$a[68];
            Object[] objArr13 = new Object[1];
            a(b, b2, (byte) (b2 | 35), objArr13);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, doubleTapTimeout, 2061780482, false, (String) objArr13[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j7 == -1 || j7 + 1977 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            try {
                Object[] objArr14 = {-1476129611};
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame26 == null) {
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9, (char) (22251 - (Process.myPid() >> 22)), 1033 - (ViewConfiguration.getPressedStateDuration() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = LocalDateTime.Property.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame26).newInstance(objArr14), -1324432460, false);
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame27 == null) {
                    int iNormalizeMetaState = 26 - KeyEvent.normalizeMetaState(0);
                    char mode = (char) View.MeasureSpec.getMode(0);
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 1041;
                    byte b3 = (byte) ($$b | 25);
                    byte b4 = $$a[68];
                    Object[] objArr15 = new Object[1];
                    a(b3, b4, (byte) (b4 | 35), objArr15);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, mode, touchSlop, 1145017376, false, (String) objArr15[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame28 == null) {
                        int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 26;
                        char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                        int jumpTapTimeout = 1041 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        byte b5 = (byte) ($$b | 33);
                        byte b6 = $$a[68];
                        Object[] objArr16 = new Object[1];
                        a(b5, b6, (byte) (b6 | 35), objArr16);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, scrollBarSize, jumpTapTimeout, 2061780482, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf);
                    objArr = objArrAccessartificialFrame$78cbbd35;
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
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame29 == null) {
                int i27 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char capsMode = (char) TextUtils.getCapsMode("", 0, 0);
                int i28 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1041;
                byte b7 = (byte) ($$b | 25);
                byte b8 = $$a[68];
                Object[] objArr17 = new Object[1];
                a(b7, b8, (byte) (b8 | 35), objArr17);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i27, capsMode, i28, 1145017376, false, (String) objArr17[0], null);
            }
            Object[] objArr18 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i29 = ((int[]) objArr18[3])[0];
            int i30 = ((int[]) objArr18[2])[0];
            String[] strArr3 = (String[]) objArr18[0];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i31 = ((((-1259114978) + (((~((-78651393) | (~iFreeMemory))) | (~((-547586) | iFreeMemory))) * (-272))) + (((~((-770843705) | iFreeMemory)) | 692192312) * (-272))) + (((~(iFreeMemory | 770843704)) | (-692739898)) * 272)) - 1324432460;
            int i32 = (i31 << 13) ^ i31;
            int i33 = i32 ^ (i32 >>> 17);
            ((int[]) objArr[1])[0] = i33 ^ (i33 << 5);
        }
        int i34 = ((int[]) objArr[2])[0];
        int i35 = ((int[]) objArr[3])[0];
        if (i35 == i34) {
            Object[] objArr19 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i36 = ((int[]) objArr[1])[0];
            int i37 = ((int[]) objArr[3])[0];
            int i38 = ((int[]) objArr[2])[0];
            String[] strArr4 = (String[]) objArr[0];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1502523733;
            int i39 = ~((-241792790) | length);
            int i40 = 1010977038 + ((138490388 | i39) * (-280)) + ((i39 | (~(163688982 | length))) * 140);
            int i41 = ~((-103302402) | length);
            int i42 = ~length;
            int i43 = i36 + i40 + (((~(i42 | 266991383)) | i41 | (~((-138490389) | i42))) * 140);
            int i44 = i43 ^ (i43 << 13);
            int i45 = i44 ^ (i44 >>> 17);
            ((int[]) objArr19[1])[0] = i45 ^ (i45 << 5);
            i = 0;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr5 = (String[]) objArr[0];
            if (strArr5 != null) {
                for (String str5 : strArr5) {
                    arrayList3.add(str5);
                }
            }
            try {
                Object[] objArr20 = {Long.valueOf(((long) (i34 ^ i35)) ^ (((long) 1875904497) << 32)), Long.valueOf(1875904499)};
                short s = (short) TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
                byte[] bArr = $$d;
                Object[] objArr21 = new Object[1];
                c(s, (byte) (-bArr[145]), (byte) (-bArr[148]), objArr21);
                Class<?> cls = Class.forName((String) objArr21[0]);
                byte b9 = bArr[5];
                Object[] objArr22 = new Object[1];
                c((short) 646, b9, (byte) (b9 | 79), objArr22);
                cls.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i46 = ((int[]) objArr[1])[0];
                int i47 = ((int[]) objArr[3])[0];
                int i48 = ((int[]) objArr[2])[0];
                String[] strArr6 = (String[]) objArr[0];
                int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i49 = i46 + 1550619146 + (((~(layoutDirection | (-450730058))) | (-528833865)) * (-465)) + (((-450730058) | (~((-528833865) | layoutDirection))) * 930) + ((layoutDirection | (-444930121)) * 465);
                int i50 = (i49 << 13) ^ i49;
                int i51 = i50 ^ (i50 >>> 17);
                i = 0;
                ((int[]) objArr23[1])[0] = i51 ^ (i51 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame30 == null) {
            int packedPositionType = 17 - ExpandableListView.getPackedPositionType(0L);
            char cRed = (char) Color.red(i);
            int scrollBarSize2 = 747 - (ViewConfiguration.getScrollBarSize() >> 8);
            byte b10 = (byte) ($$b | 33);
            byte b11 = $$a[68];
            Object[] objArr24 = new Object[1];
            a(b10, b11, (byte) (b11 | 35), objArr24);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(packedPositionType, cRed, scrollBarSize2, -144068856, false, (String) objArr24[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame30).getLong(null);
        try {
            try {
                if (j8 != -1) {
                    i2 = 0;
                    if (j8 + 1989 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame31 == null) {
                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 17;
                            char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                            int defaultSize = 747 - View.getDefaultSize(0, 0);
                            byte b12 = (byte) ($$b | 25);
                            byte b13 = $$a[68];
                            Object[] objArr25 = new Object[1];
                            a(b12, b13, (byte) (b13 | 35), objArr25);
                            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, absoluteGravity, defaultSize, -1031537386, false, (String) objArr25[0], null);
                        }
                        Object[] objArr26 = (Object[]) ((Field) objAccessartificialFrame31).get(null);
                        objArr2 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i52 = ((int[]) objArr26[3])[0];
                        int i53 = ((int[]) objArr26[4])[0];
                        List list = (List) objArr26[0];
                        List list2 = (List) objArr26[2];
                        int i54 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
                        int i55 = ((344469036 + (((~((-605595937) | i54)) | (~((-147479) | i54))) * 69)) + (((~(i54 | (-193351839))) | ((~((-798800297) | i54)) | 193204360)) * (-69))) - 1201585961;
                        int i56 = (i55 << 13) ^ i55;
                        int i57 = i56 ^ (i56 >>> 17);
                        ((int[]) objArr2[1])[0] = i57 ^ (i57 << 5);
                    }
                    i3 = ((int[]) objArr2[4])[0];
                    i4 = ((int[]) objArr2[3])[0];
                    if (i4 == i3) {
                        Object[] objArr27 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i58 = ((int[]) objArr2[1])[0];
                        int i59 = ((int[]) objArr2[3])[0];
                        int i60 = ((int[]) objArr2[4])[0];
                        List list3 = (List) objArr2[0];
                        List list4 = (List) objArr2[2];
                        int iIdentityHashCode = System.identityHashCode(this);
                        int i61 = ~iIdentityHashCode;
                        int i62 = i58 + 1856825234 + (((~((-603246241) | i61)) | (~(603315945 | iIdentityHashCode))) * (-831)) + ((~((-601113729) | iIdentityHashCode)) * (-1662)) + (((~(iIdentityHashCode | 603246240)) | (~(i61 | (-2202218))) | (~(2202217 | iIdentityHashCode))) * 831);
                        int i63 = (i62 << 13) ^ i62;
                        int i64 = i63 ^ (i63 >>> 17);
                        i5 = 0;
                        ((int[]) objArr27[1])[0] = i64 ^ (i64 << 5);
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        Object[] objArr28 = {objArr2};
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                        if (objAccessartificialFrame == null) {
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 42, (char) (View.resolveSize(0, 0) + 12468), 3642 - TextUtils.indexOf("", "", 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame).invoke(null, objArr28));
                        Object[] objArr29 = {objArr2};
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 42, (char) (Color.blue(0) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame2).invoke(null, objArr29));
                        Object[] objArr30 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) 480970455) << 32)), Long.valueOf(480970463)};
                        short s2 = (short) FacebookRequestErrorClassification.ESC_APP_INACTIVE;
                        byte[] bArr2 = $$d;
                        Object[] objArr31 = new Object[1];
                        c(s2, bArr2[571], bArr2[39], objArr31);
                        Class<?> cls2 = Class.forName((String) objArr31[0]);
                        byte b14 = bArr2[5];
                        Object[] objArr32 = new Object[1];
                        c((short) 646, b14, (byte) (b14 | 79), objArr32);
                        cls2.getMethod((String) objArr32[0], Long.TYPE, Long.TYPE).invoke(null, objArr30);
                        Object[] objArr33 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i65 = ((int[]) objArr2[1])[0];
                        int i66 = ((int[]) objArr2[3])[0];
                        int i67 = ((int[]) objArr2[4])[0];
                        List list5 = (List) objArr2[0];
                        List list6 = (List) objArr2[2];
                        int i68 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                        int i69 = i65 + (((~((-196829482) | i68)) | 60841993) * (-283)) + 643863292 + ((~(i68 | (-135987489))) * 283);
                        int i70 = (i69 << 13) ^ i69;
                        int i71 = i70 ^ (i70 >>> 17);
                        i5 = 0;
                        ((int[]) objArr33[1])[0] = i71 ^ (i71 << 5);
                    }
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame3 == null) {
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', i5) + 31;
                        char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                        int capsMode2 = TextUtils.getCapsMode("", i5, i5) + 684;
                        byte[] bArr3 = $$a;
                        Object[] objArr34 = new Object[1];
                        a((byte) 74, bArr3[64], (byte) (bArr3[15] - 1), objArr34);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, cLastIndexOf, capsMode2, -1583976536, false, (String) objArr34[0], null);
                    }
                    j = ((Field) objAccessartificialFrame3).getLong(null);
                    if (j != -1) {
                        int i72 = artificialFrame + 11;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i72 % 128;
                        int i73 = i72 % 2;
                        if (j + 1988 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(910856866);
                            if (objAccessartificialFrame24 == null) {
                                int iResolveOpacity = 30 - Drawable.resolveOpacity(0, 0);
                                char modifierMetaStateMask = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                                int i74 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                                byte[] bArr4 = $$a;
                                Object[] objArr35 = new Object[1];
                                a((byte) 62, bArr4[68], (byte) (bArr4[15] + 1), objArr35);
                                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, modifierMetaStateMask, i74, -1456483158, false, (String) objArr35[0], null);
                            }
                            Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                            objArr3 = new Object[]{new int[]{((int[]) objArr36[0])[0]}, new int[]{((int[]) objArr36[1])[0]}, new int[1], (String) objArr36[3]};
                            int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                            int i75 = ~ringerMode;
                            int i76 = (((2121344902 + (((~(967475198 | i75)) | 11148576) * 220)) + (((~(i75 | 27934196)) | 950689578) * (-440))) + ((ringerMode | 967475198) * 220)) - 1086630373;
                            int i77 = (i76 << 13) ^ i76;
                            int i78 = i77 ^ (i77 >>> 17);
                            ((int[]) objArr3[2])[0] = i78 ^ (i78 << 5);
                        } else {
                            Object[] objArr37 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1086630373};
                            byte[] bArr5 = $$d;
                            byte b15 = bArr5[571];
                            Object[] objArr38 = new Object[1];
                            c((short) 421, b15, (byte) (b15 & 234), objArr38);
                            Class<?> cls3 = Class.forName((String) objArr38[0]);
                            Object[] objArr39 = new Object[1];
                            c((short) 382, bArr5[571], (byte) (-bArr5[22]), objArr39);
                            objArr3 = (Object[]) cls3.getMethod((String) objArr39[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr37);
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                            if (objAccessartificialFrame4 == null) {
                                int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                                char cIndexOf = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                                int iRgb = Color.rgb(0, 0, 0) + 16777900;
                                byte[] bArr6 = $$a;
                                Object[] objArr40 = new Object[1];
                                a((byte) 62, bArr6[68], (byte) (bArr6[15] + 1), objArr40);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cIndexOf, iRgb, -1456483158, false, (String) objArr40[0], null);
                            }
                            ((Field) objAccessartificialFrame4).set(null, objArr3);
                            try {
                                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                                if (objAccessartificialFrame5 == null) {
                                    int offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
                                    char cMyPid = (char) ((Process.myPid() >> 22) + 49362);
                                    int gidForName = 683 - Process.getGidForName("");
                                    byte[] bArr7 = $$a;
                                    Object[] objArr41 = new Object[1];
                                    a((byte) 74, bArr7[64], (byte) (bArr7[15] - 1), objArr41);
                                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter, cMyPid, gidForName, -1583976536, false, (String) objArr41[0], null);
                                }
                                ((Field) objAccessartificialFrame5).set(null, lValueOf2);
                            } catch (Exception unused2) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object[] objArr310 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1086630373};
                        byte[] bArr8 = $$d;
                        byte b16 = bArr8[571];
                        Object[] objArr311 = new Object[1];
                        c((short) 421, b16, (byte) (b16 & 234), objArr311);
                        Class<?> cls4 = Class.forName((String) objArr311[0]);
                        Object[] objArr312 = new Object[1];
                        c((short) 382, bArr8[571], (byte) (-bArr8[22]), objArr312);
                        objArr3 = (Object[]) cls4.getMethod((String) objArr312[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr310);
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame4 == null) {
                            int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                            char cIndexOf2 = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                            int iRgb2 = Color.rgb(0, 0, 0) + 16777900;
                            byte[] bArr9 = $$a;
                            Object[] objArr42 = new Object[1];
                            a((byte) 62, bArr9[68], (byte) (bArr9[15] + 1), objArr42);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cIndexOf2, iRgb2, -1456483158, false, (String) objArr42[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArr3);
                        Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                        if (objAccessartificialFrame5 == null) {
                            int offsetAfter2 = 30 - TextUtils.getOffsetAfter("", 0);
                            char cMyPid2 = (char) ((Process.myPid() >> 22) + 49362);
                            int gidForName2 = 683 - Process.getGidForName("");
                            byte[] bArr10 = $$a;
                            Object[] objArr43 = new Object[1];
                            a((byte) 74, bArr10[64], (byte) (bArr10[15] - 1), objArr43);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter2, cMyPid2, gidForName2, -1583976536, false, (String) objArr43[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf3);
                    }
                    i6 = ((int[]) objArr3[1])[0];
                    i7 = ((int[]) objArr3[0])[0];
                    if (i7 == i6) {
                        int i79 = ((int[]) objArr3[2])[0];
                        Object[] objArr44 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                        int i80 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                        int i81 = ~i80;
                        int i82 = i79 + 1766382110 + (((~(i80 | 294035695)) | (~((-8691760) | i81)) | (-969932016)) * (-68)) + ((~((-675896321) | i81)) * (-68)) + (((~((-294035696) | i81)) | (-684588080)) * 68);
                        int i83 = (i82 << 13) ^ i82;
                        int i84 = i83 ^ (i83 >>> 17);
                        i8 = 0;
                        ((int[]) objArr44[2])[0] = i84 ^ (i84 << 5);
                    } else {
                        new ArrayList().add((String) objArr3[3]);
                        long j9 = ((long) (i6 ^ i7)) ^ (((long) (-1907527305)) << 32);
                        long j10 = -1907527321;
                        int i85 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                        artificialFrame = i85 % 128;
                        int i86 = i85 % 2;
                        Object[] objArr45 = {Long.valueOf(j9), Long.valueOf(j10)};
                        byte[] bArr11 = $$d;
                        Object[] objArr46 = new Object[1];
                        c((short) 366, bArr11[571], bArr11[109], objArr46);
                        Class<?> cls5 = Class.forName((String) objArr46[0]);
                        byte b17 = bArr11[5];
                        Object[] objArr47 = new Object[1];
                        c((short) 646, b17, (byte) (b17 | 79), objArr47);
                        cls5.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
                        int i87 = ((int[]) objArr3[2])[0];
                        Object[] objArr48 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                        int i88 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                        int i89 = ~i88;
                        int i90 = i87 + 389412626 + (((~((-452993089) | i89)) | (~((-68181151) | i88)) | (~((-4456449) | i88))) * 765) + ((452993088 | (~((-521174239) | i89))) * 1530) + (((~(i88 | (-521174239))) | (~(i89 | (-4456449)))) * 765);
                        int i91 = (i90 << 13) ^ i90;
                        int i92 = i91 ^ (i91 >>> 17);
                        i8 = 0;
                        ((int[]) objArr48[2])[0] = i92 ^ (i92 << 5);
                    }
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame6 == null) {
                        int i93 = 37 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        char capsMode3 = (char) TextUtils.getCapsMode("", i8, i8);
                        int iArgb = Color.argb(i8, i8, i8, i8) + 540;
                        byte b18 = (byte) ($$b | 33);
                        byte b19 = $$a[68];
                        Object[] objArr49 = new Object[1];
                        a(b18, b19, (byte) (b19 | 35), objArr49);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i93, capsMode3, iArgb, 624296913, false, (String) objArr49[0], null);
                    }
                    j2 = ((Field) objAccessartificialFrame6).getLong(null);
                    if (j2 != -1 || j2 + 1856 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                        if (objAccessartificialFrame7 == null) {
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (39516 - Color.green(0)), 982 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                        }
                        Object[] objArr50 = {null, ((Constructor) objAccessartificialFrame7).newInstance(null), 353439643, 0};
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-501205803);
                        if (objAccessartificialFrame8 == null) {
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 36;
                            char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                            int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0') + 541;
                            byte b20 = (byte) ($$a[21] - 1);
                            Object[] objArr51 = new Object[1];
                            a((byte) 54, b20, b20, objArr51);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(maxKeyCode, cMakeMeasureSpec, iIndexOf2, 2101703389, false, (String) objArr51[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 833), 577 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (Class) ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 54, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                        }
                        objArr4 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr50);
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame9 == null) {
                            int i94 = 37 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            char c2 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            int tapTimeout = 540 - (ViewConfiguration.getTapTimeout() >> 16);
                            byte b21 = (byte) ($$b | 25);
                            byte b22 = $$a[68];
                            Object[] objArr52 = new Object[1];
                            a(b21, b22, (byte) (b22 | 35), objArr52);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i94, c2, tapTimeout, 793268735, false, (String) objArr52[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, objArr4);
                        try {
                            Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                            if (objAccessartificialFrame10 == null) {
                                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 37;
                                char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                                int gidForName3 = Process.getGidForName("") + 541;
                                byte b23 = (byte) ($$b | 33);
                                byte b24 = $$a[68];
                                Object[] objArr53 = new Object[1];
                                a(b23, b24, (byte) (b24 | 35), objArr53);
                                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cResolveOpacity, gidForName3, 624296913, false, (String) objArr53[0], null);
                            }
                            ((Field) objAccessartificialFrame10).set(null, lValueOf4);
                        } catch (Exception unused3) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame32 == null) {
                            int i95 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 35;
                            char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                            int offsetAfter3 = 540 - TextUtils.getOffsetAfter("", 0);
                            byte b25 = (byte) ($$b | 25);
                            byte b26 = $$a[68];
                            Object[] objArr54 = new Object[1];
                            a(b25, b26, (byte) (b26 | 35), objArr54);
                            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i95, offsetBefore, offsetAfter3, 793268735, false, (String) objArr54[0], null);
                        }
                        Object[] objArr55 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                        objArr4 = new Object[]{new int[1], new int[1], new int[1]};
                        int i96 = ((int[]) objArr55[2])[0];
                        int i97 = ((int[]) objArr55[1])[0];
                        ((int[]) objArr4[2])[0] = i96;
                        ((int[]) objArr4[1])[0] = i97;
                        int iMyTid = Process.myTid();
                        int i98 = ~(818877417 | iMyTid);
                        int i99 = (-1711053781) + ((251660292 | i98) * (-814)) + ((i98 | (~((~iMyTid) | (-532744333))) | 537793377) * 407) + (((~(iMyTid | 532744332)) | (~((-818877418) | iMyTid)) | 537793377) * 407) + 353439643;
                        int i100 = (i99 << 13) ^ i99;
                        int i101 = i100 ^ (i100 >>> 17);
                        ((int[]) objArr4[0])[0] = i101 ^ (i101 << 5);
                    }
                    obj = objArr4[1];
                    i9 = ((int[]) obj)[0];
                    obj2 = objArr4[2];
                    i10 = ((int[]) obj2)[0];
                    if (i10 == i9) {
                        Object[] objArr56 = {new int[1], new int[1], new int[1]};
                        int i102 = ((int[]) objArr4[0])[0];
                        int i103 = ((int[]) obj2)[0];
                        int i104 = ((int[]) obj)[0];
                        ((int[]) objArr56[2])[0] = i103;
                        ((int[]) objArr56[1])[0] = i104;
                        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1662644464;
                        int i105 = ~iCodePointAt;
                        int i106 = i102 + 41075453 + (((~(1337502694 | i105)) | 4673545) * SyslogConstants.LOG_LOCAL7) + ((iCodePointAt | 1328057184) * (-184)) + ((~((-14119056) | i105)) * SyslogConstants.LOG_LOCAL7);
                        int i107 = (i106 << 13) ^ i106;
                        int i108 = i107 ^ (i107 >>> 17);
                        ((int[]) objArr56[0])[0] = i108 ^ (i108 << 5);
                        i11 = 0;
                    } else {
                        Object[] objArr57 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-1026252794)) << 32)), Long.valueOf(-1026248698)};
                        byte[] bArr12 = $$d;
                        Object[] objArr58 = new Object[1];
                        c((short) 366, bArr12[571], bArr12[109], objArr58);
                        Class<?> cls6 = Class.forName((String) objArr58[0]);
                        byte b27 = bArr12[5];
                        Object[] objArr59 = new Object[1];
                        c((short) 646, b27, (byte) (b27 | 79), objArr59);
                        cls6.getMethod((String) objArr59[0], Long.TYPE, Long.TYPE).invoke(null, objArr57);
                        Object[] objArr60 = {new int[1], new int[1], new int[1]};
                        int i109 = ((int[]) objArr4[0])[0];
                        int i110 = ((int[]) objArr4[2])[0];
                        int i111 = ((int[]) objArr4[1])[0];
                        ((int[]) objArr60[2])[0] = i110;
                        ((int[]) objArr60[1])[0] = i111;
                        int i112 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                        int i113 = ~((-6750225) | i112);
                        int i114 = i109 + 1635912465 + ((269015649 | i113) * (-476)) + (i113 * 952) + ((~((~i112) | (-6750225))) * 476);
                        int i115 = (i114 << 13) ^ i114;
                        int i116 = i115 ^ (i115 >>> 17);
                        i11 = 0;
                        ((int[]) objArr60[0])[0] = i116 ^ (i116 << 5);
                    }
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame11 == null) {
                        int i117 = 22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char deadChar = (char) KeyEvent.getDeadChar(i11, i11);
                        int i118 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                        byte b28 = (byte) ($$b | 33);
                        byte b29 = $$a[68];
                        Object[] objArr61 = new Object[1];
                        a(b28, b29, (byte) (b29 | 35), objArr61);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i117, deadChar, i118, -785931255, false, (String) objArr61[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame11).getLong(null);
                    if (j3 != -1 || j3 + 1957 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        baseContext2 = getBaseContext();
                        if (baseContext2 == null) {
                            Object[] objArr62 = new Object[1];
                            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 11684, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr62);
                            Class<?> cls7 = Class.forName((String) objArr62[0]);
                            Object[] objArr63 = new Object[1];
                            b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41333, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr63);
                            baseContext2 = (Context) cls7.getMethod((String) objArr63[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext2 != null) {
                            if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                                baseContext2 = baseContext2.getApplicationContext();
                            } else {
                                baseContext2 = null;
                            }
                        }
                        int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr64 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 720, new char[]{37497, 37167, 37930, 39726, 40488, 40319, 32895, 34607, 35444, 35119, 35872, 45941, 46627, 46372, 47145, 49014, 41578, 41322, 42043, 43833, 44606, 44339, 53297, 55150, 55856, 55655, 56374, 49972, 50791, 50490, 51300, 53094, 62041, 61707, 62472, 64344, 65027, 64860, 57344, 59230, 59911, 59733, 60499, 4865, 5643, 5382, 6226, 7936, 585, 335, 1100, 2843, 3602, 3358, 12319, 14153, 14871, 14661, 15428, 9025, 9748, 9537, 10309, 12051}, objArr64);
                        String str6 = (String) objArr64[0];
                        Object[] objArr65 = new Object[1];
                        b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42640, new char[]{37418, 13497, 57176, 25033, 2110, 53932, 30025, 8156, 42662, 18751, 4992, 47686, 23781, 59249, 35221, 20569, 64316, 40328, 9244, 52921, 37162, 15260, 49756, 25977, 4030, 54786, 30867, 870, 42407, 19527, 5763, 47522, 16394, 60061, 36207, 22526, 65102, 32907, 11260, 62013, 38030, 16148, 49632, 26742, 12992, 54610, 31782, 1714, 43288, 29677, 6700, 48282, 18185, 61055, 45247, 23310, 64965, 33847, 12029, 61767, 39891, 8947, 50535, 28629}, objArr65);
                        String[] strArr7 = {str6, (String) objArr65[0]};
                        int i119 = artificialFrame + 89;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i119 % 128;
                        int i120 = i119 % 2;
                        Object[] objArr66 = {baseContext2, strArr7, Integer.valueOf(iIntValue2), 1, 2103983398};
                        byte[] bArr13 = $$d;
                        Object[] objArr67 = new Object[1];
                        c((short) 342, bArr13[571], (byte) (-bArr13[426]), objArr67);
                        Class<?> cls8 = Class.forName((String) objArr67[0]);
                        byte b30 = bArr13[6];
                        Object[] objArr68 = new Object[1];
                        c((short) 286, b30, b30, objArr68);
                        objArr5 = (Object[]) cls8.getMethod((String) objArr68[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr66);
                        int i121 = ((int[]) objArr5[0])[0];
                        int i122 = ((int[]) objArr5[3])[0];
                        if (baseContext2 != null) {
                            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame12 == null) {
                                int iGreen = Color.green(0) + 21;
                                char c3 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                int i123 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                                byte b31 = (byte) ($$b | 25);
                                byte b32 = $$a[68];
                                Object[] objArr69 = new Object[1];
                                a(b31, b32, (byte) (b32 | 35), objArr69);
                                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen, c3, i123, -612765161, false, (String) objArr69[0], null);
                            }
                            ((Field) objAccessartificialFrame12).set(null, objArr5);
                            try {
                                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame13 == null) {
                                    int iIndexOf4 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                                    int doubleTapTimeout2 = 465 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                                    byte b33 = (byte) ($$b | 33);
                                    byte b34 = $$a[68];
                                    Object[] objArr70 = new Object[1];
                                    a(b33, b34, (byte) (b34 | 35), objArr70);
                                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf4, minimumFlingVelocity, doubleTapTimeout2, -785931255, false, (String) objArr70[0], null);
                                }
                                ((Field) objAccessartificialFrame13).set(null, lValueOf5);
                            } catch (Exception unused4) {
                                throw new RuntimeException();
                            }
                        }
                        i12 = 0;
                    } else {
                        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame33 == null) {
                            int iMyTid2 = 21 - (Process.myTid() >> 22);
                            char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int iAxisFromString = MotionEvent.axisFromString("") + 466;
                            byte b35 = (byte) ($$b | 25);
                            byte b36 = $$a[68];
                            Object[] objArr71 = new Object[1];
                            a(b35, b36, (byte) (b36 | 35), objArr71);
                            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iMyTid2, scrollDefaultDelay, iAxisFromString, -612765161, false, (String) objArr71[0], null);
                        }
                        Object[] objArr72 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                        objArr5 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i124 = ((int[]) objArr72[3])[0];
                        int i125 = ((int[]) objArr72[0])[0];
                        String[] strArr8 = (String[]) objArr72[1];
                        int iIdentityHashCode2 = System.identityHashCode(this);
                        int i126 = (-33042467) + (((~((-124887022) | iIdentityHashCode2)) | 35462704) * (-366)) + (((~(iIdentityHashCode2 | (-90210766))) | 786448) * 366) + 2103983398;
                        int i127 = (i126 << 13) ^ i126;
                        int i128 = i127 ^ (i127 >>> 17);
                        ((int[]) objArr5[2])[0] = i128 ^ (i128 << 5);
                        i12 = 0;
                    }
                    i13 = ((int[]) objArr5[i12])[i12];
                    i14 = ((int[]) objArr5[3])[i12];
                    if (i14 == i13) {
                        Object[] objArr73 = new Object[4];
                        int[] iArr = new int[1];
                        objArr73[i12] = iArr;
                        objArr73[2] = new int[1];
                        int[] iArr2 = new int[1];
                        objArr73[3] = iArr2;
                        int i129 = ((int[]) objArr5[2])[i12];
                        int i130 = ((int[]) objArr5[3])[i12];
                        int i131 = ((int[]) objArr5[i12])[i12];
                        String[] strArr9 = (String[]) objArr5[1];
                        iArr2[i12] = i130;
                        iArr[i12] = i131;
                        int i132 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i12]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1567782793;
                        int i133 = i129 + ((((-1691498183) + (((~(777076975 | i132)) | (-937426702)) * (-948))) + ((~((~i132) | (-294567681))) * (-948))) - 1988116212);
                        int i134 = (i133 << 13) ^ i133;
                        int i135 = i134 ^ (i134 >>> 17);
                        ((int[]) objArr73[2])[0] = i135 ^ (i135 << 5);
                        objArr73[1] = strArr9;
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArr5[1];
                        if (strArr != null) {
                            int i136 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                            artificialFrame = i136 % 128;
                            int i137 = i136 % 2;
                            for (String str7 : strArr) {
                                arrayList.add(str7);
                            }
                        }
                        long j11 = ((long) (i13 ^ i14)) ^ (((long) 1083323102) << 32);
                        long j12 = 1083323038;
                        int i138 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                        artificialFrame = i138 % 128;
                        int i139 = i138 % 2;
                        Object[] objArr74 = {Long.valueOf(j11), Long.valueOf(j12)};
                        byte[] bArr14 = $$d;
                        Object[] objArr75 = new Object[1];
                        c((short) 266, bArr14[571], (byte) (-bArr14[237]), objArr75);
                        Class<?> cls9 = Class.forName((String) objArr75[0]);
                        byte b37 = bArr14[5];
                        Object[] objArr76 = new Object[1];
                        c((short) 646, b37, (byte) (b37 | 79), objArr76);
                        cls9.getMethod((String) objArr76[0], Long.TYPE, Long.TYPE).invoke(null, objArr74);
                        Object[] objArr77 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i140 = ((int[]) objArr5[2])[0];
                        int i141 = ((int[]) objArr5[3])[0];
                        int i142 = ((int[]) objArr5[0])[0];
                        String[] strArr10 = (String[]) objArr5[1];
                        int i143 = ~((int) Runtime.getRuntime().freeMemory());
                        int i144 = i140 + 1827799658 + ((~((-271487169) | i143)) * (-783)) + (((~(i143 | (-313513157))) | (-473862883)) * 783);
                        int i145 = (i144 << 13) ^ i144;
                        int i146 = i145 ^ (i145 >>> 17);
                        ((int[]) objArr77[2])[0] = i146 ^ (i146 << 5);
                    }
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame14 == null) {
                        int keyRepeatTimeout = 30 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                        int edgeSlop = 684 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte[] bArr15 = $$a;
                        byte b38 = (byte) (-bArr15[92]);
                        byte b39 = bArr15[64];
                        Object[] objArr78 = new Object[1];
                        a(b38, b39, (byte) (b39 | 37), objArr78);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cLastIndexOf2, edgeSlop, 508509282, false, (String) objArr78[0], null);
                    }
                    j4 = ((Field) objAccessartificialFrame14).getLong(null);
                    if (j4 != -1 || j4 + 1907 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        baseContext3 = getBaseContext();
                        if (baseContext3 == null) {
                            Object[] objArr79 = new Object[1];
                            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 11670, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr79);
                            Class<?> cls10 = Class.forName((String) objArr79[0]);
                            Object[] objArr80 = new Object[1];
                            b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 41332, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr80);
                            baseContext3 = (Context) cls10.getMethod((String) objArr80[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext3 != null) {
                            if (baseContext3 instanceof ContextWrapper) {
                                i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                                artificialFrame = i16 % 128;
                                if (i16 % 2 == 0) {
                                    int i147 = 88 / 0;
                                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                        baseContext3 = baseContext3.getApplicationContext();
                                    } else {
                                        baseContext3 = null;
                                    }
                                } else if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                    baseContext3 = baseContext3.getApplicationContext();
                                } else {
                                    baseContext3 = null;
                                }
                            } else {
                                baseContext3 = baseContext3.getApplicationContext();
                            }
                        }
                        Object[] objArr81 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -2032861097};
                        byte[] bArr16 = $$d;
                        Object[] objArr82 = new Object[1];
                        c((short) 228, bArr16[571], bArr16[5], objArr82);
                        Class<?> cls11 = Class.forName((String) objArr82[0]);
                        byte b40 = bArr16[6];
                        Object[] objArr83 = new Object[1];
                        c((short) 286, b40, b40, objArr83);
                        objArr6 = (Object[]) cls11.getMethod((String) objArr83[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr81);
                        if (baseContext3 != null) {
                            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame15 == null) {
                                int i148 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                                char cBlue = (char) (49362 - Color.blue(0));
                                int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                                byte[] bArr17 = $$a;
                                Object[] objArr84 = new Object[1];
                                a((byte) (bArr17[108] + 1), bArr17[30], bArr17[15], objArr84);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i148, cBlue, jumpTapTimeout2, -1321816393, false, (String) objArr84[0], null);
                            }
                            ((Field) objAccessartificialFrame15).set(null, objArr6);
                            try {
                                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                                if (objAccessartificialFrame16 == null) {
                                    int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 30;
                                    char maximumFlingVelocity = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                                    int i149 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                    byte[] bArr18 = $$a;
                                    byte b41 = (byte) (-bArr18[92]);
                                    byte b42 = bArr18[64];
                                    Object[] objArr85 = new Object[1];
                                    a(b41, b42, (byte) (b42 | 37), objArr85);
                                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, maximumFlingVelocity, i149, 508509282, false, (String) objArr85[0], null);
                                }
                                ((Field) objAccessartificialFrame16).set(null, lValueOf6);
                            } catch (Exception unused5) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame34 == null) {
                            int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                            char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49362);
                            int i150 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                            byte[] bArr19 = $$a;
                            Object[] objArr86 = new Object[1];
                            a((byte) (bArr19[108] + 1), bArr19[30], bArr19[15], objArr86);
                            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, packedPositionGroup, i150, -1321816393, false, (String) objArr86[0], null);
                        }
                        Object[] objArr87 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                        objArr6 = new Object[]{new int[]{((int[]) objArr87[0])[0]}, new int[]{((int[]) objArr87[1])[0]}, new int[1], (String) objArr87[3]};
                        int iIdentityHashCode3 = System.identityHashCode(this);
                        int i151 = (((((~((-956318349) | iIdentityHashCode3)) | 8589394) * 449) + 1965073902) + (((~((~iIdentityHashCode3) | (-956318349))) | 8589394) * 449)) - 2032861097;
                        int i152 = (i151 << 13) ^ i151;
                        int i153 = i152 ^ (i152 >>> 17);
                        ((int[]) objArr6[2])[0] = i153 ^ (i153 << 5);
                    }
                    i17 = ((int[]) objArr6[1])[0];
                    i18 = ((int[]) objArr6[0])[0];
                    if (i18 == i17) {
                        int i154 = ((int[]) objArr6[2])[0];
                        Object[] objArr88 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 889060432;
                        int i155 = ~length2;
                        int i156 = ~(171732733 | i155);
                        int i157 = i154 + (-2055194306) + ((805306368 | i156) * (-712)) + (((~(length2 | 977039101)) | (~(i155 | (-805306369)))) * (-712)) + (((-806891042) | i156) * 712);
                        int i158 = (i157 << 13) ^ i157;
                        int i159 = i158 ^ (i158 >>> 17);
                        i19 = 0;
                        ((int[]) objArr88[2])[0] = i159 ^ (i159 << 5);
                    } else {
                        Object[] objArr89 = {Long.valueOf(((long) (i17 ^ i18)) ^ (((long) (-483182149)) << 32)), Long.valueOf(-483181637)};
                        short s3 = (short) ($$e & 955);
                        byte[] bArr20 = $$d;
                        Object[] objArr90 = new Object[1];
                        c(s3, bArr20[571], bArr20[124], objArr90);
                        Class<?> cls12 = Class.forName((String) objArr90[0]);
                        byte b43 = bArr20[5];
                        Object[] objArr91 = new Object[1];
                        c((short) 646, b43, (byte) (b43 | 79), objArr91);
                        cls12.getMethod((String) objArr91[0], Long.TYPE, Long.TYPE).invoke(null, objArr89);
                        int i160 = ((int[]) objArr6[2])[0];
                        Object[] objArr92 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int i161 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                        int i162 = (-1556515874) + (((~((-986052032) | i161)) | 4280480 | (~((-7428257) | i161))) * (-754));
                        int i163 = ~((-4280481) | i161);
                        int i164 = ~i161;
                        int i165 = i160 + i162 + ((i163 | (~((-3147777) | i164))) * (-754)) + ((i164 | (-986052032)) * 754);
                        int i166 = (i165 << 13) ^ i165;
                        int i167 = i166 ^ (i166 >>> 17);
                        i19 = 0;
                        ((int[]) objArr92[2])[0] = i167 ^ (i167 << 5);
                    }
                    super.onCreate();
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame17 == null) {
                        int iGreen2 = Color.green(i19) + 25;
                        char cRed2 = (char) (Color.red(i19) + 30068);
                        int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        byte b44 = (byte) ($$b | 33);
                        byte b45 = $$a[68];
                        Object[] objArr93 = new Object[1];
                        a(b44, b45, (byte) (b45 | 35), objArr93);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen2, cRed2, maximumFlingVelocity2, 721586079, false, (String) objArr93[0], null);
                    }
                    j5 = ((Field) objAccessartificialFrame17).getLong(null);
                    if (j5 != -1 || j5 + 1969 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr94 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1520202522};
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame18 == null) {
                            int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                            char c4 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 816;
                            byte[] bArr21 = $$a;
                            Object[] objArr95 = new Object[1];
                            a(bArr21[2], bArr21[112], bArr21[39], objArr95);
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, c4, iCombineMeasuredStates2, -797394565, false, (String) objArr95[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr7 = (Object[]) ((Method) objAccessartificialFrame18).invoke(null, objArr94);
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame19 == null) {
                            int iGreen3 = 25 - Color.green(0);
                            char cArgb = (char) (30068 - Color.argb(0, 0, 0, 0));
                            int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                            byte b46 = (byte) ($$b | 25);
                            byte b47 = $$a[68];
                            Object[] objArr96 = new Object[1];
                            a(b46, b47, (byte) (b47 | 35), objArr96);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iGreen3, cArgb, keyRepeatDelay2, 891606461, false, (String) objArr96[0], null);
                        }
                        ((Field) objAccessartificialFrame19).set(null, objArr7);
                        try {
                            Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                            if (objAccessartificialFrame20 == null) {
                                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 25;
                                char c5 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 30068);
                                int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
                                byte b48 = (byte) ($$b | 33);
                                byte b49 = $$a[68];
                                Object[] objArr97 = new Object[1];
                                a(b48, b49, (byte) (b49 | 35), objArr97);
                                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, c5, iResolveSizeAndState, 721586079, false, (String) objArr97[0], null);
                            }
                            ((Field) objAccessartificialFrame20).set(null, lValueOf7);
                        } catch (Exception unused6) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame35 == null) {
                            int i168 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char threadPriority = (char) (((Process.getThreadPriority(0) + 20) >> 6) + 30068);
                            int packedPositionGroup2 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                            byte b50 = (byte) ($$b | 25);
                            byte b51 = $$a[68];
                            Object[] objArr98 = new Object[1];
                            a(b50, b51, (byte) (b51 | 35), objArr98);
                            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i168, threadPriority, packedPositionGroup2, 891606461, false, (String) objArr98[0], null);
                        }
                        Object[] objArr99 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                        objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i169 = ((int[]) objArr99[0])[0];
                        int i170 = ((int[]) objArr99[1])[0];
                        String[] strArr11 = (String[]) objArr99[2];
                        int iUptimeMillis = (int) SystemClock.uptimeMillis();
                        int i171 = ((1952139404 + (((~((~iUptimeMillis) | 975886915)) | 72360244) * 529)) + (((~(iUptimeMillis | 975886915)) | 777714549) * 529)) - 1520202522;
                        int i172 = (i171 << 13) ^ i171;
                        int i173 = i172 ^ (i172 >>> 17);
                        ((int[]) objArr7[3])[0] = i173 ^ (i173 << 5);
                    }
                    i20 = ((int[]) objArr7[1])[0];
                    i21 = ((int[]) objArr7[0])[0];
                    if (i21 == i20) {
                        int i174 = artificialFrame + 81;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i174 % 128;
                        int i175 = i174 % 2;
                        Object[] objArr100 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i176 = ((int[]) objArr7[3])[0];
                        int i177 = ((int[]) objArr7[0])[0];
                        int i178 = ((int[]) objArr7[1])[0];
                        String[] strArr12 = (String[]) objArr7[2];
                        int iIdentityHashCode4 = System.identityHashCode(this);
                        int i179 = ~iIdentityHashCode4;
                        int i180 = i176 + (-1543358171) + (((~(iIdentityHashCode4 | (-180831422))) | (~((-379003788) | i179))) * 333) + (((~(iIdentityHashCode4 | (-379003788))) | (~(i179 | (-180831422)))) * 333);
                        int i181 = (i180 << 13) ^ i180;
                        int i182 = i181 ^ (i181 >>> 17);
                        i22 = 0;
                        ((int[]) objArr100[3])[0] = i182 ^ (i182 << 5);
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArr7[2];
                        if (strArr2 != null) {
                            for (String str8 : strArr2) {
                                arrayList2.add(str8);
                            }
                        }
                        long j13 = ((long) (i20 ^ i21)) ^ (((long) 438512053) << 32);
                        long j14 = 438512052;
                        int i183 = artificialFrame + com.salesforce.marketingcloud.analytics.stats.b.i;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i183 % 128;
                        int i184 = i183 % 2;
                        Object[] objArr101 = {Long.valueOf(j13), Long.valueOf(j14)};
                        short s4 = (short) ($$e | 512);
                        byte[] bArr22 = $$d;
                        Object[] objArr102 = new Object[1];
                        c(s4, bArr22[571], bArr22[5], objArr102);
                        Class<?> cls13 = Class.forName((String) objArr102[0]);
                        byte b52 = bArr22[5];
                        Object[] objArr103 = new Object[1];
                        c((short) 646, b52, (byte) (b52 | 79), objArr103);
                        cls13.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
                        Object[] objArr104 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i185 = ((int[]) objArr7[3])[0];
                        int i186 = ((int[]) objArr7[0])[0];
                        int i187 = ((int[]) objArr7[1])[0];
                        String[] strArr13 = (String[]) objArr7[2];
                        int i188 = ~System.identityHashCode(this);
                        int i189 = i185 + ((((-1905804427) + (((~(i188 | 519038335)) | (~((-312476686) | i188))) * (-184))) + (((202367008 | (~((-514843694) | i188))) | (~(316671327 | i188))) * SyslogConstants.LOG_LOCAL7)) - 771814312);
                        int i190 = (i189 << 13) ^ i189;
                        int i191 = i190 ^ (i190 >>> 17);
                        i22 = 0;
                        ((int[]) objArr104[3])[0] = i191 ^ (i191 << 5);
                    }
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame21 == null) {
                        int offsetBefore2 = 30 - TextUtils.getOffsetBefore("", i22);
                        char c6 = (char) ((TypedValue.complexToFraction(i22, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i22, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                        int iResolveOpacity2 = 684 - Drawable.resolveOpacity(i22, i22);
                        byte[] bArr23 = $$a;
                        byte b53 = bArr23[19];
                        byte b54 = bArr23[4];
                        Object[] objArr105 = new Object[1];
                        a(b53, b54, (byte) (b54 | 40), objArr105);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c6, iResolveOpacity2, 752929587, false, (String) objArr105[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame21).getLong(null);
                    if (j6 != -1 || j6 + 1956 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr106 = new Object[1];
                            b(11718 - ExpandableListView.getPackedPositionChild(0L), new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr106);
                            Class<?> cls14 = Class.forName((String) objArr106[0]);
                            Object[] objArr107 = new Object[1];
                            b(41333 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr107);
                            baseContext4 = (Context) cls14.getMethod((String) objArr107[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if ((baseContext4 instanceof ContextWrapper) || ((ContextWrapper) baseContext4).getBaseContext() != null) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = null;
                            }
                        }
                        Object[] objArr108 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1222513847};
                        short s5 = (short) ($$e & 377);
                        byte[] bArr24 = $$d;
                        Object[] objArr109 = new Object[1];
                        c(s5, (byte) (-bArr24[89]), bArr24[5], objArr109);
                        Class<?> cls15 = Class.forName((String) objArr109[0]);
                        Object[] objArr110 = new Object[1];
                        c((short) 512, bArr24[116], bArr24[338], objArr110);
                        objArr8 = (Object[]) cls15.getMethod((String) objArr110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr108);
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-326560385);
                            if (objAccessartificialFrame22 == null) {
                                int iMyTid3 = (Process.myTid() >> 22) + 30;
                                char cRed3 = (char) (49362 - Color.red(0));
                                int longPressTimeout3 = 684 - (ViewConfiguration.getLongPressTimeout() >> 16);
                                byte[] bArr25 = $$a;
                                Object[] objArr111 = new Object[1];
                                a((byte) (bArr25[21] - 1), bArr25[4], (byte) (bArr25[15] - 1), objArr111);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iMyTid3, cRed3, longPressTimeout3, 1944867703, false, (String) objArr111[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr8);
                            try {
                                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                                if (objAccessartificialFrame23 == null) {
                                    int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 30;
                                    char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 49362);
                                    int trimmedLength = TextUtils.getTrimmedLength("") + 684;
                                    byte[] bArr26 = $$a;
                                    byte b55 = bArr26[19];
                                    byte b56 = bArr26[4];
                                    Object[] objArr112 = new Object[1];
                                    a(b55, b56, (byte) (b56 | 40), objArr112);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, cCombineMeasuredStates, trimmedLength, 752929587, false, (String) objArr112[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf8);
                            } catch (Exception unused7) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame36 == null) {
                            int iGreen4 = Color.green(0) + 30;
                            char c7 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                            int scrollDefaultDelay3 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 684;
                            byte[] bArr27 = $$a;
                            Object[] objArr113 = new Object[1];
                            a((byte) (bArr27[21] - 1), bArr27[4], (byte) (bArr27[15] - 1), objArr113);
                            objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iGreen4, c7, scrollDefaultDelay3, 1944867703, false, (String) objArr113[0], null);
                        }
                        Object[] objArr114 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                        objArr8 = new Object[]{new int[]{((int[]) objArr114[0])[0]}, new int[]{((int[]) objArr114[1])[0]}, new int[1], (String) objArr114[3]};
                        int i192 = ~(System.identityHashCode(this) | 816041509);
                        int i193 = (((-155303418) + (((-162582266) | i192) * (-220))) + ((i192 | (-968085246)) * 220)) - 821529793;
                        int i194 = (i193 << 13) ^ i193;
                        int i195 = i194 ^ (i194 >>> 17);
                        ((int[]) objArr8[2])[0] = i195 ^ (i195 << 5);
                    }
                    i24 = ((int[]) objArr8[1])[0];
                    i25 = ((int[]) objArr8[0])[0];
                    if (i25 == i24) {
                        int i196 = artificialFrame + 59;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i196 % 128;
                        int i197 = i196 % 2;
                        int i198 = ((int[]) objArr8[2])[0];
                        Object[] objArr115 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                        int i199 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 549524111;
                        int i200 = (~((-539360263) | i199)) | 2400256;
                        int i201 = ~((~i199) | 976223518);
                        int i202 = i198 + 2106744094 + ((i200 | i201) * (-470)) + (((~(i199 | (-536960007))) | i201) * 470);
                        int i203 = (i202 << 13) ^ i202;
                        int i204 = i203 ^ (i203 >>> 17);
                        ((int[]) objArr115[2])[0] = i204 ^ (i204 << 5);
                        return;
                    }
                    Object[] objArr116 = {Long.valueOf((((long) 877473600) << 32) ^ ((long) (i24 ^ i25))), Long.valueOf(877473604)};
                    byte[] bArr28 = $$d;
                    Object[] objArr117 = new Object[1];
                    c(bArr28[5], bArr28[571], bArr28[84], objArr117);
                    Class<?> cls16 = Class.forName((String) objArr117[0]);
                    byte b57 = bArr28[5];
                    Object[] objArr118 = new Object[1];
                    c((short) 646, b57, (byte) (b57 | 79), objArr118);
                    cls16.getMethod((String) objArr118[0], Long.TYPE, Long.TYPE).invoke(null, objArr116);
                    int i205 = ((int[]) objArr8[2])[0];
                    Object[] objArr119 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                    int i206 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                    int i207 = ~i206;
                    int i208 = i205 + (-1162831722) + (((~((-23778789) | i207)) | 954844986) * (-602)) + (((~(i206 | (-23778789))) | 6866208 | (~(971757566 | i207))) * (-301)) + ((~(i207 | 954844986)) * 301);
                    int i209 = (i208 << 13) ^ i208;
                    int i210 = i209 ^ (i209 >>> 17);
                    ((int[]) objArr119[2])[0] = i210 ^ (i210 << 5);
                    return;
                }
                i2 = 0;
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame37 == null) {
                    int size = View.MeasureSpec.getSize(0) + 17;
                    char offsetBefore3 = (char) TextUtils.getOffsetBefore("", 0);
                    int iIndexOf5 = 747 - TextUtils.indexOf("", "");
                    byte b58 = (byte) ($$b | 33);
                    byte b59 = $$a[68];
                    Object[] objArr120 = new Object[1];
                    a(b58, b59, (byte) (b59 | 35), objArr120);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(size, offsetBefore3, iIndexOf5, -144068856, false, (String) objArr120[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf9);
                i3 = ((int[]) objArr2[4])[0];
                i4 = ((int[]) objArr2[3])[0];
                if (i4 == i3) {
                    Object[] objArr210 = {list3, new int[1], list4, new int[]{i59}, new int[]{i60}};
                    int i510 = ((int[]) objArr2[1])[0];
                    int i511 = ((int[]) objArr2[3])[0];
                    int i610 = ((int[]) objArr2[4])[0];
                    List list7 = (List) objArr2[0];
                    List list8 = (List) objArr2[2];
                    int iIdentityHashCode5 = System.identityHashCode(this);
                    int i611 = ~iIdentityHashCode5;
                    int i612 = i510 + 1856825234 + (((~((-603246241) | i611)) | (~(603315945 | iIdentityHashCode5))) * (-831)) + ((~((-601113729) | iIdentityHashCode5)) * (-1662)) + (((~(iIdentityHashCode5 | 603246240)) | (~(i611 | (-2202218))) | (~(2202217 | iIdentityHashCode5))) * 831);
                    int i613 = (i612 << 13) ^ i612;
                    int i614 = i613 ^ (i613 >>> 17);
                    i5 = 0;
                    ((int[]) objArr210[1])[0] = i614 ^ (i614 << 5);
                } else {
                    ArrayList arrayList5 = new ArrayList();
                    Object[] objArr211 = {objArr2};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 42, (char) (View.resolveSize(0, 0) + 12468), 3642 - TextUtils.indexOf("", "", 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame).invoke(null, objArr211));
                    Object[] objArr212 = {objArr2};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 42, (char) (Color.blue(0) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame2).invoke(null, objArr212));
                    Object[] objArr313 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) 480970455) << 32)), Long.valueOf(480970463)};
                    short s6 = (short) FacebookRequestErrorClassification.ESC_APP_INACTIVE;
                    byte[] bArr29 = $$d;
                    Object[] objArr314 = new Object[1];
                    c(s6, bArr29[571], bArr29[39], objArr314);
                    Class<?> cls17 = Class.forName((String) objArr314[0]);
                    byte b110 = bArr29[5];
                    Object[] objArr315 = new Object[1];
                    c((short) 646, b110, (byte) (b110 | 79), objArr315);
                    cls17.getMethod((String) objArr315[0], Long.TYPE, Long.TYPE).invoke(null, objArr313);
                    Object[] objArr316 = {list5, new int[1], list6, new int[]{i66}, new int[]{i67}};
                    int i615 = ((int[]) objArr2[1])[0];
                    int i616 = ((int[]) objArr2[3])[0];
                    int i617 = ((int[]) objArr2[4])[0];
                    List list9 = (List) objArr2[0];
                    List list10 = (List) objArr2[2];
                    int i618 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                    int i619 = i615 + (((~((-196829482) | i618)) | 60841993) * (-283)) + 643863292 + ((~(i618 | (-135987489))) * 283);
                    int i710 = (i619 << 13) ^ i619;
                    int i711 = i710 ^ (i710 >>> 17);
                    i5 = 0;
                    ((int[]) objArr316[1])[0] = i711 ^ (i711 << 5);
                }
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame3 == null) {
                    int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', i5) + 31;
                    char cLastIndexOf3 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                    int capsMode4 = TextUtils.getCapsMode("", i5, i5) + 684;
                    byte[] bArr30 = $$a;
                    Object[] objArr317 = new Object[1];
                    a((byte) 74, bArr30[64], (byte) (bArr30[15] - 1), objArr317);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf6, cLastIndexOf3, capsMode4, -1583976536, false, (String) objArr317[0], null);
                }
                j = ((Field) objAccessartificialFrame3).getLong(null);
                if (j != -1) {
                    int i712 = artificialFrame + 11;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i712 % 128;
                    int i713 = i712 % 2;
                    if (j + 1988 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame24 == null) {
                            int iResolveOpacity3 = 30 - Drawable.resolveOpacity(0, 0);
                            char modifierMetaStateMask2 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int i714 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                            byte[] bArr31 = $$a;
                            Object[] objArr318 = new Object[1];
                            a((byte) 62, bArr31[68], (byte) (bArr31[15] + 1), objArr318);
                            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iResolveOpacity3, modifierMetaStateMask2, i714, -1456483158, false, (String) objArr318[0], null);
                        }
                        Object[] objArr319 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                        objArr3 = new Object[]{new int[]{((int[]) objArr319[0])[0]}, new int[]{((int[]) objArr319[1])[0]}, new int[1], (String) objArr319[3]};
                        int ringerMode2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
                        int i715 = ~ringerMode2;
                        int i716 = (((2121344902 + (((~(967475198 | i715)) | 11148576) * 220)) + (((~(i715 | 27934196)) | 950689578) * (-440))) + ((ringerMode2 | 967475198) * 220)) - 1086630373;
                        int i717 = (i716 << 13) ^ i716;
                        int i718 = i717 ^ (i717 >>> 17);
                        ((int[]) objArr3[2])[0] = i718 ^ (i718 << 5);
                    } else {
                        Object[] objArr3110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1086630373};
                        byte[] bArr32 = $$d;
                        byte b111 = bArr32[571];
                        Object[] objArr3111 = new Object[1];
                        c((short) 421, b111, (byte) (b111 & 234), objArr3111);
                        Class<?> cls18 = Class.forName((String) objArr3111[0]);
                        Object[] objArr3112 = new Object[1];
                        c((short) 382, bArr32[571], (byte) (-bArr32[22]), objArr3112);
                        objArr3 = (Object[]) cls18.getMethod((String) objArr3112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr3110);
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame4 == null) {
                            int longPressTimeout4 = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                            char cIndexOf3 = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                            int iRgb3 = Color.rgb(0, 0, 0) + 16777900;
                            byte[] bArr33 = $$a;
                            Object[] objArr410 = new Object[1];
                            a((byte) 62, bArr33[68], (byte) (bArr33[15] + 1), objArr410);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout4, cIndexOf3, iRgb3, -1456483158, false, (String) objArr410[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArr3);
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                        if (objAccessartificialFrame5 == null) {
                            int offsetAfter4 = 30 - TextUtils.getOffsetAfter("", 0);
                            char cMyPid3 = (char) ((Process.myPid() >> 22) + 49362);
                            int gidForName4 = 683 - Process.getGidForName("");
                            byte[] bArr110 = $$a;
                            Object[] objArr411 = new Object[1];
                            a((byte) 74, bArr110[64], (byte) (bArr110[15] - 1), objArr411);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter4, cMyPid3, gidForName4, -1583976536, false, (String) objArr411[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf10);
                    }
                } else {
                    Object[] objArr3113 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1086630373};
                    byte[] bArr34 = $$d;
                    byte b112 = bArr34[571];
                    Object[] objArr3114 = new Object[1];
                    c((short) 421, b112, (byte) (b112 & 234), objArr3114);
                    Class<?> cls19 = Class.forName((String) objArr3114[0]);
                    Object[] objArr3115 = new Object[1];
                    c((short) 382, bArr34[571], (byte) (-bArr34[22]), objArr3115);
                    objArr3 = (Object[]) cls19.getMethod((String) objArr3115[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr3113);
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame4 == null) {
                        int longPressTimeout5 = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
                        char cIndexOf4 = (char) (TextUtils.indexOf("", "", 0, 0) + 49362);
                        int iRgb4 = Color.rgb(0, 0, 0) + 16777900;
                        byte[] bArr35 = $$a;
                        Object[] objArr412 = new Object[1];
                        a((byte) 62, bArr35[68], (byte) (bArr35[15] + 1), objArr412);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout5, cIndexOf4, iRgb4, -1456483158, false, (String) objArr412[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArr3);
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame5 == null) {
                        int offsetAfter5 = 30 - TextUtils.getOffsetAfter("", 0);
                        char cMyPid4 = (char) ((Process.myPid() >> 22) + 49362);
                        int gidForName5 = 683 - Process.getGidForName("");
                        byte[] bArr111 = $$a;
                        Object[] objArr413 = new Object[1];
                        a((byte) 74, bArr111[64], (byte) (bArr111[15] - 1), objArr413);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter5, cMyPid4, gidForName5, -1583976536, false, (String) objArr413[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf11);
                }
                i6 = ((int[]) objArr3[1])[0];
                i7 = ((int[]) objArr3[0])[0];
                if (i7 == i6) {
                    int i719 = ((int[]) objArr3[2])[0];
                    Object[] objArr414 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                    int i810 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                    int i811 = ~i810;
                    int i812 = i719 + 1766382110 + (((~(i810 | 294035695)) | (~((-8691760) | i811)) | (-969932016)) * (-68)) + ((~((-675896321) | i811)) * (-68)) + (((~((-294035696) | i811)) | (-684588080)) * 68);
                    int i813 = (i812 << 13) ^ i812;
                    int i814 = i813 ^ (i813 >>> 17);
                    i8 = 0;
                    ((int[]) objArr414[2])[0] = i814 ^ (i814 << 5);
                } else {
                    new ArrayList().add((String) objArr3[3]);
                    long j15 = ((long) (i6 ^ i7)) ^ (((long) (-1907527305)) << 32);
                    long j16 = -1907527321;
                    int i815 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i815 % 128;
                    int i816 = i815 % 2;
                    Object[] objArr415 = {Long.valueOf(j15), Long.valueOf(j16)};
                    byte[] bArr112 = $$d;
                    Object[] objArr416 = new Object[1];
                    c((short) 366, bArr112[571], bArr112[109], objArr416);
                    Class<?> cls20 = Class.forName((String) objArr416[0]);
                    byte b113 = bArr112[5];
                    Object[] objArr417 = new Object[1];
                    c((short) 646, b113, (byte) (b113 | 79), objArr417);
                    cls20.getMethod((String) objArr417[0], Long.TYPE, Long.TYPE).invoke(null, objArr415);
                    int i817 = ((int[]) objArr3[2])[0];
                    Object[] objArr418 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                    int i818 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                    int i819 = ~i818;
                    int i910 = i817 + 389412626 + (((~((-452993089) | i819)) | (~((-68181151) | i818)) | (~((-4456449) | i818))) * 765) + ((452993088 | (~((-521174239) | i819))) * 1530) + (((~(i818 | (-521174239))) | (~(i819 | (-4456449)))) * 765);
                    int i911 = (i910 << 13) ^ i910;
                    int i912 = i911 ^ (i911 >>> 17);
                    i8 = 0;
                    ((int[]) objArr418[2])[0] = i912 ^ (i912 << 5);
                }
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame6 == null) {
                    int i913 = 37 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    char capsMode5 = (char) TextUtils.getCapsMode("", i8, i8);
                    int iArgb2 = Color.argb(i8, i8, i8, i8) + 540;
                    byte b114 = (byte) ($$b | 33);
                    byte b115 = $$a[68];
                    Object[] objArr419 = new Object[1];
                    a(b114, b115, (byte) (b115 | 35), objArr419);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i913, capsMode5, iArgb2, 624296913, false, (String) objArr419[0], null);
                }
                j2 = ((Field) objAccessartificialFrame6).getLong(null);
                if (j2 != -1) {
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                    if (objAccessartificialFrame7 == null) {
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (39516 - Color.green(0)), 982 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                    }
                    Object[] objArr510 = {null, ((Constructor) objAccessartificialFrame7).newInstance(null), 353439643, 0};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-501205803);
                    if (objAccessartificialFrame8 == null) {
                        int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 36;
                        char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0') + 541;
                        byte b210 = (byte) ($$a[21] - 1);
                        Object[] objArr511 = new Object[1];
                        a((byte) 54, b210, b210, objArr511);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cMakeMeasureSpec2, iIndexOf7, 2101703389, false, (String) objArr511[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 833), 577 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (Class) ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 54, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                    }
                    objArr4 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr510);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame9 == null) {
                        int i914 = 37 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char c8 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int tapTimeout2 = 540 - (ViewConfiguration.getTapTimeout() >> 16);
                        byte b211 = (byte) ($$b | 25);
                        byte b212 = $$a[68];
                        Object[] objArr512 = new Object[1];
                        a(b211, b212, (byte) (b212 | 35), objArr512);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i914, c8, tapTimeout2, 793268735, false, (String) objArr512[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArr4);
                    Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame10 == null) {
                        int iIndexOf8 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 37;
                        char cResolveOpacity2 = (char) Drawable.resolveOpacity(0, 0);
                        int gidForName6 = Process.getGidForName("") + 541;
                        byte b213 = (byte) ($$b | 33);
                        byte b214 = $$a[68];
                        Object[] objArr513 = new Object[1];
                        a(b213, b214, (byte) (b214 | 35), objArr513);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf8, cResolveOpacity2, gidForName6, 624296913, false, (String) objArr513[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf12);
                } else {
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                    if (objAccessartificialFrame7 == null) {
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(20 - (Process.myPid() >> 22), (char) (39516 - Color.green(0)), 982 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                    }
                    Object[] objArr514 = {null, ((Constructor) objAccessartificialFrame7).newInstance(null), 353439643, 0};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-501205803);
                    if (objAccessartificialFrame8 == null) {
                        int maxKeyCode3 = (KeyEvent.getMaxKeyCode() >> 16) + 36;
                        char cMakeMeasureSpec3 = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iIndexOf9 = TextUtils.indexOf((CharSequence) "", '0') + 541;
                        byte b215 = (byte) ($$a[21] - 1);
                        Object[] objArr515 = new Object[1];
                        a((byte) 54, b215, b215, objArr515);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(maxKeyCode3, cMakeMeasureSpec3, iIndexOf9, 2101703389, false, (String) objArr515[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(55 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 833), 577 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (Class) ArtificialStackFrames.coroutineCreation(Drawable.resolveOpacity(0, 0) + 54, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 630), Integer.TYPE, Integer.TYPE});
                    }
                    objArr4 = (Object[]) ((Method) objAccessartificialFrame8).invoke(null, objArr514);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame9 == null) {
                        int i915 = 37 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char c9 = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int tapTimeout3 = 540 - (ViewConfiguration.getTapTimeout() >> 16);
                        byte b216 = (byte) ($$b | 25);
                        byte b217 = $$a[68];
                        Object[] objArr516 = new Object[1];
                        a(b216, b217, (byte) (b217 | 35), objArr516);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i915, c9, tapTimeout3, 793268735, false, (String) objArr516[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArr4);
                    Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame10 == null) {
                        int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 37;
                        char cResolveOpacity3 = (char) Drawable.resolveOpacity(0, 0);
                        int gidForName7 = Process.getGidForName("") + 541;
                        byte b218 = (byte) ($$b | 33);
                        byte b219 = $$a[68];
                        Object[] objArr517 = new Object[1];
                        a(b218, b219, (byte) (b219 | 35), objArr517);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf10, cResolveOpacity3, gidForName7, 624296913, false, (String) objArr517[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf13);
                }
                obj = objArr4[1];
                i9 = ((int[]) obj)[0];
                obj2 = objArr4[2];
                i10 = ((int[]) obj2)[0];
                if (i10 == i9) {
                    Object[] objArr518 = {new int[1], new int[1], new int[1]};
                    int i1010 = ((int[]) objArr4[0])[0];
                    int i1011 = ((int[]) obj2)[0];
                    int i1012 = ((int[]) obj)[0];
                    ((int[]) objArr518[2])[0] = i1011;
                    ((int[]) objArr518[1])[0] = i1012;
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1662644464;
                    int i1013 = ~iCodePointAt2;
                    int i1014 = i1010 + 41075453 + (((~(1337502694 | i1013)) | 4673545) * SyslogConstants.LOG_LOCAL7) + ((iCodePointAt2 | 1328057184) * (-184)) + ((~((-14119056) | i1013)) * SyslogConstants.LOG_LOCAL7);
                    int i1015 = (i1014 << 13) ^ i1014;
                    int i1016 = i1015 ^ (i1015 >>> 17);
                    ((int[]) objArr518[0])[0] = i1016 ^ (i1016 << 5);
                    i11 = 0;
                } else {
                    Object[] objArr519 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-1026252794)) << 32)), Long.valueOf(-1026248698)};
                    byte[] bArr113 = $$d;
                    Object[] objArr520 = new Object[1];
                    c((short) 366, bArr113[571], bArr113[109], objArr520);
                    Class<?> cls21 = Class.forName((String) objArr520[0]);
                    byte b220 = bArr113[5];
                    Object[] objArr521 = new Object[1];
                    c((short) 646, b220, (byte) (b220 | 79), objArr521);
                    cls21.getMethod((String) objArr521[0], Long.TYPE, Long.TYPE).invoke(null, objArr519);
                    Object[] objArr610 = {new int[1], new int[1], new int[1]};
                    int i1017 = ((int[]) objArr4[0])[0];
                    int i1110 = ((int[]) objArr4[2])[0];
                    int i1111 = ((int[]) objArr4[1])[0];
                    ((int[]) objArr610[2])[0] = i1110;
                    ((int[]) objArr610[1])[0] = i1111;
                    int i1112 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                    int i1113 = ~((-6750225) | i1112);
                    int i1114 = i1017 + 1635912465 + ((269015649 | i1113) * (-476)) + (i1113 * 952) + ((~((~i1112) | (-6750225))) * 476);
                    int i1115 = (i1114 << 13) ^ i1114;
                    int i1116 = i1115 ^ (i1115 >>> 17);
                    i11 = 0;
                    ((int[]) objArr610[0])[0] = i1116 ^ (i1116 << 5);
                }
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame11 == null) {
                    int i1117 = 22 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char deadChar2 = (char) KeyEvent.getDeadChar(i11, i11);
                    int i1118 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                    byte b221 = (byte) ($$b | 33);
                    byte b222 = $$a[68];
                    Object[] objArr611 = new Object[1];
                    a(b221, b222, (byte) (b222 | 35), objArr611);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1117, deadChar2, i1118, -785931255, false, (String) objArr611[0], null);
                }
                j3 = ((Field) objAccessartificialFrame11).getLong(null);
                if (j3 != -1) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr612 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 11684, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr612);
                        Class<?> cls22 = Class.forName((String) objArr612[0]);
                        Object[] objArr613 = new Object[1];
                        b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41333, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr613);
                        baseContext2 = (Context) cls22.getMethod((String) objArr613[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr614 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 720, new char[]{37497, 37167, 37930, 39726, 40488, 40319, 32895, 34607, 35444, 35119, 35872, 45941, 46627, 46372, 47145, 49014, 41578, 41322, 42043, 43833, 44606, 44339, 53297, 55150, 55856, 55655, 56374, 49972, 50791, 50490, 51300, 53094, 62041, 61707, 62472, 64344, 65027, 64860, 57344, 59230, 59911, 59733, 60499, 4865, 5643, 5382, 6226, 7936, 585, 335, 1100, 2843, 3602, 3358, 12319, 14153, 14871, 14661, 15428, 9025, 9748, 9537, 10309, 12051}, objArr614);
                    String str9 = (String) objArr614[0];
                    Object[] objArr615 = new Object[1];
                    b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42640, new char[]{37418, 13497, 57176, 25033, 2110, 53932, 30025, 8156, 42662, 18751, 4992, 47686, 23781, 59249, 35221, 20569, 64316, 40328, 9244, 52921, 37162, 15260, 49756, 25977, 4030, 54786, 30867, 870, 42407, 19527, 5763, 47522, 16394, 60061, 36207, 22526, 65102, 32907, 11260, 62013, 38030, 16148, 49632, 26742, 12992, 54610, 31782, 1714, 43288, 29677, 6700, 48282, 18185, 61055, 45247, 23310, 64965, 33847, 12029, 61767, 39891, 8947, 50535, 28629}, objArr615);
                    String[] strArr14 = {str9, (String) objArr615[0]};
                    int i1119 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1119 % 128;
                    int i1210 = i1119 % 2;
                    Object[] objArr616 = {baseContext2, strArr14, Integer.valueOf(iIntValue3), 1, 2103983398};
                    byte[] bArr114 = $$d;
                    Object[] objArr617 = new Object[1];
                    c((short) 342, bArr114[571], (byte) (-bArr114[426]), objArr617);
                    Class<?> cls23 = Class.forName((String) objArr617[0]);
                    byte b310 = bArr114[6];
                    Object[] objArr618 = new Object[1];
                    c((short) 286, b310, b310, objArr618);
                    objArr5 = (Object[]) cls23.getMethod((String) objArr618[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr616);
                    int i1211 = ((int[]) objArr5[0])[0];
                    int i1212 = ((int[]) objArr5[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame12 == null) {
                            int iGreen5 = Color.green(0) + 21;
                            char c10 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int i1213 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                            byte b311 = (byte) ($$b | 25);
                            byte b312 = $$a[68];
                            Object[] objArr619 = new Object[1];
                            a(b311, b312, (byte) (b312 | 35), objArr619);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen5, c10, i1213, -612765161, false, (String) objArr619[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr5);
                        Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame13 == null) {
                            int iIndexOf11 = 21 - TextUtils.indexOf("", "", 0, 0);
                            char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            int doubleTapTimeout3 = 465 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            byte b313 = (byte) ($$b | 33);
                            byte b314 = $$a[68];
                            Object[] objArr710 = new Object[1];
                            a(b313, b314, (byte) (b314 | 35), objArr710);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf11, minimumFlingVelocity2, doubleTapTimeout3, -785931255, false, (String) objArr710[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf14);
                    }
                    i12 = 0;
                } else {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr6110 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 11684, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr6110);
                        Class<?> cls24 = Class.forName((String) objArr6110[0]);
                        Object[] objArr6111 = new Object[1];
                        b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 41333, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr6111);
                        baseContext2 = (Context) cls24.getMethod((String) objArr6111[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr6112 = new Object[1];
                    b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 720, new char[]{37497, 37167, 37930, 39726, 40488, 40319, 32895, 34607, 35444, 35119, 35872, 45941, 46627, 46372, 47145, 49014, 41578, 41322, 42043, 43833, 44606, 44339, 53297, 55150, 55856, 55655, 56374, 49972, 50791, 50490, 51300, 53094, 62041, 61707, 62472, 64344, 65027, 64860, 57344, 59230, 59911, 59733, 60499, 4865, 5643, 5382, 6226, 7936, 585, 335, 1100, 2843, 3602, 3358, 12319, 14153, 14871, 14661, 15428, 9025, 9748, 9537, 10309, 12051}, objArr6112);
                    String str10 = (String) objArr6112[0];
                    Object[] objArr6113 = new Object[1];
                    b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42640, new char[]{37418, 13497, 57176, 25033, 2110, 53932, 30025, 8156, 42662, 18751, 4992, 47686, 23781, 59249, 35221, 20569, 64316, 40328, 9244, 52921, 37162, 15260, 49756, 25977, 4030, 54786, 30867, 870, 42407, 19527, 5763, 47522, 16394, 60061, 36207, 22526, 65102, 32907, 11260, 62013, 38030, 16148, 49632, 26742, 12992, 54610, 31782, 1714, 43288, 29677, 6700, 48282, 18185, 61055, 45247, 23310, 64965, 33847, 12029, 61767, 39891, 8947, 50535, 28629}, objArr6113);
                    String[] strArr15 = {str10, (String) objArr6113[0]};
                    int i11110 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i11110 % 128;
                    int i1214 = i11110 % 2;
                    Object[] objArr6114 = {baseContext2, strArr15, Integer.valueOf(iIntValue4), 1, 2103983398};
                    byte[] bArr115 = $$d;
                    Object[] objArr6115 = new Object[1];
                    c((short) 342, bArr115[571], (byte) (-bArr115[426]), objArr6115);
                    Class<?> cls25 = Class.forName((String) objArr6115[0]);
                    byte b315 = bArr115[6];
                    Object[] objArr6116 = new Object[1];
                    c((short) 286, b315, b315, objArr6116);
                    objArr5 = (Object[]) cls25.getMethod((String) objArr6116[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr6114);
                    int i1215 = ((int[]) objArr5[0])[0];
                    int i1216 = ((int[]) objArr5[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame12 == null) {
                            int iGreen6 = Color.green(0) + 21;
                            char c11 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int i1217 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 464;
                            byte b316 = (byte) ($$b | 25);
                            byte b317 = $$a[68];
                            Object[] objArr6117 = new Object[1];
                            a(b316, b317, (byte) (b317 | 35), objArr6117);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen6, c11, i1217, -612765161, false, (String) objArr6117[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr5);
                        Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame13 == null) {
                            int iIndexOf12 = 21 - TextUtils.indexOf("", "", 0, 0);
                            char minimumFlingVelocity3 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            int doubleTapTimeout4 = 465 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            byte b318 = (byte) ($$b | 33);
                            byte b319 = $$a[68];
                            Object[] objArr711 = new Object[1];
                            a(b318, b319, (byte) (b319 | 35), objArr711);
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iIndexOf12, minimumFlingVelocity3, doubleTapTimeout4, -785931255, false, (String) objArr711[0], null);
                        }
                        ((Field) objAccessartificialFrame13).set(null, lValueOf15);
                    }
                    i12 = 0;
                }
                i13 = ((int[]) objArr5[i12])[i12];
                i14 = ((int[]) objArr5[3])[i12];
                if (i14 == i13) {
                    Object[] objArr712 = new Object[4];
                    int[] iArr3 = new int[1];
                    objArr712[i12] = iArr3;
                    objArr712[2] = new int[1];
                    int[] iArr4 = new int[1];
                    objArr712[3] = iArr4;
                    int i1218 = ((int[]) objArr5[2])[i12];
                    int i1310 = ((int[]) objArr5[3])[i12];
                    int i1311 = ((int[]) objArr5[i12])[i12];
                    String[] strArr16 = (String[]) objArr5[1];
                    iArr4[i12] = i1310;
                    iArr3[i12] = i1311;
                    int i1312 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i12]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1567782793;
                    int i1313 = i1218 + ((((-1691498183) + (((~(777076975 | i1312)) | (-937426702)) * (-948))) + ((~((~i1312) | (-294567681))) * (-948))) - 1988116212);
                    int i1314 = (i1313 << 13) ^ i1313;
                    int i1315 = i1314 ^ (i1314 >>> 17);
                    ((int[]) objArr712[2])[0] = i1315 ^ (i1315 << 5);
                    objArr712[1] = strArr16;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr5[1];
                    if (strArr != null) {
                        int i1316 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                        artificialFrame = i1316 % 128;
                        int i1317 = i1316 % 2;
                        while (i15 < strArr.length) {
                            arrayList.add(str7);
                        }
                    }
                    long j17 = ((long) (i13 ^ i14)) ^ (((long) 1083323102) << 32);
                    long j18 = 1083323038;
                    int i1318 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                    artificialFrame = i1318 % 128;
                    int i1319 = i1318 % 2;
                    Object[] objArr713 = {Long.valueOf(j17), Long.valueOf(j18)};
                    byte[] bArr116 = $$d;
                    Object[] objArr714 = new Object[1];
                    c((short) 266, bArr116[571], (byte) (-bArr116[237]), objArr714);
                    Class<?> cls26 = Class.forName((String) objArr714[0]);
                    byte b320 = bArr116[5];
                    Object[] objArr715 = new Object[1];
                    c((short) 646, b320, (byte) (b320 | 79), objArr715);
                    cls26.getMethod((String) objArr715[0], Long.TYPE, Long.TYPE).invoke(null, objArr713);
                    Object[] objArr716 = {new int[]{i142}, strArr10, new int[1], new int[]{i141}};
                    int i1410 = ((int[]) objArr5[2])[0];
                    int i1411 = ((int[]) objArr5[3])[0];
                    int i1412 = ((int[]) objArr5[0])[0];
                    String[] strArr17 = (String[]) objArr5[1];
                    int i1413 = ~((int) Runtime.getRuntime().freeMemory());
                    int i1414 = i1410 + 1827799658 + ((~((-271487169) | i1413)) * (-783)) + (((~(i1413 | (-313513157))) | (-473862883)) * 783);
                    int i1415 = (i1414 << 13) ^ i1414;
                    int i1416 = i1415 ^ (i1415 >>> 17);
                    ((int[]) objArr716[2])[0] = i1416 ^ (i1416 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame14 == null) {
                    int keyRepeatTimeout2 = 30 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    char cLastIndexOf4 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                    int edgeSlop2 = 684 - (ViewConfiguration.getEdgeSlop() >> 16);
                    byte[] bArr117 = $$a;
                    byte b321 = (byte) (-bArr117[92]);
                    byte b322 = bArr117[64];
                    Object[] objArr717 = new Object[1];
                    a(b321, b322, (byte) (b322 | 37), objArr717);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, cLastIndexOf4, edgeSlop2, 508509282, false, (String) objArr717[0], null);
                }
                j4 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j4 != -1) {
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr718 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 11670, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr718);
                        Class<?> cls110 = Class.forName((String) objArr718[0]);
                        Object[] objArr810 = new Object[1];
                        b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 41332, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr810);
                        baseContext3 = (Context) cls110.getMethod((String) objArr810[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        if (baseContext3 instanceof ContextWrapper) {
                            i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                            artificialFrame = i16 % 128;
                            if (i16 % 2 == 0) {
                                int i1417 = 88 / 0;
                                if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                    baseContext3 = baseContext3.getApplicationContext();
                                } else {
                                    baseContext3 = null;
                                }
                            } else if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                baseContext3 = baseContext3.getApplicationContext();
                            } else {
                                baseContext3 = null;
                            }
                        } else {
                            baseContext3 = baseContext3.getApplicationContext();
                        }
                    }
                    Object[] objArr811 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -2032861097};
                    byte[] bArr118 = $$d;
                    Object[] objArr812 = new Object[1];
                    c((short) 228, bArr118[571], bArr118[5], objArr812);
                    Class<?> cls111 = Class.forName((String) objArr812[0]);
                    byte b410 = bArr118[6];
                    Object[] objArr813 = new Object[1];
                    c((short) 286, b410, b410, objArr813);
                    objArr6 = (Object[]) cls111.getMethod((String) objArr813[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr811);
                    if (baseContext3 != null) {
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame15 == null) {
                            int i1418 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                            char cBlue2 = (char) (49362 - Color.blue(0));
                            int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                            byte[] bArr119 = $$a;
                            Object[] objArr814 = new Object[1];
                            a((byte) (bArr119[108] + 1), bArr119[30], bArr119[15], objArr814);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i1418, cBlue2, jumpTapTimeout3, -1321816393, false, (String) objArr814[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr6);
                        Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame16 == null) {
                            int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 30;
                            char maximumFlingVelocity3 = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                            int i1419 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            byte[] bArr120 = $$a;
                            byte b411 = (byte) (-bArr120[92]);
                            byte b412 = bArr120[64];
                            Object[] objArr815 = new Object[1];
                            a(b411, b412, (byte) (b412 | 37), objArr815);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(absoluteGravity4, maximumFlingVelocity3, i1419, 508509282, false, (String) objArr815[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf16);
                    }
                } else {
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr719 = new Object[1];
                        b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 11670, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr719);
                        Class<?> cls112 = Class.forName((String) objArr719[0]);
                        Object[] objArr816 = new Object[1];
                        b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 41332, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr816);
                        baseContext3 = (Context) cls112.getMethod((String) objArr816[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        if (baseContext3 instanceof ContextWrapper) {
                            i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                            artificialFrame = i16 % 128;
                            if (i16 % 2 == 0) {
                                int i14110 = 88 / 0;
                                if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                    baseContext3 = baseContext3.getApplicationContext();
                                } else {
                                    baseContext3 = null;
                                }
                            } else if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                baseContext3 = baseContext3.getApplicationContext();
                            } else {
                                baseContext3 = null;
                            }
                        } else {
                            baseContext3 = baseContext3.getApplicationContext();
                        }
                    }
                    Object[] objArr817 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -2032861097};
                    byte[] bArr1110 = $$d;
                    Object[] objArr818 = new Object[1];
                    c((short) 228, bArr1110[571], bArr1110[5], objArr818);
                    Class<?> cls113 = Class.forName((String) objArr818[0]);
                    byte b413 = bArr1110[6];
                    Object[] objArr819 = new Object[1];
                    c((short) 286, b413, b413, objArr819);
                    objArr6 = (Object[]) cls113.getMethod((String) objArr819[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr817);
                    if (baseContext3 != null) {
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame15 == null) {
                            int i14111 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29;
                            char cBlue3 = (char) (49362 - Color.blue(0));
                            int jumpTapTimeout4 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                            byte[] bArr1111 = $$a;
                            Object[] objArr8110 = new Object[1];
                            a((byte) (bArr1111[108] + 1), bArr1111[30], bArr1111[15], objArr8110);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i14111, cBlue3, jumpTapTimeout4, -1321816393, false, (String) objArr8110[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr6);
                        Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame16 == null) {
                            int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0) + 30;
                            char maximumFlingVelocity4 = (char) (49362 - (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                            int i14112 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            byte[] bArr121 = $$a;
                            byte b414 = (byte) (-bArr121[92]);
                            byte b415 = bArr121[64];
                            Object[] objArr8111 = new Object[1];
                            a(b414, b415, (byte) (b415 | 37), objArr8111);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(absoluteGravity5, maximumFlingVelocity4, i14112, 508509282, false, (String) objArr8111[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf17);
                    }
                }
                i17 = ((int[]) objArr6[1])[0];
                i18 = ((int[]) objArr6[0])[0];
                if (i18 == i17) {
                    int i1510 = ((int[]) objArr6[2])[0];
                    Object[] objArr820 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 889060432;
                    int i1511 = ~length3;
                    int i1512 = ~(171732733 | i1511);
                    int i1513 = i1510 + (-2055194306) + ((805306368 | i1512) * (-712)) + (((~(length3 | 977039101)) | (~(i1511 | (-805306369)))) * (-712)) + (((-806891042) | i1512) * 712);
                    int i1514 = (i1513 << 13) ^ i1513;
                    int i1515 = i1514 ^ (i1514 >>> 17);
                    i19 = 0;
                    ((int[]) objArr820[2])[0] = i1515 ^ (i1515 << 5);
                } else {
                    Object[] objArr821 = {Long.valueOf(((long) (i17 ^ i18)) ^ (((long) (-483182149)) << 32)), Long.valueOf(-483181637)};
                    short s7 = (short) ($$e & 955);
                    byte[] bArr210 = $$d;
                    Object[] objArr910 = new Object[1];
                    c(s7, bArr210[571], bArr210[124], objArr910);
                    Class<?> cls114 = Class.forName((String) objArr910[0]);
                    byte b416 = bArr210[5];
                    Object[] objArr911 = new Object[1];
                    c((short) 646, b416, (byte) (b416 | 79), objArr911);
                    cls114.getMethod((String) objArr911[0], Long.TYPE, Long.TYPE).invoke(null, objArr821);
                    int i1610 = ((int[]) objArr6[2])[0];
                    Object[] objArr912 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int i1611 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                    int i1612 = (-1556515874) + (((~((-986052032) | i1611)) | 4280480 | (~((-7428257) | i1611))) * (-754));
                    int i1613 = ~((-4280481) | i1611);
                    int i1614 = ~i1611;
                    int i1615 = i1610 + i1612 + ((i1613 | (~((-3147777) | i1614))) * (-754)) + ((i1614 | (-986052032)) * 754);
                    int i1616 = (i1615 << 13) ^ i1615;
                    int i1617 = i1616 ^ (i1616 >>> 17);
                    i19 = 0;
                    ((int[]) objArr912[2])[0] = i1617 ^ (i1617 << 5);
                }
                super.onCreate();
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame17 == null) {
                    int iGreen7 = Color.green(i19) + 25;
                    char cRed4 = (char) (Color.red(i19) + 30068);
                    int maximumFlingVelocity5 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b417 = (byte) ($$b | 33);
                    byte b418 = $$a[68];
                    Object[] objArr913 = new Object[1];
                    a(b417, b418, (byte) (b418 | 35), objArr913);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iGreen7, cRed4, maximumFlingVelocity5, 721586079, false, (String) objArr913[0], null);
                }
                j5 = ((Field) objAccessartificialFrame17).getLong(null);
                if (j5 != -1) {
                    Object[] objArr914 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1520202522};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame18 == null) {
                        int scrollDefaultDelay4 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                        char c12 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 816;
                        byte[] bArr211 = $$a;
                        Object[] objArr915 = new Object[1];
                        a(bArr211[2], bArr211[112], bArr211[39], objArr915);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay4, c12, iCombineMeasuredStates3, -797394565, false, (String) objArr915[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame18).invoke(null, objArr914);
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame19 == null) {
                        int iGreen8 = 25 - Color.green(0);
                        char cArgb2 = (char) (30068 - Color.argb(0, 0, 0, 0));
                        int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte b419 = (byte) ($$b | 25);
                        byte b420 = $$a[68];
                        Object[] objArr916 = new Object[1];
                        a(b419, b420, (byte) (b420 | 35), objArr916);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iGreen8, cArgb2, keyRepeatDelay3, 891606461, false, (String) objArr916[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, objArr7);
                    Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame20 == null) {
                        int iNormalizeMetaState3 = KeyEvent.normalizeMetaState(0) + 25;
                        char c13 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 30068);
                        int iResolveSizeAndState2 = 816 - View.resolveSizeAndState(0, 0, 0);
                        byte b421 = (byte) ($$b | 33);
                        byte b422 = $$a[68];
                        Object[] objArr917 = new Object[1];
                        a(b421, b422, (byte) (b422 | 35), objArr917);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState3, c13, iResolveSizeAndState2, 721586079, false, (String) objArr917[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf18);
                } else {
                    Object[] objArr918 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1520202522};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame18 == null) {
                        int scrollDefaultDelay5 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 25;
                        char c14 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iCombineMeasuredStates4 = View.combineMeasuredStates(0, 0) + 816;
                        byte[] bArr212 = $$a;
                        Object[] objArr919 = new Object[1];
                        a(bArr212[2], bArr212[112], bArr212[39], objArr919);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay5, c14, iCombineMeasuredStates4, -797394565, false, (String) objArr919[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame18).invoke(null, objArr918);
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame19 == null) {
                        int iGreen9 = 25 - Color.green(0);
                        char cArgb3 = (char) (30068 - Color.argb(0, 0, 0, 0));
                        int keyRepeatDelay4 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte b4110 = (byte) ($$b | 25);
                        byte b423 = $$a[68];
                        Object[] objArr9110 = new Object[1];
                        a(b4110, b423, (byte) (b423 | 35), objArr9110);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iGreen9, cArgb3, keyRepeatDelay4, 891606461, false, (String) objArr9110[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, objArr7);
                    Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame20 == null) {
                        int iNormalizeMetaState4 = KeyEvent.normalizeMetaState(0) + 25;
                        char c15 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 30068);
                        int iResolveSizeAndState3 = 816 - View.resolveSizeAndState(0, 0, 0);
                        byte b424 = (byte) ($$b | 33);
                        byte b425 = $$a[68];
                        Object[] objArr9111 = new Object[1];
                        a(b424, b425, (byte) (b425 | 35), objArr9111);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState4, c15, iResolveSizeAndState3, 721586079, false, (String) objArr9111[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf19);
                }
                i20 = ((int[]) objArr7[1])[0];
                i21 = ((int[]) objArr7[0])[0];
                if (i21 == i20) {
                    int i1710 = artificialFrame + 81;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1710 % 128;
                    int i1711 = i1710 % 2;
                    Object[] objArr1010 = {new int[]{i177}, new int[]{i178}, strArr12, new int[1]};
                    int i1712 = ((int[]) objArr7[3])[0];
                    int i1713 = ((int[]) objArr7[0])[0];
                    int i1714 = ((int[]) objArr7[1])[0];
                    String[] strArr18 = (String[]) objArr7[2];
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i1715 = ~iIdentityHashCode6;
                    int i1810 = i1712 + (-1543358171) + (((~(iIdentityHashCode6 | (-180831422))) | (~((-379003788) | i1715))) * 333) + (((~(iIdentityHashCode6 | (-379003788))) | (~(i1715 | (-180831422)))) * 333);
                    int i1811 = (i1810 << 13) ^ i1810;
                    int i1812 = i1811 ^ (i1811 >>> 17);
                    i22 = 0;
                    ((int[]) objArr1010[3])[0] = i1812 ^ (i1812 << 5);
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr7[2];
                    if (strArr2 != null) {
                        while (i23 < strArr2.length) {
                            arrayList2.add(str8);
                        }
                    }
                    long j19 = ((long) (i20 ^ i21)) ^ (((long) 438512053) << 32);
                    long j110 = 438512052;
                    int i1813 = artificialFrame + com.salesforce.marketingcloud.analytics.stats.b.i;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1813 % 128;
                    int i1814 = i1813 % 2;
                    Object[] objArr1011 = {Long.valueOf(j19), Long.valueOf(j110)};
                    short s8 = (short) ($$e | 512);
                    byte[] bArr213 = $$d;
                    Object[] objArr1012 = new Object[1];
                    c(s8, bArr213[571], bArr213[5], objArr1012);
                    Class<?> cls115 = Class.forName((String) objArr1012[0]);
                    byte b510 = bArr213[5];
                    Object[] objArr1013 = new Object[1];
                    c((short) 646, b510, (byte) (b510 | 79), objArr1013);
                    cls115.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                    Object[] objArr1014 = {new int[]{i186}, new int[]{i187}, strArr13, new int[1]};
                    int i1815 = ((int[]) objArr7[3])[0];
                    int i1816 = ((int[]) objArr7[0])[0];
                    int i1817 = ((int[]) objArr7[1])[0];
                    String[] strArr19 = (String[]) objArr7[2];
                    int i1818 = ~System.identityHashCode(this);
                    int i1819 = i1815 + ((((-1905804427) + (((~(i1818 | 519038335)) | (~((-312476686) | i1818))) * (-184))) + (((202367008 | (~((-514843694) | i1818))) | (~(316671327 | i1818))) * SyslogConstants.LOG_LOCAL7)) - 771814312);
                    int i1910 = (i1819 << 13) ^ i1819;
                    int i1911 = i1910 ^ (i1910 >>> 17);
                    i22 = 0;
                    ((int[]) objArr1014[3])[0] = i1911 ^ (i1911 << 5);
                }
                objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame21 == null) {
                    int offsetBefore4 = 30 - TextUtils.getOffsetBefore("", i22);
                    char c16 = (char) ((TypedValue.complexToFraction(i22, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i22, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                    int iResolveOpacity4 = 684 - Drawable.resolveOpacity(i22, i22);
                    byte[] bArr214 = $$a;
                    byte b511 = bArr214[19];
                    byte b512 = bArr214[4];
                    Object[] objArr1015 = new Object[1];
                    a(b511, b512, (byte) (b512 | 40), objArr1015);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(offsetBefore4, c16, iResolveOpacity4, 752929587, false, (String) objArr1015[0], null);
                }
                j6 = ((Field) objAccessartificialFrame21).getLong(null);
                if (j6 != -1) {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr1016 = new Object[1];
                        b(11718 - ExpandableListView.getPackedPositionChild(0L), new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr1016);
                        Class<?> cls116 = Class.forName((String) objArr1016[0]);
                        Object[] objArr1017 = new Object[1];
                        b(41333 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr1017);
                        baseContext4 = (Context) cls116.getMethod((String) objArr1017[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr1018 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1222513847};
                    short s9 = (short) ($$e & 377);
                    byte[] bArr215 = $$d;
                    Object[] objArr1019 = new Object[1];
                    c(s9, (byte) (-bArr215[89]), bArr215[5], objArr1019);
                    Class<?> cls117 = Class.forName((String) objArr1019[0]);
                    Object[] objArr1110 = new Object[1];
                    c((short) 512, bArr215[116], bArr215[338], objArr1110);
                    objArr8 = (Object[]) cls117.getMethod((String) objArr1110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1018);
                    if (baseContext4 != null) {
                        objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame22 == null) {
                            int iMyTid4 = (Process.myTid() >> 22) + 30;
                            char cRed5 = (char) (49362 - Color.red(0));
                            int longPressTimeout6 = 684 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            byte[] bArr216 = $$a;
                            Object[] objArr1111 = new Object[1];
                            a((byte) (bArr216[21] - 1), bArr216[4], (byte) (bArr216[15] - 1), objArr1111);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iMyTid4, cRed5, longPressTimeout6, 1944867703, false, (String) objArr1111[0], null);
                        }
                        ((Field) objAccessartificialFrame22).set(null, objArr8);
                        Long lValueOf20 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame23 == null) {
                            int absoluteGravity6 = Gravity.getAbsoluteGravity(0, 0) + 30;
                            char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 49362);
                            int trimmedLength2 = TextUtils.getTrimmedLength("") + 684;
                            byte[] bArr217 = $$a;
                            byte b513 = bArr217[19];
                            byte b514 = bArr217[4];
                            Object[] objArr1112 = new Object[1];
                            a(b513, b514, (byte) (b514 | 40), objArr1112);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(absoluteGravity6, cCombineMeasuredStates2, trimmedLength2, 752929587, false, (String) objArr1112[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, lValueOf20);
                    }
                } else {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr10110 = new Object[1];
                        b(11718 - ExpandableListView.getPackedPositionChild(0L), new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr10110);
                        Class<?> cls118 = Class.forName((String) objArr10110[0]);
                        Object[] objArr10111 = new Object[1];
                        b(41333 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr10111);
                        baseContext4 = (Context) cls118.getMethod((String) objArr10111[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr10112 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1222513847};
                    short s10 = (short) ($$e & 377);
                    byte[] bArr218 = $$d;
                    Object[] objArr10113 = new Object[1];
                    c(s10, (byte) (-bArr218[89]), bArr218[5], objArr10113);
                    Class<?> cls119 = Class.forName((String) objArr10113[0]);
                    Object[] objArr1113 = new Object[1];
                    c((short) 512, bArr218[116], bArr218[338], objArr1113);
                    objArr8 = (Object[]) cls119.getMethod((String) objArr1113[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr10112);
                    if (baseContext4 != null) {
                        objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame22 == null) {
                            int iMyTid5 = (Process.myTid() >> 22) + 30;
                            char cRed6 = (char) (49362 - Color.red(0));
                            int longPressTimeout7 = 684 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            byte[] bArr219 = $$a;
                            Object[] objArr1114 = new Object[1];
                            a((byte) (bArr219[21] - 1), bArr219[4], (byte) (bArr219[15] - 1), objArr1114);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iMyTid5, cRed6, longPressTimeout7, 1944867703, false, (String) objArr1114[0], null);
                        }
                        ((Field) objAccessartificialFrame22).set(null, objArr8);
                        Long lValueOf21 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame23 == null) {
                            int absoluteGravity7 = Gravity.getAbsoluteGravity(0, 0) + 30;
                            char cCombineMeasuredStates3 = (char) (View.combineMeasuredStates(0, 0) + 49362);
                            int trimmedLength3 = TextUtils.getTrimmedLength("") + 684;
                            byte[] bArr2110 = $$a;
                            byte b515 = bArr2110[19];
                            byte b516 = bArr2110[4];
                            Object[] objArr1115 = new Object[1];
                            a(b515, b516, (byte) (b516 | 40), objArr1115);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(absoluteGravity7, cCombineMeasuredStates3, trimmedLength3, 752929587, false, (String) objArr1115[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, lValueOf21);
                    }
                }
                i24 = ((int[]) objArr8[1])[0];
                i25 = ((int[]) objArr8[0])[0];
                if (i25 == i24) {
                    int i1912 = artificialFrame + 59;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1912 % 128;
                    int i1913 = i1912 % 2;
                    int i1914 = ((int[]) objArr8[2])[0];
                    Object[] objArr1116 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                    int i1915 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 549524111;
                    int i2010 = (~((-539360263) | i1915)) | 2400256;
                    int i2011 = ~((~i1915) | 976223518);
                    int i2012 = i1914 + 2106744094 + ((i2010 | i2011) * (-470)) + (((~(i1915 | (-536960007))) | i2011) * 470);
                    int i2013 = (i2012 << 13) ^ i2012;
                    int i2014 = i2013 ^ (i2013 >>> 17);
                    ((int[]) objArr1116[2])[0] = i2014 ^ (i2014 << 5);
                    return;
                }
                Object[] objArr1117 = {Long.valueOf((((long) 877473600) << 32) ^ ((long) (i24 ^ i25))), Long.valueOf(877473604)};
                byte[] bArr220 = $$d;
                Object[] objArr1118 = new Object[1];
                c(bArr220[5], bArr220[571], bArr220[84], objArr1118);
                Class<?> cls120 = Class.forName((String) objArr1118[0]);
                byte b517 = bArr220[5];
                Object[] objArr1119 = new Object[1];
                c((short) 646, b517, (byte) (b517 | 79), objArr1119);
                cls120.getMethod((String) objArr1119[0], Long.TYPE, Long.TYPE).invoke(null, objArr1117);
                int i2015 = ((int[]) objArr8[2])[0];
                Object[] objArr1120 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                int i2016 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                int i2017 = ~i2016;
                int i2018 = i2015 + (-1162831722) + (((~((-23778789) | i2017)) | 954844986) * (-602)) + (((~(i2016 | (-23778789))) | 6866208 | (~(971757566 | i2017))) * (-301)) + ((~(i2017 | 954844986)) * 301);
                int i2019 = (i2018 << 13) ^ i2018;
                int i211 = i2019 ^ (i2019 >>> 17);
                ((int[]) objArr1120[2])[0] = i211 ^ (i211 << 5);
                return;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
            Object[] objArr121 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1908764334};
            byte[] bArr36 = $$d;
            Object[] objArr122 = new Object[1];
            c((short) 559, bArr36[571], bArr36[755], objArr122);
            Class<?> cls27 = Class.forName((String) objArr122[0]);
            Object[] objArr123 = new Object[1];
            c((short) 512, bArr36[116], bArr36[338], objArr123);
            objArr2 = (Object[]) cls27.getMethod((String) objArr123[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr121);
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame38 == null) {
                int i212 = 17 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char keyRepeatDelay5 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int i213 = 748 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                byte b60 = (byte) ($$b | 25);
                byte b61 = $$a[68];
                Object[] objArr124 = new Object[1];
                a(b60, b61, (byte) (b61 | 35), objArr124);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i212, keyRepeatDelay5, i213, -1031537386, false, (String) objArr124[0], null);
            }
            ((Field) objAccessartificialFrame38).set(null, objArr2);
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
        baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr125 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i2]).invoke(null, null)).getApplicationContext().getPackageName().length() + 11698, new char[]{37502, 49078, 51701, 6968, 9580, 30357, 32977, 53824, 64582, 2448, 23465, 26044, 46858, 49511, 4745, 15583, 19993, 38977, 42389, 63395, 455, 21284, 32119, 36507, 55510, 59924}, objArr125);
            Class<?> cls28 = Class.forName((String) objArr125[0]);
            Object[] objArr126 = new Object[1];
            b(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 41284, new char[]{37500, 13087, 53383, 30258, 6062, 46392, 23253, 63597, 39367, 16242, 56545, 25201, 768, 41103, 17933, 59309, 34080, 10932}, objArr126);
            baseContext = (Context) cls28.getMethod((String) objArr126[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            int i214 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i214 % 128;
            if (i214 % 2 != 0) {
                boolean z = baseContext instanceof ContextWrapper;
                Object obj3 = null;
                obj3.hashCode();
                throw null;
            }
            baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
        }
    }

    static void accessartificialFrame() {
        extraCommand = 1206727590267857424L;
    }
}
