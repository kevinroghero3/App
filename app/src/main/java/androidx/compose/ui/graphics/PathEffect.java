package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface PathEffect {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final PathEffect cornerPathEffect(float f) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(f);
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion companion, float[] fArr, float f, int i, Object obj) {
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            return companion.dashPathEffect(fArr, f);
        }

        public final PathEffect dashPathEffect(@NotNull float[] fArr, float f) {
            return AndroidPathEffect_androidKt.actualDashPathEffect(fArr, f);
        }

        public final PathEffect chainPathEffect(@NotNull PathEffect pathEffect, @NotNull PathEffect pathEffect2) {
            return AndroidPathEffect_androidKt.actualChainPathEffect(pathEffect, pathEffect2);
        }

        /* JADX INFO: renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m1444stampedPathEffect7aD1DOk(@NotNull Path path, float f, float f2, int i) {
            return AndroidPathEffect_androidKt.m1065actualStampedPathEffect7aD1DOk(path, f, f2, i);
        }
    }
}
