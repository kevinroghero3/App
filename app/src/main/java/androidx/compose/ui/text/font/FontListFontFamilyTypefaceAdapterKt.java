package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objLoadBlocking;
        Object objM5472constructorimpl;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int iMo3192getLoadingStrategyPKNRLFQ = font.mo3192getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (!FontLoadingStrategy.m3232equalsimpl0(iMo3192getLoadingStrategyPKNRLFQ, companion.m3237getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m3232equalsimpl0(iMo3192getLoadingStrategyPKNRLFQ, companion.m3238getOptionalLocalPKNRLFQ())) {
                    if (!FontLoadingStrategy.m3232equalsimpl0(iMo3192getLoadingStrategyPKNRLFQ, companion.m3236getAsyncPKNRLFQ())) {
                        throw new IllegalStateException("Unknown font type " + font);
                    }
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM3201get1ASDuI8 = asyncTypefaceCache.m3201get1ASDuI8(font, platformFontLoader);
                    if (asyncTypefaceResultM3201get1ASDuI8 != null) {
                        if (!AsyncTypefaceCache.AsyncTypefaceResult.m3207isPermanentFailureimpl(asyncTypefaceResultM3201get1ASDuI8.m3209unboximpl()) && asyncTypefaceResultM3201get1ASDuI8.m3209unboximpl() != null) {
                            return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m3266synthesizeTypefaceFxwP2eA(typefaceRequest.m3291getFontSynthesisGVVA2EU(), asyncTypefaceResultM3201get1ASDuI8.m3209unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m3290getFontStyle_LCdwA()));
                        }
                    } else if (listMutableListOf == null) {
                        listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(font);
                    } else {
                        listMutableListOf.add(font);
                    }
                } else {
                    synchronized (asyncTypefaceCache.cacheLock) {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objM5472constructorimpl = asyncTypefaceResult.m3209unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                objM5472constructorimpl = Result.m5472constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.Companion;
                                objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
                                objM5472constructorimpl = null;
                            }
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objM5472constructorimpl, false, 8, null);
                        }
                    }
                    if (objM5472constructorimpl != null) {
                        return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m3266synthesizeTypefaceFxwP2eA(typefaceRequest.m3291getFontSynthesisGVVA2EU(), objM5472constructorimpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m3290getFontStyle_LCdwA()));
                    }
                }
            } else {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        objLoadBlocking = asyncTypefaceResult2.m3209unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            objLoadBlocking = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                        } catch (Exception e) {
                            throw new IllegalStateException("Unable to load font " + font, e);
                        }
                    }
                }
                if (objLoadBlocking == null) {
                    throw new IllegalStateException("Unable to load font " + font);
                }
                return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m3266synthesizeTypefaceFxwP2eA(typefaceRequest.m3291getFontSynthesisGVVA2EU(), objLoadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.m3290getFontStyle_LCdwA()));
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
