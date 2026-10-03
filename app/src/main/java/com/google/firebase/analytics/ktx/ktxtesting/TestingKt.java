package com.google.firebase.analytics.ktx.ktxtesting;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class TestingKt {
    public static final void withAnalyticsForTest(@NonNull FirebaseAnalytics analytics, @NonNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (AnalyticsKt.getLOCK()) {
            FirebaseAnalytics analytics2 = AnalyticsKt.getANALYTICS();
            AnalyticsKt.setANALYTICS(analytics);
            try {
                block.invoke();
                AnalyticsKt.setANALYTICS(analytics2);
            } catch (Throwable th) {
                AnalyticsKt.setANALYTICS(analytics2);
                throw th;
            }
        }
    }
}
