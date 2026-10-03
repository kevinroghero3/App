package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FocusInteropUtils_androidKt {
    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m837boximpl(FocusDirection.Companion.m851getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m837boximpl(FocusDirection.Companion.m850getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m837boximpl(FocusDirection.Companion.m849getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m837boximpl(FocusDirection.Companion.m853getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m837boximpl(FocusDirection.Companion.m852getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m837boximpl(FocusDirection.Companion.m846getDowndhqQ8s());
    }

    /* JADX INFO: renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m854toAndroidFocusDirection3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m840equalsimpl0(i, companion.m853getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m840equalsimpl0(i, companion.m846getDowndhqQ8s())) {
            return 130;
        }
        if (FocusDirection.m840equalsimpl0(i, companion.m849getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m840equalsimpl0(i, companion.m852getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m840equalsimpl0(i, companion.m850getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m840equalsimpl0(i, companion.m851getPreviousdhqQ8s()) ? 1 : null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }

    public static final Rect calculateBoundingRect(@NotNull View view) {
        int[] tempCoordinates = FocusInteropUtils.Companion.getTempCoordinates();
        view.getLocationInWindow(tempCoordinates);
        float f = tempCoordinates[0];
        return new Rect(f, tempCoordinates[1], view.getWidth() + f, tempCoordinates[1] + view.getHeight());
    }

    public static final boolean requestInteropFocus(@NotNull View view, @Nullable Integer num, @Nullable android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if ((!viewGroup.isFocusable() || view.hasFocus()) && !(view instanceof AndroidComposeView)) {
            if (rect != null) {
                View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
                return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
            return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
        }
        return view.requestFocus(num.intValue(), rect);
    }
}
