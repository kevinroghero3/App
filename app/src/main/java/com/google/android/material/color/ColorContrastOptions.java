package com.google.android.material.color;

import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes5.dex */
public class ColorContrastOptions {
    private final int highContrastThemeOverlayResourceId;
    private final int mediumContrastThemeOverlayResourceId;

    private ColorContrastOptions(Builder builder) {
        this.mediumContrastThemeOverlayResourceId = builder.mediumContrastThemeOverlayResourceId;
        this.highContrastThemeOverlayResourceId = builder.highContrastThemeOverlayResourceId;
    }

    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }

    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    public static class Builder {
        private int highContrastThemeOverlayResourceId;
        private int mediumContrastThemeOverlayResourceId;

        public Builder setMediumContrastThemeOverlay(@StyleRes int i) {
            this.mediumContrastThemeOverlayResourceId = i;
            return this;
        }

        public Builder setHighContrastThemeOverlay(@StyleRes int i) {
            this.highContrastThemeOverlayResourceId = i;
            return this;
        }

        public ColorContrastOptions build() {
            return new ColorContrastOptions(this);
        }
    }
}
