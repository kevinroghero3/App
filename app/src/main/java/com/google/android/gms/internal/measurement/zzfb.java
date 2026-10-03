package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.RemoteException;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfb extends zzds.zzb {
    private static short[] ICustomTabsService;
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzds.zzc zzd;
    private static final byte[] $$c = {103, -8, -85, 41};
    private static final int $$d = 40;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.SYN, -75, -19, -49, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, -50, 50, Ascii.SO};
    private static final int $$b = 249;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = 1063064076;
    private static int mayLaunchUrl = -81862436;
    private static int getInterfaceDescriptor = -1298714385;
    private static byte[] ICustomTabsCallbackStubProxy = {75, 0, 41, Ascii.VT, Ascii.RS, 5, 48, 47, -62, Ascii.RS, 19, Ascii.VT, Ascii.RS, 5, Ascii.DLE, 79, -46, 1, 2, 7, Ascii.SYN, Ascii.SO, Ascii.ETB, 48, Ascii.EM, 10, 37, -17, 3, 4, -11, Ascii.ETB, Ascii.FF, 8, Ascii.CR, Ascii.SO, 2, 51, -35, 19, Ascii.FF, SignedBytes.MAX_POWER_OF_TWO, Ascii.FF, -3, 40, -46, -10, Ascii.SI, -8, Ascii.SUB, -9, -13, -16, -15, -11, 38, Ascii.SUB, -76, -16, 75, -77, Ascii.SI, Ascii.FF, -28, Ascii.SI, -10, 1, 56, -61, -14, -13, -16, 7, -1, 0, 37, -104, -122, 119, -122, 78, -75, Ascii.SUB, -99, -51, -36, -59, -52, -58, -76, -21, -63, -59, Ascii.SI, -99, -51, -57, -58, 1, -125, -45, -61, -39, Ascii.FF, -110, -73, -41, 8, Base64.padSymbol, 81, 96, 105, 80, 106, 88, 127, 85, 105, -100, 43, 85, 33};

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, byte r8, int r9) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 4
            int r7 = r7 * 5
            int r7 = r7 + 112
            int r8 = r8 * 3
            int r8 = r8 + 1
            byte[] r0 = com.google.android.gms.internal.measurement.zzfb.$$c
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r4 = r2
            goto L29
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L24:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L29:
            int r7 = r7 + r9
            int r9 = r3 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.$$e(int, byte, int):java.lang.String");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfb(zzds.zzc zzcVar, Activity activity) {
        super(zzds.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    private static void b(short s, byte b, short s2, Object[] objArr) {
        int i = s + 4;
        byte[] bArr = $$a;
        int i2 = 115 - s2;
        byte[] bArr2 = new byte[b + 2];
        int i3 = b + 1;
        int i4 = -1;
        if (bArr == null) {
            i++;
            i2 = (i3 + i2) - 5;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i2;
            if (i4 == i3) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i++;
                i2 = (i2 + bArr[i]) - 5;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(zzds.this.zzj)).onActivityPaused(ObjectWrapper.wrap(this.zzc), this.zzb);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x01a2  */
    private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        long j;
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
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(41 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (36241 - TextUtils.getCapsMode("", 0, 0)), 2342 - View.resolveSizeAndState(0, 0, 0), 371880939, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i7 = $11 + 43;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                z = true;
            } else {
                int i9 = $11 + 79;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                z = false;
            }
            if (!z) {
                j = -4629754035390455669L;
            } else {
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i11 = 0;
                    while (i11 < length) {
                        Object[] objArr3 = {Integer.valueOf(bArr[i11])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 1;
                            byte b5 = (byte) (b4 - 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(44 - TextUtils.getOffsetBefore("", 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0), 1214 - ImageFormat.getBitsPerPixel(0), 1011328145, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                        }
                        bArr2[i11] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i11++;
                        int i12 = $10 + 27;
                        $11 = i12 % 128;
                        if (i12 % 2 == 0) {
                            int i13 = 2 % 3;
                        }
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 39, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 36241), View.getDefaultSize(0, 0) + 2342, 371880939, false, $$e(b6, b7, b7), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i14 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (!z) {
                    i4 = 0;
                } else {
                    int i15 = $11 + 37;
                    $10 = i15 % 128;
                    if (i15 % 2 != 0) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                }
                iCustomTabsCallback.c = i14 + i4;
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(41 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 4066 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    loop0: while (true) {
                        int i16 = 0;
                        while (true) {
                            if (i16 >= length2) {
                                break loop0;
                            }
                            int i17 = $11 + 79;
                            $10 = i17 % 128;
                            if (i17 % 2 != 0) {
                                bArr5[i16] = (byte) (((long) bArr4[i16]) - (-4629754035390455669L));
                            } else {
                                bArr5[i16] = (byte) (((long) bArr4[i16]) ^ (-4629754035390455669L));
                                i16++;
                            }
                        }
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                int i18 = $10 + 121;
                $11 = i18 % 128;
                int i19 = i18 % 2;
                while (iCustomTabsCallback.a < iIntValue) {
                    int i20 = $11 + 107;
                    int i21 = i20 % 128;
                    $10 = i21;
                    int i22 = i20 % 2;
                    if (z2) {
                        int i23 = i21 + 29;
                        $11 = i23 % 128;
                        if (i23 % 2 == 0) {
                            byte[] bArr6 = ICustomTabsCallbackStubProxy;
                            int i24 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i24;
                            i5 = iCustomTabsCallback.createBrowser * (((byte) (((byte) (((long) bArr6[i24]) ^ (-4629754035390455669L))) >> s)) ^ b);
                        } else {
                            byte[] bArr7 = ICustomTabsCallbackStubProxy;
                            int i25 = iCustomTabsCallback.c;
                            iCustomTabsCallback.c = i25 - 1;
                            i5 = iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr7[i25]) ^ (-4629754035390455669L))) + s)) ^ b);
                        }
                        iCustomTabsCallback.createConnectionCallback = (char) i5;
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i26 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i26 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i26]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r31, int r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 3613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
