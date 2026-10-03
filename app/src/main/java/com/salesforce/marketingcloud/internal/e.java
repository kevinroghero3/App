package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.InitializationStatus;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final a a = new a(null);

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final InitializationStatus a() {
            return InitializationStatus.Companion.a();
        }

        @JvmStatic
        public final InitializationStatus.a b() {
            return InitializationStatus.Companion.b();
        }

        @JvmStatic
        public final InitializationStatus c() {
            return InitializationStatus.Companion.c();
        }

        private a() {
        }
    }

    @JvmStatic
    public static final InitializationStatus a() {
        return a.a();
    }

    @JvmStatic
    public static final InitializationStatus.a b() {
        return a.b();
    }

    @JvmStatic
    public static final InitializationStatus c() {
        return a.c();
    }
}
