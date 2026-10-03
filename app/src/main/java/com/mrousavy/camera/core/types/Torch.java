package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum Torch implements JSUnionValue {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    ON("on");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<Torch> getEntries() {
        return $ENTRIES;
    }

    Torch(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public static final class Companion implements JSUnionValue.Companion<Torch> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public Torch fromUnionValue(@Nullable String str) {
            if (Intrinsics.areEqual(str, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                return Torch.OFF;
            }
            return Intrinsics.areEqual(str, "on") ? Torch.ON : Torch.OFF;
        }
    }
}
