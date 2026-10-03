package com.salesforce.marketingcloud.http;

import android.os.Bundle;
import android.os.Parcel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a a = new a();
    private static final String b = "HttpUtils";
    private static final int c = 921600;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.http.a$a, reason: collision with other inner class name */
    static final class C0076a extends Lambda implements Function0<String> {
        public static final C0076a b = new C0076a();

        C0076a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to estimate size for request or response";
        }
    }

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Request or response too large. Request size: " + this.b + " bytes, Response size: " + this.c + " bytes";
        }
    }

    static final class c extends Lambda implements Function0<String> {
        public static final c b = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to estimate size";
        }
    }

    private a() {
    }

    public final int a(@NotNull g sizeEstimatable) {
        Intrinsics.checkNotNullParameter(sizeEstimatable, "sizeEstimatable");
        try {
            Bundle bundleH = sizeEstimatable.h();
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
            bundleH.writeToParcel(parcelObtain, 0);
            int iDataSize = parcelObtain.dataSize();
            parcelObtain.recycle();
            return iDataSize;
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.a.b(b, e, c.b);
            return -1;
        }
    }

    @JvmStatic
    public static final boolean a(@NotNull g request, @NotNull g response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        a aVar = a;
        int iA = aVar.a(request);
        int iA2 = aVar.a(response);
        if (iA == -1 || iA2 == -1) {
            com.salesforce.marketingcloud.g.b(com.salesforce.marketingcloud.g.a, b, null, C0076a.b, 2, null);
            return false;
        }
        if (iA + iA2 < c) {
            return true;
        }
        com.salesforce.marketingcloud.g.b(com.salesforce.marketingcloud.g.a, b, null, new b(iA, iA2), 2, null);
        return false;
    }
}
