package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'APPLICATION_FOREGROUNDED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BehaviorType[] $VALUES;
    public static final BehaviorType APPLICATION_BACKGROUNDED;
    public static final BehaviorType APPLICATION_FOREGROUNDED;
    public static final BehaviorType APP_VERSION_CHANGED;
    public static final Companion Companion;
    public static final BehaviorType SCREEN_ENTRY;
    private List<? extends BehaviorType> behaviorTypesToClear;
    private String intentFilter;
    private boolean sticky;

    private static final /* synthetic */ BehaviorType[] $values() {
        return new BehaviorType[]{SCREEN_ENTRY, APPLICATION_FOREGROUNDED, APPLICATION_BACKGROUNDED, APP_VERSION_CHANGED};
    }

    public static EnumEntries<BehaviorType> getEntries() {
        return $ENTRIES;
    }

    public static BehaviorType valueOf(String str) {
        return (BehaviorType) Enum.valueOf(BehaviorType.class, str);
    }

    public static BehaviorType[] values() {
        return (BehaviorType[]) $VALUES.clone();
    }

    private BehaviorType(String str, int i, String str2, boolean z, List list) {
        super(str, i);
        this.intentFilter = str2;
        this.sticky = z;
        this.behaviorTypesToClear = list;
    }

    /* synthetic */ BehaviorType(String str, int i, String str2, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : list);
    }

    public final String getIntentFilter$sfmcsdk_release() {
        return this.intentFilter;
    }

    public final void setIntentFilter$sfmcsdk_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intentFilter = str;
    }

    public final boolean getSticky$sfmcsdk_release() {
        return this.sticky;
    }

    public final void setSticky$sfmcsdk_release(boolean z) {
        this.sticky = z;
    }

    public final List<BehaviorType> getBehaviorTypesToClear$sfmcsdk_release() {
        return this.behaviorTypesToClear;
    }

    public final void setBehaviorTypesToClear$sfmcsdk_release(@Nullable List<? extends BehaviorType> list) {
        this.behaviorTypesToClear = list;
    }

    static {
        BehaviorType behaviorType = new BehaviorType("SCREEN_ENTRY", 0, "com.salesforce.marketingcloud.sfmcsdk.sdk.SCREEN_ENTRY", true, null, 4, null);
        SCREEN_ENTRY = behaviorType;
        boolean z = true;
        List list = null;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        BehaviorType behaviorType2 = new BehaviorType("APPLICATION_FOREGROUNDED", 1, "com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_FOREGROUNDED", z, list, i, defaultConstructorMarker);
        APPLICATION_FOREGROUNDED = behaviorType2;
        APPLICATION_BACKGROUNDED = new BehaviorType("APPLICATION_BACKGROUNDED", 2, "com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_BACKGROUNDED", false, CollectionsKt__CollectionsKt.listOf((Object[]) new BehaviorType[]{behaviorType2, behaviorType}), 2, null);
        APP_VERSION_CHANGED = new BehaviorType("APP_VERSION_CHANGED", 3, "com.salesforce.marketingcloud.sfmcsdk.sdk.APP_VERSION_CHANGED", z, list, i, defaultConstructorMarker);
        BehaviorType[] behaviorTypeArr$values = $values();
        $VALUES = behaviorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(behaviorTypeArr$values);
        Companion = new Companion(null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, java.util.ArrayList, java.util.Collection] */
        public final BehaviorType fromString(@Nullable String str) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = CollectionsKt__CollectionsKt.emptyList();
            if (str != null) {
                BehaviorType[] behaviorTypeArrValues = BehaviorType.values();
                ?? arrayList = new ArrayList();
                for (BehaviorType behaviorType : behaviorTypeArrValues) {
                    if (Intrinsics.areEqual(str, behaviorType.getIntentFilter$sfmcsdk_release())) {
                        arrayList.add(behaviorType);
                    }
                }
                objectRef.element = arrayList;
            }
            if (((Collection) objectRef.element).isEmpty()) {
                return null;
            }
            return (BehaviorType) ((List) objectRef.element).get(0);
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.intentFilter;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Behavior toBehavior$sfmcsdk_release(@NotNull Bundle data) {
        String string;
        Intrinsics.checkNotNullParameter(data, "data");
        long j = data.getLong("timestamp");
        String string2 = data.getString(BehaviorManagerImpl.BUNDLE_KEY_CURRENT_VERSION);
        String string3 = data.getString(BehaviorManagerImpl.BUNDLE_KEY_APP_NAME);
        String str = this.intentFilter;
        switch (str.hashCode()) {
            case -2046669238:
                if (str.equals("com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_BACKGROUNDED")) {
                    return new Behavior.AppBackgrounded(j, string2, string3);
                }
                return null;
            case -1610764001:
                if (str.equals("com.salesforce.marketingcloud.sfmcsdk.sdk.APPLICATION_FOREGROUNDED")) {
                    return new Behavior.AppForegrounded(j, string2, string3);
                }
                return null;
            case 100058561:
                if (str.equals("com.salesforce.marketingcloud.sfmcsdk.sdk.APP_VERSION_CHANGED")) {
                    return new Behavior.AppVersionChanged(j, string2, string3, data.getString(BehaviorManagerImpl.BUNDLE_KEY_PREVIOUS_VERSION));
                }
                return null;
            case 518948109:
                if (str.equals("com.salesforce.marketingcloud.sfmcsdk.sdk.SCREEN_ENTRY") && (string = data.getString("screen_name")) != null) {
                    return new Behavior.ScreenEntry(string, j, string2, string3);
                }
                return null;
            default:
                return null;
        }
    }
}
