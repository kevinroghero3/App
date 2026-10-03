package com.salesforce.marketingcloud;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.JobIntentService$JobWorkEnqueuer$$ExternalSyntheticApiModelOutline1;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
abstract class c extends Service {
    private static char[] ArtificialStackFrames;
    private static char coroutineCreation;
    static final String h;
    static final Object i;
    static final HashMap<ComponentName, h> j;
    final ArrayList<d> a;
    b b;
    h c;
    a d;
    boolean e;
    boolean f;
    boolean g;
    private static final byte[] $$l = {106, -29, -101, -119};
    private static final int $$m = 58;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$j = {91, 68, -61, -13, -3, -4, -19, -7, -3, 54, -2, -66, -12, -13, 8, -20, -3, 6, -18, 55, -73, -3, 4, -26, 7, -16, -10, -2, 56, -58, -20, 3, -21, -4, -1, -2, 47, -29, -40, -8, -6, -20, -7, 6, -6, 10, -35, 5, -15, -1, -22, 44, -42, -4, -22, -11, 8, -20, -7, -68, -19, -5, 56, -64, -15, -7, 1, -12, 0, 48, -60, -22, -14, 2, -11, -2, 58, -77, 4, -12, -4, 54, -58, -11, -3, -10, 47, -26, -43, -21, 39, -35, -30, 38, -33, -27, 78, -20};
    private static final int $$k = 129;
    private static final byte[] $$d = {5, Ascii.ESC, -76, Ascii.CR, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$e = com.salesforce.marketingcloud.analytics.stats.b.l;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            e eVarA;
            try {
                com.salesforce.marketingcloud.g.a(c.h, "Starting to dequeue work...", new Object[0]);
                while (!isCancelled() && (eVarA = c.this.a()) != null) {
                    String str = c.h;
                    com.salesforce.marketingcloud.g.a(str, "Processing next work: action=%s", eVarA.b().getAction());
                    c.this.a(eVarA.b());
                    com.salesforce.marketingcloud.g.a(str, "Completing work: action=%s", eVarA.b().getAction());
                    eVarA.a();
                }
                com.salesforce.marketingcloud.g.a(c.h, "Done processing work!", new Object[0]);
                return null;
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(c.h, e, "Exception thrown by JobIntentService", new Object[0]);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Void r1) {
            c.this.e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
            c.this.e();
        }
    }

    interface b {
        e a();

        IBinder b();
    }

    final class d implements e {
        final Intent a;
        final int b;

        d(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // com.salesforce.marketingcloud.c.e
        public void a() {
            com.salesforce.marketingcloud.g.a(c.h, "Stopping self: #%d", Integer.valueOf(this.b));
            c.this.stopSelf(this.b);
        }

        @Override // com.salesforce.marketingcloud.c.e
        public Intent b() {
            return this.a;
        }
    }

    interface e {
        void a();

        Intent b();
    }

    static final class f extends JobServiceEngine implements b {
        static final String d = com.salesforce.marketingcloud.g.a("JobServiceEngineImpl");
        final c a;
        final Object b;
        JobParameters c;

        final class a implements e {
            final JobWorkItem a;

            a(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }

            @Override // com.salesforce.marketingcloud.c.e
            public void a() {
                synchronized (f.this.b) {
                    JobParameters jobParameters = f.this.c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.a);
                    }
                }
            }

            @Override // com.salesforce.marketingcloud.c.e
            public Intent b() {
                return this.a.getIntent();
            }
        }

        f(c cVar) {
            super(cVar);
            this.b = new Object();
            this.a = cVar;
        }

