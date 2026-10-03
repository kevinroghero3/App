package com.lugg.RNCConfig;

import android.content.res.Resources;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ReactConstants;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RNCConfigModule extends ReactContextBaseJavaModule {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    public RNCConfigModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCConfigModule";
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        String packageName;
        int i = 2 % 2;
        HashMap map = new HashMap();
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            try {
                packageName = reactApplicationContext.getString(reactApplicationContext.getResources().getIdentifier("build_config_package", TypedValues.Custom.S_STRING, reactApplicationContext.getPackageName()));
                if (packageName.startsWith(".,.%")) {
                    int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                    artificialFrame = i2 % 128;
                    int i3 = i2 % 2;
                    Object[] objArr = new Object[1];
                    a(packageName.substring(4), objArr);
                    packageName = ((String) objArr[0]).intern();
                }
            } catch (Resources.NotFoundException unused) {
                packageName = getReactApplicationContext().getApplicationContext().getPackageName();
            }
            for (Field field : Class.forName(packageName + ".BuildConfig").getDeclaredFields()) {
                try {
                    map.put(field.getName(), field.get(null));
                } catch (IllegalAccessException unused2) {
                    Log.d(ReactConstants.TAG, "ReactConfig: Could not access BuildConfig field " + field.getName());
                }
            }
        } catch (ClassNotFoundException unused3) {
            Log.d(ReactConstants.TAG, "ReactConfig: Could not find BuildConfig class");
        }
        int i4 = artificialFrame + 15;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        if (i4 % 2 == 0) {
            return map;
        }
        throw null;
    }
}
