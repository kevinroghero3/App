package com.google.firebase.installations;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseInstallations, "getInstance()");
        return firebaseInstallations;
    }

    public static final FirebaseInstallations installations(@NotNull Firebase firebase2, @NotNull FirebaseApp app2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app2, "app");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance(app2);
        Intrinsics.checkNotNullExpressionValue(firebaseInstallations, "getInstance(app)");
        return firebaseInstallations;
    }
}
