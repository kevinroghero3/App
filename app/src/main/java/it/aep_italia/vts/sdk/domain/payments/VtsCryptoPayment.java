package it.aep_italia.vts.sdk.domain.payments;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsCryptoPayment implements VtsPayment, Parcelable {
    public static final Parcelable.Creator<VtsCryptoPayment> CREATOR = new a();
    private int a;
    private String b;

    class a implements Parcelable.Creator<VtsCryptoPayment> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCryptoPayment createFromParcel(Parcel parcel) {
            return new VtsCryptoPayment(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VtsCryptoPayment[] newArray(int i) {
            return new VtsCryptoPayment[i];
        }
    }

    public VtsCryptoPayment(int i, String str) {
        ValidationUtils.assertTrue(i >= 0, VtsError.INVALID_PARAMETER, "Amount cannot be negative", new Object[0]);
        this.a = i;
        this.b = str;
    }

    private VtsCryptoPayment(Parcel parcel) {
        this.a = parcel.readInt();
    }

    /* synthetic */ VtsCryptoPayment(Parcel parcel, a aVar) {
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
        return VtsPayment.PaymentType.CRYPTO;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public String getWalletType() {
        return this.b;
    }

    public String toString() {
        return "VtsCryptoPayment{amountEuroCent=" + this.a + "walletType=" + this.b + CoreConstants.CURLY_RIGHT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }
}
