package com.mrousavy.camera.core.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public final class ImageFormatUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String imageFormatToString(int i) {
            if (i == 3) {
                return "RGB_888";
            }
            if (i == 4) {
                return "RGB_565";
            }
            if (i == 16) {
                return "NV16";
            }
            if (i == 17) {
                return "NV21";
            }
            if (i == 20) {
                return "YUY2";
            }
            if (i == 54) {
                return "YCBCR_P010";
            }
            if (i == 256) {
                return "JPEG";
            }
            if (i == 538982489) {
                return "Y8";
            }
            if (i == 842094169) {
                return "YV12";
            }
            if (i == 34) {
                return "PRIVATE";
            }
            if (i == 35) {
                return "YUV_420_888";
            }
            switch (i) {
                case 39:
                    return "YUV_422_888";
                case 40:
                    return "YUV_444_888";
                case 41:
                    return "FLEX_RGB_888";
                case 42:
                    return "FLEX_RGBA_8888";
                default:
                    return "UNKNOWN (" + i + ")";
            }
        }
    }
}
