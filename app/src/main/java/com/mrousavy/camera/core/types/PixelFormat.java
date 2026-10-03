package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.PixelFormatNotSupportedError;
import com.mrousavy.camera.core.utils.ImageFormatUtils;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum PixelFormat implements JSUnionValue {
    YUV("yuv"),
    RGB("rgb"),
    UNKNOWN("unknown");

    private static final String TAG = "PixelFormat";
    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PixelFormat.values().length];
            try {
                iArr[PixelFormat.YUV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PixelFormat.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<PixelFormat> getEntries() {
        return $ENTRIES;
    }

    PixelFormat(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toImageAnalysisFormat() throws PixelFormatNotSupportedError {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                throw new PixelFormatNotSupportedError(getUnionValue());
            }
        }
        return i2;
    }

    public static final class Companion implements JSUnionValue.Companion<PixelFormat> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PixelFormat fromImageFormat(int i) {
            if (i == 1) {
                return PixelFormat.RGB;
            }
            if (i == 35) {
                return PixelFormat.YUV;
            }
            SentryLogcatAdapter.w(PixelFormat.TAG, "Unknown PixelFormat! " + ImageFormatUtils.Companion.imageFormatToString(i));
            return PixelFormat.UNKNOWN;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public PixelFormat fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -284840886) {
                    if (iHashCode != 112845) {
                        if (iHashCode == 120026 && str.equals("yuv")) {
                            return PixelFormat.YUV;
                        }
                    } else if (str.equals("rgb")) {
                        return PixelFormat.RGB;
                    }
                } else if (str.equals("unknown")) {
                    return PixelFormat.UNKNOWN;
                }
            }
            throw new InvalidTypeScriptUnionError("pixelFormat", str);
        }
    }
}
