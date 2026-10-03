package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactFindViewUtil {
    public static final ReactFindViewUtil INSTANCE = new ReactFindViewUtil();
    private static final List<OnViewFoundListener> onViewFoundListeners = new ArrayList();
    private static final Map<OnMultipleViewsFoundListener, Set<String>> onMultipleViewsFoundListener = new HashMap();

    public interface OnMultipleViewsFoundListener {
        void onViewFound(@NotNull View view, @NotNull String str);
    }

    public interface OnViewFoundListener {
        String getNativeId();

        void onViewFound(@NotNull View view);
    }

    private ReactFindViewUtil() {
    }

    @JvmStatic
    public static final View findView(@NotNull View root, @NotNull String nativeId) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        if (Intrinsics.areEqual(INSTANCE.getNativeId(root), nativeId)) {
            return root;
        }
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            View viewFindView = findView(childAt, nativeId);
            if (viewFindView != null) {
                return viewFindView;
            }
        }
        return null;
    }

    @JvmStatic
    public static final void findView(@NotNull View root, @NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        View viewFindView = findView(root, onViewFoundListener.getNativeId());
        if (viewFindView != null) {
            onViewFoundListener.onViewFound(viewFindView);
        }
        addViewListener(onViewFoundListener);
    }

    @JvmStatic
    public static final void addViewListener(@NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        onViewFoundListeners.add(onViewFoundListener);
    }

    @JvmStatic
    public static final void removeViewListener(@NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        onViewFoundListeners.remove(onViewFoundListener);
    }

    @JvmStatic
    public static final void addViewsListener(@NotNull OnMultipleViewsFoundListener listener, @NotNull Set<String> ids) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(ids, "ids");
        onMultipleViewsFoundListener.put(listener, ids);
    }

    @JvmStatic
    public static final void removeViewsListener(@NotNull OnMultipleViewsFoundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        onMultipleViewsFoundListener.remove(listener);
    }

    @JvmStatic
    public static final void notifyViewRendered(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String nativeId = INSTANCE.getNativeId(view);
        if (nativeId == null) {
            return;
        }
        Iterator<OnViewFoundListener> it2 = onViewFoundListeners.iterator();
        while (it2.hasNext()) {
            OnViewFoundListener next = it2.next();
            if (Intrinsics.areEqual(nativeId, next.getNativeId())) {
                next.onViewFound(view);
                it2.remove();
            }
        }
        for (Map.Entry<OnMultipleViewsFoundListener, Set<String>> entry : onMultipleViewsFoundListener.entrySet()) {
            OnMultipleViewsFoundListener key = entry.getKey();
            if (entry.getValue().contains(nativeId)) {
                key.onViewFound(view, nativeId);
            }
        }
    }

    private final String getNativeId(View view) {
        Object tag = view.getTag(R.id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }
}
