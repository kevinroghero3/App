package com.mrousavy.camera.core;

/* JADX INFO: loaded from: classes.dex */
public final class LocationPermissionError extends CameraError {
    public LocationPermissionError() {
        super("permission", "location-permission-denied", "The Location permission was denied! If you want to capture photos or videos without location tags, pass `enableLocation={false}`.", null, 8, null);
    }
}
