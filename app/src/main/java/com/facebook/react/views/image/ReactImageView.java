package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.fresco.ImageCacheControl;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.util.RNLog;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ReactImageView extends GenericDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private ImageSource cachedImageSource;
    private Object callerContext;
    private ControllerListener<ImageInfo> controllerForTesting;
    private Drawable defaultImageDrawable;
    private ReactImageDownloadListener<ImageInfo> downloadListener;
    private final AbstractDraweeControllerBuilder<?, ?, ?, ?> draweeControllerBuilder;
    private int fadeDurationMs;
    private final GlobalImageLoadListener globalImageLoadListener;
    private ReadableMap headers;
    private ImageSource imageSource;
    private boolean isDirty;
    private IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor;
    private Drawable loadingImageDrawable;
    private int overlayColor;
    private boolean progressiveRenderingEnabled;
    private ImageResizeMethod resizeMethod;
    private float resizeMultiplier;
    private ScalingUtils.ScaleType scaleType;
    private final List<ImageSource> sources;
    private Shader.TileMode tileMode;
    private TilePostprocessor tilePostprocessor;
    public static final Companion Companion = new Companion(null);
    private static final Matrix tileMatrix = new Matrix();

    /* JADX INFO: loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ImageCacheControl.values().length];
            try {
                iArr[ImageCacheControl.ONLY_IF_CACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageResizeMethod.values().length];
            try {
                iArr2[ImageResizeMethod.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ImageResizeMethod.RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactImageView(@NotNull Context context, @NotNull AbstractDraweeControllerBuilder<?, ?, ?, ?> draweeControllerBuilder, @Nullable GlobalImageLoadListener globalImageLoadListener, @Nullable Object obj) {
        super(context, Companion.buildHierarchy(context));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(draweeControllerBuilder, "draweeControllerBuilder");
        this.draweeControllerBuilder = draweeControllerBuilder;
        this.globalImageLoadListener = globalImageLoadListener;
        this.callerContext = obj;
        this.sources = new ArrayList();
        this.scaleType = ImageResizeMode.defaultValue();
        this.tileMode = ImageResizeMode.defaultTileMode();
        this.fadeDurationMs = -1;
        this.resizeMultiplier = 1.0f;
        this.resizeMethod = ImageResizeMethod.AUTO;
        setLegacyVisibilityHandlingEnabled(true);
    }

    public final ImageSource getImageSource$ReactAndroid_release() {
        return this.imageSource;
    }

    public final void setImageSource$ReactAndroid_release(@Nullable ImageSource imageSource) {
        this.imageSource = imageSource;
    }

    public final void updateCallerContext(@Nullable Object obj) {
        if (Intrinsics.areEqual(this.callerContext, obj)) {
            return;
        }
        this.callerContext = obj;
        this.isDirty = true;
    }

    public final void setShouldNotifyLoadEvents(boolean z) {
        if (z == (this.downloadListener != null)) {
            return;
        }
        if (!z) {
            this.downloadListener = null;
        } else {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            final EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
            this.downloadListener = new ReactImageDownloadListener<ImageInfo>() { // from class: com.facebook.react.views.image.ReactImageView.setShouldNotifyLoadEvents.1
                @Override // com.facebook.react.views.image.ReactImageDownloadListener
                public void onProgressChange(int i, int i2) {
                    if (eventDispatcherForReactTag == null || this.getImageSource$ReactAndroid_release() == null) {
                        return;
                    }
                    EventDispatcher eventDispatcher = eventDispatcherForReactTag;
                    ImageLoadEvent.Companion companion = ImageLoadEvent.Companion;
                    int surfaceId = UIManagerHelper.getSurfaceId(this);
                    int id = this.getId();
                    ImageSource imageSource$ReactAndroid_release = this.getImageSource$ReactAndroid_release();
                    eventDispatcher.dispatchEvent(companion.createProgressEvent(surfaceId, id, imageSource$ReactAndroid_release != null ? imageSource$ReactAndroid_release.getSource() : null, i, i2));
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public void onSubmit(String id, Object obj) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    EventDispatcher eventDispatcher = eventDispatcherForReactTag;
                    if (eventDispatcher == null) {
                        return;
                    }
                    eventDispatcher.dispatchEvent(ImageLoadEvent.Companion.createLoadStartEvent(UIManagerHelper.getSurfaceId(this), this.getId()));
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    EventDispatcher eventDispatcher;
                    Intrinsics.checkNotNullParameter(id, "id");
                    if (imageInfo == null || this.getImageSource$ReactAndroid_release() == null || (eventDispatcher = eventDispatcherForReactTag) == null) {
                        return;
                    }
                    ImageLoadEvent.Companion companion = ImageLoadEvent.Companion;
                    int surfaceId = UIManagerHelper.getSurfaceId(this);
                    int id2 = this.getId();
                    ImageSource imageSource$ReactAndroid_release = this.getImageSource$ReactAndroid_release();
                    eventDispatcher.dispatchEvent(companion.createLoadEvent(surfaceId, id2, imageSource$ReactAndroid_release != null ? imageSource$ReactAndroid_release.getSource() : null, imageInfo.getWidth(), imageInfo.getHeight()));
                    eventDispatcherForReactTag.dispatchEvent(companion.createLoadEndEvent(UIManagerHelper.getSurfaceId(this), this.getId()));
                }

                @Override // com.facebook.react.views.image.ReactImageDownloadListener, com.facebook.drawee.controller.ControllerListener
                public void onFailure(String id, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    EventDispatcher eventDispatcher = eventDispatcherForReactTag;
                    if (eventDispatcher == null) {
                        return;
                    }
                    eventDispatcher.dispatchEvent(ImageLoadEvent.Companion.createErrorEvent(UIManagerHelper.getSurfaceId(this), this.getId(), throwable));
                }
            };
        }
        this.isDirty = true;
    }

    public final void setBlurRadius(float f) {
        int iDpToPx = ((int) PixelUtil.INSTANCE.dpToPx(f)) / 2;
        this.iterativeBoxBlurPostProcessor = iDpToPx == 0 ? null : new IterativeBoxBlurPostProcessor(2, iDpToPx);
        this.isDirty = true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public final void setBorderColor(int i) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.ALL, Integer.valueOf(i));
    }

    public final void setOverlayColor(int i) {
        if (this.overlayColor != i) {
            this.overlayColor = i;
            this.isDirty = true;
        }
    }

    public final void setBorderWidth(float f) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.ALL, Float.valueOf(f));
    }

    public final void setBorderRadius(float f) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.BORDER_RADIUS, Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.INSTANCE.pxToDp(f), LengthPercentageType.POINT));
    }

    public final void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.values()[i], Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.INSTANCE.pxToDp(f), LengthPercentageType.POINT));
    }

    public final void setScaleType(@NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (this.scaleType != scaleType) {
            this.scaleType = scaleType;
            this.isDirty = true;
        }
    }

    public final void setTileMode(@NotNull Shader.TileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "tileMode");
        if (this.tileMode != tileMode) {
            this.tileMode = tileMode;
            this.tilePostprocessor = isTiled() ? new TilePostprocessor() : null;
            this.isDirty = true;
        }
    }

    public final void setResizeMethod(@NotNull ImageResizeMethod resizeMethod) {
        Intrinsics.checkNotNullParameter(resizeMethod, "resizeMethod");
        if (this.resizeMethod != resizeMethod) {
            this.resizeMethod = resizeMethod;
            this.isDirty = true;
        }
    }

    public final void setResizeMultiplier(float f) {
        if (Math.abs(this.resizeMultiplier - f) > 9.999999747378752E-5d) {
            this.resizeMultiplier = f;
            this.isDirty = true;
        }
    }

    public final void setSource(@Nullable ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        if (readableArray == null || readableArray.size() == 0) {
            ImageSource.Companion companion = ImageSource.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            arrayList.add(companion.getTransparentBitmapImageSource(context));
        } else {
            if (readableArray.size() == 1) {
                ReadableMap map = readableArray.getMap(0);
                if (map == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ImageCacheControl imageCacheControlComputeCacheControl = computeCacheControl(map.getString("cache"));
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                ImageSource imageSource = new ImageSource(context2, map.getString("uri"), 0.0d, 0.0d, imageCacheControlComputeCacheControl, 12, null);
                if (Intrinsics.areEqual(Uri.EMPTY, imageSource.getUri())) {
                    warnImageSource(map.getString("uri"));
                    ImageSource.Companion companion2 = ImageSource.Companion;
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    imageSource = companion2.getTransparentBitmapImageSource(context3);
                }
                arrayList.add(imageSource);
            } else {
                int size = readableArray.size();
                for (int i = 0; i < size; i++) {
                    ReadableMap map2 = readableArray.getMap(i);
                    if (map2 != null) {
                        ImageCacheControl imageCacheControlComputeCacheControl2 = computeCacheControl(map2.getString("cache"));
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        ImageSource imageSource2 = new ImageSource(context4, map2.getString("uri"), map2.getDouble("width"), map2.getDouble("height"), imageCacheControlComputeCacheControl2);
                        if (Intrinsics.areEqual(Uri.EMPTY, imageSource2.getUri())) {
                            warnImageSource(map2.getString("uri"));
                            ImageSource.Companion companion3 = ImageSource.Companion;
                            Context context5 = getContext();
                            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                            imageSource2 = companion3.getTransparentBitmapImageSource(context5);
                        }
                        arrayList.add(imageSource2);
                    }
                }
            }
        }
        if (Intrinsics.areEqual(this.sources, arrayList)) {
            return;
        }
        this.sources.clear();
        this.sources.addAll(arrayList);
        this.isDirty = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r2.equals("default") == false) goto L21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.react.modules.fresco.ImageCacheControl computeCacheControl(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L3a
            int r0 = r2.hashCode()
            switch(r0) {
                case -1564134880: goto L2b;
                case -934641255: goto L1f;
                case 706834161: goto L13;
                case 1544803905: goto La;
                default: goto L9;
            }
        L9:
            goto L37
        La:
            java.lang.String r0 = "default"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3a
            goto L37
        L13:
            java.lang.String r0 = "only-if-cached"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L1c
            goto L37
        L1c:
            com.facebook.react.modules.fresco.ImageCacheControl r2 = com.facebook.react.modules.fresco.ImageCacheControl.ONLY_IF_CACHED
            goto L3c
        L1f:
            java.lang.String r0 = "reload"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L28
            goto L37
        L28:
            com.facebook.react.modules.fresco.ImageCacheControl r2 = com.facebook.react.modules.fresco.ImageCacheControl.RELOAD
            goto L3c
        L2b:
            java.lang.String r0 = "force-cache"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L34
            goto L37
        L34:
            com.facebook.react.modules.fresco.ImageCacheControl r2 = com.facebook.react.modules.fresco.ImageCacheControl.FORCE_CACHE
            goto L3c
        L37:
            com.facebook.react.modules.fresco.ImageCacheControl r2 = com.facebook.react.modules.fresco.ImageCacheControl.DEFAULT
            goto L3c
        L3a:
            com.facebook.react.modules.fresco.ImageCacheControl r2 = com.facebook.react.modules.fresco.ImageCacheControl.DEFAULT
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ReactImageView.computeCacheControl(java.lang.String):com.facebook.react.modules.fresco.ImageCacheControl");
    }

    private final ImageRequest.RequestLevel computeRequestLevel(ImageCacheControl imageCacheControl) {
        if (WhenMappings.$EnumSwitchMapping$0[imageCacheControl.ordinal()] == 1) {
            return ImageRequest.RequestLevel.DISK_CACHE;
        }
        return ImageRequest.RequestLevel.FULL_FETCH;
    }

    public final void setDefaultSource(@Nullable String str) {
        ResourceDrawableIdHelper companion = ResourceDrawableIdHelper.Companion.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Drawable resourceDrawable = companion.getResourceDrawable(context, str);
        if (Intrinsics.areEqual(this.defaultImageDrawable, resourceDrawable)) {
            return;
        }
        this.defaultImageDrawable = resourceDrawable;
        this.isDirty = true;
    }

    public final void setLoadingIndicatorSource(@Nullable String str) {
        ResourceDrawableIdHelper companion = ResourceDrawableIdHelper.Companion.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Drawable resourceDrawable = companion.getResourceDrawable(context, str);
        AutoRotateDrawable autoRotateDrawable = resourceDrawable != null ? new AutoRotateDrawable(resourceDrawable, 1000) : null;
        if (Intrinsics.areEqual(this.loadingImageDrawable, autoRotateDrawable)) {
            return;
        }
        this.loadingImageDrawable = autoRotateDrawable;
        this.isDirty = true;
    }

    public final void setProgressiveRenderingEnabled(boolean z) {
        this.progressiveRenderingEnabled = z;
    }

    public final void setFadeDuration(int i) {
        this.fadeDurationMs = i;
    }

    public final void setHeaders(@Nullable ReadableMap readableMap) {
        this.headers = readableMap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
            if (this.downloadListener != null) {
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.Companion.createErrorEvent(UIManagerHelper.getSurfaceId(this), getId(), e));
                }
            }
        }
    }

    public final void maybeUpdateView() {
        if (this.isDirty) {
            if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
                setSourceImage();
                ImageSource imageSource = this.imageSource;
                if (imageSource == null) {
                    return;
                }
                boolean zShouldResize = shouldResize(imageSource);
                if (!zShouldResize || (getWidth() > 0 && getHeight() > 0)) {
                    if (!isTiled() || (getWidth() > 0 && getHeight() > 0)) {
                        GenericDraweeHierarchy hierarchy = getHierarchy();
                        hierarchy.setActualImageScaleType(this.scaleType);
                        Drawable drawable = this.defaultImageDrawable;
                        if (drawable != null) {
                            hierarchy.setPlaceholderImage(drawable, this.scaleType);
                        }
                        Drawable drawable2 = this.loadingImageDrawable;
                        if (drawable2 != null) {
                            hierarchy.setPlaceholderImage(drawable2, ScalingUtils.ScaleType.CENTER);
                        }
                        RoundingParams roundingParams = hierarchy.getRoundingParams();
                        if (roundingParams != null) {
                            int i = this.overlayColor;
                            if (i != 0) {
                                roundingParams.setOverlayColor(i);
                            } else {
                                roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                            }
                            hierarchy.setRoundingParams(roundingParams);
                        }
                        int i2 = this.fadeDurationMs;
                        if (i2 < 0) {
                            i2 = imageSource.isResource() ? 0 : 300;
                        }
                        hierarchy.setFadeDuration(i2);
                        maybeUpdateViewFromRequest(zShouldResize);
                        this.isDirty = false;
                    }
                }
            }
        }
    }

    private final void maybeUpdateViewFromRequest(boolean z) {
        ImageSource imageSource = this.imageSource;
        if (imageSource == null) {
            return;
        }
        Uri uri = imageSource.getUri();
        ImageCacheControl cacheControl = imageSource.getCacheControl();
        ImageRequest.RequestLevel requestLevelComputeRequestLevel = computeRequestLevel(cacheControl);
        ArrayList arrayList = new ArrayList();
        IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor = this.iterativeBoxBlurPostProcessor;
        if (iterativeBoxBlurPostProcessor != null) {
            arrayList.add(iterativeBoxBlurPostProcessor);
        }
        TilePostprocessor tilePostprocessor = this.tilePostprocessor;
        if (tilePostprocessor != null) {
            arrayList.add(tilePostprocessor);
        }
        Postprocessor postprocessorFrom = MultiPostprocessor.Companion.from(arrayList);
        ResizeOptions resizeOptions = z ? getResizeOptions() : null;
        if (cacheControl == ImageCacheControl.RELOAD) {
            Fresco.getImagePipeline().evictFromCache(uri);
        }
        ImageRequestBuilder lowestPermittedRequestLevel = ImageRequestBuilder.newBuilderWithSource(uri).setPostprocessor(postprocessorFrom).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.progressiveRenderingEnabled).setLowestPermittedRequestLevel(requestLevelComputeRequestLevel);
        ImageResizeMethod imageResizeMethod = this.resizeMethod;
        ImageResizeMethod imageResizeMethod2 = ImageResizeMethod.NONE;
        if (imageResizeMethod == imageResizeMethod2) {
            lowestPermittedRequestLevel.setDownsampleOverride(DownsampleMode.NEVER);
        }
        ReactNetworkImageRequest.Companion companion = ReactNetworkImageRequest.Companion;
        Intrinsics.checkNotNull(lowestPermittedRequestLevel);
        ReactNetworkImageRequest reactNetworkImageRequestFromBuilderWithHeaders = companion.fromBuilderWithHeaders(lowestPermittedRequestLevel, this.headers, cacheControl);
        GlobalImageLoadListener globalImageLoadListener = this.globalImageLoadListener;
        if (globalImageLoadListener != null) {
            globalImageLoadListener.onLoadAttempt(uri);
        }
        AbstractDraweeControllerBuilder<?, ?, ?, ?> abstractDraweeControllerBuilder = this.draweeControllerBuilder;
        Intrinsics.checkNotNull(abstractDraweeControllerBuilder, "null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeControllerBuilder<*, com.facebook.imagepipeline.request.ImageRequest, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.imagepipeline.image.ImageInfo>");
        abstractDraweeControllerBuilder.reset();
        abstractDraweeControllerBuilder.setImageRequest(reactNetworkImageRequestFromBuilderWithHeaders).setAutoPlayAnimations(true).setOldController(getController());
        Object obj = this.callerContext;
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(abstractDraweeControllerBuilder.setCallerContext(obj), "setCallerContext(...)");
        }
        ImageSource imageSource2 = this.cachedImageSource;
        if (imageSource2 != null) {
            ImageRequestBuilder progressiveRenderingEnabled = ImageRequestBuilder.newBuilderWithSource(imageSource2.getUri()).setPostprocessor(postprocessorFrom).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.progressiveRenderingEnabled);
            if (this.resizeMethod == imageResizeMethod2) {
                progressiveRenderingEnabled.setDownsampleOverride(DownsampleMode.NEVER);
            }
            Intrinsics.checkNotNullExpressionValue(abstractDraweeControllerBuilder.setLowResImageRequest(progressiveRenderingEnabled.build()), "setLowResImageRequest(...)");
        }
        ReactImageDownloadListener<ImageInfo> reactImageDownloadListener = this.downloadListener;
        if (reactImageDownloadListener != null && this.controllerForTesting != null) {
            ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
            forwardingControllerListener.addListener(this.downloadListener);
            forwardingControllerListener.addListener(this.controllerForTesting);
            abstractDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
        } else {
            ControllerListener<ImageInfo> controllerListener = this.controllerForTesting;
            if (controllerListener != null) {
                abstractDraweeControllerBuilder.setControllerListener(controllerListener);
            } else if (reactImageDownloadListener != null) {
                abstractDraweeControllerBuilder.setControllerListener(reactImageDownloadListener);
            }
        }
        if (this.downloadListener != null) {
            getHierarchy().setProgressBarImage(this.downloadListener);
        }
        setController(abstractDraweeControllerBuilder.build());
        abstractDraweeControllerBuilder.reset();
    }

    @VisibleForTesting
    public final void setControllerListener(@Nullable ControllerListener<ImageInfo> controllerListener) {
        this.controllerForTesting = controllerListener;
        this.isDirty = true;
        maybeUpdateView();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.isDirty = this.isDirty || hasMultipleSources() || isTiled();
        maybeUpdateView();
    }

    private final boolean hasMultipleSources() {
        return this.sources.size() > 1;
    }

    private final boolean isTiled() {
        return this.tileMode != Shader.TileMode.CLAMP;
    }

    private final void setSourceImage() {
        this.imageSource = null;
        if (this.sources.isEmpty()) {
            List<ImageSource> list = this.sources;
            ImageSource.Companion companion = ImageSource.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            list.add(companion.getTransparentBitmapImageSource(context));
        } else if (hasMultipleSources()) {
            MultiSourceHelper.MultiSourceResult bestSourceForSize = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.sources);
            this.imageSource = bestSourceForSize.bestResult;
            this.cachedImageSource = bestSourceForSize.bestResultInCache;
            return;
        }
        this.imageSource = this.sources.get(0);
    }

    private final boolean shouldResize(ImageSource imageSource) {
        int i = WhenMappings.$EnumSwitchMapping$1[this.resizeMethod.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return true;
            }
        } else if (UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri())) {
            return true;
        }
        return false;
    }

    private final ResizeOptions getResizeOptions() {
        int iRound = Math.round(getWidth() * this.resizeMultiplier);
        int iRound2 = Math.round(getHeight() * this.resizeMultiplier);
        if (iRound <= 0 || iRound2 <= 0) {
            return null;
        }
        return new ResizeOptions(iRound, iRound2, 0.0f, 0.0f, 12, null);
    }

    private final void warnImageSource(String str) {
        if (!ReactBuildConfig.DEBUG || ReactNativeFeatureFlags.enableBridgelessArchitecture()) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        RNLog.w((ReactContext) context, "ReactImageView: Image source \"" + str + "\" doesn't exist");
    }

    /* JADX INFO: loaded from: classes2.dex */
    final class TilePostprocessor extends BasePostprocessor {
        public TilePostprocessor() {
        }

        @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
        public CloseableReference<Bitmap> process(@NotNull Bitmap source, @NotNull PlatformBitmapFactory bitmapFactory) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.scaleType.getTransform(ReactImageView.tileMatrix, rect, source.getWidth(), source.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(source, ReactImageView.this.tileMode, ReactImageView.this.tileMode);
            bitmapShader.setLocalMatrix(ReactImageView.tileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference<Bitmap> closeableReferenceCreateBitmap = bitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmap, "createBitmap(...)");
            try {
                new Canvas(closeableReferenceCreateBitmap.get()).drawRect(rect, paint);
                CloseableReference<Bitmap> closeableReferenceMo4256clone = closeableReferenceCreateBitmap.mo4256clone();
                Intrinsics.checkNotNullExpressionValue(closeableReferenceMo4256clone, "clone(...)");
                return closeableReferenceMo4256clone;
            } finally {
                CloseableReference.closeSafely(closeableReferenceCreateBitmap);
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GenericDraweeHierarchy buildHierarchy(Context context) {
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
            RoundingParams roundingParamsFromCornersRadius = RoundingParams.fromCornersRadius(0.0f);
            roundingParamsFromCornersRadius.setPaintFilterBitmap(true);
            GenericDraweeHierarchy genericDraweeHierarchyBuild = genericDraweeHierarchyBuilder.setRoundingParams(roundingParamsFromCornersRadius).build();
            Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchyBuild, "build(...)");
            return genericDraweeHierarchyBuild;
        }
    }
}
