package com.salesforce.marketingcloud.sfmcsdk.components.http;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public final class RequestKt {
    private static final Charset UTF_8;

    static {
        Charset charsetForName = Charset.forName(CharEncoding.UTF_8);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        UTF_8 = charsetForName;
    }

    public static final Charset getUTF_8() {
        return UTF_8;
    }
}
