package it.aep_italia.vts.sdk.domain.payments;

/* JADX INFO: loaded from: classes6.dex */
public interface VtsPayment {

    public enum PaymentType {
        NO_PAYMENT(0),
        CASH(1),
        CREDIT_CARD(3),
        CRYPTO(13);

        private int value;

        PaymentType(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    int getAmountEuroCent();

    PaymentType getPaymentType();

    String getWalletType();
}
