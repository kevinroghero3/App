package com.swmansion.reanimated;

import androidx.annotation.NonNull;
import androidx.tracing.Trace;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ReanimatedUIManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.worklets.WorkletsModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ReanimatedPackage extends BaseReactPackage implements ReactPackage {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$getReactModuleInfoProvider$0(Map map) {
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(@NonNull String str, @NonNull ReactApplicationContext reactApplicationContext) {
        byte b;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != -1023230923) {
            if (iHashCode != 1093251842) {
                if (iHashCode == 1861242489 && str.equals(UIManagerModule.NAME)) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals(NativeReanimatedModuleSpec.NAME)) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals(NativeWorkletsModuleSpec.NAME)) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return new WorkletsModule(reactApplicationContext);
        }
        if (b == 1) {
            return new ReanimatedModule(reactApplicationContext);
        }
        if (b != 2) {
            return null;
        }
        return createUIManager(reactApplicationContext);
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {WorkletsModule.class, ReanimatedModule.class, ReanimatedUIManager.class};
        final HashMap map = new HashMap();
        for (int i = 0; i < 3; i++) {
            Class cls = clsArr[i];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            Objects.requireNonNull(reactModule);
            map.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), true, reactModule.needsEagerInit(), reactModule.isCxxModule(), false));
        }
        return new ReactModuleInfoProvider() { // from class: com.swmansion.reanimated.ReanimatedPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return ReanimatedPackage.lambda$getReactModuleInfoProvider$0(map);
            }
        };
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Trace.beginSection("createUIManagerModule");
        try {
            return ReanimatedUIManagerFactory.create(reactApplicationContext, getReactInstanceManager(reactApplicationContext).getOrCreateViewManagers(reactApplicationContext), -1);
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public ReactInstanceManager getReactInstanceManager(ReactApplicationContext reactApplicationContext) {
        return ((ReactApplication) reactApplicationContext.getApplicationContext()).getReactNativeHost().getReactInstanceManager();
    }
}
