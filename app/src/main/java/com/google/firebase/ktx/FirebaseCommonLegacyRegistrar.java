package com.google.firebase.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return CollectionsKt__CollectionsJVMKt.listOf(LibraryVersionComponent.create(LoggingKt.LIBRARY_NAME, com.google.firebase.BuildConfig.VERSION_NAME));
    }
}
