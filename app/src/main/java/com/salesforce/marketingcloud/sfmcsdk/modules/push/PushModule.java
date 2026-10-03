package com.salesforce.marketingcloud.sfmcsdk.modules.push;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.sfmcsdk.modules.Module;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.onNavigationEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class PushModule extends Module {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "~$PushSdkModule";

    public static final class Companion {
        private static short[] ICustomTabsService;
        private static final byte[] $$a = {Ascii.SI, -1, -79, -103};
        private static final int $$b = 78;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int onTransact = -1494368048;
        private static int mayLaunchUrl = -81862509;
        private static int getInterfaceDescriptor = 926835254;
        private static byte[] ICustomTabsCallbackStubProxy = {-123, -128, 122, -116, -115, 126, -114, 124, -87, -85, -117, 112, 86, -95, 117, -117, 112, 54, -63, 77, 127, 116, -97, -72, 62, -114, -128, 124, 118, -103, 117, 121, -50, Base64.padSymbol, -100, 96, -98, 124, -116, 117, -109, 113, -100, 67, 112, 113, 118, -123, 125, -90, -113, 101, -88, 78, 121, -104, 118, -86, -81, 55, 112, 113, 118, -123, 125, -90, -113, 100, -128, -116, 121, -104, 118, -86, -81, 55, 112, 113, 118, -123, 125, -90, -113, 100, -128, -100, 67, 112, 113, 118, -123, 125, -90, -113, 101, -88, 82, 117, -109, 113, 114, -122, 117, -115, 120, -122, -97, 99, 117, -115, 125, -125, -119, -102, 87, -124, 117, -115, -126, 115, -82, 111, 117, -115, 125, -125, -119, -102, -87, 74, 118, -55, 49, -115, -126, 122, -115, 116, -121, -66, 65, 112, 113, 118, -123, 125, -122, 121, -123, 120, 118, -118, -104, 120, -116, 117, 125, 102, -126, 112, -116, 93, -122, -116, -120, 112, -102, -119, -112, 106, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, -98, 49, -119, -122, -119, -66, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, 120, -109, 100, -117, -70, 87, 122, 112, -68, 88, 112, 112, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, 85, 122, -104, 100, -122, 124, -126, 117, -127, 122, -104, 117, 113, -120, 118, 126, -119, -122, -87, -127, -126, 112, 86, -95, 49, -119, -122, -119, -66, 62, -114, -128, 124, 118, -103, 117, 121, -50, 70, 96, -98, 124, 116, -128, 122, -116, -115, 126, -114, 124, -87, -85, -117, 112, 86, 111, -102, 117, 112, -125, 102, -87, 84, -124, 117};
        private static int setDefaultImpl = -260894082;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r7, byte r8, byte r9) {
            /*
                int r8 = 117 - r8
                int r7 = r7 * 2
                int r7 = 3 - r7
                byte[] r0 = com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule.Companion.$$a
                int r9 = r9 * 4
                int r9 = r9 + 1
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L15
                r8 = r7
                r3 = r9
                r4 = r2
                goto L2b
            L15:
                r3 = r2
            L16:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r9) goto L23
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L23:
                int r7 = r7 + 1
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r6
            L2b:
                int r7 = r7 + r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule.Companion.$$c(byte, byte, byte):java.lang.String");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static void b(char[] cArr, int i, int i2, int i3, boolean z, Object[] objArr) throws Throwable {
            int i4 = 2 % 2;
            onNavigationEvent onnavigationevent = new onNavigationEvent();
            char[] cArr2 = new char[i];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i) {
                int i5 = $11 + 115;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                onnavigationevent.c = cArr[onnavigationevent.d];
                cArr2[onnavigationevent.d] = (char) (i3 + onnavigationevent.c);
                int i7 = onnavigationevent.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                    if (objAccessartificialFrame == null) {
                        int maximumDrawingCacheSize = 22 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0));
                        int minimumFlingVelocity = 1775 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        byte b = (byte) ($$a[1] + 1);
                        byte b2 = (byte) (b + 3);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cLastIndexOf, minimumFlingVelocity, -2069783171, false, $$c(b, b2, (byte) (b2 - 3)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 37;
                        char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 56277);
                        int gidForName = Process.getGidForName("") + 1260;
                        byte b3 = $$a[1];
                        byte b4 = (byte) (b3 + 1);
                        byte b5 = (byte) (-b3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, keyRepeatTimeout, gidForName, 711931141, false, $$c(b4, b5, (byte) (b5 - 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (i2 > 0) {
                int i8 = $10 + 17;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                onnavigationevent.b = i2;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - onnavigationevent.b, onnavigationevent.b);
                System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i - onnavigationevent.b);
            }
            if (z) {
                char[] cArr4 = new char[i];
                onnavigationevent.d = 0;
                int i10 = $11 + 7;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                while (onnavigationevent.d < i) {
                    cArr4[onnavigationevent.d] = cArr2[(i - onnavigationevent.d) - 1];
                    Object[] objArr4 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame3 == null) {
                        int i12 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 36;
                        char keyRepeatDelay = (char) (56277 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        int i13 = 1260 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        byte b6 = $$a[1];
                        byte b7 = (byte) (b6 + 1);
                        byte b8 = (byte) (-b6);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i12, keyRepeatDelay, i13, 711931141, false, $$c(b7, b8, (byte) (b8 - 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0226 A[PHI: r0
  0x0226: PHI (r0v9 int) = (r0v8 int), (r0v40 int) binds: [B:48:0x0224, B:45:0x0212] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:50:0x0228 A[PHI: r0
  0x0228: PHI (r0v37 int) = (r0v8 int), (r0v40 int) binds: [B:48:0x0224, B:45:0x0212] A[DONT_GENERATE, DONT_INLINE]] */
        private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
            int i4;
            int i5;
            int length;
            byte[] bArr;
            int i6 = 2;
            int i7 = 2 % 2;
            ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
                if (objAccessartificialFrame == null) {
                    int iIndexOf = 40 - TextUtils.indexOf("", "", 0, 0);
                    char c = (char) (36242 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int i8 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2341;
                    byte b2 = (byte) ($$a[1] + 1);
                    byte b3 = (byte) (b2 + 5);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, c, i8, 371880939, false, $$c(b2, b3, (byte) (b3 - 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                boolean z = iIntValue == -1;
                if (z) {
                    byte[] bArr2 = ICustomTabsCallbackStubProxy;
                    char c2 = '0';
                    if (bArr2 != null) {
                        int length2 = bArr2.length;
                        byte[] bArr3 = new byte[length2];
                        int i9 = 0;
                        while (i9 < length2) {
                            int i10 = $11 + 37;
                            $10 = i10 % 128;
                            if (i10 % i6 != 0) {
                                Object[] objArr3 = {Integer.valueOf(bArr2[i9])};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                if (objAccessartificialFrame2 == null) {
                                    int iLastIndexOf = 43 - TextUtils.lastIndexOf("", c2);
                                    char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                    int scrollBarFadeDuration = 1215 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                    byte b4 = (byte) ($$a[1] + 1);
                                    byte b5 = b4;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, keyRepeatTimeout, scrollBarFadeDuration, 1011328145, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE});
                                }
                                bArr3[i9] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                                i9 %= 0;
                            } else {
                                Object[] objArr4 = {Integer.valueOf(bArr2[i9])};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                if (objAccessartificialFrame3 == null) {
                                    int i11 = 44 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                    char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                                    int iCombineMeasuredStates = 1215 - View.combineMeasuredStates(0, 0);
                                    byte b6 = (byte) ($$a[1] + 1);
                                    byte b7 = b6;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i11, cCombineMeasuredStates, iCombineMeasuredStates, 1011328145, false, $$c(b6, b7, b7), new Class[]{Integer.TYPE});
                                }
                                bArr3[i9] = ((Byte) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).byteValue();
                                i9++;
                            }
                            i6 = 2;
                            c2 = '0';
                        }
                        bArr2 = bArr3;
                    }
                    if (bArr2 != null) {
                        int i12 = $10 + 63;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                        byte[] bArr4 = ICustomTabsCallbackStubProxy;
                        Object[] objArr5 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                        if (objAccessartificialFrame4 == null) {
                            int iIndexOf2 = 39 - TextUtils.indexOf((CharSequence) "", '0');
                            char c3 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36242);
                            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 2342;
                            byte b8 = (byte) ($$a[1] + 1);
                            byte b9 = (byte) (b8 + 5);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c3, minimumFlingVelocity, 371880939, false, $$c(b8, b9, (byte) (b9 - 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        iIntValue = (byte) (((byte) (((long) bArr4[((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    } else {
                        iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    }
                }
                if (iIntValue > 0) {
                    int i14 = $10 + 9;
                    $11 = i14 % 128;
                    if (i14 % 2 == 0) {
                        i4 = ((i3 >>> iIntValue) - 3) % ((int) (((long) onTransact) - (-4629754035390455669L)));
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
                    Object[] objArr6 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(216546027);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 41, (char) (ViewConfiguration.getEdgeSlop() >> 16), Color.blue(0) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                    }
                    ((StringBuilder) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    byte[] bArr5 = ICustomTabsCallbackStubProxy;
                    if (bArr5 != null) {
                        int i15 = $10 + 21;
                        int i16 = i15 % 128;
                        $11 = i16;
                        if (i15 % 2 == 0) {
                            length = bArr5.length;
                            bArr = new byte[length];
                        } else {
                            length = bArr5.length;
                            bArr = new byte[length];
                        }
                        int i17 = i16 + 25;
                        $10 = i17 % 128;
                        if (i17 % 2 != 0) {
                            int i18 = 5 % 2;
                        }
                        for (int i19 = 0; i19 < length; i19++) {
                            bArr[i19] = (byte) (((long) bArr5[i19]) ^ (-4629754035390455669L));
                        }
                        bArr5 = bArr;
                    }
                    boolean z2 = bArr5 != null;
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
                objArr[0] = sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Class] */
        /* JADX WARN: Type inference failed for: r0v94 */
        /* JADX WARN: Type inference failed for: r10v50 */
        /* JADX WARN: Type inference failed for: r11v52 */
        /* JADX WARN: Type inference failed for: r13v46 */
        /* JADX WARN: Type inference failed for: r20v0 */
        /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r6v122 */
        /* JADX WARN: Type inference failed for: r6v213, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r6v256 */
        /* JADX WARN: Type inference failed for: r6v257 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v101, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v2, types: [int] */
        /* JADX WARN: Type inference failed for: r7v3, types: [int] */
        /* JADX WARN: Type inference failed for: r7v36, types: [java.lang.Class[]] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v42, types: [int] */
        /* JADX WARN: Type inference failed for: r7v49, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v63, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v79 */
        /* JADX WARN: Type inference failed for: r7v92 */
        /* JADX WARN: Type inference failed for: r7v95, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v60 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r31, int r32, int r33) {
            /*
                Method dump skipped, instruction units count: 4396
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule.Companion.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Module
    public String getName() {
        return "PUSH";
    }
}