        @Override // com.salesforce.marketingcloud.c.b
        public e a() {
            synchronized (this.b) {
                JobParameters jobParameters = this.c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // com.salesforce.marketingcloud.c.b
        public IBinder b() {
            return getBinder();
        }

        public boolean onStartJob(JobParameters jobParameters) {
            com.salesforce.marketingcloud.g.a(d, "onStartJob: extras=%s", jobParameters.getExtras());
            this.c = jobParameters;
            this.a.a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            if (Build.VERSION.SDK_INT >= 31) {
                com.salesforce.marketingcloud.g.a(d, "onStopJob: extras=%s stopReason=%d", jobParameters.getExtras(), Integer.valueOf(jobParameters.getStopReason()));
            } else {
                com.salesforce.marketingcloud.g.a(d, "onStopJob: extras=%s", jobParameters.getExtras());
            }
            boolean zB = this.a.b();
            synchronized (this.b) {
                this.c = null;
            }
            return zB;
        }
    }

    static final class g extends h {
        private final JobInfo d;
        private final JobScheduler e;

        g(Context context, ComponentName componentName, int i) {
            super(componentName);
            a(i);
            this.d = new JobInfo.Builder(i, this.a).setOverrideDeadline(0L).build();
            this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // com.salesforce.marketingcloud.c.h
        void a(Intent intent) {
            com.salesforce.marketingcloud.g.a(c.h, "Enqueueing work: %s", intent);
            try {
                JobScheduler jobScheduler = this.e;
                JobInfo jobInfo = this.d;
                c$g$$ExternalSyntheticApiModelOutline0.m();
                jobScheduler.enqueue(jobInfo, JobIntentService$JobWorkEnqueuer$$ExternalSyntheticApiModelOutline1.m(intent));
            } catch (Exception e) {
                com.salesforce.marketingcloud.g.b(c.h, e, "Unable to enqueue %s for work %s", Integer.valueOf(this.c), intent);
            }
        }
    }

    static abstract class h {
        final ComponentName a;
        boolean b;
        int c;

        h(ComponentName componentName) {
            this.a = componentName;
        }

        public void a() {
        }

        abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }

        void a(int i) {
            if (!this.b) {
                this.b = true;
                this.c = i;
            } else {
                if (this.c == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.c);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$n(int r7, byte r8, byte r9) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.c.$$l
            int r7 = 105 - r7
            int r9 = r9 * 3
            int r9 = 1 - r9
            int r8 = r8 * 4
            int r8 = 3 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r7 = r8
            r3 = r9
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r6
        L2a:
            int r8 = r8 + r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.c.$$n(int, byte, byte):java.lang.String");
    }

    static {
        accessartificialFrame();
        h = com.salesforce.marketingcloud.g.a("JobIntentService");
        i = new Object();
        j = new HashMap<>();
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = null;
        } else {
            this.a = new ArrayList<>();
        }
    }

    public static void a(@NonNull Context context, @NonNull Class cls, int i2, @NonNull Intent intent) {
        a(context, new ComponentName(context, (Class<?>) cls), i2, intent);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void w(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 8
            int r6 = r6 + 4
            int r7 = r7 * 28
            int r7 = 112 - r7
            byte[] r0 = com.salesforce.marketingcloud.c.$$d
            int r8 = r8 * 3
            int r1 = 12 - r8
            byte[] r1 = new byte[r1]
            int r8 = 11 - r8
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2e
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2e:
            int r7 = -r7
            int r7 = r7 + r3
            int r6 = r6 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.c.w(short, short, int, java.lang.Object[]):void");
    }

    private static void y(int i2, int i3, int i4, Object[] objArr) {
        int i5 = i4 * 4;
        int i6 = (i2 * 3) + 36;
        int i7 = i3 + 4;
        byte[] bArr = $$j;
        byte[] bArr2 = new byte[i5 + 3];
        int i8 = i5 + 2;
        int i9 = -1;
        if (bArr == null) {
            i6 = (i7 + (-i6)) - 7;
            i7 = i7;
            i9 = -1;
        }
        while (true) {
            int i10 = i7 + 1;
            int i11 = i9 + 1;
            bArr2[i11] = (byte) i6;
            if (i11 == i8) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i6 = (i6 + (-bArr[i10])) - 7;
            i7 = i10;
            i9 = i11;
        }
    }

    protected abstract void a(@NonNull Intent intent);

    public void b(boolean z) {
        this.e = z;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return true;
    }

    void e() {
        ArrayList<d> arrayList = this.a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.d = null;
                ArrayList<d> arrayList2 = this.a;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    a(false);
                } else if (!this.g) {
                    this.c.a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        IBinder iBinderB = bVar.b();
        com.salesforce.marketingcloud.g.a(h, "Returning engine: %s", iBinderB);
        return iBinderB;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.salesforce.marketingcloud.g.a(h, "CREATING: %s", this);
        if (Build.VERSION.SDK_INT >= 26) {
            this.b = new f(this);
            this.c = null;
        } else {
            this.b = null;
            this.c = a((Context) this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        ArrayList<d> arrayList = this.a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.g = true;
                this.c.a();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.a == null) {
            com.salesforce.marketingcloud.g.a(h, "Ignoring start command: %s", intent);
            return 2;
        }
        this.c.c();
        com.salesforce.marketingcloud.g.a(h, "Received compat start command #%d: %s", Integer.valueOf(i3), intent);
        synchronized (this.a) {
            ArrayList<d> arrayList = this.a;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            a(true);
        }
        return 3;
    }

    public static void a(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (i) {
            h hVarA = a(context, componentName, true, i2);
            hVarA.a(i2);
            hVarA.a(intent);
        }
    }

    boolean b() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel(this.e);
        }
        this.f = true;
        return d();
    }

    static h a(Context context, ComponentName componentName, boolean z, int i2) {
        h c0070c;
        HashMap<ComponentName, h> map = j;
        h hVar = map.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            c0070c = new C0070c(context, componentName);
        } else if (z) {
            c0070c = new g(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar2 = c0070c;
        map.put(componentName, hVar2);
        return hVar2;
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.c$c, reason: collision with other inner class name */
    static final class C0070c extends h {
        private final Context d;
        private final PowerManager.WakeLock e;
        private final PowerManager.WakeLock f;
        boolean g;
        boolean h;

        C0070c(Context context, ComponentName componentName) {
            super(componentName);
            this.d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // com.salesforce.marketingcloud.c.h
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.a);
            com.salesforce.marketingcloud.g.a(c.h, "Starting service for work: %s", intent);
            if (this.d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // com.salesforce.marketingcloud.c.h
        public void b() {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
                    this.e.release();
                }
            }
        }

        @Override // com.salesforce.marketingcloud.c.h
        public void c() {
            synchronized (this) {
                this.g = false;
            }
        }

        @Override // com.salesforce.marketingcloud.c.h
        public void a() {
            synchronized (this) {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(60000L);
                    }
                    this.h = false;
                    this.f.release();
                }
            }
        }
    }

    void a(boolean z) {
        if (this.d == null) {
            this.d = new a();
            h hVar = this.c;
            if (hVar != null && z) {
                hVar.b();
            }
            com.salesforce.marketingcloud.g.a(h, "Starting processor: %s", this.d);
            this.d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    e a() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.a();
        }
        synchronized (this.a) {
            if (this.a.size() <= 0) {
                return null;
            }
            return this.a.remove(0);
        }
    }

    private static void x(byte b2, int i2, char[] cArr, Object[] objArr) throws Throwable {
        int i3;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        char c = '0';
        int i5 = -1819279892;
        if (cArr2 != null) {
            int i6 = $10 + 115;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i8])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 15, (char) (AndroidCharacter.getMirror(c) + 20440), 2147 - ExpandableListView.getPackedPositionChild(0L), 216710116, false, $$n((byte) ($$m & 12), b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i8++;
                    c = '0';
                    i5 = -1819279892;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i9 = $10 + 65;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            cArr2 = cArr3;
        }
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            byte b4 = (byte) 0;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(14 - TextUtils.indexOf((CharSequence) "", '0'), (char) (20488 - TextUtils.getOffsetBefore("", 0)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2148, 216710116, false, $$n((byte) ($$m & 12), b4, b4), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i2];
        if (i2 % 2 != 0) {
            int i11 = $10;
            int i12 = i11 + 67;
            $11 = i12 % 128;
            if (i12 % 2 == 0) {
                i3 = i2 + 91;
                cArr4[i3] = (char) (cArr[i3] % b2);
            } else {
                i3 = i2 - 1;
                cArr4[i3] = (char) (cArr[i3] - b2);
            }
            int i13 = i11 + com.salesforce.marketingcloud.analytics.stats.b.i;
            $11 = i13 % 128;
            int i14 = i13 % 2;
        } else {
            i3 = i2;
        }
        if (i3 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i3) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b2);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b2);
                } else {
                    try {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 3;
                            byte b6 = (byte) (b5 - 3);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 46, (char) (KeyEvent.getDeadChar(0, 0) + 58859), 2464 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 276640984, false, $$n(b5, b6, b6), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i15 = $10 + 1;
                            $11 = i15 % 128;
                            int i16 = i15 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = b7;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 792, -834291897, false, $$n(b7, b8, b8), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i17 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i17];
                        } else if (extracallback.b == extracallback.d) {
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i18 = (extracallback.b * cCharValue) + extracallback.j;
                            int i19 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i18];
                            cArr4[extracallback.a + 1] = cArr2[i19];
                        } else {
                            int i20 = (extracallback.b * cCharValue) + extracallback.g;
                            int i21 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i20];
                            cArr4[extracallback.a + 1] = cArr2[i21];
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
            }
        }
        for (int i22 = 0; i22 < i2; i22++) {
            int i23 = $11 + 49;
            $10 = i23 % 128;
            int i24 = i23 % 2;
            cArr4[i22] = (char) (cArr4[i22] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:16:0x027f A[Catch: all -> 0x0b09, TryCatch #0 {all -> 0x0b09, blocks: (B:55:0x07df, B:57:0x07ff, B:58:0x084a, B:14:0x026b, B:16:0x027f, B:17:0x02b1), top: B:95:0x026b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:25:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:54:0x0740  */
    /* JADX WARN: Code duplicated, block: B:57:0x07ff A[Catch: all -> 0x0b09, TryCatch #0 {all -> 0x0b09, blocks: (B:55:0x07df, B:57:0x07ff, B:58:0x084a, B:14:0x026b, B:16:0x027f, B:17:0x02b1), top: B:95:0x026b }] */
    /* JADX WARN: Code duplicated, block: B:61:0x085c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0948  */
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
        int i2 = 2 % 2;
        int i3 = artificialFrame + 73;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
        int i4 = i3 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int iResolveSize = 26 - View.resolveSize(0, 0);
            char mode = (char) View.MeasureSpec.getMode(0);
            int mode2 = View.MeasureSpec.getMode(0) + 1041;
            byte b2 = $$d[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            w(b3, b3, b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize, mode, mode2, 2061780482, false, (String) objArr2[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 != -1) {
            long j3 = j2 + 4611686018427387790L;
            Object[] objArr3 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 34), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 90), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr4);
            if (j3 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                artificialFrame = i5 % 128;
                int i6 = i5 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iMyPid = (Process.myPid() >> 22) + 26;
                    char c = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i7 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    byte b4 = $$d[5];
                    byte b5 = b4;
                    Object[] objArr5 = new Object[1];
                    w(b5, (byte) (b5 - 1), b4, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyPid, c, i7, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i8 = ((int[]) objArr6[3])[0];
                int i9 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iMyTid = Process.myTid();
                int i10 = (-1844322660) + (((~((-4722689) | (~iMyTid))) | (-73381119)) * (-591)) + ((iMyTid | (-4722689)) * 591) + 1456507323;
                int i11 = (i10 << 13) ^ i10;
                int i12 = i11 ^ (i11 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i12 ^ (i12 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 74), ((byte) KeyEvent.getModifierMetaStateMask()) + 17, new char[]{4, 18, 16, 15, 2, 7, 15, 14, 2, 20, 17, 19, '\t', 22, 24, 1}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 15, new char[]{'\f', '\n', 20, 11, 21, 14, 23, 19, '\t', 15, '\b', 5, 18, 3, 11, 24}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-1904116427};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22251), (ViewConfiguration.getEdgeSlop() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1456507323, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                        char c2 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int i13 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                        byte b6 = $$d[5];
                        byte b7 = b6;
                        Object[] objArr10 = new Object[1];
                        w(b7, (byte) (b7 - 1), b6, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(longPressTimeout, c2, i13, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 21), (ViewConfiguration.getLongPressTimeout() >> 16) + 22, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 29), 14 - TextUtils.lastIndexOf("", '0', 0), new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                            char c3 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                            int iMyTid2 = (Process.myTid() >> 22) + 1041;
                            byte b8 = $$d[5];
                            byte b9 = (byte) (b8 - 1);
                            Object[] objArr13 = new Object[1];
                            w(b9, b9, b8, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf, c3, iMyTid2, 2061780482, false, (String) objArr13[0], null);
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
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 74), ((byte) KeyEvent.getModifierMetaStateMask()) + 17, new char[]{4, 18, 16, 15, 2, 7, 15, 14, 2, 20, 17, 19, '\t', 22, 24, 1}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 24), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 15, new char[]{'\f', '\n', 20, 11, 21, 14, 23, 19, '\t', 15, '\b', 5, 18, 3, 11, 24}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-1904116427};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22251), (ViewConfiguration.getEdgeSlop() >> 16) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1456507323, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                char c4 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int i14 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
                byte b10 = $$d[5];
                byte b11 = b10;
                Object[] objArr17 = new Object[1];
                w(b11, (byte) (b11 - 1), b10, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, c4, i14, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 21), (ViewConfiguration.getLongPressTimeout() >> 16) + 22, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 29), 14 - TextUtils.lastIndexOf("", '0', 0), new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                char c5 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int iMyTid3 = (Process.myTid() >> 22) + 1041;
                byte b12 = $$d[5];
                byte b13 = (byte) (b12 - 1);
                Object[] objArr110 = new Object[1];
                w(b13, b13, b12, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c5, iMyTid3, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i16 == i15) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i19 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i20 = ~System.identityHashCode(this);
            int i21 = i17 + 1988546842 + (((-8885441) | i20) * 494) + (((~(i20 | (-15718353))) | 91769631) * 494);
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr20[1])[0] = i23 ^ (i23 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i24 = 0;
                while (i24 < strArr3.length) {
                    int i25 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                    if (i25 % 2 != 0) {
                        arrayList.add(strArr3[i24]);
                        i24 += 53;
                    } else {
                        arrayList.add(strArr3[i24]);
                        i24++;
                    }
                    int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i26 % 128;
                    int i27 = i26 % 2;
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) (-1450269385)) << 32)), Long.valueOf(-1450269387)};
                byte[] bArr = $$j;
                Object[] objArr22 = new Object[1];
                y((byte) 25, bArr[34], (byte) (-bArr[3]), objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b14 = bArr[68];
                byte b15 = b14;
                Object[] objArr23 = new Object[1];
                y(b15, (byte) (b15 | 53), b14, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i30 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i31 = i28 + 103087658 + (((~(iMaxMemory | 674121029)) | 596017222) * (-668)) + ((674121029 | (~(596017222 | iMaxMemory))) * 1336) + ((iMaxMemory | 732874055) * 668);
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
            int iArgb = Color.argb(0, 0, 0, 0) + 25;
            char keyRepeatTimeout = (char) (30068 - (ViewConfiguration.getKeyRepeatTimeout() >> 16));
            int packedPositionGroup = 816 - ExpandableListView.getPackedPositionGroup(0L);
            byte b16 = $$d[5];
            byte b17 = (byte) (b16 - 1);
            Object[] objArr25 = new Object[1];
            w(b17, b17, b16, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iArgb, keyRepeatTimeout, packedPositionGroup, 721586079, false, (String) objArr25[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j4 != -1) {
            long j5 = j4 + 1884;
            Object[] objArr26 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 31), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr27);
            if (j5 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 26;
                    char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                    int iAxisFromString = 815 - MotionEvent.axisFromString("");
                    byte b18 = $$d[5];
                    byte b19 = b18;
                    Object[] objArr28 = new Object[1];
                    w(b19, (byte) (b19 - 1), b18, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, offsetBefore, iAxisFromString, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i34 = ((int[]) objArr29[0])[0];
                int i35 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int i36 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
                int i37 = ~i36;
                int i38 = ((((-834356350) + ((i36 | 185984510) * (-859))) + (((~(i36 | (-1171663))) | (~(185984510 | i37))) * 859)) + (((~((-12187856) | i37)) | 11016193) * 859)) - 1982167837;
                int i39 = (i38 << 13) ^ i38;
                int i40 = i39 ^ (i39 >>> 17);
                ((int[]) objArr[3])[0] = i40 ^ (i40 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                x((byte) (95 - TextUtils.getOffsetBefore("", 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{4, 18, 16, 15, 2, 7, 15, 14, 2, 20, 17, 19, '\t', 22, 24, 1}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                x((byte) (11 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 21, new char[]{'\f', '\n', 20, 11, 21, 14, 23, 19, '\t', 15, '\b', 5, 18, 3, 11, 24}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -1982167837};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int maximumFlingVelocity = 25 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    char capsMode = (char) (30068 - TextUtils.getCapsMode("", 0, 0));
                    int iIndexOf3 = 816 - TextUtils.indexOf("", "", 0);
                    byte[] bArr2 = $$d;
                    byte b20 = bArr2[8];
                    byte b21 = bArr2[5];
                    Object[] objArr33 = new Object[1];
                    w(b20, b21, (byte) (b21 - 1), objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, capsMode, iIndexOf3, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iResolveOpacity = 25 - Drawable.resolveOpacity(0, 0);
                    char trimmedLength = (char) (30068 - TextUtils.getTrimmedLength(""));
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
                    byte b22 = $$d[5];
                    byte b23 = b22;
                    Object[] objArr34 = new Object[1];
                    w(b23, (byte) (b23 - 1), b22, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, trimmedLength, iMakeMeasureSpec, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    x((byte) (15 - (ViewConfiguration.getJumpTapTimeout() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 90, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 15), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 25;
                        char cBlue = (char) (30068 - Color.blue(0));
                        int iIndexOf4 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0);
                        byte b24 = $$d[5];
                        byte b25 = (byte) (b24 - 1);
                        Object[] objArr37 = new Object[1];
                        w(b25, b25, b24, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cBlue, iIndexOf4, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            x((byte) (95 - TextUtils.getOffsetBefore("", 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{4, 18, 16, 15, 2, 7, 15, 14, 2, 20, 17, 19, '\t', 22, 24, 1}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            x((byte) (11 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 21, new char[]{'\f', '\n', 20, 11, 21, 14, 23, 19, '\t', 15, '\b', 5, 18, 3, 11, 24}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -1982167837};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int maximumFlingVelocity2 = 25 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char capsMode2 = (char) (30068 - TextUtils.getCapsMode("", 0, 0));
                int iIndexOf5 = 816 - TextUtils.indexOf("", "", 0);
                byte[] bArr3 = $$d;
                byte b26 = bArr3[8];
                byte b27 = bArr3[5];
                Object[] objArr311 = new Object[1];
                w(b26, b27, (byte) (b27 - 1), objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, capsMode2, iIndexOf5, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iResolveOpacity2 = 25 - Drawable.resolveOpacity(0, 0);
                char trimmedLength2 = (char) (30068 - TextUtils.getTrimmedLength(""));
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
                byte b28 = $$d[5];
                byte b29 = b28;
                Object[] objArr312 = new Object[1];
                w(b29, (byte) (b29 - 1), b28, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, trimmedLength2, iMakeMeasureSpec2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            x((byte) (15 - (ViewConfiguration.getJumpTapTimeout() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 90, new char[]{15, 14, 11, '\t', 21, CharUtils.CR, '\f', 24, 22, '\b', 21, 17, 17, '\b', 20, 22, 3, 14, 3, 22, 16, 2}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            x((byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 15), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{22, 1, 17, 14, 6, 22, '\n', 24, 24, 16, 4, 22, 14, 1, 13843}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iNormalizeMetaState2 = KeyEvent.normalizeMetaState(0) + 25;
                char cBlue2 = (char) (30068 - Color.blue(0));
                int iIndexOf6 = 815 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte b210 = $$d[5];
                byte b211 = (byte) (b210 - 1);
                Object[] objArr315 = new Object[1];
                w(b211, b211, b210, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState2, cBlue2, iIndexOf6, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i41 = ((int[]) objArr[1])[0];
        int i42 = ((int[]) objArr[0])[0];
        if (i42 == i41) {
            int i43 = artificialFrame + 91;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i43 % 128;
            int i44 = i43 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i45 = ((int[]) objArr[3])[0];
            int i46 = ((int[]) objArr[0])[0];
            int i47 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i48 = (int) Runtime.getRuntime().totalMemory();
            int i49 = ~i48;
            int i50 = i45 + (-580052799) + (((~(i48 | (-337320560))) | (~((-199287057) | i49)) | 1114690) * (-68)) + ((~((-336205870) | i49)) * (-68)) + (((~(337320559 | i49)) | (-535492926)) * 68);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[3])[0] = i52 ^ (i52 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        long j6 = ((long) (i41 ^ i42)) ^ (((long) (-1462951686)) << 32);
        long j7 = -1462951685;
        int i53 = artificialFrame + 79;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i53 % 128;
        int i54 = i53 % 2;
        Object[] objArr41 = {Long.valueOf(j6), Long.valueOf(j7)};
        byte[] bArr4 = $$j;
        Object[] objArr42 = new Object[1];
        y((byte) (-bArr4[32]), bArr4[19], (byte) (bArr4[45] - 1), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b30 = bArr4[68];
        byte b31 = b30;
        Object[] objArr43 = new Object[1];
        y(b31, (byte) (b31 | 53), b30, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i55 = ((int[]) objArr[3])[0];
        int i56 = ((int[]) objArr[0])[0];
        int i57 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iIdentityHashCode = System.identityHashCode(this);
        int i58 = ~iIdentityHashCode;
        int i59 = i55 + 913852413 + (((~(i58 | 784830622)) | (~(586658256 | i58)) | (-787984863)) * 464) + (((-201326607) | iIdentityHashCode) * (-464)) + (((~(iIdentityHashCode | 784830622)) | (-787984863)) * 464);
        int i60 = (i59 << 13) ^ i59;
        int i61 = i60 ^ (i60 >>> 17);
        ((int[]) objArr44[3])[0] = i61 ^ (i61 << 5);
    }

    static void accessartificialFrame() {
        ArtificialStackFrames = new char[]{44391, 44395, 44396, 44394, 44397, 44360, 44402, 44403, 44698, 44392, 44398, 44393, 44400, 44355, 44388, 44406, 44371, 44387, 44409, 44385, 44370, 44389, 44334, 44399, 44404};
        coroutineCreation = (char) 39071;
    }
}
