package com.facebook.fresco.vito.renderer.util;

import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ColorUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int multiplyColorAlpha(int i, int i2) {
            if (i2 == 0) {
                return i & ViewCompat.MEASURED_SIZE_MASK;
            }
            if (i2 == 255) {
                return i;
            }
            return ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24) | (16777215 & i);
        }

        private Companion() {
        }
    }
}
