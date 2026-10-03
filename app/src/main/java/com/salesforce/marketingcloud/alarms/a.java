package com.salesforce.marketingcloud.alarms;

import android.R;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda14;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Random;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    private final String a;
    private final long b;
    private final double c;
    private final long d;
    private final String e;
    private final int f;
    private final boolean g;

    static final class b extends a {
        b(int i) {
            this(i, "et_etanalytic_alarm_created_date", "et_etanalytic_next_alarm_interval", 60000L, 2.0d, 86400000L, true);
        }

        private b(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    static final class c extends a {
        c(int i, long j) {
            super(i, "et_delivery_receipt_alarm_created_date", "et_delivery_receipt_alarm_interval", j, 1.0d, j, false);
        }
    }

    static final class d extends a {
        d(int i) {
            super(i, "et_device_stats_alarm_created_date", "et_device_stats_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }
    }

    static final class e extends a {
        e(int i) {
            super(i, "et_events_alarm_created_date", "et_events_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }
    }

    static final class f extends a {
        f(int i) {
            super(i, "et_iam_image_cache_route_alarm_created_date", "et_iam_image_cache_route_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }
    }

    static final class g extends a {
        g(int i) {
            this(i, "et_fetch_background_beacon_messages_alarm_created_date", "et_fetch_background_beacon_messages_next_alarm_interval", 86400000L, 1.0d, 86400000L, false);
        }

        private g(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    static final class i extends a {
        i(int i) {
            this(i, "et_register_for_remote_notifications_alarm_created_date", "et_register_for_remote_notifications_next_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }

        private i(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    static final class j extends a {
        j(int i) {
            this(i, "et_registration_alarm_created_date", "et_registration_next_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }

        private j(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    static final class k extends a {
        k(int i) {
            this(i, "et_update_inbox_message_status_alarm_created_date", "et_update_inbox_message_status_next_alarm_interval", 60000L, 2.0d, 86400000L, true);
        }

        private k(int i, String str, String str2, long j, double d, long j2, boolean z) {
            super(i, str, str2, j, d, j2, z);
        }
    }

    a(@IntRange(from = 1, to = 2147483647L) int i2, @NonNull @Size(min = 1) String str, @NonNull @Size(min = 1) String str2, @IntRange(from = 1, to = 86400000) long j2, @FloatRange(from = 1.0d, to = 10.0d) double d2, @IntRange(from = 1, to = 86400000) long j3, boolean z) {
        this.f = i2;
        this.e = str;
        this.a = str2;
        this.b = j2;
        this.c = d2;
        this.d = j3;
        this.g = z;
    }

    final String a() {
        return this.e;
    }

    final int b() {
        return this.f;
    }

    final String c() {
        return this.a;
    }

    final long d() {
        return this.b;
    }

    final double e() {
        return this.c;
    }

    final long f() {
        return this.d;
    }

    final boolean g() {
        return this.g;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a, reason: collision with other inner class name */
    public static abstract class EnumC0062a {
        public static final EnumC0062a c;
        public static final EnumC0062a d;
        public static final EnumC0062a e;
        public static final EnumC0062a f;
        public static final EnumC0062a g;
        public static final EnumC0062a h;
        public static final EnumC0062a i;
        public static final EnumC0062a j;
        public static final EnumC0062a k;
        public static final EnumC0062a l;
        private static final /* synthetic */ EnumC0062a[] m = a();
        private final int b;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$a, reason: collision with other inner class name */
        final enum C0063a extends EnumC0062a {

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private long f29n;

            private C0063a(String str, int i, int i2) {
                super(str, i, i2);
                this.f29n = 10000L;
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            public void a(long j) {
                this.f29n = j;
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new c(c(), this.f29n);
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$b */
        final enum b extends EnumC0062a {
            private b(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new j(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$c */
        final enum c extends EnumC0062a {
            private c(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new b(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$d */
        final enum d extends EnumC0062a {
            private d(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new g(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$e */
        final enum e extends EnumC0062a {
            private e(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new i(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$f */
        final enum f extends EnumC0062a {
            private f(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new k(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$g */
        final enum g extends EnumC0062a {
            private g(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new h(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$h */
        final enum h extends EnumC0062a {
            private h(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new f(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$i */
        final enum i extends EnumC0062a {
            private i(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new d(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$j */
        final enum j extends EnumC0062a {
            private j(String str, int i, int i2) {
                super(str, i, i2);
            }

            @Override // com.salesforce.marketingcloud.alarms.a.EnumC0062a
            protected a b() {
                return new e(c());
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.alarms.a$a$k */
        /* JADX INFO: loaded from: classes6.dex */
        static class k {
            static final int a = 909116;
            static final int b = 909115;
            static final int c = 909114;
            static final int d = 909113;
            static final int e = 909112;
            static final int f = 909110;
            static final int g = 909109;
            static final int h = 909108;
            static final int i = 909111;
            static final int j = 909102;
            static final int k = 909100;

            k() {
            }
        }

        static {
            c = new b("REGISTRATION", 0, 909100);
            d = new c("ET_ANALYTICS", 1, 909102);
            e = new d("FETCH_REGION_MESSAGES_DAILY", 2, 909111);
            f = new e("FETCH_PUSH_TOKEN", 3, 909108);
            g = new f("UPDATE_INBOX_MESSAGE_STATUS", 4, 909110);
            h = new g("SYNC", 5, 909112);
            i = new h("IAM_IMAGE_BATCH", 6, 909113);
            j = new i("DEVICE_STATS", 7, 909114);
            k = new j("EVENTS", 8, 909115);
            l = new C0063a("DELIVERY_RECEIPT", 9, 909116);
        }

        private EnumC0062a(String str, int i2, int i3) {
            super(str, i2);
            this.b = i3;
        }

        public static EnumC0062a valueOf(String str) {
            return (EnumC0062a) Enum.valueOf(EnumC0062a.class, str);
        }

        public static EnumC0062a[] values() {
            return (EnumC0062a[]) m.clone();
        }

        public void a(long j2) {
        }

        @Deprecated
        protected boolean a(@NonNull com.salesforce.marketingcloud.storage.h hVar) {
            return true;
        }

        protected abstract a b();

        public int c() {
            return this.b;
        }

        private static /* synthetic */ EnumC0062a[] a() {
            return new EnumC0062a[]{c, d, e, f, g, h, i, j, k, l};
        }
    }

    public static final class h extends a {
        private static final byte[] $$c = {102, -25, -78, -11};
        private static final int $$d = 100;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.US, Ascii.FS, -113, 86, Ascii.VT, 2, -12};
        private static final int $$b = 60;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long coroutineBoundary = -9111899880460976458L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 11596;

        private static String $$e(short s, byte b, byte b2) {
            byte[] bArr = $$c;
            int i = b2 * 2;
            int i2 = b + 4;
            int i3 = s + 98;
            byte[] bArr2 = new byte[i + 1];
            int i4 = -1;
            if (bArr == null) {
                i3 += i;
            }
            while (true) {
                i4++;
                i2++;
                bArr2[i4] = (byte) i3;
                if (i4 == i) {
                    return new String(bArr2, 0);
                }
                i3 += bArr[i2];
            }
        }

        h(int i) {
            super(i, "et_sync_route_alarm_created_date", "et_sync_route_alarm_interval", 60000L, 2.0d, 86400000L, false);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void i(short r5, short r6, int r7, java.lang.Object[] r8) {
            /*
                int r7 = r7 * 2
                int r7 = r7 + 4
                byte[] r0 = com.salesforce.marketingcloud.alarms.a.h.$$a
                int r6 = r6 * 4
                int r6 = 109 - r6
                int r5 = r5 * 2
                int r1 = 4 - r5
                byte[] r1 = new byte[r1]
                int r5 = 3 - r5
                r2 = 0
                if (r0 != 0) goto L18
                r4 = r5
                r3 = r2
                goto L2a
            L18:
                r3 = r2
            L19:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r5) goto L26
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L26:
                r4 = r0[r7]
                int r3 = r3 + 1
            L2a:
                int r7 = r7 + 1
                int r6 = r6 + r4
                int r6 = r6 + (-3)
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.alarms.a.h.i(short, short, int, java.lang.Object[]):void");
        }

        private static void h(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
            char c2;
            int i2 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr3.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            int i3 = $11 + 19;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i5 = $11 + 101;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 1;
                        byte b2 = (byte) (-b);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(32 - Process.getGidForName(""), (char) View.combineMeasuredStates(0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1483, 1614432829, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 3;
                        byte b4 = (byte) (b3 - 4);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 32, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49169), TextUtils.indexOf("", "", 0) + 899, 214239564, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = (byte) (b5 - 1);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 2441 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -1003383455, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                    if (objAccessartificialFrame4 == null) {
                        c2 = 2;
                        byte b7 = (byte) 2;
                        byte b8 = (byte) (b7 - 3);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(19 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (29754 - View.getDefaultSize(0, 0)), 1747 - Process.getGidForName(""), 1479752515, false, $$e(b7, b8, (byte) (b8 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    } else {
                        c2 = 2;
                    }
                    cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                    cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                    iCustomTabsCallbackDefault.a++;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            objArr[0] = new String(cArr6);
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0a72  */
        /* JADX WARN: Code duplicated, block: B:109:0x0a81 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:110:0x0a83  */
        /* JADX WARN: Code duplicated, block: B:112:0x0aa4  */
        /* JADX WARN: Code duplicated, block: B:113:0x0ab1  */
        /* JADX WARN: Code duplicated, block: B:115:0x0b52  */
        /* JADX WARN: Code duplicated, block: B:133:0x0962 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:89:0x08fd  */
        /* JADX WARN: Code duplicated, block: B:90:0x08ff A[Catch: Exception -> 0x0b5f, TRY_LEAVE, TryCatch #2 {Exception -> 0x0b5f, blocks: (B:87:0x08c0, B:90:0x08ff, B:92:0x094b, B:94:0x095d, B:118:0x0b58, B:119:0x0b5e, B:91:0x0909), top: B:134:0x08c0, inners: #8 }] */
        /* JADX WARN: Code duplicated, block: B:98:0x099a  */
        /* JADX WARN: Code duplicated, block: B:99:0x099c A[Catch: Exception -> 0x0a6f, TRY_LEAVE, TryCatch #1 {Exception -> 0x0a6f, blocks: (B:96:0x0962, B:99:0x099c, B:101:0x0a60, B:103:0x0a68, B:104:0x0a6e, B:100:0x09a6), top: B:133:0x0962, inners: #7 }] */
        public static Object[] getDefaultImpl(int i, int i2) throws Throwable {
            char c;
            Object[] objArr;
            int i3;
            char c2;
            CharSequence charSequence;
            String str;
            int i4;
            File file;
            FileReader fileReader;
            BufferedReader bufferedReader;
            boolean zEquals;
            boolean zEquals2;
            int i5;
            int i6;
            int i7;
            Object[] objArr2;
            int[] iArr;
            int[] iArr2;
            int i8;
            File file2;
            FileReader fileReader2;
            BufferedReader bufferedReader2;
            int i9;
            int iJ_;
            int i10;
            int i11;
            int i12;
            int iJ_2;
            int i13;
            int i14;
            char c3;
            int i15;
            int i16 = 2 % 2;
            int i17 = 4;
            try {
                String[] strArr = new String[2];
                char[] cArr = {54266, 22355, 65319, 29198};
                int i18 = 1278795975 - (~(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                char[] cArr2 = {51357, 14560, 20044, 3880};
                int i19 = artificialFrame;
                int i20 = (i19 ^ 107) + ((i19 & 107) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                if (i20 % 2 != 0) {
                    i12 = -View.getDefaultSize(0, 0);
                    iJ_2 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                    int i21 = ~i12;
                    int i22 = ~iJ_2;
                    int i23 = ~((i21 & i22) | (i21 ^ i22));
                    int i24 = -(-((i23 & 10318) | (i23 ^ 10318)));
                    i13 = ((-518) % i12) * 9800 * ((i24 & 519) + (i24 | 519));
                } else {
                    i12 = -View.getDefaultSize(0, 0);
                    iJ_2 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                    i13 = (((i12 * (-518)) - 5344724) - (~(-(-(((~((~i12) | (~iJ_2))) | 10318) * 519))))) - 1;
                }
                int i25 = ~i12;
                int i26 = ~iJ_2;
                int i27 = ~((i25 & i26) | (i25 ^ i26) | 10318);
                int i28 = i12 | 10318;
                int i29 = ~((i28 & iJ_2) | (i28 ^ iJ_2));
                int i30 = -(-((-519) * ((i27 & i29) | (i27 ^ i29))));
                int i31 = (i13 ^ i30) + ((i30 & i13) << 1);
                int i32 = ~(10318 | iJ_2);
                int i33 = -(-(((i32 & i12) | (i12 ^ i32)) * 519));
                Object[] objArr3 = new Object[1];
                h(cArr, i18, cArr2, (char) ((i31 ^ i33) + ((i33 & i31) << 1)), new char[]{13668, 56255, 40899, 8426, 17211, 64155, 41815, 32019, 23482, 43673, 32850, 46744, 48592, 23139, 57797, 1072, 54936, 43268, 49684}, objArr3);
                strArr[0] = (String) objArr3[0];
                int i34 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                int i35 = (i34 * 71) - 69;
                int i36 = -(-(((~((~i34) | 1)) | (~((i ^ 1) | (i & 1)))) * (-140)));
                int i37 = ((i35 | i36) << 1) - (i35 ^ i36);
                int i38 = (i34 ^ 1) | (i34 & 1);
                int i39 = (~((i38 & i) | (i38 ^ i))) * 70;
                int i40 = (i37 & i39) + (i39 | i37);
                int i41 = ~((~i34) | 1);
                int i42 = ~(((-2) & i34) | ((-2) ^ i34));
                int i43 = (i41 & i42) | (i41 ^ i42);
                int i44 = ~((i34 & i) | (i34 ^ i));
                int i45 = -(-(((i44 & i43) | (i43 ^ i44)) * 70));
                int i46 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                int i47 = ~i46;
                int i48 = ~(i47 | 3031);
                int i49 = ~i;
                int i50 = ((i46 * 375) - 2264157) + ((i48 | (~((i49 ^ i46) | (i49 & i46)))) * (-374)) + ((~(((-3032) & i46) | ((-3032) ^ i46))) * 748);
                int i51 = ~((i47 & (-3032)) | (i47 ^ (-3032)));
                int i52 = ~i;
                int i53 = -(-(((~((i46 & i52) | (i52 ^ i46))) | i51) * 374));
                Object[] objArr4 = new Object[1];
                h(new char[]{54266, 22355, 65319, 29198}, ((i40 | i45) << 1) - (i45 ^ i40), new char[]{55181, 48249, 55502, 51979}, (char) ((i50 & i53) + (i53 | i50)), new char[]{14080, 41038, 20882, 32550, 21988, 7515, 1195, 4982, 2710, 30094, 62389, 9901, 38511, 27071, 14869, 56114, 43618, 10620}, objArr4);
                strArr[1] = (String) objArr4[0];
                int i54 = 0;
                int i55 = 2;
                while (true) {
                    if (i54 >= i55) {
                        objArr = new Object[i17];
                        objArr[0] = new int[]{i};
                        objArr[1] = new int[]{i};
                        objArr[2] = new int[1];
                        objArr[3] = null;
                        int i56 = artificialFrame + 69;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
                        if (i56 % 2 != 0) {
                            int startUptimeMillis = (int) Process.getStartUptimeMillis();
                            int i57 = ~startUptimeMillis;
                            i14 = i2 << ((((((~(38330244 | i57)) | (~(startUptimeMillis | 1016954019))) * 959) - 616047947) + (((~(startUptimeMillis | 38330244)) | (~(i57 | 1016954019))) * 959)) / 0);
                        } else {
                            int i58 = (-287681132) + (((~((-617956518) | i52)) | (~((-360667258) | i))) * 210) + (((~((-287971417) | i52)) | (~((-545260677) | i))) * 210);
                            i14 = (i2 & i58) + (i58 | i2);
                        }
                        int i59 = i14 ^ (i14 << 13);
                        int i60 = i59 >>> 17;
                        int i61 = (i59 | i60) & (~(i59 & i60));
                        int i62 = i61 << 5;
                        ((int[]) objArr[2])[0] = (i61 | i62) & (~(i61 & i62));
                        break;
                    }
                    String str2 = strArr[i54];
                    char[] cArr3 = new char[i17];
                    // fill-array-data instruction
                    cArr3[0] = 54266;
                    cArr3[1] = 22355;
                    cArr3[2] = 65319;
                    cArr3[3] = 29198;
                    int maximumDrawingCacheSize = ViewConfiguration.getMaximumDrawingCacheSize() >> 24;
                    char[] cArr4 = new char[i17];
                    // fill-array-data instruction
                    cArr4[0] = 56879;
                    cArr4[1] = 18402;
                    cArr4[2] = 24696;
                    cArr4[3] = 13317;
                    int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                    artificialFrame = i63 % 128;
                    int i64 = i63 % 2;
                    int i65 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                    int iJ_3 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                    int i66 = (i65 * (-830)) - (-1144832);
                    int i67 = ~iJ_3;
                    int i68 = ~((-1377) | i67);
                    int i69 = i65 | 1376;
                    int i70 = ~((i69 ^ iJ_3) | (i69 & iJ_3));
                    int i71 = ((i68 ^ i70) | (i68 & i70)) * (-831);
                    int i72 = (i66 ^ i71) + ((i71 & i66) << 1);
                    int i73 = ((-1377) ^ i65) | ((-1377) & i65);
                    int i74 = -(-((~((i73 & iJ_3) | (i73 ^ iJ_3))) * (-1662)));
                    int i75 = (i72 ^ i74) + ((i74 & i72) << 1);
                    int i76 = ~i65;
                    int i77 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    String[] strArr2 = strArr;
                    int i78 = (i77 & 33) + (i77 | 33);
                    int i79 = i49;
                    artificialFrame = i78 % 128;
                    if (i78 % 2 == 0) {
                        throw null;
                    }
                    int i80 = ~((i76 ^ i67) | (i76 & i67));
                    int i81 = ~((i65 & iJ_3) | (i65 ^ iJ_3));
                    int i82 = (i80 & i81) | (i80 ^ i81);
                    int i83 = ~((iJ_3 ^ 1376) | (iJ_3 & 1376));
                    int i84 = i77 + 79;
                    artificialFrame = i84 % 128;
                    int i85 = i84 % 2;
                    int i86 = -(-(831 * ((i82 & i83) | (i82 ^ i83))));
                    Object[] objArr5 = new Object[1];
                    h(cArr3, maximumDrawingCacheSize, cArr4, (char) ((i75 ^ i86) + ((i86 & i75) << 1)), new char[]{50348, 57388, 5544, 62772, 58270, 25708, 20462, 19230, 11510, 3004, 891, 49146, 11842, 30233, 44857, 607}, objArr5);
                    Class<?> cls = Class.forName((String) objArr5[0]);
                    Class<?>[] clsArr = new Class[0];
                    int i87 = artificialFrame;
                    int i88 = (i87 ^ 71) + ((i87 & 71) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i88 % 128;
                    int i89 = i88 % 2;
                    if (!(!((Boolean) cls.getMethod(str2, clsArr).invoke(cls, null)).booleanValue())) {
                        int i90 = (i & (-2)) | (i52 & 1);
                        objArr = new Object[4];
                        int[] iArr3 = new int[1];
                        objArr[0] = iArr3;
                        int[] iArr4 = new int[1];
                        objArr[1] = iArr4;
                        objArr[2] = new int[1];
                        int i91 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i92 = (i91 ^ 71) + ((i91 & 71) << 1);
                        artificialFrame = i92 % 128;
                        if (i92 % 2 == 0) {
                            iArr3[1] = i;
                            i15 = 99;
                            c3 = 0;
                        } else {
                            c3 = 0;
                            iArr3[0] = i;
                            i15 = 16;
                        }
                        iArr4[c3] = i90;
                        objArr[3] = null;
                        int i93 = (-569368608) + (((~((-75801121) | i)) | (~(902822654 | i))) * 69) + (((~((-633709309) | i)) | 557908188 | (~(344914466 | i))) * (-69)) + 1388951690;
                        int iJ_4 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                        int i94 = ~((~i15) | i93);
                        int i95 = ~i93;
                        int i96 = (i95 ^ i15) | (i95 & i15);
                        int i97 = ~((i96 & iJ_4) | (i96 ^ iJ_4));
                        int i98 = ((((i15 * 477) + (i93 * (-475))) - (~(-(-(((i94 & i97) | (i94 ^ i97)) * (-476)))))) - 1) + ((~((i95 ^ i15) | (i95 & i15) | iJ_4)) * 952);
                        int i99 = ~i93;
                        int i100 = ~iJ_4;
                        int i101 = (i100 & i99) | (i99 ^ i100);
                        int i102 = (~((i101 & i15) | (i101 ^ i15))) * 476;
                        int i103 = (i98 & i102) + (i102 | i98);
                        int i104 = artificialFrame;
                        int i105 = (i104 & 7) + (i104 | 7);
                        int i106 = i105 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i106;
                        int i107 = i105 % 2;
                        int i108 = i103 * 765;
                        int i109 = -(-(i2 * (-1527)));
                        int i110 = (i108 ^ i109) + ((i108 & i109) << 1);
                        int i111 = -(-(((~((i52 ^ i103) | (i52 & i103))) | i2) * 764));
                        int i112 = (i110 & i111) + (i111 | i110);
                        int i113 = ~i103;
                        int i114 = i106 + 75;
                        artificialFrame = i114 % 128;
                        int i115 = i114 % 2;
                        int i116 = ~((i113 & i2) | (i113 ^ i2));
                        int i117 = ~((i79 ^ i2) | (i79 & i2));
                        int i118 = (-1528) * ((i116 & i117) | (i116 ^ i117));
                        int i119 = (i112 & i118) + (i118 | i112);
                        int i120 = ~i103;
                        int i121 = ~((i120 & i2) | (i120 ^ i2));
                        int i122 = ~i2;
                        int i123 = i121 | (~((i122 & i103) | (i122 ^ i103)));
                        int i124 = ~(i79 | i103);
                        int i125 = (i119 - (~(((i124 & i123) | (i123 ^ i124)) * 764))) - 1;
                        int i126 = i125 ^ (i125 << 13);
                        int i127 = i126 >>> 17;
                        int i128 = ((~i126) & i127) | ((~i127) & i126);
                        int i129 = i128 << 5;
                        ((int[]) objArr[2])[0] = (i128 | i129) & (~(i128 & i129));
                        break;
                    }
                    i54 = (i54 | 1) + (i54 & 1);
                    strArr = strArr2;
                    i49 = i79;
                    i55 = 2;
                    i17 = 4;
                }
                c = 0;
            } catch (Exception unused) {
                int i130 = ~i;
                Object[] objArr6 = {new int[]{i}, new int[]{(i & (-3)) | (i130 & 2)}, new int[]{i}, null};
                int i131 = (-67954274) + (((~((-679805034) | i)) | 8716321) * 576) + (((~((-671088713) | i130)) | 290102420) * 576) + 725633600;
                int i132 = -(-(i131 * 591));
                int i133 = ((-9424) ^ i132) + ((i132 & (-9424)) << 1);
                int i134 = ~i131;
                int i135 = ~((i134 ^ i130) | (i134 & i130));
                int i136 = ~((i134 & 16) | (i134 ^ 16));
                int i137 = (i136 & i135) | (i135 ^ i136);
                int i138 = ~i;
                int i139 = ~((i138 ^ 16) | (i138 & 16));
                int i140 = (i137 & i139) | (i137 ^ i139);
                int i141 = ((-17) ^ i131) | ((-17) & i131);
                int i142 = ~((i141 & i) | (i141 ^ i));
                int i143 = ((i140 & i142) | (i140 ^ i142)) * 590;
                int i144 = ((i133 | i143) << 1) - (i143 ^ i133);
                int i145 = ~i131;
                int i146 = (i144 - (~(-(-((((~(i145 | 16)) | (~((i145 ^ i130) | (i145 & i130)))) | (~((i130 ^ 16) | (i130 & 16)))) * (-1180)))))) - 1;
                int i147 = ~(((-17) ^ i138) | (i138 & (-17)));
                int i148 = ~((i130 & i131) | (i130 ^ i131));
                int i149 = i146 + (((i147 & i148) | (i147 ^ i148)) * 590);
                int i150 = (i2 & i149) + (i2 | i149);
                int i151 = i150 << 13;
                int i152 = ((~i150) & i151) | ((~i151) & i150);
                int i153 = i152 >>> 17;
                int i154 = ((~i152) & i153) | ((~i153) & i152);
                int i155 = i154 << 5;
                int i156 = (i154 | i155) & (~(i154 & i155));
                c = 0;
                objArr = objArr6;
            }
            int[] iArr5 = (int[]) objArr[1];
            FirebaseMessaging$$ExternalSyntheticLambda14.j_();
            int i157 = ~i;
            if (i != iArr5[c]) {
                i4 = 1;
            } else {
                try {
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                    if (objAccessartificialFrame == null) {
                        int i158 = 10 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        char cIndexOf = (char) (64609 - TextUtils.indexOf((CharSequence) "", '0'));
                        int iAlpha = Color.alpha(0) + 1806;
                        byte b = (byte) 0;
                        byte b2 = b;
                        Object[] objArr7 = new Object[1];
                        i(b, b2, b2, objArr7);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i158, cIndexOf, iAlpha, -1135716921, false, (String) objArr7[0], new Class[0]);
                    }
                    long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                    int i159 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i160 = (i159 ^ 57) + ((i159 & 57) << 1);
                    int i161 = i160 % 128;
                    artificialFrame = i161;
                    int i162 = i160 % 2;
                    long j = -1405927641;
                    long j2 = (((long) 960) * j) + (((long) (-1917)) * jLongValue);
                    long j3 = 959;
                    long j4 = -1;
                    long j5 = jLongValue ^ j4;
                    long j6 = i;
                    long j7 = j6 ^ j4;
                    long j8 = j2 + ((((j5 | j7) ^ j4) | ((j | j6) ^ j4)) * j3) + (((long) (-959)) * j5) + (j3 * (((j5 | j6) ^ j4) | ((j7 | j) ^ j4))) + ((long) 1746135675);
                    int i163 = ~i;
                    int i164 = ~(759415396 | i163);
                    int i165 = ((int) (j8 >> 32)) & (((((4325380 | i164) | (~((-759415397) | i))) * (-338)) - 1395762446) + ((i164 | (~((-755090017) | i))) * 338));
                    int i166 = 1984483157 + (((~((-1977726649) | i163)) | 539041800) * (-1188));
                    int i167 = 539041800 | (~(1977726648 | i));
                    int i168 = ~(540500238 | i163);
                    int i169 = ((int) j8) & (i166 + ((i167 | i168) * 594) + (((~(1977726648 | i163)) | (-1979185087) | i168) * 594));
                    if (((i165 & i169) | (i165 ^ i169)) == 1) {
                        int i170 = i161 + 69;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i170 % 128;
                        int i171 = i170 % 2;
                        Object[] objArr8 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                        int i172 = 1578642166 + (((~((-290317343) | i163)) | 17080320 | (~((-688306433) | i163)) | (~(961543454 | i))) * (-84));
                        int i173 = (~((-688306433) | i)) | 290317342;
                        int i174 = ~(688306432 | i163);
                        int i175 = i172 + ((i173 | i174) * (-84)) + (((-961543455) | i174) * 84);
                        int iJ_5 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                        int i176 = 7440 + (i175 * (-463));
                        int i177 = ~i175;
                        int i178 = ~iJ_5;
                        int i179 = ~((i178 & i177) | (i177 ^ i178));
                        int i180 = ~((i177 & 16) | (i177 ^ 16));
                        int i181 = (i179 & i180) | (i179 ^ i180);
                        int i182 = ~iJ_5;
                        int i183 = ~((i182 & 16) | (i182 ^ 16));
                        int i184 = -(-(((i181 & i183) | (i181 ^ i183)) * 464));
                        int i185 = (i176 & i184) + (i176 | i184);
                        int i186 = (iJ_5 ^ (-17)) | (iJ_5 & (-17));
                        int i187 = ~i175;
                        int i188 = ((i187 & i186) | (i186 ^ i187)) * (-464);
                        int i189 = ((i185 | i188) << 1) - (i188 ^ i185);
                        int i190 = ((~(iJ_5 | 16)) | i180) * 464;
                        int i191 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
                        artificialFrame = i191 % 128;
                        if (i191 % 2 == 0) {
                            i9 = i189 >>> i190;
                            iJ_ = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                            i3 = i2;
                            i10 = (i9 * (-183)) >>> (185 >>> i3);
                        } else {
                            i3 = i2;
                            i9 = ((i190 & i189) << 1) + (i189 ^ i190);
                            iJ_ = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                            i10 = (i9 * (-183)) + (i3 * 185);
                        }
                        int i192 = ~i9;
                        int i193 = ~((i192 & i3) | (i192 ^ i3));
                        int i194 = ~iJ_;
                        int i195 = artificialFrame;
                        int i196 = ((i195 | 43) << 1) - (i195 ^ 43);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i196 % 128;
                        int i197 = i196 % 2;
                        int i198 = ~((i194 & i3) | (i194 ^ i3));
                        int i199 = (i193 & i198) | (i193 ^ i198);
                        if (i197 != 0) {
                            int i200 = -(183 - (~i199));
                            int i201 = ((i10 | i200) << 1) - (i10 ^ i200);
                            int i202 = ~i3;
                            int i203 = ~((i202 & i9) | (i202 ^ i9));
                            int i204 = -((-184) >> ((i203 & iJ_) | (iJ_ ^ i203)));
                            int i205 = -(~((~i9) | (~iJ_)));
                            i11 = ((i201 ^ i204) + ((i204 & i201) << 1)) / ((i205 ^ SyslogConstants.LOG_LOCAL7) + ((i205 & SyslogConstants.LOG_LOCAL7) << 1));
                        } else {
                            int i206 = (i10 - (~(-(-(i199 * SyslogConstants.LOG_LOCAL7))))) - 1;
                            int i207 = ~i3;
                            int i208 = ((~((i207 & i9) | (i207 ^ i9))) | iJ_) * (-184);
                            int i209 = (i206 ^ i208) + ((i206 & i208) << 1);
                            int i210 = ~i9;
                            int i211 = ~iJ_;
                            int i212 = (~((i210 & i211) | (i210 ^ i211))) * SyslogConstants.LOG_LOCAL7;
                            i11 = (i209 ^ i212) + ((i212 & i209) << 1);
                        }
                        int i213 = i11 << 13;
                        int i214 = (i213 & (~i11)) | ((~i213) & i11);
                        int i215 = i214 >>> 17;
                        int i216 = (i214 | i215) & (~(i214 & i215));
                        int i217 = i216 << 5;
                        ((int[]) objArr8[2])[0] = (i216 | i217) & (~(i216 & i217));
                        objArr = objArr8;
                        c2 = 0;
                    } else {
                        i3 = i2;
                        int i218 = (i159 ^ 65) + ((i159 & 65) << 1);
                        artificialFrame = i218 % 128;
                        int i219 = i218 % 2;
                        int i220 = i159 + 7;
                        int i221 = i220 % 128;
                        artificialFrame = i221;
                        int i222 = i220 % 2;
                        Object[] objArr9 = {new int[]{i}, new int[]{i}, new int[]{i}, null};
                        int i223 = i3 + 2023179742 + (((~(782890830 | i)) | 195732944) * 672) + (((~((-782890831) | i163)) | (~(195732944 | i))) * (-672)) + (((~((-195732945) | i163)) | R.id.KEYCODE_BUTTON_9) * 672);
                        int i224 = i223 << 13;
                        int i225 = (i223 | i224) & (~(i223 & i224));
                        int i226 = i225 ^ (i225 >>> 17);
                        int i227 = (i221 ^ 23) + ((i221 & 23) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i227 % 128;
                        int i228 = i227 % 2;
                        int i229 = i226 ^ (i226 << 5);
                        c2 = 0;
                        objArr = objArr9;
                    }
                    if (i != ((int[]) objArr[1])[c2]) {
                        int i230 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                        artificialFrame = i230 % 128;
                        int i231 = i230 % 2;
                    } else {
                        try {
                            char[] cArr5 = {54266, 22355, 65319, 29198};
                            int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                            char[] cArr6 = {56622, 25184, 54720, 63488};
                            charSequence = "";
                            try {
                                int i232 = -TextUtils.lastIndexOf(charSequence, '0', 0);
                                int iJ_6 = FirebaseMessaging$$ExternalSyntheticLambda14.j_();
                                int i233 = i232 * 980;
                                int i234 = (i233 & (-207336)) + (i233 | (-207336));
                                int i235 = ~iJ_6;
                                int i236 = i234 + ((~((-213) | i235)) * 979) + (((i232 ^ iJ_6) | (i232 & iJ_6)) * (-979));
                                int i237 = ~((iJ_6 & (-213)) | ((-213) ^ iJ_6));
                                int i238 = ~((i232 & i235) | (i235 ^ i232));
                                int i239 = i237 ^ i238;
                                Object[] objArr10 = new Object[1];
                                h(cArr5, keyRepeatDelay, cArr6, (char) ((i236 - (~(-(-(((i238 & i237) | i239) * 979))))) - 1), new char[]{16673, 42407, 51593, 5467, 17263, 37883, 6817, 50021, 15650, 36098, 35271, 61388, 61083, 21486, 50115, 13084, 7059, 42767, 32777, 35526, 1147, 28332, 9788, 47149, 50476, 47509, 55685, 17637, 31195, 50528, 15985, 17994, 3640, 33008, 50027, 17509, 32329, 31228, 39606, 49082}, objArr10);
                                File file3 = new File((String) objArr10[0]);
                                try {
                                    if (file3.canRead()) {
                                        FileReader fileReader3 = new FileReader(file3);
                                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                        try {
                                            String line = bufferedReader3.readLine();
                                            int i240 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                            Object[] objArr11 = new Object[1];
                                            h(new char[]{54266, 22355, 65319, 29198}, (i240 ^ (-1108505095)) + ((i240 & (-1108505095)) << 1), new char[]{63812, 60813, 61885, 21474}, (char) (58097 - (~(-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))), new char[]{25103, 27002, 7184}, objArr11);
                                            if (!line.equals((String) objArr11[0])) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                str = line;
                                            } else {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                            }
                                            Object[] objArr12 = new Object[1];
                                            h(new char[]{54266, 22355, 65319, 29198}, (-1598991173) - (~TextUtils.getCapsMode(charSequence, 0, 0)), new char[]{48237, 45396, 27808, 41202}, (char) (View.resolveSize(0, 0) + 62060), new char[]{28023, 54768, 63076, 44954, 9787, 55766, 21940, 16488, 7633, 54889, 14691, 36679, 65142, 10911, 56472, 17203, 21852, 31876, 55260, 20577, 49003, 48855, 34396, 8719, 52398, 62090, 44959, 29001, 49861, 50987, 51041}, objArr12);
                                            file = new File((String) objArr12[0]);
                                            if (!file.canRead()) {
                                                fileReader = new FileReader(file);
                                                bufferedReader = new BufferedReader(fileReader);
                                                try {
                                                    String line2 = bufferedReader.readLine();
                                                    int i241 = -(-TextUtils.indexOf(charSequence, charSequence, 0));
                                                    Object[] objArr13 = new Object[1];
                                                    h(new char[]{54266, 22355, 65319, 29198}, ((i241 | (-1547818005)) << 1) - (i241 ^ (-1547818005)), new char[]{60241, 48683, 44707, 31296}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 16558), new char[]{47849}, objArr13);
                                                    zEquals = line2.equals((String) objArr13[0]);
                                                    fileReader.close();
                                                    int i242 = artificialFrame;
                                                    int i243 = ((i242 | 107) << 1) - (i242 ^ 107);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i243 % 128;
                                                    int i244 = i243 % 2;
                                                    bufferedReader.close();
                                                    if (zEquals) {
                                                        try {
                                                            Object[] objArr14 = new Object[1];
                                                            h(new char[]{54266, 22355, 65319, 29198}, ViewConfiguration.getTouchSlop() >> 8, new char[]{33972, 48041, 30782, 65493}, (char) (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{34197, 26081, 53679, 25526, 9501, 27677, 5408, 39601, 40402, 24192, 25755, 37748, 35178, 37490, 38110, 5804, 13182, 46724, 20976, 62477, 39093, 59209, 56773, 25637, 3813, 35889, 50702, 59329, 663, 38356, 16420, 19797, 53684, 35835, 9021, 36165}, objArr14);
                                                            file2 = new File((String) objArr14[0]);
                                                            if (!file2.canRead()) {
                                                                zEquals2 = false;
                                                            } else {
                                                                fileReader2 = new FileReader(file2);
                                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                                try {
                                                                    String line3 = bufferedReader2.readLine();
                                                                    int iRgb = Color.rgb(0, 0, 0);
                                                                    int i245 = iRgb * (-183);
                                                                    int i246 = (i245 & 1007590147) + (i245 | 1007590147);
                                                                    int i247 = ~iRgb;
                                                                    int i248 = ~((i247 ^ i163) | (i247 & i163) | (-1531040789));
                                                                    int i249 = (1531040788 ^ i163) | (1531040788 & i163);
                                                                    int i250 = ~((i249 ^ iRgb) | (i249 & iRgb));
                                                                    int i251 = -(-(((i248 ^ i250) | (i248 & i250)) * (-184)));
                                                                    int i252 = (i246 & i251) + (i251 | i246);
                                                                    int i253 = (~((i247 & 1531040788) | (i247 ^ 1531040788))) | (~((~iRgb) | i157));
                                                                    int i254 = ~i249;
                                                                    int i255 = i253 ^ i254;
                                                                    int i256 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                                    int i257 = (i256 * (-500)) - 8279500;
                                                                    int i258 = ~(((-16560) & i256) | ((-16560) ^ i256));
                                                                    int i259 = ~i256;
                                                                    int i260 = i259 | 16559;
                                                                    int i261 = ~((i260 & i) | (i260 ^ i));
                                                                    int i262 = -(-(((i258 & i261) | (i258 ^ i261)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                                                    Object[] objArr15 = new Object[1];
                                                                    h(new char[]{54266, 22355, 65319, 29198}, ((i252 - (~(-(-(((i253 & i254) | i255) * SyslogConstants.LOG_LOCAL7))))) - 1) + (((-1531040789) | iRgb) * SyslogConstants.LOG_LOCAL7), new char[]{60241, 48683, 44707, 31296}, (char) (((((i257 & i262) + (i257 | i262)) - (~(-(-((~((i259 ^ (-16560)) | (i259 & (-16560)))) * 1002))))) - 1) + ((~(i259 | i163 | 16559)) * TypedValues.PositionType.TYPE_TRANSITION_EASING)), new char[]{47849}, objArr15);
                                                                    zEquals2 = line3.equals((String) objArr15[0]);
                                                                    fileReader2.close();
                                                                    bufferedReader2.close();
                                                                } catch (Throwable th) {
                                                                    fileReader2.close();
                                                                    bufferedReader2.close();
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Exception unused2) {
                                                        }
                                                        if (zEquals2) {
                                                            i5 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            i6 = (i5 & 55) + (i5 | 55);
                                                            artificialFrame = i6 % 128;
                                                            if (i6 % 2 != 0) {
                                                                Object obj = null;
                                                                obj.hashCode();
                                                                throw null;
                                                            }
                                                            if (str != null) {
                                                                i7 = i ^ 20;
                                                                objArr2 = new Object[4];
                                                                iArr = new int[1];
                                                                objArr2[0] = iArr;
                                                                iArr2 = new int[1];
                                                                objArr2[1] = iArr2;
                                                                objArr2[2] = new int[1];
                                                                i8 = ((i5 | 23) << 1) - (i5 ^ 23);
                                                                artificialFrame = i8 % 128;
                                                                if (i8 % 2 == 0) {
                                                                    iArr2[1] = i;
                                                                    iArr2[1] = i7;
                                                                    objArr2[3] = str;
                                                                } else {
                                                                    iArr[0] = i;
                                                                    iArr2[0] = i7;
                                                                    objArr2[3] = str;
                                                                }
                                                                int iNextInt = new Random().nextInt(786583549);
                                                                int i263 = (((~(iNextInt | 237602052)) * TypedValues.CycleType.TYPE_EASING) - 2094081710) + (((~((~iNextInt) | 237602052)) | 204013568) * TypedValues.CycleType.TYPE_EASING) + 16;
                                                                int i264 = ~i263;
                                                                int i265 = (i263 * 595) + (i3 * (-1187)) + (((~((i264 & i3) | (i264 ^ i3))) | (~((i157 ^ i3) | (i157 & i3)))) * (-1188));
                                                                int i266 = ~i263;
                                                                int i267 = ~((i266 & i3) | (i266 ^ i3));
                                                                int i268 = ~i3;
                                                                int i269 = (~((i & i268) | (i268 ^ i))) | i267;
                                                                int i270 = ~((i163 ^ i263) | (i163 & i263));
                                                                int i271 = (i265 - (~(-(-(((i269 & i270) | (i269 ^ i270)) * 594))))) - 1;
                                                                int i272 = ~i3;
                                                                int i273 = ((~((i272 & i163) | (i272 ^ i163))) | (~((i268 ^ i263) | (i263 & i268))) | i270) * 594;
                                                                int i274 = (i271 & i273) + (i271 | i273);
                                                                int i275 = (i274 << 13) ^ i274;
                                                                int i276 = i275 >>> 17;
                                                                int i277 = (i275 | i276) & (~(i275 & i276));
                                                                int i278 = i277 << 5;
                                                                ((int[]) objArr2[2])[0] = ((~i277) & i278) | ((~i278) & i277);
                                                                int i279 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i280 = (i279 ^ 73) + ((i279 & 73) << 1);
                                                                artificialFrame = i280 % 128;
                                                                int i281 = i280 % 2;
                                                                objArr = objArr2;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th2) {
                                                    fileReader.close();
                                                    bufferedReader.close();
                                                    throw th2;
                                                }
                                            }
                                            objArr = new Object[]{new int[]{i}, new int[]{i}, new int[]{i ^ (i << 5)}, null};
                                            int i282 = (-1120881602) + (((~((-208682245) | i)) | 207626240 | (~((-769941531) | i))) * (-880));
                                            int i283 = (~((-208682245) | i163)) | 769941530;
                                            int i284 = ~(208682244 | i);
                                            int i285 = i282 + ((i283 | i284) * (-880)) + (i284 * 880);
                                            int i286 = (i285 << 1) - i285;
                                            int i287 = i286 * 273;
                                            int i288 = i3 * (-271);
                                            int i289 = (i287 ^ i288) + ((i287 & i288) << 1);
                                            int i290 = ~i286;
                                            int i291 = (~i3) | i290;
                                            int i292 = ~((i163 & i291) | (i291 ^ i163));
                                            int i293 = i286 | i3;
                                            int i294 = ~((i293 & i) | (i293 ^ i));
                                            int i295 = ((i292 & i294) | (i292 ^ i294)) * (-272);
                                            int i296 = ((i289 | i295) << 1) - (i295 ^ i289);
                                            int i297 = ~((i290 ^ i3) | (i290 & i3));
                                            int i298 = ~i286;
                                            int i299 = ~((i298 & i) | (i298 ^ i));
                                            int i300 = ((i297 & i299) | (i297 ^ i299)) * (-272);
                                            int i301 = ~((i286 & i) | (i286 ^ i));
                                            int i302 = (((i296 | i300) << 1) - (i300 ^ i296)) + (((i301 & i3) | (i3 ^ i301)) * 272);
                                            int i303 = i302 << 13;
                                            int i304 = (i303 & (~i302)) | ((~i303) & i302);
                                            int i305 = i304 ^ (i304 >>> 17);
                                            int i306 = artificialFrame;
                                            i4 = 1;
                                            int i307 = (i306 ^ 5) + ((i306 & 5) << 1);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i307 % 128;
                                            int i308 = i307 % 2;
                                        } catch (Throwable th3) {
                                            fileReader3.close();
                                            bufferedReader3.close();
                                            throw th3;
                                        }
                                    } else {
                                        int i309 = artificialFrame + 69;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i309 % 128;
                                        if (i309 % 2 != 0) {
                                            int i310 = 2 / 4;
                                        }
                                    }
                                    Object[] objArr16 = new Object[1];
                                    h(new char[]{54266, 22355, 65319, 29198}, (-1598991173) - (~TextUtils.getCapsMode(charSequence, 0, 0)), new char[]{48237, 45396, 27808, 41202}, (char) (View.resolveSize(0, 0) + 62060), new char[]{28023, 54768, 63076, 44954, 9787, 55766, 21940, 16488, 7633, 54889, 14691, 36679, 65142, 10911, 56472, 17203, 21852, 31876, 55260, 20577, 49003, 48855, 34396, 8719, 52398, 62090, 44959, 29001, 49861, 50987, 51041}, objArr16);
                                    file = new File((String) objArr16[0]);
                                    if (!file.canRead()) {
                                        fileReader = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        String line4 = bufferedReader.readLine();
                                        int i2410 = -(-TextUtils.indexOf(charSequence, charSequence, 0));
                                        Object[] objArr17 = new Object[1];
                                        h(new char[]{54266, 22355, 65319, 29198}, ((i2410 | (-1547818005)) << 1) - (i2410 ^ (-1547818005)), new char[]{60241, 48683, 44707, 31296}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 16558), new char[]{47849}, objArr17);
                                        zEquals = line4.equals((String) objArr17[0]);
                                        fileReader.close();
                                        int i2411 = artificialFrame;
                                        int i2412 = ((i2411 | 107) << 1) - (i2411 ^ 107);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2412 % 128;
                                        int i2413 = i2412 % 2;
                                        bufferedReader.close();
                                        if (zEquals) {
                                            Object[] objArr18 = new Object[1];
                                            h(new char[]{54266, 22355, 65319, 29198}, ViewConfiguration.getTouchSlop() >> 8, new char[]{33972, 48041, 30782, 65493}, (char) (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{34197, 26081, 53679, 25526, 9501, 27677, 5408, 39601, 40402, 24192, 25755, 37748, 35178, 37490, 38110, 5804, 13182, 46724, 20976, 62477, 39093, 59209, 56773, 25637, 3813, 35889, 50702, 59329, 663, 38356, 16420, 19797, 53684, 35835, 9021, 36165}, objArr18);
                                            file2 = new File((String) objArr18[0]);
                                            if (!file2.canRead()) {
                                                zEquals2 = false;
                                            } else {
                                                fileReader2 = new FileReader(file2);
                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                String line5 = bufferedReader2.readLine();
                                                int iRgb2 = Color.rgb(0, 0, 0);
                                                int i2414 = iRgb2 * (-183);
                                                int i2415 = (i2414 & 1007590147) + (i2414 | 1007590147);
                                                int i2416 = ~iRgb2;
                                                int i2417 = ~((i2416 ^ i163) | (i2416 & i163) | (-1531040789));
                                                int i2418 = (1531040788 ^ i163) | (1531040788 & i163);
                                                int i2510 = ~((i2418 ^ iRgb2) | (i2418 & iRgb2));
                                                int i2511 = -(-(((i2417 ^ i2510) | (i2417 & i2510)) * (-184)));
                                                int i2512 = (i2415 & i2511) + (i2511 | i2415);
                                                int i2513 = (~((i2416 & 1531040788) | (i2416 ^ 1531040788))) | (~((~iRgb2) | i157));
                                                int i2514 = ~i2418;
                                                int i2515 = i2513 ^ i2514;
                                                int i2516 = -(SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                                int i2517 = (i2516 * (-500)) - 8279500;
                                                int i2518 = ~(((-16560) & i2516) | ((-16560) ^ i2516));
                                                int i2519 = ~i2516;
                                                int i2610 = i2519 | 16559;
                                                int i2611 = ~((i2610 & i) | (i2610 ^ i));
                                                int i2612 = -(-(((i2518 & i2611) | (i2518 ^ i2611)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                                Object[] objArr19 = new Object[1];
                                                h(new char[]{54266, 22355, 65319, 29198}, ((i2512 - (~(-(-(((i2513 & i2514) | i2515) * SyslogConstants.LOG_LOCAL7))))) - 1) + (((-1531040789) | iRgb2) * SyslogConstants.LOG_LOCAL7), new char[]{60241, 48683, 44707, 31296}, (char) (((((i2517 & i2612) + (i2517 | i2612)) - (~(-(-((~((i2519 ^ (-16560)) | (i2519 & (-16560)))) * 1002))))) - 1) + ((~(i2519 | i163 | 16559)) * TypedValues.PositionType.TYPE_TRANSITION_EASING)), new char[]{47849}, objArr19);
                                                zEquals2 = line5.equals((String) objArr19[0]);
                                                fileReader2.close();
                                                bufferedReader2.close();
                                            }
                                            if (zEquals2) {
                                                i5 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                i6 = (i5 & 55) + (i5 | 55);
                                                artificialFrame = i6 % 128;
                                                if (i6 % 2 != 0) {
                                                    Object obj2 = null;
                                                    obj2.hashCode();
                                                    throw null;
                                                }
                                                if (str != null) {
                                                    i7 = i ^ 20;
                                                    objArr2 = new Object[4];
                                                    iArr = new int[1];
                                                    objArr2[0] = iArr;
                                                    iArr2 = new int[1];
                                                    objArr2[1] = iArr2;
                                                    objArr2[2] = new int[1];
                                                    i8 = ((i5 | 23) << 1) - (i5 ^ 23);
                                                    artificialFrame = i8 % 128;
                                                    if (i8 % 2 == 0) {
                                                        iArr2[1] = i;
                                                        iArr2[1] = i7;
                                                        objArr2[3] = str;
                                                    } else {
                                                        iArr[0] = i;
                                                        iArr2[0] = i7;
                                                        objArr2[3] = str;
                                                    }
                                                    int iNextInt2 = new Random().nextInt(786583549);
                                                    int i2613 = (((~(iNextInt2 | 237602052)) * TypedValues.CycleType.TYPE_EASING) - 2094081710) + (((~((~iNextInt2) | 237602052)) | 204013568) * TypedValues.CycleType.TYPE_EASING) + 16;
                                                    int i2614 = ~i2613;
                                                    int i2615 = (i2613 * 595) + (i3 * (-1187)) + (((~((i2614 & i3) | (i2614 ^ i3))) | (~((i157 ^ i3) | (i157 & i3)))) * (-1188));
                                                    int i2616 = ~i2613;
                                                    int i2617 = ~((i2616 & i3) | (i2616 ^ i3));
                                                    int i2618 = ~i3;
                                                    int i2619 = (~((i & i2618) | (i2618 ^ i))) | i2617;
                                                    int i2710 = ~((i163 ^ i2613) | (i163 & i2613));
                                                    int i2711 = (i2615 - (~(-(-(((i2619 & i2710) | (i2619 ^ i2710)) * 594))))) - 1;
                                                    int i2712 = ~i3;
                                                    int i2713 = ((~((i2712 & i163) | (i2712 ^ i163))) | (~((i2618 ^ i2613) | (i2613 & i2618))) | i2710) * 594;
                                                    int i2714 = (i2711 & i2713) + (i2711 | i2713);
                                                    int i2715 = (i2714 << 13) ^ i2714;
                                                    int i2716 = i2715 >>> 17;
                                                    int i2717 = (i2715 | i2716) & (~(i2715 & i2716));
                                                    int i2718 = i2717 << 5;
                                                    ((int[]) objArr2[2])[0] = ((~i2717) & i2718) | ((~i2718) & i2717);
                                                    int i2719 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i2810 = (i2719 ^ 73) + ((i2719 & 73) << 1);
                                                    artificialFrame = i2810 % 128;
                                                    int i2811 = i2810 % 2;
                                                    objArr = objArr2;
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception unused3) {
                                }
                            } catch (Exception unused4) {
                            }
                        } catch (Exception unused5) {
                            charSequence = "";
                        }
                        str = null;
                        objArr = new Object[]{new int[]{i}, new int[]{i}, new int[]{i305 ^ (i305 << 5)}, null};
                        int i2812 = (-1120881602) + (((~((-208682245) | i)) | 207626240 | (~((-769941531) | i))) * (-880));
                        int i2813 = (~((-208682245) | i163)) | 769941530;
                        int i2814 = ~(208682244 | i);
                        int i2815 = i2812 + ((i2813 | i2814) * (-880)) + (i2814 * 880);
                        int i2816 = (i2815 << 1) - i2815;
                        int i2817 = i2816 * 273;
                        int i2818 = i3 * (-271);
                        int i2819 = (i2817 ^ i2818) + ((i2817 & i2818) << 1);
                        int i2910 = ~i2816;
                        int i2911 = (~i3) | i2910;
                        int i2912 = ~((i163 & i2911) | (i2911 ^ i163));
                        int i2913 = i2816 | i3;
                        int i2914 = ~((i2913 & i) | (i2913 ^ i));
                        int i2915 = ((i2912 & i2914) | (i2912 ^ i2914)) * (-272);
                        int i2916 = ((i2819 | i2915) << 1) - (i2915 ^ i2819);
                        int i2917 = ~((i2910 ^ i3) | (i2910 & i3));
                        int i2918 = ~i2816;
                        int i2919 = ~((i2918 & i) | (i2918 ^ i));
                        int i3010 = ((i2917 & i2919) | (i2917 ^ i2919)) * (-272);
                        int i3011 = ~((i2816 & i) | (i2816 ^ i));
                        int i3012 = (((i2916 | i3010) << 1) - (i3010 ^ i2916)) + (((i3011 & i3) | (i3 ^ i3011)) * 272);
                        int i3013 = i3012 << 13;
                        int i3014 = (i3013 & (~i3012)) | ((~i3013) & i3012);
                        int i3015 = i3014 ^ (i3014 >>> 17);
                        int i3016 = artificialFrame;
                        i4 = 1;
                        int i3017 = (i3016 ^ 5) + ((i3016 & 5) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3017 % 128;
                        int i3018 = i3017 % 2;
                    }
                    i4 = 1;
                } catch (Throwable th4) {
                    Throwable cause = th4.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th4;
                }
            }
            int i311 = artificialFrame;
            int i312 = ((i311 | 119) << i4) - (i311 ^ 119);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i312 % 128;
            int i313 = i312 % 2;
            return objArr;
        }
    }
}
