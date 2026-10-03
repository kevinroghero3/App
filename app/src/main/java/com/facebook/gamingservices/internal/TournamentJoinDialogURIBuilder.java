package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.compose.DialogNavigator;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class TournamentJoinDialogURIBuilder {
    public static final TournamentJoinDialogURIBuilder INSTANCE = new TournamentJoinDialogURIBuilder();

    private TournamentJoinDialogURIBuilder() {
    }

    private final Uri.Builder baseUriBuilder() {
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority(FacebookSdk.getFacebookGamingDomain()).appendPath(DialogNavigator.NAME).appendPath("join_tournament");
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "Builder()\n              …ndPath(\"join_tournament\")");
        return builderAppendPath;
    }

    public static /* synthetic */ Uri uri$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return tournamentJoinDialogURIBuilder.uri$facebook_gamingservices_release(str, str2);
    }

    public final Uri uri$facebook_gamingservices_release(@Nullable String str, @Nullable String str2) {
        Uri.Builder builderBaseUriBuilder = baseUriBuilder();
        if (str != null) {
            builderBaseUriBuilder.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, str);
        }
        if (str2 != null) {
            builderBaseUriBuilder.appendQueryParameter("payload", str2);
        }
        Uri uriBuild = builderBaseUriBuilder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    public static /* synthetic */ Bundle bundle$facebook_gamingservices_release$default(TournamentJoinDialogURIBuilder tournamentJoinDialogURIBuilder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return tournamentJoinDialogURIBuilder.bundle$facebook_gamingservices_release(str, str2, str3);
    }

    public final Bundle bundle$facebook_gamingservices_release(@NotNull String appID, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString("deeplink", SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        if (str != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, str);
        }
        if (str2 != null) {
            bundle.putString("payload", str2);
        }
        return bundle;
    }
}
