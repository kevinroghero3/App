package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheKeyUtil {
    public static final CacheKeyUtil INSTANCE = new CacheKeyUtil();

    private CacheKeyUtil() {
    }

    @JvmStatic
    public static final List<String> getResourceIds(@NotNull CacheKey key) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) key).getCacheKeys();
                Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                arrayList = new ArrayList(cacheKeys.size());
                int size = cacheKeys.size();
                for (int i = 0; i < size; i++) {
                    CacheKeyUtil cacheKeyUtil = INSTANCE;
                    CacheKey cacheKey = cacheKeys.get(i);
                    Intrinsics.checkNotNullExpressionValue(cacheKey, "get(...)");
                    arrayList.add(cacheKeyUtil.secureHashKey(cacheKey));
                }
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(key.isResourceIdForDebugging() ? key.getUriString() : INSTANCE.secureHashKey(key));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmStatic
    public static final String getFirstResourceId(@NotNull CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) key).getCacheKeys();
                Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                CacheKeyUtil cacheKeyUtil = INSTANCE;
                CacheKey cacheKey = cacheKeys.get(0);
                Intrinsics.checkNotNullExpressionValue(cacheKey, "get(...)");
                return cacheKeyUtil.secureHashKey(cacheKey);
            }
            return INSTANCE.secureHashKey(key);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private final String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        String uriString = cacheKey.getUriString();
        Intrinsics.checkNotNullExpressionValue(uriString, "getUriString(...)");
        Charset charsetForName = Charset.forName(CharEncoding.UTF_8);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = uriString.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strMakeSHA1HashBase64 = SecureHashUtil.makeSHA1HashBase64(bytes);
        Intrinsics.checkNotNullExpressionValue(strMakeSHA1HashBase64, "makeSHA1HashBase64(...)");
        return strMakeSHA1HashBase64;
    }
}
