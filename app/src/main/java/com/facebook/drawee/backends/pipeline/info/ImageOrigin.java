package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ImageOrigin {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISK = 3;
    public static final int LOCAL = 7;
    public static final int MEMORY_BITMAP = 5;
    public static final int MEMORY_BITMAP_SHORTCUT = 6;
    public static final int MEMORY_ENCODED = 4;
    public static final int NETWORK = 2;
    public static final int UNKNOWN = 1;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISK = 3;
        public static final int LOCAL = 7;
        public static final int MEMORY_BITMAP = 5;
        public static final int MEMORY_BITMAP_SHORTCUT = 6;
        public static final int MEMORY_ENCODED = 4;
        public static final int NETWORK = 2;
        public static final int UNKNOWN = 1;

        private Companion() {
        }
    }
}
