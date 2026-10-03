package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutIdKt {
    public static final Modifier layoutId(@NotNull Modifier modifier, @NotNull Object obj) {
        return modifier.then(new LayoutIdElement(obj));
    }

    public static final Object getLayoutId(@NotNull Measurable measurable) {
        Object parentData = measurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }
}
