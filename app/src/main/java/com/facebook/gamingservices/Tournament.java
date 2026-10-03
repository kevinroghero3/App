package com.facebook.gamingservices;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.google.gson.annotations.SerializedName;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Tournament implements ShareModel {
    public static final CREATOR CREATOR = new CREATOR(null);

    @SerializedName("tournament_end_time")
    public String endTime;

    @SerializedName("id")
    public final String identifier;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD)
    public final String payload;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_TITLE)
    public final String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final ZonedDateTime getExpiration() {
        String str = this.endTime;
        if (str != null) {
            return DateFormatter.INSTANCE.format$facebook_gamingservices_release(str);
        }
        return null;
    }

    private final void setExpiration(ZonedDateTime zonedDateTime) {
        if (Build.VERSION.SDK_INT < 26 || zonedDateTime == null) {
            return;
        }
        this.endTime = zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        setExpiration(zonedDateTime);
    }

    public Tournament(@NotNull String identifier, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.endTime = str;
        this.title = str2;
        this.payload = str3;
        setExpiration(str != null ? DateFormatter.INSTANCE.format$facebook_gamingservices_release(str) : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Tournament(@NotNull Parcel parcel) {
        this(parcel.toString(), parcel.toString(), parcel.toString(), parcel.toString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public static final class Builder implements ShareModelBuilder<Tournament, Builder> {
        private String endTime;
        private ZonedDateTime expiration;
        private String identifier;
        private String payload;
        private String title;

        public static /* synthetic */ Builder copy$default(Builder builder, String str, ZonedDateTime zonedDateTime, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.identifier;
            }
            if ((i & 2) != 0) {
                zonedDateTime = builder.expiration;
            }
            if ((i & 4) != 0) {
                str2 = builder.title;
            }
            if ((i & 8) != 0) {
                str3 = builder.payload;
            }
            return builder.copy(str, zonedDateTime, str2, str3);
        }

        public final String component1() {
            return this.identifier;
        }

        public final ZonedDateTime component2() {
            return this.expiration;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.payload;
        }

        public final Builder copy(@NotNull String identifier, @Nullable ZonedDateTime zonedDateTime, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Builder(identifier, zonedDateTime, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.identifier, builder.identifier) && Intrinsics.areEqual(this.expiration, builder.expiration) && Intrinsics.areEqual(this.title, builder.title) && Intrinsics.areEqual(this.payload, builder.payload);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode();
            ZonedDateTime zonedDateTime = this.expiration;
            int iHashCode2 = zonedDateTime == null ? 0 : zonedDateTime.hashCode();
            String str = this.title;
            int iHashCode3 = str == null ? 0 : str.hashCode();
            String str2 = this.payload;
            return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Builder(identifier=" + this.identifier + ", expiration=" + this.expiration + ", title=" + this.title + ", payload=" + this.payload + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Builder(@NotNull String identifier, @Nullable ZonedDateTime zonedDateTime, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.expiration = zonedDateTime;
            this.title = str;
            this.payload = str2;
        }

        public /* synthetic */ Builder(String str, ZonedDateTime zonedDateTime, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : zonedDateTime, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final void setIdentifier(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.identifier = str;
        }

        public final ZonedDateTime getExpiration() {
            return this.expiration;
        }

        public final void setExpiration(@Nullable ZonedDateTime zonedDateTime) {
            this.expiration = zonedDateTime;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@Nullable String str) {
            this.title = str;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final void setPayload(@Nullable String str) {
            this.payload = str;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final void setEndTime(@Nullable String str) {
            this.endTime = str;
        }

        public final Builder identifier(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            return this;
        }

        public final Builder expiration(@Nullable ZonedDateTime zonedDateTime) {
            this.expiration = zonedDateTime;
            if (Build.VERSION.SDK_INT >= 26 && zonedDateTime != null) {
                this.endTime = zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
            }
            return this;
        }

        public final Builder title(@Nullable String str) {
            this.title = str;
            return this;
        }

        public final Builder payload(@Nullable String str) {
            this.payload = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public Tournament build() {
            return new Tournament(this.identifier, this.endTime, this.title, this.payload);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(@Nullable Tournament tournament) {
            Builder builderPayload;
            return (tournament == null || (builderPayload = identifier(tournament.identifier).expiration(tournament.getExpiration()).title(tournament.title).payload(tournament.payload)) == null) ? this : builderPayload;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.identifier);
        out.writeString(this.endTime);
        out.writeString(this.title);
        out.writeString(this.payload);
    }

    public static final class CREATOR implements Parcelable.Creator<Tournament> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Tournament createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Tournament(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Tournament[] newArray(int i) {
            return new Tournament[i];
        }
    }
}
