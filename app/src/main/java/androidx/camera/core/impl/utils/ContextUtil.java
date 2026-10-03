package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextUtil {
    public static Context getApplicationContext(@NonNull Context context) {
        int deviceId;
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (deviceId = Api34Impl.getDeviceId(context)) != Api34Impl.getDeviceId(applicationContext)) {
            applicationContext = Api34Impl.createDeviceContext(applicationContext, deviceId);
        }
        if (i < 30) {
            return applicationContext;
        }
        String attributionTag = Api30Impl.getAttributionTag(context);
        return !Objects.equals(attributionTag, Api30Impl.getAttributionTag(applicationContext)) ? Api30Impl.createAttributionContext(applicationContext, attributionTag) : applicationContext;
    }

    public static Application getApplicationFromContext(@NonNull Context context) {
        for (Context applicationContext = getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    private ContextUtil() {
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static Context createDeviceContext(@NonNull Context context, int i) {
            return context.createDeviceContext(i);
        }

        static int getDeviceId(@NonNull Context context) {
            return context.getDeviceId();
        }
    }
}
