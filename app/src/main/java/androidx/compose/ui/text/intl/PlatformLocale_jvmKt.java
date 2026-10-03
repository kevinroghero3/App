package androidx.compose.ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class PlatformLocale_jvmKt {
    public static final String getLanguage(@NotNull java.util.Locale locale) {
        return locale.getLanguage();
    }

    public static final String getScript(@NotNull java.util.Locale locale) {
        return locale.getScript();
    }

    public static final String getRegion(@NotNull java.util.Locale locale) {
        return locale.getCountry();
    }

    public static final String getLanguageTag(@NotNull java.util.Locale locale) {
        return locale.toLanguageTag();
    }
}
