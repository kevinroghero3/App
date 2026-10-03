package com.salesforce.marketingcloud.sfmcsdk;

import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.modules.Config;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModuleConfig;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleConfig;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SFMCSdkModuleConfig {
    public static final Companion Companion = new Companion(null);
    private final CdpModuleConfig cdpModuleConfig;
    private List<? extends Config> configs;
    private final PushModuleConfig pushModuleConfig;

    public /* synthetic */ SFMCSdkModuleConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final SFMCSdkModuleConfig build(@NotNull Function1<? super Builder, Unit> function1) {
        return Companion.build(function1);
    }

    private SFMCSdkModuleConfig(PushModuleConfig pushModuleConfig, CdpModuleConfig cdpModuleConfig) {
        this.pushModuleConfig = pushModuleConfig;
        this.cdpModuleConfig = cdpModuleConfig;
        this.configs = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Config[]{pushModuleConfig, cdpModuleConfig});
    }

    public final PushModuleConfig getPushModuleConfig() {
        return this.pushModuleConfig;
    }

    public final CdpModuleConfig getCdpModuleConfig() {
        return this.cdpModuleConfig;
    }

    public final List<Config> getConfigs$sfmcsdk_release() {
        return this.configs;
    }

    public final void setConfigs$sfmcsdk_release(@NotNull List<? extends Config> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.configs = list;
    }

    private SFMCSdkModuleConfig(Builder builder) {
        this(builder.getPushModuleConfig(), builder.getCdpModuleConfig());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SFMCSdkModuleConfig build(@NotNull Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        private static final String TAG = "~$SFMCSdkModuleConfig.Builder";
        private CdpModuleConfig cdpModuleConfig;
        private PushModuleConfig pushModuleConfig;

        public final PushModuleConfig getPushModuleConfig() {
            return this.pushModuleConfig;
        }

        public final void setPushModuleConfig(@Nullable final PushModuleConfig pushModuleConfig) {
            if (pushModuleConfig == null || !pushModuleConfig.isModuleCompatible()) {
                SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkModuleConfig$Builder$pushModuleConfig$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "isModuleCompatible returned false. Config '" + pushModuleConfig + "' will not be applied.";
                    }
                });
                pushModuleConfig = null;
            }
            this.pushModuleConfig = pushModuleConfig;
        }

        public final CdpModuleConfig getCdpModuleConfig() {
            return this.cdpModuleConfig;
        }

        public final void setCdpModuleConfig(@Nullable final CdpModuleConfig cdpModuleConfig) {
            if (cdpModuleConfig == null || !cdpModuleConfig.isModuleCompatible()) {
                SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkModuleConfig$Builder$cdpModuleConfig$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "isModuleCompatible returned false. Config '" + cdpModuleConfig + "' will not be applied.";
                    }
                });
                cdpModuleConfig = null;
            }
            this.cdpModuleConfig = cdpModuleConfig;
        }

        public final SFMCSdkModuleConfig build() {
            return new SFMCSdkModuleConfig(this, (DefaultConstructorMarker) null);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
