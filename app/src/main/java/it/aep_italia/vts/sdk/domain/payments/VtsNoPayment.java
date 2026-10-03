package it.aep_italia.vts.sdk.domain.payments;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsNoPayment implements VtsPayment, Parcelable {
    public static final Parcelable.Creator<VtsNoPayment> CREATOR = new a();
    private int a;

    class a implements Parcelable.Creator<VtsNoPayment> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsNoPayment createFromParcel(Parcel parcel) {
            return new VtsNoPayment(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsNoPayment[] newArray(int i) {
            return new VtsNoPayment[i];
        }
    }

    public VtsNoPayment(int i) {
        this.a = i;
    }

    private VtsNoPayment(Parcel parcel) {
        this.a = parcel.readInt();
    }

    /* synthetic */ VtsNoPayment(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public int getAmountEuroCent() {
        return this.a;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public VtsPayment.PaymentType getPaymentType() {
        return VtsPayment.PaymentType.NO_PAYMENT;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public String getWalletType() {
        return "";
    }

    public String toString() {
        return "VtsNoPayment{amountEuroCent=" + this.a + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }
}
