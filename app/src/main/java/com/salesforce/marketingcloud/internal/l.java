package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Region a(@NotNull LatLon center, int i) {
            Intrinsics.checkNotNullParameter(center, "center");
            return Region.Companion.magicFence$sdk_release(center, i);
        }

        private a() {
        }

        @JvmStatic
        public final boolean a(@NotNull Region region) {
            Intrinsics.checkNotNullParameter(region, "region");
            return region.isInside$sdk_release();
        }

        @JvmStatic
        public final void a(@NotNull Region region, boolean z) {
            Intrinsics.checkNotNullParameter(region, "region");
            region.setInside$sdk_release(z);
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull Region region) {
        return a.a(region);
    }

    @JvmStatic
    public static final Region a(@NotNull LatLon latLon, int i) {
        return a.a(latLon, i);
    }

    @JvmStatic
    public static final void a(@NotNull Region region, boolean z) {
        a.a(region, z);
    }
}
