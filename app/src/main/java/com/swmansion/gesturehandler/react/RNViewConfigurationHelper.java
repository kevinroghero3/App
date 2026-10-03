package com.swmansion.gesturehandler.react;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.PointerEventsConfig;
import com.swmansion.gesturehandler.core.ViewConfigurationHelper;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNViewConfigurationHelper implements ViewConfigurationHelper {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEvents.values().length];
            try {
                iArr[PointerEvents.BOX_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEvents.BOX_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEvents.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEvents.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.swmansion.gesturehandler.core.ViewConfigurationHelper
    public PointerEventsConfig getPointerEventsConfigForView(@NotNull View view) {
        PointerEvents pointerEvents;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ReactPointerEventsView) {
            pointerEvents = ((ReactPointerEventsView) view).getPointerEvents();
        } else {
            pointerEvents = PointerEvents.AUTO;
        }
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                return PointerEventsConfig.BOX_NONE;
            }
            if (pointerEvents == PointerEvents.BOX_ONLY) {
                return PointerEventsConfig.NONE;
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[pointerEvents.ordinal()];
        if (i == 1) {
            return PointerEventsConfig.BOX_ONLY;
        }
        if (i == 2) {
            return PointerEventsConfig.BOX_NONE;
        }
        if (i == 3) {
            return PointerEventsConfig.NONE;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return PointerEventsConfig.AUTO;
    }

    @Override // com.swmansion.gesturehandler.core.ViewConfigurationHelper
    public View getChildInDrawingOrderAtIndex(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent instanceof ReactViewGroup) {
            View childAt = parent.getChildAt(((ReactViewGroup) parent).getZIndexMappedChildIndex(i));
            Intrinsics.checkNotNull(childAt);
            return childAt;
        }
        View childAt2 = parent.getChildAt(i);
        Intrinsics.checkNotNull(childAt2);
        return childAt2;
    }

    @Override // com.swmansion.gesturehandler.core.ViewConfigurationHelper
    public boolean isViewClippingChildren(@NotNull ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!view.getClipChildren()) {
            if (!(view instanceof ReactScrollView)) {
                if (view instanceof ReactHorizontalScrollView) {
                    if (!Intrinsics.areEqual(((ReactHorizontalScrollView) view).getOverflow(), ViewProps.VISIBLE)) {
                    }
                } else if (view instanceof ReactViewGroup) {
                    return Intrinsics.areEqual(((ReactViewGroup) view).getOverflow(), ViewProps.HIDDEN);
                }
                return false;
            }
            if (Intrinsics.areEqual(((ReactScrollView) view).getOverflow(), ViewProps.VISIBLE)) {
                return false;
            }
        }
        return true;
    }
}
