package com.mrousavy.camera.core.types;

import com.facebook.hermes.intl.Constants;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum VideoStabilizationMode implements JSUnionValue {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    STANDARD(Constants.COLLATION_STANDARD),
    CINEMATIC("cinematic"),
    CINEMATIC_EXTENDED("cinematic-extended");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoStabilizationMode.values().length];
            try {
                iArr[VideoStabilizationMode.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilizationMode.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC_EXTENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<VideoStabilizationMode> getEntries() {
        return $ENTRIES;
    }

    VideoStabilizationMode(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    private final int getScore() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isAtLeast(@NotNull VideoStabilizationMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return getScore() >= mode.getScore();
    }

    public static final class Companion implements JSUnionValue.Companion<VideoStabilizationMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public VideoStabilizationMode fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1348796151:
                        if (str.equals("cinematic-extended")) {
                            return VideoStabilizationMode.CINEMATIC_EXTENDED;
                        }
                        break;
                    case 109935:
                        if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 3005871:
                        if (str.equals("auto")) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 1312628413:
                        if (str.equals(Constants.COLLATION_STANDARD)) {
                            return VideoStabilizationMode.STANDARD;
                        }
                        break;
                    case 1598495741:
                        if (str.equals("cinematic")) {
                            return VideoStabilizationMode.CINEMATIC;
                        }
                        break;
                }
            }
            throw new InvalidTypeScriptUnionError("videoStabilizationMode", str);
        }
    }
}
