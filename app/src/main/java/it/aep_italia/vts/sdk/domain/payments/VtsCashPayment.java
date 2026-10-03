package it.aep_italia.vts.sdk.domain.payments;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsCashPayment implements VtsPayment, Parcelable {
    public static final Parcelable.Creator<VtsCashPayment> CREATOR = new a();
    private int a;

    class a implements Parcelable.Creator<VtsCashPayment> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCashPayment createFromParcel(Parcel parcel) {
            return new VtsCashPayment(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCashPayment[] newArray(int i) {
            return new VtsCashPayment[i];
        }
    }

    public VtsCashPayment(int i) {
        ValidationUtils.assertTrue(i >= 0, VtsError.INVALID_PARAMETER, "Amount cannot be negative", new Object[0]);
        this.a = i;
    }

    private VtsCashPayment(Parcel parcel) {
        this.a = parcel.readInt();
    }

    /* synthetic */ VtsCashPayment(Parcel parcel, a aVar) {
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
        return VtsPayment.PaymentType.CASH;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public String getWalletType() {
        return "";
    }

    public String toString() {
        return "VtsCashPayment{amountEuroCent=" + this.a + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }
}
