package com.mrousavy.camera.react.utils;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class CallbackPromiseKt {
    private static final ReadableMap makeErrorCauseMap(Throwable th) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("message", th.getMessage());
        writableMapCreateMap.putString("stacktrace", ExceptionsKt__ExceptionsKt.stackTraceToString(th));
        if (th.getCause() != null) {
            Throwable cause = th.getCause();
            Intrinsics.checkNotNull(cause);
            writableMapCreateMap.putMap("cause", makeErrorCauseMap(cause));
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    public static /* synthetic */ ReadableMap makeErrorMap$default(String str, String str2, Throwable th, WritableMap writableMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        if ((i & 8) != 0) {
            writableMap = null;
        }
        return makeErrorMap(str, str2, th, writableMap);
    }

    public static final ReadableMap makeErrorMap(@Nullable String str, @Nullable String str2, @Nullable Throwable th, @Nullable WritableMap writableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(ResponseTypeValues.CODE, str);
        writableMapCreateMap.putString("message", str2);
        writableMapCreateMap.putMap("cause", th != null ? makeErrorCauseMap(th) : null);
        writableMapCreateMap.putMap("userInfo", writableMap);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
