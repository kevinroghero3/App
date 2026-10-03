package com.mrousavy.camera.core.types;

import androidx.camera.view.PreviewView;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum PreviewViewType implements JSUnionValue {
    SURFACE_VIEW("surface-view"),
    TEXTURE_VIEW("texture-view");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewViewType.values().length];
            try {
                iArr[PreviewViewType.SURFACE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewViewType.TEXTURE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<PreviewViewType> getEntries() {
        return $ENTRIES;
    }

    PreviewViewType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final PreviewView.ImplementationMode toPreviewImplementationMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PreviewView.ImplementationMode.PERFORMANCE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return PreviewView.ImplementationMode.COMPATIBLE;
    }

    public static final class Companion implements JSUnionValue.Companion<PreviewViewType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public PreviewViewType fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(str, "surface-view")) {
                return PreviewViewType.SURFACE_VIEW;
            }
            if (Intrinsics.areEqual(str, "texture-view")) {
                return PreviewViewType.TEXTURE_VIEW;
            }
            throw new InvalidTypeScriptUnionError("androidPreviewViewType", str);
        }
    }
}
