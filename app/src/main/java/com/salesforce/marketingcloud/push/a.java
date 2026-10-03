package com.salesforce.marketingcloud.push;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String url) {
        super(f.a.BAD_MEDIA, "Unable to load media " + url);
        Intrinsics.checkNotNullParameter(url, "url");
    }
}
