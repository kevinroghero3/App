package com.facebook.react.modules.fresco;

import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.OkHttpCompat;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.HashSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = FrescoModule.NAME, needsEagerInit = true)
public class FrescoModule extends ReactContextBaseJavaModule implements ModuleDataCleaner.Cleanable, LifecycleEventListener, TurboModule {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "FrescoModule";
    private static boolean hasBeenInitialized;
    private final boolean clearOnDestroy;
    private ImagePipelineConfig config;
    private ImagePipeline pipeline;

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, false, null, 6, null);
    }

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline) {
        this(reactApplicationContext, imagePipeline, false, false, 12, null);
    }

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline, boolean z) {
        this(reactApplicationContext, imagePipeline, z, false, 8, null);
    }

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, boolean z) {
        this(reactApplicationContext, z, null, 4, null);
    }

    @JvmStatic
    public static final ImagePipelineConfig.Builder getDefaultConfigBuilder(@NotNull ReactContext reactContext) {
        return Companion.getDefaultConfigBuilder(reactContext);
    }

    @JvmStatic
    public static final boolean hasBeenInitialized() {
        return Companion.hasBeenInitialized();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public /* synthetic */ FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, ImagePipelineConfig imagePipelineConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : imagePipelineConfig);
    }

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, boolean z, @Nullable ImagePipelineConfig imagePipelineConfig) {
        super(reactApplicationContext);
        this.clearOnDestroy = z;
        this.config = imagePipelineConfig;
    }

    public /* synthetic */ FrescoModule(ReactApplicationContext reactApplicationContext, ImagePipeline imagePipeline, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, imagePipeline, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2);
    }

    public FrescoModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable ImagePipeline imagePipeline, boolean z, boolean z2) {
        this(reactApplicationContext, z, null, 4, null);
        this.pipeline = imagePipeline;
        if (z2) {
            hasBeenInitialized = true;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.addLifecycleEventListener(this);
        Companion companion = Companion;
        if (!companion.hasBeenInitialized()) {
            ImagePipelineConfig defaultConfig = this.config;
            if (defaultConfig == null) {
                Intrinsics.checkNotNull(reactApplicationContext);
                defaultConfig = companion.getDefaultConfig(reactApplicationContext);
            }
            DraweeConfig.Builder builderNewBuilder = DraweeConfig.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
            Fresco.initialize(reactApplicationContext.getApplicationContext(), defaultConfig, builderNewBuilder.build());
            hasBeenInitialized = true;
        } else if (this.config != null) {
            FLog.w(ReactConstants.TAG, "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.config = null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.modules.common.ModuleDataCleaner.Cleanable
    public void clearSensitiveData() {
        ImagePipeline imagePipeline = getImagePipeline();
        if (imagePipeline != null) {
            imagePipeline.clearCaches();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        ImagePipeline imagePipeline;
        if (Companion.hasBeenInitialized() && this.clearOnDestroy && (imagePipeline = getImagePipeline()) != null) {
            imagePipeline.clearMemoryCaches();
        }
    }

    private final ImagePipeline getImagePipeline() {
        if (this.pipeline == null) {
            this.pipeline = Fresco.getImagePipeline();
        }
        return this.pipeline;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean hasBeenInitialized() {
            return FrescoModule.hasBeenInitialized;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImagePipelineConfig getDefaultConfig(ReactContext reactContext) {
            return getDefaultConfigBuilder(reactContext).build();
        }

        @JvmStatic
        public final ImagePipelineConfig.Builder getDefaultConfigBuilder(@NotNull ReactContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            HashSet hashSet = new HashSet();
            hashSet.add(new SystraceRequestListener());
            OkHttpClient okHttpClientCreateClient = OkHttpClientProvider.createClient();
            OkHttpCompat.getCookieJarContainer(okHttpClientCreateClient).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler()));
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Intrinsics.checkNotNull(okHttpClientCreateClient);
            ImagePipelineConfig.Builder requestListeners = OkHttpImagePipelineConfigFactory.newBuilder(applicationContext, okHttpClientCreateClient).setNetworkFetcher(new ReactOkHttpNetworkFetcher(okHttpClientCreateClient)).setDownsampleMode(DownsampleMode.AUTO).setRequestListeners(hashSet);
            requestListeners.experiment().setBinaryXmlEnabled(ReactNativeFeatureFlags.loadVectorDrawablesOnImages());
            return requestListeners;
        }
    }
}
