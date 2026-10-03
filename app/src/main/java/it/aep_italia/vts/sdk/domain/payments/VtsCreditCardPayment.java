package it.aep_italia.vts.sdk.domain.payments;

import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.domain.VtsCreditCard;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsCreditCardPayment implements VtsPayment {
    private int a;
    private CardPaymentMode b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public static final class Builder {
        private int a;
        private CardPaymentMode b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;

        public Builder amountEuroCent(int i) {
            ValidationUtils.assertTrue(i >= 0, VtsError.INVALID_PARAMETER, "Amount cannot be negative", new Object[0]);
            this.a = i;
            return this;
        }

        public Builder bankDateTime(String str) {
            ValidationUtils.assertISO8601(str, VtsError.INVALID_PARAMETER, "Invalid date time", new Object[0]);
            this.j = str;
            return this;
        }

        public Builder bankDateTime(Date date) {
            ValidationUtils.assertNonNull(date, VtsError.INVALID_PARAMETER, "Date time cannot be null", new Object[0]);
            this.j = DateUtils.toISO8601(date);
            return this;
        }

        public Builder bankRefUID(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_BANK_REF_UID, "BankRefUID is invalid", new Object[0]);
            this.i = str;
            return this;
        }

        public VtsCreditCardPayment build() {
            CardPaymentMode cardPaymentMode = this.b;
            VtsError vtsError = VtsError.INVALID_PARAMETER;
            ValidationUtils.assertNonNull(cardPaymentMode, vtsError, "No payment mode specified", new Object[0]);
            if (this.b == CardPaymentMode.CLIENT_SIDE) {
                ValidationUtils.assertNonBlank(this.i, vtsError, "BankRefUID cannot be empty for CLIENT_SIDE payments", new Object[0]);
                ValidationUtils.assertNonBlank(this.j, vtsError, "BankDateTime cannot be empty for CLIENT_SIDE payments", new Object[0]);
            }
            return new VtsCreditCardPayment(this);
        }

        public Builder cardExpiry(int i, int i2) {
            ValidationUtils.assertTrue(i >= 1 && i <= 12, VtsError.INVALID_PARAMETER, "Invalid month", new Object[0]);
            this.h = String.format(Locale.ITALY, "%04d%02d", Integer.valueOf(i2), Integer.valueOf(i));
            return this;
        }

        public Builder cardIssuer(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Card issuer cannot be null or empty", new Object[0]);
            this.c = str;
            return this;
        }

        public Builder cardOwnerFirstName(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "First name cannot be null or empty", new Object[0]);
            this.f = str;
            return this;
        }

        public Builder cardOwnerLastName(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Last name cannot be null or empty", new Object[0]);
            this.g = str;
            return this;
        }

        public Builder cardPanObfuscated(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Obfuscated PAN cannot be null or empty", new Object[0]);
            this.e = str;
            return this;
        }

        public Builder cardPaymentMode(CardPaymentMode cardPaymentMode) {
            ValidationUtils.assertNonNull(cardPaymentMode, VtsError.INVALID_PARAMETER, "Payment mode cannot be null", new Object[0]);
            this.b = cardPaymentMode;
            return this;
        }

        public Builder cardSerialNumber(String str) {
            ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Serial number cannot be null or empty", new Object[0]);
            this.d = str;
            return this;
        }

        public Builder creditCard(VtsCreditCard vtsCreditCard) {
            ValidationUtils.assertNonNull(vtsCreditCard, VtsError.INVALID_PARAMETER, "Credit card cannot be null", new Object[0]);
            this.c = vtsCreditCard.getCardIssuer();
            this.d = vtsCreditCard.getCardSerialNumber();
            this.e = vtsCreditCard.getCardPanObfuscated();
            this.f = vtsCreditCard.getCardOwnerFirstName();
            this.g = vtsCreditCard.getCardOwnerLastName();
            this.h = vtsCreditCard.getCardExpiry();
            return this;
        }
    }

    public enum CardPaymentMode {
        CLIENT_SIDE(1),
        SERVER_SIDE(2);

        private int value;

        CardPaymentMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private VtsCreditCardPayment(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        ValidationUtils.assertTrue(this.a >= 0, VtsError.INVALID_PARAMETER, "Amount cannot be negative", new Object[0]);
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public int getAmountEuroCent() {
        return this.a;
    }

    public String getBankDateTime() {
        return this.j;
    }

    public String getBankRefUID() {
        return this.i;
    }

    public String getCardExpiry() {
        return this.h;
    }

    public String getCardIssuer() {
        return this.c;
    }

    public String getCardOwnerFirstName() {
        return this.f;
    }

    public String getCardOwnerLastName() {
        return this.g;
    }

    public String getCardPanObfuscated() {
        return this.e;
    }

    public CardPaymentMode getCardPaymentMode() {
        return this.b;
    }

    public String getCardSerialNumber() {
        return this.d;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public VtsPayment.PaymentType getPaymentType() {
        return VtsPayment.PaymentType.CREDIT_CARD;
    }

    @Override // it.aep_italia.vts.sdk.domain.payments.VtsPayment
    public String getWalletType() {
        return "";
    }

    public String toString() {
        return "VtsCreditCardPayment{amountEuroCent=" + this.a + ", cardPaymentMode=" + this.b + ", cardIssuer='" + this.c + CoreConstants.SINGLE_QUOTE_CHAR + ", cardSerialNumber='" + this.d + CoreConstants.SINGLE_QUOTE_CHAR + ", cardPanObfuscated='" + this.e + CoreConstants.SINGLE_QUOTE_CHAR + ", cardOwnerFirstName='" + this.f + CoreConstants.SINGLE_QUOTE_CHAR + ", cardOwnerLastName='" + this.g + CoreConstants.SINGLE_QUOTE_CHAR + ", cardExpiry='" + this.h + CoreConstants.SINGLE_QUOTE_CHAR + ", bankRefUID='" + this.i + CoreConstants.SINGLE_QUOTE_CHAR + ", bankDateTime='" + this.j + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }
}
