package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.PspPaymentRedirectDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VtsPspPaymentRedirect implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsPspPaymentRedirect> CREATOR = new a();
    private String apiToken;
    private String codeIdentifier;
    private String externalCode;
    private String redirectUrl;
    private String responseCode;

    class a implements Parcelable.Creator<VtsPspPaymentRedirect> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsPspPaymentRedirect createFromParcel(Parcel parcel) {
            return new VtsPspPaymentRedirect(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsPspPaymentRedirect[] newArray(int i) {
            return new VtsPspPaymentRedirect[i];
        }
    }

    public VtsPspPaymentRedirect() {
    }

    protected VtsPspPaymentRedirect(Parcel parcel) {
        this.responseCode = parcel.readString();
        this.apiToken = parcel.readString();
        this.redirectUrl = parcel.readString();
        this.codeIdentifier = parcel.readString();
        this.externalCode = parcel.readString();
    }

    public static VtsPspPaymentRedirect fromDto(PspPaymentRedirectDTO pspPaymentRedirectDTO) {
        if (pspPaymentRedirectDTO == null) {
            return new VtsPspPaymentRedirect();
        }
        VtsPspPaymentRedirect vtsPspPaymentRedirect = new VtsPspPaymentRedirect();
        vtsPspPaymentRedirect.responseCode = pspPaymentRedirectDTO.getResponseCode();
        vtsPspPaymentRedirect.apiToken = pspPaymentRedirectDTO.getApiToken();
        vtsPspPaymentRedirect.redirectUrl = pspPaymentRedirectDTO.getRedirectUrl();
        vtsPspPaymentRedirect.codeIdentifier = pspPaymentRedirectDTO.getCodeIdentifier();
        vtsPspPaymentRedirect.externalCode = pspPaymentRedirectDTO.getExternalCode();
        return vtsPspPaymentRedirect;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApiToken() {
        return this.apiToken;
    }

    public String getCodeIdentifier() {
        return this.codeIdentifier;
    }

    public String getExternalCode() {
        return this.externalCode;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.responseCode);
        if (StringUtils.isBlank(this.apiToken)) {
            if (!StringUtils.isBlank(this.redirectUrl)) {
                sb.append(" - ");
                str = this.redirectUrl;
            }
            return sb.toString();
        }
        sb.append(" - ");
        str = this.apiToken;
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.responseCode);
        parcel.writeString(this.apiToken);
        parcel.writeString(this.redirectUrl);
        parcel.writeString(this.codeIdentifier);
        parcel.writeString(this.externalCode);
    }
}
