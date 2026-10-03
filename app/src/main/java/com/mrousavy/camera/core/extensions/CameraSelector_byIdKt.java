package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CameraSelector_byIdKt {
    public static final CameraSelector.Builder byId(@NotNull CameraSelector.Builder builder, @NotNull final String id) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        CameraSelector.Builder builderAddCameraFilter = builder.addCameraFilter(new CameraFilter() { // from class: com.mrousavy.camera.core.extensions.CameraSelector_byIdKt$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                return CameraSelector_byIdKt.byId$lambda$1(id, list);
            }
        });
        Intrinsics.checkNotNullExpressionValue(builderAddCameraFilter, "addCameraFilter(...)");
        return builderAddCameraFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List byId$lambda$1(String str, List cameraInfos) {
        Intrinsics.checkNotNullParameter(cameraInfos, "cameraInfos");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cameraInfos) {
            CameraInfo cameraInfo = (CameraInfo) obj;
            Intrinsics.checkNotNull(cameraInfo);
            if (Intrinsics.areEqual(CameraInfo_idKt.getId(cameraInfo), str)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }
}
