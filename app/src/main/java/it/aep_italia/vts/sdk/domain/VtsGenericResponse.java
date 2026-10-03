package it.aep_italia.vts.sdk.domain;

/* JADX INFO: loaded from: classes6.dex */
public class VtsGenericResponse {
    private int a;
    private String b;
    private String c;
    private byte[] d;

    public VtsGenericResponse(int i, String str, String str2, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = bArr;
    }

    public byte[] getDataOutBin() {
        return this.d;
    }

    public String getDataOutXml() {
        return this.c;
    }

    public String getErrorString() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }
}
