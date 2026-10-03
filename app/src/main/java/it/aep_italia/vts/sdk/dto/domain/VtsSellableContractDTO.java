package it.aep_italia.vts.sdk.dto.domain;

import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSellableContractDTO {

    @Attribute(name = "ProviderId")
    private int a;

    @Attribute(name = "TariffId")
    private int b;

    @Attribute(name = "TariffFamilyId")
    private int c;

    @Attribute(name = "TariffFamilyType", required = false)
    private int d;

    @Attribute(name = "TariffDescription")
    private String e;

    @Attribute(name = "FrontImageVTID", required = false)
    private String f;

    @Attribute(name = "BackImageVTID", required = false)
    private String g;

    @Attribute(name = "ContractTypeDescription", required = false)
    private String h;

    @Attribute(name = "ContractDurationDescription", required = false)
    private String i;

    @ElementList(entry = "SellProposal", inline = true, required = false)
    private ArrayList<VtsSellProposalDTO> j;

    public String getBackImageVTID() {
        return this.g;
    }

    public String getContractDurationDescription() {
        return this.i;
    }

    public String getContractTypeDescription() {
        return this.h;
    }

    public String getFrontImageVTID() {
        return this.f;
    }

    public int getProviderID() {
        return this.a;
    }

    public ArrayList<VtsSellProposalDTO> getSellProposals() {
        ArrayList<VtsSellProposalDTO> arrayList = this.j;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public String getTariffDescription() {
        return this.e;
    }

    public int getTariffFamilyID() {
        return this.c;
    }

    public int getTariffFamilyType() {
        return this.d;
    }

    public int getTariffID() {
        return this.b;
    }

    public void setBackImageVTID(String str) {
        this.g = str;
    }

    public void setContractDurationDescription(String str) {
        this.i = str;
    }

    public void setContractTypeDescription(String str) {
        this.h = str;
    }

    public void setFrontImageVTID(String str) {
        this.f = str;
    }

    public void setProviderID(int i) {
        this.a = i;
    }

    public void setSellProposal(ArrayList<VtsSellProposalDTO> arrayList) {
        this.j = arrayList;
    }

    public void setTariffDescription(String str) {
        this.e = str;
    }

    public void setTariffFamilyID(int i) {
        this.c = i;
    }

    public void setTariffFamilyType(int i) {
        this.d = i;
    }

    public void setTariffID(int i) {
        this.b = i;
    }
}
