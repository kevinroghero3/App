package dagger.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import dagger.MembersInjector;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;

/* JADX INFO: loaded from: classes6.dex */
public final class MembersInjectors {
    private static final byte[] $$c = {98, -94, 86, -118};
    private static final int $$d = SyslogConstants.LOG_LOCAL2;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {4, -122, -75, -94, Ascii.VT, 2, -12};
    private static final int $$b = 214;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] validateRelationship = {55986, 55976, 56159, 55998, 55993, 55982, 55996, 55977, 56152, 55988, 55989, 55992, 55983, 55999, 55980, 55994, 56157, 56181, 56180, 55970, 55984, 55991, 56132, 55979, 55997, 56170};
    private static int warmup = -1044260069;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;

    private static String $$e(short s, short s2, short s3) {
        int i = s3 * 4;
        byte[] bArr = $$c;
        int i2 = 3 - (s2 * 3);
        int i3 = s + 66;
        byte[] bArr2 = new byte[i + 1];
        int i4 = -1;
        if (bArr == null) {
            i3 = (-i3) + i2;
            i4 = -1;
        }
        while (true) {
            int i5 = i2;
            int i6 = i3;
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i6;
            if (i7 == i) {
                return new String(bArr2, 0);
            }
            int i8 = i5 + 1;
            i2 = i8;
            i3 = (-bArr[i8]) + i6;
            i4 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 4
            int r0 = 4 - r5
            int r6 = r6 * 3
            int r6 = 4 - r6
            int r7 = r7 * 4
            int r7 = 109 - r7
            byte[] r1 = dagger.internal.MembersInjectors.$$a
            byte[] r0 = new byte[r0]
            int r5 = 3 - r5
            r2 = 0
            if (r1 != 0) goto L19
            r4 = r7
            r3 = r2
            r7 = r5
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r5) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L27:
            r4 = r1[r6]
            int r3 = r3 + 1
        L2b:
            int r7 = r7 + r4
            int r7 = r7 + (-3)
            int r6 = r6 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.internal.MembersInjectors.b(byte, short, byte, java.lang.Object[]):void");
    }

    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        @Override // dagger.MembersInjector
        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    private MembersInjectors() {
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        char[] cArr2;
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr3 = validateRelationship;
        float f = 0.0f;
        int i5 = 0;
        if (cArr3 != null) {
            int i6 = $10 + 5;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                length = cArr3.length;
                cArr2 = new char[length];
                i2 = 1;
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
                i2 = 0;
            }
            while (i2 < length) {
                int i7 = $11 + 55;
                $10 = i7 % 128;
                if (i7 % i3 != 0) {
                    try {
                        Object[] objArr2 = new Object[1];
                        objArr2[i5] = Integer.valueOf(cArr3[i2]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            int gidForName = 25 - Process.getGidForName("");
                            char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                            int i8 = (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1)) + 1041;
                            byte b = (byte) i5;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(gidForName, packedPositionType, i8, -1719489573, false, $$e((byte) 55, b, b), new Class[]{Integer.TYPE});
                        }
                        cArr2[i2] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    try {
                        Object[] objArr3 = {Integer.valueOf(cArr3[i2])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame2 == null) {
                            byte b2 = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0), TextUtils.getTrimmedLength("") + 1041, -1719489573, false, $$e((byte) 55, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr2[i2] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i2++;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                i3 = 2;
                f = 0.0f;
                i5 = 0;
            }
            cArr3 = cArr2;
        }
        Object[] objArr4 = {Integer.valueOf(warmup)};
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1820173622);
        if (objAccessartificialFrame3 == null) {
            byte b3 = (byte) 1;
            byte b4 = (byte) (b3 - 1);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20488), View.resolveSizeAndState(0, 0, 0) + 2148, 216472770, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
        if (!ICustomTabsServiceDefault) {
            if (!requestPostMessageChannelWithExtras) {
                onmessagechannelready.c = iArr.length;
                char[] cArr4 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    cArr4[onmessagechannelready.a] = (char) (cArr3[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                    onmessagechannelready.a++;
                    int i9 = $11 + 77;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            int i11 = $11 + 3;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr3[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame4 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - TextUtils.getCapsMode("", 0, 0), (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 59174), Color.blue(0) + 1943, 481771537, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            objArr[0] = new String(cArr5);
            return;
        }
        onmessagechannelready.c = bArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            int i13 = $10 + 53;
            $11 = i13 % 128;
            if (i13 % 2 == 0) {
                cArr6[onmessagechannelready.a] = (char) (cArr3[bArr[onmessagechannelready.c >> onmessagechannelready.a] * i] + iIntValue);
                try {
                    Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                    if (objAccessartificialFrame5 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 21, (char) (KeyEvent.normalizeMetaState(0) + 59174), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1943, 481771537, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else {
                cArr6[onmessagechannelready.a] = (char) (cArr3[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                Object[] objArr7 = {onmessagechannelready, onmessagechannelready};
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                if (objAccessartificialFrame6 == null) {
                    byte b9 = (byte) 0;
                    byte b10 = b9;
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 59174), 1943 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 481771537, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            }
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v100 */
    /* JADX WARN: Type inference failed for: r11v101 */
    /* JADX WARN: Type inference failed for: r11v102 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r11v63, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 2660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.internal.MembersInjectors.coroutineCreation(int, int):java.lang.Object[]");
    }
}
