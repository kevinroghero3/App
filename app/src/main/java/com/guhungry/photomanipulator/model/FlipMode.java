package com.guhungry.photomanipulator.model;

/* JADX INFO: loaded from: classes.dex */
public enum FlipMode {
    Both(-1.0f, -1.0f),
    Horizontal(-1.0f, 1.0f),
    None(0.0f, 0.0f),
    Vertical(1.0f, -1.0f);

    private final float scaleX;
    private final float scaleY;

    FlipMode(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }
}
