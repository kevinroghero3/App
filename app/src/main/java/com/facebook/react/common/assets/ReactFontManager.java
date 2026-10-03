package com.facebook.react.common.assets;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.content.res.ResourcesCompat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ReactFontManager {
    private static final String FONTS_ASSET_PATH = "fonts/";
    public static final Companion Companion = new Companion(null);
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final ReactFontManager _instance = new ReactFontManager();
    private final Map<String, AssetFontFamily> fontCache = new LinkedHashMap();
    private final Map<String, Typeface> customTypefaceCache = new LinkedHashMap();

    @JvmStatic
    public static final ReactFontManager getInstance() {
        return Companion.getInstance();
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, @Nullable AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, 0, 2, null), assetManager);
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, boolean z, @Nullable AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, z), assetManager);
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, int i, int i2, @Nullable AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, i2), assetManager);
    }

    public final Typeface getTypeface(@NotNull String fontFamilyName, @NotNull TypefaceStyle typefaceStyle, @Nullable AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(typefaceStyle, "typefaceStyle");
        if (this.customTypefaceCache.containsKey(fontFamilyName)) {
            return typefaceStyle.apply(this.customTypefaceCache.get(fontFamilyName));
        }
        Map<String, AssetFontFamily> map = this.fontCache;
        AssetFontFamily assetFontFamily = map.get(fontFamilyName);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            map.put(fontFamilyName, assetFontFamily);
        }
        AssetFontFamily assetFontFamily2 = assetFontFamily;
        int nearestStyle = typefaceStyle.getNearestStyle();
        Typeface typefaceForStyle = assetFontFamily2.getTypefaceForStyle(nearestStyle);
        if (typefaceForStyle != null) {
            return typefaceForStyle;
        }
        Typeface typefaceCreateAssetTypeface = Companion.createAssetTypeface(fontFamilyName, nearestStyle, assetManager);
        assetFontFamily2.setTypefaceForStyle(nearestStyle, typefaceCreateAssetTypeface);
        return typefaceCreateAssetTypeface;
    }

    public final void addCustomFont(@NotNull Context context, @NotNull String fontFamily, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        addCustomFont(fontFamily, ResourcesCompat.getFont(context, i));
    }

    public final void addCustomFont(@NotNull String fontFamily, @Nullable Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        if (typeface != null) {
            this.customTypefaceCache.put(fontFamily, typeface);
        }
    }

    public final void setTypeface(@NotNull String fontFamilyName, int i, @Nullable Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        if (typeface != null) {
            Map<String, AssetFontFamily> map = this.fontCache;
            AssetFontFamily assetFontFamily = map.get(fontFamilyName);
            if (assetFontFamily == null) {
                assetFontFamily = new AssetFontFamily();
                map.put(fontFamilyName, assetFontFamily);
            }
            assetFontFamily.setTypefaceForStyle(i, typeface);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class TypefaceStyle {
        public static final int BOLD = 700;
        public static final Companion Companion = new Companion(null);
        public static final int NORMAL = 400;
        private final boolean italic;
        private final int weight;

        public TypefaceStyle(int i) {
            this(i, 0, 2, null);
        }

        public TypefaceStyle(int i, boolean z) {
            this.italic = z;
            this.weight = i == -1 ? 400 : i;
        }

        public /* synthetic */ TypefaceStyle(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? -1 : i2);
        }

        public TypefaceStyle(int i, int i2) {
            i = i == -1 ? 0 : i;
            this.italic = (i & 2) != 0;
            this.weight = i2 == -1 ? (i & 1) != 0 ? 700 : 400 : i2;
        }

        public final int getNearestStyle() {
            if (this.weight < 700) {
                return this.italic ? 2 : 0;
            }
            return this.italic ? 3 : 1;
        }

        public final Typeface apply(@Nullable Typeface typeface) {
            if (Build.VERSION.SDK_INT < 28) {
                Typeface typefaceCreate = Typeface.create(typeface, getNearestStyle());
                Intrinsics.checkNotNull(typefaceCreate);
                return typefaceCreate;
            }
            Typeface typefaceCreate2 = Typeface.create(typeface, this.weight, this.italic);
            Intrinsics.checkNotNull(typefaceCreate2);
            return typefaceCreate2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReactFontManager getInstance() {
            return ReactFontManager._instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Typeface createAssetTypeface(String str, int i, AssetManager assetManager) {
            if (assetManager != null) {
                String str2 = ReactFontManager.EXTENSIONS[i];
                for (String str3 : ReactFontManager.FILE_EXTENSIONS) {
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(assetManager, ReactFontManager.FONTS_ASSET_PATH + str + str2 + str3);
                        Intrinsics.checkNotNullExpressionValue(typefaceCreateFromAsset, "createFromAsset(...)");
                        return typefaceCreateFromAsset;
                    } catch (RuntimeException unused) {
                    }
                }
            }
            Typeface typefaceCreate = Typeface.create(str, i);
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
            return typefaceCreate;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    static final class AssetFontFamily {
        private final SparseArray<Typeface> typefaceSparseArray = new SparseArray<>(4);

        public final Typeface getTypefaceForStyle(int i) {
            return this.typefaceSparseArray.get(i);
        }

        public final void setTypefaceForStyle(int i, @Nullable Typeface typeface) {
            this.typefaceSparseArray.put(i, typeface);
        }
    }
}
