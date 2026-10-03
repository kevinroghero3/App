package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConfigFactory;
import com.facebook.yoga.YogaErrata;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactYogaConfigProvider {
    public static final ReactYogaConfigProvider INSTANCE = new ReactYogaConfigProvider();
    private static final Lazy yogaConfig$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.facebook.react.uimanager.ReactYogaConfigProvider$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ReactYogaConfigProvider.yogaConfig_delegate$lambda$0();
        }
    });

    private ReactYogaConfigProvider() {
    }

    private final YogaConfig getYogaConfig() {
        Object value = yogaConfig$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (YogaConfig) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YogaConfig yogaConfig_delegate$lambda$0() {
        YogaConfig yogaConfigCreate = YogaConfigFactory.create();
        yogaConfigCreate.setPointScaleFactor(0.0f);
        yogaConfigCreate.setErrata(YogaErrata.ALL);
        return yogaConfigCreate;
    }

    @JvmStatic
    public static final YogaConfig get() {
        return INSTANCE.getYogaConfig();
    }
}
