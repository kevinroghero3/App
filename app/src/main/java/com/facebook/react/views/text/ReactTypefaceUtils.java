package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.google.logging.type.LogSeverity;
import io.sentry.ProfilingTraceData;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactTypefaceUtils {
    public static final ReactTypefaceUtils INSTANCE = new ReactTypefaceUtils();

    private ReactTypefaceUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x008b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final int parseFontWeight(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals(ProfilingTraceData.TRUNCATION_REASON_NORMAL)) {
                        return 400;
                    }
                    break;
                case 48625:
                    if (str.equals("100")) {
                        return 100;
                    }
                    break;
                case 49586:
                    if (str.equals("200")) {
                        return 200;
                    }
                    break;
                case 50547:
                    if (str.equals("300")) {
                        return 300;
                    }
                    break;
                case 51508:
                    if (str.equals("400")) {
                        return 400;
                    }
                    break;
                case 52469:
                    if (str.equals("500")) {
                        return 500;
                    }
                    break;
                case 53430:
                    if (str.equals("600")) {
                        return 600;
                    }
                    break;
                case 54391:
                    if (str.equals("700")) {
                        return 700;
                    }
                    break;
                case 55352:
                    if (str.equals("800")) {
                        return LogSeverity.EMERGENCY_VALUE;
                    }
                    break;
                case 56313:
                    if (str.equals("900")) {
                        return 900;
                    }
                    break;
                case 3029637:
                    if (str.equals("bold")) {
                        return 700;
                    }
                    break;
            }
        }
        return -1;
    }

    @JvmStatic
    public static final int parseFontStyle(@Nullable String str) {
        if (Intrinsics.areEqual(str, "italic")) {
            return 2;
        }
        return Intrinsics.areEqual(str, ProfilingTraceData.TRUNCATION_REASON_NORMAL) ? 0 : -1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final String parseFontVariant(@Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                switch (string.hashCode()) {
                    case -1983120972:
                        if (string.equals("stylistic-thirteen")) {
                            arrayList.add("'ss13'");
                        }
                        break;
                    case -1933522176:
                        if (string.equals("stylistic-fifteen")) {
                            arrayList.add("'ss15'");
                        }
                        break;
                    case -1534462052:
                        if (string.equals("stylistic-eighteen")) {
                            arrayList.add("'ss18'");
                        }
                        break;
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            arrayList.add("'pnum'");
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            arrayList.add("'lnum'");
                        }
                        break;
                    case -899039099:
                        if (string.equals("historical-ligatures")) {
                            arrayList.add("'hlig'");
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            arrayList.add("'tnum'");
                        }
                        break;
                    case -672279417:
                        if (string.equals("discretionary-ligatures")) {
                            arrayList.add("'dlig'");
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            arrayList.add("'onum'");
                        }
                        break;
                    case 249095901:
                        if (string.equals("no-contextual")) {
                            arrayList.add("'calt' off");
                        }
                        break;
                    case 273808209:
                        if (string.equals("contextual")) {
                            arrayList.add("'calt'");
                        }
                        break;
                    case 289909490:
                        if (string.equals("no-common-ligatures")) {
                            arrayList.add("'liga' off");
                            arrayList.add("'clig' off");
                        }
                        break;
                    case 296506098:
                        if (string.equals("stylistic-eight")) {
                            arrayList.add("'ss08'");
                        }
                        break;
                    case 309330544:
                        if (string.equals("stylistic-seven")) {
                            arrayList.add("'ss07'");
                        }
                        break;
                    case 310339585:
                        if (string.equals("stylistic-three")) {
                            arrayList.add("'ss03'");
                        }
                        break;
                    case 604478526:
                        if (string.equals("stylistic-eleven")) {
                            arrayList.add("'ss11'");
                        }
                        break;
                    case 915975441:
                        if (string.equals("no-historical-ligatures")) {
                            arrayList.add("'hlig' off");
                        }
                        break;
                    case 979426287:
                        if (string.equals("stylistic-five")) {
                            arrayList.add("'ss05'");
                        }
                        break;
                    case 979432035:
                        if (string.equals("stylistic-four")) {
                            arrayList.add("'ss04'");
                        }
                        break;
                    case 979664367:
                        if (string.equals("stylistic-nine")) {
                            arrayList.add("'ss09'");
                        }
                        break;
                    case 1001434505:
                        if (string.equals("stylistic-one")) {
                            arrayList.add("'ss01'");
                        }
                        break;
                    case 1001438213:
                        if (string.equals("stylistic-six")) {
                            arrayList.add("'ss06'");
                        }
                        break;
                    case 1001439040:
                        if (string.equals("stylistic-ten")) {
                            arrayList.add("'ss10'");
                        }
                        break;
                    case 1001439599:
                        if (string.equals("stylistic-two")) {
                            arrayList.add("'ss02'");
                        }
                        break;
                    case 1030714463:
                        if (string.equals("stylistic-sixteen")) {
                            arrayList.add("'ss16'");
                        }
                        break;
                    case 1044065430:
                        if (string.equals("stylistic-twelve")) {
                            arrayList.add("'ss12'");
                        }
                        break;
                    case 1044067310:
                        if (string.equals("stylistic-twenty")) {
                            arrayList.add("'ss20'");
                        }
                        break;
                    case 1082592379:
                        if (string.equals("no-discretionary-ligatures")) {
                            arrayList.add("'dlig' off");
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            arrayList.add("'smcp'");
                        }
                        break;
                    case 1223989350:
                        if (string.equals("common-ligatures")) {
                            arrayList.add("'liga'");
                            arrayList.add("'clig'");
                        }
                        break;
                    case 1463562569:
                        if (string.equals("stylistic-nineteen")) {
                            arrayList.add("'ss19'");
                        }
                        break;
                    case 1648446397:
                        if (string.equals("stylistic-fourteen")) {
                            arrayList.add("'ss14'");
                        }
                        break;
                    case 2097122634:
                        if (string.equals("stylistic-seventeen")) {
                            arrayList.add("'ss17'");
                        }
                        break;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    @JvmStatic
    public static final Typeface applyStyles(@Nullable Typeface typeface, int i, int i2, @Nullable String str, @NotNull AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        com.facebook.react.common.assets.ReactFontManager.TypefaceStyle typefaceStyle = new com.facebook.react.common.assets.ReactFontManager.TypefaceStyle(i, i2);
        if (str != null) {
            return com.facebook.react.common.assets.ReactFontManager.Companion.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }
}
