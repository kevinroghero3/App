package com.facebook.fresco.ui.common;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public enum VisibilityState {
    UNKNOWN(-1),
    VISIBLE(1),
    INVISIBLE(2);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);
    private static final VisibilityState[] VALUES = values();

    public static EnumEntries<VisibilityState> getEntries() {
        return $ENTRIES;
    }

    VisibilityState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VisibilityState fromInt(int i) {
            for (VisibilityState visibilityState : VisibilityState.VALUES) {
                if (visibilityState.getValue() == i) {
                    return visibilityState;
                }
            }
            return null;
        }
    }
}
