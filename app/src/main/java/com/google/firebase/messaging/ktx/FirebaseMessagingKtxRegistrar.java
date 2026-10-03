package com.google.firebase.messaging.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Migrate to use the KTX API from the main module: https://firebase.google.com/docs/android/kotlin-migration.", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class FirebaseMessagingKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
