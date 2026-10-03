package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "This class is deprecated and will be deleted in the near future. Please use [com.facebook.react.common.assets.ReactFontManager] instead.")
public final class ReactFontManager {
    public static final Companion Companion = new Companion(null);
    private static ReactFontManager instance;
    private final com.facebook.react.common.assets.ReactFontManager delegate;

    public /* synthetic */ ReactFontManager(com.facebook.react.common.assets.ReactFontManager reactFontManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactFontManager);
    }

    @JvmStatic
    public static final ReactFontManager getInstance() {
        return Companion.getInstance();
    }

    private ReactFontManager(com.facebook.react.common.assets.ReactFontManager reactFontManager) {
        this.delegate = reactFontManager;
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, @NotNull AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        return this.delegate.getTypeface(fontFamilyName, i, assetManager);
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, boolean z, @NotNull AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        return this.delegate.getTypeface(fontFamilyName, i, z, assetManager);
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, int i2, @NotNull AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        return this.delegate.getTypeface(fontFamilyName, i, i2, assetManager);
    }

    public final void addCustomFont(@NotNull Context context, @NotNull String fontFamily, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.delegate.addCustomFont(context, fontFamily, i);
    }

    public final void addCustomFont(@NotNull String fontFamily, @Nullable Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.delegate.addCustomFont(fontFamily, typeface);
    }

    public final void setTypeface(@NotNull String fontFamilyName, int i, @NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.delegate.setTypeface(fontFamilyName, i, typeface);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReactFontManager getInstance() {
            ReactFontManager reactFontManager = ReactFontManager.instance;
            if (reactFontManager != null) {
                return reactFontManager;
            }
            ReactFontManager reactFontManager2 = new ReactFontManager(com.facebook.react.common.assets.ReactFontManager.Companion.getInstance(), null);
            Companion companion = ReactFontManager.Companion;
            ReactFontManager.instance = reactFontManager2;
            return reactFontManager2;
        }
    }
}
