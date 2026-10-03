package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes4.dex */
public final class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m2522computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m2524computeFillWidthiLBOSCw(j, j2), m2521computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m2523computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m2524computeFillWidthiLBOSCw(j, j2), m2521computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m2524computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m997getWidthimpl(j2) / Size.m997getWidthimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m2521computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m994getHeightimpl(j2) / Size.m994getHeightimpl(j);
    }
}
