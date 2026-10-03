package androidx.compose.ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformLocaleDelegate {
    LocaleList getCurrent();

    java.util.Locale parseLanguageTag(@NotNull String str);
}
