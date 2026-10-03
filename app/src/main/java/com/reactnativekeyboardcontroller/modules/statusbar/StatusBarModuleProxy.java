package com.reactnativekeyboardcontroller.modules.statusbar;

import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class StatusBarModuleProxy {
    private Method getConstantsMethod;
    private Object instance;
    private Method setColorMethod;
    private Method setHiddenMethod;
    private Method setStyleMethod;
    private Method setTranslucentMethod;

    public StatusBarModuleProxy(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        try {
            Class<?> cls = Class.forName("com.facebook.react.modules.statusbar.StatusBarModule");
            this.instance = cls.getConstructor(ReactApplicationContext.class).newInstance(reactContext);
            Class cls2 = Boolean.TYPE;
            this.setHiddenMethod = cls.getMethod("setHidden", cls2);
            this.setColorMethod = cls.getMethod("setColor", Double.TYPE, cls2);
            this.setTranslucentMethod = cls.getMethod("setTranslucent", cls2);
            this.setStyleMethod = cls.getMethod("setStyle", String.class);
            this.getConstantsMethod = cls.getMethod("getConstants", null);
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Failed to initialize StatusBarModule via reflection", e);
        }
    }

    public final void setHidden(boolean z) {
        try {
            Method method = this.setHiddenMethod;
            if (method != null) {
                method.invoke(this.instance, Boolean.valueOf(z));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setHidden method", e);
        }
    }

    public final void setColor(double d, boolean z) {
        try {
            Method method = this.setColorMethod;
            if (method != null) {
                method.invoke(this.instance, Double.valueOf(d), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setColor method", e);
        }
    }

    public final void setTranslucent(boolean z) {
        try {
            Method method = this.setTranslucentMethod;
            if (method != null) {
                method.invoke(this.instance, Boolean.valueOf(z));
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setTranslucent method", e);
        }
    }

    public final void setStyle(@NotNull String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        try {
            Method method = this.setStyleMethod;
            if (method != null) {
                method.invoke(this.instance, style);
            }
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.setStyle method", e);
        }
    }

    public final Map<String, Object> getConstants() {
        try {
            Method method = this.getConstantsMethod;
            Object objInvoke = method != null ? method.invoke(this.instance, null) : null;
            if (TypeIntrinsics.isMutableMap(objInvoke)) {
                return (Map) objInvoke;
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.w(StatusBarModuleProxyKt.TAG, "Error invoking StatusBarModule.getConstants method", e);
            return null;
        }
    }
}
