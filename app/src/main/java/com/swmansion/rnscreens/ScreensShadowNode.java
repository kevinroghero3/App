package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ScreensShadowNode extends LayoutShadowNode {
    private ReactContext context;

    public ScreensShadowNode(@NotNull ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(@NotNull NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        super.onBeforeLayout(nativeViewHierarchyOptimizer);
        UIManagerModule uIManagerModule = (UIManagerModule) this.context.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.addUIBlock(new UIBlock() { // from class: com.swmansion.rnscreens.ScreensShadowNode$$ExternalSyntheticLambda0
                @Override // com.facebook.react.uimanager.UIBlock
                public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    ScreensShadowNode.onBeforeLayout$lambda$0(this.f$0, nativeViewHierarchyManager);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBeforeLayout$lambda$0(ScreensShadowNode screensShadowNode, NativeViewHierarchyManager nativeViewHierarchyManager) {
        if (nativeViewHierarchyManager == null) {
            return;
        }
        View viewResolveView = nativeViewHierarchyManager.resolveView(screensShadowNode.getReactTag());
        if (viewResolveView instanceof ScreenContainer) {
            ((ScreenContainer) viewResolveView).performUpdates();
        }
    }
}
