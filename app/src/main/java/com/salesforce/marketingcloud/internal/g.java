package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.MarketingCloudConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final a a = new a(null);

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull MarketingCloudConfig self, @NotNull MarketingCloudConfig other) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(other, "other");
            return self.applicationChanged$sdk_release(other);
        }

        private a() {
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull MarketingCloudConfig marketingCloudConfig, @NotNull MarketingCloudConfig marketingCloudConfig2) {
        return a.a(marketingCloudConfig, marketingCloudConfig2);
    }
}
