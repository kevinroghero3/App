package com.facebook.gamingservices.model;

import ch.qos.logback.core.CoreConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class CustomUpdateLocalizedText {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final String f9default;
    private final HashMap<String, String> localizations;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateLocalizedText.f9default;
        }
        if ((i & 2) != 0) {
            map = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, map);
    }

    public final String component1() {
        return this.f9default;
    }

    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    public final CustomUpdateLocalizedText copy(@NotNull String str, @Nullable HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "default");
        return new CustomUpdateLocalizedText(str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) obj;
        return Intrinsics.areEqual(this.f9default, customUpdateLocalizedText.f9default) && Intrinsics.areEqual(this.localizations, customUpdateLocalizedText.localizations);
    }

    public int hashCode() {
        int iHashCode = this.f9default.hashCode();
        HashMap<String, String> map = this.localizations;
        return (iHashCode * 31) + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.f9default + ", localizations=" + this.localizations + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public CustomUpdateLocalizedText(@NotNull String str, @Nullable HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "default");
        this.f9default = str;
        this.localizations = map;
    }

    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map);
    }

    public final String getDefault() {
        return this.f9default;
    }

    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("default", this.f9default);
        HashMap<String, String> map = this.localizations;
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("localizations", jSONObject2);
        }
        return jSONObject;
    }
}
