package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.R;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final String TAG;

    public ReactScrollViewAccessibilityDelegate() {
        String simpleName = ReactScrollViewAccessibilityDelegate.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.TAG = simpleName;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(@NotNull View host, @NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(host, event);
        if ((host instanceof ReactScrollView) || (host instanceof ReactHorizontalScrollView)) {
            onInitializeAccessibilityEventInternal(host, event);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(this.TAG, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: " + host.getClass().getSimpleName()));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        if ((host instanceof ReactScrollView) || (host instanceof ReactHorizontalScrollView)) {
            onInitializeAccessibilityNodeInfoInternal(host, info);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(this.TAG, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: " + host.getClass().getSimpleName()));
    }

    private final void onInitializeAccessibilityEventInternal(View view, AccessibilityEvent accessibilityEvent) {
        boolean zIsPartiallyScrolledInView;
        Object tag = view.getTag(R.id.accessibility_collection);
        Integer numValueOf = null;
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap == null) {
            return;
        }
        accessibilityEvent.setItemCount(readableMap.getInt("itemCount"));
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup2 == null) {
            return;
        }
        int childCount = viewGroup2.getChildCount();
        Integer numValueOf2 = null;
        for (int i = 0; i < childCount; i++) {
            View childAt2 = viewGroup2.getChildAt(i);
            if (view instanceof ReactScrollView) {
                zIsPartiallyScrolledInView = ((ReactScrollView) view).isPartiallyScrolledInView(childAt2);
            } else if (!(view instanceof ReactHorizontalScrollView)) {
                return;
            } else {
                zIsPartiallyScrolledInView = ((ReactHorizontalScrollView) view).isPartiallyScrolledInView(childAt2);
            }
            Object tag2 = childAt2.getTag(R.id.accessibility_collection_item);
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
            ReadableMap readableMap2 = (ReadableMap) tag2;
            if (!(childAt2 instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) childAt2).getChildCount();
            if (zIsPartiallyScrolledInView) {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(readableMap2.getInt("itemIndex"));
                }
                numValueOf2 = Integer.valueOf(readableMap2.getInt("itemIndex"));
            }
            if (numValueOf != null && numValueOf2 != null) {
                accessibilityEvent.setFromIndex(numValueOf.intValue());
                accessibilityEvent.setToIndex(numValueOf2.intValue());
            }
        }
    }

    private final void onInitializeAccessibilityNodeInfoInternal(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ReactAccessibilityDelegate.AccessibilityRole accessibilityRoleFromViewTag = ReactAccessibilityDelegate.AccessibilityRole.fromViewTag(view);
        if (accessibilityRoleFromViewTag != null) {
            ReactAccessibilityDelegate.setRole(accessibilityNodeInfoCompat, accessibilityRoleFromViewTag, view.getContext());
        }
        Object tag = view.getTag(R.id.accessibility_collection);
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(readableMap.getInt("rowCount"), readableMap.getInt("columnCount"), readableMap.getBoolean("hierarchical")));
        }
        if (view instanceof ReactScrollView) {
            accessibilityNodeInfoCompat.setScrollable(((ReactScrollView) view).getScrollEnabled());
        } else if (view instanceof ReactHorizontalScrollView) {
            accessibilityNodeInfoCompat.setScrollable(((ReactHorizontalScrollView) view).getScrollEnabled());
        }
    }
}
