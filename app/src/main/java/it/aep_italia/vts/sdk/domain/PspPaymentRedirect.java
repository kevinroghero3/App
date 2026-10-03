package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.PspPaymentRedirectDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PspPaymentRedirect implements Serializable, Parcelable {
    public static final Parcelable.Creator<PspPaymentRedirect> CREATOR = new a();
    private String apiToken;
    private String redirectUrl;
    private String responseCode;

    class a implements Parcelable.Creator<PspPaymentRedirect> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PspPaymentRedirect createFromParcel(Parcel parcel) {
            return new PspPaymentRedirect(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PspPaymentRedirect[] newArray(int i) {
            return new PspPaymentRedirect[i];
        }
    }

    public PspPaymentRedirect() {
    }

    protected PspPaymentRedirect(Parcel parcel) {
        this.responseCode = parcel.readString();
        this.apiToken = parcel.readString();
        this.redirectUrl = parcel.readString();
    }

    public static PspPaymentRedirect fromDto(PspPaymentRedirectDTO pspPaymentRedirectDTO) {
        if (pspPaymentRedirectDTO == null) {
            return new PspPaymentRedirect();
        }
        PspPaymentRedirect pspPaymentRedirect = new PspPaymentRedirect();
        pspPaymentRedirect.responseCode = pspPaymentRedirectDTO.getResponseCode();
        pspPaymentRedirect.apiToken = pspPaymentRedirectDTO.getApiToken();
        pspPaymentRedirect.redirectUrl = pspPaymentRedirectDTO.getRedirectUrl();
        return pspPaymentRedirect;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApiToken() {
        return this.apiToken;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setApiToken(String str) {
        this.apiToken = str;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
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
    }
}
