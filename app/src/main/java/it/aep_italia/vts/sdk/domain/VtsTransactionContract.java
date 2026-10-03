package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.dto.domain.VtsContractDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsTransactionContract {
    private long a;
    private long b;
    private long c;
    private Date d;

    private VtsTransactionContract() {
    }

    public static VtsTransactionContract fromDTO(VtsContractDTO vtsContractDTO) {
        VtsTransactionContract vtsTransactionContract = new VtsTransactionContract();
        vtsTransactionContract.a = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getContractUID());
        vtsTransactionContract.b = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getVTokenUID());
        vtsTransactionContract.c = StringUtils.unsignedHexStringToSignedLong(vtsContractDTO.getReceiptVTID());
        vtsTransactionContract.d = DateUtils.fromISO8601(vtsContractDTO.getSellDateTime());
        return vtsTransactionContract;
    }

    public long getContractUID() {
        return this.a;
    }

    public long getReceiptUID() {
        return this.c;
    }

    public Date getSellDateTime() {
        return this.d;
    }

    public long getVTokenUID() {
        return this.b;
    }
}
