package com.salesforce.marketingcloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class InitializationStatus {
    public static final b Companion = new b(null);
    public final boolean encryptionChanged;
    public final List<String> initializedComponents;
    public final boolean isUsable;
    public final boolean locationsError;
    public final boolean messagingPermissionError;
    public final String playServicesMessage;
    public final int playServicesStatus;
    public final boolean proximityError;
    public final boolean sslProviderEnablementError;
    public final Status status;
    public final boolean storageError;
    public final Throwable unrecoverableException;

    public enum Status {
        SUCCESS,
        COMPLETED_WITH_DEGRADED_FUNCTIONALITY,
        FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    public static final class a {
        private Throwable a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private String g;
        private boolean i;
        private int h = -1;
        private final List<String> j = new ArrayList();

        public final void a(boolean z) {
            this.c = z;
        }

        public final void b(boolean z) {
            this.b = z;
        }

        public final void c(boolean z) {
            this.e = z;
        }

        public final void d(boolean z) {
            this.i = z;
        }

        public final void e(boolean z) {
            this.f = z;
        }

        public final void f(boolean z) {
            this.d = z;
        }

        public final void a(int i) {
            this.h = i;
        }

        public final boolean b() {
            return this.a == null;
        }

        public final void a(@Nullable String str) {
            if (str != null) {
                String str2 = this.g;
                if (str2 == null) {
                    this.g = str;
                    return;
                }
                this.g = str2 + "\n" + str;
            }
        }

        public final void a(@NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.a = throwable;
        }

        public final void a(@NotNull d component) {
            Intrinsics.checkNotNullParameter(component, "component");
            List<String> list = this.j;
            String strComponentName = component.componentName();
            Intrinsics.checkNotNullExpressionValue(strComponentName, "componentName(...)");
            list.add(strComponentName);
        }

        public final InitializationStatus a() {
            Status status;
            if (b()) {
                if (!this.b && !this.d && !this.e && !this.i && !this.f) {
                    status = Status.SUCCESS;
                } else {
                    status = Status.COMPLETED_WITH_DEGRADED_FUNCTIONALITY;
                }
            } else {
                status = Status.FAILED;
            }
            Status status2 = status;
            Throwable th = this.a;
            boolean z = this.b;
            int i = this.h;
            String str = this.g;
            boolean z2 = this.c;
            boolean z3 = this.d;
            boolean z4 = this.i;
            boolean z5 = this.e;
            boolean z6 = this.f;
            String[] strArr = (String[]) this.j.toArray(new String[0]);
            return new InitializationStatus(status2, th, z, i, str, z2, z3, z4, z5, z6, CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)), false, 2048, null);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InitializationStatus a() {
            a aVarB = b();
            aVarB.a(new IllegalStateException("Amazon devices are not supported"));
            return aVarB.a();
        }

        public final a b() {
            return new a();
        }

        public final InitializationStatus c() {
            a aVarB = b();
            aVarB.a(new IllegalStateException("The SDK no longer includes the legacy encryption dependency. If you wish to proceed, please set the configuration parameter legacyEncryptionDependencyForciblyRemoved to true."));
            return aVarB.a();
        }

        private b() {
        }
    }

    public InitializationStatus(@NotNull Status status, @Nullable Throwable th, boolean z, int i, @Nullable String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull List<String> initializedComponents, boolean z7) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(initializedComponents, "initializedComponents");
        this.status = status;
        this.unrecoverableException = th;
        this.locationsError = z;
        this.playServicesStatus = i;
        this.playServicesMessage = str;
        this.encryptionChanged = z2;
        this.storageError = z3;
        this.proximityError = z4;
        this.messagingPermissionError = z5;
        this.sslProviderEnablementError = z6;
        this.initializedComponents = initializedComponents;
        this.isUsable = z7;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encryptionChanged", imports = {}))
    public final boolean encryptionChanged() {
        return this.encryptionChanged;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "initializedComponents", imports = {}))
    public final List<String> initializedComponents() {
        return this.initializedComponents;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "isUsable", imports = {}))
    public final boolean isUsable() {
        return this.isUsable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "locationsError", imports = {}))
    public final boolean locationsError() {
        return this.locationsError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "messagingPermissionError", imports = {}))
    public final boolean messagingPermissionError() {
        return this.messagingPermissionError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "playServicesMessage", imports = {}))
    public final String playServicesMessage() {
        return this.playServicesMessage;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "playServicesStatus", imports = {}))
    public final int playServicesStatus() {
        return this.playServicesStatus;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityError", imports = {}))
    public final boolean proximityError() {
        return this.proximityError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslProviderEnablementError", imports = {}))
    public final boolean sslProviderEnablementError() {
        return this.sslProviderEnablementError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "status", imports = {}))
    public final Status status() {
        return this.status;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "storageError", imports = {}))
    public final boolean storageError() {
        return this.storageError;
    }

    public String toString() {
        return "InitializationStatus(status=" + this.status + ", unrecoverableException=" + this.unrecoverableException + ", locationsError=" + this.locationsError + ", playServicesStatus=" + this.playServicesStatus + ", playServicesMessage=" + this.playServicesMessage + ", encryptionChanged=" + this.encryptionChanged + ", storageError=" + this.storageError + ", proximityError=" + this.proximityError + ", messagingPermissionError=" + this.messagingPermissionError + ", sslProviderEnablementError=" + this.sslProviderEnablementError + ", initializedComponents=" + this.initializedComponents + ", isUsable=" + this.isUsable + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "unrecoverableException", imports = {}))
    public final Throwable unrecoverableException() {
        return this.unrecoverableException;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InitializationStatus(Status status, Throwable th, boolean z, int i, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List list, boolean z7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z8;
        if ((i2 & 2048) != 0) {
            z8 = status != Status.FAILED;
        } else {
            z8 = z7;
        }
        this(status, th, z, i, str, z2, z3, z4, z5, z6, list, z8);
    }
}
