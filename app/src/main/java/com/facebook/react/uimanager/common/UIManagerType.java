package com.facebook.react.uimanager.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface UIManagerType {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DEFAULT = 1;
    public static final int FABRIC = 2;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT = 1;
        public static final int FABRIC = 2;

        private Companion() {
        }
    }
}
