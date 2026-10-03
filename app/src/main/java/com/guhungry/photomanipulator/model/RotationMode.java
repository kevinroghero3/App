package com.guhungry.photomanipulator.model;

/* JADX INFO: loaded from: classes.dex */
public enum RotationMode {
    None(0.0f),
    R90(90.0f),
    R180(180.0f),
    R270(270.0f);

    private final float degrees;

    RotationMode(float f) {
        this.degrees = f;
    }

    public final float getDegrees() {
        return this.degrees;
    }
}
