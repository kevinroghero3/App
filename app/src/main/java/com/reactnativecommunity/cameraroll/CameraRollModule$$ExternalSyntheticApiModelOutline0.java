package com.reactnativecommunity.cameraroll;

import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class CameraRollModule$$ExternalSyntheticApiModelOutline0 {
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$d = 39;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.FF, 109, 62, -103, Ascii.VT, 2, -12};
    private static final int $$b = 159;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = -3615390990408435760L;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, byte r7, byte r8) {
        /*
            int r7 = r7 * 4
            int r7 = 1 - r7
            int r8 = r8 * 2
            int r8 = r8 + 118
            byte[] r0 = com.reactnativecommunity.cameraroll.CameraRollModule$$ExternalSyntheticApiModelOutline0.$$c
            int r6 = r6 * 3
            int r6 = 3 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r7
            r4 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            int r6 = r6 + 1
            r3 = r0[r6]
        L28:
            int r8 = r8 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.cameraroll.CameraRollModule$$ExternalSyntheticApiModelOutline0.$$e(short, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 4
            int r6 = 4 - r6
            int r8 = r8 * 2
            int r8 = r8 + 109
            byte[] r0 = com.reactnativecommunity.cameraroll.CameraRollModule$$ExternalSyntheticApiModelOutline0.$$a
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r6
            goto L29
        L15:
            r3 = r2
        L16:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r7]
        L29:
            int r8 = r8 + r3
            int r8 = r8 + (-3)
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.cameraroll.CameraRollModule$$ExternalSyntheticApiModelOutline0.b(short, int, byte, java.lang.Object[]):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - '%', (char) ('0' - AndroidCharacter.getMirror('0')), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1407, 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - (Process.myPid() >> 22), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 249 - KeyEvent.getDeadChar(0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
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
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i4 = $11 + 67;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 8, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), ExpandableListView.getPackedPositionChild(0L) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                throw null;
            }
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr5 = {asbinder, asbinder};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 9, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0, 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        String str = new String(cArr2);
        int i5 = $10 + 107;
        $11 = i5 % 128;
        if (i5 % 2 != 0) {
            objArr[0] = str;
        } else {
            int i6 = 85 / 0;
            objArr[0] = str;
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
    public static java.lang.Object[] coroutineCreation(int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 3004
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.cameraroll.CameraRollModule$$ExternalSyntheticApiModelOutline0.coroutineCreation(int, int):java.lang.Object[]");
    }
}
