package com.facebook.hermes.unicode;

import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidUnicodeUtils {
    private static final int FORM_C = 0;
    private static final int FORM_D = 1;
    private static final int FORM_KC = 2;
    private static final int FORM_KD = 3;
    public static final AndroidUnicodeUtils INSTANCE = new AndroidUnicodeUtils();
    private static final int TARGET_LOWERCASE = 1;
    private static final int TARGET_UPPERCASE = 0;

    private AndroidUnicodeUtils() {
    }

    @JvmStatic
    public static final int localeCompare(@Nullable String str, @Nullable String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    @JvmStatic
    public static final String dateFormat(double d, boolean z, boolean z2) {
        DateFormat timeInstance;
        if (z && z2) {
            timeInstance = DateFormat.getDateTimeInstance(2, 2);
        } else if (z) {
            timeInstance = DateFormat.getDateInstance(2);
        } else if (z2) {
            timeInstance = DateFormat.getTimeInstance(2);
        } else {
            throw new IllegalStateException("Bad dateFormat configuration");
        }
        return timeInstance.format(Long.valueOf((long) d)).toString();
    }

    @JvmStatic
    public static final String convertToCase(@NotNull String input, int i, boolean z) {
        Intrinsics.checkNotNullParameter(input, "input");
        Locale locale = z ? Locale.getDefault() : Locale.ENGLISH;
        if (i == 0) {
            Intrinsics.checkNotNull(locale);
            String upperCase = input.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (i == 1) {
            Intrinsics.checkNotNull(locale);
            String lowerCase = input.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        throw new IllegalStateException("Invalid target case");
    }

    @JvmStatic
    public static final String normalize(@Nullable String str, int i) {
        if (i == 0) {
            String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFC);
            Intrinsics.checkNotNullExpressionValue(strNormalize, "normalize(...)");
            return strNormalize;
        }
        if (i == 1) {
            String strNormalize2 = Normalizer.normalize(str, Normalizer.Form.NFD);
            Intrinsics.checkNotNullExpressionValue(strNormalize2, "normalize(...)");
            return strNormalize2;
        }
        if (i == 2) {
            String strNormalize3 = Normalizer.normalize(str, Normalizer.Form.NFKC);
            Intrinsics.checkNotNullExpressionValue(strNormalize3, "normalize(...)");
            return strNormalize3;
        }
        if (i == 3) {
            String strNormalize4 = Normalizer.normalize(str, Normalizer.Form.NFKD);
            Intrinsics.checkNotNullExpressionValue(strNormalize4, "normalize(...)");
            return strNormalize4;
        }
        throw new IllegalStateException("Invalid form");
    }
}
