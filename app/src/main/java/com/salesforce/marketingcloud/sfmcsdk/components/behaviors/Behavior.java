package com.salesforce.marketingcloud.sfmcsdk.components.behaviors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Behavior {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_TIME = "timestamp";
    private final String appName;
    private final String appVersion;
    private final String previousVersion;
    private final long timestamp;

    public /* synthetic */ Behavior(long j, String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, str3);
    }

    private Behavior(long j, String str, String str2, String str3) {
        this.timestamp = j;
        this.appVersion = str;
        this.appName = str2;
        this.previousVersion = str3;
    }

    public /* synthetic */ Behavior(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, (i & 8) != 0 ? null : str3, null);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPreviousVersion() {
        return this.previousVersion;
    }

    public static final class AppForegrounded extends Behavior {
        public AppForegrounded(long j, @Nullable String str, @Nullable String str2) {
            super(j, str, str2, null, 8, null);
        }
    }

    public static final class AppBackgrounded extends Behavior {
        public AppBackgrounded(long j, @Nullable String str, @Nullable String str2) {
            super(j, str, str2, null, 8, null);
        }
    }

    public static final class AppVersionChanged extends Behavior {
        public AppVersionChanged(long j, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            super(j, str, str2, str3, null);
        }
    }

    public static final class ScreenEntry extends Behavior {
        public static final Companion Companion = new Companion(null);
        public static final String KEY_NAME = "screen_name";
        private final String name;

        public final String getName() {
            return this.name;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenEntry(@NotNull String name, long j, @Nullable String str, @Nullable String str2) {
            super(j, str, str2, null, 8, null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
