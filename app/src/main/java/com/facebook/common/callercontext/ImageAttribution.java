package com.facebook.common.callercontext;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ImageAttribution {
    String getCallingClassName();

    @Nullable
    ContextChain getContextChain();
}
