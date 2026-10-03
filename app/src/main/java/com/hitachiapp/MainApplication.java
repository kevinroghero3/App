package com.hitachiapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
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
import androidx.browser.trusted.NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4;
import app.notifee.core.a$$ExternalSyntheticApiModelOutline30;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.soloader.OpenSourceMergedSoMapping;
import com.facebook.soloader.SoLoader;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hitachiapp.services.push.bootstrap.PushSdkBootstrap;
import com.hitachiapp.services.push.mapp.MappBootstrapFactory;
import com.hitachiapp.services.push.salesforce.SfmcBootstrapFactory;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.config.TSNotification;
import io.sentry.android.core.performance.AppStartMetrics;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes.dex */
public final class MainApplication extends Application implements ReactApplication {
    private static short[] ICustomTabsService;
    private static final byte[] $$c = {84, -7, -54, -78};
    private static final int $$f = 86;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$d = {89, -28, 106, -128, 1, 0, -15, -3, 1, 58, 2, -62, -8, -9, Ascii.FF, -16, 1, 10, -14, 59, -69, 1, 8, -22, Ascii.VT, -12, -6, 2, 60, -54, -16, 7, -17, 0, 3, 2, 51, -25, -36, -4, -2, -16, -3, 10, -2, Ascii.SO, -31, 9, -11, 3, -18, 48, -38, 0, -18, -7, Ascii.FF, -16, -3, -64, -15, -1, 60, -60, -11, -3, 5, -8, 4, 52, -54, -16, 7, -17, 0, 3, 2, 51, -66, 9, -22, Ascii.FF, -16, 6, 5, -14, 59, -56, -15, 0, -6, -6, 65, -74, -2, 8, -6, 0, -14, 8, 1, -17, 66, -25, -56, 8, 10, -15, 1, 3, Ascii.GS, -47, 0, -6, -6, 75, -3, -36, -54, 1, Ascii.FF, -16, 1, 10, -14, Ascii.SYN, -41, 8, -9, 9, 0, -18, 8, 3, Ascii.DC4, -24, -15, 8, -5, 0, 46};
    private static final int $$e = 147;
    private static final byte[] $$a = {79, -66, -116, -33, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
    private static final int $$b = 17;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -424089130;
    private static int mayLaunchUrl = -81862460;
    private static int getInterfaceDescriptor = 343458329;
    private static byte[] ICustomTabsCallbackStubProxy = {54, 34, 51, 85, 0, 54, 45, Base64.padSymbol, 36, 80, 81, -5, 50, 125, -12, 59, 36, 57, 72, 32, 73, -47, -19, -36, -31, -26, -43, -2, -37, -22, -33, -18, -6, -36, -30, -39, -80, -64, -49, -5, -28, -102, -56, -36, -76, 3, -100, -66, -44, -54, -115, 113, -70, 107, 113, -100, -107, 95, -127, -101, 113, -128, -123, -115, -117, -117, -117, -117, -117};
    private final ArrayList<Class<?>> runningActivities = new ArrayList<>();
    private final ReactNativeHost reactNativeHost = new DefaultReactNativeHost(this) { // from class: com.hitachiapp.MainApplication$reactNativeHost$1
        private final boolean isHermesEnabled;
        private final boolean isNewArchEnabled;

        @Override // com.facebook.react.ReactNativeHost
        public boolean getUseDeveloperSupport() {
            return false;
        }

        {
            super(this);
            this.isHermesEnabled = true;
        }

        @Override // com.facebook.react.ReactNativeHost
        public List<ReactPackage> getPackages() {
            ArrayList<ReactPackage> packages = new PackageList(this).getPackages();
            Intrinsics.checkNotNullExpressionValue(packages, "apply(...)");
            return packages;
        }

        @Override // com.facebook.react.ReactNativeHost
        public String getJSMainModuleName() {
            return FirebaseAnalytics.Param.INDEX;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        public boolean isNewArchEnabled() {
            return this.isNewArchEnabled;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        public Boolean isHermesEnabled() {
            return Boolean.valueOf(this.isHermesEnabled);
        }
    };

    private static String $$g(byte b, short s, short s2) {
        int i = (s * 3) + 4;
        byte[] bArr = $$c;
        int i2 = (b * 5) + 112;
        int i3 = s2 * 4;
        byte[] bArr2 = new byte[i3 + 1];
        int i4 = -1;
        if (bArr == null) {
            i++;
            i2 = (-i2) + i;
            i4 = -1;
        }
        while (true) {
            int i5 = i;
            int i6 = i2;
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i6;
            if (i7 == i3) {
                return new String(bArr2, 0);
            }
            i = i5 + 1;
            i2 = (-bArr[i5]) + i6;
            i4 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 28
            int r7 = r7 + 84
            int r8 = r8 * 8
            int r8 = 20 - r8
            int r6 = r6 * 3
            int r0 = 12 - r6
            byte[] r1 = com.hitachiapp.MainApplication.$$a
            byte[] r0 = new byte[r0]
            int r6 = 11 - r6
            r2 = 0
            if (r1 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2d
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2d:
            int r8 = -r8
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.MainApplication.a(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            int r9 = r9 * 3
            int r9 = 111 - r9
            int r8 = r8 + 3
            byte[] r0 = com.hitachiapp.MainApplication.$$d
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r9
            r5 = r2
            r9 = r7
            goto L2b
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r9
            int r7 = r7 + 1
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2b:
            int r7 = -r7
            int r3 = r3 + r7
            int r7 = r3 + (-3)
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r6
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hitachiapp.MainApplication.c(short, byte, short, java.lang.Object[]):void");
    }

    public final void addActivityToStack(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        if (this.runningActivities.contains(cls)) {
            return;
        }
        this.runningActivities.add(cls);
    }

    public final void removeActivityFromStack(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        if (this.runningActivities.contains(cls)) {
            this.runningActivities.remove(cls);
        }
    }

    public final boolean isActivityInBackStack(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        return this.runningActivities.contains(cls);
    }

    @Override // com.facebook.react.ReactApplication
    public ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    @Override // com.facebook.react.ReactApplication
    public ReactHost getReactHost() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return DefaultReactHost.getDefaultReactHost(applicationContext, getReactNativeHost());
    }

    @Override // android.app.Application
    public void onCreate() throws IOException {
        AppStartMetrics.onApplicationCreate(this);
        super.onCreate();
        SoLoader.init(this, OpenSourceMergedSoMapping.INSTANCE);
        createFirebaseNotificationChannel();
        Iterator it2 = CollectionsKt__CollectionsKt.listOf((Object[]) new PushSdkBootstrap[]{SfmcBootstrapFactory.INSTANCE.create(this), MappBootstrapFactory.INSTANCE.create(this)}).iterator();
        while (it2.hasNext()) {
            ((PushSdkBootstrap) it2.next()).init(this);
        }
        AppStartMetrics.onApplicationPostCreate(this);
    }

    private final void createFirebaseNotificationChannel() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            a$$ExternalSyntheticApiModelOutline30.m();
            NotificationChannel notificationChannelM = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m("firebase-push-notifications", "Firebase Notifications", 4);
            notificationChannelM.enableVibration(true);
            notificationChannelM.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, new AudioAttributes.Builder().setUsage(5).build());
            if (i >= 29) {
                notificationChannelM.setBypassDnd(true);
            }
            Object systemService = getSystemService(TSNotification.NAME);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(notificationChannelM);
        }
    }

    private final void initializeAppoxee() {
        try {
            Class.forName("com.appoxee.Appoxee").getMethod("engage", Application.class).invoke(null, this);
            Timber.d("Appoxee SDK initialized successfully", new Object[0]);
        } catch (ClassNotFoundException unused) {
            Timber.d("Appoxee class not found - Mapp SDK may not be installed", new Object[0]);
        } catch (Exception e) {
            Timber.d("Error initializing Appoxee SDK: " + e.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c1 A[PHI: r0
  0x01c1: PHI (r0v9 int) = (r0v8 int), (r0v44 int) binds: [B:46:0x01bf, B:43:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x01c3 A[PHI: r0
  0x01c3: PHI (r0v41 int) = (r0v8 int), (r0v44 int) binds: [B:46:0x01bf, B:43:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    private static void b(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int length;
        byte[] bArr;
        int length2;
        byte[] bArr2;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 40, (char) (36240 - ImageFormat.getBitsPerPixel(0)), TextUtils.indexOf("", "") + 2342, 371880939, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + b.i;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                int i8 = $10 + 101;
                int i9 = i8 % 128;
                $11 = i9;
                int i10 = i8 % 2;
                byte[] bArr3 = ICustomTabsCallbackStubProxy;
                long j = 0;
                if (bArr3 != null) {
                    int i11 = i9 + 33;
                    $10 = i11 % 128;
                    if (i11 % 2 != 0) {
                        length2 = bArr3.length;
                        bArr2 = new byte[length2];
                    } else {
                        length2 = bArr3.length;
                        bArr2 = new byte[length2];
                    }
                    int i12 = 0;
                    while (i12 < length2) {
                        Object[] objArr3 = {Integer.valueOf(bArr3[i12])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 1;
                            byte b5 = (byte) (b4 - 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 45, (char) (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), 1263 - AndroidCharacter.getMirror('0'), 1011328145, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE});
                        }
                        bArr2[i12] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i12++;
                        j = 0;
                    }
                    bArr3 = bArr2;
                }
                if (bArr3 != null) {
                    int i13 = $10 + 123;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    byte[] bArr4 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 40, (char) (ExpandableListView.getPackedPositionType(0L) + 36241), (ViewConfiguration.getWindowTouchSlop() >> 8) + 2342, 371880939, false, $$g(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i15 = $10 + 107;
                $11 = i15 % 128;
                if (i15 % 2 == 0) {
                    i4 = ((i3 << iIntValue) >> 2) / ((int) (((long) onTransact) | (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                } else {
                    i4 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                }
                iCustomTabsCallback.c = i4 + i5;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(0, 0) + 41, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), Color.alpha(0) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr5 = ICustomTabsCallbackStubProxy;
                if (bArr5 != null) {
                    int i16 = $11 + 87;
                    $10 = i16 % 128;
                    if (i16 % 2 != 0) {
                        length = bArr5.length;
                        bArr = new byte[length];
                    } else {
                        length = bArr5.length;
                        bArr = new byte[length];
                    }
                    for (int i17 = 0; i17 < length; i17++) {
                        bArr[i17] = (byte) (((long) bArr5[i17]) ^ (-4629754035390455669L));
                    }
                    bArr5 = bArr;
                }
                if (bArr5 != null) {
                    int i18 = $11 + 123;
                    $10 = i18 % 128;
                    int i19 = i18 % 2;
                    z2 = true;
                } else {
                    z2 = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i20 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i20 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i20]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i21 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i21 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i21]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            String string = sb.toString();
            int i22 = $11 + 87;
            $10 = i22 % 128;
            int i23 = i22 % 2;
            objArr[0] = string;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x019f  */
    /* JADX WARN: Code duplicated, block: B:17:0x023d A[Catch: all -> 0x0a49, TryCatch #0 {all -> 0x0a49, blocks: (B:56:0x074d, B:58:0x076e, B:59:0x07bd, B:15:0x0229, B:17:0x023d, B:18:0x026b), top: B:96:0x0229 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0281  */
    /* JADX WARN: Code duplicated, block: B:26:0x0352  */
    /* JADX WARN: Code duplicated, block: B:55:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:58:0x076e A[Catch: all -> 0x0a49, TryCatch #0 {all -> 0x0a49, blocks: (B:56:0x074d, B:58:0x076e, B:59:0x07bd, B:15:0x0229, B:17:0x023d, B:18:0x026b), top: B:96:0x0229 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x07cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x08a8  */
    @Override // android.content.ContextWrapper
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
            int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
            char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
            int iResolveOpacity = 1041 - Drawable.resolveOpacity(0, 0);
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr2 = new Object[1];
            a(b, b, bArr[8], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cIndexOf, iResolveOpacity, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2020;
            Object[] objArr3 = new Object[1];
            b(278519247 - View.resolveSize(0, 0), (byte) View.resolveSize(0, 0), (-57) - View.MeasureSpec.getSize(0), (short) (75 - TextUtils.getOffsetAfter("", 0)), (-497420637) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(278519251 - TextUtils.getOffsetAfter("", 0), (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (-64) - KeyEvent.getDeadChar(0, 0), (short) ((-98) - ExpandableListView.getPackedPositionGroup(0L)), (ViewConfiguration.getTapTimeout() >> 16) - 497420616, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iMyTid = (Process.myTid() >> 22) + 26;
                    char c = (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1041;
                    byte b2 = $$a[5];
                    byte b3 = b2;
                    Object[] objArr5 = new Object[1];
                    a(b2, b3, b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iMyTid, c, tapTimeout, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iNextInt = new Random().nextInt(1854563803);
                int i4 = (((1628395911 + (((~((~iNextInt) | (-423757474))) | (-345653667)) * (-235))) + (((~((-423757474) | iNextInt)) | (-345653667)) * (-470))) + (((~(iNextInt | (-268566689))) | (-500844452)) * 235)) - 369942325;
                int i5 = (i4 << 13) ^ i4;
                int i6 = i5 ^ (i5 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i6 ^ (i6 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                b(278519257 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) View.resolveSize(0, 0), TextUtils.indexOf("", "", 0) - 63, (short) ((-74) - Color.green(0)), (ViewConfiguration.getTapTimeout() >> 16) - 497420602, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                b(View.resolveSize(0, 0) + 278519255, (byte) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (Process.myPid() >> 22) - 63, (short) ((-5) - View.resolveSizeAndState(0, 0, 0)), (-497420587) - TextUtils.getTrimmedLength(""), objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {990112059};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 9, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 22250), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -369942325, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 27;
                        char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int threadPriority = 1041 - ((Process.getThreadPriority(0) + 20) >> 6);
                        byte b4 = $$a[5];
                        byte b5 = b4;
                        Object[] objArr10 = new Object[1];
                        a(b4, b5, b5, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionChild, doubleTapTimeout, threadPriority, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        b(278519247 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) (AndroidCharacter.getMirror('0') - '0'), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 57, (short) (TextUtils.getTrimmedLength("") + 75), TextUtils.lastIndexOf("", '0', 0, 0) - 497420636, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        b(278519251 - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) - 64, (short) ((-98) - TextUtils.indexOf("", "", 0)), (-497420616) - View.getDefaultSize(0, 0), objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int defaultSize = 26 - View.getDefaultSize(0, 0);
                            char c2 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            int gidForName = 1040 - Process.getGidForName("");
                            byte[] bArr2 = $$a;
                            byte b6 = bArr2[5];
                            Object[] objArr13 = new Object[1];
                            a(b6, b6, bArr2[8], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(defaultSize, c2, gidForName, 2061780482, false, (String) objArr13[0], null);
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
            b(278519257 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) View.resolveSize(0, 0), TextUtils.indexOf("", "", 0) - 63, (short) ((-74) - Color.green(0)), (ViewConfiguration.getTapTimeout() >> 16) - 497420602, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b(View.resolveSize(0, 0) + 278519255, (byte) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (Process.myPid() >> 22) - 63, (short) ((-5) - View.resolveSizeAndState(0, 0, 0)), (-497420587) - TextUtils.getTrimmedLength(""), objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {990112059};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 9, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 22250), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -369942325, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 27;
                char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                int threadPriority2 = 1041 - ((Process.getThreadPriority(0) + 20) >> 6);
                byte b7 = $$a[5];
                byte b8 = b7;
                Object[] objArr17 = new Object[1];
                a(b7, b8, b8, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, doubleTapTimeout2, threadPriority2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            b(278519247 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) (AndroidCharacter.getMirror('0') - '0'), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 57, (short) (TextUtils.getTrimmedLength("") + 75), TextUtils.lastIndexOf("", '0', 0, 0) - 497420636, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            b(278519251 - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) - 64, (short) ((-98) - TextUtils.indexOf("", "", 0)), (-497420616) - View.getDefaultSize(0, 0), objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int defaultSize2 = 26 - View.getDefaultSize(0, 0);
                char c3 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int gidForName2 = 1040 - Process.getGidForName("");
                byte[] bArr3 = $$a;
                byte b9 = bArr3[5];
                Object[] objArr110 = new Object[1];
                a(b9, b9, bArr3[8], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(defaultSize2, c3, gidForName2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i8 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i8 == i7) {
            int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
            artificialFrame = i9 % 128;
            int i10 = i9 % 2;
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i14 = i11 + (-163309522) + (((~(iIdentityHashCode | 1028147374)) | 950043567) * (-668)) + ((1028147374 | (~(950043567 | iIdentityHashCode))) * 1336) + ((iIdentityHashCode | 1038666671) * 668);
            int i15 = (i14 << 13) ^ i14;
            int i16 = i15 ^ (i15 >>> 17);
            ((int[]) objArr20[1])[0] = i16 ^ (i16 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i17 = artificialFrame + 63;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i17 % 128;
                int i18 = 2;
                int i19 = i17 % 2;
                int i20 = 0;
                while (i20 < strArr3.length) {
                    int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
                    artificialFrame = i21 % 128;
                    if (i21 % i18 == 0) {
                        arrayList.add(strArr3[i20]);
                        i20 += 3;
                    } else {
                        arrayList.add(strArr3[i20]);
                        i20++;
                    }
                    i18 = 2;
                }
            }
            long j3 = (((long) 1825589567) << 32) ^ ((long) (i7 ^ i8));
            long j4 = 1825589565;
            int i22 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
            int i23 = i22 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr4 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr4[61], bArr4[69], bArr4[5], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((byte) (bArr4[69] + 1), bArr4[5], (byte) (-bArr4[37]), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i25 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i27 = i24 + (-1209245774) + (((~(iMaxMemory | 58844791)) | (-19259016)) * (-668)) + ((58844791 | (~((-19259016) | iMaxMemory))) * 1336) + ((iMaxMemory | (-2365569)) * 668);
                int i28 = (i27 << 13) ^ i27;
                int i29 = i28 ^ (i28 >>> 17);
                ((int[]) objArr24[1])[0] = i29 ^ (i29 << 5);
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
            int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
            char fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 30068);
            int i30 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 816;
            byte[] bArr5 = $$a;
            byte b10 = bArr5[5];
            Object[] objArr25 = new Object[1];
            a(b10, b10, bArr5[8], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout, fadingEdgeLength, i30, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1907;
            Object[] objArr26 = new Object[1];
            b(TextUtils.indexOf((CharSequence) "", '0', 0) + 278519248, (byte) (TextUtils.lastIndexOf("", '0') + 1), (Process.myPid() >> 22) - 57, (short) (75 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (-497420637) - (ViewConfiguration.getTapTimeout() >> 16), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            b((ViewConfiguration.getScrollBarSize() >> 8) + 278519251, (byte) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (-64) - Gravity.getAbsoluteGravity(0, 0), (short) (Process.getGidForName("") - 97), (-497420616) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                artificialFrame = i31 % 128;
                int i32 = i31 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char touchSlop = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 30068);
                    int iIndexOf = TextUtils.indexOf("", "", 0) + 816;
                    byte b11 = $$a[5];
                    byte b12 = b11;
                    Object[] objArr28 = new Object[1];
                    a(b11, b12, b12, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, touchSlop, iIndexOf, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i33 = ((int[]) objArr29[0])[0];
                int i34 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i35 = ~iIdentityHashCode2;
                int i36 = ((((-461947655) + (((~((-137396531) | i35)) | 335568896) * 220)) + (((~(i35 | (-729123136))) | 927295501) * (-440))) + ((iIdentityHashCode2 | (-137396531)) * 220)) - 343782183;
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                ((int[]) objArr[3])[0] = i38 ^ (i38 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                b(278519256 - (ViewConfiguration.getFadingEdgeLength() >> 16), (byte) (KeyEvent.getMaxKeyCode() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 63, (short) ((-74) - View.MeasureSpec.getMode(0)), Color.red(0) - 497420602, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                b((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 278519254, (byte) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (-64) - ExpandableListView.getPackedPositionChild(0L), (short) (((byte) KeyEvent.getModifierMetaStateMask()) - 4), (-514197803) - Color.rgb(0, 0, 0), objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -343782183};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int maximumDrawingCacheSize = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char c4 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int i39 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    byte b13 = (byte) ($$a[5] - 1);
                    byte b14 = b13;
                    Object[] objArr33 = new Object[1];
                    a(b13, b14, b14, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c4, i39, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int capsMode = 25 - TextUtils.getCapsMode("", 0, 0);
                    char c5 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int i40 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    byte b15 = $$a[5];
                    byte b16 = b15;
                    Object[] objArr34 = new Object[1];
                    a(b15, b16, b16, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode, c5, i40, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    b(MotionEvent.axisFromString("") + 278519248, (byte) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) - 57, (short) (76 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 497420637, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    b((ViewConfiguration.getJumpTapTimeout() >> 16) + 278519251, (byte) Color.blue(0), (-16777280) - Color.rgb(0, 0, 0), (short) ((-98) - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (-497420616) - Color.argb(0, 0, 0, 0), objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int i41 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                        char mode = (char) (View.MeasureSpec.getMode(0) + 30068);
                        int defaultSize3 = View.getDefaultSize(0, 0) + 816;
                        byte[] bArr6 = $$a;
                        byte b17 = bArr6[5];
                        Object[] objArr37 = new Object[1];
                        a(b17, b17, bArr6[8], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i41, mode, defaultSize3, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            b(278519256 - (ViewConfiguration.getFadingEdgeLength() >> 16), (byte) (KeyEvent.getMaxKeyCode() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 63, (short) ((-74) - View.MeasureSpec.getMode(0)), Color.red(0) - 497420602, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            b((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 278519254, (byte) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (-64) - ExpandableListView.getPackedPositionChild(0L), (short) (((byte) KeyEvent.getModifierMetaStateMask()) - 4), (-514197803) - Color.rgb(0, 0, 0), objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -343782183};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int maximumDrawingCacheSize2 = 25 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char c6 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i310 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte b18 = (byte) ($$a[5] - 1);
                byte b19 = b18;
                Object[] objArr311 = new Object[1];
                a(b18, b19, b19, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, c6, i310, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int capsMode2 = 25 - TextUtils.getCapsMode("", 0, 0);
                char c7 = (char) (30069 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                int i42 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte b110 = $$a[5];
                byte b111 = b110;
                Object[] objArr312 = new Object[1];
                a(b110, b111, b111, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(capsMode2, c7, i42, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            b(MotionEvent.axisFromString("") + 278519248, (byte) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) - 57, (short) (76 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 497420637, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            b((ViewConfiguration.getJumpTapTimeout() >> 16) + 278519251, (byte) Color.blue(0), (-16777280) - Color.rgb(0, 0, 0), (short) ((-98) - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (-497420616) - Color.argb(0, 0, 0, 0), objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int i43 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                char mode2 = (char) (View.MeasureSpec.getMode(0) + 30068);
                int defaultSize4 = View.getDefaultSize(0, 0) + 816;
                byte[] bArr7 = $$a;
                byte b112 = bArr7[5];
                Object[] objArr315 = new Object[1];
                a(b112, b112, bArr7[8], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i43, mode2, defaultSize4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i44 = ((int[]) objArr[1])[0];
        int i45 = ((int[]) objArr[0])[0];
        if (i45 == i44) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i46 = ((int[]) objArr[3])[0];
            int i47 = ((int[]) objArr[0])[0];
            int i48 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i49 = ~((~((int) Runtime.getRuntime().maxMemory())) | (-842067211));
            int i50 = i46 + ((((-1043394523) | i49) * (-970)) - 296197409) + ((i49 | 201327312) * 970);
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
        Object[] objArr41 = {Long.valueOf(((long) (i44 ^ i45)) ^ (((long) 1559727879) << 32)), Long.valueOf(1559727878)};
        byte[] bArr8 = $$d;
        Object[] objArr42 = new Object[1];
        c((byte) 55, (byte) 79, bArr8[68], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((byte) (bArr8[69] + 1), bArr8[5], (byte) (-bArr8[37]), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i53 = ((int[]) objArr[3])[0];
        int i54 = ((int[]) objArr[0])[0];
        int i55 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int iIdentityHashCode3 = System.identityHashCode(this);
        int i56 = i53 + 1388598763 + (((~(iIdentityHashCode3 | (-437479273))) | 635651638) * 191) + (((~((~iIdentityHashCode3) | (-437479273))) | 214560) * 191);
        int i57 = (i56 << 13) ^ i56;
        int i58 = i57 ^ (i57 >>> 17);
        ((int[]) objArr44[3])[0] = i58 ^ (i58 << 5);
    }
}
