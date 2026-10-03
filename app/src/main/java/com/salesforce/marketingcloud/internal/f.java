package com.salesforce.marketingcloud.internal;

import com.salesforce.marketingcloud.MCLogListener;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final a a = new a(null);

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@Nullable MCLogListener mCLogListener) {
            com.salesforce.marketingcloud.g.a.a(mCLogListener);
        }

        private a() {
        }

        @JvmStatic
        public final int a() {
            return com.salesforce.marketingcloud.g.a.b();
        }

        @JvmStatic
        public final void a(int i) {
            com.salesforce.marketingcloud.g.a.a(i);
        }

        @JvmStatic
        public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            com.salesforce.marketingcloud.g.a(str, str2, str3);
        }
    }

    @JvmStatic
    public static final int a() {
        return a.a();
    }

    @JvmStatic
    public static final void a(int i) {
        a.a(i);
    }

    @JvmStatic
    public static final void a(@Nullable MCLogListener mCLogListener) {
        a.a(mCLogListener);
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        a.a(str, str2, str3);
    }
}
