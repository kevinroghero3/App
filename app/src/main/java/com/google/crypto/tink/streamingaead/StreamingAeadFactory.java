package com.google.crypto.tink.streamingaead;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.RegistryConfiguration;
import com.google.crypto.tink.StreamingAead;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class StreamingAeadFactory {
    private static final byte[] $$c = {119, 121, -44, Ascii.VT};
    private static final int $$d = 96;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {68, 66, 84, 89, -11, -2, Ascii.FF};
    private static final int $$b = 40;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -1986762926786891716L;

    private static String $$e(short s, short s2, byte b) {
        int i = s * 3;
        byte[] bArr = $$c;
        int i2 = 4 - (b * 3);
        int i3 = 118 - (s2 * 4);
        byte[] bArr2 = new byte[1 - i];
        int i4 = 0 - i;
        int i5 = -1;
        if (bArr == null) {
            i3 += i4;
            i2++;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i4) {
                return new String(bArr2, 0);
            }
            i3 += bArr[i2];
            i2++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 109 - r7
            int r8 = r8 * 2
            int r0 = 4 - r8
            int r6 = r6 * 4
            int r6 = r6 + 4
            byte[] r1 = com.google.crypto.tink.streamingaead.StreamingAeadFactory.$$a
            byte[] r0 = new byte[r0]
            int r8 = 3 - r8
            r2 = 0
            if (r1 != 0) goto L19
            r7 = r6
            r3 = r8
            r4 = r2
            goto L30
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r1[r6]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L30:
            int r6 = -r6
            int r7 = r7 + 1
            int r3 = r3 + r6
            int r6 = r3 + (-3)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.StreamingAeadFactory.b(byte, int, short, java.lang.Object[]):void");
    }

    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        StreamingAeadWrapper.register();
        return (StreamingAead) keysetHandle.getPrimitive(RegistryConfiguration.get(), StreamingAead.class);
    }

    private StreamingAeadFactory() {
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $10 + 67;
        $11 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 3 % 2;
        }
        while (asbinder.d < cArr.length) {
            int i5 = $11 + 45;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                int i6 = asbinder.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 11, (char) TextUtils.getTrimmedLength(""), 1408 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() % (extraCommand / (-2360974883025274865L));
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(7 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.getCapsMode("", 0, 0), 249 - (ViewConfiguration.getEdgeSlop() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i7 = asbinder.d;
                Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame3 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(10 - ExpandableListView.getPackedPositionChild(0L), (char) ((Process.getThreadPriority(0) + 20) >> 6), 1407 - View.resolveSizeAndState(0, 0, 0), 1035473698, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr5 = {asbinder, asbinder};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - '(', (char) (ViewConfiguration.getEdgeSlop() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i8 = $11 + 69;
        $10 = i8 % 128;
        int i9 = i8 % 2;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr6 = {asbinder, asbinder};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 8, (char) TextUtils.getCapsMode("", 0, 0), 249 - Color.red(0), 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
        }
        objArr[0] = new String(cArr2);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 2848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.streamingaead.StreamingAeadFactory.coroutineCreation(int, int):java.lang.Object[]");
    }
}
