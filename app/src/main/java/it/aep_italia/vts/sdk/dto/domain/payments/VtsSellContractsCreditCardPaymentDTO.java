package it.aep_italia.vts.sdk.dto.domain.payments;

import it.aep_italia.vts.sdk.domain.payments.VtsCreditCardPayment;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellContractsCreditCardPaymentDTO implements VtsSellContractsPaymentDTO {

    @Attribute(name = "PaymentType")
    private int a = 3;

    @Attribute(name = "AmountEuroCent")
    private int b;

    @Attribute(name = "CardPaymentMode")
    private int c;

    @Attribute(name = "CardIssuer")
    private String d;

    @Attribute(name = "CardSerialNumber")
    private String e;

    @Attribute(name = "CardPanObfuscated")
    private String f;

    @Attribute(name = "CardOwnerFirstName")
    private String g;

    @Attribute(name = "CardOwnerLastName")
    private String h;

    @Attribute(name = "CardExpiry")
    private String i;

    @Attribute(name = "BankRefUID", required = false)
    private String j;

    @Attribute(name = "BankDateTime", required = false)
    private String k;

    public VtsSellContractsCreditCardPaymentDTO(VtsCreditCardPayment vtsCreditCardPayment) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsCreditCardPayment, vtsError, "Payment cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsCreditCardPayment.getCardPaymentMode(), vtsError, "Payment mode cannot be null", new Object[0]);
        this.b = vtsCreditCardPayment.getAmountEuroCent();
        this.c = vtsCreditCardPayment.getCardPaymentMode().getValue();
        this.d = vtsCreditCardPayment.getCardIssuer();
        this.e = vtsCreditCardPayment.getCardSerialNumber();
        this.f = vtsCreditCardPayment.getCardPanObfuscated();
        this.g = vtsCreditCardPayment.getCardOwnerFirstName();
        this.h = vtsCreditCardPayment.getCardOwnerLastName();
        this.i = vtsCreditCardPayment.getCardExpiry();
        this.j = vtsCreditCardPayment.getBankRefUID();
        this.k = vtsCreditCardPayment.getBankDateTime();
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getAmountEuroCent() {
        return this.b;
    }

    public String getBankDateTime() {
        return this.k;
    }

    public String getBankRefUID() {
        return this.j;
    }

    public String getCardExpiry() {
        return this.i;
    }

    public String getCardIssuer() {
        return this.d;
    }

    public String getCardOwnerFirstName() {
        return this.g;
    }

    public String getCardOwnerLastName() {
        return this.h;
    }

    public String getCardPanObfuscated() {
        return this.f;
    }

    public int getCardPaymentMode() {
        return this.c;
    }

    public String getCardSerialNumber() {
        return this.e;
    }

    @Override // it.aep_italia.vts.sdk.dto.domain.payments.VtsSellContractsPaymentDTO
    public int getPaymentType() {
        return this.a;
    }
}
