package it.aep_italia.vts.sdk.dto.domain;

import it.aep_italia.vts.sdk.dto.domain.token.VtsVTokenHeaderDTO;
import it.aep_italia.vts.sdk.dto.domain.token.VtsVTokenPayloadDTO;
import it.aep_italia.vts.sdk.dto.domain.token.VtsVTokenSignatureDTO;
import it.aep_italia.vts.sdk.dto.domain.token.VtsVTokenValidationDTO;
import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenDTO {

    @Attribute(name = "DumpVersion")
    private int a;

    @Attribute(name = "DumpDateTime")
    private String b;

    @Element(name = "VtHeader", required = false)
    private VtsVTokenHeaderDTO c;

    @Element(name = "VtPayload", required = false)
    private VtsVTokenPayloadDTO d;

    @Element(name = "VtValidation", required = false)
    private VtsVTokenValidationDTO e;

    @ElementList(entry = "VtSignature", name = "VtSignaturesList", required = false)
    @Path("VtSignature")
    private ArrayList<VtsVTokenSignatureDTO> f;

    public String getDumpDateTime() {
        return this.b;
    }

    public int getDumpVersion() {
        return this.a;
    }

    public VtsVTokenHeaderDTO getHeader() {
        return this.c;
    }

    public VtsVTokenPayloadDTO getPayload() {
        return this.d;
    }

    public ArrayList<VtsVTokenSignatureDTO> getSignatures() {
        return this.f;
    }

    public VtsVTokenValidationDTO getValidation() {
        return this.e;
    }

    public void setDumpDateTime(String str) {
        this.b = str;
    }

    public void setDumpVersion(int i) {
        this.a = i;
    }

    public void setHeader(VtsVTokenHeaderDTO vtsVTokenHeaderDTO) {
        this.c = vtsVTokenHeaderDTO;
    }

    public void setPayload(VtsVTokenPayloadDTO vtsVTokenPayloadDTO) {
        this.d = vtsVTokenPayloadDTO;
    }

    public void setSignatures(ArrayList<VtsVTokenSignatureDTO> arrayList) {
        this.f = arrayList;
    }

    public void setValidation(VtsVTokenValidationDTO vtsVTokenValidationDTO) {
        this.e = vtsVTokenValidationDTO;
    }
}
