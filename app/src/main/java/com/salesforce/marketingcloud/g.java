package com.salesforce.marketingcloud;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static final int b = 23;
    private static String c;
    private static String d;
    private static String e;
    private static MCLogListener g;
    public static final g a = new g();
    private static int f = 6;

    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class d extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ Function0<String> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Function0<String> function0) {
            super(0);
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String strInvoke = this.b.invoke();
            return ((Object) strInvoke) + " - Sdk Version: " + MarketingCloudSdk.getSdkVersionName();
        }
    }

    static final class f extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.g$g, reason: collision with other inner class name */
    static final class C0075g extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0075g(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class h extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class i extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class j extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    static final class k extends Lambda implements Function0<String> {
        final /* synthetic */ String b;
        final /* synthetic */ Object[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, Object[] objArr) {
            super(0);
            this.b = str;
            this.c = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            g gVar = g.a;
            String str = this.b;
            Object[] objArr = this.c;
            return gVar.a(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    private g() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void c(@NotNull String tag, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        c(a, tag, null, new f(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        d(a, tag, null, new h(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        e(a, tag, null, new j(msg, args), 2, null);
    }

    public final int b() {
        return f;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void b(@NotNull String tag, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        b(a, tag, null, new c(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void c(@NotNull String tag, @NotNull Throwable throwable, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a.c(tag, throwable, new C0075g(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull Throwable throwable, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a.d(tag, throwable, new i(msg, args));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull Throwable throwable, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a.e(tag, throwable, new k(msg, args));
    }

    public final void a(int i2) {
        f = i2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void b(@NotNull String tag, @NotNull Throwable throwable, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a.b(tag, throwable, new d(msg, args));
    }

    public static /* synthetic */ void c(g gVar, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        gVar.c(str, th, (Function0<String>) function0);
    }

    public static /* synthetic */ void d(g gVar, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        gVar.d(str, th, (Function0<String>) function0);
    }

    public static /* synthetic */ void e(g gVar, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        gVar.e(str, th, (Function0<String>) function0);
    }

    public final MCLogListener a() {
        return g;
    }

    public static /* synthetic */ void b(g gVar, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        gVar.b(str, th, (Function0<String>) function0);
    }

    public final void a(@Nullable MCLogListener mCLogListener) {
        g = mCLogListener;
    }

    public final void c(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        a(4, tag, th, lazyMsg);
    }

    public final void d(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        a(2, tag, th, lazyMsg);
    }

    public final void e(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        a(5, tag, th, lazyMsg);
    }

    @JvmStatic
    public static final String a(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return a.c(tag);
    }

    private final String c(String str) {
        if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "~!", false, 2, (Object) null)) {
            str = "~!" + str;
        }
        return str.length() <= 23 ? str : str.subSequence(0, 23).toString();
    }

    public final void b(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        a(6, tag, th, new e(lazyMsg));
    }

    @JvmStatic
    public static final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c = str;
        d = str2;
        e = str3;
    }

    private final String b(String str) {
        String strReplace$default;
        String strReplace$default2;
        String strReplace$default3;
        if (TextUtils.getTrimmedLength(str) == 0) {
            return "Log message was empty";
        }
        String str2 = c;
        if (str2 != null && (strReplace$default3 = StringsKt__StringsJVMKt.replace$default(str, str2, "████████-████-████-████-████████████", false, 4, (Object) null)) != null) {
            str = strReplace$default3;
        }
        String str3 = d;
        if (str3 != null && (strReplace$default2 = StringsKt__StringsJVMKt.replace$default(str, str3, "███████████████████████", false, 4, (Object) null)) != null) {
            str = strReplace$default2;
        }
        String str4 = e;
        return (str4 == null || (strReplace$default = StringsKt__StringsJVMKt.replace$default(str, str4, "████████", false, 4, (Object) null)) == null) ? str : strReplace$default;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void a(@NotNull String tag, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a(a, tag, null, new a(msg, args), 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Do not use from Kotlin")
    @JvmStatic
    public static final void a(@NotNull String tag, @NotNull Throwable throwable, @NotNull String msg, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(args, "args");
        a.a(tag, throwable, new b(msg, args));
    }

    public static /* synthetic */ void a(g gVar, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        gVar.a(str, th, (Function0<String>) function0);
    }

    public final void a(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        a(3, tag, th, lazyMsg);
    }

    private final void a(int i2, String str, Throwable th, Function0<String> function0) {
        MCLogListener mCLogListener = g;
        if (mCLogListener == null || i2 < f) {
            return;
        }
        try {
            mCLogListener.out(i2, c(str), b(function0.invoke()), th);
        } catch (Exception e2) {
            Log.e("~!Logger", "Exception was thrown by " + mCLogListener.getClass().getName(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str, Object... objArr) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }
}
