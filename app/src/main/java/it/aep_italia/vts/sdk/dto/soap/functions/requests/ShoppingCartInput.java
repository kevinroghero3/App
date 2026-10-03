package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.utils.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_RequestFunction")
public class ShoppingCartInput implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "OperationType")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "SellProposalId", required = false)
    @Path("vts:Body/vts:Parameters")
    private Long c;

    @Attribute(name = "Quantity", required = false)
    @Path("vts:Body/vts:Parameters")
    private Integer d;

    @Attribute(name = "Description", required = false)
    @Path("vts:Body/vts:Parameters")
    private String e;

    @Attribute(name = "SubDescr01", required = false)
    @Path("vts:Body/vts:Parameters")
    private String f;

    @Attribute(name = "SubDescr02", required = false)
    @Path("vts:Body/vts:Parameters")
    private String g;

    private ShoppingCartInput(String str, Long l, Integer num, String str2, String str3, String str4) {
        this.b = str;
        this.c = l;
        this.d = num;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public static ShoppingCartInput forAddOperation(long j, int i, String str, String str2, String str3) {
        return new ShoppingCartInput("Add", Long.valueOf(j), Integer.valueOf(i), str, str2, str3);
    }

    public static ShoppingCartInput forContentOperation() {
        return new ShoppingCartInput("Content", null, null, null, null, null);
    }

    public static ShoppingCartInput forEmptyOperation() {
        return new ShoppingCartInput("Empty", null, null, null, null, null);
    }

    public static ShoppingCartInput forModifyOperation(long j, int i, String str, String str2, String str3) {
        return new ShoppingCartInput("Modify", Long.valueOf(j), Integer.valueOf(i), str, str2, str3);
    }

    public static ShoppingCartInput forRemoveOperation(long j) {
        return new ShoppingCartInput("Remove", Long.valueOf(j), null, null, null, null);
    }

    public String getDescription() {
        return this.e;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncShoppingCart";
    }

    public String getOperationType() {
        return this.b;
    }

    public Integer getQuantity() {
        return this.d;
    }

    public Long getSellProposalId() {
        return this.c;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        StringBuilder sb = new StringBuilder();
        sb.append("OperationType: ");
        sb.append(this.b);
        if (this.c != null) {
            sb.append(", SellProposalId: ");
            sb.append(this.c);
        }
        if (this.d != null) {
            sb.append(", Quantity: ");
            sb.append(this.d);
        }
        if (!StringUtils.isBlank(this.e)) {
            sb.append(", Description: ");
            sb.append(this.e);
        }
        if (!StringUtils.isBlank(this.f)) {
            sb.append(", SubDescr01: ");
            sb.append(this.f);
        }
        if (!StringUtils.isBlank(this.g)) {
            sb.append(", SubDescr02: ");
            sb.append(this.g);
        }
        return sb.toString();
    }

    public String getSubDescription1() {
        return this.f;
    }

    public String getSubDescription2() {
        return this.g;
    }
}
