package it.aep_italia.vts.sdk.domain;

import android.os.Parcel;
import android.os.Parcelable;
import it.aep_italia.vts.sdk.dto.domain.VtsServiceModeDTO;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServiceMode implements Serializable, Parcelable {
    public static final Parcelable.Creator<VtsServiceMode> CREATOR = new a();
    private String description;
    private int id;
    private String shortDescription;

    class a implements Parcelable.Creator<VtsServiceMode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsServiceMode createFromParcel(Parcel parcel) {
            return new VtsServiceMode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsServiceMode[] newArray(int i) {
            return new VtsServiceMode[i];
        }
    }

    public VtsServiceMode() {
    }

    protected VtsServiceMode(Parcel parcel) {
        this.id = parcel.readInt();
        this.description = parcel.readString();
        this.shortDescription = parcel.readString();
    }

    public static VtsServiceMode fromDto(VtsServiceModeDTO vtsServiceModeDTO) {
        if (vtsServiceModeDTO == null) {
            return new VtsServiceMode();
        }
        VtsServiceMode vtsServiceMode = new VtsServiceMode();
        vtsServiceMode.id = vtsServiceModeDTO.getID().intValue();
        vtsServiceMode.description = vtsServiceModeDTO.getDescription();
        vtsServiceMode.shortDescription = vtsServiceModeDTO.getShortDescription();
        return vtsServiceMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public int getID() {
        return this.id;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public String toString() {
        if (StringUtils.isBlank(this.description)) {
            return !StringUtils.isBlank(this.shortDescription) ? this.shortDescription : String.format(Locale.getDefault(), "ID: %d", Integer.valueOf(this.id));
        }
        return this.description;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
    }
}
