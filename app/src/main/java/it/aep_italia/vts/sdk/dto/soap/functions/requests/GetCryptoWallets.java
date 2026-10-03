package it.aep_italia.vts.sdk.dto.soap.functions.requests;

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
public class GetCryptoWallets implements VtsSoapFunctionPayload {

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "RequestedCommand")
    @Path("vts:Body/vts:Parameters")
    private String b;

    @Attribute(name = "WalletAddress")
    @Path("vts:Body/vts:Parameters")
    private String c;

    @Attribute(name = "WalletType")
    @Path("vts:Body/vts:Parameters")
    private String d;

    public GetCryptoWallets(String str, String str2) {
        setRequestedCommand("search");
        setWalletType(str);
        setWalletAddress(str2);
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncCryptoWalletsManagement";
    }

    public String getRequestedCommand() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        return String.format(Locale.ITALY, "WalletType: %s; WalletAddress: %s", this.d, this.c);
    }

    public String getWalletAddress() {
        return this.c;
    }

    public String getWalletType() {
        return this.d;
    }

    public void setRequestedCommand(String str) {
        this.b = str;
    }

    public void setWalletAddress(String str) {
        this.c = str;
    }

    public void setWalletType(String str) {
        this.d = str;
    }
}
