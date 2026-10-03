package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.gestures.UiElement;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewUtils {
    private static final int[] coordinates = new int[2];

    private static boolean isViewIdGenerated(int i) {
        return ((-16777216) & i) == 0 && (i & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    private static boolean touchWithinBounds(@Nullable View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        int[] iArr = coordinates;
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return f >= ((float) i) && f <= ((float) (i + view.getWidth())) && f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getHeight()));
    }

    static UiElement findTarget(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull View view, float f, float f2, UiElement.Type type) {
        List<GestureTargetLocator> gestureTargetLocators = sentryAndroidOptions.getGestureTargetLocators();
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        UiElement uiElement = null;
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (touchWithinBounds(view2, f, f2)) {
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
                for (int i2 = 0; i2 < gestureTargetLocators.size(); i2++) {
                    UiElement uiElementLocate = gestureTargetLocators.get(i2).locate(view2, f, f2, type);
                    if (uiElementLocate != null) {
                        if (type == UiElement.Type.CLICKABLE) {
                            uiElement = uiElementLocate;
                        } else if (type == UiElement.Type.SCROLLABLE) {
                            return uiElementLocate;
                        }
                    }
                }
            }
        }
        return uiElement;
    }

    static String getResourceIdWithFallback(@NotNull View view) {
        try {
            return getResourceId(view);
        } catch (Resources.NotFoundException unused) {
            return "0x" + Integer.toString(view.getId(), 16);
        }
    }

    public static String getResourceId(@NotNull View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id == -1 || isViewIdGenerated(id)) {
            throw new Resources.NotFoundException();
        }
        Resources resources = view.getContext().getResources();
        if (resources != null) {
            return resources.getResourceEntryName(id);
        }
        return "";
    }
}
