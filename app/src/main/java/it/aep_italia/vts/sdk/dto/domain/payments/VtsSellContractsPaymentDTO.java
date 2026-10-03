package it.aep_italia.vts.sdk.dto.domain.payments;

import it.aep_italia.vts.sdk.domain.payments.VtsCashPayment;
import it.aep_italia.vts.sdk.domain.payments.VtsCreditCardPayment;
import it.aep_italia.vts.sdk.domain.payments.VtsCryptoPayment;
import it.aep_italia.vts.sdk.domain.payments.VtsNoPayment;
import it.aep_italia.vts.sdk.domain.payments.VtsPayment;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface VtsSellContractsPaymentDTO {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VtsPayment.PaymentType.values().length];
            a = iArr;
            try {
                iArr[VtsPayment.PaymentType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VtsPayment.PaymentType.CREDIT_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VtsPayment.PaymentType.NO_PAYMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[VtsPayment.PaymentType.CRYPTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static VtsSellContractsPaymentDTO fromPayment(VtsPayment vtsPayment) {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(vtsPayment, vtsError, "Payment cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsPayment.getPaymentType(), vtsError, "Payment type cannot be null", new Object[0]);
        int i = a.a[vtsPayment.getPaymentType().ordinal()];
        if (i == 1) {
            return new VtsSellContractsCashPaymentDTO((VtsCashPayment) vtsPayment);
        }
        if (i == 2) {
            return new VtsSellContractsCreditCardPaymentDTO((VtsCreditCardPayment) vtsPayment);
        }
        if (i == 3) {
            return new VtsSellContractsNoPaymentDTO((VtsNoPayment) vtsPayment);
        }
        if (i != 4) {
            return null;
        }
        return new VtsSellContractsCryptoPaymentDTO((VtsCryptoPayment) vtsPayment);
    }

    int getAmountEuroCent();

    int getPaymentType();
}
