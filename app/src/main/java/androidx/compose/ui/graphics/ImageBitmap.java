package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ImageBitmap {
    public static final Companion Companion = Companion.$$INSTANCE;

    ColorSpace getColorSpace();

    /* JADX INFO: renamed from: getConfig-_sVssgQ */
    int mo1036getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(@NotNull int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ void readPixels$default(ImageBitmap imageBitmap, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
        }
        int i8 = (i7 & 2) != 0 ? 0 : i;
        int i9 = (i7 & 4) != 0 ? 0 : i2;
        int width = (i7 & 8) != 0 ? imageBitmap.getWidth() : i3;
        imageBitmap.readPixels(iArr, i8, i9, width, (i7 & 16) != 0 ? imageBitmap.getHeight() : i4, (i7 & 32) == 0 ? i5 : 0, (i7 & 64) != 0 ? width : i6);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
