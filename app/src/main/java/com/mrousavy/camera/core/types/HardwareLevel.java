package com.mrousavy.camera.core.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum HardwareLevel implements JSUnionValue {
    LEGACY("legacy"),
    LIMITED("limited"),
    EXTERNAL("limited"),
    FULL("full"),
    LEVEL_3("full");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HardwareLevel.values().length];
            try {
                iArr[HardwareLevel.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HardwareLevel.LIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HardwareLevel.EXTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HardwareLevel.FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HardwareLevel.LEVEL_3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<HardwareLevel> getEntries() {
        return $ENTRIES;
    }

    HardwareLevel(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    private final int getRank() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HardwareLevel fromCameraHardwareLevel(int i) {
            if (i == 0) {
                return HardwareLevel.LIMITED;
            }
            if (i == 1) {
                return HardwareLevel.FULL;
            }
            if (i == 2) {
                return HardwareLevel.LEGACY;
            }
            if (i == 3) {
                return HardwareLevel.LEVEL_3;
            }
            if (i == 4) {
                return HardwareLevel.EXTERNAL;
            }
            return HardwareLevel.LEGACY;
        }
    }
}
