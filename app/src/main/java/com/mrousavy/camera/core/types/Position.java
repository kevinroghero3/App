package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum Position implements JSUnionValue {
    BACK("back"),
    FRONT("front"),
    EXTERNAL("external");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<Position> getEntries() {
        return $ENTRIES;
    }

    Position(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Position fromLensFacing(int i) {
            if (i == -1) {
                return Position.EXTERNAL;
            }
            if (i == 0) {
                return Position.FRONT;
            }
            if (i == 1) {
                return Position.BACK;
            }
            if (i == 2) {
                return Position.EXTERNAL;
            }
            return Position.EXTERNAL;
        }
    }
}
