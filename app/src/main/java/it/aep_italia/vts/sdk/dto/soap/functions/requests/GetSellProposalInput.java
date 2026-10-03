package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.domain.VtsNode;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.List;
import java.util.Locale;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class GetSellProposalInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "ProviderId")
    @Path("vts:Body/vts:Parameters")
    private int b;

    @Attribute(name = "TariffId")
    @Path("vts:Body/vts:Parameters")
    private int c;

    @Attribute(name = "OriginNodeId", required = false)
    @Path("vts:Body/vts:Parameters")
    private Integer d;

    @Attribute(name = "DestinationNodeId", required = false)
    @Path("vts:Body/vts:Parameters")
    private Integer e;

    @Attribute(name = "ContainsNodes", required = false)
    @Path("vts:Body/vts:Parameters")
    private String f;

    @Attribute(name = "PassengerClass", required = false)
    @Path("vts:Body/vts:Parameters")
    private Integer g;

    public GetSellProposalInput(int i, int i2) {
        setProviderID(i);
        setTariffID(i2);
    }

    public GetSellProposalInput(int i, int i2, VtsNode vtsNode, VtsNode vtsNode2) {
        setProviderID(i);
        setTariffID(i2);
        setOriginNodeID(vtsNode == null ? null : Integer.valueOf(vtsNode.getID()));
        setDestinationNodeID(vtsNode2 != null ? Integer.valueOf(vtsNode2.getID()) : null);
    }

    public GetSellProposalInput(int i, int i2, VtsNode vtsNode, VtsNode vtsNode2, List<String> list, int i3) {
        setProviderID(i);
        setTariffID(i2);
        setOriginNodeID(vtsNode == null ? null : Integer.valueOf(vtsNode.getID()));
        setDestinationNodeID(vtsNode2 == null ? null : Integer.valueOf(vtsNode2.getID()));
        if (list.size() > 0) {
            setContainsNodes(StringUtils.join(list, ":", true));
        }
        setPassengerClass(i3 != 0 ? Integer.valueOf(i3) : null);
    }

    public String getContainsNodes() {
        return this.f;
    }

    public Integer getDestinationNodeID() {
        return this.e;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetSellProposal";
    }

    public Integer getOriginNodeID() {
        return this.d;
    }

    public Integer getPassengerClass() {
        return this.g;
    }

    public int getProviderID() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "ProviderId: %d; TariffId: %d", Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public int getTariffID() {
        return this.c;
    }

    public void setContainsNodes(String str) {
        this.f = str;
    }

    public void setDestinationNodeID(Integer num) {
        this.e = num;
    }

    public void setOriginNodeID(Integer num) {
        this.d = num;
    }

    public void setPassengerClass(Integer num) {
        this.g = num;
    }

    public void setProviderID(int i) {
        this.b = i;
    }

    public void setTariffID(int i) {
        this.c = i;
    }
}
