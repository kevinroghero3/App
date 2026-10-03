package com.reactnativebarcodecreator;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.google.zxing.BarcodeFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeCreatorModule extends ReactContextBaseJavaModule {
    public BarcodeCreatorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return new HashMap<String, Object>() { // from class: com.reactnativebarcodecreator.BarcodeCreatorModule.1
            {
                put("AZTEC", BarcodeFormat.AZTEC.name());
                put("CODE128", BarcodeFormat.CODE_128.name());
                put("PDF417", BarcodeFormat.PDF_417.name());
                put("QR", BarcodeFormat.QR_CODE.name());
                put("EAN13", BarcodeFormat.EAN_13.name());
                put("UPCA", BarcodeFormat.UPC_A.name());
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BarcodeCreatorViewManager";
    }
}
