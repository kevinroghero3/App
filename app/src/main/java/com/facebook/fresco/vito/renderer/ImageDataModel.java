package com.facebook.fresco.vito.renderer;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageDataModel {
    private final int defaultPaintFlags;
    private final int height;
    private final int width;

    public /* synthetic */ ImageDataModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void onAttach() {
    }

    public void onDetach() {
    }

    public void setCallback(@Nullable Drawable.Callback callback) {
    }

    private ImageDataModel() {
        this.width = -1;
        this.height = -1;
        this.defaultPaintFlags = 1;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDefaultPaintFlags() {
        return this.defaultPaintFlags;
    }
}
