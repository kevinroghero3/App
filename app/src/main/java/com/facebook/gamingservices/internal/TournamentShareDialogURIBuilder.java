package com.facebook.gamingservices.internal;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.gamingservices.TournamentConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class TournamentShareDialogURIBuilder {
    public static final TournamentShareDialogURIBuilder INSTANCE = new TournamentShareDialogURIBuilder();
    public static final String authority = "fb.gg";
    public static final String me = "me";
    public static final String scheme = "https";
    public static final String tournament = "instant_tournament";

    private TournamentShareDialogURIBuilder() {
    }

    public final Uri uriForUpdating$facebook_gamingservices_release(@NotNull String tournamentID, @NotNull Number score, @NotNull String appID) {
        Intrinsics.checkNotNullParameter(tournamentID, "tournamentID");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Uri uriBuild = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(me).appendPath(tournament).appendPath(appID).appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID).appendQueryParameter("score", score.toString()).build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "Builder()\n        .schem…tring())\n        .build()");
        return uriBuild;
    }

    public final Uri uriForCreating$facebook_gamingservices_release(@NotNull TournamentConfig config, @NotNull Number score, @NotNull String appID) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").authority("fb.gg").appendPath(me).appendPath(tournament).appendPath(appID).appendQueryParameter("score", score.toString());
        Instant endTime = config.getEndTime();
        if (endTime != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_END_TIME, endTime.toString());
        }
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_TITLE, title);
        }
        String payload = config.getPayload();
        if (payload != null) {
            builderAppendQueryParameter.appendQueryParameter(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload);
        }
        Uri uriBuild = builderAppendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    public final Bundle bundleForUpdating$facebook_gamingservices_release(@NotNull String tournamentID, @NotNull Number score, @NotNull String appID) {
        Intrinsics.checkNotNullParameter(tournamentID, "tournamentID");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString("deeplink", SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        bundle.putString("score", score.toString());
        bundle.putString(SDKConstants.PARAM_TOURNAMENTS_ID, tournamentID);
        return bundle;
    }

    public final Bundle bundleForCreating$facebook_gamingservices_release(@NotNull TournamentConfig config, @NotNull Number score, @NotNull String appID) {
        Instant endTime;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(appID, "appID");
        Bundle bundle = new Bundle();
        bundle.putString("deeplink", SDKConstants.PARAM_TOURNAMENTS);
        bundle.putString("app_id", appID);
        bundle.putString("score", score.toString());
        TournamentSortOrder sortOrder = config.getSortOrder();
        if (sortOrder != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SORT_ORDER, sortOrder.toString());
        }
        TournamentScoreType scoreType = config.getScoreType();
        if (scoreType != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_SCORE_FORMAT, scoreType.toString());
        }
        String title = config.getTitle();
        if (title != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_TITLE, title.toString());
        }
        String payload = config.getPayload();
        if (payload != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD, payload.toString());
        }
        if (Build.VERSION.SDK_INT >= 26 && (endTime = config.getEndTime()) != null) {
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_END_TIME, String.valueOf((int) endTime.getEpochSecond()));
        }
        return bundle;
    }
}
