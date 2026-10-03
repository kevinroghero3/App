package it.aep_italia.vts.sdk.dto.utils;

import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsWalletFileDTO {
    private String a;
    private String b;
    private String c;
    private String d;
    private Date e;
    private Integer f;
    private long g;
    private int h;
    private byte[] i;

    public byte[] getContents() {
        return this.i;
    }

    public String getFileName() {
        return this.d;
    }

    public String getFileType() {
        return this.a;
    }

    public Date getLastUpdate() {
        return this.e;
    }

    public String getObjectType() {
        return this.b;
    }

    public String getObjectTypeFormat() {
        return this.c;
    }

    public Integer getSignatureCount() {
        return this.f;
    }

    public int getTokenGroupUID() {
        return this.h;
    }

    public long getTokenUID() {
        return this.g;
    }

    public void setContents(byte[] bArr) {
        this.i = bArr;
    }

    public void setFileName(String str) {
        this.d = str;
    }

    public void setFileType(String str) {
        this.a = str;
    }

    public void setLastUpdate(Date date) {
        this.e = date;
    }

    public void setObjectType(String str) {
        this.b = str;
    }

    public void setObjectTypeFormat(String str) {
        this.c = str;
    }

    public void setSignatureCount(Integer num) {
        this.f = num;
    }

    public void setTokenGroupUID(int i) {
        this.h = i;
    }

    public void setTokenUID(long j) {
        this.g = j;
    }
}
