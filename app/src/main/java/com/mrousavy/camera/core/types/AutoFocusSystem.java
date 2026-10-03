package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum AutoFocusSystem implements JSUnionValue {
    CONTRAST_DETECTION("contrast-detection"),
    NONE("none");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<AutoFocusSystem> getEntries() {
        return $ENTRIES;
    }

    AutoFocusSystem(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public static final class Companion implements JSUnionValue.Companion<AutoFocusSystem> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public AutoFocusSystem fromUnionValue(@Nullable String str) {
            return Intrinsics.areEqual(str, "contrast-detection") ? AutoFocusSystem.CONTRAST_DETECTION : AutoFocusSystem.NONE;
        }
    }
}
