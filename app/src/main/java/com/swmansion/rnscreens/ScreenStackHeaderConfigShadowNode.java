package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.swmansion.rnscreens.utils.PaddingBundle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenStackHeaderConfigShadowNode extends LayoutShadowNode {
    private ReactContext context;
    private float height;
    private float paddingEnd;
    private float paddingStart;

    public ScreenStackHeaderConfigShadowNode(@NotNull ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final float getPaddingStart() {
        return this.paddingStart;
    }

    public final void setPaddingStart(float f) {
        this.paddingStart = f;
    }

    public final float getPaddingEnd() {
        return this.paddingEnd;
    }

    public final void setPaddingEnd(float f) {
        this.paddingEnd = f;
    }

    public final float getHeight() {
        return this.height;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(@Nullable Object obj) {
        if (obj instanceof PaddingBundle) {
            PaddingBundle paddingBundle = (PaddingBundle) obj;
            this.paddingStart = paddingBundle.getPaddingStart();
            this.paddingEnd = paddingBundle.getPaddingEnd();
            this.height = paddingBundle.getHeight();
            setPadding(4, this.paddingStart);
            setPadding(5, this.paddingEnd);
            setPosition(1, -this.height);
            return;
        }
        super.setLocalData(obj);
    }
}
