package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum OutputOrientation implements JSUnionValue {
    DEVICE("device"),
    PREVIEW("preview");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<OutputOrientation> getEntries() {
        return $ENTRIES;
    }

    OutputOrientation(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public static final class Companion implements JSUnionValue.Companion<OutputOrientation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public OutputOrientation fromUnionValue(@Nullable String str) {
            if (Intrinsics.areEqual(str, "device")) {
                return OutputOrientation.DEVICE;
            }
            return Intrinsics.areEqual(str, "preview") ? OutputOrientation.PREVIEW : OutputOrientation.DEVICE;
        }
    }
}
