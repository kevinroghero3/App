package com.google.firebase.installations.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "com.google.firebase.installations.FirebaseInstallationsKtxRegistrar has been deprecated. Use `com.google.firebase.installationsFirebaseInstallationsKtxRegistrar` instead.", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class FirebaseInstallationsKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
