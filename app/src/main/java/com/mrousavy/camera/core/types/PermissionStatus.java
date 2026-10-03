package com.mrousavy.camera.core.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public enum PermissionStatus implements JSUnionValue {
    DENIED("denied"),
    NOT_DETERMINED("not-determined"),
    GRANTED("granted");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<PermissionStatus> getEntries() {
        return $ENTRIES;
    }

    PermissionStatus(String str) {
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

        public final PermissionStatus fromPermissionStatus(int i) {
            if (i == -1) {
                return PermissionStatus.DENIED;
            }
            if (i == 0) {
                return PermissionStatus.GRANTED;
            }
            return PermissionStatus.NOT_DETERMINED;
        }
    }
}
