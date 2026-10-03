package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private static final Companion Companion = new Companion(null);

    public /* synthetic */ DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, list, list2);
    }

    @JvmStatic
    public static final native HybridData initHybrid(@NotNull List<? extends CxxReactPackage> list);

    private DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<? extends ReactPackage> list, List<? extends CxxReactPackage> list2) {
        super(reactApplicationContext, list, Companion.initHybrid(list2));
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public HybridData initHybrid() {
        throw new UnsupportedOperationException("DefaultTurboModuleManagerDelegate.initHybrid() must never be called!");
    }

    /* JADX INFO: loaded from: classes.dex */
    public static final class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        private final List<Function1<ReactApplicationContext, List<CxxReactPackage>>> cxxReactPackageProviders = new ArrayList();

        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder
        public /* bridge */ /* synthetic */ ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List list) {
            return build(reactApplicationContext, (List<? extends ReactPackage>) list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List addCxxReactPackage$lambda$1$lambda$0(Function0 function0, ReactApplicationContext reactApplicationContext) {
            Intrinsics.checkNotNullParameter(reactApplicationContext, "<unused var>");
            return CollectionsKt__CollectionsJVMKt.listOf(function0.invoke());
        }

        public final Builder addCxxReactPackage(@NotNull final Function0<? extends CxxReactPackage> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.cxxReactPackageProviders.add(new Function1() { // from class: com.facebook.react.defaults.DefaultTurboModuleManagerDelegate$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefaultTurboModuleManagerDelegate.Builder.addCxxReactPackage$lambda$1$lambda$0(provider, (ReactApplicationContext) obj);
                }
            });
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List addCxxReactPackage$lambda$3$lambda$2(Function1 function1, ReactApplicationContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CollectionsKt__CollectionsJVMKt.listOf(function1.invoke(context));
        }

        public final Builder addCxxReactPackage(@NotNull final Function1<? super ReactApplicationContext, ? extends CxxReactPackage> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.cxxReactPackageProviders.add(new Function1() { // from class: com.facebook.react.defaults.DefaultTurboModuleManagerDelegate$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefaultTurboModuleManagerDelegate.Builder.addCxxReactPackage$lambda$3$lambda$2(provider, (ReactApplicationContext) obj);
                }
            });
            return this;
        }

        public final Builder addCxxReactPackages(@NotNull Function1<? super ReactApplicationContext, ? extends List<? extends CxxReactPackage>> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.cxxReactPackageProviders.add(provider);
            return this;
        }

        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder
        protected DefaultTurboModuleManagerDelegate build(@NotNull ReactApplicationContext context, @NotNull List<? extends ReactPackage> packages) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packages, "packages");
            List<Function1<ReactApplicationContext, List<CxxReactPackage>>> list = this.cxxReactPackageProviders;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) ((Function1) it2.next()).invoke(context));
            }
            return new DefaultTurboModuleManagerDelegate(context, packages, arrayList, null);
        }
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HybridData initHybrid(@NotNull List<? extends CxxReactPackage> list) {
            return DefaultTurboModuleManagerDelegate.initHybrid(list);
        }

        private Companion() {
        }
    }

    static {
        DefaultSoLoader.Companion.maybeLoadSoLibrary();
    }
}
