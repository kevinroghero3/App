package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class WindowUtils {
    private static final String TAG = "WindowUtils";

    private WindowUtils() {
    }

    public static Rect getCurrentWindowBounds(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getCurrentWindowBounds(windowManager);
        }
        return Api17Impl.getCurrentWindowBounds(windowManager);
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }

    static class Api14Impl {
        private Api14Impl() {
        }

        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            int i;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point realSizeForDisplay = getRealSizeForDisplay(defaultDisplay);
            Rect rect = new Rect();
            int i2 = realSizeForDisplay.x;
            if (i2 == 0 || (i = realSizeForDisplay.y) == 0) {
                defaultDisplay.getRectSize(rect);
            } else {
                rect.right = i2;
                rect.bottom = i;
            }
            return rect;
        }

        private static Point getRealSizeForDisplay(Display display) {
            Point point = new Point();
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", Point.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(display, point);
            } catch (IllegalAccessException e) {
                SentryLogcatAdapter.w(WindowUtils.TAG, e);
            } catch (NoSuchMethodException e2) {
                SentryLogcatAdapter.w(WindowUtils.TAG, e2);
            } catch (InvocationTargetException e3) {
                SentryLogcatAdapter.w(WindowUtils.TAG, e3);
            }
            return point;
        }
    }
}
