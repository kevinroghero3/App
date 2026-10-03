package com.intentfilter.androidpermissions.helpers;

import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes3.dex */
public class VersionOrchestrator {
    public static int getImmutablePendingIntentFlags(int... iArr) {
        int i = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }
}
