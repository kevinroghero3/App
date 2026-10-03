package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.ViewProps;
import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public enum Overflow {
    VISIBLE,
    HIDDEN,
    SCROLL;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final Overflow fromString(@NotNull String str) {
        return Companion.fromString(str);
    }

    public static EnumEntries<Overflow> getEntries() {
        return $ENTRIES;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Overflow fromString(@NotNull String overflow) {
            Intrinsics.checkNotNullParameter(overflow, "overflow");
            String lowerCase = overflow.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1217487446) {
                if (iHashCode != -907680051) {
                    if (iHashCode == 466743410 && lowerCase.equals(ViewProps.VISIBLE)) {
                        return Overflow.VISIBLE;
                    }
                } else if (lowerCase.equals(ViewProps.SCROLL)) {
                    return Overflow.SCROLL;
                }
            } else if (lowerCase.equals(ViewProps.HIDDEN)) {
                return Overflow.HIDDEN;
            }
            return null;
        }
    }
}
