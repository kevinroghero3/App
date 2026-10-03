package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-HklW4sA$default, reason: not valid java name */
    public static /* synthetic */ int m3394resolveTextDirectionHeuristicsHklW4sA$default(int i, LocaleList localeList, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            localeList = null;
        }
        return m3393resolveTextDirectionHeuristicsHklW4sA(i, localeList);
    }

    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-HklW4sA, reason: not valid java name */
    public static final int m3393resolveTextDirectionHeuristicsHklW4sA(int i, @Nullable LocaleList localeList) {
        Locale platformLocale;
        TextDirection.Companion companion = TextDirection.Companion;
        if (!TextDirection.m3549equalsimpl0(i, companion.m3554getContentOrLtrs_7Xco())) {
            if (!TextDirection.m3549equalsimpl0(i, companion.m3555getContentOrRtls_7Xco())) {
                if (TextDirection.m3549equalsimpl0(i, companion.m3556getLtrs_7Xco())) {
                    return 0;
                }
                if (TextDirection.m3549equalsimpl0(i, companion.m3557getRtls_7Xco())) {
                    return 1;
                }
                if (TextDirection.m3549equalsimpl0(i, companion.m3553getContents_7Xco()) || TextDirection.m3549equalsimpl0(i, companion.m3558getUnspecifieds_7Xco())) {
                    if (localeList == null || (platformLocale = localeList.get(0).getPlatformLocale()) == null) {
                        platformLocale = Locale.getDefault();
                    }
                    int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(platformLocale);
                    if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                    }
                } else {
                    throw new IllegalStateException("Invalid TextDirection.");
                }
            }
            return 3;
        }
        return 2;
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        EmojiSupportMatch emojiSupportMatchM2987boximpl = (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m2987boximpl(paragraphStyle.m3064getEmojiSupportMatch_3YsG6Y());
        return !(emojiSupportMatchM2987boximpl == null ? false : EmojiSupportMatch.m2990equalsimpl0(emojiSupportMatchM2987boximpl.m2993unboximpl(), EmojiSupportMatch.Companion.m2996getNone_3YsG6Y()));
    }
}
