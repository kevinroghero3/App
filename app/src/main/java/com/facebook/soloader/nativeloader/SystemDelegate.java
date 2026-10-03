package com.facebook.soloader.nativeloader;

import com.google.common.base.Ascii;
import o.ICustomTabsCallbackDefault;
import o.artificialFrame;

/* JADX INFO: loaded from: classes.dex */
public class SystemDelegate implements NativeLoaderDelegate {
    private static final byte[] access000 = {66, -118, -118, 77, 1, 3, -12, -26, Ascii.ESC, -9, Ascii.SO, -19, Ascii.SI, 5};
    private static final int INotificationSideChannelStubProxy = 169;
    private static int[] ICustomTabsCallbackStub = {-183403189, 1415613801, 1340150464, 1136764336, -1980926772, 181818967, -807252608, -1914731429, 48048654, 1488532634, 1091850030, 1165358919, -1165078449, 1009401509, 818331055, -899086016, 1791545097, -1912921903};
    private static long coroutineBoundary = 8031585348013098793L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 11596;

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public String getLibraryPath(String str) {
        return null;
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public int getSoSourcesVersion() {
        return 0;
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(String str, int i) {
        CoroutineDebuggingKt(str);
        return true;
    }

    private static void b(int i, int[] iArr, Object[] objArr) {
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (((long) iArr2[i2]) ^ 8786114107090493297L);
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (((long) iArr5[i3]) ^ 8786114107090493297L);
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                artificialframe.c ^= iArr4[i4];
                artificialframe.b = artificialFrame.coroutineBoundary(artificialframe.c) ^ artificialframe.b;
                int i5 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i5;
            }
            int i6 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i6;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i7 = artificialframe.c;
            int i8 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            artificialframe.e += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) {
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
        while (iCustomTabsCallbackDefault.a < length3) {
            int i2 = (iCustomTabsCallbackDefault.a + 2) % 4;
            int i3 = (iCustomTabsCallbackDefault.a + 3) % 4;
            iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback = (char) (((cArr4[iCustomTabsCallbackDefault.a % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
            cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[i3] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
            iCustomTabsCallbackDefault.a++;
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.facebook.soloader.nativeloader.SystemDelegate.access000
            int r8 = r8 * 3
            int r1 = 11 - r8
            int r6 = r6 * 3
            int r6 = r6 + 102
            int r7 = r7 + 4
            byte[] r1 = new byte[r1]
            int r8 = 10 - r8
            r2 = 0
            if (r0 != 0) goto L17
            r6 = r7
            r4 = r8
            r3 = r2
            goto L2e
        L17:
            r3 = r2
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.nativeloader.SystemDelegate.c(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 39841. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private static void CoroutineDebuggingKt(java.lang.String r34) {
        /*
            Method dump skipped, instruction units count: 3984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.nativeloader.SystemDelegate.CoroutineDebuggingKt(java.lang.String):void");
    }
}
