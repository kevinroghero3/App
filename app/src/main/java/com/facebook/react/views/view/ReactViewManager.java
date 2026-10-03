package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@ReactModule(name = "RCTView")
public class ReactViewManager extends ReactClippingViewManager<ReactViewGroup> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;
    private static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";
    public static final String REACT_CLASS = "RCTView";
    public static final Companion Companion = new Companion(null);
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5, 9, 10, 11};

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ReactProp(name = ViewProps.COLLAPSABLE)
    public void setCollapsable(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @ReactProp(name = ViewProps.COLLAPSABLE_CHILDREN)
    public void setCollapsableChildren(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public ReactViewManager() {
        setupViewRecycling();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup prepareToRecycleView(@NotNull ThemedReactContext reactContext, @NotNull ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        ReactViewGroup reactViewGroup = (ReactViewGroup) super.prepareToRecycleView(reactContext, view);
        if (reactViewGroup != null) {
            reactViewGroup.recycleView();
        }
        return view;
    }

    @ReactProp(name = "accessible")
    public void setAccessible(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(z);
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    @ReactProp(customType = "BackgroundImage", name = ViewProps.BACKGROUND_IMAGE)
    public void setBackgroundImage(@NotNull ReactViewGroup view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.getUIManagerType(view) == 2) {
            if (readableArray != null && readableArray.size() > 0) {
                ArrayList arrayList = new ArrayList(readableArray.size());
                int size = readableArray.size();
                for (int i = 0; i < size; i++) {
                    ReadableMap map = readableArray.getMap(i);
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    arrayList.add(new BackgroundImageLayer(map, context));
                }
                BackgroundStyleApplicator.setBackgroundImage(view, arrayList);
                return;
            }
            BackgroundStyleApplicator.setBackgroundImage(view, null);
        }
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(@NotNull ReactViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusDownId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(@NotNull ReactViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusForwardId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(@NotNull ReactViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusLeftId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(@NotNull ReactViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusRightId(i);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(@NotNull ReactViewGroup view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusUpId(i);
    }

    @ReactPropGroup(names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", ViewProps.BORDER_TOP_START_RADIUS, ViewProps.BORDER_TOP_END_RADIUS, ViewProps.BORDER_BOTTOM_START_RADIUS, ViewProps.BORDER_BOTTOM_END_RADIUS, ViewProps.BORDER_END_END_RADIUS, ViewProps.BORDER_END_START_RADIUS, ViewProps.BORDER_START_END_RADIUS, ViewProps.BORDER_START_START_RADIUS})
    public void setBorderRadius(@NotNull ReactViewGroup view, int i, @NotNull Dynamic rawBorderRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(rawBorderRadius, "rawBorderRadius");
        LengthPercentage fromDynamic = LengthPercentage.Companion.setFromDynamic(rawBorderRadius);
        if (ViewUtil.getUIManagerType(view) != 2 && fromDynamic != null && fromDynamic.getType() == LengthPercentageType.PERCENT) {
            fromDynamic = null;
        }
        BackgroundStyleApplicator.setBorderRadius(view, BorderRadiusProp.values()[i], fromDynamic);
    }

    @Deprecated(message = "Don't use setBorderRadius(view, int, Float) as it was deprecated in React Native 0.75.0.", replaceWith = @ReplaceWith(expression = "setBorderRadius(view, index, DynamicFromObject(borderRadius)", imports = {}))
    public void setBorderRadius(@NotNull ReactViewGroup view, int i, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        setBorderRadius(view, i, new DynamicFromObject(Float.valueOf(f)));
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(@NotNull ReactViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderStyle(view, str == null ? null : BorderStyle.Companion.fromString(str));
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(@NotNull ReactViewGroup view, @NotNull Dynamic hitSlop) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(hitSlop, "hitSlop");
        int i = WhenMappings.$EnumSwitchMapping$0[hitSlop.getType().ordinal()];
        if (i == 1) {
            ReadableMap readableMapAsMap = hitSlop.asMap();
            view.setHitSlopRect(new Rect(px(readableMapAsMap, "left"), px(readableMapAsMap, "top"), px(readableMapAsMap, ViewProps.RIGHT), px(readableMapAsMap, ViewProps.BOTTOM)));
            return;
        }
        if (i == 2) {
            int iDpToPx = (int) PixelUtil.INSTANCE.dpToPx(hitSlop.asDouble());
            view.setHitSlopRect(new Rect(iDpToPx, iDpToPx, iDpToPx, iDpToPx));
        } else {
            if (i == 3) {
                view.setHitSlopRect(null);
                return;
            }
            FLog.w(ReactConstants.TAG, "Invalid type for 'hitSlop' value " + hitSlop.getType());
            view.setHitSlopRect(null);
        }
    }

    private final int px(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return (int) PixelUtil.INSTANCE.dpToPx(readableMap.getDouble(str));
        }
        return 0;
    }

    @ReactProp(name = ViewProps.POINTER_EVENTS)
    public void setPointerEvents(@NotNull ReactViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPointerEvents(PointerEvents.Companion.parsePointerEvents(str));
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(@NotNull ReactViewGroup view, @Nullable ReadableMap readableMap) {
        Drawable drawableCreateDrawableFromJSDescription;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, readableMap);
        } else {
            drawableCreateDrawableFromJSDescription = null;
        }
        BackgroundStyleApplicator.setFeedbackUnderlay(view, drawableCreateDrawableFromJSDescription);
    }

    @ReactProp(name = "nativeForegroundAndroid")
    public void setNativeForeground(@NotNull ReactViewGroup view, @Nullable ReadableMap readableMap) {
        Drawable drawableCreateDrawableFromJSDescription;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, readableMap);
        } else {
            drawableCreateDrawableFromJSDescription = null;
        }
        view.setForeground(drawableCreateDrawableFromJSDescription);
    }

    @ReactProp(name = ViewProps.NEEDS_OFFSCREEN_ALPHA_COMPOSITING)
    public void setNeedsOffscreenAlphaCompositing(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNeedsOffscreenAlphaCompositing(z);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH})
    public void setBorderWidth(@NotNull ReactViewGroup view, int i, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.values()[i], Float.valueOf(f));
    }

    @ReactPropGroup(customType = "Color", names = {ViewProps.BORDER_COLOR, ViewProps.BORDER_LEFT_COLOR, ViewProps.BORDER_RIGHT_COLOR, ViewProps.BORDER_TOP_COLOR, ViewProps.BORDER_BOTTOM_COLOR, ViewProps.BORDER_START_COLOR, ViewProps.BORDER_END_COLOR, ViewProps.BORDER_BLOCK_COLOR, ViewProps.BORDER_BLOCK_END_COLOR, ViewProps.BORDER_BLOCK_START_COLOR})
    public void setBorderColor(@NotNull ReactViewGroup view, int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.Companion.fromSpacingType(SPACING_TYPES[i]), num);
    }

    @ReactProp(name = "focusable")
    public void setFocusable(@NotNull final ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.views.view.ReactViewManager$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReactViewManager.setFocusable$lambda$2(view, view2);
                }
            });
            view.setFocusable(true);
        } else {
            view.setOnClickListener(null);
            view.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusable$lambda$2(ReactViewGroup reactViewGroup, View view) {
        Context context = reactViewGroup.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, reactViewGroup.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId(reactViewGroup.getContext()), reactViewGroup.getId()));
        }
    }

    @ReactProp(name = ViewProps.OVERFLOW)
    public void setOverflow(@NotNull ReactViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(str);
    }

    @ReactProp(name = "backfaceVisibility")
    public void setBackfaceVisibility(@NotNull ReactViewGroup view, @NotNull String backfaceVisibility) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(backfaceVisibility, "backfaceVisibility");
        view.setBackfaceVisibility(backfaceVisibility);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setOpacity(@NotNull ReactViewGroup view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOpacityIfPossible(f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setTransformProperty(@NotNull ReactViewGroup view, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTransformProperty(view, readableArray, readableArray2);
        view.setBackfaceVisibilityDependantOpacity();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTView";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactViewGroup(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(HOTSPOT_UPDATE_KEY, 1), TuplesKt.to("setPressed", 2));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Deprecated(message = "Use receiveCommand(View, String, ReadableArray)", replaceWith = @ReplaceWith(expression = "receiveCommand(root, commandIdString, args)", imports = {}))
    public void receiveCommand(@NotNull ReactViewGroup root, int i, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (i == 1) {
            handleHotspotUpdate(root, readableArray);
        } else {
            if (i != 2) {
                return;
            }
            handleSetPressed(root, readableArray);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactViewGroup root, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (Intrinsics.areEqual(commandId, HOTSPOT_UPDATE_KEY)) {
            handleHotspotUpdate(root, readableArray);
        } else if (Intrinsics.areEqual(commandId, "setPressed")) {
            handleSetPressed(root, readableArray);
        }
    }

    private final void handleSetPressed(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    private final void handleHotspotUpdate(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        }
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        reactViewGroup.drawableHotspotChanged(pixelUtil.dpToPx(readableArray.getDouble(0)), pixelUtil.dpToPx(readableArray.getDouble(1)));
    }
}
