package com.facebook.react.views.text;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public enum TextTransform {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final String apply(@Nullable String str, @Nullable TextTransform textTransform) {
        return Companion.apply(str, textTransform);
    }

    public static EnumEntries<TextTransform> getEntries() {
        return $ENTRIES;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String apply(@Nullable String str, @Nullable TextTransform textTransform) {
            if (str != null) {
                return TextTransformKt.applyTextTransform(str, textTransform);
            }
            return null;
        }
    }
}
