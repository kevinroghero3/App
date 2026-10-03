package com.mrousavy.camera.core.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum Orientation implements JSUnionValue {
    PORTRAIT("portrait"),
    LANDSCAPE_RIGHT("landscape-right"),
    PORTRAIT_UPSIDE_DOWN("portrait-upside-down"),
    LANDSCAPE_LEFT("landscape-left");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.LANDSCAPE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Orientation.PORTRAIT_UPSIDE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Orientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    Orientation(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toSurfaceRotation() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Orientation reversed() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PORTRAIT;
        }
        if (i == 2) {
            return LANDSCAPE_RIGHT;
        }
        if (i == 3) {
            return PORTRAIT_UPSIDE_DOWN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return LANDSCAPE_LEFT;
    }

    public static final class Companion implements JSUnionValue.Companion<Orientation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public Orientation fromUnionValue(@Nullable String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1510435861:
                        if (str.equals("portrait-upside-down")) {
                            return Orientation.PORTRAIT_UPSIDE_DOWN;
                        }
                        break;
                    case 687313034:
                        if (str.equals("landscape-right")) {
                            return Orientation.LANDSCAPE_RIGHT;
                        }
                        break;
                    case 729267099:
                        if (str.equals("portrait")) {
                            return Orientation.PORTRAIT;
                        }
                        break;
                    case 1684556761:
                        if (str.equals("landscape-left")) {
                            return Orientation.LANDSCAPE_LEFT;
                        }
                        break;
                }
            }
            return Orientation.PORTRAIT;
        }

        public final Orientation fromRotationDegrees(int i) {
            if (45 <= i && i < 136) {
                return Orientation.LANDSCAPE_LEFT;
            }
            if (135 <= i && i < 226) {
                return Orientation.PORTRAIT_UPSIDE_DOWN;
            }
            if (225 <= i && i < 316) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            return Orientation.PORTRAIT;
        }

        public final Orientation fromSurfaceRotation(int i) {
            if (i == 0) {
                return Orientation.PORTRAIT;
            }
            if (i == 1) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            if (i == 2) {
                return Orientation.PORTRAIT_UPSIDE_DOWN;
            }
            if (i == 3) {
                return Orientation.LANDSCAPE_LEFT;
            }
            return Orientation.PORTRAIT;
        }
    }
}
