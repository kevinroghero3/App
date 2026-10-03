package com.google.android.play.core.review;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    public static ReviewManager create(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new zzd(new zzi(context));
    }
}
