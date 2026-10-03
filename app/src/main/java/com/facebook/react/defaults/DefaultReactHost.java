package com.facebook.react.defaults;

import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSCInstance;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultReactHost {
    public static final DefaultReactHost INSTANCE = new DefaultReactHost();
    private static ReactHost reactHost;

    private DefaultReactHost() {
    }

    public static /* synthetic */ ReactHost getDefaultReactHost$default(Context context, List list, String str, String str2, String str3, boolean z, boolean z2, List list2, int i, Object obj) {
        int i2 = i & 4;
        String str4 = FirebaseAnalytics.Param.INDEX;
        String str5 = i2 != 0 ? FirebaseAnalytics.Param.INDEX : str;
        if ((i & 8) == 0) {
            str4 = str2;
        }
        return getDefaultReactHost(context, list, str5, str4, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? true : z, (i & 64) != 0 ? ReactBuildConfig.DEBUG : z2, (i & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(@NotNull Context context, @NotNull List<? extends ReactPackage> packageList, @NotNull String jsMainModulePath, @NotNull String jsBundleAssetPath, @Nullable String str, boolean z, boolean z2, @NotNull List<? extends Function1<? super ReactContext, ? extends CxxReactPackage>> cxxReactPackageProviders) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleAssetPath, "jsBundleAssetPath");
        Intrinsics.checkNotNullParameter(cxxReactPackageProviders, "cxxReactPackageProviders");
        return getDefaultReactHost(context, packageList, jsMainModulePath, jsBundleAssetPath, str, z, z2, cxxReactPackageProviders, new Function1() { // from class: com.facebook.react.defaults.DefaultReactHost$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultReactHost.getDefaultReactHost$lambda$0((Exception) obj);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDefaultReactHost$lambda$0(Exception it2) throws Exception {
        Intrinsics.checkNotNullParameter(it2, "it");
        throw it2;
    }

    public static /* synthetic */ ReactHost getDefaultReactHost$default(Context context, List list, String str, String str2, String str3, boolean z, boolean z2, List list2, Function1 function1, BindingsInstaller bindingsInstaller, int i, Object obj) {
        int i2 = i & 4;
        String str4 = FirebaseAnalytics.Param.INDEX;
        String str5 = i2 != 0 ? FirebaseAnalytics.Param.INDEX : str;
        if ((i & 8) == 0) {
            str4 = str2;
        }
        return getDefaultReactHost(context, list, str5, str4, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? true : z, (i & 64) != 0 ? ReactBuildConfig.DEBUG : z2, (i & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 256) != 0 ? new Function1() { // from class: com.facebook.react.defaults.DefaultReactHost$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DefaultReactHost.getDefaultReactHost$lambda$1((Exception) obj2);
            }
        } : function1, (i & 512) == 0 ? bindingsInstaller : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDefaultReactHost$lambda$1(Exception it2) throws Exception {
        Intrinsics.checkNotNullParameter(it2, "it");
        throw it2;
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(@NotNull Context context, @NotNull List<? extends ReactPackage> packageList, @NotNull String jsMainModulePath, @NotNull String jsBundleAssetPath, @Nullable String str, boolean z, boolean z2, @NotNull List<? extends Function1<? super ReactContext, ? extends CxxReactPackage>> cxxReactPackageProviders, @NotNull Function1<? super Exception, Unit> exceptionHandler, @Nullable BindingsInstaller bindingsInstaller) {
        JSBundleLoader jSBundleLoaderCreateAssetLoader;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleAssetPath, "jsBundleAssetPath");
        Intrinsics.checkNotNullParameter(cxxReactPackageProviders, "cxxReactPackageProviders");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        if (reactHost == null) {
            if (str != null) {
                if (StringsKt__StringsJVMKt.startsWith$default(str, "assets://", false, 2, null)) {
                    jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(context, str, true);
                } else {
                    jSBundleLoaderCreateAssetLoader = JSBundleLoader.createFileLoader(str);
                }
            } else {
                jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(context, "assets://" + jsBundleAssetPath, true);
            }
            JSBundleLoader jSBundleLoader = jSBundleLoaderCreateAssetLoader;
            JSRuntimeFactory hermesInstance = z ? new HermesInstance() : new JSCInstance();
            DefaultTurboModuleManagerDelegate.Builder builder = new DefaultTurboModuleManagerDelegate.Builder();
            Iterator<T> it2 = cxxReactPackageProviders.iterator();
            while (it2.hasNext()) {
                builder.addCxxReactPackage((Function1<? super ReactApplicationContext, ? extends CxxReactPackage>) it2.next());
            }
            Intrinsics.checkNotNull(jSBundleLoader);
            DefaultReactHostDelegate defaultReactHostDelegate = new DefaultReactHostDelegate(jsMainModulePath, jSBundleLoader, packageList, hermesInstance, bindingsInstaller, exceptionHandler, builder);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.register(componentFactory);
            reactHost = new ReactHostImpl(context, defaultReactHostDelegate, componentFactory, true, z2);
        }
        ReactHost reactHost2 = reactHost;
        Intrinsics.checkNotNull(reactHost2, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return reactHost2;
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(@NotNull Context context, @NotNull ReactNativeHost reactNativeHost) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        if (!(reactNativeHost instanceof DefaultReactNativeHost)) {
            throw new IllegalArgumentException("You can call getDefaultReactHost only with instances of DefaultReactNativeHost");
        }
        return ((DefaultReactNativeHost) reactNativeHost).toReactHost$ReactAndroid_release(context);
    }
}
