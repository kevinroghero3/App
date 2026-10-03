package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceDrawableIdHelper {
    private static final String LOCAL_RESOURCE_SCHEME = "res";
    private final Map<String, Integer> resourceDrawableIdMap = new HashMap();
    public static final Companion Companion = new Companion(null);
    private static final ResourceDrawableIdHelper resourceDrawableIdHelper = new ResourceDrawableIdHelper();

    public static final ResourceDrawableIdHelper getInstance() {
        return Companion.getInstance();
    }

    private ResourceDrawableIdHelper() {
    }

    public final void clear() {
        synchronized (this) {
            this.resourceDrawableIdMap.clear();
        }
    }

    public final int getResourceDrawableId(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null || str.length() == 0) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt__StringsJVMKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        try {
            return Integer.parseInt(strReplace$default);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                Integer num = this.resourceDrawableIdMap.get(strReplace$default);
                return num != null ? num.intValue() : addDrawableId(context, strReplace$default);
            }
        }
    }

    private final int addDrawableId(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        this.resourceDrawableIdMap.put(str, Integer.valueOf(identifier));
        return identifier;
    }

    public final Drawable getResourceDrawable(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int resourceDrawableId = getResourceDrawableId(context, str);
        if (resourceDrawableId > 0) {
            return ResourcesCompat.getDrawable(context.getResources(), resourceDrawableId, null);
        }
        return null;
    }

    public final Uri getResourceDrawableUri(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int resourceDrawableId = getResourceDrawableId(context, str);
        if (resourceDrawableId > 0) {
            Uri uriBuild = new Uri.Builder().scheme("res").path(String.valueOf(resourceDrawableId)).build();
            Intrinsics.checkNotNull(uriBuild);
            return uriBuild;
        }
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNull(uri);
        return uri;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final ResourceDrawableIdHelper getInstance() {
            return ResourceDrawableIdHelper.resourceDrawableIdHelper;
        }

        @Deprecated(message = "Use .instance instead, this API is for backward compat", replaceWith = @ReplaceWith(expression = "instance", imports = {}))
        public final ResourceDrawableIdHelper DEPRECATED$getInstance() {
            return getInstance();
        }
    }
}
