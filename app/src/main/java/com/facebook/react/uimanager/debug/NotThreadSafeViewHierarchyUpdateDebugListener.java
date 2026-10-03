package com.facebook.react.uimanager.debug;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "NotThreadSafeViewHierarchyUpdateDebugListener will be deleted in the new architecture.")
public interface NotThreadSafeViewHierarchyUpdateDebugListener {
    void onViewHierarchyUpdateEnqueued();

    void onViewHierarchyUpdateFinished();
}
