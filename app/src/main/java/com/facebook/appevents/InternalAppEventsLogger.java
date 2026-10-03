package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class InternalAppEventsLogger {
    public static final Companion Companion = new Companion(null);
    private final AppEventsLoggerImpl loggerImpl;

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(@Nullable Context context) {
        return Companion.createInstance(context);
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(@Nullable Context context, @Nullable String str) {
        return Companion.createInstance(context, str);
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(@NotNull String str, @Nullable String str2, @Nullable AccessToken accessToken) {
        return Companion.createInstance(str, str2, accessToken);
    }

    @JvmStatic
    public static final Executor getAnalyticsExecutor() {
        return Companion.getAnalyticsExecutor();
    }

    @JvmStatic
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @JvmStatic
    public static final String getPushNotificationsRegistrationId() {
        return Companion.getPushNotificationsRegistrationId();
    }

    @JvmStatic
    public static final void setInternalUserData(@NotNull Map<String, String> map) {
        Companion.setInternalUserData(map);
    }

    @JvmStatic
    public static final void setUserData(@Nullable Bundle bundle) {
        Companion.setUserData(bundle);
    }

    public InternalAppEventsLogger(@NotNull AppEventsLoggerImpl loggerImpl) {
        Intrinsics.checkNotNullParameter(loggerImpl, "loggerImpl");
        this.loggerImpl = loggerImpl;
    }

    public InternalAppEventsLogger(@Nullable Context context) {
        this(new AppEventsLoggerImpl(context, (String) null, (AccessToken) null));
    }

    public InternalAppEventsLogger(@Nullable Context context, @Nullable String str) {
        this(new AppEventsLoggerImpl(context, str, (AccessToken) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InternalAppEventsLogger(@NotNull String activityName, @Nullable String str, @Nullable AccessToken accessToken) {
        this(new AppEventsLoggerImpl(activityName, str, accessToken));
        Intrinsics.checkNotNullParameter(activityName, "activityName");
    }

    public final void logEvent(@Nullable String str, @Nullable Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, bundle);
        }
    }

    public final void logEvent(@Nullable String str, double d, @Nullable Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, d, bundle);
        }
    }

    public static /* synthetic */ void logPurchaseImplicitly$default(InternalAppEventsLogger internalAppEventsLogger, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i, Object obj) {
        if ((i & 8) != 0) {
            operationalData = null;
        }
        internalAppEventsLogger.logPurchaseImplicitly(bigDecimal, currency, bundle, operationalData);
    }

    public final void logPurchaseImplicitly(@Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable Bundle bundle, @Nullable OperationalData operationalData) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(bigDecimal, currency, bundle, operationalData);
        }
    }

    public final void logEventFromSE(@Nullable String str, @Nullable String str2) {
        this.loggerImpl.logEventFromSE(str, str2);
    }

    public static /* synthetic */ void logEventImplicitly$default(InternalAppEventsLogger internalAppEventsLogger, String str, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i, Object obj) {
        if ((i & 16) != 0) {
            operationalData = null;
        }
        internalAppEventsLogger.logEventImplicitly(str, bigDecimal, currency, bundle, operationalData);
    }

    public final void logEventImplicitly(@Nullable String str, @Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable Bundle bundle, @Nullable OperationalData operationalData) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, bigDecimal, currency, bundle, operationalData);
        }
    }

    public final void logEventImplicitly(@Nullable String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, null);
        }
    }

    public final void logEventImplicitly(@Nullable String str, @Nullable Double d, @Nullable Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, d, bundle);
        }
    }

    public final void logEventImplicitly(@Nullable String str, @Nullable Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, bundle);
        }
    }

    public final void logChangedSettingsEvent(@NotNull Bundle parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if ((parameters.getInt("previous") & 2) == 0 && !FacebookSdk.getAutoLogAppEventsEnabled()) {
            return;
        }
        this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", null, parameters);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(@Nullable Context context) {
            return createInstance$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @JvmStatic
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }

        @JvmStatic
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }

        @JvmStatic
        public final void setUserData(@Nullable Bundle bundle) {
            UserDataStore.setUserDataAndHash(bundle);
        }

        @JvmStatic
        public final void setInternalUserData(@NotNull Map<String, String> ud) {
            Intrinsics.checkNotNullParameter(ud, "ud");
            UserDataStore.setInternalUd(ud);
        }

        public static /* synthetic */ InternalAppEventsLogger createInstance$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.createInstance(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(@Nullable Context context, @Nullable String str) {
            return new InternalAppEventsLogger(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(@NotNull String activityName, @Nullable String str, @Nullable AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            return new InternalAppEventsLogger(activityName, str, accessToken);
        }
    }
}
