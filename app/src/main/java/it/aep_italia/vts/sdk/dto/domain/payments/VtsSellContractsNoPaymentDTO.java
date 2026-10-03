package it.aep_italia.vts.sdk.dto.domain.payments;

import it.aep_italia.vts.sdk.domain.payments.VtsNoPayment;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellContractsNoPaymentDTO implements VtsSellContractsPaymentDTO {

    @Attribute(name = "PaymentType")
    private int a = 1;

    @Attribute(name = "AmountEuroCent")
    private int b;

    public VtsSellContractsNoPaymentDTO(int i) {
        this.b = i;
    }

    public VtsSellContractsNoPaymentDTO(VtsNoPayment vtsNoPayment) {
        ValidationUtils.assertNonNull(vtsNoPayment, VtsError.INVALID_PARAMETER, "Payment cannot be null", new Object[0]);
        this.b = vtsNoPayment.getAmountEuroCent();
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getAmountEuroCent() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getPaymentType() {
        return this.a;
    }
}
