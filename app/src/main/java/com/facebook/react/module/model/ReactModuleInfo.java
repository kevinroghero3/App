package com.facebook.react.module.model;

import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ReactModuleInfo {
    public static final Companion Companion = new Companion(null);
    private final boolean canOverrideExistingModule;
    private final String className;
    private final boolean isCxxModule;
    private final boolean isTurboModule;
    private final String name;
    private final boolean needsEagerInit;

    @JvmStatic
    public static final boolean classIsTurboModule(@NotNull Class<?> cls) {
        return Companion.classIsTurboModule(cls);
    }

    public ReactModuleInfo(@NotNull String name, @NotNull String className, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(className, "className");
        this.name = name;
        this.className = className;
        this.canOverrideExistingModule = z;
        this.needsEagerInit = z2;
        this.isCxxModule = z3;
        this.isTurboModule = z4;
    }

    public final String name() {
        return this.name;
    }

    public final String className() {
        return this.className;
    }

    public final boolean canOverrideExistingModule() {
        return this.canOverrideExistingModule;
    }

    public final boolean needsEagerInit() {
        return this.needsEagerInit;
    }

    public final boolean isCxxModule() {
        return this.isCxxModule;
    }

    public final boolean isTurboModule() {
        return this.isTurboModule;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor is deprecated and will be removed in the future. Use ReactModuleInfo(String, String, boolean, boolean, boolean, boolean)]", replaceWith = @ReplaceWith(expression = "ReactModuleInfo(name, className, canOverrideExistingModule, needsEagerInit, isCxxModule, isTurboModule)", imports = {}))
    public ReactModuleInfo(@NotNull String name, @NotNull String className, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(name, className, z, z2, z4, z5);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(className, "className");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean classIsTurboModule(@NotNull Class<?> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return TurboModule.class.isAssignableFrom(clazz);
        }
    }
}
