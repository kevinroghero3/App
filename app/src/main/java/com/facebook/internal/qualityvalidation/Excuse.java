package com.facebook.internal.qualityvalidation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({})
@kotlin.annotation.Target(allowedTargets = {})
@Retention(RetentionPolicy.SOURCE)
public @interface Excuse {
    String reason();

    String type();
}
