package com.reactnativebarcodecreator;

import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.zxing.BarcodeFormat;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeCreatorViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "BarcodeCreatorView";
    ReactApplicationContext mCallerContext;

    public BarcodeCreatorViewManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public BarcodeView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new BarcodeView(themedReactContext);
    }

    @ReactProp(name = "format")
    public void setFormat(BarcodeView barcodeView, @Nullable String str) {
        barcodeView.setFormat(BarcodeFormat.valueOf(str));
    }

    @ReactProp(name = ViewProps.FOREGROUND_COLOR)
    public void setForeground(BarcodeView barcodeView, @Nullable String str) {
        barcodeView.setForegroundColor(str);
    }

    @ReactProp(name = AppStateModule.APP_STATE_BACKGROUND)
    public void setBackground(BarcodeView barcodeView, @Nullable String str) {
        barcodeView.setBackgroundColor(str);
    }

    @ReactProp(name = "value")
    public void setValue(BarcodeView barcodeView, @Nullable String str) {
        barcodeView.setContent(str);
    }

    @ReactProp(name = "encodedValue")
    public void setBase64(BarcodeView barcodeView, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64);
            try {
                barcodeView.setContent(new String(Base64.decode(string, 8), readableMap.getString("messageEncoded")));
            } catch (UnsupportedEncodingException e) {
                Utils.showException(this.mCallerContext, e);
                e.printStackTrace();
            }
        }
    }

    @ReactProp(defaultInt = 100, name = "width")
    public void setWidth(BarcodeView barcodeView, @Nullable int i) {
        barcodeView.setWidth(i);
    }

    @ReactProp(defaultInt = 100, name = "height")
    public void setHeight(BarcodeView barcodeView, @Nullable int i) {
        barcodeView.setHeight(i);
    }
}
