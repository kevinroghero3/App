package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.animation.AnimationUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onPostMessage;

/* JADX INFO: loaded from: classes5.dex */
public class ExpandCollapseAnimationHelper {
    private ValueAnimator.AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final View expandedView;
    private int expandedViewOffsetY;
    private static final byte[] $$a = {55, 117, 51, -11};
    private static final int $$b = JfifUtil.MARKER_EOI;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-1588045568, -967035810, 1644189143, 1212004679, 1965859087, 946316126, -1480746292, -1029668296, -2058328950, 515246878, -253075159, -957247890, 1471627267, -1078977700, -1444640647, -102366345, -2020200205, 535344748};
    private static char[] IPostMessageService = {38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38279, 38374, 38353, 38350, 38355, 38353, 38345, 38280, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38365, 38355, 38361, 38309, 38286, 38396, 38391, 38283, 38282, 38362, 38356, 38356, 38392, 38383, 38355, 38363, 38355, 38348, 38354, 38353, 38345, 38380, 38391, 38363, 38356, 38348, 38382, 38279, 38379, 38356, 38348, 38353, 38360, 38360, 38361, 38365, 38357, 38355, 38378, 38380, 38365, 38356, 38350, 38351, 38346, 38277, 38382, 38384, 38353, 38386, 38399, 38369, 38359, 38357, 38360, 38357, 38347, 38348, 38356, 38364, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38277, 38348, 38356, 38379, 38379, 38355, 38357, 38358, 38356, 38358, 38358, 38361, 38361, 38355, 38357, 38365, 38361, 38360, 38360, 38287, 38362, 38360, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38273, 38283, 38285, 38393, 38396, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356};
    private final List<AnimatorListenerAdapter> listeners = new ArrayList();
    private final List<View> endAnchoredViews = new ArrayList();

    private static String $$c(byte b, short s, short s2) {
        byte[] bArr = $$a;
        int i = b + 65;
        int i2 = s2 * 2;
        int i3 = 3 - (s * 3);
        byte[] bArr2 = new byte[1 - i2];
        int i4 = 0 - i2;
        int i5 = -1;
        if (bArr == null) {
            i = i4 + i3;
            i3 = i3;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i4) {
                return new String(bArr2, 0);
            }
            int i7 = i3 + 1;
            i += bArr[i7];
            i3 = i7;
            i5 = i6;
        }
    }

    public ExpandCollapseAnimationHelper(@NonNull View view, @NonNull View view2) {
        this.collapsedView = view;
        this.expandedView = view2;
    }

    public Animator getExpandAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(true);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.ExpandCollapseAnimationHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(0);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    public Animator getCollapseAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(false);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.ExpandCollapseAnimationHelper.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(8);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    public ExpandCollapseAnimationHelper setDuration(long j) {
        this.duration = j;
        return this;
    }

    public ExpandCollapseAnimationHelper addListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.listeners.add(animatorListenerAdapter);
        return this;
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull View... viewArr) {
        Collections.addAll(this.endAnchoredViews, viewArr);
        return this;
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull Collection<View> collection) {
        this.endAnchoredViews.addAll(collection);
        return this;
    }

    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(@Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.additionalUpdateListener = animatorUpdateListener;
        return this;
    }

    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int i) {
        this.collapsedViewOffsetY = i;
        return this;
    }

    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int i) {
        this.expandedViewOffsetY = i;
        return this;
    }

    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i4 = 44;
        int i5 = -1780896814;
        int i6 = 1;
        int i7 = 0;
        if (iArr2 != null) {
            int i8 = $11 + 21;
            int i9 = i8 % 128;
            $10 = i9;
            int i10 = i8 % 2;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i11 = i9 + 9;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            int i13 = 0;
            while (i13 < length) {
                int i14 = $10 + 107;
                $11 = i14 % 128;
                int i15 = i14 % i2;
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i7] = Integer.valueOf(iArr2[i13]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = (byte) i7;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - View.MeasureSpec.getMode(i7), (char) (Process.getGidForName("") + 1), 1561 - MotionEvent.axisFromString(""), 180153818, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    iArr3[i13] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i13++;
                    i2 = 2;
                    i4 = 44;
                    i5 = -1780896814;
                    i7 = 0;
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
        long j = 0;
        if (iArr5 != null) {
            int i16 = $11 + 121;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i18 = 0;
            while (i18 < length3) {
                Object[] objArr3 = new Object[i6];
                objArr3[0] = Integer.valueOf(iArr5[i18]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 11, (char) (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 1562, 180153818, false, $$c((byte) 44, b3, b3), new Class[]{Integer.TYPE});
                }
                iArr6[i18] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i18++;
                iArr5 = iArr5;
                j = 0;
                i6 = 1;
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
            int i19 = 0;
            while (i19 < 16) {
                int i20 = $10 + 51;
                $11 = i20 % 128;
                if (i20 % 2 == 0) {
                    artificialframe.c ^= iArr4[i19];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 26, (char) Color.blue(0), AndroidCharacter.getMirror('0') + 993, 995482881, false, $$c((byte) ($$a[2] - 1), b4, b4), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i19 += 53;
                } else {
                    artificialframe.c ^= iArr4[i19];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1040 - MotionEvent.axisFromString(""), 995482881, false, $$c((byte) ($$a[2] - 1), b5, b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue2;
                    i19++;
                }
            }
            int i21 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i21;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i22 = artificialframe.c;
            int i23 = artificialframe.b;
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
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(36 - TextUtils.lastIndexOf("", '0', 0), (char) (28010 - (ViewConfiguration.getTapTimeout() >> 16)), ((byte) KeyEvent.getModifierMetaStateMask()) + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            c = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private AnimatorSet getAnimatorSet(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(getExpandCollapseAnimator(z), getExpandedViewChildrenAlphaAnimator(z), getEndAnchoredViewsTranslateAnimator(z));
        return animatorSet;
    }

    private Animator getExpandCollapseAnimator(boolean z) {
        Rect rectCalculateRectFromBounds = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect rectCalculateRectFromBounds2 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        final Rect rect = new Rect(rectCalculateRectFromBounds);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new RectEvaluator(rect), rectCalculateRectFromBounds, rectCalculateRectFromBounds2);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.ExpandCollapseAnimationHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$getExpandCollapseAnimator$0(rect, valueAnimator);
            }
        });
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.additionalUpdateListener;
        if (animatorUpdateListener != null) {
            valueAnimatorOfObject.addUpdateListener(animatorUpdateListener);
        }
        valueAnimatorOfObject.setDuration(this.duration);
        valueAnimatorOfObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return valueAnimatorOfObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getExpandCollapseAnimator$0(Rect rect, ValueAnimator valueAnimator) {
        ViewUtils.setBoundsFromRect(this.expandedView, rect);
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean z) {
        List<View> children = ViewUtils.getChildren(this.expandedView);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(children));
        valueAnimatorOfFloat.setDuration(this.duration);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
        return valueAnimatorOfFloat;
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((this.expandedView.getLeft() - this.collapsedView.getLeft()) + (this.collapsedView.getRight() - this.expandedView.getRight()), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(this.endAnchoredViews));
        valueAnimatorOfFloat.setDuration(this.duration);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return valueAnimatorOfFloat;
    }

    private void addListeners(Animator animator, List<AnimatorListenerAdapter> list) {
        Iterator<AnimatorListenerAdapter> it2 = list.iterator();
        while (it2.hasNext()) {
            animator.addListener(it2.next());
        }
    }

    private static void b(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
        int i;
        int i2;
        char[] cArr;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = 1;
        int i7 = iArr[1];
        int i8 = iArr[2];
        int i9 = iArr[3];
        char[] cArr2 = IPostMessageService;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i10 = 0;
            while (i10 < length) {
                try {
                    Object[] objArr2 = new Object[i6];
                    objArr2[i4] = Integer.valueOf(cArr2[i10]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - TextUtils.getCapsMode("", i4, i4), (char) (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1562, 178318710, false, $$c(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    cArr3[i10] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i10++;
                    i4 = 0;
                    i6 = 1;
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
        char[] cArr4 = new char[i7];
        System.arraycopy(cArr2, i5, cArr4, 0, i7);
        if (bArr != null) {
            char[] cArr5 = new char[i7];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i7) {
                if (bArr[onpostmessage.a] == 1) {
                    int i11 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 3;
                        byte b4 = (byte) (b3 - 3);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - Color.alpha(0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 2441 - View.getDefaultSize(0, 0), -850656813, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[i11] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i12 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 10, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), TextUtils.lastIndexOf("", '0', 0) + 1563, 1918398056, false, $$c((byte) 57, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[i12] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr5[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - View.MeasureSpec.getMode(0), (char) (29363 - Color.blue(0)), 214 - TextUtils.indexOf((CharSequence) "", '0'), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr4 = cArr5;
        }
        if (i9 > 0) {
            char[] cArr6 = new char[i7];
            System.arraycopy(cArr4, 0, cArr6, 0, i7);
            int i13 = i7 - i9;
            System.arraycopy(cArr6, 0, cArr4, i13, i9);
            System.arraycopy(cArr6, i9, cArr4, 0, i13);
        }
        if (z) {
            int i14 = $11 + 15;
            $10 = i14 % 128;
            if (i14 % 2 != 0) {
                cArr = new char[i7];
                i2 = 0;
            } else {
                i2 = 0;
                cArr = new char[i7];
            }
            while (true) {
                onpostmessage.a = i2;
                if (onpostmessage.a >= i7) {
                    break;
                }
                int i15 = $10 + 99;
                $11 = i15 % 128;
                if (i15 % 2 == 0) {
                    cArr[onpostmessage.a] = cArr4[i7 << onpostmessage.a];
                    i2 = onpostmessage.a >>> 1;
                } else {
                    cArr[onpostmessage.a] = cArr4[(i7 - onpostmessage.a) - 1];
                    i2 = onpostmessage.a + 1;
                }
            }
            int i16 = $10 + 93;
            $11 = i16 % 128;
            i = 2;
            int i17 = i16 % 2;
            cArr4 = cArr;
        } else {
            i = 2;
        }
        if (i8 > 0) {
            int i18 = $10 + 87;
            $11 = i18 % 128;
            int i19 = i18 % i;
            int i20 = 0;
            while (true) {
                onpostmessage.a = i20;
                if (onpostmessage.a >= i7) {
                    break;
                }
                cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[i]);
                i20 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0754, code lost:
    
        r11 = -(-android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0'));
        r15 = new java.lang.Object[1];
        a((r14 ^ r11) + ((r11 & r14) << 1), new int[]{2004257643, -1393803006, -693954359, -1465221745, -276179506, -776419029, -321791006, -2118870610, -1712741147, 1753786694, -1413721752, 9187172}, r15);
        r11 = (java.lang.String) r15[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0770, code lost:
    
        r14 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r15 = (r14 ^ 125) + ((r14 & 125) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r15 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x077e, code lost:
    
        if ((r15 % 2) != 0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x078d, code lost:
    
        if (r13.equals(r12.getMethod(r11, null).invoke(r6, null)) == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x078f, code lost:
    
        r3 = new java.lang.Object[]{new int[]{r21}, new int[]{r21 ^ 1}, new int[1], null};
        r0 = (int) android.os.Process.getStartUptimeMillis();
        r4 = ~r0;
        r5 = (((1231986630 + (((~(r0 | 708513418)) | ((~((-1642113) | r4)) | (-976981663))) * (-68))) + ((~((-268468245) | r4)) * (-68))) + (((~((-708513419) | r4)) | (-270110357)) * 68)) + 16;
        r0 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r4 = ((r5 * (-661)) - (~(-(-(r22 * (-661)))))) - 1;
        r6 = ~r0;
        r8 = ~r5;
        r10 = ~r22;
        r8 = ~((r8 & r10) | (r8 ^ r10));
        r4 = (r4 - (~(-(-(((r6 & r8) | (r6 ^ r8)) * 1324))))) - 1;
        r6 = ~((r5 ^ r0) | (r5 & r0));
        r0 = ~(r0 | r22);
        r0 = ((r0 & r6) | (r6 ^ r0)) * (-1324);
        r6 = (r4 & r0) + (r0 | r4);
        r0 = ~((~r5) | r22);
        r4 = ~r22;
        r4 = ~((r4 & r5) | (r4 ^ r5));
        r0 = ((r0 & r4) | (r0 ^ r4)) * 662;
        r4 = ((r6 | r0) << 1) - (r0 ^ r6);
        r0 = (r4 << 13) ^ r4;
        r4 = r0 >>> 17;
        r0 = (r0 | r4) & (~(r0 & r4));
        r4 = r0 << 5;
        ((int[]) r3[2])[0] = (r0 | r4) & (~(r0 & r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x083f, code lost:
    
        r8 = r8 + 1;
        r11 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0123, code lost:
    
        r10 = android.text.TextUtils.lastIndexOf("", '0', 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x084d, code lost:
    
        r13.equals(r12.getMethod(r11, null).invoke(r6, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0850, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0851, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0855, code lost:
    
        if (r3 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0857, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0858, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0859, code lost:
    
        r0 = r10[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x085c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0127, code lost:
    
        r11 = r10 * (-419);
        r12 = (r11 & 16419) + (r11 | 16419);
        r11 = (~((r21 ^ 39) | (r21 & 39))) * androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.TYPE_EASING;
        r13 = (r12 ^ r11) + ((r11 & r12) << 1);
        r10 = ~r10;
        r11 = ((r10 ^ 39) | (r10 & 39)) * (-420);
        r12 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r14 = (r12 ^ 5) + ((r12 & 5) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r14 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x085d, code lost:
    
        r5 = ((r5 & 1) << 1) + (r5 ^ 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0867, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0868, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x086c, code lost:
    
        if (r3 != null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x086e, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x086f, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0870, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0871, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0875, code lost:
    
        if (r3 != null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0877, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0150, code lost:
    
        if ((r14 % 2) != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0878, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0879, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x087a, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x087e, code lost:
    
        if (r3 != null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0880, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0881, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0882, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0883, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0887, code lost:
    
        if (r3 != null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0889, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0152, code lost:
    
        r11 = r13 << r11;
        r10 = ~((r10 & (-40)) | (r10 ^ (-40)));
        r13 = ~((~r21) | 39);
        r11 = r11 * (420 - ((r10 & r13) | (r10 ^ r13)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x088a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x088b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x088c, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0890, code lost:
    
        if (r3 != null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0892, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0893, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0894, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0895, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0899, code lost:
    
        if (r3 != null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x089b, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x089c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x089d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x089e, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x08a2, code lost:
    
        if (r3 != null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x08a4, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x08a5, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x08a6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x08a7, code lost:
    
        r3 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x08ab, code lost:
    
        if (r3 != null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x08ad, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0167, code lost:
    
        r10 = new int[]{2053656101, -1468708902, -640085084, -1840530613, -388172363, 489805783, 1806522971, 435089417, 2096828405, 333251813, 80603227, -820928772, 445901792, 1832668528, -1961642151, -421212352, -532470132, 402224205, -1116697409, -758311461};
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x08ae, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x08af, code lost:
    
        r0 = new java.lang.Object[]{new int[]{r21}, new int[]{r21}, new int[1], null};
        r3 = ~(1034353884 | r21);
        r5 = (((-379166076) + (((-1073151998) | r3) * (-814))) + ((r3 | ((~((~r21) | 55730109)) | 16931996)) * 407)) + (((~(r21 | (-55730110))) | ((~((-1034353885) | r21)) | 16931996)) * 407);
        r1 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r3 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r4 = (r3 ^ 85) + ((r3 & 85) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r4 % 128;
        r4 = r4 % 2;
        r3 = -(-(r5 * (-163)));
        r4 = ~r1;
        r6 = -(-((~((r4 ^ r5) | (r4 & r5))) * (-328)));
        r8 = ((r3 | r6) << 1) - (r3 ^ r6);
        r3 = r1 * 164;
        r6 = (r8 ^ r3) + ((r3 & r8) << 1);
        com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r3 = ~r5;
        r1 = -(-(164 * (((~((r1 & r3) | (r3 ^ r1))) | (~(((-1) ^ r3) | r3))) | (~((r4 ^ r5) | (r4 & r5))))));
        r3 = (r6 ^ r1) + ((r1 & r6) << 1);
        r1 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r4 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r5 = (r4 & 25) + (r4 | 25);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0956, code lost:
    
        if ((r5 % 2) == 0) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0958, code lost:
    
        r5 = -r22;
        r4 = (r3 - 405) * ((r5 ^ 407) + ((r5 & 407) << 1));
        r5 = ~r22;
        r5 = ~((r5 & r1) | (r5 ^ r1));
        r6 = (~r1) | r3;
        r6 = ~((r6 & r22) | (r6 ^ r22));
        r4 = r4 * ((-406) << ((r5 & r6) | (r5 ^ r6)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0979, code lost:
    
        r4 = r3 * (-405);
        r5 = r22 * 407;
        r6 = (r4 & r5) + (r4 | r5);
        r4 = ~((~r22) | r1);
        r5 = ~r1;
        r5 = (r5 & r3) | (r5 ^ r3);
        r5 = ~((r5 & r22) | (r5 ^ r22));
        r4 = ((r4 & r5) | (r4 ^ r5)) * (-406);
        r4 = (r4 | r6) + (r6 & r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0998, code lost:
    
        r5 = ~r22;
        r6 = ~r1;
        r5 = r5 | r6;
        r4 = r4 + ((-406) * (~((r5 & r3) | (r5 ^ r3))));
        r3 = ~r3;
        r1 = ~((r1 & r3) | (r3 ^ r1));
        r2 = ~((r22 & r6) | (r6 ^ r22));
        r1 = -(-(((r1 & r2) | (r1 ^ r2)) * 406));
        r2 = (r4 & r1) + (r1 | r4);
        r1 = r2 << 13;
        r1 = (r1 & (~r2)) | ((~r1) & r2);
        r2 = r1 >>> 17;
        r1 = (r1 | r2) & (~(r1 & r2));
        r2 = r1 << 5;
        ((int[]) r0[2])[0] = ((~r1) & r2) | ((~r2) & r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x09d7, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x016d, code lost:
    
        r11 = -(-r11);
        r14 = ((r13 | r11) << 1) - (r11 ^ r13);
        r10 = ~((r10 & (-40)) | (r10 ^ (-40)));
        r11 = ~r21;
        r11 = ~((r11 & 39) | (r11 ^ 39));
        r10 = -(-(((r10 & r11) | (r10 ^ r11)) * androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.TYPE_EASING));
        r11 = (r14 ^ r10) + ((r10 & r14) << 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x018f, code lost:
    
        r13 = (r12 & 35) + (r12 | 35);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0199, code lost:
    
        if ((r13 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x019b, code lost:
    
        r13 = new java.lang.Object[1];
        a(r11, r10, r13);
        r10 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName((java.lang.String) r13[0]), 2);
        r11 = -android.text.TextUtils.lastIndexOf("", 'n', 0, 0);
        r13 = 9;
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x01b9, code lost:
    
        r13 = new java.lang.Object[1];
        a(r11, r10, r13);
        r10 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName((java.lang.String) r13[0]), 2);
        r11 = -android.text.TextUtils.lastIndexOf("", '0', 0, 0);
        r14 = 0;
        r13 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x01d4, code lost:
    
        r15 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r5 = r11 * (-167);
        r8 = -(-(r13 * (-167)));
        r16 = (r5 & r8) + (r5 | r8);
        r5 = ~r11;
        r8 = ~r13;
        r5 = ~((r5 ^ r8) | (r5 & r8));
        r12 = ~r15;
        r6 = ~((r8 ^ r12) | (r8 & r12));
        r5 = ((r5 ^ r6) | (r5 & r6)) * 168;
        r6 = (r16 ^ r5) + ((r16 & r5) << 1);
        r5 = ~r11;
        r4 = ~r13;
        r4 = (r5 ^ r4) | (r4 & r5);
        r4 = -(-((~((r4 ^ r15) | (r4 & r15))) * 168));
        r18 = (r6 ^ r4) + ((r4 & r6) << 1);
        r4 = ~((r5 ^ r12) | (r5 & r12));
        r5 = ~((r5 & r13) | (r5 ^ r13));
        r4 = (r4 & r5) | (r4 ^ r5);
        r5 = (r8 ^ r11) | (r8 & r11);
        r5 = ~((r5 & r15) | (r5 ^ r15));
        r4 = -(-(((r4 & r5) | (r4 ^ r5)) * 168));
        r6 = new java.lang.Object[1];
        a(((r18 | r4) << 1) - (r18 ^ r4), new int[]{-1143093364, 1031716330, 919346744, 1720297628, 666016303, 1047644140, -1318156528, -1756634735, -950292797, 983693978, 919346744, 1720297628, -709676022, -1198408673, -594803311, -496208021}, r6);
        r4 = (java.lang.String) r6[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x024e, code lost:
    
        r5 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r6 = ((r5 | 67) << 1) - (r5 ^ 67);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x025c, code lost:
    
        r5 = -android.view.View.resolveSizeAndState(0, 0, 0);
        r8 = new java.lang.Object[1];
        a(((r5 | 38) << 1) - (r5 ^ 38), new int[]{2053656101, -1468708902, -640085084, -1840530613, -388172363, 489805783, 1806522971, 435089417, 2096828405, 333251813, 80603227, -820928772, 445901792, 1832668528, -1961642151, -421212352, -532470132, 402224205, -1116697409, -758311461}, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x028d, code lost:
    
        r10[r14] = java.lang.Class.forName((java.lang.String) r8[0]).getDeclaredConstructor(java.lang.String.class).newInstance(r4);
        r5 = new java.lang.Object[1];
        a(30 - android.text.TextUtils.lastIndexOf("", '0'), new int[]{-109612279, 2101287924, -950292797, 983693978, 919346744, 1720297628, -709676022, -1198408673, 1611070991, 591142963, -1487811994, 1442614595, -63577796, -751550956, 603298290, 372670507}, r5);
        r4 = (java.lang.String) r5[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x02a9, code lost:
    
        r5 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r6 = (r5 & 73) + (r5 | 73);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x02b6, code lost:
    
        if ((r6 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x02b8, code lost:
    
        r4 = new java.lang.Object[]{r4};
        r5 = android.view.View.resolveSize(1, 0);
        r6 = 52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x02c3, code lost:
    
        r4 = new java.lang.Object[]{r4};
        r5 = android.view.View.resolveSize(0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x02cb, code lost:
    
        r6 = 38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x02cd, code lost:
    
        r8 = r5 * (-813);
        r11 = -(-(r6 * com.transistorsoft.locationmanager.location.TSLocationManager.LOCATION_ERROR_TIMEOUT));
        r12 = (r8 ^ r11) + ((r8 & r11) << 1);
        r8 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r11 = r8 + 65;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r11 % 128;
        r11 = r11 % 2;
        r11 = ~r6;
        r13 = (-814) * ((~((r11 & r5) | (r11 ^ r5))) | (~((r5 ^ r21) | (r5 & r21))));
        r11 = ((r12 | r13) << 1) - (r12 ^ r13);
        r8 = r8 + 117;
        r12 = r8 % 128;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x02ff, code lost:
    
        if ((r8 % 2) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0301, code lost:
    
        r8 = ~r6;
        r13 = ~r21;
        r8 = ~((r8 & r13) | (r8 ^ r13));
        r13 = ~r5;
        r13 = ~((r13 & r6) | (r13 ^ r6));
        r8 = (r8 & r13) | (r8 ^ r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0314, code lost:
    
        r13 = 49 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0316, code lost:
    
        r8 = ~r6;
        r13 = ~r21;
        r8 = ~((r8 & r13) | (r8 ^ r13));
        r13 = ~((~r5) | r6);
        r8 = (r8 & r13) | (r8 ^ r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0324, code lost:
    
        r13 = ~(r5 | r21);
        r8 = -(-(((r8 & r13) | (r8 ^ r13)) * 407));
        r13 = ((r11 | r8) << 1) - (r8 ^ r11);
        r8 = ~r5;
        r8 = ~((r8 & r6) | (r8 ^ r6));
        r5 = ~r5;
        r5 = ~((r5 & r21) | (r5 ^ r21));
        r5 = (r5 & r8) | (r8 ^ r5);
        r6 = ~((r6 & r21) | (r6 ^ r21));
        r13 = (r13 - (~(-(-(((r5 & r6) | (r5 ^ r6)) * 407))))) - 1;
        r5 = ((r12 | 17) << 1) - (r12 ^ 17);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0362, code lost:
    
        r6 = new java.lang.Object[1];
        a(r13, new int[]{2053656101, -1468708902, -640085084, -1840530613, -388172363, 489805783, 1806522971, 435089417, 2096828405, 333251813, 80603227, -820928772, 445901792, 1832668528, -1961642151, -421212352, -532470132, 402224205, -1116697409, -758311461}, r6);
        r5 = java.lang.Class.forName((java.lang.String) r6[0]).getDeclaredConstructor(java.lang.String.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x037e, code lost:
    
        r6 = ~r21;
        r8 = ~((((-1067631649) & r6) | ((-1067631649) ^ r6)) | 1277442676);
        r6 = (r6 & (-1277442677)) | ((-1277442677) ^ r6);
        r6 = ~((r6 & 1067631648) | (r6 ^ 1067631648));
        r6 = -(-(((r6 & r8) | (r8 ^ r6)) * (-184)));
        r12 = (348128308 & r6) + (r6 | 348128308);
        r6 = ~r21;
        r6 = -(-(((~((r6 & (-1277442677)) | ((-1277442677) ^ r6))) | ((~(((-1067631649) & r6) | ((-1067631649) ^ r6))) | 203423776)) * ch.qos.logback.core.net.SyslogConstants.LOG_LOCAL7));
        r8 = ((r12 & r6) + (r6 | r12)) - 1073290400;
        r6 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r11 = ~r6;
        r11 = -(-((~((r11 & (-1556743031)) | ((-1556743031) ^ r11))) * 979));
        r14 = (((1403624212 & r11) + (r11 | 1403624212)) - (~(-(-((((-973773288) ^ r6) | ((-973773288) & r6)) * (-979)))))) - 1;
        r12 = ~(((-1556743031) & r6) | ((-1556743031) ^ r6));
        r6 = ~r6;
        r6 = ~((r6 & (-973773288)) | (r6 ^ (-973773288)));
        r6 = ((r6 & r12) | (r12 ^ r6)) * 979;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0405, code lost:
    
        if (r8 <= ((r14 ^ r6) + ((r6 & r14) << 1))) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x040b, code lost:
    
        r10[1] = r5.newInstance(r4);
        r4 = 18 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0415, code lost:
    
        r10[1] = r5.newInstance(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0419, code lost:
    
        r8 = new java.lang.Object[1];
        b(false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0}, new int[]{0, 23, 0, 0}, r8);
        r5 = java.lang.Class.forName((java.lang.String) r8[0]);
        r11 = new java.lang.Object[1];
        a(android.view.KeyEvent.getDeadChar(0, 0) + 17, new int[]{1083511439, 328918067, 1110702475, 1563480943, -123740846, 1884553706, 1679843198, 1646234063, 289300747, -63189571}, r11);
        r5 = r5.getMethod((java.lang.String) r11[0], null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x044a, code lost:
    
        r6 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r8 = (r6 ^ 47) + ((r6 & 47) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0459, code lost:
    
        if ((r8 % 2) == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x045b, code lost:
    
        r5 = r5.invoke(r20, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0461, code lost:
    
        r8 = 96 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0463, code lost:
    
        r5 = r5.invoke(r20, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0467, code lost:
    
        r11 = new java.lang.Object[1];
        b(false, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0}, new int[]{0, 23, 0, 0}, r11);
        r6 = java.lang.Class.forName((java.lang.String) r11[0]);
        r8 = -android.graphics.ImageFormat.getBitsPerPixel(0);
        r11 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r12 = (r8 * (-1939)) + 12623;
        r13 = ~((-14) | r8);
        r11 = ~r11;
        r14 = ~((r11 ^ 13) | (r11 & 13));
        r13 = ((r13 & r14) | (r13 ^ r14)) * (-970);
        r14 = (r12 & r13) + (r12 | r13);
        r8 = ~r8;
        r12 = -(-((~((r8 ^ 13) | (r8 & 13))) * 1940));
        r13 = ((r14 | r12) << 1) - (r12 ^ r14);
        r8 = ~((r8 & (-14)) | (r8 ^ (-14)));
        r11 = ~((r11 & 13) | (r11 ^ 13));
        r8 = -(-(((r8 & r11) | (r8 ^ r11)) * 970));
        r12 = new java.lang.Object[1];
        a((r13 ^ r8) + ((r8 & r13) << 1), new int[]{1083511439, 328918067, 1110702475, 1563480943, 823788042, -796783464, -667650700, 1034588987}, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x04e2, code lost:
    
        r8 = new java.lang.Object[]{r6.getMethod((java.lang.String) r12[0], null).invoke(r20, null), 64};
        r0 = -(android.os.SystemClock.currentThreadTimeMillis() > (-1) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1) ? 0 : -1));
        r12 = new java.lang.Object[1];
        a((r0 ^ 34) + ((r0 & 34) << 1), new int[]{-348689178, 709461007, 278157170, -989956444, -237226190, 231330916, -1287793827, -1376505337, 661928515, -1558678684, 1110702475, 1563480943, -123740846, 1884553706, 1679843198, 1646234063, 289300747, -63189571}, r12);
        r0 = java.lang.Class.forName((java.lang.String) r12[0]);
        r12 = new java.lang.Object[1];
        b(true, new byte[]{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, new int[]{23, 14, 0, 0}, r12);
        r0 = r0.getMethod((java.lang.String) r12[0], java.lang.String.class, java.lang.Integer.TYPE).invoke(r5, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x053b, code lost:
    
        r4 = android.text.TextUtils.indexOf("", "", 0, 0);
        r6 = new java.lang.Object[1];
        a((r4 & 30) + (r4 | 30), new int[]{-348689178, 709461007, 278157170, -989956444, -237226190, 231330916, -1287793827, -1376505337, 661928515, -1558678684, 1110702475, 1563480943, 1872005131, -567717973, 1112174780, 547808479}, r6);
        r4 = java.lang.Class.forName((java.lang.String) r6[0]);
        r5 = -android.os.Process.getGidForName("");
        r8 = new java.lang.Object[1];
        a(((r5 | 9) << 1) - (r5 ^ 9), new int[]{-326890388, 262813488, 1795438083, -1613232219, 2020731124, -1238931096}, r8);
        r0 = (java.lang.Object[]) r4.getField((java.lang.String) r8[0]).get(r0);
        r4 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x057e, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0021, code lost:
    
        if (r20 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x057f, code lost:
    
        if (r5 >= r4) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0581, code lost:
    
        r6 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame + 35;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x058e, code lost:
    
        if ((r6 % 2) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0590, code lost:
    
        r6 = r0[r5];
        r14 = new java.lang.Object[1];
        b(true, new byte[]{1, 1, 0, 1, 1}, new int[]{37, 5, 0, 3}, r14);
        r12 = r14[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x05a3, code lost:
    
        r12 = (java.lang.String) r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x05a6, code lost:
    
        r6 = r0[r5];
        r14 = new java.lang.Object[1];
        b(true, new byte[]{1, 1, 0, 1, 1}, new int[]{37, 5, 0, 3}, r14);
        r12 = r14[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x05ba, code lost:
    
        r13 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r14 = (r13 ^ 95) + ((r13 & 95) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r14 % 128;
        r14 = r14 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x05c8, code lost:
    
        r12 = new java.lang.Object[]{r12};
        r15 = new java.lang.Object[1];
        b(false, new byte[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{42, 37, 0, 0}, r15);
        r13 = java.lang.Class.forName((java.lang.String) r15[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x05e8, code lost:
    
        r14 = (android.widget.ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (android.widget.ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1));
        r15 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r15 = (r15 & 105) + (r15 | 105);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r15 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x05fc, code lost:
    
        if ((r15 % 2) == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x05fe, code lost:
    
        r15 = new java.lang.Object[1];
        a(12 / r14, new int[]{-581646756, -910376687, -409725041, -352276107, 38459726, 1416471391}, r15);
        r11 = (java.lang.String) r15[0];
        r14 = new java.lang.Class[0];
        r15 = java.lang.String.class;
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0615, code lost:
    
        r14 = -(-r14);
        r14 = new java.lang.Object[1];
        a(((r14 | 12) << 1) - (12 ^ r14), new int[]{-581646756, -910376687, -409725041, -352276107, 38459726, 1416471391}, r14);
        r11 = (java.lang.String) r14[0];
        r14 = new java.lang.Class[1];
        r15 = java.lang.String.class;
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0631, code lost:
    
        r14[r17] = r15;
        r11 = r13.getMethod(r11, r14).invoke(null, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0640, code lost:
    
        r14 = new java.lang.Object[1];
        b(false, new byte[]{0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}, new int[]{79, 28, 0, 14}, r14);
        r8 = java.lang.Class.forName((java.lang.String) r14[0]);
        r13 = -android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0);
        r15 = new java.lang.Object[1];
        a((r13 ^ 10) + ((r13 & 10) << 1), new int[]{-835263154, -499153290, 962743237, -1312730002, -2091154572, -497961815}, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0686, code lost:
    
        r6 = new java.lang.Object[]{new java.io.ByteArrayInputStream((byte[]) r8.getMethod((java.lang.String) r15[0], null).invoke(r6, null))};
        r13 = new java.lang.Object[1];
        b(false, new byte[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, new int[]{42, 37, 0, 0}, r13);
        r8 = java.lang.Class.forName((java.lang.String) r13[0]);
        r12 = new byte[]{0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x06ab, code lost:
    
        r13 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r14 = (r13 & 51) + (r13 | 51);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r14 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if (r20 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x06ba, code lost:
    
        if ((r14 % 2) != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x06c0, code lost:
    
        r14 = new java.lang.Object[1];
        b(true, r12, new int[]{107, 19, 0, 12}, r14);
        r12 = (java.lang.String) r14[0];
        r13 = new java.lang.Class[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x06d0, code lost:
    
        r14 = new java.lang.Object[1];
        b(true, r12, new int[]{107, 19, 0, 12}, r14);
        r12 = (java.lang.String) r14[0];
        r13 = new java.lang.Class[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x06e3, code lost:
    
        r13[0] = java.io.InputStream.class;
        r6 = r8.getMethod(r12, r13).invoke(r11, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x06ef, code lost:
    
        r8 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame + 65;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r8 % 128;
        r11 = 2;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x06f9, code lost:
    
        r8 = r10.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x06fa, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x06fb, code lost:
    
        if (r8 >= r11) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x06fd, code lost:
    
        r12 = com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame;
        r13 = r12 + 43;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r0 = new java.lang.Object[]{new int[]{r21}, new int[]{r21}, new int[1], null};
        r3 = new java.util.Random().nextInt();
        r5 = ~r3;
        r6 = (((-1981099522) + (((~(r5 | 888775714)) | ((~((-89848061) | r5)) | 16931036)) * 464)) + (((-72917025) | r3) * (-464))) + (((~(r3 | 888775714)) | 16931036) * 464);
        r3 = com.facebook.internal.Utility$$ExternalSyntheticLambda3.ICustomTabsCallbackDefault();
        r8 = ~r6;
        r5 = (-(-(r6 * (-675)))) + ((r3 | r8) * (-676));
        r10 = -(-(((~(~r6)) | (~(~r3))) * 676));
        r11 = (r5 ^ r10) + ((r5 & r10) << 1);
        r5 = ~(((-1) ^ r8) | r8);
        r10 = ~r3;
        r3 = -(-(((~((r3 & r6) | (r6 ^ r3))) | (r5 | (~((r8 & r10) | (r8 ^ r10))))) * 676));
        r5 = (r11 ^ r3) + ((r3 & r11) << 1);
        r3 = com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME;
        r6 = (r3 ^ 117) + ((r3 & 117) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r6 % 128;
        r6 = r6 % 2;
        r6 = r5 * 714;
        r8 = -(-(r22 * (-712)));
        r10 = (r6 & r8) + (r6 | r8);
        r6 = ~r5;
        r8 = ~r21;
        r6 = ~(r6 | r8);
        r11 = ~((~r5) | r22);
        r6 = (r6 & r11) | (r6 ^ r11);
        r11 = ~r22;
        r12 = (r11 ^ r5) | (r11 & r5);
        r12 = ~((r12 & r21) | (r12 ^ r21));
        r6 = -(-(((r6 & r12) | (r6 ^ r12)) * (-713)));
        r12 = (r10 & r6) + (r6 | r10);
        r2 = ~r22;
        r1 = -(-((~(r21 | ((r2 & r5) | (r2 ^ r5)))) * 1426));
        r2 = ((r12 | r1) << 1) - (r1 ^ r12);
        r1 = -(-((~((r11 ^ r8) | (r11 & r8))) * 713));
        r5 = (r2 ^ r1) + ((r1 & r2) << 1);
        r1 = r5 << 13;
        r1 = (r1 | r5) & (~(r5 & r1));
        r2 = r1 >>> 17;
        r1 = (r1 | r2) & (~(r1 & r2));
        r2 = r1 << 5;
        ((int[]) r0[2])[0] = ((~r1) & r2) | ((~r2) & r1);
        r1 = (r3 ^ 41) + ((r3 & 41) << 1);
        com.google.android.material.internal.ExpandCollapseAnimationHelper.artificialFrame = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0706, code lost:
    
        if ((r13 % r11) != 0) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0708, code lost:
    
        r13 = r10[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x070a, code lost:
    
        r12 = r12 + 97;
        com.google.android.material.internal.ExpandCollapseAnimationHelper.getARTIFICIAL_FRAME_PACKAGE_NAME = r12 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0711, code lost:
    
        if ((r12 % r11) == 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0715, code lost:
    
        r15 = new int[]{okhttp3.internal.ws.WebSocketProtocol.PAYLOAD_SHORT, 34, 0, r11};
        r11 = new java.lang.Object[1];
        b(true, new byte[]{1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1}, r15, r11);
        r12 = java.lang.Class.forName((java.lang.String) r11[0]);
        r14 = 34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0733, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0736, code lost:
    
        r15 = new java.lang.Object[1];
        b(true, new byte[]{1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1}, new int[]{okhttp3.internal.ws.WebSocketProtocol.PAYLOAD_SHORT, 34, 0, 2}, r15);
        r12 = java.lang.Class.forName((java.lang.String) r15[0]);
        r14 = 24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 3120
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ExpandCollapseAnimationHelper.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
    }
}
