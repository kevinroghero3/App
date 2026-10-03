package it.aep_italia.vts.sdk.dto.utils;

import it.aep_italia.vts.sdk.domain.VtsContract;
import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

/* JADX INFO: loaded from: classes6.dex */
public class VtsContractListDTO {

    @ElementList(entry = "Contract", name = "ContractList")
    private ArrayList<VtsContract> a;

    public VtsContractListDTO() {
    }

    public VtsContractListDTO(VtsContract vtsContract) {
        ArrayList<VtsContract> arrayList = new ArrayList<>();
        arrayList.add(vtsContract);
        setContracts(arrayList);
    }

    public VtsContractListDTO(ArrayList<VtsContract> arrayList) {
        setContracts(arrayList);
    }

    public ArrayList<VtsContract> getContracts() {
        return this.a;
    }

    public void setContracts(ArrayList<VtsContract> arrayList) {
        this.a = arrayList;
    }
}
