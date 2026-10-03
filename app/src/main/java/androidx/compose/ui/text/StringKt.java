package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class StringKt {
    private static final PlatformStringDelegate stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();

    public static final String toUpperCase(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.toUpperCase(str, locale.getPlatformLocale());
    }

    public static final String toLowerCase(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.toLowerCase(str, locale.getPlatformLocale());
    }

    public static final String capitalize(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.capitalize(str, locale.getPlatformLocale());
    }

    public static final String decapitalize(@NotNull String str, @NotNull Locale locale) {
        return stringDelegate.decapitalize(str, locale.getPlatformLocale());
    }

    public static final String toUpperCase(@NotNull String str, @NotNull LocaleList localeList) {
        return toUpperCase(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String toLowerCase(@NotNull String str, @NotNull LocaleList localeList) {
        return toLowerCase(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String capitalize(@NotNull String str, @NotNull LocaleList localeList) {
        return capitalize(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String decapitalize(@NotNull String str, @NotNull LocaleList localeList) {
        return decapitalize(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }
}
