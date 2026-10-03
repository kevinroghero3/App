package com.facebook.share;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Sharer {
    boolean getShouldFailOnDataError();

    void setShouldFailOnDataError(boolean z);

    public static final class Result {
        private final String postId;

        public Result(@Nullable String str) {
            this.postId = str;
        }

        public final String getPostId() {
            return this.postId;
        }
    }
}
