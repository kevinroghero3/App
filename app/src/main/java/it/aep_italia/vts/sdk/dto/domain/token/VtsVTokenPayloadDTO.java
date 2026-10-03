package it.aep_italia.vts.sdk.dto.domain.token;

import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadContractDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadEnvironmentDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadPhysicalDocInfoDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadValidationDTO;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenPayloadDTO {

    @Element(name = "PhysicalDocInfo")
    private VtsVTokenPayloadPhysicalDocInfoDTO a;

    @Element(name = "Environment", required = false)
    private VtsVTokenPayloadEnvironmentDTO b;

    @ElementList(entry = "Contract", name = "ContractsList")
    private ArrayList<VtsVTokenPayloadContractDTO> c;

    @ElementList(entry = "Validation", name = "ValidationsList")
    private ArrayList<VtsVTokenPayloadValidationDTO> d;

    public ArrayList<VtsVTokenPayloadContractDTO> getContracts() {
        ArrayList<VtsVTokenPayloadContractDTO> arrayList = this.c;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public VtsVTokenPayloadEnvironmentDTO getEnvironment() {
        return this.b;
    }

    public VtsVTokenPayloadPhysicalDocInfoDTO getPhysicalDocInfo() {
        return this.a;
    }

    public ArrayList<VtsVTokenPayloadValidationDTO> getValidations() {
        ArrayList<VtsVTokenPayloadValidationDTO> arrayList = this.d;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setContracts(ArrayList<VtsVTokenPayloadContractDTO> arrayList) {
        this.c = arrayList;
    }

    public void setEnvironment(VtsVTokenPayloadEnvironmentDTO vtsVTokenPayloadEnvironmentDTO) {
        this.b = vtsVTokenPayloadEnvironmentDTO;
    }

    public void setPhysicalDocInfo(VtsVTokenPayloadPhysicalDocInfoDTO vtsVTokenPayloadPhysicalDocInfoDTO) {
        this.a = vtsVTokenPayloadPhysicalDocInfoDTO;
    }

    public void setValidations(ArrayList<VtsVTokenPayloadValidationDTO> arrayList) {
        this.d = arrayList;
    }
}
