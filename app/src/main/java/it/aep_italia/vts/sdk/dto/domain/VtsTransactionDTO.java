package it.aep_italia.vts.sdk.dto.domain;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

/* JADX INFO: loaded from: classes6.dex */
public class VtsTransactionDTO {

    @Attribute(name = "TransactionUID")
    private long a;

    @Attribute(name = "TransactionDateTime")
    private String b;

    @Attribute(name = "TransactionReasonCode")
    private int c;

    @Attribute(name = "TransactionErrorMessage", required = false)
    private String d;

    @ElementList(entry = "Contract", inline = true, required = false)
    private List<VtsContractDTO> e;

    public List<VtsContractDTO> getContracts() {
        return this.e;
    }

    public String getTransactionDateTime() {
        return this.b;
    }

    public String getTransactionErrorMessage() {
        return this.d;
    }

    public int getTransactionReasonCode() {
        return this.c;
    }

    public long getTransactionUID() {
        return this.a;
    }

    public void setContracts(List<VtsContractDTO> list) {
        this.e = list;
    }

    public void setTransactionDateTime(String str) {
        this.b = str;
    }

    public void setTransactionErrorMessage(String str) {
        this.d = str;
    }

    public void setTransactionReasonCode(int i) {
        this.c = i;
    }

    public void setTransactionUID(long j) {
        this.a = j;
    }
}
