package com.facebook.react.uimanager;

import java.util.Locale;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public enum PointerEvents {
    NONE,
    BOX_NONE,
    BOX_ONLY,
    AUTO;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final boolean canBeTouchTarget(@NotNull PointerEvents pointerEvents) {
        return Companion.canBeTouchTarget(pointerEvents);
    }

    @JvmStatic
    public static final boolean canChildrenBeTouchTarget(@NotNull PointerEvents pointerEvents) {
        return Companion.canChildrenBeTouchTarget(pointerEvents);
    }

    public static EnumEntries<PointerEvents> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final PointerEvents parsePointerEvents(@Nullable String str) {
        return Companion.parsePointerEvents(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PointerEvents parsePointerEvents(@Nullable String str) {
            if (str == null) {
                return PointerEvents.AUTO;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return PointerEvents.valueOf(StringsKt__StringsJVMKt.replace$default(upperCase, "-", "_", false, 4, (Object) null));
        }

        @JvmStatic
        public final boolean canBeTouchTarget(@NotNull PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_ONLY;
        }

        @JvmStatic
        public final boolean canChildrenBeTouchTarget(@NotNull PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_NONE;
        }
    }
}
