package com.mycicero.reactnativekeykeeper;

import android.content.Context;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ReactNativeKeyKeeperModule.NAME)
public class ReactNativeKeyKeeperModule extends ReactContextBaseJavaModule {
    public static final String NAME = "ReactNativeKeyKeeper";
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Context context;

    public ReactNativeKeyKeeperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext.getApplicationContext();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    @ReactMethod
    public void getSecret(String str, Promise promise) {
        int i = 2 % 2;
        int i2 = artificialFrame + 121;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                String string = this.context.getString(this.context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, this.context.getPackageName()));
                if (string.startsWith(".,.%")) {
                    Object[] objArr = new Object[1];
                    a(string.substring(4), objArr);
                    string = ((String) objArr[0]).intern();
                }
                promise.resolve(string);
                int i3 = artificialFrame + 51;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                int i4 = i3 % 2;
                int i5 = artificialFrame + 107;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                return;
            }
            this.context.getString(this.context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, this.context.getPackageName())).startsWith(".,.%");
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            promise.reject("value_not_found", "Cound not find value for key " + str, th);
        }
    }
}
