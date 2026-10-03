package com.learnium.RNDeviceInfo;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: renamed from: com.learnium.RNDeviceInfo.RNInstallReferrerClient-IA, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RNInstallReferrerClientIA {
    private static final byte[] $$c = {Ascii.US, Ascii.FS, -113, 86};
    private static final int $$d = 151;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {96, -63, 33, 4, Ascii.VT, 2, -12};
    private static final int $$b = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = 1851842082713304363L;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r7, int r8, short r9) {
        /*
            int r8 = r8 * 4
            int r8 = 1 - r8
            byte[] r0 = com.learnium.RNDeviceInfo.RNInstallReferrerClientIA.$$c
            int r9 = r9 * 2
            int r9 = 118 - r9
            int r7 = r7 * 2
            int r7 = 4 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r7
            goto L2b
        L17:
            r3 = r2
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2b:
            int r7 = -r7
            int r7 = r7 + r3
            int r9 = r9 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.RNInstallReferrerClientIA.$$e(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.learnium.RNDeviceInfo.RNInstallReferrerClientIA.$$a
            int r5 = r5 * 2
            int r5 = 3 - r5
            int r7 = r7 * 3
            int r1 = 4 - r7
            int r6 = r6 * 4
            int r6 = 109 - r6
            byte[] r1 = new byte[r1]
            int r7 = 3 - r7
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r7
            r3 = r2
            goto L2c
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            int r5 = r5 + 1
            r4 = r0[r5]
            int r3 = r3 + 1
        L2c:
            int r6 = r6 + r4
            int r6 = r6 + (-3)
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.RNInstallReferrerClientIA.a(byte, short, short, java.lang.Object[]):void");
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $10 + 115;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (asbinder.d < cArr.length) {
            int i5 = $11 + 61;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), MotionEvent.axisFromString("") + 1408, 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i7] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 8, (char) (ViewConfiguration.getScrollBarSize() >> 8), ExpandableListView.getPackedPositionChild(0L) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
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
            int i8 = $11 + 125;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                try {
                    Object[] objArr4 = {asbinder, asbinder};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 8, (char) Color.alpha(0), 249 - (ViewConfiguration.getPressedStateDuration() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    Object obj = null;
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    obj.hashCode();
                    throw null;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr5 = {asbinder, asbinder};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 8, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
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
    public static java.lang.Object[] coroutineCreation(int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 2672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.RNInstallReferrerClientIA.coroutineCreation(int, int):java.lang.Object[]");
    }
}
