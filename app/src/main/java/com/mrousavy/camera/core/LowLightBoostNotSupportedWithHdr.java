package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes3.dex */
public final class LowLightBoostNotSupportedWithHdr extends CameraError {
    public LowLightBoostNotSupportedWithHdr() {
        super("format", "low-light-boost-not-supported-with-hdr", "The low light boost extension does not work when HDR is enabled! Disable either `lowLightBoost` or `videoHdr`/`photoHdr`.", null, 8, null);
    }
}
