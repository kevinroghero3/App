package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.base.Ascii;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onPostMessage;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: loaded from: classes.dex */
    public static class LoadingException extends Exception {
        private static final byte[] $$c = {52, -20, 7, -120};
        private static final int $$d = 60;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.VT, 84, -96, 47, 10, 4, 50, Ascii.SO, 3, Ascii.DC4, -50, -5, Ascii.SYN, -16, 8, 5, Ascii.ESC, Ascii.SYN, -16, Ascii.DLE, 5, -9, 5, Ascii.VT, -2, Ascii.DC2, 3, Ascii.US, 5, Ascii.DLE, Ascii.SYN, -3, 8, -9, Ascii.SO, -5, 0, -8, Ascii.DC4, 10, Ascii.DC2, 32, 8, 6, 36, 8, 3, 10, 2, 5, -49, 1, 1, -6, Ascii.GS};
        private static final int $$b = 194;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long onPostMessage = -1810291539901161840L;
        private static char[] IPostMessageService = {38278, 38356, 38356, 38348, 38347, 38356, 38365, 38364, 38354, 38350, 38360, 38360, 38386, 38382, 38356, 38355, 38355, 38358, 38351, 38350, 38384, 38385, 38351, 38357, 38224, 38062, 38063, 38225, 38222, 38063, 38063, 38060, 38217, 38221, 38062, 38063, 38067, 38226, 38226, 38070, 38071, 38063, 38060, 38067, 38070, 38073, 38067, 38066, 38225, 38218, 38064, 38395, 38191, 38191, 38190, 38182, 38185, 38194, 38381, 38170, 38173, 38171, 38172, 38172, 38374, 38160, 38160, 38155, 38155, 38285, 38355, 38356, 38363, 38359, 38355, 38354, 38358, 38363, 38357, 38351, 38350, 38286, 38356, 38356, 38363, 38359, 38355, 38354, 38358, 38363, 38357, 38351, 38350, 38353, 38351, 38253, 38259, 38261, 38269, 38256, 38254, 38260, 38369, 38146, 38285, 38363, 38365, 38358, 38348, 38348, 38278, 38347, 38278, 38348, 38378, 38386, 38355, 38347, 38349, 38351, 38356, 38363, 38365, 38280, 38349, 38351, 38356, 38358, 38366, 38363, 38356, 38357, 38357, 38349, 38199, 38067, 38067, 38066, 38073, 38074, 38071, 38066, 38069, 38076, 38068, 38066, 38061, 38059, 38060, 38278, 38352, 38354, 38359, 38360, 38348, 38345, 38358, 38366, 38358, 38356, 38351, 38349, 38350, 38287, 38357, 38348, 38382, 38389, 38358, 38359, 38355, 38382, 38390, 38358, 38351, 38350, 38384, 38382, 38347, 38347, 38312, 38385, 38356, 38362, 38354, 38380, 38385, 38358, 38355, 38348, 38345, 38345, 38280, 38385, 38381, 38354, 38358, 38358, 38358, 38351, 38383, 38391, 38362, 38355, 38212, 38059, 38064, 38058, 38312, 38385, 38356, 38362, 38391, 38386, 38361, 38365, 38358, 38354, 38386, 38391, 38357, 38357, 38365, 38390, 38369, 38249, 38224, 38216, 38216, 38250, 38245, 38213, 38217, 38224, 38220, 38245, 38239, 38213, 38221, 38215, 38244, 38377, 38260, 38231, 38237, 38232, 38257, 38358, 38255, 38248, 38243, 38248, 38253, 38255, 38152, 38148, 38247, 38253, 38154, 38148, 38249, 38246, 38239, 38236, 38236, 38145, 38179, 38152, 38312, 38382, 38345, 38345, 38348, 38355, 38358, 38385, 38382, 38356, 38390, 38380, 38354, 38362, 38356, 38385, 38306, 38373, 38344, 38350, 38342, 38368, 38373, 38346, 38343, 38336, 38205, 38205, 38370, 38312, 38381, 38347, 38349, 38383, 38391, 38362, 38356, 38385, 38312, 38385, 38356, 38362, 38391, 38381, 38347, 38382, 38278, 38348, 38350, 38350, 38349, 38353, 38385, 38389, 38358, 38359, 38355, 38382, 38390, 38358, 38351, 38350, 38384, 38314, 38395, 38388, 38284, 38289, 38394, 38312, 38384, 38350, 38351, 38358, 38390, 38383, 38174, 38176, 38277, 38348, 38358, 38357, 38348};

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, short r7, short r8) {
            /*
                int r7 = r7 * 2
                int r7 = 4 - r7
                int r8 = r8 * 2
                int r0 = r8 + 1
                int r6 = r6 + 65
                byte[] r1 = com.google.android.gms.dynamite.DynamiteModule.LoadingException.$$c
                byte[] r0 = new byte[r0]
                r2 = 0
                if (r1 != 0) goto L15
                r3 = r7
                r7 = r8
                r4 = r2
                goto L2a
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r6
                r0[r3] = r4
                if (r3 != r8) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L21:
                int r3 = r3 + 1
                r4 = r1[r7]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L2a:
                int r6 = -r6
                int r6 = r6 + r7
                int r7 = r3 + 1
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.LoadingException.$$e(int, short, short):java.lang.String");
        }

        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:8:0x0018  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0022). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(short r5, int r6, byte r7, java.lang.Object[] r8) {
            /*
                int r6 = r6 + 2
                int r7 = 115 - r7
                int r5 = 52 - r5
                byte[] r0 = com.google.android.gms.dynamite.DynamiteModule.LoadingException.$$a
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L10
                r4 = r6
                r3 = r2
                goto L22
            L10:
                r3 = r2
            L11:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r6) goto L20
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L20:
                r4 = r0[r5]
            L22:
                int r5 = r5 + 1
                int r7 = r7 + r4
                int r7 = r7 + (-5)
                goto L11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.LoadingException.a(short, int, byte, java.lang.Object[]):void");
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }

        private static void c(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
            char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
            onrelationshipvalidationresult.e = 4;
            while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                int i3 = $11 + 85;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                int i5 = onrelationshipvalidationresult.e;
                try {
                    Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - TextUtils.indexOf("", "", 0, 0), (char) (30690 - KeyEvent.normalizeMetaState(0)), 188 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    try {
                        Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                        if (objAccessartificialFrame2 == null) {
                            byte b = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - ExpandableListView.getPackedPositionChild(0L), (char) ((Process.getThreadPriority(0) + 20) >> 6), Color.green(0) + 1483, -1940971975, false, $$e((byte) 46, b, b), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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
            String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
            int i6 = $11 + 29;
            $10 = i6 % 128;
            if (i6 % 2 == 0) {
                objArr[0] = str;
            } else {
                int i7 = 42 / 0;
                objArr[0] = str;
            }
        }

        private static void b(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
            int i;
            char[] cArr;
            int i2 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i3 = 0;
            int i4 = iArr[0];
            int i5 = iArr[1];
            int i6 = iArr[2];
            int i7 = iArr[3];
            char[] cArr2 = IPostMessageService;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i8 = 0;
                while (i8 < length) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i3] = Integer.valueOf(cArr2[i8]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - View.resolveSize(i3, i3), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(i3) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i3) == 0.0d ? 0 : -1)), TextUtils.getOffsetAfter("", i3) + 1562, 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i8++;
                        i3 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                int i9 = $10 + 51;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 5 / 5;
                }
                cArr2 = cArr3;
            }
            char[] cArr4 = new char[i5];
            System.arraycopy(cArr2, i4, cArr4, 0, i5);
            if (bArr != null) {
                char[] cArr5 = new char[i5];
                onpostmessage.a = 0;
                char c = 0;
                while (onpostmessage.a < i5) {
                    int i11 = $10 + 61;
                    $11 = i11 % 128;
                    int i12 = i11 % 2;
                    if (bArr[onpostmessage.a] == 1) {
                        int i13 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 3;
                            byte b4 = (byte) (b3 - 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), View.getDefaultSize(0, 0) + 2441, -850656813, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr5[i13] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    } else {
                        int i14 = onpostmessage.a;
                        try {
                            Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 12, (char) Color.alpha(0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1562, 1918398056, false, $$e((byte) ($$d - 3), b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr5[i14] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                            int i15 = $10 + 1;
                            $11 = i15 % 128;
                            int i16 = i15 % 2;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    c = cArr5[onpostmessage.a];
                    Object[] objArr5 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (29364 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 216 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                cArr4 = cArr5;
            }
            if (i7 > 0) {
                char[] cArr6 = new char[i5];
                System.arraycopy(cArr4, 0, cArr6, 0, i5);
                int i17 = i5 - i7;
                System.arraycopy(cArr6, 0, cArr4, i17, i7);
                System.arraycopy(cArr6, i7, cArr4, 0, i17);
            }
            if (z) {
                int i18 = $11 + 13;
                $10 = i18 % 128;
                if (i18 % 2 != 0) {
                    cArr = new char[i5];
                    i = 0;
                } else {
                    i = 0;
                    cArr = new char[i5];
                }
                while (true) {
                    onpostmessage.a = i;
                    if (onpostmessage.a >= i5) {
                        break;
                    }
                    cArr[onpostmessage.a] = cArr4[(i5 - onpostmessage.a) - 1];
                    i = onpostmessage.a + 1;
                }
                cArr4 = cArr;
            }
            if (i6 > 0) {
                int i19 = 0;
                while (true) {
                    onpostmessage.a = i19;
                    if (onpostmessage.a >= i5) {
                        break;
                    }
                    cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                    i19 = onpostmessage.a + 1;
                }
            }
            objArr[0] = new String(cArr4);
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 185571. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        public static java.lang.Object[] accessartificialFrame$78cbbd35(int r64, int r65, java.lang.Object r66, int r67, boolean r68) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 18557
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z) throws LoadingException;
        }

        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            SentryLogcatAdapter.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            SentryLogcatAdapter.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            SentryLogcatAdapter.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0238  */
    /* JADX WARN: Code duplicated, block: B:112:0x023e  */
    /* JADX WARN: Code duplicated, block: B:115:0x0247  */
    /* JADX WARN: Code duplicated, block: B:120:0x0259 A[Catch: all -> 0x02a2, TryCatch #1 {all -> 0x02a2, blocks: (B:5:0x0029, B:9:0x0073, B:14:0x007b, B:17:0x0081, B:20:0x008b, B:97:0x01ea, B:98:0x01f5, B:99:0x01f6, B:100:0x01f7, B:101:0x01ff, B:120:0x0259, B:121:0x0270, B:103:0x0201, B:105:0x021f, B:107:0x022e, B:118:0x0250, B:119:0x0258, B:122:0x0271, B:123:0x02a1), top: B:137:0x0029, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0081 A[Catch: all -> 0x02a2, TRY_LEAVE, TryCatch #1 {all -> 0x02a2, blocks: (B:5:0x0029, B:9:0x0073, B:14:0x007b, B:17:0x0081, B:20:0x008b, B:97:0x01ea, B:98:0x01f5, B:99:0x01f6, B:100:0x01f7, B:101:0x01ff, B:120:0x0259, B:121:0x0270, B:103:0x0201, B:105:0x021f, B:107:0x022e, B:118:0x0250, B:119:0x0258, B:122:0x0271, B:123:0x02a1), top: B:137:0x0029, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0096 A[Catch: all -> 0x01e1, TryCatch #0 {, blocks: (B:23:0x0090, B:25:0x0096, B:26:0x0098, B:86:0x01d8, B:87:0x01e0), top: B:136:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x009b A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TRY_ENTER, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a2 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c8 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TRY_ENTER, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0135 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0141 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0165 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:68:0x016c A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0174 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0183 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:73:0x018c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x018e A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:75:0x019e A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01b3 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01bd A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01c6 A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01cf A[Catch: all -> 0x01e4, LoadingException -> 0x01e6, RemoteException -> 0x01e8, TryCatch #7 {RemoteException -> 0x01e8, LoadingException -> 0x01e6, all -> 0x01e4, blocks: (B:22:0x008f, B:28:0x009b, B:30:0x00a2, B:31:0x00c2, B:35:0x00c8, B:37:0x00d0, B:39:0x00d4, B:40:0x00df, B:47:0x00ea, B:49:0x0111, B:51:0x0119, B:52:0x0120, B:53:0x0128, B:48:0x00fe, B:56:0x012b, B:57:0x012c, B:58:0x0134, B:59:0x0135, B:60:0x013d, B:63:0x0140, B:64:0x0141, B:66:0x0165, B:68:0x016c, B:70:0x0174, B:76:0x01ad, B:78:0x01b3, B:80:0x01bd, B:81:0x01c5, B:71:0x0183, B:72:0x018b, B:74:0x018e, B:75:0x019e, B:82:0x01c6, B:83:0x01ce, B:84:0x01cf, B:85:0x01d7, B:90:0x01e3), top: B:143:0x008f }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01d8 A[Catch: all -> 0x01e1, TRY_ENTER, TryCatch #0 {, blocks: (B:23:0x0090, B:25:0x0096, B:26:0x0098, B:86:0x01d8, B:87:0x01e0), top: B:136:0x0090 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:120:0x0259, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x00a2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x0141, please report this as an issue */
    @ResultIgnorabilityUnspecified
    public static DynamiteModule load(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) throws LoadingException {
        DynamiteModule dynamiteModuleZzc;
        int i;
        Boolean bool;
        zzq zzqVarZzg;
        int iZze;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule;
        zzn zznVar;
        zzr zzrVar;
        zzn zznVar2;
        boolean z;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal = zzg;
        zzn zznVar3 = (zzn) threadLocal.get();
        zzn zznVar4 = new zzn(null);
        threadLocal.set(zznVar4);
        ThreadLocal threadLocal2 = zzh;
        Long l = (Long) threadLocal2.get();
        long jLongValue = l.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectionResultSelectModule = versionPolicy.selectModule(context, str, zzi);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + selectionResultSelectModule.localVersion + " and remote module " + str + ":" + selectionResultSelectModule.remoteVersion);
            int i2 = selectionResultSelectModule.selection;
            if (i2 != 0) {
                if (i2 != -1) {
                    if (i2 == 1 || selectionResultSelectModule.remoteVersion != 0) {
                        if (i2 == -1) {
                            dynamiteModuleZzc = zzc(applicationContext, str);
                        } else {
                            if (i2 == 1) {
                                throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                            }
                            try {
                                i = selectionResultSelectModule.remoteVersion;
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (zzf(context)) {
                                            throw new LoadingException("Remote loading disabled", null);
                                        }
                                        bool = zzb;
                                    }
                                    if (bool != null) {
                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                    }
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                        synchronized (DynamiteModule.class) {
                                            zzrVar = zzl;
                                        }
                                        if (zzrVar != null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        zznVar2 = (zzn) threadLocal.get();
                                        if (zznVar2 != null || zznVar2.zza == null) {
                                            throw new LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext2 = context.getApplicationContext();
                                        Cursor cursor2 = zznVar2.zza;
                                        ObjectWrapper.wrap(null);
                                        synchronized (DynamiteModule.class) {
                                            z = zze >= 2;
                                        }
                                        if (z) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            iObjectWrapperZze = zzrVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                        } else {
                                            SentryLogcatAdapter.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            iObjectWrapperZze = zzrVar.zze(ObjectWrapper.wrap(applicationContext2), str, i, ObjectWrapper.wrap(cursor2));
                                        }
                                        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                        if (context2 == null) {
                                            throw new LoadingException("Failed to get module context", null);
                                        }
                                        dynamiteModule = new DynamiteModule(context2);
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                        zzqVarZzg = zzg(context);
                                        if (zzqVarZzg != null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        iZze = zzqVarZzg.zze();
                                        if (iZze >= 3) {
                                            zznVar = (zzn) threadLocal.get();
                                            if (zznVar != null) {
                                                throw new LoadingException("No cached result cursor holder", null);
                                            }
                                            iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar.zza));
                                        } else if (iZze == 2) {
                                            SentryLogcatAdapter.w("DynamiteModule", "IDynamite loader version = 2");
                                            iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i);
                                        } else {
                                            SentryLogcatAdapter.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i);
                                        }
                                        objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                        if (objUnwrap != null) {
                                            throw new LoadingException("Failed to load remote module.", null);
                                        }
                                        dynamiteModule = new DynamiteModule((Context) objUnwrap);
                                    }
                                    dynamiteModuleZzc = dynamiteModule;
                                } catch (RemoteException e) {
                                    throw new LoadingException("Failed to load remote module.", e, null);
                                } catch (LoadingException e2) {
                                    throw e2;
                                } catch (Throwable th) {
                                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                                    throw new LoadingException("Failed to load remote module.", th, null);
                                }
                            } catch (LoadingException e3) {
                                SentryLogcatAdapter.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                int i3 = selectionResultSelectModule.localVersion;
                                if (i3 == 0 || versionPolicy.selectModule(context, str, new zzo(i3, 0)).selection != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e3, null);
                                }
                                dynamiteModuleZzc = zzc(applicationContext, str);
                            }
                        }
                        if (jLongValue == 0) {
                            zzh.remove();
                        } else {
                            zzh.set(l);
                        }
                        cursor = zznVar4.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        zzg.set(zznVar3);
                        return dynamiteModuleZzc;
                    }
                } else if (selectionResultSelectModule.localVersion != 0) {
                    i2 = -1;
                    if (i2 == 1) {
                    }
                    if (i2 == -1) {
                        dynamiteModuleZzc = zzc(applicationContext, str);
                    } else {
                        if (i2 == 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                        }
                        i = selectionResultSelectModule.remoteVersion;
                        synchronized (DynamiteModule.class) {
                            if (zzf(context)) {
                                throw new LoadingException("Remote loading disabled", null);
                            }
                            bool = zzb;
                            if (bool != null) {
                                throw new LoadingException("Failed to determine which loading route to use.", null);
                            }
                            if (bool.booleanValue()) {
                                Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                synchronized (DynamiteModule.class) {
                                    zzrVar = zzl;
                                    if (zzrVar != null) {
                                        throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                    }
                                    zznVar2 = (zzn) threadLocal.get();
                                    if (zznVar2 != null) {
                                    }
                                    throw new LoadingException("No result cursor", null);
                                }
                            }
                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                            zzqVarZzg = zzg(context);
                            if (zzqVarZzg != null) {
                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                            }
                            iZze = zzqVarZzg.zze();
                            if (iZze >= 3) {
                                zznVar = (zzn) threadLocal.get();
                                if (zznVar != null) {
                                    throw new LoadingException("No cached result cursor holder", null);
                                }
                                iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar.zza));
                            } else if (iZze == 2) {
                                SentryLogcatAdapter.w("DynamiteModule", "IDynamite loader version = 2");
                                iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i);
                            } else {
                                SentryLogcatAdapter.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i);
                            }
                            objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                            if (objUnwrap != null) {
                                throw new LoadingException("Failed to load remote module.", null);
                            }
                            dynamiteModule = new DynamiteModule((Context) objUnwrap);
                            dynamiteModuleZzc = dynamiteModule;
                        }
                    }
                    if (jLongValue == 0) {
                        zzh.remove();
                    } else {
                        zzh.set(l);
                    }
                    cursor = zznVar4.zza;
                    if (cursor != null) {
                        cursor.close();
                    }
                    zzg.set(zznVar3);
                    return dynamiteModuleZzc;
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectionResultSelectModule.localVersion + " and remote version is " + selectionResultSelectModule.remoteVersion + ".", null);
        } catch (Throwable th2) {
            if (jLongValue == 0) {
                zzh.remove();
            } else {
                zzh.set(l);
            }
            Cursor cursor3 = zznVar4.zza;
            if (cursor3 != null) {
                cursor3.close();
            }
            zzg.set(zznVar3);
            throw th2;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:134:0x01b8 */
    /* JADX WARN: Code duplicated, block: B:47:0x00aa A[Catch: all -> 0x00b5, TryCatch #9 {, blocks: (B:9:0x0026, B:11:0x0032, B:48:0x00b3, B:14:0x0038, B:16:0x003f, B:18:0x0045, B:21:0x0048, B:23:0x004c, B:27:0x0056, B:29:0x005e, B:32:0x0065, B:39:0x0092, B:40:0x009a, B:35:0x006c, B:37:0x0072, B:38:0x0083, B:43:0x009d, B:46:0x00a0, B:47:0x00aa, B:15:0x003b), top: B:133:0x0026, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0169 A[Catch: all -> 0x01c4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c4, blocks: (B:3:0x0002, B:61:0x00dc, B:63:0x00e2, B:68:0x0103, B:90:0x015b, B:94:0x0169, B:115:0x01bd, B:116:0x01c0, B:111:0x01b5, B:66:0x00e8, B:119:0x01c3, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:59:0x00d9, B:19:0x0046, B:41:0x009b, B:44:0x009e, B:52:0x00b7, B:60:0x00db, B:58:0x00bd), top: B:127:0x0002, inners: #0, #12 }] */
    public static int zza(@NonNull Context context, @NonNull String str, boolean z) {
        Throwable th;
        Cursor cursor;
        RemoteException e;
        Cursor cursor2;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                int iZzf = 0;
                Cursor cursor3 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else if (classLoader != null) {
                                try {
                                    zzd(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            } else {
                                if (!zzf(context)) {
                                    return 0;
                                }
                                if (zzd) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    Boolean bool2 = Boolean.TRUE;
                                    if (bool2.equals(null)) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iZzb = zzb(context, str, z, true);
                                            String str2 = zzc;
                                            if (str2 != null && !str2.isEmpty()) {
                                                ClassLoader classLoaderZza = zzb.zza();
                                                if (classLoaderZza == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        DynamiteModule$$ExternalSyntheticApiModelOutline1.m();
                                                        String str3 = zzc;
                                                        Preconditions.checkNotNull(str3);
                                                        classLoaderZza = DynamiteModule$$ExternalSyntheticApiModelOutline0.m(str3, ClassLoader.getSystemClassLoader());
                                                    } else {
                                                        String str4 = zzc;
                                                        Preconditions.checkNotNull(str4);
                                                        classLoaderZza = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                zzd(classLoaderZza);
                                                declaredField.set(null, classLoaderZza);
                                                zzb = bool2;
                                                return iZzb;
                                            }
                                            return iZzb;
                                        } catch (LoadingException unused2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                }
                            }
                            zzb = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        SentryLogcatAdapter.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e3) {
                        SentryLogcatAdapter.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarZzg = zzg(context);
                try {
                    if (zzqVarZzg != null) {
                        try {
                            int iZze = zzqVarZzg.zze();
                            if (iZze >= 3) {
                                zzn zznVar = (zzn) zzg.get();
                                if (zznVar == null || (cursor2 = zznVar.zza) == null) {
                                    cursor = (Cursor) ObjectWrapper.unwrap(zzqVarZzg.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                                    if (cursor != null) {
                                        try {
                                            if (cursor.moveToFirst()) {
                                                int i = cursor.getInt(0);
                                                cursor3 = (i <= 0 || !zze(cursor)) ? cursor : null;
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                                iZzf = i;
                                            } else {
                                                SentryLogcatAdapter.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                            }
                                        } catch (RemoteException e4) {
                                            e = e4;
                                            cursor3 = cursor;
                                            SentryLogcatAdapter.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        SentryLogcatAdapter.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                    }
                                } else {
                                    iZzf = cursor2.getInt(0);
                                }
                            } else if (iZze == 2) {
                                SentryLogcatAdapter.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iZzf = zzqVarZzg.zzg(ObjectWrapper.wrap(context), str, z);
                            } else {
                                SentryLogcatAdapter.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iZzf = zzqVarZzg.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e5) {
                            e = e5;
                        }
                    }
                    return iZzf;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursor3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private static int zzb(Context context, String str, boolean z, boolean z2) throws Throwable {
        Exception e;
        ?? r0 = 0;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    zzc = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        zze = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        zzd = z3;
                                        z4 = z3;
                                    }
                                }
                                if (zze(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r2 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e instanceof LoadingException) {
                            throw e;
                        }
                        throw new LoadingException("V2 version check failed: " + e.getMessage(), e, r1 == true ? 1 : 0);
                    }
                }
                SentryLogcatAdapter.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r3 == true ? 1 : 0);
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            r0 = context;
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            zzf = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            SentryLogcatAdapter.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                SentryLogcatAdapter.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
