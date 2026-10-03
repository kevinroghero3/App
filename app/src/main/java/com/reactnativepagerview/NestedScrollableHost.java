package com.reactnativepagerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NestedScrollableHost extends FrameLayout {
    private boolean didSetInitialIndex;
    private Integer initialIndex;
    private float initialX;
    private float initialY;
    private boolean nativeGestureStarted;
    private int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final Integer getInitialIndex() {
        return this.initialIndex;
    }

    public final void setInitialIndex(@Nullable Integer num) {
        this.initialIndex = num;
    }

    public final boolean getDidSetInitialIndex() {
        return this.didSetInitialIndex;
    }

    public final void setDidSetInitialIndex(boolean z) {
        this.didSetInitialIndex = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L1e
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L1e
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        L1e:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L25
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    private final boolean canChildScroll(int i, float f) {
        int i2 = -((int) Math.signum(f));
        if (i == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i2);
            }
        } else if (i == 1) {
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i2);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        handleInterceptTouchEvent(e);
        return super.onInterceptTouchEvent(e);
    }

    private final void handleInterceptTouchEvent(MotionEvent motionEvent) {
        ViewPager2 parentViewPager = getParentViewPager();
        Integer numValueOf = parentViewPager != null ? Integer.valueOf(parentViewPager.getOrientation()) : null;
        if (motionEvent.getAction() == 0) {
            this.initialX = motionEvent.getX();
            this.initialY = motionEvent.getY();
            if (numValueOf != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX() - this.initialX;
            float y = motionEvent.getY() - this.initialY;
            boolean z = numValueOf != null && numValueOf.intValue() == 0;
            float fAbs = Math.abs(x) * (z ? 0.5f : 1.0f);
            float fAbs2 = Math.abs(y) * (z ? 1.0f : 0.5f);
            float f = this.touchSlop;
            if (fAbs > f || fAbs2 > f) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                this.nativeGestureStarted = true;
                if (numValueOf == null) {
                    return;
                }
                if (z == (fAbs2 > fAbs)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                int iIntValue = numValueOf.intValue();
                if (!z) {
                    x = y;
                }
                if (canChildScroll(iIntValue, x)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (e.getActionMasked() == 1 && this.nativeGestureStarted) {
            NativeGestureUtil.notifyNativeGestureEnded(this, e);
            this.nativeGestureStarted = false;
        }
        return super.onTouchEvent(e);
    }
}
