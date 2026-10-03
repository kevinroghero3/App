package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface Font {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long MaximumAsyncTimeoutMillis = 15000;

    @Deprecated(message = "Replaced with FontFamily.Resolver during the introduction of async fonts, all usages should be replaced. Custom subclasses can be converted into a FontFamily.Resolver by calling createFontFamilyResolver(myFontFamilyResolver, context)")
    public interface ResourceLoader {
        @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
        Object load(@NotNull Font font);
    }

    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    int mo3200getStyle_LCdwA();

    FontWeight getWeight();

    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    default int mo3192getLoadingStrategyPKNRLFQ() {
        return FontLoadingStrategy.Companion.m3237getBlockingPKNRLFQ();
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long MaximumAsyncTimeoutMillis = 15000;

        private Companion() {
        }
    }
}
