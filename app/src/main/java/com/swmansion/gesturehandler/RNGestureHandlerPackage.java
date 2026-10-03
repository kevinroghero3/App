package com.swmansion.gesturehandler;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootViewManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerPackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {
    private final Lazy viewManagers$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.swmansion.gesturehandler.RNGestureHandlerPackage$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return RNGestureHandlerPackage.viewManagers_delegate$lambda$2();
        }
    });

    private final Map<String, ModuleSpec> getViewManagers() {
        return (Map) this.viewManagers$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map viewManagers_delegate$lambda$2() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to(RNGestureHandlerRootViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.swmansion.gesturehandler.RNGestureHandlerPackage$$ExternalSyntheticLambda2
            @Override // javax.inject.Provider
            public final Object get() {
                return RNGestureHandlerPackage.viewManagers_delegate$lambda$2$lambda$0();
            }
        })), TuplesKt.to(RNGestureHandlerButtonViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.swmansion.gesturehandler.RNGestureHandlerPackage$$ExternalSyntheticLambda3
            @Override // javax.inject.Provider
            public final Object get() {
                return RNGestureHandlerPackage.viewManagers_delegate$lambda$2$lambda$1();
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagers_delegate$lambda$2$lambda$0() {
        return new RNGestureHandlerRootViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagers_delegate$lambda$2$lambda$1() {
        return new RNGestureHandlerButtonViewManager();
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ViewManager[]{new RNGestureHandlerRootViewManager(), new RNGestureHandlerButtonViewManager()});
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public List<String> getViewManagerNames(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt___CollectionsKt.toList(getViewManagers().keySet());
    }

    @Override // com.facebook.react.BaseReactPackage
    public List<ModuleSpec> getViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt___CollectionsKt.toMutableList((Collection) getViewManagers().values());
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public ViewManager<?, ?> createViewManager(@NotNull ReactApplicationContext reactContext, @NotNull String viewManagerName) {
        Provider<? extends NativeModule> provider;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ModuleSpec moduleSpec = getViewManagers().get(viewManagerName);
        NativeModule nativeModule = (moduleSpec == null || (provider = moduleSpec.getProvider()) == null) ? null : provider.get();
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(@NotNull String name, @NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.areEqual(name, "RNGestureHandlerModule")) {
            return new RNGestureHandlerModule(reactContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() throws InvocationTargetException {
        try {
            Object objNewInstance = Class.forName("com.swmansion.gesturehandler.RNGestureHandlerPackage$$ReactModuleInfoProvider").getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.react.module.model.ReactModuleInfoProvider");
            return (ReactModuleInfoProvider) objNewInstance;
        } catch (ClassNotFoundException unused) {
            return new ReactModuleInfoProvider() { // from class: com.swmansion.gesturehandler.RNGestureHandlerPackage$$ExternalSyntheticLambda1
                @Override // com.facebook.react.module.model.ReactModuleInfoProvider
                public final Map getReactModuleInfos() {
                    return RNGestureHandlerPackage.getReactModuleInfoProvider$lambda$3();
                }
            };
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for RNGestureHandlerPackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for RNGestureHandlerPackage$$ReactModuleInfoProvider", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$3() {
        Annotation annotation = RNGestureHandlerModule.class.getAnnotation(ReactModule.class);
        Intrinsics.checkNotNull(annotation);
        ReactModule reactModule = (ReactModule) annotation;
        String strName = reactModule.name();
        String name = RNGestureHandlerModule.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("RNGestureHandlerModule", new ReactModuleInfo(strName, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), true)));
    }
}
