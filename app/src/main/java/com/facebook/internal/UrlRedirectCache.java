package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    private UrlRedirectCache() {
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = simpleName + "_Redirect";
    }

    @JvmStatic
    public static final FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x007b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:24:0x007b */
    @JvmStatic
    public static final Uri getRedirectedUri(@Nullable Uri uri) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        InputStreamReader inputStreamReader4 = null;
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(string);
        try {
            try {
                FileLruCache cache = getCache();
                InputStream inputStream = cache.get(string, redirectContentTag);
                inputStreamReader3 = null;
                boolean z = false;
                while (inputStream != null) {
                    try {
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            char[] cArr = new char[128];
                            StringBuilder sb = new StringBuilder();
                            for (int i = inputStreamReader.read(cArr, 0, 128); i > 0; i = inputStreamReader.read(cArr, 0, 128)) {
                                sb.append(cArr, 0, i);
                            }
                            Utility.closeQuietly(inputStreamReader);
                            String string2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "urlBuilder.toString()");
                            if (hashSet.contains(string2)) {
                                if (Intrinsics.areEqual(string2, string)) {
                                    inputStreamReader3 = inputStreamReader;
                                    z = true;
                                    break;
                                }
                                Logger.Companion.log(LoggingBehavior.CACHE, 6, tag, "A loop detected in UrlRedirectCache");
                                Utility.closeQuietly(inputStreamReader);
                                return null;
                            }
                            hashSet.add(string2);
                            inputStreamReader3 = inputStreamReader;
                            z = true;
                            inputStream = cache.get(string2, redirectContentTag);
                            string = string2;
                        } catch (IOException e) {
                            e = e;
                            Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
                            inputStreamReader3 = inputStreamReader;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        inputStreamReader = inputStreamReader3;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader4 = inputStreamReader3;
                        Utility.closeQuietly(inputStreamReader4);
                        throw th;
                    }
                }
                if (z) {
                    Uri uri2 = Uri.parse(string);
                    Utility.closeQuietly(inputStreamReader3);
                    return uri2;
                }
            } catch (IOException e3) {
                e = e3;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
            Utility.closeQuietly(inputStreamReader3);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader4 = inputStreamReader2;
        }
    }

    @JvmStatic
    public static final void cacheUriRedirect(@Nullable Uri uri, @Nullable Uri uri2) {
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStreamOpenPutStream = null;
        try {
            try {
                FileLruCache cache = getCache();
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "fromUri.toString()");
                outputStreamOpenPutStream = cache.openPutStream(string, redirectContentTag);
                String string2 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toUri.toString()");
                byte[] bytes = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStreamOpenPutStream.write(bytes);
            } catch (IOException e) {
                Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
            }
        } finally {
            Utility.closeQuietly(outputStreamOpenPutStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, tag, "clearCache failed " + e.getMessage());
        }
    }
}
