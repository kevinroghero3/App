package com.salesforce.marketingcloud.sfmcsdk.components.identity;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Profile {
    private final Map<String, String> attributes;
    private final String profileId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Profile copy$default(Profile profile, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profile.profileId;
        }
        if ((i & 2) != 0) {
            map = profile.attributes;
        }
        return profile.copy(str, map);
    }

    public final String component1() {
        return this.profileId;
    }

    public final Map<String, String> component2() {
        return this.attributes;
    }

    public final Profile copy(@NotNull String profileId, @NotNull Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new Profile(profileId, attributes);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return Intrinsics.areEqual(this.profileId, profile.profileId) && Intrinsics.areEqual(this.attributes, profile.attributes);
    }

    public int hashCode() {
        return (this.profileId.hashCode() * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "Profile(profileId=" + this.profileId + ", attributes=" + this.attributes + ")";
    }

    public Profile(@NotNull String profileId, @NotNull Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.profileId = profileId;
        this.attributes = attributes;
    }

    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    public final String getProfileId() {
        return this.profileId;
    }
}
