package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.dto.domain.VtsContractDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsTransactionDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VtsTransaction {
    private long a;
    private Date b;
    private int c;
    private String d;
    private List<VtsTransactionContract> e;

    private VtsTransaction() {
    }

    public static VtsTransaction fromDTO(VtsTransactionDTO vtsTransactionDTO) {
        VtsTransaction vtsTransaction = new VtsTransaction();
        vtsTransaction.a = vtsTransactionDTO.getTransactionUID();
        vtsTransaction.b = DateUtils.fromISO8601(vtsTransactionDTO.getTransactionDateTime());
        vtsTransaction.c = vtsTransactionDTO.getTransactionReasonCode();
        vtsTransaction.d = vtsTransactionDTO.getTransactionErrorMessage();
        vtsTransaction.e = new ArrayList();
        if (vtsTransactionDTO.getContracts() != null) {
            Iterator<VtsContractDTO> it2 = vtsTransactionDTO.getContracts().iterator();
            while (it2.hasNext()) {
                vtsTransaction.e.add(VtsTransactionContract.fromDTO(it2.next()));
            }
        }
        return vtsTransaction;
    }

    public List<VtsTransactionContract> getContracts() {
        return this.e;
    }

    public String getErrorMessage() {
        return StringUtils.blankToNull(this.d);
    }

    public int getReasonCode() {
        return this.c;
    }

    public Date getTimestamp() {
        return this.b;
    }

    public long getUid() {
        return this.a;
    }
}
