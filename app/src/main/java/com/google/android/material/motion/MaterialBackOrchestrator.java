package com.google.android.material.motion;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.time.DurationKt;
import o.ArtificialStackFrames;
import o.asBinder;
import o.extraCallback;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialBackOrchestrator {
    private final BackCallbackDelegate backCallbackDelegate;
    private final MaterialBackHandler backHandler;
    private final View view;

    interface BackCallbackDelegate {
        void startListeningForBackCallbacks(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z);

        void stopListeningForBackCallbacks(@NonNull View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(@NonNull T t) {
        this(t, t);
    }

    public MaterialBackOrchestrator(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = materialBackHandler;
        this.view = view;
    }

    public boolean shouldListenForBackCallbacks() {
        return this.backCallbackDelegate != null;
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    public static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        private OnBackInvokedCallback onBackInvokedCallback;
        private static final byte[] $$c = {113, 6, -112, 1};
        private static final int $$d = 89;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {55, -4, -8, -76, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
        private static final int $$b = 94;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long extraCommand = -665160496400880270L;
        private static char[] ArtificialStackFrames = {44345, 44339, 44405, 44371, 44338, 44385, 44337, 44365, 44357, 44333, 44353, 44409, 44373, 44408, 44393, 44334, 44332, 44355, 44372, 44396, 44344, 44400, 44343, 44398, 44374, 44358, 44399, 44394, 44363, 44392, 44404, 44368, 44390, 44360, 44397, 44406, 44354, 44342, 44340, 44356, 44402, 44341, 44361, 44388, 44391, 44387, 44403, 44395, 44389};
        private static char coroutineCreation = 39069;

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r6, short r7, int r8) {
            /*
                byte[] r0 = com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.$$c
                int r7 = r7 * 3
                int r7 = 1 - r7
                int r6 = r6 * 4
                int r6 = 4 - r6
                int r8 = r8 + 97
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r8
                r3 = r2
                r8 = r6
                goto L2b
            L15:
                r3 = r2
            L16:
                r5 = r8
                r8 = r6
                r6 = r5
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r7) goto L26
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L26:
                r4 = r0[r8]
                r5 = r8
                r8 = r6
                r6 = r5
            L2b:
                int r4 = -r4
                int r6 = r6 + 1
                int r8 = r8 + r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.$$e(byte, short, int):java.lang.String");
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
        private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 5
                int r0 = 9 - r7
                byte[] r1 = com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.$$a
                int r8 = r8 + 4
                int r6 = r6 * 3
                int r6 = 115 - r6
                byte[] r0 = new byte[r0]
                int r7 = 8 - r7
                r2 = 0
                if (r1 != 0) goto L17
                r3 = r8
                r4 = r2
                r8 = r7
                goto L30
            L17:
                r3 = r2
            L18:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r0[r3] = r4
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r1[r8]
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r5
            L30:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + (-7)
                r8 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.b(byte, byte, byte, java.lang.Object[]):void");
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = $11 + 117;
                $10 = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = asbinder.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                        if (objAccessartificialFrame == null) {
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 11;
                            char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                            int iIndexOf = 1407 - TextUtils.indexOf("", "", 0);
                            byte b = (byte) ($$c[3] - 1);
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maxKeyCode, edgeSlop, iIndexOf, 1035473698, false, $$e(b, b2, (byte) (b2 | Ascii.NAK)), new Class[]{Integer.TYPE, Object.class, Object.class});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() | extraCommand | (-2360974883025274865L);
                        try {
                            Object[] objArr3 = {asbinder, asbinder};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                            if (objAccessartificialFrame2 == null) {
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(8 - Color.red(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), View.resolveSizeAndState(0, 0, 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame2).invoke(null, objArr3);
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
                } else {
                    int i5 = asbinder.d;
                    try {
                        Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                        if (objAccessartificialFrame3 == null) {
                            int modifierMetaStateMask = 10 - ((byte) KeyEvent.getModifierMetaStateMask());
                            char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                            int i6 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1406;
                            byte b3 = (byte) ($$c[3] - 1);
                            byte b4 = b3;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, tapTimeout, i6, 1035473698, false, $$e(b3, b4, (byte) (b4 | Ascii.NAK)), new Class[]{Integer.TYPE, Object.class, Object.class});
                        }
                        jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                        Object[] objArr5 = {asbinder, asbinder};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame4 == null) {
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 8, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 250 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
            }
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i7 = $10 + 79;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    cArr2[asbinder.d] = (char) jArr[asbinder.d];
                    Object[] objArr6 = {asbinder, asbinder};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 7, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 249 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    int i8 = 80 / 0;
                } else {
                    cArr2[asbinder.d] = (char) jArr[asbinder.d];
                    Object[] objArr7 = {asbinder, asbinder};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame6 == null) {
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 8, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), 249 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                }
            }
            String str = new String(cArr2);
            int i9 = $11 + 89;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            objArr[0] = str;
        }

        private Api33BackCallbackDelegate() {
        }

        boolean isListeningForBackCallbacks() {
            return this.onBackInvokedCallback != null;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void startListeningForBackCallbacks(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.onBackInvokedCallback == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback = createOnBackInvokedCallback(materialBackHandler);
                this.onBackInvokedCallback = onBackInvokedCallbackCreateOnBackInvokedCallback;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? DurationKt.NANOS_IN_MILLIS : 0, onBackInvokedCallbackCreateOnBackInvokedCallback);
            }
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void stopListeningForBackCallbacks(@NonNull View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }

        OnBackInvokedCallback createOnBackInvokedCallback(@NonNull final MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new OnBackInvokedCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda1
                public final void onBackInvoked() {
                    materialBackHandler.handleBackInvoked();
                }
            };
        }

        private static void c(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            long j = 0;
            float f = 0.0f;
            char c = 3;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (i4 < length) {
                    int i5 = $10 + 43;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i4])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1819279892);
                        if (objAccessartificialFrame == null) {
                            int packedPositionChild = 14 - ExpandableListView.getPackedPositionChild(j);
                            char c2 = (char) (20488 - (TypedValue.complexToFraction(0, f, f) > f ? 1 : (TypedValue.complexToFraction(0, f, f) == f ? 0 : -1)));
                            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 2148;
                            byte b2 = (byte) ($$c[c] - 1);
                            byte b3 = b2;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionChild, c2, offsetBefore, 216710116, false, $$e(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i4++;
                        j = 0;
                        f = 0.0f;
                        c = 3;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 15;
                char maximumDrawingCacheSize = (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 20488);
                int iMakeMeasureSpec2 = 2148 - View.MeasureSpec.makeMeasureSpec(0, 0);
                byte b4 = (byte) ($$c[3] - 1);
                byte b5 = b4;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, maximumDrawingCacheSize, iMakeMeasureSpec2, 216710116, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i7 = $10 + 81;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                int i9 = $10 + 49;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i11 = $11 + 83;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            int i13 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 46;
                            char c3 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 58858);
                            int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2464;
                            byte b6 = (byte) ($$c[3] - 1);
                            byte b7 = b6;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i13, c3, keyRepeatTimeout, 276640984, false, $$e(b6, b7, (byte) (b7 + 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i14 = $10 + 97;
                            $11 = i14 % 128;
                            int i15 = i14 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                int i16 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24;
                                char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 792;
                                byte b8 = (byte) ($$c[3] - 1);
                                byte b9 = b8;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i16, edgeSlop, iIndexOf, -834291897, false, $$e(b8, b9, (byte) (b9 | 8)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i17 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i17];
                        } else if (extracallback.b == extracallback.d) {
                            extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                            extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                            int i18 = (extracallback.b * cCharValue) + extracallback.j;
                            int i19 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[i18];
                            cArr4[extracallback.a + 1] = cArr2[i19];
                        } else {
                            int i20 = (extracallback.b * cCharValue) + extracallback.g;
                            int i21 = (extracallback.d * cCharValue) + extracallback.j;
                            cArr4[extracallback.a] = cArr2[i20];
                            cArr4[extracallback.a + 1] = cArr2[i21];
                        }
                    }
                    extracallback.a += 2;
                }
            }
            for (int i22 = 0; i22 < i; i22++) {
                cArr4[i22] = (char) (cArr4[i22] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v68 */
        /* JADX WARN: Type inference failed for: r11v122, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r11v152, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r11v165, types: [java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r11v429 */
        /* JADX WARN: Type inference failed for: r11v430 */
        /* JADX WARN: Type inference failed for: r13v231, types: [java.lang.Class[]] */
        /* JADX WARN: Type inference failed for: r15v109 */
        /* JADX WARN: Type inference failed for: r15v110 */
        /* JADX WARN: Type inference failed for: r15v133 */
        /* JADX WARN: Type inference failed for: r15v134 */
        /* JADX WARN: Type inference failed for: r15v135 */
        /* JADX WARN: Type inference failed for: r15v136 */
        /* JADX WARN: Type inference failed for: r15v137 */
        /* JADX WARN: Type inference failed for: r15v138 */
        /* JADX WARN: Type inference failed for: r15v139 */
        /* JADX WARN: Type inference failed for: r15v140 */
        /* JADX WARN: Type inference failed for: r15v141 */
        /* JADX WARN: Type inference failed for: r15v16 */
        /* JADX WARN: Type inference failed for: r15v17, types: [int] */
        /* JADX WARN: Type inference failed for: r15v18 */
        /* JADX WARN: Type inference failed for: r15v19 */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v21 */
        /* JADX WARN: Type inference failed for: r15v27, types: [int] */
        /* JADX WARN: Type inference failed for: r15v28 */
        /* JADX WARN: Type inference failed for: r15v33 */
        /* JADX WARN: Type inference failed for: r15v34 */
        /* JADX WARN: Type inference failed for: r15v41, types: [java.lang.Class<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r15v85 */
        /* JADX WARN: Type inference failed for: r15v94 */
        /* JADX WARN: Type inference failed for: r15v96 */
        /* JADX WARN: Type inference failed for: r1v126, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r1v174, types: [int[]] */
        /* JADX WARN: Type inference failed for: r1v369, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r27v10 */
        /* JADX WARN: Type inference failed for: r27v11 */
        /* JADX WARN: Type inference failed for: r27v13 */
        /* JADX WARN: Type inference failed for: r28v0 */
        /* JADX WARN: Type inference failed for: r28v1 */
        /* JADX WARN: Type inference failed for: r28v11 */
        /* JADX WARN: Type inference failed for: r28v21 */
        /* JADX WARN: Type inference failed for: r28v22 */
        /* JADX WARN: Type inference failed for: r28v23 */
        /* JADX WARN: Type inference failed for: r28v24 */
        /* JADX WARN: Type inference failed for: r28v29 */
        /* JADX WARN: Type inference failed for: r28v30 */
        /* JADX WARN: Type inference failed for: r28v36 */
        /* JADX WARN: Type inference failed for: r28v37 */
        /* JADX WARN: Type inference failed for: r28v38 */
        /* JADX WARN: Type inference failed for: r28v40, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r28v41 */
        /* JADX WARN: Type inference failed for: r28v42 */
        /* JADX WARN: Type inference failed for: r28v43 */
        /* JADX WARN: Type inference failed for: r28v44 */
        /* JADX WARN: Type inference failed for: r28v45 */
        /* JADX WARN: Type inference failed for: r28v46 */
        /* JADX WARN: Type inference failed for: r28v9 */
        /* JADX WARN: Type inference failed for: r29v1 */
        /* JADX WARN: Type inference failed for: r2v235, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r2v236 */
        /* JADX WARN: Type inference failed for: r2v241 */
        /* JADX WARN: Type inference failed for: r2v242 */
        /* JADX WARN: Type inference failed for: r2v253 */
        /* JADX WARN: Type inference failed for: r2v401 */
        /* JADX WARN: Type inference failed for: r2v402 */
        /* JADX WARN: Type inference failed for: r33v13 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v123, types: [int] */
        /* JADX WARN: Type inference failed for: r3v321 */
        /* JADX WARN: Type inference failed for: r3v370 */
        /* JADX WARN: Type inference failed for: r44v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v124, types: [int[]] */
        /* JADX WARN: Type inference failed for: r4v167 */
        /* JADX WARN: Type inference failed for: r4v170 */
        /* JADX WARN: Type inference failed for: r4v188, types: [int[]] */
        /* JADX WARN: Type inference failed for: r4v236, types: [int[]] */
        /* JADX WARN: Type inference failed for: r5v103 */
        /* JADX WARN: Type inference failed for: r5v20, types: [java.nio.LongBuffer[]] */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v366 */
        /* JADX WARN: Type inference failed for: r5v367 */
        /* JADX WARN: Type inference failed for: r5v368 */
        /* JADX WARN: Type inference failed for: r5v369 */
        /* JADX WARN: Type inference failed for: r5v370 */
        /* JADX WARN: Type inference failed for: r5v371 */
        /* JADX WARN: Type inference failed for: r5v372 */
        /* JADX WARN: Type inference failed for: r5v373 */
        /* JADX WARN: Type inference failed for: r5v58 */
        /* JADX WARN: Type inference failed for: r5v60 */
        /* JADX WARN: Type inference failed for: r5v66 */
        /* JADX WARN: Type inference failed for: r5v78, types: [int[]] */
        /* JADX WARN: Type inference failed for: r5v94 */
        /* JADX WARN: Type inference failed for: r5v95 */
        /* JADX WARN: Type inference failed for: r5v96 */
        /* JADX WARN: Type inference failed for: r5v97 */
        /* JADX WARN: Type inference failed for: r6v155 */
        /* JADX WARN: Type inference failed for: r6v202, types: [int[]] */
        /* JADX WARN: Type inference failed for: r6v259 */
        /* JADX WARN: Type inference failed for: r6v39 */
        /* JADX WARN: Type inference failed for: r6v40 */
        /* JADX WARN: Type inference failed for: r6v58 */
        /* JADX WARN: Type inference failed for: r7v139, types: [int[]] */
        /* JADX WARN: Type inference failed for: r8v115, types: [int[]] */
        /* JADX WARN: Type inference failed for: r8v129 */
        /* JADX WARN: Type inference failed for: r8v157, types: [java.lang.reflect.Method] */
        /* JADX WARN: Type inference failed for: r8v28, types: [int[]] */
        /* JADX WARN: Type inference failed for: r8v57, types: [int[]] */
        /* JADX WARN: Type inference failed for: r9v113, types: [java.lang.Class] */
        /* JADX WARN: Type inference failed for: r9v23, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r9v27 */
        /* JADX WARN: Type inference failed for: r9v37 */
        /* JADX WARN: Type inference failed for: r9v443, types: [int[]] */
        /* JADX WARN: Type inference failed for: r9v446 */
        /* JADX WARN: Type inference failed for: r9v447 */
        /* JADX WARN: Type inference failed for: r9v73, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r9v92, types: [java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r9v93, types: [java.lang.Object, java.nio.LongBuffer] */
        /* JADX WARN: Type inference failed for: r9v94, types: [java.nio.LongBuffer] */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r42, java.lang.String[] r43, int r44, int r45, int r46) {
            /*
                Method dump skipped, instruction units count: 15810
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
        }
    }

    private void startListeningForBackCallbacks(boolean z) {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.startListeningForBackCallbacks(this.backHandler, this.view, z);
        }
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate backCallbackDelegate = this.backCallbackDelegate;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.stopListeningForBackCallbacks(this.view);
        }
    }

    private static BackCallbackDelegate createBackCallbackDelegate() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (i >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        OnBackInvokedCallback createOnBackInvokedCallback(@NonNull final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator.Api34BackCallbackDelegate.1
                public void onBackStarted(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.startBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackProgressed(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.updateBackProgress(new BackEventCompat(backEvent));
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.handleBackInvoked();
                }

                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        materialBackHandler.cancelBackProgress();
                    }
                }
            };
        }
    }
}
