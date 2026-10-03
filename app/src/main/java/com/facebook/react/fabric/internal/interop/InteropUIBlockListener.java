package com.facebook.react.fabric.internal.interop;

import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class InteropUIBlockListener implements UIManagerListener {
    private final List<UIBlock> beforeUIBlocks = new ArrayList();
    private final List<UIBlock> afterUIBlocks = new ArrayList();

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    public final List<UIBlock> getBeforeUIBlocks$ReactAndroid_release() {
        return this.beforeUIBlocks;
    }

    public final List<UIBlock> getAfterUIBlocks$ReactAndroid_release() {
        return this.afterUIBlocks;
    }

    public final void prependUIBlock(@NotNull UIBlock block) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.beforeUIBlocks.add(block);
        }
    }

    public final void addUIBlock(@NotNull UIBlock block) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.afterUIBlocks.add(block);
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        if (this.beforeUIBlocks.isEmpty()) {
            return;
        }
        for (UIBlock uIBlock : this.beforeUIBlocks) {
            if (uiManager instanceof UIBlockViewResolver) {
                uIBlock.execute((UIBlockViewResolver) uiManager);
            }
        }
        this.beforeUIBlocks.clear();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        if (this.afterUIBlocks.isEmpty()) {
            return;
        }
        for (UIBlock uIBlock : this.afterUIBlocks) {
            if (uiManager instanceof UIBlockViewResolver) {
                uIBlock.execute((UIBlockViewResolver) uiManager);
            }
        }
        this.afterUIBlocks.clear();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        didMountItems(uiManager);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(@NotNull UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        willMountItems(uiManager);
    }
}
