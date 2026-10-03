package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class NativeModuleRegistryBuilder {
    private final HashMap<String, ModuleHolder> modules;
    private final ReactApplicationContext reactApplicationContext;

    public NativeModuleRegistryBuilder(@NotNull ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext;
        this.modules = new HashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "ReactInstanceManager is not used", replaceWith = @ReplaceWith(expression = "NativeModuleRegistryBuilder(reactApplicationContext)", imports = {}))
    public NativeModuleRegistryBuilder(@NotNull ReactApplicationContext reactApplicationContext, @NotNull ReactInstanceManager reactInstanceManager) {
        this(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
    }

    public final void processPackage(@NotNull ReactPackage reactPackage) {
        Iterable<ModuleHolder> nativeModuleIterator;
        Intrinsics.checkNotNullParameter(reactPackage, "reactPackage");
        if (reactPackage instanceof LazyReactPackage) {
            nativeModuleIterator = ((LazyReactPackage) reactPackage).getNativeModuleIterator(this.reactApplicationContext);
        } else if (reactPackage instanceof BaseReactPackage) {
            nativeModuleIterator = ((BaseReactPackage) reactPackage).getNativeModuleIterator$ReactAndroid_release(this.reactApplicationContext);
        } else {
            nativeModuleIterator = ReactPackageHelper.INSTANCE.getNativeModuleIterator(reactPackage, this.reactApplicationContext);
        }
        for (ModuleHolder moduleHolder : nativeModuleIterator) {
            String name = moduleHolder.getName();
            ModuleHolder moduleHolder2 = this.modules.get(name);
            if (moduleHolder2 != null && !moduleHolder.getCanOverrideExistingModule()) {
                throw new IllegalStateException(("\nNative module " + name + " tried to override " + moduleHolder2.getClassName() + ".\n\nCheck the getPackages() method in MainApplication.java, it might be that module is being created twice. \nIf this was your intention, set canOverrideExistingModule=true. This error may also be present if the \npackage is present only once in getPackages() but is also automatically added later during build time \nby autolinking. Try removing the existing entry and rebuild.\n").toString());
            }
            this.modules.put(name, moduleHolder);
        }
    }

    public final NativeModuleRegistry build() {
        return new NativeModuleRegistry(this.reactApplicationContext, this.modules);
    }
}
