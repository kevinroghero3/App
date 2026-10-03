package com.captureprotection;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Activity getReactCurrentActivity(@NotNull ReactApplicationContext reactContext) {
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            return reactContext.getCurrentActivity();
        }

        public final boolean isSecureFlag(@NotNull ReactApplicationContext reactContext) {
            Window window;
            WindowManager.LayoutParams attributes;
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            Activity reactCurrentActivity = getReactCurrentActivity(reactContext);
            return !((reactCurrentActivity == null || (window = reactCurrentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null || (attributes.flags & 8192) != 0) ? false : true);
        }
    }
}
