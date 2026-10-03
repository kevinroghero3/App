package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public enum Flash implements JSUnionValue {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    ON("on"),
    AUTO("auto");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Flash.values().length];
            try {
                iArr[Flash.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Flash.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Flash.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<Flash> getEntries() {
        return $ENTRIES;
    }

    Flash(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toFlashMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion implements JSUnionValue.Companion<Flash> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public Flash fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != 3551) {
                    if (iHashCode != 109935) {
                        if (iHashCode == 3005871 && str.equals("auto")) {
                            return Flash.AUTO;
                        }
                    } else if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        return Flash.OFF;
                    }
                } else if (str.equals("on")) {
                    return Flash.ON;
                }
            }
            if (str == null) {
                str = "(null)";
            }
            throw new InvalidTypeScriptUnionError("flash", str);
        }
    }
}
