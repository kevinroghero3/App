package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes.dex */
public interface ContentScale {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo2516computeScaleFactorH7hwNQA(long j, long j2);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                float fM2522computeFillMaxDimensioniLBOSCw = ContentScaleKt.m2522computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM2522computeFillMaxDimensioniLBOSCw, fM2522computeFillMaxDimensioniLBOSCw);
            }
        };
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                float fM2523computeFillMinDimensioniLBOSCw = ContentScaleKt.m2523computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM2523computeFillMinDimensioniLBOSCw, fM2523computeFillMinDimensioniLBOSCw);
            }
        };
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                float fM2521computeFillHeightiLBOSCw = ContentScaleKt.m2521computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM2521computeFillHeightiLBOSCw, fM2521computeFillHeightiLBOSCw);
            }
        };
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                float fM2524computeFillWidthiLBOSCw = ContentScaleKt.m2524computeFillWidthiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM2524computeFillWidthiLBOSCw, fM2524computeFillWidthiLBOSCw);
            }
        };
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                if (Size.m997getWidthimpl(j) > Size.m997getWidthimpl(j2) || Size.m994getHeightimpl(j) > Size.m994getHeightimpl(j2)) {
                    float fM2523computeFillMinDimensioniLBOSCw = ContentScaleKt.m2523computeFillMinDimensioniLBOSCw(j, j2);
                    return ScaleFactorKt.ScaleFactor(fM2523computeFillMinDimensioniLBOSCw, fM2523computeFillMinDimensioniLBOSCw);
                }
                return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
            }
        };
        private static final FixedScale None = new FixedScale(1.0f);
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2516computeScaleFactorH7hwNQA(long j, long j2) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m2524computeFillWidthiLBOSCw(j, j2), ContentScaleKt.m2521computeFillHeightiLBOSCw(j, j2));
            }
        };

        public static /* synthetic */ void getCrop$annotations() {
        }

        public static /* synthetic */ void getFillBounds$annotations() {
        }

        public static /* synthetic */ void getFillHeight$annotations() {
        }

        public static /* synthetic */ void getFillWidth$annotations() {
        }

        public static /* synthetic */ void getFit$annotations() {
        }

        public static /* synthetic */ void getInside$annotations() {
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        private Companion() {
        }

        public final ContentScale getCrop() {
            return Crop;
        }

        public final ContentScale getFit() {
            return Fit;
        }

        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        public final ContentScale getInside() {
            return Inside;
        }

        public final FixedScale getNone() {
            return None;
        }

        public final ContentScale getFillBounds() {
            return FillBounds;
        }
    }
}
