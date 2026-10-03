package com.swmansion.gesturehandler.react;

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec;
import com.swmansion.gesturehandler.core.GestureHandler;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "RNGestureHandlerModule")
public final class RNGestureHandlerModule extends NativeRNGestureHandlerModuleSpec implements GestureHandlerStateManager {
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "RNGestureHandlerModule";
    private final RNGestureHandlerEventDispatcher eventDispatcher;
    private final RNGestureHandlerInteractionManager interactionManager;
    private final RNGestureHandlerRegistry registry;
    private final List<RNGestureHandlerRootHelper> roots;

    private final native void decorateRuntime(long j);

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void flushOperations() {
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleClearJSResponder() {
    }

    public RNGestureHandlerModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.registry = new RNGestureHandlerRegistry();
        ReactApplicationContext reactApplicationContext2 = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext2, "getReactApplicationContext(...)");
        this.eventDispatcher = new RNGestureHandlerEventDispatcher(reactApplicationContext2);
        this.interactionManager = new RNGestureHandlerInteractionManager();
        this.roots = new ArrayList();
    }

    public final RNGestureHandlerRegistry getRegistry() {
        return this.registry;
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGestureHandlerModule";
    }

    private final <T extends GestureHandler> void createGestureHandlerHelper(String str, int i, ReadableMap readableMap) {
        if (this.registry.getHandler(i) != null) {
            throw new IllegalStateException("Handler with tag " + i + " already exists. Please ensure that no Gesture instance is used across multiple GestureDetectors.");
        }
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForName = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForName(str);
        if (factoryFindFactoryForName == null) {
            throw new JSApplicationIllegalArgumentException("Invalid handler name " + str);
        }
        GestureHandler gestureHandlerCreate = factoryFindFactoryForName.create(getReactApplicationContext(), i);
        gestureHandlerCreate.setOnTouchEventListener(this.eventDispatcher);
        this.registry.registerHandler(gestureHandlerCreate);
        this.interactionManager.configureInteractions(gestureHandlerCreate, readableMap);
        factoryFindFactoryForName.setConfig(gestureHandlerCreate, readableMap);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void createGestureHandler(@NotNull String handlerName, double d, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        Intrinsics.checkNotNullParameter(config, "config");
        createGestureHandlerHelper(handlerName, (int) d, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void attachGestureHandler(double d, double d2, double d3) {
        int i = (int) d;
        if (this.registry.attachHandlerToView(i, (int) d2, (int) d3)) {
            return;
        }
        throw new JSApplicationIllegalArgumentException("Handler with tag " + i + " does not exists");
    }

    private final <T extends GestureHandler> void updateGestureHandlerHelper(int i, ReadableMap readableMap) {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        GestureHandler handler = this.registry.getHandler(i);
        if (handler == null || (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(handler)) == null) {
            return;
        }
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        this.interactionManager.configureInteractions(handler, readableMap);
        factoryFindFactoryForHandler.setConfig(handler, readableMap);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void updateGestureHandler(double d, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        updateGestureHandlerHelper((int) d, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void dropGestureHandler(double d) {
        int i = (int) d;
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        this.registry.dropHandler(i);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleSetJSResponder(double d, boolean z) {
        int i = (int) d;
        RNGestureHandlerRootHelper rNGestureHandlerRootHelperFindRootHelperForViewAncestor = findRootHelperForViewAncestor(i);
        if (rNGestureHandlerRootHelperFindRootHelperForViewAncestor != null) {
            rNGestureHandlerRootHelperFindRootHelperForViewAncestor.handleSetJSResponder(i, z);
        }
    }

    @Override // com.swmansion.common.GestureHandlerStateManager
    public void setGestureHandlerState(int i, int i2) {
        GestureHandler handler = this.registry.getHandler(i);
        if (handler != null) {
            if (i2 == 1) {
                handler.fail();
                return;
            }
            if (i2 == 2) {
                handler.begin();
                return;
            }
            if (i2 == 3) {
                handler.cancel();
            } else if (i2 == 4) {
                handler.activate(true);
            } else {
                if (i2 != 5) {
                    return;
                }
                handler.end();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        getReactApplicationContext().runOnJSQueueThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RNGestureHandlerModule.install$lambda$1(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void install$lambda$1(RNGestureHandlerModule rNGestureHandlerModule) {
        try {
            SoLoader.loadLibrary("gesturehandler");
            JavaScriptContextHolder javaScriptContextHolder = rNGestureHandlerModule.getReactApplicationContext().getJavaScriptContextHolder();
            Intrinsics.checkNotNull(javaScriptContextHolder);
            rNGestureHandlerModule.decorateRuntime(javaScriptContextHolder.get());
        } catch (Exception unused) {
            SentryLogcatAdapter.w("[RNGestureHandler]", "Could not install JSI bindings.");
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.registry.dropAllHandlers();
        this.interactionManager.reset();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                this.roots.size();
                this.roots.get(0).tearDown();
                this.roots.size();
            }
            Unit unit = Unit.INSTANCE;
        }
        super.invalidate();
    }

    public final void registerRootHelper(@NotNull RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.contains(root);
            this.roots.add(root);
        }
    }

    public final void unregisterRootHelper(@NotNull RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.remove(root);
        }
    }

    private final RNGestureHandlerRootHelper findRootHelperForViewAncestor(int i) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        int iResolveRootTagFromReactTag = ExtensionsKt.getUIManager(reactApplicationContext).resolveRootTagFromReactTag(i);
        Object obj = null;
        if (iResolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.roots) {
            for (Object obj2 : this.roots) {
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper2 = (RNGestureHandlerRootHelper) obj2;
                if ((rNGestureHandlerRootHelper2.getRootView() instanceof ReactRootView) && ((ReactRootView) rNGestureHandlerRootHelper2.getRootView()).getRootViewTag() == iResolveRootTagFromReactTag) {
                    obj = obj2;
                    break;
                }
            }
            rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) obj;
        }
        return rNGestureHandlerRootHelper;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
