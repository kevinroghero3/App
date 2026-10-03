package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final BorderStyle fromString(@NotNull String str) {
        return Companion.fromString(str);
    }

    public static EnumEntries<BorderStyle> getEntries() {
        return $ENTRIES;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BorderStyle fromString(@NotNull String borderStyle) {
            Intrinsics.checkNotNullParameter(borderStyle, "borderStyle");
            String lowerCase = borderStyle.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1338941519) {
                if (iHashCode != -1325970902) {
                    if (iHashCode == 109618859 && lowerCase.equals("solid")) {
                        return BorderStyle.SOLID;
                    }
                } else if (lowerCase.equals("dotted")) {
                    return BorderStyle.DOTTED;
                }
            } else if (lowerCase.equals("dashed")) {
                return BorderStyle.DASHED;
            }
            return null;
        }
    }
}
