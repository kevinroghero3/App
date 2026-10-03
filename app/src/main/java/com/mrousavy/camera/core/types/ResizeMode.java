package com.mrousavy.camera.core.types;

import androidx.camera.view.PreviewView;
import com.facebook.react.uimanager.ViewProps;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum ResizeMode implements JSUnionValue {
    COVER("cover"),
    CONTAIN("contain");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResizeMode.values().length];
            try {
                iArr[ResizeMode.COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResizeMode.CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ResizeMode> getEntries() {
        return $ENTRIES;
    }

    ResizeMode(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final PreviewView.ScaleType toScaleType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PreviewView.ScaleType.FILL_CENTER;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return PreviewView.ScaleType.FIT_CENTER;
    }

    public static final class Companion implements JSUnionValue.Companion<ResizeMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public ResizeMode fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(str, "cover")) {
                return ResizeMode.COVER;
            }
            if (Intrinsics.areEqual(str, "contain")) {
                return ResizeMode.CONTAIN;
            }
            throw new InvalidTypeScriptUnionError(ViewProps.RESIZE_MODE, str);
        }
    }
}
