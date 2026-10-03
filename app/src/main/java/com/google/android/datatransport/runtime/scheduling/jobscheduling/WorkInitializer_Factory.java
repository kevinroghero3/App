package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.ICustomTabsCallbackDefault;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    private static short[] ICustomTabsService;
    private final Provider<Executor> executorProvider;
    private final Provider<SynchronizationGuard> guardProvider;
    private final Provider<WorkScheduler> schedulerProvider;
    private final Provider<EventStore> storeProvider;
    private static final byte[] $$c = {104, 117, 100, 60};
    private static final int $$d = 238;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.SYN, -75, -19, -49, Ascii.FF, 6, -27, Ascii.SYN, Ascii.SUB, -4, Ascii.FF, 0, 8, 2, 8};
    private static final int $$b = 172;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long coroutineBoundary = -4191265354877982270L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 11596;
    private static int onTransact = -1032790813;
    private static int mayLaunchUrl = -81862403;
    private static int getInterfaceDescriptor = -1635103347;
    private static byte[] ICustomTabsCallbackStubProxy = {-52, -8, -43, -48, 114, -30, 122, -64, -101, -43, -37, -36, 52, -28, -22, 118, 124, -45, 127, 115, 36, -84, -118, -44, 118, 100, Ascii.VT, 100, -9, 83, 106, -17, 95, -19, -14, Ascii.VT, 38, -27, 107, 81, -71, 35, 77, Ascii.VT, 105, 34, 6, -11, 58, 19, 44, Ascii.CR, -114, -85, -87, 104, -97, 76, 88, -78, -42, -39, -118, -74, -93, -126, -32, -125, -113, -48, -114, -122, -41, -34, -73, -100, -36, -125, 8, Ascii.FF, -108, -14, 3, -12, -94, -110, -4, -105, -85, Ascii.FF, -106, -98, 3, 6, -29, -2, 107, 3, 6, 3, -34, 94, Ascii.SO, 4, -104, -106, -13, -105, -109, 78, -58, -92, -2, -104, -25, -63, -26, -6, -47, -5, -29, -46, -21, -78, -61, 58, -46, -21, -46, -93, 35, -45, -23, -19, -5, -62, -26, -30, -109, 43, 9, -61, -19, -54, -124, -80, -97, -80, 124, -44, -102, -55, -29, -127, -28, -8, 113, -25, -17, 112, 119, -112, -60, -29, -127, -43, 119, -19, -117, -28, 65, 8, Ascii.SO, Ascii.SO, 105, 90, -13, 67, -4, 8, SignedBytes.MAX_POWER_OF_TWO, 69, 6, 32, 10, 91, 113, -61, 100, -75, 119, 104, 3, 122, -49, 36, -79, -33, 105, -53, -64, 81, -68, -74, 122, 87, -98, -68, SignedBytes.MAX_POWER_OF_TWO, -56, 119, -128, -94, 104, -50, -65, -91, -70, -66, 3, -95, -14, -46, 119, -43, -124, -45, -94, -119, Ascii.CAN, -124, -115, -43, -124, -45, -126, -87, -56, -33, -40, -47, -116, -44, -127, 126, -23, 113, -20, 126, -121, -37, -23, 113, -31, 123, 125, -126, -49, 120, -23, -50, -52, 33, Ascii.DC2, 77, Ascii.SO, Ascii.DC4, 44, Ascii.FS, 34, 40, 57, 72, -23, Ascii.NAK, 104, -48, 44, 33, Ascii.EM, 44, 43, 38, 93, -32, Ascii.ETB, Ascii.DLE, Ascii.NAK, 36, Ascii.FS, 37, 66, -33, -47, 77, Utf8.REPLACEMENT_BYTE, -33, 75, -46, -38, 50, -25, 74, Ascii.EM, -10, -39, -45, Ascii.US, -5, -45, -97, -116, -36, -36, -101, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117, -117};

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, byte r7, int r8) {
        /*
            int r7 = r7 + 98
            int r8 = r8 * 4
            int r8 = 1 - r8
            int r6 = r6 * 2
            int r6 = 4 - r6
            byte[] r0 = com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory.$$c
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory.$$e(byte, byte, int):java.lang.String");
    }

    private static void b(int i, int i2, byte b, Object[] objArr) {
        int i3 = b * 5;
        byte[] bArr = $$a;
        int i4 = (i * 3) + 112;
        int i5 = 12 - (i2 * 8);
        byte[] bArr2 = new byte[9 - i3];
        int i6 = 8 - i3;
        int i7 = -1;
        if (bArr == null) {
            i4 = (i6 + i5) - 7;
            i5++;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i5;
            i4 = (i4 + bArr[i5]) - 7;
            i5 = i9 + 1;
            i7 = i8;
        }
    }

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.executorProvider = provider;
        this.storeProvider = provider2;
        this.schedulerProvider = provider3;
        this.guardProvider = provider4;
    }

    @Override // javax.inject.Provider
    public WorkInitializer get() {
        return newInstance(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }

    public static WorkInitializer_Factory create(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        int i3 = 0;
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        int i4 = $11 + 73;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (iCustomTabsCallbackDefault.a < length3) {
            try {
                Object[] objArr2 = {iCustomTabsCallbackDefault};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                if (objAccessartificialFrame == null) {
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 33;
                    char cMyTid = (char) (Process.myTid() >> 22);
                    int iResolveSizeAndState = View.resolveSizeAndState(i3, i3, i3) + 1483;
                    byte b = (byte) i3;
                    byte b2 = (byte) (b + 1);
                    String str$$e = $$e(b, b2, (byte) (b2 - 1));
                    Class[] clsArr = new Class[1];
                    clsArr[i3] = Object.class;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(edgeSlop, cMyTid, iResolveSizeAndState, 1614432829, false, str$$e, clsArr);
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                try {
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 32;
                        char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49167);
                        int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 900;
                        byte b3 = (byte) i3;
                        byte b4 = (byte) (b3 + 3);
                        String str$$e2 = $$e(b3, b4, (byte) (b4 - 3));
                        Class[] clsArr2 = new Class[1];
                        clsArr2[i3] = Object.class;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c2, modifierMetaStateMask, 214239564, false, str$$e2, clsArr2);
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    int i6 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                    try {
                        Object[] objArr4 = new Object[3];
                        objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                        objArr4[1] = Integer.valueOf(i6);
                        objArr4[i3] = iCustomTabsCallbackDefault;
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) i3;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - Drawable.resolveOpacity(i3, i3), (char) TextUtils.getTrimmedLength(""), 2441 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        try {
                            Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = (byte) (b7 + 2);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0') + 21, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29753), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1747, 1479752515, false, $$e(b7, b8, (byte) (b8 - 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                            cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                            cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                            iCustomTabsCallbackDefault.a++;
                            int i7 = $10 + 81;
                            $11 = i7 % 128;
                            int i8 = i7 % 2;
                            i3 = 0;
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
        int i9 = $10 + 1;
        $11 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x01b2 A[PHI: r9
  0x01b2: PHI (r9v6 int) = (r9v5 int), (r9v24 int) binds: [B:43:0x01b0, B:40:0x019f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x01b4 A[PHI: r9
  0x01b4: PHI (r9v21 int) = (r9v5 int), (r9v24 int) binds: [B:43:0x01b0, B:40:0x019f] A[DONT_GENERATE, DONT_INLINE]] */
    private static void c(int i, short s, byte b, int i2, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4;
        int i5;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(40 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (36241 - Gravity.getAbsoluteGravity(0, 0)), 2342 - KeyEvent.keyCodeFromString(""), 371880939, false, $$e(b2, (byte) (b2 | Ascii.SO), b2), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                z = true;
            } else {
                int i7 = $11 + 3;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                z = false;
            }
            if (z) {
                int i9 = $10 + 115;
                int i10 = i9 % 128;
                $11 = i10;
                int i11 = i9 % 2;
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int i12 = i10 + 23;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i14 = 0; i14 < length; i14++) {
                        try {
                            Object[] objArr3 = {Integer.valueOf(bArr[i14])};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(44 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.resolveSize(0, 0), 1214 - ((byte) KeyEvent.getModifierMetaStateMask()), 1011328145, false, $$e(b3, (byte) (b3 | 19), b3), new Class[]{Integer.TYPE});
                            }
                            bArr2[i14] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 41, (char) (36240 - ImageFormat.getBitsPerPixel(0)), (ViewConfiguration.getLongPressTimeout() >> 16) + 2342, 371880939, false, $$e(b4, (byte) (b4 | Ascii.SO), b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i15 = $10;
                int i16 = i15 + 7;
                $11 = i16 % 128;
                if (i16 % 2 == 0) {
                    i4 = ((i / iIntValue) + 2) - ((int) (((long) onTransact) * (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        int i17 = i15 + 1;
                        $11 = i17 % 128;
                        int i18 = i17 % 2;
                        i5 = 0;
                    }
                } else {
                    i4 = ((i + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L)));
                    if (z) {
                        i5 = 1;
                    } else {
                        int i19 = i15 + 1;
                        $11 = i19 % 128;
                        int i110 = i19 % 2;
                        i5 = 0;
                    }
                }
                iCustomTabsCallback.c = i4 + i5;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i3), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 41, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 4066 - View.MeasureSpec.getMode(0), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i20 = 0; i20 < length2; i20++) {
                        int i21 = $11 + 55;
                        $10 = i21 % 128;
                        int i22 = i21 % 2;
                        bArr5[i20] = (byte) (((long) bArr4[i20]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i23 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i23 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i23]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i24 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i24 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i24]) ^ (-4629754035390455669L))) + s)) ^ b));
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

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5799 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v262, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v127 */
    /* JADX WARN: Type inference failed for: r1v130, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v133, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v135, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v143 */
    /* JADX WARN: Type inference failed for: r1v362, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v372, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v374 */
    /* JADX WARN: Type inference failed for: r1v375 */
    /* JADX WARN: Type inference failed for: r1v376 */
    /* JADX WARN: Type inference failed for: r1v377 */
    /* JADX WARN: Type inference failed for: r1v378, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v387, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v389 */
    /* JADX WARN: Type inference failed for: r1v390 */
    /* JADX WARN: Type inference failed for: r1v392 */
    /* JADX WARN: Type inference failed for: r1v393 */
    /* JADX WARN: Type inference failed for: r1v394 */
    /* JADX WARN: Type inference failed for: r1v401 */
    /* JADX WARN: Type inference failed for: r1v402 */
    /* JADX WARN: Type inference failed for: r1v404 */
    /* JADX WARN: Type inference failed for: r1v411 */
    /* JADX WARN: Type inference failed for: r1v419 */
    /* JADX WARN: Type inference failed for: r1v420 */
    /* JADX WARN: Type inference failed for: r1v425 */
    /* JADX WARN: Type inference failed for: r1v448 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51, types: [int] */
    /* JADX WARN: Type inference failed for: r1v605 */
    /* JADX WARN: Type inference failed for: r1v606 */
    /* JADX WARN: Type inference failed for: r1v607 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v91, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v100 */
    /* JADX WARN: Type inference failed for: r25v101 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12, types: [short] */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v15, types: [int] */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v32, types: [short] */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v54 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v74 */
    /* JADX WARN: Type inference failed for: r25v76 */
    /* JADX WARN: Type inference failed for: r25v83 */
    /* JADX WARN: Type inference failed for: r25v84 */
    /* JADX WARN: Type inference failed for: r25v85 */
    /* JADX WARN: Type inference failed for: r25v87 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r25v90 */
    /* JADX WARN: Type inference failed for: r25v91 */
    /* JADX WARN: Type inference failed for: r25v92 */
    /* JADX WARN: Type inference failed for: r25v93 */
    /* JADX WARN: Type inference failed for: r25v94 */
    /* JADX WARN: Type inference failed for: r25v95 */
    /* JADX WARN: Type inference failed for: r25v96 */
    /* JADX WARN: Type inference failed for: r25v97 */
    /* JADX WARN: Type inference failed for: r25v98 */
    /* JADX WARN: Type inference failed for: r25v99 */
    /* JADX WARN: Type inference failed for: r26v17 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v16 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v48 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r3v147, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r3v148 */
    /* JADX WARN: Type inference failed for: r3v154 */
    /* JADX WARN: Type inference failed for: r3v155 */
    /* JADX WARN: Type inference failed for: r3v198, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v221 */
    /* JADX WARN: Type inference failed for: r3v279, types: [android.security.keystore.KeyGenParameterSpec$Builder] */
    /* JADX WARN: Type inference failed for: r3v306, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v312, types: [android.security.keystore.KeyGenParameterSpec$Builder] */
    /* JADX WARN: Type inference failed for: r3v484 */
    /* JADX WARN: Type inference failed for: r3v485 */
    /* JADX WARN: Type inference failed for: r5v209 */
    /* JADX WARN: Type inference failed for: r5v210 */
    /* JADX WARN: Type inference failed for: r5v211, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r5v213, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r5v214 */
    /* JADX WARN: Type inference failed for: r5v215 */
    /* JADX WARN: Type inference failed for: r5v216 */
    /* JADX WARN: Type inference failed for: r5v228, types: [java.lang.Object, java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r5v257 */
    /* JADX WARN: Type inference failed for: r5v258 */
    /* JADX WARN: Type inference failed for: r5v263 */
    /* JADX WARN: Type inference failed for: r5v281 */
    /* JADX WARN: Type inference failed for: r5v298, types: [java.lang.Object, java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r5v510 */
    /* JADX WARN: Type inference failed for: r5v511 */
    /* JADX WARN: Type inference failed for: r5v88, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r6v140, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r6v69, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v322, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v323 */
    /* JADX WARN: Type inference failed for: r7v324 */
    /* JADX WARN: Type inference failed for: r7v325 */
    /* JADX WARN: Type inference failed for: r7v350 */
    /* JADX WARN: Type inference failed for: r7v604 */
    /* JADX WARN: Type inference failed for: r7v90, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v115 */
    /* JADX WARN: Type inference failed for: r8v171, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r8v18, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v204, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v209 */
    /* JADX WARN: Type inference failed for: r8v51 */
    /* JADX WARN: Type inference failed for: r8v522 */
    /* JADX WARN: Type inference failed for: r8v523 */
    /* JADX WARN: Type inference failed for: r8v59, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v60, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v63 */
    /* JADX WARN: Type inference failed for: r8v94, types: [java.lang.reflect.Method] */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r41, java.lang.String[] r42, int r43, int r44, int r45) {
        /*
            Method dump skipped, instruction units count: 18734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
