package it.aep_italia.vts.sdk.dto.domain.payments;

import it.aep_italia.vts.sdk.domain.payments.VtsCryptoPayment;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellContractsCryptoPaymentDTO implements VtsSellContractsPaymentDTO {

    @Attribute(name = "PaymentType")
    private int a = 13;

    @Attribute(name = "AmountEuroCent")
    private int b;

    @Attribute(name = "WalletType")
    private String c;

    public VtsSellContractsCryptoPaymentDTO(int i, String str) {
        this.b = i;
        this.c = str;
    }

    public VtsSellContractsCryptoPaymentDTO(VtsCryptoPayment vtsCryptoPayment) {
        ValidationUtils.assertNonNull(vtsCryptoPayment, VtsError.INVALID_PARAMETER, "Payment cannot be null", new Object[0]);
        this.b = vtsCryptoPayment.getAmountEuroCent();
        this.c = vtsCryptoPayment.getWalletType();
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getAmountEuroCent() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getPaymentType() {
        return this.a;
    }

    public String getWalletType() {
        return this.c;
    }
}
