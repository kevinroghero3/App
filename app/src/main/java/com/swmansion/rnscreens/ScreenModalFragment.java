package com.swmansion.rnscreens;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.swmansion.rnscreens.bottomsheet.BottomSheetDialogRootView;
import com.swmansion.rnscreens.bottomsheet.BottomSheetDialogScreen;
import com.swmansion.rnscreens.bottomsheet.SheetUtils;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreenModalFragment extends BottomSheetDialogFragment implements ScreenStackFragmentWrapper {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ScreenModalFragment";
    private final ArrayList<ScreenContainer> childScreenContainers;
    public Screen screen;
    private BottomSheetDialog sheetDialog;

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public boolean canNavigateBack() {
        return true;
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public Fragment getFragment() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationEnd() {
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationStart() {
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Screen getScreen() {
        Screen screen = this.screen;
        if (screen != null) {
            return screen;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screen");
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void setScreen(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<set-?>");
        this.screen = screen;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public ArrayList<ScreenContainer> getChildScreenContainers() {
        return this.childScreenContainers;
    }

    private final ScreenStack getContainer() {
        ScreenContainer container = getScreen().getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    private final BottomSheetBehavior<FrameLayout> getBehavior() {
        BottomSheetDialog bottomSheetDialog = this.sheetDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetDialog");
            bottomSheetDialog = null;
        }
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "getBehavior(...)");
        return behavior;
    }

    public ScreenModalFragment() {
        this.childScreenContainers = new ArrayList<>();
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public ScreenModalFragment(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.childScreenContainers = new ArrayList<>();
        setScreen(screen);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setShowsDialog(true);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        configureDialogAndBehaviour();
        EventDispatcher reactEventDispatcher = getScreen().getReactEventDispatcher();
        if (reactEventDispatcher == null) {
            throw new IllegalStateException("[RNScreens] No ReactEventDispatcher attached to screen while creating modal fragment");
        }
        BottomSheetDialogRootView bottomSheetDialogRootView = new BottomSheetDialogRootView(getScreen().getReactContext(), reactEventDispatcher);
        bottomSheetDialogRootView.addView(ViewExtKt.recycle(getScreen()));
        BottomSheetDialog bottomSheetDialog = this.sheetDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetDialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.setContentView(bottomSheetDialogRootView);
        View viewParentAsView = ViewExtKt.parentAsView(bottomSheetDialogRootView);
        if (viewParentAsView != null) {
            viewParentAsView.setClipToOutline(true);
        }
        BottomSheetDialog bottomSheetDialog2 = this.sheetDialog;
        if (bottomSheetDialog2 != null) {
            return bottomSheetDialog2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sheetDialog");
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void dismissFromContainer() {
        if (getContainer() == null) {
            throw new IllegalStateException("Check failed.");
        }
        ScreenStack container = getContainer();
        Intrinsics.checkNotNull(container, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStack");
        container.dismiss(this);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void addChildScreenContainer(@NotNull ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().add(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void removeChildScreenContainer(@NotNull ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().remove(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Activity tryGetActivity() {
        return requireActivity();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        }
        if (getScreen().getContext() instanceof ReactContext) {
            Context context2 = getScreen().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        }
        for (ViewParent container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen = (Screen) container;
                if (screen.getContext() instanceof ReactContext) {
                    Context context3 = screen.getContext();
                    Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    return (ReactContext) context3;
                }
            }
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public boolean canDispatchLifecycleEvent(@NotNull ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void updateLastEventDispatched(@NotNull ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEvent(@NotNull ScreenFragment.ScreenLifecycleEvent event, @NotNull ScreenFragmentWrapper fragmentWrapper) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEventInChildContainers(@NotNull ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchHeaderBackButtonClickedEvent() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchTransitionProgressEvent(float f, boolean z) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ScreenStack container = getContainer();
        if (container == null || !container.hasScreen(this)) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                int surfaceId = UIManagerHelper.getSurfaceId(context);
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
                }
            }
        }
        getChildScreenContainers().clear();
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void removeToolbar() {
        throw new IllegalStateException("[RNScreens] Modal screens on Android do not support header right now");
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbar(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        throw new IllegalStateException("[RNScreens] Modal screens on Android do not support header right now");
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarShadowHidden(boolean z) {
        throw new IllegalStateException("[RNScreens] Modal screens on Android do not support header right now");
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarTranslucent(boolean z) {
        throw new IllegalStateException("[RNScreens] Modal screens on Android do not support header right now");
    }

    private final BottomSheetDialog configureDialogAndBehaviour() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        BottomSheetDialogScreen bottomSheetDialogScreen = new BottomSheetDialogScreen(contextRequireContext, this);
        this.sheetDialog = bottomSheetDialogScreen;
        bottomSheetDialogScreen.setDismissWithAnimation(true);
        BottomSheetDialog bottomSheetDialog = this.sheetDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetDialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.setCanceledOnTouchOutside(getScreen().getSheetClosesOnTouchOutside());
        configureBehaviour();
        BottomSheetDialog bottomSheetDialog2 = this.sheetDialog;
        if (bottomSheetDialog2 != null) {
            return bottomSheetDialog2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sheetDialog");
        return null;
    }

    private final Integer tryResolveContainerHeight() {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        Resources resources;
        DisplayMetrics displayMetrics;
        ScreenContainer container = getScreen().getContainer();
        if (container != null) {
            return Integer.valueOf(container.getHeight());
        }
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return Integer.valueOf(displayMetrics.heightPixels);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Context context2 = getContext();
            Object systemService = context2 != null ? context2.getSystemService("window") : null;
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                return Integer.valueOf(bounds.height());
            }
        }
        return null;
    }

    private final void configureBehaviour() {
        Integer numTryResolveContainerHeight = tryResolveContainerHeight();
        if (numTryResolveContainerHeight == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration");
        }
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        behavior.setHideable(true);
        behavior.setDraggable(true);
        int size = getScreen().getSheetDetents().size();
        if (size == 1) {
            BottomSheetBehavior<FrameLayout> behavior2 = getBehavior();
            behavior2.setState(3);
            behavior2.setSkipCollapsed(true);
            behavior2.setFitToContents(true);
            behavior2.setMaxHeight((int) (((Number) CollectionsKt___CollectionsKt.first((List) getScreen().getSheetDetents())).doubleValue() * ((double) numTryResolveContainerHeight.intValue())));
            return;
        }
        if (size == 2) {
            BottomSheetBehavior<FrameLayout> behavior3 = getBehavior();
            behavior3.setState(SheetUtils.INSTANCE.sheetStateFromDetentIndex(getScreen().getSheetInitialDetentIndex(), getScreen().getSheetDetents().size()));
            behavior3.setSkipCollapsed(false);
            behavior3.setFitToContents(true);
            behavior3.setPeekHeight((int) (getScreen().getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue())));
            behavior3.setMaxHeight((int) (getScreen().getSheetDetents().get(1).doubleValue() * ((double) numTryResolveContainerHeight.intValue())));
            return;
        }
        if (size == 3) {
            BottomSheetBehavior<FrameLayout> behavior4 = getBehavior();
            behavior4.setState(SheetUtils.INSTANCE.sheetStateFromDetentIndex(getScreen().getSheetInitialDetentIndex(), getScreen().getSheetDetents().size()));
            behavior4.setSkipCollapsed(false);
            behavior4.setFitToContents(false);
            behavior4.setPeekHeight((int) (getScreen().getSheetDetents().get(0).doubleValue() * ((double) numTryResolveContainerHeight.intValue())));
            behavior4.setExpandedOffset((int) ((((double) 1) - getScreen().getSheetDetents().get(2).doubleValue()) * ((double) numTryResolveContainerHeight.intValue())));
            behavior4.setHalfExpandedRatio((float) (getScreen().getSheetDetents().get(1).doubleValue() / getScreen().getSheetDetents().get(2).doubleValue()));
            return;
        }
        throw new IllegalStateException("[RNScreens] Invalid detent count " + getScreen().getSheetDetents().size() + ". Expected at most 3.");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
