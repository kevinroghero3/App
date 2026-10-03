package okhttp3.internal.http;

import com.google.firebase.perf.FirebasePerformance;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public final boolean invalidatesCache(@NotNull String method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        return Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, "PATCH") || Intrinsics.areEqual(method, "PUT") || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.DELETE) || Intrinsics.areEqual(method, "MOVE");
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        return Intrinsics.areEqual(method, "POST") || Intrinsics.areEqual(method, "PUT") || Intrinsics.areEqual(method, "PATCH") || Intrinsics.areEqual(method, "PROPPATCH") || Intrinsics.areEqual(method, "REPORT");
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        return (Intrinsics.areEqual(method, "GET") || Intrinsics.areEqual(method, FirebasePerformance.HttpMethod.HEAD)) ? false : true;
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        return Intrinsics.areEqual(method, "PROPFIND");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        return !Intrinsics.areEqual(method, "PROPFIND");
    }
}
