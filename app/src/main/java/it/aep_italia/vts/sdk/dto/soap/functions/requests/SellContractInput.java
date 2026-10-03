package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;
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
@Deprecated
public class SellContractInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "SellProposalId")
    @Path("vts:Body/vts:Parameters")
    private long b;

    @Attribute(name = "ReceiptType")
    @Path("vts:Body/vts:Parameters")
    private String c;

    public SellContractInput(long j, VtsReceiptType vtsReceiptType) {
        setSellProposalID(j);
        setReceiptType(vtsReceiptType == null ? null : vtsReceiptType.value());
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncSellContract";
    }

    public String getReceiptType() {
        return this.c;
    }

    public long getSellProposalID() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        Locale locale = Locale.ITALY;
        long j = this.b;
        return String.format(locale, "SellProposalId: %d, ReceiptType: %s", Long.valueOf(j), this.c);
    }

    public void setReceiptType(String str) {
        this.c = str;
    }

    public void setSellProposalID(long j) {
        this.b = j;
    }
}
