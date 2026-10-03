package com.salesforce.marketingcloud;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.maps.android.BuildConfig;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.proximity.ProximityNotificationCustomizationOptions;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleConfig;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class MarketingCloudConfig extends PushModuleConfig {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = g.a("MarketingCloudConfig");
    public final String accessToken;
    public final boolean analyticsEnabled;
    private final String appPackageName;
    private final String appVersionName;
    public final String applicationId;
    public final boolean delayRegistrationUntilContactKeyIsSet;
    public final boolean geofencingEnabled;
    public final boolean inboxEnabled;
    private final boolean legacyEncryptionDependencyForciblyRemoved;
    public final boolean markMessageReadOnInboxNotificationOpen;
    public final String marketingCloudServerUrl;
    public final String mid;
    public final NotificationCustomizationOptions notificationCustomizationOptions;
    public final boolean piAnalyticsEnabled;
    private final String predictiveIntelligenceServerUrl;
    public final boolean proximityEnabled;
    public final ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions;
    public final String senderId;
    public final UrlHandler urlHandler;
    public final boolean useLegacyPiIdentifier;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }

        private Companion() {
        }
    }

    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ InitializationStatus b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InitializationStatus initializationStatus) {
            super(0);
            this.b = initializationStatus;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "InitializationStatus: " + this.b;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketingCloudConfig(@NotNull String applicationId, @NotNull String accessToken, @Nullable String str, @NotNull String marketingCloudServerUrl, @Nullable String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull NotificationCustomizationOptions notificationCustomizationOptions, @Nullable ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions, @Nullable UrlHandler urlHandler, @NotNull String appPackageName, @NotNull String appVersionName, @NotNull String predictiveIntelligenceServerUrl, boolean z9) {
        super(applicationId);
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
        Intrinsics.checkNotNullParameter(notificationCustomizationOptions, "notificationCustomizationOptions");
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(predictiveIntelligenceServerUrl, "predictiveIntelligenceServerUrl");
        this.applicationId = applicationId;
        this.accessToken = accessToken;
        this.senderId = str;
        this.marketingCloudServerUrl = marketingCloudServerUrl;
        this.mid = str2;
        this.analyticsEnabled = z;
        this.geofencingEnabled = z2;
        this.inboxEnabled = z3;
        this.piAnalyticsEnabled = z4;
        this.proximityEnabled = z5;
        this.markMessageReadOnInboxNotificationOpen = z6;
        this.delayRegistrationUntilContactKeyIsSet = z7;
        this.useLegacyPiIdentifier = z8;
        this.notificationCustomizationOptions = notificationCustomizationOptions;
        this.proximityNotificationCustomizationOptions = proximityNotificationCustomizationOptions;
        this.urlHandler = urlHandler;
        this.appPackageName = appPackageName;
        this.appVersionName = appVersionName;
        this.predictiveIntelligenceServerUrl = predictiveIntelligenceServerUrl;
        this.legacyEncryptionDependencyForciblyRemoved = z9;
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(final ModuleReadyListener listener, InitializationStatus it2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(it2, "it");
        g.e(g.a, TAG, null, new a(it2), 2, null);
        MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() { // from class: com.salesforce.marketingcloud.MarketingCloudConfig$$ExternalSyntheticLambda1
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
            public final void ready(MarketingCloudSdk marketingCloudSdk) {
                MarketingCloudConfig.init$lambda$1$lambda$0(listener, marketingCloudSdk);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1$lambda$0(ModuleReadyListener listener, MarketingCloudSdk sdk) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        listener.ready(sdk);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "accessToken", imports = {}))
    public final String accessToken() {
        return this.accessToken;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "analyticsEnabled", imports = {}))
    public final boolean analyticsEnabled() {
        return this.analyticsEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final String appPackageName() {
        return this.appPackageName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final String appVersionName() {
        return this.appVersionName;
    }

    public final boolean applicationChanged$sdk_release(@NotNull MarketingCloudConfig other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return (Intrinsics.areEqual(this.applicationId, other.applicationId) && Intrinsics.areEqual(this.accessToken, other.accessToken)) ? false : true;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = com.salesforce.marketingcloud.analytics.stats.d.b, imports = {}))
    public final String applicationId() {
        return this.applicationId;
    }

    public final String component1() {
        return this.applicationId;
    }

    public final boolean component10() {
        return this.proximityEnabled;
    }

    public final boolean component11() {
        return this.markMessageReadOnInboxNotificationOpen;
    }

    public final boolean component12() {
        return this.delayRegistrationUntilContactKeyIsSet;
    }

    public final boolean component13() {
        return this.useLegacyPiIdentifier;
    }

    public final NotificationCustomizationOptions component14() {
        return this.notificationCustomizationOptions;
    }

    public final ProximityNotificationCustomizationOptions component15() {
        return this.proximityNotificationCustomizationOptions;
    }

    public final UrlHandler component16() {
        return this.urlHandler;
    }

    public final String component17$sdk_release() {
        return this.appPackageName;
    }

    public final String component18$sdk_release() {
        return this.appVersionName;
    }

    public final String component19$sdk_release() {
        return this.predictiveIntelligenceServerUrl;
    }

    public final String component2() {
        return this.accessToken;
    }

    public final boolean component20$sdk_release() {
        return this.legacyEncryptionDependencyForciblyRemoved;
    }

    public final String component3() {
        return this.senderId;
    }

    public final String component4() {
        return this.marketingCloudServerUrl;
    }

    public final String component5() {
        return this.mid;
    }

    public final boolean component6() {
        return this.analyticsEnabled;
    }

    public final boolean component7() {
        return this.geofencingEnabled;
    }

    public final boolean component8() {
        return this.inboxEnabled;
    }

    public final boolean component9() {
        return this.piAnalyticsEnabled;
    }

    public final MarketingCloudConfig copy(@NotNull String applicationId, @NotNull String accessToken, @Nullable String str, @NotNull String marketingCloudServerUrl, @Nullable String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull NotificationCustomizationOptions notificationCustomizationOptions, @Nullable ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions, @Nullable UrlHandler urlHandler, @NotNull String appPackageName, @NotNull String appVersionName, @NotNull String predictiveIntelligenceServerUrl, boolean z9) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
        Intrinsics.checkNotNullParameter(notificationCustomizationOptions, "notificationCustomizationOptions");
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(predictiveIntelligenceServerUrl, "predictiveIntelligenceServerUrl");
        return new MarketingCloudConfig(applicationId, accessToken, str, marketingCloudServerUrl, str2, z, z2, z3, z4, z5, z6, z7, z8, notificationCustomizationOptions, proximityNotificationCustomizationOptions, urlHandler, appPackageName, appVersionName, predictiveIntelligenceServerUrl, z9);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delayRegistrationUntilContactKeyIsSet", imports = {}))
    public final boolean delayRegistrationUntilContactKeyIsSet() {
        return this.delayRegistrationUntilContactKeyIsSet;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketingCloudConfig)) {
            return false;
        }
        MarketingCloudConfig marketingCloudConfig = (MarketingCloudConfig) obj;
        return Intrinsics.areEqual(this.applicationId, marketingCloudConfig.applicationId) && Intrinsics.areEqual(this.accessToken, marketingCloudConfig.accessToken) && Intrinsics.areEqual(this.senderId, marketingCloudConfig.senderId) && Intrinsics.areEqual(this.marketingCloudServerUrl, marketingCloudConfig.marketingCloudServerUrl) && Intrinsics.areEqual(this.mid, marketingCloudConfig.mid) && this.analyticsEnabled == marketingCloudConfig.analyticsEnabled && this.geofencingEnabled == marketingCloudConfig.geofencingEnabled && this.inboxEnabled == marketingCloudConfig.inboxEnabled && this.piAnalyticsEnabled == marketingCloudConfig.piAnalyticsEnabled && this.proximityEnabled == marketingCloudConfig.proximityEnabled && this.markMessageReadOnInboxNotificationOpen == marketingCloudConfig.markMessageReadOnInboxNotificationOpen && this.delayRegistrationUntilContactKeyIsSet == marketingCloudConfig.delayRegistrationUntilContactKeyIsSet && this.useLegacyPiIdentifier == marketingCloudConfig.useLegacyPiIdentifier && Intrinsics.areEqual(this.notificationCustomizationOptions, marketingCloudConfig.notificationCustomizationOptions) && Intrinsics.areEqual(this.proximityNotificationCustomizationOptions, marketingCloudConfig.proximityNotificationCustomizationOptions) && Intrinsics.areEqual(this.urlHandler, marketingCloudConfig.urlHandler) && Intrinsics.areEqual(this.appPackageName, marketingCloudConfig.appPackageName) && Intrinsics.areEqual(this.appVersionName, marketingCloudConfig.appVersionName) && Intrinsics.areEqual(this.predictiveIntelligenceServerUrl, marketingCloudConfig.predictiveIntelligenceServerUrl) && this.legacyEncryptionDependencyForciblyRemoved == marketingCloudConfig.legacyEncryptionDependencyForciblyRemoved;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "geofencingEnabled", imports = {}))
    public final boolean geofencingEnabled() {
        return this.geofencingEnabled;
    }

    public final String getAppPackageName$sdk_release() {
        return this.appPackageName;
    }

    public final String getAppVersionName$sdk_release() {
        return this.appVersionName;
    }

    public final boolean getLegacyEncryptionDependencyForciblyRemoved$sdk_release() {
        return this.legacyEncryptionDependencyForciblyRemoved;
    }

    public final String getPredictiveIntelligenceServerUrl$sdk_release() {
        return this.predictiveIntelligenceServerUrl;
    }

    public int hashCode() {
        int iHashCode = this.applicationId.hashCode();
        int iHashCode2 = this.accessToken.hashCode();
        String str = this.senderId;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        int iHashCode4 = this.marketingCloudServerUrl.hashCode();
        String str2 = this.mid;
        int iHashCode5 = str2 == null ? 0 : str2.hashCode();
        int iHashCode6 = Boolean.hashCode(this.analyticsEnabled);
        int iHashCode7 = Boolean.hashCode(this.geofencingEnabled);
        int iHashCode8 = Boolean.hashCode(this.inboxEnabled);
        int iHashCode9 = Boolean.hashCode(this.piAnalyticsEnabled);
        int iHashCode10 = Boolean.hashCode(this.proximityEnabled);
        int iHashCode11 = Boolean.hashCode(this.markMessageReadOnInboxNotificationOpen);
        int iHashCode12 = Boolean.hashCode(this.delayRegistrationUntilContactKeyIsSet);
        int iHashCode13 = Boolean.hashCode(this.useLegacyPiIdentifier);
        int iHashCode14 = this.notificationCustomizationOptions.hashCode();
        ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = this.proximityNotificationCustomizationOptions;
        int iHashCode15 = proximityNotificationCustomizationOptions == null ? 0 : proximityNotificationCustomizationOptions.hashCode();
        UrlHandler urlHandler = this.urlHandler;
        return (((((((((((((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + iHashCode10) * 31) + iHashCode11) * 31) + iHashCode12) * 31) + iHashCode13) * 31) + iHashCode14) * 31) + iHashCode15) * 31) + (urlHandler == null ? 0 : urlHandler.hashCode())) * 31) + this.appPackageName.hashCode()) * 31) + this.appVersionName.hashCode()) * 31) + this.predictiveIntelligenceServerUrl.hashCode()) * 31) + Boolean.hashCode(this.legacyEncryptionDependencyForciblyRemoved);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "inboxEnabled", imports = {}))
    public final boolean inboxEnabled() {
        return this.inboxEnabled;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.Config
    public void init(@NotNull Context context, @NotNull SFMCSdkComponents components, @NotNull final ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MarketingCloudSdk.b(context, this, components, new MarketingCloudSdk.InitializationListener() { // from class: com.salesforce.marketingcloud.MarketingCloudConfig$$ExternalSyntheticLambda0
            @Override // com.salesforce.marketingcloud.MarketingCloudSdk.InitializationListener
            public final void complete(InitializationStatus initializationStatus) {
                MarketingCloudConfig.init$lambda$1(listener, initializationStatus);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final boolean legacyEncryptionDependencyForciblyRemoved() {
        return this.legacyEncryptionDependencyForciblyRemoved;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "markMessageReadOnInboxNotificationOpen", imports = {}))
    public final boolean markMessageReadOnInboxNotificationOpen() {
        return this.markMessageReadOnInboxNotificationOpen;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "marketingCloudServerUrl", imports = {}))
    public final String marketingCloudServerUrl() {
        return this.marketingCloudServerUrl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mid", imports = {}))
    public final String mid() {
        return this.mid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "notificationCustomizationOptions", imports = {}))
    public final NotificationCustomizationOptions notificationCustomizationOptions() {
        return this.notificationCustomizationOptions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "piAnalyticsEnabled", imports = {}))
    public final boolean piAnalyticsEnabled() {
        return this.piAnalyticsEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "to be removed")
    public final String predictiveIntelligenceServerUrl() {
        return this.predictiveIntelligenceServerUrl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityEnabled", imports = {}))
    public final boolean proximityEnabled() {
        return this.proximityEnabled;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityNotificationCustomizationOptions", imports = {}))
    public final ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions() {
        return this.proximityNotificationCustomizationOptions;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "senderId", imports = {}))
    public final String senderId() {
        return this.senderId;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "MarketingCloudConfig(applicationId=" + this.applicationId + ", accessToken=" + this.accessToken + ", senderId=" + this.senderId + ", marketingCloudServerUrl=" + this.marketingCloudServerUrl + ", mid=" + this.mid + ", analyticsEnabled=" + this.analyticsEnabled + ", geofencingEnabled=" + this.geofencingEnabled + ", inboxEnabled=" + this.inboxEnabled + ", piAnalyticsEnabled=" + this.piAnalyticsEnabled + ", proximityEnabled=" + this.proximityEnabled + ", markMessageReadOnInboxNotificationOpen=" + this.markMessageReadOnInboxNotificationOpen + ", delayRegistrationUntilContactKeyIsSet=" + this.delayRegistrationUntilContactKeyIsSet + ", useLegacyPiIdentifier=" + this.useLegacyPiIdentifier + ", notificationCustomizationOptions=" + this.notificationCustomizationOptions + ", proximityNotificationCustomizationOptions=" + this.proximityNotificationCustomizationOptions + ", urlHandler=" + this.urlHandler + ", appPackageName=" + this.appPackageName + ", appVersionName=" + this.appVersionName + ", predictiveIntelligenceServerUrl=" + this.predictiveIntelligenceServerUrl + ", legacyEncryptionDependencyForciblyRemoved=" + this.legacyEncryptionDependencyForciblyRemoved + ")";
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "urlHandler", imports = {}))
    public final UrlHandler urlHandler() {
        return this.urlHandler;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "useLegacyPiIdentifier", imports = {}))
    public final boolean useLegacyPiIdentifier() {
        return this.useLegacyPiIdentifier;
    }

    public static final class Builder {
        private static final int ACCESS_TOKEN_LENGTH = 24;
        private static final String INITIAL_PI_VALUE = "";
        private static final String TSE_ERROR_MSG = "An App Endpoint (the Marketing Cloud Server URL) is required in order to configure the SDK. See http://salesforce-marketingcloud.github.io/MarketingCloudSDK-Android for more information.";
        private String accessToken;
        private boolean analyticsEnabled;
        private String applicationId;
        private boolean delayRegistrationUntilContactKeyIsSet;
        private boolean geofencingEnabled;
        private boolean inboxEnabled;
        private boolean legacyEncryptionDependencyForciblyRemoved;
        private boolean markMessageReadOnInboxNotificationOpen;
        private String marketingCloudServerUrl;
        private String mid;
        private NotificationCustomizationOptions notificationCustomizationOptions;
        private boolean piAnalyticsEnabled;
        private String predictiveIntelligenceServerUrl;
        private boolean proximityEnabled;
        private ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions;
        private String senderId;
        private UrlHandler urlHandler;
        private boolean useLegacyPiIdentifier;
        public static final a Companion = new a(null);
        private static final Regex APP_ID_REGEX = new Regex("[0-9a-f]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}");

        /* JADX INFO: loaded from: classes3.dex */
        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private a() {
            }
        }

        public Builder() {
            this.markMessageReadOnInboxNotificationOpen = true;
            this.useLegacyPiIdentifier = true;
            this.predictiveIntelligenceServerUrl = "";
        }

        private final String checkNotEmpty(String str, Function0<? extends Object> function0) {
            if (str == null || TextUtils.getTrimmedLength(str) != 0) {
                return str;
            }
            throw new IllegalStateException(function0.invoke().toString());
        }

        private final String checkNotNullOrEmpty(String str, Function0<? extends Object> function0) {
            if (str == null || TextUtils.getTrimmedLength(str) == 0) {
                throw new IllegalStateException(function0.invoke().toString());
            }
            return str;
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00a9  */
        public final MarketingCloudConfig build(@NotNull Context context) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            String packageName = context.getPackageName();
            try {
                str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
                if (str == null) {
                    str = BuildConfig.TRAVIS;
                }
            } catch (Exception unused) {
            }
            String str3 = str;
            String str4 = this.applicationId;
            if (str4 == null) {
                throw new IllegalStateException("applicationId == null");
            }
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = str4.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!APP_ID_REGEX.matches(lowerCase)) {
                throw new IllegalArgumentException("The applicationId is not a valid UUID.");
            }
            String str5 = this.accessToken;
            if (str5 == null) {
                throw new IllegalStateException("accessToken == null");
            }
            if (str5.length() != 24) {
                throw new IllegalArgumentException("The accessToken must be 24 characters.");
            }
            String str6 = this.marketingCloudServerUrl;
            if (str6 == null || TextUtils.getTrimmedLength(str6) == 0) {
                throw new IllegalStateException(TSE_ERROR_MSG);
            }
            if (!URLUtil.isNetworkUrl(str6)) {
                throw new IllegalArgumentException(TSE_ERROR_MSG);
            }
            if (Intrinsics.areEqual(this.predictiveIntelligenceServerUrl, "")) {
                String str7 = this.mid;
                if (str7 != null) {
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase2 = str7.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase2, "-", 0, false, 6, (Object) null);
                    String string = iIndexOf$default != -1 ? str7.subSequence(0, iIndexOf$default).toString() : str7;
                    this.mid = string;
                    str2 = "https://" + str7 + ".collect.igodigital.com/c2/" + string + "/process_batch.json";
                    if (str2 == null) {
                        str2 = "https://app.igodigital.com/api/v1/collect/process_batch";
                    }
                } else {
                    str2 = "https://app.igodigital.com/api/v1/collect/process_batch";
                }
                this.predictiveIntelligenceServerUrl = str2;
            }
            String str8 = this.senderId;
            if (str8 != null && TextUtils.getTrimmedLength(str8) == 0) {
                throw new IllegalStateException("The senderId cannot be empty.");
            }
            String str9 = this.mid;
            if (str9 != null && TextUtils.getTrimmedLength(str9) == 0) {
                throw new IllegalStateException("MID must not be empty.");
            }
            boolean z = this.analyticsEnabled;
            boolean z2 = this.geofencingEnabled;
            boolean z3 = this.inboxEnabled;
            boolean z4 = this.piAnalyticsEnabled;
            boolean z5 = this.proximityEnabled;
            boolean z6 = this.markMessageReadOnInboxNotificationOpen;
            boolean z7 = this.delayRegistrationUntilContactKeyIsSet;
            boolean z8 = this.useLegacyPiIdentifier;
            NotificationCustomizationOptions notificationCustomizationOptions = this.notificationCustomizationOptions;
            if (notificationCustomizationOptions == null) {
                throw new IllegalStateException("notificationCustomizationOptions == null");
            }
            UrlHandler urlHandler = this.urlHandler;
            String str10 = this.predictiveIntelligenceServerUrl;
            ProximityNotificationCustomizationOptions proximityNotificationCustomizationOptions = this.proximityNotificationCustomizationOptions;
            boolean z9 = this.legacyEncryptionDependencyForciblyRemoved;
            Intrinsics.checkNotNull(packageName);
            return new MarketingCloudConfig(str4, str5, str8, str6, str9, z, z2, z3, z4, z5, z6, z7, z8, notificationCustomizationOptions, proximityNotificationCustomizationOptions, urlHandler, packageName, str3, str10, z9);
        }

        public final Builder setAccessToken(@NotNull String accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            this.accessToken = accessToken;
            return this;
        }

        public final Builder setAnalyticsEnabled(boolean z) {
            this.analyticsEnabled = z;
            return this;
        }

        public final Builder setApplicationId(@NotNull String applicationId) {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            this.applicationId = applicationId;
            return this;
        }

        public final Builder setDelayRegistrationUntilContactKeyIsSet(boolean z) {
            this.delayRegistrationUntilContactKeyIsSet = z;
            return this;
        }

        public final Builder setGeofencingEnabled(boolean z) {
            this.geofencingEnabled = z;
            return this;
        }

        public final Builder setInboxEnabled(boolean z) {
            this.inboxEnabled = z;
            return this;
        }

        public final Builder setLegacyEncryptionDependencyForciblyRemoved(boolean z) {
            this.legacyEncryptionDependencyForciblyRemoved = z;
            return this;
        }

        public final Builder setMarkMessageReadOnInboxNotificationOpen(boolean z) {
            this.markMessageReadOnInboxNotificationOpen = z;
            return this;
        }

        public final Builder setMarketingCloudServerUrl(@NotNull String marketingCloudServerUrl) {
            Intrinsics.checkNotNullParameter(marketingCloudServerUrl, "marketingCloudServerUrl");
            this.marketingCloudServerUrl = marketingCloudServerUrl;
            return this;
        }

        public final Builder setMid(@NotNull String mid) {
            Intrinsics.checkNotNullParameter(mid, "mid");
            this.mid = mid;
            return this;
        }

        public final Builder setNotificationCustomizationOptions(@NotNull NotificationCustomizationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.notificationCustomizationOptions = options;
            return this;
        }

        public final Builder setPiAnalyticsEnabled(boolean z) {
            this.piAnalyticsEnabled = z;
            return this;
        }

        public final Builder setPredictiveIntelligenceServerUrl(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.predictiveIntelligenceServerUrl = url;
            return this;
        }

        public final Builder setProximityEnabled(boolean z) {
            this.proximityEnabled = z;
            return this;
        }

        public final Builder setProximityNotificationOptions(@NotNull ProximityNotificationCustomizationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.proximityNotificationCustomizationOptions = options;
            return this;
        }

        public final Builder setSenderId(@NotNull String senderId) {
            Intrinsics.checkNotNullParameter(senderId, "senderId");
            this.senderId = senderId;
            return this;
        }

        public final Builder setUrlHandler(@NotNull UrlHandler urlHandler) {
            Intrinsics.checkNotNullParameter(urlHandler, "urlHandler");
            this.urlHandler = urlHandler;
            return this;
        }

        public final Builder setUseLegacyPiIdentifier(boolean z) {
            this.useLegacyPiIdentifier = z;
            return this;
        }

        public Builder(@NotNull MarketingCloudConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.markMessageReadOnInboxNotificationOpen = true;
            this.useLegacyPiIdentifier = true;
            this.applicationId = config.applicationId;
            this.accessToken = config.accessToken;
            this.senderId = config.senderId;
            this.marketingCloudServerUrl = config.marketingCloudServerUrl;
            this.mid = config.mid;
            this.analyticsEnabled = config.analyticsEnabled;
            this.geofencingEnabled = config.geofencingEnabled;
            this.inboxEnabled = config.inboxEnabled;
            this.piAnalyticsEnabled = config.piAnalyticsEnabled;
            this.proximityEnabled = config.proximityEnabled;
            this.markMessageReadOnInboxNotificationOpen = config.markMessageReadOnInboxNotificationOpen;
            this.delayRegistrationUntilContactKeyIsSet = config.delayRegistrationUntilContactKeyIsSet;
            this.useLegacyPiIdentifier = config.useLegacyPiIdentifier;
            this.notificationCustomizationOptions = config.notificationCustomizationOptions;
            this.proximityNotificationCustomizationOptions = config.proximityNotificationCustomizationOptions;
            this.urlHandler = config.urlHandler;
            this.predictiveIntelligenceServerUrl = config.getPredictiveIntelligenceServerUrl$sdk_release();
            this.legacyEncryptionDependencyForciblyRemoved = config.getLegacyEncryptionDependencyForciblyRemoved$sdk_release();
        }
    }
}
