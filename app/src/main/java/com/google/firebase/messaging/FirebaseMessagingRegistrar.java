package com.google.firebase.messaging;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.datatransport.TransportFactory;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportBackend;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;

/* JADX INFO: loaded from: classes5.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static short[] ICustomTabsService = null;
    private static final String LIBRARY_NAME = "fire-fcm";
    private static final byte[] $$c = {98, -94, 86, -118};
    private static final int $$d = 72;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, Ascii.FF, -27, -23, Ascii.VT, 2, -12};
    private static final int $$b = 171;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = 349640032;
    private static int mayLaunchUrl = -81862520;
    private static int getInterfaceDescriptor = 1341026458;
    private static byte[] ICustomTabsCallbackStubProxy = {-101, -96, -82, 78, -95, -88, 95, -96, 115, -114, 82, -95, 95, -83, 76, -94, 126, -114, 85, -124, -22, Ascii.EM, -25, Ascii.NAK, -12, Ascii.SUB, -58, 53, -28, -50, 56, Ascii.RS, -30, Ascii.DC2, -20, -17, Ascii.CR, -122, -59, 36, -54, Ascii.SYN, 33, -116, 51, 118, -3, -52, -51, -54, 57, -63, 58, -82, 114, 125, 125, -112, -127, 106, -108, 121, 118, -116, 127, -126, 109, 75, -73, -122, 122, 121, 125, -112, -127, 58, -73, -115, 108, -126, 126, 74, -68, 120, -120, -125, 114, -123, 67, -61, -123, 121, 59, -117, 59, 59, -105, -11, -13, 0, Ascii.VT, -7, 3, Ascii.FF, -16, 8, 8, -27, -12, 4, Base64.padSymbol, -55, Ascii.CR, -3, -10, 7, -16, 54, -74, -16, Ascii.FF, 78, -58, -2, -9, 8, 75, 117, -86, -79, 94, -74, -73, 75, 72, 76, -95, -80, Ascii.VT, -122, -73, 75, 72, 76, -95, -80, Ascii.VT, -122, -68, 93, -77, 79, 123, -115, 73, -71, -78, 67, -76, 114, -14, -76, 72, 10};

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r5, byte r6, short r7) {
        /*
            int r5 = r5 * 2
            int r5 = 3 - r5
            byte[] r0 = com.google.firebase.messaging.FirebaseMessagingRegistrar.$$c
            int r6 = r6 * 4
            int r1 = 1 - r6
            int r7 = r7 * 5
            int r7 = 117 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L18
            r3 = r6
            r4 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            int r5 = r5 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L28:
            r3 = r0[r5]
        L2a:
            int r7 = r7 + r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingRegistrar.$$e(byte, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.firebase.messaging.FirebaseMessagingRegistrar.$$a
            int r5 = r5 * 3
            int r5 = r5 + 109
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r6 = r6 * 3
            int r1 = r6 + 4
            byte[] r1 = new byte[r1]
            int r6 = r6 + 3
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r6
            r3 = r2
            goto L2c
        L18:
            r3 = r2
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L28:
            r4 = r0[r7]
            int r3 = r3 + 1
        L2c:
            int r5 = r5 + r4
            int r5 = r5 + (-3)
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingRegistrar.b(int, byte, int, java.lang.Object[]):void");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualified = Qualified.qualified(TransportBackend.class, TransportFactory.class);
        return Arrays.asList(Component.builder(FirebaseMessaging.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.optional(FirebaseInstanceIdInternal.class)).add(Dependency.optionalProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.optionalProvider((Class<?>) HeartBeatInfo.class)).add(Dependency.required((Class<?>) FirebaseInstallationsApi.class)).add(Dependency.optionalProvider((Qualified<?>) qualified)).add(Dependency.required((Class<?>) Subscriber.class)).factory(new ComponentFactory() { // from class: com.google.firebase.messaging.FirebaseMessagingRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return FirebaseMessagingRegistrar.lambda$getComponents$0(qualified, componentContainer);
            }
        }).alwaysEager().build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(qualified), (Subscriber) componentContainer.get(Subscriber.class));
    }

    private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        long j;
        boolean z;
        int i4;
        int length;
        byte[] bArr;
        int i5;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            float f = 0.0f;
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 36241), (ViewConfiguration.getTouchSlop() >> 8) + 2342, 371880939, false, $$e(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            int i7 = (iIntValue == -1 ? 0 : 1) ^ 1;
            long j2 = 0;
            if (i7 == 0) {
                j = -4629754035390455669L;
            } else {
                byte[] bArr2 = ICustomTabsCallbackStubProxy;
                if (bArr2 != null) {
                    int i8 = $10 + 61;
                    $11 = i8 % 128;
                    if (i8 % 2 == 0) {
                        length = bArr2.length;
                        bArr = new byte[length];
                        i5 = 1;
                    } else {
                        length = bArr2.length;
                        bArr = new byte[length];
                        i5 = 0;
                    }
                    while (i5 < length) {
                        try {
                            Object[] objArr3 = {Integer.valueOf(bArr2[i5])};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame2 == null) {
                                int trimmedLength = 44 - TextUtils.getTrimmedLength("");
                                char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(j2) + 1);
                                int i9 = 1216 - (AudioTrack.getMaxVolume() > f ? 1 : (AudioTrack.getMaxVolume() == f ? 0 : -1));
                                byte b4 = (byte) 0;
                                byte b5 = b4;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(trimmedLength, packedPositionChild, i9, 1011328145, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                            }
                            bArr[i5] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                            i5++;
                            f = 0.0f;
                            j2 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    bArr2 = bArr;
                }
                if (bArr2 != null) {
                    int i10 = $10 + 87;
                    $11 = i10 % 128;
                    if (i10 % 2 == 0) {
                        byte[] bArr3 = ICustomTabsCallbackStubProxy;
                        Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (36242 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2342, 371880939, false, $$e(b6, b7, (byte) (b7 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        i4 = ((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) >> ((int) (((long) mayLaunchUrl) & (-4629754035390455669L)));
                    } else {
                        byte[] bArr4 = ICustomTabsCallbackStubProxy;
                        Object[] objArr5 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame4 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = b8;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 41, (char) (36241 - (ViewConfiguration.getWindowTouchSlop() >> 8)), 2342 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 371880939, false, $$e(b8, b9, (byte) (b9 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        i4 = ((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L)));
                    }
                    iIntValue = (byte) i4;
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                iCustomTabsCallback.c = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j)) + i7;
                Object[] objArr6 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 41, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), 4066 - Drawable.resolveOpacity(0, 0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr5 = ICustomTabsCallbackStubProxy;
                if (bArr5 != null) {
                    int length2 = bArr5.length;
                    byte[] bArr6 = new byte[length2];
                    for (int i11 = 0; i11 < length2; i11++) {
                        bArr6[i11] = (byte) (((long) bArr5[i11]) ^ (-4629754035390455669L));
                    }
                    bArr5 = bArr6;
                }
                if (bArr5 != null) {
                    int i12 = $11 + b.i;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    z = true;
                } else {
                    z = false;
                }
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i14 = $10 + 47;
                    int i15 = i14 % 128;
                    $11 = i15;
                    int i16 = i14 % 2;
                    if (z) {
                        int i17 = i15 + 99;
                        $10 = i17 % 128;
                        int i18 = i17 % 2;
                        byte[] bArr7 = ICustomTabsCallbackStubProxy;
                        int i19 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i19 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i19]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i20 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i20 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i20]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
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

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 40061. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] coroutineCreation(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 4006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingRegistrar.coroutineCreation(int, int):java.lang.Object[]");
    }
}
