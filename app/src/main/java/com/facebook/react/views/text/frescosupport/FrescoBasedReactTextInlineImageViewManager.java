package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = FrescoBasedReactTextInlineImageViewManager.REACT_CLASS)
public final class FrescoBasedReactTextInlineImageViewManager extends BaseViewManager<View, FrescoBasedReactTextInlineImageShadowNode> {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RCTTextInlineImage";
    private final Object callerContext;
    private final AbstractDraweeControllerBuilder<?, ?, ?, ?> draweeControllerBuilder;

    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(abstractDraweeControllerBuilder, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(@NotNull View root, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    public /* synthetic */ FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : abstractDraweeControllerBuilder, (i & 2) != 0 ? null : obj);
    }

    public FrescoBasedReactTextInlineImageViewManager(@Nullable AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder, @Nullable Object obj) {
        this.draweeControllerBuilder = abstractDraweeControllerBuilder;
        this.callerContext = obj;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public View createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public FrescoBasedReactTextInlineImageShadowNode createShadowNodeInstance() {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilderNewDraweeControllerBuilder = this.draweeControllerBuilder;
        if (abstractDraweeControllerBuilderNewDraweeControllerBuilder == null) {
            abstractDraweeControllerBuilderNewDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        }
        return new FrescoBasedReactTextInlineImageShadowNode(abstractDraweeControllerBuilderNewDraweeControllerBuilder, this.callerContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<FrescoBasedReactTextInlineImageShadowNode> getShadowNodeClass() {
        return FrescoBasedReactTextInlineImageShadowNode.class;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
