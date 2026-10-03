package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FontMatcher {
    public static final int $stable = 0;

    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3, int i, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i & 8) != 0) {
            fontWeight3 = null;
        }
        int size = list.size();
        FontWeight fontWeight5 = null;
        for (int i2 = 0; i2 < size; i2++) {
            FontWeight weight = ((Font) list.get(i2)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) < 0) {
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) > 0) {
                        fontWeight5 = weight;
                    }
                } else {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight4 == null || weight.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight;
                    }
                }
            }
        }
        if (!z ? fontWeight4 == null : fontWeight5 != null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Object obj2 = list.get(i3);
            if (Intrinsics.areEqual(((Font) obj2).getWeight(), fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public final List<Font> filterByClosestWeight$ui_text_release(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, boolean z, @Nullable FontWeight fontWeight2, @Nullable FontWeight fontWeight3) {
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        for (int i = 0; i < size; i++) {
            FontWeight weight = list.get(i).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) < 0) {
                    if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                        fontWeight4 = weight;
                    }
                } else {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                }
            }
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Font font = list.get(i2);
            if (Intrinsics.areEqual(font.getWeight(), fontWeight4)) {
                arrayList.add(font);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3239matchFontRetOiIg(@NotNull FontFamily fontFamily, @NotNull FontWeight fontWeight, int i) {
        if (!(fontFamily instanceof FontListFontFamily)) {
            throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
        }
        return m3240matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i);
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3240matchFontRetOiIg(@NotNull FontListFontFamily fontListFontFamily, @NotNull FontWeight fontWeight, int i) {
        return m3241matchFontRetOiIg(fontListFontFamily.getFonts(), fontWeight, i);
    }

    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m3241matchFontRetOiIg(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Font font = list.get(i3);
            Font font2 = font;
            if (Intrinsics.areEqual(font2.getWeight(), fontWeight) && FontStyle.m3245equalsimpl0(font2.mo3200getStyle_LCdwA(), i)) {
                arrayList.add(font);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Font font3 = list.get(i4);
            if (FontStyle.m3245equalsimpl0(font3.mo3200getStyle_LCdwA(), i)) {
                arrayList2.add(font3);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List<? extends Font> list2 = list;
        FontWeight.Companion companion = FontWeight.Companion;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) >= 0) {
            if (fontWeight.compareTo(companion.getW500()) <= 0) {
                FontWeight w500 = companion.getW500();
                int size3 = list2.size();
                FontWeight fontWeight3 = null;
                FontWeight fontWeight4 = null;
                for (int i5 = 0; i5 < size3; i5++) {
                    FontWeight weight = list2.get(i5).getWeight();
                    if (w500 == null || weight.compareTo(w500) <= 0) {
                        if (weight.compareTo(fontWeight) < 0) {
                            if (fontWeight3 == null || weight.compareTo(fontWeight3) > 0) {
                                fontWeight3 = weight;
                            }
                        } else {
                            if (weight.compareTo(fontWeight) <= 0) {
                                fontWeight3 = weight;
                                fontWeight4 = fontWeight3;
                                break;
                            }
                            if (fontWeight4 == null || weight.compareTo(fontWeight4) < 0) {
                                fontWeight4 = weight;
                            }
                        }
                    }
                }
                if (fontWeight4 != null) {
                    fontWeight3 = fontWeight4;
                }
                ArrayList arrayList3 = new ArrayList(list2.size());
                int size4 = list2.size();
                for (int i6 = 0; i6 < size4; i6++) {
                    Font font4 = list2.get(i6);
                    if (Intrinsics.areEqual(font4.getWeight(), fontWeight3)) {
                        arrayList3.add(font4);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    return arrayList3;
                }
                FontWeight w501 = FontWeight.Companion.getW500();
                int size5 = list2.size();
                FontWeight fontWeight5 = null;
                for (int i7 = 0; i7 < size5; i7++) {
                    FontWeight weight2 = list2.get(i7).getWeight();
                    if (w501 == null || weight2.compareTo(w501) >= 0) {
                        if (weight2.compareTo(fontWeight) < 0) {
                            if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                                fontWeight2 = weight2;
                            }
                        } else {
                            if (weight2.compareTo(fontWeight) <= 0) {
                                fontWeight2 = weight2;
                                fontWeight5 = fontWeight2;
                                break;
                            }
                            if (fontWeight5 == null || weight2.compareTo(fontWeight5) < 0) {
                                fontWeight5 = weight2;
                            }
                        }
                    }
                }
                if (fontWeight5 != null) {
                    fontWeight2 = fontWeight5;
                }
                ArrayList arrayList4 = new ArrayList(list2.size());
                int size6 = list2.size();
                while (i2 < size6) {
                    Font font5 = list2.get(i2);
                    if (Intrinsics.areEqual(font5.getWeight(), fontWeight2)) {
                        arrayList4.add(font5);
                    }
                    i2++;
                }
                return arrayList4;
            }
            int size7 = list2.size();
            FontWeight fontWeight6 = null;
            for (int i8 = 0; i8 < size7; i8++) {
                FontWeight weight3 = list2.get(i8).getWeight();
                if (weight3.compareTo(fontWeight) < 0) {
                    if (fontWeight6 == null || weight3.compareTo(fontWeight6) > 0) {
                        fontWeight6 = weight3;
                    }
                } else {
                    if (weight3.compareTo(fontWeight) <= 0) {
                        fontWeight6 = weight3;
                        fontWeight2 = fontWeight6;
                        break;
                    }
                    if (fontWeight2 == null || weight3.compareTo(fontWeight2) < 0) {
                        fontWeight2 = weight3;
                    }
                }
            }
            if (fontWeight2 != null) {
                fontWeight6 = fontWeight2;
            }
            ArrayList arrayList5 = new ArrayList(list2.size());
            int size8 = list2.size();
            while (i2 < size8) {
                Font font6 = list2.get(i2);
                if (Intrinsics.areEqual(font6.getWeight(), fontWeight6)) {
                    arrayList5.add(font6);
                }
                i2++;
            }
            return arrayList5;
        }
        int size9 = list2.size();
        FontWeight fontWeight7 = null;
        for (int i9 = 0; i9 < size9; i9++) {
            FontWeight weight4 = list2.get(i9).getWeight();
            if (weight4.compareTo(fontWeight) < 0) {
                if (fontWeight7 == null || weight4.compareTo(fontWeight7) > 0) {
                    fontWeight7 = weight4;
                }
            } else {
                if (weight4.compareTo(fontWeight) <= 0) {
                    fontWeight7 = weight4;
                    fontWeight2 = fontWeight7;
                    break;
                }
                if (fontWeight2 == null || weight4.compareTo(fontWeight2) < 0) {
                    fontWeight2 = weight4;
                }
            }
        }
        if (fontWeight7 == null) {
            fontWeight7 = fontWeight2;
        }
        ArrayList arrayList6 = new ArrayList(list2.size());
        int size10 = list2.size();
        while (i2 < size10) {
            Font font7 = list2.get(i2);
            if (Intrinsics.areEqual(font7.getWeight(), fontWeight7)) {
                arrayList6.add(font7);
            }
            i2++;
        }
        return arrayList6;
    }
}
