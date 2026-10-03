package com.facebook.imagepipeline.memory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface BitmapPoolType {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DEFAULT = "legacy";
    public static final String DUMMY = "dummy";
    public static final String DUMMY_WITH_TRACKING = "dummy_with_tracking";
    public static final String EXPERIMENTAL = "experimental";
    public static final String LEGACY = "legacy";
    public static final String LEGACY_DEFAULT_PARAMS = "legacy_default_params";

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEFAULT = "legacy";
        public static final String DUMMY = "dummy";
        public static final String DUMMY_WITH_TRACKING = "dummy_with_tracking";
        public static final String EXPERIMENTAL = "experimental";
        public static final String LEGACY = "legacy";
        public static final String LEGACY_DEFAULT_PARAMS = "legacy_default_params";

        private Companion() {
        }
    }
}
