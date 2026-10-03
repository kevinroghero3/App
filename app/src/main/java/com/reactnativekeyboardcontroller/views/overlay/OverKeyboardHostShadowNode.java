package com.reactnativekeyboardcontroller.views.overlay;

import android.graphics.Point;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class OverKeyboardHostShadowNode extends LayoutShadowNode {
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void addChildAt(@NotNull ReactShadowNodeImpl child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addChildAt(child, i);
        ThemedReactContext themedContext = getThemedContext();
        Intrinsics.checkNotNullExpressionValue(themedContext, "getThemedContext(...)");
        Point displaySize = ContextKt.getDisplaySize(themedContext);
        child.setStyleWidth(displaySize.x);
        child.setStyleHeight(displaySize.y);
    }
}
