package com.google.maps.android;

import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.LatLng;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class StreetViewUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Object fetchStreetViewData$default(Companion companion, LatLng latLng, String str, Source source, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                source = Source.DEFAULT;
            }
            return companion.fetchStreetViewData(latLng, str, source, continuation);
        }

        public final Object fetchStreetViewData(@NotNull LatLng latLng, @NotNull String str, @NotNull Source source, @NotNull Continuation<? super Status> continuation) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://maps.googleapis.com/maps/api/streetview/metadata");
            sb.append("?location=" + latLng.latitude + CoreConstants.COMMA_CHAR + latLng.longitude);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("&key=");
            sb2.append(str);
            sb.append(sb2.toString());
            sb.append("&source=" + source.getValue());
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return BuildersKt.withContext(Dispatchers.getIO(), new StreetViewUtils$Companion$fetchStreetViewData$2(string, null), continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ResponseStreetView deserializeResponse(String str) {
            String statusString = new JSONObject(str).optString("status");
            Intrinsics.checkNotNullExpressionValue(statusString, "statusString");
            return new ResponseStreetView(Status.valueOf(statusString));
        }
    }
}
