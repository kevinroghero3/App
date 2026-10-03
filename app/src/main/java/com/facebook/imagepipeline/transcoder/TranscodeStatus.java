package com.facebook.imagepipeline.transcoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface TranscodeStatus {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int TRANSCODING_ERROR = 2;
    public static final int TRANSCODING_NO_RESIZING = 1;
    public static final int TRANSCODING_SUCCESS = 0;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TRANSCODING_ERROR = 2;
        public static final int TRANSCODING_NO_RESIZING = 1;
        public static final int TRANSCODING_SUCCESS = 0;

        private Companion() {
        }
    }
}
