package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(@NotNull CookieHandler cookieHandler) {
        Intrinsics.checkParameterIsNotNull(cookieHandler, "cookieHandler");
        this.cookieHandler = cookieHandler;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(cookies, "cookies");
        ArrayList arrayList = new ArrayList();
        Iterator<Cookie> it2 = cookies.iterator();
        while (it2.hasNext()) {
            arrayList.add(Internal.cookieToString(it2.next(), true));
        }
        try {
            this.cookieHandler.put(url.uri(), MapsKt__MapsJVMKt.mapOf(TuplesKt.to(HttpHeaders.SET_COOKIE, arrayList)));
        } catch (IOException e) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb = new StringBuilder();
            sb.append("Saving cookies failed for ");
            HttpUrl httpUrlResolve = url.resolve("/...");
            if (httpUrlResolve == null) {
                Intrinsics.throwNpe();
            }
            sb.append(httpUrlResolve);
            platform.log(sb.toString(), 5, e);
        }
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        try {
            Map<String, List<String>> cookieHeaders = this.cookieHandler.get(url.uri(), MapsKt__MapsKt.emptyMap());
            Intrinsics.checkExpressionValueIsNotNull(cookieHeaders, "cookieHeaders");
            ArrayList arrayList = null;
            for (Map.Entry<String, List<String>> entry : cookieHeaders.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (StringsKt__StringsJVMKt.equals("Cookie", key, true) || StringsKt__StringsJVMKt.equals("Cookie2", key, true)) {
                    Intrinsics.checkExpressionValueIsNotNull(value, "value");
                    if (!value.isEmpty()) {
                        for (String header : value) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            Intrinsics.checkExpressionValueIsNotNull(header, "header");
                            arrayList.addAll(decodeHeaderAsJavaNetCookies(url, header));
                        }
                    }
                }
            }
            if (arrayList != null) {
                List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
                return listUnmodifiableList;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        } catch (IOException e) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading cookies failed for ");
            HttpUrl httpUrlResolve = url.resolve("/...");
            if (httpUrlResolve == null) {
                Intrinsics.throwNpe();
            }
            sb.append(httpUrlResolve);
            platform.log(sb.toString(), 5, e);
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    private final List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int iDelimiterOffset = Util.delimiterOffset(str, ";,", i, length);
            int iDelimiterOffset2 = Util.delimiterOffset(str, '=', i, iDelimiterOffset);
            String strTrimSubstring = Util.trimSubstring(str, i, iDelimiterOffset2);
            if (!StringsKt__StringsJVMKt.startsWith$default(strTrimSubstring, "$", false, 2, null)) {
                if (iDelimiterOffset2 < iDelimiterOffset) {
                    strSubstring = Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset);
                } else {
                    strSubstring = "";
                }
                if (StringsKt__StringsJVMKt.startsWith$default(strSubstring, "\"", false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(strSubstring, "\"", false, 2, null)) {
                    strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                    Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(new Cookie.Builder().name(strTrimSubstring).value(strSubstring).domain(httpUrl.host()).build());
            }
            i = iDelimiterOffset + 1;
        }
        return arrayList;
    }
}
