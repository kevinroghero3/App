package com.reactnativecommunity.picker;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.facebook.infer.annotation.Assertions;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.google.firebase.messaging.Constants;
import com.henninghall.date_picker.props.ModeProp;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactPickerManager extends BaseViewManager<ReactPicker, ReactPickerShadowNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLUR_PICKER = 2;
    private static final ReadableArray EMPTY_ARRAY = Arguments.createArray();
    private static final int FOCUS_PICKER = 1;
    private static final int SET_NATIVE_SELECTED = 3;

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ReactPicker reactPicker, Object obj) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put(PickerItemSelectEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(PickerFocusEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put(PickerBlurEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("focus", 1, "blur", 2, "setNativeSelected", 3);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, @androidx.annotation.Nullable float[] fArr) {
        int iApplyDimension;
        View view;
        ReactPicker reactPicker = new ReactPicker(context);
        ReactPickerAdapter reactPickerAdapter = new ReactPickerAdapter(context, readableMap2.getArray("items"));
        int i = readableMap2.getInt(ViewProps.NUMBER_OF_LINES);
        if (i > 0) {
            reactPickerAdapter.setNumberOfLines(i);
        }
        int i2 = readableMap2.getInt("selected");
        if (i2 < 0 || i2 >= reactPickerAdapter.getCount()) {
            iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            if ("dropdown".equals(readableMap2.getString(ModeProp.name))) {
                view = reactPickerAdapter.getDropDownView(i2, null, reactPicker);
            } else {
                view = reactPickerAdapter.getView(i2, null, reactPicker);
            }
            reactPicker.measureItem(view, View.MeasureSpec.makeMeasureSpec(reactPicker.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            iApplyDimension = view.getMeasuredHeight();
        }
        return YogaMeasureOutput.make(0.0f, PixelUtil.toDIPFromPixel(iApplyDimension));
    }

    @ReactProp(name = "items")
    public void setItems(ReactPicker reactPicker, @Nullable ReadableArray readableArray) {
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter == null) {
            ReactPickerAdapter reactPickerAdapter2 = new ReactPickerAdapter(reactPicker.getContext(), readableArray);
            reactPickerAdapter2.setPrimaryTextColor(reactPicker.getPrimaryColor());
            reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter2);
            return;
        }
        reactPickerAdapter.setItems(readableArray);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactPicker reactPicker, @Nullable Integer num) {
        reactPicker.setPrimaryColor(num);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter != null) {
            reactPickerAdapter.setPrimaryTextColor(num);
        }
    }

    @ReactProp(name = "prompt")
    public void setPrompt(ReactPicker reactPicker, @Nullable String str) {
        reactPicker.setPrompt(str);
    }

    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public void setEnabled(ReactPicker reactPicker, boolean z) {
        reactPicker.setEnabled(z);
    }

    @ReactProp(name = "selected")
    public void setSelected(ReactPicker reactPicker, int i) {
        reactPicker.setStagedSelection(i);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = ViewProps.BACKGROUND_COLOR)
    public void setBackgroundColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setBackgroundColor(i);
    }

    @ReactProp(name = "dropdownIconColor")
    public void setDropdownIconColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setDropdownIconColor(i);
    }

    @ReactProp(name = "dropdownIconRippleColor")
    public void setDropdownIconRippleColor(ReactPicker reactPicker, @Nullable int i) {
        reactPicker.setDropdownIconRippleColor(i);
    }

    @ReactProp(defaultInt = 1, name = ViewProps.NUMBER_OF_LINES)
    public void setNumberOfLines(ReactPicker reactPicker, int i) {
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter == null) {
            ReactPickerAdapter reactPickerAdapter2 = new ReactPickerAdapter(reactPicker.getContext(), EMPTY_ARRAY);
            reactPickerAdapter2.setPrimaryTextColor(reactPicker.getPrimaryColor());
            reactPickerAdapter2.setNumberOfLines(i);
            reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter2);
            return;
        }
        reactPickerAdapter.setNumberOfLines(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactPicker reactPicker) {
        super.onAfterUpdateTransaction(reactPicker);
        reactPicker.updateStagedSelection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactPicker reactPicker) {
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactPicker.getId());
        if (eventDispatcherForReactTag == null) {
            return;
        }
        PickerEventEmitter pickerEventEmitter = new PickerEventEmitter(reactPicker, eventDispatcherForReactTag);
        reactPicker.setOnSelectListener(pickerEventEmitter);
        reactPicker.setOnFocusListener(pickerEventEmitter);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull ReactPicker reactPicker, int i, @androidx.annotation.Nullable ReadableArray readableArray) {
        Map<String, Integer> commandsMap = getCommandsMap();
        if (commandsMap == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : commandsMap.entrySet()) {
            if (i == entry.getValue().intValue()) {
                receiveCommand(reactPicker, entry.getKey(), readableArray);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull ReactPicker reactPicker, String str, @androidx.annotation.Nullable ReadableArray readableArray) {
        byte b;
        Assertions.assertNotNull(reactPicker);
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != 3027047) {
            if (iHashCode != 97604824) {
                if (iHashCode == 361157844 && str.equals("setNativeSelected")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("focus")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("blur")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            blur(reactPicker);
            return;
        }
        if (b == 1) {
            focus(reactPicker);
        } else {
            if (b != 2) {
                return;
            }
            Assertions.assertNotNull(readableArray);
            setNativeSelected(reactPicker, readableArray.getInt(0));
        }
    }

    public void focus(ReactPicker reactPicker) {
        reactPicker.performClick();
    }

    public void blur(ReactPicker reactPicker) {
        reactPicker.clearFocus();
    }

    public void setNativeSelected(ReactPicker reactPicker, int i) {
        reactPicker.setStagedSelection(i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactPickerShadowNode createShadowNodeInstance() {
        return new ReactPickerShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends ReactPickerShadowNode> getShadowNodeClass() {
        return ReactPickerShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactPicker reactPicker, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactPicker.setStateWrapper(stateWrapper);
        return null;
    }

    static class ReactPickerAdapter extends BaseAdapter {
        private static int artificialFrame = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
        private final LayoutInflater mInflater;

        @Nullable
        private ReadableArray mItems;
        private int mNumberOfLines = 1;

        @Nullable
        private Integer mPrimaryTextColor;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public ReactPickerAdapter(Context context, @Nullable ReadableArray readableArray) {
            this.mItems = readableArray;
            this.mInflater = (LayoutInflater) Assertions.assertNotNull(context.getSystemService("layout_inflater"));
        }

        public void setItems(@Nullable ReadableArray readableArray) {
            this.mItems = readableArray;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return 0;
            }
            return readableArray.size();
        }

        @Override // android.widget.Adapter
        public ReadableMap getItem(int i) {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return null;
            }
            return readableArray.getMap(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, false);
        }

        @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, true);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x0232  */
        private View getView(int i, View view, ViewGroup viewGroup, boolean z) throws Throwable {
            ReadableMap map;
            View viewInflate;
            boolean z2;
            Integer num;
            int i2 = 2 % 2;
            ReadableMap item = getItem(i);
            Object obj = null;
            if (!(!item.hasKey(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE))) {
                int i3 = artificialFrame + b.f40o;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                if (i3 % 2 != 0) {
                    item.getMap(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                    throw null;
                }
                map = item.getMap(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            } else {
                map = null;
            }
            if (view == null) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                artificialFrame = i4 % 128;
                if (i4 % 2 == 0) {
                    obj.hashCode();
                    throw null;
                }
                viewInflate = this.mInflater.inflate(z ? R.layout.simple_spinner_dropdown_item : R.layout.simple_spinner_item, viewGroup, false);
            } else {
                viewInflate = view;
            }
            if (item.hasKey(ViewProps.ENABLED)) {
                int i5 = artificialFrame + 31;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                if (i5 % 2 != 0) {
                    z2 = item.getBoolean(ViewProps.ENABLED);
                    int i6 = 72 / 0;
                } else {
                    z2 = item.getBoolean(ViewProps.ENABLED);
                }
            } else {
                z2 = true;
            }
            viewInflate.setEnabled(z2);
            viewInflate.setClickable(!z2);
            TextView textView = (TextView) viewInflate;
            textView.setText(item.getString(Constants.ScionAnalytics.PARAM_LABEL));
            textView.setMaxLines(this.mNumberOfLines);
            if (map != null) {
                if (map.hasKey(ViewProps.BACKGROUND_COLOR) && (!map.isNull(ViewProps.BACKGROUND_COLOR))) {
                    int i7 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                    if (i7 % 2 != 0) {
                        viewInflate.setBackgroundColor(map.getInt(ViewProps.BACKGROUND_COLOR));
                        throw null;
                    }
                    viewInflate.setBackgroundColor(map.getInt(ViewProps.BACKGROUND_COLOR));
                } else {
                    viewInflate.setBackgroundColor(0);
                }
                if (map.hasKey("color")) {
                    int i8 = artificialFrame + 23;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                    int i9 = i8 % 2;
                    if (!map.isNull("color")) {
                        textView.setTextColor(map.getInt("color"));
                    }
                }
                if (map.hasKey(ViewProps.FONT_SIZE) && !map.isNull(ViewProps.FONT_SIZE) && map.getDouble(ViewProps.FONT_SIZE) > 0.1d) {
                    int i10 = artificialFrame + 39;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                    int i11 = i10 % 2;
                    textView.setTextSize((float) map.getDouble(ViewProps.FONT_SIZE));
                }
                if (map.hasKey(ViewProps.FONT_FAMILY) && !map.isNull(ViewProps.FONT_FAMILY)) {
                    int i12 = artificialFrame + 27;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                    if (i12 % 2 != 0) {
                        map.getString(ViewProps.FONT_FAMILY);
                        throw null;
                    }
                    try {
                        if (((Integer) String.class.getMethod("length", null).invoke(map.getString(ViewProps.FONT_FAMILY), null)).intValue() > 0) {
                            String str = "fonts/" + map.getString(ViewProps.FONT_FAMILY) + ".ttf";
                            try {
                                try {
                                    Object[] objArr = {viewInflate.getContext().getAssets(), str};
                                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                    if (objAccessartificialFrame == null) {
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 12, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 7116), 36 - MotionEvent.axisFromString(""), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                    }
                                    ((Method) objAccessartificialFrame).invoke(null, objArr);
                                    textView.setTypeface(Typeface.createFromAsset(viewInflate.getContext().getAssets(), str));
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        throw cause;
                                    }
                                    throw th;
                                }
                            } catch (IOException unused) {
                                textView.setTypeface(Typeface.create(map.getString(ViewProps.FONT_FAMILY), 0));
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th2;
                    }
                }
            }
            if (!z && (num = this.mPrimaryTextColor) != null) {
                textView.setTextColor(num.intValue());
            } else if (item.hasKey("color") && !item.isNull("color")) {
                int i13 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                int i14 = i13 % 2;
                textView.setTextColor(item.getInt("color"));
                int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i15 % 128;
                int i16 = i15 % 2;
            }
            if (item.hasKey("contentDescription") && !item.isNull("contentDescription")) {
                textView.setContentDescription(item.getString("contentDescription"));
            }
            if (item.hasKey(ViewProps.FONT_FAMILY)) {
                int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                artificialFrame = i17 % 128;
                if (i17 % 2 == 0) {
                    int i18 = 98 / 0;
                    if (!item.isNull(ViewProps.FONT_FAMILY)) {
                        textView.setTypeface(Typeface.create(item.getString(ViewProps.FONT_FAMILY), 0));
                    }
                } else if (!item.isNull(ViewProps.FONT_FAMILY)) {
                    textView.setTypeface(Typeface.create(item.getString(ViewProps.FONT_FAMILY), 0));
                }
            }
            if (!I18nUtil.getInstance().isRTL(viewInflate.getContext())) {
                viewInflate.setLayoutDirection(0);
                viewInflate.setTextDirection(3);
            } else {
                viewInflate.setLayoutDirection(1);
                viewInflate.setTextDirection(4);
            }
            return viewInflate;
        }

        public void setPrimaryTextColor(@Nullable Integer num) {
            this.mPrimaryTextColor = num;
            notifyDataSetChanged();
        }

        public void setNumberOfLines(int i) {
            this.mNumberOfLines = i;
            notifyDataSetChanged();
        }
    }

    static class PickerEventEmitter implements ReactPicker.OnSelectListener, ReactPicker.OnFocusListener {
        private final EventDispatcher mEventDispatcher;
        private final ReactPicker mReactPicker;

        public PickerEventEmitter(ReactPicker reactPicker, EventDispatcher eventDispatcher) {
            this.mReactPicker = reactPicker;
            this.mEventDispatcher = eventDispatcher;
        }

        @Override // com.reactnativecommunity.picker.ReactPicker.OnSelectListener
        public void onItemSelected(int i) {
            this.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(this.mReactPicker.getId(), i));
        }

        @Override // com.reactnativecommunity.picker.ReactPicker.OnFocusListener
        public void onPickerBlur() {
            this.mEventDispatcher.dispatchEvent(new PickerBlurEvent(this.mReactPicker.getId()));
        }

        @Override // com.reactnativecommunity.picker.ReactPicker.OnFocusListener
        public void onPickerFocus() {
            this.mEventDispatcher.dispatchEvent(new PickerFocusEvent(this.mReactPicker.getId()));
        }
    }
}
