package it.aep_italia.vts.sdk.dto.soap.functions.requests;

import com.facebook.hermes.intl.Constants;
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
public class GetInfoCardInput implements VtsSoapFunctionPayload {

    @Attribute(name = "VtObjectType")
    @Path("vts:Body/vts:Parameters")
    private int b;

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "VtFormat")
    @Path("vts:Body/vts:Parameters")
    private String c = "binary";

    @Attribute(name = "DumpVtHeader")
    @Path("vts:Body/vts:Parameters")
    private String d = "no";

    @Attribute(name = "DumpVtPayload")
    @Path("vts:Body/vts:Parameters")
    private String e = "no";

    @Attribute(name = "DumpVtValidation")
    @Path("vts:Body/vts:Parameters")
    private String f = "no";

    @Attribute(name = "DumpVtSignature")
    @Path("vts:Body/vts:Parameters")
    private String g = "no";

    @Attribute(name = "VtCheckSignature")
    @Path("vts:Body/vts:Parameters")
    private boolean h = false;

    public GetInfoCardInput(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        setVtObjectType(i);
        setDumpVtHeader(z);
        setDumpVtPayload(z2);
        setDumpVtValidation(z3);
        setDumpVtSignature(z4);
    }

    public String getDumpVtHeader() {
        return this.d;
    }

    public String getDumpVtPayload() {
        return this.e;
    }

    public String getDumpVtSignature() {
        return this.g;
    }

    public String getDumpVtValidation() {
        return this.f;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getFunctionName() {
        return "vts_FuncGetInfoCard";
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload
    public String getStringifiedParameters() {
        Locale locale = Locale.ITALY;
        int i = this.b;
        return String.format(locale, "VtObjectType: %d; VtFormat: %s; DumpVtHeader: %s; DumpVtPayload: %s; DumpVtValidation: %s; DumpVtSignature: %s; VtCheckSignature: %b", Integer.valueOf(i), this.c, this.d, this.e, this.f, this.g, Boolean.valueOf(this.h));
    }

    public boolean getVtCheckSignature() {
        return this.h;
    }

    public String getVtFormat() {
        return this.c;
    }

    public int getVtObjectType() {
        return this.b;
    }

    public void setDumpVtHeader(boolean z) {
        this.d = z ? "true" : Constants.CASEFIRST_FALSE;
    }

    public void setDumpVtPayload(boolean z) {
        this.e = z ? "true" : Constants.CASEFIRST_FALSE;
    }

    public void setDumpVtSignature(boolean z) {
        this.g = z ? "true" : Constants.CASEFIRST_FALSE;
    }

    public void setDumpVtValidation(boolean z) {
        this.f = z ? "true" : Constants.CASEFIRST_FALSE;
    }

    public void setVtCheckSignature(boolean z) {
        this.h = z;
    }

    public void setVtObjectType(int i) {
        this.b = i;
    }
}
