package androidx.compose.ui.autofill;

import androidx.autofill.HintConstants;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContentType {
    private final Set<String> contentHints;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ContentType Username = new ContentType("username");
    private static final ContentType Password = new ContentType("password");
    private static final ContentType EmailAddress = new ContentType(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
    private static final ContentType NewUsername = new ContentType(HintConstants.AUTOFILL_HINT_NEW_USERNAME);
    private static final ContentType NewPassword = new ContentType(HintConstants.AUTOFILL_HINT_NEW_PASSWORD);
    private static final ContentType PostalAddress = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS);
    private static final ContentType PostalCode = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_CODE);
    private static final ContentType CreditCardNumber = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER);
    private static final ContentType CreditCardSecurityCode = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE);
    private static final ContentType CreditCardExpirationDate = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE);
    private static final ContentType CreditCardExpirationMonth = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH);
    private static final ContentType CreditCardExpirationYear = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR);
    private static final ContentType CreditCardExpirationDay = new ContentType(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY);
    private static final ContentType AddressCountry = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY);
    private static final ContentType AddressRegion = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION);
    private static final ContentType AddressLocality = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY);
    private static final ContentType AddressStreet = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS);
    private static final ContentType AddressAuxiliaryDetails = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS);
    private static final ContentType PostalCodeExtended = new ContentType(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE);
    private static final ContentType PersonFullName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME);
    private static final ContentType PersonFirstName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN);
    private static final ContentType PersonLastName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY);
    private static final ContentType PersonMiddleName = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE);
    private static final ContentType PersonMiddleInitial = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL);
    private static final ContentType PersonNamePrefix = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX);
    private static final ContentType PersonNameSuffix = new ContentType(HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX);
    private static final ContentType PhoneNumber = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
    private static final ContentType PhoneNumberDevice = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE);
    private static final ContentType PhoneCountryCode = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE);
    private static final ContentType PhoneNumberNational = new ContentType(HintConstants.AUTOFILL_HINT_PHONE_NATIONAL);
    private static final ContentType Gender = new ContentType(HintConstants.AUTOFILL_HINT_GENDER);
    private static final ContentType BirthDateFull = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL);
    private static final ContentType BirthDateDay = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY);
    private static final ContentType BirthDateMonth = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH);
    private static final ContentType BirthDateYear = new ContentType(HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR);
    private static final ContentType SmsOtpCode = new ContentType(HintConstants.AUTOFILL_HINT_SMS_OTP);

    private ContentType(Set<String> set) {
        this.contentHints = set;
    }

    public ContentType(@NotNull String str) {
        this((Set<String>) SetsKt__SetsJVMKt.setOf(str));
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentType getUsername() {
            return ContentType.Username;
        }

        public final ContentType getPassword() {
            return ContentType.Password;
        }

        public final ContentType getEmailAddress() {
            return ContentType.EmailAddress;
        }

        public final ContentType getNewUsername() {
            return ContentType.NewUsername;
        }

        public final ContentType getNewPassword() {
            return ContentType.NewPassword;
        }

        public final ContentType getPostalAddress() {
            return ContentType.PostalAddress;
        }

        public final ContentType getPostalCode() {
            return ContentType.PostalCode;
        }

        public final ContentType getCreditCardNumber() {
            return ContentType.CreditCardNumber;
        }

        public final ContentType getCreditCardSecurityCode() {
            return ContentType.CreditCardSecurityCode;
        }

        public final ContentType getCreditCardExpirationDate() {
            return ContentType.CreditCardExpirationDate;
        }

        public final ContentType getCreditCardExpirationMonth() {
            return ContentType.CreditCardExpirationMonth;
        }

        public final ContentType getCreditCardExpirationYear() {
            return ContentType.CreditCardExpirationYear;
        }

        public final ContentType getCreditCardExpirationDay() {
            return ContentType.CreditCardExpirationDay;
        }

        public final ContentType getAddressCountry() {
            return ContentType.AddressCountry;
        }

        public final ContentType getAddressRegion() {
            return ContentType.AddressRegion;
        }

        public final ContentType getAddressLocality() {
            return ContentType.AddressLocality;
        }

        public final ContentType getAddressStreet() {
            return ContentType.AddressStreet;
        }

        public final ContentType getAddressAuxiliaryDetails() {
            return ContentType.AddressAuxiliaryDetails;
        }

        public final ContentType getPostalCodeExtended() {
            return ContentType.PostalCodeExtended;
        }

        public final ContentType getPersonFullName() {
            return ContentType.PersonFullName;
        }

        public final ContentType getPersonFirstName() {
            return ContentType.PersonFirstName;
        }

        public final ContentType getPersonLastName() {
            return ContentType.PersonLastName;
        }

        public final ContentType getPersonMiddleName() {
            return ContentType.PersonMiddleName;
        }

        public final ContentType getPersonMiddleInitial() {
            return ContentType.PersonMiddleInitial;
        }

        public final ContentType getPersonNamePrefix() {
            return ContentType.PersonNamePrefix;
        }

        public final ContentType getPersonNameSuffix() {
            return ContentType.PersonNameSuffix;
        }

        public final ContentType getPhoneNumber() {
            return ContentType.PhoneNumber;
        }

        public final ContentType getPhoneNumberDevice() {
            return ContentType.PhoneNumberDevice;
        }

        public final ContentType getPhoneCountryCode() {
            return ContentType.PhoneCountryCode;
        }

        public final ContentType getPhoneNumberNational() {
            return ContentType.PhoneNumberNational;
        }

        public final ContentType getGender() {
            return ContentType.Gender;
        }

        public final ContentType getBirthDateFull() {
            return ContentType.BirthDateFull;
        }

        public final ContentType getBirthDateDay() {
            return ContentType.BirthDateDay;
        }

        public final ContentType getBirthDateMonth() {
            return ContentType.BirthDateMonth;
        }

        public final ContentType getBirthDateYear() {
            return ContentType.BirthDateYear;
        }

        public final ContentType getSmsOtpCode() {
            return ContentType.SmsOtpCode;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final ContentType from$ui_release(@NotNull String str) {
            switch (str.hashCode()) {
                case -1844815832:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH)) {
                        return getCreditCardExpirationMonth();
                    }
                    break;
                case -1821235109:
                    if (str.equals(HintConstants.AUTOFILL_HINT_NEW_PASSWORD)) {
                        return getNewPassword();
                    }
                    break;
                case -1757573738:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE)) {
                        return getCreditCardSecurityCode();
                    }
                    break;
                case -1682373820:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY)) {
                        return getCreditCardExpirationDay();
                    }
                    break;
                case -1492157798:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL)) {
                        return getPersonMiddleInitial();
                    }
                    break;
                case -1327425451:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE)) {
                        return getPhoneCountryCode();
                    }
                    break;
                case -1249512767:
                    if (str.equals(HintConstants.AUTOFILL_HINT_GENDER)) {
                        return getGender();
                    }
                    break;
                case -1192969641:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)) {
                        return getPhoneNumber();
                    }
                    break;
                case -1151034798:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER)) {
                        return getCreditCardNumber();
                    }
                    break;
                case -1070931784:
                    if (str.equals(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS)) {
                        return getEmailAddress();
                    }
                    break;
                case -782964728:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION)) {
                        return getAddressRegion();
                    }
                    break;
                case -742913724:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY)) {
                        return getPersonLastName();
                    }
                    break;
                case -724274829:
                    if (str.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH)) {
                        return getBirthDateMonth();
                    }
                    break;
                case -613980922:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE)) {
                        return getCreditCardExpirationDate();
                    }
                    break;
                case -613352043:
                    if (str.equals(HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR)) {
                        return getCreditCardExpirationYear();
                    }
                    break;
                case -398527665:
                    if (str.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY)) {
                        return getBirthDateDay();
                    }
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        return getUsername();
                    }
                    break;
                case -50595520:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PHONE_NATIONAL)) {
                        return getPhoneNumberNational();
                    }
                    break;
                case 289393:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS)) {
                        return getAddressStreet();
                    }
                    break;
                case 146220155:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS)) {
                        return getAddressAuxiliaryDetails();
                    }
                    break;
                case 530622780:
                    if (str.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL)) {
                        return getBirthDateFull();
                    }
                    break;
                case 531173098:
                    if (str.equals(HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR)) {
                        return getBirthDateYear();
                    }
                    break;
                case 678483840:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME)) {
                        return getPersonFullName();
                    }
                    break;
                case 956262285:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE)) {
                        return getPhoneNumberDevice();
                    }
                    break;
                case 991032982:
                    if (str.equals(HintConstants.AUTOFILL_HINT_NEW_USERNAME)) {
                        return getNewUsername();
                    }
                    break;
                case 1216985755:
                    if (str.equals("password")) {
                        return getPassword();
                    }
                    break;
                case 1369618690:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY)) {
                        return getAddressCountry();
                    }
                    break;
                case 1617991537:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE)) {
                        return getPostalCodeExtended();
                    }
                    break;
                case 1662667945:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS)) {
                        return getPostalAddress();
                    }
                    break;
                case 1781320055:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY)) {
                        return getAddressLocality();
                    }
                    break;
                case 1834963923:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN)) {
                        return getPersonFirstName();
                    }
                    break;
                case 1865618463:
                    if (str.equals(HintConstants.AUTOFILL_HINT_SMS_OTP)) {
                        return getSmsOtpCode();
                    }
                    break;
                case 1917507122:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX)) {
                        return getPersonNamePrefix();
                    }
                    break;
                case 1935279861:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE)) {
                        return getPersonMiddleName();
                    }
                    break;
                case 2006194929:
                    if (str.equals(HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX)) {
                        return getPersonNameSuffix();
                    }
                    break;
                case 2011152728:
                    if (str.equals(HintConstants.AUTOFILL_HINT_POSTAL_CODE)) {
                        return getPostalCode();
                    }
                    break;
            }
            return new ContentType(str);
        }
    }

    public final ContentType plus$ui_release(@NotNull ContentType contentType) {
        return new ContentType((Set<String>) SetsKt___SetsKt.plus((Set) this.contentHints, (Iterable) contentType.contentHints));
    }
}
