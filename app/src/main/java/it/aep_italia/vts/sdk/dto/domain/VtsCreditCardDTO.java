package it.aep_italia.vts.sdk.dto.domain;

import it.aep_italia.vts.sdk.domain.VtsCreditCard;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsCreditCardDTO {

    @Attribute(name = "CardSerialNumber", required = true)
    private String a;

    @Attribute(name = "CardIssuer", required = false)
    private String b;

    @Attribute(name = "CardPanObfuscated", required = false)
    private String c;

    @Attribute(name = "CardOwnerFirstName", required = false)
    private String d;

    @Attribute(name = "CardOwnerLastName", required = false)
    private String e;

    @Attribute(name = "CardExpiry", required = false)
    private String f;

    @Attribute(name = "CardSecurityCheck", required = false)
    private String g;

    public static VtsCreditCardDTO fromDo(VtsCreditCard vtsCreditCard) {
        ValidationUtils.assertNonNull(vtsCreditCard, VtsError.INVALID_PARAMETER, "Credit card cannot be null", new Object[0]);
        VtsCreditCardDTO vtsCreditCardDTO = new VtsCreditCardDTO();
        vtsCreditCardDTO.a = vtsCreditCard.getCardSerialNumber();
        vtsCreditCardDTO.b = vtsCreditCard.getCardIssuer();
        vtsCreditCardDTO.c = vtsCreditCard.getCardPanObfuscated();
        vtsCreditCardDTO.d = vtsCreditCard.getCardOwnerFirstName();
        vtsCreditCardDTO.e = vtsCreditCard.getCardOwnerLastName();
        vtsCreditCardDTO.f = vtsCreditCard.getCardExpiry();
        vtsCreditCardDTO.g = vtsCreditCard.getCardSecurityCheck();
        return vtsCreditCardDTO;
    }

    public static VtsCreditCardDTO fromSerialNumber(String str) {
        ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Serial number cannot be null or empty", new Object[0]);
        VtsCreditCardDTO vtsCreditCardDTO = new VtsCreditCardDTO();
        vtsCreditCardDTO.a = str;
        return vtsCreditCardDTO;
    }

    public String getCardExpiry() {
        return this.f;
    }

    public String getCardIssuer() {
        return this.b;
    }

    public String getCardOwnerFirstName() {
        return this.d;
    }

    public String getCardOwnerLastName() {
        return this.e;
    }

    public String getCardPanObfuscated() {
        return this.c;
    }

    public String getCardSecurityCheck() {
        return this.g;
    }

    public String getCardSerialNumber() {
        return this.a;
    }

    public void setCardExpiry(String str) {
        this.f = str;
    }

    public void setCardIssuer(String str) {
        this.b = str;
    }

    public void setCardOwnerFirstName(String str) {
        this.d = str;
    }

    public void setCardOwnerLastName(String str) {
        this.e = str;
    }

    public void setCardPanObfuscated(String str) {
        this.c = str;
    }

    public void setCardSecurityCheck(String str) {
        this.g = str;
    }

    public void setCardSerialNumber(String str) {
        this.a = str;
    }
}
