package com.facebook.react.views.swiperefresh;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = SwipeRefreshLayoutManager.REACT_CLASS)
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> implements AndroidSwipeRefreshLayoutManagerInterface<ReactSwipeRefreshLayout> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";
    private final ViewManagerDelegate<ReactSwipeRefreshLayout> delegate = new AndroidSwipeRefreshLayoutManagerDelegate(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSwipeRefreshLayout createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactSwipeRefreshLayout(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public void setEnabled(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(customType = "ColorArray", name = LinearGradientManager.PROP_COLORS)
    public void setColors(@NotNull ReactSwipeRefreshLayout view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray != null) {
            int size = readableArray.size();
            int[] iArr = new int[size];
            int size2 = readableArray.size();
            for (int i = 0; i < size2; i++) {
                if (readableArray.getType(i) == ReadableType.Map) {
                    Integer color = ColorPropConverter.getColor(readableArray.getMap(i), view.getContext());
                    Intrinsics.checkNotNullExpressionValue(color, "getColor(...)");
                    iArr[i] = color.intValue();
                } else {
                    iArr[i] = readableArray.getInt(i);
                }
            }
            view.setColorSchemeColors(Arrays.copyOf(iArr, size));
            return;
        }
        view.setColorSchemeColors(new int[0]);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(@NotNull ReactSwipeRefreshLayout view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgressBackgroundColorSchemeColor(num != null ? num.intValue() : 0);
    }

    public final void setSize(@NotNull ReactSwipeRefreshLayout view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSize(i);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    public void setSize(@NotNull ReactSwipeRefreshLayout view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null || str.equals("default")) {
            view.setSize(1);
        } else {
            if (str.equals("large")) {
                view.setSize(0);
                return;
            }
            throw new IllegalArgumentException("Size must be 'default' or 'large', received: " + str);
        }
    }

    @ReactProp(name = RRWebVideoEvent.JsonKeys.SIZE)
    public final void setSize(@NotNull ReactSwipeRefreshLayout view, @NotNull Dynamic size) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(size, "size");
        if (size.isNull()) {
            view.setSize(1);
        } else if (size.getType() == ReadableType.Number) {
            view.setSize(size.asInt());
        } else {
            if (size.getType() != ReadableType.String) {
                throw new IllegalArgumentException("Size must be 'default' or 'large'");
            }
            setSize(view, size.asString());
        }
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(name = "refreshing")
    public void setRefreshing(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRefreshing(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(@NotNull ReactSwipeRefreshLayout view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgressViewOffset(f);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    public void setNativeRefreshing(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        setRefreshing(view, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull final ThemedReactContext reactContext, @NotNull final ReactSwipeRefreshLayout view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SwipeRefreshLayoutManager.addEventEmitters$lambda$0(reactContext, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$0(ThemedReactContext themedReactContext, ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactSwipeRefreshLayout.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new RefreshEvent(UIManagerHelper.getSurfaceId(reactSwipeRefreshLayout), reactSwipeRefreshLayout.getId()));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactSwipeRefreshLayout root, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (!Intrinsics.areEqual(commandId, "setNativeRefreshing") || readableArray == null) {
            return;
        }
        setRefreshing(root, readableArray.getBoolean(0));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("SIZE", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("DEFAULT", 1), TuplesKt.to("LARGE", 0))));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("topRefresh", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("registrationName", "onRefresh")))));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactSwipeRefreshLayout> getDelegate() {
        return this.delegate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
