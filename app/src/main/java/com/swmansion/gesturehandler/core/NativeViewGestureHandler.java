package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.textinput.ReactEditText;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.eventbuilders.NativeGestureHandlerEventDataBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onNavigationEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeViewGestureHandler extends GestureHandler {
    private static final boolean DEFAULT_DISALLOW_INTERRUPTION = false;
    private static final boolean DEFAULT_SHOULD_ACTIVATE_ON_START = false;
    private static final boolean DEFAULT_SHOULD_CANCEL_WHEN_OUTSIDE = true;
    private boolean disallowInterruption;
    private NativeViewGestureHandlerHook hook = defaultHook;
    private boolean shouldActivateOnStart;
    public static final Companion Companion = new Companion(null);
    private static final NativeViewGestureHandler$Companion$defaultHook$1 defaultHook = new NativeViewGestureHandlerHook() { // from class: com.swmansion.gesturehandler.core.NativeViewGestureHandler$Companion$defaultHook$1
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(MotionEvent motionEvent) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(View view) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(MotionEvent motionEvent) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(MotionEvent motionEvent) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }
    };

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    public final boolean getDisallowInterruption() {
        return this.disallowInterruption;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.shouldActivateOnStart = false;
        this.disallowInterruption = false;
        setShouldCancelWhenOutside(true);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Boolean boolShouldRecognizeSimultaneously = this.hook.shouldRecognizeSimultaneously(handler);
        if (boolShouldRecognizeSimultaneously != null) {
            return boolShouldRecognizeSimultaneously.booleanValue();
        }
        if (super.shouldRecognizeSimultaneously(handler)) {
            return true;
        }
        if ((handler instanceof NativeViewGestureHandler) && handler.getState() == 4 && ((NativeViewGestureHandler) handler).disallowInterruption) {
            return false;
        }
        boolean z = this.disallowInterruption;
        return !(getState() == 4 && handler.getState() == 4 && !z) && getState() == 4 && !z && (!this.hook.shouldCancelRootViewGestureHandlerIfNecessary() || handler.getTag() > 0);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldBeCancelledBy(@NotNull GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return !this.disallowInterruption;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onPrepare() {
        KeyEvent.Callback view = getView();
        if (view instanceof NativeViewGestureHandlerHook) {
            this.hook = (NativeViewGestureHandlerHook) view;
            return;
        }
        if (view instanceof ReactEditText) {
            this.hook = new EditTextHook(this, (ReactEditText) view);
            return;
        }
        if (view instanceof ReactSwipeRefreshLayout) {
            this.hook = new SwipeRefreshLayoutHook(this, (ReactSwipeRefreshLayout) view);
            return;
        }
        if (view instanceof ReactScrollView) {
            this.hook = new ScrollViewHook();
            return;
        }
        if (view instanceof ReactHorizontalScrollView) {
            this.hook = new ScrollViewHook();
        } else if (view instanceof ReactTextView) {
            this.hook = new TextViewHook();
        } else if (view instanceof ReactViewGroup) {
            this.hook = new ReactViewGroupHook();
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        View view = getView();
        Intrinsics.checkNotNull(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean zIsScreenReaderOn = ExtensionsKt.isScreenReaderOn(context);
        if ((view instanceof RNGestureHandlerButtonViewManager.ButtonViewGroup) && zIsScreenReaderOn) {
            return;
        }
        if (event.getActionMasked() == 1) {
            if (getState() == 0 && !this.hook.canBegin(event)) {
                cancel();
            } else {
                this.hook.sendTouchEvent(view, event);
                if ((getState() == 0 || getState() == 2) && this.hook.canActivate(view)) {
                    activate();
                }
                if (getState() == 0) {
                    cancel();
                } else {
                    end();
                }
            }
            this.hook.afterGestureEnd(event);
            return;
        }
        if (getState() == 0 || getState() == 2) {
            if (this.shouldActivateOnStart) {
                Companion.tryIntercept(view, event);
                this.hook.sendTouchEvent(view, event);
                activate();
                return;
            } else if (Companion.tryIntercept(view, event)) {
                this.hook.sendTouchEvent(view, event);
                activate();
                return;
            } else if (this.hook.wantsToHandleEventBeforeActivation()) {
                this.hook.handleEventBeforeActivation(event);
                return;
            } else {
                if (getState() == 2 || !this.hook.canBegin(event)) {
                    return;
                }
                begin();
                return;
            }
        }
        if (getState() == 4) {
            this.hook.sendTouchEvent(view, event);
        }
    }

    public interface NativeViewGestureHandlerHook {
        void afterGestureEnd(@NotNull MotionEvent motionEvent);

        boolean canActivate(@NotNull View view);

        boolean canBegin(@NotNull MotionEvent motionEvent);

        void handleEventBeforeActivation(@NotNull MotionEvent motionEvent);

        Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent);

        boolean shouldCancelRootViewGestureHandlerIfNecessary();

        Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler);

        boolean wantsToHandleEventBeforeActivation();

        /* JADX INFO: loaded from: classes.dex */
        public static final class DefaultImpls {
            private static final byte[] $$c = {109, -105, -81, -102};
            private static final int $$d = 191;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {32, -45, -106, 106, 10, 4, 50, Ascii.SO, Ascii.SYN, -3, 8, 1, -6, Ascii.GS, 1, Ascii.DLE, 5, 36, 8, 3, 10, Ascii.DC2, 0, -8, Ascii.DC4, Ascii.US, 5, Ascii.DLE, 8, 5, -2, Ascii.DC2, 3, 10, 2, 5, -9, Ascii.SO, -5, 3, Ascii.DC4, -50, Ascii.ESC, Ascii.SYN, -16, -9, 5, Ascii.VT, 32, 8, 6};
            private static final int $$b = 2;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static int setDefaultImpl = -260893965;
            private static int[] ICustomTabsCallbackStub = {-1321865789, 121742857, -1811550891, -971034231, -1285687820, -2090915135, -556864130, -133504835, -77166509, 1927692850, 1359694490, -642645718, -1593205640, -482113813, -1698702811, -2069694031, -932724927, -49573327};

            /* JADX WARN: Code duplicated, block: B:10:0x0022  */
            /* JADX WARN: Code duplicated, block: B:8:0x001c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(byte r7, int r8, short r9) {
                /*
                    byte[] r0 = com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.$$c
                    int r7 = r7 + 109
                    int r9 = r9 * 3
                    int r9 = 3 - r9
                    int r8 = r8 * 3
                    int r8 = 1 - r8
                    byte[] r1 = new byte[r8]
                    r2 = 0
                    if (r0 != 0) goto L14
                    r3 = r9
                    r5 = r2
                    goto L2a
                L14:
                    r3 = r2
                L15:
                    byte r4 = (byte) r7
                    int r5 = r3 + 1
                    r1[r3] = r4
                    if (r5 != r8) goto L22
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    return r7
                L22:
                    int r9 = r9 + 1
                    r3 = r0[r9]
                    r6 = r9
                    r9 = r7
                    r7 = r3
                    r3 = r6
                L2a:
                    int r7 = -r7
                    int r7 = r7 + r9
                    r9 = r3
                    r3 = r5
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.$$e(byte, int, short):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x0019  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
                /*
                    int r0 = 4 - r8
                    int r7 = 47 - r7
                    int r6 = 115 - r6
                    byte[] r1 = com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.$$a
                    byte[] r0 = new byte[r0]
                    int r8 = 3 - r8
                    r2 = 0
                    if (r1 != 0) goto L13
                    r3 = r7
                    r6 = r8
                    r4 = r2
                    goto L2b
                L13:
                    r3 = r2
                L14:
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    if (r3 != r8) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    r9[r2] = r6
                    return
                L21:
                    int r3 = r3 + 1
                    int r7 = r7 + 1
                    r4 = r1[r7]
                    r5 = r3
                    r3 = r7
                    r7 = r4
                    r4 = r5
                L2b:
                    int r6 = r6 + r7
                    int r6 = r6 + (-5)
                    r7 = r3
                    r3 = r4
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.a(int, byte, byte, java.lang.Object[]):void");
            }

            public static void afterGestureEnd(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
            }

            public static boolean canBegin(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return true;
            }

            public static void handleEventBeforeActivation(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
            }

            public static boolean shouldCancelRootViewGestureHandlerIfNecessary(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return false;
            }

            public static Boolean shouldRecognizeSimultaneously(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @NotNull GestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                return null;
            }

            public static boolean wantsToHandleEventBeforeActivation(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook) {
                return false;
            }

            private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
                int i4 = 2 % 2;
                onNavigationEvent onnavigationevent = new onNavigationEvent();
                char[] cArr2 = new char[i3];
                onnavigationevent.d = 0;
                while (onnavigationevent.d < i3) {
                    int i5 = $10 + 69;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    onnavigationevent.c = cArr[onnavigationevent.d];
                    cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                    int i7 = onnavigationevent.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                        if (objAccessartificialFrame == null) {
                            int offsetAfter = 22 - TextUtils.getOffsetAfter("", 0);
                            char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
                            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1775;
                            byte b = (byte) ($$d & 5);
                            byte b2 = (byte) (b - 5);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetAfter, c, edgeSlop, -2069783171, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        Object[] objArr3 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 37, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 56277), 1258 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 711931141, false, $$e((byte) ($$d & 7), b3, b3), new Class[]{Object.class, Object.class});
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
                if (i > 0) {
                    onnavigationevent.b = i;
                    char[] cArr3 = new char[i3];
                    System.arraycopy(cArr2, 0, cArr3, 0, i3);
                    System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                    System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
                }
                if (z) {
                    int i8 = $10 + b.i;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    char[] cArr4 = new char[i3];
                    onnavigationevent.d = 0;
                    while (onnavigationevent.d < i3) {
                        int i10 = $11 + 89;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame3 == null) {
                            byte b4 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(37 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (56278 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 1258, 711931141, false, $$e((byte) ($$d & 7), b4, b4), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        int i12 = $11 + 69;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            }

            private static void c(int i, int[] iArr, Object[] objArr) {
                int i2 = 2 % 2;
                artificialFrame artificialframe = new artificialFrame();
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length * 2];
                int[] iArr2 = ICustomTabsCallbackStub;
                int i3 = -1780896814;
                int i4 = 1;
                int i5 = 0;
                if (iArr2 != null) {
                    int i6 = $10 + 41;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    int length = iArr2.length;
                    int[] iArr3 = new int[length];
                    int i8 = 0;
                    while (i8 < length) {
                        try {
                            Object[] objArr2 = new Object[1];
                            objArr2[i5] = Integer.valueOf(iArr2[i8]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i5;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 12, (char) ((Process.getThreadPriority(i5) + 20) >> 6), (ViewConfiguration.getTouchSlop() >> 8) + 1562, 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                            }
                            iArr3[i8] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            i8++;
                            i3 = -1780896814;
                            i5 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    iArr2 = iArr3;
                }
                int length2 = iArr2.length;
                int[] iArr4 = new int[length2];
                int[] iArr5 = ICustomTabsCallbackStub;
                if (iArr5 != null) {
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i9 = 0;
                    while (i9 < length3) {
                        int i10 = $11 + 5;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        try {
                            Object[] objArr3 = new Object[i4];
                            objArr3[0] = Integer.valueOf(iArr5[i9]);
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = b3;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 11, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), Color.rgb(0, 0, 0) + 16778778, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                            }
                            iArr6[i9] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                            i9++;
                            i4 = 1;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    }
                    iArr5 = iArr6;
                }
                char c = 0;
                System.arraycopy(iArr5, 0, iArr4, 0, length2);
                artificialframe.e = 0;
                while (artificialframe.e < iArr.length) {
                    cArr[c] = (char) (iArr[artificialframe.e] >> 16);
                    cArr[1] = (char) iArr[artificialframe.e];
                    cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                    cArr[3] = (char) iArr[artificialframe.e + 1];
                    artificialframe.c = (cArr[0] << 16) + cArr[1];
                    artificialframe.b = (cArr[2] << 16) + cArr[3];
                    artificialFrame.coroutineBoundary(iArr4);
                    int i12 = 0;
                    while (i12 < 16) {
                        int i13 = $11 + 113;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            artificialframe.c ^= iArr4[i12];
                            Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.getTrimmedLength(""), 1041 - (ViewConfiguration.getJumpTapTimeout() >> 16), 995482881, false, $$e((byte) ($$d & 6), b5, b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = iIntValue;
                            i12 += 52;
                        } else {
                            artificialframe.c ^= iArr4[i12];
                            Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                            if (objAccessartificialFrame4 == null) {
                                byte b6 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 1041 - View.MeasureSpec.getSize(0), 995482881, false, $$e((byte) ($$d & 6), b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                            }
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = iIntValue2;
                            i12++;
                        }
                    }
                    int i14 = artificialframe.c;
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = i14;
                    artificialframe.b ^= iArr4[16];
                    artificialframe.c ^= iArr4[17];
                    int i15 = artificialframe.c;
                    int i16 = artificialframe.b;
                    cArr[0] = (char) (artificialframe.c >>> 16);
                    cArr[1] = (char) artificialframe.c;
                    cArr[2] = (char) (artificialframe.b >>> 16);
                    cArr[3] = (char) artificialframe.b;
                    artificialFrame.coroutineBoundary(iArr4);
                    cArr2[artificialframe.e * 2] = cArr[0];
                    cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                    cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                    cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                    Object[] objArr6 = {artificialframe, artificialframe};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 37, (char) (28010 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    c = 0;
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            public static boolean canActivate(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                return view.isPressed();
            }

            public static Boolean sendTouchEvent(@NotNull NativeViewGestureHandlerHook nativeViewGestureHandlerHook, @Nullable View view, @NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (view != null) {
                    return Boolean.valueOf(view.onTouchEvent(event));
                }
                return null;
            }

            /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7537 (expected less than 5000) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v929 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame$78cbbd35(int r64, int r65, java.lang.Object r66, int r67, boolean r68) {
                /*
                    Method dump skipped, instruction units count: 20167
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
            }
        }
    }

    private final void dispatchCancelEventToView() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setAction(3);
        NativeViewGestureHandlerHook nativeViewGestureHandlerHook = this.hook;
        View view = getView();
        Intrinsics.checkNotNull(motionEventObtain);
        nativeViewGestureHandlerHook.sendTouchEvent(view, motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        dispatchCancelEventToView();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onFail() {
        dispatchCancelEventToView();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        this.hook = defaultHook;
    }

    public static final class Factory extends GestureHandler.Factory<NativeViewGestureHandler> {
        public static final Companion Companion = new Companion(null);
        private static final String KEY_DISALLOW_INTERRUPTION = "disallowInterruption";
        private static final String KEY_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
        private final Class<NativeViewGestureHandler> type = NativeViewGestureHandler.class;
        private final String name = "NativeViewGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<NativeViewGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public NativeViewGestureHandler create(@Nullable Context context) {
            return new NativeViewGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull NativeViewGestureHandler handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig(handler, config);
            if (config.hasKey(KEY_SHOULD_ACTIVATE_ON_START)) {
                handler.shouldActivateOnStart = config.getBoolean(KEY_SHOULD_ACTIVATE_ON_START);
            }
            if (config.hasKey(KEY_DISALLOW_INTERRUPTION)) {
                handler.disallowInterruption = config.getBoolean(KEY_DISALLOW_INTERRUPTION);
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public NativeGestureHandlerEventDataBuilder createEventBuilder(@NotNull NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new NativeGestureHandlerEventDataBuilder(handler);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean tryIntercept(View view, MotionEvent motionEvent) {
            return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
        }
    }

    static final class TextViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return Boolean.FALSE;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view instanceof ReactTextView;
        }
    }

    static final class EditTextHook implements NativeViewGestureHandlerHook {
        private final ReactEditText editText;
        private final NativeViewGestureHandler handler;
        private float startX;
        private float startY;
        private int touchSlopSquared;

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }

        public EditTextHook(@NotNull NativeViewGestureHandler handler, @NotNull ReactEditText editText) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(editText, "editText");
            this.handler = handler;
            this.editText = editText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(editText.getContext());
            this.touchSlopSquared = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (((event.getX() - this.startX) * (event.getX() - this.startX)) + ((event.getY() - this.startY) * (event.getY() - this.startY)) < this.touchSlopSquared) {
                this.editText.requestFocusFromJS();
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return Boolean.valueOf(handler.getTag() > 0 && !(handler instanceof NativeViewGestureHandler));
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.handler.activate();
            this.editText.onTouchEvent(event);
            this.startX = event.getX();
            this.startY = event.getY();
        }
    }

    static final class SwipeRefreshLayoutHook implements NativeViewGestureHandlerHook {
        private final NativeViewGestureHandler handler;
        private final ReactSwipeRefreshLayout swipeRefreshLayout;

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return true;
        }

        public SwipeRefreshLayoutHook(@NotNull NativeViewGestureHandler handler, @NotNull ReactSwipeRefreshLayout swipeRefreshLayout) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(swipeRefreshLayout, "swipeRefreshLayout");
            this.handler = handler;
            this.swipeRefreshLayout = swipeRefreshLayout;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler) {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent event) {
            ArrayList<GestureHandler> handlersForView;
            Intrinsics.checkNotNullParameter(event, "event");
            View childAt = this.swipeRefreshLayout.getChildAt(0);
            GestureHandler gestureHandler = null;
            ScrollView scrollView = childAt instanceof ScrollView ? (ScrollView) childAt : null;
            if (scrollView == null) {
                return;
            }
            GestureHandlerOrchestrator orchestrator = this.handler.getOrchestrator();
            if (orchestrator != null && (handlersForView = orchestrator.getHandlersForView(scrollView)) != null) {
                Iterator<T> it2 = handlersForView.iterator();
                do {
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    gestureHandler = (GestureHandler) it2.next();
                } while (!(gestureHandler instanceof NativeViewGestureHandler));
            }
            if (gestureHandler == null || gestureHandler.getState() != 4 || scrollView.getScrollY() <= 0) {
                return;
            }
            this.handler.fail();
        }
    }

    static final class ScrollViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.sendTouchEvent(this, view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler) {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }
    }

    static final class ReactViewGroupHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canActivate(@NotNull View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.canActivate(this, view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(@NotNull MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.canBegin(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void handleEventBeforeActivation(@NotNull MotionEvent motionEvent) {
            NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean shouldRecognizeSimultaneously(@NotNull GestureHandler gestureHandler) {
            return NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public Boolean sendTouchEvent(@Nullable View view, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (view != null) {
                return Boolean.valueOf(view.dispatchTouchEvent(event));
            }
            return null;
        }
    }
}
