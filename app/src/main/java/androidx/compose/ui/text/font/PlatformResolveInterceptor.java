package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface PlatformResolveInterceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    default FontFamily interceptFontFamily(@Nullable FontFamily fontFamily) {
        return fontFamily;
    }

    /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
    default int m3270interceptFontStyleT2F_aPo(int i) {
        return i;
    }

    /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
    default int m3271interceptFontSynthesisMscr08Y(int i) {
        return i;
    }

    default FontWeight interceptFontWeight(@NotNull FontWeight fontWeight) {
        return fontWeight;
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
        };

        private Companion() {
        }

        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }
}
