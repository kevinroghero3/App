package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.VtsCreditCard;
import it.aep_italia.vts.sdk.dto.domain.VtsCreditCardDTO;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class CreditCardsInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "OperationType")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Element(name = "vts:CreditCard", required = false)
    @Path("vts:Body/vts:Parameters")
    private VtsCreditCardDTO c;

    private CreditCardsInput(String str, VtsCreditCardDTO vtsCreditCardDTO) {
        this.b = str;
        this.c = vtsCreditCardDTO;
    }

    public static CreditCardsInput forAddOperation(VtsCreditCard vtsCreditCard) {
        ValidationUtils.assertNonNull(vtsCreditCard, VtsError.INVALID_PARAMETER, "Credit card cannot be null", new Object[0]);
        return new CreditCardsInput("Add", VtsCreditCardDTO.fromDo(vtsCreditCard));
    }

    public static CreditCardsInput forContentOperation() {
        return new CreditCardsInput("Content", null);
    }

    public static CreditCardsInput forEmptyOperation() {
        return new CreditCardsInput("Empty", null);
    }

    public static CreditCardsInput forRemoveOperation(String str) {
        ValidationUtils.assertNonBlank(str, VtsError.INVALID_PARAMETER, "Serial number cannot be null or empty", new Object[0]);
        return new CreditCardsInput("Remove", VtsCreditCardDTO.fromSerialNumber(str));
    }

    public VtsCreditCardDTO getCreditCard() {
        return this.c;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncCreditCards";
    }

    public String getOperationType() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperationType: ");
        sb.append(this.b);
        if (this.c != null) {
            sb.append(", Card:[");
            sb.append("CardSerialNumber: ");
            sb.append(this.c.getCardSerialNumber());
            sb.append("CardIssuer: ");
            sb.append(this.c.getCardIssuer());
            sb.append("CardPanObfuscated: ");
            sb.append(this.c.getCardPanObfuscated());
            sb.append("CardOwnerFirstName: ");
            sb.append(this.c.getCardOwnerFirstName());
            sb.append("CardOwnerLastName: ");
            sb.append(this.c.getCardOwnerLastName());
            sb.append("CardExpiry: ");
            sb.append(this.c.getCardExpiry());
            sb.append("CardSecurityCheck: ");
            sb.append(this.c.getCardSecurityCheck());
            sb.append("]");
        }
        return sb.toString();
    }

    public int getVersion() {
        return this.a;
    }
}
