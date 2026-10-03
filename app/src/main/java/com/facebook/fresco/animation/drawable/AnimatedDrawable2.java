package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private AnimationBackend _animationBackend;
    private int _droppedFrames;
    private volatile boolean _isRunning;
    private final AnimationBackend.Listener animationBackendListener;
    private volatile AnimationListener animationListener;
    private volatile DrawListener drawListener;
    private DrawableProperties drawableProperties;
    private long expectedRenderTimeMs;
    private FrameScheduler frameScheduler;
    private long frameSchedulingDelayMs;
    private long frameSchedulingOffsetMs;
    private final Runnable invalidateRunnable;
    private int lastDrawnFrameNumber;
    private long lastFrameAnimationTimeMs;
    private int pausedLastDrawnFrameNumber;
    private long pausedLastFrameAnimationTimeMsDifference;
    private long pausedStartTimeMsDifference;
    private long startTimeMs;
    public static final Companion Companion = new Companion(null);
    private static final Class<?> TAG = AnimatedDrawable2.class;
    private static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();

    public interface DrawListener {
        void onDraw(@NotNull AnimatedDrawable2 animatedDrawable2, @NotNull FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public AnimatedDrawable2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public /* synthetic */ AnimatedDrawable2(AnimationBackend animationBackend, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : animationBackend);
    }

    public AnimatedDrawable2(@Nullable AnimationBackend animationBackend) {
        this._animationBackend = animationBackend;
        this.frameSchedulingDelayMs = 8L;
        this.animationListener = NO_OP_LISTENER;
        AnimationBackend.Listener listener = new AnimationBackend.Listener() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0
            private static final byte[] $$c = {96, -63, 33, 4};
            private static final int $$d = 227;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {5, Ascii.ESC, -76, Ascii.CR, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, 50, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, -50, -14};
            private static final int $$b = 233;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static long coroutineBoundary = -899883803867009716L;
            private static int accessartificialFrame = -1151259316;
            private static char CoroutineDebuggingKt = 28198;

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(short r5, short r6, int r7) {
                /*
                    int r5 = r5 * 2
                    int r5 = 3 - r5
                    int r6 = r6 * 4
                    int r0 = r6 + 1
                    byte[] r1 = com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0.$$c
                    int r7 = r7 + 98
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    if (r1 != 0) goto L15
                    r4 = r7
                    r3 = r2
                    r7 = r6
                    goto L27
                L15:
                    r3 = r2
                L16:
                    byte r4 = (byte) r7
                    r0[r3] = r4
                    if (r3 != r6) goto L21
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0, r2)
                    return r5
                L21:
                    int r3 = r3 + 1
                    int r5 = r5 + 1
                    r4 = r1[r5]
                L27:
                    int r7 = r7 + r4
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0.$$e(short, short, int):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001c  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(int r5, short r6, short r7, java.lang.Object[] r8) {
                /*
                    byte[] r0 = com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0.$$a
                    int r5 = 69 - r5
                    int r1 = 28 - r6
                    int r7 = 115 - r7
                    byte[] r1 = new byte[r1]
                    int r6 = 27 - r6
                    r2 = -1
                    if (r0 != 0) goto L12
                    r3 = r2
                    r2 = r5
                    goto L2d
                L12:
                    r4 = r7
                    r7 = r5
                    r5 = r4
                L15:
                    int r2 = r2 + 1
                    byte r3 = (byte) r5
                    r1[r2] = r3
                    if (r2 != r6) goto L25
                    java.lang.String r5 = new java.lang.String
                    r6 = 0
                    r5.<init>(r1, r6)
                    r8[r6] = r5
                    return
                L25:
                    int r7 = r7 + 1
                    r3 = r0[r7]
                    r4 = r2
                    r2 = r7
                    r7 = r3
                    r3 = r4
                L2d:
                    int r7 = -r7
                    int r5 = r5 + r7
                    int r5 = r5 + (-5)
                    r7 = r2
                    r2 = r3
                    goto L15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0.b(int, short, short, java.lang.Object[]):void");
            }

            @Override // com.facebook.fresco.animation.backend.AnimationBackend.Listener
            public final void onAnimationLoaded() {
                AnimatedDrawable2.animationBackendListener$lambda$0(this.f$0);
            }

            private static void a(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) throws Throwable {
                int i2 = 2;
                int i3 = 2 % 2;
                ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
                int length = cArr2.length;
                char[] cArr4 = new char[length];
                int length2 = cArr.length;
                char[] cArr5 = new char[length2];
                int i4 = 0;
                System.arraycopy(cArr2, 0, cArr4, 0, length);
                System.arraycopy(cArr, 0, cArr5, 0, length2);
                cArr4[0] = (char) (cArr4[0] ^ c);
                cArr5[2] = (char) (cArr5[2] + ((char) i));
                int length3 = cArr3.length;
                char[] cArr6 = new char[length3];
                iCustomTabsCallbackDefault.a = 0;
                while (iCustomTabsCallbackDefault.a < length3) {
                    int i5 = $10 + 59;
                    $11 = i5 % 128;
                    int i6 = i5 % i2;
                    try {
                        Object[] objArr2 = {iCustomTabsCallbackDefault};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                        if (objAccessartificialFrame == null) {
                            int iResolveSize = View.resolveSize(i4, i4) + 33;
                            char c2 = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1);
                            int absoluteGravity = Gravity.getAbsoluteGravity(i4, i4) + 1483;
                            byte b = (byte) i4;
                            byte b2 = b;
                            String str$$e = $$e(b, b2, (byte) (b2 + 1));
                            Class[] clsArr = new Class[1];
                            clsArr[i4] = Object.class;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveSize, c2, absoluteGravity, 1614432829, false, str$$e, clsArr);
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        try {
                            Object[] objArr3 = {iCustomTabsCallbackDefault};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                            if (objAccessartificialFrame2 == null) {
                                int i7 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 31;
                                char cMyTid = (char) (49168 - (Process.myTid() >> 22));
                                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 900;
                                byte b3 = (byte) i4;
                                byte b4 = b3;
                                String str$$e2 = $$e(b3, b4, (byte) (b4 + 3));
                                Class[] clsArr2 = new Class[1];
                                clsArr2[i4] = Object.class;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i7, cMyTid, packedPositionChild, 214239564, false, str$$e2, clsArr2);
                            }
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                            int i8 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                            try {
                                Object[] objArr4 = new Object[3];
                                objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                                objArr4[1] = Integer.valueOf(i8);
                                objArr4[i4] = iCustomTabsCallbackDefault;
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                                if (objAccessartificialFrame3 == null) {
                                    byte b5 = (byte) i4;
                                    byte b6 = b5;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(22 - TextUtils.lastIndexOf("", '0'), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', i4, i4)), 2442 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), -1003383455, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                                }
                                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                                try {
                                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b7 = (byte) 0;
                                        byte b8 = b7;
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 29754), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1748, 1479752515, false, $$e(b7, b8, (byte) (b8 + 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                                    }
                                    cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                                    cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                                    cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                                    iCustomTabsCallbackDefault.a++;
                                    int i9 = $11 + 91;
                                    $10 = i9 % 128;
                                    if (i9 % 2 != 0) {
                                        int i10 = 4 / 5;
                                    }
                                    i2 = 2;
                                    i4 = 0;
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
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                }
                String str = new String(cArr6);
                int i11 = $10 + 23;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                objArr[0] = str;
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
                    Method dump skipped, instruction units count: 3302
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        };
        this.animationBackendListener = listener;
        this.invalidateRunnable = new Runnable() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2$invalidateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.unscheduleSelf(this);
                this.this$0.invalidateSelf();
            }
        };
        this.frameScheduler = Companion.createSchedulerForBackendAndDelayMethod(this._animationBackend);
        AnimationBackend animationBackend2 = this._animationBackend;
        if (animationBackend2 != null) {
            animationBackend2.setAnimationListener(listener);
        }
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animationBackendListener$lambda$0(AnimatedDrawable2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animationListener.onAnimationLoaded();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this._animationBackend;
        return animationBackend != null ? animationBackend.getIntrinsicWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this._animationBackend;
        return animationBackend != null ? animationBackend.getIntrinsicHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (this._isRunning || (animationBackend = this._animationBackend) == null) {
            return;
        }
        Intrinsics.checkNotNull(animationBackend);
        if (animationBackend.getFrameCount() <= 1) {
            return;
        }
        this._isRunning = true;
        long jNow = now();
        long j = jNow - this.pausedStartTimeMsDifference;
        this.startTimeMs = j;
        this.expectedRenderTimeMs = j;
        this.lastFrameAnimationTimeMs = jNow - this.pausedLastFrameAnimationTimeMsDifference;
        this.lastDrawnFrameNumber = this.pausedLastDrawnFrameNumber;
        invalidateSelf();
        this.animationListener.onAnimationStart(this);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this._isRunning) {
            long jNow = now();
            this.pausedStartTimeMsDifference = jNow - this.startTimeMs;
            this.pausedLastFrameAnimationTimeMsDifference = jNow - this.lastFrameAnimationTimeMs;
            this.pausedLastDrawnFrameNumber = this.lastDrawnFrameNumber;
            this._isRunning = false;
            this.startTimeMs = 0L;
            this.expectedRenderTimeMs = 0L;
            this.lastFrameAnimationTimeMs = -1L;
            this.lastDrawnFrameNumber = -1;
            unscheduleSelf(this.invalidateRunnable);
            this.animationListener.onAnimationStop(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this._isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        long j;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._animationBackend == null || this.frameScheduler == null) {
            return;
        }
        long jNow = now();
        long jMax = this._isRunning ? (jNow - this.startTimeMs) + this.frameSchedulingOffsetMs : (long) Math.max(this.lastFrameAnimationTimeMs, 0.0d);
        FrameScheduler frameScheduler = this.frameScheduler;
        Intrinsics.checkNotNull(frameScheduler);
        int frameNumberToRender = frameScheduler.getFrameNumberToRender(jMax, this.lastFrameAnimationTimeMs);
        if (frameNumberToRender == -1) {
            AnimationBackend animationBackend = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend);
            frameNumberToRender = animationBackend.getFrameCount() - 1;
            this.animationListener.onAnimationStop(this);
            this._isRunning = false;
        } else if (frameNumberToRender == 0 && this.lastDrawnFrameNumber != -1 && jNow >= this.expectedRenderTimeMs) {
            this.animationListener.onAnimationRepeat(this);
        }
        int i = frameNumberToRender;
        AnimationBackend animationBackend2 = this._animationBackend;
        Intrinsics.checkNotNull(animationBackend2);
        boolean zDrawFrame = animationBackend2.drawFrame(this, canvas, i);
        if (zDrawFrame) {
            this.animationListener.onAnimationFrame(this, i);
            this.lastDrawnFrameNumber = i;
        }
        if (!zDrawFrame) {
            onFrameDropped();
        }
        long jNow2 = now();
        long j4 = -1;
        if (this._isRunning) {
            FrameScheduler frameScheduler2 = this.frameScheduler;
            Intrinsics.checkNotNull(frameScheduler2);
            long targetRenderTimeForNextFrameMs = frameScheduler2.getTargetRenderTimeForNextFrameMs(jNow2 - this.startTimeMs);
            if (targetRenderTimeForNextFrameMs != -1) {
                j4 = this.frameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                scheduleNextFrame(j4);
            } else {
                this.animationListener.onAnimationStop(this);
                this._isRunning = false;
            }
            j = targetRenderTimeForNextFrameMs;
            j2 = j4;
        } else {
            j = -1;
            j2 = -1;
        }
        DrawListener drawListener = this.drawListener;
        if (drawListener != null) {
            FrameScheduler frameScheduler3 = this.frameScheduler;
            if (frameScheduler3 != null) {
                drawListener.onDraw(this, frameScheduler3, i, zDrawFrame, this._isRunning, this.startTimeMs, jMax, this.lastFrameAnimationTimeMs, jNow, jNow2, j, j2);
                j3 = jMax;
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        } else {
            j3 = jMax;
        }
        this.lastFrameAnimationTimeMs = j3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.drawableProperties == null) {
            this.drawableProperties = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.drawableProperties;
        Intrinsics.checkNotNull(drawableProperties);
        drawableProperties.setAlpha(i);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.drawableProperties == null) {
            this.drawableProperties = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.drawableProperties;
        Intrinsics.checkNotNull(drawableProperties);
        drawableProperties.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public final void preloadAnimation() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.preloadAnimation();
        }
    }

    public final AnimationBackend getAnimationBackend() {
        return this._animationBackend;
    }

    public final void setAnimationBackend(@Nullable AnimationBackend animationBackend) {
        AnimationBackend animationBackend2 = this._animationBackend;
        if (animationBackend2 != null) {
            Intrinsics.checkNotNull(animationBackend2);
            animationBackend2.setAnimationListener(null);
        }
        this._animationBackend = animationBackend;
        if (animationBackend != null) {
            Intrinsics.checkNotNull(animationBackend);
            this.frameScheduler = new DropFramesFrameScheduler(animationBackend);
            AnimationBackend animationBackend3 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend3);
            animationBackend3.setAnimationListener(this.animationBackendListener);
            AnimationBackend animationBackend4 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend4);
            animationBackend4.setBounds(getBounds());
            DrawableProperties drawableProperties = this.drawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.frameScheduler = Companion.createSchedulerForBackendAndDelayMethod(this._animationBackend);
        stop();
    }

    public final long getDroppedFrames() {
        return this._droppedFrames;
    }

    public final boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.frameScheduler;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    public final void jumpToFrame(int i) {
        FrameScheduler frameScheduler;
        if (this._animationBackend == null || (frameScheduler = this.frameScheduler) == null) {
            return;
        }
        Intrinsics.checkNotNull(frameScheduler);
        this.lastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(i);
        this.pausedLastDrawnFrameNumber = i;
        this.pausedStartTimeMsDifference = 0L;
        this.pausedLastFrameAnimationTimeMsDifference = 0L;
        long jNow = now() - this.lastFrameAnimationTimeMs;
        this.startTimeMs = jNow;
        this.expectedRenderTimeMs = jNow;
        invalidateSelf();
    }

    public final long getLoopDurationMs() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0L;
        }
        FrameScheduler frameScheduler = this.frameScheduler;
        if (frameScheduler != null) {
            Intrinsics.checkNotNull(frameScheduler);
            return frameScheduler.getLoopDurationMs();
        }
        Intrinsics.checkNotNull(animationBackend);
        int frameCount = animationBackend.getFrameCount();
        int frameDurationMs = 0;
        for (int i = 0; i < frameCount; i++) {
            AnimationBackend animationBackend2 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend2);
            frameDurationMs += animationBackend2.getFrameDurationMs(i);
        }
        return frameDurationMs;
    }

    public final int getFrameCount() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getFrameCount();
    }

    public final int getFrameDurationMs(int i) {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getFrameDurationMs(i);
    }

    public final int getLoopCount() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getLoopCount();
    }

    public final void setFrameSchedulingDelayMs(long j) {
        this.frameSchedulingDelayMs = j;
    }

    public final void setFrameSchedulingOffsetMs(long j) {
        this.frameSchedulingOffsetMs = j;
    }

    public final void setAnimationListener(@Nullable AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.animationListener = animationListener;
    }

    public final void setDrawListener(@Nullable DrawListener drawListener) {
        this.drawListener = drawListener;
    }

    private final void scheduleNextFrame(long j) {
        long j2 = this.startTimeMs + j;
        this.expectedRenderTimeMs = j2;
        scheduleSelf(this.invalidateRunnable, j2);
    }

    private final void onFrameDropped() {
        this._droppedFrames++;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this._droppedFrames));
        }
    }

    private final long now() {
        return SystemClock.uptimeMillis();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this._isRunning) {
            return false;
        }
        long j = i;
        if (this.lastFrameAnimationTimeMs == j) {
            return false;
        }
        this.lastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FrameScheduler createSchedulerForBackendAndDelayMethod(AnimationBackend animationBackend) {
            if (animationBackend == null) {
                return null;
            }
            return new DropFramesFrameScheduler(animationBackend);
        }
    }
}
