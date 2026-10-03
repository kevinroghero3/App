package it.aep_italia.vts.sdk.internal.wallet;

import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletFileType;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsWalletFile {
    private VtsWalletFileType a;
    private VtsObjectType b;
    private String c;
    private long d;
    private int e;
    private int f;
    private byte[] g;

    public byte[] getContents() {
        return this.g;
    }

    public String getFileName() {
        return this.c;
    }

    public VtsWalletFileType getFileType() {
        return this.a;
    }

    public int getLastUpdate() {
        return this.f;
    }

    public Date getLastUpdateAsDate() {
        return new Date((((long) this.f) & 4294967295L) * 1000);
    }

    public VtsObjectType getObjectType() {
        return this.b;
    }

    public int getTokenGroupUID() {
        return this.e;
    }

    public long getTokenUID() {
        return this.d;
    }

    public void setContents(byte[] bArr) {
        this.g = bArr;
    }

    public void setFileName(String str) {
        this.c = str;
    }

    public void setFileType(VtsWalletFileType vtsWalletFileType) {
        this.a = vtsWalletFileType;
    }

    public void setLastUpdate(int i) {
        this.f = i;
    }

    public void setObjectType(VtsObjectType vtsObjectType) {
        this.b = vtsObjectType;
    }

    public void setTokenGroupUID(int i) {
        this.e = i;
    }

    public void setTokenUID(long j) {
        this.d = j;
    }
}
