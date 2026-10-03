package com.google.android.gms.internal.mlkit_vision_barcode;

import android.media.AudioTrack;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.util.Iterator;
import o.ArtificialStackFrames;
import o.build;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdu implements Iterator {
    private static final byte[] $$c = {Ascii.FS, 50, 106, -64};
    private static final int $$d = SyslogConstants.LOG_CLOCK;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {52, -35, -61, -47, Ascii.VT, 2, -12};
    private static final int $$b = b.l;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 1390;
    private static char ICustomTabsCallback = 55061;
    private static char extraCallbackWithResult = 62957;
    private static char onMessageChannelReady = 20436;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, byte r7, short r8) {
        /*
            int r7 = r7 * 4
            int r0 = 1 - r7
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r8 = 110 - r8
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_barcode.zzdu.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L2c
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r8 = -r8
            int r8 = r8 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzdu.$$e(int, byte, short):java.lang.String");
    }

    protected zzdu() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 4 - r8
            int r6 = r6 * 2
            int r6 = r6 + 109
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzdu.$$a
            int r7 = r7 * 4
            int r7 = 4 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r6 = r8
            r3 = r2
            goto L2c
        L17:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
        L2c:
            int r8 = r8 + r4
            int r8 = r8 + (-3)
            int r6 = r6 + 1
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzdu.a(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        int i4 = $10 + 97;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        while (buildVar.c < cArr.length) {
            int i6 = $10 + 45;
            $11 = i6 % 128;
            int i7 = 58224;
            if (i6 % 2 == 0) {
                cArr3[0] = cArr[buildVar.c];
                cArr3[1] = cArr[buildVar.c / 0];
                i2 = 1;
            } else {
                cArr3[0] = cArr[buildVar.c];
                cArr3[1] = cArr[buildVar.c + 1];
                i2 = 0;
            }
            while (i2 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i7) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) (-1);
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (KeyEvent.getDeadChar(0, 0) + 17263), 1067 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 1042277788, false, $$e(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i7) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) (-1);
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 28, (char) (17263 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 1067 - (ViewConfiguration.getTouchSlop() >> 8), 1042277788, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i7 -= 40503;
                    i2++;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) (-1);
                byte b6 = (byte) (b5 + 1);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 25, (char) (63928 - (KeyEvent.getMaxKeyCode() >> 16)), TextUtils.indexOf("", "", 0) + 486, 1554985764, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] coroutineCreation(int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 2744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzdu.coroutineCreation(int, int):java.lang.Object[]");
    }
}
