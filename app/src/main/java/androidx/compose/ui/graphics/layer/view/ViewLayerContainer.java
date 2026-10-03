package androidx.compose.ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    @Override // androidx.compose.ui.graphics.layer.view.DrawChildContainer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
    }

    protected final void dispatchGetDisplayList() {
    }

    public ViewLayerContainer(@NotNull Context context) {
        super(context);
    }
}
