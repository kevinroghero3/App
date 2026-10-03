package com.salesforce.marketingcloud.sfmcsdk.components.logging;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SFMCSdkLogger extends Logger {
    public static final SFMCSdkLogger INSTANCE = new SFMCSdkLogger();

    private SFMCSdkLogger() {
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void d(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        d(tag, null, lazyMsg);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void d(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.DEBUG, tag, th, lazyMsg);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void w(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        w(tag, null, lazyMsg);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void w(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.WARN, tag, th, lazyMsg);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void e(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        e(tag, null, lazyMsg);
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.logging.Logger
    public void e(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.ERROR, tag, th, lazyMsg);
    }
}
