package it.aep_italia.vts.sdk.dto.domain;

import it.aep_italia.vts.sdk.domain.VtsSellProposal;
import it.aep_italia.vts.sdk.domain.VtsShoppingItem;
import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;
import it.aep_italia.vts.sdk.domain.payments.VtsPayment;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellContractsProposalDTO {

    @Attribute(name = "SellProposalId")
    private long a;

    @Attribute(name = "PaymentType")
    private int b;

    @Attribute(name = "AmountEuroCent")
    private int c;

    @Attribute(name = "ReceiptType")
    private String d;

    private VtsSellContractsProposalDTO(long j, int i, int i2, String str) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = str;
    }

    public static VtsSellContractsProposalDTO fromCartItem(VtsShoppingItem vtsShoppingItem, VtsPayment vtsPayment, VtsReceiptType vtsReceiptType) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsShoppingItem, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment cannot be null", new Object[0]);
        if (vtsReceiptType == null) {
            vtsReceiptType = VtsReceiptType.NONE;
        }
        return new VtsSellContractsProposalDTO(vtsShoppingItem.getSellProposalID(), vtsPayment.getPaymentType().value(), vtsShoppingItem.getUnitPriceEuroCent(), vtsReceiptType.toString());
    }

    public static VtsSellContractsProposalDTO fromProposal(VtsSellProposal vtsSellProposal, VtsPayment vtsPayment, VtsReceiptType vtsReceiptType) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Sell proposal cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsSellProposal, vtsError, "Payment cannot be null", new Object[0]);
        if (vtsReceiptType == null) {
            vtsReceiptType = VtsReceiptType.NONE;
        }
        return new VtsSellContractsProposalDTO(vtsSellProposal.getProposalID(), vtsPayment.getPaymentType().value(), vtsSellProposal.getPriceEuroCent(), vtsReceiptType.toString());
    }

    public int getAmountEuroCent() {
        return this.c;
    }

    public int getPaymentType() {
        return this.b;
    }

    public String getReceiptType() {
        return this.d;
    }

    public long getSellProposalID() {
        return this.a;
    }
}
