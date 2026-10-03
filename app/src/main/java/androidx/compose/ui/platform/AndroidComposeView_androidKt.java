package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor = new Function1<PlatformTextInputService, PlatformTextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        public final PlatformTextInputService invoke(@NotNull PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    public static final void setPlatformTextInputServiceInterceptor(@NotNull Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> function1) {
        platformTextInputServiceInterceptor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m2863preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM2862dotp89u6pk = m2862dotp89u6pk(fArr2, 0, fArr, 0);
        float fM2862dotp89u6pk2 = m2862dotp89u6pk(fArr2, 0, fArr, 1);
        float fM2862dotp89u6pk3 = m2862dotp89u6pk(fArr2, 0, fArr, 2);
        float fM2862dotp89u6pk4 = m2862dotp89u6pk(fArr2, 0, fArr, 3);
        float fM2862dotp89u6pk5 = m2862dotp89u6pk(fArr2, 1, fArr, 0);
        float fM2862dotp89u6pk6 = m2862dotp89u6pk(fArr2, 1, fArr, 1);
        float fM2862dotp89u6pk7 = m2862dotp89u6pk(fArr2, 1, fArr, 2);
        float fM2862dotp89u6pk8 = m2862dotp89u6pk(fArr2, 1, fArr, 3);
        float fM2862dotp89u6pk9 = m2862dotp89u6pk(fArr2, 2, fArr, 0);
        float fM2862dotp89u6pk10 = m2862dotp89u6pk(fArr2, 2, fArr, 1);
        float fM2862dotp89u6pk11 = m2862dotp89u6pk(fArr2, 2, fArr, 2);
        float fM2862dotp89u6pk12 = m2862dotp89u6pk(fArr2, 2, fArr, 3);
        float fM2862dotp89u6pk13 = m2862dotp89u6pk(fArr2, 3, fArr, 0);
        float fM2862dotp89u6pk14 = m2862dotp89u6pk(fArr2, 3, fArr, 1);
        float fM2862dotp89u6pk15 = m2862dotp89u6pk(fArr2, 3, fArr, 2);
        float fM2862dotp89u6pk16 = m2862dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM2862dotp89u6pk;
        fArr[1] = fM2862dotp89u6pk2;
        fArr[2] = fM2862dotp89u6pk3;
        fArr[3] = fM2862dotp89u6pk4;
        fArr[4] = fM2862dotp89u6pk5;
        fArr[5] = fM2862dotp89u6pk6;
        fArr[6] = fM2862dotp89u6pk7;
        fArr[7] = fM2862dotp89u6pk8;
        fArr[8] = fM2862dotp89u6pk9;
        fArr[9] = fM2862dotp89u6pk10;
        fArr[10] = fM2862dotp89u6pk11;
        fArr[11] = fM2862dotp89u6pk12;
        fArr[12] = fM2862dotp89u6pk13;
        fArr[13] = fM2862dotp89u6pk14;
        fArr[14] = fM2862dotp89u6pk15;
        fArr[15] = fM2862dotp89u6pk16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    public static final void m2864preTranslatecG2Xzmc(float[] fArr, float f, float f2, float[] fArr2) {
        Matrix.m1410resetimpl(fArr2);
        Matrix.m1421translateimpl$default(fArr2, f, f2, 0.0f, 4, null);
        m2863preTransformJiSxe2E(fArr, fArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        if (Intrinsics.areEqual(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view) {
        ViewCompatShims.setImportantForContentCapture(view, 1);
        return ViewCompatShims.getContentCaptureSession(view);
    }

    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m2862dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3] * fArr2[i2]) + (fArr[i3 + 1] * fArr2[i2 + 4]) + (fArr[i3 + 2] * fArr2[i2 + 8]) + (fArr[i3 + 3] * fArr2[i2 + 12]);
    }
}
