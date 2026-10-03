package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.dto.domain.VtsCreditCardDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class VtsCreditCard implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsCreditCard> CREATOR = new a();
    private String cardExpiry;
    private String cardIssuer;
    private String cardOwnerFirstName;
    private String cardOwnerLastName;
    private String cardPanObfuscated;
    private String cardSecurityCheck;
    private String cardSerialNumber;

    public static final class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public VtsCreditCard build() {
            ValidationUtils.assertNonBlank(this.a, VtsError.INVALID_PARAMETER, "Card serial number cannot be null or empty", new Object[0]);
            return new VtsCreditCard(this, null);
        }

        public Builder cardExpiry(int i, int i2) {
            ValidationUtils.assertTrue(i >= 1 && i <= 12, VtsError.INVALID_PARAMETER, "Invalid month", new Object[0]);
            this.f = String.format(Locale.ITALY, "%04d%02d", Integer.valueOf(i2), Integer.valueOf(i));
            return this;
        }

        public Builder cardIssuer(String str) {
            this.b = str;
            return this;
        }

        public Builder cardOwnerFirstName(String str) {
            this.d = str;
            return this;
        }

        public Builder cardOwnerLastName(String str) {
            this.e = str;
            return this;
        }

        public Builder cardPanObfuscated(String str) {
            this.c = str;
            return this;
        }

        public Builder cardSecurityCheck(String str) {
            this.g = str;
            return this;
        }

        public Builder cardSerialNumber(String str) {
            this.a = str;
            return this;
        }
    }

    class a implements Parcelable.Creator<VtsCreditCard> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCreditCard createFromParcel(Parcel parcel) {
            return new VtsCreditCard(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCreditCard[] newArray(int i) {
            return new VtsCreditCard[i];
        }
    }

    private VtsCreditCard() {
    }

    protected VtsCreditCard(Parcel parcel) {
        this.cardSerialNumber = parcel.readString();
        this.cardIssuer = parcel.readString();
        this.cardPanObfuscated = parcel.readString();
        this.cardOwnerFirstName = parcel.readString();
        this.cardOwnerLastName = parcel.readString();
        this.cardExpiry = parcel.readString();
        this.cardSecurityCheck = parcel.readString();
    }

    private VtsCreditCard(Builder builder) {
        this.cardSerialNumber = builder.a;
        this.cardIssuer = builder.b;
        this.cardPanObfuscated = builder.c;
        this.cardOwnerFirstName = builder.d;
        this.cardOwnerLastName = builder.e;
        this.cardExpiry = builder.f;
        this.cardSecurityCheck = builder.g;
    }

    /* synthetic */ VtsCreditCard(Builder builder, a aVar) {
        this(builder);
    }

    public static VtsCreditCard fromDto(VtsCreditCardDTO vtsCreditCardDTO) {
        if (vtsCreditCardDTO == null) {
            return new VtsCreditCard();
        }
        VtsCreditCard vtsCreditCard = new VtsCreditCard();
        vtsCreditCard.cardSerialNumber = vtsCreditCardDTO.getCardSerialNumber();
        vtsCreditCard.cardIssuer = vtsCreditCardDTO.getCardIssuer();
        vtsCreditCard.cardPanObfuscated = vtsCreditCardDTO.getCardPanObfuscated();
        vtsCreditCard.cardOwnerFirstName = vtsCreditCardDTO.getCardOwnerFirstName();
        vtsCreditCard.cardOwnerLastName = vtsCreditCardDTO.getCardOwnerLastName();
        vtsCreditCard.cardExpiry = vtsCreditCardDTO.getCardExpiry();
        vtsCreditCard.cardSecurityCheck = vtsCreditCardDTO.getCardSecurityCheck();
        return vtsCreditCard;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCardExpiry() {
        return this.cardExpiry;
    }

    public String getCardIssuer() {
        return this.cardIssuer;
    }

    public String getCardOwnerFirstName() {
        return this.cardOwnerFirstName;
    }

    public String getCardOwnerLastName() {
        return this.cardOwnerLastName;
    }

    public String getCardPanObfuscated() {
        return this.cardPanObfuscated;
    }

    public String getCardSecurityCheck() {
        return this.cardSecurityCheck;
    }

    public String getCardSerialNumber() {
        return this.cardSerialNumber;
    }

    public String toString() {
        return "VtsCreditCard{cardSerialNumber='" + this.cardSerialNumber + CoreConstants.SINGLE_QUOTE_CHAR + ", cardIssuer='" + this.cardIssuer + CoreConstants.SINGLE_QUOTE_CHAR + ", cardPanObfuscated='" + this.cardPanObfuscated + CoreConstants.SINGLE_QUOTE_CHAR + ", cardOwnerFirstName='" + this.cardOwnerFirstName + CoreConstants.SINGLE_QUOTE_CHAR + ", cardOwnerLastName='" + this.cardOwnerLastName + CoreConstants.SINGLE_QUOTE_CHAR + ", cardExpiry='" + this.cardExpiry + CoreConstants.SINGLE_QUOTE_CHAR + ", cardSecurityCheck='" + this.cardSecurityCheck + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cardSerialNumber);
        parcel.writeString(this.cardIssuer);
        parcel.writeString(this.cardPanObfuscated);
        parcel.writeString(this.cardOwnerFirstName);
        parcel.writeString(this.cardOwnerLastName);
        parcel.writeString(this.cardExpiry);
        parcel.writeString(this.cardSecurityCheck);
    }
}
