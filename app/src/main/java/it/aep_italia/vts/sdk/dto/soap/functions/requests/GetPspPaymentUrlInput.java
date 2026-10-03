package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.payments.VtsCreditCardPayment;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetPspPaymentUrlInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "PspType")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "AmountEuroCent")
    @Path("vts:Body/vts:Parameters")
    private int c;

    @Attribute(name = "PaymentMode")
    @Path("vts:Body/vts:Parameters")
    private VtsCreditCardPayment.CardPaymentMode d;

    @Attribute(name = "BankRefUID")
    @Path("vts:Body/vts:Parameters")
    private String e;

    @Attribute(name = "ConfirmationUrl")
    @Path("vts:Body/vts:Parameters")
    private String f;

    public GetPspPaymentUrlInput(String str, VtsCreditCardPayment.CardPaymentMode cardPaymentMode, int i, String str2, String str3) {
        setPspType(str);
        setAmountEuroCent(i);
        setBankRefUID(str2);
        setPaymentMode(cardPaymentMode);
        setConfirmationUrl(str3);
    }

    public int getAmountEuroCent() {
        return this.c;
    }

    public String getBankRefUID() {
        return this.e;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetPspPaymentUrl";
    }

    public String getPspType() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        Locale locale = Locale.ITALY;
        String str = this.b;
        VtsCreditCardPayment.CardPaymentMode cardPaymentMode = this.d;
        int i = this.c;
        return String.format(locale, "PspType: %s, PaymentMode: %s, AmountEuroCent: %s, BankRefUID: %s, ConfirmationUrl: %s ", str, cardPaymentMode, Integer.valueOf(i), this.e, this.f);
    }

    public void setAmountEuroCent(int i) {
        this.c = i;
    }

    public void setBankRefUID(String str) {
        this.e = str;
    }

    public void setConfirmationUrl(String str) {
        this.f = str;
    }

    public void setPaymentMode(VtsCreditCardPayment.CardPaymentMode cardPaymentMode) {
        this.d = cardPaymentMode;
    }

    public void setPspType(String str) {
        this.b = str;
    }
}
