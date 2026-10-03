package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public final class ToneDeltaPair {
    private final double delta;
    private final TonePolarity polarity;
    private final DynamicColor roleA;
    private final DynamicColor roleB;
    private final boolean stayTogether;

    public ToneDeltaPair(@NonNull DynamicColor dynamicColor, @NonNull DynamicColor dynamicColor2, double d, @NonNull TonePolarity tonePolarity, boolean z) {
        this.roleA = dynamicColor;
        this.roleB = dynamicColor2;
        this.delta = d;
        this.polarity = tonePolarity;
        this.stayTogether = z;
    }

    public DynamicColor getRoleA() {
        return this.roleA;
    }

    public DynamicColor getRoleB() {
        return this.roleB;
    }

    public double getDelta() {
        return this.delta;
    }

    public TonePolarity getPolarity() {
        return this.polarity;
    }

    public boolean getStayTogether() {
        return this.stayTogether;
    }
}
