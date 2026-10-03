package com.mrousavy.camera.core.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum QualityBalance implements JSUnionValue {
    SPEED("speed"),
    BALANCED("balanced"),
    QUALITY("quality");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[QualityBalance.values().length];
            try {
                iArr[QualityBalance.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QualityBalance.BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QualityBalance.QUALITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<QualityBalance> getEntries() {
        return $ENTRIES;
    }

    QualityBalance(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toCaptureMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class Companion implements JSUnionValue.Companion<QualityBalance> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public QualityBalance fromUnionValue(@Nullable String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1924829944) {
                    if (iHashCode != 109641799) {
                        if (iHashCode == 651215103 && str.equals("quality")) {
                            return QualityBalance.QUALITY;
                        }
                    } else if (str.equals("speed")) {
                        return QualityBalance.SPEED;
                    }
                } else if (str.equals("balanced")) {
                    return QualityBalance.BALANCED;
                }
            }
            return QualityBalance.BALANCED;
        }
    }
}
